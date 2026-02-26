package androidx.compose.material;

import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ProgressIndicator.kt */
/* JADX INFO: loaded from: classes.dex */
final class ProgressIndicatorKt$CircularProgressIndicator$1 extends v implements l<DrawScope, k0> {
    final /* synthetic */ long $color;
    final /* synthetic */ float $progress;
    final /* synthetic */ Stroke $stroke;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProgressIndicatorKt$CircularProgressIndicator$1(float f10, long j10, Stroke stroke) {
        super(1);
        this.$progress = f10;
        this.$color = j10;
        this.$stroke = stroke;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(DrawScope drawScope) {
        invoke2(drawScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull DrawScope Canvas) {
        t.i(Canvas, "$this$Canvas");
        ProgressIndicatorKt.m1113drawDeterminateCircularIndicator42QJj7c(Canvas, 270.0f, this.$progress * 360.0f, this.$color, this.$stroke);
    }
}
