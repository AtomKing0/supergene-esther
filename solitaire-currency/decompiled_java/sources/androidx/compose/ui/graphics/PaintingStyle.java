package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PaintingStyle.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class PaintingStyle {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Fill = m1806constructorimpl(0);
    private static final int Stroke = m1806constructorimpl(1);
    private final int value;

    /* JADX INFO: compiled from: PaintingStyle.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getFill-TiuSbCo, reason: not valid java name */
        public final int m1812getFillTiuSbCo() {
            return PaintingStyle.Fill;
        }

        /* JADX INFO: renamed from: getStroke-TiuSbCo, reason: not valid java name */
        public final int m1813getStrokeTiuSbCo() {
            return PaintingStyle.Stroke;
        }
    }

    private /* synthetic */ PaintingStyle(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PaintingStyle m1805boximpl(int i10) {
        return new PaintingStyle(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1807equalsimpl(int i10, Object obj) {
        return (obj instanceof PaintingStyle) && i10 == ((PaintingStyle) obj).m1811unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1808equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1810toStringimpl(int i10) {
        return m1808equalsimpl0(i10, Fill) ? "Fill" : m1808equalsimpl0(i10, Stroke) ? "Stroke" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1807equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1809hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1810toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1811unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1806constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1809hashCodeimpl(int i10) {
        return i10;
    }
}
