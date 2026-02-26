package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Background.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BackgroundKt {
    @NotNull
    public static final Modifier background(@NotNull Modifier modifier, @NotNull Brush brush, @NotNull Shape shape, float f10) {
        t.i(modifier, "<this>");
        t.i(brush, "brush");
        t.i(shape, "shape");
        return modifier.then(new Background(null, brush, f10, shape, InspectableValueKt.isDebugInspectorInfoEnabled() ? new BackgroundKt$background$$inlined$debugInspectorInfo$1(f10, brush, shape) : InspectableValueKt.getNoInspectorInfo(), 1, null));
    }

    public static /* synthetic */ Modifier background$default(Modifier modifier, Brush brush, Shape shape, float f10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        if ((i10 & 4) != 0) {
            f10 = 1.0f;
        }
        return background(modifier, brush, shape, f10);
    }

    @NotNull
    /* JADX INFO: renamed from: background-bw27NRU, reason: not valid java name */
    public static final Modifier m165backgroundbw27NRU(@NotNull Modifier background, long j10, @NotNull Shape shape) {
        t.i(background, "$this$background");
        t.i(shape, "shape");
        return background.then(new Background(Color.m1588boximpl(j10), null, 0.0f, shape, InspectableValueKt.isDebugInspectorInfoEnabled() ? new BackgroundKt$backgroundbw27NRU$$inlined$debugInspectorInfo$1(j10, shape) : InspectableValueKt.getNoInspectorInfo(), 6, null));
    }

    /* JADX INFO: renamed from: background-bw27NRU$default, reason: not valid java name */
    public static /* synthetic */ Modifier m166backgroundbw27NRU$default(Modifier modifier, long j10, Shape shape, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        return m165backgroundbw27NRU(modifier, j10, shape);
    }
}
