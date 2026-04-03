package androidx.compose.material;

import androidx.compose.ui.text.TextStyle;
import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Text.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextKt$LocalTextStyle$1 extends v implements a<TextStyle> {
    public static final TextKt$LocalTextStyle$1 INSTANCE = new TextKt$LocalTextStyle$1();

    TextKt$LocalTextStyle$1() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final TextStyle invoke() {
        return TextStyle.Companion.getDefault();
    }
}
