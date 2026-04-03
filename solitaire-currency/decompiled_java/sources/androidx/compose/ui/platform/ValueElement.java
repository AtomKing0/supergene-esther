package androidx.compose.ui.platform;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class ValueElement {
    public static final int $stable = 8;

    @NotNull
    private final String name;

    @Nullable
    private final Object value;

    public ValueElement(@NotNull String name, @Nullable Object obj) {
        kotlin.jvm.internal.t.i(name, "name");
        this.name = name;
        this.value = obj;
    }

    public static /* synthetic */ ValueElement copy$default(ValueElement valueElement, String str, Object obj, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            str = valueElement.name;
        }
        if ((i10 & 2) != 0) {
            obj = valueElement.value;
        }
        return valueElement.copy(str, obj);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @Nullable
    public final Object component2() {
        return this.value;
    }

    @NotNull
    public final ValueElement copy(@NotNull String name, @Nullable Object obj) {
        kotlin.jvm.internal.t.i(name, "name");
        return new ValueElement(name, obj);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ValueElement)) {
            return false;
        }
        ValueElement valueElement = (ValueElement) obj;
        return kotlin.jvm.internal.t.d(this.name, valueElement.name) && kotlin.jvm.internal.t.d(this.value, valueElement.value);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Object getValue() {
        return this.value;
    }

    public int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        Object obj = this.value;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    @NotNull
    public String toString() {
        return "ValueElement(name=" + this.name + ", value=" + this.value + ')';
    }
}
