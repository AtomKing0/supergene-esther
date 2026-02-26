package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.PlatformStringDelegate;
import androidx.compose.ui.text.intl.AndroidLocale;
import androidx.compose.ui.text.intl.PlatformLocale;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import p9.b;

/* JADX INFO: compiled from: AndroidStringDelegate.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidStringDelegate implements PlatformStringDelegate {
    @Override // androidx.compose.ui.text.PlatformStringDelegate
    @NotNull
    public String capitalize(@NotNull String string, @NotNull PlatformLocale locale) {
        t.i(string, "string");
        t.i(locale, "locale");
        if (!(string.length() > 0)) {
            return string;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = string.charAt(0);
        sb.append((Object) (Character.isLowerCase(cCharAt) ? b.e(cCharAt, ((AndroidLocale) locale).getJavaLocale()) : String.valueOf(cCharAt)));
        String strSubstring = string.substring(1);
        t.h(strSubstring, "this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring);
        return sb.toString();
    }

    @Override // androidx.compose.ui.text.PlatformStringDelegate
    @NotNull
    public String decapitalize(@NotNull String string, @NotNull PlatformLocale locale) {
        t.i(string, "string");
        t.i(locale, "locale");
        if (!(string.length() > 0)) {
            return string;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((Object) b.d(string.charAt(0), ((AndroidLocale) locale).getJavaLocale()));
        String strSubstring = string.substring(1);
        t.h(strSubstring, "this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring);
        return sb.toString();
    }

    @Override // androidx.compose.ui.text.PlatformStringDelegate
    @NotNull
    public String toLowerCase(@NotNull String string, @NotNull PlatformLocale locale) {
        t.i(string, "string");
        t.i(locale, "locale");
        String lowerCase = string.toLowerCase(((AndroidLocale) locale).getJavaLocale());
        t.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    @Override // androidx.compose.ui.text.PlatformStringDelegate
    @NotNull
    public String toUpperCase(@NotNull String string, @NotNull PlatformLocale locale) {
        t.i(string, "string");
        t.i(locale, "locale");
        String upperCase = string.toUpperCase(((AndroidLocale) locale).getJavaLocale());
        t.h(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }
}
