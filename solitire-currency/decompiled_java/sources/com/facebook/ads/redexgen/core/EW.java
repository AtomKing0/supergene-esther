package com.facebook.ads.redexgen.core;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class EW extends C2202aL {
    public final ImageView A00;
    public final C2387dL A01;

    public EW(C2387dL c2387dL) {
        super(c2387dL);
        this.A01 = c2387dL;
        setRadius(30);
        this.A00 = new ImageView(c2387dL);
        this.A00.setAdjustViewBounds(true);
        addView(this.A00, new RelativeLayout.LayoutParams(-2, -1));
    }

    public final /* synthetic */ void A00(C2170Zn c2170Zn) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = -2;
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.updateViewLayout(this, layoutParams);
        }
    }

    public void setUrl(String str) {
        KZ kz = new KZ(this.A00, this.A01);
        kz.A04();
        kz.A07(str);
        kz.A06(new InterfaceC2171Zo() { // from class: com.facebook.ads.redexgen.X.EX
            @Override // com.facebook.ads.redexgen.core.InterfaceC2171Zo
            public final void ADT(C2170Zn c2170Zn) {
                this.A00.A00(c2170Zn);
            }
        });
    }
}
