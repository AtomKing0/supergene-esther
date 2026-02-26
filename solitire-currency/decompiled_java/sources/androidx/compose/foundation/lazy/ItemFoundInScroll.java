package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationVector1D;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazyListScrolling.kt */
/* JADX INFO: loaded from: classes.dex */
final class ItemFoundInScroll extends CancellationException {

    @NotNull
    private final LazyListItemInfo item;

    @NotNull
    private final AnimationState<Float, AnimationVector1D> previousAnimation;

    public ItemFoundInScroll(@NotNull LazyListItemInfo item, @NotNull AnimationState<Float, AnimationVector1D> previousAnimation) {
        t.i(item, "item");
        t.i(previousAnimation, "previousAnimation");
        this.item = item;
        this.previousAnimation = previousAnimation;
    }

    @NotNull
    public final LazyListItemInfo getItem() {
        return this.item;
    }

    @NotNull
    public final AnimationState<Float, AnimationVector1D> getPreviousAnimation() {
        return this.previousAnimation;
    }
}
