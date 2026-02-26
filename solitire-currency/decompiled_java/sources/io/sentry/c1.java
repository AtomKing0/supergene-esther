package io.sentry;

import io.sentry.Scope;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.Request;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IScope.java */
/* JADX INFO: loaded from: classes5.dex */
public interface c1 {
    void addBreadcrumb(@NotNull Breadcrumb breadcrumb, @Nullable l0 l0Var);

    @ApiStatus.Internal
    void assignTraceContext(@NotNull r6 r6Var);

    void bindClient(@NotNull i1 i1Var);

    void clear();

    void clearBreadcrumbs();

    @ApiStatus.Internal
    void clearSession();

    void clearTransaction();

    @NotNull
    /* JADX INFO: renamed from: clone */
    c1 m4210clone();

    @Nullable
    e8 endSession();

    @NotNull
    List<b> getAttachments();

    @ApiStatus.Internal
    @NotNull
    Queue<Breadcrumb> getBreadcrumbs();

    @NotNull
    i1 getClient();

    @NotNull
    Contexts getContexts();

    @ApiStatus.Internal
    @NotNull
    List<g0> getEventProcessors();

    @ApiStatus.Internal
    @NotNull
    List<io.sentry.internal.eventprocessor.a> getEventProcessorsWithOrder();

    @ApiStatus.Internal
    @NotNull
    Map<String, Object> getExtras();

    @ApiStatus.Internal
    @NotNull
    List<String> getFingerprint();

    @NotNull
    SentryId getLastEventId();

    @Nullable
    SentryLevel getLevel();

    @NotNull
    SentryOptions getOptions();

    @ApiStatus.Internal
    @NotNull
    z3 getPropagationContext();

    @ApiStatus.Internal
    @NotNull
    SentryId getReplayId();

    @Nullable
    Request getRequest();

    @ApiStatus.Internal
    @Nullable
    String getScreen();

    @ApiStatus.Internal
    @Nullable
    e8 getSession();

    @Nullable
    n1 getSpan();

    @ApiStatus.Internal
    @NotNull
    Map<String, String> getTags();

    @Nullable
    p1 getTransaction();

    @Nullable
    String getTransactionName();

    @Nullable
    User getUser();

    void removeExtra(@Nullable String str);

    void removeTag(@Nullable String str);

    @ApiStatus.Internal
    void replaceOptions(@NotNull SentryOptions sentryOptions);

    void setExtra(@Nullable String str, @Nullable String str2);

    void setFingerprint(@NotNull List<String> list);

    void setLastEventId(@NotNull SentryId sentryId);

    void setLevel(@Nullable SentryLevel sentryLevel);

    @ApiStatus.Internal
    void setPropagationContext(@NotNull z3 z3Var);

    @ApiStatus.Internal
    void setScreen(@Nullable String str);

    @ApiStatus.Internal
    void setSpanContext(@NotNull Throwable th, @NotNull n1 n1Var, @NotNull String str);

    void setTag(@Nullable String str, @Nullable String str2);

    void setTransaction(@Nullable p1 p1Var);

    void setTransaction(@NotNull String str);

    void setUser(@Nullable User user);

    @Nullable
    Scope.d startSession();

    @ApiStatus.Internal
    @NotNull
    z3 withPropagationContext(@NotNull Scope.a aVar);

    @Nullable
    e8 withSession(@NotNull Scope.b bVar);

    @ApiStatus.Internal
    void withTransaction(@NotNull Scope.c cVar);
}
