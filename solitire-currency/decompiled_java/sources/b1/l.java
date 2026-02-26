package b1;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.MotionEventCompat;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: DefaultImageHeaderParser.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l implements ImageHeaderParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final byte[] f1843a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f1844b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* JADX INFO: compiled from: DefaultImageHeaderParser.java */
    private static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f1845a;

        a(ByteBuffer byteBuffer) {
            this.f1845a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // b1.l.c
        public int a() {
            return ((b() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (b() & 255);
        }

        @Override // b1.l.c
        public int b() {
            if (this.f1845a.remaining() < 1) {
                return -1;
            }
            return this.f1845a.get();
        }

        @Override // b1.l.c
        public int c(byte[] bArr, int i10) {
            int iMin = Math.min(i10, this.f1845a.remaining());
            if (iMin == 0) {
                return -1;
            }
            this.f1845a.get(bArr, 0, iMin);
            return iMin;
        }

        @Override // b1.l.c
        public short d() {
            return (short) (b() & 255);
        }

        @Override // b1.l.c
        public long skip(long j10) {
            int iMin = (int) Math.min(this.f1845a.remaining(), j10);
            ByteBuffer byteBuffer = this.f1845a;
            byteBuffer.position(byteBuffer.position() + iMin);
            return iMin;
        }
    }

    /* JADX INFO: compiled from: DefaultImageHeaderParser.java */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f1846a;

        b(byte[] bArr, int i10) {
            this.f1846a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i10);
        }

        private boolean c(int i10, int i11) {
            return this.f1846a.remaining() - i10 >= i11;
        }

        short a(int i10) {
            if (c(i10, 2)) {
                return this.f1846a.getShort(i10);
            }
            return (short) -1;
        }

        int b(int i10) {
            if (c(i10, 4)) {
                return this.f1846a.getInt(i10);
            }
            return -1;
        }

        int d() {
            return this.f1846a.remaining();
        }

        void e(ByteOrder byteOrder) {
            this.f1846a.order(byteOrder);
        }
    }

    /* JADX INFO: compiled from: DefaultImageHeaderParser.java */
    private interface c {
        int a() throws IOException;

        int b() throws IOException;

        int c(byte[] bArr, int i10) throws IOException;

        short d() throws IOException;

        long skip(long j10) throws IOException;
    }

    /* JADX INFO: compiled from: DefaultImageHeaderParser.java */
    private static final class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InputStream f1847a;

        d(InputStream inputStream) {
            this.f1847a = inputStream;
        }

        @Override // b1.l.c
        public int a() throws IOException {
            return ((this.f1847a.read() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (this.f1847a.read() & 255);
        }

        @Override // b1.l.c
        public int b() throws IOException {
            return this.f1847a.read();
        }

        @Override // b1.l.c
        public int c(byte[] bArr, int i10) throws IOException {
            int i11 = i10;
            while (i11 > 0) {
                int i12 = this.f1847a.read(bArr, i10 - i11, i11);
                if (i12 == -1) {
                    break;
                }
                i11 -= i12;
            }
            return i10 - i11;
        }

        @Override // b1.l.c
        public short d() throws IOException {
            return (short) (this.f1847a.read() & 255);
        }

        @Override // b1.l.c
        public long skip(long j10) throws IOException {
            if (j10 < 0) {
                return 0L;
            }
            long j11 = j10;
            while (j11 > 0) {
                long jSkip = this.f1847a.skip(j11);
                if (jSkip <= 0) {
                    if (this.f1847a.read() == -1) {
                        break;
                    }
                    jSkip = 1;
                }
                j11 -= jSkip;
            }
            return j10 - j11;
        }
    }

    private static int d(int i10, int i11) {
        return i10 + 2 + (i11 * 12);
    }

    private int e(c cVar, v0.b bVar) throws IOException {
        int iA = cVar.a();
        if (!g(iA)) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + iA);
            }
            return -1;
        }
        int i10 = i(cVar);
        if (i10 == -1) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        byte[] bArr = (byte[]) bVar.c(i10, byte[].class);
        try {
            return k(cVar, bArr, i10);
        } finally {
            bVar.put(bArr);
        }
    }

    @NonNull
    private ImageHeaderParser.ImageType f(c cVar) throws IOException {
        int iA = cVar.a();
        if (iA == 65496) {
            return ImageHeaderParser.ImageType.JPEG;
        }
        int iA2 = ((iA << 16) & SupportMenu.CATEGORY_MASK) | (cVar.a() & 65535);
        if (iA2 == -1991225785) {
            cVar.skip(21L);
            return cVar.b() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
        }
        if ((iA2 >> 8) == 4671814) {
            return ImageHeaderParser.ImageType.GIF;
        }
        if (iA2 != 1380533830) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        cVar.skip(4L);
        if ((((cVar.a() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.a() & 65535)) != 1464156752) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int iA3 = ((cVar.a() << 16) & SupportMenu.CATEGORY_MASK) | (cVar.a() & 65535);
        if ((iA3 & (-256)) != 1448097792) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int i10 = iA3 & 255;
        if (i10 == 88) {
            cVar.skip(4L);
            return (cVar.b() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
        }
        if (i10 != 76) {
            return ImageHeaderParser.ImageType.WEBP;
        }
        cVar.skip(4L);
        return (cVar.b() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
    }

    private static boolean g(int i10) {
        return (i10 & 65496) == 65496 || i10 == 19789 || i10 == 18761;
    }

    private boolean h(byte[] bArr, int i10) {
        boolean z10 = bArr != null && i10 > f1843a.length;
        if (z10) {
            int i11 = 0;
            while (true) {
                byte[] bArr2 = f1843a;
                if (i11 >= bArr2.length) {
                    break;
                }
                if (bArr[i11] != bArr2[i11]) {
                    return false;
                }
                i11++;
            }
        }
        return z10;
    }

    private int i(c cVar) throws IOException {
        short sD;
        int iA;
        long j10;
        long jSkip;
        do {
            short sD2 = cVar.d();
            if (sD2 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) sD2));
                }
                return -1;
            }
            sD = cVar.d();
            if (sD == 218) {
                return -1;
            }
            if (sD == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            iA = cVar.a() - 2;
            if (sD == 225) {
                return iA;
            }
            j10 = iA;
            jSkip = cVar.skip(j10);
        } while (jSkip == j10);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + ((int) sD) + ", wanted to skip: " + iA + ", but actually skipped: " + jSkip);
        }
        return -1;
    }

    private static int j(b bVar) {
        ByteOrder byteOrder;
        short sA = bVar.a(6);
        if (sA != 18761) {
            if (sA != 19789 && Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) sA));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        bVar.e(byteOrder);
        int iB = bVar.b(10) + 6;
        short sA2 = bVar.a(iB);
        for (int i10 = 0; i10 < sA2; i10++) {
            int iD = d(iB, i10);
            short sA3 = bVar.a(iD);
            if (sA3 == 274) {
                short sA4 = bVar.a(iD + 2);
                if (sA4 >= 1 && sA4 <= 12) {
                    int iB2 = bVar.b(iD + 4);
                    if (iB2 >= 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got tagIndex=" + i10 + " tagType=" + ((int) sA3) + " formatCode=" + ((int) sA4) + " componentCount=" + iB2);
                        }
                        int i11 = iB2 + f1844b[sA4];
                        if (i11 <= 4) {
                            int i12 = iD + 8;
                            if (i12 >= 0 && i12 <= bVar.d()) {
                                if (i11 >= 0 && i11 + i12 <= bVar.d()) {
                                    return bVar.a(i12);
                                }
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) sA3));
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i12 + " tagType=" + ((int) sA3));
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) sA4));
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Negative tiff component count");
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) sA4));
                }
            }
        }
        return -1;
    }

    private int k(c cVar, byte[] bArr, int i10) throws IOException {
        int iC = cVar.c(bArr, i10);
        if (iC == i10) {
            if (h(bArr, i10)) {
                return j(new b(bArr, i10));
            }
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
            }
            return -1;
        }
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i10 + ", actually read: " + iC);
        }
        return -1;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType a(@NonNull ByteBuffer byteBuffer) throws IOException {
        return f(new a((ByteBuffer) o1.j.d(byteBuffer)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType b(@NonNull InputStream inputStream) throws IOException {
        return f(new d((InputStream) o1.j.d(inputStream)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int c(@NonNull InputStream inputStream, @NonNull v0.b bVar) throws IOException {
        return e(new d((InputStream) o1.j.d(inputStream)), (v0.b) o1.j.d(bVar));
    }
}
