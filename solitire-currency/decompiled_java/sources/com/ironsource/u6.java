package com.ironsource;

import com.ironsource.g2;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.u6;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class u6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final g2 f15561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final b2 f15562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final y5 f15563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final v8.l f15564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final v8.l f15565e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f15566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f15567g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f15568h;

    static final class a extends kotlin.jvm.internal.v implements h9.a<pk> {
        a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final pk invoke() {
            final u6 u6Var = u6.this;
            return new pk(new Runnable() { // from class: com.ironsource.v00
                @Override // java.lang.Runnable
                public final void run() {
                    u6.a.a(u6Var);
                }
            }, com.ironsource.lifecycle.b.d(), new nt());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(u6 this$0) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            this$0.f15563c.e();
        }
    }

    static final class b extends kotlin.jvm.internal.v implements h9.a<pk> {
        b() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final pk invoke() {
            final u6 u6Var = u6.this;
            return new pk(new Runnable() { // from class: com.ironsource.w00
                @Override // java.lang.Runnable
                public final void run() {
                    u6.b.a(u6Var);
                }
            }, com.ironsource.lifecycle.b.d(), new nt());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(u6 this$0) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            this$0.f15563c.f();
        }
    }

    public u6(@NotNull g2 loadingData, @NotNull b2 interactionData, @NotNull y5 mListener) {
        kotlin.jvm.internal.t.i(loadingData, "loadingData");
        kotlin.jvm.internal.t.i(interactionData, "interactionData");
        kotlin.jvm.internal.t.i(mListener, "mListener");
        this.f15561a = loadingData;
        this.f15562b = interactionData;
        this.f15563c = mListener;
        this.f15564d = v8.n.a(new a());
        this.f15565e = v8.n.a(new b());
        this.f15566f = loadingData.b() > 0;
        this.f15567g = interactionData.b() > 0;
        this.f15568h = loadingData.a() == g2.a.MANUAL_WITH_LOAD_ON_SHOW;
    }

    private final pk c() {
        return (pk) this.f15564d.getValue();
    }

    private final pk d() {
        return (pk) this.f15565e.getValue();
    }

    private final void f() {
        if (this.f15568h) {
            c().b();
        }
    }

    private final void g() {
        if (this.f15568h) {
            d().b();
        }
    }

    public final void b() {
        IronLog.INTERNAL.verbose();
        g();
    }

    public final void e() {
        IronLog.INTERNAL.verbose();
        b(this.f15562b.b());
    }

    public final void h() {
        if (!this.f15566f) {
            IronLog.INTERNAL.verbose("banner reload interval is disabled");
        } else {
            IronLog.INTERNAL.verbose();
            a(this.f15561a.b());
        }
    }

    private final void b(long j10) {
        if (this.f15568h && this.f15567g) {
            d().a(j10);
        }
    }

    public final void a() {
        IronLog.INTERNAL.verbose();
        f();
    }

    private final void a(long j10) {
        if (this.f15568h && this.f15566f) {
            c().a(j10);
        }
    }
}
