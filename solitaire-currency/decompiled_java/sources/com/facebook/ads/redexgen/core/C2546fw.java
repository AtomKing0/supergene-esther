package com.facebook.ads.redexgen.core;

import android.view.View;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2546fw implements InterfaceC2118Xn {
    public static String[] A01 = {"8tOzOPKLz5DDIwqC88XBXxH90bmVDotF", "YCktuRbEMhZaz9U821mncTHWO05lwCqY", "Eq7g3criU65KDBPK", "XEHycrxPk7FQv1FkL381pmPNBNbKujpl", "niYnM4G6gzmxtC7fq", "sRQOtQAi", "8G5qrnHnaOtx52JqPPi", "6arHmIfqlBfM2iqNpfy3RxuQJelIt1eI"};
    public final WeakReference<R0> A00;

    public C2546fw(R0 r02) {
        this.A00 = new WeakReference<>(r02);
    }

    private void A00(R0 r02) {
        C2363cw c2363cwA07 = r02.A07();
        if (c2363cwA07 != null && r02.A04() != null) {
            r02.A04().bringChildToFront(c2363cwA07);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2118Xn
    public void A3w(View view, int i10, RelativeLayout.LayoutParams layoutParams) {
        R0 r02 = this.A00.get();
        if (r02 != null && r02.A04() != null) {
            r02.A04().addView(view, i10, layoutParams);
            A00(r02);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2118Xn
    public void A3x(View view, RelativeLayout.LayoutParams layoutParams) {
        R0 r02 = this.A00.get();
        if (r02 != null && r02.A04() != null) {
            r02.A04().addView(view, layoutParams);
            A00(r02);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2118Xn
    public void A4b(String str) {
        if (this.A00.get() != null) {
            this.A00.get().A0C(str);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2118Xn
    public void A4c(String str, C2008Td c2008Td) {
        if (this.A00.get() != null) {
            this.A00.get().A0E(str, c2008Td);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2118Xn
    public void AAf(String str, N9 n92) {
        if (this.A00.get() != null) {
            WeakReference<R0> weakReference = this.A00;
            if (A01[4].length() == 0) {
                throw new RuntimeException();
            }
            A01[2] = "IO1gKUYJJG6YtU6JnI8y";
            weakReference.get().A0D(str, n92);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2118Xn
    public void ACf(int i10) {
        R0 activityApi = this.A00.get();
        if (activityApi != null) {
            activityApi.finish(i10);
        }
    }
}
