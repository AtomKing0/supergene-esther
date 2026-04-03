package androidx.media3.extractor;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ts.PsExtractor;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public final class FlacFrameReader {

    public static final class SampleNumberHolder {
        public long sampleNumber;
    }

    private FlacFrameReader() {
    }

    private static boolean checkAndReadBlockSizeSamples(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int i10) {
        int frameBlockSizeSamplesFromKey = readFrameBlockSizeSamplesFromKey(parsableByteArray, i10);
        return frameBlockSizeSamplesFromKey != -1 && frameBlockSizeSamplesFromKey <= flacStreamMetadata.maxBlockSizeSamples;
    }

    private static boolean checkAndReadCrc(ParsableByteArray parsableByteArray, int i10) {
        return parsableByteArray.readUnsignedByte() == Util.crc8(parsableByteArray.getData(), i10, parsableByteArray.getPosition() - 1, 0);
    }

    private static boolean checkAndReadFirstSampleNumber(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, boolean z10, SampleNumberHolder sampleNumberHolder) {
        try {
            long utf8EncodedLong = parsableByteArray.readUtf8EncodedLong();
            if (!z10) {
                utf8EncodedLong *= (long) flacStreamMetadata.maxBlockSizeSamples;
            }
            sampleNumberHolder.sampleNumber = utf8EncodedLong;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean checkAndReadFrameHeader(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int i10, SampleNumberHolder sampleNumberHolder) {
        int position = parsableByteArray.getPosition();
        long unsignedInt = parsableByteArray.readUnsignedInt();
        long j10 = unsignedInt >>> 16;
        if (j10 != i10) {
            return false;
        }
        return checkChannelAssignment((int) ((unsignedInt >> 4) & 15), flacStreamMetadata) && checkBitsPerSample((int) ((unsignedInt >> 1) & 7), flacStreamMetadata) && !(((unsignedInt & 1) > 1L ? 1 : ((unsignedInt & 1) == 1L ? 0 : -1)) == 0) && checkAndReadFirstSampleNumber(parsableByteArray, flacStreamMetadata, ((j10 & 1) > 1L ? 1 : ((j10 & 1) == 1L ? 0 : -1)) == 0, sampleNumberHolder) && checkAndReadBlockSizeSamples(parsableByteArray, flacStreamMetadata, (int) ((unsignedInt >> 12) & 15)) && checkAndReadSampleRate(parsableByteArray, flacStreamMetadata, (int) ((unsignedInt >> 8) & 15)) && checkAndReadCrc(parsableByteArray, position);
    }

    private static boolean checkAndReadSampleRate(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int i10) {
        int i11 = flacStreamMetadata.sampleRate;
        if (i10 == 0) {
            return true;
        }
        if (i10 <= 11) {
            return i10 == flacStreamMetadata.sampleRateLookupKey;
        }
        if (i10 == 12) {
            return parsableByteArray.readUnsignedByte() * 1000 == i11;
        }
        if (i10 > 14) {
            return false;
        }
        int unsignedShort = parsableByteArray.readUnsignedShort();
        if (i10 == 14) {
            unsignedShort *= 10;
        }
        return unsignedShort == i11;
    }

    private static boolean checkBitsPerSample(int i10, FlacStreamMetadata flacStreamMetadata) {
        return i10 == 0 || i10 == flacStreamMetadata.bitsPerSampleLookupKey;
    }

    private static boolean checkChannelAssignment(int i10, FlacStreamMetadata flacStreamMetadata) {
        return i10 <= 7 ? i10 == flacStreamMetadata.channels - 1 : i10 <= 10 && flacStreamMetadata.channels == 2;
    }

    public static boolean checkFrameHeaderFromPeek(ExtractorInput extractorInput, FlacStreamMetadata flacStreamMetadata, int i10, SampleNumberHolder sampleNumberHolder) throws IOException {
        long peekPosition = extractorInput.getPeekPosition();
        byte[] bArr = new byte[2];
        extractorInput.peekFully(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i10) {
            extractorInput.resetPeekPosition();
            extractorInput.advancePeekPosition((int) (peekPosition - extractorInput.getPosition()));
            return false;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(16);
        System.arraycopy(bArr, 0, parsableByteArray.getData(), 0, 2);
        parsableByteArray.setLimit(ExtractorUtil.peekToLength(extractorInput, parsableByteArray.getData(), 2, 14));
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition((int) (peekPosition - extractorInput.getPosition()));
        return checkAndReadFrameHeader(parsableByteArray, flacStreamMetadata, i10, sampleNumberHolder);
    }

    public static long getFirstSampleNumber(ExtractorInput extractorInput, FlacStreamMetadata flacStreamMetadata) throws IOException {
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition(1);
        byte[] bArr = new byte[1];
        extractorInput.peekFully(bArr, 0, 1);
        boolean z10 = (bArr[0] & 1) == 1;
        extractorInput.advancePeekPosition(2);
        int i10 = z10 ? 7 : 6;
        ParsableByteArray parsableByteArray = new ParsableByteArray(i10);
        parsableByteArray.setLimit(ExtractorUtil.peekToLength(extractorInput, parsableByteArray.getData(), 0, i10));
        extractorInput.resetPeekPosition();
        SampleNumberHolder sampleNumberHolder = new SampleNumberHolder();
        if (checkAndReadFirstSampleNumber(parsableByteArray, flacStreamMetadata, z10, sampleNumberHolder)) {
            return sampleNumberHolder.sampleNumber;
        }
        throw ParserException.createForMalformedContainer(null, null);
    }

    public static int readFrameBlockSizeSamplesFromKey(ParsableByteArray parsableByteArray, int i10) {
        switch (i10) {
            case 1:
                return PsExtractor.AUDIO_STREAM;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i10 - 2);
            case 6:
                return parsableByteArray.readUnsignedByte() + 1;
            case 7:
                return parsableByteArray.readUnsignedShort() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i10 - 8);
            default:
                return -1;
        }
    }
}
