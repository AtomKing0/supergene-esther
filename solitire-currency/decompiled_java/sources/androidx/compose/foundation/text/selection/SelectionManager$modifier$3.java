package androidx.compose.foundation.text.selection;

import androidx.compose.ui.focus.FocusState;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: SelectionManager.kt */
/* JADX INFO: loaded from: classes.dex */
final class SelectionManager$modifier$3 extends v implements l<FocusState, k0> {
    final /* synthetic */ SelectionManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SelectionManager$modifier$3(SelectionManager selectionManager) {
        super(1);
        this.this$0 = selectionManager;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(FocusState focusState) {
        invoke2(focusState);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull FocusState focusState) {
        t.i(focusState, "focusState");
        if (!focusState.isFocused() && this.this$0.getHasFocus()) {
            this.this$0.onRelease();
        }
        this.this$0.setHasFocus(focusState.isFocused());
    }
}
