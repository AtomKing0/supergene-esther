package androidx.compose.ui.text.intl;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Locale.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class Locale {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final PlatformLocale platformLocale;

    /* JADX INFO: compiled from: Locale.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final Locale getCurrent() {
            return new Locale(PlatformLocaleKt.getPlatformLocaleDelegate().getCurrent().get(0));
        }
    }

    public Locale(@NotNull PlatformLocale platformLocale) {
        t.i(platformLocale, "platformLocale");
        this.platformLocale = platformLocale;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof Locale)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return t.d(toLanguageTag(), ((Locale) obj).toLanguageTag());
    }

    @NotNull
    public final String getLanguage() {
        return this.platformLocale.getLanguage();
    }

    @NotNull
    public final PlatformLocale getPlatformLocale$ui_text_release() {
        return this.platformLocale;
    }

    @NotNull
    public final String getRegion() {
        return this.platformLocale.getRegion();
    }

    @NotNull
    public final String getScript() {
        return this.platformLocale.getScript();
    }

    public int hashCode() {
        return toLanguageTag().hashCode();
    }

    @NotNull
    public final String toLanguageTag() {
        return this.platformLocale.toLanguageTag();
    }

    @NotNull
    public String toString() {
        return toLanguageTag();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Locale(@NotNull String languageTag) {
        this(PlatformLocaleKt.getPlatformLocaleDelegate().parseLanguageTag(languageTag));
        t.i(languageTag, "languageTag");
    }
}
