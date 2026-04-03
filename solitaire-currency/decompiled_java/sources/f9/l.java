package f9;

import java.io.File;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FileTreeWalk.kt */
/* JADX INFO: loaded from: classes5.dex */
class l extends k {
    @NotNull
    public static final g l(@NotNull File file, @NotNull h direction) {
        t.i(file, "<this>");
        t.i(direction, "direction");
        return new g(file, direction);
    }

    @NotNull
    public static final g m(@NotNull File file) {
        t.i(file, "<this>");
        return l(file, h.f25760b);
    }
}
