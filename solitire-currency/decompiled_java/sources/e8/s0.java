package e8;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Url.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class s0 {
    @NotNull
    public static final String a(@NotNull p0 p0Var) {
        kotlin.jvm.internal.t.i(p0Var, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append(b(p0Var));
        if (p0Var.l() == 0 || p0Var.l() == p0Var.k().c()) {
            sb.append(p0Var.g());
        } else {
            sb.append(n0.f(p0Var));
        }
        String string = sb.toString();
        kotlin.jvm.internal.t.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @NotNull
    public static final String b(@NotNull p0 p0Var) {
        kotlin.jvm.internal.t.i(p0Var, "<this>");
        StringBuilder sb = new StringBuilder();
        n0.e(sb, p0Var.f(), p0Var.c());
        String string = sb.toString();
        kotlin.jvm.internal.t.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
