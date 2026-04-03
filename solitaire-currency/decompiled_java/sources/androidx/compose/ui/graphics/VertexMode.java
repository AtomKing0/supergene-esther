package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VertexMode.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class VertexMode {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Triangles = m1925constructorimpl(0);
    private static final int TriangleStrip = m1925constructorimpl(1);
    private static final int TriangleFan = m1925constructorimpl(2);

    /* JADX INFO: compiled from: VertexMode.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getTriangleFan-c2xauaI, reason: not valid java name */
        public final int m1931getTriangleFanc2xauaI() {
            return VertexMode.TriangleFan;
        }

        /* JADX INFO: renamed from: getTriangleStrip-c2xauaI, reason: not valid java name */
        public final int m1932getTriangleStripc2xauaI() {
            return VertexMode.TriangleStrip;
        }

        /* JADX INFO: renamed from: getTriangles-c2xauaI, reason: not valid java name */
        public final int m1933getTrianglesc2xauaI() {
            return VertexMode.Triangles;
        }
    }

    private /* synthetic */ VertexMode(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ VertexMode m1924boximpl(int i10) {
        return new VertexMode(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1926equalsimpl(int i10, Object obj) {
        return (obj instanceof VertexMode) && i10 == ((VertexMode) obj).m1930unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1927equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1929toStringimpl(int i10) {
        return m1927equalsimpl0(i10, Triangles) ? "Triangles" : m1927equalsimpl0(i10, TriangleStrip) ? "TriangleStrip" : m1927equalsimpl0(i10, TriangleFan) ? "TriangleFan" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1926equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1928hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1929toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1930unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1925constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1928hashCodeimpl(int i10) {
        return i10;
    }
}
