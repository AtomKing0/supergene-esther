package com.ironsource;

import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public class n6 {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f14079q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a4 f14080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f14082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList<b7> f14084e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b7 f14085f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f14086g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f14087h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private h5 f14088i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f14089j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f14090k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f14091l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f14092m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f14093n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f14094o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f14095p;

    public n6() {
        this.f14080a = new a4();
        this.f14084e = new ArrayList<>();
    }

    public int a() {
        return this.f14081b;
    }

    public long b() {
        return this.f14082c;
    }

    public boolean c() {
        return this.f14083d;
    }

    public h5 d() {
        return this.f14088i;
    }

    public boolean e() {
        return this.f14090k;
    }

    public long f() {
        return this.f14091l;
    }

    public int g() {
        return this.f14087h;
    }

    public a4 h() {
        return this.f14080a;
    }

    public int i() {
        return this.f14086g;
    }

    @NotNull
    public b7 j() {
        for (b7 b7Var : this.f14084e) {
            if (b7Var.isDefault()) {
                return b7Var;
            }
        }
        return this.f14085f;
    }

    public long k() {
        return this.f14095p;
    }

    public boolean l() {
        return this.f14089j;
    }

    public boolean m() {
        return this.f14092m;
    }

    public boolean n() {
        return this.f14094o;
    }

    public boolean o() {
        return this.f14093n;
    }

    public String toString() {
        return "BannerConfigurations{parallelLoad=" + this.f14081b + ", bidderExclusive=" + this.f14083d + '}';
    }

    public n6(int i10, long j10, boolean z10, a4 a4Var, int i11, h5 h5Var, int i12, boolean z11, boolean z12, long j11, boolean z13, boolean z14, boolean z15, long j12) {
        this.f14084e = new ArrayList<>();
        this.f14081b = i10;
        this.f14082c = j10;
        this.f14083d = z10;
        this.f14080a = a4Var;
        this.f14086g = i11;
        this.f14087h = i12;
        this.f14088i = h5Var;
        this.f14089j = z11;
        this.f14090k = z12;
        this.f14091l = j11;
        this.f14092m = z13;
        this.f14093n = z14;
        this.f14094o = z15;
        this.f14095p = j12;
    }

    public b7 a(String str) {
        for (b7 b7Var : this.f14084e) {
            if (b7Var.getPlacementName().equals(str)) {
                return b7Var;
            }
        }
        return null;
    }

    public void a(b7 b7Var) {
        if (b7Var != null) {
            this.f14084e.add(b7Var);
            if (this.f14085f == null || b7Var.isPlacementId(0)) {
                this.f14085f = b7Var;
            }
        }
    }
}
