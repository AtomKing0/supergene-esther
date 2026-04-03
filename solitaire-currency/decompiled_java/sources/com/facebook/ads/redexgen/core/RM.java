package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.api.NativeAdViewApi;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RM implements NativeAdViewApi {
    public static View A00(C2387dL c2387dL, NativeAd nativeAd, NativeAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes) {
        if (nativeAdViewAttributes == null) {
            nativeAdViewAttributes = new NativeAdViewAttributes();
        }
        C2047Ur c2047Ur = (C2047Ur) nativeAdViewAttributes.getInternalAttributes();
        C1930Qc internalNativeAd = C1930Qc.A0L(nativeAd.getInternalNativeAd());
        internalNativeAd.A1a(EnumC2048Us.A00(type.getEnumCode()));
        internalNativeAd.A1Z(c2047Ur);
        C6Q c6q = new C6Q();
        NativeAdLayout mediumRectTemplateLayout = new NativeAdLayout(c2387dL, c6q);
        c6q.A06(mediumRectTemplateLayout, c2387dL, nativeAd, c2047Ur);
        mediumRectTemplateLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, (int) (AbstractC2090Wl.A02 * type.getHeight())));
        return mediumRectTemplateLayout;
    }

    public static View A01(C2387dL c2387dL, NativeAd nativeAd, NativeAdViewAttributes nativeAdViewAttributes) {
        if (nativeAdViewAttributes == null) {
            nativeAdViewAttributes = new NativeAdViewAttributes();
        }
        C1930Qc c1930QcA0L = C1930Qc.A0L(nativeAd.getInternalNativeAd());
        C2047Ur c2047Ur = (C2047Ur) nativeAdViewAttributes.getInternalAttributes();
        c1930QcA0L.A1a(EnumC2048Us.A0B);
        c1930QcA0L.A1Z(c2047Ur);
        C6Q c6q = new C6Q();
        NativeAdLayout nativeAdLayout = new NativeAdLayout(c2387dL, c6q);
        c6q.A06(nativeAdLayout, c2387dL, nativeAd, c2047Ur);
        return nativeAdLayout;
    }

    @Override // com.facebook.ads.internal.api.NativeAdViewApi
    public final View render(Context context, NativeAd nativeAd) {
        return render(context, nativeAd, (NativeAdViewAttributes) null);
    }

    @Override // com.facebook.ads.internal.api.NativeAdViewApi
    public final View render(Context context, NativeAd nativeAd, NativeAdView.Type type) {
        return render(context, nativeAd, type, null);
    }

    @Override // com.facebook.ads.internal.api.NativeAdViewApi
    public final View render(Context context, NativeAd nativeAd, NativeAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes) {
        try {
            return A00(RB.A03(context), nativeAd, type, nativeAdViewAttributes);
        } catch (Throwable th) {
            return YB.A00(RB.A03(context), th);
        }
    }

    @Override // com.facebook.ads.internal.api.NativeAdViewApi
    public final View render(Context context, NativeAd nativeAd, NativeAdViewAttributes nativeAdViewAttributes) {
        C2387dL contextWrapper;
        try {
            if (context instanceof C2387dL) {
                contextWrapper = (C2387dL) context;
            } else {
                contextWrapper = RB.A03(context);
            }
            return A01(contextWrapper, nativeAd, nativeAdViewAttributes);
        } catch (Throwable th) {
            return YB.A00(RB.A03(context), th);
        }
    }
}
