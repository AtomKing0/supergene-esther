package androidx.compose.ui.text.intl;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PlatformLocale.kt */
/* JADX INFO: loaded from: classes.dex */
public interface PlatformLocaleDelegate {
    @NotNull
    List<PlatformLocale> getCurrent();

    @NotNull
    PlatformLocale parseLanguageTag(@NotNull String str);
}
