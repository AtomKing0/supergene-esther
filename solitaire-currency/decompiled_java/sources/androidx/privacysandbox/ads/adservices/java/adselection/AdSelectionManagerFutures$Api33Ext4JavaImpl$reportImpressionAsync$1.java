package androidx.privacysandbox.ads.adservices.java.adselection;

import androidx.privacysandbox.ads.adservices.adselection.AdSelectionManager;
import androidx.privacysandbox.ads.adservices.adselection.ReportImpressionRequest;
import androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: AdSelectionManagerFutures.kt */
/* JADX INFO: loaded from: classes2.dex */
@f(c = "androidx.privacysandbox.ads.adservices.java.adselection.AdSelectionManagerFutures$Api33Ext4JavaImpl$reportImpressionAsync$1", f = "AdSelectionManagerFutures.kt", l = {104}, m = "invokeSuspend")
final class AdSelectionManagerFutures$Api33Ext4JavaImpl$reportImpressionAsync$1 extends l implements p<o0, d<? super k0>, Object> {
    final /* synthetic */ ReportImpressionRequest $reportImpressionRequest;
    int label;
    final /* synthetic */ AdSelectionManagerFutures.Api33Ext4JavaImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdSelectionManagerFutures$Api33Ext4JavaImpl$reportImpressionAsync$1(AdSelectionManagerFutures.Api33Ext4JavaImpl api33Ext4JavaImpl, ReportImpressionRequest reportImpressionRequest, d<? super AdSelectionManagerFutures$Api33Ext4JavaImpl$reportImpressionAsync$1> dVar) {
        super(2, dVar);
        this.this$0 = api33Ext4JavaImpl;
        this.$reportImpressionRequest = reportImpressionRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
        return new AdSelectionManagerFutures$Api33Ext4JavaImpl$reportImpressionAsync$1(this.this$0, this.$reportImpressionRequest, dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            AdSelectionManager adSelectionManager = this.this$0.mAdSelectionManager;
            t.f(adSelectionManager);
            ReportImpressionRequest reportImpressionRequest = this.$reportImpressionRequest;
            this.label = 1;
            if (adSelectionManager.reportImpression(reportImpressionRequest, this) == objE) {
                return objE;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
        }
        return k0.f35197a;
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
        return ((AdSelectionManagerFutures$Api33Ext4JavaImpl$reportImpressionAsync$1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
