package com.ironsource;

import com.ironsource.c7;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class lt extends c7 implements f2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final k1 f13067d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final p6 f13068e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final d7 f13069f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final g6 f13070g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private tt f13071h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private final p3 f13072i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private final gu f13073j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private final cl f13074k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private a f13075l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    private a f13076m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f13077n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f13078o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private p1 f13079p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private IronSourceError f13080q;

    private final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final e6 f13081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public p1 f13082b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f13083c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ lt f13084d;

        public a(lt ltVar, @NotNull g6 bannerAdUnitFactory, boolean z10) {
            kotlin.jvm.internal.t.i(bannerAdUnitFactory, "bannerAdUnitFactory");
            this.f13084d = ltVar;
            this.f13081a = bannerAdUnitFactory.a(z10);
            this.f13083c = true;
        }

        public final void a() {
            this.f13081a.d();
        }

        @NotNull
        public final p1 b() {
            p1 p1Var = this.f13082b;
            if (p1Var != null) {
                return p1Var;
            }
            kotlin.jvm.internal.t.A("adUnitCallback");
            return null;
        }

        @NotNull
        public final e6 c() {
            return this.f13081a;
        }

        public final boolean d() {
            return this.f13083c;
        }

        public final boolean e() {
            return this.f13081a.e().a();
        }

        public final void f() {
            this.f13081a.a(this.f13084d);
        }

        public final void a(@NotNull p1 p1Var) {
            kotlin.jvm.internal.t.i(p1Var, "<set-?>");
            this.f13082b = p1Var;
        }

        public final void a(boolean z10) {
            this.f13083c = z10;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lt(@NotNull k1 adTools, @NotNull p6 bannerContainer, @NotNull c7.b config, @NotNull c6 bannerAdProperties, @NotNull d7 bannerStrategyListener, @NotNull g6 bannerAdUnitFactory) {
        super(config, bannerAdProperties);
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(bannerContainer, "bannerContainer");
        kotlin.jvm.internal.t.i(config, "config");
        kotlin.jvm.internal.t.i(bannerAdProperties, "bannerAdProperties");
        kotlin.jvm.internal.t.i(bannerStrategyListener, "bannerStrategyListener");
        kotlin.jvm.internal.t.i(bannerAdUnitFactory, "bannerAdUnitFactory");
        this.f13067d = adTools;
        this.f13068e = bannerContainer;
        this.f13069f = bannerStrategyListener;
        this.f13070g = bannerAdUnitFactory;
        IronLog.INTERNAL.verbose(k1.a(adTools, "refresh interval: " + b() + ", auto refresh: " + c(), (String) null, 2, (Object) null));
        this.f13072i = new p3(adTools.b());
        this.f13073j = new gu(bannerContainer);
        this.f13074k = new cl(c() ^ true);
        this.f13076m = new a(this, bannerAdUnitFactory, true);
        this.f13078o = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(lt this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.h();
    }

    private final void j() {
        this.f13078o = false;
        this.f13076m.c().a(this.f13068e.getViewBinder());
        this.f13069f.b(this.f13076m.b());
        a aVar = this.f13075l;
        if (aVar != null) {
            aVar.a();
        }
        this.f13075l = this.f13076m;
        g();
        a(this.f13073j, this.f13072i, this.f13074k);
    }

    @Override // com.ironsource.f2
    public /* bridge */ /* synthetic */ v8.k0 a(p1 p1Var, IronSourceError ironSourceError) {
        b(p1Var, ironSourceError);
        return v8.k0.f35197a;
    }

    @Override // com.ironsource.c7
    public void d() {
        this.f13076m.f();
    }

    @Override // com.ironsource.c7
    public void e() {
        if (c()) {
            this.f13074k.e();
        }
    }

    @Override // com.ironsource.c7
    public void f() {
        if (c()) {
            this.f13074k.f();
        }
    }

    @Override // com.ironsource.f2
    public /* bridge */ /* synthetic */ v8.k0 l(p1 p1Var) {
        a(p1Var);
        return v8.k0.f35197a;
    }

    private final void g() {
        if (c()) {
            a aVar = new a(this, this.f13070g, false);
            this.f13076m = aVar;
            aVar.f();
        }
    }

    private final void h() {
        this.f13067d.a(new Runnable() { // from class: com.ironsource.wx
            @Override // java.lang.Runnable
            public final void run() {
                lt.a(this.f16070a);
            }
        });
    }

    private final void i() {
        p1 p1Var = this.f13079p;
        if (p1Var != null) {
            this.f13069f.e(p1Var, this.f13080q);
            this.f13079p = null;
            this.f13080q = null;
        }
    }

    @Override // com.ironsource.c7
    public void a() {
        this.f13072i.e();
        this.f13073j.e();
        tt ttVar = this.f13071h;
        if (ttVar != null) {
            ttVar.c();
        }
        this.f13071h = null;
        a aVar = this.f13075l;
        if (aVar != null) {
            aVar.a();
        }
        this.f13076m.a();
    }

    public void b(@NotNull p1 adUnitCallback, @Nullable IronSourceError ironSourceError) {
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        this.f13076m.a(false);
        this.f13079p = adUnitCallback;
        this.f13080q = ironSourceError;
        if (this.f13078o) {
            i();
            a(this.f13072i, this.f13074k);
        } else if (this.f13077n) {
            i();
            g();
            a(this.f13072i, this.f13074k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(lt this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.f13077n = true;
        if (this$0.f13076m.e()) {
            this$0.j();
            return;
        }
        this$0.i();
        if (this$0.f13076m.d()) {
            return;
        }
        this$0.g();
        this$0.a(this$0.f13072i, this$0.f13074k);
    }

    @Override // com.ironsource.f2
    public /* synthetic */ void i(p1 p1Var) {
        ew.a(this, p1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final lt this$0, xn[] triggers) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(triggers, "$triggers");
        this$0.f13077n = false;
        tt ttVar = this$0.f13071h;
        if (ttVar != null) {
            ttVar.c();
        }
        this$0.f13071h = new tt(this$0.f13067d, new Runnable() { // from class: com.ironsource.vx
            @Override // java.lang.Runnable
            public final void run() {
                lt.b(this.f15981a);
            }
        }, this$0.b(), kotlin.collections.p.o0(triggers));
    }

    public void a(@NotNull p1 adUnitCallback) {
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        this.f13076m.a(adUnitCallback);
        this.f13076m.a(false);
        if (this.f13077n || this.f13078o) {
            j();
        }
    }

    private final void a(final xn... xnVarArr) {
        this.f13067d.c(new Runnable() { // from class: com.ironsource.ux
            @Override // java.lang.Runnable
            public final void run() {
                lt.a(this.f15625a, xnVarArr);
            }
        });
    }
}
