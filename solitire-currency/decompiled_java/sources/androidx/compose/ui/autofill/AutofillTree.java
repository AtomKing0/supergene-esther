package androidx.compose.ui.autofill;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.ExperimentalComposeUiApi;
import h9.l;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AutofillTree.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalComposeUiApi
public final class AutofillTree {
    public static final int $stable = 8;

    @NotNull
    private final Map<Integer, AutofillNode> children = new LinkedHashMap();

    @NotNull
    public final Map<Integer, AutofillNode> getChildren() {
        return this.children;
    }

    @Nullable
    public final k0 performAutofill(int i10, @NotNull String value) {
        l<String, k0> onFill;
        t.i(value, "value");
        AutofillNode autofillNode = this.children.get(Integer.valueOf(i10));
        if (autofillNode == null || (onFill = autofillNode.getOnFill()) == null) {
            return null;
        }
        onFill.invoke(value);
        return k0.f35197a;
    }

    public final void plusAssign(@NotNull AutofillNode autofillNode) {
        t.i(autofillNode, "autofillNode");
        this.children.put(Integer.valueOf(autofillNode.getId()), autofillNode);
    }
}
