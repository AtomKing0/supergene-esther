package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextUnit.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class TextUnit {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final TextUnitType[] TextUnitTypes;
    private static final long Unspecified;
    private final long packedValue;

    static {
        TextUnitType.Companion companion = TextUnitType.Companion;
        TextUnitTypes = new TextUnitType[]{TextUnitType.m3879boximpl(companion.m3888getUnspecifiedUIouoOA()), TextUnitType.m3879boximpl(companion.m3887getSpUIouoOA()), TextUnitType.m3879boximpl(companion.m3886getEmUIouoOA())};
        Unspecified = TextUnitKt.pack(0L, Float.NaN);
    }

    private /* synthetic */ TextUnit(long j10) {
        this.packedValue = j10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextUnit m3844boximpl(long j10) {
        return new TextUnit(j10);
    }

    /* JADX INFO: renamed from: compareTo--R2X_6o, reason: not valid java name */
    public static final int m3845compareToR2X_6o(long j10, long j11) {
        TextUnitKt.m3868checkArithmeticNB67dxo(j10, j11);
        return Float.compare(m3854getValueimpl(j10), m3854getValueimpl(j11));
    }

    /* JADX INFO: renamed from: div-kPz2Gy4, reason: not valid java name */
    public static final long m3848divkPz2Gy4(long j10, float f10) {
        TextUnitKt.m3867checkArithmeticR2X_6o(j10);
        return TextUnitKt.pack(m3852getRawTypeimpl(j10), m3854getValueimpl(j10) / f10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3850equalsimpl(long j10, Object obj) {
        return (obj instanceof TextUnit) && j10 == ((TextUnit) obj).m3863unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3851equalsimpl0(long j10, long j11) {
        return j10 == j11;
    }

    /* JADX INFO: renamed from: getRawType-impl, reason: not valid java name */
    public static final long m3852getRawTypeimpl(long j10) {
        return j10 & 1095216660480L;
    }

    /* JADX INFO: renamed from: getType-UIouoOA, reason: not valid java name */
    public static final long m3853getTypeUIouoOA(long j10) {
        return TextUnitTypes[(int) (m3852getRawTypeimpl(j10) >>> 32)].m3885unboximpl();
    }

    /* JADX INFO: renamed from: getValue-impl, reason: not valid java name */
    public static final float m3854getValueimpl(long j10) {
        m mVar = m.f29832a;
        return Float.intBitsToFloat((int) (j10 & 4294967295L));
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3855hashCodeimpl(long j10) {
        return androidx.compose.animation.a.a(j10);
    }

    /* JADX INFO: renamed from: isEm-impl, reason: not valid java name */
    public static final boolean m3856isEmimpl(long j10) {
        return m3852getRawTypeimpl(j10) == 8589934592L;
    }

    /* JADX INFO: renamed from: isSp-impl, reason: not valid java name */
    public static final boolean m3857isSpimpl(long j10) {
        return m3852getRawTypeimpl(j10) == 4294967296L;
    }

    /* JADX INFO: renamed from: times-kPz2Gy4, reason: not valid java name */
    public static final long m3859timeskPz2Gy4(long j10, float f10) {
        TextUnitKt.m3867checkArithmeticR2X_6o(j10);
        return TextUnitKt.pack(m3852getRawTypeimpl(j10), m3854getValueimpl(j10) * f10);
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3861toStringimpl(long j10) {
        long jM3853getTypeUIouoOA = m3853getTypeUIouoOA(j10);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m3882equalsimpl0(jM3853getTypeUIouoOA, companion.m3888getUnspecifiedUIouoOA())) {
            return "Unspecified";
        }
        if (TextUnitType.m3882equalsimpl0(jM3853getTypeUIouoOA, companion.m3887getSpUIouoOA())) {
            return m3854getValueimpl(j10) + ".sp";
        }
        if (!TextUnitType.m3882equalsimpl0(jM3853getTypeUIouoOA, companion.m3886getEmUIouoOA())) {
            return "Invalid";
        }
        return m3854getValueimpl(j10) + ".em";
    }

    /* JADX INFO: renamed from: unaryMinus-XSAIIZE, reason: not valid java name */
    public static final long m3862unaryMinusXSAIIZE(long j10) {
        TextUnitKt.m3867checkArithmeticR2X_6o(j10);
        return TextUnitKt.pack(m3852getRawTypeimpl(j10), -m3854getValueimpl(j10));
    }

    public boolean equals(Object obj) {
        return m3850equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m3855hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m3861toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m3863unboximpl() {
        return this.packedValue;
    }

    /* JADX INFO: renamed from: div-kPz2Gy4, reason: not valid java name */
    public static final long m3847divkPz2Gy4(long j10, double d10) {
        TextUnitKt.m3867checkArithmeticR2X_6o(j10);
        return TextUnitKt.pack(m3852getRawTypeimpl(j10), (float) (((double) m3854getValueimpl(j10)) / d10));
    }

    /* JADX INFO: renamed from: times-kPz2Gy4, reason: not valid java name */
    public static final long m3858timeskPz2Gy4(long j10, double d10) {
        TextUnitKt.m3867checkArithmeticR2X_6o(j10);
        return TextUnitKt.pack(m3852getRawTypeimpl(j10), (float) (((double) m3854getValueimpl(j10)) * d10));
    }

    /* JADX INFO: renamed from: div-kPz2Gy4, reason: not valid java name */
    public static final long m3849divkPz2Gy4(long j10, int i10) {
        TextUnitKt.m3867checkArithmeticR2X_6o(j10);
        return TextUnitKt.pack(m3852getRawTypeimpl(j10), m3854getValueimpl(j10) / i10);
    }

    /* JADX INFO: renamed from: times-kPz2Gy4, reason: not valid java name */
    public static final long m3860timeskPz2Gy4(long j10, int i10) {
        TextUnitKt.m3867checkArithmeticR2X_6o(j10);
        return TextUnitKt.pack(m3852getRawTypeimpl(j10), m3854getValueimpl(j10) * i10);
    }

    /* JADX INFO: compiled from: TextUnit.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final TextUnitType[] getTextUnitTypes$ui_unit_release() {
            return TextUnit.TextUnitTypes;
        }

        /* JADX INFO: renamed from: getUnspecified-XSAIIZE, reason: not valid java name */
        public final long m3865getUnspecifiedXSAIIZE() {
            return TextUnit.Unspecified;
        }

        @Stable
        /* JADX INFO: renamed from: getUnspecified-XSAIIZE$annotations, reason: not valid java name */
        public static /* synthetic */ void m3864getUnspecifiedXSAIIZE$annotations() {
        }
    }

    public static /* synthetic */ void getRawType$annotations() {
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m3846constructorimpl(long j10) {
        return j10;
    }
}
