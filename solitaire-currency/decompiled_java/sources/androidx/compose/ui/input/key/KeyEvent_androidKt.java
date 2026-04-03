package androidx.compose.ui.input.key;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: KeyEvent.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class KeyEvent_androidKt {
    /* JADX INFO: renamed from: getKey-ZmokQxo, reason: not valid java name */
    public static final long m2760getKeyZmokQxo(@NotNull android.view.KeyEvent key) {
        t.i(key, "$this$key");
        return Key_androidKt.Key(key.getKeyCode());
    }

    /* JADX INFO: renamed from: getType-ZmokQxo, reason: not valid java name */
    public static final int m2761getTypeZmokQxo(@NotNull android.view.KeyEvent type) {
        t.i(type, "$this$type");
        int action = type.getAction();
        return action != 0 ? action != 1 ? KeyEventType.Companion.m2759getUnknownCS__XNY() : KeyEventType.Companion.m2758getKeyUpCS__XNY() : KeyEventType.Companion.m2757getKeyDownCS__XNY();
    }

    /* JADX INFO: renamed from: getUtf16CodePoint-ZmokQxo, reason: not valid java name */
    public static final int m2762getUtf16CodePointZmokQxo(@NotNull android.view.KeyEvent utf16CodePoint) {
        t.i(utf16CodePoint, "$this$utf16CodePoint");
        return utf16CodePoint.getUnicodeChar();
    }

    /* JADX INFO: renamed from: isAltPressed-ZmokQxo, reason: not valid java name */
    public static final boolean m2763isAltPressedZmokQxo(@NotNull android.view.KeyEvent isAltPressed) {
        t.i(isAltPressed, "$this$isAltPressed");
        return isAltPressed.isAltPressed();
    }

    /* JADX INFO: renamed from: isCtrlPressed-ZmokQxo, reason: not valid java name */
    public static final boolean m2764isCtrlPressedZmokQxo(@NotNull android.view.KeyEvent isCtrlPressed) {
        t.i(isCtrlPressed, "$this$isCtrlPressed");
        return isCtrlPressed.isCtrlPressed();
    }

    /* JADX INFO: renamed from: isMetaPressed-ZmokQxo, reason: not valid java name */
    public static final boolean m2765isMetaPressedZmokQxo(@NotNull android.view.KeyEvent isMetaPressed) {
        t.i(isMetaPressed, "$this$isMetaPressed");
        return isMetaPressed.isMetaPressed();
    }

    /* JADX INFO: renamed from: isShiftPressed-ZmokQxo, reason: not valid java name */
    public static final boolean m2766isShiftPressedZmokQxo(@NotNull android.view.KeyEvent isShiftPressed) {
        t.i(isShiftPressed, "$this$isShiftPressed");
        return isShiftPressed.isShiftPressed();
    }
}
