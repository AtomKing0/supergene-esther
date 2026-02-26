package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;

/* JADX INFO: compiled from: CompletionState.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class g0 {
    @NotNull
    public static final <T> Object a(@Nullable Object obj, @NotNull z8.d<? super T> dVar) {
        if (!(obj instanceof c0)) {
            return v8.t.b(obj);
        }
        t.a aVar = v8.t.f35208b;
        return v8.t.b(v8.u.a(((c0) obj).f29865a));
    }

    @Nullable
    public static final <T> Object b(@NotNull Object obj, @Nullable h9.l<? super Throwable, v8.k0> lVar) {
        Throwable thE = v8.t.e(obj);
        if (thE == null) {
            return lVar != null ? new d0(obj, lVar) : obj;
        }
        return new c0(thE, false, 2, null);
    }

    @Nullable
    public static final <T> Object c(@NotNull Object obj, @NotNull o<?> oVar) {
        Throwable thE = v8.t.e(obj);
        if (thE == null) {
            return obj;
        }
        return new c0(thE, false, 2, null);
    }

    public static /* synthetic */ Object d(Object obj, h9.l lVar, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            lVar = null;
        }
        return b(obj, lVar);
    }
}
