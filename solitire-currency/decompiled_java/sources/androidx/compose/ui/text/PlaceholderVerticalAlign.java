package androidx.compose.ui.text;

import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Placeholder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PlaceholderVerticalAlign {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int AboveBaseline = m3277constructorimpl(1);
    private static final int Top = m3277constructorimpl(2);
    private static final int Bottom = m3277constructorimpl(3);
    private static final int Center = m3277constructorimpl(4);
    private static final int TextTop = m3277constructorimpl(5);
    private static final int TextBottom = m3277constructorimpl(6);
    private static final int TextCenter = m3277constructorimpl(7);

    /* JADX INFO: compiled from: Placeholder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getAboveBaseline-J6kI3mc, reason: not valid java name */
        public final int m3283getAboveBaselineJ6kI3mc() {
            return PlaceholderVerticalAlign.AboveBaseline;
        }

        /* JADX INFO: renamed from: getBottom-J6kI3mc, reason: not valid java name */
        public final int m3284getBottomJ6kI3mc() {
            return PlaceholderVerticalAlign.Bottom;
        }

        /* JADX INFO: renamed from: getCenter-J6kI3mc, reason: not valid java name */
        public final int m3285getCenterJ6kI3mc() {
            return PlaceholderVerticalAlign.Center;
        }

        /* JADX INFO: renamed from: getTextBottom-J6kI3mc, reason: not valid java name */
        public final int m3286getTextBottomJ6kI3mc() {
            return PlaceholderVerticalAlign.TextBottom;
        }

        /* JADX INFO: renamed from: getTextCenter-J6kI3mc, reason: not valid java name */
        public final int m3287getTextCenterJ6kI3mc() {
            return PlaceholderVerticalAlign.TextCenter;
        }

        /* JADX INFO: renamed from: getTextTop-J6kI3mc, reason: not valid java name */
        public final int m3288getTextTopJ6kI3mc() {
            return PlaceholderVerticalAlign.TextTop;
        }

        /* JADX INFO: renamed from: getTop-J6kI3mc, reason: not valid java name */
        public final int m3289getTopJ6kI3mc() {
            return PlaceholderVerticalAlign.Top;
        }
    }

    private /* synthetic */ PlaceholderVerticalAlign(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PlaceholderVerticalAlign m3276boximpl(int i10) {
        return new PlaceholderVerticalAlign(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3278equalsimpl(int i10, Object obj) {
        return (obj instanceof PlaceholderVerticalAlign) && i10 == ((PlaceholderVerticalAlign) obj).m3282unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3279equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3281toStringimpl(int i10) {
        return m3279equalsimpl0(i10, AboveBaseline) ? "AboveBaseline" : m3279equalsimpl0(i10, Top) ? "Top" : m3279equalsimpl0(i10, Bottom) ? "Bottom" : m3279equalsimpl0(i10, Center) ? "Center" : m3279equalsimpl0(i10, TextTop) ? "TextTop" : m3279equalsimpl0(i10, TextBottom) ? "TextBottom" : m3279equalsimpl0(i10, TextCenter) ? "TextCenter" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m3278equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3280hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m3281toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3282unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m3277constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3280hashCodeimpl(int i10) {
        return i10;
    }
}
