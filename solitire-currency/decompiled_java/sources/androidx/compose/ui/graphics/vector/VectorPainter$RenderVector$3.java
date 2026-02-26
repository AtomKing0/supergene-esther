package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composer;
import h9.p;
import h9.r;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: VectorPainter.kt */
/* JADX INFO: loaded from: classes.dex */
final class VectorPainter$RenderVector$3 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ r<Float, Float, Composer, Integer, k0> $content;
    final /* synthetic */ String $name;
    final /* synthetic */ VectorPainter $tmp0_rcvr;
    final /* synthetic */ float $viewportHeight;
    final /* synthetic */ float $viewportWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    VectorPainter$RenderVector$3(VectorPainter vectorPainter, String str, float f10, float f11, r<? super Float, ? super Float, ? super Composer, ? super Integer, k0> rVar, int i10) {
        super(2);
        this.$tmp0_rcvr = vectorPainter;
        this.$name = str;
        this.$viewportWidth = f10;
        this.$viewportHeight = f11;
        this.$content = rVar;
        this.$$changed = i10;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    public final void invoke(@Nullable Composer composer, int i10) {
        this.$tmp0_rcvr.RenderVector$ui_release(this.$name, this.$viewportWidth, this.$viewportHeight, this.$content, composer, this.$$changed | 1);
    }
}
