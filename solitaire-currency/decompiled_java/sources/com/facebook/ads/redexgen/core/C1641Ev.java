package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ev, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1641Ev extends AbstractC1934Qg implements InterfaceC2125Xu {
    public N3 A00;
    public AbstractC2459eW A01;
    public C2460eX A02;
    public C2460eX A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final int A07;
    public final SparseBooleanArray A08;
    public final C2387dL A09;
    public final C5Q A0A;

    public C1641Ev(C5Q c5q, SparseBooleanArray sparseBooleanArray, C2460eX c2460eX, int i10, int i11, int i12, int i13, C2387dL c2387dL, N3 n32) {
        super(c5q);
        this.A09 = c2387dL;
        this.A0A = c5q;
        this.A08 = sparseBooleanArray;
        this.A02 = c2460eX;
        this.A04 = i10;
        this.A05 = i11;
        this.A06 = i12;
        this.A07 = i13;
        this.A00 = n32;
    }

    private void A05(US us, XH xh, String str, C2354cn c2354cn) {
        if (this.A08.get(c2354cn.A02())) {
            return;
        }
        if (this.A03 != null) {
            this.A03.A0V();
            this.A03 = null;
        }
        this.A01 = new C1643Ex(this, str, c2354cn, us, c2354cn.A04(), xh);
        this.A03 = new C2460eX(this.A0A, 10, new WeakReference(this.A01), this.A09);
        this.A03.A0Y(false);
        this.A03.A0W(100);
        this.A03.A0X(100);
        this.A0A.setOnAssetsLoadedListener(new C1642Ew(this, c2354cn));
    }

    public final KE A0p() {
        return this.A0A.getCtaButton();
    }

    public final void A0q(C2354cn c2354cn, US us, SF sf, XH xh, String str) {
        int iA02 = c2354cn.A02();
        this.A0A.setTag(-1593835536, Integer.valueOf(iA02));
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(this.A04, -2);
        int rightMargin = iA02 == 0 ? this.A05 : this.A06;
        int position = this.A07;
        marginLayoutParams.setMargins(rightMargin, 0, iA02 >= position + (-1) ? this.A05 : this.A06, 0);
        String imageUrl = c2354cn.A03().A0H().A08();
        String strA09 = c2354cn.A03().A0H().A09();
        this.A0A.setIsVideo(!TextUtils.isEmpty(strA09));
        if (this.A0A.A1T()) {
            this.A0A.setVideoPlaceholderUrl(imageUrl);
            this.A0A.setVideoUrl(sf.A0T(strA09));
        } else {
            this.A0A.setImageUrl(imageUrl);
        }
        this.A0A.setLayoutParams(marginLayoutParams);
        this.A0A.setAdTitleAndDescription(c2354cn.A03().A0I().A0F(), c2354cn.A03().A0I().A04());
        this.A0A.setCTAInfo(c2354cn.A03().A0J(), c2354cn.A04());
        this.A0A.A1W(c2354cn.A04());
        A05(us, xh, str, c2354cn);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2125Xu
    public final void AIV() {
        this.A0A.A1O();
    }
}
