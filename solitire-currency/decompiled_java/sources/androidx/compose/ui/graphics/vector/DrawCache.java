package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.b;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: DrawCache.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DrawCache {

    @Nullable
    private Canvas cachedCanvas;

    @Nullable
    private ImageBitmap mCachedImage;

    @Nullable
    private Density scopeDensity;

    @NotNull
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private long size = IntSize.Companion.m3838getZeroYbymL2g();

    @NotNull
    private final CanvasDrawScope cacheScope = new CanvasDrawScope();

    private final void clear(DrawScope drawScope) {
        b.K(drawScope, Color.Companion.m1624getBlack0d7_KjU(), 0L, 0L, 0.0f, null, null, BlendMode.Companion.m1521getClear0nO6VwU(), 62, null);
    }

    public static /* synthetic */ void drawInto$default(DrawCache drawCache, DrawScope drawScope, float f10, ColorFilter colorFilter, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f10 = 1.0f;
        }
        if ((i10 & 4) != 0) {
            colorFilter = null;
        }
        drawCache.drawInto(drawScope, f10, colorFilter);
    }

    /* JADX INFO: renamed from: drawCachedImage-CJJAR-o, reason: not valid java name */
    public final void m2096drawCachedImageCJJARo(long j10, @NotNull Density density, @NotNull LayoutDirection layoutDirection, @NotNull l<? super DrawScope, k0> block) {
        t.i(density, "density");
        t.i(layoutDirection, "layoutDirection");
        t.i(block, "block");
        this.scopeDensity = density;
        this.layoutDirection = layoutDirection;
        ImageBitmap imageBitmapM1773ImageBitmapx__hDU$default = this.mCachedImage;
        Canvas Canvas = this.cachedCanvas;
        if (imageBitmapM1773ImageBitmapx__hDU$default == null || Canvas == null || IntSize.m3833getWidthimpl(j10) > imageBitmapM1773ImageBitmapx__hDU$default.getWidth() || IntSize.m3832getHeightimpl(j10) > imageBitmapM1773ImageBitmapx__hDU$default.getHeight()) {
            imageBitmapM1773ImageBitmapx__hDU$default = ImageBitmapKt.m1773ImageBitmapx__hDU$default(IntSize.m3833getWidthimpl(j10), IntSize.m3832getHeightimpl(j10), 0, false, null, 28, null);
            Canvas = CanvasKt.Canvas(imageBitmapM1773ImageBitmapx__hDU$default);
            this.mCachedImage = imageBitmapM1773ImageBitmapx__hDU$default;
            this.cachedCanvas = Canvas;
        }
        this.size = j10;
        CanvasDrawScope canvasDrawScope = this.cacheScope;
        long jM3843toSizeozmzZPI = IntSizeKt.m3843toSizeozmzZPI(j10);
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope.getDrawParams();
        Density densityComponent1 = drawParams.component1();
        LayoutDirection layoutDirectionComponent2 = drawParams.component2();
        Canvas canvasComponent3 = drawParams.component3();
        long jM1998component4NHjbRc = drawParams.m1998component4NHjbRc();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope.getDrawParams();
        drawParams2.setDensity(density);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(Canvas);
        drawParams2.m2001setSizeuvyYCjk(jM3843toSizeozmzZPI);
        Canvas.save();
        clear(canvasDrawScope);
        block.invoke(canvasDrawScope);
        Canvas.restore();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope.getDrawParams();
        drawParams3.setDensity(densityComponent1);
        drawParams3.setLayoutDirection(layoutDirectionComponent2);
        drawParams3.setCanvas(canvasComponent3);
        drawParams3.m2001setSizeuvyYCjk(jM1998component4NHjbRc);
        imageBitmapM1773ImageBitmapx__hDU$default.prepareToDraw();
    }

    public final void drawInto(@NotNull DrawScope target, float f10, @Nullable ColorFilter colorFilter) {
        t.i(target, "target");
        ImageBitmap imageBitmap = this.mCachedImage;
        if (!(imageBitmap != null)) {
            throw new IllegalStateException("drawCachedImage must be invoked first before attempting to draw the result into another destination".toString());
        }
        b.z(target, imageBitmap, 0L, this.size, 0L, 0L, f10, null, colorFilter, 0, 0, 858, null);
    }

    @Nullable
    public final ImageBitmap getMCachedImage() {
        return this.mCachedImage;
    }

    public final void setMCachedImage(@Nullable ImageBitmap imageBitmap) {
        this.mCachedImage = imageBitmap;
    }

    public static /* synthetic */ void getMCachedImage$annotations() {
    }
}
