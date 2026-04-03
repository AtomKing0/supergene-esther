package androidx.compose.ui.platform;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public abstract class InspectorValueInfo implements InspectableValue {
    public static final int $stable = 8;

    @Nullable
    private InspectorInfo _values;

    @NotNull
    private final h9.l<InspectorInfo, v8.k0> info;

    /* JADX WARN: Multi-variable type inference failed */
    public InspectorValueInfo(@NotNull h9.l<? super InspectorInfo, v8.k0> info) {
        kotlin.jvm.internal.t.i(info, "info");
        this.info = info;
    }

    private final InspectorInfo getValues() {
        InspectorInfo inspectorInfo = this._values;
        if (inspectorInfo == null) {
            inspectorInfo = new InspectorInfo();
            this.info.invoke(inspectorInfo);
        }
        this._values = inspectorInfo;
        return inspectorInfo;
    }

    @Override // androidx.compose.ui.platform.InspectableValue
    @NotNull
    public o9.g<ValueElement> getInspectableElements() {
        return getValues().getProperties();
    }

    @Override // androidx.compose.ui.platform.InspectableValue
    @Nullable
    public String getNameFallback() {
        return getValues().getName();
    }

    @Override // androidx.compose.ui.platform.InspectableValue
    @Nullable
    public Object getValueOverride() {
        return getValues().getValue();
    }
}
