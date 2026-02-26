package p9;

import java.util.Locale;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: _OneToManyTitlecaseMappings.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class y {
    @NotNull
    public static final String a(char c10) {
        String strValueOf = String.valueOf(c10);
        kotlin.jvm.internal.t.g(strValueOf, "null cannot be cast to non-null type java.lang.String");
        Locale locale = Locale.ROOT;
        String upperCase = strValueOf.toUpperCase(locale);
        kotlin.jvm.internal.t.h(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (upperCase.length() <= 1) {
            return String.valueOf(Character.toTitleCase(c10));
        }
        if (c10 == 329) {
            return upperCase;
        }
        char cCharAt = upperCase.charAt(0);
        kotlin.jvm.internal.t.g(upperCase, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = upperCase.substring(1);
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String).substring(startIndex)");
        kotlin.jvm.internal.t.g(strSubstring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strSubstring.toLowerCase(locale);
        kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return cCharAt + lowerCase;
    }
}
