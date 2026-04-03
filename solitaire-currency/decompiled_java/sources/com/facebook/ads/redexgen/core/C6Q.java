package com.facebook.ads.redexgen.core;

import android.widget.FrameLayout;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6Q, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C6Q extends C2530fg {
    public InterfaceC2388dM A00;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final void A06(NativeAdLayout nativeAdLayout, C2387dL c2387dL, NativeAd nativeAd, C2047Ur c2047Ur) {
        C2201aK c2201aK = new C2201aK(c2387dL);
        MediaView mediaView = new MediaView(c2387dL);
        AdOptionsView adOptionsView = new AdOptionsView(c2387dL, nativeAd, nativeAdLayout);
        c2047Ur.A09(adOptionsView, 28);
        this.A00 = new EP(c2387dL, nativeAd, c2047Ur, C1930Qc.A0L(nativeAd.getInternalNativeAd()).A18(), c2201aK, mediaView, adOptionsView);
        XP.A0K(nativeAdLayout, c2047Ur.A00());
        nativeAd.registerViewForInteraction(nativeAdLayout, mediaView, c2201aK, this.A00.getViewsForInteraction());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        nativeAdLayout.addView(this.A00.getView(), layoutParams);
    }

    @Override // com.facebook.ads.redexgen.core.R8, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A00.unregisterView();
    }
}
