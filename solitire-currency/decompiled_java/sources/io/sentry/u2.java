package io.sentry;

import io.sentry.Scope;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.Request;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NoOpScope.java */
/* JADX INFO: loaded from: classes5.dex */
public final class u2 implements c1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final u2 f28310b = new u2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final SentryOptions f28311a = SentryOptions.empty();

    private u2() {
    }

    public static u2 a() {
        return f28310b;
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @Nullable
    public e8 endSession() {
        return null;
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @NotNull
    public List<b> getAttachments() {
        return new ArrayList();
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @NotNull
    public Queue<Breadcrumb> getBreadcrumbs() {
        return new ArrayDeque();
    }

    @Override // io.sentry.c1
    @NotNull
    public i1 getClient() {
        return y2.p();
    }

    @Override // io.sentry.c1
    @NotNull
    public Contexts getContexts() {
        return new Contexts();
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @NotNull
    public List<g0> getEventProcessors() {
        return new ArrayList();
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @NotNull
    public List<io.sentry.internal.eventprocessor.a> getEventProcessorsWithOrder() {
        return new ArrayList();
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @NotNull
    public Map<String, Object> getExtras() {
        return new HashMap();
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @NotNull
    public List<String> getFingerprint() {
        return new ArrayList();
    }

    @Override // io.sentry.c1
    @NotNull
    public SentryId getLastEventId() {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.c1
    @Nullable
    public SentryLevel getLevel() {
        return null;
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @NotNull
    public SentryOptions getOptions() {
        return this.f28311a;
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @NotNull
    public z3 getPropagationContext() {
        return new z3();
    }

    @Override // io.sentry.c1
    @NotNull
    public SentryId getReplayId() {
        return SentryId.EMPTY_ID;
    }

    @Override // io.sentry.c1
    @Nullable
    public Request getRequest() {
        return null;
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @Nullable
    public String getScreen() {
        return null;
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @Nullable
    public e8 getSession() {
        return null;
    }

    @Override // io.sentry.c1
    @Nullable
    public n1 getSpan() {
        return null;
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @NotNull
    public Map<String, String> getTags() {
        return new HashMap();
    }

    @Override // io.sentry.c1
    @Nullable
    public p1 getTransaction() {
        return null;
    }

    @Override // io.sentry.c1
    @Nullable
    public String getTransactionName() {
        return null;
    }

    @Override // io.sentry.c1
    @Nullable
    public User getUser() {
        return null;
    }

    @Override // io.sentry.c1
    public void setTransaction(@Nullable p1 p1Var) {
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @Nullable
    public Scope.d startSession() {
        return null;
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @NotNull
    public z3 withPropagationContext(Scope.a aVar) {
        return new z3();
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @Nullable
    public e8 withSession(Scope.b bVar) {
        return null;
    }

    @Override // io.sentry.c1
    @NotNull
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public c1 m4216clone() {
        return a();
    }

    @Override // io.sentry.c1
    public void setTransaction(@NotNull String str) {
    }

    @Override // io.sentry.c1
    public void clear() {
    }

    @Override // io.sentry.c1
    public void clearBreadcrumbs() {
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    public void clearSession() {
    }

    @Override // io.sentry.c1
    public void clearTransaction() {
    }

    @Override // io.sentry.c1
    public void assignTraceContext(@NotNull r6 r6Var) {
    }

    @Override // io.sentry.c1
    public void bindClient(@NotNull i1 i1Var) {
    }

    @Override // io.sentry.c1
    public void removeExtra(@Nullable String str) {
    }

    @Override // io.sentry.c1
    public void removeTag(@Nullable String str) {
    }

    @Override // io.sentry.c1
    public void replaceOptions(@NotNull SentryOptions sentryOptions) {
    }

    @Override // io.sentry.c1
    public void setFingerprint(@NotNull List<String> list) {
    }

    @Override // io.sentry.c1
    public void setLastEventId(@NotNull SentryId sentryId) {
    }

    @Override // io.sentry.c1
    public void setLevel(@Nullable SentryLevel sentryLevel) {
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    public void setPropagationContext(@NotNull z3 z3Var) {
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    public void setScreen(@Nullable String str) {
    }

    @Override // io.sentry.c1
    public void setUser(@Nullable User user) {
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    public void withTransaction(Scope.c cVar) {
    }

    @Override // io.sentry.c1
    public void addBreadcrumb(@NotNull Breadcrumb breadcrumb, @Nullable l0 l0Var) {
    }

    @Override // io.sentry.c1
    public void setExtra(@Nullable String str, @Nullable String str2) {
    }

    @Override // io.sentry.c1
    public void setTag(@Nullable String str, @Nullable String str2) {
    }

    @Override // io.sentry.c1
    public void setSpanContext(@NotNull Throwable th, @NotNull n1 n1Var, @NotNull String str) {
    }
}
