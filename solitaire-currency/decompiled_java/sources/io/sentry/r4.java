package io.sentry;

import io.sentry.protocol.Feedback;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.protocol.User;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ScopesAdapter.java */
/* JADX INFO: loaded from: classes5.dex */
public final class r4 implements f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final r4 f28141a = new r4();

    private r4() {
    }

    public static r4 a() {
        return f28141a;
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId A(@NotNull Feedback feedback, @Nullable l0 l0Var) {
        return Sentry.captureFeedback(feedback, l0Var);
    }

    @Override // io.sentry.f1
    public void B(@NotNull ScopeCallback scopeCallback) {
        Sentry.withIsolationScope(scopeCallback);
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId C(r6 r6Var, ScopeCallback scopeCallback) {
        return e1.e(this, r6Var, scopeCallback);
    }

    @Override // io.sentry.f1
    public void D() {
        Sentry.startProfiler();
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId E(@NotNull r6 r6Var, @Nullable l0 l0Var) {
        return Sentry.captureEvent(r6Var, l0Var);
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
        Sentry.reportFullyDisplayed();
    }

    @Override // io.sentry.f1
    @NotNull
    public p1 J(@NotNull y8 y8Var, @NotNull a9 a9Var) {
        return Sentry.startTransaction(y8Var, a9Var);
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId K(Throwable th, ScopeCallback scopeCallback) {
        return e1.g(this, th, scopeCallback);
    }

    @Override // io.sentry.f1
    @Nullable
    public Boolean L() {
        return Sentry.isCrashedLastRun();
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId M(@NotNull r6 r6Var, @Nullable l0 l0Var, @NotNull ScopeCallback scopeCallback) {
        return Sentry.captureEvent(r6Var, l0Var, scopeCallback);
    }

    @Override // io.sentry.f1
    @ApiStatus.Internal
    @NotNull
    public c1 N() {
        return Sentry.getCurrentScopes().N();
    }

    @Override // io.sentry.f1
    public void O(@NotNull ScopeCallback scopeCallback) {
        Sentry.withScope(scopeCallback);
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId P(@NotNull String str, @NotNull SentryLevel sentryLevel, @NotNull ScopeCallback scopeCallback) {
        return Sentry.captureMessage(str, sentryLevel, scopeCallback);
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId Q(Throwable th) {
        return e1.f(this, th);
    }

    @Override // io.sentry.f1
    @Nullable
    public y8 R(@Nullable String str, @Nullable List<String> list) {
        return Sentry.continueTrace(str, list);
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId S(@NotNull Throwable th, @Nullable l0 l0Var) {
        return Sentry.captureException(th, l0Var);
    }

    @Override // io.sentry.f1
    @ApiStatus.Experimental
    @NotNull
    public SentryId T(@NotNull f fVar) {
        return Sentry.captureCheckIn(fVar);
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
        return Sentry.getBaggage();
    }

    @Override // io.sentry.f1
    @ApiStatus.Internal
    @NotNull
    public SentryId X(@NotNull SentryTransaction sentryTransaction, @Nullable v8 v8Var, @Nullable l0 l0Var, @Nullable x3 x3Var) {
        return Sentry.getCurrentScopes().X(sentryTransaction, v8Var, l0Var, x3Var);
    }

    @Override // io.sentry.f1
    @NotNull
    public k1 Y() {
        return Sentry.pushIsolationScope();
    }

    @Override // io.sentry.f1
    @NotNull
    public f1 Z(@NotNull String str) {
        return Sentry.forkedScopes(str);
    }

    @Override // io.sentry.f1
    @Nullable
    public u7 a0() {
        return Sentry.getTraceparent();
    }

    @Override // io.sentry.f1
    public void addBreadcrumb(@NotNull Breadcrumb breadcrumb, @Nullable l0 l0Var) {
        Sentry.addBreadcrumb(breadcrumb, l0Var);
    }

    @Override // io.sentry.f1
    public void b(boolean z10) {
        Sentry.close();
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId b0(@NotNull Feedback feedback) {
        return Sentry.captureFeedback(feedback);
    }

    @Override // io.sentry.f1
    public void bindClient(@NotNull i1 i1Var) {
        Sentry.bindClient(i1Var);
    }

    @Override // io.sentry.f1
    public void c(@NotNull Breadcrumb breadcrumb) {
        addBreadcrumb(breadcrumb, new l0());
    }

    @Override // io.sentry.f1
    public void clearBreadcrumbs() {
        Sentry.clearBreadcrumbs();
    }

    @Override // io.sentry.f1
    public boolean d() {
        return Sentry.isHealthy();
    }

    @Override // io.sentry.f1
    @ApiStatus.Internal
    @Nullable
    public io.sentry.transport.b0 e() {
        return Sentry.getCurrentScopes().e();
    }

    @Override // io.sentry.f1
    public void endSession() {
        Sentry.endSession();
    }

    @Override // io.sentry.f1
    public void f(long j10) {
        Sentry.flush(j10);
    }

    @Override // io.sentry.f1
    public /* synthetic */ boolean g() {
        return e1.n(this);
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId getLastEventId() {
        return Sentry.getLastEventId();
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryOptions getOptions() {
        return Sentry.getCurrentScopes().getOptions();
    }

    @Override // io.sentry.f1
    @ApiStatus.Internal
    @NotNull
    public c1 getScope() {
        return Sentry.getCurrentScopes().getScope();
    }

    @Override // io.sentry.f1
    @Nullable
    public n1 getSpan() {
        return Sentry.getCurrentScopes().getSpan();
    }

    @Override // io.sentry.f1
    @ApiStatus.Internal
    @Nullable
    public p1 getTransaction() {
        return Sentry.getCurrentScopes().getTransaction();
    }

    @Override // io.sentry.f1
    @NotNull
    public k1 h() {
        return w2.a();
    }

    @Override // io.sentry.f1
    @ApiStatus.Internal
    @NotNull
    public SentryId i(@NotNull p5 p5Var, @Nullable l0 l0Var) {
        return Sentry.getCurrentScopes().i(p5Var, l0Var);
    }

    @Override // io.sentry.f1
    public boolean isEnabled() {
        return Sentry.isEnabled();
    }

    @Override // io.sentry.f1
    public void j(@NotNull c9 c9Var) {
        Sentry.captureUserFeedback(c9Var);
    }

    @Override // io.sentry.f1
    public void k() {
        Sentry.stopProfiler();
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId l(@NotNull Throwable th, @Nullable l0 l0Var, @NotNull ScopeCallback scopeCallback) {
        return Sentry.captureException(th, l0Var, scopeCallback);
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
        Sentry.configureScope(h4Var, scopeCallback);
    }

    @Override // io.sentry.f1
    @NotNull
    public k1 p() {
        return Sentry.pushScope();
    }

    @Override // io.sentry.f1
    @ApiStatus.Experimental
    @NotNull
    public io.sentry.logger.a q() {
        return Sentry.getCurrentScopes().q();
    }

    @Override // io.sentry.f1
    @NotNull
    public f1 r(@NotNull String str) {
        return Sentry.forkedCurrentScope(str);
    }

    @Override // io.sentry.f1
    public void removeExtra(@Nullable String str) {
        Sentry.removeExtra(str);
    }

    @Override // io.sentry.f1
    public void removeTag(@Nullable String str) {
        Sentry.removeTag(str);
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId s(@NotNull Feedback feedback, @Nullable l0 l0Var, @Nullable ScopeCallback scopeCallback) {
        return Sentry.captureFeedback(feedback, l0Var, scopeCallback);
    }

    @Override // io.sentry.f1
    public void setExtra(@Nullable String str, @Nullable String str2) {
        Sentry.setExtra(str, str2);
    }

    @Override // io.sentry.f1
    public void setFingerprint(@NotNull List<String> list) {
        Sentry.setFingerprint(list);
    }

    @Override // io.sentry.f1
    public void setLevel(@Nullable SentryLevel sentryLevel) {
        Sentry.setLevel(sentryLevel);
    }

    @Override // io.sentry.f1
    @ApiStatus.Internal
    public void setSpanContext(@NotNull Throwable th, @NotNull n1 n1Var, @NotNull String str) {
        Sentry.getCurrentScopes().setSpanContext(th, n1Var, str);
    }

    @Override // io.sentry.f1
    public void setTag(@Nullable String str, @Nullable String str2) {
        Sentry.setTag(str, str2);
    }

    @Override // io.sentry.f1
    public void setTransaction(@Nullable String str) {
        Sentry.setTransaction(str);
    }

    @Override // io.sentry.f1
    public void setUser(@Nullable User user) {
        Sentry.setUser(user);
    }

    @Override // io.sentry.f1
    public void startSession() {
        Sentry.startSession();
    }

    @Override // io.sentry.f1
    @Deprecated
    public void t() {
        Sentry.popScope();
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
        return Sentry.captureMessage(str, sentryLevel);
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId y(@NotNull t3 t3Var) {
        return Sentry.getCurrentScopes().y(t3Var);
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId z(p5 p5Var) {
        return e1.c(this, p5Var);
    }

    @Override // io.sentry.f1
    @Deprecated
    @NotNull
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public v0 m4215clone() {
        return Sentry.getCurrentScopes().m4215clone();
    }
}
