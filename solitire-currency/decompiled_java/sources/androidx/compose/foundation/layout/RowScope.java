package androidx.compose.foundation.layout;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measured;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Row.kt */
/* JADX INFO: loaded from: classes.dex */
@LayoutScopeMarker
@Immutable
public interface RowScope {

    /* JADX INFO: compiled from: Row.kt */
    public static final class DefaultImpls {
    }

    @Stable
    @NotNull
    Modifier align(@NotNull Modifier modifier, @NotNull Alignment.Vertical vertical);

    @Stable
    @NotNull
    Modifier alignBy(@NotNull Modifier modifier, @NotNull HorizontalAlignmentLine horizontalAlignmentLine);

    @Stable
    @NotNull
    Modifier alignBy(@NotNull Modifier modifier, @NotNull h9.l<? super Measured, Integer> lVar);

    @Stable
    @NotNull
    Modifier alignByBaseline(@NotNull Modifier modifier);

    @Stable
    @NotNull
    Modifier weight(@NotNull Modifier modifier, float f10, boolean z10);
}
