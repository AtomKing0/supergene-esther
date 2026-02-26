package androidx.compose.ui.platform;

import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidComposeView.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidComposeView$keyInputModifier$1 extends kotlin.jvm.internal.v implements h9.l<KeyEvent, Boolean> {
    final /* synthetic */ AndroidComposeView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidComposeView$keyInputModifier$1(AndroidComposeView androidComposeView) {
        super(1);
        this.this$0 = androidComposeView;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
        return m3159invokeZmokQxo(keyEvent.m2749unboximpl());
    }

    @NotNull
    /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
    public final Boolean m3159invokeZmokQxo(@NotNull android.view.KeyEvent it) {
        kotlin.jvm.internal.t.i(it, "it");
        FocusDirection focusDirectionMo3149getFocusDirectionP8AzH3I = this.this$0.mo3149getFocusDirectionP8AzH3I(it);
        return (focusDirectionMo3149getFocusDirectionP8AzH3I == null || !KeyEventType.m2753equalsimpl0(KeyEvent_androidKt.m2761getTypeZmokQxo(it), KeyEventType.Companion.m2757getKeyDownCS__XNY())) ? Boolean.FALSE : Boolean.valueOf(this.this$0.getFocusManager().mo1317moveFocus3ESFkO8(focusDirectionMo3149getFocusDirectionP8AzH3I.m1306unboximpl()));
    }
}
