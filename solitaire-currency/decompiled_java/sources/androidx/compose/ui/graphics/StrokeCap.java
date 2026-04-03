package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StrokeCap.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class StrokeCap {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Butt = m1879constructorimpl(0);
    private static final int Round = m1879constructorimpl(1);
    private static final int Square = m1879constructorimpl(2);

    /* JADX INFO: compiled from: StrokeCap.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getButt-KaPHkGw, reason: not valid java name */
        public final int m1885getButtKaPHkGw() {
            return StrokeCap.Butt;
        }

        /* JADX INFO: renamed from: getRound-KaPHkGw, reason: not valid java name */
        public final int m1886getRoundKaPHkGw() {
            return StrokeCap.Round;
        }

        /* JADX INFO: renamed from: getSquare-KaPHkGw, reason: not valid java name */
        public final int m1887getSquareKaPHkGw() {
            return StrokeCap.Square;
        }
    }

    private /* synthetic */ StrokeCap(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ StrokeCap m1878boximpl(int i10) {
        return new StrokeCap(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1880equalsimpl(int i10, Object obj) {
        return (obj instanceof StrokeCap) && i10 == ((StrokeCap) obj).m1884unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1881equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1883toStringimpl(int i10) {
        return m1881equalsimpl0(i10, Butt) ? "Butt" : m1881equalsimpl0(i10, Round) ? "Round" : m1881equalsimpl0(i10, Square) ? "Square" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1880equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1882hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1883toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1884unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1879constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1882hashCodeimpl(int i10) {
        return i10;
    }
}
