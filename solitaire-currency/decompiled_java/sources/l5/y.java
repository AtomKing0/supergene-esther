package l5;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: LazySet.java */
/* JADX INFO: loaded from: classes3.dex */
class y<T> implements w5.b<Set<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Set<T> f30901b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Set<w5.b<T>> f30900a = Collections.newSetFromMap(new ConcurrentHashMap());

    y(Collection<w5.b<T>> collection) {
        this.f30900a.addAll(collection);
    }

    static y<?> b(Collection<w5.b<?>> collection) {
        return new y<>((Set) collection);
    }

    private synchronized void d() {
        Iterator<w5.b<T>> it = this.f30900a.iterator();
        while (it.hasNext()) {
            this.f30901b.add(it.next().get());
        }
        this.f30900a = null;
    }

    synchronized void a(w5.b<T> bVar) {
        if (this.f30901b == null) {
            this.f30900a.add(bVar);
        } else {
            this.f30901b.add(bVar.get());
        }
    }

    @Override // w5.b
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Set<T> get() {
        if (this.f30901b == null) {
            synchronized (this) {
                if (this.f30901b == null) {
                    this.f30901b = Collections.newSetFromMap(new ConcurrentHashMap());
                    d();
                }
            }
        }
        return Collections.unmodifiableSet(this.f30901b);
    }
}
