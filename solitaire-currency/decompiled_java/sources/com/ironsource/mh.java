package com.ironsource;

import android.app.Activity;
import com.ironsource.f1;
import com.ironsource.mediationsdk.IronSource;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class mh implements ci {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ck f14007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final pg f14008b;

    public mh(@NotNull ck adInternal) {
        kotlin.jvm.internal.t.i(adInternal, "adInternal");
        this.f14007a = adInternal;
        this.f14008b = el.f11917p.d().n();
    }

    private final jh b() {
        jh jhVarA = this.f14007a.a();
        if (jhVarA != null) {
            return jhVarA;
        }
        zh zhVar = new zh(this.f14007a.d(), this.f14008b.a());
        this.f14007a.b().e().a(new v1(this.f14007a.b(), zhVar));
        kh khVarE = this.f14007a.e();
        ck ckVar = this.f14007a;
        jh jhVarA2 = khVarE.a(ckVar, ckVar.b(), zhVar);
        this.f14007a.a(jhVarA2);
        return jhVarA2;
    }

    private final boolean c() {
        if (this.f14007a.d().length() == 0) {
            this.f14007a.a(new LevelPlayAdError(this.f14007a.d(), LevelPlayAdError.ERROR_CODE_NO_AD_UNIT_ID_SPECIFIED, "Ad unit ID should be specified"));
            return false;
        }
        if (!this.f14007a.b().h()) {
            this.f14007a.a(new LevelPlayAdError(this.f14007a.d(), LevelPlayAdError.ERROR_CODE_LOAD_BEFORE_INIT_SUCCESS_CALLBACK, "Load must be called after init success callback"));
            return false;
        }
        ak akVarA = this.f14007a.g().r().a();
        if (akVarA != null && akVarA.a(this.f14007a.d(), LevelPlay.AdFormat.INTERSTITIAL)) {
            return true;
        }
        this.f14007a.b(new LevelPlayAdError(this.f14007a.d(), LevelPlayAdError.ERROR_CODE_INVALID_AD_UNIT_ID, "Invalid ad unit id"));
        return false;
    }

    @Override // com.ironsource.ci
    @NotNull
    public f1 a() {
        return new f1.a(false, "load ad was not called", 1, null);
    }

    @Override // com.ironsource.ci
    public void loadAd() {
        if (c()) {
            this.f14007a.a(b());
            this.f14007a.j();
        }
    }

    @Override // com.ironsource.ci
    public /* synthetic */ void onAdInfoChanged(LevelPlayAdInfo levelPlayAdInfo) {
        ev.a(this, levelPlayAdInfo);
    }

    @Override // com.ironsource.ci
    public void a(@NotNull Activity activity, @Nullable String str) {
        kotlin.jvm.internal.t.i(activity, "activity");
        LevelPlayAdError levelPlayAdError = new LevelPlayAdError(this.f14007a.d(), LevelPlayAdError.ERROR_CODE_SHOW_BEFORE_LOAD_SUCCESS_CALLBACK, "Show called before load success");
        String strD = this.f14007a.d();
        String string = IronSource.AD_UNIT.INTERSTITIAL.toString();
        kotlin.jvm.internal.t.h(string, "INTERSTITIAL.toString()");
        this.f14007a.a(levelPlayAdError, new LevelPlayAdInfo(strD, string, null, null, 12, null));
    }
}
