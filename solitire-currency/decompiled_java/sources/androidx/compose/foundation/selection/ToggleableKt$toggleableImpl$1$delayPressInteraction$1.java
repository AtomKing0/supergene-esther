package androidx.compose.foundation.selection;

import androidx.compose.runtime.MutableState;
import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Toggleable.kt */
/* JADX INFO: loaded from: classes.dex */
final class ToggleableKt$toggleableImpl$1$delayPressInteraction$1 extends v implements a<Boolean> {
    final /* synthetic */ a<Boolean> $isRootInScrollableContainer;
    final /* synthetic */ MutableState<Boolean> $isToggleableInScrollableContainer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ToggleableKt$toggleableImpl$1$delayPressInteraction$1(MutableState<Boolean> mutableState, a<Boolean> aVar) {
        super(0);
        this.$isToggleableInScrollableContainer = mutableState;
        this.$isRootInScrollableContainer = aVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final Boolean invoke() {
        return Boolean.valueOf(this.$isToggleableInScrollableContainer.getValue().booleanValue() || this.$isRootInScrollableContainer.invoke().booleanValue());
    }
}
