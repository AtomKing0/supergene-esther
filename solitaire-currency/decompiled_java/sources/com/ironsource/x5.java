package com.ironsource;

import androidx.media3.extractor.ts.PsExtractor;
import com.unity3d.ironsourceads.banner.BannerAdView;
import java.util.concurrent.Executor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class x5 implements w5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final j3 f16135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Executor f16136b;

    public x5(@NotNull j3 analytics, @NotNull Executor callbackExecutor) {
        kotlin.jvm.internal.t.i(analytics, "analytics");
        kotlin.jvm.internal.t.i(callbackExecutor, "callbackExecutor");
        this.f16135a = analytics;
        this.f16136b = callbackExecutor;
    }

    @Override // com.ironsource.w5
    @NotNull
    public BannerAdView a(@NotNull mi adInstance, @NotNull jf adContainer, @NotNull p4 auctionDataReporter) {
        kotlin.jvm.internal.t.i(adInstance, "adInstance");
        kotlin.jvm.internal.t.i(adContainer, "adContainer");
        kotlin.jvm.internal.t.i(auctionDataReporter, "auctionDataReporter");
        return new BannerAdView(new i6(adInstance, adContainer, auctionDataReporter, this.f16135a, null, null, null, null, PsExtractor.VIDEO_STREAM_MASK, null));
    }
}
