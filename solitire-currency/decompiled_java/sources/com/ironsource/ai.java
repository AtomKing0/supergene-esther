package com.ironsource;

import android.app.Activity;
import com.ironsource.f1;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ai implements ci {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ck f11296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final LevelPlayAdInfo f11297b;

    public ai(@NotNull ck adInternal, @NotNull LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(adInternal, "adInternal");
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        this.f11296a = adInternal;
        this.f11297b = adInfo;
    }

    @Override // com.ironsource.ci
    @NotNull
    public f1 a() {
        return new f1.a(false, "ad is showing", 1, null);
    }

    @Override // com.ironsource.ci
    public void loadAd() {
        this.f11296a.b(new LevelPlayAdError(this.f11296a.d(), LevelPlayAdError.ERROR_CODE_LOAD_WHILE_SHOW, "Load is called while ad is showing"));
    }

    @Override // com.ironsource.ci
    public /* synthetic */ void onAdInfoChanged(LevelPlayAdInfo levelPlayAdInfo) {
        ev.a(this, levelPlayAdInfo);
    }

    @Override // com.ironsource.ci
    public void a(@NotNull Activity activity, @Nullable String str) {
        kotlin.jvm.internal.t.i(activity, "activity");
        this.f11296a.b(new LevelPlayAdError(this.f11296a.d(), LevelPlayAdError.ERROR_CODE_SHOW_WHILE_SHOW, "Ad is already showing"), this.f11297b);
    }
}
