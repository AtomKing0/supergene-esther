package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Constraints;
import h9.q;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LayoutModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutModifierKt {
    @NotNull
    public static final Modifier layout(@NotNull Modifier modifier, @NotNull q<? super MeasureScope, ? super Measurable, ? super Constraints, ? extends MeasureResult> measure) {
        t.i(modifier, "<this>");
        t.i(measure, "measure");
        return modifier.then(new LayoutModifierImpl(measure, InspectableValueKt.isDebugInspectorInfoEnabled() ? new LayoutModifierKt$layout$$inlined$debugInspectorInfo$1(measure) : InspectableValueKt.getNoInspectorInfo()));
    }
}
