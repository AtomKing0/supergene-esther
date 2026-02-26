package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Density.kt */
/* JADX INFO: loaded from: classes.dex */
final class DensityImpl implements Density {
    private final float density;
    private final float fontScale;

    public DensityImpl(float f10, float f11) {
        this.density = f10;
        this.fontScale = f11;
    }

    public static /* synthetic */ DensityImpl copy$default(DensityImpl densityImpl, float f10, float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = densityImpl.getDensity();
        }
        if ((i10 & 2) != 0) {
            f11 = densityImpl.getFontScale();
        }
        return densityImpl.copy(f10, f11);
    }

    public final float component1() {
        return getDensity();
    }

    public final float component2() {
        return getFontScale();
    }

    @NotNull
    public final DensityImpl copy(float f10, float f11) {
        return new DensityImpl(f10, f11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DensityImpl)) {
            return false;
        }
        DensityImpl densityImpl = (DensityImpl) obj;
        return t.d(Float.valueOf(getDensity()), Float.valueOf(densityImpl.getDensity())) && t.d(Float.valueOf(getFontScale()), Float.valueOf(densityImpl.getFontScale()));
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.density;
    }

    @Override // androidx.compose.ui.unit.Density
    public float getFontScale() {
        return this.fontScale;
    }

    public int hashCode() {
        return (Float.floatToIntBits(getDensity()) * 31) + Float.floatToIntBits(getFontScale());
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    public /* synthetic */ int mo289roundToPxR2X_6o(long j10) {
        return a.a(this, j10);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public /* synthetic */ int mo290roundToPx0680j_4(float f10) {
        return a.b(this, f10);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public /* synthetic */ float mo291toDpGaN1DYA(long j10) {
        return a.c(this, j10);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo292toDpu2uoSUM(float f10) {
        return a.d(this, f10);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public /* synthetic */ long mo294toDpSizekrfVVM(long j10) {
        return a.f(this, j10);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public /* synthetic */ float mo295toPxR2X_6o(long j10) {
        return a.g(this, j10);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public /* synthetic */ float mo296toPx0680j_4(float f10) {
        return a.h(this, f10);
    }

    @Override // androidx.compose.ui.unit.Density
    public /* synthetic */ Rect toRect(DpRect dpRect) {
        return a.i(this, dpRect);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public /* synthetic */ long mo297toSizeXkaWNTQ(long j10) {
        return a.j(this, j10);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public /* synthetic */ long mo298toSp0xMU5do(float f10) {
        return a.k(this, f10);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public /* synthetic */ long mo299toSpkPz2Gy4(float f10) {
        return a.l(this, f10);
    }

    @NotNull
    public String toString() {
        return "DensityImpl(density=" + getDensity() + ", fontScale=" + getFontScale() + ')';
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo293toDpu2uoSUM(int i10) {
        return a.e(this, i10);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public /* synthetic */ long mo300toSpkPz2Gy4(int i10) {
        return a.m(this, i10);
    }
}
