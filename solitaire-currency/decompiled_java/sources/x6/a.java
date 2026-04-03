package x6;

import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a {
    public static void a(LevelPlayInterstitialAdListener levelPlayInterstitialAdListener, @NotNull LevelPlayAdInfo adInfo) {
        t.i(adInfo, "adInfo");
    }

    public static void b(LevelPlayInterstitialAdListener levelPlayInterstitialAdListener, @NotNull LevelPlayAdInfo adInfo) {
        t.i(adInfo, "adInfo");
    }

    public static void c(LevelPlayInterstitialAdListener levelPlayInterstitialAdListener, @NotNull LevelPlayAdError error, @NotNull LevelPlayAdInfo adInfo) {
        t.i(error, "error");
        t.i(adInfo, "adInfo");
    }

    public static void d(LevelPlayInterstitialAdListener levelPlayInterstitialAdListener, @NotNull LevelPlayAdInfo adInfo) {
        t.i(adInfo, "adInfo");
    }
}
