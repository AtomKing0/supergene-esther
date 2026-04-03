package p8;

import java.io.Closeable;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q8.a;

/* JADX INFO: compiled from: Input.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class m implements Closeable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f32934h = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final s8.g<q8.a> f32935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private q8.a f32936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private ByteBuffer f32937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f32938d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f32939e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f32940f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f32941g;

    /* JADX INFO: compiled from: Input.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public m() {
        this(null, 0L, null, 7, null);
    }

    private final int B(int i10, int i11) {
        while (i10 != 0) {
            q8.a aVarU0 = U0(1);
            if (aVarU0 == null) {
                return i11;
            }
            int iMin = Math.min(aVarU0.j() - aVarU0.h(), i10);
            aVarU0.c(iMin);
            this.f32938d += iMin;
            a(aVarU0);
            i10 -= iMin;
            i11 += iMin;
        }
        return i11;
    }

    private final void G0(q8.a aVar) {
        if (this.f32941g && aVar.x() == null) {
            this.f32938d = aVar.h();
            this.f32939e = aVar.j();
            d1(0L);
            return;
        }
        int iJ = aVar.j() - aVar.h();
        int iMin = Math.min(iJ, 8 - (aVar.e() - aVar.f()));
        if (iJ > iMin) {
            I0(aVar, iJ, iMin);
        } else {
            q8.a aVarK0 = this.f32935a.k0();
            aVarK0.o(8);
            aVarK0.C(aVar.w());
            b.a(aVarK0, aVar, iJ);
            e1(aVarK0);
        }
        aVar.A(this.f32935a);
    }

    private final void I0(q8.a aVar, int i10, int i11) {
        q8.a aVarK0 = this.f32935a.k0();
        q8.a aVarK02 = this.f32935a.k0();
        aVarK0.o(8);
        aVarK02.o(8);
        aVarK0.C(aVarK02);
        aVarK02.C(aVar.w());
        b.a(aVarK0, aVar, i10 - i11);
        b.a(aVarK02, aVar, i11);
        e1(aVarK0);
        d1(h.c(aVarK02));
    }

    private final q8.a L() {
        if (this.f32941g) {
            return null;
        }
        q8.a aVarW = W();
        if (aVarW == null) {
            this.f32941g = true;
            return null;
        }
        i(aVarW);
        return aVarW;
    }

    private final q8.a R(q8.a aVar, q8.a aVar2) {
        while (aVar != aVar2) {
            q8.a aVarW = aVar.w();
            aVar.A(this.f32935a);
            if (aVarW == null) {
                e1(aVar2);
                d1(0L);
                aVar = aVar2;
            } else {
                if (aVarW.j() > aVarW.h()) {
                    e1(aVarW);
                    d1(this.f32940f - ((long) (aVarW.j() - aVarW.h())));
                    return aVarW;
                }
                aVar = aVarW;
            }
        }
        return L();
    }

    private final Void R0(int i10, int i11) {
        throw new IllegalArgumentException("min should be less or equal to max but min = " + i10 + ", max = " + i11);
    }

    private final Void S0(int i10) {
        throw new IllegalStateException("minSize of " + i10 + " is too big (should be less than 8)");
    }

    private final Void T0(int i10, int i11) throws q8.d {
        throw new q8.d("Premature end of stream: expected at least " + i10 + " chars but had only " + i11);
    }

    private final q8.a W0(int i10, q8.a aVar) {
        while (true) {
            int iL0 = L0() - N0();
            if (iL0 >= i10) {
                return aVar;
            }
            q8.a aVarX = aVar.x();
            if (aVarX == null && (aVarX = L()) == null) {
                return null;
            }
            if (iL0 == 0) {
                if (aVar != q8.a.f33167j.a()) {
                    b1(aVar);
                }
                aVar = aVarX;
            } else {
                int iA = b.a(aVar, aVarX, i10 - iL0);
                this.f32939e = aVar.j();
                d1(this.f32940f - ((long) iA));
                if (aVarX.j() > aVarX.h()) {
                    aVarX.p(iA);
                } else {
                    aVar.C(null);
                    aVar.C(aVarX.w());
                    aVarX.A(this.f32935a);
                }
                if (aVar.j() - aVar.h() >= i10) {
                    return aVar;
                }
                if (i10 > 8) {
                    S0(i10);
                    throw new v8.h();
                }
            }
        }
    }

    private final int X0(Appendable appendable, int i10, int i11) throws Throwable {
        int i12;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13 = false;
        if (i11 == 0 && i10 == 0) {
            return 0;
        }
        if (J0()) {
            if (i10 == 0) {
                return 0;
            }
            n(i10);
            throw new v8.h();
        }
        if (i11 < i10) {
            R0(i10, i11);
            throw new v8.h();
        }
        q8.a aVarB = q8.g.b(this, 1);
        if (aVarB == null) {
            i12 = 0;
        } else {
            i12 = 0;
            boolean z14 = false;
            while (true) {
                try {
                    ByteBuffer byteBufferG = aVarB.g();
                    int iH = aVarB.h();
                    int iJ = aVarB.j();
                    for (int i13 = iH; i13 < iJ; i13++) {
                        int i14 = byteBufferG.get(i13) & 255;
                        if ((i14 & 128) != 128) {
                            char c10 = (char) i14;
                            if (i12 == i11) {
                                z12 = false;
                            } else {
                                appendable.append(c10);
                                i12++;
                                z12 = true;
                            }
                            if (z12) {
                            }
                        }
                        aVarB.c(i13 - iH);
                        z10 = false;
                        break;
                    }
                    aVarB.c(iJ - iH);
                    z10 = true;
                    if (z10) {
                        z11 = true;
                    } else if (i12 == i11) {
                        z11 = false;
                    } else {
                        z11 = false;
                        z14 = true;
                    }
                    if (!z11) {
                        z13 = true;
                        break;
                    }
                    try {
                        q8.a aVarC = q8.g.c(this, aVarB);
                        if (aVarC == null) {
                            break;
                        }
                        aVarB = aVarC;
                    } catch (Throwable th) {
                        th = th;
                        if (z13) {
                            q8.g.a(this, aVarB);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z13 = true;
                }
            }
            if (z13) {
                q8.g.a(this, aVarB);
            }
            z13 = z14;
        }
        if (z13) {
            return i12 + a1(appendable, i10 - i12, i11 - i12);
        }
        if (i12 >= i10) {
            return i12;
        }
        T0(i10, i12);
        throw new v8.h();
    }

    public static /* synthetic */ String Z0(m mVar, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readText");
        }
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = Integer.MAX_VALUE;
        }
        return mVar.Y0(i10, i11);
    }

    private final void a(q8.a aVar) {
        if (aVar.j() - aVar.h() == 0) {
            b1(aVar);
        }
    }

    private final int a1(Appendable appendable, int i10, int i11) throws Throwable {
        int i12;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        q8.a aVarC;
        int i13;
        boolean z14 = true;
        q8.a aVarB = q8.g.b(this, 1);
        if (aVarB == null) {
            i13 = 0;
        } else {
            int i14 = 1;
            int i15 = 0;
            while (true) {
                try {
                    int iJ = aVarB.j() - aVarB.h();
                    if (iJ >= i14) {
                        try {
                            ByteBuffer byteBufferG = aVarB.g();
                            int iH = aVarB.h();
                            int iJ2 = aVarB.j();
                            int i16 = iH;
                            int i17 = 0;
                            int i18 = 0;
                            int i19 = 0;
                            while (true) {
                                if (i16 >= iJ2) {
                                    aVarB.c(iJ2 - iH);
                                    i12 = 0;
                                    break;
                                }
                                int i20 = byteBufferG.get(i16) & 255;
                                i12 = -1;
                                if ((i20 & 128) == 0) {
                                    if (i17 != 0) {
                                        q8.f.i(i17);
                                        throw new v8.h();
                                    }
                                    char c10 = (char) i20;
                                    if (i15 == i11) {
                                        z13 = false;
                                    } else {
                                        appendable.append(c10);
                                        i15++;
                                        z13 = true;
                                    }
                                    if (!z13) {
                                        aVarB.c(i16 - iH);
                                        break;
                                    }
                                    i16++;
                                } else if (i17 == 0) {
                                    int i21 = 128;
                                    i18 = i20;
                                    for (int i22 = 1; i22 < 7 && (i18 & i21) != 0; i22++) {
                                        i18 &= ~i21;
                                        i21 >>= 1;
                                        i17++;
                                    }
                                    int i23 = i17 - 1;
                                    if (i17 > iJ2 - i16) {
                                        aVarB.c(i16 - iH);
                                        i12 = i17;
                                        break;
                                    }
                                    i19 = i17;
                                    i17 = i23;
                                    i16++;
                                } else {
                                    i18 = (i20 & 127) | (i18 << 6);
                                    i17--;
                                    if (i17 != 0) {
                                        continue;
                                    } else if (q8.f.f(i18)) {
                                        char c11 = (char) i18;
                                        if (i15 == i11) {
                                            z12 = false;
                                        } else {
                                            appendable.append(c11);
                                            i15++;
                                            z12 = true;
                                        }
                                        if (!z12) {
                                            aVarB.c(((i16 - iH) - i19) + 1);
                                            break;
                                        }
                                        i18 = 0;
                                    } else {
                                        if (!q8.f.g(i18)) {
                                            q8.f.j(i18);
                                            throw new v8.h();
                                        }
                                        char cE = (char) q8.f.e(i18);
                                        if (i15 == i11) {
                                            z10 = false;
                                        } else {
                                            appendable.append(cE);
                                            i15++;
                                            z10 = true;
                                        }
                                        if (!z10) {
                                            break;
                                        }
                                        char cH = (char) q8.f.h(i18);
                                        if (i15 == i11) {
                                            z11 = false;
                                        } else {
                                            appendable.append(cH);
                                            i15++;
                                            z11 = true;
                                        }
                                        if (!z11) {
                                            break;
                                        }
                                        i18 = 0;
                                    }
                                    i16++;
                                }
                            }
                            aVarB.c(((i16 - iH) - i19) + 1);
                            i14 = i12 == 0 ? 1 : i12 > 0 ? i12 : 0;
                            iJ = aVarB.j() - aVarB.h();
                        } finally {
                            aVarB.j();
                            aVarB.h();
                        }
                    }
                    if (iJ == 0) {
                        try {
                            aVarC = q8.g.c(this, aVarB);
                        } catch (Throwable th) {
                            th = th;
                            z14 = false;
                            if (z14) {
                                q8.g.a(this, aVarB);
                            }
                            throw th;
                        }
                    } else if (iJ < i14 || aVarB.e() - aVarB.f() < 8) {
                        q8.g.a(this, aVarB);
                        aVarC = q8.g.b(this, i14);
                    } else {
                        aVarC = aVarB;
                    }
                    if (aVarC == null) {
                        z14 = false;
                        break;
                    }
                    aVarB = aVarC;
                    if (i14 <= 0) {
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (z14) {
                q8.g.a(this, aVarB);
            }
            i13 = i15;
        }
        if (i13 >= i10) {
            return i13;
        }
        T0(i10, i13);
        throw new v8.h();
    }

    private final void e1(q8.a aVar) {
        this.f32936b = aVar;
        this.f32937c = aVar.g();
        this.f32938d = aVar.h();
        this.f32939e = aVar.j();
    }

    private final void i(q8.a aVar) {
        q8.a aVarA = h.a(this.f32936b);
        if (aVarA != q8.a.f33167j.a()) {
            aVarA.C(aVar);
            d1(this.f32940f + h.c(aVar));
            return;
        }
        e1(aVar);
        if (!(this.f32940f == 0)) {
            throw new IllegalStateException("It should be no tail remaining bytes if current tail is EmptyBuffer");
        }
        q8.a aVarX = aVar.x();
        d1(aVarX != null ? h.c(aVarX) : 0L);
    }

    private final Void n(int i10) throws EOFException {
        throw new EOFException("at least " + i10 + " characters required but no bytes available");
    }

    public final void J(int i10) throws EOFException {
        if (z(i10) == i10) {
            return;
        }
        throw new EOFException("Unable to discard " + i10 + " bytes due to end of packet");
    }

    public final boolean J0() {
        return L0() - N0() == 0 && this.f32940f == 0 && (this.f32941g || L() == null);
    }

    @NotNull
    public final q8.a K0() {
        q8.a aVar = this.f32936b;
        aVar.d(this.f32938d);
        return aVar;
    }

    public final int L0() {
        return this.f32939e;
    }

    @NotNull
    public final ByteBuffer M0() {
        return this.f32937c;
    }

    public final int N0() {
        return this.f32938d;
    }

    @Nullable
    public final q8.a O(@NotNull q8.a current) {
        t.i(current, "current");
        return R(current, q8.a.f33167j.a());
    }

    @NotNull
    public final s8.g<q8.a> O0() {
        return this.f32935a;
    }

    public final long P0() {
        return ((long) (L0() - N0())) + this.f32940f;
    }

    protected final void Q0() {
        if (this.f32941g) {
            return;
        }
        this.f32941g = true;
    }

    @Nullable
    public final q8.a S(@NotNull q8.a current) {
        t.i(current, "current");
        return O(current);
    }

    @Nullable
    public final q8.a U0(int i10) {
        q8.a aVarK0 = K0();
        return this.f32939e - this.f32938d >= i10 ? aVarK0 : W0(i10, aVarK0);
    }

    @Nullable
    public final q8.a V0(int i10) {
        return W0(i10, K0());
    }

    @Nullable
    protected q8.a W() {
        q8.a aVarK0 = this.f32935a.k0();
        try {
            aVarK0.o(8);
            int iH0 = h0(aVarK0.g(), aVarK0.j(), aVarK0.f() - aVarK0.j());
            if (iH0 == 0) {
                boolean z10 = true;
                this.f32941g = true;
                if (aVarK0.j() <= aVarK0.h()) {
                    z10 = false;
                }
                if (!z10) {
                    aVarK0.A(this.f32935a);
                    return null;
                }
            }
            aVarK0.a(iH0);
            return aVarK0;
        } catch (Throwable th) {
            aVarK0.A(this.f32935a);
            throw th;
        }
    }

    @NotNull
    public final String Y0(int i10, int i11) throws Throwable {
        if (i10 == 0 && (i11 == 0 || J0())) {
            return "";
        }
        long jP0 = P0();
        if (jP0 > 0 && i11 >= jP0) {
            return s.g(this, (int) jP0, null, 2, null);
        }
        StringBuilder sb = new StringBuilder(n9.o.j(n9.o.e(i10, 16), i11));
        X0(sb, i10, i11);
        String string = sb.toString();
        t.h(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    @NotNull
    public final q8.a b1(@NotNull q8.a head) {
        t.i(head, "head");
        q8.a aVarW = head.w();
        if (aVarW == null) {
            aVarW = q8.a.f33167j.a();
        }
        e1(aVarW);
        d1(this.f32940f - ((long) (aVarW.j() - aVarW.h())));
        head.A(this.f32935a);
        return aVarW;
    }

    public final void c(@NotNull q8.a chain) {
        t.i(chain, "chain");
        a.d dVar = q8.a.f33167j;
        if (chain == dVar.a()) {
            return;
        }
        long jC = h.c(chain);
        if (this.f32936b == dVar.a()) {
            e1(chain);
            d1(jC - ((long) (L0() - N0())));
        } else {
            h.a(this.f32936b).C(chain);
            d1(this.f32940f + jC);
        }
    }

    public final void c1(int i10) {
        this.f32938d = i10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        release();
        if (!this.f32941g) {
            this.f32941g = true;
        }
        x();
    }

    public final void d1(long j10) {
        if (j10 >= 0) {
            this.f32940f = j10;
            return;
        }
        throw new IllegalArgumentException(("tailRemaining shouldn't be negative: " + j10).toString());
    }

    @Nullable
    public final q8.a f1() {
        q8.a aVarK0 = K0();
        q8.a aVarX = aVarK0.x();
        q8.a aVarA = q8.a.f33167j.a();
        if (aVarK0 == aVarA) {
            return null;
        }
        if (aVarX == null) {
            e1(aVarA);
            d1(0L);
        } else {
            e1(aVarX);
            d1(this.f32940f - ((long) (aVarX.j() - aVarX.h())));
        }
        aVarK0.C(null);
        return aVarK0;
    }

    @Nullable
    public final q8.a g1() {
        q8.a aVarK0 = K0();
        q8.a aVarA = q8.a.f33167j.a();
        if (aVarK0 == aVarA) {
            return null;
        }
        e1(aVarA);
        d1(0L);
        return aVarK0;
    }

    protected abstract int h0(@NotNull ByteBuffer byteBuffer, int i10, int i11);

    public final boolean h1(@NotNull q8.a chain) {
        t.i(chain, "chain");
        q8.a aVarA = h.a(K0());
        int iJ = chain.j() - chain.h();
        if (iJ == 0 || aVarA.f() - aVarA.j() < iJ) {
            return false;
        }
        b.a(aVarA, chain, iJ);
        if (K0() == aVarA) {
            this.f32939e = aVarA.j();
            return true;
        }
        d1(this.f32940f + ((long) iJ));
        return true;
    }

    public final void i0(@NotNull q8.a current) {
        t.i(current, "current");
        q8.a aVarX = current.x();
        if (aVarX == null) {
            G0(current);
            return;
        }
        int iJ = current.j() - current.h();
        int iMin = Math.min(iJ, 8 - (current.e() - current.f()));
        if (aVarX.i() < iMin) {
            G0(current);
            return;
        }
        d.f(aVarX, iMin);
        if (iJ > iMin) {
            current.l();
            this.f32939e = current.j();
            d1(this.f32940f + ((long) iMin));
        } else {
            e1(aVarX);
            d1(this.f32940f - ((long) ((aVarX.j() - aVarX.h()) - iMin)));
            current.w();
            current.A(this.f32935a);
        }
    }

    public final boolean q() {
        return (this.f32938d == this.f32939e && this.f32940f == 0) ? false : true;
    }

    public final void release() {
        q8.a aVarK0 = K0();
        q8.a aVarA = q8.a.f33167j.a();
        if (aVarK0 != aVarA) {
            e1(aVarA);
            d1(0L);
            h.b(aVarK0, this.f32935a);
        }
    }

    protected abstract void x();

    public final int z(int i10) {
        if (i10 >= 0) {
            return B(i10, 0);
        }
        throw new IllegalArgumentException(("Negative discard is not allowed: " + i10).toString());
    }

    public m(@NotNull q8.a head, long j10, @NotNull s8.g<q8.a> pool) {
        t.i(head, "head");
        t.i(pool, "pool");
        this.f32935a = pool;
        this.f32936b = head;
        this.f32937c = head.g();
        this.f32938d = head.h();
        int iJ = head.j();
        this.f32939e = iJ;
        this.f32940f = j10 - ((long) (iJ - this.f32938d));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ m(q8.a aVar, long j10, s8.g gVar, int i10, kotlin.jvm.internal.k kVar) {
        aVar = (i10 & 1) != 0 ? q8.a.f33167j.a() : aVar;
        this(aVar, (i10 & 2) != 0 ? h.c(aVar) : j10, (i10 & 4) != 0 ? q8.a.f33167j.c() : gVar);
    }
}
