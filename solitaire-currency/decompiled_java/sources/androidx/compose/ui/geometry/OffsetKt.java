package androidx.compose.ui.geometry;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;
import h9.a;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Offset.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OffsetKt {
    @Stable
    public static final long Offset(float f10, float f11) {
        return Offset.m1359constructorimpl((((long) Float.floatToIntBits(f11)) & 4294967295L) | (Float.floatToIntBits(f10) << 32));
    }

    /* JADX INFO: renamed from: isFinite-k-4lQ0M, reason: not valid java name */
    public static final boolean m1384isFinitek4lQ0M(long j10) {
        float fM1367getXimpl = Offset.m1367getXimpl(j10);
        if ((Float.isInfinite(fM1367getXimpl) || Float.isNaN(fM1367getXimpl)) ? false : true) {
            float fM1368getYimpl = Offset.m1368getYimpl(j10);
            if ((Float.isInfinite(fM1368getYimpl) || Float.isNaN(fM1368getYimpl)) ? false : true) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: isSpecified-k-4lQ0M, reason: not valid java name */
    public static final boolean m1386isSpecifiedk4lQ0M(long j10) {
        return j10 != Offset.Companion.m1382getUnspecifiedF1C5BW0();
    }

    /* JADX INFO: renamed from: isUnspecified-k-4lQ0M, reason: not valid java name */
    public static final boolean m1388isUnspecifiedk4lQ0M(long j10) {
        return j10 == Offset.Companion.m1382getUnspecifiedF1C5BW0();
    }

    @Stable
    /* JADX INFO: renamed from: lerp-Wko1d7g, reason: not valid java name */
    public static final long m1390lerpWko1d7g(long j10, long j11, float f10) {
        return Offset(MathHelpersKt.lerp(Offset.m1367getXimpl(j10), Offset.m1367getXimpl(j11), f10), MathHelpersKt.lerp(Offset.m1368getYimpl(j10), Offset.m1368getYimpl(j11), f10));
    }

    /* JADX INFO: renamed from: takeOrElse-3MmeM6k, reason: not valid java name */
    public static final long m1391takeOrElse3MmeM6k(long j10, @NotNull a<Offset> block) {
        t.i(block, "block");
        return m1386isSpecifiedk4lQ0M(j10) ? j10 : block.invoke().m1377unboximpl();
    }

    @Stable
    /* JADX INFO: renamed from: isFinite-k-4lQ0M$annotations, reason: not valid java name */
    public static /* synthetic */ void m1385isFinitek4lQ0M$annotations(long j10) {
    }

    @Stable
    /* JADX INFO: renamed from: isSpecified-k-4lQ0M$annotations, reason: not valid java name */
    public static /* synthetic */ void m1387isSpecifiedk4lQ0M$annotations(long j10) {
    }

    @Stable
    /* JADX INFO: renamed from: isUnspecified-k-4lQ0M$annotations, reason: not valid java name */
    public static /* synthetic */ void m1389isUnspecifiedk4lQ0M$annotations(long j10) {
    }
}
