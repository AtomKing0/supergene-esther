package androidx.compose.ui.platform;

import android.content.Context;
import android.os.Build;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidAccessibilityManager.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidAccessibilityManager implements AccessibilityManager {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final int FlagContentControls = 4;

    @Deprecated
    public static final int FlagContentIcons = 1;

    @Deprecated
    public static final int FlagContentText = 2;

    @NotNull
    private final android.view.accessibility.AccessibilityManager accessibilityManager;

    /* JADX INFO: compiled from: AndroidAccessibilityManager.android.kt */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public AndroidAccessibilityManager(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        Object systemService = context.getSystemService("accessibility");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        }
        this.accessibilityManager = (android.view.accessibility.AccessibilityManager) systemService;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.platform.AccessibilityManager
    public long calculateRecommendedTimeoutMillis(long j10, boolean z10, boolean z11, boolean z12) {
        int i10 = z10;
        if (j10 >= 2147483647L) {
            return j10;
        }
        if (z11) {
            i10 = (z10 ? 1 : 0) | 2;
        }
        if (z12) {
            i10 = (i10 == true ? 1 : 0) | 4;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            int recommendedTimeoutMillis = Api29Impl.INSTANCE.getRecommendedTimeoutMillis(this.accessibilityManager, (int) j10, i10);
            if (recommendedTimeoutMillis != Integer.MAX_VALUE) {
                return recommendedTimeoutMillis;
            }
        } else if (!z12 || !this.accessibilityManager.isTouchExplorationEnabled()) {
            return j10;
        }
        return Long.MAX_VALUE;
    }
}
