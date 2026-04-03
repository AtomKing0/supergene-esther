package androidx.window.layout;

import android.app.Activity;
import android.graphics.Rect;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ActivityCompatHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(30)
public final class ActivityCompatHelperApi30 {

    @NotNull
    public static final ActivityCompatHelperApi30 INSTANCE = new ActivityCompatHelperApi30();

    private ActivityCompatHelperApi30() {
    }

    @NotNull
    public final Rect currentWindowBounds(@NotNull Activity activity) {
        t.i(activity, "activity");
        Rect bounds = activity.getWindowManager().getCurrentWindowMetrics().getBounds();
        t.h(bounds, "activity.windowManager.currentWindowMetrics.bounds");
        return bounds;
    }

    @NotNull
    public final Rect maximumWindowBounds(@NotNull Activity activity) {
        t.i(activity, "activity");
        Rect bounds = activity.getWindowManager().getMaximumWindowMetrics().getBounds();
        t.h(bounds, "activity.windowManager.maximumWindowMetrics.bounds");
        return bounds;
    }
}
