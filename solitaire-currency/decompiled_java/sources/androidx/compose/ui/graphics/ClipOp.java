package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ClipOp.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class ClipOp {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Difference = m1580constructorimpl(0);
    private static final int Intersect = m1580constructorimpl(1);
    private final int value;

    /* JADX INFO: compiled from: ClipOp.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getDifference-rtfAjoo, reason: not valid java name */
        public final int m1586getDifferencertfAjoo() {
            return ClipOp.Difference;
        }

        /* JADX INFO: renamed from: getIntersect-rtfAjoo, reason: not valid java name */
        public final int m1587getIntersectrtfAjoo() {
            return ClipOp.Intersect;
        }
    }

    private /* synthetic */ ClipOp(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ClipOp m1579boximpl(int i10) {
        return new ClipOp(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1581equalsimpl(int i10, Object obj) {
        return (obj instanceof ClipOp) && i10 == ((ClipOp) obj).m1585unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1582equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1584toStringimpl(int i10) {
        return m1582equalsimpl0(i10, Difference) ? "Difference" : m1582equalsimpl0(i10, Intersect) ? "Intersect" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1581equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1583hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1584toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1585unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1580constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1583hashCodeimpl(int i10) {
        return i10;
    }
}
