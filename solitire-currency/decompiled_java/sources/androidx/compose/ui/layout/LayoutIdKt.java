package androidx.compose.ui.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LayoutId.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutIdKt {
    @Nullable
    public static final Object getLayoutId(@NotNull Measurable measurable) {
        t.i(measurable, "<this>");
        Object parentData = measurable.getParentData();
        LayoutIdParentData layoutIdParentData = parentData instanceof LayoutIdParentData ? (LayoutIdParentData) parentData : null;
        if (layoutIdParentData != null) {
            return layoutIdParentData.getLayoutId();
        }
        return null;
    }

    @Stable
    @NotNull
    public static final Modifier layoutId(@NotNull Modifier modifier, @NotNull Object layoutId) {
        t.i(modifier, "<this>");
        t.i(layoutId, "layoutId");
        return modifier.then(new LayoutId(layoutId, InspectableValueKt.isDebugInspectorInfoEnabled() ? new LayoutIdKt$layoutId$$inlined$debugInspectorInfo$1(layoutId) : InspectableValueKt.getNoInspectorInfo()));
    }
}
