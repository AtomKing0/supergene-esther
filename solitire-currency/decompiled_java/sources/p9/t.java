package p9;

import java.util.Collection;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: _Strings.kt */
/* JADX INFO: loaded from: classes5.dex */
public class t extends s {
    @NotNull
    public static String d1(@NotNull String str, int i10) {
        kotlin.jvm.internal.t.i(str, "<this>");
        if (i10 >= 0) {
            String strSubstring = str.substring(n9.o.j(i10, str.length()));
            kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String).substring(startIndex)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    public static char e1(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.t.i(charSequence, "<this>");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(0);
    }

    public static char f1(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.t.i(charSequence, "<this>");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(r.Y(charSequence));
    }

    public static char g1(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.t.i(charSequence, "<this>");
        int length = charSequence.length();
        if (length == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        if (length == 1) {
            return charSequence.charAt(0);
        }
        throw new IllegalArgumentException("Char sequence has more than one element.");
    }

    @NotNull
    public static String h1(@NotNull String str, int i10) {
        kotlin.jvm.internal.t.i(str, "<this>");
        if (i10 >= 0) {
            String strSubstring = str.substring(0, n9.o.j(i10, str.length()));
            kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    @NotNull
    public static <C extends Collection<? super Character>> C i1(@NotNull CharSequence charSequence, @NotNull C destination) {
        kotlin.jvm.internal.t.i(charSequence, "<this>");
        kotlin.jvm.internal.t.i(destination, "destination");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            destination.add(Character.valueOf(charSequence.charAt(i10)));
        }
        return destination;
    }
}
