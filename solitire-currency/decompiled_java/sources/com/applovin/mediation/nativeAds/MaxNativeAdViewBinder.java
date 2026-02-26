package com.applovin.mediation.nativeAds;

import android.view.View;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;

/* JADX INFO: loaded from: classes2.dex */
public class MaxNativeAdViewBinder {

    @IdRes
    protected final int advertiserTextViewId;

    @IdRes
    protected final int bodyTextViewId;

    @IdRes
    protected final int callToActionButtonId;

    @IdRes
    protected final int iconContentViewId;

    @IdRes
    protected final int iconImageViewId;

    @LayoutRes
    protected final int layoutResourceId;
    protected final View mainView;

    @IdRes
    protected final int mediaContentFrameLayoutId;

    @IdRes
    protected final int mediaContentViewGroupId;

    @IdRes
    protected final int optionsContentFrameLayoutId;

    @IdRes
    protected final int optionsContentViewGroupId;

    @IdRes
    protected final int starRatingContentViewGroupId;
    protected final String templateType;

    @IdRes
    protected final int titleTextViewId;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f7987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f7988b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f7989c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f7990d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f7991e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f7992f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f7993g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f7994h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f7995i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f7996j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f7997k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f7998l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f7999m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private String f8000n;

        public Builder(View view) {
            this(-1, view);
        }

        public MaxNativeAdViewBinder build() {
            return new MaxNativeAdViewBinder(this.f7987a, this.f7988b, this.f7989c, this.f7990d, this.f7991e, this.f7992f, this.f7993g, this.f7996j, this.f7994h, this.f7995i, this.f7997k, this.f7998l, this.f7999m, this.f8000n);
        }

        public Builder setAdvertiserTextViewId(@IdRes int i10) {
            this.f7990d = i10;
            return this;
        }

        public Builder setBodyTextViewId(@IdRes int i10) {
            this.f7991e = i10;
            return this;
        }

        public Builder setCallToActionButtonId(@IdRes int i10) {
            this.f7999m = i10;
            return this;
        }

        @Deprecated
        protected Builder setIconContentViewId(@IdRes int i10) {
            this.f7993g = i10;
            return this;
        }

        public Builder setIconImageViewId(@IdRes int i10) {
            this.f7992f = i10;
            return this;
        }

        @Deprecated
        protected Builder setMediaContentFrameLayoutId(@IdRes int i10) {
            this.f7998l = i10;
            return this;
        }

        public Builder setMediaContentViewGroupId(@IdRes int i10) {
            this.f7997k = i10;
            return this;
        }

        @Deprecated
        protected Builder setOptionsContentFrameLayoutId(@IdRes int i10) {
            this.f7995i = i10;
            return this;
        }

        public Builder setOptionsContentViewGroupId(@IdRes int i10) {
            this.f7994h = i10;
            return this;
        }

        public Builder setStarRatingContentViewGroupId(@IdRes int i10) {
            this.f7996j = i10;
            return this;
        }

        protected Builder setTemplateType(String str) {
            this.f8000n = str;
            return this;
        }

        public Builder setTitleTextViewId(@IdRes int i10) {
            this.f7989c = i10;
            return this;
        }

        public Builder(@LayoutRes int i10) {
            this(i10, null);
        }

        private Builder(int i10, View view) {
            this.f7989c = -1;
            this.f7990d = -1;
            this.f7991e = -1;
            this.f7992f = -1;
            this.f7993g = -1;
            this.f7994h = -1;
            this.f7995i = -1;
            this.f7996j = -1;
            this.f7997k = -1;
            this.f7998l = -1;
            this.f7999m = -1;
            this.f7988b = i10;
            this.f7987a = view;
        }
    }

    private MaxNativeAdViewBinder(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, String str) {
        this.mainView = view;
        this.layoutResourceId = i10;
        this.titleTextViewId = i11;
        this.advertiserTextViewId = i12;
        this.bodyTextViewId = i13;
        this.iconImageViewId = i14;
        this.iconContentViewId = i15;
        this.starRatingContentViewGroupId = i16;
        this.optionsContentViewGroupId = i17;
        this.optionsContentFrameLayoutId = i18;
        this.mediaContentViewGroupId = i19;
        this.mediaContentFrameLayoutId = i20;
        this.callToActionButtonId = i21;
        this.templateType = str;
    }
}
