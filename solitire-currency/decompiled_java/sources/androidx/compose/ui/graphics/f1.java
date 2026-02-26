package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Path;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Path.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f1 {
    static {
        Path.Companion companion = Path.Companion;
    }

    public static void a(Path path, @NotNull Rect rect, float f10, float f11, boolean z10) {
        kotlin.jvm.internal.t.i(rect, "rect");
        path.arcTo(rect, DegreesKt.degrees(f10), DegreesKt.degrees(f11), z10);
    }

    public static /* synthetic */ void c(Path path, Path path2, long j10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addPath-Uv8p0NA");
        }
        if ((i10 & 2) != 0) {
            j10 = Offset.Companion.m1383getZeroF1C5BW0();
        }
        path.mo1499addPathUv8p0NA(path2, j10);
    }
}
