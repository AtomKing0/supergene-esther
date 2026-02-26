package v0;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import v0.l;

/* JADX INFO: compiled from: GroupedLinkedMap.java */
/* JADX INFO: loaded from: classes2.dex */
class g<K extends l, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a<K, V> f34988a = new a<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<K, a<K, V>> f34989b = new HashMap();

    /* JADX INFO: compiled from: GroupedLinkedMap.java */
    private static class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final K f34990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<V> f34991b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        a<K, V> f34992c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        a<K, V> f34993d;

        a() {
            this(null);
        }

        public void a(V v10) {
            if (this.f34991b == null) {
                this.f34991b = new ArrayList();
            }
            this.f34991b.add(v10);
        }

        @Nullable
        public V b() {
            int iC = c();
            if (iC > 0) {
                return this.f34991b.remove(iC - 1);
            }
            return null;
        }

        public int c() {
            List<V> list = this.f34991b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        a(K k10) {
            this.f34993d = this;
            this.f34992c = this;
            this.f34990a = k10;
        }
    }

    g() {
    }

    private void b(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f34988a;
        aVar.f34993d = aVar2;
        aVar.f34992c = aVar2.f34992c;
        g(aVar);
    }

    private void c(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f34988a;
        aVar.f34993d = aVar2.f34993d;
        aVar.f34992c = aVar2;
        g(aVar);
    }

    private static <K, V> void e(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f34993d;
        aVar2.f34992c = aVar.f34992c;
        aVar.f34992c.f34993d = aVar2;
    }

    private static <K, V> void g(a<K, V> aVar) {
        aVar.f34992c.f34993d = aVar;
        aVar.f34993d.f34992c = aVar;
    }

    @Nullable
    public V a(K k10) {
        a<K, V> aVar = this.f34989b.get(k10);
        if (aVar == null) {
            aVar = new a<>(k10);
            this.f34989b.put(k10, aVar);
        } else {
            k10.a();
        }
        b(aVar);
        return aVar.b();
    }

    public void d(K k10, V v10) {
        a<K, V> aVar = this.f34989b.get(k10);
        if (aVar == null) {
            aVar = new a<>(k10);
            c(aVar);
            this.f34989b.put(k10, aVar);
        } else {
            k10.a();
        }
        aVar.a(v10);
    }

    @Nullable
    public V f() {
        for (a aVar = this.f34988a.f34993d; !aVar.equals(this.f34988a); aVar = aVar.f34993d) {
            V v10 = (V) aVar.b();
            if (v10 != null) {
                return v10;
            }
            e(aVar);
            this.f34989b.remove(aVar.f34990a);
            ((l) aVar.f34990a).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        a aVar = this.f34988a.f34992c;
        boolean z10 = false;
        while (!aVar.equals(this.f34988a)) {
            sb.append('{');
            sb.append(aVar.f34990a);
            sb.append(':');
            sb.append(aVar.c());
            sb.append("}, ");
            aVar = aVar.f34992c;
            z10 = true;
        }
        if (z10) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
