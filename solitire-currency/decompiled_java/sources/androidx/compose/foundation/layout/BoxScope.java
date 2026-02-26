package androidx.compose.foundation.layout;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Box.kt */
/* JADX INFO: loaded from: classes.dex */
@LayoutScopeMarker
@Immutable
public interface BoxScope {
    @Stable
    @NotNull
    Modifier align(@NotNull Modifier modifier, @NotNull Alignment alignment);

    @Stable
    @NotNull
    Modifier matchParentSize(@NotNull Modifier modifier);
}
