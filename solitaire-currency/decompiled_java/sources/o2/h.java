package o2;

import android.annotation.SuppressLint;
import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.C;
import com.google.common.collect.c1;
import com.google.common.collect.i1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import k2.o1;
import l2.t1;
import o2.g;
import o2.g0;
import o2.m;
import o2.o;
import o2.w;
import o2.y;

/* JADX INFO: compiled from: DefaultDrmSessionManager.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(18)
public class h implements y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final UUID f31851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g0.c f31852d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final n0 f31853e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashMap<String, String> f31854f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f31855g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int[] f31856h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f31857i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final g f31858j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final z3.f0 f31859k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final C0636h f31860l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final long f31861m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final List<o2.g> f31862n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Set<f> f31863o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Set<o2.g> f31864p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f31865q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    private g0 f31866r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    private o2.g f31867s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private o2.g f31868t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Looper f31869u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Handler f31870v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f31871w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    private byte[] f31872x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private t1 f31873y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    volatile d f31874z;

    /* JADX INFO: compiled from: DefaultDrmSessionManager.java */
    public static final class b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f31878d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f31880f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final HashMap<String, String> f31875a = new HashMap<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private UUID f31876b = k2.i.f29129d;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private g0.c f31877c = k0.f31902d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private z3.f0 f31881g = new z3.w();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int[] f31879e = new int[0];

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f31882h = 300000;

        public h a(n0 n0Var) {
            return new h(this.f31876b, this.f31877c, n0Var, this.f31875a, this.f31878d, this.f31879e, this.f31880f, this.f31881g, this.f31882h);
        }

        public b b(boolean z10) {
            this.f31878d = z10;
            return this;
        }

        public b c(boolean z10) {
            this.f31880f = z10;
            return this;
        }

        public b d(int... iArr) {
            for (int i10 : iArr) {
                boolean z10 = true;
                if (i10 != 2 && i10 != 1) {
                    z10 = false;
                }
                a4.a.a(z10);
            }
            this.f31879e = (int[]) iArr.clone();
            return this;
        }

        public b e(UUID uuid, g0.c cVar) {
            this.f31876b = (UUID) a4.a.e(uuid);
            this.f31877c = (g0.c) a4.a.e(cVar);
            return this;
        }
    }

    /* JADX INFO: compiled from: DefaultDrmSessionManager.java */
    private class c implements g0.b {
        private c() {
        }

        @Override // o2.g0.b
        public void a(g0 g0Var, @Nullable byte[] bArr, int i10, int i11, @Nullable byte[] bArr2) {
            ((d) a4.a.e(h.this.f31874z)).obtainMessage(i10, bArr).sendToTarget();
        }
    }

    /* JADX INFO: compiled from: DefaultDrmSessionManager.java */
    @SuppressLint({"HandlerLeak"})
    private class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null) {
                return;
            }
            for (o2.g gVar : h.this.f31862n) {
                if (gVar.k(bArr)) {
                    gVar.s(message.what);
                    return;
                }
            }
        }
    }

    /* JADX INFO: compiled from: DefaultDrmSessionManager.java */
    public static final class e extends Exception {
        private e(UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: DefaultDrmSessionManager.java */
    class f implements y.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private final w.a f31885b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private o f31886c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f31887d;

        public f(@Nullable w.a aVar) {
            this.f31885b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(o1 o1Var) {
            if (h.this.f31865q == 0 || this.f31887d) {
                return;
            }
            h hVar = h.this;
            this.f31886c = hVar.s((Looper) a4.a.e(hVar.f31869u), this.f31885b, o1Var, false);
            h.this.f31863o.add(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            if (this.f31887d) {
                return;
            }
            o oVar = this.f31886c;
            if (oVar != null) {
                oVar.b(this.f31885b);
            }
            h.this.f31863o.remove(this);
            this.f31887d = true;
        }

        public void c(final o1 o1Var) {
            ((Handler) a4.a.e(h.this.f31870v)).post(new Runnable() { // from class: o2.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f31897a.d(o1Var);
                }
            });
        }

        @Override // o2.y.b
        public void release() {
            a4.o0.C0((Handler) a4.a.e(h.this.f31870v), new Runnable() { // from class: o2.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f31896a.e();
                }
            });
        }
    }

    /* JADX INFO: compiled from: DefaultDrmSessionManager.java */
    private class g implements g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set<o2.g> f31889a = new HashSet();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private o2.g f31890b;

        public g(h hVar) {
        }

        @Override // o2.g.a
        public void a(o2.g gVar) {
            this.f31889a.add(gVar);
            if (this.f31890b != null) {
                return;
            }
            this.f31890b = gVar;
            gVar.y();
        }

        public void b(o2.g gVar) {
            this.f31889a.remove(gVar);
            if (this.f31890b == gVar) {
                this.f31890b = null;
                if (this.f31889a.isEmpty()) {
                    return;
                }
                o2.g next = this.f31889a.iterator().next();
                this.f31890b = next;
                next.y();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // o2.g.a
        public void onProvisionCompleted() {
            this.f31890b = null;
            com.google.common.collect.y yVarM = com.google.common.collect.y.m(this.f31889a);
            this.f31889a.clear();
            i1 it = yVarM.iterator();
            while (it.hasNext()) {
                ((o2.g) it.next()).t();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // o2.g.a
        public void onProvisionError(Exception exc, boolean z10) {
            this.f31890b = null;
            com.google.common.collect.y yVarM = com.google.common.collect.y.m(this.f31889a);
            this.f31889a.clear();
            i1 it = yVarM.iterator();
            while (it.hasNext()) {
                ((o2.g) it.next()).u(exc, z10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: o2.h$h, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DefaultDrmSessionManager.java */
    class C0636h implements g.b {
        private C0636h() {
        }

        @Override // o2.g.b
        public void a(final o2.g gVar, int i10) {
            if (i10 == 1 && h.this.f31865q > 0 && h.this.f31861m != C.TIME_UNSET) {
                h.this.f31864p.add(gVar);
                ((Handler) a4.a.e(h.this.f31870v)).postAtTime(new Runnable() { // from class: o2.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        gVar.b(null);
                    }
                }, gVar, SystemClock.uptimeMillis() + h.this.f31861m);
            } else if (i10 == 0) {
                h.this.f31862n.remove(gVar);
                if (h.this.f31867s == gVar) {
                    h.this.f31867s = null;
                }
                if (h.this.f31868t == gVar) {
                    h.this.f31868t = null;
                }
                h.this.f31858j.b(gVar);
                if (h.this.f31861m != C.TIME_UNSET) {
                    ((Handler) a4.a.e(h.this.f31870v)).removeCallbacksAndMessages(gVar);
                    h.this.f31864p.remove(gVar);
                }
            }
            h.this.B();
        }

        @Override // o2.g.b
        public void b(o2.g gVar, int i10) {
            if (h.this.f31861m != C.TIME_UNSET) {
                h.this.f31864p.remove(gVar);
                ((Handler) a4.a.e(h.this.f31870v)).removeCallbacksAndMessages(gVar);
            }
        }
    }

    private void A(Looper looper) {
        if (this.f31874z == null) {
            this.f31874z = new d(looper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (this.f31866r != null && this.f31865q == 0 && this.f31862n.isEmpty() && this.f31863o.isEmpty()) {
            ((g0) a4.a.e(this.f31866r)).release();
            this.f31866r = null;
        }
    }

    private void C() {
        i1 it = com.google.common.collect.c0.m(this.f31864p).iterator();
        while (it.hasNext()) {
            ((o) it.next()).b(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void D() {
        i1 it = com.google.common.collect.c0.m(this.f31863o).iterator();
        while (it.hasNext()) {
            ((f) it.next()).release();
        }
    }

    private void F(o oVar, @Nullable w.a aVar) {
        oVar.b(aVar);
        if (this.f31861m != C.TIME_UNSET) {
            oVar.b(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public o s(Looper looper, @Nullable w.a aVar, o1 o1Var, boolean z10) {
        List<m.b> listX;
        A(looper);
        m mVar = o1Var.f29350o;
        if (mVar == null) {
            return z(a4.x.i(o1Var.f29347l), z10);
        }
        o2.g gVarW = null;
        Object[] objArr = 0;
        if (this.f31872x == null) {
            listX = x((m) a4.a.e(mVar), this.f31851c, false);
            if (listX.isEmpty()) {
                e eVar = new e(this.f31851c);
                a4.t.d("DefaultDrmSessionMgr", "DRM error", eVar);
                if (aVar != null) {
                    aVar.l(eVar);
                }
                return new e0(new o.a(eVar, 6003));
            }
        } else {
            listX = null;
        }
        if (this.f31855g) {
            Iterator<o2.g> it = this.f31862n.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                o2.g next = it.next();
                if (a4.o0.c(next.f31814a, listX)) {
                    gVarW = next;
                    break;
                }
            }
        } else {
            gVarW = this.f31868t;
        }
        if (gVarW == null) {
            gVarW = w(listX, false, aVar, z10);
            if (!this.f31855g) {
                this.f31868t = gVarW;
            }
            this.f31862n.add(gVarW);
        } else {
            gVarW.a(aVar);
        }
        return gVarW;
    }

    private static boolean t(o oVar) {
        return oVar.getState() == 1 && (a4.o0.f214a < 19 || (((o.a) a4.a.e(oVar.getError())).getCause() instanceof ResourceBusyException));
    }

    private boolean u(m mVar) {
        if (this.f31872x != null) {
            return true;
        }
        if (x(mVar, this.f31851c, true).isEmpty()) {
            if (mVar.f31918d != 1 || !mVar.c(0).b(k2.i.f29127b)) {
                return false;
            }
            a4.t.i("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.f31851c);
        }
        String str = mVar.f31917c;
        if (str == null || C.CENC_TYPE_cenc.equals(str)) {
            return true;
        }
        return C.CENC_TYPE_cbcs.equals(str) ? a4.o0.f214a >= 25 : (C.CENC_TYPE_cbc1.equals(str) || C.CENC_TYPE_cens.equals(str)) ? false : true;
    }

    private o2.g v(@Nullable List<m.b> list, boolean z10, @Nullable w.a aVar) {
        a4.a.e(this.f31866r);
        o2.g gVar = new o2.g(this.f31851c, this.f31866r, this.f31858j, this.f31860l, list, this.f31871w, this.f31857i | z10, z10, this.f31872x, this.f31854f, this.f31853e, (Looper) a4.a.e(this.f31869u), this.f31859k, (t1) a4.a.e(this.f31873y));
        gVar.a(aVar);
        if (this.f31861m != C.TIME_UNSET) {
            gVar.a(null);
        }
        return gVar;
    }

    private o2.g w(@Nullable List<m.b> list, boolean z10, @Nullable w.a aVar, boolean z11) {
        o2.g gVarV = v(list, z10, aVar);
        if (t(gVarV) && !this.f31864p.isEmpty()) {
            C();
            F(gVarV, aVar);
            gVarV = v(list, z10, aVar);
        }
        if (!t(gVarV) || !z11 || this.f31863o.isEmpty()) {
            return gVarV;
        }
        D();
        if (!this.f31864p.isEmpty()) {
            C();
        }
        F(gVarV, aVar);
        return v(list, z10, aVar);
    }

    private static List<m.b> x(m mVar, UUID uuid, boolean z10) {
        ArrayList arrayList = new ArrayList(mVar.f31918d);
        for (int i10 = 0; i10 < mVar.f31918d; i10++) {
            m.b bVarC = mVar.c(i10);
            if ((bVarC.b(uuid) || (k2.i.f29128c.equals(uuid) && bVarC.b(k2.i.f29127b))) && (bVarC.f31923e != null || z10)) {
                arrayList.add(bVarC);
            }
        }
        return arrayList;
    }

    private synchronized void y(Looper looper) {
        Looper looper2 = this.f31869u;
        if (looper2 == null) {
            this.f31869u = looper;
            this.f31870v = new Handler(looper);
        } else {
            a4.a.g(looper2 == looper);
            a4.a.e(this.f31870v);
        }
    }

    @Nullable
    private o z(int i10, boolean z10) {
        g0 g0Var = (g0) a4.a.e(this.f31866r);
        if ((g0Var.getCryptoType() == 2 && h0.f31892d) || a4.o0.t0(this.f31856h, i10) == -1 || g0Var.getCryptoType() == 1) {
            return null;
        }
        o2.g gVar = this.f31867s;
        if (gVar == null) {
            o2.g gVarW = w(com.google.common.collect.y.q(), true, null, z10);
            this.f31862n.add(gVarW);
            this.f31867s = gVarW;
        } else {
            gVar.a(null);
        }
        return this.f31867s;
    }

    public void E(int i10, @Nullable byte[] bArr) {
        a4.a.g(this.f31862n.isEmpty());
        if (i10 == 1 || i10 == 3) {
            a4.a.e(bArr);
        }
        this.f31871w = i10;
        this.f31872x = bArr;
    }

    @Override // o2.y
    @Nullable
    public o a(@Nullable w.a aVar, o1 o1Var) {
        a4.a.g(this.f31865q > 0);
        a4.a.i(this.f31869u);
        return s(this.f31869u, aVar, o1Var, true);
    }

    @Override // o2.y
    public int b(o1 o1Var) {
        int cryptoType = ((g0) a4.a.e(this.f31866r)).getCryptoType();
        m mVar = o1Var.f29350o;
        if (mVar != null) {
            if (u(mVar)) {
                return cryptoType;
            }
            return 1;
        }
        if (a4.o0.t0(this.f31856h, a4.x.i(o1Var.f29347l)) != -1) {
            return cryptoType;
        }
        return 0;
    }

    @Override // o2.y
    public void c(Looper looper, t1 t1Var) {
        y(looper);
        this.f31873y = t1Var;
    }

    @Override // o2.y
    public y.b d(@Nullable w.a aVar, o1 o1Var) {
        a4.a.g(this.f31865q > 0);
        a4.a.i(this.f31869u);
        f fVar = new f(aVar);
        fVar.c(o1Var);
        return fVar;
    }

    @Override // o2.y
    public final void prepare() {
        int i10 = this.f31865q;
        this.f31865q = i10 + 1;
        if (i10 != 0) {
            return;
        }
        if (this.f31866r == null) {
            g0 g0VarAcquireExoMediaDrm = this.f31852d.acquireExoMediaDrm(this.f31851c);
            this.f31866r = g0VarAcquireExoMediaDrm;
            g0VarAcquireExoMediaDrm.a(new c());
        } else if (this.f31861m != C.TIME_UNSET) {
            for (int i11 = 0; i11 < this.f31862n.size(); i11++) {
                this.f31862n.get(i11).a(null);
            }
        }
    }

    @Override // o2.y
    public final void release() {
        int i10 = this.f31865q - 1;
        this.f31865q = i10;
        if (i10 != 0) {
            return;
        }
        if (this.f31861m != C.TIME_UNSET) {
            ArrayList arrayList = new ArrayList(this.f31862n);
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                ((o2.g) arrayList.get(i11)).b(null);
            }
        }
        D();
        B();
    }

    private h(UUID uuid, g0.c cVar, n0 n0Var, HashMap<String, String> map, boolean z10, int[] iArr, boolean z11, z3.f0 f0Var, long j10) {
        a4.a.e(uuid);
        a4.a.b(!k2.i.f29127b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f31851c = uuid;
        this.f31852d = cVar;
        this.f31853e = n0Var;
        this.f31854f = map;
        this.f31855g = z10;
        this.f31856h = iArr;
        this.f31857i = z11;
        this.f31859k = f0Var;
        this.f31858j = new g(this);
        this.f31860l = new C0636h();
        this.f31871w = 0;
        this.f31862n = new ArrayList();
        this.f31863o = c1.h();
        this.f31864p = c1.h();
        this.f31861m = j10;
    }
}
