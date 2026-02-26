package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Clickable.kt */
/* JADX INFO: loaded from: classes.dex */
final class ClickableKt$PressedInteractionSourceDisposableEffect$1$1 extends v implements h9.l<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ClickableKt$PressedInteractionSourceDisposableEffect$1$1(MutableState<PressInteraction.Press> mutableState, MutableInteractionSource mutableInteractionSource) {
        super(1);
        this.$pressedInteraction = mutableState;
        this.$interactionSource = mutableInteractionSource;
    }

    @Override // h9.l
    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
        t.i(DisposableEffect, "$this$DisposableEffect");
        final MutableState<PressInteraction.Press> mutableState = this.$pressedInteraction;
        final MutableInteractionSource mutableInteractionSource = this.$interactionSource;
        return new DisposableEffectResult() { // from class: androidx.compose.foundation.ClickableKt$PressedInteractionSourceDisposableEffect$1$1$invoke$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                PressInteraction.Press press = (PressInteraction.Press) mutableState.getValue();
                if (press != null) {
                    mutableInteractionSource.tryEmit(new PressInteraction.Cancel(press));
                    mutableState.setValue(null);
                }
            }
        };
    }
}
