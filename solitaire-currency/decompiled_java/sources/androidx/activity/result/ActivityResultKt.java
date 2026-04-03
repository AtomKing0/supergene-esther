package androidx.activity.result;

import android.content.Intent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ActivityResult.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultKt {
    public static final int component1(@NotNull ActivityResult activityResult) {
        return activityResult.getResultCode();
    }

    @Nullable
    public static final Intent component2(@NotNull ActivityResult activityResult) {
        return activityResult.getData();
    }
}
