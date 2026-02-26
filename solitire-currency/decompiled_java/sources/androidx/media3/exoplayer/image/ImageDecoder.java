package androidx.media3.exoplayer.image;

import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.Decoder;
import androidx.media3.decoder.DecoderException;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.image.BitmapFactoryImageDecoder;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public interface ImageDecoder extends Decoder<DecoderInputBuffer, ImageOutputBuffer, ImageDecoderException> {

    public interface Factory {
        public static final Factory DEFAULT = new BitmapFactoryImageDecoder.Factory();

        ImageDecoder createImageDecoder();

        int supportsFormat(Format format);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.media3.decoder.Decoder
    @Nullable
    ImageOutputBuffer dequeueOutputBuffer() throws ImageDecoderException;

    @Override // androidx.media3.decoder.Decoder
    @Nullable
    /* bridge */ /* synthetic */ ImageOutputBuffer dequeueOutputBuffer() throws DecoderException;

    /* JADX INFO: renamed from: queueInputBuffer, reason: avoid collision after fix types in other method */
    void queueInputBuffer2(DecoderInputBuffer decoderInputBuffer) throws ImageDecoderException;

    @Override // androidx.media3.decoder.Decoder
    /* bridge */ /* synthetic */ void queueInputBuffer(DecoderInputBuffer decoderInputBuffer) throws DecoderException;
}
