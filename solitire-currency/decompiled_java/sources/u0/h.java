package u0;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p1.a;
import u0.f;
import u0.i;

/* JADX INFO: compiled from: DecodeJob.java */
/* JADX INFO: loaded from: classes2.dex */
class h<R> implements f.a, Runnable, Comparable<h<?>>, a.f {
    private r0.a A;
    private s0.d<?> B;
    private volatile u0.f C;
    private volatile boolean D;
    private volatile boolean E;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e f34271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Pools.Pool<h<?>> f34272e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.bumptech.glide.d f34275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private r0.f f34276i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.bumptech.glide.f f34277j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private n f34278k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f34279l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f34280m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private j f34281n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private r0.h f34282o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private b<R> f34283p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f34284q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private EnumC0703h f34285r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private g f34286s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f34287t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f34288u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Object f34289v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Thread f34290w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private r0.f f34291x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private r0.f f34292y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Object f34293z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u0.g<R> f34268a = new u0.g<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Throwable> f34269b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final p1.c f34270c = p1.c.a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d<?> f34273f = new d<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final f f34274g = new f();

    /* JADX INFO: compiled from: DecodeJob.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f34294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f34295b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f34296c;

        static {
            int[] iArr = new int[r0.c.values().length];
            f34296c = iArr;
            try {
                iArr[r0.c.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34296c[r0.c.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[EnumC0703h.values().length];
            f34295b = iArr2;
            try {
                iArr2[EnumC0703h.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34295b[EnumC0703h.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f34295b[EnumC0703h.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f34295b[EnumC0703h.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f34295b[EnumC0703h.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[g.values().length];
            f34294a = iArr3;
            try {
                iArr3[g.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f34294a[g.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f34294a[g.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    interface b<R> {
        void a(v<R> vVar, r0.a aVar);

        void b(q qVar);

        void d(h<?> hVar);
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    private final class c<Z> implements i.a<Z> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final r0.a f34297a;

        c(r0.a aVar) {
            this.f34297a = aVar;
        }

        @Override // u0.i.a
        @NonNull
        public v<Z> a(@NonNull v<Z> vVar) {
            return h.this.w(this.f34297a, vVar);
        }
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    private static class d<Z> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private r0.f f34299a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private r0.k<Z> f34300b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private u<Z> f34301c;

        d() {
        }

        void a() {
            this.f34299a = null;
            this.f34300b = null;
            this.f34301c = null;
        }

        void b(e eVar, r0.h hVar) {
            p1.b.a("DecodeJob.encode");
            try {
                eVar.a().b(this.f34299a, new u0.e(this.f34300b, this.f34301c, hVar));
            } finally {
                this.f34301c.f();
                p1.b.d();
            }
        }

        boolean c() {
            return this.f34301c != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        <X> void d(r0.f fVar, r0.k<X> kVar, u<X> uVar) {
            this.f34299a = fVar;
            this.f34300b = kVar;
            this.f34301c = uVar;
        }
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    interface e {
        w0.a a();
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    private static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f34302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f34303b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f34304c;

        f() {
        }

        private boolean a(boolean z10) {
            return (this.f34304c || z10 || this.f34303b) && this.f34302a;
        }

        synchronized boolean b() {
            this.f34303b = true;
            return a(false);
        }

        synchronized boolean c() {
            this.f34304c = true;
            return a(false);
        }

        synchronized boolean d(boolean z10) {
            this.f34302a = true;
            return a(z10);
        }

        synchronized void e() {
            this.f34303b = false;
            this.f34302a = false;
            this.f34304c = false;
        }
    }

    /* JADX INFO: compiled from: DecodeJob.java */
    private enum g {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* JADX INFO: renamed from: u0.h$h, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DecodeJob.java */
    private enum EnumC0703h {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    h(e eVar, Pools.Pool<h<?>> pool) {
        this.f34271d = eVar;
        this.f34272e = pool;
    }

    private <Data, ResourceType> v<R> A(Data data, r0.a aVar, t<Data, ResourceType, R> tVar) throws q {
        r0.h hVarM = m(aVar);
        s0.e<Data> eVarL = this.f34275h.h().l(data);
        try {
            return tVar.a(eVarL, hVarM, this.f34279l, this.f34280m, new c(aVar));
        } finally {
            eVarL.b();
        }
    }

    private void B() {
        int i10 = a.f34294a[this.f34286s.ordinal()];
        if (i10 == 1) {
            this.f34285r = l(EnumC0703h.INITIALIZE);
            this.C = k();
            z();
        } else if (i10 == 2) {
            z();
        } else {
            if (i10 == 3) {
                j();
                return;
            }
            throw new IllegalStateException("Unrecognized run reason: " + this.f34286s);
        }
    }

    private void C() {
        Throwable th;
        this.f34270c.c();
        if (!this.D) {
            this.D = true;
            return;
        }
        if (this.f34269b.isEmpty()) {
            th = null;
        } else {
            List<Throwable> list = this.f34269b;
            th = list.get(list.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }

    private <Data> v<R> h(s0.d<?> dVar, Data data, r0.a aVar) throws q {
        if (data == null) {
            dVar.b();
            return null;
        }
        try {
            long jB = o1.f.b();
            v<R> vVarI = i(data, aVar);
            if (Log.isLoggable("DecodeJob", 2)) {
                p("Decoded result " + vVarI, jB);
            }
            return vVarI;
        } finally {
            dVar.b();
        }
    }

    private <Data> v<R> i(Data data, r0.a aVar) throws q {
        return A(data, aVar, this.f34268a.h(data.getClass()));
    }

    private void j() {
        v<R> vVarH;
        if (Log.isLoggable("DecodeJob", 2)) {
            q("Retrieved data", this.f34287t, "data: " + this.f34293z + ", cache key: " + this.f34291x + ", fetcher: " + this.B);
        }
        try {
            vVarH = h(this.B, this.f34293z, this.A);
        } catch (q e10) {
            e10.i(this.f34292y, this.A);
            this.f34269b.add(e10);
            vVarH = null;
        }
        if (vVarH != null) {
            s(vVarH, this.A);
        } else {
            z();
        }
    }

    private u0.f k() {
        int i10 = a.f34295b[this.f34285r.ordinal()];
        if (i10 == 1) {
            return new w(this.f34268a, this);
        }
        if (i10 == 2) {
            return new u0.c(this.f34268a, this);
        }
        if (i10 == 3) {
            return new z(this.f34268a, this);
        }
        if (i10 == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.f34285r);
    }

    private EnumC0703h l(EnumC0703h enumC0703h) {
        int i10 = a.f34295b[enumC0703h.ordinal()];
        if (i10 == 1) {
            return this.f34281n.a() ? EnumC0703h.DATA_CACHE : l(EnumC0703h.DATA_CACHE);
        }
        if (i10 == 2) {
            return this.f34288u ? EnumC0703h.FINISHED : EnumC0703h.SOURCE;
        }
        if (i10 == 3 || i10 == 4) {
            return EnumC0703h.FINISHED;
        }
        if (i10 == 5) {
            return this.f34281n.b() ? EnumC0703h.RESOURCE_CACHE : l(EnumC0703h.RESOURCE_CACHE);
        }
        throw new IllegalArgumentException("Unrecognized stage: " + enumC0703h);
    }

    @NonNull
    private r0.h m(r0.a aVar) {
        r0.h hVar = this.f34282o;
        if (Build.VERSION.SDK_INT < 26) {
            return hVar;
        }
        boolean z10 = aVar == r0.a.RESOURCE_DISK_CACHE || this.f34268a.w();
        r0.g<Boolean> gVar = b1.q.f1864j;
        Boolean bool = (Boolean) hVar.c(gVar);
        if (bool != null && (!bool.booleanValue() || z10)) {
            return hVar;
        }
        r0.h hVar2 = new r0.h();
        hVar2.d(this.f34282o);
        hVar2.e(gVar, Boolean.valueOf(z10));
        return hVar2;
    }

    private int n() {
        return this.f34277j.ordinal();
    }

    private void p(String str, long j10) {
        q(str, j10, null);
    }

    private void q(String str, long j10, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(o1.f.a(j10));
        sb.append(", load key: ");
        sb.append(this.f34278k);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    private void r(v<R> vVar, r0.a aVar) {
        C();
        this.f34283p.a(vVar, aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void s(v<R> vVar, r0.a aVar) {
        u uVar;
        if (vVar instanceof r) {
            ((r) vVar).initialize();
        }
        if (this.f34273f.c()) {
            vVar = u.d(vVar);
            uVar = vVar;
        } else {
            uVar = 0;
        }
        r(vVar, aVar);
        this.f34285r = EnumC0703h.ENCODE;
        try {
            if (this.f34273f.c()) {
                this.f34273f.b(this.f34271d, this.f34282o);
            }
            u();
        } finally {
            if (uVar != 0) {
                uVar.f();
            }
        }
    }

    private void t() {
        C();
        this.f34283p.b(new q("Failed to load resource", new ArrayList(this.f34269b)));
        v();
    }

    private void u() {
        if (this.f34274g.b()) {
            y();
        }
    }

    private void v() {
        if (this.f34274g.c()) {
            y();
        }
    }

    private void y() {
        this.f34274g.e();
        this.f34273f.a();
        this.f34268a.a();
        this.D = false;
        this.f34275h = null;
        this.f34276i = null;
        this.f34282o = null;
        this.f34277j = null;
        this.f34278k = null;
        this.f34283p = null;
        this.f34285r = null;
        this.C = null;
        this.f34290w = null;
        this.f34291x = null;
        this.f34293z = null;
        this.A = null;
        this.B = null;
        this.f34287t = 0L;
        this.E = false;
        this.f34289v = null;
        this.f34269b.clear();
        this.f34272e.release(this);
    }

    private void z() {
        this.f34290w = Thread.currentThread();
        this.f34287t = o1.f.b();
        boolean zB = false;
        while (!this.E && this.C != null && !(zB = this.C.b())) {
            this.f34285r = l(this.f34285r);
            this.C = k();
            if (this.f34285r == EnumC0703h.SOURCE) {
                e();
                return;
            }
        }
        if ((this.f34285r == EnumC0703h.FINISHED || this.E) && !zB) {
            t();
        }
    }

    boolean D() {
        EnumC0703h enumC0703hL = l(EnumC0703h.INITIALIZE);
        return enumC0703hL == EnumC0703h.RESOURCE_CACHE || enumC0703hL == EnumC0703h.DATA_CACHE;
    }

    @Override // u0.f.a
    public void a(r0.f fVar, Exception exc, s0.d<?> dVar, r0.a aVar) {
        dVar.b();
        q qVar = new q("Fetching data failed", exc);
        qVar.j(fVar, aVar, dVar.a());
        this.f34269b.add(qVar);
        if (Thread.currentThread() == this.f34290w) {
            z();
        } else {
            this.f34286s = g.SWITCH_TO_SOURCE_SERVICE;
            this.f34283p.d(this);
        }
    }

    @Override // p1.a.f
    @NonNull
    public p1.c c() {
        return this.f34270c;
    }

    @Override // u0.f.a
    public void d(r0.f fVar, Object obj, s0.d<?> dVar, r0.a aVar, r0.f fVar2) {
        this.f34291x = fVar;
        this.f34293z = obj;
        this.B = dVar;
        this.A = aVar;
        this.f34292y = fVar2;
        if (Thread.currentThread() != this.f34290w) {
            this.f34286s = g.DECODE_DATA;
            this.f34283p.d(this);
        } else {
            p1.b.a("DecodeJob.decodeFromRetrievedData");
            try {
                j();
            } finally {
                p1.b.d();
            }
        }
    }

    @Override // u0.f.a
    public void e() {
        this.f34286s = g.SWITCH_TO_SOURCE_SERVICE;
        this.f34283p.d(this);
    }

    public void f() {
        this.E = true;
        u0.f fVar = this.C;
        if (fVar != null) {
            fVar.cancel();
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull h<?> hVar) {
        int iN = n() - hVar.n();
        return iN == 0 ? this.f34284q - hVar.f34284q : iN;
    }

    h<R> o(com.bumptech.glide.d dVar, Object obj, n nVar, r0.f fVar, int i10, int i11, Class<?> cls, Class<R> cls2, com.bumptech.glide.f fVar2, j jVar, Map<Class<?>, r0.l<?>> map, boolean z10, boolean z11, boolean z12, r0.h hVar, b<R> bVar, int i12) {
        this.f34268a.u(dVar, obj, fVar, i10, i11, jVar, cls, cls2, fVar2, hVar, map, z10, z11, this.f34271d);
        this.f34275h = dVar;
        this.f34276i = fVar;
        this.f34277j = fVar2;
        this.f34278k = nVar;
        this.f34279l = i10;
        this.f34280m = i11;
        this.f34281n = jVar;
        this.f34288u = z12;
        this.f34282o = hVar;
        this.f34283p = bVar;
        this.f34284q = i12;
        this.f34286s = g.INITIALIZE;
        this.f34289v = obj;
        return this;
    }

    @Override // java.lang.Runnable
    public void run() {
        p1.b.b("DecodeJob#run(model=%s)", this.f34289v);
        s0.d<?> dVar = this.B;
        try {
            try {
                if (this.E) {
                    t();
                    return;
                }
                B();
                if (dVar != null) {
                    dVar.b();
                }
                p1.b.d();
            } finally {
                if (dVar != null) {
                    dVar.b();
                }
                p1.b.d();
            }
        } catch (u0.b e10) {
            throw e10;
        } catch (Throwable th) {
            if (Log.isLoggable("DecodeJob", 3)) {
                Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.E + ", stage: " + this.f34285r, th);
            }
            if (this.f34285r != EnumC0703h.ENCODE) {
                this.f34269b.add(th);
                t();
            }
            if (!this.E) {
                throw th;
            }
            throw th;
        }
    }

    @NonNull
    <Z> v<Z> w(r0.a aVar, @NonNull v<Z> vVar) {
        v<Z> vVarA;
        r0.l<Z> lVar;
        r0.c cVarB;
        r0.f dVar;
        Class<?> cls = vVar.get().getClass();
        r0.k<Z> kVarN = null;
        if (aVar != r0.a.RESOURCE_DISK_CACHE) {
            r0.l<Z> lVarR = this.f34268a.r(cls);
            lVar = lVarR;
            vVarA = lVarR.a(this.f34275h, vVar, this.f34279l, this.f34280m);
        } else {
            vVarA = vVar;
            lVar = null;
        }
        if (!vVar.equals(vVarA)) {
            vVar.recycle();
        }
        if (this.f34268a.v(vVarA)) {
            kVarN = this.f34268a.n(vVarA);
            cVarB = kVarN.b(this.f34282o);
        } else {
            cVarB = r0.c.NONE;
        }
        r0.k kVar = kVarN;
        if (!this.f34281n.d(!this.f34268a.x(this.f34291x), aVar, cVarB)) {
            return vVarA;
        }
        if (kVar == null) {
            throw new h.d(vVarA.get().getClass());
        }
        int i10 = a.f34296c[cVarB.ordinal()];
        if (i10 == 1) {
            dVar = new u0.d(this.f34291x, this.f34276i);
        } else {
            if (i10 != 2) {
                throw new IllegalArgumentException("Unknown strategy: " + cVarB);
            }
            dVar = new x(this.f34268a.b(), this.f34291x, this.f34276i, this.f34279l, this.f34280m, lVar, cls, this.f34282o);
        }
        u uVarD = u.d(vVarA);
        this.f34273f.d(dVar, kVar, uVarD);
        return uVarD;
    }

    void x(boolean z10) {
        if (this.f34274g.d(z10)) {
            y();
        }
    }
}
