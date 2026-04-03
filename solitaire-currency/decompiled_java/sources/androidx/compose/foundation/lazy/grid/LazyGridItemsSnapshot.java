package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.Lazy_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import h9.l;
import h9.p;
import java.util.Map;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import n9.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: LazyGridItemProviderImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalFoundationApi
public final class LazyGridItemsSnapshot {
    private final boolean hasCustomSpans;

    @NotNull
    private final IntervalList<LazyGridIntervalContent> intervals;

    @NotNull
    private final Map<Object, Integer> keyToIndexMap;

    @NotNull
    private final LazyGridSpanLayoutProvider spanLayoutProvider;

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridItemsSnapshot$Item$1, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridItemProviderImpl.kt */
    static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $index;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i10, int i11) {
            super(2);
            this.$index = i10;
            this.$$changed = i11;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            LazyGridItemsSnapshot.this.Item(this.$index, composer, this.$$changed | 1);
        }
    }

    public LazyGridItemsSnapshot(@NotNull IntervalList<LazyGridIntervalContent> intervals, boolean z10, @NotNull i nearestItemsRange) {
        t.i(intervals, "intervals");
        t.i(nearestItemsRange, "nearestItemsRange");
        this.intervals = intervals;
        this.hasCustomSpans = z10;
        this.spanLayoutProvider = new LazyGridSpanLayoutProvider(this);
        this.keyToIndexMap = LazyGridItemProviderImplKt.generateKeyToIndexMap(nearestItemsRange, intervals);
    }

    @Composable
    public final void Item(int i10, @Nullable Composer composer, int i11) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-405085610);
        IntervalList.Interval<LazyGridIntervalContent> interval = this.intervals.get(i10);
        interval.getValue().getItem().invoke(LazyGridItemScopeImpl.INSTANCE, Integer.valueOf(i10 - interval.getStartIndex()), composerStartRestartGroup, 6);
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(i10, i11));
    }

    @Nullable
    public final Object getContentType(int i10) {
        IntervalList.Interval<LazyGridIntervalContent> interval = this.intervals.get(i10);
        return interval.getValue().getType().invoke(Integer.valueOf(i10 - interval.getStartIndex()));
    }

    public final boolean getHasCustomSpans() {
        return this.hasCustomSpans;
    }

    public final int getItemsCount() {
        return this.intervals.getSize();
    }

    @NotNull
    public final Object getKey(int i10) {
        IntervalList.Interval<LazyGridIntervalContent> interval = this.intervals.get(i10);
        int startIndex = i10 - interval.getStartIndex();
        l<Integer, Object> key = interval.getValue().getKey();
        Object objInvoke = key != null ? key.invoke(Integer.valueOf(startIndex)) : null;
        return objInvoke == null ? Lazy_androidKt.getDefaultLazyLayoutKey(i10) : objInvoke;
    }

    @NotNull
    public final Map<Object, Integer> getKeyToIndexMap() {
        return this.keyToIndexMap;
    }

    /* JADX INFO: renamed from: getSpan-_-orMbw, reason: not valid java name */
    public final long m566getSpan_orMbw(@NotNull LazyGridItemSpanScope getSpan, int i10) {
        t.i(getSpan, "$this$getSpan");
        IntervalList.Interval<LazyGridIntervalContent> interval = this.intervals.get(i10);
        return interval.getValue().getSpan().mo4invoke(getSpan, Integer.valueOf(i10 - interval.getStartIndex())).m538unboximpl();
    }

    @NotNull
    public final LazyGridSpanLayoutProvider getSpanLayoutProvider() {
        return this.spanLayoutProvider;
    }
}
