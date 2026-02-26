package androidx.compose.ui.semantics;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.g;

/* JADX INFO: compiled from: SemanticsProperties.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
public final class AccessibilityAction<T extends g<? extends Boolean>> {
    public static final int $stable = 0;

    @Nullable
    private final T action;

    @Nullable
    private final String label;

    public AccessibilityAction(@Nullable String str, @Nullable T t10) {
        this.label = str;
        this.action = t10;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessibilityAction)) {
            return false;
        }
        AccessibilityAction accessibilityAction = (AccessibilityAction) obj;
        return t.d(this.label, accessibilityAction.label) && t.d(this.action, accessibilityAction.action);
    }

    @Nullable
    public final T getAction() {
        return this.action;
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    public int hashCode() {
        String str = this.label;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        T t10 = this.action;
        return iHashCode + (t10 != null ? t10.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AccessibilityAction(label=" + this.label + ", action=" + this.action + ')';
    }
}
