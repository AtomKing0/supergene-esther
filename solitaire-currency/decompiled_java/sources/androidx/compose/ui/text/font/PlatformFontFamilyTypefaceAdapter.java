package androidx.compose.ui.text.font;

import androidx.compose.ui.text.ExperimentalTextApi;
import androidx.compose.ui.text.font.TypefaceResult;
import androidx.compose.ui.text.platform.AndroidTypeface;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: PlatformFontFamilyTypefaceAdapter.android.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalTextApi
public final class PlatformFontFamilyTypefaceAdapter implements FontFamilyTypefaceAdapter {

    @NotNull
    private final PlatformTypefaces platformTypefaceResolver = PlatformTypefacesKt.PlatformTypefaces();

    @Override // androidx.compose.ui.text.font.FontFamilyTypefaceAdapter
    @Nullable
    public TypefaceResult resolve(@NotNull TypefaceRequest typefaceRequest, @NotNull PlatformFontLoader platformFontLoader, @NotNull l<? super TypefaceResult.Immutable, k0> onAsyncCompletion, @NotNull l<? super TypefaceRequest, ? extends Object> createDefaultTypeface) {
        android.graphics.Typeface typefaceMo3514getNativeTypefacePYhJU0U;
        t.i(typefaceRequest, "typefaceRequest");
        t.i(platformFontLoader, "platformFontLoader");
        t.i(onAsyncCompletion, "onAsyncCompletion");
        t.i(createDefaultTypeface, "createDefaultTypeface");
        FontFamily fontFamily = typefaceRequest.getFontFamily();
        if (fontFamily == null ? true : fontFamily instanceof DefaultFontFamily) {
            typefaceMo3514getNativeTypefacePYhJU0U = this.platformTypefaceResolver.mo3433createDefaultFO1MlWM(typefaceRequest.getFontWeight(), typefaceRequest.m3451getFontStyle_LCdwA());
        } else if (fontFamily instanceof GenericFontFamily) {
            typefaceMo3514getNativeTypefacePYhJU0U = this.platformTypefaceResolver.mo3434createNamedRetOiIg((GenericFontFamily) typefaceRequest.getFontFamily(), typefaceRequest.getFontWeight(), typefaceRequest.m3451getFontStyle_LCdwA());
        } else {
            if (!(fontFamily instanceof LoadedFontFamily)) {
                return null;
            }
            typefaceMo3514getNativeTypefacePYhJU0U = ((AndroidTypeface) ((LoadedFontFamily) typefaceRequest.getFontFamily()).getTypeface()).mo3514getNativeTypefacePYhJU0U(typefaceRequest.getFontWeight(), typefaceRequest.m3451getFontStyle_LCdwA(), typefaceRequest.m3452getFontSynthesisGVVA2EU());
        }
        return new TypefaceResult.Immutable(typefaceMo3514getNativeTypefacePYhJU0U, false, 2, null);
    }
}
