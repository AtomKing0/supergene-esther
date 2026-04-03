package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LazySemantics.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazySemanticsKt {
    @Composable
    @ExperimentalFoundationApi
    @NotNull
    public static final Modifier lazyListSemantics(@NotNull Modifier modifier, @NotNull LazyListItemProvider itemProvider, @NotNull LazyListState state, @NotNull o0 coroutineScope, boolean z10, boolean z11, boolean z12, @Nullable Composer composer, int i10) {
        t.i(modifier, "<this>");
        t.i(itemProvider, "itemProvider");
        t.i(state, "state");
        t.i(coroutineScope, "coroutineScope");
        composer.startReplaceableGroup(-1728067365);
        Object[] objArr = {itemProvider, state, Boolean.valueOf(z10), Boolean.valueOf(z11), Boolean.valueOf(z12)};
        composer.startReplaceableGroup(-568225417);
        boolean zChanged = false;
        for (int i11 = 0; i11 < 5; i11++) {
            zChanged |= composer.changed(objArr[i11]);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = SemanticsModifierKt.semantics$default(Modifier.Companion, false, new LazySemanticsKt$lazyListSemantics$1$1(new LazySemanticsKt$lazyListSemantics$1$indexForKeyMapping$1(itemProvider), z10, new ScrollAxisRange(new LazySemanticsKt$lazyListSemantics$1$accessibilityScrollState$1(state), new LazySemanticsKt$lazyListSemantics$1$accessibilityScrollState$2(state, itemProvider), z11), z12 ? new LazySemanticsKt$lazyListSemantics$1$scrollByAction$1(z10, coroutineScope, state) : null, z12 ? new LazySemanticsKt$lazyListSemantics$1$scrollToIndexAction$1(state, coroutineScope) : null, new CollectionInfo(z10 ? -1 : 1, z10 ? 1 : -1)), 1, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier modifierThen = modifier.then((Modifier) objRememberedValue);
        composer.endReplaceableGroup();
        return modifierThen;
    }
}
