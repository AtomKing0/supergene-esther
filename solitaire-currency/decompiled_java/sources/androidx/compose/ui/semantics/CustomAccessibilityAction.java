package androidx.compose.ui.semantics;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SemanticsProperties.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class CustomAccessibilityAction {
    public static final int $stable = 0;

    @NotNull
    private final h9.a<Boolean> action;

    @NotNull
    private final String label;

    public CustomAccessibilityAction(@NotNull String label, @NotNull h9.a<Boolean> action) {
        t.i(label, "label");
        t.i(action, "action");
        this.label = label;
        this.action = action;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomAccessibilityAction)) {
            return false;
        }
        CustomAccessibilityAction customAccessibilityAction = (CustomAccessibilityAction) obj;
        return t.d(this.label, customAccessibilityAction.label) && t.d(this.action, customAccessibilityAction.action);
    }

    @NotNull
    public final h9.a<Boolean> getAction() {
        return this.action;
    }

    @NotNull
    public final String getLabel() {
        return this.label;
    }

    public int hashCode() {
        return (this.label.hashCode() * 31) + this.action.hashCode();
    }

    @NotNull
    public String toString() {
        return "CustomAccessibilityAction(label=" + this.label + ", action=" + this.action + ')';
    }
}
