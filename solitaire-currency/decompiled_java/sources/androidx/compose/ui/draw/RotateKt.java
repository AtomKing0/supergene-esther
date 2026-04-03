package androidx.compose.ui.draw;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Rotate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RotateKt {
    @Stable
    @NotNull
    public static final Modifier rotate(@NotNull Modifier modifier, float f10) {
        t.i(modifier, "<this>");
        return !((f10 > 0.0f ? 1 : (f10 == 0.0f ? 0 : -1)) == 0) ? GraphicsLayerModifierKt.m1735graphicsLayerpANQ8Wg$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f10, 0.0f, 0L, null, false, null, 0L, 0L, 65279, null) : modifier;
    }
}
