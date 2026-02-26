package androidx.compose.ui.graphics;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GraphicsLayerModifier.kt */
/* JADX INFO: loaded from: classes.dex */
final class SimpleGraphicsLayerModifier$layerBlock$1 extends kotlin.jvm.internal.v implements h9.l<GraphicsLayerScope, v8.k0> {
    final /* synthetic */ SimpleGraphicsLayerModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SimpleGraphicsLayerModifier$layerBlock$1(SimpleGraphicsLayerModifier simpleGraphicsLayerModifier) {
        super(1);
        this.this$0 = simpleGraphicsLayerModifier;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ v8.k0 invoke(GraphicsLayerScope graphicsLayerScope) {
        invoke2(graphicsLayerScope);
        return v8.k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull GraphicsLayerScope graphicsLayerScope) {
        kotlin.jvm.internal.t.i(graphicsLayerScope, "$this$null");
        graphicsLayerScope.setScaleX(this.this$0.scaleX);
        graphicsLayerScope.setScaleY(this.this$0.scaleY);
        graphicsLayerScope.setAlpha(this.this$0.alpha);
        graphicsLayerScope.setTranslationX(this.this$0.translationX);
        graphicsLayerScope.setTranslationY(this.this$0.translationY);
        graphicsLayerScope.setShadowElevation(this.this$0.shadowElevation);
        graphicsLayerScope.setRotationX(this.this$0.rotationX);
        graphicsLayerScope.setRotationY(this.this$0.rotationY);
        graphicsLayerScope.setRotationZ(this.this$0.rotationZ);
        graphicsLayerScope.setCameraDistance(this.this$0.cameraDistance);
        graphicsLayerScope.mo1743setTransformOrigin__ExYCQ(this.this$0.transformOrigin);
        graphicsLayerScope.setShape(this.this$0.shape);
        graphicsLayerScope.setClip(this.this$0.clip);
        graphicsLayerScope.setRenderEffect(this.this$0.renderEffect);
        graphicsLayerScope.mo1741setAmbientShadowColor8_81llA(this.this$0.ambientShadowColor);
        graphicsLayerScope.mo1742setSpotShadowColor8_81llA(this.this$0.spotShadowColor);
    }
}
