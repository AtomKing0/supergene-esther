package e8;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ContentTypes.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull String value) {
        super("Bad Content-Type format: " + value);
        kotlin.jvm.internal.t.i(value, "value");
    }
}
