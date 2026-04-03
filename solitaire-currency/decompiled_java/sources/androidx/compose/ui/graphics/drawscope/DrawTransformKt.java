package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.DegreesKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DrawTransform.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DrawTransformKt {
    public static final void inset(@NotNull DrawTransform drawTransform, float f10, float f11) {
        t.i(drawTransform, "<this>");
        drawTransform.inset(f10, f11, f10, f11);
    }

    public static /* synthetic */ void inset$default(DrawTransform drawTransform, float f10, float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 0.0f;
        }
        t.i(drawTransform, "<this>");
        drawTransform.inset(f10, f11, f10, f11);
    }

    /* JADX INFO: renamed from: rotateRad-0AR0LA0, reason: not valid java name */
    public static final void m2079rotateRad0AR0LA0(@NotNull DrawTransform rotateRad, float f10, long j10) {
        t.i(rotateRad, "$this$rotateRad");
        rotateRad.mo2008rotateUv8p0NA(DegreesKt.degrees(f10), j10);
    }

    /* JADX INFO: renamed from: rotateRad-0AR0LA0$default, reason: not valid java name */
    public static /* synthetic */ void m2080rotateRad0AR0LA0$default(DrawTransform rotateRad, float f10, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = rotateRad.mo2006getCenterF1C5BW0();
        }
        t.i(rotateRad, "$this$rotateRad");
        rotateRad.mo2008rotateUv8p0NA(DegreesKt.degrees(f10), j10);
    }

    /* JADX INFO: renamed from: scale-0AR0LA0, reason: not valid java name */
    public static final void m2081scale0AR0LA0(@NotNull DrawTransform scale, float f10, long j10) {
        t.i(scale, "$this$scale");
        scale.mo2009scale0AR0LA0(f10, f10, j10);
    }

    /* JADX INFO: renamed from: scale-0AR0LA0$default, reason: not valid java name */
    public static /* synthetic */ void m2082scale0AR0LA0$default(DrawTransform scale, float f10, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = scale.mo2006getCenterF1C5BW0();
        }
        t.i(scale, "$this$scale");
        scale.mo2009scale0AR0LA0(f10, f10, j10);
    }

    public static final void inset(@NotNull DrawTransform drawTransform, float f10) {
        t.i(drawTransform, "<this>");
        drawTransform.inset(f10, f10, f10, f10);
    }
}
