package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.State;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazyLayout.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazyLayoutKt$LazyLayout$itemContentFactory$1$1 extends v implements h9.a<LazyLayoutItemProvider> {
    final /* synthetic */ State<LazyLayoutItemProvider> $currentItemProvider;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    LazyLayoutKt$LazyLayout$itemContentFactory$1$1(State<? extends LazyLayoutItemProvider> state) {
        super(0);
        this.$currentItemProvider = state;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final LazyLayoutItemProvider invoke() {
        return this.$currentItemProvider.getValue();
    }
}
