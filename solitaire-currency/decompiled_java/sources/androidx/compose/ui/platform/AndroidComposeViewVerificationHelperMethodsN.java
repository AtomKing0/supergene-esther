package androidx.compose.ui.platform;

import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.input.pointer.AndroidPointerIcon;
import androidx.compose.ui.input.pointer.AndroidPointerIconType;
import androidx.compose.ui.input.pointer.PointerIcon;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidComposeView.android.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
final class AndroidComposeViewVerificationHelperMethodsN {

    @NotNull
    public static final AndroidComposeViewVerificationHelperMethodsN INSTANCE = new AndroidComposeViewVerificationHelperMethodsN();

    private AndroidComposeViewVerificationHelperMethodsN() {
    }

    @DoNotInline
    @RequiresApi(24)
    public final void setPointerIcon(@NotNull View view, @Nullable PointerIcon pointerIcon) {
        kotlin.jvm.internal.t.i(view, "view");
        android.view.PointerIcon pointerIcon2 = pointerIcon instanceof AndroidPointerIcon ? ((AndroidPointerIcon) pointerIcon).getPointerIcon() : pointerIcon instanceof AndroidPointerIconType ? android.view.PointerIcon.getSystemIcon(view.getContext(), ((AndroidPointerIconType) pointerIcon).getType()) : android.view.PointerIcon.getSystemIcon(view.getContext(), 1000);
        if (kotlin.jvm.internal.t.d(view.getPointerIcon(), pointerIcon2)) {
            return;
        }
        view.setPointerIcon(pointerIcon2);
    }
}
