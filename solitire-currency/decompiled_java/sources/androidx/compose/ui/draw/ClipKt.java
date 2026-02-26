package androidx.compose.ui.draw;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Clip.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ClipKt {
    @Stable
    @NotNull
    public static final Modifier clip(@NotNull Modifier modifier, @NotNull Shape shape) {
        t.i(modifier, "<this>");
        t.i(shape, "shape");
        return GraphicsLayerModifierKt.m1735graphicsLayerpANQ8Wg$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, shape, true, null, 0L, 0L, 59391, null);
    }

    @Stable
    @NotNull
    public static final Modifier clipToBounds(@NotNull Modifier modifier) {
        t.i(modifier, "<this>");
        return GraphicsLayerModifierKt.m1735graphicsLayerpANQ8Wg$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, true, null, 0L, 0L, 61439, null);
    }
}
