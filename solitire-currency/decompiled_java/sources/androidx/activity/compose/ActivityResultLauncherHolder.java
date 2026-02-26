package androidx.activity.compose;

import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.ActivityOptionsCompat;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ActivityResultRegistry.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultLauncherHolder<I> {

    @Nullable
    private ActivityResultLauncher<I> launcher;

    @Nullable
    public final ActivityResultLauncher<I> getLauncher() {
        return this.launcher;
    }

    public final void launch(@Nullable I i10, @Nullable ActivityOptionsCompat activityOptionsCompat) {
        k0 k0Var;
        ActivityResultLauncher<I> activityResultLauncher = this.launcher;
        if (activityResultLauncher != null) {
            activityResultLauncher.launch(i10, activityOptionsCompat);
            k0Var = k0.f35197a;
        } else {
            k0Var = null;
        }
        if (k0Var == null) {
            throw new IllegalStateException("Launcher has not been initialized".toString());
        }
    }

    public final void setLauncher(@Nullable ActivityResultLauncher<I> activityResultLauncher) {
        this.launcher = activityResultLauncher;
    }

    public final void unregister() {
        k0 k0Var;
        ActivityResultLauncher<I> activityResultLauncher = this.launcher;
        if (activityResultLauncher != null) {
            activityResultLauncher.unregister();
            k0Var = k0.f35197a;
        } else {
            k0Var = null;
        }
        if (k0Var == null) {
            throw new IllegalStateException("Launcher has not been initialized".toString());
        }
    }
}
