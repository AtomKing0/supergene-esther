package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.ui.text.font.AndroidFontUtils_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.TypefaceHelperMethodsApi28;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidDefaultTypeface.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidDefaultTypeface implements AndroidTypeface {

    @NotNull
    private final FontFamily fontFamily = FontFamily.Companion.getDefault();

    @Override // androidx.compose.ui.text.font.Typeface
    @NotNull
    public FontFamily getFontFamily() {
        return this.fontFamily;
    }

    @Override // androidx.compose.ui.text.platform.AndroidTypeface
    @NotNull
    /* JADX INFO: renamed from: getNativeTypeface-PYhJU0U, reason: not valid java name */
    public Typeface mo3514getNativeTypefacePYhJU0U(@NotNull FontWeight fontWeight, int i10, int i11) {
        t.i(fontWeight, "fontWeight");
        if (Build.VERSION.SDK_INT < 28) {
            Typeface typefaceDefaultFromStyle = Typeface.defaultFromStyle(AndroidFontUtils_androidKt.m3373getAndroidTypefaceStyleFO1MlWM(fontWeight, i10));
            t.h(typefaceDefaultFromStyle, "{\n            Typeface.d…)\n            )\n        }");
            return typefaceDefaultFromStyle;
        }
        TypefaceHelperMethodsApi28 typefaceHelperMethodsApi28 = TypefaceHelperMethodsApi28.INSTANCE;
        Typeface DEFAULT = Typeface.DEFAULT;
        t.h(DEFAULT, "DEFAULT");
        return typefaceHelperMethodsApi28.create(DEFAULT, fontWeight.getWeight(), FontStyle.m3413equalsimpl0(i10, FontStyle.Companion.m3417getItalic_LCdwA()));
    }
}
