package androidx.compose.ui.input.key;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: KeyEvent.kt */
/* JADX INFO: loaded from: classes.dex */
public final class KeyEvent {

    @NotNull
    private final android.view.KeyEvent nativeKeyEvent;

    private /* synthetic */ KeyEvent(android.view.KeyEvent keyEvent) {
        this.nativeKeyEvent = keyEvent;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ KeyEvent m2743boximpl(android.view.KeyEvent keyEvent) {
        return new KeyEvent(keyEvent);
    }

    @NotNull
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static android.view.KeyEvent m2744constructorimpl(@NotNull android.view.KeyEvent nativeKeyEvent) {
        t.i(nativeKeyEvent, "nativeKeyEvent");
        return nativeKeyEvent;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2745equalsimpl(android.view.KeyEvent keyEvent, Object obj) {
        return (obj instanceof KeyEvent) && t.d(keyEvent, ((KeyEvent) obj).m2749unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2746equalsimpl0(android.view.KeyEvent keyEvent, android.view.KeyEvent keyEvent2) {
        return t.d(keyEvent, keyEvent2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2747hashCodeimpl(android.view.KeyEvent keyEvent) {
        return keyEvent.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2748toStringimpl(android.view.KeyEvent keyEvent) {
        return "KeyEvent(nativeKeyEvent=" + keyEvent + ')';
    }

    public boolean equals(Object obj) {
        return m2745equalsimpl(this.nativeKeyEvent, obj);
    }

    @NotNull
    public final android.view.KeyEvent getNativeKeyEvent() {
        return this.nativeKeyEvent;
    }

    public int hashCode() {
        return m2747hashCodeimpl(this.nativeKeyEvent);
    }

    public String toString() {
        return m2748toStringimpl(this.nativeKeyEvent);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ android.view.KeyEvent m2749unboximpl() {
        return this.nativeKeyEvent;
    }
}
