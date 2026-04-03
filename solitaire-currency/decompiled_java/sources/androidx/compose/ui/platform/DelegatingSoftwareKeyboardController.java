package androidx.compose.ui.platform;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.text.input.TextInputService;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LocalSoftwareKeyboardController.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalComposeUiApi
final class DelegatingSoftwareKeyboardController implements SoftwareKeyboardController {

    @NotNull
    private final TextInputService textInputService;

    public DelegatingSoftwareKeyboardController(@NotNull TextInputService textInputService) {
        kotlin.jvm.internal.t.i(textInputService, "textInputService");
        this.textInputService = textInputService;
    }

    @NotNull
    public final TextInputService getTextInputService() {
        return this.textInputService;
    }

    @Override // androidx.compose.ui.platform.SoftwareKeyboardController
    public void hide() {
        this.textInputService.hideSoftwareKeyboard();
    }

    @Override // androidx.compose.ui.platform.SoftwareKeyboardController
    public /* synthetic */ void hideSoftwareKeyboard() {
        x1.a(this);
    }

    @Override // androidx.compose.ui.platform.SoftwareKeyboardController
    public void show() {
        this.textInputService.showSoftwareKeyboard();
    }

    @Override // androidx.compose.ui.platform.SoftwareKeyboardController
    public /* synthetic */ void showSoftwareKeyboard() {
        x1.b(this);
    }
}
