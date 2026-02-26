package androidx.compose.ui.text.android;

import h9.l;
import h9.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: TempListUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TempListUtilsKt {
    public static final <T> void fastForEach(@NotNull List<? extends T> list, @NotNull l<? super T, k0> action) {
        t.i(list, "<this>");
        t.i(action, "action");
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            action.invoke(list.get(i10));
        }
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

    @NotNull
    public static final <T, R> List<R> fastZipWithNext(@NotNull List<? extends T> list, @NotNull p<? super T, ? super T, ? extends R> transform) {
        t.i(list, "<this>");
        t.i(transform, "transform");
        if (list.size() == 0 || list.size() == 1) {
            return v.l();
        }
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        a0.c cVar = list.get(0);
        int iM = v.m(list);
        while (i10 < iM) {
            i10++;
            T t10 = list.get(i10);
            arrayList.add(transform.mo4invoke(cVar, t10));
            cVar = t10;
        }
        return arrayList;
    }
}
