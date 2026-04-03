package androidx.compose.foundation.gestures;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ScrollableState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollableStateKt {
    @NotNull
    public static final ScrollableState ScrollableState(@NotNull l<? super Float, Float> consumeScrollDelta) {
        t.i(consumeScrollDelta, "consumeScrollDelta");
        return new DefaultScrollableState(consumeScrollDelta);
    }

    @Composable
    @NotNull
    public static final ScrollableState rememberScrollableState(@NotNull l<? super Float, Float> consumeScrollDelta, @Nullable Composer composer, int i10) {
        t.i(consumeScrollDelta, "consumeScrollDelta");
        composer.startReplaceableGroup(-180460798);
        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(consumeScrollDelta, composer, i10 & 14);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = ScrollableState(new ScrollableStateKt$rememberScrollableState$1$1(stateRememberUpdatedState));
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        ScrollableState scrollableState = (ScrollableState) objRememberedValue;
        composer.endReplaceableGroup();
        return scrollableState;
    }
}
