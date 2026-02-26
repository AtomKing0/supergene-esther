package androidx.compose.foundation.lazy.grid;

import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazySemantics.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazySemanticsKt$lazyGridSemantics$1$accessibilityScrollState$1 extends v implements h9.a<Float> {
    final /* synthetic */ LazyGridState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazySemanticsKt$lazyGridSemantics$1$accessibilityScrollState$1(LazyGridState lazyGridState) {
        super(0);
        this.$state = lazyGridState;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final Float invoke() {
        return Float.valueOf(this.$state.getFirstVisibleItemIndex() + (this.$state.getFirstVisibleItemScrollOffset() / 100000.0f));
    }
}
