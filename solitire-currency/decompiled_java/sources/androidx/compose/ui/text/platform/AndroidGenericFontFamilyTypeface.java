package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.ui.text.font.AndroidFontUtils_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.font.TypefaceHelperMethodsApi28;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidGenericFontFamilyTypeface.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidGenericFontFamilyTypeface implements AndroidTypeface {

    @NotNull
    private final FontFamily fontFamily;

    @NotNull
    private final Typeface nativeTypeface;

    public AndroidGenericFontFamilyTypeface(@NotNull GenericFontFamily fontFamily) {
        t.i(fontFamily, "fontFamily");
        this.fontFamily = fontFamily;
        Typeface typefaceCreate = Typeface.create(fontFamily.getName(), 0);
        t.f(typefaceCreate);
        this.nativeTypeface = typefaceCreate;
    }

    /* JADX INFO: renamed from: buildStyledTypeface-FO1MlWM, reason: not valid java name */
    private final Typeface m3515buildStyledTypefaceFO1MlWM(FontWeight fontWeight, int i10) {
        return Build.VERSION.SDK_INT < 28 ? Typeface.create(this.nativeTypeface, AndroidFontUtils_androidKt.m3373getAndroidTypefaceStyleFO1MlWM(fontWeight, i10)) : TypefaceHelperMethodsApi28.INSTANCE.create(this.nativeTypeface, fontWeight.getWeight(), FontStyle.m3413equalsimpl0(i10, FontStyle.Companion.m3417getItalic_LCdwA()));
    }

    @Override // androidx.compose.ui.text.font.Typeface
    @NotNull
    public FontFamily getFontFamily() {
        return this.fontFamily;
    }

    @Override // androidx.compose.ui.text.platform.AndroidTypeface
    @NotNull
    /* JADX INFO: renamed from: getNativeTypeface-PYhJU0U */
    public Typeface mo3514getNativeTypefacePYhJU0U(@NotNull FontWeight fontWeight, int i10, int i11) {
        t.i(fontWeight, "fontWeight");
        Typeface typefaceM3515buildStyledTypefaceFO1MlWM = m3515buildStyledTypefaceFO1MlWM(fontWeight, i10);
        t.h(typefaceM3515buildStyledTypefaceFO1MlWM, "buildStyledTypeface(fontWeight, fontStyle)");
        return typefaceM3515buildStyledTypefaceFO1MlWM;
    }
}
