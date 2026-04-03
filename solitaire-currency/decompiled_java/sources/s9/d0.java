package s9;

import java.util.Arrays;
import kotlinx.coroutines.g1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;

/* JADX INFO: compiled from: SharedFlow.kt */
/* JADX INFO: loaded from: classes5.dex */
public class d0<T> extends t9.b<f0> implements x<T>, s9.c<T>, t9.p<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f33658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f33659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final r9.a f33660g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private Object[] f33661h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f33662i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f33663j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f33664k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f33665l;

    /* JADX INFO: compiled from: SharedFlow.kt */
    private static final class a implements g1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final d0<?> f33666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f33667b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final Object f33668c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        public final z8.d<v8.k0> f33669d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull d0<?> d0Var, long j10, @Nullable Object obj, @NotNull z8.d<? super v8.k0> dVar) {
            this.f33666a = d0Var;
            this.f33667b = j10;
            this.f33668c = obj;
            this.f33669d = dVar;
        }

        @Override // kotlinx.coroutines.g1
        public void dispose() {
            this.f33666a.y(this);
        }
    }

    /* JADX INFO: compiled from: SharedFlow.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f33670a;

        static {
            int[] iArr = new int[r9.a.values().length];
            try {
                iArr[r9.a.SUSPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[r9.a.DROP_LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[r9.a.DROP_OLDEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f33670a = iArr;
        }
    }

    /* JADX INFO: compiled from: SharedFlow.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", l = {372, 379, 382}, m = "collect$suspendImpl")
    static final class c<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f33671j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f33672k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Object f33673l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Object f33674m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        /* synthetic */ Object f33675n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final /* synthetic */ d0<T> f33676o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        int f33677p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(d0<T> d0Var, z8.d<? super c> dVar) {
            super(dVar);
            this.f33676o = d0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f33675n = obj;
            this.f33677p |= Integer.MIN_VALUE;
            return d0.A(this.f33676o, null, this);
        }
    }

    public d0(int i10, int i11, @NotNull r9.a aVar) {
        this.f33658e = i10;
        this.f33659f = i11;
        this.f33660g = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ <T> java.lang.Object A(s9.d0<T> r8, s9.i<? super T> r9, z8.d<?> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s9.d0.A(s9.d0, s9.i, z8.d):java.lang.Object");
    }

    private final void B(long j10) {
        t9.d[] dVarArr;
        if (((t9.b) this).f34109b != 0 && (dVarArr = ((t9.b) this).f34108a) != null) {
            for (t9.d dVar : dVarArr) {
                if (dVar != null) {
                    f0 f0Var = (f0) dVar;
                    long j11 = f0Var.f33683a;
                    if (j11 >= 0 && j11 < j10) {
                        f0Var.f33683a = j10;
                    }
                }
            }
        }
        this.f33663j = j10;
    }

    private final void E() {
        Object[] objArr = this.f33661h;
        kotlin.jvm.internal.t.f(objArr);
        e0.g(objArr, K(), null);
        this.f33664k--;
        long jK = K() + 1;
        if (this.f33662i < jK) {
            this.f33662i = jK;
        }
        if (this.f33663j < jK) {
            B(jK);
        }
    }

    static /* synthetic */ <T> Object F(d0<T> d0Var, T t10, z8.d<? super v8.k0> dVar) throws Throwable {
        if (d0Var.a(t10)) {
            return v8.k0.f35197a;
        }
        Object objG = d0Var.G(t10, dVar);
        return objG == a9.d.e() ? objG : v8.k0.f35197a;
    }

    private final Object G(T t10, z8.d<? super v8.k0> dVar) throws Throwable {
        z8.d<v8.k0>[] dVarArrI;
        a aVar;
        kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(a9.c.c(dVar), 1);
        pVar.C();
        z8.d<v8.k0>[] dVarArrI2 = t9.c.f34112a;
        synchronized (this) {
            if (R(t10)) {
                t.a aVar2 = v8.t.f35208b;
                pVar.resumeWith(v8.t.b(v8.k0.f35197a));
                dVarArrI = I(dVarArrI2);
                aVar = null;
            } else {
                a aVar3 = new a(this, ((long) P()) + K(), t10, pVar);
                H(aVar3);
                this.f33665l++;
                if (this.f33659f == 0) {
                    dVarArrI2 = I(dVarArrI2);
                }
                dVarArrI = dVarArrI2;
                aVar = aVar3;
            }
        }
        if (aVar != null) {
            kotlinx.coroutines.r.a(pVar, aVar);
        }
        for (z8.d<v8.k0> dVar2 : dVarArrI) {
            if (dVar2 != null) {
                t.a aVar4 = v8.t.f35208b;
                dVar2.resumeWith(v8.t.b(v8.k0.f35197a));
            }
        }
        Object objZ = pVar.z();
        if (objZ == a9.d.e()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ == a9.d.e() ? objZ : v8.k0.f35197a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(Object obj) {
        int iP = P();
        Object[] objArrQ = this.f33661h;
        if (objArrQ == null) {
            objArrQ = Q(null, 0, 2);
        } else if (iP >= objArrQ.length) {
            objArrQ = Q(objArrQ, iP, objArrQ.length * 2);
        }
        e0.g(objArrQ, K() + ((long) iP), obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [z8.d<v8.k0>[]] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r6v3 */
    public final z8.d<v8.k0>[] I(z8.d<v8.k0>[] dVarArr) {
        t9.d[] dVarArr2;
        f0 f0Var;
        z8.d<? super v8.k0> dVar;
        int length = dVarArr.length;
        if (((t9.b) this).f34109b != 0 && (dVarArr2 = ((t9.b) this).f34108a) != null) {
            int length2 = dVarArr2.length;
            int i10 = 0;
            dVarArr = dVarArr;
            while (i10 < length2) {
                t9.d dVar2 = dVarArr2[i10];
                if (dVar2 != null && (dVar = (f0Var = (f0) dVar2).f33684b) != null && T(f0Var) >= 0) {
                    int length3 = dVarArr.length;
                    dVarArr = dVarArr;
                    if (length >= length3) {
                        Object[] objArrCopyOf = Arrays.copyOf((Object[]) dVarArr, Math.max(2, dVarArr.length * 2));
                        kotlin.jvm.internal.t.h(objArrCopyOf, "copyOf(this, newSize)");
                        dVarArr = objArrCopyOf;
                    }
                    ((z8.d[]) dVarArr)[length] = dVar;
                    f0Var.f33684b = null;
                    length++;
                }
                i10++;
                dVarArr = dVarArr;
            }
        }
        return (z8.d[]) dVarArr;
    }

    private final long J() {
        return K() + ((long) this.f33664k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long K() {
        return Math.min(this.f33663j, this.f33662i);
    }

    private final Object M(long j10) {
        Object[] objArr = this.f33661h;
        kotlin.jvm.internal.t.f(objArr);
        Object objF = e0.f(objArr, j10);
        return objF instanceof a ? ((a) objF).f33668c : objF;
    }

    private final long N() {
        return K() + ((long) this.f33664k) + ((long) this.f33665l);
    }

    private final int O() {
        return (int) ((K() + ((long) this.f33664k)) - this.f33662i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int P() {
        return this.f33664k + this.f33665l;
    }

    private final Object[] Q(Object[] objArr, int i10, int i11) {
        if (!(i11 > 0)) {
            throw new IllegalStateException("Buffer size overflow".toString());
        }
        Object[] objArr2 = new Object[i11];
        this.f33661h = objArr2;
        if (objArr == null) {
            return objArr2;
        }
        long jK = K();
        for (int i12 = 0; i12 < i10; i12++) {
            long j10 = ((long) i12) + jK;
            e0.g(objArr2, j10, e0.f(objArr, j10));
        }
        return objArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean R(T t10) {
        if (l() == 0) {
            return S(t10);
        }
        if (this.f33664k >= this.f33659f && this.f33663j <= this.f33662i) {
            int i10 = b.f33670a[this.f33660g.ordinal()];
            if (i10 == 1) {
                return false;
            }
            if (i10 == 2) {
                return true;
            }
        }
        H(t10);
        int i11 = this.f33664k + 1;
        this.f33664k = i11;
        if (i11 > this.f33659f) {
            E();
        }
        if (O() > this.f33658e) {
            V(this.f33662i + 1, this.f33663j, J(), N());
        }
        return true;
    }

    private final boolean S(T t10) {
        if (this.f33658e == 0) {
            return true;
        }
        H(t10);
        int i10 = this.f33664k + 1;
        this.f33664k = i10;
        if (i10 > this.f33658e) {
            E();
        }
        this.f33663j = K() + ((long) this.f33664k);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long T(f0 f0Var) {
        long j10 = f0Var.f33683a;
        if (j10 < J()) {
            return j10;
        }
        if (this.f33659f <= 0 && j10 <= K() && this.f33665l != 0) {
            return j10;
        }
        return -1L;
    }

    private final Object U(f0 f0Var) {
        Object obj;
        z8.d<v8.k0>[] dVarArrW = t9.c.f34112a;
        synchronized (this) {
            long jT = T(f0Var);
            if (jT < 0) {
                obj = e0.f33681a;
            } else {
                long j10 = f0Var.f33683a;
                Object objM = M(jT);
                f0Var.f33683a = jT + 1;
                dVarArrW = W(j10);
                obj = objM;
            }
        }
        for (z8.d<v8.k0> dVar : dVarArrW) {
            if (dVar != null) {
                t.a aVar = v8.t.f35208b;
                dVar.resumeWith(v8.t.b(v8.k0.f35197a));
            }
        }
        return obj;
    }

    private final void V(long j10, long j11, long j12, long j13) {
        long jMin = Math.min(j11, j10);
        for (long jK = K(); jK < jMin; jK++) {
            Object[] objArr = this.f33661h;
            kotlin.jvm.internal.t.f(objArr);
            e0.g(objArr, jK, null);
        }
        this.f33662i = j10;
        this.f33663j = j11;
        this.f33664k = (int) (j12 - jMin);
        this.f33665l = (int) (j13 - j12);
    }

    private final Object x(f0 f0Var, z8.d<? super v8.k0> dVar) throws Throwable {
        kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(a9.c.c(dVar), 1);
        pVar.C();
        synchronized (this) {
            if (T(f0Var) < 0) {
                f0Var.f33684b = pVar;
            } else {
                t.a aVar = v8.t.f35208b;
                pVar.resumeWith(v8.t.b(v8.k0.f35197a));
            }
            v8.k0 k0Var = v8.k0.f35197a;
        }
        Object objZ = pVar.z();
        if (objZ == a9.d.e()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ == a9.d.e() ? objZ : v8.k0.f35197a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(a aVar) {
        synchronized (this) {
            if (aVar.f33667b < K()) {
                return;
            }
            Object[] objArr = this.f33661h;
            kotlin.jvm.internal.t.f(objArr);
            if (e0.f(objArr, aVar.f33667b) != aVar) {
                return;
            }
            e0.g(objArr, aVar.f33667b, e0.f33681a);
            z();
            v8.k0 k0Var = v8.k0.f35197a;
        }
    }

    private final void z() {
        if (this.f33659f != 0 || this.f33665l > 1) {
            Object[] objArr = this.f33661h;
            kotlin.jvm.internal.t.f(objArr);
            while (this.f33665l > 0 && e0.f(objArr, (K() + ((long) P())) - 1) == e0.f33681a) {
                this.f33665l--;
                e0.g(objArr, K() + ((long) P()), null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // t9.b
    @NotNull
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public f0 i() {
        return new f0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // t9.b
    @NotNull
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public f0[] j(int i10) {
        return new f0[i10];
    }

    protected final T L() {
        Object[] objArr = this.f33661h;
        kotlin.jvm.internal.t.f(objArr);
        return (T) e0.f(objArr, (this.f33662i + ((long) O())) - 1);
    }

    @NotNull
    public final z8.d<v8.k0>[] W(long j10) {
        long j11;
        long j12;
        long j13;
        t9.d[] dVarArr;
        if (j10 > this.f33663j) {
            return t9.c.f34112a;
        }
        long jK = K();
        long j14 = ((long) this.f33664k) + jK;
        if (this.f33659f == 0 && this.f33665l > 0) {
            j14++;
        }
        if (((t9.b) this).f34109b != 0 && (dVarArr = ((t9.b) this).f34108a) != null) {
            for (t9.d dVar : dVarArr) {
                if (dVar != null) {
                    long j15 = ((f0) dVar).f33683a;
                    if (j15 >= 0 && j15 < j14) {
                        j14 = j15;
                    }
                }
            }
        }
        if (j14 <= this.f33663j) {
            return t9.c.f34112a;
        }
        long J = J();
        int iMin = l() > 0 ? Math.min(this.f33665l, this.f33659f - ((int) (J - j14))) : this.f33665l;
        z8.d<v8.k0>[] dVarArr2 = t9.c.f34112a;
        long j16 = ((long) this.f33665l) + J;
        if (iMin > 0) {
            dVarArr2 = new z8.d[iMin];
            Object[] objArr = this.f33661h;
            kotlin.jvm.internal.t.f(objArr);
            long j17 = J;
            int i10 = 0;
            while (true) {
                if (J >= j16) {
                    j11 = j14;
                    j12 = j16;
                    break;
                }
                Object objF = e0.f(objArr, J);
                j11 = j14;
                u9.h0 h0Var = e0.f33681a;
                if (objF != h0Var) {
                    kotlin.jvm.internal.t.g(objF, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    a aVar = (a) objF;
                    int i11 = i10 + 1;
                    j12 = j16;
                    dVarArr2[i10] = aVar.f33669d;
                    e0.g(objArr, J, h0Var);
                    e0.g(objArr, j17, aVar.f33668c);
                    j13 = 1;
                    j17++;
                    if (i11 >= iMin) {
                        break;
                    }
                    i10 = i11;
                } else {
                    j12 = j16;
                    j13 = 1;
                }
                J += j13;
                j14 = j11;
                j16 = j12;
            }
            J = j17;
        } else {
            j11 = j14;
            j12 = j16;
        }
        int i12 = (int) (J - jK);
        long j18 = l() == 0 ? J : j11;
        long jMax = Math.max(this.f33662i, J - ((long) Math.min(this.f33658e, i12)));
        if (this.f33659f == 0 && jMax < j12) {
            Object[] objArr2 = this.f33661h;
            kotlin.jvm.internal.t.f(objArr2);
            if (kotlin.jvm.internal.t.d(e0.f(objArr2, jMax), e0.f33681a)) {
                J++;
                jMax++;
            }
        }
        V(jMax, j18, J, j12);
        z();
        return (dVarArr2.length == 0) ^ true ? I(dVarArr2) : dVarArr2;
    }

    public final long X() {
        long j10 = this.f33662i;
        if (j10 < this.f33663j) {
            this.f33663j = j10;
        }
        return j10;
    }

    @Override // s9.x
    public boolean a(T t10) {
        int i10;
        boolean z10;
        z8.d<v8.k0>[] dVarArrI = t9.c.f34112a;
        synchronized (this) {
            if (R(t10)) {
                dVarArrI = I(dVarArrI);
                z10 = true;
            } else {
                z10 = false;
            }
        }
        for (z8.d<v8.k0> dVar : dVarArrI) {
            if (dVar != null) {
                t.a aVar = v8.t.f35208b;
                dVar.resumeWith(v8.t.b(v8.k0.f35197a));
            }
        }
        return z10;
    }

    @Override // t9.p
    @NotNull
    public h<T> b(@NotNull z8.g gVar, int i10, @NotNull r9.a aVar) {
        return e0.e(this, gVar, i10, aVar);
    }

    @Override // s9.c0, s9.h
    @Nullable
    public Object collect(@NotNull i<? super T> iVar, @NotNull z8.d<?> dVar) {
        return A(this, iVar, dVar);
    }

    @Override // s9.x
    public void e() {
        synchronized (this) {
            V(J(), this.f33663j, J(), N());
            v8.k0 k0Var = v8.k0.f35197a;
        }
    }

    @Override // s9.x, s9.i
    @Nullable
    public Object emit(T t10, @NotNull z8.d<? super v8.k0> dVar) {
        return F(this, t10, dVar);
    }
}
