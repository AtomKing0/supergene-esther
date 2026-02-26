package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import h9.l;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaversKt$TextIndentSaver$2 extends v implements l<Object, TextIndent> {
    public static final SaversKt$TextIndentSaver$2 INSTANCE = new SaversKt$TextIndentSaver$2();

    SaversKt$TextIndentSaver$2() {
        super(1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.l
    @Nullable
    public final TextIndent invoke(@NotNull Object it) {
        t.i(it, "it");
        List list = (List) it;
        Object obj = list.get(0);
        TextUnit.Companion companion = TextUnit.Companion;
        Saver<TextUnit, Object> saver = SaversKt.getSaver(companion);
        Boolean bool = Boolean.FALSE;
        TextUnit textUnitRestore = null;
        TextUnit textUnitRestore2 = (t.d(obj, bool) || obj == null) ? null : saver.restore(obj);
        t.f(textUnitRestore2);
        long jM3863unboximpl = textUnitRestore2.m3863unboximpl();
        Object obj2 = list.get(1);
        Saver<TextUnit, Object> saver2 = SaversKt.getSaver(companion);
        if (!t.d(obj2, bool) && obj2 != null) {
            textUnitRestore = saver2.restore(obj2);
        }
        t.f(textUnitRestore);
        return new TextIndent(jM3863unboximpl, textUnitRestore.m3863unboximpl(), null);
    }
}
