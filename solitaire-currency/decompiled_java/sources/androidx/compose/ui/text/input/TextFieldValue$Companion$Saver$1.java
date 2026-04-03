package androidx.compose.ui.text.input;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.SaversKt;
import androidx.compose.ui.text.TextRange;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextFieldValue.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextFieldValue$Companion$Saver$1 extends v implements p<SaverScope, TextFieldValue, Object> {
    public static final TextFieldValue$Companion$Saver$1 INSTANCE = new TextFieldValue$Companion$Saver$1();

    TextFieldValue$Companion$Saver$1() {
        super(2);
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull SaverScope Saver, @NotNull TextFieldValue it) {
        t.i(Saver, "$this$Saver");
        t.i(it, "it");
        return kotlin.collections.v.f(SaversKt.save(it.getAnnotatedString(), SaversKt.getAnnotatedStringSaver(), Saver), SaversKt.save(TextRange.m3323boximpl(it.m3510getSelectiond9O1mEE()), SaversKt.getSaver(TextRange.Companion), Saver));
    }
}
