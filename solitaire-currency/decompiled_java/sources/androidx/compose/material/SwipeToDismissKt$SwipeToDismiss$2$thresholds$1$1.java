package androidx.compose.material;

import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SwipeToDismiss.kt */
/* JADX INFO: loaded from: classes.dex */
final class SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1 extends v implements p<DismissValue, DismissValue, ThresholdConfig> {
    final /* synthetic */ l<DismissDirection, ThresholdConfig> $dismissThresholds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1(l<? super DismissDirection, ? extends ThresholdConfig> lVar) {
        super(2);
        this.$dismissThresholds = lVar;
    }

    @Override // h9.p
    @NotNull
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final ThresholdConfig mo4invoke(@NotNull DismissValue from, @NotNull DismissValue to) {
        t.i(from, "from");
        t.i(to, "to");
        l<DismissDirection, ThresholdConfig> lVar = this.$dismissThresholds;
        DismissDirection dismissDirection = SwipeToDismissKt.getDismissDirection(from, to);
        t.f(dismissDirection);
        return lVar.invoke(dismissDirection);
    }
}
