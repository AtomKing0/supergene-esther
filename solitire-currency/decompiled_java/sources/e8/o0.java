package e8;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HttpHeaders.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class o0 extends IllegalArgumentException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(@NotNull String header) {
        super("Header(s) " + header + " are controlled by the engine and cannot be set explicitly");
        kotlin.jvm.internal.t.i(header, "header");
    }
}
