package androidx.compose.ui.text.intl;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidLocaleDelegate.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidLocale implements PlatformLocale {

    @NotNull
    private final java.util.Locale javaLocale;

    public AndroidLocale(@NotNull java.util.Locale javaLocale) {
        t.i(javaLocale, "javaLocale");
        this.javaLocale = javaLocale;
    }

    @NotNull
    public final java.util.Locale getJavaLocale() {
        return this.javaLocale;
    }

    @Override // androidx.compose.ui.text.intl.PlatformLocale
    @NotNull
    public String getLanguage() {
        String language = this.javaLocale.getLanguage();
        t.h(language, "javaLocale.language");
        return language;
    }

    @Override // androidx.compose.ui.text.intl.PlatformLocale
    @NotNull
    public String getRegion() {
        String country = this.javaLocale.getCountry();
        t.h(country, "javaLocale.country");
        return country;
    }

    @Override // androidx.compose.ui.text.intl.PlatformLocale
    @NotNull
    public String getScript() {
        String script = this.javaLocale.getScript();
        t.h(script, "javaLocale.script");
        return script;
    }

    @Override // androidx.compose.ui.text.intl.PlatformLocale
    @NotNull
    public String toLanguageTag() {
        String languageTag = this.javaLocale.toLanguageTag();
        t.h(languageTag, "javaLocale.toLanguageTag()");
        return languageTag;
    }
}
