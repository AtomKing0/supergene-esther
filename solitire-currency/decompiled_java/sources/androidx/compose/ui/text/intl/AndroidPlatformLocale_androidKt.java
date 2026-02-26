package androidx.compose.ui.text.intl;

import android.os.Build;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidPlatformLocale.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidPlatformLocale_androidKt {
    @NotNull
    public static final PlatformLocaleDelegate createPlatformLocaleDelegate() {
        return Build.VERSION.SDK_INT >= 24 ? new AndroidLocaleDelegateAPI24() : new AndroidLocaleDelegateAPI23();
    }
}
