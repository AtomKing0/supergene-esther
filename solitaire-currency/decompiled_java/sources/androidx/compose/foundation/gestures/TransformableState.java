package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import h9.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TransformableState.kt */
/* JADX INFO: loaded from: classes.dex */
public interface TransformableState {

    /* JADX INFO: compiled from: TransformableState.kt */
    public static final class DefaultImpls {
    }

    boolean isTransformInProgress();

    @Nullable
    Object transform(@NotNull MutatePriority mutatePriority, @NotNull p<? super TransformScope, ? super z8.d<? super k0>, ? extends Object> pVar, @NotNull z8.d<? super k0> dVar);
}
