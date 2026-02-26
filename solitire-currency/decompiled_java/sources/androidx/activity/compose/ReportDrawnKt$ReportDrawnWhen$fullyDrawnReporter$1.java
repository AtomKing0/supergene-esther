package androidx.activity.compose;

import androidx.compose.runtime.Composer;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ReportDrawn.kt */
/* JADX INFO: loaded from: classes.dex */
final class ReportDrawnKt$ReportDrawnWhen$fullyDrawnReporter$1 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ h9.a<Boolean> $predicate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ReportDrawnKt$ReportDrawnWhen$fullyDrawnReporter$1(h9.a<Boolean> aVar, int i10) {
        super(2);
        this.$predicate = aVar;
        this.$$changed = i10;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    public final void invoke(@Nullable Composer composer, int i10) {
        ReportDrawnKt.ReportDrawnWhen(this.$predicate, composer, this.$$changed | 1);
    }
}
