package io.sentry;

import io.sentry.protocol.Feedback;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IScopes.java */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class e1 {
    public static void a(f1 f1Var, @NotNull String str) {
        f1Var.c(new Breadcrumb(str));
    }

    public static void b(f1 f1Var, @NotNull String str, @NotNull String str2) {
        Breadcrumb breadcrumb = new Breadcrumb(str);
        breadcrumb.setCategory(str2);
        f1Var.c(breadcrumb);
    }

    @NotNull
    public static SentryId c(f1 f1Var, @NotNull p5 p5Var) {
        return f1Var.i(p5Var, new l0());
    }

    @NotNull
    public static SentryId d(f1 f1Var, @NotNull r6 r6Var) {
        return f1Var.E(r6Var, new l0());
    }

    @NotNull
    public static SentryId e(f1 f1Var, @NotNull r6 r6Var, @NotNull ScopeCallback scopeCallback) {
        return f1Var.M(r6Var, new l0(), scopeCallback);
    }

    @NotNull
    public static SentryId f(f1 f1Var, @NotNull Throwable th) {
        return f1Var.S(th, new l0());
    }

    @NotNull
    public static SentryId g(f1 f1Var, @NotNull Throwable th, @NotNull ScopeCallback scopeCallback) {
        return f1Var.l(th, new l0(), scopeCallback);
    }

    @NotNull
    public static SentryId h(f1 f1Var, @NotNull Feedback feedback) {
        return f1Var.A(feedback, null);
    }

    @NotNull
    public static SentryId i(f1 f1Var, @NotNull Feedback feedback, @Nullable l0 l0Var) {
        return f1Var.s(feedback, l0Var, null);
    }

    @NotNull
    public static SentryId j(f1 f1Var, @NotNull String str) {
        return f1Var.x(str, SentryLevel.INFO);
    }

    @NotNull
    public static SentryId k(f1 f1Var, @NotNull String str, @NotNull ScopeCallback scopeCallback) {
        return f1Var.P(str, SentryLevel.INFO, scopeCallback);
    }

    @ApiStatus.Internal
    @NotNull
    public static SentryId l(f1 f1Var, @NotNull SentryTransaction sentryTransaction, @Nullable v8 v8Var, @Nullable l0 l0Var) {
        return f1Var.X(sentryTransaction, v8Var, l0Var, null);
    }

    public static void m(f1 f1Var, @NotNull ScopeCallback scopeCallback) {
        f1Var.o(null, scopeCallback);
    }

    public static boolean n(f1 f1Var) {
        return false;
    }

    @NotNull
    public static p1 o(f1 f1Var, @NotNull y8 y8Var) {
        return f1Var.J(y8Var, new a9());
    }

    @NotNull
    public static p1 p(f1 f1Var, @NotNull String str, @NotNull String str2) {
        return f1Var.V(str, str2, new a9());
    }

    @NotNull
    public static p1 q(f1 f1Var, @NotNull String str, @NotNull String str2, @NotNull a9 a9Var) {
        return f1Var.J(new y8(str, str2), a9Var);
    }
}
