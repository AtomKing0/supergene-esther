package androidx.compose.ui.platform;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidAccessibilityManager.android.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
public final class Api29Impl {

    @NotNull
    public static final Api29Impl INSTANCE = new Api29Impl();

    private Api29Impl() {
    }

    @DoNotInline
    public final int getRecommendedTimeoutMillis(@NotNull android.view.accessibility.AccessibilityManager accessibilityManager, int i10, int i11) {
        kotlin.jvm.internal.t.i(accessibilityManager, "accessibilityManager");
        return accessibilityManager.getRecommendedTimeoutMillis(i10, i11);
    }
}
