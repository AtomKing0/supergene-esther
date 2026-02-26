package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.compose.ui.text.font.AndroidFont;
import androidx.compose.ui.text.font.FontLoadingStrategy;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;
import v8.u;

/* JADX INFO: compiled from: AndroidFontLoader.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidFontLoader implements PlatformFontLoader {

    @Nullable
    private final Object cacheKey;
    private final Context context;

    public AndroidFontLoader(@NotNull Context context) {
        t.i(context, "context");
        this.context = context.getApplicationContext();
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    @Nullable
    public Object awaitLoad(@NotNull Font font, @NotNull z8.d<? super android.graphics.Typeface> dVar) {
        if (font instanceof AndroidFont) {
            AndroidFont androidFont = (AndroidFont) font;
            AndroidFont.TypefaceLoader typefaceLoader = androidFont.getTypefaceLoader();
            Context context = this.context;
            t.h(context, "context");
            return typefaceLoader.awaitLoad(context, androidFont, dVar);
        }
        if (font instanceof ResourceFont) {
            Context context2 = this.context;
            t.h(context2, "context");
            Object objLoadAsync = AndroidFontLoader_androidKt.loadAsync((ResourceFont) font, context2, dVar);
            return objLoadAsync == a9.d.e() ? objLoadAsync : (android.graphics.Typeface) objLoadAsync;
        }
        throw new IllegalArgumentException("Unknown font type: " + font);
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    @Nullable
    public Object getCacheKey() {
        return this.cacheKey;
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    @Nullable
    public android.graphics.Typeface loadBlocking(@NotNull Font font) {
        Object objB;
        t.i(font, "font");
        if (font instanceof AndroidFont) {
            AndroidFont androidFont = (AndroidFont) font;
            AndroidFont.TypefaceLoader typefaceLoader = androidFont.getTypefaceLoader();
            Context context = this.context;
            t.h(context, "context");
            return typefaceLoader.loadBlocking(context, androidFont);
        }
        if (!(font instanceof ResourceFont)) {
            return null;
        }
        int iMo3362getLoadingStrategyPKNRLFQ = font.mo3362getLoadingStrategyPKNRLFQ();
        FontLoadingStrategy.Companion companion = FontLoadingStrategy.Companion;
        if (FontLoadingStrategy.m3400equalsimpl0(iMo3362getLoadingStrategyPKNRLFQ, companion.m3405getBlockingPKNRLFQ())) {
            Context context2 = this.context;
            t.h(context2, "context");
            return AndroidFontLoader_androidKt.load((ResourceFont) font, context2);
        }
        if (!FontLoadingStrategy.m3400equalsimpl0(iMo3362getLoadingStrategyPKNRLFQ, companion.m3406getOptionalLocalPKNRLFQ())) {
            if (FontLoadingStrategy.m3400equalsimpl0(iMo3362getLoadingStrategyPKNRLFQ, companion.m3404getAsyncPKNRLFQ())) {
                throw new UnsupportedOperationException("Unsupported Async font load path");
            }
            throw new IllegalArgumentException("Unknown loading type " + ((Object) FontLoadingStrategy.m3402toStringimpl(font.mo3362getLoadingStrategyPKNRLFQ())));
        }
        try {
            t.a aVar = v8.t.f35208b;
            Context context3 = this.context;
            kotlin.jvm.internal.t.h(context3, "context");
            objB = v8.t.b(AndroidFontLoader_androidKt.load((ResourceFont) font, context3));
        } catch (Throwable th) {
            t.a aVar2 = v8.t.f35208b;
            objB = v8.t.b(u.a(th));
        }
        return (android.graphics.Typeface) (v8.t.g(objB) ? null : objB);
    }
}
