package s9;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SharedFlow.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final u9.h0 f33681a = new u9.h0("NO_VALUE");

    @NotNull
    public static final <T> x<T> a(int i10, int i11, @NotNull r9.a aVar) {
        boolean z10 = true;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("replay cannot be negative, but was " + i10).toString());
        }
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException(("extraBufferCapacity cannot be negative, but was " + i11).toString());
        }
        if (i10 <= 0 && i11 <= 0 && aVar != r9.a.SUSPEND) {
            z10 = false;
        }
        if (z10) {
            int i12 = i11 + i10;
            if (i12 < 0) {
                i12 = Integer.MAX_VALUE;
            }
            return new d0(i10, i12, aVar);
        }
        throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + aVar).toString());
    }

    public static /* synthetic */ x b(int i10, int i11, r9.a aVar, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        if ((i12 & 4) != 0) {
            aVar = r9.a.SUSPEND;
        }
        return a(i10, i11, aVar);
    }

    @NotNull
    public static final <T> h<T> e(@NotNull c0<? extends T> c0Var, @NotNull z8.g gVar, int i10, @NotNull r9.a aVar) {
        return ((i10 == 0 || i10 == -3) && aVar == r9.a.SUSPEND) ? c0Var : new t9.h(c0Var, gVar, i10, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object f(Object[] objArr, long j10) {
        return objArr[((int) j10) & (objArr.length - 1)];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Object[] objArr, long j10, Object obj) {
        objArr[((int) j10) & (objArr.length - 1)] = obj;
    }
}
