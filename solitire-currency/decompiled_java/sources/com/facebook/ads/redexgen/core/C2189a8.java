package com.facebook.ads.redexgen.core;

import android.content.res.Configuration;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.a8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2189a8 extends RelativeLayout {
    public static String[] A06 = {"5SHdRwFrRc5I045mD2ED8hkR", "u607MEARHNz8UhlPP1yTj4t381pEaF91", "vukf6ONNN7udfcALTJGLQQCjk2MRvNqz", "", "LcpvFkzcfh74Tt7JU5VGWxCVkX9ufVQR", "0vcUNZ0oTZNrvLONhpGozykOOsxw8rlk", "", "YDZhxKGTPmLilHONF7GF9MvjPIJLKPZP"};
    public final int A00;
    public final LinearLayout A01;
    public final C2660hw A02;
    public final C2387dL A03;
    public final US A04;
    public final InterfaceC2118Xn A05;

    public C2189a8(C2387dL c2387dL, C2660hw c2660hw, US us, InterfaceC2118Xn interfaceC2118Xn, int i10, int i11) {
        super(c2387dL);
        this.A03 = c2387dL;
        this.A02 = c2660hw;
        this.A04 = us;
        this.A05 = interfaceC2118Xn;
        this.A00 = i10;
        this.A01 = new LinearLayout(c2387dL);
        A00();
        addView(this.A01, new FrameLayout.LayoutParams(-1, -1));
        setLayoutOrientation(i11);
    }

    private void A00() {
        int i10 = 0;
        while (true) {
            int iA1u = this.A02.A1u();
            String[] strArr = A06;
            String str = strArr[2];
            String str2 = strArr[4];
            int iCharAt = str.charAt(18);
            int i11 = str2.charAt(18);
            if (iCharAt == i11) {
                throw new RuntimeException();
            }
            A06[7] = "iNncIzrUEB4NW29LDzlz6YUCQOx5Utak";
            if (i10 < iA1u) {
                KI ki = new KI(this.A03, this.A02.A1x(i10), this.A04, this.A05);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                layoutParams.weight = 1.0f;
                int i12 = KI.A0C;
                int i13 = KI.A0C;
                int i14 = KI.A0C;
                int i15 = KI.A0C;
                layoutParams.setMargins(i12, i13, i14, i15);
                ki.setLayoutParams(layoutParams);
                this.A01.addView(ki);
                i10++;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setLayoutOrientation(configuration.orientation);
    }

    private void setLayoutOrientation(int i10) {
        if (i10 != 1) {
            this.A01.setOrientation(0);
            this.A01.setPadding(0, this.A00, 0, (int) (((double) this.A00) * 0.25d));
        } else {
            this.A01.setOrientation(1);
            this.A01.setPadding(0, (int) (((double) this.A00) * 1.5d), 0, this.A00);
        }
    }
}
