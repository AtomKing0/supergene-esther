package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PathFillType.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class PathFillType {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int NonZero = m1818constructorimpl(0);
    private static final int EvenOdd = m1818constructorimpl(1);

    /* JADX INFO: compiled from: PathFillType.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getEvenOdd-Rg-k1Os, reason: not valid java name */
        public final int m1824getEvenOddRgk1Os() {
            return PathFillType.EvenOdd;
        }

        /* JADX INFO: renamed from: getNonZero-Rg-k1Os, reason: not valid java name */
        public final int m1825getNonZeroRgk1Os() {
            return PathFillType.NonZero;
        }
    }

    private /* synthetic */ PathFillType(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PathFillType m1817boximpl(int i10) {
        return new PathFillType(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1819equalsimpl(int i10, Object obj) {
        return (obj instanceof PathFillType) && i10 == ((PathFillType) obj).m1823unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1820equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1822toStringimpl(int i10) {
        return m1820equalsimpl0(i10, NonZero) ? "NonZero" : m1820equalsimpl0(i10, EvenOdd) ? "EvenOdd" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1819equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1821hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1822toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1823unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1818constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1821hashCodeimpl(int i10) {
        return i10;
    }
}
