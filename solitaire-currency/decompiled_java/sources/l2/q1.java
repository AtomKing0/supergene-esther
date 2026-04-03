package l2;

import android.util.Base64;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import k2.n3;
import l2.c;
import l2.s1;
import l3.a0;

/* JADX INFO: compiled from: DefaultPlaybackSessionManager.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q1 implements s1 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e5.u<String> f30355h = new e5.u() { // from class: l2.p1
        @Override // e5.u
        public final Object get() {
            return q1.j();
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Random f30356i = new Random();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n3.d f30357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n3.b f30358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<String, a> f30359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e5.u<String> f30360d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private s1.a f30361e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private n3 f30362f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private String f30363g;

    /* JADX INFO: compiled from: DefaultPlaybackSessionManager.java */
    private final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f30364a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f30365b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f30366c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private a0.b f30367d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f30368e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f30369f;

        public a(String str, int i10, @Nullable a0.b bVar) {
            this.f30364a = str;
            this.f30365b = i10;
            this.f30366c = bVar == null ? -1L : bVar.f30781d;
            if (bVar == null || !bVar.b()) {
                return;
            }
            this.f30367d = bVar;
        }

        private int l(n3 n3Var, n3 n3Var2, int i10) {
            if (i10 >= n3Var.t()) {
                if (i10 < n3Var2.t()) {
                    return i10;
                }
                return -1;
            }
            n3Var.r(i10, q1.this.f30357a);
            for (int i11 = q1.this.f30357a.f29327o; i11 <= q1.this.f30357a.f29328p; i11++) {
                int iF = n3Var2.f(n3Var.q(i11));
                if (iF != -1) {
                    return n3Var2.j(iF, q1.this.f30358b).f29300c;
                }
            }
            return -1;
        }

        public boolean i(int i10, @Nullable a0.b bVar) {
            if (bVar == null) {
                return i10 == this.f30365b;
            }
            a0.b bVar2 = this.f30367d;
            return bVar2 == null ? !bVar.b() && bVar.f30781d == this.f30366c : bVar.f30781d == bVar2.f30781d && bVar.f30779b == bVar2.f30779b && bVar.f30780c == bVar2.f30780c;
        }

        public boolean j(c.a aVar) {
            a0.b bVar = aVar.f30243d;
            if (bVar == null) {
                return this.f30365b != aVar.f30242c;
            }
            long j10 = this.f30366c;
            if (j10 == -1) {
                return false;
            }
            if (bVar.f30781d > j10) {
                return true;
            }
            if (this.f30367d == null) {
                return false;
            }
            int iF = aVar.f30241b.f(bVar.f30778a);
            int iF2 = aVar.f30241b.f(this.f30367d.f30778a);
            a0.b bVar2 = aVar.f30243d;
            if (bVar2.f30781d < this.f30367d.f30781d || iF < iF2) {
                return false;
            }
            if (iF > iF2) {
                return true;
            }
            if (!bVar2.b()) {
                int i10 = aVar.f30243d.f30782e;
                return i10 == -1 || i10 > this.f30367d.f30779b;
            }
            a0.b bVar3 = aVar.f30243d;
            int i11 = bVar3.f30779b;
            int i12 = bVar3.f30780c;
            a0.b bVar4 = this.f30367d;
            int i13 = bVar4.f30779b;
            if (i11 <= i13) {
                return i11 == i13 && i12 > bVar4.f30780c;
            }
            return true;
        }

        public void k(int i10, @Nullable a0.b bVar) {
            if (this.f30366c == -1 && i10 == this.f30365b && bVar != null) {
                this.f30366c = bVar.f30781d;
            }
        }

        public boolean m(n3 n3Var, n3 n3Var2) {
            int iL = l(n3Var, n3Var2, this.f30365b);
            this.f30365b = iL;
            if (iL == -1) {
                return false;
            }
            a0.b bVar = this.f30367d;
            return bVar == null || n3Var2.f(bVar.f30778a) != -1;
        }
    }

    public q1() {
        this(f30355h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String j() {
        byte[] bArr = new byte[12];
        f30356i.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    private a k(int i10, @Nullable a0.b bVar) {
        a aVar = null;
        long j10 = Long.MAX_VALUE;
        for (a aVar2 : this.f30359c.values()) {
            aVar2.k(i10, bVar);
            if (aVar2.i(i10, bVar)) {
                long j11 = aVar2.f30366c;
                if (j11 == -1 || j11 < j10) {
                    aVar = aVar2;
                    j10 = j11;
                } else if (j11 == j10 && ((a) a4.o0.j(aVar)).f30367d != null && aVar2.f30367d != null) {
                    aVar = aVar2;
                }
            }
        }
        if (aVar != null) {
            return aVar;
        }
        String str = this.f30360d.get();
        a aVar3 = new a(str, i10, bVar);
        this.f30359c.put(str, aVar3);
        return aVar3;
    }

    private void l(c.a aVar) {
        if (aVar.f30241b.u()) {
            this.f30363g = null;
            return;
        }
        a aVar2 = this.f30359c.get(this.f30363g);
        a aVarK = k(aVar.f30242c, aVar.f30243d);
        this.f30363g = aVarK.f30364a;
        d(aVar);
        a0.b bVar = aVar.f30243d;
        if (bVar == null || !bVar.b()) {
            return;
        }
        if (aVar2 != null && aVar2.f30366c == aVar.f30243d.f30781d && aVar2.f30367d != null && aVar2.f30367d.f30779b == aVar.f30243d.f30779b && aVar2.f30367d.f30780c == aVar.f30243d.f30780c) {
            return;
        }
        a0.b bVar2 = aVar.f30243d;
        this.f30361e.o0(aVar, k(aVar.f30242c, new a0.b(bVar2.f30778a, bVar2.f30781d)).f30364a, aVarK.f30364a);
    }

    @Override // l2.s1
    public void a(s1.a aVar) {
        this.f30361e = aVar;
    }

    @Override // l2.s1
    public synchronized void b(c.a aVar) {
        s1.a aVar2;
        this.f30363g = null;
        Iterator<a> it = this.f30359c.values().iterator();
        while (it.hasNext()) {
            a next = it.next();
            it.remove();
            if (next.f30368e && (aVar2 = this.f30361e) != null) {
                aVar2.U(aVar, next.f30364a, false);
            }
        }
    }

    @Override // l2.s1
    public synchronized String c(n3 n3Var, a0.b bVar) {
        return k(n3Var.l(bVar.f30778a, this.f30358b).f29300c, bVar).f30364a;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e1 A[Catch: all -> 0x0118, TryCatch #0 {, blocks: (B:4:0x0005, B:8:0x0014, B:11:0x0025, B:13:0x0030, B:16:0x003a, B:23:0x004b, B:25:0x0057, B:26:0x005d, B:28:0x0061, B:30:0x0067, B:32:0x0080, B:34:0x00db, B:36:0x00e1, B:38:0x00f7, B:40:0x0103, B:42:0x0109), top: B:48:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f3  */
    @Override // l2.s1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void d(l2.c.a r25) {
        /*
            Method dump skipped, instruction units count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l2.q1.d(l2.c$a):void");
    }

    @Override // l2.s1
    public synchronized void e(c.a aVar, int i10) {
        a4.a.e(this.f30361e);
        boolean z10 = i10 == 0;
        Iterator<a> it = this.f30359c.values().iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.j(aVar)) {
                it.remove();
                if (next.f30368e) {
                    boolean zEquals = next.f30364a.equals(this.f30363g);
                    boolean z11 = z10 && zEquals && next.f30369f;
                    if (zEquals) {
                        this.f30363g = null;
                    }
                    this.f30361e.U(aVar, next.f30364a, z11);
                }
            }
        }
        l(aVar);
    }

    @Override // l2.s1
    public synchronized void f(c.a aVar) {
        a4.a.e(this.f30361e);
        n3 n3Var = this.f30362f;
        this.f30362f = aVar.f30241b;
        Iterator<a> it = this.f30359c.values().iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!next.m(n3Var, this.f30362f) || next.j(aVar)) {
                it.remove();
                if (next.f30368e) {
                    if (next.f30364a.equals(this.f30363g)) {
                        this.f30363g = null;
                    }
                    this.f30361e.U(aVar, next.f30364a, false);
                }
            }
        }
        l(aVar);
    }

    @Override // l2.s1
    @Nullable
    public synchronized String getActiveSessionId() {
        return this.f30363g;
    }

    public q1(e5.u<String> uVar) {
        this.f30360d = uVar;
        this.f30357a = new n3.d();
        this.f30358b = new n3.b();
        this.f30359c = new HashMap<>();
        this.f30362f = n3.f29295a;
    }
}
