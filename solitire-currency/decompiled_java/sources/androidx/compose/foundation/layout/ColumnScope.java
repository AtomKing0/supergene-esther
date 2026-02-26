package androidx.compose.foundation.layout;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measured;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Column.kt */
/* JADX INFO: loaded from: classes.dex */
@LayoutScopeMarker
@Immutable
public interface ColumnScope {

    /* JADX INFO: compiled from: Column.kt */
    public static final class DefaultImpls {
    }

    @Stable
    @NotNull
    Modifier align(@NotNull Modifier modifier, @NotNull Alignment.Horizontal horizontal);

    @Stable
    @NotNull
    Modifier alignBy(@NotNull Modifier modifier, @NotNull VerticalAlignmentLine verticalAlignmentLine);

    @Stable
    @NotNull
    Modifier alignBy(@NotNull Modifier modifier, @NotNull h9.l<? super Measured, Integer> lVar);

    @Stable
    @NotNull
    Modifier weight(@NotNull Modifier modifier, float f10, boolean z10);
}
