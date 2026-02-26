package com.vungle.ads;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: VungleAds.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class VungleAds {

    @NotNull
    public static final String TAG = "VungleAds";

    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    private static com.vungle.ads.internal.v vungleInternal = new com.vungle.ads.internal.v();

    @NotNull
    private static com.vungle.ads.internal.s initializer = new com.vungle.ads.internal.s();

    @NotNull
    public static final o7.c firstPartyData = new o7.c();

    /* JADX INFO: compiled from: VungleAds.kt */
    @Keep
    public enum WrapperFramework {
        admob,
        air,
        cocos2dx,
        corona,
        dfp,
        heyzap,
        marmalade,
        mopub,
        unity,
        fyber,
        ironsource,
        upsight,
        appodeal,
        aerserv,
        adtoapp,
        tapdaq,
        vunglehbs,
        max,
        none
    }

    /* JADX INFO: compiled from: VungleAds.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final void deInit$vungle_ads_release() {
            VungleAds.initializer.deInit$vungle_ads_release();
        }

        @Nullable
        public final String getBiddingToken(@NotNull Context context) {
            kotlin.jvm.internal.t.i(context, "context");
            return VungleAds.vungleInternal.getAvailableBidTokens(context);
        }

        @NotNull
        public final String getSdkVersion() {
            return VungleAds.vungleInternal.getSdkVersion();
        }

        public final void init(@NotNull Context appContext, @NotNull String appId, @NotNull l0 callback) {
            kotlin.jvm.internal.t.i(appContext, "context");
            kotlin.jvm.internal.t.i(appId, "appId");
            kotlin.jvm.internal.t.i(callback, "callback");
            if (!(appContext instanceof Application)) {
                appContext = appContext.getApplicationContext();
            }
            com.vungle.ads.internal.s sVar = VungleAds.initializer;
            kotlin.jvm.internal.t.h(appContext, "appContext");
            sVar.init(appId, appContext, callback);
        }

        public final boolean isInitialized() {
            return VungleAds.initializer.isInitialized();
        }

        public final boolean isInline(@NotNull String placementId) {
            kotlin.jvm.internal.t.i(placementId, "placementId");
            com.vungle.ads.internal.model.j placement = com.vungle.ads.internal.k.INSTANCE.getPlacement(placementId);
            if (placement != null) {
                return placement.isInline();
            }
            return false;
        }

        public final void setIntegrationName(@NotNull WrapperFramework wrapperFramework, @NotNull String wrapperFrameworkVersion) {
            kotlin.jvm.internal.t.i(wrapperFramework, "wrapperFramework");
            kotlin.jvm.internal.t.i(wrapperFrameworkVersion, "wrapperFrameworkVersion");
            VungleAds.initializer.setIntegrationName(wrapperFramework, wrapperFrameworkVersion);
        }

        public final void getBiddingToken(@NotNull Context context, @NotNull e0 callback) {
            kotlin.jvm.internal.t.i(context, "context");
            kotlin.jvm.internal.t.i(callback, "callback");
            VungleAds.vungleInternal.getAvailableBidTokensAsync(context, callback);
        }
    }

    @Nullable
    public static final String getBiddingToken(@NotNull Context context) {
        return Companion.getBiddingToken(context);
    }

    @NotNull
    public static final String getSdkVersion() {
        return Companion.getSdkVersion();
    }

    public static final void init(@NotNull Context context, @NotNull String str, @NotNull l0 l0Var) {
        Companion.init(context, str, l0Var);
    }

    public static final boolean isInitialized() {
        return Companion.isInitialized();
    }

    public static final boolean isInline(@NotNull String str) {
        return Companion.isInline(str);
    }

    public static final void setIntegrationName(@NotNull WrapperFramework wrapperFramework, @NotNull String str) {
        Companion.setIntegrationName(wrapperFramework, str);
    }

    public static final void getBiddingToken(@NotNull Context context, @NotNull e0 e0Var) {
        Companion.getBiddingToken(context, e0Var);
    }
}
