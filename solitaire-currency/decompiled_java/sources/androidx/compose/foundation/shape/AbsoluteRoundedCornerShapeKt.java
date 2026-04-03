package androidx.compose.foundation.shape;

import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AbsoluteRoundedCornerShape.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AbsoluteRoundedCornerShapeKt {
    @NotNull
    public static final AbsoluteRoundedCornerShape AbsoluteRoundedCornerShape(@NotNull CornerSize corner) {
        t.i(corner, "corner");
        return new AbsoluteRoundedCornerShape(corner, corner, corner, corner);
    }

    public static /* synthetic */ AbsoluteRoundedCornerShape AbsoluteRoundedCornerShape$default(float f10, float f11, float f12, float f13, int i10, Object obj) {
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
        return AbsoluteRoundedCornerShape(f10, f11, f12, f13);
    }

    @NotNull
    /* JADX INFO: renamed from: AbsoluteRoundedCornerShape-0680j_4, reason: not valid java name */
    public static final AbsoluteRoundedCornerShape m634AbsoluteRoundedCornerShape0680j_4(float f10) {
        return AbsoluteRoundedCornerShape(CornerSizeKt.m638CornerSize0680j_4(f10));
    }

    @NotNull
    /* JADX INFO: renamed from: AbsoluteRoundedCornerShape-a9UjIt4, reason: not valid java name */
    public static final AbsoluteRoundedCornerShape m635AbsoluteRoundedCornerShapea9UjIt4(float f10, float f11, float f12, float f13) {
        return new AbsoluteRoundedCornerShape(CornerSizeKt.m638CornerSize0680j_4(f10), CornerSizeKt.m638CornerSize0680j_4(f11), CornerSizeKt.m638CornerSize0680j_4(f12), CornerSizeKt.m638CornerSize0680j_4(f13));
    }

    /* JADX INFO: renamed from: AbsoluteRoundedCornerShape-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ AbsoluteRoundedCornerShape m636AbsoluteRoundedCornerShapea9UjIt4$default(float f10, float f11, float f12, float f13, int i10, Object obj) {
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
        return m635AbsoluteRoundedCornerShapea9UjIt4(f10, f11, f12, f13);
    }

    @NotNull
    public static final AbsoluteRoundedCornerShape AbsoluteRoundedCornerShape(float f10) {
        return AbsoluteRoundedCornerShape(CornerSizeKt.CornerSize(f10));
    }

    public static /* synthetic */ AbsoluteRoundedCornerShape AbsoluteRoundedCornerShape$default(int i10, int i11, int i12, int i13, int i14, Object obj) {
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
        return AbsoluteRoundedCornerShape(i10, i11, i12, i13);
    }

    @NotNull
    public static final AbsoluteRoundedCornerShape AbsoluteRoundedCornerShape(int i10) {
        return AbsoluteRoundedCornerShape(CornerSizeKt.CornerSize(i10));
    }

    @NotNull
    public static final AbsoluteRoundedCornerShape AbsoluteRoundedCornerShape(float f10, float f11, float f12, float f13) {
        return new AbsoluteRoundedCornerShape(CornerSizeKt.CornerSize(f10), CornerSizeKt.CornerSize(f11), CornerSizeKt.CornerSize(f12), CornerSizeKt.CornerSize(f13));
    }

    @NotNull
    public static final AbsoluteRoundedCornerShape AbsoluteRoundedCornerShape(int i10, int i11, int i12, int i13) {
        return new AbsoluteRoundedCornerShape(CornerSizeKt.CornerSize(i10), CornerSizeKt.CornerSize(i11), CornerSizeKt.CornerSize(i12), CornerSizeKt.CornerSize(i13));
    }
}
