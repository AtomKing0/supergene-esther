package p8;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Buffer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@NotNull String message) {
        super(message);
        t.i(message, "message");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o(@NotNull String name, int i10, int i11) {
        this("Not enough free space to write " + name + " of " + i10 + " bytes, available " + i11 + " bytes.");
        t.i(name, "name");
    }
}
