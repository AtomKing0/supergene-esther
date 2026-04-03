package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PathOperation.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class PathOperation {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Difference = m1827constructorimpl(0);
    private static final int Intersect = m1827constructorimpl(1);
    private static final int Union = m1827constructorimpl(2);
    private static final int Xor = m1827constructorimpl(3);
    private static final int ReverseDifference = m1827constructorimpl(4);

    /* JADX INFO: compiled from: PathOperation.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getDifference-b3I0S0c, reason: not valid java name */
        public final int m1833getDifferenceb3I0S0c() {
            return PathOperation.Difference;
        }

        /* JADX INFO: renamed from: getIntersect-b3I0S0c, reason: not valid java name */
        public final int m1834getIntersectb3I0S0c() {
            return PathOperation.Intersect;
        }

        /* JADX INFO: renamed from: getReverseDifference-b3I0S0c, reason: not valid java name */
        public final int m1835getReverseDifferenceb3I0S0c() {
            return PathOperation.ReverseDifference;
        }

        /* JADX INFO: renamed from: getUnion-b3I0S0c, reason: not valid java name */
        public final int m1836getUnionb3I0S0c() {
            return PathOperation.Union;
        }

        /* JADX INFO: renamed from: getXor-b3I0S0c, reason: not valid java name */
        public final int m1837getXorb3I0S0c() {
            return PathOperation.Xor;
        }
    }

    private /* synthetic */ PathOperation(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PathOperation m1826boximpl(int i10) {
        return new PathOperation(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1828equalsimpl(int i10, Object obj) {
        return (obj instanceof PathOperation) && i10 == ((PathOperation) obj).m1832unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1829equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1831toStringimpl(int i10) {
        return m1829equalsimpl0(i10, Difference) ? "Difference" : m1829equalsimpl0(i10, Intersect) ? "Intersect" : m1829equalsimpl0(i10, Union) ? "Union" : m1829equalsimpl0(i10, Xor) ? "Xor" : m1829equalsimpl0(i10, ReverseDifference) ? "ReverseDifference" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1828equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1830hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1831toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1832unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1827constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1830hashCodeimpl(int i10) {
        return i10;
    }
}
