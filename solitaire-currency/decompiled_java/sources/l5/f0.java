package l5;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: RestrictedComponentContainer.java */
/* JADX INFO: loaded from: classes3.dex */
final class f0 implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<e0<?>> f30850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<e0<?>> f30851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<e0<?>> f30852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set<e0<?>> f30853d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set<e0<?>> f30854e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set<Class<?>> f30855f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final e f30856g;

    /* JADX INFO: compiled from: RestrictedComponentContainer.java */
    private static class a implements t5.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set<Class<?>> f30857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final t5.c f30858b;

        public a(Set<Class<?>> set, t5.c cVar) {
            this.f30857a = set;
            this.f30858b = cVar;
        }
    }

    f0(c<?> cVar, e eVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (r rVar : cVar.g()) {
            if (rVar.d()) {
                if (rVar.f()) {
                    hashSet4.add(rVar.b());
                } else {
                    hashSet.add(rVar.b());
                }
            } else if (rVar.c()) {
                hashSet3.add(rVar.b());
            } else if (rVar.f()) {
                hashSet5.add(rVar.b());
            } else {
                hashSet2.add(rVar.b());
            }
        }
        if (!cVar.k().isEmpty()) {
            hashSet.add(e0.b(t5.c.class));
        }
        this.f30850a = Collections.unmodifiableSet(hashSet);
        this.f30851b = Collections.unmodifiableSet(hashSet2);
        this.f30852c = Collections.unmodifiableSet(hashSet3);
        this.f30853d = Collections.unmodifiableSet(hashSet4);
        this.f30854e = Collections.unmodifiableSet(hashSet5);
        this.f30855f = cVar.k();
        this.f30856g = eVar;
    }

    @Override // l5.e
    public <T> T a(Class<T> cls) {
        if (!this.f30850a.contains(e0.b(cls))) {
            throw new t(String.format("Attempting to request an undeclared dependency %s.", cls));
        }
        T t10 = (T) this.f30856g.a(cls);
        return !cls.equals(t5.c.class) ? t10 : (T) new a(this.f30855f, (t5.c) t10);
    }

    @Override // l5.e
    public <T> Set<T> b(e0<T> e0Var) {
        if (this.f30853d.contains(e0Var)) {
            return this.f30856g.b(e0Var);
        }
        throw new t(String.format("Attempting to request an undeclared dependency Set<%s>.", e0Var));
    }

    @Override // l5.e
    public <T> w5.b<T> c(e0<T> e0Var) {
        if (this.f30851b.contains(e0Var)) {
            return this.f30856g.c(e0Var);
        }
        throw new t(String.format("Attempting to request an undeclared dependency Provider<%s>.", e0Var));
    }

    @Override // l5.e
    public <T> T d(e0<T> e0Var) {
        if (this.f30850a.contains(e0Var)) {
            return (T) this.f30856g.d(e0Var);
        }
        throw new t(String.format("Attempting to request an undeclared dependency %s.", e0Var));
    }

    @Override // l5.e
    public <T> w5.b<Set<T>> e(e0<T> e0Var) {
        if (this.f30854e.contains(e0Var)) {
            return this.f30856g.e(e0Var);
        }
        throw new t(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", e0Var));
    }

    @Override // l5.e
    public /* synthetic */ Set f(Class cls) {
        return d.d(this, cls);
    }

    @Override // l5.e
    public <T> w5.b<T> g(Class<T> cls) {
        return c(e0.b(cls));
    }
}
