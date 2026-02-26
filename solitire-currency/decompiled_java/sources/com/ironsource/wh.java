package com.ironsource;

import android.app.Activity;
import com.ironsource.f1;
import com.ironsource.mediationsdk.IronSource;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class wh implements ci {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ck f16039a;

    public wh(@NotNull ck adInternal) {
        kotlin.jvm.internal.t.i(adInternal, "adInternal");
        this.f16039a = adInternal;
    }

    @Override // com.ironsource.ci
    @NotNull
    public f1 a() {
        return new f1.a(false, "Ad is loading", 1, null);
    }

    @Override // com.ironsource.ci
    public void loadAd() {
        this.f16039a.b(new LevelPlayAdError(this.f16039a.d(), LevelPlayAdError.ERROR_CODE_IS_LOAD_FAILED_ALREADY_CALLED, "Load is already called"));
    }

    @Override // com.ironsource.ci
    public /* synthetic */ void onAdInfoChanged(LevelPlayAdInfo levelPlayAdInfo) {
        ev.a(this, levelPlayAdInfo);
    }

    @Override // com.ironsource.ci
    public void a(@NotNull Activity activity, @Nullable String str) {
        kotlin.jvm.internal.t.i(activity, "activity");
        LevelPlayAdError levelPlayAdError = new LevelPlayAdError(this.f16039a.d(), LevelPlayAdError.ERROR_CODE_SHOW_BEFORE_LOAD_SUCCESS_CALLBACK, "Show is called while loading ad");
        String strD = this.f16039a.d();
        String string = IronSource.AD_UNIT.INTERSTITIAL.toString();
        kotlin.jvm.internal.t.h(string, "INTERSTITIAL.toString()");
        this.f16039a.b(levelPlayAdError, new LevelPlayAdInfo(strD, string, null, null, 12, null));
    }
}
