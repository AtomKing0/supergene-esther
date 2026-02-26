package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidFontLoader.android.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
final class ResourceFontHelper {

    @NotNull
    public static final ResourceFontHelper INSTANCE = new ResourceFontHelper();

    private ResourceFontHelper() {
    }

    @DoNotInline
    @NotNull
    public final android.graphics.Typeface load(@NotNull Context context, @NotNull ResourceFont font) {
        t.i(context, "context");
        t.i(font, "font");
        android.graphics.Typeface font2 = context.getResources().getFont(font.getResId());
        t.h(font2, "context.resources.getFont(font.resId)");
        return font2;
    }
}
