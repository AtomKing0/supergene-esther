package o2;

import android.annotation.SuppressLint;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.C;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import l2.t1;
import o2.g0;
import o2.m;
import o2.o;
import o2.w;
import z3.f0;

/* JADX INFO: compiled from: DefaultDrmSession.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(18)
class g implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final List<m.b> f31814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g0 f31815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f31816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f31817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f31818e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f31819f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f31820g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final HashMap<String, String> f31821h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final a4.i<w.a> f31822i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final z3.f0 f31823j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final t1 f31824k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final n0 f31825l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final UUID f31826m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final e f31827n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f31828o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f31829p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private HandlerThread f31830q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    private c f31831r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    private n2.b f31832s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private o.a f31833t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private byte[] f31834u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private byte[] f31835v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    private g0.a f31836w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    private g0.d f31837x;

    /* JADX INFO: compiled from: DefaultDrmSession.java */
    public interface a {
        void a(g gVar);

        void onProvisionCompleted();

        void onProvisionError(Exception exc, boolean z10);
    }

    /* JADX INFO: compiled from: DefaultDrmSession.java */
    public interface b {
        void a(g gVar, int i10);

        void b(g gVar, int i10);
    }

    /* JADX INFO: compiled from: DefaultDrmSession.java */
    @SuppressLint({"HandlerLeak"})
    private class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @GuardedBy("this")
        private boolean f31838a;

        public c(Looper looper) {
            super(looper);
        }

        private boolean a(Message message, o0 o0Var) {
            d dVar = (d) message.obj;
            if (!dVar.f31841b) {
                return false;
            }
            int i10 = dVar.f31844e + 1;
            dVar.f31844e = i10;
            if (i10 > g.this.f31823j.getMinimumLoadableRetryCount(3)) {
                return false;
            }
            long jA = g.this.f31823j.a(new f0.a(new l3.t(dVar.f31840a, o0Var.f31925a, o0Var.f31926b, o0Var.f31927c, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - dVar.f31842c, o0Var.f31928d), new l3.w(3), o0Var.getCause() instanceof IOException ? (IOException) o0Var.getCause() : new f(o0Var.getCause()), dVar.f31844e));
            if (jA == C.TIME_UNSET) {
                return false;
            }
            synchronized (this) {
                if (this.f31838a) {
                    return false;
                }
                sendMessageDelayed(Message.obtain(message), jA);
                return true;
            }
        }

        void b(int i10, Object obj, boolean z10) {
            obtainMessage(i10, new d(l3.t.a(), z10, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        public synchronized void c() {
            removeCallbacksAndMessages(null);
            this.f31838a = true;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object objA;
            d dVar = (d) message.obj;
            try {
                int i10 = message.what;
                if (i10 == 0) {
                    g gVar = g.this;
                    objA = gVar.f31825l.a(gVar.f31826m, (g0.d) dVar.f31843d);
                } else {
                    if (i10 != 1) {
                        throw new RuntimeException();
                    }
                    g gVar2 = g.this;
                    objA = gVar2.f31825l.b(gVar2.f31826m, (g0.a) dVar.f31843d);
                }
            } catch (o0 e10) {
                boolean zA = a(message, e10);
                objA = e10;
                if (zA) {
                    return;
                }
            } catch (Exception e11) {
                a4.t.j("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", e11);
                objA = e11;
            }
            g.this.f31823j.onLoadTaskConcluded(dVar.f31840a);
            synchronized (this) {
                if (!this.f31838a) {
                    g.this.f31827n.obtainMessage(message.what, Pair.create(dVar.f31843d, objA)).sendToTarget();
                }
            }
        }
    }

    /* JADX INFO: compiled from: DefaultDrmSession.java */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f31840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f31841b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f31842c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f31843d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f31844e;

        public d(long j10, boolean z10, long j11, Object obj) {
            this.f31840a = j10;
            this.f31841b = z10;
            this.f31842c = j11;
            this.f31843d = obj;
        }
    }

    /* JADX INFO: compiled from: DefaultDrmSession.java */
    @SuppressLint({"HandlerLeak"})
    private class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i10 = message.what;
            if (i10 == 0) {
                g.this.v(obj, obj2);
            } else {
                if (i10 != 1) {
                    return;
                }
                g.this.p(obj, obj2);
            }
        }
    }

    /* JADX INFO: compiled from: DefaultDrmSession.java */
    public static final class f extends IOException {
        public f(@Nullable Throwable th) {
            super(th);
        }
    }

    public g(UUID uuid, g0 g0Var, a aVar, b bVar, @Nullable List<m.b> list, int i10, boolean z10, boolean z11, @Nullable byte[] bArr, HashMap<String, String> map, n0 n0Var, Looper looper, z3.f0 f0Var, t1 t1Var) {
        if (i10 == 1 || i10 == 3) {
            a4.a.e(bArr);
        }
        this.f31826m = uuid;
        this.f31816c = aVar;
        this.f31817d = bVar;
        this.f31815b = g0Var;
        this.f31818e = i10;
        this.f31819f = z10;
        this.f31820g = z11;
        if (bArr != null) {
            this.f31835v = bArr;
            this.f31814a = null;
        } else {
            this.f31814a = Collections.unmodifiableList((List) a4.a.e(list));
        }
        this.f31821h = map;
        this.f31825l = n0Var;
        this.f31822i = new a4.i<>();
        this.f31823j = f0Var;
        this.f31824k = t1Var;
        this.f31828o = 2;
        this.f31827n = new e(looper);
    }

    private void h(a4.h<w.a> hVar) {
        Iterator<w.a> it = this.f31822i.elementSet().iterator();
        while (it.hasNext()) {
            hVar.accept(it.next());
        }
    }

    private void i(boolean z10) {
        if (this.f31820g) {
            return;
        }
        byte[] bArr = (byte[]) a4.o0.j(this.f31834u);
        int i10 = this.f31818e;
        if (i10 != 0 && i10 != 1) {
            if (i10 == 2) {
                if (this.f31835v == null || z()) {
                    x(bArr, 2, z10);
                    return;
                }
                return;
            }
            if (i10 != 3) {
                return;
            }
            a4.a.e(this.f31835v);
            a4.a.e(this.f31834u);
            x(this.f31835v, 3, z10);
            return;
        }
        if (this.f31835v == null) {
            x(bArr, 1, z10);
            return;
        }
        if (this.f31828o == 4 || z()) {
            long j10 = j();
            if (this.f31818e != 0 || j10 > 60) {
                if (j10 <= 0) {
                    o(new m0(), 2);
                    return;
                } else {
                    this.f31828o = 4;
                    h(new a4.h() { // from class: o2.f
                        @Override // a4.h
                        public final void accept(Object obj) {
                            ((w.a) obj).j();
                        }
                    });
                    return;
                }
            }
            a4.t.b("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + j10);
            x(bArr, 2, z10);
        }
    }

    private long j() {
        if (!k2.i.f29129d.equals(this.f31826m)) {
            return Long.MAX_VALUE;
        }
        Pair pair = (Pair) a4.a.e(q0.b(this));
        return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
    }

    private boolean l() {
        int i10 = this.f31828o;
        return i10 == 3 || i10 == 4;
    }

    private void o(final Exception exc, int i10) {
        this.f31833t = new o.a(exc, c0.a(exc, i10));
        a4.t.d("DefaultDrmSession", "DRM session error", exc);
        h(new a4.h() { // from class: o2.e
            @Override // a4.h
            public final void accept(Object obj) {
                ((w.a) obj).l(exc);
            }
        });
        if (this.f31828o != 4) {
            this.f31828o = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(Object obj, Object obj2) {
        if (obj == this.f31836w && l()) {
            this.f31836w = null;
            if (obj2 instanceof Exception) {
                q((Exception) obj2, false);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.f31818e == 3) {
                    this.f31815b.provideKeyResponse((byte[]) a4.o0.j(this.f31835v), bArr);
                    h(new a4.h() { // from class: o2.b
                        @Override // a4.h
                        public final void accept(Object obj3) {
                            ((w.a) obj3).i();
                        }
                    });
                    return;
                }
                byte[] bArrProvideKeyResponse = this.f31815b.provideKeyResponse(this.f31834u, bArr);
                int i10 = this.f31818e;
                if ((i10 == 2 || (i10 == 0 && this.f31835v != null)) && bArrProvideKeyResponse != null && bArrProvideKeyResponse.length != 0) {
                    this.f31835v = bArrProvideKeyResponse;
                }
                this.f31828o = 4;
                h(new a4.h() { // from class: o2.c
                    @Override // a4.h
                    public final void accept(Object obj3) {
                        ((w.a) obj3).h();
                    }
                });
            } catch (Exception e10) {
                q(e10, true);
            }
        }
    }

    private void q(Exception exc, boolean z10) {
        if (exc instanceof NotProvisionedException) {
            this.f31816c.a(this);
        } else {
            o(exc, z10 ? 1 : 2);
        }
    }

    private void r() {
        if (this.f31818e == 0 && this.f31828o == 4) {
            a4.o0.j(this.f31834u);
            i(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(Object obj, Object obj2) {
        if (obj == this.f31837x) {
            if (this.f31828o == 2 || l()) {
                this.f31837x = null;
                if (obj2 instanceof Exception) {
                    this.f31816c.onProvisionError((Exception) obj2, false);
                    return;
                }
                try {
                    this.f31815b.provideProvisionResponse((byte[]) obj2);
                    this.f31816c.onProvisionCompleted();
                } catch (Exception e10) {
                    this.f31816c.onProvisionError(e10, true);
                }
            }
        }
    }

    private boolean w() {
        if (l()) {
            return true;
        }
        try {
            byte[] bArrOpenSession = this.f31815b.openSession();
            this.f31834u = bArrOpenSession;
            this.f31815b.b(bArrOpenSession, this.f31824k);
            this.f31832s = this.f31815b.createCryptoConfig(this.f31834u);
            final int i10 = 3;
            this.f31828o = 3;
            h(new a4.h() { // from class: o2.d
                @Override // a4.h
                public final void accept(Object obj) {
                    ((w.a) obj).k(i10);
                }
            });
            a4.a.e(this.f31834u);
            return true;
        } catch (NotProvisionedException unused) {
            this.f31816c.a(this);
            return false;
        } catch (Exception e10) {
            o(e10, 1);
            return false;
        }
    }

    private void x(byte[] bArr, int i10, boolean z10) {
        try {
            this.f31836w = this.f31815b.getKeyRequest(bArr, this.f31814a, i10, this.f31821h);
            ((c) a4.o0.j(this.f31831r)).b(1, a4.a.e(this.f31836w), z10);
        } catch (Exception e10) {
            q(e10, true);
        }
    }

    private boolean z() {
        try {
            this.f31815b.restoreKeys(this.f31834u, this.f31835v);
            return true;
        } catch (Exception e10) {
            o(e10, 1);
            return false;
        }
    }

    @Override // o2.o
    public void a(@Nullable w.a aVar) {
        if (this.f31829p < 0) {
            a4.t.c("DefaultDrmSession", "Session reference count less than zero: " + this.f31829p);
            this.f31829p = 0;
        }
        if (aVar != null) {
            this.f31822i.a(aVar);
        }
        int i10 = this.f31829p + 1;
        this.f31829p = i10;
        if (i10 == 1) {
            a4.a.g(this.f31828o == 2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.f31830q = handlerThread;
            handlerThread.start();
            this.f31831r = new c(this.f31830q.getLooper());
            if (w()) {
                i(true);
            }
        } else if (aVar != null && l() && this.f31822i.b(aVar) == 1) {
            aVar.k(this.f31828o);
        }
        this.f31817d.b(this, this.f31829p);
    }

    @Override // o2.o
    public void b(@Nullable w.a aVar) {
        int i10 = this.f31829p;
        if (i10 <= 0) {
            a4.t.c("DefaultDrmSession", "release() called on a session that's already fully released.");
            return;
        }
        int i11 = i10 - 1;
        this.f31829p = i11;
        if (i11 == 0) {
            this.f31828o = 0;
            ((e) a4.o0.j(this.f31827n)).removeCallbacksAndMessages(null);
            ((c) a4.o0.j(this.f31831r)).c();
            this.f31831r = null;
            ((HandlerThread) a4.o0.j(this.f31830q)).quit();
            this.f31830q = null;
            this.f31832s = null;
            this.f31833t = null;
            this.f31836w = null;
            this.f31837x = null;
            byte[] bArr = this.f31834u;
            if (bArr != null) {
                this.f31815b.closeSession(bArr);
                this.f31834u = null;
            }
        }
        if (aVar != null) {
            this.f31822i.d(aVar);
            if (this.f31822i.b(aVar) == 0) {
                aVar.m();
            }
        }
        this.f31817d.a(this, this.f31829p);
    }

    @Override // o2.o
    @Nullable
    public final n2.b getCryptoConfig() {
        return this.f31832s;
    }

    @Override // o2.o
    @Nullable
    public final o.a getError() {
        if (this.f31828o == 1) {
            return this.f31833t;
        }
        return null;
    }

    @Override // o2.o
    public final UUID getSchemeUuid() {
        return this.f31826m;
    }

    @Override // o2.o
    public final int getState() {
        return this.f31828o;
    }

    public boolean k(byte[] bArr) {
        return Arrays.equals(this.f31834u, bArr);
    }

    @Override // o2.o
    public boolean playClearSamplesWithoutKeys() {
        return this.f31819f;
    }

    @Override // o2.o
    @Nullable
    public Map<String, String> queryKeyStatus() {
        byte[] bArr = this.f31834u;
        if (bArr == null) {
            return null;
        }
        return this.f31815b.queryKeyStatus(bArr);
    }

    @Override // o2.o
    public boolean requiresSecureDecoder(String str) {
        return this.f31815b.requiresSecureDecoder((byte[]) a4.a.i(this.f31834u), str);
    }

    public void s(int i10) {
        if (i10 != 2) {
            return;
        }
        r();
    }

    public void t() {
        if (w()) {
            i(true);
        }
    }

    public void u(Exception exc, boolean z10) {
        o(exc, z10 ? 1 : 3);
    }

    public void y() {
        this.f31837x = this.f31815b.getProvisionRequest();
        ((c) a4.o0.j(this.f31831r)).b(0, a4.a.e(this.f31837x), true);
    }
}
