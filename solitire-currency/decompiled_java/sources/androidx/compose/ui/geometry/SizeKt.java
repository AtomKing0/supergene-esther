package androidx.compose.ui.geometry;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;
import h9.a;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Size.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SizeKt {
    @Stable
    public static final long Size(float f10, float f11) {
        return Size.m1427constructorimpl((((long) Float.floatToIntBits(f11)) & 4294967295L) | (Float.floatToIntBits(f10) << 32));
    }

    /* JADX INFO: renamed from: getCenter-uvyYCjk, reason: not valid java name */
    public static final long m1446getCenteruvyYCjk(long j10) {
        return OffsetKt.Offset(Size.m1436getWidthimpl(j10) / 2.0f, Size.m1433getHeightimpl(j10) / 2.0f);
    }

    /* JADX INFO: renamed from: isSpecified-uvyYCjk, reason: not valid java name */
    public static final boolean m1448isSpecifieduvyYCjk(long j10) {
        return j10 != Size.Companion.m1444getUnspecifiedNHjbRc();
    }

    /* JADX INFO: renamed from: isUnspecified-uvyYCjk, reason: not valid java name */
    public static final boolean m1450isUnspecifieduvyYCjk(long j10) {
        return j10 == Size.Companion.m1444getUnspecifiedNHjbRc();
    }

    @Stable
    /* JADX INFO: renamed from: lerp-VgWVRYQ, reason: not valid java name */
    public static final long m1452lerpVgWVRYQ(long j10, long j11, float f10) {
        return Size(MathHelpersKt.lerp(Size.m1436getWidthimpl(j10), Size.m1436getWidthimpl(j11), f10), MathHelpersKt.lerp(Size.m1433getHeightimpl(j10), Size.m1433getHeightimpl(j11), f10));
    }

    /* JADX INFO: renamed from: takeOrElse-TmRCtEA, reason: not valid java name */
    public static final long m1453takeOrElseTmRCtEA(long j10, @NotNull a<Size> block) {
        t.i(block, "block");
        return (j10 > Size.Companion.m1444getUnspecifiedNHjbRc() ? 1 : (j10 == Size.Companion.m1444getUnspecifiedNHjbRc() ? 0 : -1)) != 0 ? j10 : block.invoke().m1441unboximpl();
    }

    @Stable
    /* JADX INFO: renamed from: times-d16Qtg0, reason: not valid java name */
    public static final long m1456timesd16Qtg0(int i10, long j10) {
        return Size.m1439times7Ah8Wj8(j10, i10);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: toRect-uvyYCjk, reason: not valid java name */
    public static final Rect m1457toRectuvyYCjk(long j10) {
        return RectKt.m1407Recttz77jQw(Offset.Companion.m1383getZeroF1C5BW0(), j10);
    }

    @Stable
    /* JADX INFO: renamed from: times-d16Qtg0, reason: not valid java name */
    public static final long m1454timesd16Qtg0(double d10, long j10) {
        return Size.m1439times7Ah8Wj8(j10, (float) d10);
    }

    @Stable
    /* JADX INFO: renamed from: times-d16Qtg0, reason: not valid java name */
    public static final long m1455timesd16Qtg0(float f10, long j10) {
        return Size.m1439times7Ah8Wj8(j10, f10);
    }

    @Stable
    /* JADX INFO: renamed from: getCenter-uvyYCjk$annotations, reason: not valid java name */
    public static /* synthetic */ void m1447getCenteruvyYCjk$annotations(long j10) {
    }

    @Stable
    /* JADX INFO: renamed from: isSpecified-uvyYCjk$annotations, reason: not valid java name */
    public static /* synthetic */ void m1449isSpecifieduvyYCjk$annotations(long j10) {
    }

    @Stable
    /* JADX INFO: renamed from: isUnspecified-uvyYCjk$annotations, reason: not valid java name */
    public static /* synthetic */ void m1451isUnspecifieduvyYCjk$annotations(long j10) {
    }
}
