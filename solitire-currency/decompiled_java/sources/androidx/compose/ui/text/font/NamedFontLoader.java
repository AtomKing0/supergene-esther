package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.compose.ui.text.ExperimentalTextApi;
import androidx.compose.ui.text.font.AndroidFont;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DeviceFontFamilyNameFont.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalTextApi
final class NamedFontLoader implements AndroidFont.TypefaceLoader {

    @NotNull
    public static final NamedFontLoader INSTANCE = new NamedFontLoader();

    private NamedFontLoader() {
    }

    @Override // androidx.compose.ui.text.font.AndroidFont.TypefaceLoader
    @Nullable
    public Object awaitLoad(@NotNull Context context, @NotNull AndroidFont androidFont, @NotNull z8.d<? super android.graphics.Typeface> dVar) {
        throw new UnsupportedOperationException("All preloaded fonts are optional local.");
    }

    @Override // androidx.compose.ui.text.font.AndroidFont.TypefaceLoader
    @Nullable
    public android.graphics.Typeface loadBlocking(@NotNull Context context, @NotNull AndroidFont font) {
        t.i(context, "context");
        t.i(font, "font");
        DeviceFontFamilyNameFont deviceFontFamilyNameFont = font instanceof DeviceFontFamilyNameFont ? (DeviceFontFamilyNameFont) font : null;
        if (deviceFontFamilyNameFont != null) {
            return deviceFontFamilyNameFont.getResolvedTypeface();
        }
        return null;
    }
}
