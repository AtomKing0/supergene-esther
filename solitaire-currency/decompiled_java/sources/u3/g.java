package u3;

import android.text.Layout;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: TtmlStyle.java */
/* JADX INFO: loaded from: classes2.dex */
final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private String f34567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f34568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f34569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f34570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f34571e;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f34577k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private String f34578l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private Layout.Alignment f34581o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private Layout.Alignment f34582p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    private b f34584r;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f34572f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f34573g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f34574h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f34575i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f34576j = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f34579m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f34580n = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f34583q = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f34585s = Float.MAX_VALUE;

    private g r(@Nullable g gVar, boolean z10) {
        int i10;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (gVar != null) {
            if (!this.f34569c && gVar.f34569c) {
                w(gVar.f34568b);
            }
            if (this.f34574h == -1) {
                this.f34574h = gVar.f34574h;
            }
            if (this.f34575i == -1) {
                this.f34575i = gVar.f34575i;
            }
            if (this.f34567a == null && (str = gVar.f34567a) != null) {
                this.f34567a = str;
            }
            if (this.f34572f == -1) {
                this.f34572f = gVar.f34572f;
            }
            if (this.f34573g == -1) {
                this.f34573g = gVar.f34573g;
            }
            if (this.f34580n == -1) {
                this.f34580n = gVar.f34580n;
            }
            if (this.f34581o == null && (alignment2 = gVar.f34581o) != null) {
                this.f34581o = alignment2;
            }
            if (this.f34582p == null && (alignment = gVar.f34582p) != null) {
                this.f34582p = alignment;
            }
            if (this.f34583q == -1) {
                this.f34583q = gVar.f34583q;
            }
            if (this.f34576j == -1) {
                this.f34576j = gVar.f34576j;
                this.f34577k = gVar.f34577k;
            }
            if (this.f34584r == null) {
                this.f34584r = gVar.f34584r;
            }
            if (this.f34585s == Float.MAX_VALUE) {
                this.f34585s = gVar.f34585s;
            }
            if (z10 && !this.f34571e && gVar.f34571e) {
                u(gVar.f34570d);
            }
            if (z10 && this.f34579m == -1 && (i10 = gVar.f34579m) != -1) {
                this.f34579m = i10;
            }
        }
        return this;
    }

    public g A(@Nullable String str) {
        this.f34578l = str;
        return this;
    }

    public g B(boolean z10) {
        this.f34575i = z10 ? 1 : 0;
        return this;
    }

    public g C(boolean z10) {
        this.f34572f = z10 ? 1 : 0;
        return this;
    }

    public g D(@Nullable Layout.Alignment alignment) {
        this.f34582p = alignment;
        return this;
    }

    public g E(int i10) {
        this.f34580n = i10;
        return this;
    }

    public g F(int i10) {
        this.f34579m = i10;
        return this;
    }

    public g G(float f10) {
        this.f34585s = f10;
        return this;
    }

    public g H(@Nullable Layout.Alignment alignment) {
        this.f34581o = alignment;
        return this;
    }

    public g I(boolean z10) {
        this.f34583q = z10 ? 1 : 0;
        return this;
    }

    public g J(@Nullable b bVar) {
        this.f34584r = bVar;
        return this;
    }

    public g K(boolean z10) {
        this.f34573g = z10 ? 1 : 0;
        return this;
    }

    public g a(@Nullable g gVar) {
        return r(gVar, true);
    }

    public int b() {
        if (this.f34571e) {
            return this.f34570d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public int c() {
        if (this.f34569c) {
            return this.f34568b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    @Nullable
    public String d() {
        return this.f34567a;
    }

    public float e() {
        return this.f34577k;
    }

    public int f() {
        return this.f34576j;
    }

    @Nullable
    public String g() {
        return this.f34578l;
    }

    @Nullable
    public Layout.Alignment h() {
        return this.f34582p;
    }

    public int i() {
        return this.f34580n;
    }

    public int j() {
        return this.f34579m;
    }

    public float k() {
        return this.f34585s;
    }

    public int l() {
        int i10 = this.f34574h;
        if (i10 == -1 && this.f34575i == -1) {
            return -1;
        }
        return (i10 == 1 ? 1 : 0) | (this.f34575i == 1 ? 2 : 0);
    }

    @Nullable
    public Layout.Alignment m() {
        return this.f34581o;
    }

    public boolean n() {
        return this.f34583q == 1;
    }

    @Nullable
    public b o() {
        return this.f34584r;
    }

    public boolean p() {
        return this.f34571e;
    }

    public boolean q() {
        return this.f34569c;
    }

    public boolean s() {
        return this.f34572f == 1;
    }

    public boolean t() {
        return this.f34573g == 1;
    }

    public g u(int i10) {
        this.f34570d = i10;
        this.f34571e = true;
        return this;
    }

    public g v(boolean z10) {
        this.f34574h = z10 ? 1 : 0;
        return this;
    }

    public g w(int i10) {
        this.f34568b = i10;
        this.f34569c = true;
        return this;
    }

    public g x(@Nullable String str) {
        this.f34567a = str;
        return this;
    }

    public g y(float f10) {
        this.f34577k = f10;
        return this;
    }

    public g z(int i10) {
        this.f34576j = i10;
        return this;
    }
}
