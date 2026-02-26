package androidx.compose.ui.text.font;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FontFamilyResolver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FontFamilyResolverKt {

    @NotNull
    private static final TypefaceRequestCache GlobalTypefaceRequestCache = new TypefaceRequestCache();

    @NotNull
    private static final AsyncTypefaceCache GlobalAsyncTypefaceCache = new AsyncTypefaceCache();

    @NotNull
    public static final AsyncTypefaceCache getGlobalAsyncTypefaceCache() {
        return GlobalAsyncTypefaceCache;
    }

    @NotNull
    public static final TypefaceRequestCache getGlobalTypefaceRequestCache() {
        return GlobalTypefaceRequestCache;
    }

    public static /* synthetic */ void getGlobalAsyncTypefaceCache$annotations() {
    }
}
