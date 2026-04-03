package t9;

import kotlin.jvm.internal.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u9.l0;

/* JADX INFO: compiled from: ChannelFlow.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class f {
    @Nullable
    public static final <T, V> Object b(@NotNull z8.g gVar, V v10, @NotNull Object obj, @NotNull h9.p<? super V, ? super z8.d<? super T>, ? extends Object> pVar, @NotNull z8.d<? super T> dVar) {
        Object objC = l0.c(gVar, obj);
        try {
            Object objMo4invoke = ((h9.p) t0.f(pVar, 2)).mo4invoke(v10, new x(dVar, gVar));
            l0.a(gVar, objC);
            if (objMo4invoke == a9.d.e()) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            return objMo4invoke;
        } catch (Throwable th) {
            l0.a(gVar, objC);
            throw th;
        }
    }

    public static /* synthetic */ Object c(z8.g gVar, Object obj, Object obj2, h9.p pVar, z8.d dVar, int i10, Object obj3) {
        if ((i10 & 4) != 0) {
            obj2 = l0.b(gVar);
        }
        return b(gVar, obj, obj2, pVar, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> s9.i<T> d(s9.i<? super T> iVar, z8.g gVar) {
        return iVar instanceof w ? true : iVar instanceof r ? iVar : new z(iVar, gVar);
    }
}
