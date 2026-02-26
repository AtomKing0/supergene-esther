package androidx.compose.ui.hapticfeedback;

import android.view.View;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PlatformHapticFeedback.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PlatformHapticFeedback implements HapticFeedback {

    @NotNull
    private final View view;

    public PlatformHapticFeedback(@NotNull View view) {
        t.i(view, "view");
        this.view = view;
    }

    @Override // androidx.compose.ui.hapticfeedback.HapticFeedback
    /* JADX INFO: renamed from: performHapticFeedback-CdsT49E */
    public void mo2138performHapticFeedbackCdsT49E(int i10) {
        HapticFeedbackType.Companion companion = HapticFeedbackType.Companion;
        if (HapticFeedbackType.m2142equalsimpl0(i10, companion.m2146getLongPress5zf0vsI())) {
            this.view.performHapticFeedback(0);
        } else if (HapticFeedbackType.m2142equalsimpl0(i10, companion.m2147getTextHandleMove5zf0vsI())) {
            this.view.performHapticFeedback(9);
        }
    }
}
