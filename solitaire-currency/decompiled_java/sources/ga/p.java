package ga;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import la.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private Runnable f26188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private ExecutorService f26189d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f26186a = 64;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f26187b = 5;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final ArrayDeque<e.a> f26190e = new ArrayDeque<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final ArrayDeque<e.a> f26191f = new ArrayDeque<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final ArrayDeque<la.e> f26192g = new ArrayDeque<>();

    private final e.a d(String str) {
        for (e.a aVar : this.f26191f) {
            if (kotlin.jvm.internal.t.d(aVar.d(), str)) {
                return aVar;
            }
        }
        for (e.a aVar2 : this.f26190e) {
            if (kotlin.jvm.internal.t.d(aVar2.d(), str)) {
                return aVar2;
            }
        }
        return null;
    }

    private final <T> void e(Deque<T> deque, T t10) {
        Runnable runnableH;
        synchronized (this) {
            if (!deque.remove(t10)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnableH = h();
            k0 k0Var = k0.f35197a;
        }
        if (k() || runnableH == null) {
            return;
        }
        runnableH.run();
    }

    private final boolean k() {
        int i10;
        boolean z10;
        if (ha.d.f26515h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<e.a> it = this.f26190e.iterator();
            kotlin.jvm.internal.t.h(it, "readyAsyncCalls.iterator()");
            while (it.hasNext()) {
                e.a asyncCall = it.next();
                if (this.f26191f.size() >= i()) {
                    break;
                }
                if (asyncCall.c().get() < j()) {
                    it.remove();
                    asyncCall.c().incrementAndGet();
                    kotlin.jvm.internal.t.h(asyncCall, "asyncCall");
                    arrayList.add(asyncCall);
                    this.f26191f.add(asyncCall);
                }
            }
            z10 = l() > 0;
            k0 k0Var = k0.f35197a;
        }
        int size = arrayList.size();
        for (i10 = 0; i10 < size; i10++) {
            ((e.a) arrayList.get(i10)).a(c());
        }
        return z10;
    }

    public final void a(@NotNull e.a call) {
        e.a aVarD;
        kotlin.jvm.internal.t.i(call, "call");
        synchronized (this) {
            this.f26190e.add(call);
            if (!call.b().o() && (aVarD = d(call.d())) != null) {
                call.e(aVarD);
            }
            k0 k0Var = k0.f35197a;
        }
        k();
    }

    public final synchronized void b(@NotNull la.e call) {
        kotlin.jvm.internal.t.i(call, "call");
        this.f26192g.add(call);
    }

    @NotNull
    public final synchronized ExecutorService c() {
        ExecutorService executorService;
        if (this.f26189d == null) {
            this.f26189d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), ha.d.N(kotlin.jvm.internal.t.r(ha.d.f26516i, " Dispatcher"), false));
        }
        executorService = this.f26189d;
        kotlin.jvm.internal.t.f(executorService);
        return executorService;
    }

    public final void f(@NotNull e.a call) {
        kotlin.jvm.internal.t.i(call, "call");
        call.c().decrementAndGet();
        e(this.f26191f, call);
    }

    public final void g(@NotNull la.e call) {
        kotlin.jvm.internal.t.i(call, "call");
        e(this.f26192g, call);
    }

    @Nullable
    public final synchronized Runnable h() {
        return this.f26188c;
    }

    public final synchronized int i() {
        return this.f26186a;
    }

    public final synchronized int j() {
        return this.f26187b;
    }

    public final synchronized int l() {
        return this.f26191f.size() + this.f26192g.size();
    }
}
