package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Switch.kt */
/* JADX INFO: loaded from: classes.dex */
final class SwitchKt$SwitchImpl$2$1 extends v implements l<DrawScope, k0> {
    final /* synthetic */ State<Color> $trackColor$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SwitchKt$SwitchImpl$2$1(State<Color> state) {
        super(1);
        this.$trackColor$delegate = state;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(DrawScope drawScope) {
        invoke2(drawScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull DrawScope Canvas) {
        t.i(Canvas, "$this$Canvas");
        SwitchKt.m1164drawTrackRPmYEkk(Canvas, SwitchKt.m1160SwitchImpl$lambda5(this.$trackColor$delegate), Canvas.mo296toPx0680j_4(SwitchKt.getTrackWidth()), Canvas.mo296toPx0680j_4(SwitchKt.getTrackStrokeWidth()));
    }
}
