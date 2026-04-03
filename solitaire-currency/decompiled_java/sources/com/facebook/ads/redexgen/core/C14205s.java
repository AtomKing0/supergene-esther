package com.facebook.ads.redexgen.core;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5s, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14205s extends FH {
    public static String[] A00 = {"f1NrkMLFHAOxAk1WYXb4ZQBI9BQGMxNf", "ieQbYkP9qXWhodiL", "FasCpRA2RHhykdlBGUblwYUAQMGKU0mS", "sjzKgK2sh59qhJK5Sm5NCXrbKyy", "73hXtYSYooo4yypUFlMlXcqu25ITYI9G", "jFG3gQjXUuH0GALbmhZbm14pHMTfeDNL", "AB4YZhA3BNaHUCHwFjy4bae76Yz8EFa9", "dMMrkYyDXzmdfTW8HhUzXkOm8W"};

    public C14205s(C12810h c12810h, int i10, List<C2354cn> list, C2460eX c2460eX, Bundle bundle) {
        super(c12810h, i10, list, c2460eX, bundle);
        c12810h.A1h(this);
        this.A03 = new LG(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A00() {
        int iA25 = this.A0C.A25();
        if (this.A05 == null || iA25 == -1) {
            return;
        }
        int curPos = this.A05.size();
        if (iA25 < curPos - 1) {
            int i10 = iA25 + 1;
            if (A00[2].charAt(8) != 'R') {
                throw new RuntimeException();
            }
            A00[2] = "QoZYEwWSRtnMYn7R6MgH1oBp1kGEXSrp";
            A0U(i10);
        }
    }

    private void A01(int i10) {
        int visibleItem = this.A0C.A26();
        int lastVisibleItem = this.A0C.A27();
        int firstVisibleItem = this.A0C.A25();
        if (firstVisibleItem != visibleItem) {
            A0S(visibleItem);
        }
        if (firstVisibleItem != lastVisibleItem) {
            A0S(lastVisibleItem);
        }
        A0T(firstVisibleItem);
        A0V(visibleItem, lastVisibleItem, i10);
    }

    @Override // com.facebook.ads.redexgen.core.FH, com.facebook.ads.redexgen.core.QT
    public final void A0L(C14346g c14346g, int i10) {
    }

    @Override // com.facebook.ads.redexgen.core.FH, com.facebook.ads.redexgen.core.QT
    public final void A0M(C14346g c14346g, int i10, int i11) {
        if (this.A0C.A25() != -1) {
            AbstractC1740Ir curCard = (AbstractC1740Ir) this.A0C.A1o(this.A0C.A25());
            if (curCard != null && curCard.A1T() && !curCard.A1S()) {
                curCard.A1Q();
            }
            A01(i10);
        }
    }

    @Override // com.facebook.ads.redexgen.core.FH
    public final void A0X(View view, boolean z10) {
        view.setAlpha(z10 ? 1.0f : 0.8f);
    }

    @Override // com.facebook.ads.redexgen.core.FH
    public final void A0Z(AbstractC1740Ir abstractC1740Ir, boolean z10) {
        A0X(abstractC1740Ir, z10);
        if (!z10 && abstractC1740Ir.A1S()) {
            abstractC1740Ir.A1P();
        }
    }

    @Override // com.facebook.ads.redexgen.core.FH
    public final boolean A0a(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return ((float) rect.width()) / ((float) view.getWidth()) >= 0.75f;
    }

    public final C2460eX A0b() {
        return this.A04;
    }

    public final void A0c(C2460eX c2460eX) {
        this.A04 = c2460eX;
    }

    public final void A0d(List<C2354cn> list) {
        this.A05 = list;
    }
}
