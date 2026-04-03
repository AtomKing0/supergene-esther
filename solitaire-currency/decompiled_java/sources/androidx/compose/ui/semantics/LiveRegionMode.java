package androidx.compose.ui.semantics;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SemanticsProperties.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class LiveRegionMode {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Polite = m3219constructorimpl(0);
    private static final int Assertive = m3219constructorimpl(1);

    /* JADX INFO: compiled from: SemanticsProperties.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getAssertive-0phEisY, reason: not valid java name */
        public final int m3225getAssertive0phEisY() {
            return LiveRegionMode.Assertive;
        }

        /* JADX INFO: renamed from: getPolite-0phEisY, reason: not valid java name */
        public final int m3226getPolite0phEisY() {
            return LiveRegionMode.Polite;
        }
    }

    private /* synthetic */ LiveRegionMode(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ LiveRegionMode m3218boximpl(int i10) {
        return new LiveRegionMode(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3220equalsimpl(int i10, Object obj) {
        return (obj instanceof LiveRegionMode) && i10 == ((LiveRegionMode) obj).m3224unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3221equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3223toStringimpl(int i10) {
        return m3221equalsimpl0(i10, Polite) ? "Polite" : m3221equalsimpl0(i10, Assertive) ? "Assertive" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m3220equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3222hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m3223toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3224unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m3219constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3222hashCodeimpl(int i10) {
        return i10;
    }
}
