package androidx.compose.ui.text.platform;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.TypedValue;
import androidx.collection.LruCache;
import androidx.compose.ui.text.font.AndroidFont;
import androidx.compose.ui.text.font.AndroidPreloadedFont;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.ResourceFont;
import androidx.core.content.res.ResourcesCompat;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidFontListTypeface.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidTypefaceCache {

    @NotNull
    public static final AndroidTypefaceCache INSTANCE = new AndroidTypefaceCache();

    @NotNull
    private static final LruCache<String, Typeface> cache = new LruCache<>(16);

    private AndroidTypefaceCache() {
    }

    @Nullable
    public final String getKey(@NotNull Context context, @NotNull Font font) {
        t.i(context, "context");
        t.i(font, "font");
        if (!(font instanceof ResourceFont)) {
            if (font instanceof AndroidPreloadedFont) {
                return ((AndroidPreloadedFont) font).getCacheKey();
            }
            throw new IllegalArgumentException("Unknown font type: " + font);
        }
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(((ResourceFont) font).getResId(), typedValue, true);
        StringBuilder sb = new StringBuilder();
        sb.append("res:");
        CharSequence charSequence = typedValue.string;
        String string = charSequence != null ? charSequence.toString() : null;
        t.f(string);
        sb.append(string);
        return sb.toString();
    }

    @NotNull
    public final Typeface getOrCreate(@NotNull Context context, @NotNull Font font) {
        Typeface typefaceLoadBlocking;
        Typeface it;
        t.i(context, "context");
        t.i(font, "font");
        String key = getKey(context, font);
        if (key != null && (it = cache.get(key)) != null) {
            t.h(it, "it");
            return it;
        }
        if (font instanceof ResourceFont) {
            if (Build.VERSION.SDK_INT >= 26) {
                typefaceLoadBlocking = AndroidResourceFontLoaderHelper.INSTANCE.create(context, ((ResourceFont) font).getResId());
            } else {
                typefaceLoadBlocking = ResourcesCompat.getFont(context, ((ResourceFont) font).getResId());
                t.f(typefaceLoadBlocking);
                t.h(typefaceLoadBlocking, "{\n                    Re…esId)!!\n                }");
            }
        } else {
            if (!(font instanceof AndroidFont)) {
                throw new IllegalArgumentException("Unknown font type: " + font);
            }
            AndroidFont androidFont = (AndroidFont) font;
            typefaceLoadBlocking = androidFont.getTypefaceLoader().loadBlocking(context, androidFont);
        }
        if (typefaceLoadBlocking != null) {
            if (key != null) {
                cache.put(key, typefaceLoadBlocking);
            }
            return typefaceLoadBlocking;
        }
        throw new IllegalArgumentException("Unable to load font " + font);
    }
}
