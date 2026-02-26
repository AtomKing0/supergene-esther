package androidx.compose.ui.text.input;

import androidx.compose.animation.core.d;
import h9.l;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TextInputService.kt */
/* JADX INFO: loaded from: classes.dex */
public class TextInputService {

    @NotNull
    private final AtomicReference<TextInputSession> _currentInputSession;

    @NotNull
    private final PlatformTextInputService platformTextInputService;

    public TextInputService(@NotNull PlatformTextInputService platformTextInputService) {
        t.i(platformTextInputService, "platformTextInputService");
        this.platformTextInputService = platformTextInputService;
        this._currentInputSession = new AtomicReference<>(null);
    }

    @Nullable
    public final TextInputSession getCurrentInputSession$ui_text_release() {
        return this._currentInputSession.get();
    }

    public final void hideSoftwareKeyboard() {
        this.platformTextInputService.hideSoftwareKeyboard();
    }

    public final void showSoftwareKeyboard() {
        if (this._currentInputSession.get() != null) {
            this.platformTextInputService.showSoftwareKeyboard();
        }
    }

    @NotNull
    public TextInputSession startInput(@NotNull TextFieldValue value, @NotNull ImeOptions imeOptions, @NotNull l<? super List<? extends EditCommand>, k0> onEditCommand, @NotNull l<? super ImeAction, k0> onImeActionPerformed) {
        t.i(value, "value");
        t.i(imeOptions, "imeOptions");
        t.i(onEditCommand, "onEditCommand");
        t.i(onImeActionPerformed, "onImeActionPerformed");
        this.platformTextInputService.startInput(value, imeOptions, onEditCommand, onImeActionPerformed);
        TextInputSession textInputSession = new TextInputSession(this, this.platformTextInputService);
        this._currentInputSession.set(textInputSession);
        return textInputSession;
    }

    public void stopInput(@NotNull TextInputSession session) {
        t.i(session, "session");
        if (d.a(this._currentInputSession, session, null)) {
            this.platformTextInputService.stopInput();
        }
    }
}
