package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Velocity.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class Velocity {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long Zero = VelocityKt.Velocity(0.0f, 0.0f);
    private final long packedValue;

    private /* synthetic */ Velocity(long j10) {
        this.packedValue = j10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Velocity m3889boximpl(long j10) {
        return new Velocity(j10);
    }

    @Stable
    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final float m3890component1impl(long j10) {
        return m3898getXimpl(j10);
    }

    @Stable
    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final float m3891component2impl(long j10) {
        return m3899getYimpl(j10);
    }

    /* JADX INFO: renamed from: copy-OhffZ5M, reason: not valid java name */
    public static final long m3893copyOhffZ5M(long j10, float f10, float f11) {
        return VelocityKt.Velocity(f10, f11);
    }

    /* JADX INFO: renamed from: copy-OhffZ5M$default, reason: not valid java name */
    public static /* synthetic */ long m3894copyOhffZ5M$default(long j10, float f10, float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = m3898getXimpl(j10);
        }
        if ((i10 & 2) != 0) {
            f11 = m3899getYimpl(j10);
        }
        return m3893copyOhffZ5M(j10, f10, f11);
    }

    @Stable
    /* JADX INFO: renamed from: div-adjELrA, reason: not valid java name */
    public static final long m3895divadjELrA(long j10, float f10) {
        return VelocityKt.Velocity(m3898getXimpl(j10) / f10, m3899getYimpl(j10) / f10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3896equalsimpl(long j10, Object obj) {
        return (obj instanceof Velocity) && j10 == ((Velocity) obj).m3907unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3897equalsimpl0(long j10, long j11) {
        return j10 == j11;
    }

    /* JADX INFO: renamed from: getX-impl, reason: not valid java name */
    public static final float m3898getXimpl(long j10) {
        m mVar = m.f29832a;
        return Float.intBitsToFloat((int) (j10 >> 32));
    }

    /* JADX INFO: renamed from: getY-impl, reason: not valid java name */
    public static final float m3899getYimpl(long j10) {
        m mVar = m.f29832a;
        return Float.intBitsToFloat((int) (j10 & 4294967295L));
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3900hashCodeimpl(long j10) {
        return androidx.compose.animation.a.a(j10);
    }

    @Stable
    /* JADX INFO: renamed from: minus-AH228Gc, reason: not valid java name */
    public static final long m3901minusAH228Gc(long j10, long j11) {
        return VelocityKt.Velocity(m3898getXimpl(j10) - m3898getXimpl(j11), m3899getYimpl(j10) - m3899getYimpl(j11));
    }

    @Stable
    /* JADX INFO: renamed from: plus-AH228Gc, reason: not valid java name */
    public static final long m3902plusAH228Gc(long j10, long j11) {
        return VelocityKt.Velocity(m3898getXimpl(j10) + m3898getXimpl(j11), m3899getYimpl(j10) + m3899getYimpl(j11));
    }

    @Stable
    /* JADX INFO: renamed from: rem-adjELrA, reason: not valid java name */
    public static final long m3903remadjELrA(long j10, float f10) {
        return VelocityKt.Velocity(m3898getXimpl(j10) % f10, m3899getYimpl(j10) % f10);
    }

    @Stable
    /* JADX INFO: renamed from: times-adjELrA, reason: not valid java name */
    public static final long m3904timesadjELrA(long j10, float f10) {
        return VelocityKt.Velocity(m3898getXimpl(j10) * f10, m3899getYimpl(j10) * f10);
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3905toStringimpl(long j10) {
        return '(' + m3898getXimpl(j10) + ", " + m3899getYimpl(j10) + ") px/sec";
    }

    @Stable
    /* JADX INFO: renamed from: unaryMinus-9UxMQ8M, reason: not valid java name */
    public static final long m3906unaryMinus9UxMQ8M(long j10) {
        return VelocityKt.Velocity(-m3898getXimpl(j10), -m3899getYimpl(j10));
    }

    public boolean equals(Object obj) {
        return m3896equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m3900hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m3905toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m3907unboximpl() {
        return this.packedValue;
    }

    /* JADX INFO: compiled from: Velocity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getZero-9UxMQ8M, reason: not valid java name */
        public final long m3909getZero9UxMQ8M() {
            return Velocity.Zero;
        }

        @Stable
        /* JADX INFO: renamed from: getZero-9UxMQ8M$annotations, reason: not valid java name */
        public static /* synthetic */ void m3908getZero9UxMQ8M$annotations() {
        }
    }

    @Stable
    public static /* synthetic */ void getX$annotations() {
    }

    @Stable
    public static /* synthetic */ void getY$annotations() {
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m3892constructorimpl(long j10) {
        return j10;
    }
}
