package kotlin.collections;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: ReversedViews.kt */
/* JADX INFO: loaded from: classes5.dex */
public class b0 extends a0 {
    @NotNull
    public static <T> List<T> V(@NotNull List<? extends T> list) {
        kotlin.jvm.internal.t.i(list, "<this>");
        return new v0(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int W(List<?> list, int i10) {
        if (new n9.i(0, v.m(list)).i(i10)) {
            return v.m(list) - i10;
        }
        throw new IndexOutOfBoundsException("Element index " + i10 + " must be in range [" + new n9.i(0, v.m(list)) + "].");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int X(List<?> list, int i10) {
        return v.m(list) - i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int Y(List<?> list, int i10) {
        if (new n9.i(0, list.size()).i(i10)) {
            return list.size() - i10;
        }
        throw new IndexOutOfBoundsException("Position index " + i10 + " must be in range [" + new n9.i(0, list.size()) + "].");
    }
}
