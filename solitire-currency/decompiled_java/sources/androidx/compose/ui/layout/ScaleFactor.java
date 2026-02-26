package androidx.compose.ui.layout;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.m;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ScaleFactor.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class ScaleFactor {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long Unspecified = ScaleFactorKt.ScaleFactor(Float.NaN, Float.NaN);
    private final long packedValue;

    private /* synthetic */ ScaleFactor(long j10) {
        this.packedValue = j10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ScaleFactor m3027boximpl(long j10) {
        return new ScaleFactor(j10);
    }

    @Stable
    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final float m3028component1impl(long j10) {
        return m3036getScaleXimpl(j10);
    }

    @Stable
    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final float m3029component2impl(long j10) {
        return m3037getScaleYimpl(j10);
    }

    /* JADX INFO: renamed from: copy-8GGzs04, reason: not valid java name */
    public static final long m3031copy8GGzs04(long j10, float f10, float f11) {
        return ScaleFactorKt.ScaleFactor(f10, f11);
    }

    /* JADX INFO: renamed from: copy-8GGzs04$default, reason: not valid java name */
    public static /* synthetic */ long m3032copy8GGzs04$default(long j10, float f10, float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = m3036getScaleXimpl(j10);
        }
        if ((i10 & 2) != 0) {
            f11 = m3037getScaleYimpl(j10);
        }
        return m3031copy8GGzs04(j10, f10, f11);
    }

    @Stable
    /* JADX INFO: renamed from: div-44nBxM0, reason: not valid java name */
    public static final long m3033div44nBxM0(long j10, float f10) {
        return ScaleFactorKt.ScaleFactor(m3036getScaleXimpl(j10) / f10, m3037getScaleYimpl(j10) / f10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3034equalsimpl(long j10, Object obj) {
        return (obj instanceof ScaleFactor) && j10 == ((ScaleFactor) obj).m3041unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3035equalsimpl0(long j10, long j11) {
        return j10 == j11;
    }

    /* JADX INFO: renamed from: getScaleX-impl, reason: not valid java name */
    public static final float m3036getScaleXimpl(long j10) {
        if (!(j10 != Unspecified)) {
            throw new IllegalStateException("ScaleFactor is unspecified".toString());
        }
        m mVar = m.f29832a;
        return Float.intBitsToFloat((int) (j10 >> 32));
    }

    /* JADX INFO: renamed from: getScaleY-impl, reason: not valid java name */
    public static final float m3037getScaleYimpl(long j10) {
        if (!(j10 != Unspecified)) {
            throw new IllegalStateException("ScaleFactor is unspecified".toString());
        }
        m mVar = m.f29832a;
        return Float.intBitsToFloat((int) (j10 & 4294967295L));
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3038hashCodeimpl(long j10) {
        return androidx.compose.animation.a.a(j10);
    }

    @Stable
    /* JADX INFO: renamed from: times-44nBxM0, reason: not valid java name */
    public static final long m3039times44nBxM0(long j10, float f10) {
        return ScaleFactorKt.ScaleFactor(m3036getScaleXimpl(j10) * f10, m3037getScaleYimpl(j10) * f10);
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3040toStringimpl(long j10) {
        return "ScaleFactor(" + ScaleFactorKt.roundToTenths(m3036getScaleXimpl(j10)) + ", " + ScaleFactorKt.roundToTenths(m3037getScaleYimpl(j10)) + ')';
    }

    public boolean equals(Object obj) {
        return m3034equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m3038hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m3040toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m3041unboximpl() {
        return this.packedValue;
    }

    /* JADX INFO: compiled from: ScaleFactor.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getUnspecified-_hLwfpc, reason: not valid java name */
        public final long m3043getUnspecified_hLwfpc() {
            return ScaleFactor.Unspecified;
        }

        @Stable
        /* JADX INFO: renamed from: getUnspecified-_hLwfpc$annotations, reason: not valid java name */
        public static /* synthetic */ void m3042getUnspecified_hLwfpc$annotations() {
        }
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    @Stable
    public static /* synthetic */ void getScaleX$annotations() {
    }

    @Stable
    public static /* synthetic */ void getScaleY$annotations() {
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m3030constructorimpl(long j10) {
        return j10;
    }
}
