package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Menu.kt */
/* JADX INFO: loaded from: classes.dex */
final class MenuKt$DropdownMenuContent$1$1 extends v implements l<GraphicsLayerScope, k0> {
    final /* synthetic */ State<Float> $alpha$delegate;
    final /* synthetic */ State<Float> $scale$delegate;
    final /* synthetic */ MutableState<TransformOrigin> $transformOriginState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MenuKt$DropdownMenuContent$1$1(MutableState<TransformOrigin> mutableState, State<Float> state, State<Float> state2) {
        super(1);
        this.$transformOriginState = mutableState;
        this.$scale$delegate = state;
        this.$alpha$delegate = state2;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(GraphicsLayerScope graphicsLayerScope) {
        invoke2(graphicsLayerScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull GraphicsLayerScope graphicsLayer) {
        t.i(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setScaleX(MenuKt.m1058DropdownMenuContent$lambda1(this.$scale$delegate));
        graphicsLayer.setScaleY(MenuKt.m1058DropdownMenuContent$lambda1(this.$scale$delegate));
        graphicsLayer.setAlpha(MenuKt.m1059DropdownMenuContent$lambda3(this.$alpha$delegate));
        graphicsLayer.mo1743setTransformOrigin__ExYCQ(this.$transformOriginState.getValue().m1922unboximpl());
    }
}
