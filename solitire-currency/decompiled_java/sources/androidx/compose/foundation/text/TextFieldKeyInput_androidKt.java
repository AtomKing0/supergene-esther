package androidx.compose.foundation.text;

import android.view.KeyEvent;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextFieldKeyInput.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldKeyInput_androidKt {
    /* JADX INFO: renamed from: isTypedEvent-ZmokQxo, reason: not valid java name */
    public static final boolean m729isTypedEventZmokQxo(@NotNull KeyEvent isTypedEvent) {
        t.i(isTypedEvent, "$this$isTypedEvent");
        return isTypedEvent.getAction() == 0 && isTypedEvent.getUnicodeChar() != 0;
    }
}
