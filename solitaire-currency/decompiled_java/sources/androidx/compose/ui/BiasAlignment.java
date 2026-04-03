package androidx.compose.ui;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Alignment.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class BiasAlignment implements Alignment {
    private final float horizontalBias;
    private final float verticalBias;

    /* JADX INFO: compiled from: Alignment.kt */
    @Immutable
    public static final class Horizontal implements Alignment.Horizontal {
        private final float bias;

        public Horizontal(float f10) {
            this.bias = f10;
        }

        private final float component1() {
            return this.bias;
        }

        public static /* synthetic */ Horizontal copy$default(Horizontal horizontal, float f10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                f10 = horizontal.bias;
            }
            return horizontal.copy(f10);
        }

        @Override // androidx.compose.ui.Alignment.Horizontal
        public int align(int i10, int i11, @NotNull LayoutDirection layoutDirection) {
            t.i(layoutDirection, "layoutDirection");
            return j9.c.c(((i11 - i10) / 2.0f) * (1 + (layoutDirection == LayoutDirection.Ltr ? this.bias : (-1) * this.bias)));
        }

        @NotNull
        public final Horizontal copy(float f10) {
            return new Horizontal(f10);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Horizontal) && t.d(Float.valueOf(this.bias), Float.valueOf(((Horizontal) obj).bias));
        }

        public int hashCode() {
            return Float.floatToIntBits(this.bias);
        }

        @NotNull
        public String toString() {
            return "Horizontal(bias=" + this.bias + ')';
        }
    }

    /* JADX INFO: compiled from: Alignment.kt */
    @Immutable
    public static final class Vertical implements Alignment.Vertical {
        private final float bias;

        public Vertical(float f10) {
            this.bias = f10;
        }

        private final float component1() {
            return this.bias;
        }

        public static /* synthetic */ Vertical copy$default(Vertical vertical, float f10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                f10 = vertical.bias;
            }
            return vertical.copy(f10);
        }

        @Override // androidx.compose.ui.Alignment.Vertical
        public int align(int i10, int i11) {
            return j9.c.c(((i11 - i10) / 2.0f) * (1 + this.bias));
        }

        @NotNull
        public final Vertical copy(float f10) {
            return new Vertical(f10);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Vertical) && t.d(Float.valueOf(this.bias), Float.valueOf(((Vertical) obj).bias));
        }

        public int hashCode() {
            return Float.floatToIntBits(this.bias);
        }

        @NotNull
        public String toString() {
            return "Vertical(bias=" + this.bias + ')';
        }
    }

    public BiasAlignment(float f10, float f11) {
        this.horizontalBias = f10;
        this.verticalBias = f11;
    }

    public static /* synthetic */ BiasAlignment copy$default(BiasAlignment biasAlignment, float f10, float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = biasAlignment.horizontalBias;
        }
        if ((i10 & 2) != 0) {
            f11 = biasAlignment.verticalBias;
        }
        return biasAlignment.copy(f10, f11);
    }

    @Override // androidx.compose.ui.Alignment
    /* JADX INFO: renamed from: align-KFBX0sM */
    public long mo1275alignKFBX0sM(long j10, long j11, @NotNull LayoutDirection layoutDirection) {
        t.i(layoutDirection, "layoutDirection");
        float fM3833getWidthimpl = (IntSize.m3833getWidthimpl(j11) - IntSize.m3833getWidthimpl(j10)) / 2.0f;
        float fM3832getHeightimpl = (IntSize.m3832getHeightimpl(j11) - IntSize.m3832getHeightimpl(j10)) / 2.0f;
        float f10 = 1;
        return IntOffsetKt.IntOffset(j9.c.c(fM3833getWidthimpl * ((layoutDirection == LayoutDirection.Ltr ? this.horizontalBias : (-1) * this.horizontalBias) + f10)), j9.c.c(fM3832getHeightimpl * (f10 + this.verticalBias)));
    }

    public final float component1() {
        return this.horizontalBias;
    }

    public final float component2() {
        return this.verticalBias;
    }

    @NotNull
    public final BiasAlignment copy(float f10, float f11) {
        return new BiasAlignment(f10, f11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BiasAlignment)) {
            return false;
        }
        BiasAlignment biasAlignment = (BiasAlignment) obj;
        return t.d(Float.valueOf(this.horizontalBias), Float.valueOf(biasAlignment.horizontalBias)) && t.d(Float.valueOf(this.verticalBias), Float.valueOf(biasAlignment.verticalBias));
    }

    public final float getHorizontalBias() {
        return this.horizontalBias;
    }

    public final float getVerticalBias() {
        return this.verticalBias;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.horizontalBias) * 31) + Float.floatToIntBits(this.verticalBias);
    }

    @NotNull
    public String toString() {
        return "BiasAlignment(horizontalBias=" + this.horizontalBias + ", verticalBias=" + this.verticalBias + ')';
    }
}
