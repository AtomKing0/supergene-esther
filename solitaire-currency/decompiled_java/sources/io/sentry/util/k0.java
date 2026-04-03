package io.sentry.util;

import io.sentry.Scope;
import io.sentry.ScopeCallback;
import io.sentry.SentryOptions;
import io.sentry.c1;
import io.sentry.f1;
import io.sentry.n1;
import io.sentry.s2;
import io.sentry.u7;
import io.sentry.x8;
import io.sentry.z3;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TracingUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public final class k0 {

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: TracingUtils.java */
    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private z3 f28353a;

        private b() {
            this.f28353a = null;
        }
    }

    /* JADX INFO: compiled from: TracingUtils.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final u7 f28354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private final io.sentry.e f28355b;

        public c(@NotNull u7 u7Var, @Nullable io.sentry.e eVar) {
            this.f28354a = u7Var;
            this.f28355b = eVar;
        }

        @Nullable
        public io.sentry.e a() {
            return this.f28355b;
        }

        @NotNull
        public u7 b() {
            return this.f28354a;
        }
    }

    @ApiStatus.Internal
    @NotNull
    public static io.sentry.d g(@Nullable io.sentry.d dVar, @Nullable x8 x8Var) {
        return h(dVar, x8Var == null ? null : x8Var.e(), x8Var == null ? null : x8Var.d(), x8Var != null ? x8Var.c() : null);
    }

    @ApiStatus.Internal
    @NotNull
    public static io.sentry.d h(@Nullable io.sentry.d dVar, @Nullable Boolean bool, @Nullable Double d10, @Nullable Double d11) {
        if (dVar == null) {
            dVar = new io.sentry.d(s2.e());
        }
        if (dVar.n() == null) {
            Double dO = dVar.o();
            if (dO != null) {
                d10 = dO;
            }
            dVar.H(a0.b(d11, d10, bool));
        }
        if (dVar.w() && dVar.x()) {
            dVar.d();
        }
        return dVar;
    }

    @ApiStatus.Internal
    public static boolean i(@Nullable List<io.sentry.j0> list, @Nullable String str) {
        if (str != null && list != null && !list.isEmpty()) {
            Iterator<io.sentry.j0> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().a().equalsIgnoreCase(str)) {
                    return true;
                }
            }
            Iterator<io.sentry.j0> it2 = list.iterator();
            while (it2.hasNext()) {
                if (it2.next().b(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(c1 c1Var, SentryOptions sentryOptions, z3 z3Var) {
        io.sentry.d dVarD = z3Var.d();
        if (dVarD.w()) {
            dVarD.N(c1Var, sentryOptions);
            dVarD.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(final z3 z3Var, final c1 c1Var) {
        c1Var.withPropagationContext(new Scope.a() { // from class: io.sentry.util.h0
            @Override // io.sentry.Scope.a
            public final void a(z3 z3Var2) {
                c1Var.setPropagationContext(z3Var);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(c1 c1Var, z3 z3Var) {
        c1Var.setPropagationContext(new z3());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(final c1 c1Var) {
        c1Var.withPropagationContext(new Scope.a() { // from class: io.sentry.util.j0
            @Override // io.sentry.Scope.a
            public final void a(z3 z3Var) {
                k0.m(c1Var, z3Var);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o(b bVar, SentryOptions sentryOptions, c1 c1Var) {
        bVar.f28353a = p(c1Var, sentryOptions);
    }

    @NotNull
    public static z3 p(@NotNull final c1 c1Var, @NotNull final SentryOptions sentryOptions) {
        return c1Var.withPropagationContext(new Scope.a() { // from class: io.sentry.util.g0
            @Override // io.sentry.Scope.a
            public final void a(z3 z3Var) {
                k0.j(c1Var, sentryOptions, z3Var);
            }
        });
    }

    public static void q(@NotNull f1 f1Var, @NotNull final z3 z3Var) {
        f1Var.n(new ScopeCallback() { // from class: io.sentry.util.e0
            @Override // io.sentry.ScopeCallback
            public final void run(c1 c1Var) {
                k0.l(z3Var, c1Var);
            }
        });
    }

    public static void r(@NotNull f1 f1Var) {
        f1Var.n(new ScopeCallback() { // from class: io.sentry.util.i0
            @Override // io.sentry.ScopeCallback
            public final void run(c1 c1Var) {
                k0.n(c1Var);
            }
        });
    }

    @Nullable
    public static c s(@NotNull f1 f1Var, @Nullable List<String> list, @Nullable n1 n1Var) {
        final SentryOptions options = f1Var.getOptions();
        if (n1Var != null && !n1Var.g()) {
            return new c(n1Var.a(), n1Var.l(list));
        }
        final b bVar = new b();
        f1Var.n(new ScopeCallback() { // from class: io.sentry.util.f0
            @Override // io.sentry.ScopeCallback
            public final void run(c1 c1Var) {
                k0.o(bVar, options, c1Var);
            }
        });
        if (bVar.f28353a == null) {
            return null;
        }
        z3 z3Var = bVar.f28353a;
        return new c(new u7(z3Var.h(), z3Var.g(), z3Var.i()), io.sentry.e.a(z3Var.d(), list));
    }
}
