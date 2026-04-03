package e8;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: URLProtocol.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class m0 {
    public static final boolean a(@NotNull l0 l0Var) {
        kotlin.jvm.internal.t.i(l0Var, "<this>");
        return kotlin.jvm.internal.t.d(l0Var.d(), "https") || kotlin.jvm.internal.t.d(l0Var.d(), "wss");
    }

    public static final boolean b(@NotNull l0 l0Var) {
        kotlin.jvm.internal.t.i(l0Var, "<this>");
        return kotlin.jvm.internal.t.d(l0Var.d(), "ws") || kotlin.jvm.internal.t.d(l0Var.d(), "wss");
    }
}
