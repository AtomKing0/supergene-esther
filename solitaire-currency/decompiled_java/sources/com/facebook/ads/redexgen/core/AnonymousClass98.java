package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.os.Looper;
import androidx.media3.common.C;
import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.98, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass98 extends AbstractC2918mS implements InterfaceC1574Cg {
    public long A00;
    public C5H A01;
    public InterfaceC2740jM<InterfaceExecutorC1645Ez> A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public final int A06;
    public final C2Q A07;
    public final C3055oi A08;
    public final InterfaceC13984w A09;
    public final C9U A0A;
    public final InterfaceC1568Ca A0B;
    public final InterfaceC1623Ed A0C;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.jM != com.google.common.base.Supplier<com.facebook.ads.androidx.media3.exoplayer.util.ReleasableExecutor> */
    @MetaExoPlayerCustomization("Allow for passing a new drmSessionManager")
    public AnonymousClass98(C3055oi c3055oi, InterfaceC13984w interfaceC13984w, InterfaceC1568Ca interfaceC1568Ca, C9U c9u, InterfaceC1623Ed interfaceC1623Ed, int i10, InterfaceC2740jM<InterfaceExecutorC1645Ez> interfaceC2740jM) {
        this.A07 = (C2Q) C3M.A01(c3055oi.A03);
        this.A08 = c3055oi;
        this.A09 = interfaceC13984w;
        this.A0B = interfaceC1568Ca;
        this.A0A = c9u == null ? C9U.A00 : c9u;
        this.A0C = interfaceC1623Ed;
        this.A06 = i10;
        this.A04 = true;
        this.A00 = C.TIME_UNSET;
        this.A02 = interfaceC2740jM;
    }

    private void A00() {
        final Timeline anonymousClass97 = new AnonymousClass97(this.A00, this.A05, false, this.A03, null, this.A08);
        if (this.A04) {
            Timeline timeline = new C9C(anonymousClass97) { // from class: com.facebook.ads.redexgen.X.12
                @Override // com.facebook.ads.redexgen.core.C9C, com.facebook.ads.androidx.media3.common.Timeline
                public final C3035oN A0I(int i10, C3035oN c3035oN, boolean z10) {
                    super.A0I(i10, c3035oN, z10);
                    c3035oN.A05 = true;
                    return c3035oN;
                }

                @Override // com.facebook.ads.redexgen.core.C9C, com.facebook.ads.androidx.media3.common.Timeline
                public final C3033oL A0L(int i10, C3033oL c3033oL, long j10) {
                    super.A0L(i10, c3033oL, j10);
                    c3033oL.A0F = true;
                    return c3033oL;
                }
            };
            anonymousClass97 = timeline;
        }
        A05(anonymousClass97);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2918mS
    public final void A09() {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2918mS
    public final void A0A(C5H c5h) {
        this.A01 = c5h;
        this.A0A.AGK();
        this.A0A.AIu((Looper) C3M.A01(Looper.myLooper()), A00());
        A00();
    }

    @Override // com.facebook.ads.redexgen.core.CL
    @MetaExoPlayerCustomization("PlayerId needs to be set")
    public final InterfaceC2912mM A5O(C2911mL c2911mL, EO eo, long j10) {
        InterfaceExecutorC1645Ez interfaceExecutorC1645Ez;
        InterfaceC2999nl interfaceC2999nlA5A = this.A09.A5A();
        if (this.A01 != null) {
            interfaceC2999nlA5A.A3v(this.A01);
        }
        Uri uri = this.A07.A00;
        InterfaceC1569Cb interfaceC1569CbA5P = this.A0B.A5P(C14667m.A03);
        C9U c9u = this.A0A;
        C9P c9pA01 = A01(c2911mL);
        InterfaceC1623Ed interfaceC1623Ed = this.A0C;
        CW cwA02 = A02(c2911mL);
        String str = this.A07.A04;
        int i10 = this.A06;
        if (this.A02 != null) {
            interfaceExecutorC1645Ez = this.A02.get();
        } else {
            interfaceExecutorC1645Ez = null;
        }
        return new C9A(uri, interfaceC2999nlA5A, interfaceC1569CbA5P, c9u, c9pA01, interfaceC1623Ed, cwA02, this, eo, str, i10, interfaceExecutorC1645Ez);
    }

    @Override // com.facebook.ads.redexgen.core.CL
    public final void ABu() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1574Cg
    public final void AFH(long j10, boolean z10, boolean z11) {
        if (j10 == C.TIME_UNSET) {
            j10 = this.A00;
        }
        if (!this.A04 && this.A00 == j10 && this.A05 == z10 && this.A03 == z11) {
            return;
        }
        this.A00 = j10;
        this.A05 = z10;
        this.A03 = z11;
        this.A04 = false;
        A00();
    }

    @Override // com.facebook.ads.redexgen.core.CL
    public final void AH0(InterfaceC2912mM interfaceC2912mM) {
        ((C9A) interfaceC2912mM).A0a();
    }
}
