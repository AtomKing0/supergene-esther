package androidx.compose.ui.text.font;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidFontUtils.android.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
public final class TypefaceHelperMethodsApi28 {

    @NotNull
    public static final TypefaceHelperMethodsApi28 INSTANCE = new TypefaceHelperMethodsApi28();

    private TypefaceHelperMethodsApi28() {
    }

    @DoNotInline
    @RequiresApi(28)
    @NotNull
    public final android.graphics.Typeface create(@NotNull android.graphics.Typeface typeface, int i10, boolean z10) {
        t.i(typeface, "typeface");
        android.graphics.Typeface typefaceCreate = android.graphics.Typeface.create(typeface, i10, z10);
        t.h(typefaceCreate, "create(typeface, finalFontWeight, finalFontStyle)");
        return typefaceCreate;
    }
}
