package com.ironsource;

import com.ironsource.mediationsdk.model.Placement;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class pp {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f14375p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<Placement> f14376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a4 f14377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f14378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14379d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14380e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f14381f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f14382g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f14383h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f14384i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f14385j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f14386k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f14387l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Placement f14388m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private h5 f14389n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f14390o;

    public pp() {
        this.f14376a = new ArrayList<>();
        this.f14377b = new a4();
    }

    public Placement a() {
        for (Placement placement : this.f14376a) {
            if (placement.isDefault()) {
                return placement;
            }
        }
        return this.f14388m;
    }

    public int b() {
        return this.f14382g;
    }

    public int c() {
        return this.f14381f;
    }

    public boolean d() {
        return this.f14390o;
    }

    public ArrayList<Placement> e() {
        return this.f14376a;
    }

    public boolean f() {
        return this.f14385j;
    }

    public int g() {
        return this.f14378c;
    }

    public int h() {
        return this.f14380e;
    }

    public long i() {
        return TimeUnit.SECONDS.toMillis(this.f14380e);
    }

    public boolean j() {
        return this.f14379d;
    }

    public h5 k() {
        return this.f14389n;
    }

    public boolean l() {
        return this.f14383h;
    }

    public long m() {
        return this.f14384i;
    }

    public a4 n() {
        return this.f14377b;
    }

    public boolean o() {
        return this.f14387l;
    }

    public boolean p() {
        return this.f14386k;
    }

    public String toString() {
        return "RewardedVideoConfigurations{parallelLoad=" + this.f14378c + ", bidderExclusive=" + this.f14379d + '}';
    }

    public pp(int i10, boolean z10, int i11, int i12, a4 a4Var, h5 h5Var, int i13, boolean z11, boolean z12, long j10, boolean z13, boolean z14, boolean z15) {
        this.f14376a = new ArrayList<>();
        this.f14378c = i10;
        this.f14379d = z10;
        this.f14380e = i11;
        this.f14377b = a4Var;
        this.f14381f = i12;
        this.f14389n = h5Var;
        this.f14382g = i13;
        this.f14390o = z11;
        this.f14383h = z12;
        this.f14384i = j10;
        this.f14385j = z13;
        this.f14386k = z14;
        this.f14387l = z15;
    }

    public Placement a(String str) {
        for (Placement placement : this.f14376a) {
            if (placement.getPlacementName().equals(str)) {
                return placement;
            }
        }
        return null;
    }

    public void a(Placement placement) {
        if (placement != null) {
            this.f14376a.add(placement);
            if (this.f14388m == null || placement.isPlacementId(0)) {
                this.f14388m = placement;
            }
        }
    }
}
