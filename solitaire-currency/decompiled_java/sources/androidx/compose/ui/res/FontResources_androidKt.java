package androidx.compose.ui.res;

import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.font.AndroidTypeface_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.LoadedFontFamily;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.text.font.Typeface;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FontResources.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FontResources_androidKt {

    @NotNull
    private static final Object cacheLock = new Object();

    @GuardedBy("cacheLock")
    @NotNull
    private static final Map<FontFamily, Typeface> syncLoadedTypefaces = new LinkedHashMap();

    @Composable
    @ReadOnlyComposable
    @NotNull
    public static final Typeface fontResource(@NotNull FontFamily fontFamily, @Nullable Composer composer, int i10) {
        t.i(fontFamily, "fontFamily");
        return fontResourceFromContext((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext()), fontFamily);
    }

    private static final Typeface fontResourceFromContext(Context context, FontFamily fontFamily) {
        Typeface typeface;
        if (!(fontFamily instanceof SystemFontFamily) && !(fontFamily instanceof LoadedFontFamily)) {
            return AndroidTypeface_androidKt.Typeface$default(context, fontFamily, null, 4, null);
        }
        synchronized (cacheLock) {
            Map<FontFamily, Typeface> map = syncLoadedTypefaces;
            Typeface typefaceTypeface$default = map.get(fontFamily);
            if (typefaceTypeface$default == null) {
                typefaceTypeface$default = AndroidTypeface_androidKt.Typeface$default(context, fontFamily, null, 4, null);
                map.put(fontFamily, typefaceTypeface$default);
            }
            typeface = typefaceTypeface$default;
        }
        return typeface;
    }
}
