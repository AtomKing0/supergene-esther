package g8;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Text.kt */
/* JADX INFO: loaded from: classes.dex */
public final class y {
    @NotNull
    public static final h a(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<this>");
        return new h(str);
    }

    private static final char b(char c10) {
        if ('A' <= c10 && c10 < '[') {
            return (char) (c10 + ' ');
        }
        return c10 >= 0 && c10 < 128 ? c10 : Character.toLowerCase(c10);
    }

    @NotNull
    public static final String c(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<this>");
        int length = str.length();
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            }
            char cCharAt = str.charAt(i10);
            if (b(cCharAt) != cCharAt) {
                break;
            }
            i10++;
        }
        if (i10 == -1) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        sb.append((CharSequence) str, 0, i10);
        int iY = p9.r.Y(str);
        if (i10 <= iY) {
            while (true) {
                sb.append(b(str.charAt(i10)));
                if (i10 == iY) {
                    break;
                }
                i10++;
            }
        }
        String string = sb.toString();
        kotlin.jvm.internal.t.h(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }
}
