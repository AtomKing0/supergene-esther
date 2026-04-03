package androidx.media3.extractor.ts;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.DummyTrackOutput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public final class AdtsReader implements ElementaryStreamReader {
    private static final int CRC_SIZE = 2;
    private static final int HEADER_SIZE = 5;
    private static final int ID3_HEADER_SIZE = 10;
    private static final byte[] ID3_IDENTIFIER = {73, 68, 51};
    private static final int ID3_SIZE_OFFSET = 6;
    private static final int MATCH_STATE_FF = 512;
    private static final int MATCH_STATE_I = 768;
    private static final int MATCH_STATE_ID = 1024;
    private static final int MATCH_STATE_START = 256;
    private static final int MATCH_STATE_VALUE_SHIFT = 8;
    private static final int STATE_CHECKING_ADTS_HEADER = 1;
    private static final int STATE_FINDING_SAMPLE = 0;
    private static final int STATE_READING_ADTS_HEADER = 3;
    private static final int STATE_READING_ID3_HEADER = 2;
    private static final int STATE_READING_SAMPLE = 4;
    private static final String TAG = "AdtsReader";
    private static final int VERSION_UNSET = -1;
    private final ParsableBitArray adtsScratch;
    private int bytesRead;
    private int currentFrameVersion;
    private TrackOutput currentOutput;
    private long currentSampleDuration;
    private final boolean exposeId3;
    private int firstFrameSampleRateIndex;
    private int firstFrameVersion;
    private String formatId;
    private boolean foundFirstFrame;
    private boolean hasCrc;
    private boolean hasOutputFormat;
    private final ParsableByteArray id3HeaderBuffer;
    private TrackOutput id3Output;

    @Nullable
    private final String language;
    private int matchState;
    private TrackOutput output;
    private final int roleFlags;
    private long sampleDurationUs;
    private int sampleSize;
    private int state;
    private long timeUs;

    public AdtsReader(boolean z10) {
        this(z10, null, 0);
    }

    private void assertTracksCreated() {
        Assertions.checkNotNull(this.output);
        Util.castNonNull(this.currentOutput);
        Util.castNonNull(this.id3Output);
    }

    private void checkAdtsHeader(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.bytesLeft() == 0) {
            return;
        }
        this.adtsScratch.data[0] = parsableByteArray.getData()[parsableByteArray.getPosition()];
        this.adtsScratch.setPosition(2);
        int bits = this.adtsScratch.readBits(4);
        int i10 = this.firstFrameSampleRateIndex;
        if (i10 != -1 && bits != i10) {
            resetSync();
            return;
        }
        if (!this.foundFirstFrame) {
            this.foundFirstFrame = true;
            this.firstFrameVersion = this.currentFrameVersion;
            this.firstFrameSampleRateIndex = bits;
        }
        setReadingAdtsHeaderState();
    }

    private boolean checkSyncPositionValid(ParsableByteArray parsableByteArray, int i10) {
        parsableByteArray.setPosition(i10 + 1);
        if (!tryRead(parsableByteArray, this.adtsScratch.data, 1)) {
            return false;
        }
        this.adtsScratch.setPosition(4);
        int bits = this.adtsScratch.readBits(1);
        int i11 = this.firstFrameVersion;
        if (i11 != -1 && bits != i11) {
            return false;
        }
        if (this.firstFrameSampleRateIndex != -1) {
            if (!tryRead(parsableByteArray, this.adtsScratch.data, 1)) {
                return true;
            }
            this.adtsScratch.setPosition(2);
            if (this.adtsScratch.readBits(4) != this.firstFrameSampleRateIndex) {
                return false;
            }
            parsableByteArray.setPosition(i10 + 2);
        }
        if (!tryRead(parsableByteArray, this.adtsScratch.data, 4)) {
            return true;
        }
        this.adtsScratch.setPosition(14);
        int bits2 = this.adtsScratch.readBits(13);
        if (bits2 < 7) {
            return false;
        }
        byte[] data = parsableByteArray.getData();
        int iLimit = parsableByteArray.limit();
        int i12 = i10 + bits2;
        if (i12 >= iLimit) {
            return true;
        }
        byte b10 = data[i12];
        if (b10 == -1) {
            int i13 = i12 + 1;
            if (i13 == iLimit) {
                return true;
            }
            return isAdtsSyncBytes((byte) -1, data[i13]) && ((data[i13] & 8) >> 3) == bits;
        }
        if (b10 != 73) {
            return false;
        }
        int i14 = i12 + 1;
        if (i14 == iLimit) {
            return true;
        }
        if (data[i14] != 68) {
            return false;
        }
        int i15 = i12 + 2;
        return i15 == iLimit || data[i15] == 51;
    }

    private boolean continueRead(ParsableByteArray parsableByteArray, byte[] bArr, int i10) {
        int iMin = Math.min(parsableByteArray.bytesLeft(), i10 - this.bytesRead);
        parsableByteArray.readBytes(bArr, this.bytesRead, iMin);
        int i11 = this.bytesRead + iMin;
        this.bytesRead = i11;
        return i11 == i10;
    }

    private void findNextSample(ParsableByteArray parsableByteArray) {
        byte[] data = parsableByteArray.getData();
        int position = parsableByteArray.getPosition();
        int iLimit = parsableByteArray.limit();
        while (position < iLimit) {
            int i10 = position + 1;
            int i11 = data[position] & 255;
            if (this.matchState == 512 && isAdtsSyncBytes((byte) -1, (byte) i11) && (this.foundFirstFrame || checkSyncPositionValid(parsableByteArray, i10 - 2))) {
                this.currentFrameVersion = (i11 & 8) >> 3;
                this.hasCrc = (i11 & 1) == 0;
                if (this.foundFirstFrame) {
                    setReadingAdtsHeaderState();
                } else {
                    setCheckingAdtsHeaderState();
                }
                parsableByteArray.setPosition(i10);
                return;
            }
            int i12 = this.matchState;
            int i13 = i11 | i12;
            if (i13 == 329) {
                this.matchState = MATCH_STATE_I;
            } else if (i13 == 511) {
                this.matchState = 512;
            } else if (i13 == 836) {
                this.matchState = 1024;
            } else if (i13 == 1075) {
                setReadingId3HeaderState();
                parsableByteArray.setPosition(i10);
                return;
            } else if (i12 != 256) {
                this.matchState = 256;
                i10--;
            }
            position = i10;
        }
        parsableByteArray.setPosition(position);
    }

    private boolean isAdtsSyncBytes(byte b10, byte b11) {
        return isAdtsSyncWord(((b10 & 255) << 8) | (b11 & 255));
    }

    public static boolean isAdtsSyncWord(int i10) {
        return (i10 & 65526) == 65520;
    }

    private void parseAdtsHeader() throws ParserException {
        this.adtsScratch.setPosition(0);
        if (this.hasOutputFormat) {
            this.adtsScratch.skipBits(10);
        } else {
            int bits = this.adtsScratch.readBits(2) + 1;
            if (bits != 2) {
                Log.w(TAG, "Detected audio object type: " + bits + ", but assuming AAC LC.");
                bits = 2;
            }
            this.adtsScratch.skipBits(5);
            byte[] bArrBuildAudioSpecificConfig = AacUtil.buildAudioSpecificConfig(bits, this.firstFrameSampleRateIndex, this.adtsScratch.readBits(3));
            AacUtil.Config audioSpecificConfig = AacUtil.parseAudioSpecificConfig(bArrBuildAudioSpecificConfig);
            Format formatBuild = new Format.Builder().setId(this.formatId).setSampleMimeType(MimeTypes.AUDIO_AAC).setCodecs(audioSpecificConfig.codecs).setChannelCount(audioSpecificConfig.channelCount).setSampleRate(audioSpecificConfig.sampleRateHz).setInitializationData(Collections.singletonList(bArrBuildAudioSpecificConfig)).setLanguage(this.language).setRoleFlags(this.roleFlags).build();
            this.sampleDurationUs = 1024000000 / ((long) formatBuild.sampleRate);
            this.output.format(formatBuild);
            this.hasOutputFormat = true;
        }
        this.adtsScratch.skipBits(4);
        int bits2 = (this.adtsScratch.readBits(13) - 2) - 5;
        if (this.hasCrc) {
            bits2 -= 2;
        }
        setReadingSampleState(this.output, this.sampleDurationUs, 0, bits2);
    }

    private void parseId3Header() {
        this.id3Output.sampleData(this.id3HeaderBuffer, 10);
        this.id3HeaderBuffer.setPosition(6);
        setReadingSampleState(this.id3Output, 0L, 10, this.id3HeaderBuffer.readSynchSafeInt() + 10);
    }

    private void readSample(ParsableByteArray parsableByteArray) {
        int iMin = Math.min(parsableByteArray.bytesLeft(), this.sampleSize - this.bytesRead);
        this.currentOutput.sampleData(parsableByteArray, iMin);
        int i10 = this.bytesRead + iMin;
        this.bytesRead = i10;
        if (i10 == this.sampleSize) {
            Assertions.checkState(this.timeUs != C.TIME_UNSET);
            this.currentOutput.sampleMetadata(this.timeUs, 1, this.sampleSize, 0, null);
            this.timeUs += this.currentSampleDuration;
            setFindingSampleState();
        }
    }

    private void resetSync() {
        this.foundFirstFrame = false;
        setFindingSampleState();
    }

    private void setCheckingAdtsHeaderState() {
        this.state = 1;
        this.bytesRead = 0;
    }

    private void setFindingSampleState() {
        this.state = 0;
        this.bytesRead = 0;
        this.matchState = 256;
    }

    private void setReadingAdtsHeaderState() {
        this.state = 3;
        this.bytesRead = 0;
    }

    private void setReadingId3HeaderState() {
        this.state = 2;
        this.bytesRead = ID3_IDENTIFIER.length;
        this.sampleSize = 0;
        this.id3HeaderBuffer.setPosition(0);
    }

    private void setReadingSampleState(TrackOutput trackOutput, long j10, int i10, int i11) {
        this.state = 4;
        this.bytesRead = i10;
        this.currentOutput = trackOutput;
        this.currentSampleDuration = j10;
        this.sampleSize = i11;
    }

    private boolean tryRead(ParsableByteArray parsableByteArray, byte[] bArr, int i10) {
        if (parsableByteArray.bytesLeft() < i10) {
            return false;
        }
        parsableByteArray.readBytes(bArr, 0, i10);
        return true;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray) throws ParserException {
        assertTracksCreated();
        while (parsableByteArray.bytesLeft() > 0) {
            int i10 = this.state;
            if (i10 == 0) {
                findNextSample(parsableByteArray);
            } else if (i10 == 1) {
                checkAdtsHeader(parsableByteArray);
            } else if (i10 != 2) {
                if (i10 == 3) {
                    if (continueRead(parsableByteArray, this.adtsScratch.data, this.hasCrc ? 7 : 5)) {
                        parseAdtsHeader();
                    }
                } else {
                    if (i10 != 4) {
                        throw new IllegalStateException();
                    }
                    readSample(parsableByteArray);
                }
            } else if (continueRead(parsableByteArray, this.id3HeaderBuffer.getData(), 10)) {
                parseId3Header();
            }
        }
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        TrackOutput trackOutputTrack = extractorOutput.track(trackIdGenerator.getTrackId(), 1);
        this.output = trackOutputTrack;
        this.currentOutput = trackOutputTrack;
        if (!this.exposeId3) {
            this.id3Output = new DummyTrackOutput();
            return;
        }
        trackIdGenerator.generateNewId();
        TrackOutput trackOutputTrack2 = extractorOutput.track(trackIdGenerator.getTrackId(), 5);
        this.id3Output = trackOutputTrack2;
        trackOutputTrack2.format(new Format.Builder().setId(trackIdGenerator.getFormatId()).setSampleMimeType(MimeTypes.APPLICATION_ID3).build());
    }

    public long getSampleDurationUs() {
        return this.sampleDurationUs;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j10, int i10) {
        this.timeUs = j10;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.timeUs = C.TIME_UNSET;
        resetSync();
    }

    public AdtsReader(boolean z10, @Nullable String str, int i10) {
        this.adtsScratch = new ParsableBitArray(new byte[7]);
        this.id3HeaderBuffer = new ParsableByteArray(Arrays.copyOf(ID3_IDENTIFIER, 10));
        setFindingSampleState();
        this.firstFrameVersion = -1;
        this.firstFrameSampleRateIndex = -1;
        this.sampleDurationUs = C.TIME_UNSET;
        this.timeUs = C.TIME_UNSET;
        this.exposeId3 = z10;
        this.language = str;
        this.roleFlags = i10;
    }

    @Override // androidx.media3.extractor.ts.ElementaryStreamReader
    public void packetFinished(boolean z10) {
    }
}
