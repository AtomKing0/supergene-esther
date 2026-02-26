package io.sentry;

import io.sentry.SentryOptions;
import io.sentry.protocol.App;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.Request;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.TransactionNameSource;
import io.sentry.protocol.User;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class Scope implements c1 {

    @NotNull
    private WeakReference<n1> activeSpan;

    @NotNull
    private List<io.sentry.b> attachments;

    @NotNull
    private volatile Queue<Breadcrumb> breadcrumbs;

    @NotNull
    private i1 client;

    @NotNull
    private Contexts contexts;

    @NotNull
    private List<io.sentry.internal.eventprocessor.a> eventProcessors;

    @NotNull
    private Map<String, Object> extra;

    @NotNull
    private List<String> fingerprint;

    @NotNull
    private volatile SentryId lastEventId;

    @Nullable
    private SentryLevel level;

    @NotNull
    private volatile SentryOptions options;

    @NotNull
    private z3 propagationContext;

    @NotNull
    private final io.sentry.util.a propagationContextLock;

    @NotNull
    private SentryId replayId;

    @Nullable
    private Request request;

    @Nullable
    private String screen;

    @Nullable
    private volatile e8 session;

    @NotNull
    private final io.sentry.util.a sessionLock;

    @NotNull
    private Map<String, String> tags;

    @NotNull
    private final Map<Throwable, io.sentry.util.x<WeakReference<n1>, String>> throwableToSpan;

    @Nullable
    private p1 transaction;

    @NotNull
    private final io.sentry.util.a transactionLock;

    @Nullable
    private String transactionName;

    @Nullable
    private User user;

    @ApiStatus.Internal
    public interface a {
        void a(@NotNull z3 z3Var);
    }

    interface b {
        void a(@Nullable e8 e8Var);
    }

    @ApiStatus.Internal
    public interface c {
        void a(@Nullable p1 p1Var);
    }

    static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private final e8 f26949a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final e8 f26950b;

        public d(@NotNull e8 e8Var, @Nullable e8 e8Var2) {
            this.f26950b = e8Var;
            this.f26949a = e8Var2;
        }

        @NotNull
        public e8 a() {
            return this.f26950b;
        }

        @Nullable
        public e8 b() {
            return this.f26949a;
        }
    }

    public Scope(@NotNull SentryOptions sentryOptions) {
        this.activeSpan = new WeakReference<>(null);
        this.fingerprint = new ArrayList();
        this.tags = new ConcurrentHashMap();
        this.extra = new ConcurrentHashMap();
        this.eventProcessors = new CopyOnWriteArrayList();
        this.sessionLock = new io.sentry.util.a();
        this.transactionLock = new io.sentry.util.a();
        this.propagationContextLock = new io.sentry.util.a();
        this.contexts = new Contexts();
        this.attachments = new CopyOnWriteArrayList();
        SentryId sentryId = SentryId.EMPTY_ID;
        this.replayId = sentryId;
        this.client = y2.p();
        this.throwableToSpan = Collections.synchronizedMap(new WeakHashMap());
        this.options = (SentryOptions) io.sentry.util.w.c(sentryOptions, "SentryOptions is required.");
        this.breadcrumbs = createBreadcrumbsList(this.options.getMaxBreadcrumbs());
        this.propagationContext = new z3();
        this.lastEventId = sentryId;
    }

    @NotNull
    static Queue<Breadcrumb> createBreadcrumbsList(int i10) {
        return i10 > 0 ? t8.d(new g(i10)) : t8.d(new x());
    }

    @Nullable
    private Breadcrumb executeBeforeBreadcrumb(@NotNull SentryOptions.a aVar, @NotNull Breadcrumb breadcrumb, @NotNull l0 l0Var) {
        try {
            return aVar.a(breadcrumb, l0Var);
        } catch (Throwable th) {
            this.options.getLogger().b(SentryLevel.ERROR, "The BeforeBreadcrumbCallback callback threw an exception. Exception details will be added to the breadcrumb.", th);
            if (th.getMessage() == null) {
                return breadcrumb;
            }
            breadcrumb.setData("sentry:message", th.getMessage());
            return breadcrumb;
        }
    }

    public void addAttachment(@NotNull io.sentry.b bVar) {
        this.attachments.add(bVar);
    }

    @Override // io.sentry.c1
    public void addBreadcrumb(@NotNull Breadcrumb breadcrumb, @Nullable l0 l0Var) {
        if (breadcrumb == null) {
            return;
        }
        if (l0Var == null) {
            new l0();
        }
        this.options.getBeforeBreadcrumb();
        this.breadcrumbs.add(breadcrumb);
        for (d1 d1Var : this.options.getScopeObservers()) {
            d1Var.c(breadcrumb);
            d1Var.d(this.breadcrumbs);
        }
    }

    public void addEventProcessor(@NotNull g0 g0Var) {
        this.eventProcessors.add(new io.sentry.internal.eventprocessor.a(g0Var, g0Var.getOrder()));
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    public void assignTraceContext(@NotNull r6 r6Var) {
        io.sentry.util.x<WeakReference<n1>, String> xVar;
        n1 n1Var;
        if (!this.options.isTracingEnabled() || r6Var.getThrowable() == null || (xVar = this.throwableToSpan.get(io.sentry.util.g.a(r6Var.getThrowable()))) == null) {
            return;
        }
        WeakReference<n1> weakReferenceA = xVar.a();
        if (r6Var.getContexts().getTrace() == null && weakReferenceA != null && (n1Var = weakReferenceA.get()) != null) {
            r6Var.getContexts().setTrace(n1Var.r());
        }
        String strB = xVar.b();
        if (r6Var.getTransaction() != null || strB == null) {
            return;
        }
        r6Var.A(strB);
    }

    @Override // io.sentry.c1
    public void bindClient(@NotNull i1 i1Var) {
        this.client = i1Var;
    }

    @Override // io.sentry.c1
    public void clear() {
        this.level = null;
        this.user = null;
        this.request = null;
        this.screen = null;
        this.fingerprint.clear();
        clearBreadcrumbs();
        this.tags.clear();
        this.extra.clear();
        this.eventProcessors.clear();
        clearTransaction();
        clearAttachments();
    }

    public void clearAttachments() {
        this.attachments.clear();
    }

    @Override // io.sentry.c1
    public void clearBreadcrumbs() {
        this.breadcrumbs.clear();
        Iterator<d1> it = this.options.getScopeObservers().iterator();
        while (it.hasNext()) {
            it.next().d(this.breadcrumbs);
        }
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    public void clearSession() {
        this.session = null;
    }

    @Override // io.sentry.c1
    public void clearTransaction() {
        k1 k1VarA = this.transactionLock.a();
        try {
            this.transaction = null;
            if (k1VarA != null) {
                k1VarA.close();
            }
            this.transactionName = null;
            for (d1 d1Var : this.options.getScopeObservers()) {
                d1Var.setTransaction(null);
                d1Var.f(null, this);
            }
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @Nullable
    public e8 endSession() {
        k1 k1VarA = this.sessionLock.a();
        try {
            e8 e8Var = null;
            if (this.session != null) {
                this.session.c();
                this.options.getContinuousProfiler().d();
                e8 e8VarClone = this.session.clone();
                this.session = null;
                e8Var = e8VarClone;
            }
            if (k1VarA != null) {
                k1VarA.close();
            }
            return e8Var;
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @NotNull
    public List<io.sentry.b> getAttachments() {
        return new CopyOnWriteArrayList(this.attachments);
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @NotNull
    public Queue<Breadcrumb> getBreadcrumbs() {
        return this.breadcrumbs;
    }

    @Override // io.sentry.c1
    @NotNull
    public i1 getClient() {
        return this.client;
    }

    @Override // io.sentry.c1
    @NotNull
    public Contexts getContexts() {
        return this.contexts;
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @NotNull
    public List<g0> getEventProcessors() {
        return io.sentry.util.f.a(this.eventProcessors);
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @NotNull
    public List<io.sentry.internal.eventprocessor.a> getEventProcessorsWithOrder() {
        return this.eventProcessors;
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @NotNull
    public Map<String, Object> getExtras() {
        return this.extra;
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @NotNull
    public List<String> getFingerprint() {
        return this.fingerprint;
    }

    @Override // io.sentry.c1
    @NotNull
    public SentryId getLastEventId() {
        return this.lastEventId;
    }

    @Override // io.sentry.c1
    @Nullable
    public SentryLevel getLevel() {
        return this.level;
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @NotNull
    public SentryOptions getOptions() {
        return this.options;
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @NotNull
    public z3 getPropagationContext() {
        return this.propagationContext;
    }

    @Override // io.sentry.c1
    @NotNull
    public SentryId getReplayId() {
        return this.replayId;
    }

    @Override // io.sentry.c1
    @Nullable
    public Request getRequest() {
        return this.request;
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @Nullable
    public String getScreen() {
        return this.screen;
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @Nullable
    public e8 getSession() {
        return this.session;
    }

    @Override // io.sentry.c1
    @Nullable
    public n1 getSpan() {
        n1 n1VarO;
        n1 n1Var = this.activeSpan.get();
        if (n1Var != null) {
            return n1Var;
        }
        p1 p1Var = this.transaction;
        return (p1Var == null || (n1VarO = p1Var.o()) == null) ? p1Var : n1VarO;
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @NotNull
    public Map<String, String> getTags() {
        return io.sentry.util.c.b(this.tags);
    }

    @Override // io.sentry.c1
    @Nullable
    public p1 getTransaction() {
        return this.transaction;
    }

    @Override // io.sentry.c1
    @Nullable
    public String getTransactionName() {
        p1 p1Var = this.transaction;
        return p1Var != null ? p1Var.getName() : this.transactionName;
    }

    @Override // io.sentry.c1
    @Nullable
    public User getUser() {
        return this.user;
    }

    public void removeContexts(@Nullable String str) {
        if (str == null) {
            return;
        }
        this.contexts.remove(str);
    }

    @Override // io.sentry.c1
    public void removeExtra(@Nullable String str) {
        if (str == null) {
            return;
        }
        this.extra.remove(str);
        for (d1 d1Var : this.options.getScopeObservers()) {
            d1Var.removeExtra(str);
            d1Var.i(this.extra);
        }
    }

    @Override // io.sentry.c1
    public void removeTag(@Nullable String str) {
        if (str == null) {
            return;
        }
        this.tags.remove(str);
        for (d1 d1Var : this.options.getScopeObservers()) {
            d1Var.removeTag(str);
            d1Var.a(this.tags);
        }
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    public void replaceOptions(@NotNull SentryOptions sentryOptions) {
        this.options = sentryOptions;
        Queue<Breadcrumb> queue = this.breadcrumbs;
        this.breadcrumbs = createBreadcrumbsList(sentryOptions.getMaxBreadcrumbs());
        Iterator<Breadcrumb> it = queue.iterator();
        while (it.hasNext()) {
            addBreadcrumb(it.next());
        }
    }

    public void setActiveSpan(@Nullable n1 n1Var) {
        this.activeSpan = new WeakReference<>(n1Var);
    }

    public void setContexts(@Nullable String str, @Nullable Object obj) {
        if (str == null) {
            return;
        }
        this.contexts.put(str, obj);
        Iterator<d1> it = this.options.getScopeObservers().iterator();
        while (it.hasNext()) {
            it.next().g(this.contexts);
        }
    }

    @Override // io.sentry.c1
    public void setExtra(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            return;
        }
        if (str2 == null) {
            removeExtra(str);
            return;
        }
        this.extra.put(str, str2);
        for (d1 d1Var : this.options.getScopeObservers()) {
            d1Var.setExtra(str, str2);
            d1Var.i(this.extra);
        }
    }

    @Override // io.sentry.c1
    public void setFingerprint(@NotNull List<String> list) {
        if (list == null) {
            return;
        }
        this.fingerprint = new ArrayList(list);
        Iterator<d1> it = this.options.getScopeObservers().iterator();
        while (it.hasNext()) {
            it.next().e(list);
        }
    }

    @Override // io.sentry.c1
    public void setLastEventId(@NotNull SentryId sentryId) {
        this.lastEventId = sentryId;
    }

    @Override // io.sentry.c1
    public void setLevel(@Nullable SentryLevel sentryLevel) {
        this.level = sentryLevel;
        Iterator<d1> it = this.options.getScopeObservers().iterator();
        while (it.hasNext()) {
            it.next().setLevel(sentryLevel);
        }
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    public void setPropagationContext(@NotNull z3 z3Var) {
        this.propagationContext = z3Var;
        j8 j8VarJ = z3Var.j();
        Iterator<d1> it = this.options.getScopeObservers().iterator();
        while (it.hasNext()) {
            it.next().f(j8VarJ, this);
        }
    }

    public void setReplayId(@NotNull SentryId sentryId) {
        this.replayId = sentryId;
        Iterator<d1> it = this.options.getScopeObservers().iterator();
        while (it.hasNext()) {
            it.next().j(sentryId);
        }
    }

    public void setRequest(@Nullable Request request) {
        this.request = request;
        Iterator<d1> it = this.options.getScopeObservers().iterator();
        while (it.hasNext()) {
            it.next().h(request);
        }
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    public void setScreen(@Nullable String str) {
        this.screen = str;
        Contexts contexts = getContexts();
        App app = contexts.getApp();
        if (app == null) {
            app = new App();
            contexts.setApp(app);
        }
        if (str == null) {
            app.setViewNames(null);
        } else {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(str);
            app.setViewNames(arrayList);
        }
        Iterator<d1> it = this.options.getScopeObservers().iterator();
        while (it.hasNext()) {
            it.next().g(contexts);
        }
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    public void setSpanContext(@NotNull Throwable th, @NotNull n1 n1Var, @NotNull String str) {
        io.sentry.util.w.c(th, "throwable is required");
        io.sentry.util.w.c(n1Var, "span is required");
        io.sentry.util.w.c(str, "transactionName is required");
        Throwable thA = io.sentry.util.g.a(th);
        if (this.throwableToSpan.containsKey(thA)) {
            return;
        }
        this.throwableToSpan.put(thA, new io.sentry.util.x<>(new WeakReference(n1Var), str));
    }

    @Override // io.sentry.c1
    public void setTag(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            return;
        }
        if (str2 == null) {
            removeTag(str);
            return;
        }
        this.tags.put(str, str2);
        for (d1 d1Var : this.options.getScopeObservers()) {
            d1Var.setTag(str, str2);
            d1Var.a(this.tags);
        }
    }

    @Override // io.sentry.c1
    public void setTransaction(@NotNull String str) {
        if (str == null) {
            this.options.getLogger().c(SentryLevel.WARNING, "Transaction cannot be null", new Object[0]);
            return;
        }
        p1 p1Var = this.transaction;
        if (p1Var != null) {
            p1Var.c(str, TransactionNameSource.CUSTOM);
        }
        this.transactionName = str;
        Iterator<d1> it = this.options.getScopeObservers().iterator();
        while (it.hasNext()) {
            it.next().setTransaction(str);
        }
    }

    @Override // io.sentry.c1
    public void setUser(@Nullable User user) {
        this.user = user;
        Iterator<d1> it = this.options.getScopeObservers().iterator();
        while (it.hasNext()) {
            it.next().setUser(user);
        }
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @Nullable
    public d startSession() {
        k1 k1VarA = this.sessionLock.a();
        try {
            if (this.session != null) {
                this.session.c();
                this.options.getContinuousProfiler().d();
            }
            e8 e8Var = this.session;
            d dVar = null;
            if (this.options.getRelease() != null) {
                this.session = new e8(this.options.getDistinctId(), this.user, this.options.getEnvironment(), this.options.getRelease());
                dVar = new d(this.session.clone(), e8Var != null ? e8Var.clone() : null);
            } else {
                this.options.getLogger().c(SentryLevel.WARNING, "Release is not set on SentryOptions. Session could not be started", new Object[0]);
            }
            if (k1VarA != null) {
                k1VarA.close();
            }
            return dVar;
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @NotNull
    public z3 withPropagationContext(@NotNull a aVar) {
        k1 k1VarA = this.propagationContextLock.a();
        try {
            aVar.a(this.propagationContext);
            z3 z3Var = new z3(this.propagationContext);
            if (k1VarA != null) {
                k1VarA.close();
            }
            return z3Var;
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    @Nullable
    public e8 withSession(@NotNull b bVar) {
        k1 k1VarA = this.sessionLock.a();
        try {
            bVar.a(this.session);
            e8 e8VarClone = this.session != null ? this.session.clone() : null;
            if (k1VarA != null) {
                k1VarA.close();
            }
            return e8VarClone;
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // io.sentry.c1
    @ApiStatus.Internal
    public void withTransaction(@NotNull c cVar) {
        k1 k1VarA = this.transactionLock.a();
        try {
            cVar.a(this.transaction);
            if (k1VarA != null) {
                k1VarA.close();
            }
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // io.sentry.c1
    @NotNull
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public c1 m4210clone() {
        return new Scope(this);
    }

    public void setContexts(@Nullable String str, @Nullable Boolean bool) {
        if (str == null) {
            return;
        }
        if (bool == null) {
            setContexts(str, (Object) null);
            return;
        }
        HashMap map = new HashMap();
        map.put("value", bool);
        setContexts(str, map);
    }

    public void addBreadcrumb(@NotNull Breadcrumb breadcrumb) {
        addBreadcrumb(breadcrumb, null);
    }

    @Override // io.sentry.c1
    public void setTransaction(@Nullable p1 p1Var) {
        k1 k1VarA = this.transactionLock.a();
        try {
            this.transaction = p1Var;
            for (d1 d1Var : this.options.getScopeObservers()) {
                if (p1Var != null) {
                    d1Var.setTransaction(p1Var.getName());
                    d1Var.f(p1Var.r(), this);
                } else {
                    d1Var.setTransaction(null);
                    d1Var.f(null, this);
                }
            }
            if (k1VarA != null) {
                k1VarA.close();
            }
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void setContexts(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            return;
        }
        if (str2 == null) {
            setContexts(str, (Object) null);
            return;
        }
        HashMap map = new HashMap();
        map.put("value", str2);
        setContexts(str, map);
    }

    public void setContexts(@Nullable String str, @Nullable Number number) {
        if (str == null) {
            return;
        }
        if (number == null) {
            setContexts(str, (Object) null);
            return;
        }
        HashMap map = new HashMap();
        map.put("value", number);
        setContexts(str, map);
    }

    public void setContexts(@Nullable String str, @Nullable Collection<?> collection) {
        if (str == null) {
            return;
        }
        if (collection == null) {
            setContexts(str, (Object) null);
            return;
        }
        HashMap map = new HashMap();
        map.put("value", collection);
        setContexts(str, map);
    }

    private Scope(@NotNull Scope scope) {
        this.activeSpan = new WeakReference<>(null);
        this.fingerprint = new ArrayList();
        this.tags = new ConcurrentHashMap();
        this.extra = new ConcurrentHashMap();
        this.eventProcessors = new CopyOnWriteArrayList();
        this.sessionLock = new io.sentry.util.a();
        this.transactionLock = new io.sentry.util.a();
        this.propagationContextLock = new io.sentry.util.a();
        this.contexts = new Contexts();
        this.attachments = new CopyOnWriteArrayList();
        this.replayId = SentryId.EMPTY_ID;
        this.client = y2.p();
        this.throwableToSpan = Collections.synchronizedMap(new WeakHashMap());
        this.transaction = scope.transaction;
        this.transactionName = scope.transactionName;
        this.session = scope.session;
        this.options = scope.options;
        this.level = scope.level;
        this.client = scope.client;
        this.lastEventId = scope.getLastEventId();
        User user = scope.user;
        this.user = user != null ? new User(user) : null;
        this.screen = scope.screen;
        this.replayId = scope.replayId;
        Request request = scope.request;
        this.request = request != null ? new Request(request) : null;
        this.fingerprint = new ArrayList(scope.fingerprint);
        this.eventProcessors = new CopyOnWriteArrayList(scope.eventProcessors);
        Breadcrumb[] breadcrumbArr = (Breadcrumb[]) scope.breadcrumbs.toArray(new Breadcrumb[0]);
        Queue<Breadcrumb> queueCreateBreadcrumbsList = createBreadcrumbsList(scope.options.getMaxBreadcrumbs());
        for (Breadcrumb breadcrumb : breadcrumbArr) {
            queueCreateBreadcrumbsList.add(new Breadcrumb(breadcrumb));
        }
        this.breadcrumbs = queueCreateBreadcrumbsList;
        Map<String, String> map = scope.tags;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                concurrentHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        this.tags = concurrentHashMap;
        Map<String, Object> map2 = scope.extra;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        for (Map.Entry<String, Object> entry2 : map2.entrySet()) {
            if (entry2 != null) {
                concurrentHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        this.extra = concurrentHashMap2;
        this.contexts = new Contexts(scope.contexts);
        this.attachments = new CopyOnWriteArrayList(scope.attachments);
        this.propagationContext = new z3(scope.propagationContext);
    }

    public void setContexts(@Nullable String str, @Nullable Object[] objArr) {
        if (str == null) {
            return;
        }
        if (objArr == null) {
            setContexts(str, (Object) null);
            return;
        }
        HashMap map = new HashMap();
        map.put("value", objArr);
        setContexts(str, map);
    }

    public void setContexts(@Nullable String str, @Nullable Character ch) {
        if (str == null) {
            return;
        }
        if (ch == null) {
            setContexts(str, (Object) null);
            return;
        }
        HashMap map = new HashMap();
        map.put("value", ch);
        setContexts(str, map);
    }
}
