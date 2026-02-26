package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PainterModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PainterModifierKt {
    @NotNull
    public static final Modifier paint(@NotNull Modifier modifier, @NotNull Painter painter, boolean z10, @NotNull Alignment alignment, @NotNull ContentScale contentScale, float f10, @Nullable ColorFilter colorFilter) {
        t.i(modifier, "<this>");
        t.i(painter, "painter");
        t.i(alignment, "alignment");
        t.i(contentScale, "contentScale");
        return modifier.then(new PainterModifier(painter, z10, alignment, contentScale, f10, colorFilter, InspectableValueKt.isDebugInspectorInfoEnabled() ? new PainterModifierKt$paint$$inlined$debugInspectorInfo$1(painter, z10, alignment, contentScale, f10, colorFilter) : InspectableValueKt.getNoInspectorInfo()));
    }

    public static /* synthetic */ Modifier paint$default(Modifier modifier, Painter painter, boolean z10, Alignment alignment, ContentScale contentScale, float f10, ColorFilter colorFilter, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        boolean z11 = z10;
        if ((i10 & 4) != 0) {
            alignment = Alignment.Companion.getCenter();
        }
        Alignment alignment2 = alignment;
        if ((i10 & 8) != 0) {
            contentScale = ContentScale.Companion.getInside();
        }
        ContentScale contentScale2 = contentScale;
        if ((i10 & 16) != 0) {
            f10 = 1.0f;
        }
        float f11 = f10;
        if ((i10 & 32) != 0) {
            colorFilter = null;
        }
        return paint(modifier, painter, z11, alignment2, contentScale2, f11, colorFilter);
    }
}
