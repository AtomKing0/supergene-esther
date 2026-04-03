package t8;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import p9.p;

/* JADX INFO: compiled from: Atomic.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final int a(@NotNull String name, int i10) {
        String property;
        Integer numL;
        t.i(name, "name");
        try {
            property = System.getProperty("io.ktor.utils.io." + name);
        } catch (SecurityException unused) {
            property = null;
        }
        return (property == null || (numL = p.l(property)) == null) ? i10 : numL.intValue();
    }
}
