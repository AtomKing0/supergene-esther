package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class p3 extends xn {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f14298f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private static final String f14299g = "AppLifecycleTrigger";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final com.ironsource.lifecycle.b f14300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final ij f14301e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p3(@NotNull com.ironsource.lifecycle.b lifeCycleObserver) {
        super(false, 1, null);
        kotlin.jvm.internal.t.i(lifeCycleObserver, "lifeCycleObserver");
        this.f14300d = lifeCycleObserver;
        b bVar = new b();
        this.f14301e = bVar;
        lifeCycleObserver.a(bVar);
        a(lifeCycleObserver.e());
    }

    @Override // com.ironsource.xn
    @NotNull
    public String b() {
        return f14299g;
    }

    public final void e() {
        this.f14300d.b(this.f14301e);
    }

    public static final class b implements ij {
        b() {
        }

        @Override // com.ironsource.ij
        public void a() {
            p3.this.a(false);
        }

        @Override // com.ironsource.ij
        public void d() {
            p3.this.a(true);
        }

        @Override // com.ironsource.ij
        public void b() {
        }

        @Override // com.ironsource.ij
        public void c() {
        }
    }
}
