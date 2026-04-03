package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PointMode.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class PointMode {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Points = m1840constructorimpl(0);
    private static final int Lines = m1840constructorimpl(1);
    private static final int Polygon = m1840constructorimpl(2);

    /* JADX INFO: compiled from: PointMode.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getLines-r_lszbg, reason: not valid java name */
        public final int m1846getLinesr_lszbg() {
            return PointMode.Lines;
        }

        /* JADX INFO: renamed from: getPoints-r_lszbg, reason: not valid java name */
        public final int m1847getPointsr_lszbg() {
            return PointMode.Points;
        }

        /* JADX INFO: renamed from: getPolygon-r_lszbg, reason: not valid java name */
        public final int m1848getPolygonr_lszbg() {
            return PointMode.Polygon;
        }
    }

    private /* synthetic */ PointMode(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PointMode m1839boximpl(int i10) {
        return new PointMode(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1841equalsimpl(int i10, Object obj) {
        return (obj instanceof PointMode) && i10 == ((PointMode) obj).m1845unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1842equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1844toStringimpl(int i10) {
        return m1842equalsimpl0(i10, Points) ? "Points" : m1842equalsimpl0(i10, Lines) ? "Lines" : m1842equalsimpl0(i10, Polygon) ? "Polygon" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1841equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1843hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1844toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1845unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1840constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1843hashCodeimpl(int i10) {
        return i10;
    }
}
