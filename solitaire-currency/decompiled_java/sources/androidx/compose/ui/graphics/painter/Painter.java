package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Painter.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class Painter {

    @Nullable
    private ColorFilter colorFilter;

    @Nullable
    private Paint layerPaint;
    private boolean useLayer;
    private float alpha = 1.0f;

    @NotNull
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;

    @NotNull
    private final l<DrawScope, k0> drawLambda = new Painter$drawLambda$1(this);

    private final void configureAlpha(float f10) {
        if (this.alpha == f10) {
            return;
        }
        if (!applyAlpha(f10)) {
            if (f10 == 1.0f) {
                Paint paint = this.layerPaint;
                if (paint != null) {
                    paint.setAlpha(f10);
                }
                this.useLayer = false;
            } else {
                obtainPaint().setAlpha(f10);
                this.useLayer = true;
            }
        }
        this.alpha = f10;
    }

    private final void configureColorFilter(ColorFilter colorFilter) {
        if (t.d(this.colorFilter, colorFilter)) {
            return;
        }
        if (!applyColorFilter(colorFilter)) {
            if (colorFilter == null) {
                Paint paint = this.layerPaint;
                if (paint != null) {
                    paint.setColorFilter(null);
                }
                this.useLayer = false;
            } else {
                obtainPaint().setColorFilter(colorFilter);
                this.useLayer = true;
            }
        }
        this.colorFilter = colorFilter;
    }

    private final void configureLayoutDirection(LayoutDirection layoutDirection) {
        if (this.layoutDirection != layoutDirection) {
            applyLayoutDirection(layoutDirection);
            this.layoutDirection = layoutDirection;
        }
    }

    /* JADX INFO: renamed from: draw-x_KDEd0$default, reason: not valid java name */
    public static /* synthetic */ void m2094drawx_KDEd0$default(Painter painter, DrawScope drawScope, long j10, float f10, ColorFilter colorFilter, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: draw-x_KDEd0");
        }
        if ((i10 & 2) != 0) {
            f10 = 1.0f;
        }
        float f11 = f10;
        if ((i10 & 4) != 0) {
            colorFilter = null;
        }
        painter.m2095drawx_KDEd0(drawScope, j10, f11, colorFilter);
    }

    private final Paint obtainPaint() {
        Paint paint = this.layerPaint;
        if (paint != null) {
            return paint;
        }
        Paint Paint = AndroidPaint_androidKt.Paint();
        this.layerPaint = Paint;
        return Paint;
    }

    protected boolean applyAlpha(float f10) {
        return false;
    }

    protected boolean applyColorFilter(@Nullable ColorFilter colorFilter) {
        return false;
    }

    protected boolean applyLayoutDirection(@NotNull LayoutDirection layoutDirection) {
        t.i(layoutDirection, "layoutDirection");
        return false;
    }

    /* JADX INFO: renamed from: draw-x_KDEd0, reason: not valid java name */
    public final void m2095drawx_KDEd0(@NotNull DrawScope draw, long j10, float f10, @Nullable ColorFilter colorFilter) {
        t.i(draw, "$this$draw");
        configureAlpha(f10);
        configureColorFilter(colorFilter);
        configureLayoutDirection(draw.getLayoutDirection());
        float fM1436getWidthimpl = Size.m1436getWidthimpl(draw.mo1996getSizeNHjbRc()) - Size.m1436getWidthimpl(j10);
        float fM1433getHeightimpl = Size.m1433getHeightimpl(draw.mo1996getSizeNHjbRc()) - Size.m1433getHeightimpl(j10);
        draw.getDrawContext().getTransform().inset(0.0f, 0.0f, fM1436getWidthimpl, fM1433getHeightimpl);
        if (f10 > 0.0f && Size.m1436getWidthimpl(j10) > 0.0f && Size.m1433getHeightimpl(j10) > 0.0f) {
            if (this.useLayer) {
                Rect rectM1407Recttz77jQw = RectKt.m1407Recttz77jQw(Offset.Companion.m1383getZeroF1C5BW0(), SizeKt.Size(Size.m1436getWidthimpl(j10), Size.m1433getHeightimpl(j10)));
                Canvas canvas = draw.getDrawContext().getCanvas();
                try {
                    canvas.saveLayer(rectM1407Recttz77jQw, obtainPaint());
                    onDraw(draw);
                } finally {
                    canvas.restore();
                }
            } else {
                onDraw(draw);
            }
        }
        draw.getDrawContext().getTransform().inset(-0.0f, -0.0f, -fM1436getWidthimpl, -fM1433getHeightimpl);
    }

    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public abstract long mo2089getIntrinsicSizeNHjbRc();

    protected abstract void onDraw(@NotNull DrawScope drawScope);
}
