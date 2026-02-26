package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.layout.GraphicLayerInfo;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RenderNodeLayer.android.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
public final class RenderNodeLayer implements OwnedLayer, GraphicLayerInfo {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final h9.p<DeviceRenderNode, Matrix, v8.k0> getMatrix = RenderNodeLayer$Companion$getMatrix$1.INSTANCE;

    @NotNull
    private final CanvasHolder canvasHolder;

    @Nullable
    private h9.l<? super Canvas, v8.k0> drawBlock;
    private boolean drawnWithZ;

    @Nullable
    private h9.a<v8.k0> invalidateParentLayer;
    private boolean isDestroyed;
    private boolean isDirty;

    @NotNull
    private final LayerMatrixCache<DeviceRenderNode> matrixCache;

    @NotNull
    private final OutlineResolver outlineResolver;

    @NotNull
    private final AndroidComposeView ownerView;

    @NotNull
    private final DeviceRenderNode renderNode;

    @Nullable
    private Paint softwareLayerPaint;
    private long transformOrigin;

    /* JADX INFO: compiled from: RenderNodeLayer.android.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: RenderNodeLayer.android.kt */
    @RequiresApi(29)
    private static final class UniqueDrawingIdApi29 {

        @NotNull
        public static final UniqueDrawingIdApi29 INSTANCE = new UniqueDrawingIdApi29();

        private UniqueDrawingIdApi29() {
        }

        @DoNotInline
        public static final long getUniqueDrawingId(@NotNull View view) {
            kotlin.jvm.internal.t.i(view, "view");
            return view.getUniqueDrawingId();
        }
    }

    public RenderNodeLayer(@NotNull AndroidComposeView ownerView, @NotNull h9.l<? super Canvas, v8.k0> drawBlock, @NotNull h9.a<v8.k0> invalidateParentLayer) {
        kotlin.jvm.internal.t.i(ownerView, "ownerView");
        kotlin.jvm.internal.t.i(drawBlock, "drawBlock");
        kotlin.jvm.internal.t.i(invalidateParentLayer, "invalidateParentLayer");
        this.ownerView = ownerView;
        this.drawBlock = drawBlock;
        this.invalidateParentLayer = invalidateParentLayer;
        this.outlineResolver = new OutlineResolver(ownerView.getDensity());
        this.matrixCache = new LayerMatrixCache<>(getMatrix);
        this.canvasHolder = new CanvasHolder();
        this.transformOrigin = TransformOrigin.Companion.m1923getCenterSzJe1aQ();
        DeviceRenderNode renderNodeApi29 = Build.VERSION.SDK_INT >= 29 ? new RenderNodeApi29(ownerView) : new RenderNodeApi23(ownerView);
        renderNodeApi29.setHasOverlappingRendering(true);
        this.renderNode = renderNodeApi29;
    }

    private final void clipRenderNode(Canvas canvas) {
        if (this.renderNode.getClipToOutline() || this.renderNode.getClipToBounds()) {
            this.outlineResolver.clipToOutline(canvas);
        }
    }

    private final void setDirty(boolean z10) {
        if (z10 != this.isDirty) {
            this.isDirty = z10;
            this.ownerView.notifyLayerIsDirty$ui_release(this, z10);
        }
    }

    private final void triggerRepaint() {
        if (Build.VERSION.SDK_INT >= 26) {
            WrapperRenderNodeLayerHelperMethods.INSTANCE.onDescendantInvalidated(this.ownerView);
        } else {
            this.ownerView.invalidate();
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void destroy() {
        if (this.renderNode.getHasDisplayList()) {
            this.renderNode.discardDisplayList();
        }
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.isDestroyed = true;
        setDirty(false);
        this.ownerView.requestClearInvalidObservations();
        this.ownerView.recycle$ui_release(this);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void drawLayer(@NotNull Canvas canvas) {
        kotlin.jvm.internal.t.i(canvas, "canvas");
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (nativeCanvas.isHardwareAccelerated()) {
            updateDisplayList();
            boolean z10 = this.renderNode.getElevation() > 0.0f;
            this.drawnWithZ = z10;
            if (z10) {
                canvas.enableZ();
            }
            this.renderNode.drawInto(nativeCanvas);
            if (this.drawnWithZ) {
                canvas.disableZ();
                return;
            }
            return;
        }
        float left = this.renderNode.getLeft();
        float top = this.renderNode.getTop();
        float right = this.renderNode.getRight();
        float bottom = this.renderNode.getBottom();
        if (this.renderNode.getAlpha() < 1.0f) {
            Paint Paint = this.softwareLayerPaint;
            if (Paint == null) {
                Paint = AndroidPaint_androidKt.Paint();
                this.softwareLayerPaint = Paint;
            }
            Paint.setAlpha(this.renderNode.getAlpha());
            nativeCanvas.saveLayer(left, top, right, bottom, Paint.asFrameworkPaint());
        } else {
            canvas.save();
        }
        canvas.translate(left, top);
        canvas.mo1464concat58bKbWc(this.matrixCache.m3190calculateMatrixGrdbGEg(this.renderNode));
        clipRenderNode(canvas);
        h9.l<? super Canvas, v8.k0> lVar = this.drawBlock;
        if (lVar != null) {
            lVar.invoke(canvas);
        }
        canvas.restore();
        setDirty(false);
    }

    @Override // androidx.compose.ui.layout.GraphicLayerInfo
    public long getLayerId() {
        return this.renderNode.getUniqueId();
    }

    @NotNull
    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    @Override // androidx.compose.ui.layout.GraphicLayerInfo
    public long getOwnerViewId() {
        if (Build.VERSION.SDK_INT >= 29) {
            return UniqueDrawingIdApi29.getUniqueDrawingId(this.ownerView);
        }
        return -1L;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void invalidate() {
        if (this.isDirty || this.isDestroyed) {
            return;
        }
        this.ownerView.invalidate();
        setDirty(true);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: isInLayer-k-4lQ0M */
    public boolean mo3142isInLayerk4lQ0M(long j10) {
        float fM1367getXimpl = Offset.m1367getXimpl(j10);
        float fM1368getYimpl = Offset.m1368getYimpl(j10);
        if (this.renderNode.getClipToBounds()) {
            return 0.0f <= fM1367getXimpl && fM1367getXimpl < ((float) this.renderNode.getWidth()) && 0.0f <= fM1368getYimpl && fM1368getYimpl < ((float) this.renderNode.getHeight());
        }
        if (this.renderNode.getClipToOutline()) {
            return this.outlineResolver.m3212isInOutlinek4lQ0M(j10);
        }
        return true;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void mapBounds(@NotNull MutableRect rect, boolean z10) {
        kotlin.jvm.internal.t.i(rect, "rect");
        if (!z10) {
            androidx.compose.ui.graphics.Matrix.m1784mapimpl(this.matrixCache.m3190calculateMatrixGrdbGEg(this.renderNode), rect);
            return;
        }
        float[] fArrM3189calculateInverseMatrixbWbORWo = this.matrixCache.m3189calculateInverseMatrixbWbORWo(this.renderNode);
        if (fArrM3189calculateInverseMatrixbWbORWo == null) {
            rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            androidx.compose.ui.graphics.Matrix.m1784mapimpl(fArrM3189calculateInverseMatrixbWbORWo, rect);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: mapOffset-8S9VItk */
    public long mo3143mapOffset8S9VItk(long j10, boolean z10) {
        if (!z10) {
            return androidx.compose.ui.graphics.Matrix.m1782mapMKHz9U(this.matrixCache.m3190calculateMatrixGrdbGEg(this.renderNode), j10);
        }
        float[] fArrM3189calculateInverseMatrixbWbORWo = this.matrixCache.m3189calculateInverseMatrixbWbORWo(this.renderNode);
        return fArrM3189calculateInverseMatrixbWbORWo != null ? androidx.compose.ui.graphics.Matrix.m1782mapMKHz9U(fArrM3189calculateInverseMatrixbWbORWo, j10) : Offset.Companion.m1381getInfiniteF1C5BW0();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: move--gyyYBs */
    public void mo3144movegyyYBs(long j10) {
        int left = this.renderNode.getLeft();
        int top = this.renderNode.getTop();
        int iM3791getXimpl = IntOffset.m3791getXimpl(j10);
        int iM3792getYimpl = IntOffset.m3792getYimpl(j10);
        if (left == iM3791getXimpl && top == iM3792getYimpl) {
            return;
        }
        this.renderNode.offsetLeftAndRight(iM3791getXimpl - left);
        this.renderNode.offsetTopAndBottom(iM3792getYimpl - top);
        triggerRepaint();
        this.matrixCache.invalidate();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: resize-ozmzZPI */
    public void mo3145resizeozmzZPI(long j10) {
        int iM3833getWidthimpl = IntSize.m3833getWidthimpl(j10);
        int iM3832getHeightimpl = IntSize.m3832getHeightimpl(j10);
        float f10 = iM3833getWidthimpl;
        this.renderNode.setPivotX(TransformOrigin.m1918getPivotFractionXimpl(this.transformOrigin) * f10);
        float f11 = iM3832getHeightimpl;
        this.renderNode.setPivotY(TransformOrigin.m1919getPivotFractionYimpl(this.transformOrigin) * f11);
        DeviceRenderNode deviceRenderNode = this.renderNode;
        if (deviceRenderNode.setPosition(deviceRenderNode.getLeft(), this.renderNode.getTop(), this.renderNode.getLeft() + iM3833getWidthimpl, this.renderNode.getTop() + iM3832getHeightimpl)) {
            this.outlineResolver.m3213updateuvyYCjk(SizeKt.Size(f10, f11));
            this.renderNode.setOutline(this.outlineResolver.getOutline());
            invalidate();
            this.matrixCache.invalidate();
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void reuseLayer(@NotNull h9.l<? super Canvas, v8.k0> drawBlock, @NotNull h9.a<v8.k0> invalidateParentLayer) {
        kotlin.jvm.internal.t.i(drawBlock, "drawBlock");
        kotlin.jvm.internal.t.i(invalidateParentLayer, "invalidateParentLayer");
        setDirty(false);
        this.isDestroyed = false;
        this.drawnWithZ = false;
        this.transformOrigin = TransformOrigin.Companion.m1923getCenterSzJe1aQ();
        this.drawBlock = drawBlock;
        this.invalidateParentLayer = invalidateParentLayer;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateDisplayList() {
        if (this.isDirty || !this.renderNode.getHasDisplayList()) {
            setDirty(false);
            Path clipPath = (!this.renderNode.getClipToOutline() || this.outlineResolver.getOutlineClipSupported()) ? null : this.outlineResolver.getClipPath();
            h9.l<? super Canvas, v8.k0> lVar = this.drawBlock;
            if (lVar != null) {
                this.renderNode.record(this.canvasHolder, clipPath, lVar);
            }
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: updateLayerProperties-NHXXZp8 */
    public void mo3146updateLayerPropertiesNHXXZp8(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, long j10, @NotNull Shape shape, boolean z10, @Nullable RenderEffect renderEffect, long j11, long j12, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
        h9.a<v8.k0> aVar;
        kotlin.jvm.internal.t.i(shape, "shape");
        kotlin.jvm.internal.t.i(layoutDirection, "layoutDirection");
        kotlin.jvm.internal.t.i(density, "density");
        this.transformOrigin = j10;
        boolean z11 = this.renderNode.getClipToOutline() && !this.outlineResolver.getOutlineClipSupported();
        this.renderNode.setScaleX(f10);
        this.renderNode.setScaleY(f11);
        this.renderNode.setAlpha(f12);
        this.renderNode.setTranslationX(f13);
        this.renderNode.setTranslationY(f14);
        this.renderNode.setElevation(f15);
        this.renderNode.setAmbientShadowColor(ColorKt.m1653toArgb8_81llA(j11));
        this.renderNode.setSpotShadowColor(ColorKt.m1653toArgb8_81llA(j12));
        this.renderNode.setRotationZ(f18);
        this.renderNode.setRotationX(f16);
        this.renderNode.setRotationY(f17);
        this.renderNode.setCameraDistance(f19);
        this.renderNode.setPivotX(TransformOrigin.m1918getPivotFractionXimpl(j10) * this.renderNode.getWidth());
        this.renderNode.setPivotY(TransformOrigin.m1919getPivotFractionYimpl(j10) * this.renderNode.getHeight());
        this.renderNode.setClipToOutline(z10 && shape != RectangleShapeKt.getRectangleShape());
        this.renderNode.setClipToBounds(z10 && shape == RectangleShapeKt.getRectangleShape());
        this.renderNode.setRenderEffect(renderEffect);
        boolean zUpdate = this.outlineResolver.update(shape, this.renderNode.getAlpha(), this.renderNode.getClipToOutline(), this.renderNode.getElevation(), layoutDirection, density);
        this.renderNode.setOutline(this.outlineResolver.getOutline());
        boolean z12 = this.renderNode.getClipToOutline() && !this.outlineResolver.getOutlineClipSupported();
        if (z11 != z12 || (z12 && zUpdate)) {
            invalidate();
        } else {
            triggerRepaint();
        }
        if (!this.drawnWithZ && this.renderNode.getElevation() > 0.0f && (aVar = this.invalidateParentLayer) != null) {
            aVar.invoke();
        }
        this.matrixCache.invalidate();
    }
}
