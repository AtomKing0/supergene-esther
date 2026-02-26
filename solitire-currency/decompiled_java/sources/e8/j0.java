package e8;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: URLParser.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class j0 extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(@NotNull String urlString, @NotNull Throwable cause) {
        super("Fail to parse url: " + urlString, cause);
        kotlin.jvm.internal.t.i(urlString, "urlString");
        kotlin.jvm.internal.t.i(cause, "cause");
    }
}
