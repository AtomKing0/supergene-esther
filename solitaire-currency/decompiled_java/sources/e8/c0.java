package e8;

import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Parameters.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c0 extends g8.w implements z {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(@NotNull Map<String, ? extends List<String>> values) {
        super(true, values);
        kotlin.jvm.internal.t.i(values, "values");
    }

    @NotNull
    public String toString() {
        return "Parameters " + a();
    }
}
