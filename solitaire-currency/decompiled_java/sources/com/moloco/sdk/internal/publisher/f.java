package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdShowListener;
import com.moloco.sdk.publisher.MolocoAd;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class f<T extends AdShowListener> implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final T f17972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.services.m f17973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a f17974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final AdFormatType f17975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ h0 f17976e;

    public f(@NotNull T adShowListener, @NotNull com.moloco.sdk.internal.services.m appLifecycleTrackerService, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, @NotNull h9.a<com.moloco.sdk.internal.ortb.model.q> provideSdkEvents, @NotNull h9.a<r> provideBUrlData, @NotNull AdFormatType adFormatType) {
        kotlin.jvm.internal.t.i(adShowListener, "adShowListener");
        kotlin.jvm.internal.t.i(appLifecycleTrackerService, "appLifecycleTrackerService");
        kotlin.jvm.internal.t.i(customUserEventBuilderService, "customUserEventBuilderService");
        kotlin.jvm.internal.t.i(provideSdkEvents, "provideSdkEvents");
        kotlin.jvm.internal.t.i(provideBUrlData, "provideBUrlData");
        kotlin.jvm.internal.t.i(adFormatType, "adFormatType");
        this.f17972a = adShowListener;
        this.f17973b = appLifecycleTrackerService;
        this.f17974c = customUserEventBuilderService;
        this.f17975d = adFormatType;
        this.f17976e = b.a(adShowListener, appLifecycleTrackerService, customUserEventBuilderService, provideSdkEvents, provideBUrlData, (96 & 32) != 0 ? com.moloco.sdk.internal.w.a() : null, (96 & 64) != 0 ? com.moloco.sdk.internal.h.a() : null, adFormatType);
    }

    @Override // com.moloco.sdk.internal.publisher.h0
    public void a(@NotNull com.moloco.sdk.internal.q internalError) {
        kotlin.jvm.internal.t.i(internalError, "internalError");
        this.f17976e.a(internalError);
    }

    @Override // com.moloco.sdk.internal.publisher.h0
    public void onAdClicked(@NotNull MolocoAd molocoAd) {
        kotlin.jvm.internal.t.i(molocoAd, "molocoAd");
        this.f17976e.onAdClicked(molocoAd);
    }

    @Override // com.moloco.sdk.internal.publisher.h0
    public void onAdHidden(@NotNull MolocoAd molocoAd) {
        kotlin.jvm.internal.t.i(molocoAd, "molocoAd");
        this.f17976e.onAdHidden(molocoAd);
    }

    @Override // com.moloco.sdk.internal.publisher.h0
    public void onAdShowSuccess(@NotNull MolocoAd molocoAd) {
        kotlin.jvm.internal.t.i(molocoAd, "molocoAd");
        this.f17976e.onAdShowSuccess(molocoAd);
    }
}
