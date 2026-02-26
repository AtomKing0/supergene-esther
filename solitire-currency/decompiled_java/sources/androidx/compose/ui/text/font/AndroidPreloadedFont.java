package androidx.compose.ui.text.font;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidFont.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidPreloadedFont extends AndroidFont {
    public AndroidPreloadedFont() {
        super(FontLoadingStrategy.Companion.m3405getBlockingPKNRLFQ(), AndroidPreloadedFontTypefaceLoader.INSTANCE, null);
    }

    @Nullable
    public abstract String getCacheKey();

    @Nullable
    public abstract android.graphics.Typeface getTypefaceInternal();
}
