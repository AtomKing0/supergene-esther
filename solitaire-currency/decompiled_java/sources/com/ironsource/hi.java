package com.ironsource;

import com.ironsource.mediationsdk.model.InterstitialPlacement;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class hi {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f12482o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<InterstitialPlacement> f12483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a4 f12484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f12485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f12486d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f12487e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f12488f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private h5 f12489g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f12490h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f12491i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f12492j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f12493k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f12494l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f12495m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private InterstitialPlacement f12496n;

    public hi() {
        this.f12483a = new ArrayList<>();
        this.f12484b = new a4();
        this.f12489g = new h5();
    }

    public InterstitialPlacement a() {
        for (InterstitialPlacement interstitialPlacement : this.f12483a) {
            if (interstitialPlacement.isDefault()) {
                return interstitialPlacement;
            }
        }
        return this.f12496n;
    }

    public int b() {
        return this.f12488f;
    }

    public int c() {
        return this.f12485c;
    }

    public int d() {
        return this.f12487e;
    }

    public long e() {
        return TimeUnit.SECONDS.toMillis(this.f12487e);
    }

    public boolean f() {
        return this.f12486d;
    }

    public h5 g() {
        return this.f12489g;
    }

    public boolean h() {
        return this.f12491i;
    }

    public long i() {
        return this.f12492j;
    }

    public a4 j() {
        return this.f12484b;
    }

    public boolean k() {
        return this.f12490h;
    }

    public boolean l() {
        return this.f12493k;
    }

    public boolean m() {
        return this.f12495m;
    }

    public boolean n() {
        return this.f12494l;
    }

    public String toString() {
        return "InterstitialConfigurations{parallelLoad=" + this.f12485c + ", bidderExclusive=" + this.f12486d + '}';
    }

    public hi(int i10, boolean z10, int i11, a4 a4Var, h5 h5Var, int i12, boolean z11, boolean z12, long j10, boolean z13, boolean z14, boolean z15) {
        this.f12483a = new ArrayList<>();
        this.f12485c = i10;
        this.f12486d = z10;
        this.f12487e = i11;
        this.f12484b = a4Var;
        this.f12489g = h5Var;
        this.f12493k = z13;
        this.f12494l = z14;
        this.f12488f = i12;
        this.f12490h = z11;
        this.f12491i = z12;
        this.f12492j = j10;
        this.f12495m = z15;
    }

    public InterstitialPlacement a(String str) {
        for (InterstitialPlacement interstitialPlacement : this.f12483a) {
            if (interstitialPlacement.getPlacementName().equals(str)) {
                return interstitialPlacement;
            }
        }
        return null;
    }

    public void a(InterstitialPlacement interstitialPlacement) {
        if (interstitialPlacement != null) {
            this.f12483a.add(interstitialPlacement);
            if (this.f12496n == null || interstitialPlacement.isPlacementId(0)) {
                this.f12496n = interstitialPlacement;
            }
        }
    }
}
