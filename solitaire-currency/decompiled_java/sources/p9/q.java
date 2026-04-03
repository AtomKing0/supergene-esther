package p9;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.collections.l0;
import kotlin.jvm.internal.s0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: StringsJVM.kt */
/* JADX INFO: loaded from: classes5.dex */
public class q extends p {
    public static boolean A(@NotNull String str, int i10, @NotNull String other, int i11, int i12, boolean z10) {
        kotlin.jvm.internal.t.i(str, "<this>");
        kotlin.jvm.internal.t.i(other, "other");
        return !z10 ? str.regionMatches(i10, other, i11, i12) : str.regionMatches(z10, i10, other, i11, i12);
    }

    public static /* synthetic */ boolean B(String str, int i10, String str2, int i11, int i12, boolean z10, int i13, Object obj) {
        if ((i13 & 16) != 0) {
            z10 = false;
        }
        return A(str, i10, str2, i11, i12, z10);
    }

    @NotNull
    public static String C(@NotNull CharSequence charSequence, int i10) {
        kotlin.jvm.internal.t.i(charSequence, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i10 + '.').toString());
        }
        if (i10 == 0) {
            return "";
        }
        if (i10 == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char cCharAt = charSequence.charAt(0);
            char[] cArr = new char[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                cArr[i11] = cCharAt;
            }
            return new String(cArr);
        }
        StringBuilder sb = new StringBuilder(charSequence.length() * i10);
        l0 l0VarG = new n9.i(1, i10).iterator();
        while (l0VarG.hasNext()) {
            l0VarG.nextInt();
            sb.append(charSequence);
        }
        String string = sb.toString();
        kotlin.jvm.internal.t.h(string, "{\n                    va…tring()\n                }");
        return string;
    }

    @NotNull
    public static final String D(@NotNull String str, char c10, char c11, boolean z10) {
        kotlin.jvm.internal.t.i(str, "<this>");
        if (!z10) {
            String strReplace = str.replace(c10, c11);
            kotlin.jvm.internal.t.h(strReplace, "this as java.lang.String…replace(oldChar, newChar)");
            return strReplace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (c.g(cCharAt, c10, z10)) {
                cCharAt = c11;
            }
            sb.append(cCharAt);
        }
        String string = sb.toString();
        kotlin.jvm.internal.t.h(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    @NotNull
    public static String E(@NotNull String str, @NotNull String oldValue, @NotNull String newValue, boolean z10) {
        kotlin.jvm.internal.t.i(str, "<this>");
        kotlin.jvm.internal.t.i(oldValue, "oldValue");
        kotlin.jvm.internal.t.i(newValue, "newValue");
        int i10 = 0;
        int iA0 = r.a0(str, oldValue, 0, z10);
        if (iA0 < 0) {
            return str;
        }
        int length = oldValue.length();
        int iE = n9.o.e(length, 1);
        int length2 = (str.length() - length) + newValue.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i10, iA0);
            sb.append(newValue);
            i10 = iA0 + length;
            if (iA0 >= str.length()) {
                break;
            }
            iA0 = r.a0(str, oldValue, iA0 + iE, z10);
        } while (iA0 > 0);
        sb.append((CharSequence) str, i10, str.length());
        String string = sb.toString();
        kotlin.jvm.internal.t.h(string, "stringBuilder.append(this, i, length).toString()");
        return string;
    }

    public static /* synthetic */ String F(String str, char c10, char c11, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return D(str, c10, c11, z10);
    }

    public static /* synthetic */ String G(String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return E(str, str2, str3, z10);
    }

    public static boolean H(@NotNull String str, @NotNull String prefix, int i10, boolean z10) {
        kotlin.jvm.internal.t.i(str, "<this>");
        kotlin.jvm.internal.t.i(prefix, "prefix");
        return !z10 ? str.startsWith(prefix, i10) : A(str, i10, prefix, 0, prefix.length(), z10);
    }

    public static boolean I(@NotNull String str, @NotNull String prefix, boolean z10) {
        kotlin.jvm.internal.t.i(str, "<this>");
        kotlin.jvm.internal.t.i(prefix, "prefix");
        return !z10 ? str.startsWith(prefix) : A(str, 0, prefix, 0, prefix.length(), z10);
    }

    public static /* synthetic */ boolean J(String str, String str2, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return H(str, str2, i10, z10);
    }

    public static /* synthetic */ boolean K(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return I(str, str2, z10);
    }

    @NotNull
    public static String p(@NotNull char[] cArr) {
        kotlin.jvm.internal.t.i(cArr, "<this>");
        return new String(cArr);
    }

    @NotNull
    public static String q(@NotNull char[] cArr, int i10, int i11) {
        kotlin.jvm.internal.t.i(cArr, "<this>");
        kotlin.collections.c.Companion.a(i10, i11, cArr.length);
        return new String(cArr, i10, i11 - i10);
    }

    public static final boolean r(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        return (!(charSequence instanceof String) || charSequence2 == null) ? r.R(charSequence, charSequence2) : ((String) charSequence).contentEquals(charSequence2);
    }

    public static boolean s(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, boolean z10) {
        return z10 ? r.Q(charSequence, charSequence2) : r(charSequence, charSequence2);
    }

    @NotNull
    public static String t(@NotNull byte[] bArr) {
        kotlin.jvm.internal.t.i(bArr, "<this>");
        return new String(bArr, d.f32952b);
    }

    @NotNull
    public static byte[] u(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<this>");
        byte[] bytes = str.getBytes(d.f32952b);
        kotlin.jvm.internal.t.h(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static boolean v(@NotNull String str, @NotNull String suffix, boolean z10) {
        kotlin.jvm.internal.t.i(str, "<this>");
        kotlin.jvm.internal.t.i(suffix, "suffix");
        return !z10 ? str.endsWith(suffix) : A(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    public static /* synthetic */ boolean w(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return v(str, str2, z10);
    }

    public static boolean x(@Nullable String str, @Nullable String str2, boolean z10) {
        return str == null ? str2 == null : !z10 ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    @NotNull
    public static Comparator<String> y(@NotNull s0 s0Var) {
        kotlin.jvm.internal.t.i(s0Var, "<this>");
        Comparator<String> CASE_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
        kotlin.jvm.internal.t.h(CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
        return CASE_INSENSITIVE_ORDER;
    }

    public static boolean z(@NotNull CharSequence charSequence) {
        boolean z10;
        kotlin.jvm.internal.t.i(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return true;
        }
        Iterable iterableX = r.X(charSequence);
        if ((iterableX instanceof Collection) && ((Collection) iterableX).isEmpty()) {
            z10 = true;
        } else {
            Iterator it = iterableX.iterator();
            while (it.hasNext()) {
                if (!b.c(charSequence.charAt(((l0) it).nextInt()))) {
                    z10 = false;
                    break;
                }
            }
            z10 = true;
        }
        return z10;
    }
}
