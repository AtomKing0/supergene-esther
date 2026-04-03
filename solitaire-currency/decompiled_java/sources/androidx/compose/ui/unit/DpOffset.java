package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Dp.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class DpOffset {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long Unspecified;
    private static final long Zero;
    private final long packedValue;

    /* JADX INFO: compiled from: Dp.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getUnspecified-RKDOV3M, reason: not valid java name */
        public final long m3743getUnspecifiedRKDOV3M() {
            return DpOffset.Unspecified;
        }

        /* JADX INFO: renamed from: getZero-RKDOV3M, reason: not valid java name */
        public final long m3744getZeroRKDOV3M() {
            return DpOffset.Zero;
        }
    }

    static {
        float f10 = 0;
        Zero = DpKt.m3694DpOffsetYgX7TsA(Dp.m3673constructorimpl(f10), Dp.m3673constructorimpl(f10));
        Dp.Companion companion = Dp.Companion;
        Unspecified = DpKt.m3694DpOffsetYgX7TsA(companion.m3693getUnspecifiedD9Ej5fM(), companion.m3693getUnspecifiedD9Ej5fM());
    }

    private /* synthetic */ DpOffset(long j10) {
        this.packedValue = j10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DpOffset m3728boximpl(long j10) {
        return new DpOffset(j10);
    }

    /* JADX INFO: renamed from: copy-tPigGR8, reason: not valid java name */
    public static final long m3730copytPigGR8(long j10, float f10, float f11) {
        return DpKt.m3694DpOffsetYgX7TsA(f10, f11);
    }

    /* JADX INFO: renamed from: copy-tPigGR8$default, reason: not valid java name */
    public static /* synthetic */ long m3731copytPigGR8$default(long j10, float f10, float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = m3734getXD9Ej5fM(j10);
        }
        if ((i10 & 2) != 0) {
            f11 = m3736getYD9Ej5fM(j10);
        }
        return m3730copytPigGR8(j10, f10, f11);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3732equalsimpl(long j10, Object obj) {
        return (obj instanceof DpOffset) && j10 == ((DpOffset) obj).m3742unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3733equalsimpl0(long j10, long j11) {
        return j10 == j11;
    }

    /* JADX INFO: renamed from: getX-D9Ej5fM, reason: not valid java name */
    public static final float m3734getXD9Ej5fM(long j10) {
        if (!(j10 != Unspecified)) {
            throw new IllegalStateException("DpOffset is unspecified".toString());
        }
        m mVar = m.f29832a;
        return Dp.m3673constructorimpl(Float.intBitsToFloat((int) (j10 >> 32)));
    }

    /* JADX INFO: renamed from: getY-D9Ej5fM, reason: not valid java name */
    public static final float m3736getYD9Ej5fM(long j10) {
        if (!(j10 != Unspecified)) {
            throw new IllegalStateException("DpOffset is unspecified".toString());
        }
        m mVar = m.f29832a;
        return Dp.m3673constructorimpl(Float.intBitsToFloat((int) (j10 & 4294967295L)));
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3738hashCodeimpl(long j10) {
        return androidx.compose.animation.a.a(j10);
    }

    @Stable
    /* JADX INFO: renamed from: minus-CB-Mgk4, reason: not valid java name */
    public static final long m3739minusCBMgk4(long j10, long j11) {
        return DpKt.m3694DpOffsetYgX7TsA(Dp.m3673constructorimpl(m3734getXD9Ej5fM(j10) - m3734getXD9Ej5fM(j11)), Dp.m3673constructorimpl(m3736getYD9Ej5fM(j10) - m3736getYD9Ej5fM(j11)));
    }

    @Stable
    /* JADX INFO: renamed from: plus-CB-Mgk4, reason: not valid java name */
    public static final long m3740plusCBMgk4(long j10, long j11) {
        return DpKt.m3694DpOffsetYgX7TsA(Dp.m3673constructorimpl(m3734getXD9Ej5fM(j10) + m3734getXD9Ej5fM(j11)), Dp.m3673constructorimpl(m3736getYD9Ej5fM(j10) + m3736getYD9Ej5fM(j11)));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3741toStringimpl(long j10) {
        if (!(j10 != Companion.m3743getUnspecifiedRKDOV3M())) {
            return "DpOffset.Unspecified";
        }
        return '(' + ((Object) Dp.m3684toStringimpl(m3734getXD9Ej5fM(j10))) + ", " + ((Object) Dp.m3684toStringimpl(m3736getYD9Ej5fM(j10))) + ')';
    }

    public boolean equals(Object obj) {
        return m3732equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m3738hashCodeimpl(this.packedValue);
    }

    @Stable
    @NotNull
    public String toString() {
        return m3741toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m3742unboximpl() {
        return this.packedValue;
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    @Stable
    /* JADX INFO: renamed from: getX-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3735getXD9Ej5fM$annotations() {
    }

    @Stable
    /* JADX INFO: renamed from: getY-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3737getYD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m3729constructorimpl(long j10) {
        return j10;
    }
}
