package com.facebook.ads.redexgen.core;

import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.a6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2188a6 {
    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.ads.redexgen.X.0g] */
    public static C12800g A00(final C2225ai c2225ai, final C1930Qc c1930Qc, final String str, final C14205s c14205s) {
        final boolean z10 = true;
        return new C14095h(c2225ai, c1930Qc, z10, str, c14205s) { // from class: com.facebook.ads.redexgen.X.0g
            public KE A00;
            public C2354cn A01;
            public final US A02 = this.A0I.A06().A02().A0A();
            public final C1930Qc A03;
            public final C14205s A04;
            public final String A05;
            public static String[] A06 = {"q", "A73Xi2G3GXsP7eqOYxzIEC2a49UqAHwv", "tzkKnItTrh", "5yGem34VUXIU78ICazF0QaKYuuceWMlm", "d26mhKEOwDnFCjn", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "vFFUszWLQFPwstqQ2PhnuKwIvdRc", "cQLhl1S6XoLnT945hQssVDVRJiee0FVC"};
            public static final int A08 = (int) (AbstractC2090Wl.A02 * (-4.0f));
            public static final int A07 = (int) (AbstractC2090Wl.A02 * 6.0f);

            {
                this.A03 = c1930Qc;
                this.A05 = str;
                this.A04 = c14205s;
                this.A03.A1L(this);
            }

            @Override // com.facebook.ads.redexgen.core.AbstractC1740Ir
            public void setupNativeCtaExtension(C2354cn c2354cn) {
                N3 n3A21;
                this.A01 = c2354cn;
                int iA0Q = U7.A0Q(this.A0I.A06());
                C1850My c1850MyA01 = this.A03.A10().A1z().A01();
                C2387dL c2387dLA06 = this.A0I.A06();
                String strA0r = this.A03.A10().A0r();
                US us = this.A02;
                InterfaceC2118Xn dummyListener = C2159Zc.getDummyListener();
                C2460eX c2460eXA0b = this.A04.A0b();
                XH xhA1A = this.A03.A1A();
                if (this.A03.A10() == null) {
                    n3A21 = null;
                } else {
                    n3A21 = this.A03.A10().A21();
                }
                this.A00 = new KE(c2387dLA06, strA0r, c1850MyA01, us, dummyListener, c2460eXA0b, xhA1A, n3A21);
                this.A00.setCta(c2354cn.A03().A0J(), this.A05, new HashMap());
                this.A03.A1L(this.A00);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                if (iA0Q == 1) {
                    layoutParams.addRule(12);
                    String[] strArr = A06;
                    String str2 = strArr[5];
                    String str3 = strArr[0];
                    int length = str2.length();
                    int extensionVariant = str3.length();
                    if (length != extensionVariant) {
                        throw new RuntimeException();
                    }
                    A06[4] = "cEnNLXyXCc05OsZ";
                    XP.A0N(this.A00, A07, 5, c1850MyA01.A0A(false));
                    ((C14095h) this).A06.addView(this.A00, layoutParams);
                    return;
                }
                if (iA0Q == 2) {
                    layoutParams.addRule(3, ((C14095h) this).A06.getId());
                    int extensionVariant2 = A08;
                    layoutParams.setMargins(0, extensionVariant2, 0, 0);
                    addView(this.A00, 0, layoutParams);
                    ((C14095h) this).A06.bringToFront();
                }
            }
        };
    }
}
