package com.facebook.ads.redexgen.core;

import android.widget.ImageView;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class J3 implements InterfaceC2171Zo {
    public final /* synthetic */ C1741Is A00;

    public J3(C1741Is c1741Is) {
        this.A00 = c1741Is;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2171Zo
    public final void ADT(C2170Zn c2170Zn) {
        if (this.A00.A02 != null && c2170Zn.A00() != null) {
            this.A00.A02.setImageBitmap(c2170Zn.A00());
            this.A00.A02.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.A00.A02.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
    }
}
