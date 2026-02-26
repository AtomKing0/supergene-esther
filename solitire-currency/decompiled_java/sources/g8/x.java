package g8;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StringValues.kt */
/* JADX INFO: loaded from: classes.dex */
public final class x {
    @NotNull
    public static final u c(@NotNull u uVar, @NotNull u builder) {
        kotlin.jvm.internal.t.i(uVar, "<this>");
        kotlin.jvm.internal.t.i(builder, "builder");
        Iterator<T> it = builder.a().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            uVar.d((String) entry.getKey(), (List) entry.getValue());
        }
        return uVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(Set<? extends Map.Entry<String, ? extends List<String>>> set, Set<? extends Map.Entry<String, ? extends List<String>>> set2) {
        return kotlin.jvm.internal.t.d(set, set2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int e(Set<? extends Map.Entry<String, ? extends List<String>>> set, int i10) {
        return (i10 * 31) + set.hashCode();
    }
}
