package kotlin.jvm.internal;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ArrayIterator.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c {
    @NotNull
    public static final <T> Iterator<T> a(@NotNull T[] array) {
        t.i(array, "array");
        return new b(array);
    }
}
