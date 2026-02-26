package androidx.media3.extractor.mp3;

import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.MpegAudioUtil;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;

/* JADX INFO: loaded from: classes2.dex */
final class XingSeeker implements Seeker {
    private static final String TAG = "XingSeeker";
    private final long dataEndPosition;
    private final long dataSize;
    private final long dataStartPosition;
    private final long durationUs;

    @Nullable
    private final long[] tableOfContents;
    private final int xingFrameSize;

    private XingSeeker(long j10, int i10, long j11) {
        this(j10, i10, j11, -1L, null);
    }

    @Nullable
    public static XingSeeker create(long j10, XingFrame xingFrame, long j11) {
        long j12 = xingFrame.frameCount;
        if (j12 == -1 && j12 == 0) {
            return null;
        }
        MpegAudioUtil.Header header = xingFrame.header;
        long jSampleCountToDurationUs = Util.sampleCountToDurationUs((j12 * ((long) header.samplesPerFrame)) - 1, header.sampleRate);
        long j13 = xingFrame.dataSize;
        if (j13 == -1 || xingFrame.tableOfContents == null) {
            return new XingSeeker(j11, xingFrame.header.frameSize, jSampleCountToDurationUs);
        }
        if (j10 != -1 && j10 != j11 + j13) {
            Log.w(TAG, "XING data size mismatch: " + j10 + ", " + (j11 + xingFrame.dataSize));
        }
        return new XingSeeker(j11, xingFrame.header.frameSize, jSampleCountToDurationUs, xingFrame.dataSize, xingFrame.tableOfContents);
    }

    private long getTimeUsForTableIndex(int i10) {
        return (this.durationUs * ((long) i10)) / 100;
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
        if (!isSeekable()) {
            return new SeekMap.SeekPoints(new SeekPoint(0L, this.dataStartPosition + ((long) this.xingFrameSize)));
        }
        long jConstrainValue = Util.constrainValue(j10, 0L, this.durationUs);
        double d10 = (jConstrainValue * 100.0d) / this.durationUs;
        double d11 = 0.0d;
        if (d10 > 0.0d) {
            if (d10 >= 100.0d) {
                d11 = 256.0d;
            } else {
                int i10 = (int) d10;
                double d12 = ((long[]) Assertions.checkStateNotNull(this.tableOfContents))[i10];
                d11 = d12 + ((d10 - ((double) i10)) * ((i10 == 99 ? 256.0d : r3[i10 + 1]) - d12));
            }
        }
        return new SeekMap.SeekPoints(new SeekPoint(jConstrainValue, this.dataStartPosition + Util.constrainValue(Math.round((d11 / 256.0d) * this.dataSize), this.xingFrameSize, this.dataSize - 1)));
    }

    @Override // androidx.media3.extractor.mp3.Seeker
    public long getTimeUs(long j10) {
        long j11 = j10 - this.dataStartPosition;
        if (!isSeekable() || j11 <= this.xingFrameSize) {
            return 0L;
        }
        long[] jArr = (long[]) Assertions.checkStateNotNull(this.tableOfContents);
        double d10 = (j11 * 256.0d) / this.dataSize;
        int iBinarySearchFloor = Util.binarySearchFloor(jArr, (long) d10, true, true);
        long timeUsForTableIndex = getTimeUsForTableIndex(iBinarySearchFloor);
        long j12 = jArr[iBinarySearchFloor];
        int i10 = iBinarySearchFloor + 1;
        long timeUsForTableIndex2 = getTimeUsForTableIndex(i10);
        return timeUsForTableIndex + Math.round((j12 == (iBinarySearchFloor == 99 ? 256L : jArr[i10]) ? 0.0d : (d10 - j12) / (r0 - j12)) * (timeUsForTableIndex2 - timeUsForTableIndex));
    }

    @Override // androidx.media3.extractor.SeekMap
    public boolean isSeekable() {
        return this.tableOfContents != null;
    }

    private XingSeeker(long j10, int i10, long j11, long j12, @Nullable long[] jArr) {
        this.dataStartPosition = j10;
        this.xingFrameSize = i10;
        this.durationUs = j11;
        this.tableOfContents = jArr;
        this.dataSize = j12;
        this.dataEndPosition = j12 != -1 ? j10 + j12 : -1L;
    }
}
