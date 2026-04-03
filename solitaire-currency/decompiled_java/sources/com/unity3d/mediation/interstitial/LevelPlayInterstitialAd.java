package com.unity3d.mediation.interstitial;

import android.app.Activity;
import com.ironsource.ck;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class LevelPlayInterstitialAd {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f23911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final ck f23912b;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        public final boolean isPlacementCapped(@NotNull String placementName) {
            t.i(placementName, "placementName");
            return ck.f11577j.a(placementName);
        }
    }

    public LevelPlayInterstitialAd(@NotNull String adUnitId) {
        t.i(adUnitId, "adUnitId");
        this.f23911a = adUnitId;
        ck ckVarA = ck.b.a();
        this.f23912b = ckVarA;
        ckVarA.a(adUnitId);
    }

    public static final boolean isPlacementCapped(@NotNull String str) {
        return Companion.isPlacementCapped(str);
    }

    public static /* synthetic */ void showAd$default(LevelPlayInterstitialAd levelPlayInterstitialAd, Activity activity, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        levelPlayInterstitialAd.showAd(activity, str);
    }

    @NotNull
    public final String getAdUnitId() {
        return this.f23911a;
    }

    public final boolean isAdReady() {
        return this.f23912b.h();
    }

    public final void loadAd() {
        this.f23912b.i();
    }

    public final void setListener(@Nullable LevelPlayInterstitialAdListener levelPlayInterstitialAdListener) {
        this.f23912b.a(levelPlayInterstitialAdListener);
    }

    public final void showAd(@NotNull Activity activity) {
        t.i(activity, "activity");
        showAd$default(this, activity, null, 2, null);
    }

    public final void showAd(@NotNull Activity activity, @Nullable String str) {
        t.i(activity, "activity");
        this.f23912b.a(activity, str);
    }
}
