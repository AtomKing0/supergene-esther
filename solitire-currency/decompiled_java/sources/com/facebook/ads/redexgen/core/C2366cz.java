package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.media3.extractor.ts.PsExtractor;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2366cz extends FrameLayout {
    public static byte[] A0C;
    public static String[] A0D = {"5vYLtEaU9MAxDoI06TlJjFfWs8tiaGj", "TX23sib3Tj6X7eJy5cgYAILp0vVPLOiW", "Lxz50jZMaNdiu", "yIxUapHBf", "xsW4qvb7U5EMj5cNQbMl14i5qh6u6uOh", "8XLPt3rjq6gnj0Cd96o3z24ZTqMdgzej", "IIODaFrLnzdPntRGftRJpuPC", "ODWlzaCdU1siup4vWOfVQK22DnthNinE"};
    public static final float A0E;
    public static final RelativeLayout.LayoutParams A0F;
    public int A00;
    public long A01;
    public InterfaceC2364cx A02;
    public Map<String, String> A03;
    public final AbstractC2662hy A04;
    public final NB A05;
    public final C2387dL A06;
    public final US A07;
    public final InterfaceC2164Zh A08;
    public final C1783Ki A09;
    public final AtomicBoolean A0A;
    public final AtomicBoolean A0B;

    public static String A06(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] ^ i12) ^ 9);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        String[] strArr = A0D;
        if (strArr[1].charAt(1) != strArr[5].charAt(1)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0D;
        strArr2[7] = "Af0WM9g7Nak7nSkWG18ndsMVC8MahONd";
        strArr2[4] = "VergmF1iO6RBn6aZ7U2vBdquKGl77VZm";
        A0C = new byte[]{54, 18, 32, 28, 17, 9, 17, 18, 28, 21, 49, 20, 19, 34, 49, 48, 42, 45, 36, 99, 38, 49, 49, 44, 49, 68, 120, 117, 109, 117, 118, 120, 113, 52, 112, 123, 87, 96, 117, 87, 120, 125, 119, 127, 52, 96, 102, 125, 115, 115, 113, 102, 113, 112, 52, 99, 125, 96, 124, 52, 100, 102, 113, 57, 113, 98, 113, 122, 96, 52, 119, 120, 125, 119, 127, 103, 52, 119, 123, 97, 122, 96, 52, 117, 122, 112, 52, 80, 113, 120, 117, 109, 13, 49, 60, 36, 60, 63, 49, 56, 28, 57, 46, 11, 52, 56, 42, 114, 117, 119, 121, 126, 48, 124, 127, 113, 116, 121, 126, 119, 48, 98, 117, 125, 127, 100, 117, 48, 96, 124, 113, 105, 113, 114, 124, 117, 34, 45, 40, 34, 42, 50, 5, 4, 13, 0, 24, 114, 110, 99, 123, 99, 96, 110, 103, 52, 40, 37, 61, 37, 38, 40, 33, 27, 54, 33, 41, 43, 48, 33, 95, 72, 64, 66, 89, 72, 114, 94, 72, 94, 94, 68, 66, 67, 114, 68, 73, 78, 85, 81, 95, 84, 119, 101, 98, 95, 118, 105, 101, 119};
    }

    static {
        A09();
        A0E = (int) (AbstractC2090Wl.A02 * 4.0f);
        A0F = new RelativeLayout.LayoutParams(-1, -1);
    }

    public C2366cz(C2387dL c2387dL, AbstractC2662hy abstractC2662hy, NB nb, US us, InterfaceC2364cx interfaceC2364cx, Map<String, String> playableMetricsData) {
        super(c2387dL);
        this.A0A = new AtomicBoolean(false);
        this.A0B = new AtomicBoolean(false);
        this.A01 = -1L;
        this.A00 = 0;
        this.A08 = new AbstractC1794Kt() { // from class: com.facebook.ads.redexgen.X.3p
            @Override // com.facebook.ads.redexgen.core.InterfaceC2164Zh
            public final void ACO() {
            }

            @Override // com.facebook.ads.redexgen.core.AbstractC1794Kt, com.facebook.ads.redexgen.core.InterfaceC2164Zh
            public final void ADG(int i10, String str) {
                this.A00.A0B.set(true);
                if (this.A00.A02 == null) {
                    return;
                }
                this.A00.A02.AE2();
            }

            @Override // com.facebook.ads.redexgen.core.InterfaceC2164Zh
            public final void ADW() {
                if (this.A00.A0B.get() || !this.A00.A0A.compareAndSet(false, true) || this.A00.A02 == null) {
                    return;
                }
                this.A00.A02.ADW();
            }

            @Override // com.facebook.ads.redexgen.core.InterfaceC2164Zh
            public final void AFw() {
                if (this.A00.A02 == null) {
                    return;
                }
                this.A00.A02.AFw();
            }
        };
        this.A06 = c2387dL;
        this.A04 = abstractC2662hy;
        this.A05 = nb;
        this.A07 = us;
        this.A02 = interfaceC2364cx;
        this.A03 = playableMetricsData;
        this.A09 = A04();
        if (this.A05.A0M() && !this.A05.A0O()) {
            A0B();
        }
        if (U7.A1u(this.A06)) {
            this.A06.A0B().AK2(this.A09, this.A04.A25(), false);
        }
        addView(this.A09, A0F);
    }

    public static /* synthetic */ int A00(C2366cz c2366cz) {
        int i10 = c2366cz.A00;
        c2366cz.A00 = i10 + 1;
        return i10;
    }

    private C1783Ki A04() {
        C1783Ki c1783Ki = new C1783Ki(this.A06, (WeakReference<InterfaceC2164Zh>) new WeakReference(this.A08), 10, U7.A22(this.A06));
        c1783Ki.setCornerRadius(A0E);
        c1783Ki.setLogMultipleImpressions(false);
        c1783Ki.setCheckAssetsByJavascriptBridge(false);
        c1783Ki.setWebViewTimeoutInMillis(this.A05.A09());
        c1783Ki.setRequestId(this.A04.A17());
        c1783Ki.setOnTouchListener(new ViewOnTouchListenerC2365cy(this));
        WebSettings settings = c1783Ki.getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        c1783Ki.addJavascriptInterface(new C2367d0(this.A06, this, this.A07, this.A03, this.A04.A25()), A06(0, 12, 121));
        return c1783Ki;
    }

    public final void A0A() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.A01;
        C2001Sw c2001Sw = new C2001Sw(A06(25, 67, 29));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A06(136, 6, 72), this.A00);
            jSONObject.put(A06(142, 5, 104), jCurrentTimeMillis);
            jSONObject.put(A06(187, 5, 51), this.A04.A25());
        } catch (JSONException e10) {
            Log.e(A06(92, 15, 84), A06(12, 13, 74), e10);
        }
        c2001Sw.A07(jSONObject);
        c2001Sw.A05(1);
        InterfaceC1999Su interfaceC1999SuA08 = this.A06.A08();
        int i10 = AbstractC2000Sv.A2D;
        String strA06 = A06(147, 8, 11);
        interfaceC1999SuA08.AAz(strA06, i10, c2001Sw);
        this.A00 = 0;
        if (!U7.A1p(this.A06)) {
            if (this.A02 == null) {
                return;
            }
            this.A02.ACt();
            return;
        }
        if (jCurrentTimeMillis <= U7.A0L(this.A06)) {
            InterfaceC2364cx interfaceC2364cx = this.A02;
            String[] strArr = A0D;
            if (strArr[7].charAt(0) == strArr[4].charAt(0)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0D;
            strArr2[1] = "0XAlcIRGce3nNmobAWWNAzxTwWjfpKo1";
            strArr2[5] = "vX4VpuJxASYV4FwrDvVxGQ4QiWthZxUm";
            if (interfaceC2364cx != null) {
                this.A02.ACt();
                return;
            }
            return;
        }
        c2001Sw.A05(0);
        this.A06.A08().AAy(strA06, AbstractC2000Sv.A2E, c2001Sw);
    }

    public final void A0B() {
        String strA0F;
        if (this.A05.A0O()) {
            C2001Sw c2001Sw = new C2001Sw(A06(107, 29, 25));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(A06(170, 17, 36), this.A05.A0I());
                jSONObject.put(A06(187, 5, 51), this.A04.A25());
            } catch (JSONException e10) {
                String strA06 = A06(92, 15, 84);
                String strA062 = A06(12, 13, 74);
                String[] strArr = A0D;
                if (strArr[1].charAt(1) != strArr[5].charAt(1)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0D;
                strArr2[3] = "qKqF8GsLC";
                strArr2[6] = "yUBs4wOBB81EmWZp6CsNCuI0";
                Log.e(strA06, strA062, e10);
            }
            c2001Sw.A07(jSONObject);
            c2001Sw.A05(1);
            InterfaceC1999Su interfaceC1999SuA08 = this.A06.A08();
            int i10 = AbstractC2000Sv.A2G;
            String strA063 = A06(155, 15, 77);
            interfaceC1999SuA08.AAz(strA063, i10, c2001Sw);
            if (U7.A0r(this.A06) && XE.A00(this.A06) == XD.A07) {
                this.A06.A08().AAz(strA063, AbstractC2000Sv.A2F, c2001Sw);
                this.A08.ADG(0, null);
                String[] strArr3 = A0D;
                if (strArr3[1].charAt(1) != strArr3[5].charAt(1)) {
                    String[] strArr4 = A0D;
                    strArr4[7] = "eYeTyqsAvkMxTzxGPJMzaaOJBs1WoRUE";
                    strArr4[4] = "DGSgvEgHkFrTWskIwQomZOyU4ros1fyW";
                    return;
                } else {
                    String[] strArr5 = A0D;
                    strArr5[1] = "QXwUk7ZcYbXDO6xLw92fyo5XHWgn18Du";
                    strArr5[5] = "iXthj0ZXJZZP0QlicLBvNNfJ4d5EWvqr";
                    return;
                }
            }
        }
        try {
            C1783Ki c1783Ki = this.A09;
            if (!TextUtils.isEmpty(this.A05.A0C())) {
                strA0F = this.A05.A0C();
            } else {
                strA0F = this.A05.A0F();
            }
            c1783Ki.loadUrl(strA0F);
        } catch (Exception e11) {
            this.A06.A08().AAy(A06(PsExtractor.AUDIO_STREAM, 8, 9), AbstractC2000Sv.A2f, new C2001Sw(e11));
        }
    }

    public final void A0C() {
        if (U7.A1u(this.A06)) {
            this.A06.A0B().AJj(this.A09);
        }
        this.A09.removeJavascriptInterface(A06(0, 12, 121));
        this.A09.destroy();
    }

    public XH getTouchDataRecorder() {
        return this.A09.getTouchDataRecorder();
    }

    public C2460eX getViewabilityChecker() {
        return this.A09.getViewabilityChecker();
    }

    public void setPlayableAdsViewListener(InterfaceC2364cx interfaceC2364cx) {
        this.A02 = interfaceC2364cx;
    }
}
