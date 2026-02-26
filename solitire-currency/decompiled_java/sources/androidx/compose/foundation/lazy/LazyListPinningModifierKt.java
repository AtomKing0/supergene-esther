package androidx.compose.foundation.lazy;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LazyListPinningModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListPinningModifierKt {
    @Composable
    @NotNull
    public static final Modifier lazyListPinningModifier(@NotNull Modifier modifier, @NotNull LazyListState state, @NotNull LazyListBeyondBoundsInfo beyondBoundsInfo, @Nullable Composer composer, int i10) {
        t.i(modifier, "<this>");
        t.i(state, "state");
        t.i(beyondBoundsInfo, "beyondBoundsInfo");
        composer.startReplaceableGroup(854917725);
        int i11 = MutableVector.$stable;
        composer.startReplaceableGroup(511388516);
        boolean zChanged = composer.changed(state) | composer.changed(beyondBoundsInfo);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new LazyListPinningModifier(state, beyondBoundsInfo);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier modifierThen = modifier.then((Modifier) objRememberedValue);
        composer.endReplaceableGroup();
        return modifierThen;
    }
}
