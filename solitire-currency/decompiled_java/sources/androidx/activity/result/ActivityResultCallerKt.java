package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import h9.l;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ActivityResultCaller.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultCallerKt {
    @NotNull
    public static final <I, O> ActivityResultLauncher<k0> registerForActivityResult(@NotNull ActivityResultCaller activityResultCaller, @NotNull ActivityResultContract<I, O> activityResultContract, I i10, @NotNull ActivityResultRegistry activityResultRegistry, @NotNull final l<? super O, k0> lVar) {
        return new ActivityResultCallerLauncher(activityResultCaller.registerForActivityResult(activityResultContract, activityResultRegistry, new ActivityResultCallback() { // from class: androidx.activity.result.b
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                lVar.invoke(obj);
            }
        }), activityResultContract, i10);
    }

    @NotNull
    public static final <I, O> ActivityResultLauncher<k0> registerForActivityResult(@NotNull ActivityResultCaller activityResultCaller, @NotNull ActivityResultContract<I, O> activityResultContract, I i10, @NotNull final l<? super O, k0> lVar) {
        return new ActivityResultCallerLauncher(activityResultCaller.registerForActivityResult(activityResultContract, new ActivityResultCallback() { // from class: androidx.activity.result.a
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                lVar.invoke(obj);
            }
        }), activityResultContract, i10);
    }
}
