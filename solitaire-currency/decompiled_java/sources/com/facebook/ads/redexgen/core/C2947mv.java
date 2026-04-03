package com.facebook.ads.redexgen.core;

import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.Ac3Util;
import androidx.media3.extractor.Ac4Util;
import androidx.media3.extractor.DtsUtil;
import androidx.media3.extractor.MpegAudioUtil;
import androidx.media3.extractor.OpusUtil;
import java.math.RoundingMode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2947mv implements InterfaceC14808d {
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;

    public C2947mv(C14888o c14888o) {
        this.A02 = c14888o.A02;
        this.A01 = c14888o.A01;
        this.A05 = c14888o.A05;
        this.A04 = c14888o.A04;
        this.A03 = c14888o.A03;
        this.A00 = c14888o.A00;
    }

    public static int A00(int i10) {
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

    private final int A01(int i10) {
        int iA00 = A00(i10);
        int maxByteRate = this.A03;
        return AD.A03((((long) maxByteRate) * ((long) iA00)) / 1000000);
    }

    private final int A02(int i10, int i11) {
        int bufferSizeUs;
        int i12 = this.A04;
        if (i10 == 5) {
            int bufferSizeUs2 = this.A00;
            i12 *= bufferSizeUs2;
        }
        if (i11 != -1) {
            bufferSizeUs = C9D.A00(i11, 8, RoundingMode.CEILING);
        } else {
            bufferSizeUs = A00(i10);
        }
        return AD.A03((((long) i12) * ((long) bufferSizeUs)) / 1000000);
    }

    public static int A03(int i10, int i11, int i12) {
        return AD.A03(((((long) i10) * ((long) i11)) * ((long) i12)) / 1000000);
    }

    private final int A04(int i10, int i11, int i12) {
        int maxAppBufferSize = this.A05 * i10;
        int targetBufferSize = this.A02;
        int minAppBufferSize = A03(targetBufferSize, i11, i12);
        int targetBufferSize2 = this.A01;
        return AbstractC13764a.A07(maxAppBufferSize, minAppBufferSize, A03(targetBufferSize2, i11, i12));
    }

    private final int A05(int i10, int i11, int i12, int i13, int i14, int i15) {
        switch (i12) {
            case 0:
                return A04(i10, i14, i13);
            case 1:
                return A01(i11);
            case 2:
                return A02(i11, i15);
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC14808d
    public final int A6x(int i10, int i11, int i12, int i13, int i14, int i15, double d10) {
        int bufferSize = A05(i10, i11, i12, i13, i14, i15);
        return (((Math.max(i10, (int) (((double) bufferSize) * d10)) + i13) - 1) / i13) * i13;
    }
}
