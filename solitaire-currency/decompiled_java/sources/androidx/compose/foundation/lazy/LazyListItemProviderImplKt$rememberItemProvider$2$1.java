package androidx.compose.foundation.lazy;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import h9.l;
import kotlin.jvm.internal.v;
import n9.i;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: LazyListItemProviderImpl.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazyListItemProviderImplKt$rememberItemProvider$2$1 extends v implements h9.a<LazyListItemsSnapshot> {
    final /* synthetic */ State<l<LazyListScope, k0>> $latestContent;
    final /* synthetic */ MutableState<i> $nearestItemsRangeState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    LazyListItemProviderImplKt$rememberItemProvider$2$1(State<? extends l<? super LazyListScope, k0>> state, MutableState<i> mutableState) {
        super(0);
        this.$latestContent = state;
        this.$nearestItemsRangeState = mutableState;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final LazyListItemsSnapshot invoke() {
        LazyListScopeImpl lazyListScopeImpl = new LazyListScopeImpl();
        this.$latestContent.getValue().invoke(lazyListScopeImpl);
        return new LazyListItemsSnapshot(lazyListScopeImpl.getIntervals(), lazyListScopeImpl.getHeaderIndexes(), this.$nearestItemsRangeState.getValue());
    }
}
