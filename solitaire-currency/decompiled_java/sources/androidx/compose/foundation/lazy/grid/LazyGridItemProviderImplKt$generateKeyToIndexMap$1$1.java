package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.IntervalList;
import h9.l;
import java.util.HashMap;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: LazyGridItemProviderImpl.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazyGridItemProviderImplKt$generateKeyToIndexMap$1$1 extends v implements l<IntervalList.Interval<LazyGridIntervalContent>, k0> {
    final /* synthetic */ int $first;
    final /* synthetic */ int $last;
    final /* synthetic */ HashMap<Object, Integer> $map;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyGridItemProviderImplKt$generateKeyToIndexMap$1$1(int i10, int i11, HashMap<Object, Integer> map) {
        super(1);
        this.$first = i10;
        this.$last = i11;
        this.$map = map;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(IntervalList.Interval<LazyGridIntervalContent> interval) {
        invoke2(interval);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull IntervalList.Interval<LazyGridIntervalContent> it) {
        t.i(it, "it");
        if (it.getValue().getKey() == null) {
            return;
        }
        l<Integer, Object> key = it.getValue().getKey();
        if (key == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        int iMax = Math.max(this.$first, it.getStartIndex());
        int iMin = Math.min(this.$last, (it.getStartIndex() + it.getSize()) - 1);
        if (iMax > iMin) {
            return;
        }
        while (true) {
            this.$map.put(key.invoke(Integer.valueOf(iMax - it.getStartIndex())), Integer.valueOf(iMax));
            if (iMax == iMin) {
                return;
            } else {
                iMax++;
            }
        }
    }
}
