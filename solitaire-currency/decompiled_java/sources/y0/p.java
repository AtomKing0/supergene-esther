package y0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ModelLoaderRegistry.java */
/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r f36306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f36307b;

    /* JADX INFO: compiled from: ModelLoaderRegistry.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<Class<?>, C0737a<?>> f36308a = new HashMap();

        /* JADX INFO: renamed from: y0.p$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ModelLoaderRegistry.java */
        private static class C0737a<Model> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final List<n<Model, ?>> f36309a;

            public C0737a(List<n<Model, ?>> list) {
                this.f36309a = list;
            }
        }

        a() {
        }

        public void a() {
            this.f36308a.clear();
        }

        @Nullable
        public <Model> List<n<Model, ?>> b(Class<Model> cls) {
            C0737a<?> c0737a = this.f36308a.get(cls);
            if (c0737a == null) {
                return null;
            }
            return (List<n<Model, ?>>) c0737a.f36309a;
        }

        public <Model> void c(Class<Model> cls, List<n<Model, ?>> list) {
            if (this.f36308a.put(cls, new C0737a<>(list)) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }
    }

    public p(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(new r(pool));
    }

    @NonNull
    private static <A> Class<A> b(@NonNull A a10) {
        return (Class<A>) a10.getClass();
    }

    @NonNull
    private synchronized <A> List<n<A, ?>> e(@NonNull Class<A> cls) {
        List<n<A, ?>> listB;
        listB = this.f36307b.b(cls);
        if (listB == null) {
            listB = Collections.unmodifiableList(this.f36306a.c(cls));
            this.f36307b.c(cls, listB);
        }
        return listB;
    }

    public synchronized <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        this.f36306a.b(cls, cls2, oVar);
        this.f36307b.a();
    }

    @NonNull
    public synchronized List<Class<?>> c(@NonNull Class<?> cls) {
        return this.f36306a.g(cls);
    }

    @NonNull
    public <A> List<n<A, ?>> d(@NonNull A a10) {
        List<n<A, ?>> listE = e(b(a10));
        int size = listE.size();
        List<n<A, ?>> listEmptyList = Collections.emptyList();
        boolean z10 = true;
        for (int i10 = 0; i10 < size; i10++) {
            n<A, ?> nVar = listE.get(i10);
            if (nVar.a(a10)) {
                if (z10) {
                    listEmptyList = new ArrayList<>(size - i10);
                    z10 = false;
                }
                listEmptyList.add(nVar);
            }
        }
        return listEmptyList;
    }

    private p(@NonNull r rVar) {
        this.f36307b = new a();
        this.f36306a = rVar;
    }
}
