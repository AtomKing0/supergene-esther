package androidx.compose.ui;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.focus.FocusRequesterModifier;
import androidx.compose.ui.focus.FocusRequesterModifierLocal;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ComposedModifier.kt */
/* JADX INFO: loaded from: classes.dex */
final class ComposedModifierKt$WrapFocusRequesterModifier$1 extends v implements q<FocusRequesterModifier, Composer, Integer, FocusRequesterModifierLocal> {
    public static final ComposedModifierKt$WrapFocusRequesterModifier$1 INSTANCE = new ComposedModifierKt$WrapFocusRequesterModifier$1();

    ComposedModifierKt$WrapFocusRequesterModifier$1() {
        super(3);
    }

    @Override // h9.q
    public /* bridge */ /* synthetic */ FocusRequesterModifierLocal invoke(FocusRequesterModifier focusRequesterModifier, Composer composer, Integer num) {
        return invoke(focusRequesterModifier, composer, num.intValue());
    }

    @Composable
    @NotNull
    public final FocusRequesterModifierLocal invoke(@NotNull FocusRequesterModifier mod, @Nullable Composer composer, int i10) {
        t.i(mod, "mod");
        composer.startReplaceableGroup(945678692);
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(mod);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new FocusRequesterModifierLocal(mod.getFocusRequester());
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        FocusRequesterModifierLocal focusRequesterModifierLocal = (FocusRequesterModifierLocal) objRememberedValue;
        composer.endReplaceableGroup();
        return focusRequesterModifierLocal;
    }
}
