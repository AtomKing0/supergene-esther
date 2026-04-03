package androidx.compose.ui.layout;

import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BeyondBoundsLayout.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BeyondBoundsLayoutKt {

    @NotNull
    private static final ProvidableModifierLocal<BeyondBoundsLayout> ModifierLocalBeyondBoundsLayout = ModifierLocalKt.modifierLocalOf(BeyondBoundsLayoutKt$ModifierLocalBeyondBoundsLayout$1.INSTANCE);

    @NotNull
    public static final ProvidableModifierLocal<BeyondBoundsLayout> getModifierLocalBeyondBoundsLayout() {
        return ModifierLocalBeyondBoundsLayout;
    }
}
