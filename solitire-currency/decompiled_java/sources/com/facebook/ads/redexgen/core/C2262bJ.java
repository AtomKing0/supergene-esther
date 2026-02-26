package com.facebook.ads.redexgen.core;

import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2262bJ extends FrameLayout {
    public final int A00;
    public final RelativeLayout A01;
    public final KE A02;
    public static final int A05 = (int) (AbstractC2090Wl.A02 * 36.0f);
    public static final int A06 = (int) (AbstractC2090Wl.A02 * 36.0f);
    public static final int A03 = (int) (AbstractC2090Wl.A02 * 23.0f);
    public static final int A04 = (int) (AbstractC2090Wl.A02 * 3.0f);
    public static final int A07 = (int) (AbstractC2090Wl.A02 * 4.0f);

    public C2262bJ(C2387dL c2387dL, KE ke, AbstractC2662hy abstractC2662hy, US us, InterfaceC2118Xn interfaceC2118Xn, C2460eX c2460eX, XH xh, C1850My c1850My, InterfaceC2187a4 interfaceC2187a4) {
        super(c2387dL);
        this.A00 = c1850My.A09(true);
        this.A01 = new RelativeLayout(c2387dL);
        addView(this.A01, new FrameLayout.LayoutParams(-1, -1));
        this.A01.setClickable(false);
        A01(c2387dL, abstractC2662hy.A20().A0J().A04());
        if (ke == null) {
            this.A02 = new KE(c2387dL, abstractC2662hy.A0r(), (C1850My) null, us, interfaceC2118Xn, c2460eX, xh, abstractC2662hy.A21());
        } else {
            this.A02 = ke;
        }
        A03();
        this.A02.setCta(abstractC2662hy.A20().A0J(), abstractC2662hy.A25(), new HashMap(), interfaceC2187a4);
        this.A02.setIsInAppBrowser(true);
        FrameLayout.LayoutParams ctaButtonParams = new FrameLayout.LayoutParams(-1, -1);
        addView(this.A02, ctaButtonParams);
    }

    private void A00(C2387dL c2387dL, View view) {
        ImageView imageView = new ImageView(c2387dL);
        imageView.setImageBitmap(XY.A01(XX.MINIMIZE_ARROW));
        imageView.setRotation(180.0f);
        imageView.setClickable(false);
        imageView.setColorFilter(this.A00);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(A03, A03);
        imageView.setPadding(A04, A04, A04, A04);
        layoutParams.addRule(2, view.getId());
        layoutParams.addRule(14);
        this.A01.addView(imageView, layoutParams);
    }

    private void A01(C2387dL c2387dL, String str) {
        Button button = new Button(c2387dL);
        XP.A0I(button);
        button.setPadding(A06, 0, A06, 0);
        button.setText(str.toUpperCase(Locale.getDefault()));
        button.setTextSize(14.0f);
        button.setTypeface(Typeface.defaultFromStyle(1));
        XP.A0M(button, this.A00, A07);
        button.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        RelativeLayout.LayoutParams ctaParams = new RelativeLayout.LayoutParams(-2, A05);
        ctaParams.addRule(12);
        ctaParams.addRule(14);
        this.A01.addView(button, ctaParams);
        A00(c2387dL, button);
    }

    public final ME A02(String str) {
        return this.A02.A0E(str);
    }

    public final void A03() {
        this.A02.setBackgroundColor(0);
        this.A02.setTextColor(0);
    }

    @Override // android.view.View
    public final boolean performClick() {
        return this.A02.performClick();
    }

    public void setAutoClickTime(AbstractC2662hy abstractC2662hy, AbstractC2117Xm abstractC2117Xm) {
        this.A02.A0F(abstractC2662hy, abstractC2117Xm);
    }

    public void setCta(C1851Mz c1851Mz, String str, HashMap<String, String> extras, InterfaceC2187a4 interfaceC2187a4) {
        this.A02.setCta(c1851Mz, str, extras, interfaceC2187a4);
    }
}
