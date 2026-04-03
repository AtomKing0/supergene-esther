package androidx.compose.ui.platform;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.ColorKt;
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
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ViewLayer.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewLayer extends View implements OwnedLayer, GraphicLayerInfo {
    private static boolean hasRetrievedMethod;

    @Nullable
    private static Field recreateDisplayList;
    private static boolean shouldUseDispatchDraw;

    @Nullable
    private static Method updateDisplayListIfDirtyMethod;

    @NotNull
    private final CanvasHolder canvasHolder;

    @Nullable
    private Rect clipBoundsCache;
    private boolean clipToBounds;

    @NotNull
    private final DrawChildContainer container;

    @Nullable
    private h9.l<? super Canvas, v8.k0> drawBlock;
    private boolean drawnWithZ;

    @Nullable
    private h9.a<v8.k0> invalidateParentLayer;
    private boolean isInvalidated;
    private long mTransformOrigin;

    @NotNull
    private final LayerMatrixCache<View> matrixCache;

    @NotNull
    private final OutlineResolver outlineResolver;

    @NotNull
    private final AndroidComposeView ownerView;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final h9.p<View, Matrix, v8.k0> getMatrix = ViewLayer$Companion$getMatrix$1.INSTANCE;

    @NotNull
    private static final ViewOutlineProvider OutlineProvider = new ViewOutlineProvider() { // from class: androidx.compose.ui.platform.ViewLayer$Companion$OutlineProvider$1
        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            kotlin.jvm.internal.t.i(view, "view");
            kotlin.jvm.internal.t.i(outline, "outline");
            Outline outline2 = ((ViewLayer) view).outlineResolver.getOutline();
            kotlin.jvm.internal.t.f(outline2);
            outline.set(outline2);
        }
    };

    /* JADX INFO: compiled from: ViewLayer.android.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final boolean getHasRetrievedMethod() {
            return ViewLayer.hasRetrievedMethod;
        }

        @NotNull
        public final ViewOutlineProvider getOutlineProvider() {
            return ViewLayer.OutlineProvider;
        }

        public final boolean getShouldUseDispatchDraw() {
            return ViewLayer.shouldUseDispatchDraw;
        }

        public final void setShouldUseDispatchDraw$ui_release(boolean z10) {
            ViewLayer.shouldUseDispatchDraw = z10;
        }

        @SuppressLint({"BanUncheckedReflection"})
        public final void updateDisplayList(@NotNull View view) {
            kotlin.jvm.internal.t.i(view, "view");
            try {
                if (!getHasRetrievedMethod()) {
                    ViewLayer.hasRetrievedMethod = true;
                    if (Build.VERSION.SDK_INT < 28) {
                        ViewLayer.updateDisplayListIfDirtyMethod = View.class.getDeclaredMethod("updateDisplayListIfDirty", new Class[0]);
                        ViewLayer.recreateDisplayList = View.class.getDeclaredField("mRecreateDisplayList");
                    } else {
                        ViewLayer.updateDisplayListIfDirtyMethod = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", String.class, new Class[0].getClass()).invoke(View.class, "updateDisplayListIfDirty", new Class[0]);
                        ViewLayer.recreateDisplayList = (Field) Class.class.getDeclaredMethod("getDeclaredField", String.class).invoke(View.class, "mRecreateDisplayList");
                    }
                    Method method = ViewLayer.updateDisplayListIfDirtyMethod;
                    if (method != null) {
                        method.setAccessible(true);
                    }
                    Field field = ViewLayer.recreateDisplayList;
                    if (field != null) {
                        field.setAccessible(true);
                    }
                }
                Field field2 = ViewLayer.recreateDisplayList;
                if (field2 != null) {
                    field2.setBoolean(view, true);
                }
                Method method2 = ViewLayer.updateDisplayListIfDirtyMethod;
                if (method2 != null) {
                    method2.invoke(view, new Object[0]);
                }
            } catch (Throwable unused) {
                setShouldUseDispatchDraw$ui_release(true);
            }
        }
    }

    /* JADX INFO: compiled from: ViewLayer.android.kt */
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewLayer(@NotNull AndroidComposeView ownerView, @NotNull DrawChildContainer container, @NotNull h9.l<? super Canvas, v8.k0> drawBlock, @NotNull h9.a<v8.k0> invalidateParentLayer) {
        super(ownerView.getContext());
        kotlin.jvm.internal.t.i(ownerView, "ownerView");
        kotlin.jvm.internal.t.i(container, "container");
        kotlin.jvm.internal.t.i(drawBlock, "drawBlock");
        kotlin.jvm.internal.t.i(invalidateParentLayer, "invalidateParentLayer");
        this.ownerView = ownerView;
        this.container = container;
        this.drawBlock = drawBlock;
        this.invalidateParentLayer = invalidateParentLayer;
        this.outlineResolver = new OutlineResolver(ownerView.getDensity());
        this.canvasHolder = new CanvasHolder();
        this.matrixCache = new LayerMatrixCache<>(getMatrix);
        this.mTransformOrigin = TransformOrigin.Companion.m1923getCenterSzJe1aQ();
        setWillNotDraw(false);
        setId(View.generateViewId());
        container.addView(this);
    }

    private final Path getManualClipPath() {
        if (!getClipToOutline() || this.outlineResolver.getOutlineClipSupported()) {
            return null;
        }
        return this.outlineResolver.getClipPath();
    }

    private final void resetClipBounds() {
        Rect rect;
        if (this.clipToBounds) {
            Rect rect2 = this.clipBoundsCache;
            if (rect2 == null) {
                this.clipBoundsCache = new Rect(0, 0, getWidth(), getHeight());
            } else {
                kotlin.jvm.internal.t.f(rect2);
                rect2.set(0, 0, getWidth(), getHeight());
            }
            rect = this.clipBoundsCache;
        } else {
            rect = null;
        }
        setClipBounds(rect);
    }

    private final void setInvalidated(boolean z10) {
        if (z10 != this.isInvalidated) {
            this.isInvalidated = z10;
            this.ownerView.notifyLayerIsDirty$ui_release(this, z10);
        }
    }

    private final void updateOutlineResolver() {
        setOutlineProvider(this.outlineResolver.getOutline() != null ? OutlineProvider : null);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void destroy() {
        setInvalidated(false);
        this.ownerView.requestClearInvalidObservations();
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.ownerView.recycle$ui_release(this);
        this.container.removeViewInLayout(this);
    }

    @Override // android.view.View
    protected void dispatchDraw(@NotNull android.graphics.Canvas canvas) {
        kotlin.jvm.internal.t.i(canvas, "canvas");
        boolean z10 = false;
        setInvalidated(false);
        CanvasHolder canvasHolder = this.canvasHolder;
        android.graphics.Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
        canvasHolder.getAndroidCanvas().setInternalCanvas(canvas);
        AndroidCanvas androidCanvas = canvasHolder.getAndroidCanvas();
        if (getManualClipPath() != null || !canvas.isHardwareAccelerated()) {
            androidCanvas.save();
            this.outlineResolver.clipToOutline(androidCanvas);
            z10 = true;
        }
        h9.l<? super Canvas, v8.k0> lVar = this.drawBlock;
        if (lVar != null) {
            lVar.invoke(androidCanvas);
        }
        if (z10) {
            androidCanvas.restore();
        }
        canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void drawLayer(@NotNull Canvas canvas) {
        kotlin.jvm.internal.t.i(canvas, "canvas");
        boolean z10 = getElevation() > 0.0f;
        this.drawnWithZ = z10;
        if (z10) {
            canvas.enableZ();
        }
        this.container.drawChild$ui_release(canvas, this, getDrawingTime());
        if (this.drawnWithZ) {
            canvas.disableZ();
        }
    }

    public final float getCameraDistancePx() {
        return getCameraDistance() / getResources().getDisplayMetrics().densityDpi;
    }

    @NotNull
    public final DrawChildContainer getContainer() {
        return this.container;
    }

    @Override // androidx.compose.ui.layout.GraphicLayerInfo
    public long getLayerId() {
        return getId();
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

    @Override // android.view.View, androidx.compose.ui.node.OwnedLayer
    public void invalidate() {
        if (this.isInvalidated) {
            return;
        }
        setInvalidated(true);
        super.invalidate();
        this.ownerView.invalidate();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: isInLayer-k-4lQ0M */
    public boolean mo3142isInLayerk4lQ0M(long j10) {
        float fM1367getXimpl = Offset.m1367getXimpl(j10);
        float fM1368getYimpl = Offset.m1368getYimpl(j10);
        if (this.clipToBounds) {
            return 0.0f <= fM1367getXimpl && fM1367getXimpl < ((float) getWidth()) && 0.0f <= fM1368getYimpl && fM1368getYimpl < ((float) getHeight());
        }
        if (getClipToOutline()) {
            return this.outlineResolver.m3212isInOutlinek4lQ0M(j10);
        }
        return true;
    }

    public final boolean isInvalidated() {
        return this.isInvalidated;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void mapBounds(@NotNull MutableRect rect, boolean z10) {
        kotlin.jvm.internal.t.i(rect, "rect");
        if (!z10) {
            androidx.compose.ui.graphics.Matrix.m1784mapimpl(this.matrixCache.m3190calculateMatrixGrdbGEg(this), rect);
            return;
        }
        float[] fArrM3189calculateInverseMatrixbWbORWo = this.matrixCache.m3189calculateInverseMatrixbWbORWo(this);
        if (fArrM3189calculateInverseMatrixbWbORWo != null) {
            androidx.compose.ui.graphics.Matrix.m1784mapimpl(fArrM3189calculateInverseMatrixbWbORWo, rect);
        } else {
            rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: mapOffset-8S9VItk */
    public long mo3143mapOffset8S9VItk(long j10, boolean z10) {
        if (!z10) {
            return androidx.compose.ui.graphics.Matrix.m1782mapMKHz9U(this.matrixCache.m3190calculateMatrixGrdbGEg(this), j10);
        }
        float[] fArrM3189calculateInverseMatrixbWbORWo = this.matrixCache.m3189calculateInverseMatrixbWbORWo(this);
        return fArrM3189calculateInverseMatrixbWbORWo != null ? androidx.compose.ui.graphics.Matrix.m1782mapMKHz9U(fArrM3189calculateInverseMatrixbWbORWo, j10) : Offset.Companion.m1381getInfiniteF1C5BW0();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: move--gyyYBs */
    public void mo3144movegyyYBs(long j10) {
        int iM3791getXimpl = IntOffset.m3791getXimpl(j10);
        if (iM3791getXimpl != getLeft()) {
            offsetLeftAndRight(iM3791getXimpl - getLeft());
            this.matrixCache.invalidate();
        }
        int iM3792getYimpl = IntOffset.m3792getYimpl(j10);
        if (iM3792getYimpl != getTop()) {
            offsetTopAndBottom(iM3792getYimpl - getTop());
            this.matrixCache.invalidate();
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: resize-ozmzZPI */
    public void mo3145resizeozmzZPI(long j10) {
        int iM3833getWidthimpl = IntSize.m3833getWidthimpl(j10);
        int iM3832getHeightimpl = IntSize.m3832getHeightimpl(j10);
        if (iM3833getWidthimpl == getWidth() && iM3832getHeightimpl == getHeight()) {
            return;
        }
        float f10 = iM3833getWidthimpl;
        setPivotX(TransformOrigin.m1918getPivotFractionXimpl(this.mTransformOrigin) * f10);
        float f11 = iM3832getHeightimpl;
        setPivotY(TransformOrigin.m1919getPivotFractionYimpl(this.mTransformOrigin) * f11);
        this.outlineResolver.m3213updateuvyYCjk(SizeKt.Size(f10, f11));
        updateOutlineResolver();
        layout(getLeft(), getTop(), getLeft() + iM3833getWidthimpl, getTop() + iM3832getHeightimpl);
        resetClipBounds();
        this.matrixCache.invalidate();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void reuseLayer(@NotNull h9.l<? super Canvas, v8.k0> drawBlock, @NotNull h9.a<v8.k0> invalidateParentLayer) {
        kotlin.jvm.internal.t.i(drawBlock, "drawBlock");
        kotlin.jvm.internal.t.i(invalidateParentLayer, "invalidateParentLayer");
        this.container.addView(this);
        this.clipToBounds = false;
        this.drawnWithZ = false;
        this.mTransformOrigin = TransformOrigin.Companion.m1923getCenterSzJe1aQ();
        this.drawBlock = drawBlock;
        this.invalidateParentLayer = invalidateParentLayer;
    }

    public final void setCameraDistancePx(float f10) {
        setCameraDistance(f10 * getResources().getDisplayMetrics().densityDpi);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateDisplayList() {
        if (!this.isInvalidated || shouldUseDispatchDraw) {
            return;
        }
        setInvalidated(false);
        Companion.updateDisplayList(this);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* JADX INFO: renamed from: updateLayerProperties-NHXXZp8 */
    public void mo3146updateLayerPropertiesNHXXZp8(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, long j10, @NotNull Shape shape, boolean z10, @Nullable RenderEffect renderEffect, long j11, long j12, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
        h9.a<v8.k0> aVar;
        kotlin.jvm.internal.t.i(shape, "shape");
        kotlin.jvm.internal.t.i(layoutDirection, "layoutDirection");
        kotlin.jvm.internal.t.i(density, "density");
        this.mTransformOrigin = j10;
        setScaleX(f10);
        setScaleY(f11);
        setAlpha(f12);
        setTranslationX(f13);
        setTranslationY(f14);
        setElevation(f15);
        setRotation(f18);
        setRotationX(f16);
        setRotationY(f17);
        setPivotX(TransformOrigin.m1918getPivotFractionXimpl(this.mTransformOrigin) * getWidth());
        setPivotY(TransformOrigin.m1919getPivotFractionYimpl(this.mTransformOrigin) * getHeight());
        setCameraDistancePx(f19);
        this.clipToBounds = z10 && shape == RectangleShapeKt.getRectangleShape();
        resetClipBounds();
        boolean z11 = getManualClipPath() != null;
        setClipToOutline(z10 && shape != RectangleShapeKt.getRectangleShape());
        boolean zUpdate = this.outlineResolver.update(shape, getAlpha(), getClipToOutline(), getElevation(), layoutDirection, density);
        updateOutlineResolver();
        boolean z12 = getManualClipPath() != null;
        if (z11 != z12 || (z12 && zUpdate)) {
            invalidate();
        }
        if (!this.drawnWithZ && getElevation() > 0.0f && (aVar = this.invalidateParentLayer) != null) {
            aVar.invoke();
        }
        this.matrixCache.invalidate();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            ViewLayerVerificationHelper28 viewLayerVerificationHelper28 = ViewLayerVerificationHelper28.INSTANCE;
            viewLayerVerificationHelper28.setOutlineAmbientShadowColor(this, ColorKt.m1653toArgb8_81llA(j11));
            viewLayerVerificationHelper28.setOutlineSpotShadowColor(this, ColorKt.m1653toArgb8_81llA(j12));
        }
        if (i10 >= 31) {
            ViewLayerVerificationHelper31.INSTANCE.setRenderEffect(this, renderEffect);
        }
    }

    @Override // android.view.View
    public void forceLayout() {
    }

    @Override // android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
    }
}
