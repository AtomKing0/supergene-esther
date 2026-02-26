package com.facebook.ads.redexgen.core;

import android.net.Uri;
import androidx.media3.common.C;
import com.facebook.ads.androidx.media3.common.Timeline;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.97, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass97 extends Timeline {
    public static byte[] A0D;
    public static final C3055oi A0E;
    public static final Object A0F;
    public final long A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final long A06;
    public final C3057ok A07;
    public final C3055oi A08;
    public final Object A09;
    public final boolean A0A;
    public final boolean A0B;
    public final boolean A0C;

    public static String A00(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] - i12) - 50);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A0D = new byte[]{-79, -57, -52, -59, -54, -61, -82, -61, -48, -57, -51, -62, -78, -57, -53, -61, -54, -57, -52, -61};
    }

    static {
        A01();
        A0F = new Object();
        A0E = new C2I().A03(A00(0, 20, 44)).A00(Uri.EMPTY).A05();
    }

    public AnonymousClass97(long j10, long j11, long j12, long j13, long j14, long j15, long j16, boolean z10, boolean z11, boolean z12, Object obj, C3055oi c3055oi, C3057ok c3057ok) {
        this.A02 = j10;
        this.A06 = j11;
        this.A00 = j12;
        this.A01 = j13;
        this.A04 = j14;
        this.A05 = j15;
        this.A03 = j16;
        this.A0B = z10;
        this.A0A = z11;
        this.A0C = z12;
        this.A09 = obj;
        this.A08 = (C3055oi) C3M.A01(c3055oi);
        this.A07 = c3057ok;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AnonymousClass97(long j10, long j11, long j12, long j13, boolean z10, boolean z11, boolean z12, Object obj, C3055oi c3055oi) {
        C3057ok c3057ok;
        if (z12) {
            c3057ok = c3055oi.A02;
        } else {
            c3057ok = null;
        }
        this(C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, j10, j11, j12, j13, z10, z11, false, obj, c3055oi, c3057ok);
    }

    public AnonymousClass97(long j10, boolean z10, boolean z11, boolean z12, Object obj, C3055oi c3055oi) {
        this(j10, j10, 0L, 0L, z10, z11, z12, obj, c3055oi);
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final int A06() {
        return 1;
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final int A07() {
        return 1;
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final int A0A(Object obj) {
        return A0F.equals(obj) ? 0 : -1;
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final C3035oN A0I(int i10, C3035oN c3035oN, boolean z10) {
        C3M.A00(i10, 0, 1);
        return c3035oN.A0F(null, z10 ? A0F : null, 0, this.A01, -this.A05);
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final C3033oL A0L(int i10, C3033oL c3033oL, long j10) {
        C3M.A00(i10, 0, 1);
        long j11 = this.A03;
        if (this.A0A && !this.A0C && j10 != 0) {
            if (this.A04 == C.TIME_UNSET) {
                j11 = C.TIME_UNSET;
            } else {
                j11 += j10;
                if (j11 > this.A04) {
                    j11 = C.TIME_UNSET;
                }
            }
        }
        return c3033oL.A07(C3033oL.A0K, this.A08, this.A09, this.A02, this.A06, C.TIME_UNSET, this.A0B, this.A0A, null, j11, this.A04, 0, 0, this.A05);
    }

    @Override // com.facebook.ads.androidx.media3.common.Timeline
    public final Object A0M(int i10) {
        C3M.A00(i10, 0, 1);
        return A0F;
    }
}
