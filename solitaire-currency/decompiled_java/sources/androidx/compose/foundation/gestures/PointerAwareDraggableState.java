package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import h9.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Draggable.kt */
/* JADX INFO: loaded from: classes.dex */
public interface PointerAwareDraggableState {
    void dispatchRawDelta(float f10);

    @Nullable
    Object drag(@NotNull MutatePriority mutatePriority, @NotNull p<? super PointerAwareDragScope, ? super z8.d<? super k0>, ? extends Object> pVar, @NotNull z8.d<? super k0> dVar);
}
