package v0;

import android.util.Log;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: LruArrayPool.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements v0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g<a, Object> f34994a = new g<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f34995b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f34996c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<Class<?>, v0.a<?>> f34997d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f34998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f34999f;

    /* JADX INFO: compiled from: LruArrayPool.java */
    private static final class a implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f35000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f35001b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Class<?> f35002c;

        a(b bVar) {
            this.f35000a = bVar;
        }

        @Override // v0.l
        public void a() {
            this.f35000a.c(this);
        }

        void b(int i10, Class<?> cls) {
            this.f35001b = i10;
            this.f35002c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f35001b == aVar.f35001b && this.f35002c == aVar.f35002c;
        }

        public int hashCode() {
            int i10 = this.f35001b * 31;
            Class<?> cls = this.f35002c;
            return i10 + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.f35001b + "array=" + this.f35002c + '}';
        }
    }

    /* JADX INFO: compiled from: LruArrayPool.java */
    private static final class b extends c<a> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // v0.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        a e(int i10, Class<?> cls) {
            a aVarB = b();
            aVarB.b(i10, cls);
            return aVarB;
        }
    }

    public i(int i10) {
        this.f34998e = i10;
    }

    private void e(int i10, Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMapL = l(cls);
        Integer num = navigableMapL.get(Integer.valueOf(i10));
        if (num != null) {
            if (num.intValue() == 1) {
                navigableMapL.remove(Integer.valueOf(i10));
                return;
            } else {
                navigableMapL.put(Integer.valueOf(i10), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i10 + ", this: " + this);
    }

    private void f() {
        g(this.f34998e);
    }

    private void g(int i10) {
        while (this.f34999f > i10) {
            Object objF = this.f34994a.f();
            o1.j.d(objF);
            v0.a aVarH = h(objF);
            this.f34999f -= aVarH.b(objF) * aVarH.a();
            e(aVarH.b(objF), objF.getClass());
            if (Log.isLoggable(aVarH.getTag(), 2)) {
                Log.v(aVarH.getTag(), "evicted: " + aVarH.b(objF));
            }
        }
    }

    private <T> v0.a<T> h(T t10) {
        return i(t10.getClass());
    }

    private <T> v0.a<T> i(Class<T> cls) {
        v0.a<T> fVar = (v0.a) this.f34997d.get(cls);
        if (fVar == null) {
            if (cls.equals(int[].class)) {
                fVar = new h();
            } else {
                if (!cls.equals(byte[].class)) {
                    throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
                }
                fVar = new f();
            }
            this.f34997d.put(cls, fVar);
        }
        return fVar;
    }

    @Nullable
    private <T> T j(a aVar) {
        return (T) this.f34994a.a(aVar);
    }

    private <T> T k(a aVar, Class<T> cls) {
        v0.a<T> aVarI = i(cls);
        T t10 = (T) j(aVar);
        if (t10 != null) {
            this.f34999f -= aVarI.b(t10) * aVarI.a();
            e(aVarI.b(t10), cls);
        }
        if (t10 != null) {
            return t10;
        }
        if (Log.isLoggable(aVarI.getTag(), 2)) {
            Log.v(aVarI.getTag(), "Allocated " + aVar.f35001b + " bytes");
        }
        return aVarI.newArray(aVar.f35001b);
    }

    private NavigableMap<Integer, Integer> l(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f34996c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f34996c.put(cls, treeMap);
        return treeMap;
    }

    private boolean m() {
        int i10 = this.f34999f;
        return i10 == 0 || this.f34998e / i10 >= 2;
    }

    private boolean n(int i10) {
        return i10 <= this.f34998e / 2;
    }

    private boolean o(int i10, Integer num) {
        return num != null && (m() || num.intValue() <= i10 * 8);
    }

    @Override // v0.b
    public synchronized void a(int i10) {
        try {
            if (i10 >= 40) {
                b();
            } else if (i10 >= 20 || i10 == 15) {
                g(this.f34998e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // v0.b
    public synchronized void b() {
        g(0);
    }

    @Override // v0.b
    public synchronized <T> T c(int i10, Class<T> cls) {
        Integer numCeilingKey;
        numCeilingKey = l(cls).ceilingKey(Integer.valueOf(i10));
        return (T) k(o(i10, numCeilingKey) ? this.f34995b.e(numCeilingKey.intValue(), cls) : this.f34995b.e(i10, cls), cls);
    }

    @Override // v0.b
    public synchronized <T> T d(int i10, Class<T> cls) {
        return (T) k(this.f34995b.e(i10, cls), cls);
    }

    @Override // v0.b
    public synchronized <T> void put(T t10) {
        Class<?> cls = t10.getClass();
        v0.a<T> aVarI = i(cls);
        int iB = aVarI.b(t10);
        int iA = aVarI.a() * iB;
        if (n(iA)) {
            a aVarE = this.f34995b.e(iB, cls);
            this.f34994a.d(aVarE, t10);
            NavigableMap<Integer, Integer> navigableMapL = l(cls);
            Integer num = navigableMapL.get(Integer.valueOf(aVarE.f35001b));
            Integer numValueOf = Integer.valueOf(aVarE.f35001b);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapL.put(numValueOf, Integer.valueOf(iIntValue));
            this.f34999f += iA;
            f();
        }
    }
}
