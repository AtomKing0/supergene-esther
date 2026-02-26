package androidx.compose.material;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Swipeable.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@ExperimentalMaterialApi
public final class FixedThreshold implements ThresholdConfig {
    private final float offset;

    public /* synthetic */ FixedThreshold(float f10, k kVar) {
        this(f10);
    }

    /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name */
    private final float m1040component1D9Ej5fM() {
        return this.offset;
    }

    /* JADX INFO: renamed from: copy-0680j_4$default, reason: not valid java name */
    public static /* synthetic */ FixedThreshold m1041copy0680j_4$default(FixedThreshold fixedThreshold, float f10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = fixedThreshold.offset;
        }
        return fixedThreshold.m1042copy0680j_4(f10);
    }

    @Override // androidx.compose.material.ThresholdConfig
    public float computeThreshold(@NotNull Density density, float f10, float f11) {
        t.i(density, "<this>");
        return f10 + (density.mo296toPx0680j_4(this.offset) * Math.signum(f11 - f10));
    }

    @NotNull
    /* JADX INFO: renamed from: copy-0680j_4, reason: not valid java name */
    public final FixedThreshold m1042copy0680j_4(float f10) {
        return new FixedThreshold(f10, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FixedThreshold) && Dp.m3678equalsimpl0(this.offset, ((FixedThreshold) obj).offset);
    }

    public int hashCode() {
        return Dp.m3679hashCodeimpl(this.offset);
    }

    @NotNull
    public String toString() {
        return "FixedThreshold(offset=" + ((Object) Dp.m3684toStringimpl(this.offset)) + ')';
    }

    private FixedThreshold(float f10) {
        this.offset = f10;
    }
}
