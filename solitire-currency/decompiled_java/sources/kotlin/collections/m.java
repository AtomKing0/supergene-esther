package kotlin.collections;

import java.lang.reflect.Array;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ArraysJVM.kt */
/* JADX INFO: loaded from: classes5.dex */
class m {
    @NotNull
    public static final <T> T[] a(@NotNull T[] reference, int i10) {
        kotlin.jvm.internal.t.i(reference, "reference");
        Object objNewInstance = Array.newInstance(reference.getClass().getComponentType(), i10);
        kotlin.jvm.internal.t.g(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (T[]) ((Object[]) objNewInstance);
    }

    public static final void b(int i10, int i11) {
        if (i10 <= i11) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i10 + ") is greater than size (" + i11 + ").");
    }
}
