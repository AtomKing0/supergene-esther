package x2;

import a4.c0;
import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: TrackFragment.java */
/* JADX INFO: loaded from: classes2.dex */
final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f35874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f35875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f35876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f35877d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f35878e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f35879f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f35885l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public p f35887n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f35889p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f35890q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f35891r;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long[] f35880g = new long[0];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f35881h = new int[0];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f35882i = new int[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long[] f35883j = new long[0];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean[] f35884k = new boolean[0];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean[] f35886m = new boolean[0];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c0 f35888o = new c0();

    public void a(c0 c0Var) {
        c0Var.j(this.f35888o.d(), 0, this.f35888o.f());
        this.f35888o.P(0);
        this.f35889p = false;
    }

    public void b(p2.m mVar) throws IOException {
        mVar.readFully(this.f35888o.d(), 0, this.f35888o.f());
        this.f35888o.P(0);
        this.f35889p = false;
    }

    public long c(int i10) {
        return this.f35883j[i10];
    }

    public void d(int i10) {
        this.f35888o.L(i10);
        this.f35885l = true;
        this.f35889p = true;
    }

    public void e(int i10, int i11) {
        this.f35878e = i10;
        this.f35879f = i11;
        if (this.f35881h.length < i10) {
            this.f35880g = new long[i10];
            this.f35881h = new int[i10];
        }
        if (this.f35882i.length < i11) {
            int i12 = (i11 * 125) / 100;
            this.f35882i = new int[i12];
            this.f35883j = new long[i12];
            this.f35884k = new boolean[i12];
            this.f35886m = new boolean[i12];
        }
    }

    public void f() {
        this.f35878e = 0;
        this.f35890q = 0L;
        this.f35891r = false;
        this.f35885l = false;
        this.f35889p = false;
        this.f35887n = null;
    }

    public boolean g(int i10) {
        return this.f35885l && this.f35886m[i10];
    }
}
