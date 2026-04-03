package androidx.compose.ui.text.style;

import androidx.compose.ui.text.ExperimentalTextApi;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LineHeightStyle.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalTextApi
public final class LineHeightStyle {

    @NotNull
    public static final Companion Companion;

    @NotNull
    private static final LineHeightStyle Default;
    private final int alignment;
    private final int trim;

    /* JADX INFO: compiled from: LineHeightStyle.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final LineHeightStyle getDefault() {
            return LineHeightStyle.Default;
        }
    }

    static {
        k kVar = null;
        Companion = new Companion(kVar);
        Default = new LineHeightStyle(Alignment.Companion.m3571getProportionalPIaL0Z0(), Trim.Companion.m3582getBothEVpEnUU(), kVar);
    }

    public /* synthetic */ LineHeightStyle(int i10, int i11, k kVar) {
        this(i10, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LineHeightStyle)) {
            return false;
        }
        LineHeightStyle lineHeightStyle = (LineHeightStyle) obj;
        return Alignment.m3565equalsimpl0(this.alignment, lineHeightStyle.alignment) && Trim.m3576equalsimpl0(this.trim, lineHeightStyle.trim);
    }

    /* JADX INFO: renamed from: getAlignment-PIaL0Z0, reason: not valid java name */
    public final int m3560getAlignmentPIaL0Z0() {
        return this.alignment;
    }

    /* JADX INFO: renamed from: getTrim-EVpEnUU, reason: not valid java name */
    public final int m3561getTrimEVpEnUU() {
        return this.trim;
    }

    public int hashCode() {
        return (Alignment.m3566hashCodeimpl(this.alignment) * 31) + Trim.m3577hashCodeimpl(this.trim);
    }

    @NotNull
    public String toString() {
        return "LineHeightStyle(alignment=" + ((Object) Alignment.m3567toStringimpl(this.alignment)) + ", trim=" + ((Object) Trim.m3580toStringimpl(this.trim)) + ')';
    }

    private LineHeightStyle(int i10, int i11) {
        this.alignment = i10;
        this.trim = i11;
    }

    /* JADX INFO: compiled from: LineHeightStyle.kt */
    @ExperimentalTextApi
    public static final class Alignment {
        private final int topPercentage;

        @NotNull
        public static final Companion Companion = new Companion(null);
        private static final int Top = m3563constructorimpl(0);
        private static final int Center = m3563constructorimpl(50);
        private static final int Proportional = m3563constructorimpl(-1);
        private static final int Bottom = m3563constructorimpl(100);

        /* JADX INFO: compiled from: LineHeightStyle.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            /* JADX INFO: renamed from: getBottom-PIaL0Z0, reason: not valid java name */
            public final int m3569getBottomPIaL0Z0() {
                return Alignment.Bottom;
            }

            /* JADX INFO: renamed from: getCenter-PIaL0Z0, reason: not valid java name */
            public final int m3570getCenterPIaL0Z0() {
                return Alignment.Center;
            }

            /* JADX INFO: renamed from: getProportional-PIaL0Z0, reason: not valid java name */
            public final int m3571getProportionalPIaL0Z0() {
                return Alignment.Proportional;
            }

            /* JADX INFO: renamed from: getTop-PIaL0Z0, reason: not valid java name */
            public final int m3572getTopPIaL0Z0() {
                return Alignment.Top;
            }
        }

        private /* synthetic */ Alignment(int i10) {
            this.topPercentage = i10;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Alignment m3562boximpl(int i10) {
            return new Alignment(i10);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        private static int m3563constructorimpl(int i10) {
            boolean z10 = true;
            if (!(i10 >= 0 && i10 < 101) && i10 != -1) {
                z10 = false;
            }
            if (z10) {
                return i10;
            }
            throw new IllegalStateException("topRatio should be in [0..100] range or -1".toString());
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m3564equalsimpl(int i10, Object obj) {
            return (obj instanceof Alignment) && i10 == ((Alignment) obj).m3568unboximpl();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m3565equalsimpl0(int i10, int i11) {
            return i10 == i11;
        }

        @NotNull
        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m3567toStringimpl(int i10) {
            if (i10 == Top) {
                return "LineHeightStyle.Alignment.Top";
            }
            if (i10 == Center) {
                return "LineHeightStyle.Alignment.Center";
            }
            if (i10 == Proportional) {
                return "LineHeightStyle.Alignment.Proportional";
            }
            if (i10 == Bottom) {
                return "LineHeightStyle.Alignment.Bottom";
            }
            return "LineHeightStyle.Alignment(topPercentage = " + i10 + ')';
        }

        public boolean equals(Object obj) {
            return m3564equalsimpl(this.topPercentage, obj);
        }

        public int hashCode() {
            return m3566hashCodeimpl(this.topPercentage);
        }

        @NotNull
        public String toString() {
            return m3567toStringimpl(this.topPercentage);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m3568unboximpl() {
            return this.topPercentage;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m3566hashCodeimpl(int i10) {
            return i10;
        }
    }

    /* JADX INFO: compiled from: LineHeightStyle.kt */
    @ExperimentalTextApi
    public static final class Trim {
        private static final int FlagTrimBottom = 16;
        private static final int FlagTrimTop = 1;
        private final int value;

        @NotNull
        public static final Companion Companion = new Companion(null);
        private static final int FirstLineTop = m3574constructorimpl(1);
        private static final int LastLineBottom = m3574constructorimpl(16);
        private static final int Both = m3574constructorimpl(17);
        private static final int None = m3574constructorimpl(0);

        /* JADX INFO: compiled from: LineHeightStyle.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            /* JADX INFO: renamed from: getBoth-EVpEnUU, reason: not valid java name */
            public final int m3582getBothEVpEnUU() {
                return Trim.Both;
            }

            /* JADX INFO: renamed from: getFirstLineTop-EVpEnUU, reason: not valid java name */
            public final int m3583getFirstLineTopEVpEnUU() {
                return Trim.FirstLineTop;
            }

            /* JADX INFO: renamed from: getLastLineBottom-EVpEnUU, reason: not valid java name */
            public final int m3584getLastLineBottomEVpEnUU() {
                return Trim.LastLineBottom;
            }

            /* JADX INFO: renamed from: getNone-EVpEnUU, reason: not valid java name */
            public final int m3585getNoneEVpEnUU() {
                return Trim.None;
            }
        }

        private /* synthetic */ Trim(int i10) {
            this.value = i10;
        }

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Trim m3573boximpl(int i10) {
            return new Trim(i10);
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m3575equalsimpl(int i10, Object obj) {
            return (obj instanceof Trim) && i10 == ((Trim) obj).m3581unboximpl();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m3576equalsimpl0(int i10, int i11) {
            return i10 == i11;
        }

        /* JADX INFO: renamed from: isTrimFirstLineTop-impl$ui_text_release, reason: not valid java name */
        public static final boolean m3578isTrimFirstLineTopimpl$ui_text_release(int i10) {
            return (i10 & 1) > 0;
        }

        /* JADX INFO: renamed from: isTrimLastLineBottom-impl$ui_text_release, reason: not valid java name */
        public static final boolean m3579isTrimLastLineBottomimpl$ui_text_release(int i10) {
            return (i10 & 16) > 0;
        }

        @NotNull
        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m3580toStringimpl(int i10) {
            return i10 == FirstLineTop ? "LineHeightStyle.Trim.FirstLineTop" : i10 == LastLineBottom ? "LineHeightStyle.Trim.LastLineBottom" : i10 == Both ? "LineHeightStyle.Trim.Both" : i10 == None ? "LineHeightStyle.Trim.None" : "Invalid";
        }

        public boolean equals(Object obj) {
            return m3575equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m3577hashCodeimpl(this.value);
        }

        @NotNull
        public String toString() {
            return m3580toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m3581unboximpl() {
            return this.value;
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        private static int m3574constructorimpl(int i10) {
            return i10;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m3577hashCodeimpl(int i10) {
            return i10;
        }
    }
}
