package androidx.collection;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ArraySet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ArraySetKt {
    @NotNull
    public static final <T> ArraySet<T> arraySetOf() {
        return new ArraySet<>();
    }

    @NotNull
    public static final <T> ArraySet<T> arraySetOf(@NotNull T... values) {
        t.j(values, "values");
        ArraySet<T> arraySet = new ArraySet<>(values.length);
        for (T t10 : values) {
            arraySet.add(t10);
        }
        return arraySet;
    }
}
