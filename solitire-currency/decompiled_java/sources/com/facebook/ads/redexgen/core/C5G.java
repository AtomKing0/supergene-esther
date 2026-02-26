package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5G, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C5G extends FrameLayout implements I3 {
    public static byte[] A0A;
    public static String[] A0B = {"cNW8ZlUzhquZSz6XSi", "gKIjGDOIeaOzZR9qeyStr8duZ", "mQKfIuNnQZgt5ES8sx19fjwTYxycx0Lp", "WvoZHe7VElSdYX15O8PPMcOC5YskUK4l", "BfRVnLJiFu3hDnD", "WxgvJAZOXh", "crPtNK55mSnLeOXFeJGYeBq3ABMrpYK", "K6RBlZSEjGoukPcRXJY4znE0whNpCjIj"};
    public C2460eX A00;
    public final int A01;
    public final AbstractC2662hy A02;
    public final C2387dL A03;
    public final US A04;
    public final XH A05;
    public final InterfaceC2287bi A06;
    public final C2298bt A07;
    public final String A08;
    public final boolean A09;

    public static String A01(int i10, int i11, int i12) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i10, i10 + i11);
        for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
            bArrCopyOfRange[i13] = (byte) ((bArrCopyOfRange[i13] ^ i12) ^ 14);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0A = new byte[]{100, 70, 73, 0, 83, 7, 84, 83, 70, 85, 83, 7, 102, 82, 67, 78, 66, 73, 68, 66, 105, 66, 83, 80, 72, 85, 76, 102, 68, 83, 78, 81, 78, 83, 94, 9, 7, 106, 70, 76, 66, 7, 84, 82, 85, 66, 7, 83, 79, 70, 83, 7, 78, 83, 0, 84, 7, 78, 73, 7, 94, 72, 82, 85, 7, 102, 73, 67, 85, 72, 78, 67, 106, 70, 73, 78, 65, 66, 84, 83, 9, 95, 74, 75, 7, 65, 78, 75, 66, 9, 24, 28, 31, 43, 58, 55, 59, 48, 61, 59, 16, 59, 42, 41, 49, 44, 53, 69, 74, 123, 69, 71, 80, 77, 82, 77, 80, 93, 4, 11, 14, 4, 12, 56, 20, 8, 18, 21, 4, 2, 90, 85, 64, 93, 66, 81, 117, 80, 112, 85, 64, 85, 118, 65, 90, 80, 88, 81, 27, 29, 11, 28, 13, 2, 7, 13, 5, 22, 9, 5, 23, 52, 25, 16, 5};
    }

    static {
        A02();
    }

    public C5G(C2387dL c2387dL, US us, InterfaceC2287bi interfaceC2287bi, AbstractC2662hy abstractC2662hy, String str, int i10, XH xh) {
        super(c2387dL);
        this.A03 = c2387dL;
        this.A04 = us;
        this.A02 = abstractC2662hy;
        this.A08 = str;
        this.A06 = interfaceC2287bi;
        this.A01 = i10;
        C2298bt preloadedDynamicWebViewController = AbstractC2299bu.A02(abstractC2662hy.A17());
        if (preloadedDynamicWebViewController != null) {
            this.A07 = preloadedDynamicWebViewController;
            this.A09 = true;
        } else {
            this.A07 = new C2298bt(this.A03, abstractC2662hy, us, i10);
            AbstractC2299bu.A03(abstractC2662hy, this.A07);
            this.A09 = false;
        }
        if (xh != null) {
            this.A05 = xh;
            this.A07.A0Z(xh);
        } else {
            this.A05 = this.A07.A0L();
        }
        this.A07.A0c(new IT(this));
        this.A07.A0a(interfaceC2287bi);
        EnumC2095Wq.A04(this, EnumC2095Wq.A0B);
        if (U7.A1u(c2387dL)) {
            c2387dL.A0B().AK4(this.A07.A0O(), abstractC2662hy.A25(), false, false, true);
        }
        A04();
    }

    private final void A03() {
        this.A07.A0d(this);
        if (!this.A09) {
            this.A03.A0F().A5y();
            this.A07.A0X();
        } else {
            this.A03.A0F().A5z();
            if (this.A07.A0k()) {
                if (this.A01 == 4) {
                    if (this.A06 != null) {
                        this.A06.AD8(this);
                    }
                    if (U7.A1u(this.A03)) {
                        InterfaceC2034Ue interfaceC2034UeA0B = this.A03.A0B();
                        if (A0B[1].length() != 25) {
                            throw new RuntimeException();
                        }
                        A0B[5] = "";
                        interfaceC2034UeA0B.ACx();
                    }
                } else {
                    AJS();
                }
            }
        }
        A08();
    }

    private final void A04() {
        C2298bt.A0B().incrementAndGet();
        A03();
        this.A07.A0W();
    }

    private void A05(Intent intent, AbstractC2662hy abstractC2662hy) {
        intent.putExtra(A01(157, 8, 110), EnumC2057Vb.A07);
        intent.putExtra(A01(130, 18, 58), abstractC2662hy);
        intent.addFlags(268435456);
    }

    private final void A06(AbstractC2662hy abstractC2662hy) {
        AdActivityIntent adActivityIntentA05 = WB.A05(this.A03);
        A05(adActivityIntentA05, abstractC2662hy);
        try {
            WB.A0B(this.A03, adActivityIntentA05);
        } catch (Exception e10) {
            this.A03.A08().AAy(A01(107, 11, 42), AbstractC2000Sv.A0D, new C2001Sw(e10));
            Log.e(A01(90, 17, 80), A01(0, 90, 41), e10);
        }
    }

    private void A07(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a5 a5Var = new a5(this.A03, this.A08, this.A00, this.A05, this.A04, this.A02.A21());
        HashMap map = new HashMap();
        map.put(A01(118, 12, 105), A01(148, 9, 96));
        a5Var.A05(this.A02.A25(), str, map);
    }

    public final void A08() {
        XP.A0H(this.A07.A0O());
        addView(this.A07.A0O(), new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.facebook.ads.redexgen.core.I3
    public final void A9X() {
        A07(this.A02.A20().A0J().A05());
    }

    @Override // com.facebook.ads.redexgen.core.I3
    public final void A9Y(String str) {
        A07(str);
    }

    @Override // com.facebook.ads.redexgen.core.I3
    public final void A9c() {
    }

    @Override // com.facebook.ads.redexgen.core.I3
    public final void AAd() {
        new Handler(Looper.getMainLooper()).post(new IH(this));
    }

    @Override // com.facebook.ads.redexgen.core.I3
    public final void ADM() {
        A06(this.A02);
    }

    @Override // com.facebook.ads.redexgen.core.I3
    public final void ADQ() {
    }

    @Override // com.facebook.ads.redexgen.core.I3
    public final void AEF(boolean z10) {
    }

    @Override // com.facebook.ads.redexgen.core.I3
    public final void AFG() {
    }

    @Override // com.facebook.ads.redexgen.core.I3
    public final void AFn(boolean z10) {
    }

    @Override // com.facebook.ads.redexgen.core.I3
    public final void AFp(boolean z10) {
    }

    @Override // com.facebook.ads.redexgen.core.I3
    public final void AG4(String str) {
    }

    @Override // com.facebook.ads.redexgen.core.I3
    public final void AJS() {
        if (this.A06 != null) {
            this.A06.AD8(this);
        }
    }

    @Override // com.facebook.ads.redexgen.core.I3
    public final void close() {
    }

    public US getAdEventManager() {
        return this.A04;
    }

    public C2298bt getDynamicWebViewController() {
        return this.A07;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(motionEvent);
    }

    public void setAdViewabilityChecker(C2460eX c2460eX) {
        this.A00 = c2460eX;
        this.A07.A0e(c2460eX);
    }
}
