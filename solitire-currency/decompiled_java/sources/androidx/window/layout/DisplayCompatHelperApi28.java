package androidx.window.layout;

import android.view.DisplayCutout;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DisplayCompatHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(28)
public final class DisplayCompatHelperApi28 {

    @NotNull
    public static final DisplayCompatHelperApi28 INSTANCE = new DisplayCompatHelperApi28();

    private DisplayCompatHelperApi28() {
    }

    public final int safeInsetBottom(@NotNull DisplayCutout displayCutout) {
        t.i(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetBottom();
    }

    public final int safeInsetLeft(@NotNull DisplayCutout displayCutout) {
        t.i(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetLeft();
    }

    public final int safeInsetRight(@NotNull DisplayCutout displayCutout) {
        t.i(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetRight();
    }

    public final int safeInsetTop(@NotNull DisplayCutout displayCutout) {
        t.i(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetTop();
    }
}
