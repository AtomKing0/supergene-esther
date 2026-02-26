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
public final class DpSize {

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

        /* JADX INFO: renamed from: getUnspecified-MYxV2XQ, reason: not valid java name */
        public final long m3780getUnspecifiedMYxV2XQ() {
            return DpSize.Unspecified;
        }

        /* JADX INFO: renamed from: getZero-MYxV2XQ, reason: not valid java name */
        public final long m3781getZeroMYxV2XQ() {
            return DpSize.Zero;
        }
    }

    static {
        float f10 = 0;
        Zero = DpKt.m3695DpSizeYgX7TsA(Dp.m3673constructorimpl(f10), Dp.m3673constructorimpl(f10));
        Dp.Companion companion = Dp.Companion;
        Unspecified = DpKt.m3695DpSizeYgX7TsA(companion.m3693getUnspecifiedD9Ej5fM(), companion.m3693getUnspecifiedD9Ej5fM());
    }

    private /* synthetic */ DpSize(long j10) {
        this.packedValue = j10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DpSize m3759boximpl(long j10) {
        return new DpSize(j10);
    }

    @Stable
    /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name */
    public static final float m3760component1D9Ej5fM(long j10) {
        return m3771getWidthD9Ej5fM(j10);
    }

    @Stable
    /* JADX INFO: renamed from: component2-D9Ej5fM, reason: not valid java name */
    public static final float m3761component2D9Ej5fM(long j10) {
        return m3769getHeightD9Ej5fM(j10);
    }

    /* JADX INFO: renamed from: copy-DwJknco, reason: not valid java name */
    public static final long m3763copyDwJknco(long j10, float f10, float f11) {
        return DpKt.m3695DpSizeYgX7TsA(f10, f11);
    }

    /* JADX INFO: renamed from: copy-DwJknco$default, reason: not valid java name */
    public static /* synthetic */ long m3764copyDwJknco$default(long j10, float f10, float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = m3771getWidthD9Ej5fM(j10);
        }
        if ((i10 & 2) != 0) {
            f11 = m3769getHeightD9Ej5fM(j10);
        }
        return m3763copyDwJknco(j10, f10, f11);
    }

    @Stable
    /* JADX INFO: renamed from: div-Gh9hcWk, reason: not valid java name */
    public static final long m3766divGh9hcWk(long j10, int i10) {
        float f10 = i10;
        return DpKt.m3695DpSizeYgX7TsA(Dp.m3673constructorimpl(m3771getWidthD9Ej5fM(j10) / f10), Dp.m3673constructorimpl(m3769getHeightD9Ej5fM(j10) / f10));
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3767equalsimpl(long j10, Object obj) {
        return (obj instanceof DpSize) && j10 == ((DpSize) obj).m3779unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3768equalsimpl0(long j10, long j11) {
        return j10 == j11;
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public static final float m3769getHeightD9Ej5fM(long j10) {
        if (!(j10 != Unspecified)) {
            throw new IllegalStateException("DpSize is unspecified".toString());
        }
        m mVar = m.f29832a;
        return Dp.m3673constructorimpl(Float.intBitsToFloat((int) (j10 & 4294967295L)));
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public static final float m3771getWidthD9Ej5fM(long j10) {
        if (!(j10 != Unspecified)) {
            throw new IllegalStateException("DpSize is unspecified".toString());
        }
        m mVar = m.f29832a;
        return Dp.m3673constructorimpl(Float.intBitsToFloat((int) (j10 >> 32)));
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3773hashCodeimpl(long j10) {
        return androidx.compose.animation.a.a(j10);
    }

    @Stable
    /* JADX INFO: renamed from: minus-e_xh8Ic, reason: not valid java name */
    public static final long m3774minuse_xh8Ic(long j10, long j11) {
        return DpKt.m3695DpSizeYgX7TsA(Dp.m3673constructorimpl(m3771getWidthD9Ej5fM(j10) - m3771getWidthD9Ej5fM(j11)), Dp.m3673constructorimpl(m3769getHeightD9Ej5fM(j10) - m3769getHeightD9Ej5fM(j11)));
    }

    @Stable
    /* JADX INFO: renamed from: plus-e_xh8Ic, reason: not valid java name */
    public static final long m3775pluse_xh8Ic(long j10, long j11) {
        return DpKt.m3695DpSizeYgX7TsA(Dp.m3673constructorimpl(m3771getWidthD9Ej5fM(j10) + m3771getWidthD9Ej5fM(j11)), Dp.m3673constructorimpl(m3769getHeightD9Ej5fM(j10) + m3769getHeightD9Ej5fM(j11)));
    }

    @Stable
    /* JADX INFO: renamed from: times-Gh9hcWk, reason: not valid java name */
    public static final long m3777timesGh9hcWk(long j10, int i10) {
        float f10 = i10;
        return DpKt.m3695DpSizeYgX7TsA(Dp.m3673constructorimpl(m3771getWidthD9Ej5fM(j10) * f10), Dp.m3673constructorimpl(m3769getHeightD9Ej5fM(j10) * f10));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3778toStringimpl(long j10) {
        if (!(j10 != Companion.m3780getUnspecifiedMYxV2XQ())) {
            return "DpSize.Unspecified";
        }
        return ((Object) Dp.m3684toStringimpl(m3771getWidthD9Ej5fM(j10))) + " x " + ((Object) Dp.m3684toStringimpl(m3769getHeightD9Ej5fM(j10)));
    }

    public boolean equals(Object obj) {
        return m3767equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m3773hashCodeimpl(this.packedValue);
    }

    @Stable
    @NotNull
    public String toString() {
        return m3778toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m3779unboximpl() {
        return this.packedValue;
    }

    @Stable
    /* JADX INFO: renamed from: div-Gh9hcWk, reason: not valid java name */
    public static final long m3765divGh9hcWk(long j10, float f10) {
        return DpKt.m3695DpSizeYgX7TsA(Dp.m3673constructorimpl(m3771getWidthD9Ej5fM(j10) / f10), Dp.m3673constructorimpl(m3769getHeightD9Ej5fM(j10) / f10));
    }

    @Stable
    /* JADX INFO: renamed from: times-Gh9hcWk, reason: not valid java name */
    public static final long m3776timesGh9hcWk(long j10, float f10) {
        return DpKt.m3695DpSizeYgX7TsA(Dp.m3673constructorimpl(m3771getWidthD9Ej5fM(j10) * f10), Dp.m3673constructorimpl(m3769getHeightD9Ej5fM(j10) * f10));
    }

    @Stable
    /* JADX INFO: renamed from: getHeight-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3770getHeightD9Ej5fM$annotations() {
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    @Stable
    /* JADX INFO: renamed from: getWidth-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3772getWidthD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m3762constructorimpl(long j10) {
        return j10;
    }
}
