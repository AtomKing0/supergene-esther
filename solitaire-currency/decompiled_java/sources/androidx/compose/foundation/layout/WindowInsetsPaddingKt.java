package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WindowInsetsPadding.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsPaddingKt {

    @NotNull
    private static final ProvidableModifierLocal<WindowInsets> ModifierLocalConsumedWindowInsets = ModifierLocalKt.modifierLocalOf(WindowInsetsPaddingKt$ModifierLocalConsumedWindowInsets$1.INSTANCE);

    @Stable
    @ExperimentalLayoutApi
    @NotNull
    public static final Modifier consumedWindowInsets(@NotNull Modifier modifier, @NotNull WindowInsets insets) {
        t.i(modifier, "<this>");
        t.i(insets, "insets");
        return modifier.then(new UnionInsetsConsumingModifier(insets, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPaddingKt$consumedWindowInsets$$inlined$debugInspectorInfo$1(insets) : InspectableValueKt.getNoInspectorInfo()));
    }

    @NotNull
    public static final ProvidableModifierLocal<WindowInsets> getModifierLocalConsumedWindowInsets() {
        return ModifierLocalConsumedWindowInsets;
    }

    @Stable
    @NotNull
    public static final Modifier windowInsetsPadding(@NotNull Modifier modifier, @NotNull WindowInsets insets) {
        t.i(modifier, "<this>");
        t.i(insets, "insets");
        return modifier.then(new InsetsPaddingModifier(insets, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPaddingKt$windowInsetsPadding$$inlined$debugInspectorInfo$1(insets) : InspectableValueKt.getNoInspectorInfo()));
    }

    @Stable
    @ExperimentalLayoutApi
    @NotNull
    public static final Modifier consumedWindowInsets(@NotNull Modifier modifier, @NotNull PaddingValues paddingValues) {
        t.i(modifier, "<this>");
        t.i(paddingValues, "paddingValues");
        return modifier.then(new PaddingValuesConsumingModifier(paddingValues, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPaddingKt$consumedWindowInsets$$inlined$debugInspectorInfo$2(paddingValues) : InspectableValueKt.getNoInspectorInfo()));
    }
}
