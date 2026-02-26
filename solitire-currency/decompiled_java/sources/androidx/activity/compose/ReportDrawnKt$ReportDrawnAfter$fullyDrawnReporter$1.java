package androidx.activity.compose;

import androidx.compose.runtime.Composer;
import h9.l;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: ReportDrawn.kt */
/* JADX INFO: loaded from: classes.dex */
final class ReportDrawnKt$ReportDrawnAfter$fullyDrawnReporter$1 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ l<d<? super k0>, Object> $block;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ReportDrawnKt$ReportDrawnAfter$fullyDrawnReporter$1(l<? super d<? super k0>, ? extends Object> lVar, int i10) {
        super(2);
        this.$block = lVar;
        this.$$changed = i10;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    public final void invoke(@Nullable Composer composer, int i10) {
        ReportDrawnKt.ReportDrawnAfter(this.$block, composer, this.$$changed | 1);
    }
}
