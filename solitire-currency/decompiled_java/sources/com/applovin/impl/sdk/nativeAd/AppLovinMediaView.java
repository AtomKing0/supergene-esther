package com.applovin.impl.sdk.nativeAd;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.applovin.impl.a7;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.l4;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.ImageViewUtils;
import com.applovin.sdk.R;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
public class AppLovinMediaView extends FrameLayout {
    protected final ImageView imageView;
    protected final n logger;
    protected final com.applovin.impl.sdk.j sdk;

    public AppLovinMediaView(AppLovinNativeAdImpl appLovinNativeAdImpl, com.applovin.impl.sdk.j jVar, Context context) {
        super(context);
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.sdk = jVar;
        this.logger = jVar.I();
        LayoutInflater.from(context).inflate(R.layout.applovin_native_ad_media_view, (ViewGroup) this, true);
        Uri mainImageUri = appLovinNativeAdImpl.getMainImageUri();
        a7 vastAd = appLovinNativeAdImpl.getVastAd();
        Uri uriP0 = vastAd != null ? vastAd.p0() : null;
        if (mainImageUri == null && uriP0 == null) {
            throw new IllegalStateException("AppLovin native ad missing image AND video resources");
        }
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        if (((Boolean) jVar.a(l4.f5745t2)).booleanValue()) {
            setOnTouchListener(new AppLovinTouchToClickListener(jVar, l4.f5671k0, context, appLovinNativeAdImpl));
        } else {
            setOnClickListener(appLovinNativeAdImpl);
        }
        ImageView imageView = (ImageView) findViewById(R.id.image_view);
        this.imageView = imageView;
        if (mainImageUri != null) {
            ImageViewUtils.setAndDownscaleImageUri(imageView, mainImageUri);
        }
        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
    }

    public void destroy() {
        setOnClickListener(null);
        setOnTouchListener(null);
        removeAllViews();
    }
}
