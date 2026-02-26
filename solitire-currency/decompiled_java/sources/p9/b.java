package p9;

import java.util.Locale;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: CharJVM.kt */
/* JADX INFO: loaded from: classes5.dex */
public class b {
    public static int a(int i10) {
        if (new n9.i(2, 36).i(i10)) {
            return i10;
        }
        throw new IllegalArgumentException("radix " + i10 + " was not in valid range " + new n9.i(2, 36));
    }

    public static final int b(char c10, int i10) {
        return Character.digit((int) c10, i10);
    }

    public static boolean c(char c10) {
        return Character.isWhitespace(c10) || Character.isSpaceChar(c10);
    }

    @NotNull
    public static String d(char c10, @NotNull Locale locale) {
        kotlin.jvm.internal.t.i(locale, "locale");
        String strValueOf = String.valueOf(c10);
        kotlin.jvm.internal.t.g(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strValueOf.toLowerCase(locale);
        kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    @NotNull
    public static String e(char c10, @NotNull Locale locale) {
        kotlin.jvm.internal.t.i(locale, "locale");
        String strF = f(c10, locale);
        if (strF.length() <= 1) {
            String strValueOf = String.valueOf(c10);
            kotlin.jvm.internal.t.g(strValueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strValueOf.toUpperCase(Locale.ROOT);
            kotlin.jvm.internal.t.h(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            return !kotlin.jvm.internal.t.d(strF, upperCase) ? strF : String.valueOf(Character.toTitleCase(c10));
        }
        if (c10 == 329) {
            return strF;
        }
        char cCharAt = strF.charAt(0);
        kotlin.jvm.internal.t.g(strF, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = strF.substring(1);
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String).substring(startIndex)");
        kotlin.jvm.internal.t.g(strSubstring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strSubstring.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return cCharAt + lowerCase;
    }

    @NotNull
    public static final String f(char c10, @NotNull Locale locale) {
        kotlin.jvm.internal.t.i(locale, "locale");
        String strValueOf = String.valueOf(c10);
        kotlin.jvm.internal.t.g(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = strValueOf.toUpperCase(locale);
        kotlin.jvm.internal.t.h(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }
}
