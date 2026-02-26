package io.sentry;

import io.sentry.protocol.Feedback;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.protocol.User;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HubScopesWrapper.java */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class q0 implements v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final f1 f28092a;

    public q0(@NotNull f1 f1Var) {
        this.f28092a = f1Var;
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId A(Feedback feedback, l0 l0Var) {
        return e1.i(this, feedback, l0Var);
    }

    @Override // io.sentry.f1
    public void B(@NotNull ScopeCallback scopeCallback) {
        this.f28092a.B(scopeCallback);
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId C(r6 r6Var, ScopeCallback scopeCallback) {
        return e1.e(this, r6Var, scopeCallback);
    }

    @Override // io.sentry.f1
    public void D() {
        this.f28092a.D();
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId E(@NotNull r6 r6Var, @Nullable l0 l0Var) {
        return this.f28092a.E(r6Var, l0Var);
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
    public void I() {
        this.f28092a.I();
    }

    @Override // io.sentry.f1
    @NotNull
    public p1 J(@NotNull y8 y8Var, @NotNull a9 a9Var) {
        return this.f28092a.J(y8Var, a9Var);
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId K(Throwable th, ScopeCallback scopeCallback) {
        return e1.g(this, th, scopeCallback);
    }

    @Override // io.sentry.f1
    @Nullable
    public Boolean L() {
        return this.f28092a.L();
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId M(@NotNull r6 r6Var, @Nullable l0 l0Var, @NotNull ScopeCallback scopeCallback) {
        return this.f28092a.M(r6Var, l0Var, scopeCallback);
    }

    @Override // io.sentry.f1
    @ApiStatus.Internal
    @NotNull
    public c1 N() {
        return this.f28092a.N();
    }

    @Override // io.sentry.f1
    public void O(@NotNull ScopeCallback scopeCallback) {
        this.f28092a.O(scopeCallback);
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId P(@NotNull String str, @NotNull SentryLevel sentryLevel, @NotNull ScopeCallback scopeCallback) {
        return this.f28092a.P(str, sentryLevel, scopeCallback);
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId Q(Throwable th) {
        return e1.f(this, th);
    }

    @Override // io.sentry.f1
    @Nullable
    public y8 R(@Nullable String str, @Nullable List<String> list) {
        return this.f28092a.R(str, list);
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId S(@NotNull Throwable th, @Nullable l0 l0Var) {
        return this.f28092a.S(th, l0Var);
    }

    @Override // io.sentry.f1
    @ApiStatus.Experimental
    @NotNull
    public SentryId T(@NotNull f fVar) {
        return this.f28092a.T(fVar);
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
        return this.f28092a.W();
    }

    @Override // io.sentry.f1
    @ApiStatus.Internal
    @NotNull
    public SentryId X(@NotNull SentryTransaction sentryTransaction, @Nullable v8 v8Var, @Nullable l0 l0Var, @Nullable x3 x3Var) {
        return this.f28092a.X(sentryTransaction, v8Var, l0Var, x3Var);
    }

    @Override // io.sentry.f1
    @NotNull
    public k1 Y() {
        return this.f28092a.Y();
    }

    @Override // io.sentry.f1
    @NotNull
    public f1 Z(@NotNull String str) {
        return this.f28092a.Z(str);
    }

    @Override // io.sentry.f1
    @Nullable
    public u7 a0() {
        return this.f28092a.a0();
    }

    @Override // io.sentry.f1
    public void addBreadcrumb(@NotNull Breadcrumb breadcrumb, @Nullable l0 l0Var) {
        this.f28092a.addBreadcrumb(breadcrumb, l0Var);
    }

    @Override // io.sentry.f1
    public void b(boolean z10) {
        this.f28092a.b(z10);
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId b0(Feedback feedback) {
        return e1.h(this, feedback);
    }

    @Override // io.sentry.f1
    public void bindClient(@NotNull i1 i1Var) {
        this.f28092a.bindClient(i1Var);
    }

    @Override // io.sentry.f1
    public void c(@NotNull Breadcrumb breadcrumb) {
        this.f28092a.c(breadcrumb);
    }

    @Override // io.sentry.f1
    public void clearBreadcrumbs() {
        this.f28092a.clearBreadcrumbs();
    }

    @Override // io.sentry.f1
    public boolean d() {
        return this.f28092a.d();
    }

    @Override // io.sentry.f1
    @ApiStatus.Internal
    @Nullable
    public io.sentry.transport.b0 e() {
        return this.f28092a.e();
    }

    @Override // io.sentry.f1
    public void endSession() {
        this.f28092a.endSession();
    }

    @Override // io.sentry.f1
    public void f(long j10) {
        this.f28092a.f(j10);
    }

    @Override // io.sentry.f1
    public /* synthetic */ boolean g() {
        return e1.n(this);
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId getLastEventId() {
        return this.f28092a.getLastEventId();
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryOptions getOptions() {
        return this.f28092a.getOptions();
    }

    @Override // io.sentry.f1
    @ApiStatus.Internal
    @NotNull
    public c1 getScope() {
        return this.f28092a.getScope();
    }

    @Override // io.sentry.f1
    @Nullable
    public n1 getSpan() {
        return this.f28092a.getSpan();
    }

    @Override // io.sentry.f1
    @ApiStatus.Internal
    @Nullable
    public p1 getTransaction() {
        return this.f28092a.getTransaction();
    }

    @Override // io.sentry.f1
    @NotNull
    public k1 h() {
        return this.f28092a.h();
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId i(@NotNull p5 p5Var, @Nullable l0 l0Var) {
        return this.f28092a.i(p5Var, l0Var);
    }

    @Override // io.sentry.f1
    public boolean isEnabled() {
        return this.f28092a.isEnabled();
    }

    @Override // io.sentry.f1
    public void j(@NotNull c9 c9Var) {
        this.f28092a.j(c9Var);
    }

    @Override // io.sentry.f1
    public void k() {
        this.f28092a.k();
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId l(@NotNull Throwable th, @Nullable l0 l0Var, @NotNull ScopeCallback scopeCallback) {
        return this.f28092a.l(th, l0Var, scopeCallback);
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
    public void o(@Nullable h4 h4Var, @NotNull ScopeCallback scopeCallback) {
        this.f28092a.o(h4Var, scopeCallback);
    }

    @Override // io.sentry.f1
    @NotNull
    public k1 p() {
        return this.f28092a.p();
    }

    @Override // io.sentry.f1
    @ApiStatus.Experimental
    @NotNull
    public io.sentry.logger.a q() {
        return this.f28092a.q();
    }

    @Override // io.sentry.f1
    @NotNull
    public f1 r(@NotNull String str) {
        return this.f28092a.r(str);
    }

    @Override // io.sentry.f1
    public void removeExtra(@Nullable String str) {
        this.f28092a.removeExtra(str);
    }

    @Override // io.sentry.f1
    public void removeTag(@Nullable String str) {
        this.f28092a.removeTag(str);
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId s(@NotNull Feedback feedback, @Nullable l0 l0Var, @Nullable ScopeCallback scopeCallback) {
        return this.f28092a.s(feedback, l0Var, scopeCallback);
    }

    @Override // io.sentry.f1
    public void setExtra(@Nullable String str, @Nullable String str2) {
        this.f28092a.setExtra(str, str2);
    }

    @Override // io.sentry.f1
    public void setFingerprint(@NotNull List<String> list) {
        this.f28092a.setFingerprint(list);
    }

    @Override // io.sentry.f1
    public void setLevel(@Nullable SentryLevel sentryLevel) {
        this.f28092a.setLevel(sentryLevel);
    }

    @Override // io.sentry.f1
    @ApiStatus.Internal
    public void setSpanContext(@NotNull Throwable th, @NotNull n1 n1Var, @NotNull String str) {
        this.f28092a.setSpanContext(th, n1Var, str);
    }

    @Override // io.sentry.f1
    public void setTag(@Nullable String str, @Nullable String str2) {
        this.f28092a.setTag(str, str2);
    }

    @Override // io.sentry.f1
    public void setTransaction(@Nullable String str) {
        this.f28092a.setTransaction(str);
    }

    @Override // io.sentry.f1
    public void setUser(@Nullable User user) {
        this.f28092a.setUser(user);
    }

    @Override // io.sentry.f1
    public void startSession() {
        this.f28092a.startSession();
    }

    @Override // io.sentry.f1
    @Deprecated
    public void t() {
        this.f28092a.t();
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
        return this.f28092a.x(str, sentryLevel);
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId y(@NotNull t3 t3Var) {
        return this.f28092a.y(t3Var);
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId z(p5 p5Var) {
        return e1.c(this, p5Var);
    }

    @Override // io.sentry.f1
    @Deprecated
    @NotNull
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public v0 m4212clone() {
        return this.f28092a.m4215clone();
    }
}
