package l3;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import k2.n3;
import k2.w1;

/* JADX INFO: compiled from: SinglePeriodTimeline.java */
/* JADX INFO: loaded from: classes2.dex */
public final class x0 extends n3 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Object f30763p = new Object();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final w1 f30764q = new w1.c().d("SinglePeriodTimeline").g(Uri.EMPTY).a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f30765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f30766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f30767e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f30768f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f30769g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f30770h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f30771i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f30772j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f30773k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f30774l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private final Object f30775m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private final w1 f30776n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private final w1.g f30777o;

    public x0(long j10, boolean z10, boolean z11, boolean z12, @Nullable Object obj, w1 w1Var) {
        this(j10, j10, 0L, 0L, z10, z11, z12, obj, w1Var);
    }

    @Override // k2.n3
    public int f(Object obj) {
        return f30763p.equals(obj) ? 0 : -1;
    }

    @Override // k2.n3
    public n3.b k(int i10, n3.b bVar, boolean z10) {
        a4.a.c(i10, 0, 1);
        return bVar.v(null, z10 ? f30763p : null, 0, this.f30768f, -this.f30770h);
    }

    @Override // k2.n3
    public int m() {
        return 1;
    }

    @Override // k2.n3
    public Object q(int i10) {
        a4.a.c(i10, 0, 1);
        return f30763p;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002e A[PHI: r1
      0x002e: PHI (r1v2 long) = (r1v1 long), (r1v1 long), (r1v1 long), (r1v6 long) binds: [B:3:0x000d, B:5:0x0011, B:7:0x0017, B:12:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // k2.n3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public k2.n3.d s(int r25, k2.n3.d r26, long r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = 0
            r2 = 1
            r3 = r25
            a4.a.c(r3, r1, r2)
            long r1 = r0.f30771i
            boolean r14 = r0.f30773k
            if (r14 == 0) goto L2e
            boolean r3 = r0.f30774l
            if (r3 != 0) goto L2e
            r3 = 0
            int r3 = (r27 > r3 ? 1 : (r27 == r3 ? 0 : -1))
            if (r3 == 0) goto L2e
            long r3 = r0.f30769g
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L27
        L24:
            r16 = r5
            goto L30
        L27:
            long r1 = r1 + r27
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L2e
            goto L24
        L2e:
            r16 = r1
        L30:
            java.lang.Object r4 = k2.n3.d.f29309r
            k2.w1 r5 = r0.f30776n
            java.lang.Object r6 = r0.f30775m
            long r7 = r0.f30765c
            long r9 = r0.f30766d
            long r11 = r0.f30767e
            boolean r13 = r0.f30772j
            k2.w1$g r15 = r0.f30777o
            long r1 = r0.f30769g
            r18 = r1
            r20 = 0
            r21 = 0
            long r1 = r0.f30770h
            r22 = r1
            r3 = r26
            k2.n3$d r1 = r3.k(r4, r5, r6, r7, r9, r11, r13, r14, r15, r16, r18, r20, r21, r22)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.x0.s(int, k2.n3$d, long):k2.n3$d");
    }

    @Override // k2.n3
    public int t() {
        return 1;
    }

    public x0(long j10, long j11, long j12, long j13, boolean z10, boolean z11, boolean z12, @Nullable Object obj, w1 w1Var) {
        this(C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, j10, j11, j12, j13, z10, z11, false, obj, w1Var, z12 ? w1Var.f29519d : null);
    }

    public x0(long j10, long j11, long j12, long j13, long j14, long j15, long j16, boolean z10, boolean z11, boolean z12, @Nullable Object obj, w1 w1Var, @Nullable w1.g gVar) {
        this.f30765c = j10;
        this.f30766d = j11;
        this.f30767e = j12;
        this.f30768f = j13;
        this.f30769g = j14;
        this.f30770h = j15;
        this.f30771i = j16;
        this.f30772j = z10;
        this.f30773k = z11;
        this.f30774l = z12;
        this.f30775m = obj;
        this.f30776n = (w1) a4.a.e(w1Var);
        this.f30777o = gVar;
    }
}
