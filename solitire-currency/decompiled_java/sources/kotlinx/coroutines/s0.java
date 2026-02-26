package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import v8.t;

/* JADX INFO: compiled from: DebugStrings.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class s0 {
    @NotNull
    public static final String a(@NotNull Object obj) {
        return obj.getClass().getSimpleName();
    }

    @NotNull
    public static final String b(@NotNull Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    @NotNull
    public static final String c(@NotNull z8.d<?> dVar) {
        Object objB;
        if (dVar instanceof u9.j) {
            return dVar.toString();
        }
        try {
            t.a aVar = v8.t.f35208b;
            objB = v8.t.b(dVar + '@' + b(dVar));
        } catch (Throwable th) {
            t.a aVar2 = v8.t.f35208b;
            objB = v8.t.b(v8.u.a(th));
        }
        if (v8.t.e(objB) != null) {
            objB = dVar.getClass().getName() + '@' + b(dVar);
        }
        return (String) objB;
    }
}
