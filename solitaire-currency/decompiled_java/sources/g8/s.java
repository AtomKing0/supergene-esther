package g8;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PlatformUtilsJvm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class s {
    @NotNull
    public static final q a(@NotNull r rVar) {
        kotlin.jvm.internal.t.i(rVar, "<this>");
        return q.Jvm;
    }

    public static final boolean b(@NotNull r rVar) {
        kotlin.jvm.internal.t.i(rVar, "<this>");
        String property = System.getProperty("io.ktor.development");
        return property != null && Boolean.parseBoolean(property);
    }

    public static final boolean c(@NotNull r rVar) {
        kotlin.jvm.internal.t.i(rVar, "<this>");
        return true;
    }
}
