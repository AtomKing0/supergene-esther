package androidx.compose.foundation.lazy;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LazyBeyondBoundsModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyBeyondBoundsModifierKt {
    @Composable
    @NotNull
    public static final Modifier lazyListBeyondBoundsModifier(@NotNull Modifier modifier, @NotNull LazyListState state, @NotNull LazyListBeyondBoundsInfo beyondBoundsInfo, boolean z10, @Nullable Composer composer, int i10) {
        t.i(modifier, "<this>");
        t.i(state, "state");
        t.i(beyondBoundsInfo, "beyondBoundsInfo");
        composer.startReplaceableGroup(1245943849);
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        Object[] objArr = {state, beyondBoundsInfo, Boolean.valueOf(z10), layoutDirection};
        composer.startReplaceableGroup(-568225417);
        boolean zChanged = false;
        for (int i11 = 0; i11 < 4; i11++) {
            zChanged |= composer.changed(objArr[i11]);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new LazyListBeyondBoundsModifierLocal(state, beyondBoundsInfo, z10, layoutDirection);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier modifierThen = modifier.then((Modifier) objRememberedValue);
        composer.endReplaceableGroup();
        return modifierThen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void unsupportedDirection() {
        throw new IllegalStateException("Lazy list does not support beyond bounds layout for the specified direction".toString());
    }
}
