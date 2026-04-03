package l5;

import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import l5.o;

/* JADX INFO: compiled from: ComponentRuntime.java */
/* JADX INFO: loaded from: classes3.dex */
public class o implements e, o5.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final w5.b<Set<Object>> f30869i = new w5.b() { // from class: l5.l
        @Override // w5.b
        public final Object get() {
            return Collections.emptySet();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<c<?>, w5.b<?>> f30870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<e0<?>, w5.b<?>> f30871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<e0<?>, y<?>> f30872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<w5.b<ComponentRegistrar>> f30873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Set<String> f30874e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final v f30875f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicReference<Boolean> f30876g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final j f30877h;

    public static b k(Executor executor) {
        return new b(executor);
    }

    private void l(List<c<?>> list) {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<w5.b<ComponentRegistrar>> it = this.f30873d.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = it.next().get();
                    if (componentRegistrar != null) {
                        list.addAll(this.f30877h.a(componentRegistrar));
                        it.remove();
                    }
                } catch (w e10) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e10);
                }
            }
            Iterator<c<?>> it2 = list.iterator();
            while (it2.hasNext()) {
                Object[] array = it2.next().j().toArray();
                int length = array.length;
                int i10 = 0;
                while (true) {
                    if (i10 < length) {
                        Object obj = array[i10];
                        if (obj.toString().contains("kotlinx.coroutines.CoroutineDispatcher")) {
                            if (this.f30874e.contains(obj.toString())) {
                                it2.remove();
                                break;
                            }
                            this.f30874e.add(obj.toString());
                        }
                        i10++;
                    }
                }
            }
            if (this.f30870a.isEmpty()) {
                q.a(list);
            } else {
                ArrayList arrayList2 = new ArrayList(this.f30870a.keySet());
                arrayList2.addAll(list);
                q.a(arrayList2);
            }
            for (final c<?> cVar : list) {
                this.f30870a.put(cVar, new x(new w5.b() { // from class: l5.k
                    @Override // w5.b
                    public final Object get() {
                        return this.f30863a.p(cVar);
                    }
                }));
            }
            arrayList.addAll(u(list));
            arrayList.addAll(v());
            t();
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            ((Runnable) it3.next()).run();
        }
        s();
    }

    private void m(Map<c<?>, w5.b<?>> map, boolean z10) {
        for (Map.Entry<c<?>, w5.b<?>> entry : map.entrySet()) {
            c<?> key = entry.getKey();
            w5.b<?> value = entry.getValue();
            if (key.n() || (key.o() && z10)) {
                value.get();
            }
        }
        this.f30875f.e();
    }

    private static <T> List<T> o(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object p(c cVar) {
        return cVar.h().a(new f0(cVar, this));
    }

    private void s() {
        Boolean bool = this.f30876g.get();
        if (bool != null) {
            m(this.f30870a, bool.booleanValue());
        }
    }

    private void t() {
        for (c<?> cVar : this.f30870a.keySet()) {
            for (r rVar : cVar.g()) {
                if (rVar.f() && !this.f30872c.containsKey(rVar.b())) {
                    this.f30872c.put(rVar.b(), y.b(Collections.emptySet()));
                } else if (this.f30871b.containsKey(rVar.b())) {
                    continue;
                } else {
                    if (rVar.e()) {
                        throw new z(String.format("Unsatisfied dependency for component %s: %s", cVar, rVar.b()));
                    }
                    if (!rVar.f()) {
                        this.f30871b.put(rVar.b(), c0.c());
                    }
                }
            }
        }
    }

    private List<Runnable> u(List<c<?>> list) {
        ArrayList arrayList = new ArrayList();
        for (c<?> cVar : list) {
            if (cVar.p()) {
                final w5.b<?> bVar = this.f30870a.get(cVar);
                for (e0<? super Object> e0Var : cVar.j()) {
                    if (this.f30871b.containsKey(e0Var)) {
                        final c0 c0Var = (c0) this.f30871b.get(e0Var);
                        arrayList.add(new Runnable() { // from class: l5.m
                            @Override // java.lang.Runnable
                            public final void run() {
                                c0Var.f(bVar);
                            }
                        });
                    } else {
                        this.f30871b.put(e0Var, bVar);
                    }
                }
            }
        }
        return arrayList;
    }

    private List<Runnable> v() {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (Map.Entry<c<?>, w5.b<?>> entry : this.f30870a.entrySet()) {
            c<?> key = entry.getKey();
            if (!key.p()) {
                w5.b<?> value = entry.getValue();
                for (e0<? super Object> e0Var : key.j()) {
                    if (!map.containsKey(e0Var)) {
                        map.put(e0Var, new HashSet());
                    }
                    ((Set) map.get(e0Var)).add(value);
                }
            }
        }
        for (Map.Entry entry2 : map.entrySet()) {
            if (this.f30872c.containsKey(entry2.getKey())) {
                final y<?> yVar = this.f30872c.get(entry2.getKey());
                for (final w5.b bVar : (Set) entry2.getValue()) {
                    arrayList.add(new Runnable() { // from class: l5.n
                        @Override // java.lang.Runnable
                        public final void run() {
                            yVar.a(bVar);
                        }
                    });
                }
            } else {
                this.f30872c.put((e0) entry2.getKey(), y.b((Collection) entry2.getValue()));
            }
        }
        return arrayList;
    }

    @Override // l5.e
    public /* synthetic */ Object a(Class cls) {
        return d.a(this, cls);
    }

    @Override // l5.e
    public /* synthetic */ Set b(e0 e0Var) {
        return d.e(this, e0Var);
    }

    @Override // l5.e
    public synchronized <T> w5.b<T> c(e0<T> e0Var) {
        d0.c(e0Var, "Null interface requested.");
        return (w5.b) this.f30871b.get(e0Var);
    }

    @Override // l5.e
    public /* synthetic */ Object d(e0 e0Var) {
        return d.b(this, e0Var);
    }

    @Override // l5.e
    public synchronized <T> w5.b<Set<T>> e(e0<T> e0Var) {
        y<?> yVar = this.f30872c.get(e0Var);
        if (yVar != null) {
            return yVar;
        }
        return (w5.b<Set<T>>) f30869i;
    }

    @Override // l5.e
    public /* synthetic */ Set f(Class cls) {
        return d.d(this, cls);
    }

    @Override // l5.e
    public /* synthetic */ w5.b g(Class cls) {
        return d.c(this, cls);
    }

    public void n(boolean z10) {
        HashMap map;
        if (androidx.compose.animation.core.d.a(this.f30876g, null, Boolean.valueOf(z10))) {
            synchronized (this) {
                map = new HashMap(this.f30870a);
            }
            m(map, z10);
        }
    }

    private o(Executor executor, Iterable<w5.b<ComponentRegistrar>> iterable, Collection<c<?>> collection, j jVar) {
        this.f30870a = new HashMap();
        this.f30871b = new HashMap();
        this.f30872c = new HashMap();
        this.f30874e = new HashSet();
        this.f30876g = new AtomicReference<>();
        v vVar = new v(executor);
        this.f30875f = vVar;
        this.f30877h = jVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(c.s(vVar, v.class, t5.d.class, t5.c.class));
        arrayList.add(c.s(this, o5.a.class, new Class[0]));
        for (c<?> cVar : collection) {
            if (cVar != null) {
                arrayList.add(cVar);
            }
        }
        this.f30873d = o(iterable);
        l(arrayList);
    }

    /* JADX INFO: compiled from: ComponentRuntime.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Executor f30878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<w5.b<ComponentRegistrar>> f30879b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<c<?>> f30880c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private j f30881d = j.f30862a;

        b(Executor executor) {
            this.f30878a = executor;
        }

        public b b(c<?> cVar) {
            this.f30880c.add(cVar);
            return this;
        }

        public b c(final ComponentRegistrar componentRegistrar) {
            this.f30879b.add(new w5.b() { // from class: l5.p
                @Override // w5.b
                public final Object get() {
                    return o.b.f(componentRegistrar);
                }
            });
            return this;
        }

        public b d(Collection<w5.b<ComponentRegistrar>> collection) {
            this.f30879b.addAll(collection);
            return this;
        }

        public o e() {
            return new o(this.f30878a, this.f30879b, this.f30880c, this.f30881d);
        }

        public b g(j jVar) {
            this.f30881d = jVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ComponentRegistrar f(ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }
    }
}
