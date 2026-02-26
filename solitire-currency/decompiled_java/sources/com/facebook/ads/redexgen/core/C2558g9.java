package com.facebook.ads.redexgen.core;

import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.g9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2558g9 implements InterfaceC1913Pl {
    public static byte[] A01;
    public final /* synthetic */ C14346g A00;

    static {
        A01();
    }

    public static String A00(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] - i12) - 72);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-26, 4, 15, 15, 8, 7, -61, 4, 23, 23, 4, 6, 11, -61, 18, 17, -61, 4, -61, 6, 11, 12, 15, 7, -61, 26, 11, 12, 6, 11, -61, 12, 22, -61, 17, 18, 23, -61, 7, 8, 23, 4, 6, 11, 8, 7, -35, -61, -53, -55, -44, -44, -51, -52, -120, -52, -51, -36, -55, -53, -48, -120, -41, -42, -120, -55, -42, -120, -55, -44, -38, -51, -55, -52, -31, -120, -52, -51, -36, -55, -53, -48, -51, -52, -120, -53, -48, -47, -44, -52, -120};
    }

    public C2558g9(C14346g c14346g) {
        this.A00 = c14346g;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1913Pl
    public final void A4C(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        AbstractC1934Qg abstractC1934QgA0F = C14346g.A0F(view);
        if (abstractC1934QgA0F != null) {
            if (abstractC1934QgA0F.A0i() || abstractC1934QgA0F.A0l()) {
                abstractC1934QgA0F.A0V();
            } else {
                throw new IllegalArgumentException(A00(0, 48, 91) + abstractC1934QgA0F + this.A00.A1J());
            }
        }
        this.A00.attachViewToParent(view, i10, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1913Pl
    public final void A5o(int i10) {
        AbstractC1934Qg abstractC1934QgA0F;
        View view = A79(i10);
        if (view != null && (abstractC1934QgA0F = C14346g.A0F(view)) != null) {
            if (!abstractC1934QgA0F.A0i() || abstractC1934QgA0F.A0l()) {
                abstractC1934QgA0F.A0Z(256);
            } else {
                throw new IllegalArgumentException(A00(48, 43, 32) + abstractC1934QgA0F + this.A00.A1J());
            }
        }
        this.A00.detachViewFromParent(i10);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1913Pl
    public final View A79(int i10) {
        return this.A00.getChildAt(i10);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1913Pl
    public final int A7A() {
        return this.A00.getChildCount();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1913Pl
    public final AbstractC1934Qg A7D(View view) {
        return C14346g.A0F(view);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1913Pl
    public final int A9z(View view) {
        return this.A00.indexOfChild(view);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1913Pl
    public final void ADA(View view) {
        AbstractC1934Qg abstractC1934QgA0F = C14346g.A0F(view);
        if (abstractC1934QgA0F != null) {
            abstractC1934QgA0F.A0D(this.A00);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1913Pl
    public final void ADv(View view) {
        AbstractC1934Qg abstractC1934QgA0F = C14346g.A0F(view);
        if (abstractC1934QgA0F != null) {
            abstractC1934QgA0F.A0E(this.A00);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1913Pl
    public final void AHg() {
        int iA7A = A7A();
        for (int i10 = 0; i10 < iA7A; i10++) {
            View viewA79 = A79(i10);
            this.A00.A1g(viewA79);
            viewA79.clearAnimation();
        }
        this.A00.removeAllViews();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1913Pl
    public final void AHm(int i10) {
        View childAt = this.A00.getChildAt(i10);
        if (childAt != null) {
            this.A00.A1g(childAt);
            childAt.clearAnimation();
        }
        this.A00.removeViewAt(i10);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1913Pl
    public final void addView(View view, int i10) {
        this.A00.addView(view, i10);
        this.A00.A1f(view);
    }
}
