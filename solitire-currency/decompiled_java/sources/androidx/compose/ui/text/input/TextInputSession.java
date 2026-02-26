package androidx.compose.ui.text.input;

import androidx.compose.ui.geometry.Rect;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TextInputService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextInputSession {

    @NotNull
    private final PlatformTextInputService platformTextInputService;

    @NotNull
    private final TextInputService textInputService;

    public TextInputSession(@NotNull TextInputService textInputService, @NotNull PlatformTextInputService platformTextInputService) {
        t.i(textInputService, "textInputService");
        t.i(platformTextInputService, "platformTextInputService");
        this.textInputService = textInputService;
        this.platformTextInputService = platformTextInputService;
    }

    private final boolean ensureOpenSession(h9.a<k0> aVar) {
        boolean zIsOpen = isOpen();
        if (zIsOpen) {
            aVar.invoke();
        }
        return zIsOpen;
    }

    public final void dispose() {
        this.textInputService.stopInput(this);
    }

    public final boolean hideSoftwareKeyboard() {
        boolean zIsOpen = isOpen();
        if (zIsOpen) {
            this.platformTextInputService.hideSoftwareKeyboard();
        }
        return zIsOpen;
    }

    public final boolean isOpen() {
        return t.d(this.textInputService.getCurrentInputSession$ui_text_release(), this);
    }

    public final boolean notifyFocusedRect(@NotNull Rect rect) {
        t.i(rect, "rect");
        boolean zIsOpen = isOpen();
        if (zIsOpen) {
            this.platformTextInputService.notifyFocusedRect(rect);
        }
        return zIsOpen;
    }

    public final boolean showSoftwareKeyboard() {
        boolean zIsOpen = isOpen();
        if (zIsOpen) {
            this.platformTextInputService.showSoftwareKeyboard();
        }
        return zIsOpen;
    }

    public final boolean updateState(@Nullable TextFieldValue textFieldValue, @NotNull TextFieldValue newValue) {
        t.i(newValue, "newValue");
        boolean zIsOpen = isOpen();
        if (zIsOpen) {
            this.platformTextInputService.updateState(textFieldValue, newValue);
        }
        return zIsOpen;
    }
}
