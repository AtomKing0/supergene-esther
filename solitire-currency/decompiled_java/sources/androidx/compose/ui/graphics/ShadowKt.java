package androidx.compose.ui.graphics;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.util.MathHelpersKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Shadow.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ShadowKt {
    @Stable
    @NotNull
    public static final Shadow lerp(@NotNull Shadow start, @NotNull Shadow stop, float f10) {
        kotlin.jvm.internal.t.i(start, "start");
        kotlin.jvm.internal.t.i(stop, "stop");
        return new Shadow(ColorKt.m1650lerpjxsXWHM(start.m1865getColor0d7_KjU(), stop.m1865getColor0d7_KjU(), f10), OffsetKt.m1390lerpWko1d7g(start.m1866getOffsetF1C5BW0(), stop.m1866getOffsetF1C5BW0(), f10), MathHelpersKt.lerp(start.getBlurRadius(), stop.getBlurRadius(), f10), null);
    }
}
