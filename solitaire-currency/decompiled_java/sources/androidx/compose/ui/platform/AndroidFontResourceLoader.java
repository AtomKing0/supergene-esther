package androidx.compose.ui.platform;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.ResourceFont;
import androidx.core.content.res.ResourcesCompat;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidFontResourceLoader.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidFontResourceLoader implements Font.ResourceLoader {

    @NotNull
    private final Context context;

    public AndroidFontResourceLoader(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        this.context = context;
    }

    @Override // androidx.compose.ui.text.font.Font.ResourceLoader
    @NotNull
    public Typeface load(@NotNull Font font) {
        kotlin.jvm.internal.t.i(font, "font");
        if (!(font instanceof ResourceFont)) {
            throw new IllegalArgumentException("Unknown font type: " + font);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return AndroidFontResourceLoaderHelper.INSTANCE.create(this.context, ((ResourceFont) font).getResId());
        }
        Typeface font2 = ResourcesCompat.getFont(this.context, ((ResourceFont) font).getResId());
        kotlin.jvm.internal.t.f(font2);
        kotlin.jvm.internal.t.h(font2, "{\n                    Re…esId)!!\n                }");
        return font2;
    }
}
