package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import h9.l;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaversKt$AnnotatedStringSaver$2 extends v implements l<Object, AnnotatedString> {
    public static final SaversKt$AnnotatedStringSaver$2 INSTANCE = new SaversKt$AnnotatedStringSaver$2();

    SaversKt$AnnotatedStringSaver$2() {
        super(1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.l
    @Nullable
    public final AnnotatedString invoke(@NotNull Object it) {
        t.i(it, "it");
        List list = (List) it;
        Object obj = list.get(0);
        List list2 = null;
        String str = obj != null ? (String) obj : null;
        t.f(str);
        Object obj2 = list.get(1);
        Saver saver = SaversKt.AnnotationRangeListSaver;
        Boolean bool = Boolean.FALSE;
        List list3 = (t.d(obj2, bool) || obj2 == null) ? null : (List) saver.restore(obj2);
        t.f(list3);
        Object obj3 = list.get(2);
        List list4 = (t.d(obj3, bool) || obj3 == null) ? null : (List) SaversKt.AnnotationRangeListSaver.restore(obj3);
        t.f(list4);
        Object obj4 = list.get(3);
        Saver saver2 = SaversKt.AnnotationRangeListSaver;
        if (!t.d(obj4, bool) && obj4 != null) {
            list2 = (List) saver2.restore(obj4);
        }
        t.f(list2);
        return new AnnotatedString(str, list3, list4, list2);
    }
}
