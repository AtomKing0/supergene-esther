package t7;

import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class h extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull f8.b content) {
        super("Failed to write body: " + o0.b(content.getClass()));
        t.i(content, "content");
    }
}
