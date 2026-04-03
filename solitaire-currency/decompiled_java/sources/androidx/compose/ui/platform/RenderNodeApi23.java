package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.os.Build;
import android.view.DisplayListCanvas;
import android.view.RenderNode;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.core.view.ViewCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RenderNodeApi23.android.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
public final class RenderNodeApi23 implements DeviceRenderNode {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static boolean needToValidateAccess = true;
    private static boolean testFailCreateRenderNode;
    private int bottom;
    private boolean clipToBounds;
    private int left;

    @NotNull
    private final AndroidComposeView ownerView;

    @Nullable
    private RenderEffect renderEffect;

    @NotNull
    private final RenderNode renderNode;
    private int right;
    private int top;

    /* JADX INFO: compiled from: RenderNodeApi23.android.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final boolean getTestFailCreateRenderNode$ui_release() {
            return RenderNodeApi23.testFailCreateRenderNode;
        }

        public final void setTestFailCreateRenderNode$ui_release(boolean z10) {
            RenderNodeApi23.testFailCreateRenderNode = z10;
        }
    }

    public RenderNodeApi23(@NotNull AndroidComposeView ownerView) {
        kotlin.jvm.internal.t.i(ownerView, "ownerView");
        this.ownerView = ownerView;
        RenderNode renderNodeCreate = RenderNode.create("Compose", ownerView);
        kotlin.jvm.internal.t.h(renderNodeCreate, "create(\"Compose\", ownerView)");
        this.renderNode = renderNodeCreate;
        if (needToValidateAccess) {
            renderNodeCreate.setScaleX(renderNodeCreate.getScaleX());
            renderNodeCreate.setScaleY(renderNodeCreate.getScaleY());
            renderNodeCreate.setTranslationX(renderNodeCreate.getTranslationX());
            renderNodeCreate.setTranslationY(renderNodeCreate.getTranslationY());
            renderNodeCreate.setElevation(renderNodeCreate.getElevation());
            renderNodeCreate.setRotation(renderNodeCreate.getRotation());
            renderNodeCreate.setRotationX(renderNodeCreate.getRotationX());
            renderNodeCreate.setRotationY(renderNodeCreate.getRotationY());
            renderNodeCreate.setCameraDistance(renderNodeCreate.getCameraDistance());
            renderNodeCreate.setPivotX(renderNodeCreate.getPivotX());
            renderNodeCreate.setPivotY(renderNodeCreate.getPivotY());
            renderNodeCreate.setClipToOutline(renderNodeCreate.getClipToOutline());
            renderNodeCreate.setClipToBounds(false);
            renderNodeCreate.setAlpha(renderNodeCreate.getAlpha());
            renderNodeCreate.isValid();
            renderNodeCreate.setLeftTopRightBottom(0, 0, 0, 0);
            renderNodeCreate.offsetLeftAndRight(0);
            renderNodeCreate.offsetTopAndBottom(0);
            verifyShadowColorProperties(renderNodeCreate);
            discardDisplayListInternal();
            needToValidateAccess = false;
        }
        if (testFailCreateRenderNode) {
            throw new NoClassDefFoundError();
        }
    }

    private final void discardDisplayListInternal() {
        if (Build.VERSION.SDK_INT >= 24) {
            RenderNodeVerificationHelper24.INSTANCE.discardDisplayList(this.renderNode);
        } else {
            RenderNodeVerificationHelper23.INSTANCE.destroyDisplayListData(this.renderNode);
        }
    }

    private final void verifyShadowColorProperties(RenderNode renderNode) {
        if (Build.VERSION.SDK_INT >= 28) {
            RenderNodeVerificationHelper28 renderNodeVerificationHelper28 = RenderNodeVerificationHelper28.INSTANCE;
            renderNodeVerificationHelper28.setAmbientShadowColor(renderNode, renderNodeVerificationHelper28.getAmbientShadowColor(renderNode));
            renderNodeVerificationHelper28.setSpotShadowColor(renderNode, renderNodeVerificationHelper28.getSpotShadowColor(renderNode));
        }
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void discardDisplayList() {
        discardDisplayListInternal();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void drawInto(@NotNull Canvas canvas) {
        kotlin.jvm.internal.t.i(canvas, "canvas");
        ((DisplayListCanvas) canvas).drawRenderNode(this.renderNode);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    @NotNull
    public DeviceRenderNodeData dumpRenderNodeData() {
        return new DeviceRenderNodeData(0L, 0, 0, 0, 0, 0, 0, this.renderNode.getScaleX(), this.renderNode.getScaleY(), this.renderNode.getTranslationX(), this.renderNode.getTranslationY(), this.renderNode.getElevation(), getAmbientShadowColor(), getSpotShadowColor(), this.renderNode.getRotation(), this.renderNode.getRotationX(), this.renderNode.getRotationY(), this.renderNode.getCameraDistance(), this.renderNode.getPivotX(), this.renderNode.getPivotY(), this.renderNode.getClipToOutline(), getClipToBounds(), this.renderNode.getAlpha(), getRenderEffect());
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getAlpha() {
        return this.renderNode.getAlpha();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getAmbientShadowColor() {
        return Build.VERSION.SDK_INT >= 28 ? RenderNodeVerificationHelper28.INSTANCE.getAmbientShadowColor(this.renderNode) : ViewCompat.MEASURED_STATE_MASK;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getBottom() {
        return this.bottom;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getCameraDistance() {
        return -this.renderNode.getCameraDistance();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean getClipToBounds() {
        return this.clipToBounds;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean getClipToOutline() {
        return this.renderNode.getClipToOutline();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getElevation() {
        return this.renderNode.getElevation();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean getHasDisplayList() {
        return this.renderNode.isValid();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getHeight() {
        return getBottom() - getTop();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void getInverseMatrix(@NotNull Matrix matrix) {
        kotlin.jvm.internal.t.i(matrix, "matrix");
        this.renderNode.getInverseMatrix(matrix);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getLeft() {
        return this.left;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void getMatrix(@NotNull Matrix matrix) {
        kotlin.jvm.internal.t.i(matrix, "matrix");
        this.renderNode.getMatrix(matrix);
    }

    @NotNull
    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getPivotX() {
        return this.renderNode.getPivotX();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getPivotY() {
        return this.renderNode.getPivotY();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    @Nullable
    public RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getRight() {
        return this.right;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getRotationX() {
        return this.renderNode.getRotationX();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getRotationY() {
        return this.renderNode.getRotationY();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getRotationZ() {
        return this.renderNode.getRotation();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getScaleX() {
        return this.renderNode.getScaleX();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getScaleY() {
        return this.renderNode.getScaleY();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getSpotShadowColor() {
        return Build.VERSION.SDK_INT >= 28 ? RenderNodeVerificationHelper28.INSTANCE.getSpotShadowColor(this.renderNode) : ViewCompat.MEASURED_STATE_MASK;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getTop() {
        return this.top;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getTranslationX() {
        return this.renderNode.getTranslationX();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getTranslationY() {
        return this.renderNode.getTranslationY();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public long getUniqueId() {
        return 0L;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getWidth() {
        return getRight() - getLeft();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void offsetLeftAndRight(int i10) {
        setLeft(getLeft() + i10);
        setRight(getRight() + i10);
        this.renderNode.offsetLeftAndRight(i10);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void offsetTopAndBottom(int i10) {
        setTop(getTop() + i10);
        setBottom(getBottom() + i10);
        this.renderNode.offsetTopAndBottom(i10);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void record(@NotNull CanvasHolder canvasHolder, @Nullable Path path, @NotNull h9.l<? super androidx.compose.ui.graphics.Canvas, v8.k0> drawBlock) {
        kotlin.jvm.internal.t.i(canvasHolder, "canvasHolder");
        kotlin.jvm.internal.t.i(drawBlock, "drawBlock");
        DisplayListCanvas displayListCanvasStart = this.renderNode.start(getWidth(), getHeight());
        kotlin.jvm.internal.t.h(displayListCanvasStart, "renderNode.start(width, height)");
        Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
        canvasHolder.getAndroidCanvas().setInternalCanvas((Canvas) displayListCanvasStart);
        AndroidCanvas androidCanvas = canvasHolder.getAndroidCanvas();
        if (path != null) {
            androidCanvas.save();
            androidx.compose.ui.graphics.a1.m(androidCanvas, path, 0, 2, null);
        }
        drawBlock.invoke(androidCanvas);
        if (path != null) {
            androidCanvas.restore();
        }
        canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
        this.renderNode.end(displayListCanvasStart);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setAlpha(float f10) {
        this.renderNode.setAlpha(f10);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setAmbientShadowColor(int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            RenderNodeVerificationHelper28.INSTANCE.setAmbientShadowColor(this.renderNode, i10);
        }
    }

    public void setBottom(int i10) {
        this.bottom = i10;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setCameraDistance(float f10) {
        this.renderNode.setCameraDistance(-f10);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setClipToBounds(boolean z10) {
        this.clipToBounds = z10;
        this.renderNode.setClipToBounds(z10);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setClipToOutline(boolean z10) {
        this.renderNode.setClipToOutline(z10);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setElevation(float f10) {
        this.renderNode.setElevation(f10);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean setHasOverlappingRendering(boolean z10) {
        return this.renderNode.setHasOverlappingRendering(z10);
    }

    public void setLeft(int i10) {
        this.left = i10;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setOutline(@Nullable Outline outline) {
        this.renderNode.setOutline(outline);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setPivotX(float f10) {
        this.renderNode.setPivotX(f10);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setPivotY(float f10) {
        this.renderNode.setPivotY(f10);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean setPosition(int i10, int i11, int i12, int i13) {
        setLeft(i10);
        setTop(i11);
        setRight(i12);
        setBottom(i13);
        return this.renderNode.setLeftTopRightBottom(i10, i11, i12, i13);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setRenderEffect(@Nullable RenderEffect renderEffect) {
        this.renderEffect = renderEffect;
    }

    public void setRight(int i10) {
        this.right = i10;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setRotationX(float f10) {
        this.renderNode.setRotationX(f10);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setRotationY(float f10) {
        this.renderNode.setRotationY(f10);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setRotationZ(float f10) {
        this.renderNode.setRotation(f10);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setScaleX(float f10) {
        this.renderNode.setScaleX(f10);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setScaleY(float f10) {
        this.renderNode.setScaleY(f10);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setSpotShadowColor(int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            RenderNodeVerificationHelper28.INSTANCE.setSpotShadowColor(this.renderNode, i10);
        }
    }

    public void setTop(int i10) {
        this.top = i10;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setTranslationX(float f10) {
        this.renderNode.setTranslationX(f10);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setTranslationY(float f10) {
        this.renderNode.setTranslationY(f10);
    }
}
