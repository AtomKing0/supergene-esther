package androidx.compose.ui.text.font;

import android.content.Context;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidFont.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidFont implements Font {
    private final int loadingStrategy;

    @NotNull
    private final TypefaceLoader typefaceLoader;

    /* JADX INFO: compiled from: AndroidFont.kt */
    public interface TypefaceLoader {
        @Nullable
        Object awaitLoad(@NotNull Context context, @NotNull AndroidFont androidFont, @NotNull z8.d<? super android.graphics.Typeface> dVar);

        @Nullable
        android.graphics.Typeface loadBlocking(@NotNull Context context, @NotNull AndroidFont androidFont);
    }

    public /* synthetic */ AndroidFont(int i10, TypefaceLoader typefaceLoader, k kVar) {
        this(i10, typefaceLoader);
    }

    @Override // androidx.compose.ui.text.font.Font
    /* JADX INFO: renamed from: getLoadingStrategy-PKNRLFQ, reason: not valid java name */
    public final int mo3362getLoadingStrategyPKNRLFQ() {
        return this.loadingStrategy;
    }

    @NotNull
    public final TypefaceLoader getTypefaceLoader() {
        return this.typefaceLoader;
    }

    private AndroidFont(int i10, TypefaceLoader typefaceLoader) {
        this.loadingStrategy = i10;
        this.typefaceLoader = typefaceLoader;
    }
}
