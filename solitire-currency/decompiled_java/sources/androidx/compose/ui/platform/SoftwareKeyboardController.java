package androidx.compose.ui.platform;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.ExperimentalComposeUiApi;

/* JADX INFO: compiled from: SoftwareKeyboardController.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalComposeUiApi
public interface SoftwareKeyboardController {
    void hide();

    void hideSoftwareKeyboard();

    void show();

    void showSoftwareKeyboard();
}
