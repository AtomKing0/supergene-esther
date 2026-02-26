package androidx.compose.ui.hapticfeedback;

import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HapticFeedbackType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class HapticFeedbackType {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int value;

    /* JADX INFO: compiled from: HapticFeedbackType.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getLongPress-5zf0vsI, reason: not valid java name */
        public final int m2146getLongPress5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m2148getLongPress5zf0vsI();
        }

        /* JADX INFO: renamed from: getTextHandleMove-5zf0vsI, reason: not valid java name */
        public final int m2147getTextHandleMove5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m2149getTextHandleMove5zf0vsI();
        }

        @NotNull
        public final List<HapticFeedbackType> values() {
            return v.n(HapticFeedbackType.m2139boximpl(m2146getLongPress5zf0vsI()), HapticFeedbackType.m2139boximpl(m2147getTextHandleMove5zf0vsI()));
        }
    }

    private /* synthetic */ HapticFeedbackType(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ HapticFeedbackType m2139boximpl(int i10) {
        return new HapticFeedbackType(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2141equalsimpl(int i10, Object obj) {
        return (obj instanceof HapticFeedbackType) && i10 == ((HapticFeedbackType) obj).m2145unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2142equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2144toStringimpl(int i10) {
        Companion companion = Companion;
        return m2142equalsimpl0(i10, companion.m2146getLongPress5zf0vsI()) ? "LongPress" : m2142equalsimpl0(i10, companion.m2147getTextHandleMove5zf0vsI()) ? "TextHandleMove" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m2141equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2143hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m2144toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2145unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m2140constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2143hashCodeimpl(int i10) {
        return i10;
    }
}
