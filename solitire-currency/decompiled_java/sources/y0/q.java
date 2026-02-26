package y0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import s0.d;
import y0.n;

/* JADX INFO: compiled from: MultiModelLoader.java */
/* JADX INFO: loaded from: classes2.dex */
class q<Model, Data> implements n<Model, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<n<Model, Data>> f36310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f36311b;

    /* JADX INFO: compiled from: MultiModelLoader.java */
    static class a<Data> implements s0.d<Data>, d.a<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<s0.d<Data>> f36312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Pools.Pool<List<Throwable>> f36313b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f36314c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private com.bumptech.glide.f f36315d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private d.a<? super Data> f36316e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        private List<Throwable> f36317f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f36318g;

        a(@NonNull List<s0.d<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.f36313b = pool;
            o1.j.c(list);
            this.f36312a = list;
            this.f36314c = 0;
        }

        private void g() {
            if (this.f36318g) {
                return;
            }
            if (this.f36314c < this.f36312a.size() - 1) {
                this.f36314c++;
                e(this.f36315d, this.f36316e);
            } else {
                o1.j.d(this.f36317f);
                this.f36316e.c(new u0.q("Fetch failed", new ArrayList(this.f36317f)));
            }
        }

        @Override // s0.d
        @NonNull
        public Class<Data> a() {
            return this.f36312a.get(0).a();
        }

        @Override // s0.d
        public void b() {
            List<Throwable> list = this.f36317f;
            if (list != null) {
                this.f36313b.release(list);
            }
            this.f36317f = null;
            Iterator<s0.d<Data>> it = this.f36312a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }

        @Override // s0.d.a
        public void c(@NonNull Exception exc) {
            ((List) o1.j.d(this.f36317f)).add(exc);
            g();
        }

        @Override // s0.d
        public void cancel() {
            this.f36318g = true;
            Iterator<s0.d<Data>> it = this.f36312a.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
        }

        @Override // s0.d
        @NonNull
        public r0.a d() {
            return this.f36312a.get(0).d();
        }

        @Override // s0.d
        public void e(@NonNull com.bumptech.glide.f fVar, @NonNull d.a<? super Data> aVar) {
            this.f36315d = fVar;
            this.f36316e = aVar;
            this.f36317f = this.f36313b.acquire();
            this.f36312a.get(this.f36314c).e(fVar, this);
            if (this.f36318g) {
                cancel();
            }
        }

        @Override // s0.d.a
        public void f(@Nullable Data data) {
            if (data != null) {
                this.f36316e.f(data);
            } else {
                g();
            }
        }
    }

    q(@NonNull List<n<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.f36310a = list;
        this.f36311b = pool;
    }

    @Override // y0.n
    public boolean a(@NonNull Model model) {
        Iterator<n<Model, Data>> it = this.f36310a.iterator();
        while (it.hasNext()) {
            if (it.next().a(model)) {
                return true;
            }
        }
        return false;
    }

    @Override // y0.n
    public n.a<Data> b(@NonNull Model model, int i10, int i11, @NonNull r0.h hVar) {
        n.a<Data> aVarB;
        int size = this.f36310a.size();
        ArrayList arrayList = new ArrayList(size);
        r0.f fVar = null;
        for (int i12 = 0; i12 < size; i12++) {
            n<Model, Data> nVar = this.f36310a.get(i12);
            if (nVar.a(model) && (aVarB = nVar.b(model, i10, i11, hVar)) != null) {
                fVar = aVarB.f36303a;
                arrayList.add(aVarB.f36305c);
            }
        }
        if (arrayList.isEmpty() || fVar == null) {
            return null;
        }
        return new n.a<>(fVar, new a(arrayList, this.f36311b));
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f36310a.toArray()) + '}';
    }
}
