package p1;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: FactoryPools.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final g<Object> f32415a = new C0648a();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: FactoryPools.java */
    class b<T> implements d<List<T>> {
        b() {
        }

        @Override // p1.a.d
        @NonNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public List<T> a() {
            return new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: FactoryPools.java */
    class c<T> implements g<List<T>> {
        c() {
        }

        @Override // p1.a.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NonNull List<T> list) {
            list.clear();
        }
    }

    /* JADX INFO: compiled from: FactoryPools.java */
    public interface d<T> {
        T a();
    }

    /* JADX INFO: compiled from: FactoryPools.java */
    private static final class e<T> implements Pools.Pool<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d<T> f32416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final g<T> f32417b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Pools.Pool<T> f32418c;

        e(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar, @NonNull g<T> gVar) {
            this.f32418c = pool;
            this.f32416a = dVar;
            this.f32417b = gVar;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T tAcquire = this.f32418c.acquire();
            if (tAcquire == null) {
                tAcquire = this.f32416a.a();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + tAcquire.getClass());
                }
            }
            if (tAcquire instanceof f) {
                ((f) tAcquire).c().b(false);
            }
            return tAcquire;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t10) {
            if (t10 instanceof f) {
                ((f) t10).c().b(true);
            }
            this.f32417b.a(t10);
            return this.f32418c.release(t10);
        }
    }

    /* JADX INFO: compiled from: FactoryPools.java */
    public interface f {
        @NonNull
        p1.c c();
    }

    /* JADX INFO: compiled from: FactoryPools.java */
    public interface g<T> {
        void a(@NonNull T t10);
    }

    @NonNull
    private static <T extends f> Pools.Pool<T> a(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar) {
        return b(pool, dVar, c());
    }

    @NonNull
    private static <T> Pools.Pool<T> b(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar, @NonNull g<T> gVar) {
        return new e(pool, dVar, gVar);
    }

    @NonNull
    private static <T> g<T> c() {
        return (g<T>) f32415a;
    }

    @NonNull
    public static <T extends f> Pools.Pool<T> d(int i10, @NonNull d<T> dVar) {
        return a(new Pools.SynchronizedPool(i10), dVar);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> e() {
        return f(20);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> f(int i10) {
        return b(new Pools.SynchronizedPool(i10), new b(), new c());
    }

    /* JADX INFO: renamed from: p1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FactoryPools.java */
    class C0648a implements g<Object> {
        C0648a() {
        }

        @Override // p1.a.g
        public void a(@NonNull Object obj) {
        }
    }
}
