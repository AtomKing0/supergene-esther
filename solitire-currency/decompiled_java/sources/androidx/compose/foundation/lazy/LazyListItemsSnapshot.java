package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.Lazy_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import h9.l;
import h9.p;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import n9.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: LazyListItemProviderImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalFoundationApi
public final class LazyListItemsSnapshot {

    @NotNull
    private final List<Integer> headerIndexes;

    @NotNull
    private final IntervalList<LazyListIntervalContent> intervals;

    @NotNull
    private final Map<Object, Integer> keyToIndexMap;

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListItemsSnapshot$Item$1, reason: invalid class name */
    /* JADX INFO: compiled from: LazyListItemProviderImpl.kt */
    static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $index;
        final /* synthetic */ LazyItemScope $scope;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LazyItemScope lazyItemScope, int i10, int i11) {
            super(2);
            this.$scope = lazyItemScope;
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
            LazyListItemsSnapshot.this.Item(this.$scope, this.$index, composer, this.$$changed | 1);
        }
    }

    public LazyListItemsSnapshot(@NotNull IntervalList<LazyListIntervalContent> intervals, @NotNull List<Integer> headerIndexes, @NotNull i nearestItemsRange) {
        t.i(intervals, "intervals");
        t.i(headerIndexes, "headerIndexes");
        t.i(nearestItemsRange, "nearestItemsRange");
        this.intervals = intervals;
        this.headerIndexes = headerIndexes;
        this.keyToIndexMap = LazyListItemProviderImplKt.generateKeyToIndexMap(nearestItemsRange, intervals);
    }

    @Composable
    public final void Item(@NotNull LazyItemScope scope, int i10, @Nullable Composer composer, int i11) {
        t.i(scope, "scope");
        Composer composerStartRestartGroup = composer.startRestartGroup(1922528915);
        IntervalList.Interval<LazyListIntervalContent> interval = this.intervals.get(i10);
        interval.getValue().getItem().invoke(scope, Integer.valueOf(i10 - interval.getStartIndex()), composerStartRestartGroup, Integer.valueOf(i11 & 14));
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(scope, i10, i11));
    }

    @Nullable
    public final Object getContentType(int i10) {
        IntervalList.Interval<LazyListIntervalContent> interval = this.intervals.get(i10);
        return interval.getValue().getType().invoke(Integer.valueOf(i10 - interval.getStartIndex()));
    }

    @NotNull
    public final List<Integer> getHeaderIndexes() {
        return this.headerIndexes;
    }

    public final int getItemsCount() {
        return this.intervals.getSize();
    }

    @NotNull
    public final Object getKey(int i10) {
        IntervalList.Interval<LazyListIntervalContent> interval = this.intervals.get(i10);
        int startIndex = i10 - interval.getStartIndex();
        l<Integer, Object> key = interval.getValue().getKey();
        Object objInvoke = key != null ? key.invoke(Integer.valueOf(startIndex)) : null;
        return objInvoke == null ? Lazy_androidKt.getDefaultLazyLayoutKey(i10) : objInvoke;
    }

    @NotNull
    public final Map<Object, Integer> getKeyToIndexMap() {
        return this.keyToIndexMap;
    }
}
