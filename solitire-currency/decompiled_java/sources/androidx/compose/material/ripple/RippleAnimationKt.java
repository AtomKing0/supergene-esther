package androidx.compose.material.ripple;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RippleAnimation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RippleAnimationKt {
    private static final float BoundedRippleExtraRadius = Dp.m3673constructorimpl(10);
    private static final int FadeInDuration = 75;
    private static final int FadeOutDuration = 150;
    private static final int RadiusDuration = 225;

    /* JADX INFO: renamed from: getRippleEndRadius-cSwnlzA, reason: not valid java name */
    public static final float m1231getRippleEndRadiuscSwnlzA(@NotNull Density getRippleEndRadius, boolean z10, long j10) {
        t.i(getRippleEndRadius, "$this$getRippleEndRadius");
        float fM1365getDistanceimpl = Offset.m1365getDistanceimpl(OffsetKt.Offset(Size.m1436getWidthimpl(j10), Size.m1433getHeightimpl(j10))) / 2.0f;
        return z10 ? fM1365getDistanceimpl + getRippleEndRadius.mo296toPx0680j_4(BoundedRippleExtraRadius) : fM1365getDistanceimpl;
    }

    /* JADX INFO: renamed from: getRippleStartRadius-uvyYCjk, reason: not valid java name */
    public static final float m1232getRippleStartRadiusuvyYCjk(long j10) {
        return Math.max(Size.m1436getWidthimpl(j10), Size.m1433getHeightimpl(j10)) * 0.3f;
    }
}
