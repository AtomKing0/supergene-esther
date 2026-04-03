package androidx.compose.ui.text.font;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PlatformTypefaces.kt */
/* JADX INFO: loaded from: classes.dex */
public interface PlatformTypefaces {
    @NotNull
    /* JADX INFO: renamed from: createDefault-FO1MlWM, reason: not valid java name */
    android.graphics.Typeface mo3433createDefaultFO1MlWM(@NotNull FontWeight fontWeight, int i10);

    @NotNull
    /* JADX INFO: renamed from: createNamed-RetOiIg, reason: not valid java name */
    android.graphics.Typeface mo3434createNamedRetOiIg(@NotNull GenericFontFamily genericFontFamily, @NotNull FontWeight fontWeight, int i10);

    @Nullable
    /* JADX INFO: renamed from: optionalOnDeviceFontFamilyByName-RetOiIg, reason: not valid java name */
    android.graphics.Typeface mo3435optionalOnDeviceFontFamilyByNameRetOiIg(@NotNull String str, @NotNull FontWeight fontWeight, int i10);
}
