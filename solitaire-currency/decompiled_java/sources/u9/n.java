package u9;

import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: InlineList.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class n<E> {
    public static /* synthetic */ Object b(Object obj, int i10, kotlin.jvm.internal.k kVar) {
        if ((i10 & 1) != 0) {
            obj = null;
        }
        return a(obj);
    }

    @NotNull
    public static final Object c(Object obj, E e10) {
        if (obj == null) {
            return a(e10);
        }
        if (obj instanceof ArrayList) {
            kotlin.jvm.internal.t.g(obj, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ((ArrayList) obj).add(e10);
            return a(obj);
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e10);
        return a(arrayList);
    }

    @NotNull
    public static <E> Object a(@Nullable Object obj) {
        return obj;
    }
}
