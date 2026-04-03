package androidx.compose.foundation.layout;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WindowInsets.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsSides {
    private static final int AllowLeftInLtr;
    private static final int AllowLeftInRtl;
    private static final int AllowRightInLtr;
    private static final int AllowRightInRtl;
    private static final int Bottom;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int End;
    private static final int Horizontal;
    private static final int Left;
    private static final int Right;
    private static final int Start;
    private static final int Top;
    private static final int Vertical;
    private final int value;

    /* JADX INFO: compiled from: WindowInsets.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getAllowLeftInLtr-JoeWqyM$foundation_layout_release, reason: not valid java name */
        public final int m472getAllowLeftInLtrJoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.AllowLeftInLtr;
        }

        /* JADX INFO: renamed from: getAllowLeftInRtl-JoeWqyM$foundation_layout_release, reason: not valid java name */
        public final int m473getAllowLeftInRtlJoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.AllowLeftInRtl;
        }

        /* JADX INFO: renamed from: getAllowRightInLtr-JoeWqyM$foundation_layout_release, reason: not valid java name */
        public final int m474getAllowRightInLtrJoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.AllowRightInLtr;
        }

        /* JADX INFO: renamed from: getAllowRightInRtl-JoeWqyM$foundation_layout_release, reason: not valid java name */
        public final int m475getAllowRightInRtlJoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.AllowRightInRtl;
        }

        /* JADX INFO: renamed from: getBottom-JoeWqyM, reason: not valid java name */
        public final int m476getBottomJoeWqyM() {
            return WindowInsetsSides.Bottom;
        }

        /* JADX INFO: renamed from: getEnd-JoeWqyM, reason: not valid java name */
        public final int m477getEndJoeWqyM() {
            return WindowInsetsSides.End;
        }

        /* JADX INFO: renamed from: getHorizontal-JoeWqyM, reason: not valid java name */
        public final int m478getHorizontalJoeWqyM() {
            return WindowInsetsSides.Horizontal;
        }

        /* JADX INFO: renamed from: getLeft-JoeWqyM, reason: not valid java name */
        public final int m479getLeftJoeWqyM() {
            return WindowInsetsSides.Left;
        }

        /* JADX INFO: renamed from: getRight-JoeWqyM, reason: not valid java name */
        public final int m480getRightJoeWqyM() {
            return WindowInsetsSides.Right;
        }

        /* JADX INFO: renamed from: getStart-JoeWqyM, reason: not valid java name */
        public final int m481getStartJoeWqyM() {
            return WindowInsetsSides.Start;
        }

        /* JADX INFO: renamed from: getTop-JoeWqyM, reason: not valid java name */
        public final int m482getTopJoeWqyM() {
            return WindowInsetsSides.Top;
        }

        /* JADX INFO: renamed from: getVertical-JoeWqyM, reason: not valid java name */
        public final int m483getVerticalJoeWqyM() {
            return WindowInsetsSides.Vertical;
        }
    }

    static {
        int iM462constructorimpl = m462constructorimpl(8);
        AllowLeftInLtr = iM462constructorimpl;
        int iM462constructorimpl2 = m462constructorimpl(4);
        AllowRightInLtr = iM462constructorimpl2;
        int iM462constructorimpl3 = m462constructorimpl(2);
        AllowLeftInRtl = iM462constructorimpl3;
        int iM462constructorimpl4 = m462constructorimpl(1);
        AllowRightInRtl = iM462constructorimpl4;
        Start = m467plusgK_yJZ4(iM462constructorimpl, iM462constructorimpl4);
        End = m467plusgK_yJZ4(iM462constructorimpl2, iM462constructorimpl3);
        int iM462constructorimpl5 = m462constructorimpl(16);
        Top = iM462constructorimpl5;
        int iM462constructorimpl6 = m462constructorimpl(32);
        Bottom = iM462constructorimpl6;
        int iM467plusgK_yJZ4 = m467plusgK_yJZ4(iM462constructorimpl, iM462constructorimpl3);
        Left = iM467plusgK_yJZ4;
        int iM467plusgK_yJZ42 = m467plusgK_yJZ4(iM462constructorimpl2, iM462constructorimpl4);
        Right = iM467plusgK_yJZ42;
        Horizontal = m467plusgK_yJZ4(iM467plusgK_yJZ4, iM467plusgK_yJZ42);
        Vertical = m467plusgK_yJZ4(iM462constructorimpl5, iM462constructorimpl6);
    }

    private /* synthetic */ WindowInsetsSides(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ WindowInsetsSides m461boximpl(int i10) {
        return new WindowInsetsSides(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m463equalsimpl(int i10, Object obj) {
        return (obj instanceof WindowInsetsSides) && i10 == ((WindowInsetsSides) obj).m471unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m464equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    /* JADX INFO: renamed from: hasAny-bkgdKaI$foundation_layout_release, reason: not valid java name */
    public static final boolean m465hasAnybkgdKaI$foundation_layout_release(int i10, int i11) {
        return (i10 & i11) != 0;
    }

    /* JADX INFO: renamed from: plus-gK_yJZ4, reason: not valid java name */
    public static final int m467plusgK_yJZ4(int i10, int i11) {
        return m462constructorimpl(i10 | i11);
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m468toStringimpl(int i10) {
        return "WindowInsetsSides(" + m469valueToStringimpl(i10) + ')';
    }

    /* JADX INFO: renamed from: valueToString-impl, reason: not valid java name */
    private static final String m469valueToStringimpl(int i10) {
        StringBuilder sb = new StringBuilder();
        int i11 = Start;
        if ((i10 & i11) == i11) {
            m470valueToString_impl$lambda0$appendPlus(sb, "Start");
        }
        int i12 = Left;
        if ((i10 & i12) == i12) {
            m470valueToString_impl$lambda0$appendPlus(sb, "Left");
        }
        int i13 = Top;
        if ((i10 & i13) == i13) {
            m470valueToString_impl$lambda0$appendPlus(sb, "Top");
        }
        int i14 = End;
        if ((i10 & i14) == i14) {
            m470valueToString_impl$lambda0$appendPlus(sb, "End");
        }
        int i15 = Right;
        if ((i10 & i15) == i15) {
            m470valueToString_impl$lambda0$appendPlus(sb, "Right");
        }
        int i16 = Bottom;
        if ((i10 & i16) == i16) {
            m470valueToString_impl$lambda0$appendPlus(sb, "Bottom");
        }
        String string = sb.toString();
        t.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX INFO: renamed from: valueToString_impl$lambda-0$appendPlus, reason: not valid java name */
    private static final void m470valueToString_impl$lambda0$appendPlus(StringBuilder sb, String str) {
        if (sb.length() > 0) {
            sb.append('+');
        }
        sb.append(str);
    }

    public boolean equals(Object obj) {
        return m463equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m466hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m468toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m471unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m462constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m466hashCodeimpl(int i10) {
        return i10;
    }
}
