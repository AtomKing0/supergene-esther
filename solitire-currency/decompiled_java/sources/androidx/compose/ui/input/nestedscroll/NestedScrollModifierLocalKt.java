package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: NestedScrollModifierLocal.kt */
/* JADX INFO: loaded from: classes.dex */
public final class NestedScrollModifierLocalKt {

    @NotNull
    private static final ProvidableModifierLocal<NestedScrollModifierLocal> ModifierLocalNestedScroll = ModifierLocalKt.modifierLocalOf(NestedScrollModifierLocalKt$ModifierLocalNestedScroll$1.INSTANCE);

    @NotNull
    public static final ProvidableModifierLocal<NestedScrollModifierLocal> getModifierLocalNestedScroll() {
        return ModifierLocalNestedScroll;
    }
}
