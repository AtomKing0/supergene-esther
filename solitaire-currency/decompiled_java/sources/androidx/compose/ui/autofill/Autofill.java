package androidx.compose.ui.autofill;

import androidx.compose.ui.ExperimentalComposeUiApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Autofill.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalComposeUiApi
public interface Autofill {
    void cancelAutofillForNode(@NotNull AutofillNode autofillNode);

    void requestAutofillForNode(@NotNull AutofillNode autofillNode);
}
