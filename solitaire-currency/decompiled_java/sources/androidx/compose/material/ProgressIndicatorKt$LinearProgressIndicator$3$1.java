package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ProgressIndicator.kt */
/* JADX INFO: loaded from: classes.dex */
final class ProgressIndicatorKt$LinearProgressIndicator$3$1 extends v implements l<DrawScope, k0> {
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ long $color;
    final /* synthetic */ State<Float> $firstLineHead$delegate;
    final /* synthetic */ State<Float> $firstLineTail$delegate;
    final /* synthetic */ State<Float> $secondLineHead$delegate;
    final /* synthetic */ State<Float> $secondLineTail$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProgressIndicatorKt$LinearProgressIndicator$3$1(long j10, long j11, State<Float> state, State<Float> state2, State<Float> state3, State<Float> state4) {
        super(1);
        this.$backgroundColor = j10;
        this.$color = j11;
        this.$firstLineHead$delegate = state;
        this.$firstLineTail$delegate = state2;
        this.$secondLineHead$delegate = state3;
        this.$secondLineTail$delegate = state4;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(DrawScope drawScope) {
        invoke2(drawScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull DrawScope Canvas) {
        t.i(Canvas, "$this$Canvas");
        float fM1433getHeightimpl = Size.m1433getHeightimpl(Canvas.mo1996getSizeNHjbRc());
        ProgressIndicatorKt.m1116drawLinearIndicatorBackgroundbw27NRU(Canvas, this.$backgroundColor, fM1433getHeightimpl);
        if (ProgressIndicatorKt.m1096LinearProgressIndicator_RIQooxk$lambda1(this.$firstLineHead$delegate) - ProgressIndicatorKt.m1097LinearProgressIndicator_RIQooxk$lambda2(this.$firstLineTail$delegate) > 0.0f) {
            ProgressIndicatorKt.m1115drawLinearIndicator42QJj7c(Canvas, ProgressIndicatorKt.m1096LinearProgressIndicator_RIQooxk$lambda1(this.$firstLineHead$delegate), ProgressIndicatorKt.m1097LinearProgressIndicator_RIQooxk$lambda2(this.$firstLineTail$delegate), this.$color, fM1433getHeightimpl);
        }
        if (ProgressIndicatorKt.m1098LinearProgressIndicator_RIQooxk$lambda3(this.$secondLineHead$delegate) - ProgressIndicatorKt.m1099LinearProgressIndicator_RIQooxk$lambda4(this.$secondLineTail$delegate) > 0.0f) {
            ProgressIndicatorKt.m1115drawLinearIndicator42QJj7c(Canvas, ProgressIndicatorKt.m1098LinearProgressIndicator_RIQooxk$lambda3(this.$secondLineHead$delegate), ProgressIndicatorKt.m1099LinearProgressIndicator_RIQooxk$lambda4(this.$secondLineTail$delegate), this.$color, fM1433getHeightimpl);
        }
    }
}
