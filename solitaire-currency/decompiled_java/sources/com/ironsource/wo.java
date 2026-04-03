package com.ironsource;

import androidx.media3.extractor.ts.PsExtractor;
import com.unity3d.ironsourceads.rewarded.RewardedAd;
import java.util.concurrent.Executor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class wo implements y0<RewardedAd> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final j3 f16043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Executor f16044b;

    public wo(@NotNull j3 analytics, @NotNull Executor callbackExecutor) {
        kotlin.jvm.internal.t.i(analytics, "analytics");
        kotlin.jvm.internal.t.i(callbackExecutor, "callbackExecutor");
        this.f16043a = analytics;
        this.f16044b = callbackExecutor;
    }

    @Override // com.ironsource.y0
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RewardedAd a(@NotNull mi adInstance, @NotNull p4 auctionDataReporter) {
        kotlin.jvm.internal.t.i(adInstance, "adInstance");
        kotlin.jvm.internal.t.i(auctionDataReporter, "auctionDataReporter");
        return new RewardedAd(new zo(adInstance, new x0(new um()), auctionDataReporter, this.f16043a, null, null, null, null, xo.f16200a, PsExtractor.VIDEO_STREAM_MASK, null));
    }
}
