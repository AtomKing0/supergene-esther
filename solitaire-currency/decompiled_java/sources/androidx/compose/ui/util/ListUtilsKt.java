package androidx.compose.ui.util;

import h9.l;
import h9.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ListUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ListUtilsKt {
    public static final <T> boolean fastAll(@NotNull List<? extends T> list, @NotNull l<? super T, Boolean> predicate) {
        t.i(list, "<this>");
        t.i(predicate, "predicate");
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!predicate.invoke(list.get(i10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean fastAny(@NotNull List<? extends T> list, @NotNull l<? super T, Boolean> predicate) {
        t.i(list, "<this>");
        t.i(predicate, "predicate");
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (predicate.invoke(list.get(i10)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.Object] */
    @Nullable
    public static final <T> T fastFirstOrNull(@NotNull List<? extends T> list, @NotNull l<? super T, Boolean> predicate) {
        t.i(list, "<this>");
        t.i(predicate, "predicate");
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            T t10 = list.get(i10);
            if (predicate.invoke(t10).booleanValue()) {
                return t10;
            }
        }
        return null;
    }

    public static final <T> void fastForEach(@NotNull List<? extends T> list, @NotNull l<? super T, k0> action) {
        t.i(list, "<this>");
        t.i(action, "action");
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            action.invoke(list.get(i10));
        }
    }

    public static final <T> void fastForEachIndexed(@NotNull List<? extends T> list, @NotNull p<? super Integer, ? super T, k0> action) {
        t.i(list, "<this>");
        t.i(action, "action");
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            action.mo4invoke(Integer.valueOf(i10), list.get(i10));
        }
    }

    @NotNull
    public static final <T, R> List<R> fastMap(@NotNull List<? extends T> list, @NotNull l<? super T, ? extends R> transform) {
        t.i(list, "<this>");
        t.i(transform, "transform");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(transform.invoke(list.get(i10)));
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C fastMapTo(@NotNull List<? extends T> list, @NotNull C destination, @NotNull l<? super T, ? extends R> transform) {
        t.i(list, "<this>");
        t.i(destination, "destination");
        t.i(transform, "transform");
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            destination.add(transform.invoke(list.get(i10)));
        }
        return destination;
    }

    @Nullable
    public static final <T, R extends Comparable<? super R>> T fastMaxBy(@NotNull List<? extends T> list, @NotNull l<? super T, ? extends R> selector) {
        t.i(list, "<this>");
        t.i(selector, "selector");
        if (list.isEmpty()) {
            return null;
        }
        T t10 = list.get(0);
        R rInvoke = selector.invoke(t10);
        int iM = v.m(list);
        int i10 = 1;
        if (1 <= iM) {
            while (true) {
                T t11 = list.get(i10);
                R rInvoke2 = selector.invoke(t11);
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    t10 = t11;
                    rInvoke = rInvoke2;
                }
                if (i10 == iM) {
                    break;
                }
                i10++;
            }
        }
        return (T) t10;
    }

    public static final <T> int fastSumBy(@NotNull List<? extends T> list, @NotNull l<? super T, Integer> selector) {
        t.i(list, "<this>");
        t.i(selector, "selector");
        int size = list.size();
        int iIntValue = 0;
        for (int i10 = 0; i10 < size; i10++) {
            iIntValue += selector.invoke(list.get(i10)).intValue();
        }
        return iIntValue;
    }
}
