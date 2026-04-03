package androidx.compose.foundation.lazy.grid;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import h9.l;
import kotlin.jvm.internal.v;
import n9.i;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: LazyGridItemProviderImpl.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazyGridItemProviderImplKt$rememberItemProvider$2$1 extends v implements h9.a<LazyGridItemsSnapshot> {
    final /* synthetic */ State<l<LazyGridScope, k0>> $latestContent;
    final /* synthetic */ MutableState<i> $nearestItemsRangeState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    LazyGridItemProviderImplKt$rememberItemProvider$2$1(State<? extends l<? super LazyGridScope, k0>> state, MutableState<i> mutableState) {
        super(0);
        this.$latestContent = state;
        this.$nearestItemsRangeState = mutableState;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final LazyGridItemsSnapshot invoke() {
        LazyGridScopeImpl lazyGridScopeImpl = new LazyGridScopeImpl();
        this.$latestContent.getValue().invoke(lazyGridScopeImpl);
        return new LazyGridItemsSnapshot(lazyGridScopeImpl.getIntervals$foundation_release(), lazyGridScopeImpl.getHasCustomSpans$foundation_release(), this.$nearestItemsRangeState.getValue());
    }
}
