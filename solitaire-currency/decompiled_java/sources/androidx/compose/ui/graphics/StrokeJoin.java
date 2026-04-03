package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StrokeJoin.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class StrokeJoin {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Miter = m1889constructorimpl(0);
    private static final int Round = m1889constructorimpl(1);
    private static final int Bevel = m1889constructorimpl(2);

    /* JADX INFO: compiled from: StrokeJoin.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getBevel-LxFBmk8, reason: not valid java name */
        public final int m1895getBevelLxFBmk8() {
            return StrokeJoin.Bevel;
        }

        /* JADX INFO: renamed from: getMiter-LxFBmk8, reason: not valid java name */
        public final int m1896getMiterLxFBmk8() {
            return StrokeJoin.Miter;
        }

        /* JADX INFO: renamed from: getRound-LxFBmk8, reason: not valid java name */
        public final int m1897getRoundLxFBmk8() {
            return StrokeJoin.Round;
        }
    }

    private /* synthetic */ StrokeJoin(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ StrokeJoin m1888boximpl(int i10) {
        return new StrokeJoin(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1890equalsimpl(int i10, Object obj) {
        return (obj instanceof StrokeJoin) && i10 == ((StrokeJoin) obj).m1894unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1891equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1893toStringimpl(int i10) {
        return m1891equalsimpl0(i10, Miter) ? "Miter" : m1891equalsimpl0(i10, Round) ? "Round" : m1891equalsimpl0(i10, Bevel) ? "Bevel" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1890equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1892hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1893toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1894unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1889constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1892hashCodeimpl(int i10) {
        return i10;
    }
}
