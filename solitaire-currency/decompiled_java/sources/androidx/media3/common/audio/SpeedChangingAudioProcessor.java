package androidx.media3.common.audio;

import androidx.media3.common.C;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class SpeedChangingAudioProcessor extends BaseAudioProcessor {
    private long bytesRead;
    private boolean endOfStreamQueuedToSonic;
    private final SpeedProvider speedProvider;
    private final SonicAudioProcessor sonicAudioProcessor = new SonicAudioProcessor();
    private float currentSpeed = 1.0f;

    public SpeedChangingAudioProcessor(SpeedProvider speedProvider) {
        this.speedProvider = speedProvider;
    }

    private boolean isUsingSonic() {
        return this.currentSpeed != 1.0f;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor, androidx.media3.common.audio.AudioProcessor
    public ByteBuffer getOutput() {
        return isUsingSonic() ? this.sonicAudioProcessor.getOutput() : super.getOutput();
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor, androidx.media3.common.audio.AudioProcessor
    public boolean isEnded() {
        return super.isEnded() && this.sonicAudioProcessor.isEnded();
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public AudioProcessor.AudioFormat onConfigure(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        return this.sonicAudioProcessor.configure(audioFormat);
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    protected void onFlush() {
        this.sonicAudioProcessor.flush();
        this.endOfStreamQueuedToSonic = false;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    protected void onQueueEndOfStream() {
        if (this.endOfStreamQueuedToSonic) {
            return;
        }
        this.sonicAudioProcessor.queueEndOfStream();
        this.endOfStreamQueuedToSonic = true;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    protected void onReset() {
        this.currentSpeed = 1.0f;
        this.bytesRead = 0L;
        this.sonicAudioProcessor.reset();
        this.endOfStreamQueuedToSonic = false;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        int iScaleLargeTimestamp;
        long j10 = this.bytesRead;
        AudioProcessor.AudioFormat audioFormat = this.inputAudioFormat;
        long jScaleLargeTimestamp = Util.scaleLargeTimestamp(j10, 1000000L, ((long) audioFormat.sampleRate) * ((long) audioFormat.bytesPerFrame));
        float speed = this.speedProvider.getSpeed(jScaleLargeTimestamp);
        if (speed != this.currentSpeed) {
            this.currentSpeed = speed;
            if (isUsingSonic()) {
                this.sonicAudioProcessor.setSpeed(speed);
                this.sonicAudioProcessor.setPitch(speed);
            }
            flush();
        }
        int iLimit = byteBuffer.limit();
        long nextSpeedChangeTimeUs = this.speedProvider.getNextSpeedChangeTimeUs(jScaleLargeTimestamp);
        if (nextSpeedChangeTimeUs != C.TIME_UNSET) {
            long j11 = nextSpeedChangeTimeUs - jScaleLargeTimestamp;
            AudioProcessor.AudioFormat audioFormat2 = this.inputAudioFormat;
            iScaleLargeTimestamp = (int) Util.scaleLargeTimestamp(j11, ((long) audioFormat2.sampleRate) * ((long) audioFormat2.bytesPerFrame), 1000000L);
            int i10 = this.inputAudioFormat.bytesPerFrame;
            int i11 = i10 - (iScaleLargeTimestamp % i10);
            if (i11 != i10) {
                iScaleLargeTimestamp += i11;
            }
            byteBuffer.limit(Math.min(iLimit, byteBuffer.position() + iScaleLargeTimestamp));
        } else {
            iScaleLargeTimestamp = -1;
        }
        long jPosition = byteBuffer.position();
        if (isUsingSonic()) {
            this.sonicAudioProcessor.queueInput(byteBuffer);
            if (iScaleLargeTimestamp != -1 && ((long) byteBuffer.position()) - jPosition == iScaleLargeTimestamp) {
                this.sonicAudioProcessor.queueEndOfStream();
                this.endOfStreamQueuedToSonic = true;
            }
        } else {
            ByteBuffer byteBufferReplaceOutputBuffer = replaceOutputBuffer(byteBuffer.remaining());
            if (byteBuffer.hasRemaining()) {
                byteBufferReplaceOutputBuffer.put(byteBuffer);
            }
            byteBufferReplaceOutputBuffer.flip();
        }
        this.bytesRead += ((long) byteBuffer.position()) - jPosition;
        byteBuffer.limit(iLimit);
    }
}
