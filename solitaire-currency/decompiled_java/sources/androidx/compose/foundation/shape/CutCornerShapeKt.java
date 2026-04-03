package androidx.compose.foundation.shape;

import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CutCornerShape.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CutCornerShapeKt {
    @NotNull
    public static final CutCornerShape CutCornerShape(@NotNull CornerSize corner) {
        t.i(corner, "corner");
        return new CutCornerShape(corner, corner, corner, corner);
    }

    public static /* synthetic */ CutCornerShape CutCornerShape$default(float f10, float f11, float f12, float f13, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 0.0f;
        }
        if ((i10 & 4) != 0) {
            f12 = 0.0f;
        }
        if ((i10 & 8) != 0) {
            f13 = 0.0f;
        }
        return CutCornerShape(f10, f11, f12, f13);
    }

    @NotNull
    /* JADX INFO: renamed from: CutCornerShape-0680j_4, reason: not valid java name */
    public static final CutCornerShape m639CutCornerShape0680j_4(float f10) {
        return CutCornerShape(CornerSizeKt.m638CornerSize0680j_4(f10));
    }

    @NotNull
    /* JADX INFO: renamed from: CutCornerShape-a9UjIt4, reason: not valid java name */
    public static final CutCornerShape m640CutCornerShapea9UjIt4(float f10, float f11, float f12, float f13) {
        return new CutCornerShape(CornerSizeKt.m638CornerSize0680j_4(f10), CornerSizeKt.m638CornerSize0680j_4(f11), CornerSizeKt.m638CornerSize0680j_4(f12), CornerSizeKt.m638CornerSize0680j_4(f13));
    }

    /* JADX INFO: renamed from: CutCornerShape-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ CutCornerShape m641CutCornerShapea9UjIt4$default(float f10, float f11, float f12, float f13, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = Dp.m3673constructorimpl(0);
        }
        if ((i10 & 2) != 0) {
            f11 = Dp.m3673constructorimpl(0);
        }
        if ((i10 & 4) != 0) {
            f12 = Dp.m3673constructorimpl(0);
        }
        if ((i10 & 8) != 0) {
            f13 = Dp.m3673constructorimpl(0);
        }
        return m640CutCornerShapea9UjIt4(f10, f11, f12, f13);
    }

    @NotNull
    public static final CutCornerShape CutCornerShape(float f10) {
        return CutCornerShape(CornerSizeKt.CornerSize(f10));
    }

    public static /* synthetic */ CutCornerShape CutCornerShape$default(int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = 0;
        }
        if ((i14 & 2) != 0) {
            i11 = 0;
        }
        if ((i14 & 4) != 0) {
            i12 = 0;
        }
        if ((i14 & 8) != 0) {
            i13 = 0;
        }
        return CutCornerShape(i10, i11, i12, i13);
    }

    @NotNull
    public static final CutCornerShape CutCornerShape(int i10) {
        return CutCornerShape(CornerSizeKt.CornerSize(i10));
    }

    @NotNull
    public static final CutCornerShape CutCornerShape(float f10, float f11, float f12, float f13) {
        return new CutCornerShape(CornerSizeKt.CornerSize(f10), CornerSizeKt.CornerSize(f11), CornerSizeKt.CornerSize(f12), CornerSizeKt.CornerSize(f13));
    }

    @NotNull
    public static final CutCornerShape CutCornerShape(int i10, int i11, int i12, int i13) {
        return new CutCornerShape(CornerSizeKt.CornerSize(i10), CornerSizeKt.CornerSize(i11), CornerSizeKt.CornerSize(i12), CornerSizeKt.CornerSize(i13));
    }
}
