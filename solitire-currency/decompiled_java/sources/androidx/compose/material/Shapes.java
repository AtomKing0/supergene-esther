package androidx.compose.material;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Shapes.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class Shapes {

    @NotNull
    private final CornerBasedShape large;

    @NotNull
    private final CornerBasedShape medium;

    @NotNull
    private final CornerBasedShape small;

    public Shapes() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ Shapes copy$default(Shapes shapes, CornerBasedShape cornerBasedShape, CornerBasedShape cornerBasedShape2, CornerBasedShape cornerBasedShape3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cornerBasedShape = shapes.small;
        }
        if ((i10 & 2) != 0) {
            cornerBasedShape2 = shapes.medium;
        }
        if ((i10 & 4) != 0) {
            cornerBasedShape3 = shapes.large;
        }
        return shapes.copy(cornerBasedShape, cornerBasedShape2, cornerBasedShape3);
    }

    @NotNull
    public final Shapes copy(@NotNull CornerBasedShape small, @NotNull CornerBasedShape medium, @NotNull CornerBasedShape large) {
        t.i(small, "small");
        t.i(medium, "medium");
        t.i(large, "large");
        return new Shapes(small, medium, large);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Shapes)) {
            return false;
        }
        Shapes shapes = (Shapes) obj;
        return t.d(this.small, shapes.small) && t.d(this.medium, shapes.medium) && t.d(this.large, shapes.large);
    }

    @NotNull
    public final CornerBasedShape getLarge() {
        return this.large;
    }

    @NotNull
    public final CornerBasedShape getMedium() {
        return this.medium;
    }

    @NotNull
    public final CornerBasedShape getSmall() {
        return this.small;
    }

    public int hashCode() {
        return (((this.small.hashCode() * 31) + this.medium.hashCode()) * 31) + this.large.hashCode();
    }

    @NotNull
    public String toString() {
        return "Shapes(small=" + this.small + ", medium=" + this.medium + ", large=" + this.large + ')';
    }

    public Shapes(@NotNull CornerBasedShape small, @NotNull CornerBasedShape medium, @NotNull CornerBasedShape large) {
        t.i(small, "small");
        t.i(medium, "medium");
        t.i(large, "large");
        this.small = small;
        this.medium = medium;
        this.large = large;
    }

    public /* synthetic */ Shapes(CornerBasedShape cornerBasedShape, CornerBasedShape cornerBasedShape2, CornerBasedShape cornerBasedShape3, int i10, k kVar) {
        this((i10 & 1) != 0 ? RoundedCornerShapeKt.m646RoundedCornerShape0680j_4(Dp.m3673constructorimpl(4)) : cornerBasedShape, (i10 & 2) != 0 ? RoundedCornerShapeKt.m646RoundedCornerShape0680j_4(Dp.m3673constructorimpl(4)) : cornerBasedShape2, (i10 & 4) != 0 ? RoundedCornerShapeKt.m646RoundedCornerShape0680j_4(Dp.m3673constructorimpl(0)) : cornerBasedShape3);
    }
}
