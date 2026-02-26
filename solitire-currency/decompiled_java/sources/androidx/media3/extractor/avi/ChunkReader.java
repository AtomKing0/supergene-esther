package androidx.media3.extractor.avi;

import androidx.media3.common.DataReader;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import androidx.media3.extractor.TrackOutput;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class ChunkReader {
    private static final int CHUNK_TYPE_AUDIO = 1651965952;
    private static final int CHUNK_TYPE_VIDEO_COMPRESSED = 1667497984;
    private static final int CHUNK_TYPE_VIDEO_UNCOMPRESSED = 1650720768;
    private static final int INITIAL_INDEX_SIZE = 512;
    private final int alternativeChunkId;
    private int bytesRemainingInCurrentChunk;
    private final int chunkId;
    private int currentChunkIndex;
    private int currentChunkSize;
    private final long durationUs;
    private int indexChunkCount;
    private int indexSize;
    private int[] keyFrameIndices;
    private long[] keyFrameOffsets;
    private final int streamHeaderChunkCount;
    protected final TrackOutput trackOutput;

    public ChunkReader(int i10, int i11, long j10, int i12, TrackOutput trackOutput) {
        boolean z10 = true;
        if (i11 != 1 && i11 != 2) {
            z10 = false;
        }
        Assertions.checkArgument(z10);
        this.durationUs = j10;
        this.streamHeaderChunkCount = i12;
        this.trackOutput = trackOutput;
        this.chunkId = getChunkIdFourCc(i10, i11 == 2 ? CHUNK_TYPE_VIDEO_COMPRESSED : CHUNK_TYPE_AUDIO);
        this.alternativeChunkId = i11 == 2 ? getChunkIdFourCc(i10, CHUNK_TYPE_VIDEO_UNCOMPRESSED) : -1;
        this.keyFrameOffsets = new long[512];
        this.keyFrameIndices = new int[512];
    }

    private static int getChunkIdFourCc(int i10, int i11) {
        return (((i10 % 10) + 48) << 8) | ((i10 / 10) + 48) | i11;
    }

    private long getChunkTimestampUs(int i10) {
        return (this.durationUs * ((long) i10)) / ((long) this.streamHeaderChunkCount);
    }

    private SeekPoint getSeekPoint(int i10) {
        return new SeekPoint(((long) this.keyFrameIndices[i10]) * getFrameDurationUs(), this.keyFrameOffsets[i10]);
    }

    public void advanceCurrentChunk() {
        this.currentChunkIndex++;
    }

    public void appendKeyFrameToIndex(long j10) {
        if (this.indexSize == this.keyFrameIndices.length) {
            long[] jArr = this.keyFrameOffsets;
            this.keyFrameOffsets = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
            int[] iArr = this.keyFrameIndices;
            this.keyFrameIndices = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
        }
        long[] jArr2 = this.keyFrameOffsets;
        int i10 = this.indexSize;
        jArr2[i10] = j10;
        this.keyFrameIndices[i10] = this.indexChunkCount;
        this.indexSize = i10 + 1;
    }

    public void compactIndex() {
        this.keyFrameOffsets = Arrays.copyOf(this.keyFrameOffsets, this.indexSize);
        this.keyFrameIndices = Arrays.copyOf(this.keyFrameIndices, this.indexSize);
    }

    public long getCurrentChunkTimestampUs() {
        return getChunkTimestampUs(this.currentChunkIndex);
    }

    public long getFrameDurationUs() {
        return getChunkTimestampUs(1);
    }

    public SeekMap.SeekPoints getSeekPoints(long j10) {
        int frameDurationUs = (int) (j10 / getFrameDurationUs());
        int iBinarySearchFloor = Util.binarySearchFloor(this.keyFrameIndices, frameDurationUs, true, true);
        if (this.keyFrameIndices[iBinarySearchFloor] == frameDurationUs) {
            return new SeekMap.SeekPoints(getSeekPoint(iBinarySearchFloor));
        }
        SeekPoint seekPoint = getSeekPoint(iBinarySearchFloor);
        int i10 = iBinarySearchFloor + 1;
        return i10 < this.keyFrameOffsets.length ? new SeekMap.SeekPoints(seekPoint, getSeekPoint(i10)) : new SeekMap.SeekPoints(seekPoint);
    }

    public boolean handlesChunkId(int i10) {
        return this.chunkId == i10 || this.alternativeChunkId == i10;
    }

    public void incrementIndexChunkCount() {
        this.indexChunkCount++;
    }

    public boolean isAudio() {
        return (this.chunkId & CHUNK_TYPE_AUDIO) == CHUNK_TYPE_AUDIO;
    }

    public boolean isCurrentFrameAKeyFrame() {
        return Arrays.binarySearch(this.keyFrameIndices, this.currentChunkIndex) >= 0;
    }

    public boolean isVideo() {
        return (this.chunkId & CHUNK_TYPE_VIDEO_COMPRESSED) == CHUNK_TYPE_VIDEO_COMPRESSED;
    }

    public boolean onChunkData(ExtractorInput extractorInput) throws IOException {
        int i10 = this.bytesRemainingInCurrentChunk;
        int iSampleData = i10 - this.trackOutput.sampleData((DataReader) extractorInput, i10, false);
        this.bytesRemainingInCurrentChunk = iSampleData;
        boolean z10 = iSampleData == 0;
        if (z10) {
            if (this.currentChunkSize > 0) {
                this.trackOutput.sampleMetadata(getCurrentChunkTimestampUs(), isCurrentFrameAKeyFrame() ? 1 : 0, this.currentChunkSize, 0, null);
            }
            advanceCurrentChunk();
        }
        return z10;
    }

    public void onChunkStart(int i10) {
        this.currentChunkSize = i10;
        this.bytesRemainingInCurrentChunk = i10;
    }

    public void seekToPosition(long j10) {
        if (this.indexSize == 0) {
            this.currentChunkIndex = 0;
        } else {
            this.currentChunkIndex = this.keyFrameIndices[Util.binarySearchFloor(this.keyFrameOffsets, j10, true, true)];
        }
    }
}
