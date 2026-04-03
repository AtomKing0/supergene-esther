package androidx.compose.ui.text.font;

import androidx.compose.runtime.Stable;
import java.util.List;
import kotlin.collections.o;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FontFamily.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FontFamilyKt {
    @Stable
    @NotNull
    public static final FontFamily FontFamily(@NotNull List<? extends Font> fonts) {
        t.i(fonts, "fonts");
        return new FontListFontFamily(fonts);
    }

    @Stable
    @NotNull
    public static final FontFamily FontFamily(@NotNull Font... fonts) {
        t.i(fonts, "fonts");
        return new FontListFontFamily(o.c(fonts));
    }

    @Stable
    @NotNull
    public static final FontFamily FontFamily(@NotNull Typeface typeface) {
        t.i(typeface, "typeface");
        return new LoadedFontFamily(typeface);
    }
}
