package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.AnnotatedString;
import h9.l;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.q;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaversKt$AnnotationRangeSaver$2 extends v implements l<Object, AnnotatedString.Range<? extends Object>> {
    public static final SaversKt$AnnotationRangeSaver$2 INSTANCE = new SaversKt$AnnotationRangeSaver$2();

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

    SaversKt$AnnotationRangeSaver$2() {
        super(1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.l
    @Nullable
    public final AnnotatedString.Range<? extends Object> invoke(@NotNull Object it) {
        t.i(it, "it");
        List list = (List) it;
        Object obj = list.get(0);
        AnnotationType annotationType = obj != null ? (AnnotationType) obj : null;
        t.f(annotationType);
        Object obj2 = list.get(2);
        Integer num = obj2 != null ? (Integer) obj2 : null;
        t.f(num);
        int iIntValue = num.intValue();
        Object obj3 = list.get(3);
        Integer num2 = obj3 != null ? (Integer) obj3 : null;
        t.f(num2);
        int iIntValue2 = num2.intValue();
        Object obj4 = list.get(4);
        String str = obj4 != null ? (String) obj4 : null;
        t.f(str);
        int i10 = WhenMappings.$EnumSwitchMapping$0[annotationType.ordinal()];
        if (i10 == 1) {
            Object obj5 = list.get(1);
            Saver<ParagraphStyle, Object> paragraphStyleSaver = SaversKt.getParagraphStyleSaver();
            if (!t.d(obj5, Boolean.FALSE) && obj5 != null) {
                paragraphStyleRestore = paragraphStyleSaver.restore(obj5);
            }
            t.f(paragraphStyleRestore);
            return new AnnotatedString.Range<>(paragraphStyleRestore, iIntValue, iIntValue2, str);
        }
        if (i10 == 2) {
            Object obj6 = list.get(1);
            Saver<SpanStyle, Object> spanStyleSaver = SaversKt.getSpanStyleSaver();
            if (!t.d(obj6, Boolean.FALSE) && obj6 != null) {
                paragraphStyleRestore = spanStyleSaver.restore(obj6);
            }
            t.f(paragraphStyleRestore);
            return new AnnotatedString.Range<>(paragraphStyleRestore, iIntValue, iIntValue2, str);
        }
        if (i10 != 3) {
            if (i10 != 4) {
                throw new q();
            }
            Object obj7 = list.get(1);
            paragraphStyleRestore = obj7 != null ? (String) obj7 : null;
            t.f(paragraphStyleRestore);
            return new AnnotatedString.Range<>(paragraphStyleRestore, iIntValue, iIntValue2, str);
        }
        Object obj8 = list.get(1);
        Saver saver = SaversKt.VerbatimTtsAnnotationSaver;
        if (!t.d(obj8, Boolean.FALSE) && obj8 != null) {
            paragraphStyleRestore = (VerbatimTtsAnnotation) saver.restore(obj8);
        }
        t.f(paragraphStyleRestore);
        return new AnnotatedString.Range<>(paragraphStyleRestore, iIntValue, iIntValue2, str);
    }
}
