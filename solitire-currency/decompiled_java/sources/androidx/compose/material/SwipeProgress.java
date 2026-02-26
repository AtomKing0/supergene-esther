package androidx.compose.material;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Swipeable.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@ExperimentalMaterialApi
public final class SwipeProgress<T> {
    private final float fraction;
    private final T from;
    private final T to;

    public SwipeProgress(T t10, T t11, float f10) {
        this.from = t10;
        this.to = t11;
        this.fraction = f10;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwipeProgress)) {
            return false;
        }
        SwipeProgress swipeProgress = (SwipeProgress) obj;
        if (t.d(this.from, swipeProgress.from) && t.d(this.to, swipeProgress.to)) {
            return (this.fraction > swipeProgress.fraction ? 1 : (this.fraction == swipeProgress.fraction ? 0 : -1)) == 0;
        }
        return false;
    }

    public final float getFraction() {
        return this.fraction;
    }

    public final T getFrom() {
        return this.from;
    }

    public final T getTo() {
        return this.to;
    }

    public int hashCode() {
        T t10 = this.from;
        int iHashCode = (t10 != null ? t10.hashCode() : 0) * 31;
        T t11 = this.to;
        return ((iHashCode + (t11 != null ? t11.hashCode() : 0)) * 31) + Float.floatToIntBits(this.fraction);
    }

    @NotNull
    public String toString() {
        return "SwipeProgress(from=" + this.from + ", to=" + this.to + ", fraction=" + this.fraction + ')';
    }
}
