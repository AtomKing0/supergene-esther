package s9;

import kotlinx.coroutines.b2;
import org.jetbrains.annotations.NotNull;
import t9.p;

/* JADX INFO: compiled from: Context.kt */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class n {
    @NotNull
    public static final <T> h<T> a(@NotNull h<? extends T> hVar, int i10, @NotNull r9.a aVar) {
        int i11;
        r9.a aVar2;
        boolean z10 = true;
        if (!(i10 >= 0 || i10 == -2 || i10 == -1)) {
            throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i10).toString());
        }
        if (i10 == -1 && aVar != r9.a.SUSPEND) {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
        if (i10 == -1) {
            aVar2 = r9.a.DROP_OLDEST;
            i11 = 0;
        } else {
            i11 = i10;
            aVar2 = aVar;
        }
        return hVar instanceof t9.p ? p.a.a((t9.p) hVar, null, i11, aVar2, 1, null) : new t9.h(hVar, null, i11, aVar2, 2, null);
    }

    public static /* synthetic */ h b(h hVar, int i10, r9.a aVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = -2;
        }
        if ((i11 & 2) != 0) {
            aVar = r9.a.SUSPEND;
        }
        return j.d(hVar, i10, aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> h<T> c(@NotNull h<? extends T> hVar) {
        return hVar instanceof c ? hVar : new d(hVar);
    }

    private static final void d(z8.g gVar) {
        if (gVar.get(b2.O7) == null) {
            return;
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + gVar).toString());
    }

    @NotNull
    public static final <T> h<T> e(@NotNull h<? extends T> hVar) {
        return b(hVar, -1, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> h<T> f(@NotNull h<? extends T> hVar, @NotNull z8.g gVar) {
        d(gVar);
        return kotlin.jvm.internal.t.d(gVar, z8.h.f37608a) ? hVar : hVar instanceof t9.p ? p.a.a((t9.p) hVar, gVar, 0, null, 6, null) : new t9.h(hVar, gVar, 0, null, 12, null);
    }
}
