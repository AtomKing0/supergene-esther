package androidx.compose.ui.platform;

import android.graphics.Rect;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import java.text.BreakIterator;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AccessibilityIterators.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AccessibilityIterators {

    /* JADX INFO: compiled from: AccessibilityIterators.android.kt */
    @StabilityInferred(parameters = 0)
    public static abstract class AbstractTextSegmentIterator implements TextSegmentIterator {
        public static final int $stable = 8;

        @NotNull
        private final int[] segment = new int[2];
        protected String text;

        @Nullable
        protected final int[] getRange(int i10, int i11) {
            if (i10 < 0 || i11 < 0 || i10 == i11) {
                return null;
            }
            int[] iArr = this.segment;
            iArr[0] = i10;
            iArr[1] = i11;
            return iArr;
        }

        @NotNull
        protected final String getText() {
            String str = this.text;
            if (str != null) {
                return str;
            }
            kotlin.jvm.internal.t.A("text");
            return null;
        }

        public void initialize(@NotNull String text) {
            kotlin.jvm.internal.t.i(text, "text");
            setText(text);
        }

        protected final void setText(@NotNull String str) {
            kotlin.jvm.internal.t.i(str, "<set-?>");
            this.text = str;
        }
    }

    /* JADX INFO: compiled from: AccessibilityIterators.android.kt */
    @StabilityInferred(parameters = 0)
    public static class CharacterTextSegmentIterator extends AbstractTextSegmentIterator {

        @Nullable
        private static CharacterTextSegmentIterator instance;
        private BreakIterator impl;

        @NotNull
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        /* JADX INFO: compiled from: AccessibilityIterators.android.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final CharacterTextSegmentIterator getInstance(@NotNull Locale locale) {
                kotlin.jvm.internal.t.i(locale, "locale");
                if (CharacterTextSegmentIterator.instance == null) {
                    CharacterTextSegmentIterator.instance = new CharacterTextSegmentIterator(locale, null);
                }
                CharacterTextSegmentIterator characterTextSegmentIterator = CharacterTextSegmentIterator.instance;
                if (characterTextSegmentIterator != null) {
                    return characterTextSegmentIterator;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.CharacterTextSegmentIterator");
            }
        }

        public /* synthetic */ CharacterTextSegmentIterator(Locale locale, kotlin.jvm.internal.k kVar) {
            this(locale);
        }

        private final void onLocaleChanged(Locale locale) {
            BreakIterator characterInstance = BreakIterator.getCharacterInstance(locale);
            kotlin.jvm.internal.t.h(characterInstance, "getCharacterInstance(locale)");
            this.impl = characterInstance;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        @Nullable
        public int[] following(int i10) {
            int length = getText().length();
            if (length <= 0 || i10 >= length) {
                return null;
            }
            if (i10 < 0) {
                i10 = 0;
            }
            do {
                BreakIterator breakIterator = this.impl;
                if (breakIterator == null) {
                    kotlin.jvm.internal.t.A("impl");
                    breakIterator = null;
                }
                if (breakIterator.isBoundary(i10)) {
                    BreakIterator breakIterator2 = this.impl;
                    if (breakIterator2 == null) {
                        kotlin.jvm.internal.t.A("impl");
                        breakIterator2 = null;
                    }
                    int iFollowing = breakIterator2.following(i10);
                    if (iFollowing == -1) {
                        return null;
                    }
                    return getRange(i10, iFollowing);
                }
                BreakIterator breakIterator3 = this.impl;
                if (breakIterator3 == null) {
                    kotlin.jvm.internal.t.A("impl");
                    breakIterator3 = null;
                }
                i10 = breakIterator3.following(i10);
            } while (i10 != -1);
            return null;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.AbstractTextSegmentIterator
        public void initialize(@NotNull String text) {
            kotlin.jvm.internal.t.i(text, "text");
            super.initialize(text);
            BreakIterator breakIterator = this.impl;
            if (breakIterator == null) {
                kotlin.jvm.internal.t.A("impl");
                breakIterator = null;
            }
            breakIterator.setText(text);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        @Nullable
        public int[] preceding(int i10) {
            int length = getText().length();
            if (length <= 0 || i10 <= 0) {
                return null;
            }
            if (i10 > length) {
                i10 = length;
            }
            do {
                BreakIterator breakIterator = this.impl;
                if (breakIterator == null) {
                    kotlin.jvm.internal.t.A("impl");
                    breakIterator = null;
                }
                if (breakIterator.isBoundary(i10)) {
                    BreakIterator breakIterator2 = this.impl;
                    if (breakIterator2 == null) {
                        kotlin.jvm.internal.t.A("impl");
                        breakIterator2 = null;
                    }
                    int iPreceding = breakIterator2.preceding(i10);
                    if (iPreceding == -1) {
                        return null;
                    }
                    return getRange(iPreceding, i10);
                }
                BreakIterator breakIterator3 = this.impl;
                if (breakIterator3 == null) {
                    kotlin.jvm.internal.t.A("impl");
                    breakIterator3 = null;
                }
                i10 = breakIterator3.preceding(i10);
            } while (i10 != -1);
            return null;
        }

        private CharacterTextSegmentIterator(Locale locale) {
            onLocaleChanged(locale);
        }
    }

    /* JADX INFO: compiled from: AccessibilityIterators.android.kt */
    @StabilityInferred(parameters = 0)
    public static final class LineTextSegmentIterator extends AbstractTextSegmentIterator {

        @Nullable
        private static LineTextSegmentIterator lineInstance;
        private TextLayoutResult layoutResult;

        @NotNull
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        @NotNull
        private static final ResolvedTextDirection DirectionStart = ResolvedTextDirection.Rtl;

        @NotNull
        private static final ResolvedTextDirection DirectionEnd = ResolvedTextDirection.Ltr;

        /* JADX INFO: compiled from: AccessibilityIterators.android.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final LineTextSegmentIterator getInstance() {
                if (LineTextSegmentIterator.lineInstance == null) {
                    LineTextSegmentIterator.lineInstance = new LineTextSegmentIterator(null);
                }
                LineTextSegmentIterator lineTextSegmentIterator = LineTextSegmentIterator.lineInstance;
                if (lineTextSegmentIterator != null) {
                    return lineTextSegmentIterator;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.LineTextSegmentIterator");
            }
        }

        public /* synthetic */ LineTextSegmentIterator(kotlin.jvm.internal.k kVar) {
            this();
        }

        private final int getLineEdgeIndex(int i10, ResolvedTextDirection resolvedTextDirection) {
            TextLayoutResult textLayoutResult = this.layoutResult;
            TextLayoutResult textLayoutResult2 = null;
            if (textLayoutResult == null) {
                kotlin.jvm.internal.t.A("layoutResult");
                textLayoutResult = null;
            }
            int lineStart = textLayoutResult.getLineStart(i10);
            TextLayoutResult textLayoutResult3 = this.layoutResult;
            if (textLayoutResult3 == null) {
                kotlin.jvm.internal.t.A("layoutResult");
                textLayoutResult3 = null;
            }
            if (resolvedTextDirection != textLayoutResult3.getParagraphDirection(lineStart)) {
                TextLayoutResult textLayoutResult4 = this.layoutResult;
                if (textLayoutResult4 == null) {
                    kotlin.jvm.internal.t.A("layoutResult");
                } else {
                    textLayoutResult2 = textLayoutResult4;
                }
                return textLayoutResult2.getLineStart(i10);
            }
            TextLayoutResult textLayoutResult5 = this.layoutResult;
            if (textLayoutResult5 == null) {
                kotlin.jvm.internal.t.A("layoutResult");
                textLayoutResult5 = null;
            }
            return TextLayoutResult.getLineEnd$default(textLayoutResult5, i10, false, 2, null) - 1;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        @Nullable
        public int[] following(int i10) {
            int lineForOffset;
            if (getText().length() <= 0 || i10 >= getText().length()) {
                return null;
            }
            if (i10 < 0) {
                TextLayoutResult textLayoutResult = this.layoutResult;
                if (textLayoutResult == null) {
                    kotlin.jvm.internal.t.A("layoutResult");
                    textLayoutResult = null;
                }
                lineForOffset = textLayoutResult.getLineForOffset(0);
            } else {
                TextLayoutResult textLayoutResult2 = this.layoutResult;
                if (textLayoutResult2 == null) {
                    kotlin.jvm.internal.t.A("layoutResult");
                    textLayoutResult2 = null;
                }
                int lineForOffset2 = textLayoutResult2.getLineForOffset(i10);
                lineForOffset = getLineEdgeIndex(lineForOffset2, DirectionStart) == i10 ? lineForOffset2 : lineForOffset2 + 1;
            }
            TextLayoutResult textLayoutResult3 = this.layoutResult;
            if (textLayoutResult3 == null) {
                kotlin.jvm.internal.t.A("layoutResult");
                textLayoutResult3 = null;
            }
            if (lineForOffset >= textLayoutResult3.getLineCount()) {
                return null;
            }
            return getRange(getLineEdgeIndex(lineForOffset, DirectionStart), getLineEdgeIndex(lineForOffset, DirectionEnd) + 1);
        }

        public final void initialize(@NotNull String text, @NotNull TextLayoutResult layoutResult) {
            kotlin.jvm.internal.t.i(text, "text");
            kotlin.jvm.internal.t.i(layoutResult, "layoutResult");
            setText(text);
            this.layoutResult = layoutResult;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        @Nullable
        public int[] preceding(int i10) {
            int lineForOffset;
            if (getText().length() <= 0 || i10 <= 0) {
                return null;
            }
            if (i10 > getText().length()) {
                TextLayoutResult textLayoutResult = this.layoutResult;
                if (textLayoutResult == null) {
                    kotlin.jvm.internal.t.A("layoutResult");
                    textLayoutResult = null;
                }
                lineForOffset = textLayoutResult.getLineForOffset(getText().length());
            } else {
                TextLayoutResult textLayoutResult2 = this.layoutResult;
                if (textLayoutResult2 == null) {
                    kotlin.jvm.internal.t.A("layoutResult");
                    textLayoutResult2 = null;
                }
                int lineForOffset2 = textLayoutResult2.getLineForOffset(i10);
                lineForOffset = getLineEdgeIndex(lineForOffset2, DirectionEnd) + 1 == i10 ? lineForOffset2 : lineForOffset2 - 1;
            }
            if (lineForOffset < 0) {
                return null;
            }
            return getRange(getLineEdgeIndex(lineForOffset, DirectionStart), getLineEdgeIndex(lineForOffset, DirectionEnd) + 1);
        }

        private LineTextSegmentIterator() {
        }
    }

    /* JADX INFO: compiled from: AccessibilityIterators.android.kt */
    @StabilityInferred(parameters = 0)
    public static final class PageTextSegmentIterator extends AbstractTextSegmentIterator {

        @Nullable
        private static PageTextSegmentIterator pageInstance;
        private TextLayoutResult layoutResult;
        private SemanticsNode node;

        @NotNull
        private Rect tempRect;

        @NotNull
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        @NotNull
        private static final ResolvedTextDirection DirectionStart = ResolvedTextDirection.Rtl;

        @NotNull
        private static final ResolvedTextDirection DirectionEnd = ResolvedTextDirection.Ltr;

        /* JADX INFO: compiled from: AccessibilityIterators.android.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final PageTextSegmentIterator getInstance() {
                if (PageTextSegmentIterator.pageInstance == null) {
                    PageTextSegmentIterator.pageInstance = new PageTextSegmentIterator(null);
                }
                PageTextSegmentIterator pageTextSegmentIterator = PageTextSegmentIterator.pageInstance;
                if (pageTextSegmentIterator != null) {
                    return pageTextSegmentIterator;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.PageTextSegmentIterator");
            }
        }

        public /* synthetic */ PageTextSegmentIterator(kotlin.jvm.internal.k kVar) {
            this();
        }

        private final int getLineEdgeIndex(int i10, ResolvedTextDirection resolvedTextDirection) {
            TextLayoutResult textLayoutResult = this.layoutResult;
            TextLayoutResult textLayoutResult2 = null;
            if (textLayoutResult == null) {
                kotlin.jvm.internal.t.A("layoutResult");
                textLayoutResult = null;
            }
            int lineStart = textLayoutResult.getLineStart(i10);
            TextLayoutResult textLayoutResult3 = this.layoutResult;
            if (textLayoutResult3 == null) {
                kotlin.jvm.internal.t.A("layoutResult");
                textLayoutResult3 = null;
            }
            if (resolvedTextDirection != textLayoutResult3.getParagraphDirection(lineStart)) {
                TextLayoutResult textLayoutResult4 = this.layoutResult;
                if (textLayoutResult4 == null) {
                    kotlin.jvm.internal.t.A("layoutResult");
                } else {
                    textLayoutResult2 = textLayoutResult4;
                }
                return textLayoutResult2.getLineStart(i10);
            }
            TextLayoutResult textLayoutResult5 = this.layoutResult;
            if (textLayoutResult5 == null) {
                kotlin.jvm.internal.t.A("layoutResult");
                textLayoutResult5 = null;
            }
            return TextLayoutResult.getLineEnd$default(textLayoutResult5, i10, false, 2, null) - 1;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        @Nullable
        public int[] following(int i10) {
            int lineCount;
            TextLayoutResult textLayoutResult = null;
            if (getText().length() <= 0 || i10 >= getText().length()) {
                return null;
            }
            try {
                SemanticsNode semanticsNode = this.node;
                if (semanticsNode == null) {
                    kotlin.jvm.internal.t.A("node");
                    semanticsNode = null;
                }
                int iC = j9.c.c(semanticsNode.getBoundsInRoot().getHeight());
                int iE = n9.o.e(0, i10);
                TextLayoutResult textLayoutResult2 = this.layoutResult;
                if (textLayoutResult2 == null) {
                    kotlin.jvm.internal.t.A("layoutResult");
                    textLayoutResult2 = null;
                }
                int lineForOffset = textLayoutResult2.getLineForOffset(iE);
                TextLayoutResult textLayoutResult3 = this.layoutResult;
                if (textLayoutResult3 == null) {
                    kotlin.jvm.internal.t.A("layoutResult");
                    textLayoutResult3 = null;
                }
                float lineTop = textLayoutResult3.getLineTop(lineForOffset) + iC;
                TextLayoutResult textLayoutResult4 = this.layoutResult;
                if (textLayoutResult4 == null) {
                    kotlin.jvm.internal.t.A("layoutResult");
                    textLayoutResult4 = null;
                }
                TextLayoutResult textLayoutResult5 = this.layoutResult;
                if (textLayoutResult5 == null) {
                    kotlin.jvm.internal.t.A("layoutResult");
                    textLayoutResult5 = null;
                }
                if (lineTop < textLayoutResult4.getLineTop(textLayoutResult5.getLineCount() - 1)) {
                    TextLayoutResult textLayoutResult6 = this.layoutResult;
                    if (textLayoutResult6 == null) {
                        kotlin.jvm.internal.t.A("layoutResult");
                    } else {
                        textLayoutResult = textLayoutResult6;
                    }
                    lineCount = textLayoutResult.getLineForVerticalPosition(lineTop);
                } else {
                    TextLayoutResult textLayoutResult7 = this.layoutResult;
                    if (textLayoutResult7 == null) {
                        kotlin.jvm.internal.t.A("layoutResult");
                    } else {
                        textLayoutResult = textLayoutResult7;
                    }
                    lineCount = textLayoutResult.getLineCount();
                }
                return getRange(iE, getLineEdgeIndex(lineCount - 1, DirectionEnd) + 1);
            } catch (IllegalStateException unused) {
                return null;
            }
        }

        public final void initialize(@NotNull String text, @NotNull TextLayoutResult layoutResult, @NotNull SemanticsNode node) {
            kotlin.jvm.internal.t.i(text, "text");
            kotlin.jvm.internal.t.i(layoutResult, "layoutResult");
            kotlin.jvm.internal.t.i(node, "node");
            setText(text);
            this.layoutResult = layoutResult;
            this.node = node;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        @Nullable
        public int[] preceding(int i10) {
            int lineForVerticalPosition;
            TextLayoutResult textLayoutResult = null;
            if (getText().length() <= 0 || i10 <= 0) {
                return null;
            }
            try {
                SemanticsNode semanticsNode = this.node;
                if (semanticsNode == null) {
                    kotlin.jvm.internal.t.A("node");
                    semanticsNode = null;
                }
                int iC = j9.c.c(semanticsNode.getBoundsInRoot().getHeight());
                int iJ = n9.o.j(getText().length(), i10);
                TextLayoutResult textLayoutResult2 = this.layoutResult;
                if (textLayoutResult2 == null) {
                    kotlin.jvm.internal.t.A("layoutResult");
                    textLayoutResult2 = null;
                }
                int lineForOffset = textLayoutResult2.getLineForOffset(iJ);
                TextLayoutResult textLayoutResult3 = this.layoutResult;
                if (textLayoutResult3 == null) {
                    kotlin.jvm.internal.t.A("layoutResult");
                    textLayoutResult3 = null;
                }
                float lineTop = textLayoutResult3.getLineTop(lineForOffset) - iC;
                if (lineTop > 0.0f) {
                    TextLayoutResult textLayoutResult4 = this.layoutResult;
                    if (textLayoutResult4 == null) {
                        kotlin.jvm.internal.t.A("layoutResult");
                    } else {
                        textLayoutResult = textLayoutResult4;
                    }
                    lineForVerticalPosition = textLayoutResult.getLineForVerticalPosition(lineTop);
                } else {
                    lineForVerticalPosition = 0;
                }
                if (iJ == getText().length() && lineForVerticalPosition < lineForOffset) {
                    lineForVerticalPosition++;
                }
                return getRange(getLineEdgeIndex(lineForVerticalPosition, DirectionStart), iJ);
            } catch (IllegalStateException unused) {
                return null;
            }
        }

        private PageTextSegmentIterator() {
            this.tempRect = new Rect();
        }
    }

    /* JADX INFO: compiled from: AccessibilityIterators.android.kt */
    @StabilityInferred(parameters = 0)
    public static final class ParagraphTextSegmentIterator extends AbstractTextSegmentIterator {
        public static final int $stable = 0;

        @NotNull
        public static final Companion Companion = new Companion(null);

        @Nullable
        private static ParagraphTextSegmentIterator instance;

        /* JADX INFO: compiled from: AccessibilityIterators.android.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final ParagraphTextSegmentIterator getInstance() {
                if (ParagraphTextSegmentIterator.instance == null) {
                    ParagraphTextSegmentIterator.instance = new ParagraphTextSegmentIterator(null);
                }
                ParagraphTextSegmentIterator paragraphTextSegmentIterator = ParagraphTextSegmentIterator.instance;
                if (paragraphTextSegmentIterator != null) {
                    return paragraphTextSegmentIterator;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.ParagraphTextSegmentIterator");
            }
        }

        public /* synthetic */ ParagraphTextSegmentIterator(kotlin.jvm.internal.k kVar) {
            this();
        }

        private final boolean isEndBoundary(int i10) {
            return i10 > 0 && getText().charAt(i10 + (-1)) != '\n' && (i10 == getText().length() || getText().charAt(i10) == '\n');
        }

        private final boolean isStartBoundary(int i10) {
            return getText().charAt(i10) != '\n' && (i10 == 0 || getText().charAt(i10 - 1) == '\n');
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        @Nullable
        public int[] following(int i10) {
            int length = getText().length();
            if (length <= 0 || i10 >= length) {
                return null;
            }
            if (i10 < 0) {
                i10 = 0;
            }
            while (i10 < length && getText().charAt(i10) == '\n' && !isStartBoundary(i10)) {
                i10++;
            }
            if (i10 >= length) {
                return null;
            }
            int i11 = i10 + 1;
            while (i11 < length && !isEndBoundary(i11)) {
                i11++;
            }
            return getRange(i10, i11);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        @Nullable
        public int[] preceding(int i10) {
            int length = getText().length();
            if (length <= 0 || i10 <= 0) {
                return null;
            }
            if (i10 > length) {
                i10 = length;
            }
            while (i10 > 0 && getText().charAt(i10 - 1) == '\n' && !isEndBoundary(i10)) {
                i10--;
            }
            if (i10 <= 0) {
                return null;
            }
            int i11 = i10 - 1;
            while (i11 > 0 && !isStartBoundary(i11)) {
                i11--;
            }
            return getRange(i11, i10);
        }

        private ParagraphTextSegmentIterator() {
        }
    }

    /* JADX INFO: compiled from: AccessibilityIterators.android.kt */
    public interface TextSegmentIterator {
        @Nullable
        int[] following(int i10);

        @Nullable
        int[] preceding(int i10);
    }

    /* JADX INFO: compiled from: AccessibilityIterators.android.kt */
    @StabilityInferred(parameters = 0)
    public static final class WordTextSegmentIterator extends AbstractTextSegmentIterator {

        @Nullable
        private static WordTextSegmentIterator instance;
        private BreakIterator impl;

        @NotNull
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        /* JADX INFO: compiled from: AccessibilityIterators.android.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
                this();
            }

            @NotNull
            public final WordTextSegmentIterator getInstance(@NotNull Locale locale) {
                kotlin.jvm.internal.t.i(locale, "locale");
                if (WordTextSegmentIterator.instance == null) {
                    WordTextSegmentIterator.instance = new WordTextSegmentIterator(locale, null);
                }
                WordTextSegmentIterator wordTextSegmentIterator = WordTextSegmentIterator.instance;
                if (wordTextSegmentIterator != null) {
                    return wordTextSegmentIterator;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.WordTextSegmentIterator");
            }
        }

        public /* synthetic */ WordTextSegmentIterator(Locale locale, kotlin.jvm.internal.k kVar) {
            this(locale);
        }

        private final boolean isEndBoundary(int i10) {
            return i10 > 0 && isLetterOrDigit(i10 + (-1)) && (i10 == getText().length() || !isLetterOrDigit(i10));
        }

        private final boolean isLetterOrDigit(int i10) {
            if (i10 < 0 || i10 >= getText().length()) {
                return false;
            }
            return Character.isLetterOrDigit(getText().codePointAt(i10));
        }

        private final boolean isStartBoundary(int i10) {
            return isLetterOrDigit(i10) && (i10 == 0 || !isLetterOrDigit(i10 - 1));
        }

        private final void onLocaleChanged(Locale locale) {
            BreakIterator wordInstance = BreakIterator.getWordInstance(locale);
            kotlin.jvm.internal.t.h(wordInstance, "getWordInstance(locale)");
            this.impl = wordInstance;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        @Nullable
        public int[] following(int i10) {
            if (getText().length() <= 0 || i10 >= getText().length()) {
                return null;
            }
            if (i10 < 0) {
                i10 = 0;
            }
            while (!isLetterOrDigit(i10) && !isStartBoundary(i10)) {
                BreakIterator breakIterator = this.impl;
                if (breakIterator == null) {
                    kotlin.jvm.internal.t.A("impl");
                    breakIterator = null;
                }
                i10 = breakIterator.following(i10);
                if (i10 == -1) {
                    return null;
                }
            }
            BreakIterator breakIterator2 = this.impl;
            if (breakIterator2 == null) {
                kotlin.jvm.internal.t.A("impl");
                breakIterator2 = null;
            }
            int iFollowing = breakIterator2.following(i10);
            if (iFollowing == -1 || !isEndBoundary(iFollowing)) {
                return null;
            }
            return getRange(i10, iFollowing);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.AbstractTextSegmentIterator
        public void initialize(@NotNull String text) {
            kotlin.jvm.internal.t.i(text, "text");
            super.initialize(text);
            BreakIterator breakIterator = this.impl;
            if (breakIterator == null) {
                kotlin.jvm.internal.t.A("impl");
                breakIterator = null;
            }
            breakIterator.setText(text);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        @Nullable
        public int[] preceding(int i10) {
            int length = getText().length();
            if (length <= 0 || i10 <= 0) {
                return null;
            }
            if (i10 > length) {
                i10 = length;
            }
            while (i10 > 0 && !isLetterOrDigit(i10 - 1) && !isEndBoundary(i10)) {
                BreakIterator breakIterator = this.impl;
                if (breakIterator == null) {
                    kotlin.jvm.internal.t.A("impl");
                    breakIterator = null;
                }
                i10 = breakIterator.preceding(i10);
                if (i10 == -1) {
                    return null;
                }
            }
            BreakIterator breakIterator2 = this.impl;
            if (breakIterator2 == null) {
                kotlin.jvm.internal.t.A("impl");
                breakIterator2 = null;
            }
            int iPreceding = breakIterator2.preceding(i10);
            if (iPreceding == -1 || !isStartBoundary(iPreceding)) {
                return null;
            }
            return getRange(iPreceding, i10);
        }

        private WordTextSegmentIterator(Locale locale) {
            onLocaleChanged(locale);
        }
    }
}
