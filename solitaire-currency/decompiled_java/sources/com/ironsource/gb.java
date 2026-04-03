package com.ironsource;

import com.ironsource.c3;
import com.ironsource.f3;
import com.ironsource.mediationsdk.logger.IronSourceError;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class gb implements tk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final IronSourceError f12231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final y6 f12232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final j3 f12233c;

    public gb(@NotNull IronSourceError error, @NotNull y6 adLoadTaskListener, @NotNull j3 analytics) {
        kotlin.jvm.internal.t.i(error, "error");
        kotlin.jvm.internal.t.i(adLoadTaskListener, "adLoadTaskListener");
        kotlin.jvm.internal.t.i(analytics, "analytics");
        this.f12231a = error;
        this.f12232b = adLoadTaskListener;
        this.f12233c = analytics;
    }

    @NotNull
    public final IronSourceError a() {
        return this.f12231a;
    }

    @Override // com.ironsource.tk
    public void start() {
        c3.c.a aVar = c3.c.f11505a;
        aVar.a().a(this.f12233c);
        aVar.a(new f3.j(this.f12231a.getErrorCode()), new f3.k(this.f12231a.getErrorMessage()), new f3.f(0L)).a(this.f12233c);
        this.f12232b.onAdLoadFailed(this.f12231a);
    }
}
