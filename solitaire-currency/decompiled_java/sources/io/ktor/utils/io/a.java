package io.ktor.utils.io;

import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import io.ktor.utils.io.internal.g;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.b2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;

/* JADX INFO: compiled from: ByteBufferChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public class a implements io.ktor.utils.io.c, io.ktor.utils.io.g, io.ktor.utils.io.j {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    public static final C0573a f26646l = new C0573a(null);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f26647m = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_state");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f26648n = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_closed");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f26649o = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_readOp");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f26650p = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_writeOp");

    @NotNull
    private volatile /* synthetic */ Object _closed;

    @NotNull
    private volatile /* synthetic */ Object _readOp;

    @NotNull
    private volatile /* synthetic */ Object _state;

    @NotNull
    volatile /* synthetic */ Object _writeOp;

    @Nullable
    private volatile b2 attachedJob;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f26651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final s8.g<g.c> f26652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f26653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f26654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f26655f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final io.ktor.utils.io.internal.f f26656g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final io.ktor.utils.io.internal.l f26657h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private final io.ktor.utils.io.internal.b<Boolean> f26658i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private final io.ktor.utils.io.internal.b<k0> f26659j;

    @Nullable
    private volatile io.ktor.utils.io.internal.d joining;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private final h9.l<z8.d<? super k0>, Object> f26660k;
    private volatile long totalBytesRead;
    private volatile long totalBytesWritten;
    private volatile int writeSuspensionSize;

    /* JADX INFO: renamed from: io.ktor.utils.io.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    public static final class C0573a {
        private C0573a() {
        }

        public /* synthetic */ C0573a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    static final class b extends kotlin.jvm.internal.v implements h9.l<Throwable, k0> {
        b() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
            invoke2(th);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) {
            a.this.attachedJob = null;
            if (th == null) {
                return;
            }
            a.this.b(s.a(th));
        }
    }

    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1200, 1271, AdaptiveTrackSelection.DEFAULT_MAX_WIDTH_TO_DISCARD}, m = "copyDirect$ktor_io")
    static final class c extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f26662j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f26663k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Object f26664l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Object f26665m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Object f26666n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Object f26667o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        Object f26668p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        Object f26669q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        Object f26670r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        Object f26671s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        long f26672t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        long f26673u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        boolean f26674v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        /* synthetic */ Object f26675w;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        int f26677y;

        c(z8.d<? super c> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f26675w = obj;
            this.f26677y |= Integer.MIN_VALUE;
            return a.this.J(null, 0L, null, this);
        }
    }

    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {729, 733}, m = "readAvailableSuspend")
    static final class d extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f26678j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f26679k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f26680l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f26681m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        /* synthetic */ Object f26682n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        int f26684p;

        d(z8.d<? super d> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f26682n = obj;
            this.f26684p |= Integer.MIN_VALUE;
            return a.this.d0(null, 0, 0, this);
        }
    }

    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {745, 749}, m = "readAvailableSuspend")
    static final class e extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f26685j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f26686k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f26687l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f26689n;

        e(z8.d<? super e> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f26687l = obj;
            this.f26689n |= Integer.MIN_VALUE;
            return a.this.c0(null, this);
        }
    }

    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1710, 1718}, m = "readBlockSuspend")
    static final class f extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f26690j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f26691k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f26692l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        /* synthetic */ Object f26693m;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        int f26695o;

        f(z8.d<? super f> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f26693m = obj;
            this.f26695o |= Integer.MIN_VALUE;
            return a.this.e0(0, null, this);
        }
    }

    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {2093}, m = "readRemainingSuspend")
    static final class g extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f26696j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f26697k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Object f26698l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Object f26699m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Object f26700n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        /* synthetic */ Object f26701o;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        int f26703q;

        g(z8.d<? super g> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f26701o = obj;
            this.f26703q |= Integer.MIN_VALUE;
            return a.this.g0(0L, this);
        }
    }

    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {2236}, m = "readSuspendImpl")
    static final class h extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f26704j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f26705k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f26706l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f26708n;

        h(z8.d<? super h> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f26706l = obj;
            this.f26708n |= Integer.MIN_VALUE;
            return a.this.i0(0, this);
        }
    }

    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {2189}, m = "readSuspendLoop")
    static final class i extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f26709j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f26710k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f26711l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f26713n;

        i(z8.d<? super i> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f26711l = obj;
            this.f26713n |= Integer.MIN_VALUE;
            return a.this.j0(0, this);
        }
    }

    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {IronSourceConstants.RV_CALLBACK_SHOW_FAILED, 1115}, m = "writeFullySuspend")
    static final class j extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f26714j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f26715k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f26716l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f26718n;

        j(z8.d<? super j> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f26716l = obj;
            this.f26718n |= Integer.MIN_VALUE;
            return a.this.M0(null, this);
        }
    }

    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1123, 1125}, m = "writeFullySuspend")
    static final class k extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f26719j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f26720k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f26721l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f26723n;

        k(z8.d<? super k> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f26721l = obj;
            this.f26723n |= Integer.MIN_VALUE;
            return a.this.N0(null, this);
        }
    }

    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1422}, m = "writeFullySuspend")
    static final class l extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f26724j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f26725k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f26726l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f26727m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        /* synthetic */ Object f26728n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        int f26730p;

        l(z8.d<? super l> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f26728n = obj;
            this.f26730p |= Integer.MIN_VALUE;
            return a.this.O0(null, 0, 0, this);
        }
    }

    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", l = {1439, 1441}, m = "writeSuspend")
    static final class m extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f26731j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f26732k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f26733l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f26734m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        /* synthetic */ Object f26735n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        int f26737p;

        m(z8.d<? super m> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f26735n = obj;
            this.f26737p |= Integer.MIN_VALUE;
            return a.this.P0(null, 0, 0, this);
        }
    }

    /* JADX INFO: compiled from: ByteBufferChannel.kt */
    static final class n extends kotlin.jvm.internal.v implements h9.l<z8.d<? super k0>, Object> {
        n() {
            super(1);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0052, code lost:
        
            r5 = false;
         */
        @Override // h9.l
        @org.jetbrains.annotations.NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r10) throws java.lang.Throwable {
            /*
                r9 = this;
                java.lang.String r0 = "ucont"
                kotlin.jvm.internal.t.i(r10, r0)
                io.ktor.utils.io.a r0 = io.ktor.utils.io.a.this
                int r0 = io.ktor.utils.io.a.r(r0)
            Lb:
                io.ktor.utils.io.a r1 = io.ktor.utils.io.a.this
                io.ktor.utils.io.internal.c r1 = io.ktor.utils.io.a.p(r1)
                if (r1 == 0) goto L23
                java.lang.Throwable r1 = r1.c()
                if (r1 != 0) goto L1a
                goto L23
            L1a:
                io.ktor.utils.io.b.a(r1)
                v8.h r10 = new v8.h
                r10.<init>()
                throw r10
            L23:
                io.ktor.utils.io.a r1 = io.ktor.utils.io.a.this
                boolean r1 = io.ktor.utils.io.a.F(r1, r0)
                if (r1 != 0) goto L37
                v8.t$a r1 = v8.t.f35208b
                v8.k0 r1 = v8.k0.f35197a
                java.lang.Object r1 = v8.t.b(r1)
                r10.resumeWith(r1)
                goto L6b
            L37:
                io.ktor.utils.io.a r1 = io.ktor.utils.io.a.this
                z8.d r2 = a9.b.c(r10)
                io.ktor.utils.io.a r3 = io.ktor.utils.io.a.this
            L3f:
                z8.d r4 = io.ktor.utils.io.a.q(r1)
                r5 = 1
                r6 = 0
                if (r4 != 0) goto L49
                r4 = r5
                goto L4a
            L49:
                r4 = r6
            L4a:
                if (r4 == 0) goto L82
                boolean r4 = io.ktor.utils.io.a.F(r3, r0)
                if (r4 != 0) goto L54
            L52:
                r5 = r6
                goto L69
            L54:
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = io.ktor.utils.io.a.f26650p
                r7 = 0
                boolean r8 = androidx.concurrent.futures.a.a(r4, r1, r7, r2)
                if (r8 == 0) goto L3f
                boolean r3 = io.ktor.utils.io.a.F(r3, r0)
                if (r3 != 0) goto L69
                boolean r1 = androidx.concurrent.futures.a.a(r4, r1, r2, r7)
                if (r1 != 0) goto L52
            L69:
                if (r5 == 0) goto Lb
            L6b:
                io.ktor.utils.io.a r10 = io.ktor.utils.io.a.this
                io.ktor.utils.io.a.o(r10, r0)
                io.ktor.utils.io.a r10 = io.ktor.utils.io.a.this
                boolean r10 = io.ktor.utils.io.a.A(r10)
                if (r10 == 0) goto L7d
                io.ktor.utils.io.a r10 = io.ktor.utils.io.a.this
                io.ktor.utils.io.a.y(r10)
            L7d:
                java.lang.Object r10 = a9.b.e()
                return r10
            L82:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "Operation is already in progress"
                java.lang.String r0 = r0.toString()
                r10.<init>(r0)
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.a.n.invoke(z8.d):java.lang.Object");
        }
    }

    public a(boolean z10, @NotNull s8.g<g.c> pool, int i10) {
        kotlin.jvm.internal.t.i(pool, "pool");
        this.f26651b = z10;
        this.f26652c = pool;
        this.f26653d = i10;
        this._state = g.a.f26846c;
        this._closed = null;
        this._readOp = null;
        this._writeOp = null;
        this.f26656g = new io.ktor.utils.io.internal.f(this);
        this.f26657h = new io.ktor.utils.io.internal.l(this);
        this.f26658i = new io.ktor.utils.io.internal.b<>();
        this.f26659j = new io.ktor.utils.io.internal.b<>();
        this.f26660k = new n();
    }

    private final boolean A0(io.ktor.utils.io.internal.d dVar) {
        if (!B0(true)) {
            return false;
        }
        L(dVar);
        z8.d dVar2 = (z8.d) f26649o.getAndSet(this, null);
        if (dVar2 != null) {
            t.a aVar = v8.t.f35208b;
            dVar2.resumeWith(v8.t.b(v8.u.a(new IllegalStateException("Joining is in progress"))));
        }
        s0();
        return true;
    }

    private final boolean B0(boolean z10) {
        Object obj;
        g.f fVar;
        g.c cVarG = null;
        do {
            obj = this._state;
            io.ktor.utils.io.internal.g gVar = (io.ktor.utils.io.internal.g) obj;
            io.ktor.utils.io.internal.c cVarN = N();
            if (cVarG != null) {
                if ((cVarN != null ? cVarN.b() : null) == null) {
                    cVarG.f26845b.j();
                }
                s0();
                cVarG = null;
            }
            fVar = g.f.f26856c;
            if (gVar == fVar) {
                return true;
            }
            if (gVar != g.a.f26846c) {
                if (cVarN != null && (gVar instanceof g.b) && (gVar.f26845b.k() || cVarN.b() != null)) {
                    if (cVarN.b() != null) {
                        gVar.f26845b.f();
                    }
                    cVarG = ((g.b) gVar).g();
                } else {
                    if (!z10 || !(gVar instanceof g.b) || !gVar.f26845b.k()) {
                        return false;
                    }
                    cVarG = ((g.b) gVar).g();
                }
            }
        } while (!androidx.concurrent.futures.a.a(f26647m, this, obj, fVar));
        if (cVarG != null && P() == fVar) {
            k0(cVarG);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007c A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int E0(java.nio.ByteBuffer r11) throws java.lang.Throwable {
        /*
            r10 = this;
            io.ktor.utils.io.internal.d r0 = r10.joining
            if (r0 == 0) goto La
            io.ktor.utils.io.a r0 = r10.n0(r10, r0)
            if (r0 != 0) goto Lb
        La:
            r0 = r10
        Lb:
            java.nio.ByteBuffer r1 = r0.x0()
            r2 = 0
            if (r1 != 0) goto L13
            return r2
        L13:
            io.ktor.utils.io.internal.g r3 = r0.P()
            io.ktor.utils.io.internal.i r3 = r3.f26845b
            long r4 = r0.R()
            io.ktor.utils.io.internal.c r6 = r0.N()     // Catch: java.lang.Throwable -> La2
            if (r6 != 0) goto L95
            int r6 = r11.limit()     // Catch: java.lang.Throwable -> La2
            r7 = r2
        L28:
            int r8 = r11.position()     // Catch: java.lang.Throwable -> La2
            int r8 = r6 - r8
            if (r8 == 0) goto L6a
            int r9 = r1.remaining()     // Catch: java.lang.Throwable -> La2
            int r8 = java.lang.Math.min(r8, r9)     // Catch: java.lang.Throwable -> La2
            int r8 = r3.n(r8)     // Catch: java.lang.Throwable -> La2
            if (r8 == 0) goto L6a
            if (r8 <= 0) goto L42
            r9 = 1
            goto L43
        L42:
            r9 = r2
        L43:
            if (r9 == 0) goto L5e
            int r9 = r11.position()     // Catch: java.lang.Throwable -> La2
            int r9 = r9 + r8
            r11.limit(r9)     // Catch: java.lang.Throwable -> La2
            r1.put(r11)     // Catch: java.lang.Throwable -> La2
            int r7 = r7 + r8
            int r8 = r0.f26655f     // Catch: java.lang.Throwable -> La2
            int r8 = r8 + r7
            int r8 = r0.I(r1, r8)     // Catch: java.lang.Throwable -> La2
            int r9 = r3._availableForWrite$internal     // Catch: java.lang.Throwable -> La2
            r0.V(r1, r8, r9)     // Catch: java.lang.Throwable -> La2
            goto L28
        L5e:
            java.lang.String r11 = "Failed requirement."
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> La2
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Throwable -> La2
            r1.<init>(r11)     // Catch: java.lang.Throwable -> La2
            throw r1     // Catch: java.lang.Throwable -> La2
        L6a:
            r11.limit(r6)     // Catch: java.lang.Throwable -> La2
            r0.H(r1, r3, r7)     // Catch: java.lang.Throwable -> La2
            boolean r11 = r3.h()
            if (r11 != 0) goto L7c
            boolean r11 = r0.n()
            if (r11 == 0) goto L7f
        L7c:
            r0.flush()
        L7f:
            if (r0 == r10) goto L8e
            long r1 = r10.R()
            long r8 = r0.R()
            long r8 = r8 - r4
            long r1 = r1 + r8
            r10.v0(r1)
        L8e:
            r0.p0()
            r0.C0()
            return r7
        L95:
            java.lang.Throwable r11 = r6.c()     // Catch: java.lang.Throwable -> La2
            io.ktor.utils.io.b.a(r11)     // Catch: java.lang.Throwable -> La2
            v8.h r11 = new v8.h     // Catch: java.lang.Throwable -> La2
            r11.<init>()     // Catch: java.lang.Throwable -> La2
            throw r11     // Catch: java.lang.Throwable -> La2
        La2:
            r11 = move-exception
            boolean r1 = r3.h()
            if (r1 != 0) goto Laf
            boolean r1 = r0.n()
            if (r1 == 0) goto Lb2
        Laf:
            r0.flush()
        Lb2:
            if (r0 == r10) goto Lc1
            long r1 = r10.R()
            long r6 = r0.R()
            long r6 = r6 - r4
            long r1 = r1 + r6
            r10.v0(r1)
        Lc1:
            r0.p0()
            r0.C0()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.a.E0(java.nio.ByteBuffer):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005a A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int F0(p8.a r11) throws java.lang.Throwable {
        /*
            r10 = this;
            io.ktor.utils.io.internal.d r0 = r10.joining
            if (r0 == 0) goto La
            io.ktor.utils.io.a r0 = r10.n0(r10, r0)
            if (r0 != 0) goto Lb
        La:
            r0 = r10
        Lb:
            java.nio.ByteBuffer r1 = r0.x0()
            r2 = 0
            if (r1 != 0) goto L13
            return r2
        L13:
            io.ktor.utils.io.internal.g r3 = r0.P()
            io.ktor.utils.io.internal.i r3 = r3.f26845b
            long r4 = r0.R()
            io.ktor.utils.io.internal.c r6 = r0.N()     // Catch: java.lang.Throwable -> L80
            if (r6 != 0) goto L73
        L23:
            int r6 = r11.j()     // Catch: java.lang.Throwable -> L80
            int r7 = r11.h()     // Catch: java.lang.Throwable -> L80
            int r6 = r6 - r7
            int r7 = r1.remaining()     // Catch: java.lang.Throwable -> L80
            int r6 = java.lang.Math.min(r6, r7)     // Catch: java.lang.Throwable -> L80
            int r6 = r3.n(r6)     // Catch: java.lang.Throwable -> L80
            if (r6 == 0) goto L4b
            p8.g.a(r11, r1, r6)     // Catch: java.lang.Throwable -> L80
            int r2 = r2 + r6
            int r6 = r0.f26655f     // Catch: java.lang.Throwable -> L80
            int r6 = r6 + r2
            int r6 = r0.I(r1, r6)     // Catch: java.lang.Throwable -> L80
            int r7 = r3._availableForWrite$internal     // Catch: java.lang.Throwable -> L80
            r0.V(r1, r6, r7)     // Catch: java.lang.Throwable -> L80
            goto L23
        L4b:
            r0.H(r1, r3, r2)     // Catch: java.lang.Throwable -> L80
            boolean r11 = r3.h()
            if (r11 != 0) goto L5a
            boolean r11 = r0.n()
            if (r11 == 0) goto L5d
        L5a:
            r0.flush()
        L5d:
            if (r0 == r10) goto L6c
            long r6 = r10.R()
            long r8 = r0.R()
            long r8 = r8 - r4
            long r6 = r6 + r8
            r10.v0(r6)
        L6c:
            r0.p0()
            r0.C0()
            return r2
        L73:
            java.lang.Throwable r11 = r6.c()     // Catch: java.lang.Throwable -> L80
            io.ktor.utils.io.b.a(r11)     // Catch: java.lang.Throwable -> L80
            v8.h r11 = new v8.h     // Catch: java.lang.Throwable -> L80
            r11.<init>()     // Catch: java.lang.Throwable -> L80
            throw r11     // Catch: java.lang.Throwable -> L80
        L80:
            r11 = move-exception
            boolean r1 = r3.h()
            if (r1 != 0) goto L8d
            boolean r1 = r0.n()
            if (r1 == 0) goto L90
        L8d:
            r0.flush()
        L90:
            if (r0 == r10) goto L9f
            long r1 = r10.R()
            long r6 = r0.R()
            long r6 = r6 - r4
            long r1 = r1 + r6
            r10.v0(r1)
        L9f:
            r0.p0()
            r0.C0()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.a.F0(p8.a):int");
    }

    private final void G(ByteBuffer byteBuffer, io.ktor.utils.io.internal.i iVar, int i10) {
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        this.f26654e = I(byteBuffer, this.f26654e + i10);
        iVar.a(i10);
        u0(Q() + ((long) i10));
        s0();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0069 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int G0(byte[] r10, int r11, int r12) throws java.lang.Throwable {
        /*
            r9 = this;
            io.ktor.utils.io.internal.d r0 = r9.joining
            if (r0 == 0) goto La
            io.ktor.utils.io.a r0 = r9.n0(r9, r0)
            if (r0 != 0) goto Lb
        La:
            r0 = r9
        Lb:
            java.nio.ByteBuffer r1 = r0.x0()
            r2 = 0
            if (r1 != 0) goto L13
            return r2
        L13:
            io.ktor.utils.io.internal.g r3 = r0.P()
            io.ktor.utils.io.internal.i r3 = r3.f26845b
            long r4 = r0.R()
            io.ktor.utils.io.internal.c r6 = r0.N()     // Catch: java.lang.Throwable -> L8f
            if (r6 != 0) goto L82
            r6 = r2
        L24:
            int r7 = r12 - r6
            int r8 = r1.remaining()     // Catch: java.lang.Throwable -> L8f
            int r7 = java.lang.Math.min(r7, r8)     // Catch: java.lang.Throwable -> L8f
            int r7 = r3.n(r7)     // Catch: java.lang.Throwable -> L8f
            if (r7 == 0) goto L5a
            if (r7 <= 0) goto L38
            r8 = 1
            goto L39
        L38:
            r8 = r2
        L39:
            if (r8 == 0) goto L4e
            int r8 = r11 + r6
            r1.put(r10, r8, r7)     // Catch: java.lang.Throwable -> L8f
            int r6 = r6 + r7
            int r7 = r0.f26655f     // Catch: java.lang.Throwable -> L8f
            int r7 = r7 + r6
            int r7 = r0.I(r1, r7)     // Catch: java.lang.Throwable -> L8f
            int r8 = r3._availableForWrite$internal     // Catch: java.lang.Throwable -> L8f
            r0.V(r1, r7, r8)     // Catch: java.lang.Throwable -> L8f
            goto L24
        L4e:
            java.lang.String r10 = "Failed requirement."
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L8f
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L8f
            r11.<init>(r10)     // Catch: java.lang.Throwable -> L8f
            throw r11     // Catch: java.lang.Throwable -> L8f
        L5a:
            r0.H(r1, r3, r6)     // Catch: java.lang.Throwable -> L8f
            boolean r10 = r3.h()
            if (r10 != 0) goto L69
            boolean r10 = r0.n()
            if (r10 == 0) goto L6c
        L69:
            r0.flush()
        L6c:
            if (r0 == r9) goto L7b
            long r10 = r9.R()
            long r1 = r0.R()
            long r1 = r1 - r4
            long r10 = r10 + r1
            r9.v0(r10)
        L7b:
            r0.p0()
            r0.C0()
            return r6
        L82:
            java.lang.Throwable r10 = r6.c()     // Catch: java.lang.Throwable -> L8f
            io.ktor.utils.io.b.a(r10)     // Catch: java.lang.Throwable -> L8f
            v8.h r10 = new v8.h     // Catch: java.lang.Throwable -> L8f
            r10.<init>()     // Catch: java.lang.Throwable -> L8f
            throw r10     // Catch: java.lang.Throwable -> L8f
        L8f:
            r10 = move-exception
            boolean r11 = r3.h()
            if (r11 != 0) goto L9c
            boolean r11 = r0.n()
            if (r11 == 0) goto L9f
        L9c:
            r0.flush()
        L9f:
            if (r0 == r9) goto Lae
            long r11 = r9.R()
            long r1 = r0.R()
            long r1 = r1 - r4
            long r11 = r11 + r1
            r9.v0(r11)
        Lae:
            r0.p0()
            r0.C0()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.a.G0(byte[], int, int):int");
    }

    private final void H(ByteBuffer byteBuffer, io.ktor.utils.io.internal.i iVar, int i10) {
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        this.f26655f = I(byteBuffer, this.f26655f + i10);
        iVar.c(i10);
        v0(R() + ((long) i10));
    }

    private final int I(ByteBuffer byteBuffer, int i10) {
        return i10 >= byteBuffer.capacity() - this.f26653d ? i10 - (byteBuffer.capacity() - this.f26653d) : i10;
    }

    static /* synthetic */ Object I0(a aVar, byte[] bArr, int i10, int i11, z8.d<? super Integer> dVar) throws Throwable {
        a aVarN0;
        io.ktor.utils.io.internal.d dVar2 = aVar.joining;
        if (dVar2 != null && (aVarN0 = aVar.n0(aVar, dVar2)) != null) {
            return aVarN0.H0(bArr, i10, i11, dVar);
        }
        int iG0 = aVar.G0(bArr, i10, i11);
        return iG0 > 0 ? kotlin.coroutines.jvm.internal.b.d(iG0) : aVar.P0(bArr, i10, i11, dVar);
    }

    static /* synthetic */ Object J0(a aVar, ByteBuffer byteBuffer, z8.d<? super k0> dVar) throws Throwable {
        a aVarN0;
        io.ktor.utils.io.internal.d dVar2 = aVar.joining;
        if (dVar2 != null && (aVarN0 = aVar.n0(aVar, dVar2)) != null) {
            Object objJ = aVarN0.j(byteBuffer, dVar);
            return objJ == a9.d.e() ? objJ : k0.f35197a;
        }
        aVar.E0(byteBuffer);
        if (!byteBuffer.hasRemaining()) {
            return k0.f35197a;
        }
        Object objM0 = aVar.M0(byteBuffer, dVar);
        return objM0 == a9.d.e() ? objM0 : k0.f35197a;
    }

    static /* synthetic */ Object K0(a aVar, p8.a aVar2, z8.d<? super k0> dVar) throws Throwable {
        aVar.F0(aVar2);
        if (!(aVar2.j() > aVar2.h())) {
            return k0.f35197a;
        }
        Object objN0 = aVar.N0(aVar2, dVar);
        return objN0 == a9.d.e() ? objN0 : k0.f35197a;
    }

    private final void L(io.ktor.utils.io.internal.d dVar) {
        io.ktor.utils.io.internal.c cVarN = N();
        if (cVarN == null) {
            return;
        }
        this.joining = null;
        if (!dVar.b()) {
            dVar.c().flush();
            dVar.a();
            return;
        }
        io.ktor.utils.io.internal.g gVarP = dVar.c().P();
        boolean z10 = (gVarP instanceof g.C0577g) || (gVarP instanceof g.e);
        if (cVarN.b() == null && z10) {
            dVar.c().flush();
        } else {
            dVar.c().d(cVarN.b());
        }
        dVar.a();
    }

    static /* synthetic */ Object L0(a aVar, byte[] bArr, int i10, int i11, z8.d<? super k0> dVar) throws Throwable {
        a aVarN0;
        io.ktor.utils.io.internal.d dVar2 = aVar.joining;
        if (dVar2 != null && (aVarN0 = aVar.n0(aVar, dVar2)) != null) {
            Object objL = aVarN0.l(bArr, i10, i11, dVar);
            return objL == a9.d.e() ? objL : k0.f35197a;
        }
        while (i11 > 0) {
            int iG0 = aVar.G0(bArr, i10, i11);
            if (iG0 == 0) {
                break;
            }
            i10 += iG0;
            i11 -= iG0;
        }
        if (i11 == 0) {
            return k0.f35197a;
        }
        Object objO0 = aVar.O0(bArr, i10, i11, dVar);
        return objO0 == a9.d.e() ? objO0 : k0.f35197a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(int i10) {
        io.ktor.utils.io.internal.g gVarP;
        g.f fVar;
        a aVarC;
        io.ktor.utils.io.internal.d dVar = this.joining;
        if (dVar != null && (aVarC = dVar.c()) != null) {
            aVarC.flush();
        }
        do {
            gVarP = P();
            fVar = g.f.f26856c;
            if (gVarP == fVar) {
                return;
            } else {
                gVarP.f26845b.e();
            }
        } while (gVarP != P());
        int i11 = gVarP.f26845b._availableForWrite$internal;
        if (gVarP.f26845b._availableForRead$internal >= 1) {
            r0();
        }
        io.ktor.utils.io.internal.d dVar2 = this.joining;
        if (i11 >= i10) {
            if (dVar2 == null || P() == fVar) {
                s0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0054 -> B:22:0x0057). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object M0(java.nio.ByteBuffer r6, z8.d<? super v8.k0> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.a.j
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.a$j r0 = (io.ktor.utils.io.a.j) r0
            int r1 = r0.f26718n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f26718n = r1
            goto L18
        L13:
            io.ktor.utils.io.a$j r0 = new io.ktor.utils.io.a$j
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f26716l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f26718n
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            v8.u.b(r7)
            goto L6f
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            java.lang.Object r6 = r0.f26715k
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r2 = r0.f26714j
            io.ktor.utils.io.a r2 = (io.ktor.utils.io.a) r2
            v8.u.b(r7)
            goto L57
        L40:
            v8.u.b(r7)
            r2 = r5
        L44:
            boolean r7 = r6.hasRemaining()
            if (r7 == 0) goto L76
            r0.f26714j = r2
            r0.f26715k = r6
            r0.f26718n = r4
            java.lang.Object r7 = r2.D0(r4, r0)
            if (r7 != r1) goto L57
            return r1
        L57:
            io.ktor.utils.io.internal.d r7 = r2.joining
            if (r7 == 0) goto L72
            io.ktor.utils.io.a r7 = r2.n0(r2, r7)
            if (r7 == 0) goto L72
            r2 = 0
            r0.f26714j = r2
            r0.f26715k = r2
            r0.f26718n = r3
            java.lang.Object r6 = r7.j(r6, r0)
            if (r6 != r1) goto L6f
            return r1
        L6f:
            v8.k0 r6 = v8.k0.f35197a
            return r6
        L72:
            r2.E0(r6)
            goto L44
        L76:
            v8.k0 r6 = v8.k0.f35197a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.a.M0(java.nio.ByteBuffer, z8.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final io.ktor.utils.io.internal.c N() {
        return (io.ktor.utils.io.internal.c) this._closed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005d -> B:25:0x0060). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object N0(p8.a r7, z8.d<? super v8.k0> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.a.k
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.utils.io.a$k r0 = (io.ktor.utils.io.a.k) r0
            int r1 = r0.f26723n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f26723n = r1
            goto L18
        L13:
            io.ktor.utils.io.a$k r0 = new io.ktor.utils.io.a$k
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f26721l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f26723n
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            v8.u.b(r8)
            goto L78
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            java.lang.Object r7 = r0.f26720k
            p8.a r7 = (p8.a) r7
            java.lang.Object r2 = r0.f26719j
            io.ktor.utils.io.a r2 = (io.ktor.utils.io.a) r2
            v8.u.b(r8)
            goto L60
        L40:
            v8.u.b(r8)
            r2 = r6
        L44:
            int r8 = r7.j()
            int r5 = r7.h()
            if (r8 <= r5) goto L50
            r8 = r4
            goto L51
        L50:
            r8 = 0
        L51:
            if (r8 == 0) goto L7f
            r0.f26719j = r2
            r0.f26720k = r7
            r0.f26723n = r4
            java.lang.Object r8 = r2.D0(r4, r0)
            if (r8 != r1) goto L60
            return r1
        L60:
            io.ktor.utils.io.internal.d r8 = r2.joining
            if (r8 == 0) goto L7b
            io.ktor.utils.io.a r8 = r2.n0(r2, r8)
            if (r8 == 0) goto L7b
            r2 = 0
            r0.f26719j = r2
            r0.f26720k = r2
            r0.f26723n = r3
            java.lang.Object r7 = r8.e(r7, r0)
            if (r7 != r1) goto L78
            return r1
        L78:
            v8.k0 r7 = v8.k0.f35197a
            return r7
        L7b:
            r2.F0(r7)
            goto L44
        L7f:
            v8.k0 r7 = v8.k0.f35197a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.a.N0(p8.a, z8.d):java.lang.Object");
    }

    private final z8.d<Boolean> O() {
        return (z8.d) this._readOp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0054 -> B:20:0x0057). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object O0(byte[] r6, int r7, int r8, z8.d<? super v8.k0> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof io.ktor.utils.io.a.l
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.utils.io.a$l r0 = (io.ktor.utils.io.a.l) r0
            int r1 = r0.f26730p
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f26730p = r1
            goto L18
        L13:
            io.ktor.utils.io.a$l r0 = new io.ktor.utils.io.a$l
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f26728n
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f26730p
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            int r6 = r0.f26727m
            int r7 = r0.f26726l
            java.lang.Object r8 = r0.f26725k
            byte[] r8 = (byte[]) r8
            java.lang.Object r2 = r0.f26724j
            io.ktor.utils.io.a r2 = (io.ktor.utils.io.a) r2
            v8.u.b(r9)
            goto L57
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            v8.u.b(r9)
            r2 = r5
        L41:
            if (r8 <= 0) goto L63
            r0.f26724j = r2
            r0.f26725k = r6
            r0.f26726l = r7
            r0.f26727m = r8
            r0.f26730p = r3
            java.lang.Object r9 = r2.H0(r6, r7, r8, r0)
            if (r9 != r1) goto L54
            return r1
        L54:
            r4 = r8
            r8 = r6
            r6 = r4
        L57:
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            int r7 = r7 + r9
            int r6 = r6 - r9
            r4 = r8
            r8 = r6
            r6 = r4
            goto L41
        L63:
            v8.k0 r6 = v8.k0.f35197a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.a.O0(byte[], int, int, z8.d):java.lang.Object");
    }

    private final io.ktor.utils.io.internal.g P() {
        return (io.ktor.utils.io.internal.g) this._state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0059 -> B:20:0x005c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object P0(byte[] r7, int r8, int r9, z8.d<? super java.lang.Integer> r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.a.m
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.utils.io.a$m r0 = (io.ktor.utils.io.a.m) r0
            int r1 = r0.f26737p
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f26737p = r1
            goto L18
        L13:
            io.ktor.utils.io.a$m r0 = new io.ktor.utils.io.a$m
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f26735n
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f26737p
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L47
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            v8.u.b(r10)
            goto L74
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            int r7 = r0.f26734m
            int r8 = r0.f26733l
            java.lang.Object r9 = r0.f26732k
            byte[] r9 = (byte[]) r9
            java.lang.Object r2 = r0.f26731j
            io.ktor.utils.io.a r2 = (io.ktor.utils.io.a) r2
            v8.u.b(r10)
            r5 = r9
            r9 = r7
            r7 = r5
            goto L5c
        L47:
            v8.u.b(r10)
            r2 = r6
        L4b:
            r0.f26731j = r2
            r0.f26732k = r7
            r0.f26733l = r8
            r0.f26734m = r9
            r0.f26737p = r4
            java.lang.Object r10 = r2.D0(r4, r0)
            if (r10 != r1) goto L5c
            return r1
        L5c:
            io.ktor.utils.io.internal.d r10 = r2.joining
            if (r10 == 0) goto L75
            io.ktor.utils.io.a r10 = r2.n0(r2, r10)
            if (r10 == 0) goto L75
            r2 = 0
            r0.f26731j = r2
            r0.f26732k = r2
            r0.f26737p = r3
            java.lang.Object r10 = r10.P0(r7, r8, r9, r0)
            if (r10 != r1) goto L74
            return r1
        L74:
            return r10
        L75:
            int r10 = r2.G0(r7, r8, r9)
            if (r10 <= 0) goto L4b
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.b.d(r10)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.a.P0(byte[], int, int, z8.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Q0(int i10) {
        io.ktor.utils.io.internal.d dVar = this.joining;
        io.ktor.utils.io.internal.g gVarP = P();
        if (N() != null) {
            return false;
        }
        if (dVar == null) {
            if (gVarP.f26845b._availableForWrite$internal >= i10 || gVarP == g.a.f26846c) {
                return false;
            }
        } else if (gVarP == g.f.f26856c || (gVarP instanceof g.C0577g) || (gVarP instanceof g.e)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final z8.d<k0> S() {
        return (z8.d) this._writeOp;
    }

    private final g.c U() {
        g.c cVarK0 = this.f26652c.k0();
        cVarK0.f26845b.j();
        return cVarK0;
    }

    private final void V(ByteBuffer byteBuffer, int i10, int i11) {
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        byteBuffer.limit(n9.o.j(i11 + i10, byteBuffer.capacity() - this.f26653d));
        byteBuffer.position(i10);
    }

    static /* synthetic */ Object W(a aVar, int i10, h9.l<? super ByteBuffer, k0> lVar, z8.d<? super k0> dVar) throws Throwable {
        boolean z10 = true;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException("min should be positive or zero".toString());
        }
        ByteBuffer byteBufferW0 = aVar.w0();
        if (byteBufferW0 != null) {
            io.ktor.utils.io.internal.i iVar = aVar.P().f26845b;
            try {
                if (iVar._availableForRead$internal != 0) {
                    int i11 = iVar._availableForRead$internal;
                    if (i11 <= 0 || i11 < i10) {
                        z10 = false;
                    } else {
                        int iPosition = byteBufferW0.position();
                        int iLimit = byteBufferW0.limit();
                        lVar.invoke(byteBufferW0);
                        if (!(iLimit == byteBufferW0.limit())) {
                            throw new IllegalStateException("Buffer limit modified.".toString());
                        }
                        int iPosition2 = byteBufferW0.position() - iPosition;
                        if (!(iPosition2 >= 0)) {
                            throw new IllegalStateException("Position has been moved backward: pushback is not supported.".toString());
                        }
                        if (!iVar.m(iPosition2)) {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                        aVar.G(byteBufferW0, iVar, iPosition2);
                    }
                    aVar.o0();
                    aVar.C0();
                    z = z10;
                }
            } finally {
                aVar.o0();
                aVar.C0();
            }
        }
        if (z) {
            return k0.f35197a;
        }
        if (!aVar.m() || i10 <= 0) {
            Object objE0 = aVar.e0(i10, lVar, dVar);
            return objE0 == a9.d.e() ? objE0 : k0.f35197a;
        }
        throw new EOFException("Got EOF but at least " + i10 + " bytes were expected");
    }

    private final int X(p8.a aVar, int i10, int i11) throws Throwable {
        int iL;
        boolean z10;
        do {
            ByteBuffer byteBufferW0 = w0();
            if (byteBufferW0 == null) {
                z10 = false;
                iL = 0;
            } else {
                io.ktor.utils.io.internal.i iVar = P().f26845b;
                try {
                    if (iVar._availableForRead$internal == 0) {
                        z10 = false;
                        iL = 0;
                    } else {
                        int iF = aVar.f() - aVar.j();
                        iL = iVar.l(Math.min(byteBufferW0.remaining(), Math.min(iF, i11)));
                        if (iL <= 0) {
                            z10 = false;
                        } else {
                            if (iF < byteBufferW0.remaining()) {
                                byteBufferW0.limit(byteBufferW0.position() + iF);
                            }
                            p8.e.a(aVar, byteBufferW0);
                            G(byteBufferW0, iVar, iL);
                            z10 = true;
                        }
                    }
                } finally {
                    o0();
                    C0();
                }
            }
            i10 += iL;
            i11 -= iL;
            if (!z10) {
                break;
            }
            if (!(aVar.f() > aVar.j())) {
                break;
            }
        } while (P().f26845b._availableForRead$internal > 0);
        return i10;
    }

    private final int Y(byte[] bArr, int i10, int i11) throws Throwable {
        ByteBuffer byteBufferW0 = w0();
        int i12 = 0;
        if (byteBufferW0 != null) {
            io.ktor.utils.io.internal.i iVar = P().f26845b;
            try {
                if (iVar._availableForRead$internal != 0) {
                    int iCapacity = byteBufferW0.capacity() - this.f26653d;
                    while (true) {
                        int i13 = i11 - i12;
                        if (i13 == 0) {
                            break;
                        }
                        int i14 = this.f26654e;
                        int iL = iVar.l(Math.min(iCapacity - i14, i13));
                        if (iL == 0) {
                            break;
                        }
                        byteBufferW0.limit(i14 + iL);
                        byteBufferW0.position(i14);
                        byteBufferW0.get(bArr, i10 + i12, iL);
                        G(byteBufferW0, iVar, iL);
                        i12 += iL;
                    }
                }
            } finally {
                o0();
                C0();
            }
        }
        return i12;
    }

    static /* synthetic */ int Z(a aVar, p8.a aVar2, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readAsMuchAsPossible");
        }
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = aVar2.f() - aVar2.j();
        }
        return aVar.X(aVar2, i10, i11);
    }

    static /* synthetic */ Object a0(a aVar, q8.a aVar2, z8.d<? super Integer> dVar) {
        int iZ = Z(aVar, aVar2, 0, 0, 6, null);
        if (iZ == 0 && aVar.N() != null) {
            iZ = aVar.P().f26845b.e() ? Z(aVar, aVar2, 0, 0, 6, null) : -1;
        } else if (iZ <= 0) {
            if (aVar2.f() > aVar2.j()) {
                return aVar.c0(aVar2, dVar);
            }
        }
        return kotlin.coroutines.jvm.internal.b.d(iZ);
    }

    static /* synthetic */ Object b0(a aVar, byte[] bArr, int i10, int i11, z8.d<? super Integer> dVar) throws Throwable {
        int iY = aVar.Y(bArr, i10, i11);
        if (iY == 0 && aVar.N() != null) {
            iY = aVar.P().f26845b.e() ? aVar.Y(bArr, i10, i11) : -1;
        } else if (iY <= 0 && i11 != 0) {
            return aVar.d0(bArr, i10, i11, dVar);
        }
        return kotlin.coroutines.jvm.internal.b.d(iY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c0(q8.a r6, z8.d<? super java.lang.Integer> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.a.e
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.a$e r0 = (io.ktor.utils.io.a.e) r0
            int r1 = r0.f26689n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f26689n = r1
            goto L18
        L13:
            io.ktor.utils.io.a$e r0 = new io.ktor.utils.io.a$e
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f26687l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f26689n
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            v8.u.b(r7)
            goto L6d
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            java.lang.Object r6 = r0.f26686k
            q8.a r6 = (q8.a) r6
            java.lang.Object r2 = r0.f26685j
            io.ktor.utils.io.a r2 = (io.ktor.utils.io.a) r2
            v8.u.b(r7)
            goto L51
        L40:
            v8.u.b(r7)
            r0.f26685j = r5
            r0.f26686k = r6
            r0.f26689n = r4
            java.lang.Object r7 = r5.h0(r4, r0)
            if (r7 != r1) goto L50
            return r1
        L50:
            r2 = r5
        L51:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L5f
            r6 = -1
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.b.d(r6)
            return r6
        L5f:
            r7 = 0
            r0.f26685j = r7
            r0.f26686k = r7
            r0.f26689n = r3
            java.lang.Object r7 = r2.k(r6, r0)
            if (r7 != r1) goto L6d
            return r1
        L6d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.a.c0(q8.a, z8.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d0(byte[] r6, int r7, int r8, z8.d<? super java.lang.Integer> r9) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r9 instanceof io.ktor.utils.io.a.d
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.utils.io.a$d r0 = (io.ktor.utils.io.a.d) r0
            int r1 = r0.f26684p
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f26684p = r1
            goto L18
        L13:
            io.ktor.utils.io.a$d r0 = new io.ktor.utils.io.a$d
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f26682n
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f26684p
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            v8.u.b(r9)
            goto L75
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            int r8 = r0.f26681m
            int r7 = r0.f26680l
            java.lang.Object r6 = r0.f26679k
            byte[] r6 = (byte[]) r6
            java.lang.Object r2 = r0.f26678j
            io.ktor.utils.io.a r2 = (io.ktor.utils.io.a) r2
            v8.u.b(r9)
            goto L59
        L44:
            v8.u.b(r9)
            r0.f26678j = r5
            r0.f26679k = r6
            r0.f26680l = r7
            r0.f26681m = r8
            r0.f26684p = r4
            java.lang.Object r9 = r5.h0(r4, r0)
            if (r9 != r1) goto L58
            return r1
        L58:
            r2 = r5
        L59:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L67
            r6 = -1
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.b.d(r6)
            return r6
        L67:
            r9 = 0
            r0.f26678j = r9
            r0.f26679k = r9
            r0.f26684p = r3
            java.lang.Object r9 = r2.g(r6, r7, r8, r0)
            if (r9 != r1) goto L75
            return r1
        L75:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.a.d0(byte[], int, int, z8.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e0(int r6, h9.l<? super java.nio.ByteBuffer, v8.k0> r7, z8.d<? super v8.k0> r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.a.f
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.utils.io.a$f r0 = (io.ktor.utils.io.a.f) r0
            int r1 = r0.f26695o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f26695o = r1
            goto L18
        L13:
            io.ktor.utils.io.a$f r0 = new io.ktor.utils.io.a$f
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f26693m
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f26695o
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            v8.u.b(r8)
            goto L90
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            int r6 = r0.f26692l
            java.lang.Object r7 = r0.f26691k
            h9.l r7 = (h9.l) r7
            java.lang.Object r2 = r0.f26690j
            io.ktor.utils.io.a r2 = (io.ktor.utils.io.a) r2
            v8.u.b(r8)
            goto L59
        L42:
            v8.u.b(r8)
            int r8 = n9.m.e(r6, r4)
            r0.f26690j = r5
            r0.f26691k = r7
            r0.f26692l = r6
            r0.f26695o = r4
            java.lang.Object r8 = r5.h0(r8, r0)
            if (r8 != r1) goto L58
            return r1
        L58:
            r2 = r5
        L59:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L82
            if (r6 > 0) goto L66
            v8.k0 r6 = v8.k0.f35197a
            return r6
        L66:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Got EOF but at least "
            r8.append(r0)
            r8.append(r6)
            java.lang.String r6 = " bytes were expected"
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r7.<init>(r6)
            throw r7
        L82:
            r8 = 0
            r0.f26690j = r8
            r0.f26691k = r8
            r0.f26695o = r3
            java.lang.Object r6 = r2.h(r6, r7, r0)
            if (r6 != r1) goto L90
            return r1
        L90:
            v8.k0 r6 = v8.k0.f35197a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.a.e0(int, h9.l, z8.d):java.lang.Object");
    }

    static /* synthetic */ Object f0(a aVar, long j10, z8.d<? super p8.j> dVar) throws Throwable {
        if (!aVar.T()) {
            return aVar.g0(j10, dVar);
        }
        Throwable thC = aVar.c();
        if (thC == null) {
            return aVar.l0(j10);
        }
        io.ktor.utils.io.b.b(thC);
        throw new v8.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0071 A[Catch: all -> 0x003e, TryCatch #2 {all -> 0x003e, blocks: (B:12:0x0039, B:32:0x00a7, B:38:0x00b6, B:21:0x0061, B:23:0x0071, B:24:0x0075, B:26:0x008b, B:28:0x0091), top: B:55:0x0039, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b A[Catch: all -> 0x003e, TryCatch #2 {all -> 0x003e, blocks: (B:12:0x0039, B:32:0x00a7, B:38:0x00b6, B:21:0x0061, B:23:0x0071, B:24:0x0075, B:26:0x008b, B:28:0x0091), top: B:55:0x0039, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b6 A[Catch: all -> 0x003e, TRY_LEAVE, TryCatch #2 {all -> 0x003e, blocks: (B:12:0x0039, B:32:0x00a7, B:38:0x00b6, B:21:0x0061, B:23:0x0071, B:24:0x0075, B:26:0x008b, B:28:0x0091), top: B:55:0x0039, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bb A[Catch: all -> 0x00ce, TRY_ENTER, TryCatch #1 {all -> 0x00ce, blocks: (B:40:0x00bb, B:42:0x00c4, B:44:0x00c9, B:45:0x00ca, B:46:0x00cd, B:12:0x0039, B:32:0x00a7, B:38:0x00b6, B:21:0x0061, B:23:0x0071, B:24:0x0075, B:26:0x008b, B:28:0x0091), top: B:54:0x0021, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00a4 -> B:32:0x00a7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00b3 -> B:37:0x00b4). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g0(long r13, z8.d<? super p8.j> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.a.g0(long, z8.d):java.lang.Object");
    }

    private final Object h0(int i10, z8.d<? super Boolean> dVar) throws Throwable {
        if (P().f26845b._availableForRead$internal >= i10) {
            return kotlin.coroutines.jvm.internal.b.a(true);
        }
        io.ktor.utils.io.internal.c cVarN = N();
        if (cVarN == null) {
            return i10 == 1 ? i0(1, dVar) : j0(i10, dVar);
        }
        Throwable thB = cVarN.b();
        if (thB != null) {
            io.ktor.utils.io.b.b(thB);
            throw new v8.h();
        }
        io.ktor.utils.io.internal.i iVar = P().f26845b;
        boolean z10 = iVar.e() && iVar._availableForRead$internal >= i10;
        if (O() == null) {
            return kotlin.coroutines.jvm.internal.b.a(z10);
        }
        throw new IllegalStateException("Read operation is already in progress");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i0(int r5, z8.d<? super java.lang.Boolean> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.a.h
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.a$h r0 = (io.ktor.utils.io.a.h) r0
            int r1 = r0.f26708n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f26708n = r1
            goto L18
        L13:
            io.ktor.utils.io.a$h r0 = new io.ktor.utils.io.a$h
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f26706l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f26708n
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r5 = r0.f26704j
            io.ktor.utils.io.a r5 = (io.ktor.utils.io.a) r5
            v8.u.b(r6)     // Catch: java.lang.Throwable -> L2d
            goto L7f
        L2d:
            r6 = move-exception
            goto L82
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            v8.u.b(r6)
            io.ktor.utils.io.internal.g r6 = r4.P()
            io.ktor.utils.io.internal.i r2 = r6.f26845b
            int r2 = r2._availableForRead$internal
            if (r2 >= r5) goto L58
            io.ktor.utils.io.internal.d r2 = r4.joining
            if (r2 == 0) goto L56
            z8.d r2 = r4.S()
            if (r2 == 0) goto L56
            io.ktor.utils.io.internal.g$a r2 = io.ktor.utils.io.internal.g.a.f26846c
            if (r6 == r2) goto L58
            boolean r6 = r6 instanceof io.ktor.utils.io.internal.g.b
            if (r6 != 0) goto L58
        L56:
            r6 = r3
            goto L59
        L58:
            r6 = 0
        L59:
            if (r6 != 0) goto L60
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.b.a(r3)
            return r5
        L60:
            r0.f26704j = r4     // Catch: java.lang.Throwable -> L80
            r0.f26705k = r5     // Catch: java.lang.Throwable -> L80
            r0.f26708n = r3     // Catch: java.lang.Throwable -> L80
            io.ktor.utils.io.internal.b<java.lang.Boolean> r6 = r4.f26658i     // Catch: java.lang.Throwable -> L80
            r4.z0(r5, r6)     // Catch: java.lang.Throwable -> L80
            z8.d r5 = a9.b.c(r0)     // Catch: java.lang.Throwable -> L80
            java.lang.Object r6 = r6.f(r5)     // Catch: java.lang.Throwable -> L80
            java.lang.Object r5 = a9.b.e()     // Catch: java.lang.Throwable -> L80
            if (r6 != r5) goto L7c
            kotlin.coroutines.jvm.internal.h.c(r0)     // Catch: java.lang.Throwable -> L80
        L7c:
            if (r6 != r1) goto L7f
            return r1
        L7f:
            return r6
        L80:
            r6 = move-exception
            r5 = r4
        L82:
            r0 = 0
            r5.t0(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.a.i0(int, z8.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0092 -> B:39:0x0095). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j0(int r6, z8.d<? super java.lang.Boolean> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.a.i
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.a$i r0 = (io.ktor.utils.io.a.i) r0
            int r1 = r0.f26713n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f26713n = r1
            goto L18
        L13:
            io.ktor.utils.io.a$i r0 = new io.ktor.utils.io.a$i
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f26711l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f26713n
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 != r4) goto L30
            int r6 = r0.f26710k
            java.lang.Object r2 = r0.f26709j
            io.ktor.utils.io.a r2 = (io.ktor.utils.io.a) r2
            v8.u.b(r7)
            goto L95
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            v8.u.b(r7)
            r2 = r5
        L3c:
            io.ktor.utils.io.internal.g r7 = r2.P()
            io.ktor.utils.io.internal.i r7 = r7.f26845b
            int r7 = r7._availableForRead$internal
            if (r7 < r6) goto L4b
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.b.a(r4)
            return r6
        L4b:
            io.ktor.utils.io.internal.c r7 = r2.N()
            if (r7 == 0) goto L88
            java.lang.Throwable r0 = r7.b()
            if (r0 != 0) goto L7b
            io.ktor.utils.io.internal.g r7 = r2.P()
            io.ktor.utils.io.internal.i r7 = r7.f26845b
            boolean r0 = r7.e()
            if (r0 == 0) goto L68
            int r7 = r7._availableForRead$internal
            if (r7 < r6) goto L68
            r3 = r4
        L68:
            z8.d r6 = r2.O()
            if (r6 != 0) goto L73
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.b.a(r3)
            return r6
        L73:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Read operation is already in progress"
            r6.<init>(r7)
            throw r6
        L7b:
            java.lang.Throwable r6 = r7.b()
            io.ktor.utils.io.b.a(r6)
            v8.h r6 = new v8.h
            r6.<init>()
            throw r6
        L88:
            r0.f26709j = r2
            r0.f26710k = r6
            r0.f26713n = r4
            java.lang.Object r7 = r2.i0(r6, r0)
            if (r7 != r1) goto L95
            return r1
        L95:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L3c
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.b.a(r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.a.j0(int, z8.d):java.lang.Object");
    }

    private final void k0(g.c cVar) {
        this.f26652c.C0(cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final p8.j l0(long j10) {
        p8.i iVar = new p8.i(null, 1, 0 == true ? 1 : 0);
        try {
            q8.a aVarD = q8.g.d(iVar, 1, null);
            while (true) {
                try {
                    if (aVarD.f() - aVarD.j() > j10) {
                        aVarD.s((int) j10);
                    }
                    j10 -= (long) Z(this, aVarD, 0, 0, 6, null);
                    if (!(j10 > 0 && !m())) {
                        iVar.c();
                        return iVar.T0();
                    }
                    aVarD = q8.g.d(iVar, 1, aVarD);
                } catch (Throwable th) {
                    iVar.c();
                    throw th;
                }
            }
        } catch (Throwable th2) {
            iVar.release();
            throw th2;
        }
    }

    private final a n0(a aVar, io.ktor.utils.io.internal.d dVar) {
        while (aVar.P() == g.f.f26856c) {
            aVar = dVar.c();
            dVar = aVar.joining;
            if (dVar == null) {
                return aVar;
            }
        }
        return null;
    }

    private final void o0() {
        Object obj;
        io.ktor.utils.io.internal.g gVarE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        io.ktor.utils.io.internal.g gVar = null;
        do {
            obj = this._state;
            io.ktor.utils.io.internal.g gVar2 = (io.ktor.utils.io.internal.g) obj;
            g.b bVar = (g.b) gVar;
            if (bVar != null) {
                bVar.f26845b.j();
                s0();
                gVar = null;
            }
            gVarE = gVar2.e();
            if ((gVarE instanceof g.b) && P() == gVar2 && gVarE.f26845b.k()) {
                gVarE = g.a.f26846c;
                gVar = gVarE;
            }
            atomicReferenceFieldUpdater = f26647m;
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj, gVarE));
        g.a aVar = g.a.f26846c;
        if (gVarE == aVar) {
            g.b bVar2 = (g.b) gVar;
            if (bVar2 != null) {
                k0(bVar2.g());
            }
            s0();
            return;
        }
        if ((gVarE instanceof g.b) && gVarE.f26845b.g() && gVarE.f26845b.k() && androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, gVarE, aVar)) {
            gVarE.f26845b.j();
            k0(((g.b) gVarE).g());
            s0();
        }
    }

    private final void q0(Throwable th) {
        z8.d dVar = (z8.d) f26649o.getAndSet(this, null);
        if (dVar != null) {
            if (th != null) {
                t.a aVar = v8.t.f35208b;
                dVar.resumeWith(v8.t.b(v8.u.a(th)));
            } else {
                dVar.resumeWith(v8.t.b(Boolean.valueOf(P().f26845b._availableForRead$internal > 0)));
            }
        }
        z8.d dVar2 = (z8.d) f26650p.getAndSet(this, null);
        if (dVar2 != null) {
            t.a aVar2 = v8.t.f35208b;
            if (th == null) {
                th = new p("Byte channel was closed");
            }
            dVar2.resumeWith(v8.t.b(v8.u.a(th)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0() {
        z8.d dVar = (z8.d) f26649o.getAndSet(this, null);
        if (dVar != null) {
            io.ktor.utils.io.internal.c cVarN = N();
            Throwable thB = cVarN != null ? cVarN.b() : null;
            if (thB != null) {
                t.a aVar = v8.t.f35208b;
                dVar.resumeWith(v8.t.b(v8.u.a(thB)));
            } else {
                t.a aVar2 = v8.t.f35208b;
                dVar.resumeWith(v8.t.b(Boolean.TRUE));
            }
        }
    }

    private final void s0() {
        z8.d<k0> dVarS;
        io.ktor.utils.io.internal.c cVarN;
        Object objA;
        do {
            dVarS = S();
            if (dVarS == null) {
                return;
            }
            cVarN = N();
            if (cVarN == null && this.joining != null) {
                io.ktor.utils.io.internal.g gVarP = P();
                if (!(gVarP instanceof g.C0577g) && !(gVarP instanceof g.e) && gVarP != g.f.f26856c) {
                    return;
                }
            }
        } while (!androidx.concurrent.futures.a.a(f26650p, this, dVarS, null));
        if (cVarN == null) {
            t.a aVar = v8.t.f35208b;
            objA = k0.f35197a;
        } else {
            t.a aVar2 = v8.t.f35208b;
            objA = v8.u.a(cVarN.c());
        }
        dVarS.resumeWith(v8.t.b(objA));
    }

    private final void t0(z8.d<? super Boolean> dVar) {
        this._readOp = dVar;
    }

    private final ByteBuffer w0() throws Throwable {
        Object obj;
        Throwable thB;
        io.ktor.utils.io.internal.g gVarC;
        Throwable thB2;
        do {
            obj = this._state;
            io.ktor.utils.io.internal.g gVar = (io.ktor.utils.io.internal.g) obj;
            if (kotlin.jvm.internal.t.d(gVar, g.f.f26856c) ? true : kotlin.jvm.internal.t.d(gVar, g.a.f26846c)) {
                io.ktor.utils.io.internal.c cVarN = N();
                if (cVarN == null || (thB = cVarN.b()) == null) {
                    return null;
                }
                io.ktor.utils.io.b.b(thB);
                throw new v8.h();
            }
            io.ktor.utils.io.internal.c cVarN2 = N();
            if (cVarN2 != null && (thB2 = cVarN2.b()) != null) {
                io.ktor.utils.io.b.b(thB2);
                throw new v8.h();
            }
            if (gVar.f26845b._availableForRead$internal == 0) {
                return null;
            }
            gVarC = gVar.c();
        } while (!androidx.concurrent.futures.a.a(f26647m, this, obj, gVarC));
        ByteBuffer byteBufferA = gVarC.a();
        V(byteBufferA, this.f26654e, gVarC.f26845b._availableForRead$internal);
        return byteBufferA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean y0() {
        return this.joining != null && (P() == g.a.f26846c || (P() instanceof g.b));
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00b8, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object z0(int r7, z8.d<? super java.lang.Boolean> r8) {
        /*
            Method dump skipped, instruction units count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.a.z0(int, z8.d):java.lang.Object");
    }

    public final boolean C0() {
        if (N() == null || !B0(false)) {
            return false;
        }
        io.ktor.utils.io.internal.d dVar = this.joining;
        if (dVar != null) {
            L(dVar);
        }
        r0();
        s0();
        return true;
    }

    @Nullable
    public final Object D0(int i10, @NotNull z8.d<? super k0> dVar) throws Throwable {
        Throwable thC;
        if (!Q0(i10)) {
            io.ktor.utils.io.internal.c cVarN = N();
            if (cVarN == null || (thC = cVarN.c()) == null) {
                return k0.f35197a;
            }
            io.ktor.utils.io.b.b(thC);
            throw new v8.h();
        }
        this.writeSuspensionSize = i10;
        if (this.attachedJob != null) {
            Object objInvoke = this.f26660k.invoke(dVar);
            if (objInvoke == a9.d.e()) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            return objInvoke == a9.d.e() ? objInvoke : k0.f35197a;
        }
        io.ktor.utils.io.internal.b<k0> bVar = this.f26659j;
        this.f26660k.invoke(bVar);
        Object objF = bVar.f(a9.c.c(dVar));
        if (objF == a9.d.e()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objF == a9.d.e() ? objF : k0.f35197a;
    }

    @Nullable
    public Object H0(@NotNull byte[] bArr, int i10, int i11, @NotNull z8.d<? super Integer> dVar) {
        return I0(this, bArr, i10, i11, dVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:232:0x014f, code lost:
    
        r4 = r28;
        r6 = r29;
        r0 = r3;
        r11 = r13;
        r12 = r14;
        r7 = r16;
        r14 = r26;
        r3 = r27;
        r15 = r2;
        r16 = r8;
        r8 = r17;
        r26 = r18;
     */
    /* JADX WARN: Path cross not found for [B:136:0x02ed, B:138:0x02f3], limit reached: 229 */
    /* JADX WARN: Path cross not found for [B:138:0x02f3, B:136:0x02ed], limit reached: 229 */
    /* JADX WARN: Path cross not found for [B:144:0x0315, B:150:0x032e], limit reached: 229 */
    /* JADX WARN: Path cross not found for [B:150:0x032e, B:144:0x0315], limit reached: 229 */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02ed A[Catch: all -> 0x03c2, TryCatch #0 {all -> 0x03c2, blocks: (B:134:0x02e7, B:136:0x02ed, B:140:0x02f8, B:141:0x0307, B:138:0x02f3), top: B:203:0x02e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02f8 A[Catch: all -> 0x03c2, TryCatch #0 {all -> 0x03c2, blocks: (B:134:0x02e7, B:136:0x02ed, B:140:0x02f8, B:141:0x0307, B:138:0x02f3), top: B:203:0x02e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0315 A[Catch: all -> 0x007c, TRY_ENTER, TryCatch #12 {all -> 0x007c, blocks: (B:14:0x0047, B:49:0x011c, B:51:0x0122, B:53:0x0126, B:56:0x012d, B:144:0x0315, B:147:0x031d, B:149:0x0329, B:150:0x032e, B:152:0x0334, B:154:0x033d, B:158:0x036c, B:161:0x0376, B:171:0x0396, B:173:0x039a, B:165:0x037f, B:59:0x0135, B:186:0x03e2, B:188:0x03e8, B:192:0x03f3, B:193:0x0400, B:194:0x0406, B:190:0x03ee, B:196:0x0409, B:197:0x040c, B:19:0x0076), top: B:227:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0334 A[Catch: all -> 0x007c, TryCatch #12 {all -> 0x007c, blocks: (B:14:0x0047, B:49:0x011c, B:51:0x0122, B:53:0x0126, B:56:0x012d, B:144:0x0315, B:147:0x031d, B:149:0x0329, B:150:0x032e, B:152:0x0334, B:154:0x033d, B:158:0x036c, B:161:0x0376, B:171:0x0396, B:173:0x039a, B:165:0x037f, B:59:0x0135, B:186:0x03e2, B:188:0x03e8, B:192:0x03f3, B:193:0x0400, B:194:0x0406, B:190:0x03ee, B:196:0x0409, B:197:0x040c, B:19:0x0076), top: B:227:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x039a A[Catch: all -> 0x007c, TRY_LEAVE, TryCatch #12 {all -> 0x007c, blocks: (B:14:0x0047, B:49:0x011c, B:51:0x0122, B:53:0x0126, B:56:0x012d, B:144:0x0315, B:147:0x031d, B:149:0x0329, B:150:0x032e, B:152:0x0334, B:154:0x033d, B:158:0x036c, B:161:0x0376, B:171:0x0396, B:173:0x039a, B:165:0x037f, B:59:0x0135, B:186:0x03e2, B:188:0x03e8, B:192:0x03f3, B:193:0x0400, B:194:0x0406, B:190:0x03ee, B:196:0x0409, B:197:0x040c, B:19:0x0076), top: B:227:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x03e8 A[Catch: all -> 0x007c, TryCatch #12 {all -> 0x007c, blocks: (B:14:0x0047, B:49:0x011c, B:51:0x0122, B:53:0x0126, B:56:0x012d, B:144:0x0315, B:147:0x031d, B:149:0x0329, B:150:0x032e, B:152:0x0334, B:154:0x033d, B:158:0x036c, B:161:0x0376, B:171:0x0396, B:173:0x039a, B:165:0x037f, B:59:0x0135, B:186:0x03e2, B:188:0x03e8, B:192:0x03f3, B:193:0x0400, B:194:0x0406, B:190:0x03ee, B:196:0x0409, B:197:0x040c, B:19:0x0076), top: B:227:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03ee A[Catch: all -> 0x007c, TryCatch #12 {all -> 0x007c, blocks: (B:14:0x0047, B:49:0x011c, B:51:0x0122, B:53:0x0126, B:56:0x012d, B:144:0x0315, B:147:0x031d, B:149:0x0329, B:150:0x032e, B:152:0x0334, B:154:0x033d, B:158:0x036c, B:161:0x0376, B:171:0x0396, B:173:0x039a, B:165:0x037f, B:59:0x0135, B:186:0x03e2, B:188:0x03e8, B:192:0x03f3, B:193:0x0400, B:194:0x0406, B:190:0x03ee, B:196:0x0409, B:197:0x040c, B:19:0x0076), top: B:227:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x03f3 A[Catch: all -> 0x007c, TryCatch #12 {all -> 0x007c, blocks: (B:14:0x0047, B:49:0x011c, B:51:0x0122, B:53:0x0126, B:56:0x012d, B:144:0x0315, B:147:0x031d, B:149:0x0329, B:150:0x032e, B:152:0x0334, B:154:0x033d, B:158:0x036c, B:161:0x0376, B:171:0x0396, B:173:0x039a, B:165:0x037f, B:59:0x0135, B:186:0x03e2, B:188:0x03e8, B:192:0x03f3, B:193:0x0400, B:194:0x0406, B:190:0x03ee, B:196:0x0409, B:197:0x040c, B:19:0x0076), top: B:227:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0409 A[Catch: all -> 0x007c, TryCatch #12 {all -> 0x007c, blocks: (B:14:0x0047, B:49:0x011c, B:51:0x0122, B:53:0x0126, B:56:0x012d, B:144:0x0315, B:147:0x031d, B:149:0x0329, B:150:0x032e, B:152:0x0334, B:154:0x033d, B:158:0x036c, B:161:0x0376, B:171:0x0396, B:173:0x039a, B:165:0x037f, B:59:0x0135, B:186:0x03e2, B:188:0x03e8, B:192:0x03f3, B:193:0x0400, B:194:0x0406, B:190:0x03ee, B:196:0x0409, B:197:0x040c, B:19:0x0076), top: B:227:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0279 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0122 A[Catch: all -> 0x007c, TryCatch #12 {all -> 0x007c, blocks: (B:14:0x0047, B:49:0x011c, B:51:0x0122, B:53:0x0126, B:56:0x012d, B:144:0x0315, B:147:0x031d, B:149:0x0329, B:150:0x032e, B:152:0x0334, B:154:0x033d, B:158:0x036c, B:161:0x0376, B:171:0x0396, B:173:0x039a, B:165:0x037f, B:59:0x0135, B:186:0x03e2, B:188:0x03e8, B:192:0x03f3, B:193:0x0400, B:194:0x0406, B:190:0x03ee, B:196:0x0409, B:197:0x040c, B:19:0x0076), top: B:227:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0155 A[Catch: all -> 0x03c5, TryCatch #2 {all -> 0x03c5, blocks: (B:63:0x014f, B:65:0x0155, B:67:0x0159), top: B:207:0x014f }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0196 A[Catch: all -> 0x01ac, TRY_LEAVE, TryCatch #6 {all -> 0x01ac, blocks: (B:73:0x0192, B:75:0x0196), top: B:215:0x0192 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01ef A[Catch: all -> 0x02c9, TRY_LEAVE, TryCatch #4 {all -> 0x02c9, blocks: (B:83:0x01cf, B:86:0x01ef), top: B:211:0x01cf }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:149:0x0329 -> B:176:0x03be). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:172:0x0398 -> B:176:0x03be). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:174:0x03bb -> B:176:0x03be). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object J(@org.jetbrains.annotations.NotNull io.ktor.utils.io.a r26, long r27, @org.jetbrains.annotations.Nullable io.ktor.utils.io.internal.d r29, @org.jetbrains.annotations.NotNull z8.d<? super java.lang.Long> r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1050
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.a.J(io.ktor.utils.io.a, long, io.ktor.utils.io.internal.d, z8.d):java.lang.Object");
    }

    @NotNull
    public final io.ktor.utils.io.internal.g K() {
        return P();
    }

    public long Q() {
        return this.totalBytesRead;
    }

    public long R() {
        return this.totalBytesWritten;
    }

    public boolean T() {
        return N() != null;
    }

    @Override // io.ktor.utils.io.c
    public void a(@NotNull b2 job) {
        kotlin.jvm.internal.t.i(job, "job");
        b2 b2Var = this.attachedJob;
        if (b2Var != null) {
            b2.a.a(b2Var, null, 1, null);
        }
        this.attachedJob = job;
        b2.a.d(job, true, false, new b(), 2, null);
    }

    @Override // io.ktor.utils.io.g
    public boolean b(@Nullable Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel has been cancelled");
        }
        return d(th);
    }

    @Override // io.ktor.utils.io.g
    @Nullable
    public Throwable c() {
        io.ktor.utils.io.internal.c cVarN = N();
        if (cVarN != null) {
            return cVarN.b();
        }
        return null;
    }

    @Override // io.ktor.utils.io.j
    public boolean d(@Nullable Throwable th) {
        io.ktor.utils.io.internal.d dVar;
        if (N() != null) {
            return false;
        }
        io.ktor.utils.io.internal.c cVarA = th == null ? io.ktor.utils.io.internal.c.f26830b.a() : new io.ktor.utils.io.internal.c(th);
        P().f26845b.e();
        if (!androidx.concurrent.futures.a.a(f26648n, this, null, cVarA)) {
            return false;
        }
        P().f26845b.e();
        if (P().f26845b.g() || th != null) {
            C0();
        }
        q0(th);
        if (P() == g.f.f26856c && (dVar = this.joining) != null) {
            L(dVar);
        }
        if (th == null) {
            this.f26659j.e(new p("Byte channel was closed"));
            this.f26658i.d(Boolean.valueOf(P().f26845b.e()));
            return true;
        }
        b2 b2Var = this.attachedJob;
        if (b2Var != null) {
            b2.a.a(b2Var, null, 1, null);
        }
        this.f26658i.e(th);
        this.f26659j.e(th);
        return true;
    }

    @Override // io.ktor.utils.io.j
    @Nullable
    public Object e(@NotNull p8.a aVar, @NotNull z8.d<? super k0> dVar) {
        return K0(this, aVar, dVar);
    }

    @Override // io.ktor.utils.io.g
    public int f() {
        return P().f26845b._availableForRead$internal;
    }

    @Override // io.ktor.utils.io.j
    public void flush() {
        M(1);
    }

    @Override // io.ktor.utils.io.g
    @Nullable
    public Object g(@NotNull byte[] bArr, int i10, int i11, @NotNull z8.d<? super Integer> dVar) {
        return b0(this, bArr, i10, i11, dVar);
    }

    @Override // io.ktor.utils.io.g
    @Nullable
    public Object h(int i10, @NotNull h9.l<? super ByteBuffer, k0> lVar, @NotNull z8.d<? super k0> dVar) {
        return W(this, i10, lVar, dVar);
    }

    @Override // io.ktor.utils.io.g
    @Nullable
    public Object i(long j10, @NotNull z8.d<? super p8.j> dVar) {
        return f0(this, j10, dVar);
    }

    @Override // io.ktor.utils.io.j
    @Nullable
    public Object j(@NotNull ByteBuffer byteBuffer, @NotNull z8.d<? super k0> dVar) {
        return J0(this, byteBuffer, dVar);
    }

    @Override // io.ktor.utils.io.g
    @Nullable
    public Object k(@NotNull q8.a aVar, @NotNull z8.d<? super Integer> dVar) {
        return a0(this, aVar, dVar);
    }

    @Override // io.ktor.utils.io.j
    @Nullable
    public Object l(@NotNull byte[] bArr, int i10, int i11, @NotNull z8.d<? super k0> dVar) {
        return L0(this, bArr, i10, i11, dVar);
    }

    @Override // io.ktor.utils.io.g
    public boolean m() {
        return P() == g.f.f26856c && N() != null;
    }

    @NotNull
    public final a m0() {
        a aVarN0;
        io.ktor.utils.io.internal.d dVar = this.joining;
        return (dVar == null || (aVarN0 = n0(this, dVar)) == null) ? this : aVarN0;
    }

    @Override // io.ktor.utils.io.j
    public boolean n() {
        return this.f26651b;
    }

    public final void p0() {
        Object obj;
        io.ktor.utils.io.internal.g gVarF;
        g.b bVar;
        io.ktor.utils.io.internal.g gVar = null;
        do {
            obj = this._state;
            gVarF = ((io.ktor.utils.io.internal.g) obj).f();
            if ((gVarF instanceof g.b) && gVarF.f26845b.g()) {
                gVarF = g.a.f26846c;
                gVar = gVarF;
            }
        } while (!androidx.concurrent.futures.a.a(f26647m, this, obj, gVarF));
        if (gVarF != g.a.f26846c || (bVar = (g.b) gVar) == null) {
            return;
        }
        k0(bVar.g());
    }

    @NotNull
    public String toString() {
        return "ByteBufferChannel(" + hashCode() + ", " + P() + ')';
    }

    public void u0(long j10) {
        this.totalBytesRead = j10;
    }

    public void v0(long j10) {
        this.totalBytesWritten = j10;
    }

    @Nullable
    public final ByteBuffer x0() throws Throwable {
        Object obj;
        io.ktor.utils.io.internal.g gVar;
        g.a aVar;
        io.ktor.utils.io.internal.g gVarD;
        z8.d<k0> dVarS = S();
        if (dVarS != null) {
            throw new IllegalStateException("Write operation is already in progress: " + dVarS);
        }
        io.ktor.utils.io.internal.g gVar2 = null;
        g.c cVarU = null;
        do {
            obj = this._state;
            gVar = (io.ktor.utils.io.internal.g) obj;
            if (this.joining != null) {
                if (cVarU != null) {
                    k0(cVarU);
                }
                return null;
            }
            if (N() != null) {
                if (cVarU != null) {
                    k0(cVarU);
                }
                io.ktor.utils.io.internal.c cVarN = N();
                kotlin.jvm.internal.t.f(cVarN);
                io.ktor.utils.io.b.b(cVarN.c());
                throw new v8.h();
            }
            aVar = g.a.f26846c;
            if (gVar == aVar) {
                if (cVarU == null) {
                    cVarU = U();
                }
                gVarD = cVarU.d();
            } else {
                if (gVar == g.f.f26856c) {
                    if (cVarU != null) {
                        k0(cVarU);
                    }
                    if (this.joining != null) {
                        return null;
                    }
                    io.ktor.utils.io.internal.c cVarN2 = N();
                    kotlin.jvm.internal.t.f(cVarN2);
                    io.ktor.utils.io.b.b(cVarN2.c());
                    throw new v8.h();
                }
                gVarD = gVar.d();
            }
        } while (!androidx.concurrent.futures.a.a(f26647m, this, obj, gVarD));
        if (N() != null) {
            p0();
            C0();
            io.ktor.utils.io.internal.c cVarN3 = N();
            kotlin.jvm.internal.t.f(cVarN3);
            io.ktor.utils.io.b.b(cVarN3.c());
            throw new v8.h();
        }
        ByteBuffer byteBufferB = gVarD.b();
        if (cVarU != null) {
            if (gVar == null) {
                kotlin.jvm.internal.t.A("old");
            } else {
                gVar2 = gVar;
            }
            if (gVar2 != aVar) {
                k0(cVarU);
            }
        }
        V(byteBufferB, this.f26655f, gVarD.f26845b._availableForWrite$internal);
        return byteBufferB;
    }

    public /* synthetic */ a(boolean z10, s8.g gVar, int i10, int i11, kotlin.jvm.internal.k kVar) {
        this(z10, (i11 & 2) != 0 ? io.ktor.utils.io.internal.e.c() : gVar, (i11 & 4) != 0 ? 8 : i10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NotNull ByteBuffer content) {
        this(false, io.ktor.utils.io.internal.e.b(), 0);
        kotlin.jvm.internal.t.i(content, "content");
        ByteBuffer byteBufferSlice = content.slice();
        kotlin.jvm.internal.t.h(byteBufferSlice, "content.slice()");
        g.c cVar = new g.c(byteBufferSlice, 0);
        cVar.f26845b.i();
        this._state = cVar.d();
        p0();
        io.ktor.utils.io.k.a(this);
        C0();
    }
}
