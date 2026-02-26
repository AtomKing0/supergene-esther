package r9;

import java.util.concurrent.atomic.AtomicReferenceArray;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u9.e0;

/* JADX INFO: compiled from: BufferedChannel.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class i<E> extends e0<i<E>> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final b<E> f33396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final AtomicReferenceArray f33397f;

    public i(long j10, @Nullable i<E> iVar, @Nullable b<E> bVar, int i10) {
        super(j10, iVar, i10);
        this.f33396e = bVar;
        this.f33397f = new AtomicReferenceArray(c.f33370b * 2);
    }

    private final void z(int i10, Object obj) {
        this.f33397f.lazySet(i10 * 2, obj);
    }

    public final void A(int i10, @Nullable Object obj) {
        this.f33397f.set((i10 * 2) + 1, obj);
    }

    public final void B(int i10, E e10) {
        z(i10, e10);
    }

    @Override // u9.e0
    public int n() {
        return c.f33370b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0063, code lost:
    
        s(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0066, code lost:
    
        if (r0 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0068, code lost:
    
        r4 = u().f33348b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006e, code lost:
    
        if (r4 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0070, code lost:
    
        u9.z.b(r4, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0073, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
    
        return;
     */
    @Override // u9.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void o(int r4, @org.jetbrains.annotations.Nullable java.lang.Throwable r5, @org.jetbrains.annotations.NotNull z8.g r6) {
        /*
            r3 = this;
            int r5 = r9.c.f33370b
            if (r4 < r5) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r4 = r4 - r5
        La:
            java.lang.Object r5 = r3.v(r4)
        Le:
            java.lang.Object r1 = r3.w(r4)
            boolean r2 = r1 instanceof kotlinx.coroutines.j3
            if (r2 != 0) goto L74
            boolean r2 = r1 instanceof r9.v
            if (r2 == 0) goto L1b
            goto L74
        L1b:
            u9.h0 r2 = r9.c.j()
            if (r1 == r2) goto L63
            u9.h0 r2 = r9.c.i()
            if (r1 != r2) goto L28
            goto L63
        L28:
            u9.h0 r2 = r9.c.p()
            if (r1 == r2) goto Le
            u9.h0 r2 = r9.c.q()
            if (r1 != r2) goto L35
            goto Le
        L35:
            u9.h0 r4 = r9.c.f()
            if (r1 == r4) goto L62
            u9.h0 r4 = r9.c.f33372d
            if (r1 != r4) goto L40
            goto L62
        L40:
            u9.h0 r4 = r9.c.z()
            if (r1 != r4) goto L47
            return
        L47:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "unexpected state: "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L62:
            return
        L63:
            r3.s(r4)
            if (r0 == 0) goto L73
            r9.b r4 = r3.u()
            h9.l<E, v8.k0> r4 = r4.f33348b
            if (r4 == 0) goto L73
            u9.z.b(r4, r5, r6)
        L73:
            return
        L74:
            if (r0 == 0) goto L7b
            u9.h0 r2 = r9.c.j()
            goto L7f
        L7b:
            u9.h0 r2 = r9.c.i()
        L7f:
            boolean r1 = r3.r(r4, r1, r2)
            if (r1 == 0) goto Le
            r3.s(r4)
            r1 = r0 ^ 1
            r3.x(r4, r1)
            if (r0 == 0) goto L9a
            r9.b r4 = r3.u()
            h9.l<E, v8.k0> r4 = r4.f33348b
            if (r4 == 0) goto L9a
            u9.z.b(r4, r5, r6)
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: r9.i.o(int, java.lang.Throwable, z8.g):void");
    }

    public final boolean r(int i10, @Nullable Object obj, @Nullable Object obj2) {
        return s8.c.a(this.f33397f, (i10 * 2) + 1, obj, obj2);
    }

    public final void s(int i10) {
        z(i10, null);
    }

    @Nullable
    public final Object t(int i10, @Nullable Object obj) {
        return this.f33397f.getAndSet((i10 * 2) + 1, obj);
    }

    @NotNull
    public final b<E> u() {
        b<E> bVar = this.f33396e;
        kotlin.jvm.internal.t.f(bVar);
        return bVar;
    }

    public final E v(int i10) {
        return (E) this.f33397f.get(i10 * 2);
    }

    @Nullable
    public final Object w(int i10) {
        return this.f33397f.get((i10 * 2) + 1);
    }

    public final void x(int i10, boolean z10) {
        if (z10) {
            u().M0((this.f34654c * ((long) c.f33370b)) + ((long) i10));
        }
        p();
    }

    public final E y(int i10) {
        E eV = v(i10);
        s(i10);
        return eV;
    }
}
