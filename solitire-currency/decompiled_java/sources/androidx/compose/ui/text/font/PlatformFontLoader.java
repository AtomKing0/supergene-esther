package androidx.compose.ui.text.font;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Font.kt */
/* JADX INFO: loaded from: classes.dex */
public interface PlatformFontLoader {
    @Nullable
    Object awaitLoad(@NotNull Font font, @NotNull z8.d<Object> dVar);

    @Nullable
    Object getCacheKey();

    @Nullable
    Object loadBlocking(@NotNull Font font);
}
