package r9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Channel.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class g {
    @NotNull
    public static final <E> d<E> a(int i10, @NotNull a aVar, @Nullable h9.l<? super E, k0> lVar) {
        d<E> bVar;
        if (i10 != -2) {
            if (i10 == -1) {
                if (aVar == a.SUSPEND) {
                    return new o(1, a.DROP_OLDEST, lVar);
                }
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
            }
            if (i10 != 0) {
                return i10 != Integer.MAX_VALUE ? aVar == a.SUSPEND ? new b(i10, lVar) : new o(i10, aVar, lVar) : new b(Integer.MAX_VALUE, lVar);
            }
            bVar = aVar == a.SUSPEND ? new b<>(0, lVar) : new o<>(1, aVar, lVar);
        } else {
            bVar = aVar == a.SUSPEND ? new b<>(d.Q7.a(), lVar) : new o<>(1, aVar, lVar);
        }
        return bVar;
    }

    public static /* synthetic */ d b(int i10, a aVar, h9.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        if ((i11 & 2) != 0) {
            aVar = a.SUSPEND;
        }
        if ((i11 & 4) != 0) {
            lVar = null;
        }
        return a(i10, aVar, lVar);
    }
}
