package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Checkbox.kt */
/* JADX INFO: loaded from: classes.dex */
final class CheckboxKt$CheckboxImpl$1$1 extends v implements l<DrawScope, k0> {
    final /* synthetic */ State<Color> $borderColor$delegate;
    final /* synthetic */ State<Color> $boxColor$delegate;
    final /* synthetic */ CheckDrawingCache $checkCache;
    final /* synthetic */ State<Float> $checkCenterGravitationShiftFraction$delegate;
    final /* synthetic */ State<Color> $checkColor$delegate;
    final /* synthetic */ State<Float> $checkDrawFraction$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CheckboxKt$CheckboxImpl$1$1(CheckDrawingCache checkDrawingCache, State<Color> state, State<Color> state2, State<Color> state3, State<Float> state4, State<Float> state5) {
        super(1);
        this.$checkCache = checkDrawingCache;
        this.$boxColor$delegate = state;
        this.$borderColor$delegate = state2;
        this.$checkColor$delegate = state3;
        this.$checkDrawFraction$delegate = state4;
        this.$checkCenterGravitationShiftFraction$delegate = state5;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(DrawScope drawScope) {
        invoke2(drawScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull DrawScope Canvas) {
        t.i(Canvas, "$this$Canvas");
        float fFloor = (float) Math.floor(Canvas.mo296toPx0680j_4(CheckboxKt.StrokeWidth));
        CheckboxKt.m929drawBox1wkBAMs(Canvas, CheckboxKt.m921CheckboxImpl$lambda9(this.$boxColor$delegate), CheckboxKt.m917CheckboxImpl$lambda10(this.$borderColor$delegate), Canvas.mo296toPx0680j_4(CheckboxKt.RadiusSize), fFloor);
        CheckboxKt.m930drawCheck3IgeMak(Canvas, CheckboxKt.m920CheckboxImpl$lambda8(this.$checkColor$delegate), CheckboxKt.m918CheckboxImpl$lambda4(this.$checkDrawFraction$delegate), CheckboxKt.m919CheckboxImpl$lambda6(this.$checkCenterGravitationShiftFraction$delegate), fFloor, this.$checkCache);
    }
}
