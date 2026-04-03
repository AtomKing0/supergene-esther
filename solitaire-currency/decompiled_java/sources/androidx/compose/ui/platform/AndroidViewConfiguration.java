package androidx.compose.ui.platform;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidViewConfiguration.android.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class AndroidViewConfiguration implements ViewConfiguration {
    public static final int $stable = 8;

    @NotNull
    private final android.view.ViewConfiguration viewConfiguration;

    public AndroidViewConfiguration(@NotNull android.view.ViewConfiguration viewConfiguration) {
        kotlin.jvm.internal.t.i(viewConfiguration, "viewConfiguration");
        this.viewConfiguration = viewConfiguration;
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public long getDoubleTapMinTimeMillis() {
        return 40L;
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public long getDoubleTapTimeoutMillis() {
        return android.view.ViewConfiguration.getDoubleTapTimeout();
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public long getLongPressTimeoutMillis() {
        return android.view.ViewConfiguration.getLongPressTimeout();
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    /* JADX INFO: renamed from: getMinimumTouchTargetSize-MYxV2XQ */
    public /* synthetic */ long mo3104getMinimumTouchTargetSizeMYxV2XQ() {
        return a2.a(this);
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public float getTouchSlop() {
        return this.viewConfiguration.getScaledTouchSlop();
    }
}
