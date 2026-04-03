package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Dp.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class Dp implements Comparable<Dp> {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final float Hairline = m3673constructorimpl(0.0f);
    private static final float Infinity = m3673constructorimpl(Float.POSITIVE_INFINITY);
    private static final float Unspecified = m3673constructorimpl(Float.NaN);
    private final float value;

    private /* synthetic */ Dp(float f10) {
        this.value = f10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Dp m3671boximpl(float f10) {
        return new Dp(f10);
    }

    @Stable
    /* JADX INFO: renamed from: div-0680j_4, reason: not valid java name */
    public static final float m3674div0680j_4(float f10, float f11) {
        return f10 / f11;
    }

    @Stable
    /* JADX INFO: renamed from: div-u2uoSUM, reason: not valid java name */
    public static final float m3675divu2uoSUM(float f10, float f11) {
        return m3673constructorimpl(f10 / f11);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3677equalsimpl(float f10, Object obj) {
        if (obj instanceof Dp) {
            return t.d(Float.valueOf(f10), Float.valueOf(((Dp) obj).m3687unboximpl()));
        }
        return false;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3678equalsimpl0(float f10, float f11) {
        return t.d(Float.valueOf(f10), Float.valueOf(f11));
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3679hashCodeimpl(float f10) {
        return Float.floatToIntBits(f10);
    }

    @Stable
    /* JADX INFO: renamed from: minus-5rwHm24, reason: not valid java name */
    public static final float m3680minus5rwHm24(float f10, float f11) {
        return m3673constructorimpl(f10 - f11);
    }

    @Stable
    /* JADX INFO: renamed from: plus-5rwHm24, reason: not valid java name */
    public static final float m3681plus5rwHm24(float f10, float f11) {
        return m3673constructorimpl(f10 + f11);
    }

    @Stable
    /* JADX INFO: renamed from: times-u2uoSUM, reason: not valid java name */
    public static final float m3682timesu2uoSUM(float f10, float f11) {
        return m3673constructorimpl(f10 * f11);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3684toStringimpl(float f10) {
        if (Float.isNaN(f10)) {
            return "Dp.Unspecified";
        }
        return f10 + ".dp";
    }

    @Stable
    /* JADX INFO: renamed from: unaryMinus-D9Ej5fM, reason: not valid java name */
    public static final float m3685unaryMinusD9Ej5fM(float f10) {
        return m3673constructorimpl(-f10);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Dp dp) {
        return m3686compareTo0680j_4(dp.m3687unboximpl());
    }

    @Stable
    /* JADX INFO: renamed from: compareTo-0680j_4, reason: not valid java name */
    public int m3686compareTo0680j_4(float f10) {
        return m3672compareTo0680j_4(this.value, f10);
    }

    public boolean equals(Object obj) {
        return m3677equalsimpl(this.value, obj);
    }

    public final float getValue() {
        return this.value;
    }

    public int hashCode() {
        return m3679hashCodeimpl(this.value);
    }

    @Stable
    @NotNull
    public String toString() {
        return m3684toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float m3687unboximpl() {
        return this.value;
    }

    @Stable
    /* JADX INFO: renamed from: compareTo-0680j_4, reason: not valid java name */
    public static int m3672compareTo0680j_4(float f10, float f11) {
        return Float.compare(f10, f11);
    }

    @Stable
    /* JADX INFO: renamed from: div-u2uoSUM, reason: not valid java name */
    public static final float m3676divu2uoSUM(float f10, int i10) {
        return m3673constructorimpl(f10 / i10);
    }

    @Stable
    /* JADX INFO: renamed from: times-u2uoSUM, reason: not valid java name */
    public static final float m3683timesu2uoSUM(float f10, int i10) {
        return m3673constructorimpl(f10 * i10);
    }

    /* JADX INFO: compiled from: Dp.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getHairline-D9Ej5fM, reason: not valid java name */
        public final float m3691getHairlineD9Ej5fM() {
            return Dp.Hairline;
        }

        /* JADX INFO: renamed from: getInfinity-D9Ej5fM, reason: not valid java name */
        public final float m3692getInfinityD9Ej5fM() {
            return Dp.Infinity;
        }

        /* JADX INFO: renamed from: getUnspecified-D9Ej5fM, reason: not valid java name */
        public final float m3693getUnspecifiedD9Ej5fM() {
            return Dp.Unspecified;
        }

        @Stable
        /* JADX INFO: renamed from: getHairline-D9Ej5fM$annotations, reason: not valid java name */
        public static /* synthetic */ void m3688getHairlineD9Ej5fM$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getInfinity-D9Ej5fM$annotations, reason: not valid java name */
        public static /* synthetic */ void m3689getInfinityD9Ej5fM$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getUnspecified-D9Ej5fM$annotations, reason: not valid java name */
        public static /* synthetic */ void m3690getUnspecifiedD9Ej5fM$annotations() {
        }
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static float m3673constructorimpl(float f10) {
        return f10;
    }
}
