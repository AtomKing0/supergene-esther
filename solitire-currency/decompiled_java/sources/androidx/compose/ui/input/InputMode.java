package androidx.compose.ui.input;

import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InputModeManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InputMode {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Touch = m2151constructorimpl(1);
    private static final int Keyboard = m2151constructorimpl(2);

    /* JADX INFO: compiled from: InputModeManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: renamed from: getKeyboard-aOaMEAU, reason: not valid java name */
        public final int m2157getKeyboardaOaMEAU() {
            return InputMode.Keyboard;
        }

        /* JADX INFO: renamed from: getTouch-aOaMEAU, reason: not valid java name */
        public final int m2158getTouchaOaMEAU() {
            return InputMode.Touch;
        }
    }

    private /* synthetic */ InputMode(int i10) {
        this.value = i10;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ InputMode m2150boximpl(int i10) {
        return new InputMode(i10);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2152equalsimpl(int i10, Object obj) {
        return (obj instanceof InputMode) && i10 == ((InputMode) obj).m2156unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2153equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2155toStringimpl(int i10) {
        return m2153equalsimpl0(i10, Touch) ? "Touch" : m2153equalsimpl0(i10, Keyboard) ? "Keyboard" : "Error";
    }

    public boolean equals(Object obj) {
        return m2152equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2154hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m2155toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2156unboximpl() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m2151constructorimpl(int i10) {
        return i10;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2154hashCodeimpl(int i10) {
        return i10;
    }
}
