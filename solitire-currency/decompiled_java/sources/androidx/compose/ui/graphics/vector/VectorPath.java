package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ImageVector.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class VectorPath extends VectorNode {

    @Nullable
    private final Brush fill;
    private final float fillAlpha;

    @NotNull
    private final String name;

    @NotNull
    private final List<PathNode> pathData;
    private final int pathFillType;

    @Nullable
    private final Brush stroke;
    private final float strokeAlpha;
    private final int strokeLineCap;
    private final int strokeLineJoin;
    private final float strokeLineMiter;
    private final float strokeLineWidth;
    private final float trimPathEnd;
    private final float trimPathOffset;
    private final float trimPathStart;

    public /* synthetic */ VectorPath(String str, List list, int i10, Brush brush, float f10, Brush brush2, float f11, float f12, int i11, int i12, float f13, float f14, float f15, float f16, k kVar) {
        this(str, list, i10, brush, f10, brush2, f11, f12, i11, i12, f13, f14, f15, f16);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !t.d(o0.b(VectorPath.class), o0.b(obj.getClass()))) {
            return false;
        }
        VectorPath vectorPath = (VectorPath) obj;
        if (!t.d(this.name, vectorPath.name) || !t.d(this.fill, vectorPath.fill)) {
            return false;
        }
        if (!(this.fillAlpha == vectorPath.fillAlpha) || !t.d(this.stroke, vectorPath.stroke)) {
            return false;
        }
        if (!(this.strokeAlpha == vectorPath.strokeAlpha)) {
            return false;
        }
        if (!(this.strokeLineWidth == vectorPath.strokeLineWidth) || !StrokeCap.m1881equalsimpl0(this.strokeLineCap, vectorPath.strokeLineCap) || !StrokeJoin.m1891equalsimpl0(this.strokeLineJoin, vectorPath.strokeLineJoin)) {
            return false;
        }
        if (!(this.strokeLineMiter == vectorPath.strokeLineMiter)) {
            return false;
        }
        if (!(this.trimPathStart == vectorPath.trimPathStart)) {
            return false;
        }
        if (this.trimPathEnd == vectorPath.trimPathEnd) {
            return ((this.trimPathOffset > vectorPath.trimPathOffset ? 1 : (this.trimPathOffset == vectorPath.trimPathOffset ? 0 : -1)) == 0) && PathFillType.m1820equalsimpl0(this.pathFillType, vectorPath.pathFillType) && t.d(this.pathData, vectorPath.pathData);
        }
        return false;
    }

    @Nullable
    public final Brush getFill() {
        return this.fill;
    }

    public final float getFillAlpha() {
        return this.fillAlpha;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final List<PathNode> getPathData() {
        return this.pathData;
    }

    /* JADX INFO: renamed from: getPathFillType-Rg-k1Os, reason: not valid java name */
    public final int m2131getPathFillTypeRgk1Os() {
        return this.pathFillType;
    }

    @Nullable
    public final Brush getStroke() {
        return this.stroke;
    }

    public final float getStrokeAlpha() {
        return this.strokeAlpha;
    }

    /* JADX INFO: renamed from: getStrokeLineCap-KaPHkGw, reason: not valid java name */
    public final int m2132getStrokeLineCapKaPHkGw() {
        return this.strokeLineCap;
    }

    /* JADX INFO: renamed from: getStrokeLineJoin-LxFBmk8, reason: not valid java name */
    public final int m2133getStrokeLineJoinLxFBmk8() {
        return this.strokeLineJoin;
    }

    public final float getStrokeLineMiter() {
        return this.strokeLineMiter;
    }

    public final float getStrokeLineWidth() {
        return this.strokeLineWidth;
    }

    public final float getTrimPathEnd() {
        return this.trimPathEnd;
    }

    public final float getTrimPathOffset() {
        return this.trimPathOffset;
    }

    public final float getTrimPathStart() {
        return this.trimPathStart;
    }

    public int hashCode() {
        int iHashCode = ((this.name.hashCode() * 31) + this.pathData.hashCode()) * 31;
        Brush brush = this.fill;
        int iHashCode2 = (((iHashCode + (brush != null ? brush.hashCode() : 0)) * 31) + Float.floatToIntBits(this.fillAlpha)) * 31;
        Brush brush2 = this.stroke;
        return ((((((((((((((((((iHashCode2 + (brush2 != null ? brush2.hashCode() : 0)) * 31) + Float.floatToIntBits(this.strokeAlpha)) * 31) + Float.floatToIntBits(this.strokeLineWidth)) * 31) + StrokeCap.m1882hashCodeimpl(this.strokeLineCap)) * 31) + StrokeJoin.m1892hashCodeimpl(this.strokeLineJoin)) * 31) + Float.floatToIntBits(this.strokeLineMiter)) * 31) + Float.floatToIntBits(this.trimPathStart)) * 31) + Float.floatToIntBits(this.trimPathEnd)) * 31) + Float.floatToIntBits(this.trimPathOffset)) * 31) + PathFillType.m1821hashCodeimpl(this.pathFillType);
    }

    public /* synthetic */ VectorPath(String str, List list, int i10, Brush brush, float f10, Brush brush2, float f11, float f12, int i11, int i12, float f13, float f14, float f15, float f16, int i13, k kVar) {
        this((i13 & 1) != 0 ? "" : str, list, i10, (i13 & 8) != 0 ? null : brush, (i13 & 16) != 0 ? 1.0f : f10, (i13 & 32) != 0 ? null : brush2, (i13 & 64) != 0 ? 1.0f : f11, (i13 & 128) != 0 ? 0.0f : f12, (i13 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : i11, (i13 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : i12, (i13 & 1024) != 0 ? 4.0f : f13, (i13 & 2048) != 0 ? 0.0f : f14, (i13 & 4096) != 0 ? 1.0f : f15, (i13 & 8192) != 0 ? 0.0f : f16, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private VectorPath(String str, List<? extends PathNode> list, int i10, Brush brush, float f10, Brush brush2, float f11, float f12, int i11, int i12, float f13, float f14, float f15, float f16) {
        super(null);
        this.name = str;
        this.pathData = list;
        this.pathFillType = i10;
        this.fill = brush;
        this.fillAlpha = f10;
        this.stroke = brush2;
        this.strokeAlpha = f11;
        this.strokeLineWidth = f12;
        this.strokeLineCap = i11;
        this.strokeLineJoin = i12;
        this.strokeLineMiter = f13;
        this.trimPathStart = f14;
        this.trimPathEnd = f15;
        this.trimPathOffset = f16;
    }
}
