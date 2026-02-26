package androidx.activity.result;

import androidx.core.app.ActivityOptionsCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ActivityResultLauncher.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultLauncherKt {
    public static final void launch(@NotNull ActivityResultLauncher<Void> activityResultLauncher, @Nullable ActivityOptionsCompat activityOptionsCompat) {
        activityResultLauncher.launch(null, activityOptionsCompat);
    }

    public static /* synthetic */ void launch$default(ActivityResultLauncher activityResultLauncher, ActivityOptionsCompat activityOptionsCompat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            activityOptionsCompat = null;
        }
        launch(activityResultLauncher, activityOptionsCompat);
    }

    public static final void launchUnit(@NotNull ActivityResultLauncher<k0> activityResultLauncher, @Nullable ActivityOptionsCompat activityOptionsCompat) {
        activityResultLauncher.launch(k0.f35197a, activityOptionsCompat);
    }

    public static /* synthetic */ void launchUnit$default(ActivityResultLauncher activityResultLauncher, ActivityOptionsCompat activityOptionsCompat, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            activityOptionsCompat = null;
        }
        launchUnit(activityResultLauncher, activityOptionsCompat);
    }
}
