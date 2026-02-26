package com.facebook.ads.redexgen.core;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Y9 extends FrameLayout {
    public static byte[] A0C;
    public static String[] A0D = {"EYRP1PEEhxzmFZofVXiCCrEXWQs6qPAa", "IPRTBS", "NsAYUXCCkxBbK0XyUhCt1xHChz5fZfMK", "fEJJ0", "6651Qynk9CVpAvzNTMvYSQKVDYa6iazW", "nD7S5n7VHEDKGeK1PzI1a27Vk58dSaaa", "vFV0GS7SjmRPmH7mLZ5yrXn6gSrRknN8", "LPfldR2r"};
    public static final int A0E;
    public boolean A00;
    public final C2671iB A01;
    public final C2387dL A02;
    public final US A03;
    public final C2030Ua A04;
    public final XH A05;
    public final Mn A06;
    public final Y3 A07;
    public final AbstractC2459eW A08;
    public final C2460eX A09;
    public final String A0A;
    public final WeakReference<Y8> A0B;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 20 out of bounds for length 19
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public Y9(C2387dL c2387dL, US us, SF sf, WeakReference<Y8> weakReference, int i10, int i11, int i12, int i13, C2671iB c2671iB, String str) {
        super(c2387dL);
        this.A05 = new XH();
        this.A02 = c2387dL;
        this.A03 = us;
        this.A01 = c2671iB;
        this.A0B = weakReference;
        this.A0A = str;
        AbstractC2662hy abstractC2662hyA0C = this.A01.A0C();
        if (abstractC2662hyA0C == null) {
            throw new IllegalStateException(A09(0, 32, 86));
        }
        XP.A0K(this, -1);
        this.A04 = new C2030Ua(this.A01.A7G(), this.A03);
        this.A08 = A06();
        this.A09 = A07(i10, i13, i11, i12);
        LinearLayout linearLayout = new LinearLayout(c2387dL);
        linearLayout.setOrientation(1);
        addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        this.A07 = A04(sf);
        if (this.A07 != null) {
            linearLayout.addView(this.A07, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
        this.A06 = A02(abstractC2662hyA0C);
        linearLayout.addView(this.A06, new LinearLayout.LayoutParams(-1, -2));
    }

    public static String A09(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            byte b10 = (byte) ((bArrCopyOfRange[i13] - i12) - 99);
            if (A0D[6].charAt(17) == 'I') {
                throw new RuntimeException();
            }
            A0D[6] = "HyV3wef6DGt1nbLL1fRSvAmBe6VeBas4";
            bArrCopyOfRange[i13] = b10;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0F() {
        A0C = new byte[]{-6, 29, -39, 29, 26, 45, 26, -39, 27, 46, 39, 29, 37, 30, -39, 34, 44, -39, 28, 26, 39, 39, 40, 45, -39, 27, 30, -39, 39, 46, 37, 37, 52, 64, 62, -1, 55, 50, 52, 54, 51, 64, 64, 60, -1, 50, 53, 68, -1, 51, 50, 63, 63, 54, 67, -1, 52, 61, 58, 52, 60, 54, 53};
    }

    static {
        A0F();
        A0E = (int) (AbstractC2090Wl.A02 * 40.0f);
    }

    private Mn A02(AbstractC2662hy abstractC2662hy) {
        C1850My c1850MyA00;
        C1841Mp c1841MpA20 = abstractC2662hy.A20();
        OA oa2 = new OA() { // from class: com.facebook.ads.redexgen.X.61
            public static byte[] A01;
            public static String[] A02 = {"69whQSJFXzC5tMS1mvBQof2SK7ErE5ZD", "1jHEgafKgZ1qGtZeFln5jYEaZuoTSi1L", "X7dL0uEA8hI8yFDxVjmpGWGPGaRf3imC", "xkNxR1N5ht6u5HrBYV6Jaj9BRbbqvvjX", "FzWiIV8jsRMCATg74qRy8XJg", "NPgeBhkCK5cdUCtVbQG3V7Bzbyz9qF6p", "wkBgnizDM2wMuU", "fQJYdDBiu8hI0YoMzyDMv7ESaoH1tCRU"};

            public static String A00(int i10, int i11, int i12) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i10, i10 + i11);
                int i13 = 0;
                while (true) {
                    int length = bArrCopyOfRange.length;
                    String[] strArr = A02;
                    if (strArr[5].charAt(30) == strArr[3].charAt(30)) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A02;
                    strArr2[5] = "zFlqgUHcpRBmVFunDUsFQIo1zDN3Ly6W";
                    strArr2[3] = "vgtBZdmtnd3XTM9GsG6r3isUaM0HNLHl";
                    if (i13 >= length) {
                        return new String(bArrCopyOfRange);
                    }
                    bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] - i12) - 4);
                    i13++;
                }
            }

            public static void A01() {
                A01 = new byte[]{-102};
            }

            static {
                A01();
            }

            @Override // com.facebook.ads.redexgen.core.InterfaceC2118Xn
            public final void A4b(String str) {
                OO.A00(this.A00.A02).A07(new Intent(str + A00(0, 1, 92) + this.A00.A0A));
            }
        };
        if (getOrientation() == 1) {
            c1850MyA00 = abstractC2662hy.A1z().A01();
        } else {
            C1838Ml c1838MlA1z = abstractC2662hy.A1z();
            String[] strArr = A0D;
            if (strArr[1].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            A0D[7] = "bY8FFe1Y";
            c1850MyA00 = c1838MlA1z.A00();
        }
        Mn mn = new Mn(this.A02, A0E, c1850MyA00, c1841MpA20.A0J().A06(), A09(32, 31, 110), this.A03, oa2, this.A09, this.A05, abstractC2662hy.A21());
        mn.setInfo(c1841MpA20.A0I(), c1841MpA20.A0J(), this.A01.A7G(), abstractC2662hy.A23().A01(), null, null);
        if (U7.A1M(this.A02)) {
            mn.A0h();
        }
        return mn;
    }

    private Y3 A04(SF sf) {
        Y6 y62 = new Y6(this);
        String strA0b = this.A01.A0b();
        if (A0H(sf, this.A01) && strA0b != null) {
            C1826Lz c1826Lz = new C1826Lz(this.A02, this.A03, sf, this.A04, y62);
            String strA7G = this.A01.A7G();
            String videoUrl = this.A01.A0E() != null ? this.A01.A0E().getUrl() : null;
            C1826Lz videoView = c1826Lz.A0F(strA7G, strA0b, videoUrl, this.A01.A0O(), this.A01.A0N());
            if (U7.A1Q(this.A02)) {
                setViewAsCTA(videoView);
            }
            return videoView;
        }
        C2045Up c2045UpA0E = this.A01.A0E();
        if (c2045UpA0E == null) {
            return null;
        }
        MZ mzA0F = new MZ(this.A02, y62).A0F(c2045UpA0E.getUrl());
        if (U7.A1O(this.A02)) {
            setViewAsCTA(mzA0F);
        }
        return mzA0F;
    }

    private C1825Ly A06() {
        return new C1825Ly(this);
    }

    private C2460eX A07(int i10, int i11, int i12, int i13) {
        C2460eX c2460eX = new C2460eX(this, i10, i11, true, new WeakReference(this.A08), this.A02);
        c2460eX.A0W(i12);
        c2460eX.A0X(i13);
        return c2460eX;
    }

    private void A0C() {
        String strA0J = this.A01.A0J();
        if (!TextUtils.isEmpty(strA0J)) {
            WN wn = new WN();
            C2387dL c2387dL = this.A02;
            Uri uriA00 = WQ.A00(strA0J);
            String adChoicesLinkUrl = this.A01.A7G();
            WN.A0O(wn, c2387dL, uriA00, adChoicesLinkUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D() {
        this.A04.A04(UZ.A0A, null);
        if (!O3.A00(this.A02.A02()).A0O(this.A02, false)) {
            A0C();
            return;
        }
        AbstractC2134Yd abstractC2134YdA01 = AbstractC2135Ye.A01(this.A02, this.A03, this.A01.A7G(), this);
        if (abstractC2134YdA01 == null) {
            A0C();
            return;
        }
        XP.A0R(this);
        addView(abstractC2134YdA01, new FrameLayout.LayoutParams(-1, -1));
        abstractC2134YdA01.A0M();
    }

    private void A0E() {
        if (getVisibility() == 0 && this.A00 && hasWindowFocus()) {
            this.A09.A0U();
        } else {
            this.A09.A0V();
        }
    }

    public static boolean A0H(SF sf, C2671iB c2671iB) {
        String strA0b = c2671iB.A0b();
        if (TextUtils.isEmpty(strA0b)) {
            return false;
        }
        String videoUrl = sf.A0T(strA0b);
        return !TextUtils.isEmpty(videoUrl);
    }

    public final void A0I() {
        if (this.A07 != null) {
            this.A07.A0A();
        }
        if (this.A09 != null) {
            this.A09.A0V();
        }
        XP.A0H(this);
    }

    public final void A0J() {
        if (this.A07 != null) {
            Y3 y32 = this.A07;
            if (A0D[2].charAt(13) == 'c') {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[0] = "hgkEcT5pEsAUKYMkvVnojxGMD5WCOUSh";
            strArr[5] = "qBRuzdoZQfMYUt1SZmDdshQz8Ndd8EXP";
            y32.A0B();
        }
    }

    private int getOrientation() {
        Activity activity = this.A02.A0E();
        if (activity != null) {
            return activity.getResources().getConfiguration().orientation;
        }
        return 1;
    }

    public C2460eX getViewabilityChecker() {
        return this.A09;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A00 = true;
        A0E();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A00 = false;
        A0E();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.A05.A06(this.A02, motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        A0E();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        A0E();
    }

    private void setViewAsCTA(View view) {
        view.setOnClickListener(new Y7(this));
    }
}
