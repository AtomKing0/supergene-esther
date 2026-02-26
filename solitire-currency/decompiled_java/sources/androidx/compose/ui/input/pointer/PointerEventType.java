package androidx.compose.ui.input.pointer;

import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PointerEvent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PointerEventType {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Unknown = m2825constructorimpl(0);
    private static final int Press = m2825constructorimpl(1);
    private static final int Release = m2825constructorimpl(2);
    private static final int Move = m2825constructorimpl(3);
    private static final int Enter = m2825constructorimpl(4);
    private static final int Exit = m2825constructorimpl(5);
    private static final int Scroll = m2825constructorimpl(6);

    /* JADX INFO: compiled from: PointerEvent.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getEnter-7fucELk, reason: not valid java name */
        public final int m2831getEnter7fucELk() {
            return PointerEventType.Enter;
        }

        /* JADX INFO: renamed from: getExit-7fucELk, reason: not valid java name */
        public final int m2832getExit7fucELk() {
            return PointerEventType.Exit;
        }

        /* JADX INFO: renamed from: getMove-7fucELk, reason: not valid java name */
        public final int m2833getMove7fucELk() {
            return PointerEventType.Move;
        }

        /* JADX INFO: renamed from: getPress-7fucELk, reason: not valid java name */
        public final int m2834getPress7fucELk() {
            return PointerEventType.Press;
        }

        /* JADX INFO: renamed from: getRelease-7fucELk, reason: not valid java name */
        public final int m2835getRelease7fucELk() {
            return PointerEventType.Release;
        }

        /* JADX INFO: renamed from: getScroll-7fucELk, reason: not valid java name */
        public final int m2836getScroll7fucELk() {
            return PointerEventType.Scroll;
        }

        /* JADX INFO: renamed from: getUnknown-7fucELk, reason: not valid java name */
        public final int m2837getUnknown7fucELk() {
            return PointerEventType.Unknown;
        }
    }

    private /* synthetic */ PointerEventType(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PointerEventType m2824boximpl(int i10) {
        return new PointerEventType(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2826equalsimpl(int i10, Object obj) {
        return (obj instanceof PointerEventType) && i10 == ((PointerEventType) obj).m2830unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2827equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2829toStringimpl(int i10) {
        return m2827equalsimpl0(i10, Press) ? "Press" : m2827equalsimpl0(i10, Release) ? "Release" : m2827equalsimpl0(i10, Move) ? "Move" : m2827equalsimpl0(i10, Enter) ? "Enter" : m2827equalsimpl0(i10, Exit) ? "Exit" : m2827equalsimpl0(i10, Scroll) ? "Scroll" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m2826equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2828hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m2829toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2830unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m2825constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2828hashCodeimpl(int i10) {
        return i10;
    }
}
