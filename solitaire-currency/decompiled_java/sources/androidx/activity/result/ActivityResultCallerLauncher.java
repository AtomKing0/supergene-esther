package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.l;
import v8.n;

/* JADX INFO: compiled from: ActivityResultCaller.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultCallerLauncher<I, O> extends ActivityResultLauncher<k0> {

    @NotNull
    private final ActivityResultContract<I, O> callerContract;
    private final I callerInput;

    @NotNull
    private final ActivityResultLauncher<I> launcher;

    @NotNull
    private final l resultContract$delegate = n.a(new ActivityResultCallerLauncher$resultContract$2(this));

    public ActivityResultCallerLauncher(@NotNull ActivityResultLauncher<I> activityResultLauncher, @NotNull ActivityResultContract<I, O> activityResultContract, I i10) {
        this.launcher = activityResultLauncher;
        this.callerContract = activityResultContract;
        this.callerInput = i10;
    }

    @NotNull
    public final ActivityResultContract<I, O> getCallerContract() {
        return this.callerContract;
    }

    public final I getCallerInput() {
        return this.callerInput;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    @NotNull
    public ActivityResultContract<k0, ?> getContract() {
        return getResultContract();
    }

    @NotNull
    public final ActivityResultLauncher<I> getLauncher() {
        return this.launcher;
    }

    @NotNull
    public final ActivityResultContract<k0, O> getResultContract() {
        return (ActivityResultContract) this.resultContract$delegate.getValue();
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void unregister() {
        this.launcher.unregister();
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void launch(@NotNull k0 k0Var, @Nullable ActivityOptionsCompat activityOptionsCompat) {
        this.launcher.launch(this.callerInput, activityOptionsCompat);
    }
}
