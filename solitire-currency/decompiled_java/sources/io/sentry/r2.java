package io.sentry;

import io.sentry.protocol.Feedback;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.protocol.User;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NoOpHub.java */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class r2 implements v0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final r2 f28137b = new r2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final SentryOptions f28138a = SentryOptions.empty();

    private r2() {
    }

    @Deprecated
    public static r2 a() {
        return f28137b;
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId A(Feedback feedback, l0 l0Var) {
        return e1.i(this, feedback, l0Var);
    }

    @Override // io.sentry.f1
    public void B(@NotNull ScopeCallback scopeCallback) {
        scopeCallback.run(u2.a());
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId C(r6 r6Var, ScopeCallback scopeCallback) {
        return e1.e(this, r6Var, scopeCallback);
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId E(@NotNull r6 r6Var, @Nullable l0 l0Var) {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.f1
    public /* synthetic */ p1 F(y8 y8Var) {
        return e1.o(this, y8Var);
    }

    @Override // io.sentry.f1
    public /* synthetic */ p1 G(String str, String str2) {
        return e1.p(this, str, str2);
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId H(r6 r6Var) {
        return e1.d(this, r6Var);
    }

    @Override // io.sentry.f1
    @NotNull
    public p1 J(@NotNull y8 y8Var, @NotNull a9 a9Var) {
        return g3.v();
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId K(Throwable th, ScopeCallback scopeCallback) {
        return e1.g(this, th, scopeCallback);
    }

    @Override // io.sentry.f1
    @Nullable
    public Boolean L() {
        return null;
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId M(@NotNull r6 r6Var, @Nullable l0 l0Var, @NotNull ScopeCallback scopeCallback) {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.f1
    @ApiStatus.Internal
    @NotNull
    public c1 N() {
        return u2.a();
    }

    @Override // io.sentry.f1
    public void O(@NotNull ScopeCallback scopeCallback) {
        scopeCallback.run(u2.a());
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId P(@NotNull String str, @NotNull SentryLevel sentryLevel, @NotNull ScopeCallback scopeCallback) {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId Q(Throwable th) {
        return e1.f(this, th);
    }

    @Override // io.sentry.f1
    @Nullable
    public y8 R(@Nullable String str, @Nullable List<String> list) {
        return null;
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId S(@NotNull Throwable th, @Nullable l0 l0Var) {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.f1
    @ApiStatus.Experimental
    @NotNull
    public SentryId T(@NotNull f fVar) {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.f1
    public /* synthetic */ void U(String str, String str2) {
        e1.b(this, str, str2);
    }

    @Override // io.sentry.f1
    public /* synthetic */ p1 V(String str, String str2, a9 a9Var) {
        return e1.q(this, str, str2, a9Var);
    }

    @Override // io.sentry.f1
    @Nullable
    public e W() {
        return null;
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId X(@NotNull SentryTransaction sentryTransaction, @Nullable v8 v8Var, @Nullable l0 l0Var, @Nullable x3 x3Var) {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.f1
    @NotNull
    public k1 Y() {
        return w2.a();
    }

    @Override // io.sentry.f1
    @NotNull
    public f1 Z(@NotNull String str) {
        return v2.a();
    }

    @Override // io.sentry.f1
    @Nullable
    public u7 a0() {
        return null;
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId b0(Feedback feedback) {
        return e1.h(this, feedback);
    }

    @Override // io.sentry.f1
    public boolean d() {
        return true;
    }

    @Override // io.sentry.f1
    @Nullable
    public io.sentry.transport.b0 e() {
        return null;
    }

    @Override // io.sentry.f1
    public boolean g() {
        return true;
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId getLastEventId() {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryOptions getOptions() {
        return this.f28138a;
    }

    @Override // io.sentry.f1
    @ApiStatus.Internal
    @NotNull
    public c1 getScope() {
        return u2.a();
    }

    @Override // io.sentry.f1
    @Nullable
    public n1 getSpan() {
        return null;
    }

    @Override // io.sentry.f1
    @Nullable
    public p1 getTransaction() {
        return null;
    }

    @Override // io.sentry.f1
    @NotNull
    public k1 h() {
        return w2.a();
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId i(@NotNull p5 p5Var, @Nullable l0 l0Var) {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.f1
    public boolean isEnabled() {
        return false;
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId l(@NotNull Throwable th, @Nullable l0 l0Var, @NotNull ScopeCallback scopeCallback) {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId m(SentryTransaction sentryTransaction, v8 v8Var, l0 l0Var) {
        return e1.l(this, sentryTransaction, v8Var, l0Var);
    }

    @Override // io.sentry.f1
    public /* synthetic */ void n(ScopeCallback scopeCallback) {
        e1.m(this, scopeCallback);
    }

    @Override // io.sentry.f1
    @NotNull
    public k1 p() {
        return w2.a();
    }

    @Override // io.sentry.f1
    @ApiStatus.Experimental
    @NotNull
    public io.sentry.logger.a q() {
        return io.sentry.logger.f.a();
    }

    @Override // io.sentry.f1
    @NotNull
    public f1 r(@NotNull String str) {
        return v2.a();
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId s(@NotNull Feedback feedback, @Nullable l0 l0Var, @Nullable ScopeCallback scopeCallback) {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.f1
    public /* synthetic */ void u(String str) {
        e1.a(this, str);
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId v(String str, ScopeCallback scopeCallback) {
        return e1.k(this, str, scopeCallback);
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId w(String str) {
        return e1.j(this, str);
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId x(@NotNull String str, @NotNull SentryLevel sentryLevel) {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId y(@NotNull t3 t3Var) {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId z(p5 p5Var) {
        return e1.c(this, p5Var);
    }

    @Override // io.sentry.f1
    @Deprecated
    @NotNull
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public v0 m4214clone() {
        return f28137b;
    }

    @Override // io.sentry.f1
    public void D() {
    }

    @Override // io.sentry.f1
    public void I() {
    }

    @Override // io.sentry.f1
    public void clearBreadcrumbs() {
    }

    @Override // io.sentry.f1
    public void endSession() {
    }

    @Override // io.sentry.f1
    public void k() {
    }

    @Override // io.sentry.f1
    public void startSession() {
    }

    @Override // io.sentry.f1
    @Deprecated
    public void t() {
    }

    @Override // io.sentry.f1
    public void b(boolean z10) {
    }

    @Override // io.sentry.f1
    public void bindClient(@NotNull i1 i1Var) {
    }

    @Override // io.sentry.f1
    public void c(@NotNull Breadcrumb breadcrumb) {
    }

    @Override // io.sentry.f1
    public void f(long j10) {
    }

    @Override // io.sentry.f1
    public void j(@NotNull c9 c9Var) {
    }

    @Override // io.sentry.f1
    public void removeExtra(@Nullable String str) {
    }

    @Override // io.sentry.f1
    public void removeTag(@Nullable String str) {
    }

    @Override // io.sentry.f1
    public void setFingerprint(@NotNull List<String> list) {
    }

    @Override // io.sentry.f1
    public void setLevel(@Nullable SentryLevel sentryLevel) {
    }

    @Override // io.sentry.f1
    public void setTransaction(@Nullable String str) {
    }

    @Override // io.sentry.f1
    public void setUser(@Nullable User user) {
    }

    @Override // io.sentry.f1
    public void addBreadcrumb(@NotNull Breadcrumb breadcrumb, @Nullable l0 l0Var) {
    }

    @Override // io.sentry.f1
    public void o(@Nullable h4 h4Var, @NotNull ScopeCallback scopeCallback) {
    }

    @Override // io.sentry.f1
    public void setExtra(@Nullable String str, @Nullable String str2) {
    }

    @Override // io.sentry.f1
    public void setTag(@Nullable String str, @Nullable String str2) {
    }

    @Override // io.sentry.f1
    public void setSpanContext(@NotNull Throwable th, @NotNull n1 n1Var, @NotNull String str) {
    }
}
