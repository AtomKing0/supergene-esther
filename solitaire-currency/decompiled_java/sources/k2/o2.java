package k2;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.util.List;
import l3.a0;

/* JADX INFO: compiled from: PlaybackInfo.java */
/* JADX INFO: loaded from: classes2.dex */
final class o2 {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final a0.b f29388s = new a0.b(new Object());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n3 f29389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0.b f29390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f29391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f29392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f29393e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final q f29394f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f29395g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l3.e1 f29396h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final x3.c0 f29397i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<c3.a> f29398j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a0.b f29399k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f29400l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f29401m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final q2 f29402n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f29403o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile long f29404p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile long f29405q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile long f29406r;

    public o2(n3 n3Var, a0.b bVar, long j10, long j11, int i10, @Nullable q qVar, boolean z10, l3.e1 e1Var, x3.c0 c0Var, List<c3.a> list, a0.b bVar2, boolean z11, int i11, q2 q2Var, long j12, long j13, long j14, boolean z12) {
        this.f29389a = n3Var;
        this.f29390b = bVar;
        this.f29391c = j10;
        this.f29392d = j11;
        this.f29393e = i10;
        this.f29394f = qVar;
        this.f29395g = z10;
        this.f29396h = e1Var;
        this.f29397i = c0Var;
        this.f29398j = list;
        this.f29399k = bVar2;
        this.f29400l = z11;
        this.f29401m = i11;
        this.f29402n = q2Var;
        this.f29404p = j12;
        this.f29405q = j13;
        this.f29406r = j14;
        this.f29403o = z12;
    }

    public static o2 j(x3.c0 c0Var) {
        n3 n3Var = n3.f29295a;
        a0.b bVar = f29388s;
        return new o2(n3Var, bVar, C.TIME_UNSET, 0L, 1, null, false, l3.e1.f30515d, c0Var, com.google.common.collect.y.q(), bVar, false, 0, q2.f29419d, 0L, 0L, 0L, false);
    }

    public static a0.b k() {
        return f29388s;
    }

    @CheckResult
    public o2 a(boolean z10) {
        return new o2(this.f29389a, this.f29390b, this.f29391c, this.f29392d, this.f29393e, this.f29394f, z10, this.f29396h, this.f29397i, this.f29398j, this.f29399k, this.f29400l, this.f29401m, this.f29402n, this.f29404p, this.f29405q, this.f29406r, this.f29403o);
    }

    @CheckResult
    public o2 b(a0.b bVar) {
        return new o2(this.f29389a, this.f29390b, this.f29391c, this.f29392d, this.f29393e, this.f29394f, this.f29395g, this.f29396h, this.f29397i, this.f29398j, bVar, this.f29400l, this.f29401m, this.f29402n, this.f29404p, this.f29405q, this.f29406r, this.f29403o);
    }

    @CheckResult
    public o2 c(a0.b bVar, long j10, long j11, long j12, long j13, l3.e1 e1Var, x3.c0 c0Var, List<c3.a> list) {
        return new o2(this.f29389a, bVar, j11, j12, this.f29393e, this.f29394f, this.f29395g, e1Var, c0Var, list, this.f29399k, this.f29400l, this.f29401m, this.f29402n, this.f29404p, j13, j10, this.f29403o);
    }

    @CheckResult
    public o2 d(boolean z10, int i10) {
        return new o2(this.f29389a, this.f29390b, this.f29391c, this.f29392d, this.f29393e, this.f29394f, this.f29395g, this.f29396h, this.f29397i, this.f29398j, this.f29399k, z10, i10, this.f29402n, this.f29404p, this.f29405q, this.f29406r, this.f29403o);
    }

    @CheckResult
    public o2 e(@Nullable q qVar) {
        return new o2(this.f29389a, this.f29390b, this.f29391c, this.f29392d, this.f29393e, qVar, this.f29395g, this.f29396h, this.f29397i, this.f29398j, this.f29399k, this.f29400l, this.f29401m, this.f29402n, this.f29404p, this.f29405q, this.f29406r, this.f29403o);
    }

    @CheckResult
    public o2 f(q2 q2Var) {
        return new o2(this.f29389a, this.f29390b, this.f29391c, this.f29392d, this.f29393e, this.f29394f, this.f29395g, this.f29396h, this.f29397i, this.f29398j, this.f29399k, this.f29400l, this.f29401m, q2Var, this.f29404p, this.f29405q, this.f29406r, this.f29403o);
    }

    @CheckResult
    public o2 g(int i10) {
        return new o2(this.f29389a, this.f29390b, this.f29391c, this.f29392d, i10, this.f29394f, this.f29395g, this.f29396h, this.f29397i, this.f29398j, this.f29399k, this.f29400l, this.f29401m, this.f29402n, this.f29404p, this.f29405q, this.f29406r, this.f29403o);
    }

    @CheckResult
    public o2 h(boolean z10) {
        return new o2(this.f29389a, this.f29390b, this.f29391c, this.f29392d, this.f29393e, this.f29394f, this.f29395g, this.f29396h, this.f29397i, this.f29398j, this.f29399k, this.f29400l, this.f29401m, this.f29402n, this.f29404p, this.f29405q, this.f29406r, z10);
    }

    @CheckResult
    public o2 i(n3 n3Var) {
        return new o2(n3Var, this.f29390b, this.f29391c, this.f29392d, this.f29393e, this.f29394f, this.f29395g, this.f29396h, this.f29397i, this.f29398j, this.f29399k, this.f29400l, this.f29401m, this.f29402n, this.f29404p, this.f29405q, this.f29406r, this.f29403o);
    }
}
