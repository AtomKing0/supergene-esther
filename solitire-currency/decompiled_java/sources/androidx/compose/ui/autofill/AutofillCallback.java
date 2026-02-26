package androidx.compose.ui.autofill;

import android.util.Log;
import android.view.View;
import android.view.autofill.AutofillManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.ExperimentalComposeUiApi;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AutofillCallback.android.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
public final class AutofillCallback extends AutofillManager.AutofillCallback {

    @NotNull
    public static final AutofillCallback INSTANCE = new AutofillCallback();

    private AutofillCallback() {
    }

    @Override // android.view.autofill.AutofillManager.AutofillCallback
    public void onAutofillEvent(@NotNull View view, int i10, int i11) {
        t.i(view, "view");
        super.onAutofillEvent(view, i10, i11);
        Log.d("Autofill Status", i11 != 1 ? i11 != 2 ? i11 != 3 ? "Unknown status event." : "Autofill popup isn't shown because autofill is not available.\n\nDid you set up autofill?\n1. Go to Settings > System > Languages&input > Advanced > Autofill Service\n2. Pick a service\n\nDid you add an account?\n1. Go to Settings > System > Languages&input > Advanced\n2. Click on the settings icon next to the Autofill Service\n3. Add your account" : "Autofill popup was hidden." : "Autofill popup was shown.");
    }

    @DoNotInline
    @ExperimentalComposeUiApi
    public final void register(@NotNull AndroidAutofill autofill) {
        t.i(autofill, "autofill");
        autofill.getAutofillManager().registerCallback(this);
    }

    @DoNotInline
    @ExperimentalComposeUiApi
    public final void unregister(@NotNull AndroidAutofill autofill) {
        t.i(autofill, "autofill");
        autofill.getAutofillManager().unregisterCallback(this);
    }
}
