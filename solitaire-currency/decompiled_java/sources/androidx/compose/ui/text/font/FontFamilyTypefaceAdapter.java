package androidx.compose.ui.text.font;

import androidx.compose.ui.text.font.TypefaceResult;
import h9.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: FontFamilyTypefaceAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public interface FontFamilyTypefaceAdapter {
    @Nullable
    TypefaceResult resolve(@NotNull TypefaceRequest typefaceRequest, @NotNull PlatformFontLoader platformFontLoader, @NotNull l<? super TypefaceResult.Immutable, k0> lVar, @NotNull l<? super TypefaceRequest, ? extends Object> lVar2);
}
