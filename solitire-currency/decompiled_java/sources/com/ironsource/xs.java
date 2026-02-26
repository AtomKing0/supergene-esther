package com.ironsource;

import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.banner.LevelPlayBannerAdViewListener;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class xs implements LevelPlayBannerAdViewListener {
    @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
    public void onAdClicked(@NotNull LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        m5.a().b(et.f11994a.a(adInfo));
    }

    @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
    public /* synthetic */ void onAdCollapsed(LevelPlayAdInfo levelPlayAdInfo) {
        w6.a.b(this, levelPlayAdInfo);
    }

    @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
    public /* synthetic */ void onAdDisplayFailed(LevelPlayAdInfo levelPlayAdInfo, LevelPlayAdError levelPlayAdError) {
        w6.a.c(this, levelPlayAdInfo, levelPlayAdError);
    }

    @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
    public void onAdDisplayed(@NotNull LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        m5.a().f(et.f11994a.a(adInfo));
    }

    @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
    public /* synthetic */ void onAdExpanded(LevelPlayAdInfo levelPlayAdInfo) {
        w6.a.e(this, levelPlayAdInfo);
    }

    @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
    public void onAdLeftApplication(@NotNull LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        m5.a().c(et.f11994a.a(adInfo));
    }

    @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
    public void onAdLoadFailed(@NotNull LevelPlayAdError error) {
        kotlin.jvm.internal.t.i(error, "error");
        m5.a().a(et.f11994a.a(error));
    }

    @Override // com.unity3d.mediation.banner.LevelPlayBannerAdViewListener
    public void onAdLoaded(@NotNull LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        m5.a().d(et.f11994a.a(adInfo));
    }
}
