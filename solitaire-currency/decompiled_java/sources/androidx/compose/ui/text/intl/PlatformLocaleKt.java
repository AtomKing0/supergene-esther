package androidx.compose.ui.text.intl;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PlatformLocale.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PlatformLocaleKt {

    @NotNull
    private static final PlatformLocaleDelegate platformLocaleDelegate = AndroidPlatformLocale_androidKt.createPlatformLocaleDelegate();

    @NotNull
    public static final PlatformLocaleDelegate getPlatformLocaleDelegate() {
        return platformLocaleDelegate;
    }
}
