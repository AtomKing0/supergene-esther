package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FilterQuality.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class FilterQuality {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int None = m1677constructorimpl(0);
    private static final int Low = m1677constructorimpl(1);
    private static final int Medium = m1677constructorimpl(2);
    private static final int High = m1677constructorimpl(3);

    /* JADX INFO: compiled from: FilterQuality.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getHigh-f-v9h1I, reason: not valid java name */
        public final int m1683getHighfv9h1I() {
            return FilterQuality.High;
        }

        /* JADX INFO: renamed from: getLow-f-v9h1I, reason: not valid java name */
        public final int m1684getLowfv9h1I() {
            return FilterQuality.Low;
        }

        /* JADX INFO: renamed from: getMedium-f-v9h1I, reason: not valid java name */
        public final int m1685getMediumfv9h1I() {
            return FilterQuality.Medium;
        }

        /* JADX INFO: renamed from: getNone-f-v9h1I, reason: not valid java name */
        public final int m1686getNonefv9h1I() {
            return FilterQuality.None;
        }
    }

    private /* synthetic */ FilterQuality(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FilterQuality m1676boximpl(int i10) {
        return new FilterQuality(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1678equalsimpl(int i10, Object obj) {
        return (obj instanceof FilterQuality) && i10 == ((FilterQuality) obj).m1682unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1679equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1681toStringimpl(int i10) {
        return m1679equalsimpl0(i10, None) ? "None" : m1679equalsimpl0(i10, Low) ? "Low" : m1679equalsimpl0(i10, Medium) ? "Medium" : m1679equalsimpl0(i10, High) ? "High" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1678equalsimpl(this.value, obj);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m1680hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1681toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1682unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1677constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1680hashCodeimpl(int i10) {
        return i10;
    }
}
