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
final class UnionInsetsConsumingModifier extends InsetsConsumingModifier {

    @NotNull
    private final WindowInsets insets;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnionInsetsConsumingModifier(@NotNull WindowInsets insets, @NotNull h9.l<? super InspectorInfo, k0> inspectorInfo) {
        super(inspectorInfo, null);
        t.i(insets, "insets");
        t.i(inspectorInfo, "inspectorInfo");
        this.insets = insets;
    }

    @Override // androidx.compose.foundation.layout.InsetsConsumingModifier
    @NotNull
    public WindowInsets calculateInsets(@NotNull WindowInsets modifierLocalInsets) {
        t.i(modifierLocalInsets, "modifierLocalInsets");
        return WindowInsetsKt.union(this.insets, modifierLocalInsets);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UnionInsetsConsumingModifier) {
            return t.d(((UnionInsetsConsumingModifier) obj).insets, this.insets);
        }
        return false;
    }

    public int hashCode() {
        return this.insets.hashCode();
    }
}
