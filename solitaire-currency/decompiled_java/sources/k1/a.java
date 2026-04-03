package k1;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b1.m;
import b1.s;
import b1.u;
import java.util.Map;
import k1.a;
import o1.k;
import r0.l;
import u0.j;

/* JADX INFO: compiled from: BaseRequestOptions.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T extends a<T>> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f28886a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private Drawable f28890e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f28891f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private Drawable f28892g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f28893h;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f28898m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private Drawable f28900o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f28901p;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f28905t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private Resources.Theme f28906u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f28907v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f28908w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f28909x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f28911z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f28887b = 1.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private j f28888c = j.f34325e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    private com.bumptech.glide.f f28889d = com.bumptech.glide.f.NORMAL;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f28894i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f28895j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f28896k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    private r0.f f28897l = n1.a.c();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f28899n = true;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    private r0.h f28902q = new r0.h();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    private Map<Class<?>, l<?>> f28903r = new o1.b();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    private Class<?> f28904s = Object.class;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f28910y = true;

    private boolean F(int i10) {
        return G(this.f28886a, i10);
    }

    private static boolean G(int i10, int i11) {
        return (i10 & i11) != 0;
    }

    @NonNull
    private T P(@NonNull m mVar, @NonNull l<Bitmap> lVar) {
        return (T) U(mVar, lVar, false);
    }

    @NonNull
    private T T(@NonNull m mVar, @NonNull l<Bitmap> lVar) {
        return (T) U(mVar, lVar, true);
    }

    @NonNull
    private T U(@NonNull m mVar, @NonNull l<Bitmap> lVar, boolean z10) {
        T t10 = z10 ? (T) c0(mVar, lVar) : (T) Q(mVar, lVar);
        t10.f28910y = true;
        return t10;
    }

    @NonNull
    private T W() {
        if (this.f28905t) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return (T) V();
    }

    public final boolean A() {
        return this.f28911z;
    }

    public final boolean B() {
        return this.f28908w;
    }

    public final boolean C() {
        return this.f28894i;
    }

    public final boolean D() {
        return F(8);
    }

    boolean E() {
        return this.f28910y;
    }

    public final boolean H() {
        return this.f28899n;
    }

    public final boolean I() {
        return this.f28898m;
    }

    public final boolean J() {
        return F(2048);
    }

    public final boolean K() {
        return k.r(this.f28896k, this.f28895j);
    }

    @NonNull
    public T L() {
        this.f28905t = true;
        return (T) V();
    }

    @NonNull
    @CheckResult
    public T M() {
        return (T) Q(m.f1852e, new b1.j());
    }

    @NonNull
    @CheckResult
    public T N() {
        return (T) P(m.f1851d, new b1.k());
    }

    @NonNull
    @CheckResult
    public T O() {
        return (T) P(m.f1850c, new u());
    }

    @NonNull
    final T Q(@NonNull m mVar, @NonNull l<Bitmap> lVar) {
        if (this.f28907v) {
            return (T) d().Q(mVar, lVar);
        }
        g(mVar);
        return (T) f0(lVar, false);
    }

    @NonNull
    @CheckResult
    public T R(int i10, int i11) {
        if (this.f28907v) {
            return (T) d().R(i10, i11);
        }
        this.f28896k = i10;
        this.f28895j = i11;
        this.f28886a |= 512;
        return (T) W();
    }

    @NonNull
    @CheckResult
    public T S(@NonNull com.bumptech.glide.f fVar) {
        if (this.f28907v) {
            return (T) d().S(fVar);
        }
        this.f28889d = (com.bumptech.glide.f) o1.j.d(fVar);
        this.f28886a |= 8;
        return (T) W();
    }

    @NonNull
    @CheckResult
    public <Y> T X(@NonNull r0.g<Y> gVar, @NonNull Y y10) {
        if (this.f28907v) {
            return (T) d().X(gVar, y10);
        }
        o1.j.d(gVar);
        o1.j.d(y10);
        this.f28902q.e(gVar, y10);
        return (T) W();
    }

    @NonNull
    @CheckResult
    public T Y(@NonNull r0.f fVar) {
        if (this.f28907v) {
            return (T) d().Y(fVar);
        }
        this.f28897l = (r0.f) o1.j.d(fVar);
        this.f28886a |= 1024;
        return (T) W();
    }

    @NonNull
    @CheckResult
    public T Z(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        if (this.f28907v) {
            return (T) d().Z(f10);
        }
        if (f10 < 0.0f || f10 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f28887b = f10;
        this.f28886a |= 2;
        return (T) W();
    }

    @NonNull
    @CheckResult
    public T a0(boolean z10) {
        if (this.f28907v) {
            return (T) d().a0(true);
        }
        this.f28894i = !z10;
        this.f28886a |= 256;
        return (T) W();
    }

    @NonNull
    @CheckResult
    public T b(@NonNull a<?> aVar) {
        if (this.f28907v) {
            return (T) d().b(aVar);
        }
        if (G(aVar.f28886a, 2)) {
            this.f28887b = aVar.f28887b;
        }
        if (G(aVar.f28886a, 262144)) {
            this.f28908w = aVar.f28908w;
        }
        if (G(aVar.f28886a, 1048576)) {
            this.f28911z = aVar.f28911z;
        }
        if (G(aVar.f28886a, 4)) {
            this.f28888c = aVar.f28888c;
        }
        if (G(aVar.f28886a, 8)) {
            this.f28889d = aVar.f28889d;
        }
        if (G(aVar.f28886a, 16)) {
            this.f28890e = aVar.f28890e;
            this.f28891f = 0;
            this.f28886a &= -33;
        }
        if (G(aVar.f28886a, 32)) {
            this.f28891f = aVar.f28891f;
            this.f28890e = null;
            this.f28886a &= -17;
        }
        if (G(aVar.f28886a, 64)) {
            this.f28892g = aVar.f28892g;
            this.f28893h = 0;
            this.f28886a &= -129;
        }
        if (G(aVar.f28886a, 128)) {
            this.f28893h = aVar.f28893h;
            this.f28892g = null;
            this.f28886a &= -65;
        }
        if (G(aVar.f28886a, 256)) {
            this.f28894i = aVar.f28894i;
        }
        if (G(aVar.f28886a, 512)) {
            this.f28896k = aVar.f28896k;
            this.f28895j = aVar.f28895j;
        }
        if (G(aVar.f28886a, 1024)) {
            this.f28897l = aVar.f28897l;
        }
        if (G(aVar.f28886a, 4096)) {
            this.f28904s = aVar.f28904s;
        }
        if (G(aVar.f28886a, 8192)) {
            this.f28900o = aVar.f28900o;
            this.f28901p = 0;
            this.f28886a &= -16385;
        }
        if (G(aVar.f28886a, 16384)) {
            this.f28901p = aVar.f28901p;
            this.f28900o = null;
            this.f28886a &= -8193;
        }
        if (G(aVar.f28886a, 32768)) {
            this.f28906u = aVar.f28906u;
        }
        if (G(aVar.f28886a, 65536)) {
            this.f28899n = aVar.f28899n;
        }
        if (G(aVar.f28886a, 131072)) {
            this.f28898m = aVar.f28898m;
        }
        if (G(aVar.f28886a, 2048)) {
            this.f28903r.putAll(aVar.f28903r);
            this.f28910y = aVar.f28910y;
        }
        if (G(aVar.f28886a, 524288)) {
            this.f28909x = aVar.f28909x;
        }
        if (!this.f28899n) {
            this.f28903r.clear();
            int i10 = this.f28886a & (-2049);
            this.f28898m = false;
            this.f28886a = i10 & (-131073);
            this.f28910y = true;
        }
        this.f28886a |= aVar.f28886a;
        this.f28902q.d(aVar.f28902q);
        return (T) W();
    }

    @NonNull
    @CheckResult
    public T b0(@IntRange(from = 0) int i10) {
        return (T) X(z0.a.f36962b, Integer.valueOf(i10));
    }

    @NonNull
    public T c() {
        if (this.f28905t && !this.f28907v) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.f28907v = true;
        return (T) L();
    }

    @NonNull
    @CheckResult
    final T c0(@NonNull m mVar, @NonNull l<Bitmap> lVar) {
        if (this.f28907v) {
            return (T) d().c0(mVar, lVar);
        }
        g(mVar);
        return (T) e0(lVar);
    }

    @Override // 
    @CheckResult
    public T d() {
        try {
            T t10 = (T) super.clone();
            r0.h hVar = new r0.h();
            t10.f28902q = hVar;
            hVar.d(this.f28902q);
            o1.b bVar = new o1.b();
            t10.f28903r = bVar;
            bVar.putAll(this.f28903r);
            t10.f28905t = false;
            t10.f28907v = false;
            return t10;
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    @NonNull
    <Y> T d0(@NonNull Class<Y> cls, @NonNull l<Y> lVar, boolean z10) {
        if (this.f28907v) {
            return (T) d().d0(cls, lVar, z10);
        }
        o1.j.d(cls);
        o1.j.d(lVar);
        this.f28903r.put(cls, lVar);
        int i10 = this.f28886a | 2048;
        this.f28899n = true;
        int i11 = i10 | 65536;
        this.f28886a = i11;
        this.f28910y = false;
        if (z10) {
            this.f28886a = i11 | 131072;
            this.f28898m = true;
        }
        return (T) W();
    }

    @NonNull
    @CheckResult
    public T e(@NonNull Class<?> cls) {
        if (this.f28907v) {
            return (T) d().e(cls);
        }
        this.f28904s = (Class) o1.j.d(cls);
        this.f28886a |= 4096;
        return (T) W();
    }

    @NonNull
    @CheckResult
    public T e0(@NonNull l<Bitmap> lVar) {
        return (T) f0(lVar, true);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Float.compare(aVar.f28887b, this.f28887b) == 0 && this.f28891f == aVar.f28891f && k.c(this.f28890e, aVar.f28890e) && this.f28893h == aVar.f28893h && k.c(this.f28892g, aVar.f28892g) && this.f28901p == aVar.f28901p && k.c(this.f28900o, aVar.f28900o) && this.f28894i == aVar.f28894i && this.f28895j == aVar.f28895j && this.f28896k == aVar.f28896k && this.f28898m == aVar.f28898m && this.f28899n == aVar.f28899n && this.f28908w == aVar.f28908w && this.f28909x == aVar.f28909x && this.f28888c.equals(aVar.f28888c) && this.f28889d == aVar.f28889d && this.f28902q.equals(aVar.f28902q) && this.f28903r.equals(aVar.f28903r) && this.f28904s.equals(aVar.f28904s) && k.c(this.f28897l, aVar.f28897l) && k.c(this.f28906u, aVar.f28906u);
    }

    @NonNull
    @CheckResult
    public T f(@NonNull j jVar) {
        if (this.f28907v) {
            return (T) d().f(jVar);
        }
        this.f28888c = (j) o1.j.d(jVar);
        this.f28886a |= 4;
        return (T) W();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    T f0(@NonNull l<Bitmap> lVar, boolean z10) {
        if (this.f28907v) {
            return (T) d().f0(lVar, z10);
        }
        s sVar = new s(lVar, z10);
        d0(Bitmap.class, lVar, z10);
        d0(Drawable.class, sVar, z10);
        d0(BitmapDrawable.class, sVar.c(), z10);
        d0(f1.c.class, new f1.f(lVar), z10);
        return (T) W();
    }

    @NonNull
    @CheckResult
    public T g(@NonNull m mVar) {
        return (T) X(m.f1855h, o1.j.d(mVar));
    }

    @NonNull
    @CheckResult
    public T g0(boolean z10) {
        if (this.f28907v) {
            return (T) d().g0(z10);
        }
        this.f28911z = z10;
        this.f28886a |= 1048576;
        return (T) W();
    }

    @NonNull
    @CheckResult
    public T h() {
        return (T) T(m.f1850c, new u());
    }

    public int hashCode() {
        return k.m(this.f28906u, k.m(this.f28897l, k.m(this.f28904s, k.m(this.f28903r, k.m(this.f28902q, k.m(this.f28889d, k.m(this.f28888c, k.n(this.f28909x, k.n(this.f28908w, k.n(this.f28899n, k.n(this.f28898m, k.l(this.f28896k, k.l(this.f28895j, k.n(this.f28894i, k.m(this.f28900o, k.l(this.f28901p, k.m(this.f28892g, k.l(this.f28893h, k.m(this.f28890e, k.l(this.f28891f, k.j(this.f28887b)))))))))))))))))))));
    }

    @NonNull
    public final j i() {
        return this.f28888c;
    }

    public final int j() {
        return this.f28891f;
    }

    @Nullable
    public final Drawable k() {
        return this.f28890e;
    }

    @Nullable
    public final Drawable l() {
        return this.f28900o;
    }

    public final int m() {
        return this.f28901p;
    }

    public final boolean o() {
        return this.f28909x;
    }

    @NonNull
    public final r0.h p() {
        return this.f28902q;
    }

    public final int q() {
        return this.f28895j;
    }

    public final int r() {
        return this.f28896k;
    }

    @Nullable
    public final Drawable s() {
        return this.f28892g;
    }

    public final int t() {
        return this.f28893h;
    }

    @NonNull
    public final com.bumptech.glide.f u() {
        return this.f28889d;
    }

    @NonNull
    public final Class<?> v() {
        return this.f28904s;
    }

    @NonNull
    public final r0.f w() {
        return this.f28897l;
    }

    public final float x() {
        return this.f28887b;
    }

    @Nullable
    public final Resources.Theme y() {
        return this.f28906u;
    }

    @NonNull
    public final Map<Class<?>, l<?>> z() {
        return this.f28903r;
    }

    private T V() {
        return this;
    }
}
