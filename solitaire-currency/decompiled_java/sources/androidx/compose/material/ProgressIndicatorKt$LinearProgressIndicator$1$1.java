package androidx.compose.material;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ProgressIndicator.kt */
/* JADX INFO: loaded from: classes.dex */
final class ProgressIndicatorKt$LinearProgressIndicator$1$1 extends v implements l<DrawScope, k0> {
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ long $color;
    final /* synthetic */ float $progress;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProgressIndicatorKt$LinearProgressIndicator$1$1(long j10, float f10, long j11) {
        super(1);
        this.$backgroundColor = j10;
        this.$progress = f10;
        this.$color = j11;
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
        ProgressIndicatorKt.m1115drawLinearIndicator42QJj7c(Canvas, 0.0f, this.$progress, this.$color, fM1433getHeightimpl);
    }
}
