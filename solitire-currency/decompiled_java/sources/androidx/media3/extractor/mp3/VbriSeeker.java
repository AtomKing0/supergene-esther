package androidx.media3.extractor.mp3;

import androidx.annotation.Nullable;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.MpegAudioUtil;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;

/* JADX INFO: loaded from: classes2.dex */
final class VbriSeeker implements Seeker {
    private static final String TAG = "VbriSeeker";
    private final long dataEndPosition;
    private final long durationUs;
    private final long[] positions;
    private final long[] timesUs;

    private VbriSeeker(long[] jArr, long[] jArr2, long j10, long j11) {
        this.timesUs = jArr;
        this.positions = jArr2;
        this.durationUs = j10;
        this.dataEndPosition = j11;
    }

    @Nullable
    public static VbriSeeker create(long j10, long j11, MpegAudioUtil.Header header, ParsableByteArray parsableByteArray) {
        int unsignedByte;
        parsableByteArray.skipBytes(10);
        int i10 = parsableByteArray.readInt();
        if (i10 <= 0) {
            return null;
        }
        int i11 = header.sampleRate;
        long jScaleLargeTimestamp = Util.scaleLargeTimestamp(i10, ((long) (i11 >= 32000 ? 1152 : 576)) * 1000000, i11);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        int unsignedShort2 = parsableByteArray.readUnsignedShort();
        int unsignedShort3 = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(2);
        long j12 = j11 + ((long) header.frameSize);
        long[] jArr = new long[unsignedShort];
        long[] jArr2 = new long[unsignedShort];
        int i12 = 0;
        long j13 = j11;
        while (i12 < unsignedShort) {
            int i13 = unsignedShort2;
            long j14 = j12;
            jArr[i12] = (((long) i12) * jScaleLargeTimestamp) / ((long) unsignedShort);
            jArr2[i12] = Math.max(j13, j14);
            if (unsignedShort3 == 1) {
                unsignedByte = parsableByteArray.readUnsignedByte();
            } else if (unsignedShort3 == 2) {
                unsignedByte = parsableByteArray.readUnsignedShort();
            } else if (unsignedShort3 == 3) {
                unsignedByte = parsableByteArray.readUnsignedInt24();
            } else {
                if (unsignedShort3 != 4) {
                    return null;
                }
                unsignedByte = parsableByteArray.readUnsignedIntToInt();
            }
            j13 += ((long) unsignedByte) * ((long) i13);
            i12++;
            jArr = jArr;
            unsignedShort2 = i13;
            j12 = j14;
        }
        long[] jArr3 = jArr;
        if (j10 != -1 && j10 != j13) {
            Log.w(TAG, "VBRI data size mismatch: " + j10 + ", " + j13);
        }
        return new VbriSeeker(jArr3, jArr2, jScaleLargeTimestamp, j13);
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public long getDataEndPosition() {
        return this.dataEndPosition;
    }

    @Override // androidx.media3.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override // androidx.media3.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long j10) {
        int iBinarySearchFloor = Util.binarySearchFloor(this.timesUs, j10, true, true);
        SeekPoint seekPoint = new SeekPoint(this.timesUs[iBinarySearchFloor], this.positions[iBinarySearchFloor]);
        if (seekPoint.timeUs >= j10 || iBinarySearchFloor == this.timesUs.length - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i10 = iBinarySearchFloor + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.timesUs[i10], this.positions[i10]));
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public long getTimeUs(long j10) {
        return this.timesUs[Util.binarySearchFloor(this.positions, j10, true, true)];
    }

    @Override // androidx.media3.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }
}
