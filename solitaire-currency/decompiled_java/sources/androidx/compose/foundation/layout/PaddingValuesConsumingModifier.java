package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: WindowInsetsPadding.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
final class PaddingValuesConsumingModifier extends InsetsConsumingModifier {

    @NotNull
    private final PaddingValues paddingValues;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaddingValuesConsumingModifier(@NotNull PaddingValues paddingValues, @NotNull h9.l<? super InspectorInfo, k0> inspectorInfo) {
        super(inspectorInfo, null);
        t.i(paddingValues, "paddingValues");
        t.i(inspectorInfo, "inspectorInfo");
        this.paddingValues = paddingValues;
    }

    @Override // androidx.compose.foundation.layout.InsetsConsumingModifier
    @NotNull
    public WindowInsets calculateInsets(@NotNull WindowInsets modifierLocalInsets) {
        t.i(modifierLocalInsets, "modifierLocalInsets");
        return WindowInsetsKt.add(WindowInsetsKt.asInsets(this.paddingValues), modifierLocalInsets);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PaddingValuesConsumingModifier) {
            return t.d(((PaddingValuesConsumingModifier) obj).paddingValues, this.paddingValues);
        }
        return false;
    }

    public int hashCode() {
        return this.paddingValues.hashCode();
    }
}
