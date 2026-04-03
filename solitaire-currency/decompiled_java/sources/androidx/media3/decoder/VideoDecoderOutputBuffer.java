package androidx.media3.decoder;

import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.DecoderOutputBuffer;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public class VideoDecoderOutputBuffer extends DecoderOutputBuffer {
    public static final int COLORSPACE_BT2020 = 3;
    public static final int COLORSPACE_BT601 = 1;
    public static final int COLORSPACE_BT709 = 2;
    public static final int COLORSPACE_UNKNOWN = 0;
    public int colorspace;

    @Nullable
    public ByteBuffer data;
    public int decoderPrivate;

    @Nullable
    public Format format;
    public int height;
    public int mode;
    private final DecoderOutputBuffer.Owner<VideoDecoderOutputBuffer> owner;

    @Nullable
    public ByteBuffer supplementalData;
    public int width;

    @Nullable
    public ByteBuffer[] yuvPlanes;

    @Nullable
    public int[] yuvStrides;

    public VideoDecoderOutputBuffer(DecoderOutputBuffer.Owner<VideoDecoderOutputBuffer> owner) {
        this.owner = owner;
    }

    private static boolean isSafeToMultiply(int i10, int i11) {
        return i10 >= 0 && i11 >= 0 && (i11 <= 0 || i10 < Integer.MAX_VALUE / i11);
    }

    public void init(long j10, int i10, @Nullable ByteBuffer byteBuffer) {
        this.timeUs = j10;
        this.mode = i10;
        if (byteBuffer == null || !byteBuffer.hasRemaining()) {
            this.supplementalData = null;
            return;
        }
        addFlag(268435456);
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBuffer2 = this.supplementalData;
        if (byteBuffer2 == null || byteBuffer2.capacity() < iLimit) {
            this.supplementalData = ByteBuffer.allocate(iLimit);
        } else {
            this.supplementalData.clear();
        }
        this.supplementalData.put(byteBuffer);
        this.supplementalData.flip();
        byteBuffer.position(0);
    }

    public void initForPrivateFrame(int i10, int i11) {
        this.width = i10;
        this.height = i11;
    }

    public boolean initForYuvFrame(int i10, int i11, int i12, int i13, int i14) {
        this.width = i10;
        this.height = i11;
        this.colorspace = i14;
        int i15 = (int) ((((long) i11) + 1) / 2);
        if (isSafeToMultiply(i12, i11) && isSafeToMultiply(i13, i15)) {
            int i16 = i11 * i12;
            int i17 = i15 * i13;
            int i18 = (i17 * 2) + i16;
            if (isSafeToMultiply(i17, 2) && i18 >= i16) {
                ByteBuffer byteBuffer = this.data;
                if (byteBuffer == null || byteBuffer.capacity() < i18) {
                    this.data = ByteBuffer.allocateDirect(i18);
                } else {
                    this.data.position(0);
                    this.data.limit(i18);
                }
                if (this.yuvPlanes == null) {
                    this.yuvPlanes = new ByteBuffer[3];
                }
                ByteBuffer byteBuffer2 = this.data;
                ByteBuffer[] byteBufferArr = this.yuvPlanes;
                ByteBuffer byteBufferSlice = byteBuffer2.slice();
                byteBufferArr[0] = byteBufferSlice;
                byteBufferSlice.limit(i16);
                byteBuffer2.position(i16);
                ByteBuffer byteBufferSlice2 = byteBuffer2.slice();
                byteBufferArr[1] = byteBufferSlice2;
                byteBufferSlice2.limit(i17);
                byteBuffer2.position(i16 + i17);
                ByteBuffer byteBufferSlice3 = byteBuffer2.slice();
                byteBufferArr[2] = byteBufferSlice3;
                byteBufferSlice3.limit(i17);
                if (this.yuvStrides == null) {
                    this.yuvStrides = new int[3];
                }
                int[] iArr = this.yuvStrides;
                iArr[0] = i12;
                iArr[1] = i13;
                iArr[2] = i13;
                return true;
            }
        }
        return false;
    }

    @Override // androidx.media3.decoder.DecoderOutputBuffer
    public void release() {
        this.owner.releaseOutputBuffer(this);
    }
}
