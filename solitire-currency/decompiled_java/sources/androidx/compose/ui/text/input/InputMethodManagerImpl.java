package androidx.compose.ui.text.input;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.ExtractedText;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.l;
import v8.n;
import v8.p;

/* JADX INFO: compiled from: InputMethodManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InputMethodManagerImpl implements InputMethodManager {

    @NotNull
    private final l imm$delegate;

    public InputMethodManagerImpl(@NotNull Context context) {
        t.i(context, "context");
        this.imm$delegate = n.b(p.f35203c, new InputMethodManagerImpl$imm$2(context));
    }

    private final android.view.inputmethod.InputMethodManager getImm() {
        return (android.view.inputmethod.InputMethodManager) this.imm$delegate.getValue();
    }

    @Override // androidx.compose.ui.text.input.InputMethodManager
    public void hideSoftInputFromWindow(@Nullable IBinder iBinder) {
        getImm().hideSoftInputFromWindow(iBinder, 0);
    }

    @Override // androidx.compose.ui.text.input.InputMethodManager
    public void restartInput(@NotNull View view) {
        t.i(view, "view");
        getImm().restartInput(view);
    }

    @Override // androidx.compose.ui.text.input.InputMethodManager
    public void showSoftInput(@NotNull View view) {
        t.i(view, "view");
        getImm().showSoftInput(view, 0);
    }

    @Override // androidx.compose.ui.text.input.InputMethodManager
    public void updateExtractedText(@NotNull View view, int i10, @NotNull ExtractedText extractedText) {
        t.i(view, "view");
        t.i(extractedText, "extractedText");
        getImm().updateExtractedText(view, i10, extractedText);
    }

    @Override // androidx.compose.ui.text.input.InputMethodManager
    public void updateSelection(@NotNull View view, int i10, int i11, int i12, int i13) {
        t.i(view, "view");
        getImm().updateSelection(view, i10, i11, i12, i13);
    }
}
