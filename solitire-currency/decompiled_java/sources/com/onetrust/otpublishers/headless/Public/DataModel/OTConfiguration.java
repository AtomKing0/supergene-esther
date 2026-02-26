package com.onetrust.otpublishers.headless.Public.DataModel;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.onetrust.otpublishers.headless.Internal.c;
import com.onetrust.otpublishers.headless.Public.OTBackButtonMode;
import com.onetrust.otpublishers.headless.Public.OTVendorListDismissMode;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class OTConfiguration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, Typeface> f21959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f21961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f21962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f21963e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Drawable f21964f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Drawable f21965g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f21966h;

    public static class OTConfigurationBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashMap<String, Typeface> f21967a = new HashMap<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f21968b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f21969c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f21970d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f21971e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Drawable f21972f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Drawable f21973g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f21974h;

        @NonNull
        public static OTConfigurationBuilder newInstance() {
            return new OTConfigurationBuilder();
        }

        @NonNull
        public OTConfigurationBuilder addOTTypeFace(@NonNull String str, @NonNull Typeface typeface) {
            this.f21967a.put(str, typeface);
            return this;
        }

        @NonNull
        public OTConfiguration build() {
            return new OTConfiguration(this);
        }

        @NonNull
        public OTConfigurationBuilder setBackButton(@NonNull String str) {
            this.f21968b = str;
            return this;
        }

        @NonNull
        public OTConfigurationBuilder setBannerLogo(@NonNull Drawable drawable) {
            this.f21972f = drawable;
            return this;
        }

        @NonNull
        public OTConfigurationBuilder setPCLogo(@NonNull Drawable drawable) {
            this.f21973g = drawable;
            return this;
        }

        @NonNull
        public OTConfigurationBuilder setSyncNotificationView(@NonNull View view) {
            this.f21971e = view;
            return this;
        }

        @NonNull
        public OTConfigurationBuilder setVendorListJourney(@NonNull String str) {
            this.f21969c = str;
            return this;
        }

        @NonNull
        public OTConfigurationBuilder shouldEnableDarkMode(@NonNull String str) {
            this.f21970d = str;
            return this;
        }

        @NonNull
        public OTConfigurationBuilder syncOTUIWithBYOUIMethods(boolean z10) {
            this.f21974h = z10;
            return this;
        }
    }

    public OTConfiguration(@NonNull OTConfigurationBuilder oTConfigurationBuilder) {
        this.f21959a = oTConfigurationBuilder.f21967a;
        this.f21960b = oTConfigurationBuilder.f21968b;
        this.f21961c = oTConfigurationBuilder.f21969c;
        this.f21962d = oTConfigurationBuilder.f21970d;
        this.f21963e = oTConfigurationBuilder.f21971e;
        this.f21964f = oTConfigurationBuilder.f21972f;
        this.f21965g = oTConfigurationBuilder.f21973g;
        this.f21966h = oTConfigurationBuilder.f21974h;
    }

    @Nullable
    public Drawable getBannerLogo() {
        return this.f21964f;
    }

    @Nullable
    public String getDarkModeThemeValue() {
        return this.f21962d;
    }

    @Nullable
    public Typeface getOtTypeFaceMap(@NonNull String str) {
        if (this.f21959a.containsKey(str)) {
            return this.f21959a.get(str);
        }
        return null;
    }

    @Nullable
    public Drawable getPcLogo() {
        return this.f21965g;
    }

    @Nullable
    public View getView() {
        return this.f21963e;
    }

    public boolean isBannerBackButtonCloseBanner() {
        if (c.q(this.f21960b)) {
            return false;
        }
        return OTBackButtonMode.DEFAULT_CONSENT_AND_CLOSE_BANNER.equalsIgnoreCase(this.f21960b);
    }

    public boolean isBannerBackButtonDisMissUI() {
        if (c.q(this.f21960b)) {
            return false;
        }
        return OTBackButtonMode.DISMISS_BANNER.equalsIgnoreCase(this.f21960b);
    }

    public boolean isBannerBackButtonDisabled() {
        return (isBannerBackButtonDisMissUI() || isBannerBackButtonCloseBanner()) ? false : true;
    }

    public boolean isShowConfirmMyChoice() {
        if (c.q(this.f21961c)) {
            return false;
        }
        return OTVendorListDismissMode.SHOW_CONFIRM_MY_CHOICE.equalsIgnoreCase(this.f21961c);
    }

    public boolean issSncOTUIWithBYOUIMethodsEnabled() {
        return this.f21966h;
    }

    @NonNull
    public String toString() {
        return "OTConfig{otTypeFaceMap=" + this.f21959a + "bannerBackButton=" + this.f21960b + "vendorListMode=" + this.f21961c + "darkMode=" + this.f21962d + '}';
    }

    @NonNull
    public HashMap<String, Typeface> getOtTypeFaceMap() {
        return this.f21959a;
    }
}
