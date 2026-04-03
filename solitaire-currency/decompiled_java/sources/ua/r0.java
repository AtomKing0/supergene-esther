package ua;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PeekSource.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class r0 implements z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final e f34811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final c f34812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private u0 f34813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f34814d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f34815e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f34816f;

    public r0(@NotNull e upstream) {
        kotlin.jvm.internal.t.i(upstream, "upstream");
        this.f34811a = upstream;
        c cVarG = upstream.g();
        this.f34812b = cVarG;
        u0 u0Var = cVarG.f34738a;
        this.f34813c = u0Var;
        this.f34814d = u0Var != null ? u0Var.f34827b : -1;
    }

    @Override // ua.z0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f34815e = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    @Override // ua.z0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long read(@org.jetbrains.annotations.NotNull ua.c r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.t.i(r9, r0)
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            r3 = 0
            r4 = 1
            if (r2 < 0) goto Lf
            r5 = r4
            goto L10
        Lf:
            r5 = r3
        L10:
            if (r5 == 0) goto L87
            boolean r5 = r8.f34815e
            r5 = r5 ^ r4
            if (r5 == 0) goto L7b
            ua.u0 r5 = r8.f34813c
            if (r5 == 0) goto L2a
            ua.c r6 = r8.f34812b
            ua.u0 r6 = r6.f34738a
            if (r5 != r6) goto L2b
            int r5 = r8.f34814d
            kotlin.jvm.internal.t.f(r6)
            int r6 = r6.f34827b
            if (r5 != r6) goto L2b
        L2a:
            r3 = r4
        L2b:
            if (r3 == 0) goto L6f
            if (r2 != 0) goto L30
            return r0
        L30:
            ua.e r0 = r8.f34811a
            long r1 = r8.f34816f
            r3 = 1
            long r1 = r1 + r3
            boolean r0 = r0.K(r1)
            if (r0 != 0) goto L40
            r9 = -1
            return r9
        L40:
            ua.u0 r0 = r8.f34813c
            if (r0 != 0) goto L53
            ua.c r0 = r8.f34812b
            ua.u0 r0 = r0.f34738a
            if (r0 == 0) goto L53
            r8.f34813c = r0
            kotlin.jvm.internal.t.f(r0)
            int r0 = r0.f34827b
            r8.f34814d = r0
        L53:
            ua.c r0 = r8.f34812b
            long r0 = r0.size()
            long r2 = r8.f34816f
            long r0 = r0 - r2
            long r10 = java.lang.Math.min(r10, r0)
            ua.c r2 = r8.f34812b
            long r4 = r8.f34816f
            r3 = r9
            r6 = r10
            r2.z(r3, r4, r6)
            long r0 = r8.f34816f
            long r0 = r0 + r10
            r8.f34816f = r0
            return r10
        L6f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Peek source is invalid because upstream source was used"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L7b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L87:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "byteCount < 0: "
            r9.append(r0)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ua.r0.read(ua.c, long):long");
    }

    @Override // ua.z0
    @NotNull
    public a1 timeout() {
        return this.f34811a.timeout();
    }
}
