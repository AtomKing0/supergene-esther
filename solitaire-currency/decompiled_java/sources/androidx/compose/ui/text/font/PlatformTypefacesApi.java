package androidx.compose.ui.text.font;

import androidx.annotation.VisibleForTesting;
import androidx.compose.ui.text.font.FontFamily;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PlatformTypefaces.kt */
/* JADX INFO: loaded from: classes.dex */
@VisibleForTesting
final class PlatformTypefacesApi implements PlatformTypefaces {
    /* JADX INFO: renamed from: createAndroidTypefaceUsingTypefaceStyle-RetOiIg, reason: not valid java name */
    private final android.graphics.Typeface m3436createAndroidTypefaceUsingTypefaceStyleRetOiIg(String str, FontWeight fontWeight, int i10) {
        if (FontStyle.m3413equalsimpl0(i10, FontStyle.Companion.m3418getNormal_LCdwA()) && t.d(fontWeight, FontWeight.Companion.getNormal())) {
            if (str == null || str.length() == 0) {
                android.graphics.Typeface DEFAULT = android.graphics.Typeface.DEFAULT;
                t.h(DEFAULT, "DEFAULT");
                return DEFAULT;
            }
        }
        int iM3373getAndroidTypefaceStyleFO1MlWM = AndroidFontUtils_androidKt.m3373getAndroidTypefaceStyleFO1MlWM(fontWeight, i10);
        if (str == null || str.length() == 0) {
            android.graphics.Typeface typefaceDefaultFromStyle = android.graphics.Typeface.defaultFromStyle(iM3373getAndroidTypefaceStyleFO1MlWM);
            t.h(typefaceDefaultFromStyle, "{\n            Typeface.d…le(targetStyle)\n        }");
            return typefaceDefaultFromStyle;
        }
        android.graphics.Typeface typefaceCreate = android.graphics.Typeface.create(str, iM3373getAndroidTypefaceStyleFO1MlWM);
        t.h(typefaceCreate, "{\n            Typeface.c…y, targetStyle)\n        }");
        return typefaceCreate;
    }

    /* JADX INFO: renamed from: createAndroidTypefaceUsingTypefaceStyle-RetOiIg$default, reason: not valid java name */
    static /* synthetic */ android.graphics.Typeface m3437createAndroidTypefaceUsingTypefaceStyleRetOiIg$default(PlatformTypefacesApi platformTypefacesApi, String str, FontWeight fontWeight, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        if ((i11 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i11 & 4) != 0) {
            i10 = FontStyle.Companion.m3418getNormal_LCdwA();
        }
        return platformTypefacesApi.m3436createAndroidTypefaceUsingTypefaceStyleRetOiIg(str, fontWeight, i10);
    }

    /* JADX INFO: renamed from: loadNamedFromTypefaceCacheOrNull-RetOiIg, reason: not valid java name */
    private final android.graphics.Typeface m3438loadNamedFromTypefaceCacheOrNullRetOiIg(String str, FontWeight fontWeight, int i10) {
        if (str.length() == 0) {
            return null;
        }
        android.graphics.Typeface typefaceM3436createAndroidTypefaceUsingTypefaceStyleRetOiIg = m3436createAndroidTypefaceUsingTypefaceStyleRetOiIg(str, fontWeight, i10);
        if ((t.d(typefaceM3436createAndroidTypefaceUsingTypefaceStyleRetOiIg, android.graphics.Typeface.create(android.graphics.Typeface.DEFAULT, AndroidFontUtils_androidKt.m3373getAndroidTypefaceStyleFO1MlWM(fontWeight, i10))) || t.d(typefaceM3436createAndroidTypefaceUsingTypefaceStyleRetOiIg, m3436createAndroidTypefaceUsingTypefaceStyleRetOiIg(null, fontWeight, i10))) ? false : true) {
            return typefaceM3436createAndroidTypefaceUsingTypefaceStyleRetOiIg;
        }
        return null;
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    @NotNull
    /* JADX INFO: renamed from: createDefault-FO1MlWM */
    public android.graphics.Typeface mo3433createDefaultFO1MlWM(@NotNull FontWeight fontWeight, int i10) {
        t.i(fontWeight, "fontWeight");
        return m3436createAndroidTypefaceUsingTypefaceStyleRetOiIg(null, fontWeight, i10);
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    @NotNull
    /* JADX INFO: renamed from: createNamed-RetOiIg */
    public android.graphics.Typeface mo3434createNamedRetOiIg(@NotNull GenericFontFamily name, @NotNull FontWeight fontWeight, int i10) {
        t.i(name, "name");
        t.i(fontWeight, "fontWeight");
        android.graphics.Typeface typefaceM3438loadNamedFromTypefaceCacheOrNullRetOiIg = m3438loadNamedFromTypefaceCacheOrNullRetOiIg(PlatformTypefacesKt.getWeightSuffixForFallbackFamilyName(name.getName(), fontWeight), fontWeight, i10);
        return typefaceM3438loadNamedFromTypefaceCacheOrNullRetOiIg == null ? m3436createAndroidTypefaceUsingTypefaceStyleRetOiIg(name.getName(), fontWeight, i10) : typefaceM3438loadNamedFromTypefaceCacheOrNullRetOiIg;
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    @Nullable
    /* JADX INFO: renamed from: optionalOnDeviceFontFamilyByName-RetOiIg */
    public android.graphics.Typeface mo3435optionalOnDeviceFontFamilyByNameRetOiIg(@NotNull String familyName, @NotNull FontWeight weight, int i10) {
        t.i(familyName, "familyName");
        t.i(weight, "weight");
        FontFamily.Companion companion = FontFamily.Companion;
        return t.d(familyName, companion.getSansSerif().getName()) ? mo3434createNamedRetOiIg(companion.getSansSerif(), weight, i10) : t.d(familyName, companion.getSerif().getName()) ? mo3434createNamedRetOiIg(companion.getSerif(), weight, i10) : t.d(familyName, companion.getMonospace().getName()) ? mo3434createNamedRetOiIg(companion.getMonospace(), weight, i10) : t.d(familyName, companion.getCursive().getName()) ? mo3434createNamedRetOiIg(companion.getCursive(), weight, i10) : m3438loadNamedFromTypefaceCacheOrNullRetOiIg(familyName, weight, i10);
    }
}
