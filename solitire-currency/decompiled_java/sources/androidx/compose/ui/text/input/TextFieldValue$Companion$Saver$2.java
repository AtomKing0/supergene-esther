package androidx.compose.ui.text.input;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SaversKt;
import androidx.compose.ui.text.TextRange;
import h9.l;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextFieldValue.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextFieldValue$Companion$Saver$2 extends v implements l<Object, TextFieldValue> {
    public static final TextFieldValue$Companion$Saver$2 INSTANCE = new TextFieldValue$Companion$Saver$2();

    TextFieldValue$Companion$Saver$2() {
        super(1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.l
    @Nullable
    public final TextFieldValue invoke(@NotNull Object it) {
        t.i(it, "it");
        List list = (List) it;
        Object obj = list.get(0);
        Saver<AnnotatedString, Object> annotatedStringSaver = SaversKt.getAnnotatedStringSaver();
        Boolean bool = Boolean.FALSE;
        TextRange textRangeRestore = null;
        AnnotatedString annotatedStringRestore = (t.d(obj, bool) || obj == null) ? null : annotatedStringSaver.restore(obj);
        t.f(annotatedStringRestore);
        Object obj2 = list.get(1);
        Saver<TextRange, Object> saver = SaversKt.getSaver(TextRange.Companion);
        if (!t.d(obj2, bool) && obj2 != null) {
            textRangeRestore = saver.restore(obj2);
        }
        t.f(textRangeRestore);
        return new TextFieldValue(annotatedStringRestore, textRangeRestore.m3339unboximpl(), (TextRange) null, 4, (k) null);
    }
}
