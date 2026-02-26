package androidx.compose.ui.text.platform;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontListFontFamily;
import androidx.compose.ui.text.font.FontMatcher;
import androidx.compose.ui.text.font.FontSynthesis_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.d0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidFontListTypeface.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidFontListTypeface implements AndroidTypeface {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @Deprecated
    @NotNull
    private static final FontMatcher fontMatcher = new FontMatcher();

    @NotNull
    private final FontFamily fontFamily;

    @NotNull
    private final FontMatcher fontMatcher$1;

    @NotNull
    private final Map<Font, Typeface> loadedTypefaces;

    /* JADX INFO: compiled from: AndroidFontListTypeface.android.kt */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final FontMatcher getFontMatcher() {
            return AndroidFontListTypeface.fontMatcher;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AndroidFontListTypeface(@org.jetbrains.annotations.NotNull androidx.compose.ui.text.font.FontListFontFamily r8, @org.jetbrains.annotations.NotNull android.content.Context r9, @org.jetbrains.annotations.Nullable java.util.List<v8.s<androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle>> r10, @org.jetbrains.annotations.NotNull androidx.compose.ui.text.font.FontMatcher r11) {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.AndroidFontListTypeface.<init>(androidx.compose.ui.text.font.FontListFontFamily, android.content.Context, java.util.List, androidx.compose.ui.text.font.FontMatcher):void");
    }

    @Override // androidx.compose.ui.text.font.Typeface
    @NotNull
    public FontFamily getFontFamily() {
        return this.fontFamily;
    }

    @NotNull
    public final FontMatcher getFontMatcher() {
        return this.fontMatcher$1;
    }

    @Override // androidx.compose.ui.text.platform.AndroidTypeface
    @NotNull
    /* JADX INFO: renamed from: getNativeTypeface-PYhJU0U */
    public Typeface mo3514getNativeTypefacePYhJU0U(@NotNull FontWeight fontWeight, int i10, int i11) {
        t.i(fontWeight, "fontWeight");
        Font font = (Font) d0.k0(this.fontMatcher$1.m3409matchFontRetOiIg(new ArrayList(this.loadedTypefaces.keySet()), fontWeight, i10));
        if (font == null) {
            throw new IllegalStateException("Could not load font");
        }
        Typeface typeface = this.loadedTypefaces.get(font);
        if (typeface != null) {
            return (Typeface) FontSynthesis_androidKt.m3432synthesizeTypefaceFxwP2eA(i11, typeface, font, fontWeight, i10);
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public /* synthetic */ AndroidFontListTypeface(FontListFontFamily fontListFontFamily, Context context, List list, FontMatcher fontMatcher2, int i10, k kVar) {
        this(fontListFontFamily, context, (i10 & 4) != 0 ? null : list, (i10 & 8) != 0 ? fontMatcher : fontMatcher2);
    }
}
