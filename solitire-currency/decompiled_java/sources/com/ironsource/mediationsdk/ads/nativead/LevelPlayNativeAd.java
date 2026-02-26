package com.ironsource.mediationsdk.ads.nativead;

import android.app.Activity;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.i9;
import com.ironsource.mediationsdk.ads.nativead.LevelPlayNativeAd;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdInterface;
import com.ironsource.mediationsdk.ads.nativead.internal.InternalNativeAdListener;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.p;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sl;
import com.ironsource.ul;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class LevelPlayNativeAd implements NativeAdInterface, NativeAdDataInterface, InternalNativeAdListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private String f13284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private Placement f13285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private LevelPlayNativeAdListener f13286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private sl f13287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private AdapterNativeAdData f13288e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private AdapterNativeAdViewBinder f13289f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final AtomicBoolean f13290g;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private String f13291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private LevelPlayNativeAdListener f13292b;

        @NotNull
        public final LevelPlayNativeAd build() {
            return new LevelPlayNativeAd(this, null);
        }

        @Nullable
        public final LevelPlayNativeAdListener getMListener$mediationsdk_release() {
            return this.f13292b;
        }

        @Nullable
        public final String getMPlacementName$mediationsdk_release() {
            return this.f13291a;
        }

        public final void setMListener$mediationsdk_release(@Nullable LevelPlayNativeAdListener levelPlayNativeAdListener) {
            this.f13292b = levelPlayNativeAdListener;
        }

        public final void setMPlacementName$mediationsdk_release(@Nullable String str) {
            this.f13291a = str;
        }

        @NotNull
        public final Builder withActivity(@Nullable Activity activity) {
            ContextProvider.getInstance().updateActivity(activity);
            IronLog ironLog = IronLog.INTERNAL;
            StringBuilder sb = new StringBuilder();
            sb.append("activity is updated to: ");
            sb.append(activity != null ? activity.hashCode() : 0);
            ironLog.verbose(sb.toString());
            return this;
        }

        @NotNull
        public final Builder withListener(@NotNull LevelPlayNativeAdListener listener) {
            t.i(listener, "listener");
            this.f13292b = listener;
            return this;
        }

        @NotNull
        public final Builder withPlacementName(@Nullable String str) {
            this.f13291a = str;
            return this;
        }
    }

    private LevelPlayNativeAd(Builder builder) {
        this.f13290g = new AtomicBoolean(false);
        this.f13284a = builder.getMPlacementName$mediationsdk_release();
        this.f13286c = builder.getMListener$mediationsdk_release();
    }

    private final void a() {
        LevelPlayNativeAdListener levelPlayNativeAdListener = this.f13286c;
        if (levelPlayNativeAdListener != null) {
            levelPlayNativeAdListener.onAdLoadFailed(this, ErrorBuilder.buildInitFailedError("init() has failed", IronSourceConstants.NATIVE_AD_UNIT));
        }
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdInterface
    public void destroyAd() {
        IronLog.API.info(String.valueOf(this));
        try {
            sl slVar = this.f13287d;
            if (slVar != null) {
                slVar.M();
            }
        } catch (Throwable th) {
            i9.d().a(th);
            IronLog.API.error("destroyNativeAd()");
        }
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    @Nullable
    public String getAdvertiser() {
        AdapterNativeAdData adapterNativeAdData = this.f13288e;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getAdvertiser();
        }
        return null;
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    @Nullable
    public String getBody() {
        AdapterNativeAdData adapterNativeAdData = this.f13288e;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getBody();
        }
        return null;
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    @Nullable
    public String getCallToAction() {
        AdapterNativeAdData adapterNativeAdData = this.f13288e;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getCallToAction();
        }
        return null;
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    @Nullable
    public NativeAdDataInterface.Image getIcon() {
        AdapterNativeAdData adapterNativeAdData = this.f13288e;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getIcon();
        }
        return null;
    }

    @Nullable
    public final AdapterNativeAdViewBinder getNativeAdViewBinder() {
        return this.f13289f;
    }

    @Nullable
    public final UUID getObjectId() {
        sl slVar = this.f13287d;
        if (slVar != null) {
            return slVar.k();
        }
        return null;
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface
    @Nullable
    public String getTitle() {
        AdapterNativeAdData adapterNativeAdData = this.f13288e;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getTitle();
        }
        return null;
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdInterface
    public void loadAd() {
        IronLog.API.info(String.valueOf(this));
        String initError = p.m().e();
        t.h(initError, "initError");
        if (!(initError.length() > 0)) {
            IronSourceThreadManager.INSTANCE.getInitHandler().post(new Runnable() { // from class: i6.a
                @Override // java.lang.Runnable
                public final void run() {
                    LevelPlayNativeAd.a(this.f26617a);
                }
            });
            return;
        }
        LevelPlayNativeAdListener levelPlayNativeAdListener = this.f13286c;
        if (levelPlayNativeAdListener != null) {
            levelPlayNativeAdListener.onAdLoadFailed(this, ErrorBuilder.buildInitFailedError("loadAd(): " + initError, IronSourceConstants.NATIVE_AD_UNIT));
        }
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.internal.InternalNativeAdListener
    public void onNativeAdClicked(@Nullable final AdInfo adInfo) {
        IronLog.CALLBACK.info(String.valueOf(this));
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new Runnable() { // from class: i6.e
            @Override // java.lang.Runnable
            public final void run() {
                LevelPlayNativeAd.a(this.f26626a, adInfo);
            }
        }, 0L, 2, null);
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.internal.InternalNativeAdListener
    public void onNativeAdImpression(@Nullable final AdInfo adInfo) {
        IronLog.CALLBACK.info(String.valueOf(this));
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new Runnable() { // from class: i6.b
            @Override // java.lang.Runnable
            public final void run() {
                LevelPlayNativeAd.b(this.f26618a, adInfo);
            }
        }, 0L, 2, null);
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.internal.InternalNativeAdListener
    public void onNativeAdLoadFailed(@Nullable final IronSourceError ironSourceError) {
        IronLog.CALLBACK.info(String.valueOf(this));
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new Runnable() { // from class: i6.d
            @Override // java.lang.Runnable
            public final void run() {
                LevelPlayNativeAd.a(this.f26624a, ironSourceError);
            }
        }, 0L, 2, null);
    }

    @Override // com.ironsource.mediationsdk.ads.nativead.internal.InternalNativeAdListener
    public void onNativeAdLoaded(@Nullable final AdInfo adInfo, @NotNull final AdapterNativeAdData adapterNativeAdData, @NotNull final AdapterNativeAdViewBinder nativeAdViewBinder) {
        t.i(adapterNativeAdData, "adapterNativeAdData");
        t.i(nativeAdViewBinder, "nativeAdViewBinder");
        IronLog.CALLBACK.info(String.valueOf(this));
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new Runnable() { // from class: i6.c
            @Override // java.lang.Runnable
            public final void run() {
                LevelPlayNativeAd.a(this.f26620a, adapterNativeAdData, nativeAdViewBinder, adInfo);
            }
        }, 0L, 2, null);
    }

    public final void setListener(@Nullable LevelPlayNativeAdListener levelPlayNativeAdListener) {
        this.f13286c = levelPlayNativeAdListener;
    }

    public /* synthetic */ LevelPlayNativeAd(Builder builder, k kVar) {
        this(builder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LevelPlayNativeAd this$0) {
        k0 k0Var;
        t.i(this$0, "this$0");
        this$0.b();
        sl slVar = this$0.f13287d;
        if (slVar != null) {
            slVar.a(this$0.f13285b);
            k0Var = k0.f35197a;
        } else {
            k0Var = null;
        }
        if (k0Var == null) {
            this$0.a();
        }
    }

    private final void b() {
        if (this.f13290g.compareAndSet(false, true)) {
            sl slVarF = p.m().f();
            this.f13287d = slVarF;
            if (slVarF != null) {
                slVarF.a(this);
                ul ulVarN = p.m().n(this.f13284a);
                t.h(ulVarN, "getInstance().getNativeAdPlacement(mPlacementName)");
                this.f13285b = new Placement(ulVarN);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LevelPlayNativeAd this$0, AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder nativeAdViewBinder, AdInfo adInfo) {
        t.i(this$0, "this$0");
        t.i(adapterNativeAdData, "$adapterNativeAdData");
        t.i(nativeAdViewBinder, "$nativeAdViewBinder");
        this$0.f13288e = adapterNativeAdData;
        this$0.f13289f = nativeAdViewBinder;
        LevelPlayNativeAdListener levelPlayNativeAdListener = this$0.f13286c;
        if (levelPlayNativeAdListener != null) {
            levelPlayNativeAdListener.onAdLoaded(this$0, adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LevelPlayNativeAd this$0, AdInfo adInfo) {
        t.i(this$0, "this$0");
        LevelPlayNativeAdListener levelPlayNativeAdListener = this$0.f13286c;
        if (levelPlayNativeAdListener != null) {
            levelPlayNativeAdListener.onAdImpression(this$0, adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LevelPlayNativeAd this$0, AdInfo adInfo) {
        t.i(this$0, "this$0");
        LevelPlayNativeAdListener levelPlayNativeAdListener = this$0.f13286c;
        if (levelPlayNativeAdListener != null) {
            levelPlayNativeAdListener.onAdClicked(this$0, adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LevelPlayNativeAd this$0, IronSourceError ironSourceError) {
        t.i(this$0, "this$0");
        LevelPlayNativeAdListener levelPlayNativeAdListener = this$0.f13286c;
        if (levelPlayNativeAdListener != null) {
            levelPlayNativeAdListener.onAdLoadFailed(this$0, ironSourceError);
        }
    }
}
