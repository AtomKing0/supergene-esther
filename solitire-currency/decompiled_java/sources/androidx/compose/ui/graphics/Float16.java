package androidx.compose.ui.graphics;

import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Float16.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Float16 implements Comparable<Float16> {
    private static final int FP16_COMBINED = 32767;
    private static final int FP16_EXPONENT_BIAS = 15;
    private static final int FP16_EXPONENT_MASK = 31;
    private static final int FP16_EXPONENT_MAX = 31744;
    private static final int FP16_EXPONENT_SHIFT = 10;
    private static final int FP16_SIGNIFICAND_MASK = 1023;
    private static final int FP16_SIGN_MASK = 32768;
    private static final int FP16_SIGN_SHIFT = 15;
    private static final float FP32_DENORMAL_FLOAT;
    private static final int FP32_DENORMAL_MAGIC = 1056964608;
    private static final int FP32_EXPONENT_BIAS = 127;
    private static final int FP32_EXPONENT_MASK = 255;
    private static final int FP32_EXPONENT_SHIFT = 23;
    private static final int FP32_QNAN_MASK = 4194304;
    private static final int FP32_SIGNIFICAND_MASK = 8388607;
    private static final int FP32_SIGN_SHIFT = 31;
    public static final int MaxExponent = 15;
    public static final int MinExponent = -14;
    public static final int Size = 16;
    private final short halfValue;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final short Epsilon = m1693constructorimpl((short) 5120);
    private static final short LowestValue = m1693constructorimpl((short) -1025);
    private static final short MaxValue = m1693constructorimpl((short) 31743);
    private static final short MinNormal = m1693constructorimpl(SilenceSkippingAudioProcessor.DEFAULT_SILENCE_THRESHOLD_LEVEL);
    private static final short MinValue = m1693constructorimpl((short) 1);
    private static final short NaN = m1693constructorimpl((short) 32256);
    private static final short NegativeInfinity = m1693constructorimpl((short) -1024);
    private static final short NegativeZero = m1693constructorimpl(Short.MIN_VALUE);
    private static final short PositiveInfinity = m1693constructorimpl((short) 31744);
    private static final short PositiveZero = m1693constructorimpl((short) 0);
    private static final short One = m1692constructorimpl(1.0f);
    private static final short NegativeOne = m1692constructorimpl(-1.0f);

    /* JADX INFO: compiled from: Float16.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final short floatToHalf(float f10) {
            int i10;
            int i11;
            int iFloatToRawIntBits = Float.floatToRawIntBits(f10);
            int i12 = iFloatToRawIntBits >>> 31;
            int i13 = (iFloatToRawIntBits >>> 23) & 255;
            int i14 = iFloatToRawIntBits & Float16.FP32_SIGNIFICAND_MASK;
            int i15 = 31;
            int i16 = 0;
            if (i13 == 255) {
                if (i14 != 0) {
                    i11 = 512;
                    i16 = i11;
                }
                i10 = (i12 << 15) | (i15 << 10) | i16;
            } else {
                int i17 = (i13 - 127) + 15;
                if (i17 >= 31) {
                    i15 = 49;
                } else if (i17 > 0) {
                    i16 = i14 >> 13;
                    if ((i14 & 4096) != 0) {
                        i10 = (((i17 << 10) | i16) + 1) | (i12 << 15);
                    } else {
                        i15 = i17;
                    }
                } else if (i17 >= -10) {
                    int i18 = (i14 | 8388608) >> (1 - i17);
                    if ((i18 & 4096) != 0) {
                        i18 += 8192;
                    }
                    i11 = i18 >> 13;
                    i15 = 0;
                    i16 = i11;
                } else {
                    i15 = 0;
                }
                i10 = (i12 << 15) | (i15 << 10) | i16;
            }
            return (short) i10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int toCompareValue(short s10) {
            return (s10 & Short.MIN_VALUE) != 0 ? 32768 - (s10 & 65535) : s10 & 65535;
        }

        /* JADX INFO: renamed from: getEpsilon-slo4al4, reason: not valid java name */
        public final short m1720getEpsilonslo4al4() {
            return Float16.Epsilon;
        }

        /* JADX INFO: renamed from: getLowestValue-slo4al4, reason: not valid java name */
        public final short m1721getLowestValueslo4al4() {
            return Float16.LowestValue;
        }

        /* JADX INFO: renamed from: getMaxValue-slo4al4, reason: not valid java name */
        public final short m1722getMaxValueslo4al4() {
            return Float16.MaxValue;
        }

        /* JADX INFO: renamed from: getMinNormal-slo4al4, reason: not valid java name */
        public final short m1723getMinNormalslo4al4() {
            return Float16.MinNormal;
        }

        /* JADX INFO: renamed from: getMinValue-slo4al4, reason: not valid java name */
        public final short m1724getMinValueslo4al4() {
            return Float16.MinValue;
        }

        /* JADX INFO: renamed from: getNaN-slo4al4, reason: not valid java name */
        public final short m1725getNaNslo4al4() {
            return Float16.NaN;
        }

        /* JADX INFO: renamed from: getNegativeInfinity-slo4al4, reason: not valid java name */
        public final short m1726getNegativeInfinityslo4al4() {
            return Float16.NegativeInfinity;
        }

        /* JADX INFO: renamed from: getNegativeZero-slo4al4, reason: not valid java name */
        public final short m1727getNegativeZeroslo4al4() {
            return Float16.NegativeZero;
        }

        /* JADX INFO: renamed from: getPositiveInfinity-slo4al4, reason: not valid java name */
        public final short m1728getPositiveInfinityslo4al4() {
            return Float16.PositiveInfinity;
        }

        /* JADX INFO: renamed from: getPositiveZero-slo4al4, reason: not valid java name */
        public final short m1729getPositiveZeroslo4al4() {
            return Float16.PositiveZero;
        }
    }

    static {
        kotlin.jvm.internal.m mVar = kotlin.jvm.internal.m.f29832a;
        FP32_DENORMAL_FLOAT = Float.intBitsToFloat(FP32_DENORMAL_MAGIC);
    }

    private /* synthetic */ Float16(short s10) {
        this.halfValue = s10;
    }

    /* JADX INFO: renamed from: absoluteValue-slo4al4, reason: not valid java name */
    public static final short m1687absoluteValueslo4al4(short s10) {
        return m1693constructorimpl((short) (s10 & Short.MAX_VALUE));
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Float16 m1688boximpl(short s10) {
        return new Float16(s10);
    }

    /* JADX INFO: renamed from: ceil-slo4al4, reason: not valid java name */
    public static final short m1689ceilslo4al4(short s10) {
        int i10 = s10 & 65535;
        int i11 = i10 & FP16_COMBINED;
        if (i11 < 15360) {
            i10 = ((-((~(i10 >> 15)) & (i11 == 0 ? 0 : 1))) & 15360) | (32768 & i10);
        } else if (i11 < 25600) {
            int i12 = (1 << (25 - (i11 >> 10))) - 1;
            i10 = (i10 + (i12 & ((i10 >> 15) - 1))) & (~i12);
        }
        return m1693constructorimpl((short) i10);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static short m1693constructorimpl(short s10) {
        return s10;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1694equalsimpl(short s10, Object obj) {
        return (obj instanceof Float16) && s10 == ((Float16) obj).m1719unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1695equalsimpl0(short s10, short s11) {
        return s10 == s11;
    }

    /* JADX INFO: renamed from: floor-slo4al4, reason: not valid java name */
    public static final short m1696floorslo4al4(short s10) {
        int i10 = s10 & 65535;
        int i11 = i10 & FP16_COMBINED;
        if (i11 < 15360) {
            i10 = ((i10 <= 32768 ? 0 : 65535) & 15360) | (i10 & 32768);
        } else if (i11 < 25600) {
            int i12 = (1 << (25 - (i11 >> 10))) - 1;
            i10 = (i10 + ((-(i10 >> 15)) & i12)) & (~i12);
        }
        return m1693constructorimpl((short) i10);
    }

    /* JADX INFO: renamed from: getExponent-impl, reason: not valid java name */
    public static final int m1697getExponentimpl(short s10) {
        return ((s10 >>> 10) & 31) - 15;
    }

    /* JADX INFO: renamed from: getSign-slo4al4, reason: not valid java name */
    public static final short m1698getSignslo4al4(short s10) {
        return m1703isNaNimpl(s10) ? NaN : m1690compareTo41bOqos(s10, NegativeZero) < 0 ? NegativeOne : m1690compareTo41bOqos(s10, PositiveZero) > 0 ? One : s10;
    }

    /* JADX INFO: renamed from: getSignificand-impl, reason: not valid java name */
    public static final int m1699getSignificandimpl(short s10) {
        return s10 & 1023;
    }

    /* JADX INFO: renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m1701isFiniteimpl(short s10) {
        return (s10 & Short.MAX_VALUE) != FP16_EXPONENT_MAX;
    }

    /* JADX INFO: renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m1702isInfiniteimpl(short s10) {
        return (s10 & Short.MAX_VALUE) == FP16_EXPONENT_MAX;
    }

    /* JADX INFO: renamed from: isNaN-impl, reason: not valid java name */
    public static final boolean m1703isNaNimpl(short s10) {
        return (s10 & Short.MAX_VALUE) > FP16_EXPONENT_MAX;
    }

    /* JADX INFO: renamed from: isNormalized-impl, reason: not valid java name */
    public static final boolean m1704isNormalizedimpl(short s10) {
        int i10 = s10 & FP16_EXPONENT_MAX;
        return (i10 == 0 || i10 == FP16_EXPONENT_MAX) ? false : true;
    }

    /* JADX INFO: renamed from: round-slo4al4, reason: not valid java name */
    public static final short m1705roundslo4al4(short s10) {
        int i10 = s10 & 65535;
        int i11 = i10 & FP16_COMBINED;
        if (i11 < 15360) {
            i10 = (i10 & 32768) | ((i11 < 14336 ? 0 : 65535) & 15360);
        } else if (i11 < 25600) {
            int i12 = 25 - (i11 >> 10);
            i10 = (i10 + (1 << (i12 - 1))) & (~((1 << i12) - 1));
        }
        return m1693constructorimpl((short) i10);
    }

    /* JADX INFO: renamed from: toBits-impl, reason: not valid java name */
    public static final int m1706toBitsimpl(short s10) {
        return m1703isNaNimpl(s10) ? NaN : s10 & 65535;
    }

    /* JADX INFO: renamed from: toByte-impl, reason: not valid java name */
    public static final byte m1707toByteimpl(short s10) {
        return (byte) m1709toFloatimpl(s10);
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    public static final double m1708toDoubleimpl(short s10) {
        return m1709toFloatimpl(s10);
    }

    /* JADX INFO: renamed from: toFloat-impl, reason: not valid java name */
    public static final float m1709toFloatimpl(short s10) {
        int i10;
        int i11;
        int i12;
        int i13 = s10 & 65535;
        int i14 = 32768 & i13;
        int i15 = (i13 >>> 10) & 31;
        int i16 = i13 & 1023;
        if (i15 != 0) {
            int i17 = i16 << 13;
            if (i15 == 31) {
                i10 = 255;
                if (i17 != 0) {
                    i17 |= 4194304;
                }
            } else {
                i10 = (i15 - 15) + 127;
            }
            int i18 = i10;
            i11 = i17;
            i12 = i18;
        } else {
            if (i16 != 0) {
                kotlin.jvm.internal.m mVar = kotlin.jvm.internal.m.f29832a;
                float fIntBitsToFloat = Float.intBitsToFloat(i16 + FP32_DENORMAL_MAGIC) - FP32_DENORMAL_FLOAT;
                return i14 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i12 = 0;
            i11 = 0;
        }
        int i19 = (i12 << 23) | (i14 << 16) | i11;
        kotlin.jvm.internal.m mVar2 = kotlin.jvm.internal.m.f29832a;
        return Float.intBitsToFloat(i19);
    }

    @NotNull
    /* JADX INFO: renamed from: toHexString-impl, reason: not valid java name */
    public static final String m1710toHexStringimpl(short s10) {
        StringBuilder sb = new StringBuilder();
        int i10 = s10 & 65535;
        int i11 = i10 >>> 15;
        int i12 = (i10 >>> 10) & 31;
        int i13 = i10 & 1023;
        if (i12 != 31) {
            if (i11 == 1) {
                sb.append('-');
            }
            if (i12 != 0) {
                sb.append("0x1.");
                String string = Integer.toString(i13, p9.b.a(16));
                kotlin.jvm.internal.t.h(string, "toString(this, checkRadix(radix))");
                sb.append(new p9.f("0{2,}$").c(string, ""));
                sb.append('p');
                sb.append(String.valueOf(i12 - 15));
            } else if (i13 == 0) {
                sb.append("0x0.0p0");
            } else {
                sb.append("0x0.");
                String string2 = Integer.toString(i13, p9.b.a(16));
                kotlin.jvm.internal.t.h(string2, "toString(this, checkRadix(radix))");
                sb.append(new p9.f("0{2,}$").c(string2, ""));
                sb.append("p-14");
            }
        } else if (i13 == 0) {
            if (i11 != 0) {
                sb.append('-');
            }
            sb.append("Infinity");
        } else {
            sb.append("NaN");
        }
        String string3 = sb.toString();
        kotlin.jvm.internal.t.h(string3, "o.toString()");
        return string3;
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    public static final int m1711toIntimpl(short s10) {
        return (int) m1709toFloatimpl(s10);
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    public static final long m1712toLongimpl(short s10) {
        return (long) m1709toFloatimpl(s10);
    }

    /* JADX INFO: renamed from: toRawBits-impl, reason: not valid java name */
    public static final int m1713toRawBitsimpl(short s10) {
        return s10 & 65535;
    }

    /* JADX INFO: renamed from: toShort-impl, reason: not valid java name */
    public static final short m1714toShortimpl(short s10) {
        return (short) m1709toFloatimpl(s10);
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1715toStringimpl(short s10) {
        return String.valueOf(m1709toFloatimpl(s10));
    }

    /* JADX INFO: renamed from: trunc-slo4al4, reason: not valid java name */
    public static final short m1716truncslo4al4(short s10) {
        int i10;
        int i11 = s10 & 65535;
        int i12 = i11 & FP16_COMBINED;
        if (i12 >= 15360) {
            i10 = i12 < 25600 ? ~((1 << (25 - (i12 >> 10))) - 1) : 32768;
            return m1693constructorimpl((short) i11);
        }
        i11 &= i10;
        return m1693constructorimpl((short) i11);
    }

    /* JADX INFO: renamed from: withSign-qCeQghg, reason: not valid java name */
    public static final short m1717withSignqCeQghg(short s10, short s11) {
        return m1693constructorimpl((short) ((s10 & Short.MAX_VALUE) | (s11 & Short.MIN_VALUE)));
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Float16 float16) {
        return m1718compareTo41bOqos(float16.m1719unboximpl());
    }

    /* JADX INFO: renamed from: compareTo-41bOqos, reason: not valid java name */
    public int m1718compareTo41bOqos(short s10) {
        return m1690compareTo41bOqos(this.halfValue, s10);
    }

    public boolean equals(Object obj) {
        return m1694equalsimpl(this.halfValue, obj);
    }

    public final short getHalfValue() {
        return this.halfValue;
    }

    public int hashCode() {
        return m1700hashCodeimpl(this.halfValue);
    }

    @NotNull
    public String toString() {
        return m1715toStringimpl(this.halfValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ short m1719unboximpl() {
        return this.halfValue;
    }

    /* JADX INFO: renamed from: compareTo-41bOqos, reason: not valid java name */
    public static int m1690compareTo41bOqos(short s10, short s11) {
        if (m1703isNaNimpl(s10)) {
            return !m1703isNaNimpl(s11) ? 1 : 0;
        }
        if (m1703isNaNimpl(s11)) {
            return -1;
        }
        Companion companion = Companion;
        return kotlin.jvm.internal.t.k(companion.toCompareValue(s10), companion.toCompareValue(s11));
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static short m1692constructorimpl(float f10) {
        return m1693constructorimpl(Companion.floatToHalf(f10));
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static short m1691constructorimpl(double d10) {
        return m1692constructorimpl((float) d10);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1700hashCodeimpl(short s10) {
        return s10;
    }
}
