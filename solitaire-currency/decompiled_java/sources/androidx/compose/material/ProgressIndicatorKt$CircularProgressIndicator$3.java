package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ProgressIndicator.kt */
/* JADX INFO: loaded from: classes.dex */
final class ProgressIndicatorKt$CircularProgressIndicator$3 extends v implements l<DrawScope, k0> {
    final /* synthetic */ State<Float> $baseRotation$delegate;
    final /* synthetic */ long $color;
    final /* synthetic */ State<Integer> $currentRotation$delegate;
    final /* synthetic */ State<Float> $endAngle$delegate;
    final /* synthetic */ State<Float> $startAngle$delegate;
    final /* synthetic */ Stroke $stroke;
    final /* synthetic */ float $strokeWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProgressIndicatorKt$CircularProgressIndicator$3(float f10, long j10, Stroke stroke, State<Integer> state, State<Float> state2, State<Float> state3, State<Float> state4) {
        super(1);
        this.$strokeWidth = f10;
        this.$color = j10;
        this.$stroke = stroke;
        this.$currentRotation$delegate = state;
        this.$endAngle$delegate = state2;
        this.$startAngle$delegate = state3;
        this.$baseRotation$delegate = state4;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(DrawScope drawScope) {
        invoke2(drawScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull DrawScope Canvas) {
        t.i(Canvas, "$this$Canvas");
        ProgressIndicatorKt.m1114drawIndeterminateCircularIndicatorhrjfTZI(Canvas, ProgressIndicatorKt.m1091CircularProgressIndicator_aM_cp0Q$lambda11(this.$startAngle$delegate) + (((ProgressIndicatorKt.m1092CircularProgressIndicator_aM_cp0Q$lambda8(this.$currentRotation$delegate) * 216.0f) % 360.0f) - 90.0f) + ProgressIndicatorKt.m1093CircularProgressIndicator_aM_cp0Q$lambda9(this.$baseRotation$delegate), this.$strokeWidth, Math.abs(ProgressIndicatorKt.m1090CircularProgressIndicator_aM_cp0Q$lambda10(this.$endAngle$delegate) - ProgressIndicatorKt.m1091CircularProgressIndicator_aM_cp0Q$lambda11(this.$startAngle$delegate)), this.$color, this.$stroke);
    }
}
