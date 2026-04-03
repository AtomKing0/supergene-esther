package androidx.compose.ui.text.font;

import androidx.compose.ui.text.ExperimentalTextApi;
import androidx.compose.ui.text.font.AsyncTypefaceCache;
import androidx.compose.ui.text.font.FontLoadingStrategy;
import h9.l;
import java.util.List;
import kotlin.collections.v;
import v8.k0;
import v8.s;
import v8.t;
import v8.u;
import v8.y;

/* JADX INFO: compiled from: FontListFontFamilyTypefaceAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FontListFontFamilyTypefaceAdapterKt {
    /* JADX INFO: Access modifiers changed from: private */
    @ExperimentalTextApi
    public static final s<List<Font>, Object> firstImmediatelyAvailable(List<? extends Font> list, TypefaceRequest typefaceRequest, AsyncTypefaceCache asyncTypefaceCache, PlatformFontLoader platformFontLoader, l<? super TypefaceRequest, ? extends Object> lVar) {
        Object objLoadBlocking;
        Object objB;
        int size = list.size();
        List listQ = null;
        for (int i10 = 0; i10 < size; i10++) {
            Font font = list.get(i10);
            int iMo3362getLoadingStrategyPKNRLFQ = font.mo3362getLoadingStrategyPKNRLFQ();
            FontLoadingStrategy.Companion companion = FontLoadingStrategy.Companion;
            if (FontLoadingStrategy.m3400equalsimpl0(iMo3362getLoadingStrategyPKNRLFQ, companion.m3405getBlockingPKNRLFQ())) {
                synchronized (asyncTypefaceCache.cacheLock) {
                    AsyncTypefaceCache.Key key = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                    AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key);
                    if (asyncTypefaceResult == null) {
                        asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key);
                    }
                    if (asyncTypefaceResult != null) {
                        objLoadBlocking = asyncTypefaceResult.m3382unboximpl();
                    } else {
                        k0 k0Var = k0.f35197a;
                        try {
                            objLoadBlocking = platformFontLoader.loadBlocking(font);
                            AsyncTypefaceCache.put$default(asyncTypefaceCache, font, platformFontLoader, objLoadBlocking, false, 8, null);
                        } catch (Exception e10) {
                            throw new IllegalStateException("Unable to load font " + font, e10);
                        }
                    }
                }
                if (objLoadBlocking != null) {
                    return y.a(listQ, FontSynthesis_androidKt.m3432synthesizeTypefaceFxwP2eA(typefaceRequest.m3452getFontSynthesisGVVA2EU(), objLoadBlocking, font, typefaceRequest.getFontWeight(), typefaceRequest.m3451getFontStyle_LCdwA()));
                }
                throw new IllegalStateException("Unable to load font " + font);
            }
            if (FontLoadingStrategy.m3400equalsimpl0(iMo3362getLoadingStrategyPKNRLFQ, companion.m3406getOptionalLocalPKNRLFQ())) {
                synchronized (asyncTypefaceCache.cacheLock) {
                    AsyncTypefaceCache.Key key2 = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                    AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key2);
                    if (asyncTypefaceResult2 == null) {
                        asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key2);
                    }
                    if (asyncTypefaceResult2 != null) {
                        objB = asyncTypefaceResult2.m3382unboximpl();
                    } else {
                        k0 k0Var2 = k0.f35197a;
                        try {
                            t.a aVar = t.f35208b;
                            objB = t.b(platformFontLoader.loadBlocking(font));
                        } catch (Throwable th) {
                            t.a aVar2 = t.f35208b;
                            objB = t.b(u.a(th));
                        }
                        if (t.g(objB)) {
                            objB = null;
                        }
                        AsyncTypefaceCache.put$default(asyncTypefaceCache, font, platformFontLoader, objB, false, 8, null);
                    }
                }
                if (objB != null) {
                    return y.a(listQ, FontSynthesis_androidKt.m3432synthesizeTypefaceFxwP2eA(typefaceRequest.m3452getFontSynthesisGVVA2EU(), objB, font, typefaceRequest.getFontWeight(), typefaceRequest.m3451getFontStyle_LCdwA()));
                }
            } else {
                if (!FontLoadingStrategy.m3400equalsimpl0(iMo3362getLoadingStrategyPKNRLFQ, companion.m3404getAsyncPKNRLFQ())) {
                    throw new IllegalStateException("Unknown font type " + font);
                }
                AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResultM3374get1ASDuI8 = asyncTypefaceCache.m3374get1ASDuI8(font, platformFontLoader);
                if (asyncTypefaceResultM3374get1ASDuI8 != null) {
                    if (!AsyncTypefaceCache.AsyncTypefaceResult.m3380isPermanentFailureimpl(asyncTypefaceResultM3374get1ASDuI8.m3382unboximpl()) && asyncTypefaceResultM3374get1ASDuI8.m3382unboximpl() != null) {
                        return y.a(listQ, FontSynthesis_androidKt.m3432synthesizeTypefaceFxwP2eA(typefaceRequest.m3452getFontSynthesisGVVA2EU(), asyncTypefaceResultM3374get1ASDuI8.m3382unboximpl(), font, typefaceRequest.getFontWeight(), typefaceRequest.m3451getFontStyle_LCdwA()));
                    }
                } else if (listQ == null) {
                    listQ = v.q(font);
                } else {
                    listQ.add(font);
                }
            }
        }
        return y.a(listQ, lVar.invoke(typefaceRequest));
    }
}
