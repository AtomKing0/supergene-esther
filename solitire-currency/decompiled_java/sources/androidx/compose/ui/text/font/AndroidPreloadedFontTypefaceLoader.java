package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.compose.ui.text.font.AndroidFont;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidFont.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidPreloadedFontTypefaceLoader implements AndroidFont.TypefaceLoader {

    @NotNull
    public static final AndroidPreloadedFontTypefaceLoader INSTANCE = new AndroidPreloadedFontTypefaceLoader();

    private AndroidPreloadedFontTypefaceLoader() {
    }

    @Override // androidx.compose.ui.text.font.AndroidFont.TypefaceLoader
    @Nullable
    public Object awaitLoad(@NotNull Context context, @NotNull AndroidFont androidFont, @NotNull z8.d<?> dVar) {
        throw new UnsupportedOperationException("All preloaded fonts are blocking.");
    }

    @Override // androidx.compose.ui.text.font.AndroidFont.TypefaceLoader
    @Nullable
    public android.graphics.Typeface loadBlocking(@NotNull Context context, @NotNull AndroidFont font) {
        t.i(context, "context");
        t.i(font, "font");
        AndroidPreloadedFont androidPreloadedFont = font instanceof AndroidPreloadedFont ? (AndroidPreloadedFont) font : null;
        if (androidPreloadedFont != null) {
            return androidPreloadedFont.getTypefaceInternal();
        }
        return null;
    }
}
