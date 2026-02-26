package androidx.media3.exoplayer.video.spherical;

import androidx.annotation.Nullable;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.video.spherical.Projection;
import java.util.ArrayList;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes2.dex */
final class ProjectionDecoder {
    private static final int MAX_COORDINATE_COUNT = 10000;
    private static final int MAX_TRIANGLE_INDICES = 128000;
    private static final int MAX_VERTEX_COUNT = 32000;
    private static final int TYPE_DFL8 = 1684433976;
    private static final int TYPE_MESH = 1835365224;
    private static final int TYPE_MSHP = 1836279920;
    private static final int TYPE_PROJ = 1886547818;
    private static final int TYPE_RAW = 1918990112;
    private static final int TYPE_YTMP = 2037673328;

    private ProjectionDecoder() {
    }

    @Nullable
    public static Projection decode(byte[] bArr, int i10) {
        ArrayList<Projection.Mesh> proj;
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        try {
            proj = isProj(parsableByteArray) ? parseProj(parsableByteArray) : parseMshp(parsableByteArray);
        } catch (ArrayIndexOutOfBoundsException unused) {
            proj = null;
        }
        if (proj == null) {
            return null;
        }
        int size = proj.size();
        if (size == 1) {
            return new Projection(proj.get(0), i10);
        }
        if (size != 2) {
            return null;
        }
        return new Projection(proj.get(0), proj.get(1), i10);
    }

    private static int decodeZigZag(int i10) {
        return (-(i10 & 1)) ^ (i10 >> 1);
    }

    private static boolean isProj(ParsableByteArray parsableByteArray) {
        parsableByteArray.skipBytes(4);
        int i10 = parsableByteArray.readInt();
        parsableByteArray.setPosition(0);
        return i10 == 1886547818;
    }

    @Nullable
    private static Projection.Mesh parseMesh(ParsableByteArray parsableByteArray) {
        int i10 = parsableByteArray.readInt();
        if (i10 > 10000) {
            return null;
        }
        float[] fArr = new float[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            fArr[i11] = parsableByteArray.readFloat();
        }
        int i12 = parsableByteArray.readInt();
        if (i12 > MAX_VERTEX_COUNT) {
            return null;
        }
        double d10 = 2.0d;
        double dLog = Math.log(2.0d);
        int iCeil = (int) Math.ceil(Math.log(((double) i10) * 2.0d) / dLog);
        ParsableBitArray parsableBitArray = new ParsableBitArray(parsableByteArray.getData());
        int i13 = 8;
        parsableBitArray.setPosition(parsableByteArray.getPosition() * 8);
        float[] fArr2 = new float[i12 * 5];
        int i14 = 5;
        int[] iArr = new int[5];
        int i15 = 0;
        int i16 = 0;
        while (i15 < i12) {
            int i17 = 0;
            while (i17 < i14) {
                int iDecodeZigZag = iArr[i17] + decodeZigZag(parsableBitArray.readBits(iCeil));
                if (iDecodeZigZag >= i10 || iDecodeZigZag < 0) {
                    return null;
                }
                fArr2[i16] = fArr[iDecodeZigZag];
                iArr[i17] = iDecodeZigZag;
                i17++;
                i16++;
                i14 = 5;
            }
            i15++;
            i14 = 5;
        }
        parsableBitArray.setPosition((parsableBitArray.getPosition() + 7) & (-8));
        int i18 = 32;
        int bits = parsableBitArray.readBits(32);
        Projection.SubMesh[] subMeshArr = new Projection.SubMesh[bits];
        int i19 = 0;
        while (i19 < bits) {
            int bits2 = parsableBitArray.readBits(i13);
            int bits3 = parsableBitArray.readBits(i13);
            int bits4 = parsableBitArray.readBits(i18);
            if (bits4 > MAX_TRIANGLE_INDICES) {
                return null;
            }
            int iCeil2 = (int) Math.ceil(Math.log(((double) i12) * d10) / dLog);
            float[] fArr3 = new float[bits4 * 3];
            float[] fArr4 = new float[bits4 * 2];
            int iDecodeZigZag2 = 0;
            for (int i20 = 0; i20 < bits4; i20++) {
                iDecodeZigZag2 += decodeZigZag(parsableBitArray.readBits(iCeil2));
                if (iDecodeZigZag2 < 0 || iDecodeZigZag2 >= i12) {
                    return null;
                }
                int i21 = i20 * 3;
                int i22 = iDecodeZigZag2 * 5;
                fArr3[i21] = fArr2[i22];
                fArr3[i21 + 1] = fArr2[i22 + 1];
                fArr3[i21 + 2] = fArr2[i22 + 2];
                int i23 = i20 * 2;
                fArr4[i23] = fArr2[i22 + 3];
                fArr4[i23 + 1] = fArr2[i22 + 4];
            }
            subMeshArr[i19] = new Projection.SubMesh(bits2, fArr3, fArr4, bits3);
            i19++;
            i18 = 32;
            d10 = 2.0d;
            i13 = 8;
        }
        return new Projection.Mesh(subMeshArr);
    }

    @Nullable
    private static ArrayList<Projection.Mesh> parseMshp(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.readUnsignedByte() != 0) {
            return null;
        }
        parsableByteArray.skipBytes(7);
        int i10 = parsableByteArray.readInt();
        if (i10 == TYPE_DFL8) {
            ParsableByteArray parsableByteArray2 = new ParsableByteArray();
            Inflater inflater = new Inflater(true);
            try {
                if (!Util.inflate(parsableByteArray, parsableByteArray2, inflater)) {
                    return null;
                }
                inflater.end();
                parsableByteArray = parsableByteArray2;
            } finally {
                inflater.end();
            }
        } else if (i10 != TYPE_RAW) {
            return null;
        }
        return parseRawMshpData(parsableByteArray);
    }

    @Nullable
    private static ArrayList<Projection.Mesh> parseProj(ParsableByteArray parsableByteArray) {
        int i10;
        parsableByteArray.skipBytes(8);
        int position = parsableByteArray.getPosition();
        int iLimit = parsableByteArray.limit();
        while (position < iLimit && (i10 = parsableByteArray.readInt() + position) > position && i10 <= iLimit) {
            int i11 = parsableByteArray.readInt();
            if (i11 == TYPE_YTMP || i11 == TYPE_MSHP) {
                parsableByteArray.setLimit(i10);
                return parseMshp(parsableByteArray);
            }
            parsableByteArray.setPosition(i10);
            position = i10;
        }
        return null;
    }

    @Nullable
    private static ArrayList<Projection.Mesh> parseRawMshpData(ParsableByteArray parsableByteArray) {
        ArrayList<Projection.Mesh> arrayList = new ArrayList<>();
        int position = parsableByteArray.getPosition();
        int iLimit = parsableByteArray.limit();
        while (position < iLimit) {
            int i10 = parsableByteArray.readInt() + position;
            if (i10 <= position || i10 > iLimit) {
                return null;
            }
            if (parsableByteArray.readInt() == TYPE_MESH) {
                Projection.Mesh mesh = parseMesh(parsableByteArray);
                if (mesh == null) {
                    return null;
                }
                arrayList.add(mesh);
            }
            parsableByteArray.setPosition(i10);
            position = i10;
        }
        return arrayList;
    }
}
