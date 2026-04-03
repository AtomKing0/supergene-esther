package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.BannerAdShowListener;
import com.moloco.sdk.publisher.MolocoAd;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final BannerAdShowListener f17897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h0 f17898b;

    public d(@Nullable BannerAdShowListener bannerAdShowListener, @NotNull com.moloco.sdk.internal.services.m appLifecycleTrackerService, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, @NotNull h9.a<com.moloco.sdk.internal.ortb.model.q> provideSdkEvents, @NotNull h9.a<r> provideBUrlData, @NotNull AdFormatType adType) {
        kotlin.jvm.internal.t.i(appLifecycleTrackerService, "appLifecycleTrackerService");
        kotlin.jvm.internal.t.i(customUserEventBuilderService, "customUserEventBuilderService");
        kotlin.jvm.internal.t.i(provideSdkEvents, "provideSdkEvents");
        kotlin.jvm.internal.t.i(provideBUrlData, "provideBUrlData");
        kotlin.jvm.internal.t.i(adType, "adType");
        this.f17897a = bannerAdShowListener;
        this.f17898b = b.a(bannerAdShowListener, appLifecycleTrackerService, customUserEventBuilderService, provideSdkEvents, provideBUrlData, (96 & 32) != 0 ? com.moloco.sdk.internal.w.a() : null, (96 & 64) != 0 ? com.moloco.sdk.internal.h.a() : null, adType);
    }

    @Override // com.moloco.sdk.internal.publisher.h0
    public void a(@NotNull com.moloco.sdk.internal.q internalError) {
        kotlin.jvm.internal.t.i(internalError, "internalError");
        this.f17898b.a(internalError);
    }

    @Nullable
    public final BannerAdShowListener b() {
        return this.f17897a;
    }

    @Override // com.moloco.sdk.internal.publisher.h0
    public void onAdClicked(@NotNull MolocoAd molocoAd) {
        kotlin.jvm.internal.t.i(molocoAd, "molocoAd");
        this.f17898b.onAdClicked(molocoAd);
    }

    @Override // com.moloco.sdk.internal.publisher.h0
    public void onAdHidden(@NotNull MolocoAd molocoAd) {
        kotlin.jvm.internal.t.i(molocoAd, "molocoAd");
        this.f17898b.onAdHidden(molocoAd);
    }

    @Override // com.moloco.sdk.internal.publisher.h0
    public void onAdShowSuccess(@NotNull MolocoAd molocoAd) {
        kotlin.jvm.internal.t.i(molocoAd, "molocoAd");
        this.f17898b.onAdShowSuccess(molocoAd);
    }
}
