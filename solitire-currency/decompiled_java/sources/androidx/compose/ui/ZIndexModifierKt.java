package androidx.compose.ui;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ZIndexModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ZIndexModifierKt {
    @Stable
    @NotNull
    public static final Modifier zIndex(@NotNull Modifier modifier, float f10) {
        t.i(modifier, "<this>");
        return modifier.then(new ZIndexModifier(f10, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ZIndexModifierKt$zIndex$$inlined$debugInspectorInfo$1(f10) : InspectableValueKt.getNoInspectorInfo()));
    }
}
