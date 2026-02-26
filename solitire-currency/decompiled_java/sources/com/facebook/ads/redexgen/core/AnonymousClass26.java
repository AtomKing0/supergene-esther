package com.facebook.ads.redexgen.core;

import android.view.View;
import android.view.animation.AlphaAnimation;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.settings.AdInternalSettings;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.26, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass26 extends AbstractC1893Or<C2460eX> implements SM {
    public C2387dL A00;
    public boolean A01;

    public AnonymousClass26(C2460eX c2460eX, C2387dL c2387dL) {
        super(c2460eX);
        this.A00 = c2387dL;
        this.A01 = false;
    }

    private void A00(int i10) {
        if (!this.A01) {
            this.A00.A0F().A3n(i10);
        }
        this.A01 = true;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC2074Vt
    public final void A07() {
        C2460eX c2460eXA08 = A08();
        int iIntValue = 0;
        if (c2460eXA08 == null) {
            A00(0);
            return;
        }
        View view = c2460eXA08.A0C;
        AbstractC2459eW abstractC2459eW = (AbstractC2459eW) c2460eXA08.A0E.get();
        int i10 = 1;
        boolean z10 = view == null;
        if (!z10 && abstractC2459eW != null) {
            C2461eY c2461eYA0E = C2460eX.A0E(view, c2460eXA08.A0A, this.A00);
            if (c2461eYA0E.A04()) {
                C2460eX.A05(c2460eXA08);
            } else {
                c2460eXA08.A00 = 0;
            }
            boolean z11 = c2460eXA08.A00 > c2460eXA08.A09;
            boolean wasViewable = c2460eXA08.A05 != null && c2460eXA08.A05.A04();
            if (z11 || !c2461eYA0E.A04()) {
                c2460eXA08.A05 = c2461eYA0E;
            }
            String strValueOf = String.valueOf(c2461eYA0E.A01());
            synchronized (c2460eXA08) {
                if (c2460eXA08.A06.containsKey(strValueOf)) {
                    iIntValue = ((Integer) c2460eXA08.A06.get(strValueOf)).intValue();
                }
                c2460eXA08.A06.put(strValueOf, Integer.valueOf(iIntValue + 1));
            }
            if (z11 && !wasViewable) {
                this.A01 = true;
                c2460eXA08.A03 = System.currentTimeMillis();
                if (c2460eXA08.A07) {
                    this.A00.A0F().A3o();
                }
                abstractC2459eW.A03();
                if (BuildConfigApi.isDebug() && AdInternalSettings.isVisibleAnimation()) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                    alphaAnimation.setDuration(500L);
                    view.startAnimation(alphaAnimation);
                }
                if (!c2460eXA08.A0F) {
                    return;
                }
            } else if (!z11 && wasViewable) {
                this.A01 = true;
                if (c2460eXA08.A07) {
                    this.A00.A0F().A3K(c2461eYA0E.A02());
                }
                abstractC2459eW.A00();
            } else {
                abstractC2459eW.A02();
                if (!this.A01 && c2460eXA08.A07) {
                    this.A00.A0F().A3m(c2461eYA0E.A02());
                }
                this.A01 = true;
            }
            if (!c2460eXA08.A08 && c2460eXA08.A04 != null) {
                c2460eXA08.A0B.postDelayed(c2460eXA08.A04, c2460eXA08.A02);
                return;
            }
            return;
        }
        if (c2460eXA08.A07) {
            if (!z10) {
                i10 = 2;
            }
            A00(i10);
        }
    }

    @Override // com.facebook.ads.redexgen.core.SM
    public final C2387dL A6e() {
        return this.A00;
    }
}
