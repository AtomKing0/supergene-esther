package androidx.compose.ui.text.input;

import android.content.Context;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InputMethodManager.kt */
/* JADX INFO: loaded from: classes.dex */
final class InputMethodManagerImpl$imm$2 extends v implements h9.a<android.view.inputmethod.InputMethodManager> {
    final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InputMethodManagerImpl$imm$2(Context context) {
        super(0);
        this.$context = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final android.view.inputmethod.InputMethodManager invoke() {
        Object systemService = this.$context.getSystemService("input_method");
        if (systemService != null) {
            return (android.view.inputmethod.InputMethodManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }
}
