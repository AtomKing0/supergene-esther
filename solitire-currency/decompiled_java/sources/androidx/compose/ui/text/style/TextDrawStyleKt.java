package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.SpanStyleKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextDrawStyle.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextDrawStyleKt {
    @NotNull
    public static final TextDrawStyle lerp(@NotNull TextDrawStyle start, @NotNull TextDrawStyle stop, float f10) {
        t.i(start, "start");
        t.i(stop, "stop");
        return ((start instanceof BrushStyle) || (stop instanceof BrushStyle)) ? (TextDrawStyle) SpanStyleKt.lerpDiscrete(start, stop, f10) : TextDrawStyle.Companion.m3611from8_81llA(ColorKt.m1650lerpjxsXWHM(start.mo3556getColor0d7_KjU(), stop.mo3556getColor0d7_KjU(), f10));
    }
}
