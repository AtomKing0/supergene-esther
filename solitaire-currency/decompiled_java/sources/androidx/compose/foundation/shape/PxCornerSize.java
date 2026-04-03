package androidx.compose.foundation.shape;

import androidx.compose.ui.platform.InspectableValue;
import androidx.compose.ui.platform.v;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.t;
import o9.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CornerSize.kt */
/* JADX INFO: loaded from: classes.dex */
final class PxCornerSize implements CornerSize, InspectableValue {
    private final float size;

    public PxCornerSize(float f10) {
        this.size = f10;
    }

    private final float component1() {
        return this.size;
    }

    public static /* synthetic */ PxCornerSize copy$default(PxCornerSize pxCornerSize, float f10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = pxCornerSize.size;
        }
        return pxCornerSize.copy(f10);
    }

    @NotNull
    public final PxCornerSize copy(float f10) {
        return new PxCornerSize(f10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PxCornerSize) && t.d(Float.valueOf(this.size), Float.valueOf(((PxCornerSize) obj).size));
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
        return Float.floatToIntBits(this.size);
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    /* JADX INFO: renamed from: toPx-TmRCtEA */
    public float mo637toPxTmRCtEA(long j10, @NotNull Density density) {
        t.i(density, "density");
        return this.size;
    }

    @NotNull
    public String toString() {
        return "CornerSize(size = " + this.size + ".px)";
    }

    @Override // androidx.compose.ui.platform.InspectableValue
    @NotNull
    public String getValueOverride() {
        return this.size + "px";
    }
}
