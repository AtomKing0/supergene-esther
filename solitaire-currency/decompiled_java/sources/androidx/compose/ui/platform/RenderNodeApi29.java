package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RenderNodeApi29.android.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
public final class RenderNodeApi29 implements DeviceRenderNode {

    @Nullable
    private RenderEffect internalRenderEffect;

    @NotNull
    private final AndroidComposeView ownerView;

    @NotNull
    private final RenderNode renderNode;

    public RenderNodeApi29(@NotNull AndroidComposeView ownerView) {
        kotlin.jvm.internal.t.i(ownerView, "ownerView");
        this.ownerView = ownerView;
        this.renderNode = new RenderNode("Compose");
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void discardDisplayList() {
        this.renderNode.discardDisplayList();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void drawInto(@NotNull Canvas canvas) {
        kotlin.jvm.internal.t.i(canvas, "canvas");
        canvas.drawRenderNode(this.renderNode);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    @NotNull
    public DeviceRenderNodeData dumpRenderNodeData() {
        return new DeviceRenderNodeData(this.renderNode.getUniqueId(), this.renderNode.getLeft(), this.renderNode.getTop(), this.renderNode.getRight(), this.renderNode.getBottom(), this.renderNode.getWidth(), this.renderNode.getHeight(), this.renderNode.getScaleX(), this.renderNode.getScaleY(), this.renderNode.getTranslationX(), this.renderNode.getTranslationY(), this.renderNode.getElevation(), this.renderNode.getAmbientShadowColor(), this.renderNode.getSpotShadowColor(), this.renderNode.getRotationZ(), this.renderNode.getRotationX(), this.renderNode.getRotationY(), this.renderNode.getCameraDistance(), this.renderNode.getPivotX(), this.renderNode.getPivotY(), this.renderNode.getClipToOutline(), this.renderNode.getClipToBounds(), this.renderNode.getAlpha(), this.internalRenderEffect);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getAlpha() {
        return this.renderNode.getAlpha();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getAmbientShadowColor() {
        return this.renderNode.getAmbientShadowColor();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getBottom() {
        return this.renderNode.getBottom();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getCameraDistance() {
        return this.renderNode.getCameraDistance();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean getClipToBounds() {
        return this.renderNode.getClipToBounds();
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
        return this.renderNode.hasDisplayList();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getHeight() {
        return this.renderNode.getHeight();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void getInverseMatrix(@NotNull Matrix matrix) {
        kotlin.jvm.internal.t.i(matrix, "matrix");
        this.renderNode.getInverseMatrix(matrix);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getLeft() {
        return this.renderNode.getLeft();
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
        return this.internalRenderEffect;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getRight() {
        return this.renderNode.getRight();
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
        return this.renderNode.getRotationZ();
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
        return this.renderNode.getSpotShadowColor();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getTop() {
        return this.renderNode.getTop();
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
        return this.renderNode.getUniqueId();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getWidth() {
        return this.renderNode.getWidth();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void offsetLeftAndRight(int i10) {
        this.renderNode.offsetLeftAndRight(i10);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void offsetTopAndBottom(int i10) {
        this.renderNode.offsetTopAndBottom(i10);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void record(@NotNull CanvasHolder canvasHolder, @Nullable Path path, @NotNull h9.l<? super androidx.compose.ui.graphics.Canvas, v8.k0> drawBlock) {
        kotlin.jvm.internal.t.i(canvasHolder, "canvasHolder");
        kotlin.jvm.internal.t.i(drawBlock, "drawBlock");
        RecordingCanvas recordingCanvasBeginRecording = this.renderNode.beginRecording();
        kotlin.jvm.internal.t.h(recordingCanvasBeginRecording, "renderNode.beginRecording()");
        Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
        canvasHolder.getAndroidCanvas().setInternalCanvas(recordingCanvasBeginRecording);
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
        this.renderNode.endRecording();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setAlpha(float f10) {
        this.renderNode.setAlpha(f10);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setAmbientShadowColor(int i10) {
        this.renderNode.setAmbientShadowColor(i10);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setCameraDistance(float f10) {
        this.renderNode.setCameraDistance(f10);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setClipToBounds(boolean z10) {
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
        return this.renderNode.setPosition(i10, i11, i12, i13);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setRenderEffect(@Nullable RenderEffect renderEffect) {
        this.internalRenderEffect = renderEffect;
        if (Build.VERSION.SDK_INT >= 31) {
            RenderNodeApi29VerificationHelper.INSTANCE.setRenderEffect(this.renderNode, renderEffect);
        }
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
        this.renderNode.setRotationZ(f10);
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
        this.renderNode.setSpotShadowColor(i10);
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
