package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Shadow.kt */
/* JADX INFO: loaded from: classes.dex */
final class ShadowKt$shadow$2$1 extends v implements l<GraphicsLayerScope, k0> {
    final /* synthetic */ long $ambientColor;
    final /* synthetic */ boolean $clip;
    final /* synthetic */ float $elevation;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ long $spotColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ShadowKt$shadow$2$1(float f10, Shape shape, boolean z10, long j10, long j11) {
        super(1);
        this.$elevation = f10;
        this.$shape = shape;
        this.$clip = z10;
        this.$ambientColor = j10;
        this.$spotColor = j11;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(GraphicsLayerScope graphicsLayerScope) {
        invoke2(graphicsLayerScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull GraphicsLayerScope graphicsLayer) {
        t.i(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setShadowElevation(graphicsLayer.mo296toPx0680j_4(this.$elevation));
        graphicsLayer.setShape(this.$shape);
        graphicsLayer.setClip(this.$clip);
        graphicsLayer.mo1741setAmbientShadowColor8_81llA(this.$ambientColor);
        graphicsLayer.mo1742setSpotShadowColor8_81llA(this.$spotColor);
    }
}
