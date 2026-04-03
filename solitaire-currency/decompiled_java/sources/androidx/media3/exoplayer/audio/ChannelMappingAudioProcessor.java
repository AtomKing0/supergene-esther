package androidx.media3.exoplayer.audio;

import androidx.annotation.Nullable;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
final class ChannelMappingAudioProcessor extends androidx.media3.common.audio.BaseAudioProcessor {

    @Nullable
    private int[] outputChannels;

    @Nullable
    private int[] pendingOutputChannels;

    ChannelMappingAudioProcessor() {
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public AudioProcessor.AudioFormat onConfigure(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        int[] iArr = this.pendingOutputChannels;
        if (iArr == null) {
            return AudioProcessor.AudioFormat.NOT_SET;
        }
        if (audioFormat.encoding != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
        }
        boolean z10 = audioFormat.channelCount != iArr.length;
        int i10 = 0;
        while (i10 < iArr.length) {
            int i11 = iArr[i10];
            if (i11 >= audioFormat.channelCount) {
                throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
            }
            z10 |= i11 != i10;
            i10++;
        }
        return z10 ? new AudioProcessor.AudioFormat(audioFormat.sampleRate, iArr.length, 2) : AudioProcessor.AudioFormat.NOT_SET;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    protected void onFlush() {
        this.outputChannels = this.pendingOutputChannels;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    protected void onReset() {
        this.outputChannels = null;
        this.pendingOutputChannels = null;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) Assertions.checkNotNull(this.outputChannels);
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBufferReplaceOutputBuffer = replaceOutputBuffer(((iLimit - iPosition) / this.inputAudioFormat.bytesPerFrame) * this.outputAudioFormat.bytesPerFrame);
        while (iPosition < iLimit) {
            for (int i10 : iArr) {
                byteBufferReplaceOutputBuffer.putShort(byteBuffer.getShort((i10 * 2) + iPosition));
            }
            iPosition += this.inputAudioFormat.bytesPerFrame;
        }
        byteBuffer.position(iLimit);
        byteBufferReplaceOutputBuffer.flip();
    }

    public void setChannelMap(@Nullable int[] iArr) {
        this.pendingOutputChannels = iArr;
    }
}
