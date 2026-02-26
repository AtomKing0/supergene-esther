package e8;

import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Headers.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class m extends g8.w implements k {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@NotNull Map<String, ? extends List<String>> values) {
        super(true, values);
        kotlin.jvm.internal.t.i(values, "values");
    }

    @NotNull
    public String toString() {
        return "Headers " + a();
    }
}
