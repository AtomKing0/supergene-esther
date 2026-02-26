package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.internal.t;
import n9.o;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Dp.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DpKt {
    @Stable
    /* JADX INFO: renamed from: DpOffset-YgX7TsA, reason: not valid java name */
    public static final long m3694DpOffsetYgX7TsA(float f10, float f11) {
        return DpOffset.m3729constructorimpl((((long) Float.floatToIntBits(f11)) & 4294967295L) | (Float.floatToIntBits(f10) << 32));
    }

    @Stable
    /* JADX INFO: renamed from: DpSize-YgX7TsA, reason: not valid java name */
    public static final long m3695DpSizeYgX7TsA(float f10, float f11) {
        return DpSize.m3762constructorimpl((((long) Float.floatToIntBits(f11)) & 4294967295L) | (Float.floatToIntBits(f10) << 32));
    }

    @Stable
    /* JADX INFO: renamed from: coerceAtLeast-YgX7TsA, reason: not valid java name */
    public static final float m3696coerceAtLeastYgX7TsA(float f10, float f11) {
        return Dp.m3673constructorimpl(o.d(f10, f11));
    }

    @Stable
    /* JADX INFO: renamed from: coerceAtMost-YgX7TsA, reason: not valid java name */
    public static final float m3697coerceAtMostYgX7TsA(float f10, float f11) {
        return Dp.m3673constructorimpl(o.i(f10, f11));
    }

    @Stable
    /* JADX INFO: renamed from: coerceIn-2z7ARbQ, reason: not valid java name */
    public static final float m3698coerceIn2z7ARbQ(float f10, float f11, float f12) {
        return Dp.m3673constructorimpl(o.m(f10, f11, f12));
    }

    /* JADX INFO: renamed from: getCenter-EaSLcWc, reason: not valid java name */
    public static final long m3699getCenterEaSLcWc(long j10) {
        return m3694DpOffsetYgX7TsA(Dp.m3673constructorimpl(DpSize.m3771getWidthD9Ej5fM(j10) / 2.0f), Dp.m3673constructorimpl(DpSize.m3769getHeightD9Ej5fM(j10) / 2.0f));
    }

    public static final float getDp(int i10) {
        return Dp.m3673constructorimpl(i10);
    }

    @Stable
    public static /* synthetic */ void getDp$annotations(double d10) {
    }

    public static final float getHeight(@NotNull DpRect dpRect) {
        t.i(dpRect, "<this>");
        return Dp.m3673constructorimpl(dpRect.m3755getBottomD9Ej5fM() - dpRect.m3758getTopD9Ej5fM());
    }

    public static final long getSize(@NotNull DpRect dpRect) {
        t.i(dpRect, "<this>");
        return m3695DpSizeYgX7TsA(Dp.m3673constructorimpl(dpRect.m3757getRightD9Ej5fM() - dpRect.m3756getLeftD9Ej5fM()), Dp.m3673constructorimpl(dpRect.m3755getBottomD9Ej5fM() - dpRect.m3758getTopD9Ej5fM()));
    }

    public static final float getWidth(@NotNull DpRect dpRect) {
        t.i(dpRect, "<this>");
        return Dp.m3673constructorimpl(dpRect.m3757getRightD9Ej5fM() - dpRect.m3756getLeftD9Ej5fM());
    }

    /* JADX INFO: renamed from: isFinite-0680j_4, reason: not valid java name */
    public static final boolean m3701isFinite0680j_4(float f10) {
        return !(f10 == Float.POSITIVE_INFINITY);
    }

    /* JADX INFO: renamed from: isSpecified-0680j_4, reason: not valid java name */
    public static final boolean m3703isSpecified0680j_4(float f10) {
        return !Float.isNaN(f10);
    }

    /* JADX INFO: renamed from: isSpecified-EaSLcWc, reason: not valid java name */
    public static final boolean m3705isSpecifiedEaSLcWc(long j10) {
        return j10 != DpSize.Companion.m3780getUnspecifiedMYxV2XQ();
    }

    /* JADX INFO: renamed from: isSpecified-jo-Fl9I, reason: not valid java name */
    public static final boolean m3707isSpecifiedjoFl9I(long j10) {
        return j10 != DpOffset.Companion.m3743getUnspecifiedRKDOV3M();
    }

    /* JADX INFO: renamed from: isUnspecified-0680j_4, reason: not valid java name */
    public static final boolean m3709isUnspecified0680j_4(float f10) {
        return Float.isNaN(f10);
    }

    /* JADX INFO: renamed from: isUnspecified-EaSLcWc, reason: not valid java name */
    public static final boolean m3711isUnspecifiedEaSLcWc(long j10) {
        return j10 == DpSize.Companion.m3780getUnspecifiedMYxV2XQ();
    }

    /* JADX INFO: renamed from: isUnspecified-jo-Fl9I, reason: not valid java name */
    public static final boolean m3713isUnspecifiedjoFl9I(long j10) {
        return j10 == DpOffset.Companion.m3743getUnspecifiedRKDOV3M();
    }

    @Stable
    /* JADX INFO: renamed from: lerp-IDex15A, reason: not valid java name */
    public static final long m3715lerpIDex15A(long j10, long j11, float f10) {
        return m3695DpSizeYgX7TsA(m3716lerpMdfbLM(DpSize.m3771getWidthD9Ej5fM(j10), DpSize.m3771getWidthD9Ej5fM(j11), f10), m3716lerpMdfbLM(DpSize.m3769getHeightD9Ej5fM(j10), DpSize.m3769getHeightD9Ej5fM(j11), f10));
    }

    @Stable
    /* JADX INFO: renamed from: lerp-Md-fbLM, reason: not valid java name */
    public static final float m3716lerpMdfbLM(float f10, float f11, float f12) {
        return Dp.m3673constructorimpl(MathHelpersKt.lerp(f10, f11, f12));
    }

    @Stable
    /* JADX INFO: renamed from: lerp-xhh869w, reason: not valid java name */
    public static final long m3717lerpxhh869w(long j10, long j11, float f10) {
        return m3694DpOffsetYgX7TsA(m3716lerpMdfbLM(DpOffset.m3734getXD9Ej5fM(j10), DpOffset.m3734getXD9Ej5fM(j11), f10), m3716lerpMdfbLM(DpOffset.m3736getYD9Ej5fM(j10), DpOffset.m3736getYD9Ej5fM(j11), f10));
    }

    @Stable
    /* JADX INFO: renamed from: max-YgX7TsA, reason: not valid java name */
    public static final float m3718maxYgX7TsA(float f10, float f11) {
        return Dp.m3673constructorimpl(Math.max(f10, f11));
    }

    @Stable
    /* JADX INFO: renamed from: min-YgX7TsA, reason: not valid java name */
    public static final float m3719minYgX7TsA(float f10, float f11) {
        return Dp.m3673constructorimpl(Math.min(f10, f11));
    }

    /* JADX INFO: renamed from: takeOrElse-D5KLDUw, reason: not valid java name */
    public static final float m3720takeOrElseD5KLDUw(float f10, @NotNull h9.a<Dp> block) {
        t.i(block, "block");
        return Float.isNaN(f10) ^ true ? f10 : block.invoke().m3687unboximpl();
    }

    /* JADX INFO: renamed from: takeOrElse-gVKV90s, reason: not valid java name */
    public static final long m3721takeOrElsegVKV90s(long j10, @NotNull h9.a<DpOffset> block) {
        t.i(block, "block");
        return (j10 > DpOffset.Companion.m3743getUnspecifiedRKDOV3M() ? 1 : (j10 == DpOffset.Companion.m3743getUnspecifiedRKDOV3M() ? 0 : -1)) != 0 ? j10 : block.invoke().m3742unboximpl();
    }

    /* JADX INFO: renamed from: takeOrElse-itqla9I, reason: not valid java name */
    public static final long m3722takeOrElseitqla9I(long j10, @NotNull h9.a<DpSize> block) {
        t.i(block, "block");
        return (j10 > DpSize.Companion.m3780getUnspecifiedMYxV2XQ() ? 1 : (j10 == DpSize.Companion.m3780getUnspecifiedMYxV2XQ() ? 0 : -1)) != 0 ? j10 : block.invoke().m3779unboximpl();
    }

    @Stable
    /* JADX INFO: renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m3724times3ABfNKs(float f10, float f11) {
        return Dp.m3673constructorimpl(f10 * f11);
    }

    @Stable
    /* JADX INFO: renamed from: times-6HolHcs, reason: not valid java name */
    public static final long m3727times6HolHcs(int i10, long j10) {
        return DpSize.m3777timesGh9hcWk(j10, i10);
    }

    public static final float getDp(double d10) {
        return Dp.m3673constructorimpl((float) d10);
    }

    @Stable
    public static /* synthetic */ void getDp$annotations(float f10) {
    }

    @Stable
    /* JADX INFO: renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m3723times3ABfNKs(double d10, float f10) {
        return Dp.m3673constructorimpl(((float) d10) * f10);
    }

    @Stable
    /* JADX INFO: renamed from: times-6HolHcs, reason: not valid java name */
    public static final long m3726times6HolHcs(float f10, long j10) {
        return DpSize.m3776timesGh9hcWk(j10, f10);
    }

    public static final float getDp(float f10) {
        return Dp.m3673constructorimpl(f10);
    }

    @Stable
    public static /* synthetic */ void getDp$annotations(int i10) {
    }

    @Stable
    /* JADX INFO: renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m3725times3ABfNKs(int i10, float f10) {
        return Dp.m3673constructorimpl(i10 * f10);
    }

    @Stable
    /* JADX INFO: renamed from: getCenter-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m3700getCenterEaSLcWc$annotations(long j10) {
    }

    @Stable
    public static /* synthetic */ void getHeight$annotations(DpRect dpRect) {
    }

    @Stable
    public static /* synthetic */ void getSize$annotations(DpRect dpRect) {
    }

    @Stable
    public static /* synthetic */ void getWidth$annotations(DpRect dpRect) {
    }

    @Stable
    /* JADX INFO: renamed from: isFinite-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m3702isFinite0680j_4$annotations(float f10) {
    }

    @Stable
    /* JADX INFO: renamed from: isSpecified-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m3704isSpecified0680j_4$annotations(float f10) {
    }

    @Stable
    /* JADX INFO: renamed from: isSpecified-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m3706isSpecifiedEaSLcWc$annotations(long j10) {
    }

    @Stable
    /* JADX INFO: renamed from: isSpecified-jo-Fl9I$annotations, reason: not valid java name */
    public static /* synthetic */ void m3708isSpecifiedjoFl9I$annotations(long j10) {
    }

    @Stable
    /* JADX INFO: renamed from: isUnspecified-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m3710isUnspecified0680j_4$annotations(float f10) {
    }

    @Stable
    /* JADX INFO: renamed from: isUnspecified-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m3712isUnspecifiedEaSLcWc$annotations(long j10) {
    }

    @Stable
    /* JADX INFO: renamed from: isUnspecified-jo-Fl9I$annotations, reason: not valid java name */
    public static /* synthetic */ void m3714isUnspecifiedjoFl9I$annotations(long j10) {
    }
}
