package androidx.compose.ui.text.input;

import androidx.compose.ui.geometry.Rect;
import h9.l;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TextInputService.kt */
/* JADX INFO: loaded from: classes.dex */
public interface PlatformTextInputService {
    void hideSoftwareKeyboard();

    void notifyFocusedRect(@NotNull Rect rect);

    void showSoftwareKeyboard();

    void startInput(@NotNull TextFieldValue textFieldValue, @NotNull ImeOptions imeOptions, @NotNull l<? super List<? extends EditCommand>, k0> lVar, @NotNull l<? super ImeAction, k0> lVar2);

    void stopInput();

    void updateState(@Nullable TextFieldValue textFieldValue, @NotNull TextFieldValue textFieldValue2);
}
