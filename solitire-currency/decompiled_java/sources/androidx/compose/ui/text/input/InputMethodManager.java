package androidx.compose.ui.text.input;

import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.ExtractedText;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: InputMethodManager.kt */
/* JADX INFO: loaded from: classes.dex */
public interface InputMethodManager {
    void hideSoftInputFromWindow(@Nullable IBinder iBinder);

    void restartInput(@NotNull View view);

    void showSoftInput(@NotNull View view);

    void updateExtractedText(@NotNull View view, int i10, @NotNull ExtractedText extractedText);

    void updateSelection(@NotNull View view, int i10, int i11, int i12, int i13);
}
