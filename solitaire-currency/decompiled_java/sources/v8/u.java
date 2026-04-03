package v8;

import org.jetbrains.annotations.NotNull;
import v8.t;

/* JADX INFO: compiled from: Result.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class u {
    @NotNull
    public static final Object a(@NotNull Throwable exception) {
        kotlin.jvm.internal.t.i(exception, "exception");
        return new t.b(exception);
    }

    public static final void b(@NotNull Object obj) {
        if (obj instanceof t.b) {
            throw ((t.b) obj).f35210a;
        }
    }
}
