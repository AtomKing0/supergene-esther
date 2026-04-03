package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntOffset;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazyItemScope.kt */
/* JADX INFO: loaded from: classes.dex */
@LazyScopeMarker
@Stable
public interface LazyItemScope {

    /* JADX INFO: compiled from: LazyItemScope.kt */
    public static final class DefaultImpls {
    }

    @ExperimentalFoundationApi
    @NotNull
    Modifier animateItemPlacement(@NotNull Modifier modifier, @NotNull FiniteAnimationSpec<IntOffset> finiteAnimationSpec);

    @NotNull
    Modifier fillParentMaxHeight(@NotNull Modifier modifier, float f10);

    @NotNull
    Modifier fillParentMaxSize(@NotNull Modifier modifier, float f10);

    @NotNull
    Modifier fillParentMaxWidth(@NotNull Modifier modifier, float f10);
}
