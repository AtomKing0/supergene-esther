package androidx.compose.ui.graphics;

import android.graphics.Canvas;
import androidx.compose.ui.graphics.VertexMode;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidVertexMode.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidVertexMode_androidKt {
    @NotNull
    /* JADX INFO: renamed from: toAndroidVertexMode-JOOmi9M, reason: not valid java name */
    public static final Canvas.VertexMode m1512toAndroidVertexModeJOOmi9M(int i10) {
        VertexMode.Companion companion = VertexMode.Companion;
        return VertexMode.m1927equalsimpl0(i10, companion.m1933getTrianglesc2xauaI()) ? Canvas.VertexMode.TRIANGLES : VertexMode.m1927equalsimpl0(i10, companion.m1932getTriangleStripc2xauaI()) ? Canvas.VertexMode.TRIANGLE_STRIP : VertexMode.m1927equalsimpl0(i10, companion.m1931getTriangleFanc2xauaI()) ? Canvas.VertexMode.TRIANGLE_FAN : Canvas.VertexMode.TRIANGLES;
    }
}
