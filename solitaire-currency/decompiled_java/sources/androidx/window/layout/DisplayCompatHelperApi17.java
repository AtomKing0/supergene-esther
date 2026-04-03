package androidx.window.layout;

import android.graphics.Point;
import android.view.Display;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DisplayCompatHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(17)
public final class DisplayCompatHelperApi17 {

    @NotNull
    public static final DisplayCompatHelperApi17 INSTANCE = new DisplayCompatHelperApi17();

    private DisplayCompatHelperApi17() {
    }

    public final void getRealSize(@NotNull Display display, @NotNull Point point) {
        t.i(display, "display");
        t.i(point, "point");
        display.getRealSize(point);
    }
}
