package androidx.activity.compose;

import h9.l;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ReportDrawn.kt */
/* JADX INFO: loaded from: classes.dex */
/* synthetic */ class ReportDrawnComposition$checkReporter$1 extends q implements l<h9.a<? extends Boolean>, k0> {
    ReportDrawnComposition$checkReporter$1(Object obj) {
        super(1, obj, ReportDrawnComposition.class, "observeReporter", "observeReporter(Lkotlin/jvm/functions/Function0;)V", 0);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(h9.a<? extends Boolean> aVar) {
        invoke2((h9.a<Boolean>) aVar);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull h9.a<Boolean> aVar) {
        ((ReportDrawnComposition) this.receiver).observeReporter(aVar);
    }
}
