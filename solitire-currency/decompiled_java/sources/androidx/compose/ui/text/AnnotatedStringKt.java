package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.intl.LocaleList;
import h9.l;
import h9.p;
import h9.q;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AnnotatedString.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnnotatedStringKt {

    @NotNull
    private static final AnnotatedString EmptyAnnotatedString = new AnnotatedString("", null, null, 6, null);

    /* JADX INFO: renamed from: androidx.compose.ui.text.AnnotatedStringKt$capitalize$1, reason: invalid class name */
    /* JADX INFO: compiled from: AnnotatedString.kt */
    static final class AnonymousClass1 extends v implements q<String, Integer, Integer, String> {
        final /* synthetic */ LocaleList $localeList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LocaleList localeList) {
            super(3);
            this.$localeList = localeList;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ String invoke(String str, Integer num, Integer num2) {
            return invoke(str, num.intValue(), num2.intValue());
        }

        @NotNull
        public final String invoke(@NotNull String str, int i10, int i11) {
            t.i(str, "str");
            if (i10 == 0) {
                String strSubstring = str.substring(i10, i11);
                t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                return StringKt.capitalize(strSubstring, this.$localeList);
            }
            String strSubstring2 = str.substring(i10, i11);
            t.h(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring2;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.text.AnnotatedStringKt$decapitalize$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnnotatedString.kt */
    static final class C10051 extends v implements q<String, Integer, Integer, String> {
        final /* synthetic */ LocaleList $localeList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10051(LocaleList localeList) {
            super(3);
            this.$localeList = localeList;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ String invoke(String str, Integer num, Integer num2) {
            return invoke(str, num.intValue(), num2.intValue());
        }

        @NotNull
        public final String invoke(@NotNull String str, int i10, int i11) {
            t.i(str, "str");
            if (i10 == 0) {
                String strSubstring = str.substring(i10, i11);
                t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                return StringKt.decapitalize(strSubstring, this.$localeList);
            }
            String strSubstring2 = str.substring(i10, i11);
            t.h(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring2;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.text.AnnotatedStringKt$toLowerCase$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnnotatedString.kt */
    static final class C10061 extends v implements q<String, Integer, Integer, String> {
        final /* synthetic */ LocaleList $localeList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10061(LocaleList localeList) {
            super(3);
            this.$localeList = localeList;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ String invoke(String str, Integer num, Integer num2) {
            return invoke(str, num.intValue(), num2.intValue());
        }

        @NotNull
        public final String invoke(@NotNull String str, int i10, int i11) {
            t.i(str, "str");
            String strSubstring = str.substring(i10, i11);
            t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return StringKt.toLowerCase(strSubstring, this.$localeList);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.text.AnnotatedStringKt$toUpperCase$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AnnotatedString.kt */
    static final class C10071 extends v implements q<String, Integer, Integer, String> {
        final /* synthetic */ LocaleList $localeList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10071(LocaleList localeList) {
            super(3);
            this.$localeList = localeList;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ String invoke(String str, Integer num, Integer num2) {
            return invoke(str, num.intValue(), num2.intValue());
        }

        @NotNull
        public final String invoke(@NotNull String str, int i10, int i11) {
            t.i(str, "str");
            String strSubstring = str.substring(i10, i11);
            t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return StringKt.toUpperCase(strSubstring, this.$localeList);
        }
    }

    @NotNull
    public static final AnnotatedString AnnotatedString(@NotNull String text, @NotNull SpanStyle spanStyle, @Nullable ParagraphStyle paragraphStyle) {
        t.i(text, "text");
        t.i(spanStyle, "spanStyle");
        return new AnnotatedString(text, u.e(new AnnotatedString.Range(spanStyle, 0, text.length())), paragraphStyle == null ? kotlin.collections.v.l() : u.e(new AnnotatedString.Range(paragraphStyle, 0, text.length())));
    }

    public static /* synthetic */ AnnotatedString AnnotatedString$default(String str, SpanStyle spanStyle, ParagraphStyle paragraphStyle, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            paragraphStyle = null;
        }
        return AnnotatedString(str, spanStyle, paragraphStyle);
    }

    @NotNull
    public static final AnnotatedString buildAnnotatedString(@NotNull l<? super AnnotatedString.Builder, k0> builder) {
        t.i(builder, "builder");
        AnnotatedString.Builder builder2 = new AnnotatedString.Builder(0, 1, null);
        builder.invoke(builder2);
        return builder2.toAnnotatedString();
    }

    @NotNull
    public static final AnnotatedString capitalize(@NotNull AnnotatedString annotatedString, @NotNull LocaleList localeList) {
        t.i(annotatedString, "<this>");
        t.i(localeList, "localeList");
        return JvmAnnotatedString_jvmKt.transform(annotatedString, new AnonymousClass1(localeList));
    }

    public static /* synthetic */ AnnotatedString capitalize$default(AnnotatedString annotatedString, LocaleList localeList, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            localeList = LocaleList.Companion.getCurrent();
        }
        return capitalize(annotatedString, localeList);
    }

    public static final boolean contains(int i10, int i11, int i12, int i13) {
        if (i10 > i12 || i13 > i11) {
            return false;
        }
        if (i11 == i13) {
            if ((i12 == i13) != (i10 == i11)) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final AnnotatedString decapitalize(@NotNull AnnotatedString annotatedString, @NotNull LocaleList localeList) {
        t.i(annotatedString, "<this>");
        t.i(localeList, "localeList");
        return JvmAnnotatedString_jvmKt.transform(annotatedString, new C10051(localeList));
    }

    public static /* synthetic */ AnnotatedString decapitalize$default(AnnotatedString annotatedString, LocaleList localeList, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            localeList = LocaleList.Companion.getCurrent();
        }
        return decapitalize(annotatedString, localeList);
    }

    @NotNull
    public static final AnnotatedString emptyAnnotatedString() {
        return EmptyAnnotatedString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> List<AnnotatedString.Range<T>> filterRanges(List<? extends AnnotatedString.Range<? extends T>> list, int i10, int i11) {
        if (!(i10 <= i11)) {
            throw new IllegalArgumentException(("start (" + i10 + ") should be less than or equal to end (" + i11 + ')').toString());
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i12 = 0; i12 < size; i12++) {
            AnnotatedString.Range<? extends T> range = list.get(i12);
            AnnotatedString.Range<? extends T> range2 = range;
            if (intersect(i10, i11, range2.getStart(), range2.getEnd())) {
                arrayList.add(range);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i13 = 0; i13 < size2; i13++) {
            AnnotatedString.Range range3 = (AnnotatedString.Range) arrayList.get(i13);
            arrayList2.add(new AnnotatedString.Range(range3.getItem(), Math.max(i10, range3.getStart()) - i10, Math.min(i11, range3.getEnd()) - i10, range3.getTag()));
        }
        return arrayList2;
    }

    private static final List<AnnotatedString.Range<SpanStyle>> getLocalStyles(AnnotatedString annotatedString, int i10, int i11) {
        if (i10 == i11) {
            return kotlin.collections.v.l();
        }
        if (i10 == 0 && i11 >= annotatedString.getText().length()) {
            return annotatedString.getSpanStyles();
        }
        List<AnnotatedString.Range<SpanStyle>> spanStyles = annotatedString.getSpanStyles();
        ArrayList arrayList = new ArrayList(spanStyles.size());
        int size = spanStyles.size();
        for (int i12 = 0; i12 < size; i12++) {
            AnnotatedString.Range<SpanStyle> range = spanStyles.get(i12);
            AnnotatedString.Range<SpanStyle> range2 = range;
            if (intersect(i10, i11, range2.getStart(), range2.getEnd())) {
                arrayList.add(range);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i13 = 0; i13 < size2; i13++) {
            AnnotatedString.Range range3 = (AnnotatedString.Range) arrayList.get(i13);
            arrayList2.add(new AnnotatedString.Range(range3.getItem(), o.n(range3.getStart(), i10, i11) - i10, o.n(range3.getEnd(), i10, i11) - i10));
        }
        return arrayList2;
    }

    public static final boolean intersect(int i10, int i11, int i12, int i13) {
        return Math.max(i10, i12) < Math.min(i11, i13) || contains(i10, i11, i12, i13) || contains(i12, i13, i10, i11);
    }

    @NotNull
    public static final <T> List<T> mapEachParagraphStyle(@NotNull AnnotatedString annotatedString, @NotNull ParagraphStyle defaultParagraphStyle, @NotNull p<? super AnnotatedString, ? super AnnotatedString.Range<ParagraphStyle>, ? extends T> block) {
        t.i(annotatedString, "<this>");
        t.i(defaultParagraphStyle, "defaultParagraphStyle");
        t.i(block, "block");
        List<AnnotatedString.Range<ParagraphStyle>> listNormalizedParagraphStyles = normalizedParagraphStyles(annotatedString, defaultParagraphStyle);
        ArrayList arrayList = new ArrayList(listNormalizedParagraphStyles.size());
        int size = listNormalizedParagraphStyles.size();
        for (int i10 = 0; i10 < size; i10++) {
            AnnotatedString.Range<ParagraphStyle> range = listNormalizedParagraphStyles.get(i10);
            arrayList.add(block.mo4invoke(substringWithoutParagraphStyles(annotatedString, range.getStart(), range.getEnd()), range));
        }
        return arrayList;
    }

    @NotNull
    public static final List<AnnotatedString.Range<ParagraphStyle>> normalizedParagraphStyles(@NotNull AnnotatedString annotatedString, @NotNull ParagraphStyle defaultParagraphStyle) {
        t.i(annotatedString, "<this>");
        t.i(defaultParagraphStyle, "defaultParagraphStyle");
        int length = annotatedString.getText().length();
        List<AnnotatedString.Range<ParagraphStyle>> paragraphStyles = annotatedString.getParagraphStyles();
        ArrayList arrayList = new ArrayList();
        int size = paragraphStyles.size();
        int i10 = 0;
        int i11 = 0;
        while (i10 < size) {
            AnnotatedString.Range<ParagraphStyle> range = paragraphStyles.get(i10);
            ParagraphStyle paragraphStyleComponent1 = range.component1();
            int iComponent2 = range.component2();
            int iComponent3 = range.component3();
            if (iComponent2 != i11) {
                arrayList.add(new AnnotatedString.Range(defaultParagraphStyle, i11, iComponent2));
            }
            arrayList.add(new AnnotatedString.Range(defaultParagraphStyle.merge(paragraphStyleComponent1), iComponent2, iComponent3));
            i10++;
            i11 = iComponent3;
        }
        if (i11 != length) {
            arrayList.add(new AnnotatedString.Range(defaultParagraphStyle, i11, length));
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new AnnotatedString.Range(defaultParagraphStyle, 0, 0));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedString substringWithoutParagraphStyles(AnnotatedString annotatedString, int i10, int i11) {
        String strSubstring;
        if (i10 != i11) {
            strSubstring = annotatedString.getText().substring(i10, i11);
            t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        } else {
            strSubstring = "";
        }
        return new AnnotatedString(strSubstring, getLocalStyles(annotatedString, i10, i11), null, 4, null);
    }

    @NotNull
    public static final AnnotatedString toLowerCase(@NotNull AnnotatedString annotatedString, @NotNull LocaleList localeList) {
        t.i(annotatedString, "<this>");
        t.i(localeList, "localeList");
        return JvmAnnotatedString_jvmKt.transform(annotatedString, new C10061(localeList));
    }

    public static /* synthetic */ AnnotatedString toLowerCase$default(AnnotatedString annotatedString, LocaleList localeList, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            localeList = LocaleList.Companion.getCurrent();
        }
        return toLowerCase(annotatedString, localeList);
    }

    @NotNull
    public static final AnnotatedString toUpperCase(@NotNull AnnotatedString annotatedString, @NotNull LocaleList localeList) {
        t.i(annotatedString, "<this>");
        t.i(localeList, "localeList");
        return JvmAnnotatedString_jvmKt.transform(annotatedString, new C10071(localeList));
    }

    public static /* synthetic */ AnnotatedString toUpperCase$default(AnnotatedString annotatedString, LocaleList localeList, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            localeList = LocaleList.Companion.getCurrent();
        }
        return toUpperCase(annotatedString, localeList);
    }

    @ExperimentalTextApi
    @NotNull
    public static final <R> R withAnnotation(@NotNull AnnotatedString.Builder builder, @NotNull String tag, @NotNull String annotation, @NotNull l<? super AnnotatedString.Builder, ? extends R> block) {
        t.i(builder, "<this>");
        t.i(tag, "tag");
        t.i(annotation, "annotation");
        t.i(block, "block");
        int iPushStringAnnotation = builder.pushStringAnnotation(tag, annotation);
        try {
            return block.invoke(builder);
        } finally {
            r.b(1);
            builder.pop(iPushStringAnnotation);
            r.a(1);
        }
    }

    @NotNull
    public static final <R> R withStyle(@NotNull AnnotatedString.Builder builder, @NotNull SpanStyle style, @NotNull l<? super AnnotatedString.Builder, ? extends R> block) {
        t.i(builder, "<this>");
        t.i(style, "style");
        t.i(block, "block");
        int iPushStyle = builder.pushStyle(style);
        try {
            return block.invoke(builder);
        } finally {
            r.b(1);
            builder.pop(iPushStyle);
            r.a(1);
        }
    }

    @NotNull
    public static final AnnotatedString AnnotatedString(@NotNull String text, @NotNull ParagraphStyle paragraphStyle) {
        t.i(text, "text");
        t.i(paragraphStyle, "paragraphStyle");
        return new AnnotatedString(text, kotlin.collections.v.l(), u.e(new AnnotatedString.Range(paragraphStyle, 0, text.length())));
    }

    @ExperimentalTextApi
    @NotNull
    public static final <R> R withAnnotation(@NotNull AnnotatedString.Builder builder, @NotNull TtsAnnotation ttsAnnotation, @NotNull l<? super AnnotatedString.Builder, ? extends R> block) {
        t.i(builder, "<this>");
        t.i(ttsAnnotation, "ttsAnnotation");
        t.i(block, "block");
        int iPushTtsAnnotation = builder.pushTtsAnnotation(ttsAnnotation);
        try {
            return block.invoke(builder);
        } finally {
            r.b(1);
            builder.pop(iPushTtsAnnotation);
            r.a(1);
        }
    }

    @NotNull
    public static final <R> R withStyle(@NotNull AnnotatedString.Builder builder, @NotNull ParagraphStyle style, @NotNull l<? super AnnotatedString.Builder, ? extends R> block) {
        t.i(builder, "<this>");
        t.i(style, "style");
        t.i(block, "block");
        int iPushStyle = builder.pushStyle(style);
        try {
            return block.invoke(builder);
        } finally {
            r.b(1);
            builder.pop(iPushStyle);
            r.a(1);
        }
    }
}
