package com.ironsource;

import com.ironsource.environment.ContextProvider;
import com.ironsource.j4;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public class j5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final p2 f12702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final s1 f12703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final ta f12704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final com.ironsource.mediationsdk.e f12705d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final w4 f12706e;

    public static final class a implements j4.d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ k5 f12708b;

        a(k5 k5Var) {
            this.f12708b = k5Var;
        }

        @Override // com.ironsource.j4.d
        public void a(@NotNull j4 auction) {
            kotlin.jvm.internal.t.i(auction, "auction");
            j5.this.b(auction, this.f12708b);
        }

        @Override // com.ironsource.j4.d
        public void a(@NotNull j4 auction, @NotNull String error) {
            kotlin.jvm.internal.t.i(auction, "auction");
            kotlin.jvm.internal.t.i(error, "error");
            j5.this.b(auction, this.f12708b);
        }
    }

    public static final class b extends yp {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ k5 f12710b;

        b(k5 k5Var) {
            this.f12710b = k5Var;
        }

        @Override // com.ironsource.yp
        public void a() {
            j5.this.a(this.f12710b);
        }
    }

    public j5(@NotNull p2 adTools, @NotNull s1 adUnitData) {
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(adUnitData, "adUnitData");
        this.f12702a = adTools;
        this.f12703b = adUnitData;
        this.f12704c = new ta();
        h5 h5VarE = adUnitData.e();
        String sessionId = IronSourceUtils.getSessionId();
        kotlin.jvm.internal.t.h(sessionId, "getSessionId()");
        com.ironsource.mediationsdk.e eVar = new com.ironsource.mediationsdk.e(new com.ironsource.mediationsdk.f(h5VarE, sessionId));
        this.f12705d = eVar;
        this.f12706e = new w4(adTools, eVar);
    }

    private final com.ironsource.mediationsdk.i a(j4 j4Var, int i10) {
        com.ironsource.mediationsdk.i iVar = new com.ironsource.mediationsdk.i(this.f12703b.b().a());
        iVar.b(IronSourceUtils.isEncryptedResponse());
        iVar.a(j4Var.b().a());
        iVar.a(j4Var.b().b());
        iVar.a(this.f12702a.i());
        iVar.a(i10);
        iVar.a(this.f12702a.m());
        ts tsVarF = this.f12703b.b().f();
        iVar.e(tsVarF != null ? tsVarF.b() : false);
        z4 z4VarJ = this.f12702a.j();
        if (z4VarJ != null) {
            z4VarJ.a(iVar);
        }
        return iVar;
    }

    @NotNull
    public final w4 b() {
        return this.f12706e;
    }

    private final String a() {
        return k1.a(this.f12702a, (String) null, (String) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(j4 j4Var, k5 k5Var) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("auction waterfallString = " + ((Object) j4Var.b().c())));
        if (j4Var.e()) {
            this.f12702a.e().b().b(j4Var.b().c().toString());
            this.f12705d.a(ContextProvider.getInstance().getApplicationContext(), a(j4Var, this.f12702a.g()), k5Var);
        } else {
            ironLog.verbose(a("auction failed - no candidates"));
            this.f12702a.e().b().a(1005, "No candidates available for auctioning");
            k5Var.a(t1.e(this.f12703b.b().a()), "no available ad to load");
        }
    }

    private final String a(String str) {
        return k1.a(this.f12702a, str, (String) null, 2, (Object) null);
    }

    public void b(@NotNull k5 completionListener) {
        kotlin.jvm.internal.t.i(completionListener, "completionListener");
        IronLog.INTERNAL.verbose(a());
        long jK = this.f12703b.e().k() - ta.a(this.f12704c);
        if (jK > 0) {
            this.f12702a.a((yp) new b(completionListener), jK);
        } else {
            a(completionListener);
        }
    }

    private final void a(j4 j4Var, k5 k5Var) {
        if (j4Var.d()) {
            j4Var.a(new a(k5Var));
        } else {
            b(j4Var, k5Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(k5 k5Var) {
        IronLog.INTERNAL.verbose(a());
        this.f12702a.e().b().a();
        j4 j4Var = new j4(this.f12702a, this.f12703b);
        if (this.f12703b.f()) {
            a(j4Var, k5Var);
        } else {
            b(j4Var, k5Var);
        }
    }
}
