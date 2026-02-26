package androidx.compose.foundation.gestures;

import androidx.compose.runtime.Stable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FlingBehavior.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public interface FlingBehavior {
    @Nullable
    Object performFling(@NotNull ScrollScope scrollScope, float f10, @NotNull z8.d<? super Float> dVar);
}
