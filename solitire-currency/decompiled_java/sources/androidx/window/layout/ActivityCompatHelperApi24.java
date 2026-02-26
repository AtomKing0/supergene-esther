package androidx.window.layout;

import android.app.Activity;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ActivityCompatHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(24)
public final class ActivityCompatHelperApi24 {

    @NotNull
    public static final ActivityCompatHelperApi24 INSTANCE = new ActivityCompatHelperApi24();

    private ActivityCompatHelperApi24() {
    }

    public final boolean isInMultiWindowMode(@NotNull Activity activity) {
        t.i(activity, "activity");
        return activity.isInMultiWindowMode();
    }
}
