package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: KeyEventHelpers.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class KeyEventHelpers_androidKt {
    /* JADX INFO: renamed from: cancelsTextSelection-ZmokQxo, reason: not valid java name */
    public static final boolean m671cancelsTextSelectionZmokQxo(@NotNull KeyEvent cancelsTextSelection) {
        t.i(cancelsTextSelection, "$this$cancelsTextSelection");
        return cancelsTextSelection.getKeyCode() == 4 && KeyEventType.m2753equalsimpl0(KeyEvent_androidKt.m2761getTypeZmokQxo(cancelsTextSelection), KeyEventType.Companion.m2758getKeyUpCS__XNY());
    }

    public static final void showCharacterPalette() {
    }
}
