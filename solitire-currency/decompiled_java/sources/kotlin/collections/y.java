package kotlin.collections;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Iterators.kt */
/* JADX INFO: loaded from: classes5.dex */
public class y extends x {
    @NotNull
    public static <T> Iterator<i0<T>> y(@NotNull Iterator<? extends T> it) {
        kotlin.jvm.internal.t.i(it, "<this>");
        return new k0(it);
    }
}
