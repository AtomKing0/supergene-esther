package androidx.compose.foundation.layout;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RowColumnImpl.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RowColumnParentData {

    @Nullable
    private CrossAxisAlignment crossAxisAlignment;
    private boolean fill;
    private float weight;

    public RowColumnParentData() {
        this(0.0f, false, null, 7, null);
    }

    public static /* synthetic */ RowColumnParentData copy$default(RowColumnParentData rowColumnParentData, float f10, boolean z10, CrossAxisAlignment crossAxisAlignment, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = rowColumnParentData.weight;
        }
        if ((i10 & 2) != 0) {
            z10 = rowColumnParentData.fill;
        }
        if ((i10 & 4) != 0) {
            crossAxisAlignment = rowColumnParentData.crossAxisAlignment;
        }
        return rowColumnParentData.copy(f10, z10, crossAxisAlignment);
    }

    public final float component1() {
        return this.weight;
    }

    public final boolean component2() {
        return this.fill;
    }

    @Nullable
    public final CrossAxisAlignment component3() {
        return this.crossAxisAlignment;
    }

    @NotNull
    public final RowColumnParentData copy(float f10, boolean z10, @Nullable CrossAxisAlignment crossAxisAlignment) {
        return new RowColumnParentData(f10, z10, crossAxisAlignment);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RowColumnParentData)) {
            return false;
        }
        RowColumnParentData rowColumnParentData = (RowColumnParentData) obj;
        return t.d(Float.valueOf(this.weight), Float.valueOf(rowColumnParentData.weight)) && this.fill == rowColumnParentData.fill && t.d(this.crossAxisAlignment, rowColumnParentData.crossAxisAlignment);
    }

    @Nullable
    public final CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    public final boolean getFill() {
        return this.fill;
    }

    public final float getWeight() {
        return this.weight;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iFloatToIntBits = Float.floatToIntBits(this.weight) * 31;
        boolean z10 = this.fill;
        ?? r12 = z10;
        if (z10) {
            r12 = 1;
        }
        int i10 = (iFloatToIntBits + r12) * 31;
        CrossAxisAlignment crossAxisAlignment = this.crossAxisAlignment;
        return i10 + (crossAxisAlignment == null ? 0 : crossAxisAlignment.hashCode());
    }

    public final void setCrossAxisAlignment(@Nullable CrossAxisAlignment crossAxisAlignment) {
        this.crossAxisAlignment = crossAxisAlignment;
    }

    public final void setFill(boolean z10) {
        this.fill = z10;
    }

    public final void setWeight(float f10) {
        this.weight = f10;
    }

    @NotNull
    public String toString() {
        return "RowColumnParentData(weight=" + this.weight + ", fill=" + this.fill + ", crossAxisAlignment=" + this.crossAxisAlignment + ')';
    }

    public RowColumnParentData(float f10, boolean z10, @Nullable CrossAxisAlignment crossAxisAlignment) {
        this.weight = f10;
        this.fill = z10;
        this.crossAxisAlignment = crossAxisAlignment;
    }

    public /* synthetic */ RowColumnParentData(float f10, boolean z10, CrossAxisAlignment crossAxisAlignment, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? 0.0f : f10, (i10 & 2) != 0 ? true : z10, (i10 & 4) != 0 ? null : crossAxisAlignment);
    }
}
