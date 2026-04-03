package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.unit.Constraints;
import h9.p;
import java.util.List;
import kotlin.jvm.internal.v;

/* JADX INFO: compiled from: LazyMeasuredLineProvider.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazyMeasuredLineProvider$childConstraints$1 extends v implements p<Integer, Integer, Constraints> {
    final /* synthetic */ int $crossAxisSpacing;
    final /* synthetic */ List<Integer> $slotSizesSums;
    final /* synthetic */ LazyMeasuredLineProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyMeasuredLineProvider$childConstraints$1(List<Integer> list, int i10, LazyMeasuredLineProvider lazyMeasuredLineProvider) {
        super(2);
        this.$slotSizesSums = list;
        this.$crossAxisSpacing = i10;
        this.this$0 = lazyMeasuredLineProvider;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Constraints mo4invoke(Integer num, Integer num2) {
        return Constraints.m3629boximpl(m590invokeJhjzzOo(num.intValue(), num2.intValue()));
    }

    /* JADX INFO: renamed from: invoke-JhjzzOo, reason: not valid java name */
    public final long m590invokeJhjzzOo(int i10, int i11) {
        int iIntValue = (this.$slotSizesSums.get((i10 + i11) - 1).intValue() - (i10 == 0 ? 0 : this.$slotSizesSums.get(i10 - 1).intValue())) + (this.$crossAxisSpacing * (i11 - 1));
        return this.this$0.isVertical ? Constraints.Companion.m3651fixedWidthOenEA2s(iIntValue) : Constraints.Companion.m3650fixedHeightOenEA2s(iIntValue);
    }
}
