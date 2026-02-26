package androidx.compose.ui.layout;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.State;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SubcomposeLayout.kt */
/* JADX INFO: loaded from: classes.dex */
final class SubcomposeLayoutKt$SubcomposeLayout$5$1 extends v implements h9.l<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ State<SubcomposeLayoutState> $stateHolder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubcomposeLayoutKt$SubcomposeLayout$5$1(State<SubcomposeLayoutState> state) {
        super(1);
        this.$stateHolder = state;
    }

    @Override // h9.l
    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
        t.i(DisposableEffect, "$this$DisposableEffect");
        final State<SubcomposeLayoutState> state = this.$stateHolder;
        return new DisposableEffectResult() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$5$1$invoke$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                ((SubcomposeLayoutState) state.getValue()).disposeCurrentNodes$ui_release();
            }
        };
    }
}
