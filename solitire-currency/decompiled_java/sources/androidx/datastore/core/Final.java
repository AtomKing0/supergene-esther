package androidx.datastore.core;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SingleProcessDataStore.kt */
/* JADX INFO: loaded from: classes.dex */
final class Final<T> extends State<T> {

    @NotNull
    private final Throwable finalException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Final(@NotNull Throwable finalException) {
        super(null);
        t.i(finalException, "finalException");
        this.finalException = finalException;
    }

    @NotNull
    public final Throwable getFinalException() {
        return this.finalException;
    }
}
