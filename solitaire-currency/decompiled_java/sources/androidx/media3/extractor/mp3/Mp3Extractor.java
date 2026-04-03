package androidx.media3.extractor.mp3;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.DummyTrackOutput;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.Id3Peeker;
import androidx.media3.extractor.MpegAudioUtil;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.d;
import androidx.media3.extractor.f;
import androidx.media3.extractor.metadata.id3.Id3Decoder;
import androidx.media3.extractor.metadata.id3.MlltFrame;
import androidx.media3.extractor.metadata.id3.TextInformationFrame;
import androidx.media3.extractor.mp3.Seeker;
import androidx.media3.extractor.text.SubtitleParser;
import java.io.EOFException;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public final class Mp3Extractor implements Extractor {
    public static final int FLAG_DISABLE_ID3_METADATA = 8;
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING = 1;
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING_ALWAYS = 2;
    public static final int FLAG_ENABLE_INDEX_SEEKING = 4;
    private static final int MAX_SNIFF_BYTES = 32768;
    private static final int MAX_SYNC_BYTES = 131072;
    private static final int MPEG_AUDIO_HEADER_MASK = -128000;
    private static final int SCRATCH_LENGTH = 10;
    private static final int SEEK_HEADER_INFO = 1231971951;
    private static final int SEEK_HEADER_UNSET = 0;
    private static final int SEEK_HEADER_VBRI = 1447187017;
    private static final int SEEK_HEADER_XING = 1483304551;
    private long basisTimeUs;
    private TrackOutput currentTrackOutput;
    private boolean disableSeeking;
    private ExtractorOutput extractorOutput;
    private long firstSamplePosition;
    private final int flags;
    private final long forcedFirstSampleTimestampUs;
    private final GaplessInfoHolder gaplessInfoHolder;
    private final Id3Peeker id3Peeker;
    private boolean isSeekInProgress;

    @Nullable
    private Metadata metadata;
    private TrackOutput realTrackOutput;
    private int sampleBytesRemaining;
    private long samplesRead;
    private final ParsableByteArray scratch;
    private long seekTimeUs;
    private Seeker seeker;
    private final TrackOutput skippingTrackOutput;
    private final MpegAudioUtil.Header synchronizedHeader;
    private int synchronizedHeaderData;
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: androidx.media3.extractor.mp3.a
        @Override // androidx.media3.extractor.ExtractorsFactory
        public final Extractor[] createExtractors() {
            return Mp3Extractor.lambda$static$0();
        }

        @Override // androidx.media3.extractor.ExtractorsFactory
        public /* synthetic */ ExtractorsFactory experimentalSetTextTrackTranscodingEnabled(boolean z10) {
            return f.b(this, z10);
        }

        @Override // androidx.media3.extractor.ExtractorsFactory
        public /* synthetic */ ExtractorsFactory setSubtitleParserFactory(SubtitleParser.Factory factory) {
            return f.c(this, factory);
        }

        @Override // androidx.media3.extractor.ExtractorsFactory
        public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
            return f.a(this, uri, map);
        }
    };
    private static final Id3Decoder.FramePredicate REQUIRED_ID3_FRAME_PREDICATE = new Id3Decoder.FramePredicate() { // from class: androidx.media3.extractor.mp3.b
        @Override // androidx.media3.extractor.metadata.id3.Id3Decoder.FramePredicate
        public final boolean evaluate(int i10, int i11, int i12, int i13, int i14) {
            return Mp3Extractor.lambda$static$1(i10, i11, i12, i13, i14);
        }
    };

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public Mp3Extractor() {
        this(0);
    }

    private void assertInitialized() {
        Assertions.checkStateNotNull(this.realTrackOutput);
        Util.castNonNull(this.extractorOutput);
    }

    private Seeker computeSeeker(ExtractorInput extractorInput) throws IOException {
        long id3TlenUs;
        long dataEndPosition;
        Seeker seekerMaybeReadSeekFrame = maybeReadSeekFrame(extractorInput);
        MlltSeeker mlltSeekerMaybeHandleSeekMetadata = maybeHandleSeekMetadata(this.metadata, extractorInput.getPosition());
        if (this.disableSeeking) {
            return new Seeker.UnseekableSeeker();
        }
        if ((this.flags & 4) != 0) {
            if (mlltSeekerMaybeHandleSeekMetadata != null) {
                id3TlenUs = mlltSeekerMaybeHandleSeekMetadata.getDurationUs();
                dataEndPosition = mlltSeekerMaybeHandleSeekMetadata.getDataEndPosition();
            } else if (seekerMaybeReadSeekFrame != null) {
                id3TlenUs = seekerMaybeReadSeekFrame.getDurationUs();
                dataEndPosition = seekerMaybeReadSeekFrame.getDataEndPosition();
            } else {
                id3TlenUs = getId3TlenUs(this.metadata);
                dataEndPosition = -1;
            }
            seekerMaybeReadSeekFrame = new IndexSeeker(id3TlenUs, extractorInput.getPosition(), dataEndPosition);
        } else if (mlltSeekerMaybeHandleSeekMetadata != null) {
            seekerMaybeReadSeekFrame = mlltSeekerMaybeHandleSeekMetadata;
        } else if (seekerMaybeReadSeekFrame == null) {
            seekerMaybeReadSeekFrame = null;
        }
        if (seekerMaybeReadSeekFrame == null || !(seekerMaybeReadSeekFrame.isSeekable() || (this.flags & 1) == 0)) {
            return getConstantBitrateSeeker(extractorInput, (this.flags & 2) != 0);
        }
        return seekerMaybeReadSeekFrame;
    }

    private long computeTimeUs(long j10) {
        return this.basisTimeUs + ((j10 * 1000000) / ((long) this.synchronizedHeader.sampleRate));
    }

    private Seeker getConstantBitrateSeeker(ExtractorInput extractorInput, boolean z10) throws IOException {
        return getConstantBitrateSeeker(extractorInput, -1L, z10);
    }

    private static long getId3TlenUs(@Nullable Metadata metadata) {
        if (metadata == null) {
            return C.TIME_UNSET;
        }
        int length = metadata.length();
        for (int i10 = 0; i10 < length; i10++) {
            Metadata.Entry entry = metadata.get(i10);
            if (entry instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) entry;
                if (textInformationFrame.id.equals("TLEN")) {
                    return Util.msToUs(Long.parseLong(textInformationFrame.values.get(0)));
                }
            }
        }
        return C.TIME_UNSET;
    }

    private static int getSeekFrameHeader(ParsableByteArray parsableByteArray, int i10) {
        if (parsableByteArray.limit() >= i10 + 4) {
            parsableByteArray.setPosition(i10);
            int i11 = parsableByteArray.readInt();
            if (i11 == SEEK_HEADER_XING || i11 == SEEK_HEADER_INFO) {
                return i11;
            }
        }
        if (parsableByteArray.limit() < 40) {
            return 0;
        }
        parsableByteArray.setPosition(36);
        if (parsableByteArray.readInt() == SEEK_HEADER_VBRI) {
            return SEEK_HEADER_VBRI;
        }
        return 0;
    }

    private static boolean headersMatch(int i10, long j10) {
        return ((long) (i10 & MPEG_AUDIO_HEADER_MASK)) == (j10 & (-128000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new Mp3Extractor()};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$static$1(int i10, int i11, int i12, int i13, int i14) {
        return (i11 == 67 && i12 == 79 && i13 == 77 && (i14 == 77 || i10 == 2)) || (i11 == 77 && i12 == 76 && i13 == 76 && (i14 == 84 || i10 == 2));
    }

    @Nullable
    private static MlltSeeker maybeHandleSeekMetadata(@Nullable Metadata metadata, long j10) {
        if (metadata == null) {
            return null;
        }
        int length = metadata.length();
        for (int i10 = 0; i10 < length; i10++) {
            Metadata.Entry entry = metadata.get(i10);
            if (entry instanceof MlltFrame) {
                return MlltSeeker.create(j10, (MlltFrame) entry, getId3TlenUs(metadata));
            }
        }
        return null;
    }

    @Nullable
    private Seeker maybeReadSeekFrame(ExtractorInput extractorInput) throws IOException {
        int i10;
        int i11;
        ParsableByteArray parsableByteArray = new ParsableByteArray(this.synchronizedHeader.frameSize);
        extractorInput.peekFully(parsableByteArray.getData(), 0, this.synchronizedHeader.frameSize);
        MpegAudioUtil.Header header = this.synchronizedHeader;
        int i12 = 21;
        if ((header.version & 1) != 0) {
            if (header.channels != 1) {
                i12 = 36;
            }
        } else if (header.channels == 1) {
            i12 = 13;
        }
        int seekFrameHeader = getSeekFrameHeader(parsableByteArray, i12);
        if (seekFrameHeader != SEEK_HEADER_INFO) {
            if (seekFrameHeader == SEEK_HEADER_VBRI) {
                VbriSeeker vbriSeekerCreate = VbriSeeker.create(extractorInput.getLength(), extractorInput.getPosition(), this.synchronizedHeader, parsableByteArray);
                extractorInput.skipFully(this.synchronizedHeader.frameSize);
                return vbriSeekerCreate;
            }
            if (seekFrameHeader != SEEK_HEADER_XING) {
                extractorInput.resetPeekPosition();
                return null;
            }
        }
        XingFrame xingFrame = XingFrame.parse(this.synchronizedHeader, parsableByteArray);
        if (!this.gaplessInfoHolder.hasGaplessInfo() && (i10 = xingFrame.encoderDelay) != -1 && (i11 = xingFrame.encoderPadding) != -1) {
            GaplessInfoHolder gaplessInfoHolder = this.gaplessInfoHolder;
            gaplessInfoHolder.encoderDelay = i10;
            gaplessInfoHolder.encoderPadding = i11;
        }
        long position = extractorInput.getPosition();
        extractorInput.skipFully(this.synchronizedHeader.frameSize);
        if (seekFrameHeader == SEEK_HEADER_XING) {
            return XingSeeker.create(extractorInput.getLength(), xingFrame, position);
        }
        long j10 = xingFrame.dataSize;
        return getConstantBitrateSeeker(extractorInput, j10 != -1 ? position + j10 : -1L, false);
    }

    private boolean peekEndOfStreamOrHeader(ExtractorInput extractorInput) throws IOException {
        Seeker seeker = this.seeker;
        if (seeker != null) {
            long dataEndPosition = seeker.getDataEndPosition();
            if (dataEndPosition != -1 && extractorInput.getPeekPosition() > dataEndPosition - 4) {
                return true;
            }
        }
        try {
            return !extractorInput.peekFully(this.scratch.getData(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    private int readInternal(ExtractorInput extractorInput) throws IOException {
        if (this.synchronizedHeaderData == 0) {
            try {
                synchronize(extractorInput, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.seeker == null) {
            Seeker seekerComputeSeeker = computeSeeker(extractorInput);
            this.seeker = seekerComputeSeeker;
            this.extractorOutput.seekMap(seekerComputeSeeker);
            this.currentTrackOutput.format(new Format.Builder().setSampleMimeType(this.synchronizedHeader.mimeType).setMaxInputSize(4096).setChannelCount(this.synchronizedHeader.channels).setSampleRate(this.synchronizedHeader.sampleRate).setEncoderDelay(this.gaplessInfoHolder.encoderDelay).setEncoderPadding(this.gaplessInfoHolder.encoderPadding).setMetadata((this.flags & 8) != 0 ? null : this.metadata).build());
            this.firstSamplePosition = extractorInput.getPosition();
        } else if (this.firstSamplePosition != 0) {
            long position = extractorInput.getPosition();
            long j10 = this.firstSamplePosition;
            if (position < j10) {
                extractorInput.skipFully((int) (j10 - position));
            }
        }
        return readSample(extractorInput);
    }

    private int readSample(ExtractorInput extractorInput) throws IOException {
        if (this.sampleBytesRemaining == 0) {
            extractorInput.resetPeekPosition();
            if (peekEndOfStreamOrHeader(extractorInput)) {
                return -1;
            }
            this.scratch.setPosition(0);
            int i10 = this.scratch.readInt();
            if (!headersMatch(i10, this.synchronizedHeaderData) || MpegAudioUtil.getFrameSize(i10) == -1) {
                extractorInput.skipFully(1);
                this.synchronizedHeaderData = 0;
                return 0;
            }
            this.synchronizedHeader.setForHeaderData(i10);
            if (this.basisTimeUs == C.TIME_UNSET) {
                this.basisTimeUs = this.seeker.getTimeUs(extractorInput.getPosition());
                if (this.forcedFirstSampleTimestampUs != C.TIME_UNSET) {
                    this.basisTimeUs += this.forcedFirstSampleTimestampUs - this.seeker.getTimeUs(0L);
                }
            }
            MpegAudioUtil.Header header = this.synchronizedHeader;
            this.sampleBytesRemaining = header.frameSize;
            Seeker seeker = this.seeker;
            if (seeker instanceof IndexSeeker) {
                IndexSeeker indexSeeker = (IndexSeeker) seeker;
                indexSeeker.maybeAddSeekPoint(computeTimeUs(this.samplesRead + ((long) header.samplesPerFrame)), extractorInput.getPosition() + ((long) this.synchronizedHeader.frameSize));
                if (this.isSeekInProgress && indexSeeker.isTimeUsInIndex(this.seekTimeUs)) {
                    this.isSeekInProgress = false;
                    this.currentTrackOutput = this.realTrackOutput;
                }
            }
        }
        int iSampleData = this.currentTrackOutput.sampleData((DataReader) extractorInput, this.sampleBytesRemaining, true);
        if (iSampleData == -1) {
            return -1;
        }
        int i11 = this.sampleBytesRemaining - iSampleData;
        this.sampleBytesRemaining = i11;
        if (i11 > 0) {
            return 0;
        }
        this.currentTrackOutput.sampleMetadata(computeTimeUs(this.samplesRead), 1, this.synchronizedHeader.frameSize, 0, null);
        this.samplesRead += (long) this.synchronizedHeader.samplesPerFrame;
        this.sampleBytesRemaining = 0;
        return 0;
    }

    private boolean synchronize(ExtractorInput extractorInput, boolean z10) throws IOException {
        int peekPosition;
        int i10;
        int frameSize;
        int i11 = z10 ? 32768 : 131072;
        extractorInput.resetPeekPosition();
        if (extractorInput.getPosition() == 0) {
            Metadata metadataPeekId3Data = this.id3Peeker.peekId3Data(extractorInput, (this.flags & 8) == 0 ? null : REQUIRED_ID3_FRAME_PREDICATE);
            this.metadata = metadataPeekId3Data;
            if (metadataPeekId3Data != null) {
                this.gaplessInfoHolder.setFromMetadata(metadataPeekId3Data);
            }
            peekPosition = (int) extractorInput.getPeekPosition();
            if (!z10) {
                extractorInput.skipFully(peekPosition);
            }
            i10 = 0;
        } else {
            peekPosition = 0;
            i10 = 0;
        }
        int i12 = i10;
        int i13 = i12;
        while (true) {
            if (!peekEndOfStreamOrHeader(extractorInput)) {
                this.scratch.setPosition(0);
                int i14 = this.scratch.readInt();
                if ((i10 == 0 || headersMatch(i14, i10)) && (frameSize = MpegAudioUtil.getFrameSize(i14)) != -1) {
                    i12++;
                    if (i12 != 1) {
                        if (i12 == 4) {
                            break;
                        }
                    } else {
                        this.synchronizedHeader.setForHeaderData(i14);
                        i10 = i14;
                    }
                    extractorInput.advancePeekPosition(frameSize - 4);
                } else {
                    int i15 = i13 + 1;
                    if (i13 == i11) {
                        if (z10) {
                            return false;
                        }
                        throw ParserException.createForMalformedContainer("Searched too many bytes.", null);
                    }
                    if (z10) {
                        extractorInput.resetPeekPosition();
                        extractorInput.advancePeekPosition(peekPosition + i15);
                    } else {
                        extractorInput.skipFully(1);
                    }
                    i12 = 0;
                    i13 = i15;
                    i10 = 0;
                }
            } else if (i12 <= 0) {
                throw new EOFException();
            }
        }
        if (z10) {
            extractorInput.skipFully(peekPosition + i13);
        } else {
            extractorInput.resetPeekPosition();
        }
        this.synchronizedHeaderData = i10;
        return true;
    }

    public void disableSeeking() {
        this.disableSeeking = true;
    }

    @Override // androidx.media3.extractor.Extractor
    public /* synthetic */ Extractor getUnderlyingImplementation() {
        return d.a(this);
    }

    @Override // androidx.media3.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
        TrackOutput trackOutputTrack = extractorOutput.track(0, 1);
        this.realTrackOutput = trackOutputTrack;
        this.currentTrackOutput = trackOutputTrack;
        this.extractorOutput.endTracks();
    }

    @Override // androidx.media3.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        assertInitialized();
        int internal = readInternal(extractorInput);
        if (internal == -1 && (this.seeker instanceof IndexSeeker)) {
            long jComputeTimeUs = computeTimeUs(this.samplesRead);
            if (this.seeker.getDurationUs() != jComputeTimeUs) {
                ((IndexSeeker) this.seeker).setDurationUs(jComputeTimeUs);
                this.extractorOutput.seekMap(this.seeker);
            }
        }
        return internal;
    }

    @Override // androidx.media3.extractor.Extractor
    public void seek(long j10, long j11) {
        this.synchronizedHeaderData = 0;
        this.basisTimeUs = C.TIME_UNSET;
        this.samplesRead = 0L;
        this.sampleBytesRemaining = 0;
        this.seekTimeUs = j11;
        Seeker seeker = this.seeker;
        if (!(seeker instanceof IndexSeeker) || ((IndexSeeker) seeker).isTimeUsInIndex(j11)) {
            return;
        }
        this.isSeekInProgress = true;
        this.currentTrackOutput = this.skippingTrackOutput;
    }

    @Override // androidx.media3.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        return synchronize(extractorInput, true);
    }

    public Mp3Extractor(int i10) {
        this(i10, C.TIME_UNSET);
    }

    private Seeker getConstantBitrateSeeker(ExtractorInput extractorInput, long j10, boolean z10) throws IOException {
        extractorInput.peekFully(this.scratch.getData(), 0, 4);
        this.scratch.setPosition(0);
        this.synchronizedHeader.setForHeaderData(this.scratch.readInt());
        if (extractorInput.getLength() != -1) {
            j10 = extractorInput.getLength();
        }
        return new ConstantBitrateSeeker(j10, extractorInput.getPosition(), this.synchronizedHeader, z10);
    }

    public Mp3Extractor(int i10, long j10) {
        this.flags = (i10 & 2) != 0 ? i10 | 1 : i10;
        this.forcedFirstSampleTimestampUs = j10;
        this.scratch = new ParsableByteArray(10);
        this.synchronizedHeader = new MpegAudioUtil.Header();
        this.gaplessInfoHolder = new GaplessInfoHolder();
        this.basisTimeUs = C.TIME_UNSET;
        this.id3Peeker = new Id3Peeker();
        DummyTrackOutput dummyTrackOutput = new DummyTrackOutput();
        this.skippingTrackOutput = dummyTrackOutput;
        this.currentTrackOutput = dummyTrackOutput;
    }

    @Override // androidx.media3.extractor.Extractor
    public void release() {
    }
}
