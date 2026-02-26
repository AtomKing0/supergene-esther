package androidx.compose.ui.focus;

import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FocusManager.kt */
/* JADX INFO: loaded from: classes.dex */
final class FocusManagerImpl$moveFocus$1 extends v implements l<FocusModifier, Boolean> {
    final /* synthetic */ FocusModifier $source;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FocusManagerImpl$moveFocus$1(FocusModifier focusModifier) {
        super(1);
        this.$source = focusModifier;
    }

    @Override // h9.l
    @NotNull
    public final Boolean invoke(@NotNull FocusModifier destination) {
        t.i(destination, "destination");
        if (t.d(destination, this.$source)) {
            return Boolean.FALSE;
        }
        if (destination.getParent() == null) {
            throw new IllegalStateException("Move focus landed at the root.".toString());
        }
        FocusTransactionsKt.requestFocus(destination);
        return Boolean.TRUE;
    }
}
