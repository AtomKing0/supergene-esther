package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.drawscope.b;
import androidx.compose.ui.unit.Dp;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: RadioButton.kt */
/* JADX INFO: loaded from: classes.dex */
final class RadioButtonKt$RadioButton$2$1 extends v implements l<DrawScope, k0> {
    final /* synthetic */ State<Dp> $dotRadius;
    final /* synthetic */ State<Color> $radioColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RadioButtonKt$RadioButton$2$1(State<Color> state, State<Dp> state2) {
        super(1);
        this.$radioColor = state;
        this.$dotRadius = state2;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(DrawScope drawScope) {
        invoke2(drawScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull DrawScope Canvas) {
        t.i(Canvas, "$this$Canvas");
        float fMo296toPx0680j_4 = Canvas.mo296toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
        float f10 = fMo296toPx0680j_4 / 2;
        b.x(Canvas, this.$radioColor.getValue().m1608unboximpl(), Canvas.mo296toPx0680j_4(RadioButtonKt.RadioRadius) - f10, 0L, 0.0f, new Stroke(fMo296toPx0680j_4, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
        if (Dp.m3672compareTo0680j_4(this.$dotRadius.getValue().m3687unboximpl(), Dp.m3673constructorimpl(0)) > 0) {
            b.x(Canvas, this.$radioColor.getValue().m1608unboximpl(), Canvas.mo296toPx0680j_4(this.$dotRadius.getValue().m3687unboximpl()) - f10, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
        }
    }
}
