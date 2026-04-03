package androidx.compose.ui.text.font;

import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FontSynthesis.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FontSynthesis {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int None = m3420constructorimpl(0);
    private static final int All = m3420constructorimpl(1);
    private static final int Weight = m3420constructorimpl(2);
    private static final int Style = m3420constructorimpl(3);

    /* JADX INFO: compiled from: FontSynthesis.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getAll-GVVA2EU, reason: not valid java name */
        public final int m3428getAllGVVA2EU() {
            return FontSynthesis.All;
        }

        /* JADX INFO: renamed from: getNone-GVVA2EU, reason: not valid java name */
        public final int m3429getNoneGVVA2EU() {
            return FontSynthesis.None;
        }

        /* JADX INFO: renamed from: getStyle-GVVA2EU, reason: not valid java name */
        public final int m3430getStyleGVVA2EU() {
            return FontSynthesis.Style;
        }

        /* JADX INFO: renamed from: getWeight-GVVA2EU, reason: not valid java name */
        public final int m3431getWeightGVVA2EU() {
            return FontSynthesis.Weight;
        }
    }

    private /* synthetic */ FontSynthesis(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FontSynthesis m3419boximpl(int i10) {
        return new FontSynthesis(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3421equalsimpl(int i10, Object obj) {
        return (obj instanceof FontSynthesis) && i10 == ((FontSynthesis) obj).m3427unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3422equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    /* JADX INFO: renamed from: isStyleOn-impl$ui_text_release, reason: not valid java name */
    public static final boolean m3424isStyleOnimpl$ui_text_release(int i10) {
        return m3422equalsimpl0(i10, All) || m3422equalsimpl0(i10, Style);
    }

    /* JADX INFO: renamed from: isWeightOn-impl$ui_text_release, reason: not valid java name */
    public static final boolean m3425isWeightOnimpl$ui_text_release(int i10) {
        return m3422equalsimpl0(i10, All) || m3422equalsimpl0(i10, Weight);
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3426toStringimpl(int i10) {
        return m3422equalsimpl0(i10, None) ? "None" : m3422equalsimpl0(i10, All) ? "All" : m3422equalsimpl0(i10, Weight) ? "Weight" : m3422equalsimpl0(i10, Style) ? "Style" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m3421equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3423hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m3426toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3427unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m3420constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3423hashCodeimpl(int i10) {
        return i10;
    }
}
