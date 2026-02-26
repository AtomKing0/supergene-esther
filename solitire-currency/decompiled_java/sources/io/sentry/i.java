package io.sentry;

import io.sentry.Scope;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.Request;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CombinedScopeView.java */
/* JADX INFO: loaded from: classes5.dex */
public final class i implements c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c1 f27855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c1 f27856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c1 f27857c;

    /* JADX INFO: compiled from: CombinedScopeView.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f27858a;

        static {
            int[] iArr = new int[h4.values().length];
            f27858a = iArr;
            try {
                iArr[h4.CURRENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27858a[h4.ISOLATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f27858a[h4.GLOBAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f27858a[h4.COMBINED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public i(@NotNull c1 c1Var, @NotNull c1 c1Var2, @NotNull c1 c1Var3) {
        this.f27855a = c1Var;
        this.f27856b = c1Var2;
        this.f27857c = c1Var3;
    }

    @NotNull
    private c1 a() {
        return b(null);
    }

    @Override // io.sentry.c1
    public void addBreadcrumb(@NotNull Breadcrumb breadcrumb, @Nullable l0 l0Var) {
        a().addBreadcrumb(breadcrumb, l0Var);
    }

    @Override // io.sentry.c1
    public void assignTraceContext(@NotNull r6 r6Var) {
        this.f27855a.assignTraceContext(r6Var);
    }

    c1 b(@Nullable h4 h4Var) {
        if (h4Var != null) {
            int i10 = a.f27858a[h4Var.ordinal()];
            if (i10 == 1) {
                return this.f27857c;
            }
            if (i10 == 2) {
                return this.f27856b;
            }
            if (i10 == 3) {
                return this.f27855a;
            }
            if (i10 == 4) {
                return this;
            }
        }
        int i11 = a.f27858a[getOptions().getDefaultScopeType().ordinal()];
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? this.f27857c : this.f27855a : this.f27856b : this.f27857c;
    }

    @Override // io.sentry.c1
    public void bindClient(@NotNull i1 i1Var) {
        a().bindClient(i1Var);
    }

    @Override // io.sentry.c1
    public void clear() {
        a().clear();
    }

    @Override // io.sentry.c1
    public void clearBreadcrumbs() {
        a().clearBreadcrumbs();
    }

    @Override // io.sentry.c1
    public void clearSession() {
        a().clearSession();
    }

    @Override // io.sentry.c1
    public void clearTransaction() {
        a().clearTransaction();
    }

    @Override // io.sentry.c1
    @Nullable
    public e8 endSession() {
        return a().endSession();
    }

    @Override // io.sentry.c1
    @NotNull
    public List<b> getAttachments() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.addAll(this.f27855a.getAttachments());
        copyOnWriteArrayList.addAll(this.f27856b.getAttachments());
        copyOnWriteArrayList.addAll(this.f27857c.getAttachments());
        return copyOnWriteArrayList;
    }

    @Override // io.sentry.c1
    @NotNull
    public Queue<Breadcrumb> getBreadcrumbs() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f27855a.getBreadcrumbs());
        arrayList.addAll(this.f27856b.getBreadcrumbs());
        arrayList.addAll(this.f27857c.getBreadcrumbs());
        Collections.sort(arrayList);
        Queue<Breadcrumb> queueCreateBreadcrumbsList = Scope.createBreadcrumbsList(this.f27857c.getOptions().getMaxBreadcrumbs());
        queueCreateBreadcrumbsList.addAll(arrayList);
        return queueCreateBreadcrumbsList;
    }

    @Override // io.sentry.c1
    @NotNull
    public i1 getClient() {
        i1 client = this.f27857c.getClient();
        if (!(client instanceof y2)) {
            return client;
        }
        i1 client2 = this.f27856b.getClient();
        return !(client2 instanceof y2) ? client2 : this.f27855a.getClient();
    }

    @Override // io.sentry.c1
    @NotNull
    public Contexts getContexts() {
        return new h(this.f27855a.getContexts(), this.f27856b.getContexts(), this.f27857c.getContexts(), getOptions().getDefaultScopeType());
    }

    @Override // io.sentry.c1
    @NotNull
    public List<g0> getEventProcessors() {
        return io.sentry.util.f.a(getEventProcessorsWithOrder());
    }

    @Override // io.sentry.c1
    @NotNull
    public List<io.sentry.internal.eventprocessor.a> getEventProcessorsWithOrder() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.addAll(this.f27855a.getEventProcessorsWithOrder());
        copyOnWriteArrayList.addAll(this.f27856b.getEventProcessorsWithOrder());
        copyOnWriteArrayList.addAll(this.f27857c.getEventProcessorsWithOrder());
        Collections.sort(copyOnWriteArrayList);
        return copyOnWriteArrayList;
    }

    @Override // io.sentry.c1
    @NotNull
    public Map<String, Object> getExtras() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.putAll(this.f27855a.getExtras());
        concurrentHashMap.putAll(this.f27856b.getExtras());
        concurrentHashMap.putAll(this.f27857c.getExtras());
        return concurrentHashMap;
    }

    @Override // io.sentry.c1
    @NotNull
    public List<String> getFingerprint() {
        List<String> fingerprint = this.f27857c.getFingerprint();
        if (!fingerprint.isEmpty()) {
            return fingerprint;
        }
        List<String> fingerprint2 = this.f27856b.getFingerprint();
        return !fingerprint2.isEmpty() ? fingerprint2 : this.f27855a.getFingerprint();
    }

    @Override // io.sentry.c1
    @NotNull
    public SentryId getLastEventId() {
        return this.f27855a.getLastEventId();
    }

    @Override // io.sentry.c1
    @Nullable
    public SentryLevel getLevel() {
        SentryLevel level = this.f27857c.getLevel();
        if (level != null) {
            return level;
        }
        SentryLevel level2 = this.f27856b.getLevel();
        return level2 != null ? level2 : this.f27855a.getLevel();
    }

    @Override // io.sentry.c1
    @NotNull
    public SentryOptions getOptions() {
        return this.f27855a.getOptions();
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @NotNull
    public z3 getPropagationContext() {
        return a().getPropagationContext();
    }

    @Override // io.sentry.c1
    @NotNull
    public SentryId getReplayId() {
        SentryId replayId = this.f27857c.getReplayId();
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!sentryId.equals(replayId)) {
            return replayId;
        }
        SentryId replayId2 = this.f27856b.getReplayId();
        return !sentryId.equals(replayId2) ? replayId2 : this.f27855a.getReplayId();
    }

    @Override // io.sentry.c1
    @Nullable
    public Request getRequest() {
        Request request = this.f27857c.getRequest();
        if (request != null) {
            return request;
        }
        Request request2 = this.f27856b.getRequest();
        return request2 != null ? request2 : this.f27855a.getRequest();
    }

    @Override // io.sentry.c1
    @Nullable
    public String getScreen() {
        String screen = this.f27857c.getScreen();
        if (screen != null) {
            return screen;
        }
        String screen2 = this.f27856b.getScreen();
        return screen2 != null ? screen2 : this.f27855a.getScreen();
    }

    @Override // io.sentry.c1
    @Nullable
    public e8 getSession() {
        e8 session = this.f27857c.getSession();
        if (session != null) {
            return session;
        }
        e8 session2 = this.f27856b.getSession();
        return session2 != null ? session2 : this.f27855a.getSession();
    }

    @Override // io.sentry.c1
    @Nullable
    public n1 getSpan() {
        n1 span = this.f27857c.getSpan();
        if (span != null) {
            return span;
        }
        n1 span2 = this.f27856b.getSpan();
        return span2 != null ? span2 : this.f27855a.getSpan();
    }

    @Override // io.sentry.c1
    @NotNull
    public Map<String, String> getTags() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.putAll(this.f27855a.getTags());
        concurrentHashMap.putAll(this.f27856b.getTags());
        concurrentHashMap.putAll(this.f27857c.getTags());
        return concurrentHashMap;
    }

    @Override // io.sentry.c1
    @Nullable
    public p1 getTransaction() {
        p1 transaction = this.f27857c.getTransaction();
        if (transaction != null) {
            return transaction;
        }
        p1 transaction2 = this.f27856b.getTransaction();
        return transaction2 != null ? transaction2 : this.f27855a.getTransaction();
    }

    @Override // io.sentry.c1
    @Nullable
    public String getTransactionName() {
        String transactionName = this.f27857c.getTransactionName();
        if (transactionName != null) {
            return transactionName;
        }
        String transactionName2 = this.f27856b.getTransactionName();
        return transactionName2 != null ? transactionName2 : this.f27855a.getTransactionName();
    }

    @Override // io.sentry.c1
    @Nullable
    public User getUser() {
        User user = this.f27857c.getUser();
        if (user != null) {
            return user;
        }
        User user2 = this.f27856b.getUser();
        return user2 != null ? user2 : this.f27855a.getUser();
    }

    @Override // io.sentry.c1
    public void removeExtra(@Nullable String str) {
        a().removeExtra(str);
    }

    @Override // io.sentry.c1
    public void removeTag(@Nullable String str) {
        a().removeTag(str);
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    public void replaceOptions(@NotNull SentryOptions sentryOptions) {
        this.f27855a.replaceOptions(sentryOptions);
    }

    @Override // io.sentry.c1
    public void setExtra(@Nullable String str, @Nullable String str2) {
        a().setExtra(str, str2);
    }

    @Override // io.sentry.c1
    public void setFingerprint(@NotNull List<String> list) {
        a().setFingerprint(list);
    }

    @Override // io.sentry.c1
    public void setLastEventId(@NotNull SentryId sentryId) {
        this.f27855a.setLastEventId(sentryId);
        this.f27856b.setLastEventId(sentryId);
        this.f27857c.setLastEventId(sentryId);
    }

    @Override // io.sentry.c1
    public void setLevel(@Nullable SentryLevel sentryLevel) {
        a().setLevel(sentryLevel);
    }

    @Override // io.sentry.c1
    public void setPropagationContext(@NotNull z3 z3Var) {
        a().setPropagationContext(z3Var);
    }

    @Override // io.sentry.c1
    public void setScreen(@Nullable String str) {
        a().setScreen(str);
    }

    @Override // io.sentry.c1
    public void setSpanContext(@NotNull Throwable th, @NotNull n1 n1Var, @NotNull String str) {
        this.f27855a.setSpanContext(th, n1Var, str);
    }

    @Override // io.sentry.c1
    public void setTag(@Nullable String str, @Nullable String str2) {
        a().setTag(str, str2);
    }

    @Override // io.sentry.c1
    public void setTransaction(@NotNull String str) {
        a().setTransaction(str);
    }

    @Override // io.sentry.c1
    public void setUser(@Nullable User user) {
        a().setUser(user);
    }

    @Override // io.sentry.c1
    @Nullable
    public Scope.d startSession() {
        return a().startSession();
    }

    @Override // io.sentry.c1
    @NotNull
    public z3 withPropagationContext(Scope.a aVar) {
        return a().withPropagationContext(aVar);
    }

    @Override // io.sentry.c1
    @Nullable
    public e8 withSession(Scope.b bVar) {
        return a().withSession(bVar);
    }

    @Override // io.sentry.c1
    public void withTransaction(Scope.c cVar) {
        a().withTransaction(cVar);
    }

    @Override // io.sentry.c1
    @NotNull
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public c1 m4211clone() {
        return new i(this.f27855a, this.f27856b.m4210clone(), this.f27857c.m4210clone());
    }

    @Override // io.sentry.c1
    public void setTransaction(@Nullable p1 p1Var) {
        a().setTransaction(p1Var);
    }
}
