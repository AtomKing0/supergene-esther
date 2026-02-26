package io.ktor.utils.io;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ByteChannelSequential.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f implements io.ktor.utils.io.c, io.ktor.utils.io.g, io.ktor.utils.io.j {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f26740h = AtomicLongFieldUpdater.newUpdater(f.class, "_totalBytesRead");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f26741i = AtomicLongFieldUpdater.newUpdater(f.class, "_totalBytesWritten");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f26742j = AtomicIntegerFieldUpdater.newUpdater(f.class, "_availableForRead");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f26743k = AtomicIntegerFieldUpdater.newUpdater(f.class, "channelSize");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f26744l = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_closed");

    @NotNull
    private volatile /* synthetic */ int _availableForRead;

    @NotNull
    private volatile /* synthetic */ Object _closed;

    @NotNull
    private volatile /* synthetic */ Object _lastReadView;

    @NotNull
    private volatile /* synthetic */ long _totalBytesRead;

    @NotNull
    private volatile /* synthetic */ long _totalBytesWritten;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f26745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final p8.i f26746c;

    @NotNull
    private volatile /* synthetic */ int channelSize;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final p8.j f26747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final io.ktor.utils.io.internal.a f26748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final Object f26749f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final p8.i f26750g;

    @NotNull
    private volatile /* synthetic */ int lastReadAvailable$delegate;

    @NotNull
    private volatile /* synthetic */ Object lastReadView$delegate;

    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {88}, m = "awaitAtLeastNBytesAvailableForRead$ktor_io")
    static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f26751j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f26752k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f26753l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f26755n;

        a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f26753l = obj;
            this.f26755n |= Integer.MIN_VALUE;
            return f.this.t(0, this);
        }
    }

    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    static final class b extends kotlin.jvm.internal.v implements h9.a<Boolean> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f26757h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i10) {
            super(0);
            this.f26757h = i10;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final Boolean invoke() {
            return Boolean.valueOf(f.this.f() < this.f26757h && !f.this.m());
        }
    }

    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {81}, m = "awaitAtLeastNBytesAvailableForWrite$ktor_io")
    static final class c extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f26758j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f26759k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f26760l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f26762n;

        c(z8.d<? super c> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f26760l = obj;
            this.f26762n |= Integer.MIN_VALUE;
            return f.this.u(0, this);
        }
    }

    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    static final class d extends kotlin.jvm.internal.v implements h9.a<Boolean> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f26764h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(int i10) {
            super(0);
            this.f26764h = i10;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final Boolean invoke() {
            return Boolean.valueOf(f.this.C() < this.f26764h && !f.this.D());
        }
    }

    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {611}, m = "awaitSuspend")
    static final class e extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f26765j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f26766k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f26767l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f26769n;

        e(z8.d<? super e> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f26767l = obj;
            this.f26769n |= Integer.MIN_VALUE;
            return f.this.w(0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {486}, m = "readAvailable$ktor_io")
    static final class C0574f extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f26770j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f26771k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f26772l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f26774n;

        C0574f(z8.d<? super C0574f> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f26772l = obj;
            this.f26774n |= Integer.MIN_VALUE;
            return f.this.G(null, this);
        }
    }

    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {IronSourceError.ERROR_AD_UNIT_CAPPED}, m = "readAvailable$suspendImpl")
    static final class g extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f26775j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f26776k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f26777l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f26778m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        /* synthetic */ Object f26779n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        int f26781p;

        g(z8.d<? super g> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f26779n = obj;
            this.f26781p |= Integer.MIN_VALUE;
            return f.I(f.this, null, 0, 0, this);
        }
    }

    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {TypedValues.CycleType.TYPE_WAVE_PHASE}, m = "readRemainingSuspend")
    static final class h extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f26782j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f26783k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        long f26784l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        /* synthetic */ Object f26785m;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        int f26787o;

        h(z8.d<? super h> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f26785m = obj;
            this.f26787o |= Integer.MIN_VALUE;
            return f.this.K(null, 0L, this);
        }
    }

    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {193}, m = "writeFully$suspendImpl")
    static final class i extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f26788j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f26789k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f26790l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f26792n;

        i(z8.d<? super i> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f26790l = obj;
            this.f26792n |= Integer.MIN_VALUE;
            return f.M(f.this, null, this);
        }
    }

    /* JADX INFO: compiled from: ByteChannelSequential.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.ByteChannelSequentialBase", f = "ByteChannelSequential.kt", l = {204}, m = "writeFully$suspendImpl")
    static final class j extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f26793j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f26794k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f26795l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f26796m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        /* synthetic */ Object f26797n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        int f26799p;

        j(z8.d<? super j> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f26797n = obj;
            this.f26799p |= Integer.MIN_VALUE;
            return f.N(f.this, null, 0, 0, this);
        }
    }

    private final boolean A() {
        if (this.f26746c.V0()) {
            this.f26748e.c();
            return false;
        }
        B();
        this.f26748e.c();
        return true;
    }

    private final void B() {
        synchronized (this.f26749f) {
            int iU0 = this.f26746c.U0();
            q8.a aVarK0 = this.f26746c.K0();
            kotlin.jvm.internal.t.f(aVarK0);
            this.f26750g.L0(aVarK0);
            f26742j.addAndGet(this, iU0);
        }
    }

    private final boolean E() {
        n nVar = (n) this._closed;
        return (nVar != null ? nVar.a() : null) != null;
    }

    static /* synthetic */ Object H(f fVar, q8.a aVar, z8.d<? super Integer> dVar) {
        kotlin.jvm.internal.t.g(aVar, "null cannot be cast to non-null type io.ktor.utils.io.core.Buffer");
        return fVar.G(aVar, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object I(io.ktor.utils.io.f r6, byte[] r7, int r8, int r9, z8.d<? super java.lang.Integer> r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof io.ktor.utils.io.f.g
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.utils.io.f$g r0 = (io.ktor.utils.io.f.g) r0
            int r1 = r0.f26781p
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f26781p = r1
            goto L18
        L13:
            io.ktor.utils.io.f$g r0 = new io.ktor.utils.io.f$g
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f26779n
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f26781p
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            int r6 = r0.f26778m
            int r7 = r0.f26777l
            java.lang.Object r8 = r0.f26776k
            byte[] r8 = (byte[]) r8
            java.lang.Object r9 = r0.f26775j
            io.ktor.utils.io.f r9 = (io.ktor.utils.io.f) r9
            v8.u.b(r10)
            r4 = r9
            r9 = r6
            r6 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L7d
        L3b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L43:
            v8.u.b(r10)
            java.lang.Throwable r10 = r6.c()
            if (r10 != 0) goto La1
            boolean r10 = r6.D()
            if (r10 == 0) goto L5e
            int r10 = r6.f()
            if (r10 != 0) goto L5e
            r6 = -1
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.b.d(r6)
            return r6
        L5e:
            if (r9 != 0) goto L66
            r6 = 0
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.b.d(r6)
            return r6
        L66:
            int r10 = r6.f()
            if (r10 != 0) goto L7d
            r0.f26775j = r6
            r0.f26776k = r7
            r0.f26777l = r8
            r0.f26778m = r9
            r0.f26781p = r3
            java.lang.Object r10 = r6.w(r3, r0)
            if (r10 != r1) goto L7d
            return r1
        L7d:
            p8.j r10 = r6.f26747d
            boolean r10 = r10.q()
            if (r10 != 0) goto L88
            r6.F()
        L88:
            long r9 = (long) r9
            p8.j r0 = r6.f26747d
            long r0 = r0.P0()
            long r9 = java.lang.Math.min(r9, r0)
            int r9 = (int) r9
            p8.j r10 = r6.f26747d
            p8.n.b(r10, r7, r8, r9)
            r6.r(r9)
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.b.d(r9)
            return r6
        La1:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.f.I(io.ktor.utils.io.f, byte[], int, int, z8.d):java.lang.Object");
    }

    static /* synthetic */ Object J(f fVar, long j10, z8.d<? super p8.j> dVar) throws Throwable {
        fVar.y();
        p8.i iVar = new p8.i(null, 1, null);
        long jMin = Math.min(j10, fVar.f26747d.P0());
        iVar.N0(fVar.f26747d, jMin);
        fVar.r((int) jMin);
        if (j10 - ((long) iVar.U0()) != 0 && !fVar.m()) {
            return fVar.K(iVar, j10, dVar);
        }
        fVar.z(iVar);
        return iVar.T0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object K(p8.i r11, long r12, z8.d<? super p8.j> r14) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r14 instanceof io.ktor.utils.io.f.h
            if (r0 == 0) goto L13
            r0 = r14
            io.ktor.utils.io.f$h r0 = (io.ktor.utils.io.f.h) r0
            int r1 = r0.f26787o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f26787o = r1
            goto L18
        L13:
            io.ktor.utils.io.f$h r0 = new io.ktor.utils.io.f$h
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.f26785m
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f26787o
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            long r11 = r0.f26784l
            java.lang.Object r13 = r0.f26783k
            p8.i r13 = (p8.i) r13
            java.lang.Object r2 = r0.f26782j
            io.ktor.utils.io.f r2 = (io.ktor.utils.io.f) r2
            v8.u.b(r14)
            r8 = r11
            r11 = r13
            r12 = r8
            goto L42
        L36:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3e:
            v8.u.b(r14)
            r2 = r10
        L42:
            int r14 = r11.U0()
            long r4 = (long) r14
            int r14 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r14 >= 0) goto L85
            int r14 = r11.U0()
            long r4 = (long) r14
            long r4 = r12 - r4
            p8.j r14 = r2.f26747d
            long r6 = r14.P0()
            long r4 = java.lang.Math.min(r4, r6)
            p8.j r14 = r2.f26747d
            r11.N0(r14, r4)
            int r14 = (int) r4
            r2.r(r14)
            r2.z(r11)
            boolean r14 = r2.m()
            if (r14 != 0) goto L85
            int r14 = r11.U0()
            int r4 = (int) r12
            if (r14 != r4) goto L76
            goto L85
        L76:
            r0.f26782j = r2
            r0.f26783k = r11
            r0.f26784l = r12
            r0.f26787o = r3
            java.lang.Object r14 = r2.w(r3, r0)
            if (r14 != r1) goto L42
            return r1
        L85:
            r2.z(r11)
            p8.j r11 = r11.T0()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.f.K(p8.i, long, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object M(io.ktor.utils.io.f r4, p8.a r5, z8.d<? super v8.k0> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.f.i
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.f$i r0 = (io.ktor.utils.io.f.i) r0
            int r1 = r0.f26792n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f26792n = r1
            goto L18
        L13:
            io.ktor.utils.io.f$i r0 = new io.ktor.utils.io.f$i
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f26790l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f26792n
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.f26789k
            r5 = r4
            p8.a r5 = (p8.a) r5
            java.lang.Object r4 = r0.f26788j
            io.ktor.utils.io.f r4 = (io.ktor.utils.io.f) r4
            v8.u.b(r6)
            goto L4a
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            v8.u.b(r6)
            r0.f26788j = r4
            r0.f26789k = r5
            r0.f26792n = r3
            java.lang.Object r6 = r4.u(r3, r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            int r6 = r5.j()
            int r0 = r5.h()
            int r6 = r6 - r0
            p8.i r0 = r4.f26746c
            r1 = 2
            r2 = 0
            r3 = 0
            p8.q.c(r0, r5, r3, r1, r2)
            r4.s(r6)
            v8.k0 r4 = v8.k0.f35197a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.f.M(io.ktor.utils.io.f, p8.a, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0059 -> B:19:0x005c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object N(io.ktor.utils.io.f r5, byte[] r6, int r7, int r8, z8.d<? super v8.k0> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.io.f.j
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.utils.io.f$j r0 = (io.ktor.utils.io.f.j) r0
            int r1 = r0.f26799p
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f26799p = r1
            goto L18
        L13:
            io.ktor.utils.io.f$j r0 = new io.ktor.utils.io.f$j
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f26797n
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f26799p
            r3 = 1
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            int r5 = r0.f26796m
            int r6 = r0.f26795l
            java.lang.Object r7 = r0.f26794k
            byte[] r7 = (byte[]) r7
            java.lang.Object r8 = r0.f26793j
            io.ktor.utils.io.f r8 = (io.ktor.utils.io.f) r8
            v8.u.b(r9)
            r4 = r8
            r8 = r6
            r6 = r4
            goto L5c
        L38:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L40:
            v8.u.b(r9)
            int r8 = r8 + r7
            r4 = r6
            r6 = r5
            r5 = r8
            r8 = r7
            r7 = r4
        L49:
            if (r8 >= r5) goto L70
            r0.f26793j = r6
            r0.f26794k = r7
            r0.f26795l = r8
            r0.f26796m = r5
            r0.f26799p = r3
            java.lang.Object r9 = r6.u(r3, r0)
            if (r9 != r1) goto L5c
            return r1
        L5c:
            int r9 = r6.C()
            int r2 = r5 - r8
            int r9 = java.lang.Math.min(r9, r2)
            p8.i r2 = r6.f26746c
            p8.q.b(r2, r7, r8, r9)
            int r8 = r8 + r9
            r6.s(r9)
            goto L49
        L70:
            v8.k0 r5 = v8.k0.f35197a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.f.N(io.ktor.utils.io.f, byte[], int, int, z8.d):java.lang.Object");
    }

    private final void p(int i10) {
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Can't read negative amount of bytes: " + i10).toString());
        }
        int i11 = -i10;
        f26743k.getAndAdd(this, i11);
        f26740h.addAndGet(this, i10);
        f26742j.getAndAdd(this, i11);
        if (!(this.channelSize >= 0)) {
            throw new IllegalStateException(("Readable bytes count is negative: " + f() + ", " + i10 + " in " + this).toString());
        }
        if (f() >= 0) {
            return;
        }
        throw new IllegalStateException(("Readable bytes count is negative: " + f() + ", " + i10 + " in " + this).toString());
    }

    private final void q(int i10) {
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Can't write negative amount of bytes: " + i10).toString());
        }
        f26743k.getAndAdd(this, i10);
        f26741i.addAndGet(this, i10);
        if (this.channelSize >= 0) {
            return;
        }
        throw new IllegalStateException(("Readable bytes count is negative: " + this.channelSize + ", " + i10 + " in " + this).toString());
    }

    private final void x() throws Throwable {
        if (D()) {
            Throwable thC = c();
            if (thC != null) {
                throw thC;
            }
            throw new p("Channel " + this + " is already closed");
        }
    }

    private final void y() throws Throwable {
        Throwable thC = c();
        if (thC != null) {
            throw thC;
        }
    }

    private final void z(p8.i iVar) throws Throwable {
        Throwable thC = c();
        if (thC == null) {
            return;
        }
        iVar.release();
        throw thC;
    }

    public int C() {
        return Math.max(0, 4088 - this.channelSize);
    }

    protected final boolean D() {
        return this._closed != null;
    }

    protected final void F() {
        synchronized (this.f26749f) {
            q8.g.e(this.f26747d, this.f26750g);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object G(@org.jetbrains.annotations.NotNull p8.a r6, @org.jetbrains.annotations.NotNull z8.d<? super java.lang.Integer> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.f.C0574f
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.f$f r0 = (io.ktor.utils.io.f.C0574f) r0
            int r1 = r0.f26774n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f26774n = r1
            goto L18
        L13:
            io.ktor.utils.io.f$f r0 = new io.ktor.utils.io.f$f
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f26772l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f26774n
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.f26771k
            p8.a r6 = (p8.a) r6
            java.lang.Object r0 = r0.f26770j
            io.ktor.utils.io.f r0 = (io.ktor.utils.io.f) r0
            v8.u.b(r7)
            goto L79
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            v8.u.b(r7)
            java.lang.Throwable r7 = r5.c()
            if (r7 != 0) goto La6
            boolean r7 = r5.D()
            if (r7 == 0) goto L54
            int r7 = r5.f()
            if (r7 != 0) goto L54
            r6 = -1
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.b.d(r6)
            return r6
        L54:
            int r7 = r6.f()
            int r2 = r6.j()
            int r7 = r7 - r2
            if (r7 != 0) goto L65
            r6 = 0
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.b.d(r6)
            return r6
        L65:
            int r7 = r5.f()
            if (r7 != 0) goto L78
            r0.f26770j = r5
            r0.f26771k = r6
            r0.f26774n = r3
            java.lang.Object r7 = r5.w(r3, r0)
            if (r7 != r1) goto L78
            return r1
        L78:
            r0 = r5
        L79:
            p8.j r7 = r0.f26747d
            boolean r7 = r7.q()
            if (r7 != 0) goto L84
            r0.F()
        L84:
            int r7 = r6.f()
            int r1 = r6.j()
            int r7 = r7 - r1
            long r1 = (long) r7
            p8.j r7 = r0.f26747d
            long r3 = r7.P0()
            long r1 = java.lang.Math.min(r1, r3)
            int r7 = (int) r1
            p8.j r1 = r0.f26747d
            p8.n.a(r1, r6, r7)
            r0.r(r7)
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.b.d(r7)
            return r6
        La6:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.f.G(p8.a, z8.d):java.lang.Object");
    }

    public final long L(@NotNull f dst, long j10) throws Throwable {
        kotlin.jvm.internal.t.i(dst, "dst");
        long jP0 = this.f26747d.P0();
        if (jP0 > j10) {
            return 0L;
        }
        dst.f26746c.M0(this.f26747d);
        int i10 = (int) jP0;
        dst.s(i10);
        r(i10);
        return jP0;
    }

    @Override // io.ktor.utils.io.g
    public boolean b(@Nullable Throwable th) {
        if (c() != null || D()) {
            return false;
        }
        if (th == null) {
            th = new CancellationException("Channel cancelled");
        }
        return d(th);
    }

    @Override // io.ktor.utils.io.g
    @Nullable
    public final Throwable c() {
        n nVar = (n) this._closed;
        if (nVar != null) {
            return nVar.a();
        }
        return null;
    }

    @Override // io.ktor.utils.io.j
    public boolean d(@Nullable Throwable th) {
        if (!androidx.concurrent.futures.a.a(f26744l, this, null, th == null ? o.a() : new n(th))) {
            return false;
        }
        if (th != null) {
            this.f26747d.release();
            this.f26746c.release();
            this.f26750g.release();
        } else {
            flush();
            this.f26746c.release();
        }
        this.f26748e.b(th);
        return true;
    }

    @Override // io.ktor.utils.io.j
    @Nullable
    public Object e(@NotNull p8.a aVar, @NotNull z8.d<? super k0> dVar) {
        return M(this, aVar, dVar);
    }

    @Override // io.ktor.utils.io.g
    public int f() {
        return this._availableForRead;
    }

    @Override // io.ktor.utils.io.j
    public void flush() {
        A();
    }

    @Override // io.ktor.utils.io.g
    @Nullable
    public Object g(@NotNull byte[] bArr, int i10, int i11, @NotNull z8.d<? super Integer> dVar) {
        return I(this, bArr, i10, i11, dVar);
    }

    @Override // io.ktor.utils.io.g
    @Nullable
    public Object i(long j10, @NotNull z8.d<? super p8.j> dVar) {
        return J(this, j10, dVar);
    }

    @Override // io.ktor.utils.io.g
    @Nullable
    public Object k(@NotNull q8.a aVar, @NotNull z8.d<? super Integer> dVar) {
        return H(this, aVar, dVar);
    }

    @Override // io.ktor.utils.io.j
    @Nullable
    public Object l(@NotNull byte[] bArr, int i10, int i11, @NotNull z8.d<? super k0> dVar) {
        return N(this, bArr, i10, i11, dVar);
    }

    @Override // io.ktor.utils.io.g
    public boolean m() {
        return E() || (D() && this.channelSize == 0);
    }

    @Override // io.ktor.utils.io.j
    public boolean n() {
        return this.f26745b;
    }

    protected final void r(int i10) {
        p(i10);
        this.f26748e.c();
    }

    protected final void s(int i10) throws Throwable {
        q(i10);
        if (D()) {
            this.f26746c.release();
            x();
        }
        if (n() || C() == 0) {
            flush();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(int r6, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.f.a
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.f$a r0 = (io.ktor.utils.io.f.a) r0
            int r1 = r0.f26755n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f26755n = r1
            goto L18
        L13:
            io.ktor.utils.io.f$a r0 = new io.ktor.utils.io.f$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f26753l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f26755n
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            int r6 = r0.f26752k
            java.lang.Object r2 = r0.f26751j
            io.ktor.utils.io.f r2 = (io.ktor.utils.io.f) r2
            v8.u.b(r7)
            goto L3b
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            v8.u.b(r7)
            r2 = r5
        L3b:
            int r7 = r2.f()
            if (r7 >= r6) goto L5b
            boolean r7 = r2.m()
            if (r7 != 0) goto L5b
            io.ktor.utils.io.internal.a r7 = r2.f26748e
            io.ktor.utils.io.f$b r4 = new io.ktor.utils.io.f$b
            r4.<init>(r6)
            r0.f26751j = r2
            r0.f26752k = r6
            r0.f26755n = r3
            java.lang.Object r7 = r7.d(r4, r0)
            if (r7 != r1) goto L3b
            return r1
        L5b:
            v8.k0 r6 = v8.k0.f35197a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.f.t(int, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u(int r6, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.f.c
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.f$c r0 = (io.ktor.utils.io.f.c) r0
            int r1 = r0.f26762n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f26762n = r1
            goto L18
        L13:
            io.ktor.utils.io.f$c r0 = new io.ktor.utils.io.f$c
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f26760l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f26762n
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            int r6 = r0.f26759k
            java.lang.Object r2 = r0.f26758j
            io.ktor.utils.io.f r2 = (io.ktor.utils.io.f) r2
            v8.u.b(r7)
            goto L3b
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            v8.u.b(r7)
            r2 = r5
        L3b:
            int r7 = r2.C()
            if (r7 >= r6) goto L61
            boolean r7 = r2.D()
            if (r7 != 0) goto L61
            boolean r7 = r2.A()
            if (r7 != 0) goto L3b
            io.ktor.utils.io.internal.a r7 = r2.f26748e
            io.ktor.utils.io.f$d r4 = new io.ktor.utils.io.f$d
            r4.<init>(r6)
            r0.f26758j = r2
            r0.f26759k = r6
            r0.f26762n = r3
            java.lang.Object r7 = r7.d(r4, r0)
            if (r7 != r1) goto L3b
            return r1
        L61:
            v8.k0 r6 = v8.k0.f35197a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.f.u(int, z8.d):java.lang.Object");
    }

    @Nullable
    public final Object v(@NotNull z8.d<? super Boolean> dVar) {
        return this.f26747d.J0() ^ true ? kotlin.coroutines.jvm.internal.b.a(true) : w(1, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final java.lang.Object w(int r6, @org.jetbrains.annotations.NotNull z8.d<? super java.lang.Boolean> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.f.e
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.utils.io.f$e r0 = (io.ktor.utils.io.f.e) r0
            int r1 = r0.f26769n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f26769n = r1
            goto L18
        L13:
            io.ktor.utils.io.f$e r0 = new io.ktor.utils.io.f$e
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f26767l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f26769n
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 != r4) goto L30
            int r6 = r0.f26766k
            java.lang.Object r0 = r0.f26765j
            io.ktor.utils.io.f r0 = (io.ktor.utils.io.f) r0
            v8.u.b(r7)
            goto L50
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            v8.u.b(r7)
            if (r6 < 0) goto L3f
            r7 = r4
            goto L40
        L3f:
            r7 = r3
        L40:
            if (r7 == 0) goto L6c
            r0.f26765j = r5
            r0.f26766k = r6
            r0.f26769n = r4
            java.lang.Object r7 = r5.t(r6, r0)
            if (r7 != r1) goto L4f
            return r1
        L4f:
            r0 = r5
        L50:
            r0.F()
            java.lang.Throwable r7 = r0.c()
            if (r7 != 0) goto L6b
            boolean r7 = r0.m()
            if (r7 != 0) goto L66
            int r7 = r0.f()
            if (r7 < r6) goto L66
            r3 = r4
        L66:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.b.a(r3)
            return r6
        L6b:
            throw r7
        L6c:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "Failed requirement."
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.f.w(int, z8.d):java.lang.Object");
    }
}
