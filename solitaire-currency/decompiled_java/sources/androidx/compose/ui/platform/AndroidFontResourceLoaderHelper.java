package androidx.compose.ui.platform;

import android.content.Context;
import android.graphics.Typeface;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidFontResourceLoader.android.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
final class AndroidFontResourceLoaderHelper {

    @NotNull
    public static final AndroidFontResourceLoaderHelper INSTANCE = new AndroidFontResourceLoaderHelper();

    private AndroidFontResourceLoaderHelper() {
    }

    @DoNotInline
    @RequiresApi(26)
    @NotNull
    public final Typeface create(@NotNull Context context, int i10) {
        kotlin.jvm.internal.t.i(context, "context");
        Typeface font = context.getResources().getFont(i10);
        kotlin.jvm.internal.t.h(font, "context.resources.getFont(resourceId)");
        return font;
    }
}
