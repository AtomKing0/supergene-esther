package androidx.compose.ui.input.key;

import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: KeyEvent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class KeyEventType {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Unknown = m2751constructorimpl(0);
    private static final int KeyUp = m2751constructorimpl(1);
    private static final int KeyDown = m2751constructorimpl(2);

    /* JADX INFO: compiled from: KeyEvent.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getKeyDown-CS__XNY, reason: not valid java name */
        public final int m2757getKeyDownCS__XNY() {
            return KeyEventType.KeyDown;
        }

        /* JADX INFO: renamed from: getKeyUp-CS__XNY, reason: not valid java name */
        public final int m2758getKeyUpCS__XNY() {
            return KeyEventType.KeyUp;
        }

        /* JADX INFO: renamed from: getUnknown-CS__XNY, reason: not valid java name */
        public final int m2759getUnknownCS__XNY() {
            return KeyEventType.Unknown;
        }
    }

    private /* synthetic */ KeyEventType(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ KeyEventType m2750boximpl(int i10) {
        return new KeyEventType(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2752equalsimpl(int i10, Object obj) {
        return (obj instanceof KeyEventType) && i10 == ((KeyEventType) obj).m2756unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2753equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2755toStringimpl(int i10) {
        return m2753equalsimpl0(i10, KeyUp) ? "KeyUp" : m2753equalsimpl0(i10, KeyDown) ? "KeyDown" : m2753equalsimpl0(i10, Unknown) ? "Unknown" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m2752equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2754hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m2755toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2756unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m2751constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2754hashCodeimpl(int i10) {
        return i10;
    }
}
