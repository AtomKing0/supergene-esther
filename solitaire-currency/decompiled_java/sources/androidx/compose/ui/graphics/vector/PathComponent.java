package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathMeasure;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.drawscope.b;
import androidx.compose.ui.graphics.f1;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.l;
import v8.n;
import v8.p;

/* JADX INFO: compiled from: Vector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PathComponent extends VNode {

    @Nullable
    private Brush fill;
    private float fillAlpha;
    private boolean isPathDirty;
    private boolean isStrokeDirty;
    private boolean isTrimPathDirty;

    @NotNull
    private String name;

    @NotNull
    private final PathParser parser;

    @NotNull
    private final Path path;

    @NotNull
    private List<? extends PathNode> pathData;
    private int pathFillType;

    @NotNull
    private final l pathMeasure$delegate;

    @NotNull
    private final Path renderPath;

    @Nullable
    private Brush stroke;
    private float strokeAlpha;
    private int strokeLineCap;
    private int strokeLineJoin;
    private float strokeLineMiter;
    private float strokeLineWidth;

    @Nullable
    private Stroke strokeStyle;
    private float trimPathEnd;
    private float trimPathOffset;
    private float trimPathStart;

    public PathComponent() {
        super(null);
        this.name = "";
        this.fillAlpha = 1.0f;
        this.pathData = VectorKt.getEmptyPath();
        this.pathFillType = VectorKt.getDefaultFillType();
        this.strokeAlpha = 1.0f;
        this.strokeLineCap = VectorKt.getDefaultStrokeLineCap();
        this.strokeLineJoin = VectorKt.getDefaultStrokeLineJoin();
        this.strokeLineMiter = 4.0f;
        this.trimPathEnd = 1.0f;
        this.isPathDirty = true;
        this.isStrokeDirty = true;
        this.isTrimPathDirty = true;
        this.path = AndroidPath_androidKt.Path();
        this.renderPath = AndroidPath_androidKt.Path();
        this.pathMeasure$delegate = n.b(p.f35203c, PathComponent$pathMeasure$2.INSTANCE);
        this.parser = new PathParser();
    }

    private final PathMeasure getPathMeasure() {
        return (PathMeasure) this.pathMeasure$delegate.getValue();
    }

    private final void updatePath() {
        this.parser.clear();
        this.path.reset();
        this.parser.addPathNodes(this.pathData).toPath(this.path);
        updateRenderPath();
    }

    private final void updateRenderPath() {
        this.renderPath.reset();
        if (this.trimPathStart == 0.0f) {
            if (this.trimPathEnd == 1.0f) {
                f1.c(this.renderPath, this.path, 0L, 2, null);
                return;
            }
        }
        getPathMeasure().setPath(this.path, false);
        float length = getPathMeasure().getLength();
        float f10 = this.trimPathStart;
        float f11 = this.trimPathOffset;
        float f12 = ((f10 + f11) % 1.0f) * length;
        float f13 = ((this.trimPathEnd + f11) % 1.0f) * length;
        if (f12 <= f13) {
            getPathMeasure().getSegment(f12, f13, this.renderPath, true);
        } else {
            getPathMeasure().getSegment(f12, length, this.renderPath, true);
            getPathMeasure().getSegment(0.0f, f13, this.renderPath, true);
        }
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public void draw(@NotNull DrawScope drawScope) {
        t.i(drawScope, "<this>");
        if (this.isPathDirty) {
            updatePath();
        } else if (this.isTrimPathDirty) {
            updateRenderPath();
        }
        this.isPathDirty = false;
        this.isTrimPathDirty = false;
        Brush brush = this.fill;
        if (brush != null) {
            b.F(drawScope, this.renderPath, brush, this.fillAlpha, null, null, 0, 56, null);
        }
        Brush brush2 = this.stroke;
        if (brush2 != null) {
            Stroke stroke = this.strokeStyle;
            if (this.isStrokeDirty || stroke == null) {
                stroke = new Stroke(this.strokeLineWidth, this.strokeLineMiter, this.strokeLineCap, this.strokeLineJoin, null, 16, null);
                this.strokeStyle = stroke;
                this.isStrokeDirty = false;
            }
            b.F(drawScope, this.renderPath, brush2, this.strokeAlpha, stroke, null, 0, 48, null);
        }
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
    public final int m2105getPathFillTypeRgk1Os() {
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
    public final int m2106getStrokeLineCapKaPHkGw() {
        return this.strokeLineCap;
    }

    /* JADX INFO: renamed from: getStrokeLineJoin-LxFBmk8, reason: not valid java name */
    public final int m2107getStrokeLineJoinLxFBmk8() {
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

    public final void setFill(@Nullable Brush brush) {
        this.fill = brush;
        invalidate();
    }

    public final void setFillAlpha(float f10) {
        this.fillAlpha = f10;
        invalidate();
    }

    public final void setName(@NotNull String value) {
        t.i(value, "value");
        this.name = value;
        invalidate();
    }

    public final void setPathData(@NotNull List<? extends PathNode> value) {
        t.i(value, "value");
        this.pathData = value;
        this.isPathDirty = true;
        invalidate();
    }

    /* JADX INFO: renamed from: setPathFillType-oQ8Xj4U, reason: not valid java name */
    public final void m2108setPathFillTypeoQ8Xj4U(int i10) {
        this.pathFillType = i10;
        this.renderPath.mo1502setFillTypeoQ8Xj4U(i10);
        invalidate();
    }

    public final void setStroke(@Nullable Brush brush) {
        this.stroke = brush;
        invalidate();
    }

    public final void setStrokeAlpha(float f10) {
        this.strokeAlpha = f10;
        invalidate();
    }

    /* JADX INFO: renamed from: setStrokeLineCap-BeK7IIE, reason: not valid java name */
    public final void m2109setStrokeLineCapBeK7IIE(int i10) {
        this.strokeLineCap = i10;
        this.isStrokeDirty = true;
        invalidate();
    }

    /* JADX INFO: renamed from: setStrokeLineJoin-Ww9F2mQ, reason: not valid java name */
    public final void m2110setStrokeLineJoinWw9F2mQ(int i10) {
        this.strokeLineJoin = i10;
        this.isStrokeDirty = true;
        invalidate();
    }

    public final void setStrokeLineMiter(float f10) {
        this.strokeLineMiter = f10;
        this.isStrokeDirty = true;
        invalidate();
    }

    public final void setStrokeLineWidth(float f10) {
        this.strokeLineWidth = f10;
        invalidate();
    }

    public final void setTrimPathEnd(float f10) {
        if (this.trimPathEnd == f10) {
            return;
        }
        this.trimPathEnd = f10;
        this.isTrimPathDirty = true;
        invalidate();
    }

    public final void setTrimPathOffset(float f10) {
        if (this.trimPathOffset == f10) {
            return;
        }
        this.trimPathOffset = f10;
        this.isTrimPathDirty = true;
        invalidate();
    }

    public final void setTrimPathStart(float f10) {
        if (this.trimPathStart == f10) {
            return;
        }
        this.trimPathStart = f10;
        this.isTrimPathDirty = true;
        invalidate();
    }

    @NotNull
    public String toString() {
        return this.path.toString();
    }
}
