package com.facebook.ads.redexgen.core;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2p, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C13392p extends AbstractC1594Da {
    public static String[] A04 = {"hk0dnqphYZ0B2FA2HHbeoaEOUC9cHUBv", "tTD1hmxYdA3U5n9t8Z20NsAIS", "BfpeWRttIDT9n", "BdF5VvNpfNEd8dAFz8yBB3tju8j2QPKu", "opIRFI8OjkHX6xnIsWRzCqWD0", "Ob0oYr4gU4dgC4EVWukqT8XlG8BtSCcB", "HPuRIIJ62FmEL4YF0ip1f4WrSa12U9bK", "7SB"};
    public final ImageView A00;
    public final C2387dL A01;
    public final AbstractC2010Tf<C13533d> A02;
    public final AbstractC2010Tf<DQ> A03;

    public C13392p(C2387dL c2387dL) {
        this(c2387dL, false);
    }

    public C13392p(C2387dL c2387dL, boolean z10) {
        ImageView.ScaleType scaleType;
        int color;
        super(c2387dL);
        this.A03 = new C1593Cz(this);
        this.A02 = new C1592Cy(this);
        this.A01 = c2387dL;
        this.A00 = new ImageView(c2387dL);
        if (!z10) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
            color = ViewCompat.MEASURED_STATE_MASK;
        } else {
            scaleType = ImageView.ScaleType.FIT_START;
            color = 0;
        }
        this.A00.setScaleType(scaleType);
        XP.A0K(this.A00, color);
        this.A00.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.A00);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1594Da
    public final void A07() {
        super.A07();
        if (getVideoView() != null) {
            C2009Te<AbstractC2010Tf, C2008Td> eventBus = getVideoView().getEventBus();
            AbstractC2010Tf[] abstractC2010TfArr = new AbstractC2010Tf[2];
            String[] strArr = A04;
            if (strArr[3].charAt(25) != strArr[5].charAt(25)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[7] = "Nqq";
            strArr2[2] = "4efeQvUmAeHBj";
            abstractC2010TfArr[0] = this.A03;
            abstractC2010TfArr[1] = this.A02;
            eventBus.A03(abstractC2010TfArr);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1594Da
    public final void A08() {
        if (getVideoView() != null) {
            getVideoView().getEventBus().A04(this.A02, this.A03);
        }
        super.A08();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        this.A00.layout(0, 0, i12 - i10, i13 - i11);
    }

    public void setImage(String str) {
        setImage(str, null);
    }

    public void setImage(String str, InterfaceC2171Zo interfaceC2171Zo) {
        if (str == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        KZ downloadImageTask = new KZ(this.A00, this.A01).A04();
        if (interfaceC2171Zo != null) {
            downloadImageTask.A06(interfaceC2171Zo);
        }
        downloadImageTask.A07(str);
    }
}
