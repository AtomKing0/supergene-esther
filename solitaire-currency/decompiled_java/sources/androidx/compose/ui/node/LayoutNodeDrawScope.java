package androidx.compose.ui.node;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasureScope;
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

/* JADX INFO: compiled from: LayoutNodeDrawScope.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutNodeDrawScope implements DrawScope, ContentDrawScope {

    @NotNull
    private final CanvasDrawScope canvasDrawScope;

    @Nullable
    private DrawEntity drawEntity;

    /* JADX WARN: Multi-variable type inference failed */
    public LayoutNodeDrawScope() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: renamed from: draw-eZhPAX0$ui_release, reason: not valid java name */
    public final void m3110draweZhPAX0$ui_release(@NotNull Canvas canvas, long j10, @NotNull LayoutNodeWrapper layoutNodeWrapper, @NotNull DrawEntity drawEntity, @NotNull l<? super DrawScope, k0> block) {
        t.i(canvas, "canvas");
        t.i(layoutNodeWrapper, "layoutNodeWrapper");
        t.i(drawEntity, "drawEntity");
        t.i(block, "block");
        DrawEntity drawEntity2 = this.drawEntity;
        this.drawEntity = drawEntity;
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        MeasureScope measureScope = layoutNodeWrapper.getMeasureScope();
        LayoutDirection layoutDirection = layoutNodeWrapper.getMeasureScope().getLayoutDirection();
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope.getDrawParams();
        Density densityComponent1 = drawParams.component1();
        LayoutDirection layoutDirectionComponent2 = drawParams.component2();
        Canvas canvasComponent3 = drawParams.component3();
        long jM1998component4NHjbRc = drawParams.m1998component4NHjbRc();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope.getDrawParams();
        drawParams2.setDensity(measureScope);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas);
        drawParams2.m2001setSizeuvyYCjk(j10);
        canvas.save();
        block.invoke(canvasDrawScope);
        canvas.restore();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope.getDrawParams();
        drawParams3.setDensity(densityComponent1);
        drawParams3.setLayoutDirection(layoutDirectionComponent2);
        drawParams3.setCanvas(canvasComponent3);
        drawParams3.m2001setSizeuvyYCjk(jM1998component4NHjbRc);
        this.drawEntity = drawEntity2;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawArc-illE91I */
    public void mo1976drawArcillE91I(@NotNull Brush brush, float f10, float f11, boolean z10, long j10, long j11, float f12, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10) {
        t.i(brush, "brush");
        t.i(style, "style");
        this.canvasDrawScope.mo1976drawArcillE91I(brush, f10, f11, z10, j10, j11, f12, style, colorFilter, i10);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawArc-yD3GUKo */
    public void mo1977drawArcyD3GUKo(long j10, float f10, float f11, boolean z10, long j11, long j12, float f12, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10) {
        t.i(style, "style");
        this.canvasDrawScope.mo1977drawArcyD3GUKo(j10, f10, f11, z10, j11, j12, f12, style, colorFilter, i10);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawCircle-V9BoPsw */
    public void mo1978drawCircleV9BoPsw(@NotNull Brush brush, float f10, long j10, float f11, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10) {
        t.i(brush, "brush");
        t.i(style, "style");
        this.canvasDrawScope.mo1978drawCircleV9BoPsw(brush, f10, j10, f11, style, colorFilter, i10);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawCircle-VaOC9Bg */
    public void mo1979drawCircleVaOC9Bg(long j10, float f10, long j11, float f11, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10) {
        t.i(style, "style");
        this.canvasDrawScope.mo1979drawCircleVaOC9Bg(j10, f10, j11, f11, style, colorFilter, i10);
    }

    @Override // androidx.compose.ui.graphics.drawscope.ContentDrawScope
    public void drawContent() {
        Canvas canvas = getDrawContext().getCanvas();
        DrawEntity drawEntity = this.drawEntity;
        t.f(drawEntity);
        DrawEntity next = drawEntity.getNext();
        if (next != null) {
            next.draw(canvas);
        } else {
            drawEntity.getLayoutNodeWrapper().performDraw(canvas);
        }
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-9jGpkUE */
    public /* synthetic */ void mo1980drawImage9jGpkUE(ImageBitmap image, long j10, long j11, long j12, long j13, float f10, DrawStyle style, ColorFilter colorFilter, int i10) {
        t.i(image, "image");
        t.i(style, "style");
        this.canvasDrawScope.mo1980drawImage9jGpkUE(image, j10, j11, j12, j13, f10, style, colorFilter, i10);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-AZ2fEMs */
    public void mo1981drawImageAZ2fEMs(@NotNull ImageBitmap image, long j10, long j11, long j12, long j13, float f10, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10, int i11) {
        t.i(image, "image");
        t.i(style, "style");
        this.canvasDrawScope.mo1981drawImageAZ2fEMs(image, j10, j11, j12, j13, f10, style, colorFilter, i10, i11);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawImage-gbVJVH8 */
    public void mo1982drawImagegbVJVH8(@NotNull ImageBitmap image, long j10, float f10, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10) {
        t.i(image, "image");
        t.i(style, "style");
        this.canvasDrawScope.mo1982drawImagegbVJVH8(image, j10, f10, style, colorFilter, i10);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawLine-1RTmtNc */
    public void mo1983drawLine1RTmtNc(@NotNull Brush brush, long j10, long j11, float f10, int i10, @Nullable PathEffect pathEffect, float f11, @Nullable ColorFilter colorFilter, int i11) {
        t.i(brush, "brush");
        this.canvasDrawScope.mo1983drawLine1RTmtNc(brush, j10, j11, f10, i10, pathEffect, f11, colorFilter, i11);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawLine-NGM6Ib0 */
    public void mo1984drawLineNGM6Ib0(long j10, long j11, long j12, float f10, int i10, @Nullable PathEffect pathEffect, float f11, @Nullable ColorFilter colorFilter, int i11) {
        this.canvasDrawScope.mo1984drawLineNGM6Ib0(j10, j11, j12, f10, i10, pathEffect, f11, colorFilter, i11);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawOval-AsUm42w */
    public void mo1985drawOvalAsUm42w(@NotNull Brush brush, long j10, long j11, float f10, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10) {
        t.i(brush, "brush");
        t.i(style, "style");
        this.canvasDrawScope.mo1985drawOvalAsUm42w(brush, j10, j11, f10, style, colorFilter, i10);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawOval-n-J9OG0 */
    public void mo1986drawOvalnJ9OG0(long j10, long j11, long j12, float f10, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10) {
        t.i(style, "style");
        this.canvasDrawScope.mo1986drawOvalnJ9OG0(j10, j11, j12, f10, style, colorFilter, i10);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-GBMwjPU */
    public void mo1987drawPathGBMwjPU(@NotNull Path path, @NotNull Brush brush, float f10, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10) {
        t.i(path, "path");
        t.i(brush, "brush");
        t.i(style, "style");
        this.canvasDrawScope.mo1987drawPathGBMwjPU(path, brush, f10, style, colorFilter, i10);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPath-LG529CI */
    public void mo1988drawPathLG529CI(@NotNull Path path, long j10, float f10, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10) {
        t.i(path, "path");
        t.i(style, "style");
        this.canvasDrawScope.mo1988drawPathLG529CI(path, j10, f10, style, colorFilter, i10);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPoints-F8ZwMP8 */
    public void mo1989drawPointsF8ZwMP8(@NotNull List<Offset> points, int i10, long j10, float f10, int i11, @Nullable PathEffect pathEffect, float f11, @Nullable ColorFilter colorFilter, int i12) {
        t.i(points, "points");
        this.canvasDrawScope.mo1989drawPointsF8ZwMP8(points, i10, j10, f10, i11, pathEffect, f11, colorFilter, i12);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawPoints-Gsft0Ws */
    public void mo1990drawPointsGsft0Ws(@NotNull List<Offset> points, int i10, @NotNull Brush brush, float f10, int i11, @Nullable PathEffect pathEffect, float f11, @Nullable ColorFilter colorFilter, int i12) {
        t.i(points, "points");
        t.i(brush, "brush");
        this.canvasDrawScope.mo1990drawPointsGsft0Ws(points, i10, brush, f10, i11, pathEffect, f11, colorFilter, i12);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-AsUm42w */
    public void mo1991drawRectAsUm42w(@NotNull Brush brush, long j10, long j11, float f10, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10) {
        t.i(brush, "brush");
        t.i(style, "style");
        this.canvasDrawScope.mo1991drawRectAsUm42w(brush, j10, j11, f10, style, colorFilter, i10);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRect-n-J9OG0 */
    public void mo1992drawRectnJ9OG0(long j10, long j11, long j12, float f10, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10) {
        t.i(style, "style");
        this.canvasDrawScope.mo1992drawRectnJ9OG0(j10, j11, j12, f10, style, colorFilter, i10);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-ZuiqVtQ */
    public void mo1993drawRoundRectZuiqVtQ(@NotNull Brush brush, long j10, long j11, long j12, float f10, @NotNull DrawStyle style, @Nullable ColorFilter colorFilter, int i10) {
        t.i(brush, "brush");
        t.i(style, "style");
        this.canvasDrawScope.mo1993drawRoundRectZuiqVtQ(brush, j10, j11, j12, f10, style, colorFilter, i10);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: drawRoundRect-u-Aw5IA */
    public void mo1994drawRoundRectuAw5IA(long j10, long j11, long j12, long j13, @NotNull DrawStyle style, float f10, @Nullable ColorFilter colorFilter, int i10) {
        t.i(style, "style");
        this.canvasDrawScope.mo1994drawRoundRectuAw5IA(j10, j11, j12, j13, style, f10, colorFilter, i10);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: getCenter-F1C5BW0 */
    public long mo1995getCenterF1C5BW0() {
        return this.canvasDrawScope.mo1995getCenterF1C5BW0();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.canvasDrawScope.getDensity();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    @NotNull
    public DrawContext getDrawContext() {
        return this.canvasDrawScope.getDrawContext();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getFontScale() {
        return this.canvasDrawScope.getFontScale();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    @NotNull
    public LayoutDirection getLayoutDirection() {
        return this.canvasDrawScope.getLayoutDirection();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* JADX INFO: renamed from: getSize-NH-jbRc */
    public long mo1996getSizeNHjbRc() {
        return this.canvasDrawScope.mo1996getSizeNHjbRc();
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    public int mo289roundToPxR2X_6o(long j10) {
        return this.canvasDrawScope.mo289roundToPxR2X_6o(j10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public int mo290roundToPx0680j_4(float f10) {
        return this.canvasDrawScope.mo290roundToPx0680j_4(f10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public float mo291toDpGaN1DYA(long j10) {
        return this.canvasDrawScope.mo291toDpGaN1DYA(j10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public float mo292toDpu2uoSUM(float f10) {
        return this.canvasDrawScope.mo292toDpu2uoSUM(f10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public long mo294toDpSizekrfVVM(long j10) {
        return this.canvasDrawScope.mo294toDpSizekrfVVM(j10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public float mo295toPxR2X_6o(long j10) {
        return this.canvasDrawScope.mo295toPxR2X_6o(j10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public float mo296toPx0680j_4(float f10) {
        return this.canvasDrawScope.mo296toPx0680j_4(f10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    @NotNull
    public Rect toRect(@NotNull DpRect dpRect) {
        t.i(dpRect, "<this>");
        return this.canvasDrawScope.toRect(dpRect);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public long mo297toSizeXkaWNTQ(long j10) {
        return this.canvasDrawScope.mo297toSizeXkaWNTQ(j10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public long mo298toSp0xMU5do(float f10) {
        return this.canvasDrawScope.mo298toSp0xMU5do(f10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public long mo299toSpkPz2Gy4(float f10) {
        return this.canvasDrawScope.mo299toSpkPz2Gy4(f10);
    }

    public LayoutNodeDrawScope(@NotNull CanvasDrawScope canvasDrawScope) {
        t.i(canvasDrawScope, "canvasDrawScope");
        this.canvasDrawScope = canvasDrawScope;
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public float mo293toDpu2uoSUM(int i10) {
        return this.canvasDrawScope.mo293toDpu2uoSUM(i10);
    }

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public long mo300toSpkPz2Gy4(int i10) {
        return this.canvasDrawScope.mo300toSpkPz2Gy4(i10);
    }

    public /* synthetic */ LayoutNodeDrawScope(CanvasDrawScope canvasDrawScope, int i10, k kVar) {
        this((i10 & 1) != 0 ? new CanvasDrawScope() : canvasDrawScope);
    }
}
