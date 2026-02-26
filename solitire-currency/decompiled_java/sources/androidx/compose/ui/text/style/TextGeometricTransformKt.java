package androidx.compose.ui.text.style;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextGeometricTransform.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextGeometricTransformKt {
    @NotNull
    public static final TextGeometricTransform lerp(@NotNull TextGeometricTransform start, @NotNull TextGeometricTransform stop, float f10) {
        t.i(start, "start");
        t.i(stop, "stop");
        return new TextGeometricTransform(MathHelpersKt.lerp(start.getScaleX(), stop.getScaleX(), f10), MathHelpersKt.lerp(start.getSkewX(), stop.getSkewX(), f10));
    }
}
