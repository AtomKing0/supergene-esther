package androidx.compose.ui.geometry;

import androidx.compose.animation.a;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CornerRadius.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class CornerRadius {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long Zero = CornerRadiusKt.CornerRadius$default(0.0f, 0.0f, 2, null);
    private final long packedValue;

    private /* synthetic */ CornerRadius(long j10) {
        this.packedValue = j10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ CornerRadius m1333boximpl(long j10) {
        return new CornerRadius(j10);
    }

    @Stable
    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final float m1334component1impl(long j10) {
        return m1342getXimpl(j10);
    }

    @Stable
    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final float m1335component2impl(long j10) {
        return m1343getYimpl(j10);
    }

    /* JADX INFO: renamed from: copy-OHQCggk, reason: not valid java name */
    public static final long m1337copyOHQCggk(long j10, float f10, float f11) {
        return CornerRadiusKt.CornerRadius(f10, f11);
    }

    /* JADX INFO: renamed from: copy-OHQCggk$default, reason: not valid java name */
    public static /* synthetic */ long m1338copyOHQCggk$default(long j10, float f10, float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = m1342getXimpl(j10);
        }
        if ((i10 & 2) != 0) {
            f11 = m1343getYimpl(j10);
        }
        return m1337copyOHQCggk(j10, f10, f11);
    }

    @Stable
    /* JADX INFO: renamed from: div-Bz7bX_o, reason: not valid java name */
    public static final long m1339divBz7bX_o(long j10, float f10) {
        return CornerRadiusKt.CornerRadius(m1342getXimpl(j10) / f10, m1343getYimpl(j10) / f10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1340equalsimpl(long j10, Object obj) {
        return (obj instanceof CornerRadius) && j10 == ((CornerRadius) obj).m1350unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1341equalsimpl0(long j10, long j11) {
        return j10 == j11;
    }

    /* JADX INFO: renamed from: getX-impl, reason: not valid java name */
    public static final float m1342getXimpl(long j10) {
        m mVar = m.f29832a;
        return Float.intBitsToFloat((int) (j10 >> 32));
    }

    /* JADX INFO: renamed from: getY-impl, reason: not valid java name */
    public static final float m1343getYimpl(long j10) {
        m mVar = m.f29832a;
        return Float.intBitsToFloat((int) (j10 & 4294967295L));
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1344hashCodeimpl(long j10) {
        return a.a(j10);
    }

    @Stable
    /* JADX INFO: renamed from: minus-vF7b-mM, reason: not valid java name */
    public static final long m1345minusvF7bmM(long j10, long j11) {
        return CornerRadiusKt.CornerRadius(m1342getXimpl(j10) - m1342getXimpl(j11), m1343getYimpl(j10) - m1343getYimpl(j11));
    }

    @Stable
    /* JADX INFO: renamed from: plus-vF7b-mM, reason: not valid java name */
    public static final long m1346plusvF7bmM(long j10, long j11) {
        return CornerRadiusKt.CornerRadius(m1342getXimpl(j10) + m1342getXimpl(j11), m1343getYimpl(j10) + m1343getYimpl(j11));
    }

    @Stable
    /* JADX INFO: renamed from: times-Bz7bX_o, reason: not valid java name */
    public static final long m1347timesBz7bX_o(long j10, float f10) {
        return CornerRadiusKt.CornerRadius(m1342getXimpl(j10) * f10, m1343getYimpl(j10) * f10);
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1348toStringimpl(long j10) {
        if (m1342getXimpl(j10) == m1343getYimpl(j10)) {
            return "CornerRadius.circular(" + GeometryUtilsKt.toStringAsFixed(m1342getXimpl(j10), 1) + ')';
        }
        return "CornerRadius.elliptical(" + GeometryUtilsKt.toStringAsFixed(m1342getXimpl(j10), 1) + ", " + GeometryUtilsKt.toStringAsFixed(m1343getYimpl(j10), 1) + ')';
    }

    @Stable
    /* JADX INFO: renamed from: unaryMinus-kKHJgLs, reason: not valid java name */
    public static final long m1349unaryMinuskKHJgLs(long j10) {
        return CornerRadiusKt.CornerRadius(-m1342getXimpl(j10), -m1343getYimpl(j10));
    }

    public boolean equals(Object obj) {
        return m1340equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m1344hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m1348toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m1350unboximpl() {
        return this.packedValue;
    }

    /* JADX INFO: compiled from: CornerRadius.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getZero-kKHJgLs, reason: not valid java name */
        public final long m1352getZerokKHJgLs() {
            return CornerRadius.Zero;
        }

        @Stable
        /* JADX INFO: renamed from: getZero-kKHJgLs$annotations, reason: not valid java name */
        public static /* synthetic */ void m1351getZerokKHJgLs$annotations() {
        }
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    @Stable
    public static /* synthetic */ void getX$annotations() {
    }

    @Stable
    public static /* synthetic */ void getY$annotations() {
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m1336constructorimpl(long j10) {
        return j10;
    }
}
