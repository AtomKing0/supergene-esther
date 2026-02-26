package oa;

import io.sentry.protocol.TransactionInfo;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import oa.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Http2Connection.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class f implements Closeable {

    @NotNull
    public static final b C = new b(null);

    @NotNull
    private static final m D;

    @NotNull
    private final d A;

    @NotNull
    private final Set<Integer> B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f32139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final c f32140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final Map<Integer, oa.i> f32141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final String f32142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f32143e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f32144f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f32145g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final ka.e f32146h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private final ka.d f32147i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private final ka.d f32148j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private final ka.d f32149k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private final oa.l f32150l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f32151m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f32152n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f32153o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f32154p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f32155q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f32156r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NotNull
    private final m f32157s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NotNull
    private m f32158t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f32159u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f32160v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f32161w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f32162x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NotNull
    private final Socket f32163y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @NotNull
    private final oa.j f32164z;

    /* JADX INFO: compiled from: Http2Connection.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f32165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final ka.e f32166b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Socket f32167c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f32168d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ua.e f32169e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ua.d f32170f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @NotNull
        private c f32171g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @NotNull
        private oa.l f32172h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f32173i;

        public a(boolean z10, @NotNull ka.e taskRunner) {
            t.i(taskRunner, "taskRunner");
            this.f32165a = z10;
            this.f32166b = taskRunner;
            this.f32171g = c.f32175b;
            this.f32172h = oa.l.f32300b;
        }

        @NotNull
        public final f a() {
            return new f(this);
        }

        public final boolean b() {
            return this.f32165a;
        }

        @NotNull
        public final String c() {
            String str = this.f32168d;
            if (str != null) {
                return str;
            }
            t.A("connectionName");
            return null;
        }

        @NotNull
        public final c d() {
            return this.f32171g;
        }

        public final int e() {
            return this.f32173i;
        }

        @NotNull
        public final oa.l f() {
            return this.f32172h;
        }

        @NotNull
        public final ua.d g() {
            ua.d dVar = this.f32170f;
            if (dVar != null) {
                return dVar;
            }
            t.A("sink");
            return null;
        }

        @NotNull
        public final Socket h() {
            Socket socket = this.f32167c;
            if (socket != null) {
                return socket;
            }
            t.A("socket");
            return null;
        }

        @NotNull
        public final ua.e i() {
            ua.e eVar = this.f32169e;
            if (eVar != null) {
                return eVar;
            }
            t.A(TransactionInfo.JsonKeys.SOURCE);
            return null;
        }

        @NotNull
        public final ka.e j() {
            return this.f32166b;
        }

        @NotNull
        public final a k(@NotNull c listener) {
            t.i(listener, "listener");
            n(listener);
            return this;
        }

        @NotNull
        public final a l(int i10) {
            o(i10);
            return this;
        }

        public final void m(@NotNull String str) {
            t.i(str, "<set-?>");
            this.f32168d = str;
        }

        public final void n(@NotNull c cVar) {
            t.i(cVar, "<set-?>");
            this.f32171g = cVar;
        }

        public final void o(int i10) {
            this.f32173i = i10;
        }

        public final void p(@NotNull ua.d dVar) {
            t.i(dVar, "<set-?>");
            this.f32170f = dVar;
        }

        public final void q(@NotNull Socket socket) {
            t.i(socket, "<set-?>");
            this.f32167c = socket;
        }

        public final void r(@NotNull ua.e eVar) {
            t.i(eVar, "<set-?>");
            this.f32169e = eVar;
        }

        @NotNull
        public final a s(@NotNull Socket socket, @NotNull String peerName, @NotNull ua.e source, @NotNull ua.d sink) throws IOException {
            String strR;
            t.i(socket, "socket");
            t.i(peerName, "peerName");
            t.i(source, "source");
            t.i(sink, "sink");
            q(socket);
            if (b()) {
                strR = ha.d.f26516i + ' ' + peerName;
            } else {
                strR = t.r("MockWebServer ", peerName);
            }
            m(strR);
            r(source);
            p(sink);
            return this;
        }
    }

    /* JADX INFO: compiled from: Http2Connection.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final m a() {
            return f.D;
        }
    }

    /* JADX INFO: compiled from: Http2Connection.kt */
    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f32174a = new b(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public static final c f32175b = new a();

        /* JADX INFO: compiled from: Http2Connection.kt */
        public static final class a extends c {
            a() {
            }

            @Override // oa.f.c
            public void b(@NotNull oa.i stream) throws IOException {
                t.i(stream, "stream");
                stream.d(oa.b.REFUSED_STREAM, null);
            }
        }

        /* JADX INFO: compiled from: Http2Connection.kt */
        public static final class b {
            private b() {
            }

            public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
                this();
            }
        }

        public void a(@NotNull f connection, @NotNull m settings) {
            t.i(connection, "connection");
            t.i(settings, "settings");
        }

        public abstract void b(@NotNull oa.i iVar) throws IOException;
    }

    /* JADX INFO: compiled from: TaskQueue.kt */
    public static final class e extends ka.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f32196e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f32197f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f32198g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f32199h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ ua.c f32200i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f32201j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ boolean f32202k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, boolean z10, f fVar, int i10, ua.c cVar, int i11, boolean z11) {
            super(str, z10);
            this.f32196e = str;
            this.f32197f = z10;
            this.f32198g = fVar;
            this.f32199h = i10;
            this.f32200i = cVar;
            this.f32201j = i11;
            this.f32202k = z11;
        }

        @Override // ka.a
        public long f() {
            try {
                boolean zA = this.f32198g.f32150l.a(this.f32199h, this.f32200i, this.f32201j, this.f32202k);
                if (zA) {
                    this.f32198g.X0().O(this.f32199h, oa.b.CANCEL);
                }
                if (!zA && !this.f32202k) {
                    return -1L;
                }
                synchronized (this.f32198g) {
                    this.f32198g.B.remove(Integer.valueOf(this.f32199h));
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    /* JADX INFO: renamed from: oa.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TaskQueue.kt */
    public static final class C0644f extends ka.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f32203e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f32204f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f32205g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f32206h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ List f32207i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ boolean f32208j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0644f(String str, boolean z10, f fVar, int i10, List list, boolean z11) {
            super(str, z10);
            this.f32203e = str;
            this.f32204f = z10;
            this.f32205g = fVar;
            this.f32206h = i10;
            this.f32207i = list;
            this.f32208j = z11;
        }

        @Override // ka.a
        public long f() {
            boolean zD = this.f32205g.f32150l.d(this.f32206h, this.f32207i, this.f32208j);
            if (zD) {
                try {
                    this.f32205g.X0().O(this.f32206h, oa.b.CANCEL);
                } catch (IOException unused) {
                    return -1L;
                }
            }
            if (!zD && !this.f32208j) {
                return -1L;
            }
            synchronized (this.f32205g) {
                this.f32205g.B.remove(Integer.valueOf(this.f32206h));
            }
            return -1L;
        }
    }

    /* JADX INFO: compiled from: TaskQueue.kt */
    public static final class g extends ka.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f32209e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f32210f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f32211g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f32212h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ List f32213i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, boolean z10, f fVar, int i10, List list) {
            super(str, z10);
            this.f32209e = str;
            this.f32210f = z10;
            this.f32211g = fVar;
            this.f32212h = i10;
            this.f32213i = list;
        }

        @Override // ka.a
        public long f() {
            if (!this.f32211g.f32150l.c(this.f32212h, this.f32213i)) {
                return -1L;
            }
            try {
                this.f32211g.X0().O(this.f32212h, oa.b.CANCEL);
                synchronized (this.f32211g) {
                    this.f32211g.B.remove(Integer.valueOf(this.f32212h));
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    /* JADX INFO: compiled from: TaskQueue.kt */
    public static final class h extends ka.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f32214e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f32215f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f32216g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f32217h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ oa.b f32218i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, boolean z10, f fVar, int i10, oa.b bVar) {
            super(str, z10);
            this.f32214e = str;
            this.f32215f = z10;
            this.f32216g = fVar;
            this.f32217h = i10;
            this.f32218i = bVar;
        }

        @Override // ka.a
        public long f() {
            this.f32216g.f32150l.b(this.f32217h, this.f32218i);
            synchronized (this.f32216g) {
                this.f32216g.B.remove(Integer.valueOf(this.f32217h));
                k0 k0Var = k0.f35197a;
            }
            return -1L;
        }
    }

    /* JADX INFO: compiled from: TaskQueue.kt */
    public static final class i extends ka.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f32219e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f32220f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f32221g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(String str, boolean z10, f fVar) {
            super(str, z10);
            this.f32219e = str;
            this.f32220f = z10;
            this.f32221g = fVar;
        }

        @Override // ka.a
        public long f() {
            this.f32221g.r1(false, 2, 0);
            return -1L;
        }
    }

    /* JADX INFO: compiled from: TaskQueue.kt */
    public static final class j extends ka.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f32222e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f f32223f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f32224g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(String str, f fVar, long j10) {
            super(str, false, 2, null);
            this.f32222e = str;
            this.f32223f = fVar;
            this.f32224g = j10;
        }

        @Override // ka.a
        public long f() {
            boolean z10;
            synchronized (this.f32223f) {
                if (this.f32223f.f32152n < this.f32223f.f32151m) {
                    z10 = true;
                } else {
                    this.f32223f.f32151m++;
                    z10 = false;
                }
            }
            if (z10) {
                this.f32223f.K0(null);
                return -1L;
            }
            this.f32223f.r1(false, 1, 0);
            return this.f32224g;
        }
    }

    /* JADX INFO: compiled from: TaskQueue.kt */
    public static final class k extends ka.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f32225e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f32226f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f32227g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f32228h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ oa.b f32229i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(String str, boolean z10, f fVar, int i10, oa.b bVar) {
            super(str, z10);
            this.f32225e = str;
            this.f32226f = z10;
            this.f32227g = fVar;
            this.f32228h = i10;
            this.f32229i = bVar;
        }

        @Override // ka.a
        public long f() {
            try {
                this.f32227g.s1(this.f32228h, this.f32229i);
                return -1L;
            } catch (IOException e10) {
                this.f32227g.K0(e10);
                return -1L;
            }
        }
    }

    /* JADX INFO: compiled from: TaskQueue.kt */
    public static final class l extends ka.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f32230e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f32231f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f32232g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f32233h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f32234i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(String str, boolean z10, f fVar, int i10, long j10) {
            super(str, z10);
            this.f32230e = str;
            this.f32231f = z10;
            this.f32232g = fVar;
            this.f32233h = i10;
            this.f32234i = j10;
        }

        @Override // ka.a
        public long f() {
            try {
                this.f32232g.X0().S(this.f32233h, this.f32234i);
                return -1L;
            } catch (IOException e10) {
                this.f32232g.K0(e10);
                return -1L;
            }
        }
    }

    static {
        m mVar = new m();
        mVar.h(7, 65535);
        mVar.h(5, 16384);
        D = mVar;
    }

    public f(@NotNull a builder) {
        t.i(builder, "builder");
        boolean zB = builder.b();
        this.f32139a = zB;
        this.f32140b = builder.d();
        this.f32141c = new LinkedHashMap();
        String strC = builder.c();
        this.f32142d = strC;
        this.f32144f = builder.b() ? 3 : 2;
        ka.e eVarJ = builder.j();
        this.f32146h = eVarJ;
        ka.d dVarI = eVarJ.i();
        this.f32147i = dVarI;
        this.f32148j = eVarJ.i();
        this.f32149k = eVarJ.i();
        this.f32150l = builder.f();
        m mVar = new m();
        if (builder.b()) {
            mVar.h(7, 16777216);
        }
        this.f32157s = mVar;
        this.f32158t = D;
        this.f32162x = r2.c();
        this.f32163y = builder.h();
        this.f32164z = new oa.j(builder.g(), zB);
        this.A = new d(this, new oa.h(builder.i(), zB));
        this.B = new LinkedHashSet();
        if (builder.e() != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(builder.e());
            dVarI.i(new j(t.r(strC, " ping"), this, nanos), nanos);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K0(IOException iOException) {
        oa.b bVar = oa.b.PROTOCOL_ERROR;
        J0(bVar, bVar, iOException);
    }

    private final oa.i Z0(int i10, List<oa.c> list, boolean z10) throws IOException {
        int iP0;
        oa.i iVar;
        boolean z11;
        boolean z12 = !z10;
        synchronized (this.f32164z) {
            synchronized (this) {
                if (P0() > 1073741823) {
                    l1(oa.b.REFUSED_STREAM);
                }
                if (this.f32145g) {
                    throw new oa.a();
                }
                iP0 = P0();
                j1(P0() + 2);
                iVar = new oa.i(iP0, this, z12, false, null);
                z11 = !z10 || W0() >= V0() || iVar.r() >= iVar.q();
                if (iVar.u()) {
                    U0().put(Integer.valueOf(iP0), iVar);
                }
                k0 k0Var = k0.f35197a;
            }
            if (i10 == 0) {
                X0().z(z12, iP0, list);
            } else {
                if (!(true ^ L0())) {
                    throw new IllegalArgumentException("client streams shouldn't have associated stream IDs".toString());
                }
                X0().L(i10, iP0, list);
            }
        }
        if (z11) {
            this.f32164z.flush();
        }
        return iVar;
    }

    public static /* synthetic */ void n1(f fVar, boolean z10, ka.e eVar, int i10, Object obj) throws IOException {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            eVar = ka.e.f29730i;
        }
        fVar.m1(z10, eVar);
    }

    public final void J0(@NotNull oa.b connectionCode, @NotNull oa.b streamCode, @Nullable IOException iOException) {
        int i10;
        Object[] array;
        t.i(connectionCode, "connectionCode");
        t.i(streamCode, "streamCode");
        if (ha.d.f26515h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        try {
            l1(connectionCode);
        } catch (IOException unused) {
        }
        synchronized (this) {
            if (!U0().isEmpty()) {
                array = U0().values().toArray(new oa.i[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
                U0().clear();
            } else {
                array = null;
            }
            k0 k0Var = k0.f35197a;
        }
        oa.i[] iVarArr = (oa.i[]) array;
        if (iVarArr != null) {
            for (oa.i iVar : iVarArr) {
                try {
                    iVar.d(streamCode, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            X0().close();
        } catch (IOException unused3) {
        }
        try {
            S0().close();
        } catch (IOException unused4) {
        }
        this.f32147i.o();
        this.f32148j.o();
        this.f32149k.o();
    }

    public final boolean L0() {
        return this.f32139a;
    }

    @NotNull
    public final String M0() {
        return this.f32142d;
    }

    public final int N0() {
        return this.f32143e;
    }

    @NotNull
    public final c O0() {
        return this.f32140b;
    }

    public final int P0() {
        return this.f32144f;
    }

    @NotNull
    public final m Q0() {
        return this.f32157s;
    }

    @NotNull
    public final m R0() {
        return this.f32158t;
    }

    @NotNull
    public final Socket S0() {
        return this.f32163y;
    }

    @Nullable
    public final synchronized oa.i T0(int i10) {
        return this.f32141c.get(Integer.valueOf(i10));
    }

    @NotNull
    public final Map<Integer, oa.i> U0() {
        return this.f32141c;
    }

    public final long V0() {
        return this.f32162x;
    }

    public final long W0() {
        return this.f32161w;
    }

    @NotNull
    public final oa.j X0() {
        return this.f32164z;
    }

    public final synchronized boolean Y0(long j10) {
        if (this.f32145g) {
            return false;
        }
        if (this.f32154p < this.f32153o) {
            if (j10 >= this.f32156r) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public final oa.i a1(@NotNull List<oa.c> requestHeaders, boolean z10) throws IOException {
        t.i(requestHeaders, "requestHeaders");
        return Z0(0, requestHeaders, z10);
    }

    public final void b1(int i10, @NotNull ua.e source, int i11, boolean z10) throws IOException {
        t.i(source, "source");
        ua.c cVar = new ua.c();
        long j10 = i11;
        source.a0(j10);
        source.read(cVar, j10);
        this.f32148j.i(new e(this.f32142d + '[' + i10 + "] onData", true, this, i10, cVar, i11, z10), 0L);
    }

    public final void c1(int i10, @NotNull List<oa.c> requestHeaders, boolean z10) {
        t.i(requestHeaders, "requestHeaders");
        this.f32148j.i(new C0644f(this.f32142d + '[' + i10 + "] onHeaders", true, this, i10, requestHeaders, z10), 0L);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        J0(oa.b.NO_ERROR, oa.b.CANCEL, null);
    }

    public final void d1(int i10, @NotNull List<oa.c> requestHeaders) {
        t.i(requestHeaders, "requestHeaders");
        synchronized (this) {
            if (this.B.contains(Integer.valueOf(i10))) {
                t1(i10, oa.b.PROTOCOL_ERROR);
                return;
            }
            this.B.add(Integer.valueOf(i10));
            this.f32148j.i(new g(this.f32142d + '[' + i10 + "] onRequest", true, this, i10, requestHeaders), 0L);
        }
    }

    public final void e1(int i10, @NotNull oa.b errorCode) {
        t.i(errorCode, "errorCode");
        this.f32148j.i(new h(this.f32142d + '[' + i10 + "] onReset", true, this, i10, errorCode), 0L);
    }

    public final boolean f1(int i10) {
        return i10 != 0 && (i10 & 1) == 0;
    }

    public final void flush() throws IOException {
        this.f32164z.flush();
    }

    @Nullable
    public final synchronized oa.i g1(int i10) {
        oa.i iVarRemove;
        iVarRemove = this.f32141c.remove(Integer.valueOf(i10));
        notifyAll();
        return iVarRemove;
    }

    public final void h1() {
        synchronized (this) {
            long j10 = this.f32154p;
            long j11 = this.f32153o;
            if (j10 < j11) {
                return;
            }
            this.f32153o = j11 + 1;
            this.f32156r = System.nanoTime() + ((long) 1000000000);
            k0 k0Var = k0.f35197a;
            this.f32147i.i(new i(t.r(this.f32142d, " ping"), true, this), 0L);
        }
    }

    public final void i1(int i10) {
        this.f32143e = i10;
    }

    public final void j1(int i10) {
        this.f32144f = i10;
    }

    public final void k1(@NotNull m mVar) {
        t.i(mVar, "<set-?>");
        this.f32158t = mVar;
    }

    public final void l1(@NotNull oa.b statusCode) throws IOException {
        t.i(statusCode, "statusCode");
        synchronized (this.f32164z) {
            l0 l0Var = new l0();
            synchronized (this) {
                if (this.f32145g) {
                    return;
                }
                this.f32145g = true;
                l0Var.f29831a = N0();
                k0 k0Var = k0.f35197a;
                X0().x(l0Var.f29831a, statusCode, ha.d.f26508a);
            }
        }
    }

    public final void m1(boolean z10, @NotNull ka.e taskRunner) throws IOException {
        t.i(taskRunner, "taskRunner");
        if (z10) {
            this.f32164z.c();
            this.f32164z.R(this.f32157s);
            if (this.f32157s.c() != 65535) {
                this.f32164z.S(0, r5 - 65535);
            }
        }
        taskRunner.i().i(new ka.c(this.f32142d, true, this.A), 0L);
    }

    public final synchronized void o1(long j10) {
        long j11 = this.f32159u + j10;
        this.f32159u = j11;
        long j12 = j11 - this.f32160v;
        if (j12 >= this.f32157s.c() / 2) {
            u1(0, j12);
            this.f32160v += j12;
        }
    }

    public final void p1(int i10, boolean z10, @Nullable ua.c cVar, long j10) throws IOException {
        int iMin;
        long j11;
        if (j10 == 0) {
            this.f32164z.i(z10, i10, cVar, 0);
            return;
        }
        while (j10 > 0) {
            synchronized (this) {
                while (W0() >= V0()) {
                    try {
                        if (!U0().containsKey(Integer.valueOf(i10))) {
                            throw new IOException("stream closed");
                        }
                        wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                iMin = Math.min((int) Math.min(j10, V0() - W0()), X0().B());
                j11 = iMin;
                this.f32161w = W0() + j11;
                k0 k0Var = k0.f35197a;
            }
            j10 -= j11;
            this.f32164z.i(z10 && j10 == 0, i10, cVar, iMin);
        }
    }

    public final void q1(int i10, boolean z10, @NotNull List<oa.c> alternating) throws IOException {
        t.i(alternating, "alternating");
        this.f32164z.z(z10, i10, alternating);
    }

    public final void r1(boolean z10, int i10, int i11) {
        try {
            this.f32164z.J(z10, i10, i11);
        } catch (IOException e10) {
            K0(e10);
        }
    }

    public final void s1(int i10, @NotNull oa.b statusCode) throws IOException {
        t.i(statusCode, "statusCode");
        this.f32164z.O(i10, statusCode);
    }

    public final void t1(int i10, @NotNull oa.b errorCode) {
        t.i(errorCode, "errorCode");
        this.f32147i.i(new k(this.f32142d + '[' + i10 + "] writeSynReset", true, this, i10, errorCode), 0L);
    }

    public final void u1(int i10, long j10) {
        this.f32147i.i(new l(this.f32142d + '[' + i10 + "] windowUpdate", true, this, i10, j10), 0L);
    }

    /* JADX INFO: compiled from: Http2Connection.kt */
    public final class d implements h.c, h9.a<k0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final oa.h f32176a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f32177b;

        /* JADX INFO: compiled from: TaskQueue.kt */
        public static final class a extends ka.a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f32178e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f32179f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ f f32180g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ n0 f32181h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, boolean z10, f fVar, n0 n0Var) {
                super(str, z10);
                this.f32178e = str;
                this.f32179f = z10;
                this.f32180g = fVar;
                this.f32181h = n0Var;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // ka.a
            public long f() {
                this.f32180g.O0().a(this.f32180g, (m) this.f32181h.f29834a);
                return -1L;
            }
        }

        /* JADX INFO: compiled from: TaskQueue.kt */
        public static final class b extends ka.a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f32182e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f32183f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ f f32184g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ oa.i f32185h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str, boolean z10, f fVar, oa.i iVar) {
                super(str, z10);
                this.f32182e = str;
                this.f32183f = z10;
                this.f32184g = fVar;
                this.f32185h = iVar;
            }

            @Override // ka.a
            public long f() {
                try {
                    this.f32184g.O0().b(this.f32185h);
                    return -1L;
                } catch (IOException e10) {
                    qa.j.f33228a.g().k(t.r("Http2Connection.Listener failure for ", this.f32184g.M0()), 4, e10);
                    try {
                        this.f32185h.d(oa.b.PROTOCOL_ERROR, e10);
                        return -1L;
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
            }
        }

        /* JADX INFO: compiled from: TaskQueue.kt */
        public static final class c extends ka.a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f32186e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f32187f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ f f32188g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f32189h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ int f32190i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str, boolean z10, f fVar, int i10, int i11) {
                super(str, z10);
                this.f32186e = str;
                this.f32187f = z10;
                this.f32188g = fVar;
                this.f32189h = i10;
                this.f32190i = i11;
            }

            @Override // ka.a
            public long f() {
                this.f32188g.r1(true, this.f32189h, this.f32190i);
                return -1L;
            }
        }

        /* JADX INFO: renamed from: oa.f$d$d, reason: collision with other inner class name */
        /* JADX INFO: compiled from: TaskQueue.kt */
        public static final class C0643d extends ka.a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f32191e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f32192f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ d f32193g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ boolean f32194h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ m f32195i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0643d(String str, boolean z10, d dVar, boolean z11, m mVar) {
                super(str, z10);
                this.f32191e = str;
                this.f32192f = z10;
                this.f32193g = dVar;
                this.f32194h = z11;
                this.f32195i = mVar;
            }

            @Override // ka.a
            public long f() {
                this.f32193g.k(this.f32194h, this.f32195i);
                return -1L;
            }
        }

        public d(@NotNull f this$0, oa.h reader) {
            t.i(this$0, "this$0");
            t.i(reader, "reader");
            this.f32177b = this$0;
            this.f32176a = reader;
        }

        @Override // oa.h.c
        public void a(boolean z10, int i10, @NotNull ua.e source, int i11) throws IOException {
            t.i(source, "source");
            if (this.f32177b.f1(i10)) {
                this.f32177b.b1(i10, source, i11, z10);
                return;
            }
            oa.i iVarT0 = this.f32177b.T0(i10);
            if (iVarT0 == null) {
                this.f32177b.t1(i10, oa.b.PROTOCOL_ERROR);
                long j10 = i11;
                this.f32177b.o1(j10);
                source.skip(j10);
                return;
            }
            iVarT0.w(source, i11);
            if (z10) {
                iVarT0.x(ha.d.f26509b, true);
            }
        }

        @Override // oa.h.c
        public void b(boolean z10, int i10, int i11, @NotNull List<oa.c> headerBlock) {
            t.i(headerBlock, "headerBlock");
            if (this.f32177b.f1(i10)) {
                this.f32177b.c1(i10, headerBlock, z10);
                return;
            }
            f fVar = this.f32177b;
            synchronized (fVar) {
                oa.i iVarT0 = fVar.T0(i10);
                if (iVarT0 != null) {
                    k0 k0Var = k0.f35197a;
                    iVarT0.x(ha.d.Q(headerBlock), z10);
                    return;
                }
                if (fVar.f32145g) {
                    return;
                }
                if (i10 <= fVar.N0()) {
                    return;
                }
                if (i10 % 2 == fVar.P0() % 2) {
                    return;
                }
                oa.i iVar = new oa.i(i10, fVar, false, z10, ha.d.Q(headerBlock));
                fVar.i1(i10);
                fVar.U0().put(Integer.valueOf(i10), iVar);
                fVar.f32146h.i().i(new b(fVar.M0() + '[' + i10 + "] onStream", true, fVar, iVar), 0L);
            }
        }

        @Override // oa.h.c
        public void c(int i10, @NotNull oa.b errorCode, @NotNull ua.f debugData) {
            int i11;
            Object[] array;
            t.i(errorCode, "errorCode");
            t.i(debugData, "debugData");
            debugData.B();
            f fVar = this.f32177b;
            synchronized (fVar) {
                i11 = 0;
                array = fVar.U0().values().toArray(new oa.i[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
                fVar.f32145g = true;
                k0 k0Var = k0.f35197a;
            }
            oa.i[] iVarArr = (oa.i[]) array;
            int length = iVarArr.length;
            while (i11 < length) {
                oa.i iVar = iVarArr[i11];
                i11++;
                if (iVar.j() > i10 && iVar.t()) {
                    iVar.y(oa.b.REFUSED_STREAM);
                    this.f32177b.g1(iVar.j());
                }
            }
        }

        @Override // oa.h.c
        public void d(int i10, long j10) {
            if (i10 == 0) {
                f fVar = this.f32177b;
                synchronized (fVar) {
                    fVar.f32162x = fVar.V0() + j10;
                    fVar.notifyAll();
                    k0 k0Var = k0.f35197a;
                }
                return;
            }
            oa.i iVarT0 = this.f32177b.T0(i10);
            if (iVarT0 != null) {
                synchronized (iVarT0) {
                    iVarT0.a(j10);
                    k0 k0Var2 = k0.f35197a;
                }
            }
        }

        @Override // oa.h.c
        public void e(int i10, int i11, @NotNull List<oa.c> requestHeaders) {
            t.i(requestHeaders, "requestHeaders");
            this.f32177b.d1(i11, requestHeaders);
        }

        @Override // oa.h.c
        public void f(int i10, @NotNull oa.b errorCode) {
            t.i(errorCode, "errorCode");
            if (this.f32177b.f1(i10)) {
                this.f32177b.e1(i10, errorCode);
                return;
            }
            oa.i iVarG1 = this.f32177b.g1(i10);
            if (iVarG1 == null) {
                return;
            }
            iVarG1.y(errorCode);
        }

        @Override // oa.h.c
        public void h(boolean z10, @NotNull m settings) {
            t.i(settings, "settings");
            this.f32177b.f32147i.i(new C0643d(t.r(this.f32177b.M0(), " applyAndAckSettings"), true, this, z10, settings), 0L);
        }

        @Override // oa.h.c
        public void i(boolean z10, int i10, int i11) {
            if (!z10) {
                this.f32177b.f32147i.i(new c(t.r(this.f32177b.M0(), " ping"), true, this.f32177b, i10, i11), 0L);
                return;
            }
            f fVar = this.f32177b;
            synchronized (fVar) {
                if (i10 == 1) {
                    fVar.f32152n++;
                } else if (i10 != 2) {
                    if (i10 == 3) {
                        fVar.f32155q++;
                        fVar.notifyAll();
                    }
                    k0 k0Var = k0.f35197a;
                } else {
                    fVar.f32154p++;
                }
            }
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() throws Throwable {
            l();
            return k0.f35197a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v1 */
        /* JADX WARN: Type inference failed for: r13v2, types: [T, oa.m] */
        /* JADX WARN: Type inference failed for: r13v3 */
        public final void k(boolean z10, @NotNull m settings) {
            ?? r13;
            long jC;
            int i10;
            oa.i[] iVarArr;
            t.i(settings, "settings");
            n0 n0Var = new n0();
            oa.j jVarX0 = this.f32177b.X0();
            f fVar = this.f32177b;
            synchronized (jVarX0) {
                synchronized (fVar) {
                    m mVarR0 = fVar.R0();
                    if (z10) {
                        r13 = settings;
                    } else {
                        m mVar = new m();
                        mVar.g(mVarR0);
                        mVar.g(settings);
                        r13 = mVar;
                    }
                    n0Var.f29834a = r13;
                    jC = ((long) r13.c()) - ((long) mVarR0.c());
                    i10 = 0;
                    if (jC == 0 || fVar.U0().isEmpty()) {
                        iVarArr = null;
                    } else {
                        Object[] array = fVar.U0().values().toArray(new oa.i[0]);
                        if (array == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        }
                        iVarArr = (oa.i[]) array;
                    }
                    fVar.k1((m) n0Var.f29834a);
                    fVar.f32149k.i(new a(t.r(fVar.M0(), " onSettings"), true, fVar, n0Var), 0L);
                    k0 k0Var = k0.f35197a;
                }
                try {
                    fVar.X0().a((m) n0Var.f29834a);
                } catch (IOException e10) {
                    fVar.K0(e10);
                }
                k0 k0Var2 = k0.f35197a;
            }
            if (iVarArr != null) {
                int length = iVarArr.length;
                while (i10 < length) {
                    oa.i iVar = iVarArr[i10];
                    i10++;
                    synchronized (iVar) {
                        iVar.a(jC);
                        k0 k0Var3 = k0.f35197a;
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [oa.b] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable, oa.h] */
        public void l() throws Throwable {
            oa.b bVar;
            oa.b bVar2 = oa.b.INTERNAL_ERROR;
            IOException e10 = null;
            try {
                try {
                    this.f32176a.i(this);
                    while (this.f32176a.c(false, this)) {
                    }
                    oa.b bVar3 = oa.b.NO_ERROR;
                    try {
                        this.f32177b.J0(bVar3, oa.b.CANCEL, null);
                        bVar = bVar3;
                    } catch (IOException e11) {
                        e10 = e11;
                        oa.b bVar4 = oa.b.PROTOCOL_ERROR;
                        f fVar = this.f32177b;
                        fVar.J0(bVar4, bVar4, e10);
                        bVar = fVar;
                    }
                } catch (Throwable th) {
                    th = th;
                    this.f32177b.J0(bVar, bVar2, e10);
                    ha.d.m(this.f32176a);
                    throw th;
                }
            } catch (IOException e12) {
                e10 = e12;
            } catch (Throwable th2) {
                th = th2;
                bVar = bVar2;
                this.f32177b.J0(bVar, bVar2, e10);
                ha.d.m(this.f32176a);
                throw th;
            }
            bVar2 = this.f32176a;
            ha.d.m(bVar2);
        }

        @Override // oa.h.c
        public void g() {
        }

        @Override // oa.h.c
        public void j(int i10, int i11, int i12, boolean z10) {
        }
    }
}
