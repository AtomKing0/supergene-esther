package androidx.compose.ui.text;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnnotatedString.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class AnnotatedString implements CharSequence {

    @NotNull
    private final List<Range<? extends Object>> annotations;

    @NotNull
    private final List<Range<ParagraphStyle>> paragraphStyles;

    @NotNull
    private final List<Range<SpanStyle>> spanStyles;

    @NotNull
    private final String text;

    /* JADX INFO: compiled from: AnnotatedString.kt */
    public static final class Builder {

        @NotNull
        private final List<MutableRange<? extends Object>> annotations;

        @NotNull
        private final List<MutableRange<ParagraphStyle>> paragraphStyles;

        @NotNull
        private final List<MutableRange<SpanStyle>> spanStyles;

        @NotNull
        private final List<MutableRange<? extends Object>> styleStack;

        @NotNull
        private final StringBuilder text;

        public Builder() {
            this(0, 1, null);
        }

        public final void addStringAnnotation(@NotNull String tag, @NotNull String annotation, int i10, int i11) {
            t.i(tag, "tag");
            t.i(annotation, "annotation");
            this.annotations.add(new MutableRange<>(annotation, i10, i11, tag));
        }

        public final void addStyle(@NotNull SpanStyle style, int i10, int i11) {
            t.i(style, "style");
            this.spanStyles.add(new MutableRange<>(style, i10, i11, null, 8, null));
        }

        @ExperimentalTextApi
        public final void addTtsAnnotation(@NotNull TtsAnnotation ttsAnnotation, int i10, int i11) {
            t.i(ttsAnnotation, "ttsAnnotation");
            this.annotations.add(new MutableRange<>(ttsAnnotation, i10, i11, null, 8, null));
        }

        public final void append(@NotNull String text) {
            t.i(text, "text");
            this.text.append(text);
        }

        public final int getLength() {
            return this.text.length();
        }

        public final void pop() {
            if (!(!this.styleStack.isEmpty())) {
                throw new IllegalStateException("Nothing to pop.".toString());
            }
            this.styleStack.remove(r0.size() - 1).setEnd(this.text.length());
        }

        public final int pushStringAnnotation(@NotNull String tag, @NotNull String annotation) {
            t.i(tag, "tag");
            t.i(annotation, "annotation");
            MutableRange<? extends Object> mutableRange = new MutableRange<>(annotation, this.text.length(), 0, tag, 4, null);
            this.styleStack.add(mutableRange);
            this.annotations.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        public final int pushStyle(@NotNull SpanStyle style) {
            t.i(style, "style");
            MutableRange<SpanStyle> mutableRange = new MutableRange<>(style, this.text.length(), 0, null, 12, null);
            this.styleStack.add(mutableRange);
            this.spanStyles.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        public final int pushTtsAnnotation(@NotNull TtsAnnotation ttsAnnotation) {
            t.i(ttsAnnotation, "ttsAnnotation");
            MutableRange<? extends Object> mutableRange = new MutableRange<>(ttsAnnotation, this.text.length(), 0, null, 12, null);
            this.styleStack.add(mutableRange);
            this.annotations.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        @NotNull
        public final AnnotatedString toAnnotatedString() {
            String string = this.text.toString();
            t.h(string, "text.toString()");
            List<MutableRange<SpanStyle>> list = this.spanStyles;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                arrayList.add(list.get(i10).toRange(this.text.length()));
            }
            List<MutableRange<ParagraphStyle>> list2 = this.paragraphStyles;
            ArrayList arrayList2 = new ArrayList(list2.size());
            int size2 = list2.size();
            for (int i11 = 0; i11 < size2; i11++) {
                arrayList2.add(list2.get(i11).toRange(this.text.length()));
            }
            List<MutableRange<? extends Object>> list3 = this.annotations;
            ArrayList arrayList3 = new ArrayList(list3.size());
            int size3 = list3.size();
            for (int i12 = 0; i12 < size3; i12++) {
                arrayList3.add(list3.get(i12).toRange(this.text.length()));
            }
            return new AnnotatedString(string, arrayList, arrayList2, arrayList3);
        }

        public Builder(int i10) {
            this.text = new StringBuilder(i10);
            this.spanStyles = new ArrayList();
            this.paragraphStyles = new ArrayList();
            this.annotations = new ArrayList();
            this.styleStack = new ArrayList();
        }

        public final void addStyle(@NotNull ParagraphStyle style, int i10, int i11) {
            t.i(style, "style");
            this.paragraphStyles.add(new MutableRange<>(style, i10, i11, null, 8, null));
        }

        public final void append(char c10) {
            this.text.append(c10);
        }

        public final void append(@NotNull AnnotatedString text) {
            t.i(text, "text");
            int length = this.text.length();
            this.text.append(text.getText());
            List<Range<SpanStyle>> spanStyles = text.getSpanStyles();
            int size = spanStyles.size();
            for (int i10 = 0; i10 < size; i10++) {
                Range<SpanStyle> range = spanStyles.get(i10);
                addStyle(range.getItem(), range.getStart() + length, range.getEnd() + length);
            }
            List<Range<ParagraphStyle>> paragraphStyles = text.getParagraphStyles();
            int size2 = paragraphStyles.size();
            for (int i11 = 0; i11 < size2; i11++) {
                Range<ParagraphStyle> range2 = paragraphStyles.get(i11);
                addStyle(range2.getItem(), range2.getStart() + length, range2.getEnd() + length);
            }
            List<Range<? extends Object>> annotations$ui_text_release = text.getAnnotations$ui_text_release();
            int size3 = annotations$ui_text_release.size();
            for (int i12 = 0; i12 < size3; i12++) {
                Range<? extends Object> range3 = annotations$ui_text_release.get(i12);
                this.annotations.add(new MutableRange<>(range3.getItem(), range3.getStart() + length, range3.getEnd() + length, range3.getTag()));
            }
        }

        /* JADX INFO: compiled from: AnnotatedString.kt */
        private static final class MutableRange<T> {
            private int end;
            private final T item;
            private final int start;

            @NotNull
            private final String tag;

            public MutableRange(T t10, int i10, int i11, @NotNull String tag) {
                t.i(tag, "tag");
                this.item = t10;
                this.start = i10;
                this.end = i11;
                this.tag = tag;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ MutableRange copy$default(MutableRange mutableRange, Object obj, int i10, int i11, String str, int i12, Object obj2) {
                if ((i12 & 1) != 0) {
                    obj = mutableRange.item;
                }
                if ((i12 & 2) != 0) {
                    i10 = mutableRange.start;
                }
                if ((i12 & 4) != 0) {
                    i11 = mutableRange.end;
                }
                if ((i12 & 8) != 0) {
                    str = mutableRange.tag;
                }
                return mutableRange.copy(obj, i10, i11, str);
            }

            public static /* synthetic */ Range toRange$default(MutableRange mutableRange, int i10, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    i10 = Integer.MIN_VALUE;
                }
                return mutableRange.toRange(i10);
            }

            public final T component1() {
                return this.item;
            }

            public final int component2() {
                return this.start;
            }

            public final int component3() {
                return this.end;
            }

            @NotNull
            public final String component4() {
                return this.tag;
            }

            @NotNull
            public final MutableRange<T> copy(T t10, int i10, int i11, @NotNull String tag) {
                t.i(tag, "tag");
                return new MutableRange<>(t10, i10, i11, tag);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MutableRange)) {
                    return false;
                }
                MutableRange mutableRange = (MutableRange) obj;
                return t.d(this.item, mutableRange.item) && this.start == mutableRange.start && this.end == mutableRange.end && t.d(this.tag, mutableRange.tag);
            }

            public final int getEnd() {
                return this.end;
            }

            public final T getItem() {
                return this.item;
            }

            public final int getStart() {
                return this.start;
            }

            @NotNull
            public final String getTag() {
                return this.tag;
            }

            public int hashCode() {
                T t10 = this.item;
                return ((((((t10 == null ? 0 : t10.hashCode()) * 31) + this.start) * 31) + this.end) * 31) + this.tag.hashCode();
            }

            public final void setEnd(int i10) {
                this.end = i10;
            }

            @NotNull
            public final Range<T> toRange(int i10) {
                int i11 = this.end;
                if (i11 != Integer.MIN_VALUE) {
                    i10 = i11;
                }
                if (i10 != Integer.MIN_VALUE) {
                    return new Range<>(this.item, this.start, i10, this.tag);
                }
                throw new IllegalStateException("Item.end should be set first".toString());
            }

            @NotNull
            public String toString() {
                return "MutableRange(item=" + this.item + ", start=" + this.start + ", end=" + this.end + ", tag=" + this.tag + ')';
            }

            public /* synthetic */ MutableRange(Object obj, int i10, int i11, String str, int i12, k kVar) {
                this(obj, i10, (i12 & 4) != 0 ? Integer.MIN_VALUE : i11, (i12 & 8) != 0 ? "" : str);
            }
        }

        public final void pop(int i10) {
            if (i10 < this.styleStack.size()) {
                while (this.styleStack.size() - 1 >= i10) {
                    pop();
                }
            } else {
                throw new IllegalStateException((i10 + " should be less than " + this.styleStack.size()).toString());
            }
        }

        public final int pushStyle(@NotNull ParagraphStyle style) {
            t.i(style, "style");
            MutableRange<ParagraphStyle> mutableRange = new MutableRange<>(style, this.text.length(), 0, null, 12, null);
            this.styleStack.add(mutableRange);
            this.paragraphStyles.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        public /* synthetic */ Builder(int i10, int i11, k kVar) {
            this((i11 & 1) != 0 ? 16 : i10);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(@NotNull String text) {
            this(0, 1, null);
            t.i(text, "text");
            append(text);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(@NotNull AnnotatedString text) {
            this(0, 1, null);
            t.i(text, "text");
            append(text);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnnotatedString(@NotNull String text, @NotNull List<Range<SpanStyle>> spanStyles, @NotNull List<Range<ParagraphStyle>> paragraphStyles, @NotNull List<? extends Range<? extends Object>> annotations) {
        t.i(text, "text");
        t.i(spanStyles, "spanStyles");
        t.i(paragraphStyles, "paragraphStyles");
        t.i(annotations, "annotations");
        this.text = text;
        this.spanStyles = spanStyles;
        this.paragraphStyles = paragraphStyles;
        this.annotations = annotations;
        int size = paragraphStyles.size();
        int end = -1;
        for (int i10 = 0; i10 < size; i10++) {
            Range<ParagraphStyle> range = paragraphStyles.get(i10);
            if (!(range.getStart() >= end)) {
                throw new IllegalArgumentException("ParagraphStyle should not overlap".toString());
            }
            if (!(range.getEnd() <= this.text.length())) {
                throw new IllegalArgumentException(("ParagraphStyle range [" + range.getStart() + ", " + range.getEnd() + ") is out of boundary").toString());
            }
            end = range.getEnd();
        }
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i10) {
        return get(i10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnnotatedString)) {
            return false;
        }
        AnnotatedString annotatedString = (AnnotatedString) obj;
        return t.d(this.text, annotatedString.text) && t.d(this.spanStyles, annotatedString.spanStyles) && t.d(this.paragraphStyles, annotatedString.paragraphStyles) && t.d(this.annotations, annotatedString.annotations);
    }

    public char get(int i10) {
        return this.text.charAt(i10);
    }

    @NotNull
    public final List<Range<? extends Object>> getAnnotations$ui_text_release() {
        return this.annotations;
    }

    public int getLength() {
        return this.text.length();
    }

    @NotNull
    public final List<Range<ParagraphStyle>> getParagraphStyles() {
        return this.paragraphStyles;
    }

    @NotNull
    public final List<Range<SpanStyle>> getSpanStyles() {
        return this.spanStyles;
    }

    @NotNull
    public final List<Range<String>> getStringAnnotations(@NotNull String tag, int i10, int i11) {
        t.i(tag, "tag");
        List<Range<? extends Object>> list = this.annotations;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i12 = 0; i12 < size; i12++) {
            Range<? extends Object> range = list.get(i12);
            Range<? extends Object> range2 = range;
            if ((range2.getItem() instanceof String) && t.d(tag, range2.getTag()) && AnnotatedStringKt.intersect(i10, i11, range2.getStart(), range2.getEnd())) {
                arrayList.add(range);
            }
        }
        return arrayList;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @NotNull
    public final List<Range<TtsAnnotation>> getTtsAnnotations(int i10, int i11) {
        List<Range<? extends Object>> list = this.annotations;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i12 = 0; i12 < size; i12++) {
            Range<? extends Object> range = list.get(i12);
            Range<? extends Object> range2 = range;
            if ((range2.getItem() instanceof TtsAnnotation) && AnnotatedStringKt.intersect(i10, i11, range2.getStart(), range2.getEnd())) {
                arrayList.add(range);
            }
        }
        return arrayList;
    }

    public int hashCode() {
        return (((((this.text.hashCode() * 31) + this.spanStyles.hashCode()) * 31) + this.paragraphStyles.hashCode()) * 31) + this.annotations.hashCode();
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return getLength();
    }

    @Stable
    @NotNull
    public final AnnotatedString plus(@NotNull AnnotatedString other) {
        t.i(other, "other");
        Builder builder = new Builder(this);
        builder.append(other);
        return builder.toAnnotatedString();
    }

    @NotNull
    /* JADX INFO: renamed from: subSequence-5zc-tL8, reason: not valid java name */
    public final AnnotatedString m3249subSequence5zctL8(long j10) {
        return subSequence(TextRange.m3333getMinimpl(j10), TextRange.m3332getMaximpl(j10));
    }

    @Override // java.lang.CharSequence
    @NotNull
    public String toString() {
        return this.text;
    }

    @Override // java.lang.CharSequence
    @NotNull
    public AnnotatedString subSequence(int i10, int i11) {
        if (i10 <= i11) {
            if (i10 == 0 && i11 == this.text.length()) {
                return this;
            }
            String strSubstring = this.text.substring(i10, i11);
            t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return new AnnotatedString(strSubstring, AnnotatedStringKt.filterRanges(this.spanStyles, i10, i11), AnnotatedStringKt.filterRanges(this.paragraphStyles, i10, i11), AnnotatedStringKt.filterRanges(this.annotations, i10, i11));
        }
        throw new IllegalArgumentException(("start (" + i10 + ") should be less or equal to end (" + i11 + ')').toString());
    }

    /* JADX INFO: compiled from: AnnotatedString.kt */
    @Immutable
    public static final class Range<T> {
        private final int end;
        private final T item;
        private final int start;

        @NotNull
        private final String tag;

        public Range(T t10, int i10, int i11, @NotNull String tag) {
            t.i(tag, "tag");
            this.item = t10;
            this.start = i10;
            this.end = i11;
            this.tag = tag;
            if (!(i10 <= i11)) {
                throw new IllegalArgumentException("Reversed range is not supported".toString());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Range copy$default(Range range, Object obj, int i10, int i11, String str, int i12, Object obj2) {
            if ((i12 & 1) != 0) {
                obj = range.item;
            }
            if ((i12 & 2) != 0) {
                i10 = range.start;
            }
            if ((i12 & 4) != 0) {
                i11 = range.end;
            }
            if ((i12 & 8) != 0) {
                str = range.tag;
            }
            return range.copy(obj, i10, i11, str);
        }

        public final T component1() {
            return this.item;
        }

        public final int component2() {
            return this.start;
        }

        public final int component3() {
            return this.end;
        }

        @NotNull
        public final String component4() {
            return this.tag;
        }

        @NotNull
        public final Range<T> copy(T t10, int i10, int i11, @NotNull String tag) {
            t.i(tag, "tag");
            return new Range<>(t10, i10, i11, tag);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Range)) {
                return false;
            }
            Range range = (Range) obj;
            return t.d(this.item, range.item) && this.start == range.start && this.end == range.end && t.d(this.tag, range.tag);
        }

        public final int getEnd() {
            return this.end;
        }

        public final T getItem() {
            return this.item;
        }

        public final int getStart() {
            return this.start;
        }

        @NotNull
        public final String getTag() {
            return this.tag;
        }

        public int hashCode() {
            T t10 = this.item;
            return ((((((t10 == null ? 0 : t10.hashCode()) * 31) + this.start) * 31) + this.end) * 31) + this.tag.hashCode();
        }

        @NotNull
        public String toString() {
            return "Range(item=" + this.item + ", start=" + this.start + ", end=" + this.end + ", tag=" + this.tag + ')';
        }

        public Range(T t10, int i10, int i11) {
            this(t10, i10, i11, "");
        }
    }

    @NotNull
    public final List<Range<String>> getStringAnnotations(int i10, int i11) {
        List<Range<? extends Object>> list = this.annotations;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i12 = 0; i12 < size; i12++) {
            Range<? extends Object> range = list.get(i12);
            Range<? extends Object> range2 = range;
            if ((range2.getItem() instanceof String) && AnnotatedStringKt.intersect(i10, i11, range2.getStart(), range2.getEnd())) {
                arrayList.add(range);
            }
        }
        return arrayList;
    }

    public /* synthetic */ AnnotatedString(String str, List list, List list2, List list3, int i10, k kVar) {
        this(str, (i10 & 2) != 0 ? v.l() : list, (i10 & 4) != 0 ? v.l() : list2, (i10 & 8) != 0 ? v.l() : list3);
    }

    public /* synthetic */ AnnotatedString(String str, List list, List list2, int i10, k kVar) {
        this(str, (i10 & 2) != 0 ? v.l() : list, (i10 & 4) != 0 ? v.l() : list2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AnnotatedString(@NotNull String text, @NotNull List<Range<SpanStyle>> spanStyles, @NotNull List<Range<ParagraphStyle>> paragraphStyles) {
        this(text, spanStyles, paragraphStyles, v.l());
        t.i(text, "text");
        t.i(spanStyles, "spanStyles");
        t.i(paragraphStyles, "paragraphStyles");
    }
}
