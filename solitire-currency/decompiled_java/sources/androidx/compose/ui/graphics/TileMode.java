package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TileMode.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class TileMode {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Clamp = m1899constructorimpl(0);
    private static final int Repeated = m1899constructorimpl(1);
    private static final int Mirror = m1899constructorimpl(2);
    private static final int Decal = m1899constructorimpl(3);

    /* JADX INFO: compiled from: TileMode.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getClamp-3opZhB0, reason: not valid java name */
        public final int m1905getClamp3opZhB0() {
            return TileMode.Clamp;
        }

        /* JADX INFO: renamed from: getDecal-3opZhB0, reason: not valid java name */
        public final int m1906getDecal3opZhB0() {
            return TileMode.Decal;
        }

        /* JADX INFO: renamed from: getMirror-3opZhB0, reason: not valid java name */
        public final int m1907getMirror3opZhB0() {
            return TileMode.Mirror;
        }

        /* JADX INFO: renamed from: getRepeated-3opZhB0, reason: not valid java name */
        public final int m1908getRepeated3opZhB0() {
            return TileMode.Repeated;
        }
    }

    private /* synthetic */ TileMode(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TileMode m1898boximpl(int i10) {
        return new TileMode(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1900equalsimpl(int i10, Object obj) {
        return (obj instanceof TileMode) && i10 == ((TileMode) obj).m1904unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1901equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1903toStringimpl(int i10) {
        return m1901equalsimpl0(i10, Clamp) ? "Clamp" : m1901equalsimpl0(i10, Repeated) ? "Repeated" : m1901equalsimpl0(i10, Mirror) ? "Mirror" : m1901equalsimpl0(i10, Decal) ? "Decal" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1900equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1902hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1903toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1904unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1899constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1902hashCodeimpl(int i10) {
        return i10;
    }
}
