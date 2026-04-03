package androidx.compose.material;

import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.b;
import h9.a;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Drawer.kt */
/* JADX INFO: loaded from: classes.dex */
final class DrawerKt$Scrim$1$1 extends v implements l<DrawScope, k0> {
    final /* synthetic */ long $color;
    final /* synthetic */ a<Float> $fraction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DrawerKt$Scrim$1$1(long j10, a<Float> aVar) {
        super(1);
        this.$color = j10;
        this.$fraction = aVar;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(DrawScope drawScope) {
        invoke2(drawScope);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull DrawScope Canvas) {
        t.i(Canvas, "$this$Canvas");
        b.K(Canvas, this.$color, 0L, 0L, this.$fraction.invoke().floatValue(), null, null, 0, 118, null);
    }
}
