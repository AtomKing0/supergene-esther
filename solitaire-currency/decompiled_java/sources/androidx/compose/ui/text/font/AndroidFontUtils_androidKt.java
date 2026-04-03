package androidx.compose.ui.text.font;

import androidx.compose.ui.text.font.FontWeight;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidFontUtils.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidFontUtils_androidKt {
    @NotNull
    public static final FontWeight getAndroidBold(@NotNull FontWeight.Companion companion) {
        t.i(companion, "<this>");
        return companion.getW600();
    }

    public static final int getAndroidTypefaceStyle(boolean z10, boolean z11) {
        if (z11 && z10) {
            return 3;
        }
        if (z10) {
            return 1;
        }
        return z11 ? 2 : 0;
    }

    /* JADX INFO: renamed from: getAndroidTypefaceStyle-FO1MlWM, reason: not valid java name */
    public static final int m3373getAndroidTypefaceStyleFO1MlWM(@NotNull FontWeight fontWeight, int i10) {
        t.i(fontWeight, "fontWeight");
        return getAndroidTypefaceStyle(fontWeight.compareTo(getAndroidBold(FontWeight.Companion)) >= 0, FontStyle.m3413equalsimpl0(i10, FontStyle.Companion.m3417getItalic_LCdwA()));
    }
}
