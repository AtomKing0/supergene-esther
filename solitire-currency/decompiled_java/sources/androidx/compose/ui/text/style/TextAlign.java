package androidx.compose.ui.text.style;

import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextAlign.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextAlign {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Left = m3587constructorimpl(1);
    private static final int Right = m3587constructorimpl(2);
    private static final int Center = m3587constructorimpl(3);
    private static final int Justify = m3587constructorimpl(4);
    private static final int Start = m3587constructorimpl(5);
    private static final int End = m3587constructorimpl(6);

    /* JADX INFO: compiled from: TextAlign.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getCenter-e0LSkKk, reason: not valid java name */
        public final int m3593getCentere0LSkKk() {
            return TextAlign.Center;
        }

        /* JADX INFO: renamed from: getEnd-e0LSkKk, reason: not valid java name */
        public final int m3594getEnde0LSkKk() {
            return TextAlign.End;
        }

        /* JADX INFO: renamed from: getJustify-e0LSkKk, reason: not valid java name */
        public final int m3595getJustifye0LSkKk() {
            return TextAlign.Justify;
        }

        /* JADX INFO: renamed from: getLeft-e0LSkKk, reason: not valid java name */
        public final int m3596getLefte0LSkKk() {
            return TextAlign.Left;
        }

        /* JADX INFO: renamed from: getRight-e0LSkKk, reason: not valid java name */
        public final int m3597getRighte0LSkKk() {
            return TextAlign.Right;
        }

        /* JADX INFO: renamed from: getStart-e0LSkKk, reason: not valid java name */
        public final int m3598getStarte0LSkKk() {
            return TextAlign.Start;
        }

        @NotNull
        public final List<TextAlign> values() {
            return v.n(TextAlign.m3586boximpl(m3596getLefte0LSkKk()), TextAlign.m3586boximpl(m3597getRighte0LSkKk()), TextAlign.m3586boximpl(m3593getCentere0LSkKk()), TextAlign.m3586boximpl(m3595getJustifye0LSkKk()), TextAlign.m3586boximpl(m3598getStarte0LSkKk()), TextAlign.m3586boximpl(m3594getEnde0LSkKk()));
        }
    }

    private /* synthetic */ TextAlign(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextAlign m3586boximpl(int i10) {
        return new TextAlign(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3588equalsimpl(int i10, Object obj) {
        return (obj instanceof TextAlign) && i10 == ((TextAlign) obj).m3592unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3589equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3591toStringimpl(int i10) {
        return m3589equalsimpl0(i10, Left) ? "Left" : m3589equalsimpl0(i10, Right) ? "Right" : m3589equalsimpl0(i10, Center) ? "Center" : m3589equalsimpl0(i10, Justify) ? "Justify" : m3589equalsimpl0(i10, Start) ? "Start" : m3589equalsimpl0(i10, End) ? "End" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m3588equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3590hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m3591toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3592unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m3587constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3590hashCodeimpl(int i10) {
        return i10;
    }
}
