package androidx.compose.ui.text.intl;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PlatformLocale.kt */
/* JADX INFO: loaded from: classes.dex */
public interface PlatformLocale {
    @NotNull
    String getLanguage();

    @NotNull
    String getRegion();

    @NotNull
    String getScript();

    @NotNull
    String toLanguageTag();
}
