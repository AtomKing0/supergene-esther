package com.applovin.mediation.nativeAds;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.applovin.impl.mediation.nativeAds.MaxNativeAdImpl;
import com.applovin.mediation.MaxAdFormat;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MaxNativeAd extends MaxNativeAdImpl {
    private static final float MINIMUM_STARS_TO_RENDER = 3.0f;
    private final String advertiser;
    private final String body;
    private final String callToAction;
    private final MaxAdFormat format;
    private final MaxNativeAdImage icon;
    private final View iconView;
    private boolean isExpired;
    private final MaxNativeAdImage mainImage;
    private final float mediaContentAspectRatio;
    private final View mediaView;
    private MaxNativeAdView nativeAdView;
    private final View optionsView;
    private final Double starRating;
    private final String title;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private MaxAdFormat f7956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f7957b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f7958c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f7959d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f7960e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private MaxNativeAdImage f7961f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private View f7962g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private View f7963h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private View f7964i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private MaxNativeAdImage f7965j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private float f7966k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private Double f7967l;

        public MaxNativeAd build() {
            return new MaxNativeAd(this);
        }

        public Builder setAdFormat(MaxAdFormat maxAdFormat) {
            this.f7956a = maxAdFormat;
            return this;
        }

        public Builder setAdvertiser(String str) {
            this.f7958c = str;
            return this;
        }

        public Builder setBody(String str) {
            this.f7959d = str;
            return this;
        }

        public Builder setCallToAction(String str) {
            this.f7960e = str;
            return this;
        }

        public Builder setIcon(MaxNativeAdImage maxNativeAdImage) {
            this.f7961f = maxNativeAdImage;
            return this;
        }

        public Builder setIconView(View view) {
            this.f7962g = view;
            return this;
        }

        public Builder setMainImage(MaxNativeAdImage maxNativeAdImage) {
            this.f7965j = maxNativeAdImage;
            return this;
        }

        public Builder setMediaContentAspectRatio(float f10) {
            this.f7966k = f10;
            return this;
        }

        public Builder setMediaView(View view) {
            this.f7964i = view;
            return this;
        }

        public Builder setOptionsView(View view) {
            this.f7963h = view;
            return this;
        }

        public Builder setStarRating(Double d10) {
            this.f7967l = d10;
            return this;
        }

        public Builder setTitle(String str) {
            this.f7957b = str;
            return this;
        }
    }

    public MaxNativeAd(Builder builder) {
        this.format = builder.f7956a;
        this.title = builder.f7957b;
        this.advertiser = builder.f7958c;
        this.body = builder.f7959d;
        this.callToAction = builder.f7960e;
        this.icon = builder.f7961f;
        this.iconView = builder.f7962g;
        this.optionsView = builder.f7963h;
        this.mediaView = builder.f7964i;
        this.mainImage = builder.f7965j;
        this.mediaContentAspectRatio = builder.f7966k;
        Double d10 = builder.f7967l;
        this.starRating = (d10 == null || d10.doubleValue() < 3.0d) ? null : d10;
    }

    @Nullable
    public final String getAdvertiser() {
        return this.advertiser;
    }

    @Nullable
    public final String getBody() {
        return this.body;
    }

    @Nullable
    public final String getCallToAction() {
        return this.callToAction;
    }

    @NonNull
    public final MaxAdFormat getFormat() {
        return this.format;
    }

    @Nullable
    public final MaxNativeAdImage getIcon() {
        return this.icon;
    }

    @Nullable
    public final View getIconView() {
        return this.iconView;
    }

    @Nullable
    public final MaxNativeAdImage getMainImage() {
        return this.mainImage;
    }

    public final float getMediaContentAspectRatio() {
        return this.mediaContentAspectRatio;
    }

    @Nullable
    public final View getMediaView() {
        return this.mediaView;
    }

    @Nullable
    public final View getOptionsView() {
        return this.optionsView;
    }

    @Nullable
    public final Double getStarRating() {
        return this.starRating;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public boolean isContainerClickable() {
        return false;
    }

    public final boolean isExpired() {
        return this.isExpired;
    }

    @UiThread
    public void performClick() {
        Button callToActionButton;
        MaxNativeAdView maxNativeAdView = this.nativeAdView;
        if (maxNativeAdView == null || (callToActionButton = maxNativeAdView.getCallToActionButton()) == null) {
            return;
        }
        callToActionButton.performClick();
    }

    public boolean prepareForInteraction(List<View> list, ViewGroup viewGroup) {
        return false;
    }

    public void setExpired() {
        this.isExpired = true;
    }

    public void setNativeAdView(MaxNativeAdView maxNativeAdView) {
        this.nativeAdView = maxNativeAdView;
    }

    public boolean shouldPrepareViewForInteractionOnMainThread() {
        return true;
    }

    public static class MaxNativeAdImage {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Drawable f7968a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Uri f7969b;

        public MaxNativeAdImage(Drawable drawable) {
            this.f7968a = drawable;
        }

        @Nullable
        public Drawable getDrawable() {
            return this.f7968a;
        }

        @Nullable
        public Uri getUri() {
            return this.f7969b;
        }

        public MaxNativeAdImage(Uri uri) {
            this.f7969b = uri;
        }
    }

    @Deprecated
    public void prepareViewForInteraction(MaxNativeAdView maxNativeAdView) {
    }
}
