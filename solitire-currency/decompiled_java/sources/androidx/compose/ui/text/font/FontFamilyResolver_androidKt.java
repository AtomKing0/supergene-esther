package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.compose.ui.text.ExperimentalTextApi;
import androidx.compose.ui.text.InternalTextApi;
import androidx.compose.ui.text.font.FontFamily;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import z8.g;

/* JADX INFO: compiled from: FontFamilyResolver.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FontFamilyResolver_androidKt {
    @NotNull
    public static final FontFamily.Resolver createFontFamilyResolver(@NotNull Context context) {
        t.i(context, "context");
        return new FontFamilyResolverImpl(new AndroidFontLoader(context), AndroidFontResolveInterceptor_androidKt.AndroidFontResolveInterceptor(context), null, null, null, 28, null);
    }

    @InternalTextApi
    @NotNull
    public static final FontFamily.Resolver emptyCacheFontFamilyResolver(@NotNull Context context) {
        t.i(context, "context");
        return new FontFamilyResolverImpl(new AndroidFontLoader(context), null, new TypefaceRequestCache(), new FontListFontFamilyTypefaceAdapter(new AsyncTypefaceCache(), null, 2, null), null, 18, null);
    }

    @ExperimentalTextApi
    @NotNull
    public static final FontFamily.Resolver createFontFamilyResolver(@NotNull Context context, @NotNull g coroutineContext) {
        t.i(context, "context");
        t.i(coroutineContext, "coroutineContext");
        return new FontFamilyResolverImpl(new AndroidFontLoader(context), AndroidFontResolveInterceptor_androidKt.AndroidFontResolveInterceptor(context), FontFamilyResolverKt.getGlobalTypefaceRequestCache(), new FontListFontFamilyTypefaceAdapter(FontFamilyResolverKt.getGlobalAsyncTypefaceCache(), coroutineContext), null, 16, null);
    }
}
