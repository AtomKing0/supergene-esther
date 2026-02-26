package v8;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Standard.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class r extends Error {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(@NotNull String message) {
        super(message);
        kotlin.jvm.internal.t.i(message, "message");
    }

    public /* synthetic */ r(String str, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? "An operation is not implemented." : str);
    }
}
