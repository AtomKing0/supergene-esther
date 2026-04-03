package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AspectRatio.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AspectRatioKt {
    @Stable
    @NotNull
    public static final Modifier aspectRatio(@NotNull Modifier modifier, float f10, boolean z10) {
        t.i(modifier, "<this>");
        return modifier.then(new AspectRatioModifier(f10, z10, InspectableValueKt.isDebugInspectorInfoEnabled() ? new AspectRatioKt$aspectRatio$$inlined$debugInspectorInfo$1(f10, z10) : InspectableValueKt.getNoInspectorInfo()));
    }

    public static /* synthetic */ Modifier aspectRatio$default(Modifier modifier, float f10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return aspectRatio(modifier, f10, z10);
    }
}
