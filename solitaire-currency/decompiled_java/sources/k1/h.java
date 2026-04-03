package k1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ironsource.v8;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import u0.k;
import u0.q;
import u0.v;

/* JADX INFO: compiled from: SingleRequest.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h<R> implements c, l1.g, g {
    private static final boolean D = Log.isLoggable("Request", 2);

    @GuardedBy("requestLock")
    private int A;

    @GuardedBy("requestLock")
    private boolean B;

    @Nullable
    private RuntimeException C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final String f28925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p1.c f28926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f28927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final e<R> f28928d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d f28929e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f28930f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.bumptech.glide.d f28931g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private final Object f28932h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Class<R> f28933i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final k1.a<?> f28934j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f28935k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f28936l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final com.bumptech.glide.f f28937m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final l1.h<R> f28938n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private final List<e<R>> f28939o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final m1.c<? super R> f28940p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Executor f28941q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @GuardedBy("requestLock")
    private v<R> f28942r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @GuardedBy("requestLock")
    private k.d f28943s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @GuardedBy("requestLock")
    private long f28944t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private volatile k f28945u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @GuardedBy("requestLock")
    private a f28946v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    @GuardedBy("requestLock")
    private Drawable f28947w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    @GuardedBy("requestLock")
    private Drawable f28948x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    @GuardedBy("requestLock")
    private Drawable f28949y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @GuardedBy("requestLock")
    private int f28950z;

    /* JADX INFO: compiled from: SingleRequest.java */
    private enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    private h(Context context, com.bumptech.glide.d dVar, @NonNull Object obj, @Nullable Object obj2, Class<R> cls, k1.a<?> aVar, int i10, int i11, com.bumptech.glide.f fVar, l1.h<R> hVar, @Nullable e<R> eVar, @Nullable List<e<R>> list, d dVar2, k kVar, m1.c<? super R> cVar, Executor executor) {
        this.f28925a = D ? String.valueOf(super.hashCode()) : null;
        this.f28926b = p1.c.a();
        this.f28927c = obj;
        this.f28930f = context;
        this.f28931g = dVar;
        this.f28932h = obj2;
        this.f28933i = cls;
        this.f28934j = aVar;
        this.f28935k = i10;
        this.f28936l = i11;
        this.f28937m = fVar;
        this.f28938n = hVar;
        this.f28928d = eVar;
        this.f28939o = list;
        this.f28929e = dVar2;
        this.f28945u = kVar;
        this.f28940p = cVar;
        this.f28941q = executor;
        this.f28946v = a.PENDING;
        if (this.C == null && dVar.i()) {
            this.C = new RuntimeException("Glide request origin trace");
        }
    }

    @GuardedBy("requestLock")
    private void f() {
        if (this.B) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @GuardedBy("requestLock")
    private boolean i() {
        d dVar = this.f28929e;
        return dVar == null || dVar.e(this);
    }

    @GuardedBy("requestLock")
    private boolean k() {
        d dVar = this.f28929e;
        return dVar == null || dVar.i(this);
    }

    @GuardedBy("requestLock")
    private boolean l() {
        d dVar = this.f28929e;
        return dVar == null || dVar.c(this);
    }

    @GuardedBy("requestLock")
    private void m() {
        f();
        this.f28926b.c();
        this.f28938n.b(this);
        k.d dVar = this.f28943s;
        if (dVar != null) {
            dVar.a();
            this.f28943s = null;
        }
    }

    @GuardedBy("requestLock")
    private Drawable n() {
        if (this.f28947w == null) {
            Drawable drawableK = this.f28934j.k();
            this.f28947w = drawableK;
            if (drawableK == null && this.f28934j.j() > 0) {
                this.f28947w = r(this.f28934j.j());
            }
        }
        return this.f28947w;
    }

    @GuardedBy("requestLock")
    private Drawable o() {
        if (this.f28949y == null) {
            Drawable drawableL = this.f28934j.l();
            this.f28949y = drawableL;
            if (drawableL == null && this.f28934j.m() > 0) {
                this.f28949y = r(this.f28934j.m());
            }
        }
        return this.f28949y;
    }

    @GuardedBy("requestLock")
    private Drawable p() {
        if (this.f28948x == null) {
            Drawable drawableS = this.f28934j.s();
            this.f28948x = drawableS;
            if (drawableS == null && this.f28934j.t() > 0) {
                this.f28948x = r(this.f28934j.t());
            }
        }
        return this.f28948x;
    }

    @GuardedBy("requestLock")
    private boolean q() {
        d dVar = this.f28929e;
        return dVar == null || !dVar.b();
    }

    @GuardedBy("requestLock")
    private Drawable r(@DrawableRes int i10) {
        return d1.a.a(this.f28931g, i10, this.f28934j.y() != null ? this.f28934j.y() : this.f28930f.getTheme());
    }

    private void s(String str) {
        Log.v("Request", str + " this: " + this.f28925a);
    }

    private static int t(int i10, float f10) {
        return i10 == Integer.MIN_VALUE ? i10 : Math.round(f10 * i10);
    }

    @GuardedBy("requestLock")
    private void u() {
        d dVar = this.f28929e;
        if (dVar != null) {
            dVar.a(this);
        }
    }

    @GuardedBy("requestLock")
    private void v() {
        d dVar = this.f28929e;
        if (dVar != null) {
            dVar.f(this);
        }
    }

    public static <R> h<R> w(Context context, com.bumptech.glide.d dVar, Object obj, Object obj2, Class<R> cls, k1.a<?> aVar, int i10, int i11, com.bumptech.glide.f fVar, l1.h<R> hVar, e<R> eVar, @Nullable List<e<R>> list, d dVar2, k kVar, m1.c<? super R> cVar, Executor executor) {
        return new h<>(context, dVar, obj, obj2, cls, aVar, i10, i11, fVar, hVar, eVar, list, dVar2, kVar, cVar, executor);
    }

    private void x(q qVar, int i10) {
        boolean zB;
        this.f28926b.c();
        synchronized (this.f28927c) {
            qVar.k(this.C);
            int iG = this.f28931g.g();
            if (iG <= i10) {
                Log.w("Glide", "Load failed for " + this.f28932h + " with size [" + this.f28950z + ViewHierarchyNode.JsonKeys.X + this.A + v8.i.f15839e, qVar);
                if (iG <= 4) {
                    qVar.g("Glide");
                }
            }
            this.f28943s = null;
            this.f28946v = a.FAILED;
            boolean z10 = true;
            this.B = true;
            try {
                List<e<R>> list = this.f28939o;
                if (list != null) {
                    Iterator<e<R>> it = list.iterator();
                    zB = false;
                    while (it.hasNext()) {
                        zB |= it.next().b(qVar, this.f28932h, this.f28938n, q());
                    }
                } else {
                    zB = false;
                }
                e<R> eVar = this.f28928d;
                if (eVar == null || !eVar.b(qVar, this.f28932h, this.f28938n, q())) {
                    z10 = false;
                }
                if (!(zB | z10)) {
                    z();
                }
                this.B = false;
                u();
            } catch (Throwable th) {
                this.B = false;
                throw th;
            }
        }
    }

    @GuardedBy("requestLock")
    private void y(v<R> vVar, R r10, r0.a aVar) {
        boolean zA;
        boolean zQ = q();
        this.f28946v = a.COMPLETE;
        this.f28942r = vVar;
        if (this.f28931g.g() <= 3) {
            Log.d("Glide", "Finished loading " + r10.getClass().getSimpleName() + " from " + aVar + " for " + this.f28932h + " with size [" + this.f28950z + ViewHierarchyNode.JsonKeys.X + this.A + "] in " + o1.f.a(this.f28944t) + " ms");
        }
        boolean z10 = true;
        this.B = true;
        try {
            List<e<R>> list = this.f28939o;
            if (list != null) {
                Iterator<e<R>> it = list.iterator();
                zA = false;
                while (it.hasNext()) {
                    zA |= it.next().a(r10, this.f28932h, this.f28938n, aVar, zQ);
                }
            } else {
                zA = false;
            }
            e<R> eVar = this.f28928d;
            if (eVar == null || !eVar.a(r10, this.f28932h, this.f28938n, aVar, zQ)) {
                z10 = false;
            }
            if (!(z10 | zA)) {
                this.f28938n.g(r10, this.f28940p.a(aVar, zQ));
            }
            this.B = false;
            v();
        } catch (Throwable th) {
            this.B = false;
            throw th;
        }
    }

    @GuardedBy("requestLock")
    private void z() {
        if (k()) {
            Drawable drawableO = this.f28932h == null ? o() : null;
            if (drawableO == null) {
                drawableO = n();
            }
            if (drawableO == null) {
                drawableO = p();
            }
            this.f28938n.f(drawableO);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // k1.g
    public void a(v<?> vVar, r0.a aVar) {
        this.f28926b.c();
        v<?> vVar2 = null;
        try {
            synchronized (this.f28927c) {
                try {
                    this.f28943s = null;
                    if (vVar == null) {
                        b(new q("Expected to receive a Resource<R> with an object of " + this.f28933i + " inside, but instead got null."));
                        return;
                    }
                    Object obj = vVar.get();
                    try {
                        if (obj != null && this.f28933i.isAssignableFrom(obj.getClass())) {
                            if (l()) {
                                y(vVar, obj, aVar);
                                return;
                            }
                            this.f28942r = null;
                            this.f28946v = a.COMPLETE;
                            this.f28945u.k(vVar);
                            return;
                        }
                        this.f28942r = null;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected to receive an object of ");
                        sb.append(this.f28933i);
                        sb.append(" but instead got ");
                        sb.append(obj != null ? obj.getClass() : "");
                        sb.append("{");
                        sb.append(obj);
                        sb.append("} inside Resource{");
                        sb.append(vVar);
                        sb.append("}.");
                        sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                        b(new q(sb.toString()));
                        this.f28945u.k(vVar);
                    } catch (Throwable th) {
                        vVar2 = vVar;
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (vVar2 != null) {
                this.f28945u.k(vVar2);
            }
            throw th3;
        }
    }

    @Override // k1.g
    public void b(q qVar) {
        x(qVar, 5);
    }

    @Override // l1.g
    public void c(int i10, int i11) throws Throwable {
        Object obj;
        this.f28926b.c();
        Object obj2 = this.f28927c;
        synchronized (obj2) {
            try {
                try {
                    boolean z10 = D;
                    if (z10) {
                        s("Got onSizeReady in " + o1.f.a(this.f28944t));
                    }
                    if (this.f28946v == a.WAITING_FOR_SIZE) {
                        a aVar = a.RUNNING;
                        this.f28946v = aVar;
                        float fX = this.f28934j.x();
                        this.f28950z = t(i10, fX);
                        this.A = t(i11, fX);
                        if (z10) {
                            s("finished setup for calling load in " + o1.f.a(this.f28944t));
                        }
                        obj = obj2;
                        try {
                            this.f28943s = this.f28945u.f(this.f28931g, this.f28932h, this.f28934j.w(), this.f28950z, this.A, this.f28934j.v(), this.f28933i, this.f28937m, this.f28934j.i(), this.f28934j.z(), this.f28934j.I(), this.f28934j.E(), this.f28934j.p(), this.f28934j.C(), this.f28934j.B(), this.f28934j.A(), this.f28934j.o(), this, this.f28941q);
                            if (this.f28946v != aVar) {
                                this.f28943s = null;
                            }
                            if (z10) {
                                s("finished onSizeReady in " + o1.f.a(this.f28944t));
                            }
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                obj = obj2;
            }
        }
    }

    @Override // k1.c
    public void clear() {
        synchronized (this.f28927c) {
            f();
            this.f28926b.c();
            a aVar = this.f28946v;
            a aVar2 = a.CLEARED;
            if (aVar == aVar2) {
                return;
            }
            m();
            v<R> vVar = this.f28942r;
            if (vVar != null) {
                this.f28942r = null;
            } else {
                vVar = null;
            }
            if (i()) {
                this.f28938n.d(p());
            }
            this.f28946v = aVar2;
            if (vVar != null) {
                this.f28945u.k(vVar);
            }
        }
    }

    @Override // k1.c
    public boolean d() {
        boolean z10;
        synchronized (this.f28927c) {
            z10 = this.f28946v == a.CLEARED;
        }
        return z10;
    }

    @Override // k1.g
    public Object e() {
        this.f28926b.c();
        return this.f28927c;
    }

    @Override // k1.c
    public boolean g(c cVar) {
        int i10;
        int i11;
        Object obj;
        Class<R> cls;
        k1.a<?> aVar;
        com.bumptech.glide.f fVar;
        int size;
        int i12;
        int i13;
        Object obj2;
        Class<R> cls2;
        k1.a<?> aVar2;
        com.bumptech.glide.f fVar2;
        int size2;
        if (!(cVar instanceof h)) {
            return false;
        }
        synchronized (this.f28927c) {
            i10 = this.f28935k;
            i11 = this.f28936l;
            obj = this.f28932h;
            cls = this.f28933i;
            aVar = this.f28934j;
            fVar = this.f28937m;
            List<e<R>> list = this.f28939o;
            size = list != null ? list.size() : 0;
        }
        h hVar = (h) cVar;
        synchronized (hVar.f28927c) {
            i12 = hVar.f28935k;
            i13 = hVar.f28936l;
            obj2 = hVar.f28932h;
            cls2 = hVar.f28933i;
            aVar2 = hVar.f28934j;
            fVar2 = hVar.f28937m;
            List<e<R>> list2 = hVar.f28939o;
            size2 = list2 != null ? list2.size() : 0;
        }
        return i10 == i12 && i11 == i13 && o1.k.b(obj, obj2) && cls.equals(cls2) && aVar.equals(aVar2) && fVar == fVar2 && size == size2;
    }

    @Override // k1.c
    public boolean h() {
        boolean z10;
        synchronized (this.f28927c) {
            z10 = this.f28946v == a.COMPLETE;
        }
        return z10;
    }

    @Override // k1.c
    public boolean isRunning() {
        boolean z10;
        synchronized (this.f28927c) {
            a aVar = this.f28946v;
            z10 = aVar == a.RUNNING || aVar == a.WAITING_FOR_SIZE;
        }
        return z10;
    }

    @Override // k1.c
    public void j() {
        synchronized (this.f28927c) {
            f();
            this.f28926b.c();
            this.f28944t = o1.f.b();
            if (this.f28932h == null) {
                if (o1.k.r(this.f28935k, this.f28936l)) {
                    this.f28950z = this.f28935k;
                    this.A = this.f28936l;
                }
                x(new q("Received null model"), o() == null ? 5 : 3);
                return;
            }
            a aVar = this.f28946v;
            a aVar2 = a.RUNNING;
            if (aVar == aVar2) {
                throw new IllegalArgumentException("Cannot restart a running request");
            }
            if (aVar == a.COMPLETE) {
                a(this.f28942r, r0.a.MEMORY_CACHE);
                return;
            }
            a aVar3 = a.WAITING_FOR_SIZE;
            this.f28946v = aVar3;
            if (o1.k.r(this.f28935k, this.f28936l)) {
                c(this.f28935k, this.f28936l);
            } else {
                this.f28938n.e(this);
            }
            a aVar4 = this.f28946v;
            if ((aVar4 == aVar2 || aVar4 == aVar3) && k()) {
                this.f28938n.c(p());
            }
            if (D) {
                s("finished run method in " + o1.f.a(this.f28944t));
            }
        }
    }

    @Override // k1.c
    public void pause() {
        synchronized (this.f28927c) {
            if (isRunning()) {
                clear();
            }
        }
    }
}
