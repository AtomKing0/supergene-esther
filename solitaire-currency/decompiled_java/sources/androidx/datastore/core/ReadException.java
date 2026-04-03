package androidx.datastore.core;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SingleProcessDataStore.kt */
/* JADX INFO: loaded from: classes.dex */
final class ReadException<T> extends State<T> {

    @NotNull
    private final Throwable readException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadException(@NotNull Throwable readException) {
        super(null);
        t.i(readException, "readException");
        this.readException = readException;
    }

    @NotNull
    public final Throwable getReadException() {
        return this.readException;
    }
}
