package l5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: CycleDetector.java */
/* JADX INFO: loaded from: classes3.dex */
class q {

    /* JADX INFO: compiled from: CycleDetector.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final l5.c<?> f30883a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set<b> f30884b = new HashSet();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Set<b> f30885c = new HashSet();

        b(l5.c<?> cVar) {
            this.f30883a = cVar;
        }

        void a(b bVar) {
            this.f30884b.add(bVar);
        }

        void b(b bVar) {
            this.f30885c.add(bVar);
        }

        l5.c<?> c() {
            return this.f30883a;
        }

        Set<b> d() {
            return this.f30884b;
        }

        boolean e() {
            return this.f30884b.isEmpty();
        }

        boolean f() {
            return this.f30885c.isEmpty();
        }

        void g(b bVar) {
            this.f30885c.remove(bVar);
        }
    }

    /* JADX INFO: compiled from: CycleDetector.java */
    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e0<?> f30886a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f30887b;

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return cVar.f30886a.equals(this.f30886a) && cVar.f30887b == this.f30887b;
        }

        public int hashCode() {
            return ((this.f30886a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f30887b).hashCode();
        }

        private c(e0<?> e0Var, boolean z10) {
            this.f30886a = e0Var;
            this.f30887b = z10;
        }
    }

    static void a(List<l5.c<?>> list) {
        Set<b> setC = c(list);
        Set<b> setB = b(setC);
        int i10 = 0;
        while (!setB.isEmpty()) {
            b next = setB.iterator().next();
            setB.remove(next);
            i10++;
            for (b bVar : next.d()) {
                bVar.g(next);
                if (bVar.f()) {
                    setB.add(bVar);
                }
            }
        }
        if (i10 == list.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar2 : setC) {
            if (!bVar2.f() && !bVar2.e()) {
                arrayList.add(bVar2.c());
            }
        }
        throw new s(arrayList);
    }

    private static Set<b> b(Set<b> set) {
        HashSet hashSet = new HashSet();
        for (b bVar : set) {
            if (bVar.f()) {
                hashSet.add(bVar);
            }
        }
        return hashSet;
    }

    private static Set<b> c(List<l5.c<?>> list) {
        Set<b> set;
        HashMap map = new HashMap(list.size());
        Iterator<l5.c<?>> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                Iterator it2 = map.values().iterator();
                while (it2.hasNext()) {
                    for (b bVar : (Set) it2.next()) {
                        for (r rVar : bVar.c().g()) {
                            if (rVar.d() && (set = (Set) map.get(new c(rVar.b(), rVar.f()))) != null) {
                                for (b bVar2 : set) {
                                    bVar.a(bVar2);
                                    bVar2.b(bVar);
                                }
                            }
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                Iterator it3 = map.values().iterator();
                while (it3.hasNext()) {
                    hashSet.addAll((Set) it3.next());
                }
                return hashSet;
            }
            l5.c<?> next = it.next();
            b bVar3 = new b(next);
            for (e0<? super Object> e0Var : next.j()) {
                c cVar = new c(e0Var, !next.p());
                if (!map.containsKey(cVar)) {
                    map.put(cVar, new HashSet());
                }
                Set set2 = (Set) map.get(cVar);
                if (!set2.isEmpty() && !cVar.f30887b) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", e0Var));
                }
                set2.add(bVar3);
            }
        }
    }
}
