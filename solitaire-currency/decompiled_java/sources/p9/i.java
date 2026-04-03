package p9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Appendable.kt */
/* JADX INFO: loaded from: classes5.dex */
public class i {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(@NotNull Appendable appendable, T t10, @Nullable h9.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.t.i(appendable, "<this>");
        if (lVar != null) {
            appendable.append(lVar.invoke(t10));
            return;
        }
        if (t10 == 0 ? true : t10 instanceof CharSequence) {
            appendable.append((CharSequence) t10);
        } else if (t10 instanceof Character) {
            appendable.append(((Character) t10).charValue());
        } else {
            appendable.append(String.valueOf(t10));
        }
    }
}
