package m;

import android.content.Context;
import java.io.Closeable;
import m.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ua.q0;

/* JADX INFO: compiled from: ImageSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class q {
    @NotNull
    public static final p a(@NotNull ua.e eVar, @NotNull Context context) {
        return new s(eVar, a0.j.m(context), null);
    }

    @NotNull
    public static final p b(@NotNull ua.e eVar, @NotNull Context context, @Nullable p.a aVar) {
        return new s(eVar, a0.j.m(context), aVar);
    }

    @NotNull
    public static final p c(@NotNull q0 q0Var, @NotNull ua.j jVar, @Nullable String str, @Nullable Closeable closeable) {
        return new o(q0Var, jVar, str, closeable, null);
    }

    public static /* synthetic */ p d(q0 q0Var, ua.j jVar, String str, Closeable closeable, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            jVar = ua.j.f34780b;
        }
        if ((i10 & 4) != 0) {
            str = null;
        }
        if ((i10 & 8) != 0) {
            closeable = null;
        }
        return c(q0Var, jVar, str, closeable);
    }
}
