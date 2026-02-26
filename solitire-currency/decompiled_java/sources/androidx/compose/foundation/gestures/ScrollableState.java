package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import h9.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ScrollableState.kt */
/* JADX INFO: loaded from: classes.dex */
public interface ScrollableState {

    /* JADX INFO: compiled from: ScrollableState.kt */
    public static final class DefaultImpls {
    }

    float dispatchRawDelta(float f10);

    boolean isScrollInProgress();

    @Nullable
    Object scroll(@NotNull MutatePriority mutatePriority, @NotNull p<? super ScrollScope, ? super z8.d<? super k0>, ? extends Object> pVar, @NotNull z8.d<? super k0> dVar);
}
