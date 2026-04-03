package io.sentry;

import io.sentry.protocol.Feedback;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.protocol.User;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IScopes.java */
/* JADX INFO: loaded from: classes5.dex */
public interface f1 {
    @NotNull
    SentryId A(@NotNull Feedback feedback, @Nullable l0 l0Var);

    void B(@NotNull ScopeCallback scopeCallback);

    @NotNull
    SentryId C(@NotNull r6 r6Var, @NotNull ScopeCallback scopeCallback);

    void D();

    @NotNull
    SentryId E(@NotNull r6 r6Var, @Nullable l0 l0Var);

    @NotNull
    p1 F(@NotNull y8 y8Var);

    @NotNull
    p1 G(@NotNull String str, @NotNull String str2);

    @NotNull
    SentryId H(@NotNull r6 r6Var);

    void I();

    @NotNull
    p1 J(@NotNull y8 y8Var, @NotNull a9 a9Var);

    @NotNull
    SentryId K(@NotNull Throwable th, @NotNull ScopeCallback scopeCallback);

    @Nullable
    Boolean L();

    @NotNull
    SentryId M(@NotNull r6 r6Var, @Nullable l0 l0Var, @NotNull ScopeCallback scopeCallback);

    @ApiStatus.Internal
    @NotNull
    c1 N();

    void O(@NotNull ScopeCallback scopeCallback);

    @NotNull
    SentryId P(@NotNull String str, @NotNull SentryLevel sentryLevel, @NotNull ScopeCallback scopeCallback);

    @NotNull
    SentryId Q(@NotNull Throwable th);

    @Nullable
    y8 R(@Nullable String str, @Nullable List<String> list);

    @NotNull
    SentryId S(@NotNull Throwable th, @Nullable l0 l0Var);

    @ApiStatus.Experimental
    @NotNull
    SentryId T(@NotNull f fVar);

    void U(@NotNull String str, @NotNull String str2);

    @NotNull
    p1 V(@NotNull String str, @NotNull String str2, @NotNull a9 a9Var);

    @Nullable
    e W();

    @ApiStatus.Internal
    @NotNull
    SentryId X(@NotNull SentryTransaction sentryTransaction, @Nullable v8 v8Var, @Nullable l0 l0Var, @Nullable x3 x3Var);

    @NotNull
    k1 Y();

    @NotNull
    f1 Z(@NotNull String str);

    @Nullable
    u7 a0();

    void addBreadcrumb(@NotNull Breadcrumb breadcrumb, @Nullable l0 l0Var);

    void b(boolean z10);

    @NotNull
    SentryId b0(@NotNull Feedback feedback);

    void bindClient(@NotNull i1 i1Var);

    void c(@NotNull Breadcrumb breadcrumb);

    void clearBreadcrumbs();

    @Deprecated
    @NotNull
    v0 clone();

    boolean d();

    @ApiStatus.Internal
    @Nullable
    io.sentry.transport.b0 e();

    void endSession();

    void f(long j10);

    boolean g();

    @NotNull
    SentryId getLastEventId();

    @NotNull
    SentryOptions getOptions();

    @ApiStatus.Internal
    @NotNull
    c1 getScope();

    @Nullable
    n1 getSpan();

    @ApiStatus.Internal
    @Nullable
    p1 getTransaction();

    @NotNull
    k1 h();

    @NotNull
    SentryId i(@NotNull p5 p5Var, @Nullable l0 l0Var);

    boolean isEnabled();

    void j(@NotNull c9 c9Var);

    void k();

    @NotNull
    SentryId l(@NotNull Throwable th, @Nullable l0 l0Var, @NotNull ScopeCallback scopeCallback);

    @ApiStatus.Internal
    @NotNull
    SentryId m(@NotNull SentryTransaction sentryTransaction, @Nullable v8 v8Var, @Nullable l0 l0Var);

    void n(@NotNull ScopeCallback scopeCallback);

    void o(@Nullable h4 h4Var, @NotNull ScopeCallback scopeCallback);

    @NotNull
    k1 p();

    @ApiStatus.Experimental
    @NotNull
    io.sentry.logger.a q();

    @NotNull
    f1 r(@NotNull String str);

    void removeExtra(@Nullable String str);

    void removeTag(@Nullable String str);

    @NotNull
    SentryId s(@NotNull Feedback feedback, @Nullable l0 l0Var, @Nullable ScopeCallback scopeCallback);

    void setExtra(@Nullable String str, @Nullable String str2);

    void setFingerprint(@NotNull List<String> list);

    void setLevel(@Nullable SentryLevel sentryLevel);

    @ApiStatus.Internal
    void setSpanContext(@NotNull Throwable th, @NotNull n1 n1Var, @NotNull String str);

    void setTag(@Nullable String str, @Nullable String str2);

    void setTransaction(@Nullable String str);

    void setUser(@Nullable User user);

    void startSession();

    @Deprecated
    void t();

    void u(@NotNull String str);

    @NotNull
    SentryId v(@NotNull String str, @NotNull ScopeCallback scopeCallback);

    @NotNull
    SentryId w(@NotNull String str);

    @NotNull
    SentryId x(@NotNull String str, @NotNull SentryLevel sentryLevel);

    @ApiStatus.Internal
    @NotNull
    SentryId y(@NotNull t3 t3Var);

    @NotNull
    SentryId z(@NotNull p5 p5Var);
}
