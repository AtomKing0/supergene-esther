package androidx.compose.ui.draw;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Scale.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ScaleKt {
    @Stable
    @NotNull
    public static final Modifier scale(@NotNull Modifier modifier, float f10, float f11) {
        t.i(modifier, "<this>");
        if (f10 == 1.0f) {
            if (f11 == 1.0f) {
                return modifier;
            }
        }
        return GraphicsLayerModifierKt.m1735graphicsLayerpANQ8Wg$default(modifier, f10, f11, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 65532, null);
    }

    @Stable
    @NotNull
    public static final Modifier scale(@NotNull Modifier modifier, float f10) {
        t.i(modifier, "<this>");
        return scale(modifier, f10, f10);
    }
}
