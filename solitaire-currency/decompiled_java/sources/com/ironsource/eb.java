package com.ironsource;

import com.ironsource.c3;
import com.ironsource.f3;
import com.ironsource.mediationsdk.logger.IronSourceError;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class eb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final j3 f11913a;

    public eb(@NotNull j3 analytics, @NotNull String adRequestAdId, @NotNull oo adRequestProviderName) {
        kotlin.jvm.internal.t.i(analytics, "analytics");
        kotlin.jvm.internal.t.i(adRequestAdId, "adRequestAdId");
        kotlin.jvm.internal.t.i(adRequestProviderName, "adRequestProviderName");
        this.f11913a = analytics;
        analytics.a(new f3.s(adRequestProviderName.value()), new f3.b(adRequestAdId));
    }

    public final void a() {
        c3.c.f11505a.a().a(this.f11913a);
    }

    public final void a(@NotNull IronSourceError error) {
        kotlin.jvm.internal.t.i(error, "error");
        c3.c.f11505a.a(new f3.j(error.getErrorCode()), new f3.k(error.getErrorMessage()), new f3.f(0L)).a(this.f11913a);
    }
}
