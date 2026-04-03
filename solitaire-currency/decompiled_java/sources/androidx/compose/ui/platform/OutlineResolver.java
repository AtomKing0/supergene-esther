package androidx.compose.ui.platform;

import android.graphics.Outline;
import android.os.Build;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: OutlineResolver.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OutlineResolver {
    private boolean cacheIsDirty;

    @NotNull
    private final Outline cachedOutline;

    @Nullable
    private Path cachedRrectPath;

    @Nullable
    private androidx.compose.ui.graphics.Outline calculatedOutline;

    @NotNull
    private Density density;
    private boolean isSupportedOutline;

    @NotNull
    private LayoutDirection layoutDirection;
    private boolean outlineNeeded;

    @Nullable
    private Path outlinePath;
    private long rectSize;
    private long rectTopLeft;
    private float roundedCornerRadius;

    @NotNull
    private Shape shape;
    private long size;

    @Nullable
    private Path tmpOpPath;

    @Nullable
    private Path tmpPath;

    @Nullable
    private RoundRect tmpRoundRect;

    @Nullable
    private Path tmpTouchPointPath;
    private boolean usePathForClip;

    public OutlineResolver(@NotNull Density density) {
        kotlin.jvm.internal.t.i(density, "density");
        this.density = density;
        this.isSupportedOutline = true;
        Outline outline = new Outline();
        outline.setAlpha(1.0f);
        this.cachedOutline = outline;
        Size.Companion companion = Size.Companion;
        this.size = companion.m1445getZeroNHjbRc();
        this.shape = RectangleShapeKt.getRectangleShape();
        this.rectTopLeft = Offset.Companion.m1383getZeroF1C5BW0();
        this.rectSize = companion.m1445getZeroNHjbRc();
        this.layoutDirection = LayoutDirection.Ltr;
    }

    /* JADX INFO: renamed from: isSameBounds-4L21HEs, reason: not valid java name */
    private final boolean m3211isSameBounds4L21HEs(RoundRect roundRect, long j10, long j11, float f10) {
        if (roundRect == null || !RoundRectKt.isSimple(roundRect)) {
            return false;
        }
        if (!(roundRect.getLeft() == Offset.m1367getXimpl(j10))) {
            return false;
        }
        if (!(roundRect.getTop() == Offset.m1368getYimpl(j10))) {
            return false;
        }
        if (!(roundRect.getRight() == Offset.m1367getXimpl(j10) + Size.m1436getWidthimpl(j11))) {
            return false;
        }
        if (roundRect.getBottom() == Offset.m1368getYimpl(j10) + Size.m1433getHeightimpl(j11)) {
            return (CornerRadius.m1342getXimpl(roundRect.m1417getTopLeftCornerRadiuskKHJgLs()) > f10 ? 1 : (CornerRadius.m1342getXimpl(roundRect.m1417getTopLeftCornerRadiuskKHJgLs()) == f10 ? 0 : -1)) == 0;
        }
        return false;
    }

    private final void updateCache() {
        if (this.cacheIsDirty) {
            this.rectTopLeft = Offset.Companion.m1383getZeroF1C5BW0();
            long j10 = this.size;
            this.rectSize = j10;
            this.roundedCornerRadius = 0.0f;
            this.outlinePath = null;
            this.cacheIsDirty = false;
            this.usePathForClip = false;
            if (!this.outlineNeeded || Size.m1436getWidthimpl(j10) <= 0.0f || Size.m1433getHeightimpl(this.size) <= 0.0f) {
                this.cachedOutline.setEmpty();
                return;
            }
            this.isSupportedOutline = true;
            androidx.compose.ui.graphics.Outline outlineMo201createOutlinePq9zytI = this.shape.mo201createOutlinePq9zytI(this.size, this.layoutDirection, this.density);
            this.calculatedOutline = outlineMo201createOutlinePq9zytI;
            if (outlineMo201createOutlinePq9zytI instanceof Outline.Rectangle) {
                updateCacheWithRect(((Outline.Rectangle) outlineMo201createOutlinePq9zytI).getRect());
            } else if (outlineMo201createOutlinePq9zytI instanceof Outline.Rounded) {
                updateCacheWithRoundRect(((Outline.Rounded) outlineMo201createOutlinePq9zytI).getRoundRect());
            } else if (outlineMo201createOutlinePq9zytI instanceof Outline.Generic) {
                updateCacheWithPath(((Outline.Generic) outlineMo201createOutlinePq9zytI).getPath());
            }
        }
    }

    private final void updateCacheWithPath(Path path) {
        if (Build.VERSION.SDK_INT > 28 || path.isConvex()) {
            android.graphics.Outline outline = this.cachedOutline;
            if (!(path instanceof AndroidPath)) {
                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            }
            outline.setConvexPath(((AndroidPath) path).getInternalPath());
            this.usePathForClip = !this.cachedOutline.canClip();
        } else {
            this.isSupportedOutline = false;
            this.cachedOutline.setEmpty();
            this.usePathForClip = true;
        }
        this.outlinePath = path;
    }

    private final void updateCacheWithRect(Rect rect) {
        this.rectTopLeft = OffsetKt.Offset(rect.getLeft(), rect.getTop());
        this.rectSize = SizeKt.Size(rect.getWidth(), rect.getHeight());
        this.cachedOutline.setRect(j9.c.c(rect.getLeft()), j9.c.c(rect.getTop()), j9.c.c(rect.getRight()), j9.c.c(rect.getBottom()));
    }

    private final void updateCacheWithRoundRect(RoundRect roundRect) {
        float fM1342getXimpl = CornerRadius.m1342getXimpl(roundRect.m1417getTopLeftCornerRadiuskKHJgLs());
        this.rectTopLeft = OffsetKt.Offset(roundRect.getLeft(), roundRect.getTop());
        this.rectSize = SizeKt.Size(roundRect.getWidth(), roundRect.getHeight());
        if (RoundRectKt.isSimple(roundRect)) {
            this.cachedOutline.setRoundRect(j9.c.c(roundRect.getLeft()), j9.c.c(roundRect.getTop()), j9.c.c(roundRect.getRight()), j9.c.c(roundRect.getBottom()), fM1342getXimpl);
            this.roundedCornerRadius = fM1342getXimpl;
            return;
        }
        Path Path = this.cachedRrectPath;
        if (Path == null) {
            Path = AndroidPath_androidKt.Path();
            this.cachedRrectPath = Path;
        }
        Path.reset();
        Path.addRoundRect(roundRect);
        updateCacheWithPath(Path);
    }

    public final void clipToOutline(@NotNull Canvas canvas) {
        kotlin.jvm.internal.t.i(canvas, "canvas");
        Path clipPath = getClipPath();
        if (clipPath != null) {
            androidx.compose.ui.graphics.a1.m(canvas, clipPath, 0, 2, null);
            return;
        }
        float f10 = this.roundedCornerRadius;
        if (f10 <= 0.0f) {
            androidx.compose.ui.graphics.a1.n(canvas, Offset.m1367getXimpl(this.rectTopLeft), Offset.m1368getYimpl(this.rectTopLeft), Offset.m1367getXimpl(this.rectTopLeft) + Size.m1436getWidthimpl(this.rectSize), Offset.m1368getYimpl(this.rectTopLeft) + Size.m1433getHeightimpl(this.rectSize), 0, 16, null);
            return;
        }
        Path Path = this.tmpPath;
        RoundRect roundRect = this.tmpRoundRect;
        if (Path == null || !m3211isSameBounds4L21HEs(roundRect, this.rectTopLeft, this.rectSize, f10)) {
            RoundRect roundRectM1421RoundRectgG7oq9Y = RoundRectKt.m1421RoundRectgG7oq9Y(Offset.m1367getXimpl(this.rectTopLeft), Offset.m1368getYimpl(this.rectTopLeft), Offset.m1367getXimpl(this.rectTopLeft) + Size.m1436getWidthimpl(this.rectSize), Offset.m1368getYimpl(this.rectTopLeft) + Size.m1433getHeightimpl(this.rectSize), CornerRadiusKt.CornerRadius$default(this.roundedCornerRadius, 0.0f, 2, null));
            if (Path == null) {
                Path = AndroidPath_androidKt.Path();
            } else {
                Path.reset();
            }
            Path.addRoundRect(roundRectM1421RoundRectgG7oq9Y);
            this.tmpRoundRect = roundRectM1421RoundRectgG7oq9Y;
            this.tmpPath = Path;
        }
        androidx.compose.ui.graphics.a1.m(canvas, Path, 0, 2, null);
    }

    @Nullable
    public final Path getClipPath() {
        updateCache();
        return this.outlinePath;
    }

    @Nullable
    public final android.graphics.Outline getOutline() {
        updateCache();
        if (this.outlineNeeded && this.isSupportedOutline) {
            return this.cachedOutline;
        }
        return null;
    }

    public final boolean getOutlineClipSupported() {
        return !this.usePathForClip;
    }

    /* JADX INFO: renamed from: isInOutline-k-4lQ0M, reason: not valid java name */
    public final boolean m3212isInOutlinek4lQ0M(long j10) {
        androidx.compose.ui.graphics.Outline outline;
        if (this.outlineNeeded && (outline = this.calculatedOutline) != null) {
            return ShapeContainingUtilKt.isInOutline(outline, Offset.m1367getXimpl(j10), Offset.m1368getYimpl(j10), this.tmpTouchPointPath, this.tmpOpPath);
        }
        return true;
    }

    public final boolean update(@NotNull Shape shape, float f10, boolean z10, float f11, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
        kotlin.jvm.internal.t.i(shape, "shape");
        kotlin.jvm.internal.t.i(layoutDirection, "layoutDirection");
        kotlin.jvm.internal.t.i(density, "density");
        this.cachedOutline.setAlpha(f10);
        boolean z11 = !kotlin.jvm.internal.t.d(this.shape, shape);
        if (z11) {
            this.shape = shape;
            this.cacheIsDirty = true;
        }
        boolean z12 = z10 || f11 > 0.0f;
        if (this.outlineNeeded != z12) {
            this.outlineNeeded = z12;
            this.cacheIsDirty = true;
        }
        if (this.layoutDirection != layoutDirection) {
            this.layoutDirection = layoutDirection;
            this.cacheIsDirty = true;
        }
        if (!kotlin.jvm.internal.t.d(this.density, density)) {
            this.density = density;
            this.cacheIsDirty = true;
        }
        return z11;
    }

    /* JADX INFO: renamed from: update-uvyYCjk, reason: not valid java name */
    public final void m3213updateuvyYCjk(long j10) {
        if (Size.m1432equalsimpl0(this.size, j10)) {
            return;
        }
        this.size = j10;
        this.cacheIsDirty = true;
    }
}
