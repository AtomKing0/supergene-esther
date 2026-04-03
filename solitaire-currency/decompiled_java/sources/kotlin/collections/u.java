package kotlin.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: CollectionsJVM.kt */
/* JADX INFO: loaded from: classes5.dex */
public class u {
    @NotNull
    public static <E> List<E> a(@NotNull List<E> builder) {
        kotlin.jvm.internal.t.i(builder, "builder");
        return ((w8.b) builder).h();
    }

    @NotNull
    public static final <T> Object[] b(@NotNull T[] tArr, boolean z10) {
        kotlin.jvm.internal.t.i(tArr, "<this>");
        if (z10 && kotlin.jvm.internal.t.d(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        kotlin.jvm.internal.t.h(objArrCopyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return objArrCopyOf;
    }

    @NotNull
    public static <E> List<E> c() {
        return new w8.b();
    }

    @NotNull
    public static <E> List<E> d(int i10) {
        return new w8.b(i10);
    }

    @NotNull
    public static <T> List<T> e(T t10) {
        List<T> listSingletonList = Collections.singletonList(t10);
        kotlin.jvm.internal.t.h(listSingletonList, "singletonList(element)");
        return listSingletonList;
    }
}
