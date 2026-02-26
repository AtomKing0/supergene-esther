package q8;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: UTF8.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull String message) {
        super(message);
        t.i(message, "message");
    }
}
