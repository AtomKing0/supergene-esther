package r9;

import kotlin.jvm.internal.o0;
import kotlinx.coroutines.j3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r9.h;
import u9.s0;
import u9.z;
import v8.k0;

/* JADX INFO: compiled from: ConflatedBufferedChannel.kt */
/* JADX INFO: loaded from: classes5.dex */
public class o<E> extends b<E> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f33402m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    private final a f33403n;

    public o(int i10, @NotNull a aVar, @Nullable h9.l<? super E, k0> lVar) {
        super(i10, lVar);
        this.f33402m = i10;
        this.f33403n = aVar;
        if (!(aVar != a.SUSPEND)) {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + o0.b(b.class).getSimpleName() + " instead").toString());
        }
        if (i10 >= 1) {
            return;
        }
        throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i10 + " was specified").toString());
    }

    static /* synthetic */ <E> Object N0(o<E> oVar, E e10, z8.d<? super k0> dVar) throws Throwable {
        s0 s0VarD;
        Object objQ0 = oVar.Q0(e10, true);
        if (!(objQ0 instanceof h.a)) {
            return k0.f35197a;
        }
        h.e(objQ0);
        h9.l<E, k0> lVar = oVar.f33348b;
        if (lVar == null || (s0VarD = z.d(lVar, e10, null, 2, null)) == null) {
            throw oVar.Q();
        }
        v8.f.a(s0VarD, oVar.Q());
        throw s0VarD;
    }

    private final Object O0(E e10, boolean z10) {
        h9.l<E, k0> lVar;
        s0 s0VarD;
        Object objF = super.f(e10);
        if (h.i(objF) || h.h(objF)) {
            return objF;
        }
        if (!z10 || (lVar = this.f33348b) == null || (s0VarD = z.d(lVar, e10, null, 2, null)) == null) {
            return h.f33392b.c(k0.f35197a);
        }
        throw s0VarD;
    }

    private final Object P0(E e10) {
        i iVar;
        Object obj = c.f33372d;
        i iVar2 = (i) b.f33342h.get(this);
        while (true) {
            long andIncrement = b.f33338d.getAndIncrement(this);
            long j10 = andIncrement & 1152921504606846975L;
            boolean zA0 = a0(andIncrement);
            int i10 = c.f33370b;
            long j11 = j10 / ((long) i10);
            int i11 = (int) (j10 % ((long) i10));
            if (iVar2.f34654c != j11) {
                i iVarL = L(j11, iVar2);
                if (iVarL != null) {
                    iVar = iVarL;
                } else if (zA0) {
                    return h.f33392b.a(Q());
                }
            } else {
                iVar = iVar2;
            }
            int iI0 = I0(iVar, i11, e10, j10, obj, zA0);
            if (iI0 == 0) {
                iVar.b();
                return h.f33392b.c(k0.f35197a);
            }
            if (iI0 == 1) {
                return h.f33392b.c(k0.f35197a);
            }
            if (iI0 == 2) {
                if (zA0) {
                    iVar.p();
                    return h.f33392b.a(Q());
                }
                j3 j3Var = obj instanceof j3 ? (j3) obj : null;
                if (j3Var != null) {
                    q0(j3Var, iVar, i11);
                }
                H((iVar.f34654c * ((long) i10)) + ((long) i11));
                return h.f33392b.c(k0.f35197a);
            }
            if (iI0 == 3) {
                throw new IllegalStateException("unexpected".toString());
            }
            if (iI0 == 4) {
                if (j10 < P()) {
                    iVar.b();
                }
                return h.f33392b.a(Q());
            }
            if (iI0 == 5) {
                iVar.b();
            }
            iVar2 = iVar;
        }
    }

    private final Object Q0(E e10, boolean z10) {
        return this.f33403n == a.DROP_LATEST ? O0(e10, z10) : P0(e10);
    }

    @Override // r9.b
    protected boolean b0() {
        return this.f33403n == a.DROP_OLDEST;
    }

    @Override // r9.b, r9.u
    @NotNull
    public Object f(E e10) {
        return Q0(e10, false);
    }

    @Override // r9.b, r9.u
    @Nullable
    public Object p(E e10, @NotNull z8.d<? super k0> dVar) {
        return N0(this, e10, dVar);
    }
}
