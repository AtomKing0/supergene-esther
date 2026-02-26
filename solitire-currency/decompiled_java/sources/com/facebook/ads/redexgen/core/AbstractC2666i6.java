package com.facebook.ads.redexgen.core;

import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.i6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2666i6 extends QC<OB> {
    public static String[] A05 = {"BofGdT", "Cb8B81bPHxSAbCDzy4", "tLXqRIVVg6Ax3ByQPtTHAjuCLXMkMIv2", "Awqy8gsEnlsE3SarczMGKLCzZdtyeG5w", "c95zYEegXXkMe1M4f4KrlDKZ96YYHdKl", "dzB1VPy83al1mBxHBTo", "7fXNgxpNBgLKECdM7L4CyN3WmxsqHAeT", "HUwJOtf8ZOX36MmDYBkOhN0MiSikj2Pg"};
    public static final int A06 = (int) (AbstractC2090Wl.A02 * 4.0f);
    public InterfaceC1837Mk A00;
    public final List<C1930Qc> A01;
    public final int A02;
    public final C2387dL A03;
    public final AbstractC2459eW A04 = new C2669i9(this);

    public AbstractC2666i6(C0L c0l, List<C1930Qc> list, C2387dL c2387dL) {
        this.A03 = c2387dL;
        this.A02 = c0l.getChildSpacing();
        this.A01 = list;
    }

    private ViewGroup.MarginLayoutParams A01(int i10) {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -1);
        int i11 = this.A02;
        if (i10 == 0) {
            i11 *= 2;
        }
        int size = this.A01.size() - 1;
        String[] strArr = A05;
        if (strArr[3].charAt(2) == strArr[4].charAt(2)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A05;
        strArr2[7] = "KlchvvVcsY9zV3e8wqzNtTZQscUuxnqD";
        strArr2[1] = "gQBYn2ao1l5plthpQQ";
        marginLayoutParams.setMargins(i11, 0, i10 >= size ? this.A02 * 2 : this.A02, 0);
        return marginLayoutParams;
    }

    @Override // com.facebook.ads.redexgen.core.QC
    public final int A0B() {
        return this.A01.size();
    }

    public final void A0O(ImageView imageView, int i10) {
        C1930Qc c1930Qc = this.A01.get(i10);
        C2045Up adCoverImage = c1930Qc.getAdCoverImage();
        if (adCoverImage != null) {
            KZ kzA04 = new KZ(imageView, this.A03).A04();
            kzA04.A06(new C2668i8(this, i10, c1930Qc));
            kzA04.A07(adCoverImage.getUrl());
        }
    }

    public final void A0P(InterfaceC1837Mk interfaceC1837Mk) {
        this.A00 = interfaceC1837Mk;
    }

    public void A0Q(OB ob, int i10) {
        ob.A0p().setLayoutParams(A01(i10));
    }
}
