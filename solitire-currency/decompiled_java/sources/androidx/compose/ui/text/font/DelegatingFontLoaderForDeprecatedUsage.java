package androidx.compose.ui.text.font;

import androidx.compose.ui.text.font.Font;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DelegatingFontLoaderForDeprecatedUsage.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DelegatingFontLoaderForDeprecatedUsage implements PlatformFontLoader {

    @NotNull
    private final Object cacheKey;

    @NotNull
    private final Font.ResourceLoader loader;

    public DelegatingFontLoaderForDeprecatedUsage(@NotNull Font.ResourceLoader loader) {
        t.i(loader, "loader");
        this.loader = loader;
        this.cacheKey = new Object();
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    @Nullable
    public Object awaitLoad(@NotNull Font font, @NotNull z8.d<Object> dVar) {
        return this.loader.load(font);
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
    @NotNull
    public Object loadBlocking(@NotNull Font font) {
        t.i(font, "font");
        return this.loader.load(font);
    }
}
