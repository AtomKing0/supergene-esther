package androidx.compose.foundation.lazy.grid;

import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LazyGridDsl.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public interface GridCells {

    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @StabilityInferred(parameters = 0)
    public static final class Adaptive implements GridCells {
        public static final int $stable = 0;
        private final float minSize;

        public /* synthetic */ Adaptive(float f10, k kVar) {
            this(f10);
        }

        @Override // androidx.compose.foundation.lazy.grid.GridCells
        @NotNull
        public List<Integer> calculateCrossAxisCellSizes(@NotNull Density density, int i10, int i11) {
            t.i(density, "<this>");
            return LazyGridDslKt.calculateCellsCrossAxisSizeImpl(i10, Math.max((i10 + i11) / (density.mo290roundToPx0680j_4(this.minSize) + i11), 1), i11);
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof Adaptive) && Dp.m3678equalsimpl0(this.minSize, ((Adaptive) obj).minSize);
        }

        public int hashCode() {
            return Dp.m3679hashCodeimpl(this.minSize);
        }

        private Adaptive(float f10) {
            this.minSize = f10;
            if (!(Dp.m3672compareTo0680j_4(f10, Dp.m3673constructorimpl((float) 0)) > 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
    }

    /* JADX INFO: compiled from: LazyGridDsl.kt */
    @StabilityInferred(parameters = 0)
    public static final class Fixed implements GridCells {
        public static final int $stable = 0;
        private final int count;

        public Fixed(int i10) {
            this.count = i10;
            if (!(i10 > 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }

        @Override // androidx.compose.foundation.lazy.grid.GridCells
        @NotNull
        public List<Integer> calculateCrossAxisCellSizes(@NotNull Density density, int i10, int i11) {
            t.i(density, "<this>");
            return LazyGridDslKt.calculateCellsCrossAxisSizeImpl(i10, this.count, i11);
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof Fixed) && this.count == ((Fixed) obj).count;
        }

        public int hashCode() {
            return -this.count;
        }
    }

    @NotNull
    List<Integer> calculateCrossAxisCellSizes(@NotNull Density density, int i10, int i11);
}
