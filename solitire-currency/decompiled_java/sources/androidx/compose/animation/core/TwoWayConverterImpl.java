package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VectorConverters.kt */
/* JADX INFO: loaded from: classes.dex */
final class TwoWayConverterImpl<T, V extends AnimationVector> implements TwoWayConverter<T, V> {

    @NotNull
    private final l<V, T> convertFromVector;

    @NotNull
    private final l<T, V> convertToVector;

    /* JADX WARN: Multi-variable type inference failed */
    public TwoWayConverterImpl(@NotNull l<? super T, ? extends V> convertToVector, @NotNull l<? super V, ? extends T> convertFromVector) {
        t.i(convertToVector, "convertToVector");
        t.i(convertFromVector, "convertFromVector");
        this.convertToVector = convertToVector;
        this.convertFromVector = convertFromVector;
    }

    @Override // androidx.compose.animation.core.TwoWayConverter
    @NotNull
    public l<V, T> getConvertFromVector() {
        return this.convertFromVector;
    }

    @Override // androidx.compose.animation.core.TwoWayConverter
    @NotNull
    public l<T, V> getConvertToVector() {
        return this.convertToVector;
    }
}
