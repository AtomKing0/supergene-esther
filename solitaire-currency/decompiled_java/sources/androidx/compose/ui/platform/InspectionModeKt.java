package androidx.compose.ui.platform;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InspectionMode.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InspectionModeKt {

    @NotNull
    private static final ProvidableCompositionLocal<Boolean> LocalInspectionMode = CompositionLocalKt.staticCompositionLocalOf(InspectionModeKt$LocalInspectionMode$1.INSTANCE);

    @NotNull
    public static final ProvidableCompositionLocal<Boolean> getLocalInspectionMode() {
        return LocalInspectionMode;
    }
}
