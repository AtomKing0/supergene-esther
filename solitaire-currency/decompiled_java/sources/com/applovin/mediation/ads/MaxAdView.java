package com.applovin.mediation.ads;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.mediation.ads.MaxAdViewImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.q;
import com.applovin.impl.q7;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxAdViewConfiguration;
import com.applovin.sdk.AppLovinSdk;
import com.ironsource.mediationsdk.impressionData.ImpressionData;

/* JADX INFO: loaded from: classes2.dex */
public class MaxAdView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MaxAdViewImpl f7946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f7947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7948c;

    public MaxAdView(String str) {
        this(str, (MaxAdViewConfiguration) null);
    }

    private void a(String str, MaxAdFormat maxAdFormat, MaxAdViewConfiguration maxAdViewConfiguration, int i10, Context context) {
        View view = new View(context.getApplicationContext());
        this.f7947b = view;
        view.setBackgroundColor(0);
        addView(this.f7947b);
        this.f7947b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f7948c = getVisibility();
        this.f7946a = new MaxAdViewImpl(str.trim(), maxAdFormat, maxAdViewConfiguration, this, this.f7947b, context);
        setGravity(i10);
        if (getBackground() instanceof ColorDrawable) {
            setBackgroundColor(((ColorDrawable) getBackground()).getColor());
        }
        super.setBackgroundColor(0);
    }

    public void destroy() {
        this.f7946a.logApiCall("destroy()");
        this.f7946a.destroy();
    }

    public MaxAdFormat getAdFormat() {
        return this.f7946a.getAdFormat();
    }

    public String getAdUnitId() {
        return this.f7946a.getAdUnitId();
    }

    public String getPlacement() {
        this.f7946a.logApiCall("getPlacement()");
        return this.f7946a.getPlacement();
    }

    public void loadAd() {
        this.f7946a.logApiCall("loadAd()");
        this.f7946a.loadAd();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        if (isInEditMode()) {
            return;
        }
        this.f7946a.logApiCall("onWindowVisibilityChanged(visibility=" + i10 + ")");
        if (this.f7946a != null && q7.a(this.f7948c, i10)) {
            this.f7946a.onWindowVisibilityChanged(i10);
        }
        this.f7948c = i10;
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        this.f7946a.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.f7946a.setAdReviewListener(maxAdReviewListener);
    }

    @Override // android.view.View
    public void setAlpha(float f10) {
        this.f7946a.logApiCall("setAlpha(alpha=" + f10 + ")");
        View view = this.f7947b;
        if (view != null) {
            view.setAlpha(f10);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        this.f7946a.logApiCall("setBackgroundColor(color=" + i10 + ")");
        MaxAdViewImpl maxAdViewImpl = this.f7946a;
        if (maxAdViewImpl != null) {
            maxAdViewImpl.setPublisherBackgroundColor(i10);
        }
        View view = this.f7947b;
        if (view != null) {
            view.setBackgroundColor(i10);
        }
    }

    public void setCustomData(String str) {
        this.f7946a.logApiCall("setCustomData(value=" + str + ")");
        this.f7946a.setCustomData(str);
    }

    public void setExtraParameter(String str, String str2) {
        this.f7946a.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f7946a.setExtraParameter(str, str2);
    }

    public void setListener(MaxAdViewAdListener maxAdViewAdListener) {
        this.f7946a.logApiCall("setListener(listener=" + maxAdViewAdListener + ")");
        this.f7946a.setListener(maxAdViewAdListener);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        this.f7946a.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f7946a.setLocalExtraParameter(str, obj);
    }

    public void setPlacement(String str) {
        this.f7946a.logApiCall("setPlacement(placement=" + str + ")");
        this.f7946a.setPlacement(str);
    }

    public void setRequestListener(MaxAdRequestListener maxAdRequestListener) {
        this.f7946a.logApiCall("setRequestListener(listener=" + maxAdRequestListener + ")");
        this.f7946a.setRequestListener(maxAdRequestListener);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        this.f7946a.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f7946a.setRevenueListener(maxAdRevenueListener);
    }

    public void startAutoRefresh() {
        this.f7946a.logApiCall("startAutoRefresh()");
        this.f7946a.startAutoRefresh();
    }

    public void stopAutoRefresh() {
        this.f7946a.logApiCall("stopAutoRefresh()");
        this.f7946a.stopAutoRefresh();
    }

    @Override // android.view.View
    @NonNull
    public String toString() {
        MaxAdViewImpl maxAdViewImpl = this.f7946a;
        return maxAdViewImpl != null ? maxAdViewImpl.toString() : "MaxAdView";
    }

    public MaxAdView(String str, MaxAdFormat maxAdFormat) {
        this(str, maxAdFormat, (MaxAdViewConfiguration) null);
    }

    public MaxAdView(String str, @Nullable MaxAdViewConfiguration maxAdViewConfiguration) {
        this(str, q.a(j.n()), maxAdViewConfiguration);
    }

    public MaxAdView(String str, MaxAdFormat maxAdFormat, @Nullable MaxAdViewConfiguration maxAdViewConfiguration) {
        super(j.n());
        a.logApiCall("MaxAdView", "MaxAdView(adUnitId=" + str + ", adFormat=" + maxAdFormat + ", configuration=" + maxAdViewConfiguration + ")");
        a(str, maxAdFormat, maxAdViewConfiguration, 49, j.n());
    }

    public MaxAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaxAdView(Context context, AttributeSet attributeSet, int i10) {
        MaxAdFormat maxAdFormatA;
        super(context, attributeSet, i10);
        String strA = q.a(context, attributeSet, AppLovinAdView.NAMESPACE, "adUnitId");
        String strA2 = q.a(context, attributeSet, AppLovinAdView.NAMESPACE, ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT);
        if (StringUtils.isValidString(strA2)) {
            maxAdFormatA = MaxAdFormat.formatFromString(strA2);
        } else {
            maxAdFormatA = q.a(context);
        }
        MaxAdFormat maxAdFormat = maxAdFormatA;
        int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 49);
        if (strA != null) {
            if (!TextUtils.isEmpty(strA)) {
                if (isInEditMode()) {
                    a(context);
                    return;
                } else {
                    a(strA, maxAdFormat, null, attributeIntValue, context);
                    return;
                }
            }
            throw new IllegalArgumentException("Empty ad unit ID specified");
        }
        throw new IllegalArgumentException("No ad unit ID specified");
    }

    private void a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i10 = displayMetrics.widthPixels;
        int i11 = displayMetrics.heightPixels;
        TextView textView = new TextView(context);
        textView.setBackgroundColor(Color.rgb(220, 220, 220));
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setText("AppLovin MAX Ad");
        textView.setGravity(17);
        addView(textView, i10, i11);
    }

    @Deprecated
    public MaxAdView(String str, Context context) {
        this(str, AppLovinSdk.getInstance(context), context);
    }

    @Deprecated
    public MaxAdView(String str, AppLovinSdk appLovinSdk, Context context) {
        this(str, q.a(context), context);
    }

    @Deprecated
    public MaxAdView(String str, MaxAdFormat maxAdFormat, Context context) {
        this(str, maxAdFormat, AppLovinSdk.getInstance(context), context);
    }

    @Deprecated
    public MaxAdView(String str, MaxAdFormat maxAdFormat, AppLovinSdk appLovinSdk, Context context) {
        super(context);
        a.logApiCall("MaxAdView", "MaxAdView(adUnitId=" + str + ", adFormat=" + maxAdFormat + ")");
        a(str, maxAdFormat, null, 49, context);
    }
}
