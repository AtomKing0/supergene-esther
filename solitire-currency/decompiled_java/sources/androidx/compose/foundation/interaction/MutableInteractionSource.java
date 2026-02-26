package androidx.compose.foundation.interaction;

import androidx.compose.runtime.Stable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: InteractionSource.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public interface MutableInteractionSource extends InteractionSource {
    @Nullable
    Object emit(@NotNull Interaction interaction, @NotNull d<? super k0> dVar);

    boolean tryEmit(@NotNull Interaction interaction);
}
