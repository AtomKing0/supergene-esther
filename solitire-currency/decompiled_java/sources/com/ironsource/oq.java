package com.ironsource;

import android.content.Context;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.oq;
import com.ironsource.zn;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class oq {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static fr f14256b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private static bq f14262h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private static dq f14263i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f14264j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static long f14265k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final oq f14255a = new oq();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final v8.l f14257c = v8.n.a(a.f14266a);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f14258d = oq.class.getSimpleName();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final sq f14259e = new sq();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final ar f14260f = new ar();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private static final List<hq> f14261g = new ArrayList();

    static final class a extends kotlin.jvm.internal.v implements h9.a<sd> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f14266a = new a();

        a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final sd invoke() {
            return el.f11917p.d().t();
        }
    }

    public static final class b implements hq {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f14267a;

        b(Context context) {
            this.f14267a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(Context applicationContext, bq sdkConfig) {
            kotlin.jvm.internal.t.i(sdkConfig, "$sdkConfig");
            oq oqVar = oq.f14255a;
            kotlin.jvm.internal.t.h(applicationContext, "applicationContext");
            oqVar.a(applicationContext, sdkConfig);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(dq error) {
            kotlin.jvm.internal.t.i(error, "$error");
            oq.f14255a.a(error);
        }

        @Override // com.ironsource.hq
        public void a(@NotNull final bq sdkConfig) {
            kotlin.jvm.internal.t.i(sdkConfig, "sdkConfig");
            sq sqVar = oq.f14259e;
            final Context context = this.f14267a;
            sqVar.a(new Runnable() { // from class: com.ironsource.jz
                @Override // java.lang.Runnable
                public final void run() {
                    oq.b.a(context, sdkConfig);
                }
            });
        }

        @Override // com.ironsource.hq
        public void a(@NotNull final dq error) {
            kotlin.jvm.internal.t.i(error, "error");
            oq.f14259e.a(new Runnable() { // from class: com.ironsource.iz
                @Override // java.lang.Runnable
                public final void run() {
                    oq.b.b(error);
                }
            });
        }
    }

    private oq() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Context context, bq bqVar) {
        b(bqVar);
        d4 d4VarA = bqVar.a();
        ja jaVar = ja.f12717a;
        jaVar.c(d4VarA.g());
        el.f11917p.a().v().a(d4VarA.c());
        jaVar.a(d4VarA.f());
        jaVar.a(d4VarA.j());
        IronSourceThreadManager.INSTANCE.setUseSharedExecutorService(d4VarA.h());
        c().a(d4VarA);
        sq sqVar = f14259e;
        a(context, sqVar.b(), bqVar.d());
        sqVar.a(new Date().getTime() - f14265k, bqVar.f());
        fr frVar = new fr();
        f14256b = frVar;
        frVar.a(c());
        IronSourceUtils.saveLastResponse(context, bqVar.d().toString());
        ji.i().c(true);
        rp.i().c(true);
        zn.P.c(true);
        b(context, bqVar);
        IronSourceLoggerManager.getLogger(0).setDebugLevel(bqVar.e().b());
        w3 w3VarB = bqVar.b();
        if (w3VarB.f()) {
            sqVar.a(w3VarB);
        }
        a(bqVar);
        new zn.a().a();
        d();
    }

    private final qq b() {
        return f14262h != null ? qq.INITIATED : f14263i != null ? qq.INIT_FAILED : f14264j ? qq.INIT_IN_PROGRESS : qq.NOT_INIT;
    }

    private final sd c() {
        return (sd) f14257c.getValue();
    }

    private final void d() {
        if (el.f11917p.d().d().b()) {
            rp.i().a(new kb(IronSourceConstants.EP_CONFIG_RECEIVED, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        f14255a.a(true);
    }

    public final void e() {
        f14259e.c(new Runnable() { // from class: com.ironsource.gz
            @Override // java.lang.Runnable
            public final void run() {
                oq.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Context context, hq listener, iq initRequest, Context context2) {
        kotlin.jvm.internal.t.i(context, "$context");
        kotlin.jvm.internal.t.i(listener, "$listener");
        kotlin.jvm.internal.t.i(initRequest, "$initRequest");
        j.f12678a.a(context);
        bq bqVar = f14262h;
        if (bqVar != null) {
            f14255a.a(listener, bqVar);
            return;
        }
        f14261g.add(listener);
        if (f14264j) {
            return;
        }
        f14263i = null;
        f14255a.a(true);
        f14265k = new Date().getTime();
        f14260f.a(context, initRequest, f14259e, new b(context2));
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void b(android.content.Context r8, com.ironsource.bq r9) {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.oq.b(android.content.Context, com.ironsource.bq):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(dq error) {
        kotlin.jvm.internal.t.i(error, "$error");
        f14255a.a(error);
    }

    private final void b(a4 a4Var, Context context, cr crVar) {
        rp.i().a(a4Var.c(), context);
        rp.i().b(a4Var.d(), context);
        rp.i().b(a4Var.f());
        rp.i().a(a4Var.e());
        rp.i().c(a4Var.a());
        rp.i().c(a4Var.i(), context);
        rp.i().a(a4Var.h(), context);
        rp.i().b(a4Var.j(), context);
        rp.i().d(a4Var.g(), context);
        rp rpVarI = rp.i();
        t3 t3VarB = crVar.c().b();
        kotlin.jvm.internal.t.f(t3VarB);
        rpVarI.a(t3VarB.i());
        rp.i().a(a4Var.k());
        rp.i().d(a4Var.b());
    }

    public final void a(@NotNull final Context context, @NotNull final iq initRequest, @NotNull final hq listener) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(initRequest, "initRequest");
        kotlin.jvm.internal.t.i(listener, "listener");
        final Context applicationContext = context.getApplicationContext();
        f14259e.c(new Runnable() { // from class: com.ironsource.cz
            @Override // java.lang.Runnable
            public final void run() {
                oq.a(context, listener, initRequest, applicationContext);
            }
        });
    }

    private final void a(Context context, vi viVar, cr crVar) {
        viVar.i(crVar.f().h());
        viVar.b(crVar.f().d());
        t3 t3VarB = crVar.c().b();
        kotlin.jvm.internal.t.f(t3VarB);
        viVar.a(t3VarB.a());
        viVar.c(t3VarB.b().b());
        viVar.b(t3VarB.j().b());
        viVar.a(Boolean.valueOf(IronSourceUtils.getFirstSession(context)));
        t3 t3VarB2 = crVar.c().b();
        kotlin.jvm.internal.t.f(t3VarB2);
        viVar.b(t3VarB2.e().b());
    }

    private final void b(bq bqVar) {
        f14262h = bqVar;
        a(false);
    }

    private final void a(a4 a4Var, Context context, cr crVar) {
        ji.i().a(a4Var.c(), context);
        ji.i().b(a4Var.d(), context);
        ji.i().b(a4Var.f());
        ji.i().a(a4Var.e());
        ji.i().c(a4Var.a());
        ji.i().c(a4Var.i(), context);
        ji.i().a(a4Var.h(), context);
        ji.i().b(a4Var.j(), context);
        ji.i().d(a4Var.g(), context);
        ji jiVarI = ji.i();
        t3 t3VarB = crVar.c().b();
        kotlin.jvm.internal.t.f(t3VarB);
        jiVarI.a(t3VarB.i());
        ji.i().a(a4Var.k());
        ji.i().d(a4Var.b());
    }

    public final void b(@NotNull final dq error) {
        kotlin.jvm.internal.t.i(error, "error");
        f14259e.c(new Runnable() { // from class: com.ironsource.fz
            @Override // java.lang.Runnable
            public final void run() {
                oq.c(error);
            }
        });
    }

    private final void a(bq bqVar) {
        Iterator<hq> it = f14261g.iterator();
        while (it.hasNext()) {
            a(it.next(), bqVar);
        }
        f14261g.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(hq listener, bq sdkConfig) {
        kotlin.jvm.internal.t.i(listener, "$listener");
        kotlin.jvm.internal.t.i(sdkConfig, "$sdkConfig");
        listener.a(sdkConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(dq dqVar) {
        f14263i = dqVar;
        a(false);
        Iterator<hq> it = f14261g.iterator();
        while (it.hasNext()) {
            a(it.next(), dqVar);
        }
        f14261g.clear();
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "Mediation availability false reason: " + dqVar, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(hq listener, dq error) {
        kotlin.jvm.internal.t.i(listener, "$listener");
        kotlin.jvm.internal.t.i(error, "$error");
        listener.a(error);
    }

    private final void a(final hq hqVar, final bq bqVar) {
        f14259e.e(new Runnable() { // from class: com.ironsource.hz
            @Override // java.lang.Runnable
            public final void run() {
                oq.b(hqVar, bqVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(jq serverResponse) {
        kotlin.jvm.internal.t.i(serverResponse, "$serverResponse");
        bq bqVar = new bq(serverResponse);
        oq oqVar = f14255a;
        oqVar.b(bqVar);
        oqVar.a(bqVar);
    }

    private final void a(final hq hqVar, final dq dqVar) {
        f14259e.e(new Runnable() { // from class: com.ironsource.ez
            @Override // java.lang.Runnable
            public final void run() {
                oq.b(hqVar, dqVar);
            }
        });
    }

    public final void a(@NotNull final jq serverResponse) {
        kotlin.jvm.internal.t.i(serverResponse, "serverResponse");
        f14259e.c(new Runnable() { // from class: com.ironsource.dz
            @Override // java.lang.Runnable
            public final void run() {
                oq.b(serverResponse);
            }
        });
    }

    private final void a(boolean z10) {
        f14264j = z10;
        f14259e.a(b());
    }
}
