package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.RenderEffectKt;
import androidx.compose.ui.graphics.Shape;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Blur.kt */
/* JADX INFO: loaded from: classes.dex */
final class BlurKt$blur$1 extends v implements l<GraphicsLayerScope, k0> {
    final /* synthetic */ boolean $clip;
    final /* synthetic */ Shape $edgeTreatment;
    final /* synthetic */ float $radiusX;
    final /* synthetic */ float $radiusY;
    final /* synthetic */ int $tileMode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlurKt$blur$1(float f10, float f11, int i10, Shape shape, boolean z10) {
        super(1);
        this.$radiusX = f10;
        this.$radiusY = f11;
        this.$tileMode = i10;
        this.$edgeTreatment = shape;
        this.$clip = z10;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(GraphicsLayerScope graphicsLayerScope) {
        invoke2(graphicsLayerScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull GraphicsLayerScope graphicsLayer) {
        t.i(graphicsLayer, "$this$graphicsLayer");
        float fMo296toPx0680j_4 = graphicsLayer.mo296toPx0680j_4(this.$radiusX);
        float fMo296toPx0680j_42 = graphicsLayer.mo296toPx0680j_4(this.$radiusY);
        graphicsLayer.setRenderEffect((fMo296toPx0680j_4 <= 0.0f || fMo296toPx0680j_42 <= 0.0f) ? null : RenderEffectKt.m1849BlurEffect3YTHUZs(fMo296toPx0680j_4, fMo296toPx0680j_42, this.$tileMode));
        Shape rectangleShape = this.$edgeTreatment;
        if (rectangleShape == null) {
            rectangleShape = RectangleShapeKt.getRectangleShape();
        }
        graphicsLayer.setShape(rectangleShape);
        graphicsLayer.setClip(this.$clip);
    }
}
