package androidx.compose.ui.text.style;

import androidx.compose.ui.text.SpanStyleKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextIndent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextIndentKt {
    @NotNull
    public static final TextIndent lerp(@NotNull TextIndent start, @NotNull TextIndent stop, float f10) {
        t.i(start, "start");
        t.i(stop, "stop");
        return new TextIndent(SpanStyleKt.m3313lerpTextUnitInheritableC3pnCVY(start.m3614getFirstLineXSAIIZE(), stop.m3614getFirstLineXSAIIZE(), f10), SpanStyleKt.m3313lerpTextUnitInheritableC3pnCVY(start.m3615getRestLineXSAIIZE(), stop.m3615getRestLineXSAIIZE(), f10), null);
    }
}
