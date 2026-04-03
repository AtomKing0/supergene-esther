package androidx.media3.exoplayer.video;

import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.TimedValueQueue;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoConfig;
import androidx.media3.decoder.Decoder;
import androidx.media3.decoder.DecoderException;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.VideoDecoderOutputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.video.VideoRendererEventListener;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public abstract class DecoderVideoRenderer extends BaseRenderer {
    private static final int REINITIALIZATION_STATE_NONE = 0;
    private static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 2;
    private static final String TAG = "DecoderVideoRenderer";
    private final long allowedJoiningTimeMs;
    private int buffersInCodecCount;
    private int consecutiveDroppedFrameCount;

    @Nullable
    private Decoder<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> decoder;
    protected DecoderCounters decoderCounters;

    @Nullable
    private DrmSession decoderDrmSession;
    private boolean decoderReceivedBuffers;
    private int decoderReinitializationState;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private final VideoRendererEventListener.EventDispatcher eventDispatcher;
    private int firstFrameState;
    private final DecoderInputBuffer flagsOnlyBuffer;
    private final TimedValueQueue<Format> formatQueue;

    @Nullable
    private VideoFrameMetadataListener frameMetadataListener;
    private long initialPositionUs;

    @Nullable
    private DecoderInputBuffer inputBuffer;

    @Nullable
    private Format inputFormat;
    private boolean inputStreamEnded;
    private long joiningDeadlineMs;
    private long lastRenderTimeUs;
    private final int maxDroppedFramesToNotify;

    @Nullable
    private Object output;

    @Nullable
    private VideoDecoderOutputBuffer outputBuffer;

    @Nullable
    private VideoDecoderOutputBufferRenderer outputBufferRenderer;

    @Nullable
    private Format outputFormat;
    private int outputMode;
    private boolean outputStreamEnded;
    private long outputStreamOffsetUs;

    @Nullable
    private Surface outputSurface;

    @Nullable
    private VideoSize reportedVideoSize;

    @Nullable
    private DrmSession sourceDrmSession;
    private boolean waitingForFirstSampleInFormat;

    protected DecoderVideoRenderer(long j10, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i10) {
        super(2);
        this.allowedJoiningTimeMs = j10;
        this.maxDroppedFramesToNotify = i10;
        this.joiningDeadlineMs = C.TIME_UNSET;
        this.formatQueue = new TimedValueQueue<>();
        this.flagsOnlyBuffer = DecoderInputBuffer.newNoDataInstance();
        this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.decoderReinitializationState = 0;
        this.outputMode = -1;
        this.firstFrameState = 0;
        this.decoderCounters = new DecoderCounters();
    }

    private boolean drainOutputBuffer(long j10, long j11) throws ExoPlaybackException, DecoderException {
        if (this.outputBuffer == null) {
            VideoDecoderOutputBuffer videoDecoderOutputBuffer = (VideoDecoderOutputBuffer) ((Decoder) Assertions.checkNotNull(this.decoder)).dequeueOutputBuffer();
            this.outputBuffer = videoDecoderOutputBuffer;
            if (videoDecoderOutputBuffer == null) {
                return false;
            }
            DecoderCounters decoderCounters = this.decoderCounters;
            int i10 = decoderCounters.skippedOutputBufferCount;
            int i11 = videoDecoderOutputBuffer.skippedOutputBufferCount;
            decoderCounters.skippedOutputBufferCount = i10 + i11;
            this.buffersInCodecCount -= i11;
        }
        if (!this.outputBuffer.isEndOfStream()) {
            boolean zProcessOutputBuffer = processOutputBuffer(j10, j11);
            if (zProcessOutputBuffer) {
                onProcessedOutputBuffer(((VideoDecoderOutputBuffer) Assertions.checkNotNull(this.outputBuffer)).timeUs);
                this.outputBuffer = null;
            }
            return zProcessOutputBuffer;
        }
        if (this.decoderReinitializationState == 2) {
            releaseDecoder();
            maybeInitDecoder();
        } else {
            this.outputBuffer.release();
            this.outputBuffer = null;
            this.outputStreamEnded = true;
        }
        return false;
    }

    private boolean feedInputBuffer() throws ExoPlaybackException, DecoderException {
        Decoder<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> decoder = this.decoder;
        if (decoder == null || this.decoderReinitializationState == 2 || this.inputStreamEnded) {
            return false;
        }
        if (this.inputBuffer == null) {
            DecoderInputBuffer decoderInputBufferDequeueInputBuffer = decoder.dequeueInputBuffer();
            this.inputBuffer = decoderInputBufferDequeueInputBuffer;
            if (decoderInputBufferDequeueInputBuffer == null) {
                return false;
            }
        }
        DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) Assertions.checkNotNull(this.inputBuffer);
        if (this.decoderReinitializationState == 1) {
            decoderInputBuffer.setFlags(4);
            ((Decoder) Assertions.checkNotNull(this.decoder)).queueInputBuffer(decoderInputBuffer);
            this.inputBuffer = null;
            this.decoderReinitializationState = 2;
            return false;
        }
        FormatHolder formatHolder = getFormatHolder();
        int source = readSource(formatHolder, decoderInputBuffer, 0);
        if (source == -5) {
            onInputFormatChanged(formatHolder);
            return true;
        }
        if (source != -4) {
            if (source == -3) {
                return false;
            }
            throw new IllegalStateException();
        }
        if (decoderInputBuffer.isEndOfStream()) {
            this.inputStreamEnded = true;
            ((Decoder) Assertions.checkNotNull(this.decoder)).queueInputBuffer(decoderInputBuffer);
            this.inputBuffer = null;
            return false;
        }
        if (this.waitingForFirstSampleInFormat) {
            this.formatQueue.add(decoderInputBuffer.timeUs, (Format) Assertions.checkNotNull(this.inputFormat));
            this.waitingForFirstSampleInFormat = false;
        }
        if (decoderInputBuffer.timeUs < getLastResetPositionUs()) {
            decoderInputBuffer.addFlag(Integer.MIN_VALUE);
        }
        decoderInputBuffer.flip();
        decoderInputBuffer.format = this.inputFormat;
        onQueueInputBuffer(decoderInputBuffer);
        ((Decoder) Assertions.checkNotNull(this.decoder)).queueInputBuffer(decoderInputBuffer);
        this.buffersInCodecCount++;
        this.decoderReceivedBuffers = true;
        this.decoderCounters.queuedInputBufferCount++;
        this.inputBuffer = null;
        return true;
    }

    private boolean hasOutput() {
        return this.outputMode != -1;
    }

    private static boolean isBufferLate(long j10) {
        return j10 < -30000;
    }

    private static boolean isBufferVeryLate(long j10) {
        return j10 < -500000;
    }

    private void lowerFirstFrameState(int i10) {
        this.firstFrameState = Math.min(this.firstFrameState, i10);
    }

    private void maybeInitDecoder() throws ExoPlaybackException {
        CryptoConfig cryptoConfig;
        if (this.decoder != null) {
            return;
        }
        setDecoderDrmSession(this.sourceDrmSession);
        DrmSession drmSession = this.decoderDrmSession;
        if (drmSession != null) {
            cryptoConfig = drmSession.getCryptoConfig();
            if (cryptoConfig == null && this.decoderDrmSession.getError() == null) {
                return;
            }
        } else {
            cryptoConfig = null;
        }
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Decoder<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> decoderCreateDecoder = createDecoder((Format) Assertions.checkNotNull(this.inputFormat), cryptoConfig);
            this.decoder = decoderCreateDecoder;
            decoderCreateDecoder.setOutputStartTimeUs(getLastResetPositionUs());
            setDecoderOutputMode(this.outputMode);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            this.eventDispatcher.decoderInitialized(((Decoder) Assertions.checkNotNull(this.decoder)).getName(), jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
            this.decoderCounters.decoderInitCount++;
        } catch (DecoderException e10) {
            Log.e(TAG, "Video codec error", e10);
            this.eventDispatcher.videoCodecError(e10);
            throw createRendererException(e10, this.inputFormat, 4001);
        } catch (OutOfMemoryError e11) {
            throw createRendererException(e11, this.inputFormat, 4001);
        }
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, jElapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = jElapsedRealtime;
        }
    }

    private void maybeNotifyRenderedFirstFrame() {
        if (this.firstFrameState != 3) {
            this.firstFrameState = 3;
            Object obj = this.output;
            if (obj != null) {
                this.eventDispatcher.renderedFirstFrame(obj);
            }
        }
    }

    private void maybeNotifyVideoSizeChanged(int i10, int i11) {
        VideoSize videoSize = this.reportedVideoSize;
        if (videoSize != null && videoSize.width == i10 && videoSize.height == i11) {
            return;
        }
        VideoSize videoSize2 = new VideoSize(i10, i11);
        this.reportedVideoSize = videoSize2;
        this.eventDispatcher.videoSizeChanged(videoSize2);
    }

    private void maybeRenotifyRenderedFirstFrame() {
        Object obj;
        if (this.firstFrameState != 3 || (obj = this.output) == null) {
            return;
        }
        this.eventDispatcher.renderedFirstFrame(obj);
    }

    private void maybeRenotifyVideoSizeChanged() {
        VideoSize videoSize = this.reportedVideoSize;
        if (videoSize != null) {
            this.eventDispatcher.videoSizeChanged(videoSize);
        }
    }

    private void onOutputChanged() {
        maybeRenotifyVideoSizeChanged();
        lowerFirstFrameState(1);
        if (getState() == 2) {
            setJoiningDeadlineMs();
        }
    }

    private void onOutputRemoved() {
        this.reportedVideoSize = null;
        lowerFirstFrameState(1);
    }

    private void onOutputReset() {
        maybeRenotifyVideoSizeChanged();
        maybeRenotifyRenderedFirstFrame();
    }

    private boolean processOutputBuffer(long j10, long j11) throws ExoPlaybackException, DecoderException {
        if (this.initialPositionUs == C.TIME_UNSET) {
            this.initialPositionUs = j10;
        }
        VideoDecoderOutputBuffer videoDecoderOutputBuffer = (VideoDecoderOutputBuffer) Assertions.checkNotNull(this.outputBuffer);
        long j12 = videoDecoderOutputBuffer.timeUs;
        long j13 = j12 - j10;
        if (!hasOutput()) {
            if (!isBufferLate(j13)) {
                return false;
            }
            skipOutputBuffer(videoDecoderOutputBuffer);
            return true;
        }
        Format formatPollFloor = this.formatQueue.pollFloor(j12);
        if (formatPollFloor != null) {
            this.outputFormat = formatPollFloor;
        } else if (this.outputFormat == null) {
            this.outputFormat = this.formatQueue.pollFirst();
        }
        long j14 = j12 - this.outputStreamOffsetUs;
        if (shouldForceRender(j13)) {
            renderOutputBuffer(videoDecoderOutputBuffer, j14, (Format) Assertions.checkNotNull(this.outputFormat));
            return true;
        }
        if (!(getState() == 2) || j10 == this.initialPositionUs || (shouldDropBuffersToKeyframe(j13, j11) && maybeDropBuffersToKeyframe(j10))) {
            return false;
        }
        if (shouldDropOutputBuffer(j13, j11)) {
            dropOutputBuffer(videoDecoderOutputBuffer);
            return true;
        }
        if (j13 < 30000) {
            renderOutputBuffer(videoDecoderOutputBuffer, j14, (Format) Assertions.checkNotNull(this.outputFormat));
            return true;
        }
        return false;
    }

    private void setDecoderDrmSession(@Nullable DrmSession drmSession) {
        androidx.media3.exoplayer.drm.i.b(this.decoderDrmSession, drmSession);
        this.decoderDrmSession = drmSession;
    }

    private void setJoiningDeadlineMs() {
        this.joiningDeadlineMs = this.allowedJoiningTimeMs > 0 ? SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs : C.TIME_UNSET;
    }

    private void setSourceDrmSession(@Nullable DrmSession drmSession) {
        androidx.media3.exoplayer.drm.i.b(this.sourceDrmSession, drmSession);
        this.sourceDrmSession = drmSession;
    }

    private boolean shouldForceRender(long j10) {
        boolean z10 = getState() == 2;
        int i10 = this.firstFrameState;
        if (i10 == 0) {
            return z10;
        }
        if (i10 == 1) {
            return true;
        }
        if (i10 == 3) {
            return z10 && shouldForceRenderOutputBuffer(j10, Util.msToUs(SystemClock.elapsedRealtime()) - this.lastRenderTimeUs);
        }
        throw new IllegalStateException();
    }

    protected DecoderReuseEvaluation canReuseDecoder(String str, Format format, Format format2) {
        return new DecoderReuseEvaluation(str, format, format2, 0, 1);
    }

    protected abstract Decoder<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> createDecoder(Format format, @Nullable CryptoConfig cryptoConfig) throws DecoderException;

    protected void dropOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        updateDroppedBufferCounters(0, 1);
        videoDecoderOutputBuffer.release();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.Renderer
    public void enableMayRenderStartOfStream() {
        if (this.firstFrameState == 0) {
            this.firstFrameState = 1;
        }
    }

    @CallSuper
    protected void flushDecoder() throws ExoPlaybackException {
        this.buffersInCodecCount = 0;
        if (this.decoderReinitializationState != 0) {
            releaseDecoder();
            maybeInitDecoder();
            return;
        }
        this.inputBuffer = null;
        VideoDecoderOutputBuffer videoDecoderOutputBuffer = this.outputBuffer;
        if (videoDecoderOutputBuffer != null) {
            videoDecoderOutputBuffer.release();
            this.outputBuffer = null;
        }
        Decoder decoder = (Decoder) Assertions.checkNotNull(this.decoder);
        decoder.flush();
        decoder.setOutputStartTimeUs(getLastResetPositionUs());
        this.decoderReceivedBuffers = false;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.PlayerMessage.Target
    public void handleMessage(int i10, @Nullable Object obj) throws ExoPlaybackException {
        if (i10 == 1) {
            setOutput(obj);
        } else if (i10 == 7) {
            this.frameMetadataListener = (VideoFrameMetadataListener) obj;
        } else {
            super.handleMessage(i10, obj);
        }
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public boolean isReady() {
        if (this.inputFormat != null && ((isSourceReady() || this.outputBuffer != null) && (this.firstFrameState == 3 || !hasOutput()))) {
            this.joiningDeadlineMs = C.TIME_UNSET;
            return true;
        }
        if (this.joiningDeadlineMs == C.TIME_UNSET) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.joiningDeadlineMs) {
            return true;
        }
        this.joiningDeadlineMs = C.TIME_UNSET;
        return false;
    }

    protected boolean maybeDropBuffersToKeyframe(long j10) throws ExoPlaybackException {
        int iSkipSource = skipSource(j10);
        if (iSkipSource == 0) {
            return false;
        }
        this.decoderCounters.droppedToKeyframeCount++;
        updateDroppedBufferCounters(iSkipSource, this.buffersInCodecCount);
        flushDecoder();
        return true;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void onDisabled() {
        this.inputFormat = null;
        this.reportedVideoSize = null;
        lowerFirstFrameState(0);
        try {
            setSourceDrmSession(null);
            releaseDecoder();
        } finally {
            this.eventDispatcher.disabled(this.decoderCounters);
        }
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void onEnabled(boolean z10, boolean z11) throws ExoPlaybackException {
        DecoderCounters decoderCounters = new DecoderCounters();
        this.decoderCounters = decoderCounters;
        this.eventDispatcher.enabled(decoderCounters);
        this.firstFrameState = z11 ? 1 : 0;
    }

    @CallSuper
    protected void onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException {
        this.waitingForFirstSampleInFormat = true;
        Format format = (Format) Assertions.checkNotNull(formatHolder.format);
        setSourceDrmSession(formatHolder.drmSession);
        Format format2 = this.inputFormat;
        this.inputFormat = format;
        Decoder<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> decoder = this.decoder;
        if (decoder == null) {
            maybeInitDecoder();
            this.eventDispatcher.inputFormatChanged((Format) Assertions.checkNotNull(this.inputFormat), null);
            return;
        }
        DecoderReuseEvaluation decoderReuseEvaluation = this.sourceDrmSession != this.decoderDrmSession ? new DecoderReuseEvaluation(decoder.getName(), (Format) Assertions.checkNotNull(format2), format, 0, 128) : canReuseDecoder(decoder.getName(), (Format) Assertions.checkNotNull(format2), format);
        if (decoderReuseEvaluation.result == 0) {
            if (this.decoderReceivedBuffers) {
                this.decoderReinitializationState = 1;
            } else {
                releaseDecoder();
                maybeInitDecoder();
            }
        }
        this.eventDispatcher.inputFormatChanged((Format) Assertions.checkNotNull(this.inputFormat), decoderReuseEvaluation);
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void onPositionReset(long j10, boolean z10) throws ExoPlaybackException {
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        lowerFirstFrameState(1);
        this.initialPositionUs = C.TIME_UNSET;
        this.consecutiveDroppedFrameCount = 0;
        if (this.decoder != null) {
            flushDecoder();
        }
        if (z10) {
            setJoiningDeadlineMs();
        } else {
            this.joiningDeadlineMs = C.TIME_UNSET;
        }
        this.formatQueue.clear();
    }

    @CallSuper
    protected void onProcessedOutputBuffer(long j10) {
        this.buffersInCodecCount--;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void onStarted() {
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
        this.lastRenderTimeUs = Util.msToUs(SystemClock.elapsedRealtime());
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void onStopped() {
        this.joiningDeadlineMs = C.TIME_UNSET;
        maybeNotifyDroppedFrames();
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    protected void onStreamChanged(Format[] formatArr, long j10, long j11, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException {
        this.outputStreamOffsetUs = j11;
        super.onStreamChanged(formatArr, j10, j11, mediaPeriodId);
    }

    @CallSuper
    protected void releaseDecoder() {
        this.inputBuffer = null;
        this.outputBuffer = null;
        this.decoderReinitializationState = 0;
        this.decoderReceivedBuffers = false;
        this.buffersInCodecCount = 0;
        Decoder<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> decoder = this.decoder;
        if (decoder != null) {
            this.decoderCounters.decoderReleaseCount++;
            decoder.release();
            this.eventDispatcher.decoderReleased(this.decoder.getName());
            this.decoder = null;
        }
        setDecoderDrmSession(null);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public void render(long j10, long j11) throws ExoPlaybackException {
        if (this.outputStreamEnded) {
            return;
        }
        if (this.inputFormat == null) {
            FormatHolder formatHolder = getFormatHolder();
            this.flagsOnlyBuffer.clear();
            int source = readSource(formatHolder, this.flagsOnlyBuffer, 2);
            if (source != -5) {
                if (source == -4) {
                    Assertions.checkState(this.flagsOnlyBuffer.isEndOfStream());
                    this.inputStreamEnded = true;
                    this.outputStreamEnded = true;
                    return;
                }
                return;
            }
            onInputFormatChanged(formatHolder);
        }
        maybeInitDecoder();
        if (this.decoder != null) {
            try {
                TraceUtil.beginSection("drainAndFeed");
                while (drainOutputBuffer(j10, j11)) {
                }
                while (feedInputBuffer()) {
                }
                TraceUtil.endSection();
                this.decoderCounters.ensureUpdated();
            } catch (DecoderException e10) {
                Log.e(TAG, "Video codec error", e10);
                this.eventDispatcher.videoCodecError(e10);
                throw createRendererException(e10, this.inputFormat, PlaybackException.ERROR_CODE_DECODING_FAILED);
            }
        }
    }

    protected void renderOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer, long j10, Format format) throws DecoderException {
        VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j10, getClock().nanoTime(), format, null);
        }
        this.lastRenderTimeUs = Util.msToUs(SystemClock.elapsedRealtime());
        int i10 = videoDecoderOutputBuffer.mode;
        boolean z10 = i10 == 1 && this.outputSurface != null;
        boolean z11 = i10 == 0 && this.outputBufferRenderer != null;
        if (!z11 && !z10) {
            dropOutputBuffer(videoDecoderOutputBuffer);
            return;
        }
        maybeNotifyVideoSizeChanged(videoDecoderOutputBuffer.width, videoDecoderOutputBuffer.height);
        if (z11) {
            ((VideoDecoderOutputBufferRenderer) Assertions.checkNotNull(this.outputBufferRenderer)).setOutputBuffer(videoDecoderOutputBuffer);
        } else {
            renderOutputBufferToSurface(videoDecoderOutputBuffer, (Surface) Assertions.checkNotNull(this.outputSurface));
        }
        this.consecutiveDroppedFrameCount = 0;
        this.decoderCounters.renderedOutputBufferCount++;
        maybeNotifyRenderedFirstFrame();
    }

    protected abstract void renderOutputBufferToSurface(VideoDecoderOutputBuffer videoDecoderOutputBuffer, Surface surface) throws DecoderException;

    protected abstract void setDecoderOutputMode(int i10);

    protected final void setOutput(@Nullable Object obj) {
        if (obj instanceof Surface) {
            this.outputSurface = (Surface) obj;
            this.outputBufferRenderer = null;
            this.outputMode = 1;
        } else if (obj instanceof VideoDecoderOutputBufferRenderer) {
            this.outputSurface = null;
            this.outputBufferRenderer = (VideoDecoderOutputBufferRenderer) obj;
            this.outputMode = 0;
        } else {
            this.outputSurface = null;
            this.outputBufferRenderer = null;
            this.outputMode = -1;
            obj = null;
        }
        if (this.output == obj) {
            if (obj != null) {
                onOutputReset();
                return;
            }
            return;
        }
        this.output = obj;
        if (obj == null) {
            onOutputRemoved();
            return;
        }
        if (this.decoder != null) {
            setDecoderOutputMode(this.outputMode);
        }
        onOutputChanged();
    }

    protected boolean shouldDropBuffersToKeyframe(long j10, long j11) {
        return isBufferVeryLate(j10);
    }

    protected boolean shouldDropOutputBuffer(long j10, long j11) {
        return isBufferLate(j10);
    }

    protected boolean shouldForceRenderOutputBuffer(long j10, long j11) {
        return isBufferLate(j10) && j11 > SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US;
    }

    protected void skipOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        this.decoderCounters.skippedOutputBufferCount++;
        videoDecoderOutputBuffer.release();
    }

    protected void updateDroppedBufferCounters(int i10, int i11) {
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.droppedInputBufferCount += i10;
        int i12 = i10 + i11;
        decoderCounters.droppedBufferCount += i12;
        this.droppedFrames += i12;
        int i13 = this.consecutiveDroppedFrameCount + i12;
        this.consecutiveDroppedFrameCount = i13;
        decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(i13, decoderCounters.maxConsecutiveDroppedBufferCount);
        int i14 = this.maxDroppedFramesToNotify;
        if (i14 <= 0 || this.droppedFrames < i14) {
            return;
        }
        maybeNotifyDroppedFrames();
    }

    protected void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
    }
}
