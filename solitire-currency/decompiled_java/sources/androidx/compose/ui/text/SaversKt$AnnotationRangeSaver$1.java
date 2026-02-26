package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.AnnotatedString;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.q;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaversKt$AnnotationRangeSaver$1 extends v implements p<SaverScope, AnnotatedString.Range<? extends Object>, Object> {
    public static final SaversKt$AnnotationRangeSaver$1 INSTANCE = new SaversKt$AnnotationRangeSaver$1();

    /* JADX INFO: compiled from: Savers.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnnotationType.values().length];
            iArr[AnnotationType.Paragraph.ordinal()] = 1;
            iArr[AnnotationType.Span.ordinal()] = 2;
            iArr[AnnotationType.VerbatimTts.ordinal()] = 3;
            iArr[AnnotationType.String.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    SaversKt$AnnotationRangeSaver$1() {
        super(2);
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull SaverScope Saver, @NotNull AnnotatedString.Range<? extends Object> it) {
        Object objSave;
        t.i(Saver, "$this$Saver");
        t.i(it, "it");
        Object item = it.getItem();
        AnnotationType annotationType = item instanceof ParagraphStyle ? AnnotationType.Paragraph : item instanceof SpanStyle ? AnnotationType.Span : item instanceof VerbatimTtsAnnotation ? AnnotationType.VerbatimTts : AnnotationType.String;
        int i10 = WhenMappings.$EnumSwitchMapping$0[annotationType.ordinal()];
        if (i10 == 1) {
            objSave = SaversKt.save((ParagraphStyle) it.getItem(), SaversKt.getParagraphStyleSaver(), Saver);
        } else if (i10 == 2) {
            objSave = SaversKt.save((SpanStyle) it.getItem(), SaversKt.getSpanStyleSaver(), Saver);
        } else if (i10 == 3) {
            objSave = SaversKt.save((VerbatimTtsAnnotation) it.getItem(), SaversKt.VerbatimTtsAnnotationSaver, Saver);
        } else {
            if (i10 != 4) {
                throw new q();
            }
            objSave = SaversKt.save(it.getItem());
        }
        return kotlin.collections.v.f(SaversKt.save(annotationType), objSave, SaversKt.save(Integer.valueOf(it.getStart())), SaversKt.save(Integer.valueOf(it.getEnd())), SaversKt.save(it.getTag()));
    }
}
