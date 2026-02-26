package androidx.compose.foundation;

import androidx.compose.runtime.MutableState;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Clickable.kt */
/* JADX INFO: loaded from: classes.dex */
final class ClickableKt$clickable$4$delayPressInteraction$1 extends v implements h9.a<Boolean> {
    final /* synthetic */ MutableState<Boolean> $isClickableInScrollableContainer;
    final /* synthetic */ h9.a<Boolean> $isRootInScrollableContainer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ClickableKt$clickable$4$delayPressInteraction$1(MutableState<Boolean> mutableState, h9.a<Boolean> aVar) {
        super(0);
        this.$isClickableInScrollableContainer = mutableState;
        this.$isRootInScrollableContainer = aVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final Boolean invoke() {
        return Boolean.valueOf(this.$isClickableInScrollableContainer.getValue().booleanValue() || this.$isRootInScrollableContainer.invoke().booleanValue());
    }
}
