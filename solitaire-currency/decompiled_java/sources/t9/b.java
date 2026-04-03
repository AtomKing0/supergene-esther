package t9;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;
import t9.d;
import v8.k0;
import v8.t;

/* JADX INFO: compiled from: AbstractSharedFlow.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b<S extends d<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private S[] f34108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f34109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f34110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private y f34111d;

    @NotNull
    public final m0<Integer> c() {
        y yVar;
        synchronized (this) {
            yVar = this.f34111d;
            if (yVar == null) {
                yVar = new y(this.f34109b);
                this.f34111d = yVar;
            }
        }
        return yVar;
    }

    @NotNull
    protected final S h() {
        S s10;
        y yVar;
        synchronized (this) {
            S[] sArr = this.f34108a;
            if (sArr == null) {
                sArr = (S[]) j(2);
                this.f34108a = sArr;
            } else if (this.f34109b >= sArr.length) {
                Object[] objArrCopyOf = Arrays.copyOf(sArr, sArr.length * 2);
                kotlin.jvm.internal.t.h(objArrCopyOf, "copyOf(this, newSize)");
                this.f34108a = (S[]) ((d[]) objArrCopyOf);
                sArr = (S[]) ((d[]) objArrCopyOf);
            }
            int i10 = this.f34110c;
            do {
                s10 = sArr[i10];
                if (s10 == null) {
                    s10 = (S) i();
                    sArr[i10] = s10;
                }
                i10++;
                if (i10 >= sArr.length) {
                    i10 = 0;
                }
                kotlin.jvm.internal.t.g(s10, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            } while (!s10.a(this));
            this.f34110c = i10;
            this.f34109b++;
            yVar = this.f34111d;
        }
        if (yVar != null) {
            yVar.Z(1);
        }
        return s10;
    }

    @NotNull
    protected abstract S i();

    @NotNull
    protected abstract S[] j(int i10);

    protected final void k(@NotNull S s10) {
        y yVar;
        int i10;
        z8.d<k0>[] dVarArrB;
        synchronized (this) {
            int i11 = this.f34109b - 1;
            this.f34109b = i11;
            yVar = this.f34111d;
            if (i11 == 0) {
                this.f34110c = 0;
            }
            kotlin.jvm.internal.t.g(s10, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            dVarArrB = s10.b(this);
        }
        for (z8.d<k0> dVar : dVarArrB) {
            if (dVar != null) {
                t.a aVar = v8.t.f35208b;
                dVar.resumeWith(v8.t.b(k0.f35197a));
            }
        }
        if (yVar != null) {
            yVar.Z(-1);
        }
    }

    protected final int l() {
        return this.f34109b;
    }

    @Nullable
    protected final S[] m() {
        return this.f34108a;
    }
}
