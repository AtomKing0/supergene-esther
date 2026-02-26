package androidx.compose.ui.text.font;

import android.content.Context;
import android.os.Build;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidFontResolveInterceptor.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidFontResolveInterceptor_androidKt {
    @NotNull
    public static final AndroidFontResolveInterceptor AndroidFontResolveInterceptor(@NotNull Context context) {
        t.i(context, "context");
        return new AndroidFontResolveInterceptor(Build.VERSION.SDK_INT >= 31 ? context.getResources().getConfiguration().fontWeightAdjustment : 0);
    }
}
