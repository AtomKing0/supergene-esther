package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaversKt$AnnotatedStringSaver$1 extends v implements p<SaverScope, AnnotatedString, Object> {
    public static final SaversKt$AnnotatedStringSaver$1 INSTANCE = new SaversKt$AnnotatedStringSaver$1();

    SaversKt$AnnotatedStringSaver$1() {
        super(2);
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull SaverScope Saver, @NotNull AnnotatedString it) {
        t.i(Saver, "$this$Saver");
        t.i(it, "it");
        return kotlin.collections.v.f(SaversKt.save(it.getText()), SaversKt.save(it.getSpanStyles(), SaversKt.AnnotationRangeListSaver, Saver), SaversKt.save(it.getParagraphStyles(), SaversKt.AnnotationRangeListSaver, Saver), SaversKt.save(it.getAnnotations$ui_text_release(), SaversKt.AnnotationRangeListSaver, Saver));
    }
}
