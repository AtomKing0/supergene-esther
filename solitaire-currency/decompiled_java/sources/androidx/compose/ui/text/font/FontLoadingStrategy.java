package androidx.compose.ui.text.font;

import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FontLoadingStrategy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FontLoadingStrategy {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Blocking = m3398constructorimpl(0);
    private static final int OptionalLocal = m3398constructorimpl(1);
    private static final int Async = m3398constructorimpl(2);

    /* JADX INFO: compiled from: FontLoadingStrategy.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getAsync-PKNRLFQ, reason: not valid java name */
        public final int m3404getAsyncPKNRLFQ() {
            return FontLoadingStrategy.Async;
        }

        /* JADX INFO: renamed from: getBlocking-PKNRLFQ, reason: not valid java name */
        public final int m3405getBlockingPKNRLFQ() {
            return FontLoadingStrategy.Blocking;
        }

        /* JADX INFO: renamed from: getOptionalLocal-PKNRLFQ, reason: not valid java name */
        public final int m3406getOptionalLocalPKNRLFQ() {
            return FontLoadingStrategy.OptionalLocal;
        }
    }

    private /* synthetic */ FontLoadingStrategy(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FontLoadingStrategy m3397boximpl(int i10) {
        return new FontLoadingStrategy(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3399equalsimpl(int i10, Object obj) {
        return (obj instanceof FontLoadingStrategy) && i10 == ((FontLoadingStrategy) obj).m3403unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3400equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3402toStringimpl(int i10) {
        if (m3400equalsimpl0(i10, Blocking)) {
            return "Blocking";
        }
        if (m3400equalsimpl0(i10, OptionalLocal)) {
            return "Optional";
        }
        if (m3400equalsimpl0(i10, Async)) {
            return "Async";
        }
        return "Invalid(value=" + i10 + ')';
    }

    public boolean equals(Object obj) {
        return m3399equalsimpl(this.value, obj);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m3401hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m3402toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3403unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m3398constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3401hashCodeimpl(int i10) {
        return i10;
    }
}
