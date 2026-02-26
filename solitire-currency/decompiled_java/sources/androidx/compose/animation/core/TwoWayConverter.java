package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import h9.l;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VectorConverters.kt */
/* JADX INFO: loaded from: classes.dex */
public interface TwoWayConverter<T, V extends AnimationVector> {
    @NotNull
    l<V, T> getConvertFromVector();

    @NotNull
    l<T, V> getConvertToVector();
}
