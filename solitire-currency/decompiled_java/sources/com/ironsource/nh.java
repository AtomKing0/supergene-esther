package com.ironsource;

import androidx.media3.extractor.ts.PsExtractor;
import com.unity3d.ironsourceads.interstitial.InterstitialAd;
import java.util.concurrent.Executor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class nh implements y0<InterstitialAd> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final j3 f14131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Executor f14132b;

    public nh(@NotNull j3 analytics, @NotNull Executor callbackExecutor) {
        kotlin.jvm.internal.t.i(analytics, "analytics");
        kotlin.jvm.internal.t.i(callbackExecutor, "callbackExecutor");
        this.f14131a = analytics;
        this.f14132b = callbackExecutor;
    }

    @Override // com.ironsource.y0
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public InterstitialAd a(@NotNull mi adInstance, @NotNull p4 auctionDataReporter) {
        kotlin.jvm.internal.t.i(adInstance, "adInstance");
        kotlin.jvm.internal.t.i(auctionDataReporter, "auctionDataReporter");
        return new InterstitialAd(new ph(adInstance, new x0(new um()), auctionDataReporter, this.f14131a, null, null, null, null, oh.f14250a, PsExtractor.VIDEO_STREAM_MASK, null));
    }
}
