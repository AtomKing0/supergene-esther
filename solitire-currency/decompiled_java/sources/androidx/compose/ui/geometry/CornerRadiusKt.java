package androidx.compose.ui.geometry;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;

/* JADX INFO: compiled from: CornerRadius.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CornerRadiusKt {
    @Stable
    public static final long CornerRadius(float f10, float f11) {
        return CornerRadius.m1336constructorimpl((((long) Float.floatToIntBits(f11)) & 4294967295L) | (Float.floatToIntBits(f10) << 32));
    }

    public static /* synthetic */ long CornerRadius$default(float f10, float f11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f11 = f10;
        }
        return CornerRadius(f10, f11);
    }

    @Stable
    /* JADX INFO: renamed from: lerp-3Ry4LBc, reason: not valid java name */
    public static final long m1353lerp3Ry4LBc(long j10, long j11, float f10) {
        return CornerRadius(MathHelpersKt.lerp(CornerRadius.m1342getXimpl(j10), CornerRadius.m1342getXimpl(j11), f10), MathHelpersKt.lerp(CornerRadius.m1343getYimpl(j10), CornerRadius.m1343getYimpl(j11), f10));
    }
}
