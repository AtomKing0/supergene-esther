package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import h9.l;
import h9.q;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.collections.d0;
import kotlin.collections.r0;
import kotlin.collections.y0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.y;

/* JADX INFO: compiled from: JvmAnnotatedString.jvm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class JvmAnnotatedString_jvmKt {
    private static final <T> void collectRangeTransitions(List<AnnotatedString.Range<T>> list, SortedSet<Integer> sortedSet) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            AnnotatedString.Range<T> range = list.get(i10);
            sortedSet.add(Integer.valueOf(range.getStart()));
            sortedSet.add(Integer.valueOf(range.getEnd()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final AnnotatedString transform(@NotNull AnnotatedString annotatedString, @NotNull q<? super String, ? super Integer, ? super Integer, String> transform) {
        t.i(annotatedString, "<this>");
        t.i(transform, "transform");
        TreeSet treeSetD = y0.d(0, Integer.valueOf(annotatedString.getText().length()));
        collectRangeTransitions(annotatedString.getSpanStyles(), treeSetD);
        collectRangeTransitions(annotatedString.getParagraphStyles(), treeSetD);
        n0 n0Var = new n0();
        n0Var.f29834a = "";
        Map mapL = r0.l(y.a(0, 0));
        d0.V0(treeSetD, 2, 0, false, new AnonymousClass1(n0Var, transform, annotatedString, mapL), 6, null);
        List<AnnotatedString.Range<SpanStyle>> spanStyles = annotatedString.getSpanStyles();
        ArrayList arrayList = new ArrayList(spanStyles.size());
        int size = spanStyles.size();
        for (int i10 = 0; i10 < size; i10++) {
            AnnotatedString.Range<SpanStyle> range = spanStyles.get(i10);
            SpanStyle item = range.getItem();
            Object obj = mapL.get(Integer.valueOf(range.getStart()));
            t.f(obj);
            int iIntValue = ((Number) obj).intValue();
            Object obj2 = mapL.get(Integer.valueOf(range.getEnd()));
            t.f(obj2);
            arrayList.add(new AnnotatedString.Range(item, iIntValue, ((Number) obj2).intValue()));
        }
        List<AnnotatedString.Range<ParagraphStyle>> paragraphStyles = annotatedString.getParagraphStyles();
        ArrayList arrayList2 = new ArrayList(paragraphStyles.size());
        int size2 = paragraphStyles.size();
        for (int i11 = 0; i11 < size2; i11++) {
            AnnotatedString.Range<ParagraphStyle> range2 = paragraphStyles.get(i11);
            ParagraphStyle item2 = range2.getItem();
            Object obj3 = mapL.get(Integer.valueOf(range2.getStart()));
            t.f(obj3);
            int iIntValue2 = ((Number) obj3).intValue();
            Object obj4 = mapL.get(Integer.valueOf(range2.getEnd()));
            t.f(obj4);
            arrayList2.add(new AnnotatedString.Range(item2, iIntValue2, ((Number) obj4).intValue()));
        }
        List<AnnotatedString.Range<? extends Object>> annotations$ui_text_release = annotatedString.getAnnotations$ui_text_release();
        ArrayList arrayList3 = new ArrayList(annotations$ui_text_release.size());
        int size3 = annotations$ui_text_release.size();
        for (int i12 = 0; i12 < size3; i12++) {
            AnnotatedString.Range<? extends Object> range3 = annotations$ui_text_release.get(i12);
            Object item3 = range3.getItem();
            Object obj5 = mapL.get(Integer.valueOf(range3.getStart()));
            t.f(obj5);
            int iIntValue3 = ((Number) obj5).intValue();
            Object obj6 = mapL.get(Integer.valueOf(range3.getEnd()));
            t.f(obj6);
            arrayList3.add(new AnnotatedString.Range(item3, iIntValue3, ((Number) obj6).intValue()));
        }
        return new AnnotatedString((String) n0Var.f29834a, arrayList, arrayList2, arrayList3);
    }

    /* JADX INFO: renamed from: androidx.compose.ui.text.JvmAnnotatedString_jvmKt$transform$1, reason: invalid class name */
    /* JADX INFO: compiled from: JvmAnnotatedString.jvm.kt */
    static final class AnonymousClass1 extends v implements l<List<? extends Integer>, Integer> {
        final /* synthetic */ Map<Integer, Integer> $offsetMap;
        final /* synthetic */ n0<String> $resultStr;
        final /* synthetic */ AnnotatedString $this_transform;
        final /* synthetic */ q<String, Integer, Integer, String> $transform;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(n0<String> n0Var, q<? super String, ? super Integer, ? super Integer, String> qVar, AnnotatedString annotatedString, Map<Integer, Integer> map) {
            super(1);
            this.$resultStr = n0Var;
            this.$transform = qVar;
            this.$this_transform = annotatedString;
            this.$offsetMap = map;
        }

        /* JADX WARN: Type inference failed for: r0v8, types: [T, java.lang.String] */
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Integer invoke2(@NotNull List<Integer> list) {
            t.i(list, "<name for destructuring parameter 0>");
            int iIntValue = list.get(0).intValue();
            int iIntValue2 = list.get(1).intValue();
            this.$resultStr.f29834a = this.$resultStr.f29834a + this.$transform.invoke(this.$this_transform.getText(), Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2));
            return this.$offsetMap.put(Integer.valueOf(iIntValue2), Integer.valueOf(this.$resultStr.f29834a.length()));
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Integer invoke(List<? extends Integer> list) {
            return invoke2((List<Integer>) list);
        }
    }
}
