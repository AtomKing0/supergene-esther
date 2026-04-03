package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Animation.kt */
/* JADX INFO: loaded from: classes.dex */
public interface Animation<T, V extends AnimationVector> {

    /* JADX INFO: compiled from: Animation.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static <T, V extends AnimationVector> boolean isFinishedFromNanos(@NotNull Animation<T, V> animation, long j10) {
            return a.a(animation, j10);
        }
    }

    long getDurationNanos();

    T getTargetValue();

    @NotNull
    TwoWayConverter<T, V> getTypeConverter();

    T getValueFromNanos(long j10);

    @NotNull
    V getVelocityVectorFromNanos(long j10);

    boolean isFinishedFromNanos(long j10);

    boolean isInfinite();
}
