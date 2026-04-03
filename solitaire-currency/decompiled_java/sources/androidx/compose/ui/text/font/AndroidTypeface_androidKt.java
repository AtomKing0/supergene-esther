package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.compose.ui.text.platform.AndroidDefaultTypeface;
import androidx.compose.ui.text.platform.AndroidFontListTypeface;
import androidx.compose.ui.text.platform.AndroidGenericFontFamilyTypeface;
import androidx.compose.ui.text.platform.AndroidTypefaceWrapper;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.q;
import v8.s;

/* JADX INFO: compiled from: AndroidTypeface.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidTypeface_androidKt {
    @NotNull
    public static final FontFamily FontFamily(@NotNull android.graphics.Typeface typeface) {
        t.i(typeface, "typeface");
        return FontFamilyKt.FontFamily(Typeface(typeface));
    }

    @NotNull
    public static final Typeface Typeface(@NotNull Context context, @NotNull FontFamily fontFamily, @Nullable List<s<FontWeight, FontStyle>> list) {
        t.i(context, "context");
        t.i(fontFamily, "fontFamily");
        if (fontFamily instanceof FontListFontFamily) {
            return new AndroidFontListTypeface((FontListFontFamily) fontFamily, context, list, null, 8, null);
        }
        if (fontFamily instanceof GenericFontFamily) {
            return new AndroidGenericFontFamilyTypeface((GenericFontFamily) fontFamily);
        }
        if (fontFamily instanceof DefaultFontFamily) {
            return new AndroidDefaultTypeface();
        }
        if (fontFamily instanceof LoadedFontFamily) {
            return ((LoadedFontFamily) fontFamily).getTypeface();
        }
        throw new q();
    }

    public static /* synthetic */ Typeface Typeface$default(Context context, FontFamily fontFamily, List list, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            list = null;
        }
        return Typeface(context, fontFamily, list);
    }

    @NotNull
    public static final Typeface Typeface(@NotNull android.graphics.Typeface typeface) {
        t.i(typeface, "typeface");
        return new AndroidTypefaceWrapper(typeface);
    }
}
