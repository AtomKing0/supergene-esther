package androidx.media3.exoplayer.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
final class ToFloatPcmAudioProcessor extends androidx.media3.common.audio.BaseAudioProcessor {
    private static final int FLOAT_NAN_AS_INT = Float.floatToIntBits(Float.NaN);
    private static final double PCM_32_BIT_INT_TO_PCM_32_BIT_FLOAT_FACTOR = 4.656612875245797E-10d;

    ToFloatPcmAudioProcessor() {
    }

    private static void writePcm32BitFloat(int i10, ByteBuffer byteBuffer) {
        int iFloatToIntBits = Float.floatToIntBits((float) (((double) i10) * PCM_32_BIT_INT_TO_PCM_32_BIT_FLOAT_FACTOR));
        if (iFloatToIntBits == FLOAT_NAN_AS_INT) {
            iFloatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(iFloatToIntBits);
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public AudioProcessor.AudioFormat onConfigure(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        int i10 = audioFormat.encoding;
        if (Util.isEncodingHighResolutionPcm(i10)) {
            return i10 != 4 ? new AudioProcessor.AudioFormat(audioFormat.sampleRate, audioFormat.channelCount, 4) : AudioProcessor.AudioFormat.NOT_SET;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferReplaceOutputBuffer;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i10 = iLimit - iPosition;
        int i11 = this.inputAudioFormat.encoding;
        if (i11 == 21) {
            byteBufferReplaceOutputBuffer = replaceOutputBuffer((i10 / 3) * 4);
            while (iPosition < iLimit) {
                writePcm32BitFloat(((byteBuffer.get(iPosition) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition + 2) & 255) << 24), byteBufferReplaceOutputBuffer);
                iPosition += 3;
            }
        } else if (i11 == 22) {
            byteBufferReplaceOutputBuffer = replaceOutputBuffer(i10);
            while (iPosition < iLimit) {
                writePcm32BitFloat((byteBuffer.get(iPosition) & 255) | ((byteBuffer.get(iPosition + 1) & 255) << 8) | ((byteBuffer.get(iPosition + 2) & 255) << 16) | ((byteBuffer.get(iPosition + 3) & 255) << 24), byteBufferReplaceOutputBuffer);
                iPosition += 4;
            }
        } else if (i11 == 1342177280) {
            byteBufferReplaceOutputBuffer = replaceOutputBuffer((i10 / 3) * 4);
            while (iPosition < iLimit) {
                writePcm32BitFloat(((byteBuffer.get(iPosition + 2) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition) & 255) << 24), byteBufferReplaceOutputBuffer);
                iPosition += 3;
            }
        } else {
            if (i11 != 1610612736) {
                throw new IllegalStateException();
            }
            byteBufferReplaceOutputBuffer = replaceOutputBuffer(i10);
            while (iPosition < iLimit) {
                writePcm32BitFloat((byteBuffer.get(iPosition + 3) & 255) | ((byteBuffer.get(iPosition + 2) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition) & 255) << 24), byteBufferReplaceOutputBuffer);
                iPosition += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        byteBufferReplaceOutputBuffer.flip();
    }
}
