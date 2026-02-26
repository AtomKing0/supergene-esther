package com.ironsource;

import com.ironsource.c7;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class kt extends c7 implements f2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final k1 f12906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final p6 f12907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final d7 f12908f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final g6 f12909g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private tt f12910h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private final p3 f12911i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private final gu f12912j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private final cl f12913k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private a f12914l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    private a f12915m;

    private final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final e6 f12916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public p1 f12917b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ kt f12918c;

        public a(kt ktVar, @NotNull g6 bannerAdUnitFactory, boolean z10) {
            kotlin.jvm.internal.t.i(bannerAdUnitFactory, "bannerAdUnitFactory");
            this.f12918c = ktVar;
            this.f12916a = bannerAdUnitFactory.a(z10);
        }

        public final void a() {
            this.f12916a.d();
        }

        @NotNull
        public final p1 b() {
            p1 p1Var = this.f12917b;
            if (p1Var != null) {
                return p1Var;
            }
            kotlin.jvm.internal.t.A("adUnitCallback");
            return null;
        }

        @NotNull
        public final e6 c() {
            return this.f12916a;
        }

        @NotNull
        public final f1 d() {
            return this.f12916a.e();
        }

        public final void e() {
            this.f12916a.a(this.f12918c);
        }

        public final void a(@NotNull p1 p1Var) {
            kotlin.jvm.internal.t.i(p1Var, "<set-?>");
            this.f12917b = p1Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kt(@NotNull k1 adTools, @NotNull p6 bannerContainer, @NotNull c7.b config, @NotNull c6 bannerAdProperties, @NotNull d7 bannerStrategyListener, @NotNull g6 bannerAdUnitFactory) {
        super(config, bannerAdProperties);
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(bannerContainer, "bannerContainer");
        kotlin.jvm.internal.t.i(config, "config");
        kotlin.jvm.internal.t.i(bannerAdProperties, "bannerAdProperties");
        kotlin.jvm.internal.t.i(bannerStrategyListener, "bannerStrategyListener");
        kotlin.jvm.internal.t.i(bannerAdUnitFactory, "bannerAdUnitFactory");
        this.f12906d = adTools;
        this.f12907e = bannerContainer;
        this.f12908f = bannerStrategyListener;
        this.f12909g = bannerAdUnitFactory;
        IronLog.INTERNAL.verbose(k1.a(adTools, "refresh interval: " + b() + ", auto refresh: " + c(), (String) null, 2, (Object) null));
        this.f12911i = new p3(adTools.b());
        this.f12912j = new gu(bannerContainer);
        this.f12913k = new cl(c() ^ true);
        this.f12915m = new a(this, bannerAdUnitFactory, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(kt this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.h();
    }

    @Override // com.ironsource.f2
    public /* bridge */ /* synthetic */ v8.k0 a(p1 p1Var, IronSourceError ironSourceError) {
        b(p1Var, ironSourceError);
        return v8.k0.f35197a;
    }

    @Override // com.ironsource.c7
    public void d() {
        this.f12915m.e();
    }

    @Override // com.ironsource.c7
    public void e() {
        if (c()) {
            this.f12913k.e();
        }
    }

    @Override // com.ironsource.c7
    public void f() {
        if (c()) {
            this.f12913k.f();
        }
    }

    @Override // com.ironsource.f2
    public /* bridge */ /* synthetic */ v8.k0 l(p1 p1Var) {
        a(p1Var);
        return v8.k0.f35197a;
    }

    private final void b(p1 p1Var) {
        this.f12915m.a(p1Var);
        this.f12915m.c().a(this.f12907e.getViewBinder());
        this.f12908f.b(this.f12915m.b());
        a aVar = this.f12914l;
        if (aVar != null) {
            aVar.a();
        }
        this.f12914l = null;
    }

    private final void g() {
        this.f12914l = this.f12915m;
        a aVar = new a(this, this.f12909g, false);
        this.f12915m = aVar;
        aVar.e();
    }

    private final void h() {
        this.f12906d.a(new Runnable() { // from class: com.ironsource.cx
            @Override // java.lang.Runnable
            public final void run() {
                kt.a(this.f11722a);
            }
        });
    }

    @Override // com.ironsource.c7
    public void a() {
        this.f12911i.e();
        this.f12912j.e();
        tt ttVar = this.f12910h;
        if (ttVar != null) {
            ttVar.c();
        }
        this.f12910h = null;
        a aVar = this.f12914l;
        if (aVar != null) {
            aVar.a();
        }
        this.f12914l = null;
        this.f12915m.a();
    }

    @Override // com.ironsource.f2
    public /* synthetic */ void i(p1 p1Var) {
        ew.a(this, p1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(kt this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.g();
    }

    public void b(@NotNull p1 adUnitCallback, @Nullable IronSourceError ironSourceError) {
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        this.f12908f.e(adUnitCallback, ironSourceError);
        a(this.f12911i, this.f12913k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final kt this$0, xn[] triggers) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(triggers, "$triggers");
        this$0.f12910h = new tt(this$0.f12906d, new Runnable() { // from class: com.ironsource.ex
            @Override // java.lang.Runnable
            public final void run() {
                kt.b(this.f12002a);
            }
        }, this$0.b(), kotlin.collections.p.o0(triggers));
    }

    public void a(@NotNull p1 adUnitCallback) {
        kotlin.jvm.internal.t.i(adUnitCallback, "adUnitCallback");
        b(adUnitCallback);
        a(this.f12912j, this.f12911i, this.f12913k);
    }

    private final void a(final xn... xnVarArr) {
        this.f12906d.c(new Runnable() { // from class: com.ironsource.dx
            @Override // java.lang.Runnable
            public final void run() {
                kt.a(this.f11869a, xnVarArr);
            }
        });
    }
}
