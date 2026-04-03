package androidx.compose.ui.text.platform.extensions;

import androidx.compose.ui.text.intl.AndroidLocale;
import java.util.Locale;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LocaleExtensions.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LocaleExtensions_androidKt {
    @NotNull
    public static final Locale toJavaLocale(@NotNull androidx.compose.ui.text.intl.Locale locale) {
        t.i(locale, "<this>");
        return ((AndroidLocale) locale.getPlatformLocale$ui_text_release()).getJavaLocale();
    }
}
