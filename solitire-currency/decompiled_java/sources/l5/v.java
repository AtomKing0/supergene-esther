package l5;

import androidx.annotation.GuardedBy;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: EventBus.java */
/* JADX INFO: loaded from: classes3.dex */
class v implements t5.d, t5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    private final Map<Class<?>, ConcurrentHashMap<t5.b<Object>, Executor>> f30894a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy("this")
    private Queue<t5.a<?>> f30895b = new ArrayDeque();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f30896c;

    v(Executor executor) {
        this.f30896c = executor;
    }

    private synchronized Set<Map.Entry<t5.b<Object>, Executor>> f(t5.a<?> aVar) {
        ConcurrentHashMap<t5.b<Object>, Executor> concurrentHashMap;
        concurrentHashMap = this.f30894a.get(aVar.b());
        return concurrentHashMap == null ? Collections.emptySet() : concurrentHashMap.entrySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(Map.Entry entry, t5.a aVar) {
        ((t5.b) entry.getKey()).a(aVar);
    }

    @Override // t5.d
    public synchronized <T> void a(Class<T> cls, t5.b<? super T> bVar) {
        d0.b(cls);
        d0.b(bVar);
        if (this.f30894a.containsKey(cls)) {
            ConcurrentHashMap<t5.b<Object>, Executor> concurrentHashMap = this.f30894a.get(cls);
            concurrentHashMap.remove(bVar);
            if (concurrentHashMap.isEmpty()) {
                this.f30894a.remove(cls);
            }
        }
    }

    @Override // t5.d
    public synchronized <T> void b(Class<T> cls, Executor executor, t5.b<? super T> bVar) {
        d0.b(cls);
        d0.b(bVar);
        d0.b(executor);
        if (!this.f30894a.containsKey(cls)) {
            this.f30894a.put(cls, new ConcurrentHashMap<>());
        }
        this.f30894a.get(cls).put(bVar, executor);
    }

    @Override // t5.d
    public <T> void c(Class<T> cls, t5.b<? super T> bVar) {
        b(cls, this.f30896c, bVar);
    }

    void e() {
        Queue<t5.a<?>> queue;
        synchronized (this) {
            queue = this.f30895b;
            if (queue != null) {
                this.f30895b = null;
            } else {
                queue = null;
            }
        }
        if (queue != null) {
            Iterator<t5.a<?>> it = queue.iterator();
            while (it.hasNext()) {
                h(it.next());
            }
        }
    }

    public void h(final t5.a<?> aVar) {
        d0.b(aVar);
        synchronized (this) {
            Queue<t5.a<?>> queue = this.f30895b;
            if (queue != null) {
                queue.add(aVar);
                return;
            }
            for (final Map.Entry<t5.b<Object>, Executor> entry : f(aVar)) {
                entry.getValue().execute(new Runnable() { // from class: l5.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.g(entry, aVar);
                    }
                });
            }
        }
    }
}
