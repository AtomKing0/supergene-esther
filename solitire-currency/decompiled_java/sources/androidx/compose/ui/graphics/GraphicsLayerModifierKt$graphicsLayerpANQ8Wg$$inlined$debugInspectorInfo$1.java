package androidx.compose.ui.graphics;

import androidx.compose.ui.platform.InspectorInfo;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: androidx.compose.ui.graphics.GraphicsLayerModifierKt$graphicsLayer-pANQ8Wg$$inlined$debugInspectorInfo$1, reason: invalid class name */
/* JADX INFO: compiled from: InspectableValue.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GraphicsLayerModifierKt$graphicsLayerpANQ8Wg$$inlined$debugInspectorInfo$1 extends kotlin.jvm.internal.v implements h9.l<InspectorInfo, v8.k0> {
    final /* synthetic */ float $alpha$inlined;
    final /* synthetic */ long $ambientShadowColor$inlined;
    final /* synthetic */ float $cameraDistance$inlined;
    final /* synthetic */ boolean $clip$inlined;
    final /* synthetic */ RenderEffect $renderEffect$inlined;
    final /* synthetic */ float $rotationX$inlined;
    final /* synthetic */ float $rotationY$inlined;
    final /* synthetic */ float $rotationZ$inlined;
    final /* synthetic */ float $scaleX$inlined;
    final /* synthetic */ float $scaleY$inlined;
    final /* synthetic */ float $shadowElevation$inlined;
    final /* synthetic */ Shape $shape$inlined;
    final /* synthetic */ long $spotShadowColor$inlined;
    final /* synthetic */ long $transformOrigin$inlined;
    final /* synthetic */ float $translationX$inlined;
    final /* synthetic */ float $translationY$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GraphicsLayerModifierKt$graphicsLayerpANQ8Wg$$inlined$debugInspectorInfo$1(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, long j10, Shape shape, boolean z10, RenderEffect renderEffect, long j11, long j12) {
        super(1);
        this.$scaleX$inlined = f10;
        this.$scaleY$inlined = f11;
        this.$alpha$inlined = f12;
        this.$translationX$inlined = f13;
        this.$translationY$inlined = f14;
        this.$shadowElevation$inlined = f15;
        this.$rotationX$inlined = f16;
        this.$rotationY$inlined = f17;
        this.$rotationZ$inlined = f18;
        this.$cameraDistance$inlined = f19;
        this.$transformOrigin$inlined = j10;
        this.$shape$inlined = shape;
        this.$clip$inlined = z10;
        this.$renderEffect$inlined = renderEffect;
        this.$ambientShadowColor$inlined = j11;
        this.$spotShadowColor$inlined = j12;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ v8.k0 invoke(InspectorInfo inspectorInfo) {
        invoke2(inspectorInfo);
        return v8.k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull InspectorInfo inspectorInfo) {
        kotlin.jvm.internal.t.i(inspectorInfo, "$this$null");
        inspectorInfo.setName("graphicsLayer");
        inspectorInfo.getProperties().set("scaleX", Float.valueOf(this.$scaleX$inlined));
        inspectorInfo.getProperties().set("scaleY", Float.valueOf(this.$scaleY$inlined));
        inspectorInfo.getProperties().set("alpha", Float.valueOf(this.$alpha$inlined));
        inspectorInfo.getProperties().set("translationX", Float.valueOf(this.$translationX$inlined));
        inspectorInfo.getProperties().set("translationY", Float.valueOf(this.$translationY$inlined));
        inspectorInfo.getProperties().set("shadowElevation", Float.valueOf(this.$shadowElevation$inlined));
        inspectorInfo.getProperties().set("rotationX", Float.valueOf(this.$rotationX$inlined));
        inspectorInfo.getProperties().set("rotationY", Float.valueOf(this.$rotationY$inlined));
        inspectorInfo.getProperties().set("rotationZ", Float.valueOf(this.$rotationZ$inlined));
        inspectorInfo.getProperties().set("cameraDistance", Float.valueOf(this.$cameraDistance$inlined));
        inspectorInfo.getProperties().set("transformOrigin", TransformOrigin.m1910boximpl(this.$transformOrigin$inlined));
        inspectorInfo.getProperties().set("shape", this.$shape$inlined);
        inspectorInfo.getProperties().set("clip", Boolean.valueOf(this.$clip$inlined));
        inspectorInfo.getProperties().set("renderEffect", this.$renderEffect$inlined);
        inspectorInfo.getProperties().set("ambientShadowColor", Color.m1588boximpl(this.$ambientShadowColor$inlined));
        inspectorInfo.getProperties().set("spotShadowColor", Color.m1588boximpl(this.$spotShadowColor$inlined));
    }
}
