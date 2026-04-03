package androidx.compose.ui.platform;

import androidx.compose.ui.input.InputMode;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidComposeView.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidComposeView$_inputModeManager$1 extends kotlin.jvm.internal.v implements h9.l<InputMode, Boolean> {
    final /* synthetic */ AndroidComposeView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidComposeView$_inputModeManager$1(AndroidComposeView androidComposeView) {
        super(1);
        this.this$0 = androidComposeView;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Boolean invoke(InputMode inputMode) {
        return m3158invokeiuPiT84(inputMode.m2156unboximpl());
    }

    @NotNull
    /* JADX INFO: renamed from: invoke-iuPiT84, reason: not valid java name */
    public final Boolean m3158invokeiuPiT84(int i10) {
        InputMode.Companion companion = InputMode.Companion;
        return Boolean.valueOf(InputMode.m2153equalsimpl0(i10, companion.m2158getTouchaOaMEAU()) ? this.this$0.isInTouchMode() : InputMode.m2153equalsimpl0(i10, companion.m2157getKeyboardaOaMEAU()) ? this.this$0.isInTouchMode() ? this.this$0.requestFocusFromTouch() : true : false);
    }
}
