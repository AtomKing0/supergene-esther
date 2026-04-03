package com.ironsource;

import android.app.Activity;
import com.ironsource.f1;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class vh implements ci {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ck f15909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private LevelPlayAdInfo f15910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final k9 f15911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f15912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f15913e;

    public vh(@NotNull ck adInternal, @NotNull LevelPlayAdInfo adInfo, @NotNull k9 currentTimeProvider) {
        kotlin.jvm.internal.t.i(adInternal, "adInternal");
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        kotlin.jvm.internal.t.i(currentTimeProvider, "currentTimeProvider");
        this.f15909a = adInternal;
        this.f15910b = adInfo;
        this.f15911c = currentTimeProvider;
        this.f15912d = adInternal.b().f();
        this.f15913e = currentTimeProvider.a();
    }

    private final long b() {
        return this.f15911c.a() - this.f15913e;
    }

    private final f1 c() {
        f8 f8VarA = this.f15909a.c().a(this.f15909a.d());
        return f8VarA.d() ? f1.a.f12013c.a(f8VarA.e()) : new f1.b(false, 1, null);
    }

    @Override // com.ironsource.ci
    @NotNull
    public f1 a() {
        f1 f1VarC = c();
        return ((f1VarC instanceof f1.b) && a(b()) && this.f15912d > 0) ? f1.a.f12013c.a() : f1VarC;
    }

    @Override // com.ironsource.ci
    public void loadAd() {
        long jB = b();
        boolean zA = a(jB);
        a(jB, zA);
        ck ckVar = this.f15909a;
        if (zA) {
            ckVar.j();
        } else {
            ckVar.e(this.f15910b);
        }
    }

    @Override // com.ironsource.ci
    public void onAdInfoChanged(@NotNull LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        this.f15910b = adInfo;
    }

    private final void a(long j10, boolean z10) {
        long j11 = this.f15912d;
        this.f15909a.b().e().g().a(Long.valueOf(j10), j11 >= 0 ? TimeUnit.MILLISECONDS.toMinutes(j11) : -1L, z10);
    }

    @Override // com.ironsource.ci
    public void a(@NotNull Activity activity, @Nullable String str) {
        kotlin.jvm.internal.t.i(activity, "activity");
        Placement placementD = this.f15909a.b().d(str);
        jh jhVarA = this.f15909a.a();
        if (jhVarA == null) {
            this.f15909a.b(new LevelPlayAdError(this.f15909a.d(), IronSourceError.ERROR_IS_SHOW_EXCEPTION, "Internal Error, Illegal state"), this.f15910b);
            return;
        }
        ck ckVar = this.f15909a;
        ckVar.a(new ai(ckVar, this.f15910b));
        jhVarA.a(activity, placementD);
    }

    private final boolean a(long j10) {
        long j11 = this.f15912d;
        return 0 <= j11 && j11 <= j10;
    }
}
