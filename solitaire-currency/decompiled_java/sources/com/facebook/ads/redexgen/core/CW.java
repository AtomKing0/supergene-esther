package com.facebook.ads.redexgen.core;

import android.os.Handler;
import androidx.media3.common.C;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class CW {
    public final int A00;
    public final C2911mL A01;
    public final long A02;
    public final CopyOnWriteArrayList<CV> A03;

    public CW() {
        this(new CopyOnWriteArrayList(), 0, null, 0L);
    }

    public CW(CopyOnWriteArrayList<CV> copyOnWriteArrayList, int i10, C2911mL c2911mL, long j10) {
        this.A03 = copyOnWriteArrayList;
        this.A00 = i10;
        this.A01 = c2911mL;
        this.A02 = j10;
    }

    private long A00(long j10) {
        long jA0P = AbstractC13764a.A0P(j10);
        if (jA0P == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        long mediaTimeMs = this.A02;
        return mediaTimeMs + jA0P;
    }

    @MetaExoPlayerCustomization(type = {"MERGED"}, value = "https://github.com/androidx/media/pull/1768")
    private final void A01(final CE ce, final CG cg, final int i10) {
        for (CV cv : this.A03) {
            final CX cx = cv.A01;
            AbstractC13764a.A1B(cv.A00, new Runnable() { // from class: com.facebook.ads.redexgen.X.CS
                @Override // java.lang.Runnable
                public final void run() {
                }
            });
        }
    }

    public final CW A02(int i10, C2911mL c2911mL, long j10) {
        return new CW(this.A03, i10, c2911mL, j10);
    }

    public final void A03(int i10, C3064or c3064or, int i11, Object obj, long j10) {
        A0C(new CG(1, i10, c3064or, i11, obj, A00(j10), C.TIME_UNSET));
    }

    public final void A04(Handler handler, CX cx) {
        C3M.A01(handler);
        C3M.A01(cx);
        this.A03.add(new CV(handler, cx));
    }

    public final void A05(CE ce, int i10, int i11, C3064or c3064or, int i12, Object obj, long j10, long j11) {
        A09(ce, new CG(i10, i11, c3064or, i12, obj, A00(j10), A00(j11)));
    }

    @MetaExoPlayerCustomization(type = {"MERGED"}, value = "https://github.com/androidx/media/pull/1768")
    public final void A06(CE ce, int i10, int i11, C3064or c3064or, int i12, Object obj, long j10, long j11, int i13) {
        A01(ce, new CG(i10, i11, c3064or, i12, obj, A00(j10), A00(j11)), i13);
    }

    public final void A07(CE ce, int i10, int i11, C3064or c3064or, int i12, Object obj, long j10, long j11, IOException iOException, boolean z10) {
        A0A(ce, new CG(i10, i11, c3064or, i12, obj, A00(j10), A00(j11)), iOException, z10);
    }

    public final void A08(@MetaExoPlayerCustomization CE ce, @MetaExoPlayerCustomization int i10, int i11, C3064or c3064or, int i12, Object obj, long j10, long j11, Object obj2, Object obj3) {
        A0B(ce, new CG(i10, i11, c3064or, i12, obj, A00(j10), A00(j11)), obj2, obj3);
    }

    public final void A09(final CE ce, final CG cg) {
        for (CV cv : this.A03) {
            final CX listener = cv.A01;
            AbstractC13764a.A1B(cv.A00, new Runnable() { // from class: com.facebook.ads.redexgen.X.CT
                @Override // java.lang.Runnable
                public final void run() {
                    this.A02.A0E(listener, ce, cg);
                }
            });
        }
    }

    public final void A0A(final CE ce, final CG cg, final IOException iOException, final boolean z10) {
        for (CV cv : this.A03) {
            final CX cx = cv.A01;
            AbstractC13764a.A1B(cv.A00, new Runnable() { // from class: com.facebook.ads.redexgen.X.CO
                @Override // java.lang.Runnable
                public final void run() {
                    this.A02.A0F(cx, ce, cg, iOException, z10);
                }
            });
        }
    }

    public final void A0B(@MetaExoPlayerCustomization final CE ce, @MetaExoPlayerCustomization final CG cg, final Object obj, final Object obj2) {
        for (CV cv : this.A03) {
            final CX cx = cv.A01;
            AbstractC13764a.A1B(cv.A00, new Runnable() { // from class: com.facebook.ads.redexgen.X.CP
                @Override // java.lang.Runnable
                public final void run() {
                    this.A02.A0G(cx, ce, cg, obj, obj2);
                }
            });
        }
    }

    public final void A0C(final CG cg) {
        for (CV cv : this.A03) {
            final CX listener = cv.A01;
            AbstractC13764a.A1B(cv.A00, new Runnable() { // from class: com.facebook.ads.redexgen.X.CQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.A01.A0H(listener, cg);
                }
            });
        }
    }

    public final void A0D(CX cx) {
        for (CV listenerAndHandler : this.A03) {
            if (listenerAndHandler.A01 == cx) {
                this.A03.remove(listenerAndHandler);
            }
        }
    }

    public final /* synthetic */ void A0E(CX cx, CE ce, CG cg) {
        cx.ADw(this.A00, this.A01, ce, cg);
    }

    public final /* synthetic */ void A0F(CX cx, CE ce, CG cg, IOException iOException, boolean z10) {
        cx.AE1(this.A00, this.A01, ce, cg, iOException, z10);
    }

    public final /* synthetic */ void A0G(CX cx, CE ce, CG cg, Object obj, Object obj2) {
        cx.ADy(this.A00, this.A01, ce, cg, obj, obj2);
    }

    public final /* synthetic */ void A0H(CX cx, CG cg) {
        cx.AD6(this.A00, this.A01, cg);
    }
}
