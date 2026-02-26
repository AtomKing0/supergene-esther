package androidx.compose.ui.text.font;

import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PlatformTypefaces.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
@VisibleForTesting
final class PlatformTypefacesApi28 implements PlatformTypefaces {
    /* JADX INFO: renamed from: createAndroidTypefaceApi28-RetOiIg, reason: not valid java name */
    private final android.graphics.Typeface m3439createAndroidTypefaceApi28RetOiIg(String str, FontWeight fontWeight, int i10) {
        FontStyle.Companion companion = FontStyle.Companion;
        if (FontStyle.m3413equalsimpl0(i10, companion.m3418getNormal_LCdwA()) && t.d(fontWeight, FontWeight.Companion.getNormal())) {
            if (str == null || str.length() == 0) {
                android.graphics.Typeface DEFAULT = android.graphics.Typeface.DEFAULT;
                t.h(DEFAULT, "DEFAULT");
                return DEFAULT;
            }
        }
        android.graphics.Typeface typefaceCreate = android.graphics.Typeface.create(str == null ? android.graphics.Typeface.DEFAULT : android.graphics.Typeface.create(str, 0), fontWeight.getWeight(), FontStyle.m3413equalsimpl0(i10, companion.m3417getItalic_LCdwA()));
        t.h(typefaceCreate, "create(\n            fami…ontStyle.Italic\n        )");
        return typefaceCreate;
    }

    /* JADX INFO: renamed from: createAndroidTypefaceApi28-RetOiIg$default, reason: not valid java name */
    static /* synthetic */ android.graphics.Typeface m3440createAndroidTypefaceApi28RetOiIg$default(PlatformTypefacesApi28 platformTypefacesApi28, String str, FontWeight fontWeight, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        return platformTypefacesApi28.m3439createAndroidTypefaceApi28RetOiIg(str, fontWeight, i10);
    }

    /* JADX INFO: renamed from: loadNamedFromTypefaceCacheOrNull-RetOiIg, reason: not valid java name */
    private final android.graphics.Typeface m3441loadNamedFromTypefaceCacheOrNullRetOiIg(String str, FontWeight fontWeight, int i10) {
        if (str.length() == 0) {
            return null;
        }
        android.graphics.Typeface typefaceM3439createAndroidTypefaceApi28RetOiIg = m3439createAndroidTypefaceApi28RetOiIg(str, fontWeight, i10);
        boolean zM3413equalsimpl0 = FontStyle.m3413equalsimpl0(i10, FontStyle.Companion.m3417getItalic_LCdwA());
        TypefaceHelperMethodsApi28 typefaceHelperMethodsApi28 = TypefaceHelperMethodsApi28.INSTANCE;
        android.graphics.Typeface DEFAULT = android.graphics.Typeface.DEFAULT;
        t.h(DEFAULT, "DEFAULT");
        if ((t.d(typefaceM3439createAndroidTypefaceApi28RetOiIg, typefaceHelperMethodsApi28.create(DEFAULT, fontWeight.getWeight(), zM3413equalsimpl0)) || t.d(typefaceM3439createAndroidTypefaceApi28RetOiIg, m3439createAndroidTypefaceApi28RetOiIg(null, fontWeight, i10))) ? false : true) {
            return typefaceM3439createAndroidTypefaceApi28RetOiIg;
        }
        return null;
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    @NotNull
    /* JADX INFO: renamed from: createDefault-FO1MlWM */
    public android.graphics.Typeface mo3433createDefaultFO1MlWM(@NotNull FontWeight fontWeight, int i10) {
        t.i(fontWeight, "fontWeight");
        return m3439createAndroidTypefaceApi28RetOiIg(null, fontWeight, i10);
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    @NotNull
    /* JADX INFO: renamed from: createNamed-RetOiIg */
    public android.graphics.Typeface mo3434createNamedRetOiIg(@NotNull GenericFontFamily name, @NotNull FontWeight fontWeight, int i10) {
        t.i(name, "name");
        t.i(fontWeight, "fontWeight");
        return m3439createAndroidTypefaceApi28RetOiIg(name.getName(), fontWeight, i10);
    }

    @Override // androidx.compose.ui.text.font.PlatformTypefaces
    @Nullable
    /* JADX INFO: renamed from: optionalOnDeviceFontFamilyByName-RetOiIg */
    public android.graphics.Typeface mo3435optionalOnDeviceFontFamilyByNameRetOiIg(@NotNull String familyName, @NotNull FontWeight weight, int i10) {
        t.i(familyName, "familyName");
        t.i(weight, "weight");
        FontFamily.Companion companion = FontFamily.Companion;
        return t.d(familyName, companion.getSansSerif().getName()) ? mo3434createNamedRetOiIg(companion.getSansSerif(), weight, i10) : t.d(familyName, companion.getSerif().getName()) ? mo3434createNamedRetOiIg(companion.getSerif(), weight, i10) : t.d(familyName, companion.getMonospace().getName()) ? mo3434createNamedRetOiIg(companion.getMonospace(), weight, i10) : t.d(familyName, companion.getCursive().getName()) ? mo3434createNamedRetOiIg(companion.getCursive(), weight, i10) : m3441loadNamedFromTypefaceCacheOrNullRetOiIg(familyName, weight, i10);
    }
}
