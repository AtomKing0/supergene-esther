package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import androidx.exifinterface.media.ExifInterface;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BlendMode.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class BlendMode {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Clear = m1515constructorimpl(0);
    private static final int Src = m1515constructorimpl(1);
    private static final int Dst = m1515constructorimpl(2);
    private static final int SrcOver = m1515constructorimpl(3);
    private static final int DstOver = m1515constructorimpl(4);
    private static final int SrcIn = m1515constructorimpl(5);
    private static final int DstIn = m1515constructorimpl(6);
    private static final int SrcOut = m1515constructorimpl(7);
    private static final int DstOut = m1515constructorimpl(8);
    private static final int SrcAtop = m1515constructorimpl(9);
    private static final int DstAtop = m1515constructorimpl(10);
    private static final int Xor = m1515constructorimpl(11);
    private static final int Plus = m1515constructorimpl(12);
    private static final int Modulate = m1515constructorimpl(13);
    private static final int Screen = m1515constructorimpl(14);
    private static final int Overlay = m1515constructorimpl(15);
    private static final int Darken = m1515constructorimpl(16);
    private static final int Lighten = m1515constructorimpl(17);
    private static final int ColorDodge = m1515constructorimpl(18);
    private static final int ColorBurn = m1515constructorimpl(19);
    private static final int Hardlight = m1515constructorimpl(20);
    private static final int Softlight = m1515constructorimpl(21);
    private static final int Difference = m1515constructorimpl(22);
    private static final int Exclusion = m1515constructorimpl(23);
    private static final int Multiply = m1515constructorimpl(24);
    private static final int Hue = m1515constructorimpl(25);
    private static final int Saturation = m1515constructorimpl(26);
    private static final int Color = m1515constructorimpl(27);
    private static final int Luminosity = m1515constructorimpl(28);

    /* JADX INFO: compiled from: BlendMode.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getClear-0nO6VwU, reason: not valid java name */
        public final int m1521getClear0nO6VwU() {
            return BlendMode.Clear;
        }

        /* JADX INFO: renamed from: getColor-0nO6VwU, reason: not valid java name */
        public final int m1522getColor0nO6VwU() {
            return BlendMode.Color;
        }

        /* JADX INFO: renamed from: getColorBurn-0nO6VwU, reason: not valid java name */
        public final int m1523getColorBurn0nO6VwU() {
            return BlendMode.ColorBurn;
        }

        /* JADX INFO: renamed from: getColorDodge-0nO6VwU, reason: not valid java name */
        public final int m1524getColorDodge0nO6VwU() {
            return BlendMode.ColorDodge;
        }

        /* JADX INFO: renamed from: getDarken-0nO6VwU, reason: not valid java name */
        public final int m1525getDarken0nO6VwU() {
            return BlendMode.Darken;
        }

        /* JADX INFO: renamed from: getDifference-0nO6VwU, reason: not valid java name */
        public final int m1526getDifference0nO6VwU() {
            return BlendMode.Difference;
        }

        /* JADX INFO: renamed from: getDst-0nO6VwU, reason: not valid java name */
        public final int m1527getDst0nO6VwU() {
            return BlendMode.Dst;
        }

        /* JADX INFO: renamed from: getDstAtop-0nO6VwU, reason: not valid java name */
        public final int m1528getDstAtop0nO6VwU() {
            return BlendMode.DstAtop;
        }

        /* JADX INFO: renamed from: getDstIn-0nO6VwU, reason: not valid java name */
        public final int m1529getDstIn0nO6VwU() {
            return BlendMode.DstIn;
        }

        /* JADX INFO: renamed from: getDstOut-0nO6VwU, reason: not valid java name */
        public final int m1530getDstOut0nO6VwU() {
            return BlendMode.DstOut;
        }

        /* JADX INFO: renamed from: getDstOver-0nO6VwU, reason: not valid java name */
        public final int m1531getDstOver0nO6VwU() {
            return BlendMode.DstOver;
        }

        /* JADX INFO: renamed from: getExclusion-0nO6VwU, reason: not valid java name */
        public final int m1532getExclusion0nO6VwU() {
            return BlendMode.Exclusion;
        }

        /* JADX INFO: renamed from: getHardlight-0nO6VwU, reason: not valid java name */
        public final int m1533getHardlight0nO6VwU() {
            return BlendMode.Hardlight;
        }

        /* JADX INFO: renamed from: getHue-0nO6VwU, reason: not valid java name */
        public final int m1534getHue0nO6VwU() {
            return BlendMode.Hue;
        }

        /* JADX INFO: renamed from: getLighten-0nO6VwU, reason: not valid java name */
        public final int m1535getLighten0nO6VwU() {
            return BlendMode.Lighten;
        }

        /* JADX INFO: renamed from: getLuminosity-0nO6VwU, reason: not valid java name */
        public final int m1536getLuminosity0nO6VwU() {
            return BlendMode.Luminosity;
        }

        /* JADX INFO: renamed from: getModulate-0nO6VwU, reason: not valid java name */
        public final int m1537getModulate0nO6VwU() {
            return BlendMode.Modulate;
        }

        /* JADX INFO: renamed from: getMultiply-0nO6VwU, reason: not valid java name */
        public final int m1538getMultiply0nO6VwU() {
            return BlendMode.Multiply;
        }

        /* JADX INFO: renamed from: getOverlay-0nO6VwU, reason: not valid java name */
        public final int m1539getOverlay0nO6VwU() {
            return BlendMode.Overlay;
        }

        /* JADX INFO: renamed from: getPlus-0nO6VwU, reason: not valid java name */
        public final int m1540getPlus0nO6VwU() {
            return BlendMode.Plus;
        }

        /* JADX INFO: renamed from: getSaturation-0nO6VwU, reason: not valid java name */
        public final int m1541getSaturation0nO6VwU() {
            return BlendMode.Saturation;
        }

        /* JADX INFO: renamed from: getScreen-0nO6VwU, reason: not valid java name */
        public final int m1542getScreen0nO6VwU() {
            return BlendMode.Screen;
        }

        /* JADX INFO: renamed from: getSoftlight-0nO6VwU, reason: not valid java name */
        public final int m1543getSoftlight0nO6VwU() {
            return BlendMode.Softlight;
        }

        /* JADX INFO: renamed from: getSrc-0nO6VwU, reason: not valid java name */
        public final int m1544getSrc0nO6VwU() {
            return BlendMode.Src;
        }

        /* JADX INFO: renamed from: getSrcAtop-0nO6VwU, reason: not valid java name */
        public final int m1545getSrcAtop0nO6VwU() {
            return BlendMode.SrcAtop;
        }

        /* JADX INFO: renamed from: getSrcIn-0nO6VwU, reason: not valid java name */
        public final int m1546getSrcIn0nO6VwU() {
            return BlendMode.SrcIn;
        }

        /* JADX INFO: renamed from: getSrcOut-0nO6VwU, reason: not valid java name */
        public final int m1547getSrcOut0nO6VwU() {
            return BlendMode.SrcOut;
        }

        /* JADX INFO: renamed from: getSrcOver-0nO6VwU, reason: not valid java name */
        public final int m1548getSrcOver0nO6VwU() {
            return BlendMode.SrcOver;
        }

        /* JADX INFO: renamed from: getXor-0nO6VwU, reason: not valid java name */
        public final int m1549getXor0nO6VwU() {
            return BlendMode.Xor;
        }
    }

    private /* synthetic */ BlendMode(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ BlendMode m1514boximpl(int i10) {
        return new BlendMode(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1516equalsimpl(int i10, Object obj) {
        return (obj instanceof BlendMode) && i10 == ((BlendMode) obj).m1520unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1517equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1519toStringimpl(int i10) {
        return m1517equalsimpl0(i10, Clear) ? "Clear" : m1517equalsimpl0(i10, Src) ? "Src" : m1517equalsimpl0(i10, Dst) ? "Dst" : m1517equalsimpl0(i10, SrcOver) ? "SrcOver" : m1517equalsimpl0(i10, DstOver) ? "DstOver" : m1517equalsimpl0(i10, SrcIn) ? "SrcIn" : m1517equalsimpl0(i10, DstIn) ? "DstIn" : m1517equalsimpl0(i10, SrcOut) ? "SrcOut" : m1517equalsimpl0(i10, DstOut) ? "DstOut" : m1517equalsimpl0(i10, SrcAtop) ? "SrcAtop" : m1517equalsimpl0(i10, DstAtop) ? "DstAtop" : m1517equalsimpl0(i10, Xor) ? "Xor" : m1517equalsimpl0(i10, Plus) ? "Plus" : m1517equalsimpl0(i10, Modulate) ? "Modulate" : m1517equalsimpl0(i10, Screen) ? "Screen" : m1517equalsimpl0(i10, Overlay) ? "Overlay" : m1517equalsimpl0(i10, Darken) ? "Darken" : m1517equalsimpl0(i10, Lighten) ? "Lighten" : m1517equalsimpl0(i10, ColorDodge) ? "ColorDodge" : m1517equalsimpl0(i10, ColorBurn) ? "ColorBurn" : m1517equalsimpl0(i10, Hardlight) ? "HardLight" : m1517equalsimpl0(i10, Softlight) ? "Softlight" : m1517equalsimpl0(i10, Difference) ? "Difference" : m1517equalsimpl0(i10, Exclusion) ? "Exclusion" : m1517equalsimpl0(i10, Multiply) ? "Multiply" : m1517equalsimpl0(i10, Hue) ? "Hue" : m1517equalsimpl0(i10, Saturation) ? ExifInterface.TAG_SATURATION : m1517equalsimpl0(i10, Color) ? "Color" : m1517equalsimpl0(i10, Luminosity) ? "Luminosity" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1516equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1518hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1519toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1520unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1515constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1518hashCodeimpl(int i10) {
        return i10;
    }
}
