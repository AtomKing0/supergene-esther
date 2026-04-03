package androidx.compose.foundation.lazy;

import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazySemantics.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazySemanticsKt$lazyListSemantics$1$accessibilityScrollState$1 extends v implements h9.a<Float> {
    final /* synthetic */ LazyListState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazySemanticsKt$lazyListSemantics$1$accessibilityScrollState$1(LazyListState lazyListState) {
        super(0);
        this.$state = lazyListState;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final Float invoke() {
        return Float.valueOf(this.$state.getFirstVisibleItemIndex() + (this.$state.getFirstVisibleItemScrollOffset() / 100000.0f));
    }
}
