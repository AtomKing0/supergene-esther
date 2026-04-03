package androidx.compose.ui.platform;

import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidComposeView.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidComposeView$rotaryInputModifier$1 extends kotlin.jvm.internal.v implements h9.l<RotaryScrollEvent, Boolean> {
    public static final AndroidComposeView$rotaryInputModifier$1 INSTANCE = new AndroidComposeView$rotaryInputModifier$1();

    AndroidComposeView$rotaryInputModifier$1() {
        super(1);
    }

    @Override // h9.l
    @NotNull
    public final Boolean invoke(@NotNull RotaryScrollEvent it) {
        kotlin.jvm.internal.t.i(it, "it");
        return Boolean.FALSE;
    }
}
