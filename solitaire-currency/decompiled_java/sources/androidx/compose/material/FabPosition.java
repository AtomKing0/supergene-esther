package androidx.compose.material;

import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Scaffold.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FabPosition {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Center = m1032constructorimpl(0);
    private static final int End = m1032constructorimpl(1);

    /* JADX INFO: compiled from: Scaffold.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getCenter-5ygKITE, reason: not valid java name */
        public final int m1038getCenter5ygKITE() {
            return FabPosition.Center;
        }

        /* JADX INFO: renamed from: getEnd-5ygKITE, reason: not valid java name */
        public final int m1039getEnd5ygKITE() {
            return FabPosition.End;
        }
    }

    private /* synthetic */ FabPosition(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FabPosition m1031boximpl(int i10) {
        return new FabPosition(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1033equalsimpl(int i10, Object obj) {
        return (obj instanceof FabPosition) && i10 == ((FabPosition) obj).m1037unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1034equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1036toStringimpl(int i10) {
        return m1034equalsimpl0(i10, Center) ? "FabPosition.Center" : "FabPosition.End";
    }

    public boolean equals(Object obj) {
        return m1033equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1035hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1036toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1037unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1032constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1035hashCodeimpl(int i10) {
        return i10;
    }
}
