package androidx.activity.compose;

import androidx.activity.FullyDrawnReporter;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import h9.l;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ReportDrawn.kt */
/* JADX INFO: loaded from: classes.dex */
final class ReportDrawnComposition implements h9.a<k0> {

    @NotNull
    private final l<h9.a<Boolean>, k0> checkReporter;

    @NotNull
    private final FullyDrawnReporter fullyDrawnReporter;

    @NotNull
    private final h9.a<Boolean> predicate;

    @NotNull
    private final SnapshotStateObserver snapshotStateObserver;

    /* JADX INFO: renamed from: androidx.activity.compose.ReportDrawnComposition$observeReporter$1, reason: invalid class name */
    /* JADX INFO: compiled from: ReportDrawn.kt */
    static final class AnonymousClass1 extends v implements h9.a<k0> {
        final /* synthetic */ h9.a<Boolean> $predicate;
        final /* synthetic */ i0 $reporterPassed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(i0 i0Var, h9.a<Boolean> aVar) {
            super(0);
            this.$reporterPassed = i0Var;
            this.$predicate = aVar;
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            invoke2();
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$reporterPassed.f29826a = this.$predicate.invoke().booleanValue();
        }
    }

    public ReportDrawnComposition(@NotNull FullyDrawnReporter fullyDrawnReporter, @NotNull h9.a<Boolean> aVar) {
        this.fullyDrawnReporter = fullyDrawnReporter;
        this.predicate = aVar;
        SnapshotStateObserver snapshotStateObserver = new SnapshotStateObserver(ReportDrawnComposition$snapshotStateObserver$1.INSTANCE);
        snapshotStateObserver.start();
        this.snapshotStateObserver = snapshotStateObserver;
        this.checkReporter = new ReportDrawnComposition$checkReporter$1(this);
        fullyDrawnReporter.addOnReportDrawnListener(this);
        if (fullyDrawnReporter.isFullyDrawnReported()) {
            return;
        }
        fullyDrawnReporter.addReporter();
        observeReporter(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void observeReporter(h9.a<Boolean> aVar) {
        i0 i0Var = new i0();
        this.snapshotStateObserver.observeReads(aVar, this.checkReporter, new AnonymousClass1(i0Var, aVar));
        if (i0Var.f29826a) {
            removeReporter();
        }
    }

    @Override // h9.a
    public /* bridge */ /* synthetic */ k0 invoke() {
        invoke2();
        return k0.f35197a;
    }

    public final void removeReporter() {
        this.snapshotStateObserver.clear(this.predicate);
        if (!this.fullyDrawnReporter.isFullyDrawnReported()) {
            this.fullyDrawnReporter.removeReporter();
        }
        invoke2();
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2() {
        this.snapshotStateObserver.clear();
        this.snapshotStateObserver.stop();
    }
}
