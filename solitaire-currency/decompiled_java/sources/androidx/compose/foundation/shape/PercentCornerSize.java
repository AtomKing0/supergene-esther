package androidx.compose.foundation.shape;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.platform.InspectableValue;
import androidx.compose.ui.platform.v;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.t;
import o9.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CornerSize.kt */
/* JADX INFO: loaded from: classes.dex */
final class PercentCornerSize implements CornerSize, InspectableValue {
    private final float percent;

    public PercentCornerSize(float f10) {
        this.percent = f10;
        if (f10 < 0.0f || f10 > 100.0f) {
            throw new IllegalArgumentException("The percent should be in the range of [0, 100]");
        }
    }

    private final float component1() {
        return this.percent;
    }

    public static /* synthetic */ PercentCornerSize copy$default(PercentCornerSize percentCornerSize, float f10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = percentCornerSize.percent;
        }
        return percentCornerSize.copy(f10);
    }

    @NotNull
    public final PercentCornerSize copy(float f10) {
        return new PercentCornerSize(f10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PercentCornerSize) && t.d(Float.valueOf(this.percent), Float.valueOf(((PercentCornerSize) obj).percent));
    }

    @Override // androidx.compose.ui.platform.InspectableValue
    public /* synthetic */ g getInspectableElements() {
        return v.a(this);
    }

    @Override // androidx.compose.ui.platform.InspectableValue
    public /* synthetic */ String getNameFallback() {
        return v.b(this);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.percent);
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    /* JADX INFO: renamed from: toPx-TmRCtEA */
    public float mo637toPxTmRCtEA(long j10, @NotNull Density density) {
        t.i(density, "density");
        return Size.m1435getMinDimensionimpl(j10) * (this.percent / 100.0f);
    }

    @NotNull
    public String toString() {
        return "CornerSize(size = " + this.percent + "%)";
    }

    @Override // androidx.compose.ui.platform.InspectableValue
    @NotNull
    public String getValueOverride() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.percent);
        sb.append('%');
        return sb.toString();
    }
}
