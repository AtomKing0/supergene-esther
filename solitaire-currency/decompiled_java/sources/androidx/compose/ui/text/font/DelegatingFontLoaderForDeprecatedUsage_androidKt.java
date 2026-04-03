package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DelegatingFontLoaderForDeprecatedUsage.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DelegatingFontLoaderForDeprecatedUsage_androidKt {
    @NotNull
    public static final FontFamily.Resolver createFontFamilyResolver(@NotNull Font.ResourceLoader fontResourceLoader, @NotNull Context context) {
        t.i(fontResourceLoader, "fontResourceLoader");
        t.i(context, "context");
        Context applicationContext = context.getApplicationContext();
        t.h(applicationContext, "context.applicationContext");
        return new FontFamilyResolverImpl(new DelegatingFontLoaderForBridgeUsage(fontResourceLoader, applicationContext), null, null, null, null, 30, null);
    }

    @NotNull
    public static final FontFamily.Resolver createFontFamilyResolver(@NotNull Font.ResourceLoader fontResourceLoader) {
        t.i(fontResourceLoader, "fontResourceLoader");
        return new FontFamilyResolverImpl(new DelegatingFontLoaderForDeprecatedUsage(fontResourceLoader), null, null, null, null, 30, null);
    }
}
