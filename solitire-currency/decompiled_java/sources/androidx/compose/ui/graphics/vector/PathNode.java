package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PathNode.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public abstract class PathNode {
    private final boolean isCurve;
    private final boolean isQuad;

    /* JADX INFO: compiled from: PathNode.kt */
    @Immutable
    public static final class ArcTo extends PathNode {
        private final float arcStartX;
        private final float arcStartY;
        private final float horizontalEllipseRadius;
        private final boolean isMoreThanHalf;
        private final boolean isPositiveArc;
        private final float theta;
        private final float verticalEllipseRadius;

        /* JADX WARN: Illegal instructions before constructor call */
        public ArcTo(float f10, float f11, float f12, boolean z10, boolean z11, float f13, float f14) {
            boolean z12 = false;
            super(z12, z12, 3, null);
            this.horizontalEllipseRadius = f10;
            this.verticalEllipseRadius = f11;
            this.theta = f12;
            this.isMoreThanHalf = z10;
            this.isPositiveArc = z11;
            this.arcStartX = f13;
            this.arcStartY = f14;
        }

        public static /* synthetic */ ArcTo copy$default(ArcTo arcTo, float f10, float f11, float f12, boolean z10, boolean z11, float f13, float f14, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                f10 = arcTo.horizontalEllipseRadius;
            }
            if ((i10 & 2) != 0) {
                f11 = arcTo.verticalEllipseRadius;
            }
            float f15 = f11;
            if ((i10 & 4) != 0) {
                f12 = arcTo.theta;
            }
            float f16 = f12;
            if ((i10 & 8) != 0) {
                z10 = arcTo.isMoreThanHalf;
            }
            boolean z12 = z10;
            if ((i10 & 16) != 0) {
                z11 = arcTo.isPositiveArc;
            }
            boolean z13 = z11;
            if ((i10 & 32) != 0) {
                f13 = arcTo.arcStartX;
            }
            float f17 = f13;
            if ((i10 & 64) != 0) {
                f14 = arcTo.arcStartY;
            }
            return arcTo.copy(f10, f15, f16, z12, z13, f17, f14);
        }

        public final float component1() {
            return this.horizontalEllipseRadius;
        }

        public final float component2() {
            return this.verticalEllipseRadius;
        }

        public final float component3() {
            return this.theta;
        }

        public final boolean component4() {
            return this.isMoreThanHalf;
        }

        public final boolean component5() {
            return this.isPositiveArc;
        }

        public final float component6() {
            return this.arcStartX;
        }

        public final float component7() {
            return this.arcStartY;
        }

        @NotNull
        public final ArcTo copy(float f10, float f11, float f12, boolean z10, boolean z11, float f13, float f14) {
            return new ArcTo(f10, f11, f12, z10, z11, f13, f14);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ArcTo)) {
                return false;
            }
            ArcTo arcTo = (ArcTo) obj;
            return t.d(Float.valueOf(this.horizontalEllipseRadius), Float.valueOf(arcTo.horizontalEllipseRadius)) && t.d(Float.valueOf(this.verticalEllipseRadius), Float.valueOf(arcTo.verticalEllipseRadius)) && t.d(Float.valueOf(this.theta), Float.valueOf(arcTo.theta)) && this.isMoreThanHalf == arcTo.isMoreThanHalf && this.isPositiveArc == arcTo.isPositiveArc && t.d(Float.valueOf(this.arcStartX), Float.valueOf(arcTo.arcStartX)) && t.d(Float.valueOf(this.arcStartY), Float.valueOf(arcTo.arcStartY));
        }

        public final float getArcStartX() {
            return this.arcStartX;
        }

        public final float getArcStartY() {
            return this.arcStartY;
        }

        public final float getHorizontalEllipseRadius() {
            return this.horizontalEllipseRadius;
        }

        public final float getTheta() {
            return this.theta;
        }

        public final float getVerticalEllipseRadius() {
            return this.verticalEllipseRadius;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public int hashCode() {
            int iFloatToIntBits = ((((Float.floatToIntBits(this.horizontalEllipseRadius) * 31) + Float.floatToIntBits(this.verticalEllipseRadius)) * 31) + Float.floatToIntBits(this.theta)) * 31;
            boolean z10 = this.isMoreThanHalf;
            ?? r12 = z10;
            if (z10) {
                r12 = 1;
            }
            int i10 = (iFloatToIntBits + r12) * 31;
            boolean z11 = this.isPositiveArc;
            return ((((i10 + (z11 ? 1 : z11)) * 31) + Float.floatToIntBits(this.arcStartX)) * 31) + Float.floatToIntBits(this.arcStartY);
        }

        public final boolean isMoreThanHalf() {
            return this.isMoreThanHalf;
        }

        public final boolean isPositiveArc() {
            return this.isPositiveArc;
        }

        @NotNull
        public String toString() {
            return "ArcTo(horizontalEllipseRadius=" + this.horizontalEllipseRadius + ", verticalEllipseRadius=" + this.verticalEllipseRadius + ", theta=" + this.theta + ", isMoreThanHalf=" + this.isMoreThanHalf + ", isPositiveArc=" + this.isPositiveArc + ", arcStartX=" + this.arcStartX + ", arcStartY=" + this.arcStartY + ')';
        }
    }

    /* JADX INFO: compiled from: PathNode.kt */
    @Immutable
    public static final class Close extends PathNode {

        @NotNull
        public static final Close INSTANCE = new Close();

        /* JADX WARN: Illegal instructions before constructor call */
        private Close() {
            boolean z10 = false;
            super(z10, z10, 3, null);
        }
    }

    /* JADX INFO: compiled from: PathNode.kt */
    @Immutable
    public static final class CurveTo extends PathNode {

        /* JADX INFO: renamed from: x1, reason: collision with root package name */
        private final float f775x1;

        /* JADX INFO: renamed from: x2, reason: collision with root package name */
        private final float f776x2;

        /* JADX INFO: renamed from: x3, reason: collision with root package name */
        private final float f777x3;

        /* JADX INFO: renamed from: y1, reason: collision with root package name */
        private final float f778y1;

        /* JADX INFO: renamed from: y2, reason: collision with root package name */
        private final float f779y2;

        /* JADX INFO: renamed from: y3, reason: collision with root package name */
        private final float f780y3;

        public CurveTo(float f10, float f11, float f12, float f13, float f14, float f15) {
            super(true, false, 2, null);
            this.f775x1 = f10;
            this.f778y1 = f11;
            this.f776x2 = f12;
            this.f779y2 = f13;
            this.f777x3 = f14;
            this.f780y3 = f15;
        }

        public static /* synthetic */ CurveTo copy$default(CurveTo curveTo, float f10, float f11, float f12, float f13, float f14, float f15, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                f10 = curveTo.f775x1;
            }
            if ((i10 & 2) != 0) {
                f11 = curveTo.f778y1;
            }
            float f16 = f11;
            if ((i10 & 4) != 0) {
                f12 = curveTo.f776x2;
            }
            float f17 = f12;
            if ((i10 & 8) != 0) {
                f13 = curveTo.f779y2;
            }
            float f18 = f13;
            if ((i10 & 16) != 0) {
                f14 = curveTo.f777x3;
            }
            float f19 = f14;
            if ((i10 & 32) != 0) {
                f15 = curveTo.f780y3;
            }
            return curveTo.copy(f10, f16, f17, f18, f19, f15);
        }

        public final float component1() {
            return this.f775x1;
        }

        public final float component2() {
            return this.f778y1;
        }

        public final float component3() {
            return this.f776x2;
        }

        public final float component4() {
            return this.f779y2;
        }

        public final float component5() {
            return this.f777x3;
        }

        public final float component6() {
            return this.f780y3;
        }

        @NotNull
        public final CurveTo copy(float f10, float f11, float f12, float f13, float f14, float f15) {
            return new CurveTo(f10, f11, f12, f13, f14, f15);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CurveTo)) {
                return false;
            }
            CurveTo curveTo = (CurveTo) obj;
            return t.d(Float.valueOf(this.f775x1), Float.valueOf(curveTo.f775x1)) && t.d(Float.valueOf(this.f778y1), Float.valueOf(curveTo.f778y1)) && t.d(Float.valueOf(this.f776x2), Float.valueOf(curveTo.f776x2)) && t.d(Float.valueOf(this.f779y2), Float.valueOf(curveTo.f779y2)) && t.d(Float.valueOf(this.f777x3), Float.valueOf(curveTo.f777x3)) && t.d(Float.valueOf(this.f780y3), Float.valueOf(curveTo.f780y3));
        }

        public final float getX1() {
            return this.f775x1;
        }

        public final float getX2() {
            return this.f776x2;
        }

        public final float getX3() {
            return this.f777x3;
        }

        public final float getY1() {
            return this.f778y1;
        }

        public final float getY2() {
            return this.f779y2;
        }

        public final float getY3() {
            return this.f780y3;
        }

        public int hashCode() {
            return (((((((((Float.floatToIntBits(this.f775x1) * 31) + Float.floatToIntBits(this.f778y1)) * 31) + Float.floatToIntBits(this.f776x2)) * 31) + Float.floatToIntBits(this.f779y2)) * 31) + Float.floatToIntBits(this.f777x3)) * 31) + Float.floatToIntBits(this.f780y3);
        }

        @NotNull
        public String toString() {
            return "CurveTo(x1=" + this.f775x1 + ", y1=" + this.f778y1 + ", x2=" + this.f776x2 + ", y2=" + this.f779y2 + ", x3=" + this.f777x3 + ", y3=" + this.f780y3 + ')';
        }
    }

    /* JADX INFO: compiled from: PathNode.kt */
    @Immutable
    public static final class HorizontalTo extends PathNode {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final float f781x;

        /* JADX WARN: Illegal instructions before constructor call */
        public HorizontalTo(float f10) {
            boolean z10 = false;
            super(z10, z10, 3, null);
            this.f781x = f10;
        }

        public static /* synthetic */ HorizontalTo copy$default(HorizontalTo horizontalTo, float f10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                f10 = horizontalTo.f781x;
            }
            return horizontalTo.copy(f10);
        }

        public final float component1() {
            return this.f781x;
        }

        @NotNull
        public final HorizontalTo copy(float f10) {
            return new HorizontalTo(f10);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HorizontalTo) && t.d(Float.valueOf(this.f781x), Float.valueOf(((HorizontalTo) obj).f781x));
        }

        public final float getX() {
            return this.f781x;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f781x);
        }

        @NotNull
        public String toString() {
            return "HorizontalTo(x=" + this.f781x + ')';
        }
    }

    /* JADX INFO: compiled from: PathNode.kt */
    @Immutable
    public static final class LineTo extends PathNode {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final float f782x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private final float f783y;

        /* JADX WARN: Illegal instructions before constructor call */
        public LineTo(float f10, float f11) {
            boolean z10 = false;
            super(z10, z10, 3, null);
            this.f782x = f10;
            this.f783y = f11;
        }

        public static /* synthetic */ LineTo copy$default(LineTo lineTo, float f10, float f11, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                f10 = lineTo.f782x;
            }
            if ((i10 & 2) != 0) {
                f11 = lineTo.f783y;
            }
            return lineTo.copy(f10, f11);
        }

        public final float component1() {
            return this.f782x;
        }

        public final float component2() {
            return this.f783y;
        }

        @NotNull
        public final LineTo copy(float f10, float f11) {
            return new LineTo(f10, f11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LineTo)) {
                return false;
            }
            LineTo lineTo = (LineTo) obj;
            return t.d(Float.valueOf(this.f782x), Float.valueOf(lineTo.f782x)) && t.d(Float.valueOf(this.f783y), Float.valueOf(lineTo.f783y));
        }

        public final float getX() {
            return this.f782x;
        }

        public final float getY() {
            return this.f783y;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f782x) * 31) + Float.floatToIntBits(this.f783y);
        }

        @NotNull
        public String toString() {
            return "LineTo(x=" + this.f782x + ", y=" + this.f783y + ')';
        }
    }

    /* JADX INFO: compiled from: PathNode.kt */
    @Immutable
    public static final class MoveTo extends PathNode {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final float f784x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private final float f785y;

        /* JADX WARN: Illegal instructions before constructor call */
        public MoveTo(float f10, float f11) {
            boolean z10 = false;
            super(z10, z10, 3, null);
            this.f784x = f10;
            this.f785y = f11;
        }

        public static /* synthetic */ MoveTo copy$default(MoveTo moveTo, float f10, float f11, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                f10 = moveTo.f784x;
            }
            if ((i10 & 2) != 0) {
                f11 = moveTo.f785y;
            }
            return moveTo.copy(f10, f11);
        }

        public final float component1() {
            return this.f784x;
        }

        public final float component2() {
            return this.f785y;
        }

        @NotNull
        public final MoveTo copy(float f10, float f11) {
            return new MoveTo(f10, f11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MoveTo)) {
                return false;
            }
            MoveTo moveTo = (MoveTo) obj;
            return t.d(Float.valueOf(this.f784x), Float.valueOf(moveTo.f784x)) && t.d(Float.valueOf(this.f785y), Float.valueOf(moveTo.f785y));
        }

        public final float getX() {
            return this.f784x;
        }

        public final float getY() {
            return this.f785y;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f784x) * 31) + Float.floatToIntBits(this.f785y);
        }

        @NotNull
        public String toString() {
            return "MoveTo(x=" + this.f784x + ", y=" + this.f785y + ')';
        }
    }

    /* JADX INFO: compiled from: PathNode.kt */
    @Immutable
    public static final class QuadTo extends PathNode {

        /* JADX INFO: renamed from: x1, reason: collision with root package name */
        private final float f786x1;

        /* JADX INFO: renamed from: x2, reason: collision with root package name */
        private final float f787x2;

        /* JADX INFO: renamed from: y1, reason: collision with root package name */
        private final float f788y1;

        /* JADX INFO: renamed from: y2, reason: collision with root package name */
        private final float f789y2;

        public QuadTo(float f10, float f11, float f12, float f13) {
            super(false, true, 1 == true ? 1 : 0, null);
            this.f786x1 = f10;
            this.f788y1 = f11;
            this.f787x2 = f12;
            this.f789y2 = f13;
        }

        public static /* synthetic */ QuadTo copy$default(QuadTo quadTo, float f10, float f11, float f12, float f13, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                f10 = quadTo.f786x1;
            }
            if ((i10 & 2) != 0) {
                f11 = quadTo.f788y1;
            }
            if ((i10 & 4) != 0) {
                f12 = quadTo.f787x2;
            }
            if ((i10 & 8) != 0) {
                f13 = quadTo.f789y2;
            }
            return quadTo.copy(f10, f11, f12, f13);
        }

        public final float component1() {
            return this.f786x1;
        }

        public final float component2() {
            return this.f788y1;
        }

        public final float component3() {
            return this.f787x2;
        }

        public final float component4() {
            return this.f789y2;
        }

        @NotNull
        public final QuadTo copy(float f10, float f11, float f12, float f13) {
            return new QuadTo(f10, f11, f12, f13);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof QuadTo)) {
                return false;
            }
            QuadTo quadTo = (QuadTo) obj;
            return t.d(Float.valueOf(this.f786x1), Float.valueOf(quadTo.f786x1)) && t.d(Float.valueOf(this.f788y1), Float.valueOf(quadTo.f788y1)) && t.d(Float.valueOf(this.f787x2), Float.valueOf(quadTo.f787x2)) && t.d(Float.valueOf(this.f789y2), Float.valueOf(quadTo.f789y2));
        }

        public final float getX1() {
            return this.f786x1;
        }

        public final float getX2() {
            return this.f787x2;
        }

        public final float getY1() {
            return this.f788y1;
        }

        public final float getY2() {
            return this.f789y2;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.f786x1) * 31) + Float.floatToIntBits(this.f788y1)) * 31) + Float.floatToIntBits(this.f787x2)) * 31) + Float.floatToIntBits(this.f789y2);
        }

        @NotNull
        public String toString() {
            return "QuadTo(x1=" + this.f786x1 + ", y1=" + this.f788y1 + ", x2=" + this.f787x2 + ", y2=" + this.f789y2 + ')';
        }
    }

    /* JADX INFO: compiled from: PathNode.kt */
    @Immutable
    public static final class ReflectiveCurveTo extends PathNode {

        /* JADX INFO: renamed from: x1, reason: collision with root package name */
        private final float f790x1;

        /* JADX INFO: renamed from: x2, reason: collision with root package name */
        private final float f791x2;

        /* JADX INFO: renamed from: y1, reason: collision with root package name */
        private final float f792y1;

        /* JADX INFO: renamed from: y2, reason: collision with root package name */
        private final float f793y2;

        public ReflectiveCurveTo(float f10, float f11, float f12, float f13) {
            super(true, false, 2, null);
            this.f790x1 = f10;
            this.f792y1 = f11;
            this.f791x2 = f12;
            this.f793y2 = f13;
        }

        public static /* synthetic */ ReflectiveCurveTo copy$default(ReflectiveCurveTo reflectiveCurveTo, float f10, float f11, float f12, float f13, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                f10 = reflectiveCurveTo.f790x1;
            }
            if ((i10 & 2) != 0) {
                f11 = reflectiveCurveTo.f792y1;
            }
            if ((i10 & 4) != 0) {
                f12 = reflectiveCurveTo.f791x2;
            }
            if ((i10 & 8) != 0) {
                f13 = reflectiveCurveTo.f793y2;
            }
            return reflectiveCurveTo.copy(f10, f11, f12, f13);
        }

        public final float component1() {
            return this.f790x1;
        }

        public final float component2() {
            return this.f792y1;
        }

        public final float component3() {
            return this.f791x2;
        }

        public final float component4() {
            return this.f793y2;
        }

        @NotNull
        public final ReflectiveCurveTo copy(float f10, float f11, float f12, float f13) {
            return new ReflectiveCurveTo(f10, f11, f12, f13);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ReflectiveCurveTo)) {
                return false;
            }
            ReflectiveCurveTo reflectiveCurveTo = (ReflectiveCurveTo) obj;
            return t.d(Float.valueOf(this.f790x1), Float.valueOf(reflectiveCurveTo.f790x1)) && t.d(Float.valueOf(this.f792y1), Float.valueOf(reflectiveCurveTo.f792y1)) && t.d(Float.valueOf(this.f791x2), Float.valueOf(reflectiveCurveTo.f791x2)) && t.d(Float.valueOf(this.f793y2), Float.valueOf(reflectiveCurveTo.f793y2));
        }

        public final float getX1() {
            return this.f790x1;
        }

        public final float getX2() {
            return this.f791x2;
        }

        public final float getY1() {
            return this.f792y1;
        }

        public final float getY2() {
            return this.f793y2;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.f790x1) * 31) + Float.floatToIntBits(this.f792y1)) * 31) + Float.floatToIntBits(this.f791x2)) * 31) + Float.floatToIntBits(this.f793y2);
        }

        @NotNull
        public String toString() {
            return "ReflectiveCurveTo(x1=" + this.f790x1 + ", y1=" + this.f792y1 + ", x2=" + this.f791x2 + ", y2=" + this.f793y2 + ')';
        }
    }

    /* JADX INFO: compiled from: PathNode.kt */
    @Immutable
    public static final class ReflectiveQuadTo extends PathNode {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final float f794x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private final float f795y;

        public ReflectiveQuadTo(float f10, float f11) {
            super(false, true, 1 == true ? 1 : 0, null);
            this.f794x = f10;
            this.f795y = f11;
        }

        public static /* synthetic */ ReflectiveQuadTo copy$default(ReflectiveQuadTo reflectiveQuadTo, float f10, float f11, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                f10 = reflectiveQuadTo.f794x;
            }
            if ((i10 & 2) != 0) {
                f11 = reflectiveQuadTo.f795y;
            }
            return reflectiveQuadTo.copy(f10, f11);
        }

        public final float component1() {
            return this.f794x;
        }

        public final float component2() {
            return this.f795y;
        }

        @NotNull
        public final ReflectiveQuadTo copy(float f10, float f11) {
            return new ReflectiveQuadTo(f10, f11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ReflectiveQuadTo)) {
                return false;
            }
            ReflectiveQuadTo reflectiveQuadTo = (ReflectiveQuadTo) obj;
            return t.d(Float.valueOf(this.f794x), Float.valueOf(reflectiveQuadTo.f794x)) && t.d(Float.valueOf(this.f795y), Float.valueOf(reflectiveQuadTo.f795y));
        }

        public final float getX() {
            return this.f794x;
        }

        public final float getY() {
            return this.f795y;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.f794x) * 31) + Float.floatToIntBits(this.f795y);
        }

        @NotNull
        public String toString() {
            return "ReflectiveQuadTo(x=" + this.f794x + ", y=" + this.f795y + ')';
        }
    }

    /* JADX INFO: compiled from: PathNode.kt */
    @Immutable
    public static final class RelativeArcTo extends PathNode {
        private final float arcStartDx;
        private final float arcStartDy;
        private final float horizontalEllipseRadius;
        private final boolean isMoreThanHalf;
        private final boolean isPositiveArc;
        private final float theta;
        private final float verticalEllipseRadius;

        /* JADX WARN: Illegal instructions before constructor call */
        public RelativeArcTo(float f10, float f11, float f12, boolean z10, boolean z11, float f13, float f14) {
            boolean z12 = false;
            super(z12, z12, 3, null);
            this.horizontalEllipseRadius = f10;
            this.verticalEllipseRadius = f11;
            this.theta = f12;
            this.isMoreThanHalf = z10;
            this.isPositiveArc = z11;
            this.arcStartDx = f13;
            this.arcStartDy = f14;
        }

        public static /* synthetic */ RelativeArcTo copy$default(RelativeArcTo relativeArcTo, float f10, float f11, float f12, boolean z10, boolean z11, float f13, float f14, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                f10 = relativeArcTo.horizontalEllipseRadius;
            }
            if ((i10 & 2) != 0) {
                f11 = relativeArcTo.verticalEllipseRadius;
            }
            float f15 = f11;
            if ((i10 & 4) != 0) {
                f12 = relativeArcTo.theta;
            }
            float f16 = f12;
            if ((i10 & 8) != 0) {
                z10 = relativeArcTo.isMoreThanHalf;
            }
            boolean z12 = z10;
            if ((i10 & 16) != 0) {
                z11 = relativeArcTo.isPositiveArc;
            }
            boolean z13 = z11;
            if ((i10 & 32) != 0) {
                f13 = relativeArcTo.arcStartDx;
            }
            float f17 = f13;
            if ((i10 & 64) != 0) {
                f14 = relativeArcTo.arcStartDy;
            }
            return relativeArcTo.copy(f10, f15, f16, z12, z13, f17, f14);
        }

        public final float component1() {
            return this.horizontalEllipseRadius;
        }

        public final float component2() {
            return this.verticalEllipseRadius;
        }

        public final float component3() {
            return this.theta;
        }

        public final boolean component4() {
            return this.isMoreThanHalf;
        }

        public final boolean component5() {
            return this.isPositiveArc;
        }

        public final float component6() {
            return this.arcStartDx;
        }

        public final float component7() {
            return this.arcStartDy;
        }

        @NotNull
        public final RelativeArcTo copy(float f10, float f11, float f12, boolean z10, boolean z11, float f13, float f14) {
            return new RelativeArcTo(f10, f11, f12, z10, z11, f13, f14);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeArcTo)) {
                return false;
            }
            RelativeArcTo relativeArcTo = (RelativeArcTo) obj;
            return t.d(Float.valueOf(this.horizontalEllipseRadius), Float.valueOf(relativeArcTo.horizontalEllipseRadius)) && t.d(Float.valueOf(this.verticalEllipseRadius), Float.valueOf(relativeArcTo.verticalEllipseRadius)) && t.d(Float.valueOf(this.theta), Float.valueOf(relativeArcTo.theta)) && this.isMoreThanHalf == relativeArcTo.isMoreThanHalf && this.isPositiveArc == relativeArcTo.isPositiveArc && t.d(Float.valueOf(this.arcStartDx), Float.valueOf(relativeArcTo.arcStartDx)) && t.d(Float.valueOf(this.arcStartDy), Float.valueOf(relativeArcTo.arcStartDy));
        }

        public final float getArcStartDx() {
            return this.arcStartDx;
        }

        public final float getArcStartDy() {
            return this.arcStartDy;
        }

        public final float getHorizontalEllipseRadius() {
            return this.horizontalEllipseRadius;
        }

        public final float getTheta() {
            return this.theta;
        }

        public final float getVerticalEllipseRadius() {
            return this.verticalEllipseRadius;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public int hashCode() {
            int iFloatToIntBits = ((((Float.floatToIntBits(this.horizontalEllipseRadius) * 31) + Float.floatToIntBits(this.verticalEllipseRadius)) * 31) + Float.floatToIntBits(this.theta)) * 31;
            boolean z10 = this.isMoreThanHalf;
            ?? r12 = z10;
            if (z10) {
                r12 = 1;
            }
            int i10 = (iFloatToIntBits + r12) * 31;
            boolean z11 = this.isPositiveArc;
            return ((((i10 + (z11 ? 1 : z11)) * 31) + Float.floatToIntBits(this.arcStartDx)) * 31) + Float.floatToIntBits(this.arcStartDy);
        }

        public final boolean isMoreThanHalf() {
            return this.isMoreThanHalf;
        }

        public final boolean isPositiveArc() {
            return this.isPositiveArc;
        }

        @NotNull
        public String toString() {
            return "RelativeArcTo(horizontalEllipseRadius=" + this.horizontalEllipseRadius + ", verticalEllipseRadius=" + this.verticalEllipseRadius + ", theta=" + this.theta + ", isMoreThanHalf=" + this.isMoreThanHalf + ", isPositiveArc=" + this.isPositiveArc + ", arcStartDx=" + this.arcStartDx + ", arcStartDy=" + this.arcStartDy + ')';
        }
    }

    /* JADX INFO: compiled from: PathNode.kt */
    @Immutable
    public static final class RelativeCurveTo extends PathNode {
        private final float dx1;
        private final float dx2;
        private final float dx3;
        private final float dy1;
        private final float dy2;
        private final float dy3;

        public RelativeCurveTo(float f10, float f11, float f12, float f13, float f14, float f15) {
            super(true, false, 2, null);
            this.dx1 = f10;
            this.dy1 = f11;
            this.dx2 = f12;
            this.dy2 = f13;
            this.dx3 = f14;
            this.dy3 = f15;
        }

        public static /* synthetic */ RelativeCurveTo copy$default(RelativeCurveTo relativeCurveTo, float f10, float f11, float f12, float f13, float f14, float f15, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                f10 = relativeCurveTo.dx1;
            }
            if ((i10 & 2) != 0) {
                f11 = relativeCurveTo.dy1;
            }
            float f16 = f11;
            if ((i10 & 4) != 0) {
                f12 = relativeCurveTo.dx2;
            }
            float f17 = f12;
            if ((i10 & 8) != 0) {
                f13 = relativeCurveTo.dy2;
            }
            float f18 = f13;
            if ((i10 & 16) != 0) {
                f14 = relativeCurveTo.dx3;
            }
            float f19 = f14;
            if ((i10 & 32) != 0) {
                f15 = relativeCurveTo.dy3;
            }
            return relativeCurveTo.copy(f10, f16, f17, f18, f19, f15);
        }

        public final float component1() {
            return this.dx1;
        }

        public final float component2() {
            return this.dy1;
        }

        public final float component3() {
            return this.dx2;
        }

        public final float component4() {
            return this.dy2;
        }

        public final float component5() {
            return this.dx3;
        }

        public final float component6() {
            return this.dy3;
        }

        @NotNull
        public final RelativeCurveTo copy(float f10, float f11, float f12, float f13, float f14, float f15) {
            return new RelativeCurveTo(f10, f11, f12, f13, f14, f15);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeCurveTo)) {
                return false;
            }
            RelativeCurveTo relativeCurveTo = (RelativeCurveTo) obj;
            return t.d(Float.valueOf(this.dx1), Float.valueOf(relativeCurveTo.dx1)) && t.d(Float.valueOf(this.dy1), Float.valueOf(relativeCurveTo.dy1)) && t.d(Float.valueOf(this.dx2), Float.valueOf(relativeCurveTo.dx2)) && t.d(Float.valueOf(this.dy2), Float.valueOf(relativeCurveTo.dy2)) && t.d(Float.valueOf(this.dx3), Float.valueOf(relativeCurveTo.dx3)) && t.d(Float.valueOf(this.dy3), Float.valueOf(relativeCurveTo.dy3));
        }

        public final float getDx1() {
            return this.dx1;
        }

        public final float getDx2() {
            return this.dx2;
        }

        public final float getDx3() {
            return this.dx3;
        }

        public final float getDy1() {
            return this.dy1;
        }

        public final float getDy2() {
            return this.dy2;
        }

        public final float getDy3() {
            return this.dy3;
        }

        public int hashCode() {
            return (((((((((Float.floatToIntBits(this.dx1) * 31) + Float.floatToIntBits(this.dy1)) * 31) + Float.floatToIntBits(this.dx2)) * 31) + Float.floatToIntBits(this.dy2)) * 31) + Float.floatToIntBits(this.dx3)) * 31) + Float.floatToIntBits(this.dy3);
        }

        @NotNull
        public String toString() {
            return "RelativeCurveTo(dx1=" + this.dx1 + ", dy1=" + this.dy1 + ", dx2=" + this.dx2 + ", dy2=" + this.dy2 + ", dx3=" + this.dx3 + ", dy3=" + this.dy3 + ')';
        }
    }

    /* JADX INFO: compiled from: PathNode.kt */
    @Immutable
    public static final class RelativeHorizontalTo extends PathNode {
        private final float dx;

        /* JADX WARN: Illegal instructions before constructor call */
        public RelativeHorizontalTo(float f10) {
            boolean z10 = false;
            super(z10, z10, 3, null);
            this.dx = f10;
        }

        public static /* synthetic */ RelativeHorizontalTo copy$default(RelativeHorizontalTo relativeHorizontalTo, float f10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                f10 = relativeHorizontalTo.dx;
            }
            return relativeHorizontalTo.copy(f10);
        }

        public final float component1() {
            return this.dx;
        }

        @NotNull
        public final RelativeHorizontalTo copy(float f10) {
            return new RelativeHorizontalTo(f10);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RelativeHorizontalTo) && t.d(Float.valueOf(this.dx), Float.valueOf(((RelativeHorizontalTo) obj).dx));
        }

        public final float getDx() {
            return this.dx;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.dx);
        }

        @NotNull
        public String toString() {
            return "RelativeHorizontalTo(dx=" + this.dx + ')';
        }
    }

    /* JADX INFO: compiled from: PathNode.kt */
    @Immutable
    public static final class RelativeLineTo extends PathNode {
        private final float dx;
        private final float dy;

        /* JADX WARN: Illegal instructions before constructor call */
        public RelativeLineTo(float f10, float f11) {
            boolean z10 = false;
            super(z10, z10, 3, null);
            this.dx = f10;
            this.dy = f11;
        }

        public static /* synthetic */ RelativeLineTo copy$default(RelativeLineTo relativeLineTo, float f10, float f11, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                f10 = relativeLineTo.dx;
            }
            if ((i10 & 2) != 0) {
                f11 = relativeLineTo.dy;
            }
            return relativeLineTo.copy(f10, f11);
        }

        public final float component1() {
            return this.dx;
        }

        public final float component2() {
            return this.dy;
        }

        @NotNull
        public final RelativeLineTo copy(float f10, float f11) {
            return new RelativeLineTo(f10, f11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeLineTo)) {
                return false;
            }
            RelativeLineTo relativeLineTo = (RelativeLineTo) obj;
            return t.d(Float.valueOf(this.dx), Float.valueOf(relativeLineTo.dx)) && t.d(Float.valueOf(this.dy), Float.valueOf(relativeLineTo.dy));
        }

        public final float getDx() {
            return this.dx;
        }

        public final float getDy() {
            return this.dy;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.dx) * 31) + Float.floatToIntBits(this.dy);
        }

        @NotNull
        public String toString() {
            return "RelativeLineTo(dx=" + this.dx + ", dy=" + this.dy + ')';
        }
    }

    /* JADX INFO: compiled from: PathNode.kt */
    @Immutable
    public static final class RelativeMoveTo extends PathNode {
        private final float dx;
        private final float dy;

        /* JADX WARN: Illegal instructions before constructor call */
        public RelativeMoveTo(float f10, float f11) {
            boolean z10 = false;
            super(z10, z10, 3, null);
            this.dx = f10;
            this.dy = f11;
        }

        public static /* synthetic */ RelativeMoveTo copy$default(RelativeMoveTo relativeMoveTo, float f10, float f11, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                f10 = relativeMoveTo.dx;
            }
            if ((i10 & 2) != 0) {
                f11 = relativeMoveTo.dy;
            }
            return relativeMoveTo.copy(f10, f11);
        }

        public final float component1() {
            return this.dx;
        }

        public final float component2() {
            return this.dy;
        }

        @NotNull
        public final RelativeMoveTo copy(float f10, float f11) {
            return new RelativeMoveTo(f10, f11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeMoveTo)) {
                return false;
            }
            RelativeMoveTo relativeMoveTo = (RelativeMoveTo) obj;
            return t.d(Float.valueOf(this.dx), Float.valueOf(relativeMoveTo.dx)) && t.d(Float.valueOf(this.dy), Float.valueOf(relativeMoveTo.dy));
        }

        public final float getDx() {
            return this.dx;
        }

        public final float getDy() {
            return this.dy;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.dx) * 31) + Float.floatToIntBits(this.dy);
        }

        @NotNull
        public String toString() {
            return "RelativeMoveTo(dx=" + this.dx + ", dy=" + this.dy + ')';
        }
    }

    /* JADX INFO: compiled from: PathNode.kt */
    @Immutable
    public static final class RelativeQuadTo extends PathNode {
        private final float dx1;
        private final float dx2;
        private final float dy1;
        private final float dy2;

        public RelativeQuadTo(float f10, float f11, float f12, float f13) {
            super(false, true, 1 == true ? 1 : 0, null);
            this.dx1 = f10;
            this.dy1 = f11;
            this.dx2 = f12;
            this.dy2 = f13;
        }

        public static /* synthetic */ RelativeQuadTo copy$default(RelativeQuadTo relativeQuadTo, float f10, float f11, float f12, float f13, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                f10 = relativeQuadTo.dx1;
            }
            if ((i10 & 2) != 0) {
                f11 = relativeQuadTo.dy1;
            }
            if ((i10 & 4) != 0) {
                f12 = relativeQuadTo.dx2;
            }
            if ((i10 & 8) != 0) {
                f13 = relativeQuadTo.dy2;
            }
            return relativeQuadTo.copy(f10, f11, f12, f13);
        }

        public final float component1() {
            return this.dx1;
        }

        public final float component2() {
            return this.dy1;
        }

        public final float component3() {
            return this.dx2;
        }

        public final float component4() {
            return this.dy2;
        }

        @NotNull
        public final RelativeQuadTo copy(float f10, float f11, float f12, float f13) {
            return new RelativeQuadTo(f10, f11, f12, f13);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeQuadTo)) {
                return false;
            }
            RelativeQuadTo relativeQuadTo = (RelativeQuadTo) obj;
            return t.d(Float.valueOf(this.dx1), Float.valueOf(relativeQuadTo.dx1)) && t.d(Float.valueOf(this.dy1), Float.valueOf(relativeQuadTo.dy1)) && t.d(Float.valueOf(this.dx2), Float.valueOf(relativeQuadTo.dx2)) && t.d(Float.valueOf(this.dy2), Float.valueOf(relativeQuadTo.dy2));
        }

        public final float getDx1() {
            return this.dx1;
        }

        public final float getDx2() {
            return this.dx2;
        }

        public final float getDy1() {
            return this.dy1;
        }

        public final float getDy2() {
            return this.dy2;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.dx1) * 31) + Float.floatToIntBits(this.dy1)) * 31) + Float.floatToIntBits(this.dx2)) * 31) + Float.floatToIntBits(this.dy2);
        }

        @NotNull
        public String toString() {
            return "RelativeQuadTo(dx1=" + this.dx1 + ", dy1=" + this.dy1 + ", dx2=" + this.dx2 + ", dy2=" + this.dy2 + ')';
        }
    }

    /* JADX INFO: compiled from: PathNode.kt */
    @Immutable
    public static final class RelativeReflectiveCurveTo extends PathNode {
        private final float dx1;
        private final float dx2;
        private final float dy1;
        private final float dy2;

        public RelativeReflectiveCurveTo(float f10, float f11, float f12, float f13) {
            super(true, false, 2, null);
            this.dx1 = f10;
            this.dy1 = f11;
            this.dx2 = f12;
            this.dy2 = f13;
        }

        public static /* synthetic */ RelativeReflectiveCurveTo copy$default(RelativeReflectiveCurveTo relativeReflectiveCurveTo, float f10, float f11, float f12, float f13, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                f10 = relativeReflectiveCurveTo.dx1;
            }
            if ((i10 & 2) != 0) {
                f11 = relativeReflectiveCurveTo.dy1;
            }
            if ((i10 & 4) != 0) {
                f12 = relativeReflectiveCurveTo.dx2;
            }
            if ((i10 & 8) != 0) {
                f13 = relativeReflectiveCurveTo.dy2;
            }
            return relativeReflectiveCurveTo.copy(f10, f11, f12, f13);
        }

        public final float component1() {
            return this.dx1;
        }

        public final float component2() {
            return this.dy1;
        }

        public final float component3() {
            return this.dx2;
        }

        public final float component4() {
            return this.dy2;
        }

        @NotNull
        public final RelativeReflectiveCurveTo copy(float f10, float f11, float f12, float f13) {
            return new RelativeReflectiveCurveTo(f10, f11, f12, f13);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeReflectiveCurveTo)) {
                return false;
            }
            RelativeReflectiveCurveTo relativeReflectiveCurveTo = (RelativeReflectiveCurveTo) obj;
            return t.d(Float.valueOf(this.dx1), Float.valueOf(relativeReflectiveCurveTo.dx1)) && t.d(Float.valueOf(this.dy1), Float.valueOf(relativeReflectiveCurveTo.dy1)) && t.d(Float.valueOf(this.dx2), Float.valueOf(relativeReflectiveCurveTo.dx2)) && t.d(Float.valueOf(this.dy2), Float.valueOf(relativeReflectiveCurveTo.dy2));
        }

        public final float getDx1() {
            return this.dx1;
        }

        public final float getDx2() {
            return this.dx2;
        }

        public final float getDy1() {
            return this.dy1;
        }

        public final float getDy2() {
            return this.dy2;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.dx1) * 31) + Float.floatToIntBits(this.dy1)) * 31) + Float.floatToIntBits(this.dx2)) * 31) + Float.floatToIntBits(this.dy2);
        }

        @NotNull
        public String toString() {
            return "RelativeReflectiveCurveTo(dx1=" + this.dx1 + ", dy1=" + this.dy1 + ", dx2=" + this.dx2 + ", dy2=" + this.dy2 + ')';
        }
    }

    /* JADX INFO: compiled from: PathNode.kt */
    @Immutable
    public static final class RelativeReflectiveQuadTo extends PathNode {
        private final float dx;
        private final float dy;

        public RelativeReflectiveQuadTo(float f10, float f11) {
            super(false, true, 1 == true ? 1 : 0, null);
            this.dx = f10;
            this.dy = f11;
        }

        public static /* synthetic */ RelativeReflectiveQuadTo copy$default(RelativeReflectiveQuadTo relativeReflectiveQuadTo, float f10, float f11, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                f10 = relativeReflectiveQuadTo.dx;
            }
            if ((i10 & 2) != 0) {
                f11 = relativeReflectiveQuadTo.dy;
            }
            return relativeReflectiveQuadTo.copy(f10, f11);
        }

        public final float component1() {
            return this.dx;
        }

        public final float component2() {
            return this.dy;
        }

        @NotNull
        public final RelativeReflectiveQuadTo copy(float f10, float f11) {
            return new RelativeReflectiveQuadTo(f10, f11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeReflectiveQuadTo)) {
                return false;
            }
            RelativeReflectiveQuadTo relativeReflectiveQuadTo = (RelativeReflectiveQuadTo) obj;
            return t.d(Float.valueOf(this.dx), Float.valueOf(relativeReflectiveQuadTo.dx)) && t.d(Float.valueOf(this.dy), Float.valueOf(relativeReflectiveQuadTo.dy));
        }

        public final float getDx() {
            return this.dx;
        }

        public final float getDy() {
            return this.dy;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.dx) * 31) + Float.floatToIntBits(this.dy);
        }

        @NotNull
        public String toString() {
            return "RelativeReflectiveQuadTo(dx=" + this.dx + ", dy=" + this.dy + ')';
        }
    }

    /* JADX INFO: compiled from: PathNode.kt */
    @Immutable
    public static final class RelativeVerticalTo extends PathNode {
        private final float dy;

        /* JADX WARN: Illegal instructions before constructor call */
        public RelativeVerticalTo(float f10) {
            boolean z10 = false;
            super(z10, z10, 3, null);
            this.dy = f10;
        }

        public static /* synthetic */ RelativeVerticalTo copy$default(RelativeVerticalTo relativeVerticalTo, float f10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                f10 = relativeVerticalTo.dy;
            }
            return relativeVerticalTo.copy(f10);
        }

        public final float component1() {
            return this.dy;
        }

        @NotNull
        public final RelativeVerticalTo copy(float f10) {
            return new RelativeVerticalTo(f10);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RelativeVerticalTo) && t.d(Float.valueOf(this.dy), Float.valueOf(((RelativeVerticalTo) obj).dy));
        }

        public final float getDy() {
            return this.dy;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.dy);
        }

        @NotNull
        public String toString() {
            return "RelativeVerticalTo(dy=" + this.dy + ')';
        }
    }

    /* JADX INFO: compiled from: PathNode.kt */
    @Immutable
    public static final class VerticalTo extends PathNode {

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private final float f796y;

        /* JADX WARN: Illegal instructions before constructor call */
        public VerticalTo(float f10) {
            boolean z10 = false;
            super(z10, z10, 3, null);
            this.f796y = f10;
        }

        public static /* synthetic */ VerticalTo copy$default(VerticalTo verticalTo, float f10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                f10 = verticalTo.f796y;
            }
            return verticalTo.copy(f10);
        }

        public final float component1() {
            return this.f796y;
        }

        @NotNull
        public final VerticalTo copy(float f10) {
            return new VerticalTo(f10);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof VerticalTo) && t.d(Float.valueOf(this.f796y), Float.valueOf(((VerticalTo) obj).f796y));
        }

        public final float getY() {
            return this.f796y;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f796y);
        }

        @NotNull
        public String toString() {
            return "VerticalTo(y=" + this.f796y + ')';
        }
    }

    public /* synthetic */ PathNode(boolean z10, boolean z11, k kVar) {
        this(z10, z11);
    }

    public final boolean isCurve() {
        return this.isCurve;
    }

    public final boolean isQuad() {
        return this.isQuad;
    }

    private PathNode(boolean z10, boolean z11) {
        this.isCurve = z10;
        this.isQuad = z11;
    }

    public /* synthetic */ PathNode(boolean z10, boolean z11, int i10, k kVar) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? false : z11, null);
    }
}
