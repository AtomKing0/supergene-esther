package androidx.compose.ui.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ScaleFactor.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ScaleFactorKt {
    @Stable
    public static final long ScaleFactor(float f10, float f11) {
        return ScaleFactor.m3030constructorimpl((((long) Float.floatToIntBits(f11)) & 4294967295L) | (Float.floatToIntBits(f10) << 32));
    }

    @Stable
    /* JADX INFO: renamed from: div-UQTWf7w, reason: not valid java name */
    public static final long m3044divUQTWf7w(long j10, long j11) {
        return SizeKt.Size(Size.m1436getWidthimpl(j10) / ScaleFactor.m3036getScaleXimpl(j11), Size.m1433getHeightimpl(j10) / ScaleFactor.m3037getScaleYimpl(j11));
    }

    /* JADX INFO: renamed from: isSpecified-FK8aYYs, reason: not valid java name */
    public static final boolean m3045isSpecifiedFK8aYYs(long j10) {
        return j10 != ScaleFactor.Companion.m3043getUnspecified_hLwfpc();
    }

    /* JADX INFO: renamed from: isUnspecified-FK8aYYs, reason: not valid java name */
    public static final boolean m3047isUnspecifiedFK8aYYs(long j10) {
        return j10 == ScaleFactor.Companion.m3043getUnspecified_hLwfpc();
    }

    @Stable
    /* JADX INFO: renamed from: lerp--bDIf60, reason: not valid java name */
    public static final long m3049lerpbDIf60(long j10, long j11, float f10) {
        return ScaleFactor(MathHelpersKt.lerp(ScaleFactor.m3036getScaleXimpl(j10), ScaleFactor.m3036getScaleXimpl(j11), f10), MathHelpersKt.lerp(ScaleFactor.m3037getScaleYimpl(j10), ScaleFactor.m3037getScaleYimpl(j11), f10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float roundToTenths(float f10) {
        float f11 = 10;
        float f12 = f10 * f11;
        int i10 = (int) f12;
        if (f12 - i10 >= 0.5f) {
            i10++;
        }
        return i10 / f11;
    }

    /* JADX INFO: renamed from: takeOrElse-oyDd2qo, reason: not valid java name */
    public static final long m3050takeOrElseoyDd2qo(long j10, @NotNull h9.a<ScaleFactor> block) {
        t.i(block, "block");
        return (j10 > ScaleFactor.Companion.m3043getUnspecified_hLwfpc() ? 1 : (j10 == ScaleFactor.Companion.m3043getUnspecified_hLwfpc() ? 0 : -1)) != 0 ? j10 : block.invoke().m3041unboximpl();
    }

    @Stable
    /* JADX INFO: renamed from: times-UQTWf7w, reason: not valid java name */
    public static final long m3051timesUQTWf7w(long j10, long j11) {
        return SizeKt.Size(Size.m1436getWidthimpl(j10) * ScaleFactor.m3036getScaleXimpl(j11), Size.m1433getHeightimpl(j10) * ScaleFactor.m3037getScaleYimpl(j11));
    }

    @Stable
    /* JADX INFO: renamed from: times-m-w2e94, reason: not valid java name */
    public static final long m3052timesmw2e94(long j10, long j11) {
        return m3051timesUQTWf7w(j11, j10);
    }

    @Stable
    /* JADX INFO: renamed from: isSpecified-FK8aYYs$annotations, reason: not valid java name */
    public static /* synthetic */ void m3046isSpecifiedFK8aYYs$annotations(long j10) {
    }

    @Stable
    /* JADX INFO: renamed from: isUnspecified-FK8aYYs$annotations, reason: not valid java name */
    public static /* synthetic */ void m3048isUnspecifiedFK8aYYs$annotations(long j10) {
    }
}
