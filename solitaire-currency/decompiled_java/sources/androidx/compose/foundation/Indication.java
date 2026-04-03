package androidx.compose.foundation;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Indication.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public interface Indication {
    @Composable
    @NotNull
    IndicationInstance rememberUpdatedInstance(@NotNull InteractionSource interactionSource, @Nullable Composer composer, int i10);
}
