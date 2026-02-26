package androidx.compose.foundation;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TempListUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TempListUtilsKt {
    @NotNull
    public static final <T> List<T> fastFilter(@NotNull List<? extends T> list, @NotNull h9.l<? super T, Boolean> predicate) {
        t.i(list, "<this>");
        t.i(predicate, "predicate");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            T t10 = list.get(i10);
            if (predicate.invoke(t10).booleanValue()) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    public static final <T, R> R fastFold(@NotNull List<? extends T> list, R r10, @NotNull h9.p<? super R, ? super T, ? extends R> operation) {
        t.i(list, "<this>");
        t.i(operation, "operation");
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            r10 = operation.mo4invoke(r10, list.get(i10));
        }
        return r10;
    }

    @NotNull
    public static final <T, R> List<R> fastMapIndexedNotNull(@NotNull List<? extends T> list, @NotNull h9.p<? super Integer, ? super T, ? extends R> transform) {
        t.i(list, "<this>");
        t.i(transform, "transform");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            R rMo4invoke = transform.mo4invoke(Integer.valueOf(i10), list.get(i10));
            if (rMo4invoke != null) {
                arrayList.add(rMo4invoke);
            }
        }
        return arrayList;
    }

    @Nullable
    public static final <T, R extends Comparable<? super R>> R fastMaxOfOrNull(@NotNull List<? extends T> list, @NotNull h9.l<? super T, ? extends R> selector) {
        t.i(list, "<this>");
        t.i(selector, "selector");
        if (list.isEmpty()) {
            return null;
        }
        R rInvoke = selector.invoke(list.get(0));
        int iM = v.m(list);
        int i10 = 1;
        if (1 <= iM) {
            while (true) {
                R rInvoke2 = selector.invoke(list.get(i10));
                if (rInvoke2.compareTo(rInvoke) > 0) {
                    rInvoke = rInvoke2;
                }
                if (i10 == iM) {
                    break;
                }
                i10++;
            }
        }
        return rInvoke;
    }
}
