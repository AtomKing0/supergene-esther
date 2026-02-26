package androidx.compose.foundation.text.selection;

import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextSelectionColors.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextSelectionColorsKt$LocalTextSelectionColors$1 extends v implements h9.a<TextSelectionColors> {
    public static final TextSelectionColorsKt$LocalTextSelectionColors$1 INSTANCE = new TextSelectionColorsKt$LocalTextSelectionColors$1();

    TextSelectionColorsKt$LocalTextSelectionColors$1() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final TextSelectionColors invoke() {
        return TextSelectionColorsKt.DefaultTextSelectionColors;
    }
}
