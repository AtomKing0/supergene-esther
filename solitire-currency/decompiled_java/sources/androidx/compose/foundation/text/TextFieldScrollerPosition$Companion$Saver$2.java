package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import h9.l;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextFieldScroll.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextFieldScrollerPosition$Companion$Saver$2 extends v implements l<List<? extends Object>, TextFieldScrollerPosition> {
    public static final TextFieldScrollerPosition$Companion$Saver$2 INSTANCE = new TextFieldScrollerPosition$Companion$Saver$2();

    TextFieldScrollerPosition$Companion$Saver$2() {
        super(1);
    }

    @Override // h9.l
    @Nullable
    public final TextFieldScrollerPosition invoke(@NotNull List<? extends Object> restored) {
        t.i(restored, "restored");
        return new TextFieldScrollerPosition(((Boolean) restored.get(1)).booleanValue() ? Orientation.Vertical : Orientation.Horizontal, ((Float) restored.get(0)).floatValue());
    }
}
