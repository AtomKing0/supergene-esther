package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.LayoutDirection;
import h9.l;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.q;

/* JADX INFO: compiled from: CanvasDrawScope.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CanvasDrawScope implements DrawScope {

    @Nullable
    private Paint fillPaint;

    @Nullable
    private Paint strokePaint;

    @NotNull
    private final DrawParams drawParams = new DrawParams(null, null, null, 0, 15, null);

    @NotNull
    private final DrawContext drawContext = new DrawContext() { // from class: androidx.compose.ui.graphics.drawscope.CanvasDrawScope$drawContext$1

        @NotNull
        private final DrawTransform transform = CanvasDrawScopeKt.asDrawTransform(this);

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        @NotNull
        public Canvas getCanvas() {
            return this.this$0.getDrawParams().getCanvas();
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public long mo2002getSizeNHjbRc() {
            return this.this$0.getDrawParams().m2000getSizeNHjbRc();
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        @NotNull
        public DrawTransform getTransform() {
            return this.transform;
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawContext
        /* JADX INFO: renamed from: setSize-uvyYCjk, reason: not valid java name */
        public void mo2003setSizeuvyYCjk(long j10) {
            this.this$0.getDrawParams().m2001setSizeuvyYCjk(j10);
        }
    };

    /* JADX INFO: compiled from: CanvasDrawScope.kt */
    public static final class DrawParams {

        @NotNull
        private Canvas canvas;

        @NotNull
        private Density density;

        @NotNull
        private LayoutDirection layoutDirection;
        private long size;

        public /* synthetic */ DrawParams(Density density, LayoutDirection layoutDirection, Canvas canvas, long j10, k kVar) {
            this(density, layoutDirection, canvas, j10);
        }

        /* JADX INFO: renamed from: copy-Ug5Nnss$default, reason: not valid java name */
        public static /* synthetic */ DrawParams m1997copyUg5Nnss$default(DrawParams drawParams, Density density, LayoutDirection layoutDirection, Canvas canvas, long j10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                density = drawParams.density;
            }
            if ((i10 & 2) != 0) {
                layoutDirection = drawParams.layoutDirection;
            }
            LayoutDirection layoutDirection2 = layoutDirection;
            if ((i10 & 4) != 0) {
                canvas = drawParams.canvas;
            }
            Canvas canvas2 = canvas;
            if ((i10 & 8) != 0) {
                j10 = drawParams.size;
            }
            return drawParams.m1999copyUg5Nnss(density, layoutDirection2, canvas2, j10);
        }

        @NotNull
        public final Density component1() {
            return this.density;
        }

        @NotNull
        public final LayoutDirection component2() {
            return this.layoutDirection;
        }

        @NotNull
        public final Canvas component3() {
            return this.canvas;
        }

        /* JADX INFO: renamed from: component4-NH-jbRc, reason: not valid java name */
        public final long m1998component4NHjbRc() {
            return this.size;
        }

        @NotNull
        /* JADX INFO: renamed from: copy-Ug5Nnss, reason: not valid java name */
        public final DrawParams m1999copyUg5Nnss(@NotNull Density density, @NotNull LayoutDirection layoutDirection, @NotNull Canvas canvas, long j10) {
            t.i(density, "density");
            t.i(layoutDirection, "layoutDirection");
            t.i(canvas, "canvas");
            return new DrawParams(density, layoutDirection, canvas, j10, null);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DrawParams)) {
                return false;
            }
            DrawParams drawParams = (DrawParams) obj;
            return t.d(this.density, drawParams.density) && this.layoutDirection == drawParams.layoutDirection && t.d(this.canvas, drawParams.canvas) && Size.m1432equalsimpl0(this.size, drawParams.size);
        }

        @NotNull
        public final Canvas getCanvas() {
            return this.canvas;
        }

        @NotNull
        public final Density getDensity() {
            return this.density;
        }

        @NotNull
        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public final long m2000getSizeNHjbRc() {
            return this.size;
        }

        public int hashCode() {
            return (((((this.density.hashCode() * 31) + this.layoutDirection.hashCode()) * 31) + this.canvas.hashCode()) * 31) + Size.m1437hashCodeimpl(this.size);
        }

        public final void setCanvas(@NotNull Canvas canvas) {
            t.i(canvas, "<set-?>");
            this.canvas = canvas;
        }

        public final void setDensity(@NotNull Density density) {
            t.i(density, "<set-?>");
            this.density = density;
        }

        public final void setLayoutDirection(@NotNull LayoutDirection layoutDirection) {
            t.i(layoutDirection, "<set-?>");
            this.layoutDirection = layoutDirection;
        }

        /* JADX INFO: renamed from: setSize-uvyYCjk, reason: not valid java name */
        public final void m2001setSizeuvyYCjk(long j10) {
            this.size = j10;
        }

        @NotNull
        public String toString() {
            return "DrawParams(density=" + this.density + ", layoutDirection=" + this.layoutDirection + ", canvas=" + this.canvas + ", size=" + ((Object) Size.m1440toStringimpl(this.size)) + ')';
        }

        private DrawParams(Density density, LayoutDirection layoutDirection, Canvas canvas, long j10) {
            this.density = density;
            this.layoutDirection = layoutDirection;
            this.canvas = canvas;
            this.size = j10;
        }

        public /* synthetic */ DrawParams(Density density, LayoutDirection layoutDirection, Canvas canvas, long j10, int i10, k kVar) {
            this((i10 & 1) != 0 ? CanvasDrawScopeKt.DefaultDensity : density, (i10 & 2) != 0 ? LayoutDirection.Ltr : layoutDirection, (i10 & 4) != 0 ? new EmptyCanvas() : canvas, (i10 & 8) != 0 ? Size.Companion.m1445getZeroNHjbRc() : j10, null);
        }
    }

    /* JADX INFO: renamed from: configurePaint-2qPWKa0, reason: not valid java name */
    private final Paint m1966configurePaint2qPWKa0(long j10, DrawStyle drawStyle, float f10, ColorFilter colorFilter, int i10, int i11) {
        Paint paintSelectPaint = selectPaint(drawStyle);
        long jM1974modulate5vOe2sY = m1974modulate5vOe2sY(j10, f10);
        if (!Color.m1599equalsimpl0(paintSelectPaint.mo1482getColor0d7_KjU(), jM1974modulate5vOe2sY)) {
            paintSelectPaint.mo1488setColor8_81llA(jM1974modulate5vOe2sY);
        }
        if (paintSelectPaint.getShader() != null) {
            paintSelectPaint.setShader(null);
        }
        if (!t.d(paintSelectPaint.getColorFilter(), colorFilter)) {
            paintSelectPaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m1517equalsimpl0(paintSelectPaint.mo1481getBlendMode0nO6VwU(), i10)) {
            paintSelectPaint.mo1487setBlendModes9anfk8(i10);
        }
        if (!FilterQuality.m1679equalsimpl0(paintSelectPaint.mo1483getFilterQualityfv9h1I(), i11)) {
            paintSelectPaint.mo1489setFilterQualityvDHp3xo(i11);
        }
        return paintSelectPaint;
    }

    /* JADX INFO: renamed from: configurePaint-2qPWKa0$default, reason: not valid java name */
    static /* synthetic */ Paint m1967configurePaint2qPWKa0$default(CanvasDrawScope canvasDrawScope, long j10, DrawStyle drawStyle, float f10, ColorFilter colorFilter, int i10, int i11, int i12, Object obj) {
        return canvasDrawScope.m1966configurePaint2qPWKa0(j10, drawStyle, f10, colorFilter, i10, (i12 & 32) != 0 ? DrawScope.Companion.m2027getDefaultFilterQualityfv9h1I() : i11);
    }

    /* JADX INFO: renamed from: configurePaint-swdJneE, reason: not valid java name */
    private final Paint m1968configurePaintswdJneE(Brush brush, DrawStyle drawStyle, float f10, ColorFilter colorFilter, int i10, int i11) {
        Paint paintSelectPaint = selectPaint(drawStyle);
        if (brush != null) {
            brush.mo1551applyToPq9zytI(mo1996getSizeNHjbRc(), paintSelectPaint, f10);
        } else {
            if (!(paintSelectPaint.getAlpha() == f10)) {
                paintSelectPaint.setAlpha(f10);
            }
        }
        if (!t.d(paintSelectPaint.getColorFilter(), colorFilter)) {
            paintSelectPaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m1517equalsimpl0(paintSelectPaint.mo1481getBlendMode0nO6VwU(), i10)) {
            paintSelectPaint.mo1487setBlendModes9anfk8(i10);
        }
        if (!FilterQuality.m1679equalsimpl0(paintSelectPaint.mo1483getFilterQualityfv9h1I(), i11)) {
            paintSelectPaint.mo1489setFilterQualityvDHp3xo(i11);
        }
        return paintSelectPaint;
    }

    /* JADX INFO: renamed from: configurePaint-swdJneE$default, reason: not valid java name */
    static /* synthetic */ Paint m1969configurePaintswdJneE$default(CanvasDrawScope canvasDrawScope, Brush brush, DrawStyle drawStyle, float f10, ColorFilter colorFilter, int i10, int i11, int i12, Object obj) {
        if ((i12 & 32) != 0) {
            i11 = DrawScope.Companion.m2027getDefaultFilterQualityfv9h1I();
        }
        return canvasDrawScope.m1968configurePaintswdJneE(brush, drawStyle, f10, colorFilter, i10, i11);
    }

    /* JADX INFO: renamed from: configureStrokePaint-Q_0CZUI, reason: not valid java name */
    private final Paint m1970configureStrokePaintQ_0CZUI(long j10, float f10, float f11, int i10, int i11, PathEffect pathEffect, float f12, ColorFilter colorFilter, int i12, int i13) {
        Paint paintObtainStrokePaint = obtainStrokePaint();
        long jM1974modulate5vOe2sY = m1974modulate5vOe2sY(j10, f12);
        if (!Color.m1599equalsimpl0(paintObtainStrokePaint.mo1482getColor0d7_KjU(), jM1974modulate5vOe2sY)) {
            paintObtainStrokePaint.mo1488setColor8_81llA(jM1974modulate5vOe2sY);
        }
        if (paintObtainStrokePaint.getShader() != null) {
            paintObtainStrokePaint.setShader(null);
        }
        if (!t.d(paintObtainStrokePaint.getColorFilter(), colorFilter)) {
            paintObtainStrokePaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m1517equalsimpl0(paintObtainStrokePaint.mo1481getBlendMode0nO6VwU(), i12)) {
            paintObtainStrokePaint.mo1487setBlendModes9anfk8(i12);
        }
        if (!(paintObtainStrokePaint.getStrokeWidth() == f10)) {
            paintObtainStrokePaint.setStrokeWidth(f10);
        }
        if (!(paintObtainStrokePaint.getStrokeMiterLimit() == f11)) {
            paintObtainStrokePaint.setStrokeMiterLimit(f11);
        }
        if (!StrokeCap.m1881equalsimpl0(paintObtainStrokePaint.mo1484getStrokeCapKaPHkGw(), i10)) {
            paintObtainStrokePaint.mo1490setStrokeCapBeK7IIE(i10);
        }
        if (!StrokeJoin.m1891equalsimpl0(paintObtainStrokePaint.mo1485getStrokeJoinLxFBmk8(), i11)) {
            paintObtainStrokePaint.mo1491setStrokeJoinWw9F2mQ(i11);
        }
        if (!t.d(paintObtainStrokePaint.getPathEffect(), pathEffect)) {
            paintObtainStrokePaint.setPathEffect(pathEffect);
        }
        if (!FilterQuality.m1679equalsimpl0(paintObtainStrokePaint.mo1483getFilterQualityfv9h1I(), i13)) {
            paintObtainStrokePaint.mo1489setFilterQualityvDHp3xo(i13);
        }
        return paintObtainStrokePaint;
    }

    /* JADX INFO: renamed from: configureStrokePaint-Q_0CZUI$default, reason: not valid java name */
    static /* synthetic */ Paint m1971configureStrokePaintQ_0CZUI$default(CanvasDrawScope canvasDrawScope, long j10, float f10, float f11, int i10, int i11, PathEffect pathEffect, float f12, ColorFilter colorFilter, int i12, int i13, int i14, Object obj) {
        return canvasDrawScope.m1970configureStrokePaintQ_0CZUI(j10, f10, f11, i10, i11, pathEffect, f12, colorFilter, i12, (i14 & 512) != 0 ? DrawScope.Companion.m2027getDefaultFilterQualityfv9h1I() : i13);
    }

    /* JADX INFO: renamed from: configureStrokePaint-ho4zsrM, reason: not valid java name */
    private final Paint m1972configureStrokePaintho4zsrM(Brush brush, float f10, float f11, int i10, int i11, PathEffect pathEffect, float f12, ColorFilter colorFilter, int i12, int i13) {
        Paint paintObtainStrokePaint = obtainStrokePaint();
        if (brush != null) {
            brush.mo1551applyToPq9zytI(mo1996getSizeNHjbRc(), paintObtainStrokePaint, f12);
        } else {
            if (!(paintObtainStrokePaint.getAlpha() == f12)) {
                paintObtainStrokePaint.setAlpha(f12);
            }
        }
        if (!t.d(paintObtainStrokePaint.getColorFilter(), colorFilter)) {
            paintObtainStrokePaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m1517equalsimpl0(paintObtainStrokePaint.mo1481getBlendMode0nO6VwU(), i12)) {
            paintObtainStrokePaint.mo1487setBlendModes9anfk8(i12);
        }
        if (!(paintObtainStrokePaint.getStrokeWidth() == f10)) {
            paintObtainStrokePaint.setStrokeWidth(f10);
        }
        if (!(paintObtainStrokePaint.getStrokeMiterLimit() == f11)) {
            paintObtainStrokePaint.setStrokeMiterLimit(f11);
        }
        if (!StrokeCap.m1881equalsimpl0(paintObtainStrokePaint.mo1484getStrokeCapKaPHkGw(), i10)) {
            paintObtainStrokePaint.mo1490setStrokeCapBeK7IIE(i10);
        }
        if (!StrokeJoin.m1891equalsimpl0(paintObtainStrokePaint.mo1485getStrokeJoinLxFBmk8(), i11)) {
            paintObtainStrokePaint.mo1491setStrokeJoinWw9F2mQ(i11);
        }
        if (!t.d(paintObtainStrokePaint.getPathEffect(), pathEffect)) {
            paintObtainStrokePaint.setPathEffect(pathEffect);
        }
        if (!FilterQuality.m1679equalsimpl0(paintObtainStrokePaint.mo1483getFilterQualityfv9h1I(), i13)) {
            paintObtainStrokePaint.mo1489setFilterQualityvDHp3xo(i13);
        }
        return paintObtainStrokePaint;
    }

    /* JADX INFO: renamed from: configureStrokePaint-ho4zsrM$default, reason: not valid java name */
    static /* synthetic */ Paint m1973configureStrokePaintho4zsrM$default(CanvasDrawScope canvasDrawScope, Brush brush, float f10, float f11, int i10, int i11, PathEffect pathEffect, float f12, ColorFilter colorFilter, int i12, int i13, int i14, Object obj) {
        return canvasDrawScope.m1972configureStrokePaintho4zsrM(brush, f10, f11, i10, i11, pathEffect, f12, colorFilter, i12, (i14 & 512) != 0 ? DrawScope.Companion.m2027getDefaultFilterQualityfv9h1I() : i13);
    }

    /* JADX INFO: renamed from: modulate-5vOe2sY, reason: not valid java name */
    private final long m1974modulate5vOe2sY(long j10, float f10) {
        return !((f10 > 1.0f ? 1 : (f10 == 1.0f ? 0 : -1)) == 0) ? Color.m1597copywmQWz5c$default(j10, Color.m1600getAlphaimpl(j10) * f10, 0.0f, 0.0f, 0.0f, 14, null) : j10;
    }

    private final Paint obtainFillPaint() {
        Paint paint = this.fillPaint;
        if (paint != null) {
            return paint;
        }
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.mo1492setStylek9PVt8s(PaintingStyle.Companion.m1812getFillTiuSbCo());
        this.fillPaint = Paint;
        return Paint;
    }

    private final Paint obtainStrokePaint() {
        Paint paint = this.strokePaint;
        if (paint != null) {
            return paint;
        }
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.mo1492setStylek9PVt8s(PaintingStyle.Companion.m1813getStrokeTiuSbCo());
        this.strokePaint = Paint;
        return Paint;
    }

    private final Paint selectPaint(DrawStyle drawStyle) {
        if (t.d(drawStyle, Fill.INSTANCE)) {
            return obtainFillPaint();
        }
        if (!(drawStyle instanceof Stroke)) {
            throw new q();
        }
        Paint paintObtainStrokePaint = obtainStrokePaint();
        Stroke stroke = (Stroke) drawStyle;
        if (!(paintObtainStrokePaint.getStrokeWidth() == stroke.getWidth())) {
            paintObtainStrokePaint.setStrokeWidth(stroke.getWidth());
        }
        if (!StrokeCap.m1881equalsimpl0(paintObtainStrokePaint.mo1484getStrokeCapKaPHkGw(), stroke.m2083getCapKaPHkGw())) {
            paintObtainStrokePaint.mo1490setStrokeCapBeK7IIE(stroke.m2083getCapKaPHkGw());
        }
        if (!(paintObtainStrokePaint.getStrokeMiterLimit() == stroke.getMiter())) {
            paintObtainStrokePaint.setStrokeMiterLimit(stroke.getMiter());
        }
        if (!StrokeJoin.m1891equalsimpl0(paintObtainStrokePaint.mo1485getStrokeJoinLxFBmk8(), stroke.m2084getJoinLxFBmk8())) {
            paintObtainStrokePaint.mo1491setStrokeJoinWw9F2mQ(stroke.m2084getJoinLxFBmk8());
        }
        if (!t.d(paintObtainStrokePaint.getPathEffect(), stroke.getPathEffect())) {
            paintObtainStrokePaint.setPathEffect(stroke.getPathEffect());
        }
        return paintObtainStrokePaint;
    }

    /* JADX INFO: renamed from: draw-yzxVdVo, reason: not valid java name */
    public final void m1975drawyzxVdVo(@NotNull Density density, @NotNull LayoutDirection layoutDirection, @NotNull Canvas canvas, long j10, @NotNull l<? super DrawScope, k0> block) {
        t.i(density, "density");
        t.i(layoutDirection, "layoutDirection");
        t.i(canvas, "canvas");
        t.i(block, "block");
        DrawParams drawParams = getDrawParams();
        Density densityComponent1 = drawParams.component1();
        LayoutDirection layoutDirectionComponent2 = drawParams.component2();
        Canvas canvasComponent3 = drawParams.component3();
        long jM1998component4NHjbRc = drawParams.m1998component4NHjbRc();
        DrawParams drawParams2 = getDrawParams();
        drawParams2.setDensity(density);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas);
        drawParams2.m2001setSizeuvyYCjk(j10);
        canvas.save();
        block.invoke(this);
        canvas.restore();
        DrawParams drawParams3 = getDrawParams();
        drawParams3.setDensity(densityComponent1);
        drawParams3.setLayoutDirection(layoutDirectionComponent2);
        drawParams3.setCanvas(canvasComponent3);
        drawParams3.m2001setSizeuvyYCjk(jM1998component4NHjbRc);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawArc-illE91I, reason: not valid java name */
    public void mo1976drawArcillE91I(@NotNull Brush brush, float f10, float f11, boolean z10, long j10, long j11, float f12, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10) {
        t.i(brush, "brush");
        t.i(style, "style");
        this.drawParams.getCanvas().drawArc(Offset.m1367getXimpl(j10), Offset.m1368getYimpl(j10), Offset.m1367getXimpl(j10) + Size.m1436getWidthimpl(j11), Offset.m1368getYimpl(j10) + Size.m1433getHeightimpl(j11), f10, f11, z10, m1969configurePaintswdJneE$default(this, brush, style, f12, colorFilter, i10, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawArc-yD3GUKo, reason: not valid java name */
    public void mo1977drawArcyD3GUKo(long j10, float f10, float f11, boolean z10, long j11, long j12, float f12, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10) {
        t.i(style, "style");
        this.drawParams.getCanvas().drawArc(Offset.m1367getXimpl(j11), Offset.m1368getYimpl(j11), Offset.m1367getXimpl(j11) + Size.m1436getWidthimpl(j12), Offset.m1368getYimpl(j11) + Size.m1433getHeightimpl(j12), f10, f11, z10, m1967configurePaint2qPWKa0$default(this, j10, style, f12, colorFilter, i10, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawCircle-V9BoPsw, reason: not valid java name */
    public void mo1978drawCircleV9BoPsw(@NotNull Brush brush, float f10, long j10, float f11, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10) {
        t.i(brush, "brush");
        t.i(style, "style");
        this.drawParams.getCanvas().mo1465drawCircle9KIMszo(j10, f10, m1969configurePaintswdJneE$default(this, brush, style, f11, colorFilter, i10, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawCircle-VaOC9Bg, reason: not valid java name */
    public void mo1979drawCircleVaOC9Bg(long j10, float f10, long j11, float f11, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10) {
        t.i(style, "style");
        this.drawParams.getCanvas().mo1465drawCircle9KIMszo(j11, f10, m1967configurePaint2qPWKa0$default(this, j10, style, f11, colorFilter, i10, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-9jGpkUE, reason: not valid java name */
    public /* synthetic */ void mo1980drawImage9jGpkUE(ImageBitmap image, long j10, long j11, long j12, long j13, float f10, DrawStyle style, ColorFilter colorFilter, int i10) {
        t.i(image, "image");
        t.i(style, "style");
        this.drawParams.getCanvas().mo1467drawImageRectHPBpro0(image, j10, j11, j12, j13, m1969configurePaintswdJneE$default(this, null, style, f10, colorFilter, i10, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-AZ2fEMs, reason: not valid java name */
    public void mo1981drawImageAZ2fEMs(@NotNull ImageBitmap image, long j10, long j11, long j12, long j13, float f10, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10, int i11) {
        t.i(image, "image");
        t.i(style, "style");
        this.drawParams.getCanvas().mo1467drawImageRectHPBpro0(image, j10, j11, j12, j13, m1968configurePaintswdJneE(null, style, f10, colorFilter, i10, i11));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-gbVJVH8, reason: not valid java name */
    public void mo1982drawImagegbVJVH8(@NotNull ImageBitmap image, long j10, float f10, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10) {
        t.i(image, "image");
        t.i(style, "style");
        this.drawParams.getCanvas().mo1466drawImaged4ec7I(image, j10, m1969configurePaintswdJneE$default(this, null, style, f10, colorFilter, i10, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawLine-1RTmtNc, reason: not valid java name */
    public void mo1983drawLine1RTmtNc(@NotNull Brush brush, long j10, long j11, float f10, int i10, @Nullable PathEffect pathEffect, float f11, @Nullable ColorFilter colorFilter, int i11) {
        t.i(brush, "brush");
        this.drawParams.getCanvas().mo1468drawLineWko1d7g(j10, j11, m1973configureStrokePaintho4zsrM$default(this, brush, f10, 4.0f, i10, StrokeJoin.Companion.m1896getMiterLxFBmk8(), pathEffect, f11, colorFilter, i11, 0, 512, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawLine-NGM6Ib0, reason: not valid java name */
    public void mo1984drawLineNGM6Ib0(long j10, long j11, long j12, float f10, int i10, @Nullable PathEffect pathEffect, float f11, @Nullable ColorFilter colorFilter, int i11) {
        this.drawParams.getCanvas().mo1468drawLineWko1d7g(j11, j12, m1971configureStrokePaintQ_0CZUI$default(this, j10, f10, 4.0f, i10, StrokeJoin.Companion.m1896getMiterLxFBmk8(), pathEffect, f11, colorFilter, i11, 0, 512, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawOval-AsUm42w, reason: not valid java name */
    public void mo1985drawOvalAsUm42w(@NotNull Brush brush, long j10, long j11, float f10, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10) {
        t.i(brush, "brush");
        t.i(style, "style");
        this.drawParams.getCanvas().drawOval(Offset.m1367getXimpl(j10), Offset.m1368getYimpl(j10), Offset.m1367getXimpl(j10) + Size.m1436getWidthimpl(j11), Offset.m1368getYimpl(j10) + Size.m1433getHeightimpl(j11), m1969configurePaintswdJneE$default(this, brush, style, f10, colorFilter, i10, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawOval-n-J9OG0, reason: not valid java name */
    public void mo1986drawOvalnJ9OG0(long j10, long j11, long j12, float f10, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10) {
        t.i(style, "style");
        this.drawParams.getCanvas().drawOval(Offset.m1367getXimpl(j11), Offset.m1368getYimpl(j11), Offset.m1367getXimpl(j11) + Size.m1436getWidthimpl(j12), Offset.m1368getYimpl(j11) + Size.m1433getHeightimpl(j12), m1967configurePaint2qPWKa0$default(this, j10, style, f10, colorFilter, i10, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-GBMwjPU, reason: not valid java name */
    public void mo1987drawPathGBMwjPU(@NotNull Path path, @NotNull Brush brush, float f10, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10) {
        t.i(path, "path");
        t.i(brush, "brush");
        t.i(style, "style");
        this.drawParams.getCanvas().drawPath(path, m1969configurePaintswdJneE$default(this, brush, style, f10, colorFilter, i10, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-LG529CI, reason: not valid java name */
    public void mo1988drawPathLG529CI(@NotNull Path path, long j10, float f10, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10) {
        t.i(path, "path");
        t.i(style, "style");
        this.drawParams.getCanvas().drawPath(path, m1967configurePaint2qPWKa0$default(this, j10, style, f10, colorFilter, i10, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPoints-F8ZwMP8, reason: not valid java name */
    public void mo1989drawPointsF8ZwMP8(@NotNull List<Offset> points, int i10, long j10, float f10, int i11, @Nullable PathEffect pathEffect, float f11, @Nullable ColorFilter colorFilter, int i12) {
        t.i(points, "points");
        this.drawParams.getCanvas().mo1469drawPointsO7TthRY(i10, points, m1971configureStrokePaintQ_0CZUI$default(this, j10, f10, 4.0f, i11, StrokeJoin.Companion.m1896getMiterLxFBmk8(), pathEffect, f11, colorFilter, i12, 0, 512, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPoints-Gsft0Ws, reason: not valid java name */
    public void mo1990drawPointsGsft0Ws(@NotNull List<Offset> points, int i10, @NotNull Brush brush, float f10, int i11, @Nullable PathEffect pathEffect, float f11, @Nullable ColorFilter colorFilter, int i12) {
        t.i(points, "points");
        t.i(brush, "brush");
        this.drawParams.getCanvas().mo1469drawPointsO7TthRY(i10, points, m1973configureStrokePaintho4zsrM$default(this, brush, f10, 4.0f, i11, StrokeJoin.Companion.m1896getMiterLxFBmk8(), pathEffect, f11, colorFilter, i12, 0, 512, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-AsUm42w, reason: not valid java name */
    public void mo1991drawRectAsUm42w(@NotNull Brush brush, long j10, long j11, float f10, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10) {
        t.i(brush, "brush");
        t.i(style, "style");
        this.drawParams.getCanvas().drawRect(Offset.m1367getXimpl(j10), Offset.m1368getYimpl(j10), Offset.m1367getXimpl(j10) + Size.m1436getWidthimpl(j11), Offset.m1368getYimpl(j10) + Size.m1433getHeightimpl(j11), m1969configurePaintswdJneE$default(this, brush, style, f10, colorFilter, i10, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-n-J9OG0, reason: not valid java name */
    public void mo1992drawRectnJ9OG0(long j10, long j11, long j12, float f10, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10) {
        t.i(style, "style");
        this.drawParams.getCanvas().drawRect(Offset.m1367getXimpl(j11), Offset.m1368getYimpl(j11), Offset.m1367getXimpl(j11) + Size.m1436getWidthimpl(j12), Offset.m1368getYimpl(j11) + Size.m1433getHeightimpl(j12), m1967configurePaint2qPWKa0$default(this, j10, style, f10, colorFilter, i10, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-ZuiqVtQ, reason: not valid java name */
    public void mo1993drawRoundRectZuiqVtQ(@NotNull Brush brush, long j10, long j11, long j12, float f10, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10) {
        t.i(brush, "brush");
        t.i(style, "style");
        this.drawParams.getCanvas().drawRoundRect(Offset.m1367getXimpl(j10), Offset.m1368getYimpl(j10), Offset.m1367getXimpl(j10) + Size.m1436getWidthimpl(j11), Offset.m1368getYimpl(j10) + Size.m1433getHeightimpl(j11), CornerRadius.m1342getXimpl(j12), CornerRadius.m1343getYimpl(j12), m1969configurePaintswdJneE$default(this, brush, style, f10, colorFilter, i10, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-u-Aw5IA, reason: not valid java name */
    public void mo1994drawRoundRectuAw5IA(long j10, long j11, long j12, long j13, @NotNull DrawStyle style, float f10, @Nullable ColorFilter colorFilter, int i10) {
        t.i(style, "style");
        this.drawParams.getCanvas().drawRoundRect(Offset.m1367getXimpl(j11), Offset.m1368getYimpl(j11), Offset.m1367getXimpl(j11) + Size.m1436getWidthimpl(j12), Offset.m1368getYimpl(j11) + Size.m1433getHeightimpl(j12), CornerRadius.m1342getXimpl(j13), CornerRadius.m1343getYimpl(j13), m1967configurePaint2qPWKa0$default(this, j10, style, f10, colorFilter, i10, 0, 32, null));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
    public /* synthetic */ long mo1995getCenterF1C5BW0() {
        return b.b(this);
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.drawParams.getDensity().getDensity();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    @NotNull
    public DrawContext getDrawContext() {
        return this.drawContext;
    }

    @NotNull
    public final DrawParams getDrawParams() {
        return this.drawParams;
    }

    @Override // androidx.compose.ui.unit.Density
    public float getFontScale() {
        return this.drawParams.getDensity().getFontScale();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    @NotNull
    public LayoutDirection getLayoutDirection() {
        return this.drawParams.getLayoutDirection();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
    public /* synthetic */ long mo1996getSizeNHjbRc() {
        return b.c(this);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    public /* synthetic */ int mo289roundToPxR2X_6o(long j10) {
        return androidx.compose.ui.unit.a.a(this, j10);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public /* synthetic */ int mo290roundToPx0680j_4(float f10) {
        return androidx.compose.ui.unit.a.b(this, f10);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public /* synthetic */ float mo291toDpGaN1DYA(long j10) {
        return androidx.compose.ui.unit.a.c(this, j10);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo292toDpu2uoSUM(float f10) {
        return androidx.compose.ui.unit.a.d(this, f10);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public /* synthetic */ long mo294toDpSizekrfVVM(long j10) {
        return androidx.compose.ui.unit.a.f(this, j10);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public /* synthetic */ float mo295toPxR2X_6o(long j10) {
        return androidx.compose.ui.unit.a.g(this, j10);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public /* synthetic */ float mo296toPx0680j_4(float f10) {
        return androidx.compose.ui.unit.a.h(this, f10);
    }

    @Override // androidx.compose.ui.unit.Density
    public /* synthetic */ Rect toRect(DpRect dpRect) {
        return androidx.compose.ui.unit.a.i(this, dpRect);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public /* synthetic */ long mo297toSizeXkaWNTQ(long j10) {
        return androidx.compose.ui.unit.a.j(this, j10);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public /* synthetic */ long mo298toSp0xMU5do(float f10) {
        return androidx.compose.ui.unit.a.k(this, f10);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public /* synthetic */ long mo299toSpkPz2Gy4(float f10) {
        return androidx.compose.ui.unit.a.l(this, f10);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo293toDpu2uoSUM(int i10) {
        return androidx.compose.ui.unit.a.e(this, i10);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public /* synthetic */ long mo300toSpkPz2Gy4(int i10) {
        return androidx.compose.ui.unit.a.m(this, i10);
    }

    public static /* synthetic */ void getDrawParams$annotations() {
    }
}
