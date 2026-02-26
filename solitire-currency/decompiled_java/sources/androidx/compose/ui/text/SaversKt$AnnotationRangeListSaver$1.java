package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.AnnotatedString;
import h9.p;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaversKt$AnnotationRangeListSaver$1 extends v implements p<SaverScope, List<? extends AnnotatedString.Range<? extends Object>>, Object> {
    public static final SaversKt$AnnotationRangeListSaver$1 INSTANCE = new SaversKt$AnnotationRangeListSaver$1();

    SaversKt$AnnotationRangeListSaver$1() {
        super(2);
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull SaverScope Saver, @NotNull List<? extends AnnotatedString.Range<? extends Object>> it) {
        t.i(Saver, "$this$Saver");
        t.i(it, "it");
        ArrayList arrayList = new ArrayList(it.size());
        int size = it.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(SaversKt.save(it.get(i10), SaversKt.AnnotationRangeSaver, Saver));
        }
        return arrayList;
    }
}
