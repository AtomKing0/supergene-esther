package androidx.compose.animation;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Crossfade.kt */
/* JADX INFO: loaded from: classes.dex */
final class CrossfadeKt$Crossfade$4$1$1$1 extends v implements l<GraphicsLayerScope, k0> {
    final /* synthetic */ State<Float> $alpha$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CrossfadeKt$Crossfade$4$1$1$1(State<Float> state) {
        super(1);
        this.$alpha$delegate = state;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(GraphicsLayerScope graphicsLayerScope) {
        invoke2(graphicsLayerScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull GraphicsLayerScope graphicsLayer) {
        t.i(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setAlpha(CrossfadeKt$Crossfade$4$1.m42invoke$lambda1(this.$alpha$delegate));
    }
}
