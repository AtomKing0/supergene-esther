package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
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
final class SaversKt$ParagraphStyleSaver$2 extends v implements l<Object, ParagraphStyle> {
    public static final SaversKt$ParagraphStyleSaver$2 INSTANCE = new SaversKt$ParagraphStyleSaver$2();

    SaversKt$ParagraphStyleSaver$2() {
        super(1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.l
    @Nullable
    public final ParagraphStyle invoke(@NotNull Object it) {
        t.i(it, "it");
        List list = (List) it;
        Object obj = list.get(0);
        TextAlign textAlign = obj != null ? (TextAlign) obj : null;
        Object obj2 = list.get(1);
        TextDirection textDirection = obj2 != null ? (TextDirection) obj2 : null;
        Object obj3 = list.get(2);
        Saver<TextUnit, Object> saver = SaversKt.getSaver(TextUnit.Companion);
        Boolean bool = Boolean.FALSE;
        TextUnit textUnitRestore = (t.d(obj3, bool) || obj3 == null) ? null : saver.restore(obj3);
        t.f(textUnitRestore);
        long jM3863unboximpl = textUnitRestore.m3863unboximpl();
        Object obj4 = list.get(3);
        return new ParagraphStyle(textAlign, textDirection, jM3863unboximpl, (t.d(obj4, bool) || obj4 == null) ? null : SaversKt.getSaver(TextIndent.Companion).restore(obj4), null);
    }
}
