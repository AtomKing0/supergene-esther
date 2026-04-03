package androidx.compose.ui.text;

import h9.l;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaversKt$TextRangeSaver$2 extends v implements l<Object, TextRange> {
    public static final SaversKt$TextRangeSaver$2 INSTANCE = new SaversKt$TextRangeSaver$2();

    SaversKt$TextRangeSaver$2() {
        super(1);
    }

    @Override // h9.l
    @Nullable
    /* JADX INFO: renamed from: invoke-VqIyPBM, reason: not valid java name and merged with bridge method [inline-methods] */
    public final TextRange invoke(@NotNull Object it) {
        t.i(it, "it");
        List list = (List) it;
        Object obj = list.get(0);
        Integer num = obj != null ? (Integer) obj : null;
        t.f(num);
        int iIntValue = num.intValue();
        Object obj2 = list.get(1);
        Integer num2 = obj2 != null ? (Integer) obj2 : null;
        t.f(num2);
        return TextRange.m3323boximpl(TextRangeKt.TextRange(iIntValue, num2.intValue()));
    }
}
