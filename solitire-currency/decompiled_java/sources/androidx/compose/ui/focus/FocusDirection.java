package androidx.compose.ui.focus;

import androidx.compose.ui.ExperimentalComposeUiApi;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FocusTraversal.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FocusDirection {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Next = m1301constructorimpl(1);
    private static final int Previous = m1301constructorimpl(2);
    private static final int Left = m1301constructorimpl(3);
    private static final int Right = m1301constructorimpl(4);
    private static final int Up = m1301constructorimpl(5);
    private static final int Down = m1301constructorimpl(6);
    private static final int In = m1301constructorimpl(7);
    private static final int Out = m1301constructorimpl(8);

    private /* synthetic */ FocusDirection(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FocusDirection m1300boximpl(int i10) {
        return new FocusDirection(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1302equalsimpl(int i10, Object obj) {
        return (obj instanceof FocusDirection) && i10 == ((FocusDirection) obj).m1306unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1303equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1305toStringimpl(int i10) {
        return m1303equalsimpl0(i10, Next) ? "Next" : m1303equalsimpl0(i10, Previous) ? "Previous" : m1303equalsimpl0(i10, Left) ? "Left" : m1303equalsimpl0(i10, Right) ? "Right" : m1303equalsimpl0(i10, Up) ? "Up" : m1303equalsimpl0(i10, Down) ? "Down" : m1303equalsimpl0(i10, In) ? "In" : m1303equalsimpl0(i10, Out) ? "Out" : "Invalid FocusDirection";
    }

    public boolean equals(Object obj) {
        return m1302equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1304hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1305toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1306unboximpl() {
        return this.value;
    }

    /* JADX INFO: compiled from: FocusTraversal.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getDown-dhqQ-8s, reason: not valid java name */
        public final int m1309getDowndhqQ8s() {
            return FocusDirection.Down;
        }

        /* JADX INFO: renamed from: getIn-dhqQ-8s, reason: not valid java name */
        public final int m1310getIndhqQ8s() {
            return FocusDirection.In;
        }

        /* JADX INFO: renamed from: getLeft-dhqQ-8s, reason: not valid java name */
        public final int m1311getLeftdhqQ8s() {
            return FocusDirection.Left;
        }

        /* JADX INFO: renamed from: getNext-dhqQ-8s, reason: not valid java name */
        public final int m1312getNextdhqQ8s() {
            return FocusDirection.Next;
        }

        /* JADX INFO: renamed from: getOut-dhqQ-8s, reason: not valid java name */
        public final int m1313getOutdhqQ8s() {
            return FocusDirection.Out;
        }

        /* JADX INFO: renamed from: getPrevious-dhqQ-8s, reason: not valid java name */
        public final int m1314getPreviousdhqQ8s() {
            return FocusDirection.Previous;
        }

        /* JADX INFO: renamed from: getRight-dhqQ-8s, reason: not valid java name */
        public final int m1315getRightdhqQ8s() {
            return FocusDirection.Right;
        }

        /* JADX INFO: renamed from: getUp-dhqQ-8s, reason: not valid java name */
        public final int m1316getUpdhqQ8s() {
            return FocusDirection.Up;
        }

        @ExperimentalComposeUiApi
        /* JADX INFO: renamed from: getIn-dhqQ-8s$annotations, reason: not valid java name */
        public static /* synthetic */ void m1307getIndhqQ8s$annotations() {
        }

        @ExperimentalComposeUiApi
        /* JADX INFO: renamed from: getOut-dhqQ-8s$annotations, reason: not valid java name */
        public static /* synthetic */ void m1308getOutdhqQ8s$annotations() {
        }
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1301constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1304hashCodeimpl(int i10) {
        return i10;
    }
}
