package l5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: Component.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f30829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<e0<? super T>> f30830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<r> f30831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f30832d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f30833e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final h<T> f30834f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Set<Class<?>> f30835g;

    public static <T> b<T> c(Class<T> cls) {
        return new b<>(cls, new Class[0]);
    }

    @SafeVarargs
    public static <T> b<T> d(Class<T> cls, Class<? super T>... clsArr) {
        return new b<>(cls, clsArr);
    }

    public static <T> b<T> e(e0<T> e0Var) {
        return new b<>(e0Var, new e0[0]);
    }

    @SafeVarargs
    public static <T> b<T> f(e0<T> e0Var, e0<? super T>... e0VarArr) {
        return new b<>(e0Var, e0VarArr);
    }

    public static <T> c<T> l(final T t10, Class<T> cls) {
        return m(cls).f(new h() { // from class: l5.a
            @Override // l5.h
            public final Object a(e eVar) {
                return c.q(t10, eVar);
            }
        }).d();
    }

    public static <T> b<T> m(Class<T> cls) {
        return c(cls).g();
    }

    @SafeVarargs
    public static <T> c<T> s(final T t10, Class<T> cls, Class<? super T>... clsArr) {
        return d(cls, clsArr).f(new h() { // from class: l5.b
            @Override // l5.h
            public final Object a(e eVar) {
                return c.r(t10, eVar);
            }
        }).d();
    }

    public Set<r> g() {
        return this.f30831c;
    }

    public h<T> h() {
        return this.f30834f;
    }

    @Nullable
    public String i() {
        return this.f30829a;
    }

    public Set<e0<? super T>> j() {
        return this.f30830b;
    }

    public Set<Class<?>> k() {
        return this.f30835g;
    }

    public boolean n() {
        return this.f30832d == 1;
    }

    public boolean o() {
        return this.f30832d == 2;
    }

    public boolean p() {
        return this.f30833e == 0;
    }

    public c<T> t(h<T> hVar) {
        return new c<>(this.f30829a, this.f30830b, this.f30831c, this.f30832d, this.f30833e, hVar, this.f30835g);
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f30830b.toArray()) + ">{" + this.f30832d + ", type=" + this.f30833e + ", deps=" + Arrays.toString(this.f30831c.toArray()) + "}";
    }

    /* JADX INFO: compiled from: Component.java */
    public static class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f30836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set<e0<? super T>> f30837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Set<r> f30838c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f30839d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f30840e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private h<T> f30841f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Set<Class<?>> f30842g;

        /* JADX INFO: Access modifiers changed from: private */
        public b<T> g() {
            this.f30840e = 1;
            return this;
        }

        private b<T> i(int i10) {
            d0.d(this.f30839d == 0, "Instantiation type has already been set.");
            this.f30839d = i10;
            return this;
        }

        private void j(e0<?> e0Var) {
            d0.a(!this.f30837b.contains(e0Var), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        public b<T> b(r rVar) {
            d0.c(rVar, "Null dependency");
            j(rVar.b());
            this.f30838c.add(rVar);
            return this;
        }

        public b<T> c() {
            return i(1);
        }

        public c<T> d() {
            d0.d(this.f30841f != null, "Missing required property: factory.");
            return new c<>(this.f30836a, new HashSet(this.f30837b), new HashSet(this.f30838c), this.f30839d, this.f30840e, this.f30841f, this.f30842g);
        }

        public b<T> e() {
            return i(2);
        }

        public b<T> f(h<T> hVar) {
            this.f30841f = (h) d0.c(hVar, "Null factory");
            return this;
        }

        public b<T> h(@NonNull String str) {
            this.f30836a = str;
            return this;
        }

        @SafeVarargs
        private b(Class<T> cls, Class<? super T>... clsArr) {
            this.f30836a = null;
            HashSet hashSet = new HashSet();
            this.f30837b = hashSet;
            this.f30838c = new HashSet();
            this.f30839d = 0;
            this.f30840e = 0;
            this.f30842g = new HashSet();
            d0.c(cls, "Null interface");
            hashSet.add(e0.b(cls));
            for (Class<? super T> cls2 : clsArr) {
                d0.c(cls2, "Null interface");
                this.f30837b.add(e0.b(cls2));
            }
        }

        @SafeVarargs
        private b(e0<T> e0Var, e0<? super T>... e0VarArr) {
            this.f30836a = null;
            HashSet hashSet = new HashSet();
            this.f30837b = hashSet;
            this.f30838c = new HashSet();
            this.f30839d = 0;
            this.f30840e = 0;
            this.f30842g = new HashSet();
            d0.c(e0Var, "Null interface");
            hashSet.add(e0Var);
            for (e0<? super T> e0Var2 : e0VarArr) {
                d0.c(e0Var2, "Null interface");
            }
            Collections.addAll(this.f30837b, e0VarArr);
        }
    }

    private c(@Nullable String str, Set<e0<? super T>> set, Set<r> set2, int i10, int i11, h<T> hVar, Set<Class<?>> set3) {
        this.f30829a = str;
        this.f30830b = Collections.unmodifiableSet(set);
        this.f30831c = Collections.unmodifiableSet(set2);
        this.f30832d = i10;
        this.f30833e = i11;
        this.f30834f = hVar;
        this.f30835g = Collections.unmodifiableSet(set3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object q(Object obj, e eVar) {
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object r(Object obj, e eVar) {
        return obj;
    }
}
