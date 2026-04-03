package p9;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Char.kt */
/* JADX INFO: loaded from: classes5.dex */
public class c extends b {
    public static final boolean g(char c10, char c11, boolean z10) {
        if (c10 == c11) {
            return true;
        }
        if (!z10) {
            return false;
        }
        char upperCase = Character.toUpperCase(c10);
        char upperCase2 = Character.toUpperCase(c11);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static boolean h(char c10) {
        return new n9.c((char) 55296, (char) 57343).g(c10);
    }

    @NotNull
    public static String i(char c10) {
        return y.a(c10);
    }
}
