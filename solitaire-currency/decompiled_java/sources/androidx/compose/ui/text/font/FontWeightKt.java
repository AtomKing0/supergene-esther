package androidx.compose.ui.text.font;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.internal.t;
import n9.o;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FontWeight.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FontWeightKt {
    @NotNull
    public static final FontWeight lerp(@NotNull FontWeight start, @NotNull FontWeight stop, float f10) {
        t.i(start, "start");
        t.i(stop, "stop");
        return new FontWeight(o.n(MathHelpersKt.lerp(start.getWeight(), stop.getWeight(), f10), 1, 1000));
    }
}
