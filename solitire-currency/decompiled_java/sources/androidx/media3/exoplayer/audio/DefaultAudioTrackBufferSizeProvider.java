package androidx.media3.exoplayer.audio;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.Ac3Util;
import androidx.media3.extractor.Ac4Util;
import androidx.media3.extractor.DtsUtil;
import androidx.media3.extractor.MpegAudioUtil;
import androidx.media3.extractor.OpusUtil;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public class DefaultAudioTrackBufferSizeProvider implements DefaultAudioSink.AudioTrackBufferSizeProvider {
    private static final int AC3_BUFFER_MULTIPLICATION_FACTOR = 2;
    private static final int DTSHD_BUFFER_MULTIPLICATION_FACTOR = 4;
    private static final int MAX_PCM_BUFFER_DURATION_US = 750000;
    private static final int MIN_PCM_BUFFER_DURATION_US = 250000;
    private static final int OFFLOAD_BUFFER_DURATION_US = 50000000;
    private static final int PASSTHROUGH_BUFFER_DURATION_US = 250000;
    private static final int PCM_BUFFER_MULTIPLICATION_FACTOR = 4;
    public final int ac3BufferMultiplicationFactor;
    public final int dtshdBufferMultiplicationFactor;
    protected final int maxPcmBufferDurationUs;
    protected final int minPcmBufferDurationUs;
    protected final int offloadBufferDurationUs;
    protected final int passthroughBufferDurationUs;
    protected final int pcmBufferMultiplicationFactor;

    public static class Builder {
        private int minPcmBufferDurationUs = 250000;
        private int maxPcmBufferDurationUs = DefaultAudioTrackBufferSizeProvider.MAX_PCM_BUFFER_DURATION_US;
        private int pcmBufferMultiplicationFactor = 4;
        private int passthroughBufferDurationUs = 250000;
        private int offloadBufferDurationUs = DefaultAudioTrackBufferSizeProvider.OFFLOAD_BUFFER_DURATION_US;
        private int ac3BufferMultiplicationFactor = 2;
        private int dtshdBufferMultiplicationFactor = 4;

        public DefaultAudioTrackBufferSizeProvider build() {
            return new DefaultAudioTrackBufferSizeProvider(this);
        }

        public Builder setAc3BufferMultiplicationFactor(int i10) {
            this.ac3BufferMultiplicationFactor = i10;
            return this;
        }

        public Builder setDtshdBufferMultiplicationFactor(int i10) {
            this.dtshdBufferMultiplicationFactor = i10;
            return this;
        }

        public Builder setMaxPcmBufferDurationUs(int i10) {
            this.maxPcmBufferDurationUs = i10;
            return this;
        }

        public Builder setMinPcmBufferDurationUs(int i10) {
            this.minPcmBufferDurationUs = i10;
            return this;
        }

        public Builder setOffloadBufferDurationUs(int i10) {
            this.offloadBufferDurationUs = i10;
            return this;
        }

        public Builder setPassthroughBufferDurationUs(int i10) {
            this.passthroughBufferDurationUs = i10;
            return this;
        }

        public Builder setPcmBufferMultiplicationFactor(int i10) {
            this.pcmBufferMultiplicationFactor = i10;
            return this;
        }
    }

    protected DefaultAudioTrackBufferSizeProvider(Builder builder) {
        this.minPcmBufferDurationUs = builder.minPcmBufferDurationUs;
        this.maxPcmBufferDurationUs = builder.maxPcmBufferDurationUs;
        this.pcmBufferMultiplicationFactor = builder.pcmBufferMultiplicationFactor;
        this.passthroughBufferDurationUs = builder.passthroughBufferDurationUs;
        this.offloadBufferDurationUs = builder.offloadBufferDurationUs;
        this.ac3BufferMultiplicationFactor = builder.ac3BufferMultiplicationFactor;
        this.dtshdBufferMultiplicationFactor = builder.dtshdBufferMultiplicationFactor;
    }

    protected static int durationUsToBytes(int i10, int i11, int i12) {
        return g5.e.d(((((long) i10) * ((long) i11)) * ((long) i12)) / 1000000);
    }

    protected static int getMaximumEncodedRateBytesPerSecond(int i10) {
        switch (i10) {
            case 5:
                return Ac3Util.AC3_MAX_RATE_BYTES_PER_SECOND;
            case 6:
            case 18:
                return 768000;
            case 7:
                return DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND;
            case 8:
                return DtsUtil.DTS_HD_MAX_RATE_BYTES_PER_SECOND;
            case 9:
                return MpegAudioUtil.MAX_RATE_BYTES_PER_SECOND;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            case 13:
            case 19:
            default:
                throw new IllegalArgumentException();
            case 14:
                return Ac3Util.TRUEHD_MAX_RATE_BYTES_PER_SECOND;
            case 15:
                return 8000;
            case 16:
                return AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND;
            case 17:
                return Ac4Util.MAX_RATE_BYTES_PER_SECOND;
            case 20:
                return OpusUtil.MAX_BYTES_PER_SECOND;
        }
    }

    protected int get1xBufferSizeInBytes(int i10, int i11, int i12, int i13, int i14, int i15) {
        if (i12 == 0) {
            return getPcmBufferSizeInBytes(i10, i14, i13);
        }
        if (i12 == 1) {
            return getOffloadBufferSizeInBytes(i11);
        }
        if (i12 == 2) {
            return getPassthroughBufferSizeInBytes(i11, i15);
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.media3.exoplayer.audio.DefaultAudioSink.AudioTrackBufferSizeProvider
    public int getBufferSizeInBytes(int i10, int i11, int i12, int i13, int i14, int i15, double d10) {
        return (((Math.max(i10, (int) (((double) get1xBufferSizeInBytes(i10, i11, i12, i13, i14, i15)) * d10)) + i13) - 1) / i13) * i13;
    }

    protected int getOffloadBufferSizeInBytes(int i10) {
        return g5.e.d((((long) this.offloadBufferDurationUs) * ((long) getMaximumEncodedRateBytesPerSecond(i10))) / 1000000);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected int getPassthroughBufferSizeInBytes(int r4, int r5) {
        /*
            r3 = this;
            int r0 = r3.passthroughBufferDurationUs
            r1 = 5
            r2 = 8
            if (r4 != r1) goto Lb
            int r1 = r3.ac3BufferMultiplicationFactor
        L9:
            int r0 = r0 * r1
            goto L10
        Lb:
            if (r4 != r2) goto L10
            int r1 = r3.dtshdBufferMultiplicationFactor
            goto L9
        L10:
            r1 = -1
            if (r5 == r1) goto L1a
            java.math.RoundingMode r4 = java.math.RoundingMode.CEILING
            int r4 = f5.d.a(r5, r2, r4)
            goto L1e
        L1a:
            int r4 = getMaximumEncodedRateBytesPerSecond(r4)
        L1e:
            long r0 = (long) r0
            long r4 = (long) r4
            long r0 = r0 * r4
            r4 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r0 / r4
            int r4 = g5.e.d(r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.DefaultAudioTrackBufferSizeProvider.getPassthroughBufferSizeInBytes(int, int):int");
    }

    protected int getPcmBufferSizeInBytes(int i10, int i11, int i12) {
        return Util.constrainValue(i10 * this.pcmBufferMultiplicationFactor, durationUsToBytes(this.minPcmBufferDurationUs, i11, i12), durationUsToBytes(this.maxPcmBufferDurationUs, i11, i12));
    }
}
