package kotlin.collections;

import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: _CollectionsJvm.kt */
/* JADX INFO: loaded from: classes5.dex */
class c0 extends b0 {
    public static final <T> void Z(@NotNull List<T> list) {
        kotlin.jvm.internal.t.i(list, "<this>");
        Collections.reverse(list);
    }
}
