package androidx.compose.foundation.shape;

import androidx.compose.ui.platform.InspectableValue;
import androidx.compose.ui.platform.v;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.t;
import o9.g;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CornerSize.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CornerSizeKt$ZeroCornerSize$1 implements CornerSize, InspectableValue {
    CornerSizeKt$ZeroCornerSize$1() {
    }

    @Override // androidx.compose.ui.platform.InspectableValue
    public /* synthetic */ g getInspectableElements() {
        return v.a(this);
    }

    @Override // androidx.compose.ui.platform.InspectableValue
    public /* synthetic */ String getNameFallback() {
        return v.b(this);
    }

    @Override // androidx.compose.ui.platform.InspectableValue
    @NotNull
    public String getValueOverride() {
        return "ZeroCornerSize";
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    /* JADX INFO: renamed from: toPx-TmRCtEA */
    public float mo637toPxTmRCtEA(long j10, @NotNull Density density) {
        t.i(density, "density");
        return 0.0f;
    }

    @NotNull
    public String toString() {
        return "ZeroCornerSize";
    }
}
