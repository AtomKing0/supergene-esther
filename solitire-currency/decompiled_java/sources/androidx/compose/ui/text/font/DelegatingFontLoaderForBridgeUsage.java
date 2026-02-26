package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.compose.ui.text.font.Font;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DelegatingFontLoaderForDeprecatedUsage.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DelegatingFontLoaderForBridgeUsage implements PlatformFontLoader {

    @NotNull
    private final Object cacheKey;

    @NotNull
    private final Context context;

    @NotNull
    private final Font.ResourceLoader loader;

    public DelegatingFontLoaderForBridgeUsage(@NotNull Font.ResourceLoader loader, @NotNull Context context) {
        t.i(loader, "loader");
        t.i(context, "context");
        this.loader = loader;
        this.context = context;
        this.cacheKey = new Object();
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    @Nullable
    public Object awaitLoad(@NotNull Font font, @NotNull z8.d<Object> dVar) {
        if (!(font instanceof AndroidFont)) {
            return this.loader.load(font);
        }
        AndroidFont androidFont = (AndroidFont) font;
        return androidFont.getTypefaceLoader().awaitLoad(this.context, androidFont, dVar);
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    @NotNull
    public Object getCacheKey() {
        return this.cacheKey;
    }

    @NotNull
    public final Font.ResourceLoader getLoader$ui_text_release() {
        return this.loader;
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    @Nullable
    public Object loadBlocking(@NotNull Font font) {
        t.i(font, "font");
        if (!(font instanceof AndroidFont)) {
            return this.loader.load(font);
        }
        AndroidFont androidFont = (AndroidFont) font;
        return androidFont.getTypefaceLoader().loadBlocking(this.context, androidFont);
    }
}
