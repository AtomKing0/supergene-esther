package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composition;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VectorPainter.kt */
/* JADX INFO: loaded from: classes.dex */
final class VectorPainter$RenderVector$2 extends v implements l<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ Composition $composition;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VectorPainter$RenderVector$2(Composition composition) {
        super(1);
        this.$composition = composition;
    }

    @Override // h9.l
    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
        t.i(DisposableEffect, "$this$DisposableEffect");
        final Composition composition = this.$composition;
        return new DisposableEffectResult() { // from class: androidx.compose.ui.graphics.vector.VectorPainter$RenderVector$2$invoke$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                composition.dispose();
            }
        };
    }
}
