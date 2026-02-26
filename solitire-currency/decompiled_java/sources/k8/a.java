package k8;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import xa.b;

/* JADX INFO: compiled from: KtorSimpleLoggerJvm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    @NotNull
    public static final xa.a a(@NotNull String name) {
        t.i(name, "name");
        xa.a aVarJ = b.j(name);
        t.h(aVarJ, "getLogger(name)");
        return aVarJ;
    }
}
