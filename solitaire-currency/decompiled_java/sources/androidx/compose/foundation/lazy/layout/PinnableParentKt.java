package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PinnableParent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PinnableParentKt {

    @NotNull
    private static final ProvidableModifierLocal<PinnableParent> ModifierLocalPinnableParent = ModifierLocalKt.modifierLocalOf(PinnableParentKt$ModifierLocalPinnableParent$1.INSTANCE);

    @ExperimentalFoundationApi
    @NotNull
    public static final ProvidableModifierLocal<PinnableParent> getModifierLocalPinnableParent() {
        return ModifierLocalPinnableParent;
    }

    @ExperimentalFoundationApi
    public static /* synthetic */ void getModifierLocalPinnableParent$annotations() {
    }
}
