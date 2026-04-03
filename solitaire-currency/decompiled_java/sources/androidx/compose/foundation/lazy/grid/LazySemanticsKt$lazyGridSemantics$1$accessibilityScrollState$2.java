package androidx.compose.foundation.lazy.grid;

import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazySemantics.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazySemanticsKt$lazyGridSemantics$1$accessibilityScrollState$2 extends v implements h9.a<Float> {
    final /* synthetic */ LazyGridItemProvider $itemProvider;
    final /* synthetic */ LazyGridState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazySemanticsKt$lazyGridSemantics$1$accessibilityScrollState$2(LazyGridState lazyGridState, LazyGridItemProvider lazyGridItemProvider) {
        super(0);
        this.$state = lazyGridState;
        this.$itemProvider = lazyGridItemProvider;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final Float invoke() {
        float firstVisibleItemIndex;
        float firstVisibleItemScrollOffset;
        if (this.$state.getCanScrollForward$foundation_release()) {
            firstVisibleItemIndex = this.$itemProvider.getItemCount();
            firstVisibleItemScrollOffset = 1.0f;
        } else {
            firstVisibleItemIndex = this.$state.getFirstVisibleItemIndex();
            firstVisibleItemScrollOffset = this.$state.getFirstVisibleItemScrollOffset() / 100000.0f;
        }
        return Float.valueOf(firstVisibleItemIndex + firstVisibleItemScrollOffset);
    }
}
