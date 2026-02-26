package androidx.compose.ui.text.intl;

import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidLocaleDelegate.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidLocaleDelegateAPI23 implements PlatformLocaleDelegate {
    @Override // androidx.compose.ui.text.intl.PlatformLocaleDelegate
    @NotNull
    public List<PlatformLocale> getCurrent() {
        java.util.Locale locale = java.util.Locale.getDefault();
        t.h(locale, "getDefault()");
        return u.e(new AndroidLocale(locale));
    }

    @Override // androidx.compose.ui.text.intl.PlatformLocaleDelegate
    @NotNull
    public PlatformLocale parseLanguageTag(@NotNull String languageTag) {
        t.i(languageTag, "languageTag");
        java.util.Locale localeForLanguageTag = java.util.Locale.forLanguageTag(languageTag);
        t.h(localeForLanguageTag, "forLanguageTag(languageTag)");
        return new AndroidLocale(localeForLanguageTag);
    }
}
