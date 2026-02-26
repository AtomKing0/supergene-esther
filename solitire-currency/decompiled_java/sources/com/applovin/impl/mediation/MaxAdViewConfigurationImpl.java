package com.applovin.impl.mediation;

import androidx.annotation.NonNull;
import com.applovin.mediation.MaxAdViewConfiguration;

/* JADX INFO: loaded from: classes2.dex */
public class MaxAdViewConfigurationImpl extends MaxAdViewConfiguration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaxAdViewConfiguration.AdaptiveType f5908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f5909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f5910c;

    public static class BuilderImpl implements MaxAdViewConfiguration.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private MaxAdViewConfiguration.AdaptiveType f5911a = MaxAdViewConfiguration.AdaptiveType.NONE;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f5912b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f5913c = -1;

        @Override // com.applovin.mediation.MaxAdViewConfiguration.Builder
        public MaxAdViewConfiguration build() {
            return new MaxAdViewConfigurationImpl(this);
        }

        public MaxAdViewConfiguration.AdaptiveType getAdaptiveType() {
            return this.f5911a;
        }

        public int getAdaptiveWidth() {
            return this.f5912b;
        }

        public int getInlineMaximumHeight() {
            return this.f5913c;
        }

        @Override // com.applovin.mediation.MaxAdViewConfiguration.Builder
        public MaxAdViewConfiguration.Builder setAdaptiveType(MaxAdViewConfiguration.AdaptiveType adaptiveType) {
            com.applovin.impl.sdk.n.e("MaxAdViewConfiguration", "setAdaptiveType(adaptiveType=" + adaptiveType + ")");
            this.f5911a = adaptiveType;
            return this;
        }

        @Override // com.applovin.mediation.MaxAdViewConfiguration.Builder
        public MaxAdViewConfiguration.Builder setAdaptiveWidth(int i10) {
            com.applovin.impl.sdk.n.e("MaxAdViewConfiguration", "setAdaptiveWidth(adaptiveWidth=" + i10 + ")");
            this.f5912b = i10;
            return this;
        }

        @Override // com.applovin.mediation.MaxAdViewConfiguration.Builder
        public MaxAdViewConfiguration.Builder setInlineMaximumHeight(int i10) {
            com.applovin.impl.sdk.n.e("MaxAdViewConfiguration", "setInlineMaximumHeight(inlineMaximumHeight=" + i10 + ")");
            this.f5913c = i10;
            return this;
        }

        @NonNull
        public String toString() {
            return "MaxAdViewConfiguration.Builder{adaptiveType=" + this.f5911a + ", adaptiveWidth=" + this.f5912b + ", inlineMaximumHeight=" + this.f5913c + "}";
        }
    }

    @Override // com.applovin.mediation.MaxAdViewConfiguration
    public MaxAdViewConfiguration.AdaptiveType getAdaptiveType() {
        return this.f5908a;
    }

    @Override // com.applovin.mediation.MaxAdViewConfiguration
    public int getAdaptiveWidth() {
        return this.f5909b;
    }

    @Override // com.applovin.mediation.MaxAdViewConfiguration
    public int getInlineMaximumHeight() {
        return this.f5910c;
    }

    @NonNull
    public String toString() {
        return "MaxAdViewConfiguration{adaptiveType=" + this.f5908a + ", adaptiveWidth=" + this.f5909b + ", inlineMaximumHeight=" + this.f5910c + "}";
    }

    private MaxAdViewConfigurationImpl(BuilderImpl builderImpl) {
        this.f5908a = builderImpl.f5911a;
        this.f5909b = builderImpl.f5912b;
        this.f5910c = builderImpl.f5913c;
    }
}
