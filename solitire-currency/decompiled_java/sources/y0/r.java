package y0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import y0.n;

/* JADX INFO: compiled from: MultiModelLoaderFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final c f36319e = new c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final n<Object, Object> f36320f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<b<?, ?>> f36321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f36322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<b<?, ?>> f36323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f36324d;

    /* JADX INFO: compiled from: MultiModelLoaderFactory.java */
    private static class a implements n<Object, Object> {
        a() {
        }

        @Override // y0.n
        public boolean a(@NonNull Object obj) {
            return false;
        }

        @Override // y0.n
        @Nullable
        public n.a<Object> b(@NonNull Object obj, int i10, int i11, @NonNull r0.h hVar) {
            return null;
        }
    }

    /* JADX INFO: compiled from: MultiModelLoaderFactory.java */
    private static class b<Model, Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<Model> f36325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Class<Data> f36326b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final o<? extends Model, ? extends Data> f36327c;

        public b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
            this.f36325a = cls;
            this.f36326b = cls2;
            this.f36327c = oVar;
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.f36325a.isAssignableFrom(cls);
        }

        public boolean b(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return a(cls) && this.f36326b.isAssignableFrom(cls2);
        }
    }

    /* JADX INFO: compiled from: MultiModelLoaderFactory.java */
    static class c {
        c() {
        }

        @NonNull
        public <Model, Data> q<Model, Data> a(@NonNull List<n<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            return new q<>(list, pool);
        }
    }

    public r(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(pool, f36319e);
    }

    private <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar, boolean z10) {
        b<?, ?> bVar = new b<>(cls, cls2, oVar);
        List<b<?, ?>> list = this.f36321a;
        list.add(z10 ? list.size() : 0, bVar);
    }

    @NonNull
    private <Model, Data> n<Model, Data> e(@NonNull b<?, ?> bVar) {
        return (n) o1.j.d(bVar.f36327c.b(this));
    }

    @NonNull
    private static <Model, Data> n<Model, Data> f() {
        return (n<Model, Data>) f36320f;
    }

    synchronized <Model, Data> void b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        a(cls, cls2, oVar, true);
    }

    @NonNull
    synchronized <Model> List<n<Model, ?>> c(@NonNull Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.f36321a) {
                if (!this.f36323c.contains(bVar) && bVar.a(cls)) {
                    this.f36323c.add(bVar);
                    arrayList.add(e(bVar));
                    this.f36323c.remove(bVar);
                }
            }
        } catch (Throwable th) {
            this.f36323c.clear();
            throw th;
        }
        return arrayList;
    }

    @NonNull
    public synchronized <Model, Data> n<Model, Data> d(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z10 = false;
            for (b<?, ?> bVar : this.f36321a) {
                if (this.f36323c.contains(bVar)) {
                    z10 = true;
                } else if (bVar.b(cls, cls2)) {
                    this.f36323c.add(bVar);
                    arrayList.add(e(bVar));
                    this.f36323c.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.f36322b.a(arrayList, this.f36324d);
            }
            if (arrayList.size() == 1) {
                return (n) arrayList.get(0);
            }
            if (!z10) {
                throw new h.c(cls, cls2);
            }
            return f();
        } catch (Throwable th) {
            this.f36323c.clear();
            throw th;
        }
    }

    @NonNull
    synchronized List<Class<?>> g(@NonNull Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.f36321a) {
            if (!arrayList.contains(bVar.f36326b) && bVar.a(cls)) {
                arrayList.add(bVar.f36326b);
            }
        }
        return arrayList;
    }

    @VisibleForTesting
    r(@NonNull Pools.Pool<List<Throwable>> pool, @NonNull c cVar) {
        this.f36321a = new ArrayList();
        this.f36323c = new HashSet();
        this.f36324d = pool;
        this.f36322b = cVar;
    }
}
