package p9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.d0;
import kotlin.collections.l0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes5.dex */
public class r extends q {

    /* JADX INFO: compiled from: Strings.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.p<CharSequence, Integer, v8.s<? extends Integer, ? extends Integer>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ char[] f32976g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f32977h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(char[] cArr, boolean z10) {
            super(2);
            this.f32976g = cArr;
            this.f32977h = z10;
        }

        @Nullable
        public final v8.s<Integer, Integer> a(@NotNull CharSequence $receiver, int i10) {
            kotlin.jvm.internal.t.i($receiver, "$this$$receiver");
            int iF0 = r.f0($receiver, this.f32976g, i10, this.f32977h);
            if (iF0 < 0) {
                return null;
            }
            return v8.y.a(Integer.valueOf(iF0), 1);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ v8.s<? extends Integer, ? extends Integer> mo4invoke(CharSequence charSequence, Integer num) {
            return a(charSequence, num.intValue());
        }
    }

    /* JADX INFO: compiled from: Strings.kt */
    static final class b extends kotlin.jvm.internal.v implements h9.p<CharSequence, Integer, v8.s<? extends Integer, ? extends Integer>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ List<String> f32978g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f32979h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(List<String> list, boolean z10) {
            super(2);
            this.f32978g = list;
            this.f32979h = z10;
        }

        @Nullable
        public final v8.s<Integer, Integer> a(@NotNull CharSequence $receiver, int i10) {
            kotlin.jvm.internal.t.i($receiver, "$this$$receiver");
            v8.s sVarW = r.W($receiver, this.f32978g, i10, this.f32979h, false);
            if (sVarW != null) {
                return v8.y.a(sVarW.c(), Integer.valueOf(((String) sVarW.d()).length()));
            }
            return null;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ v8.s<? extends Integer, ? extends Integer> mo4invoke(CharSequence charSequence, Integer num) {
            return a(charSequence, num.intValue());
        }
    }

    /* JADX INFO: compiled from: Strings.kt */
    static final class c extends kotlin.jvm.internal.v implements h9.l<n9.i, String> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ CharSequence f32980g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(CharSequence charSequence) {
            super(1);
            this.f32980g = charSequence;
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(@NotNull n9.i it) {
            kotlin.jvm.internal.t.i(it, "it");
            return r.J0(this.f32980g, it);
        }
    }

    private static final List<String> A0(CharSequence charSequence, String str, boolean z10, int i10) {
        x0(i10);
        int length = 0;
        int iA0 = a0(charSequence, str, 0, z10);
        if (iA0 == -1 || i10 == 1) {
            return kotlin.collections.u.e(charSequence.toString());
        }
        boolean z11 = i10 > 0;
        ArrayList arrayList = new ArrayList(z11 ? n9.o.j(i10, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iA0).toString());
            length = str.length() + iA0;
            if (z11 && arrayList.size() == i10 - 1) {
                break;
            }
            iA0 = a0(charSequence, str, length, z10);
        } while (iA0 != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List B0(CharSequence charSequence, char[] cArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return y0(charSequence, cArr, z10, i10);
    }

    public static /* synthetic */ List C0(CharSequence charSequence, String[] strArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return z0(charSequence, strArr, z10, i10);
    }

    @NotNull
    public static final o9.g<String> D0(@NotNull CharSequence charSequence, @NotNull String[] delimiters, boolean z10, int i10) {
        kotlin.jvm.internal.t.i(charSequence, "<this>");
        kotlin.jvm.internal.t.i(delimiters, "delimiters");
        return o9.o.s(t0(charSequence, delimiters, 0, z10, i10, 2, null), new c(charSequence));
    }

    public static /* synthetic */ o9.g E0(CharSequence charSequence, String[] strArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return D0(charSequence, strArr, z10, i10);
    }

    public static final boolean F0(@NotNull CharSequence charSequence, char c10, boolean z10) {
        kotlin.jvm.internal.t.i(charSequence, "<this>");
        return charSequence.length() > 0 && p9.c.g(charSequence.charAt(0), c10, z10);
    }

    public static final boolean G0(@NotNull CharSequence charSequence, @NotNull CharSequence prefix, boolean z10) {
        kotlin.jvm.internal.t.i(charSequence, "<this>");
        kotlin.jvm.internal.t.i(prefix, "prefix");
        return (!z10 && (charSequence instanceof String) && (prefix instanceof String)) ? q.K((String) charSequence, (String) prefix, false, 2, null) : u0(charSequence, 0, prefix, 0, prefix.length(), z10);
    }

    public static /* synthetic */ boolean H0(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return F0(charSequence, c10, z10);
    }

    public static /* synthetic */ boolean I0(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return G0(charSequence, charSequence2, z10);
    }

    @NotNull
    public static final String J0(@NotNull CharSequence charSequence, @NotNull n9.i range) {
        kotlin.jvm.internal.t.i(charSequence, "<this>");
        kotlin.jvm.internal.t.i(range, "range");
        return charSequence.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1).toString();
    }

    @NotNull
    public static final String K0(@NotNull String str, char c10, @NotNull String missingDelimiterValue) {
        kotlin.jvm.internal.t.i(str, "<this>");
        kotlin.jvm.internal.t.i(missingDelimiterValue, "missingDelimiterValue");
        int iD0 = d0(str, c10, 0, false, 6, null);
        if (iD0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iD0 + 1, str.length());
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @NotNull
    public static final String L0(@NotNull String str, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        kotlin.jvm.internal.t.i(str, "<this>");
        kotlin.jvm.internal.t.i(delimiter, "delimiter");
        kotlin.jvm.internal.t.i(missingDelimiterValue, "missingDelimiterValue");
        int iE0 = e0(str, delimiter, 0, false, 6, null);
        if (iE0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iE0 + delimiter.length(), str.length());
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final boolean M(@NotNull CharSequence charSequence, char c10, boolean z10) {
        kotlin.jvm.internal.t.i(charSequence, "<this>");
        return d0(charSequence, c10, 0, z10, 2, null) >= 0;
    }

    public static /* synthetic */ String M0(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return K0(str, c10, str2);
    }

    public static boolean N(@NotNull CharSequence charSequence, @NotNull CharSequence other, boolean z10) {
        kotlin.jvm.internal.t.i(charSequence, "<this>");
        kotlin.jvm.internal.t.i(other, "other");
        if (other instanceof String) {
            if (e0(charSequence, (String) other, 0, z10, 2, null) >= 0) {
                return true;
            }
        } else if (c0(charSequence, other, 0, charSequence.length(), z10, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ String N0(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return L0(str, str2, str3);
    }

    public static /* synthetic */ boolean O(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return M(charSequence, c10, z10);
    }

    @NotNull
    public static String O0(@NotNull String str, char c10, @NotNull String missingDelimiterValue) {
        kotlin.jvm.internal.t.i(str, "<this>");
        kotlin.jvm.internal.t.i(missingDelimiterValue, "missingDelimiterValue");
        int iJ0 = j0(str, c10, 0, false, 6, null);
        if (iJ0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iJ0 + 1, str.length());
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ boolean P(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return N(charSequence, charSequence2, z10);
    }

    @NotNull
    public static final String P0(@NotNull String str, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        kotlin.jvm.internal.t.i(str, "<this>");
        kotlin.jvm.internal.t.i(delimiter, "delimiter");
        kotlin.jvm.internal.t.i(missingDelimiterValue, "missingDelimiterValue");
        int iK0 = k0(str, delimiter, 0, false, 6, null);
        if (iK0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iK0 + delimiter.length(), str.length());
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final boolean Q(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return q.x((String) charSequence, (String) charSequence2, true);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!p9.c.g(charSequence.charAt(i10), charSequence2.charAt(i10), true)) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ String Q0(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return O0(str, c10, str2);
    }

    public static final boolean R(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return kotlin.jvm.internal.t.d(charSequence, charSequence2);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (charSequence.charAt(i10) != charSequence2.charAt(i10)) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ String R0(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return P0(str, str2, str3);
    }

    public static final boolean S(@NotNull CharSequence charSequence, char c10, boolean z10) {
        kotlin.jvm.internal.t.i(charSequence, "<this>");
        return charSequence.length() > 0 && p9.c.g(charSequence.charAt(Y(charSequence)), c10, z10);
    }

    @NotNull
    public static final String S0(@NotNull String str, char c10, @NotNull String missingDelimiterValue) {
        kotlin.jvm.internal.t.i(str, "<this>");
        kotlin.jvm.internal.t.i(missingDelimiterValue, "missingDelimiterValue");
        int iD0 = d0(str, c10, 0, false, 6, null);
        if (iD0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iD0);
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final boolean T(@NotNull CharSequence charSequence, @NotNull CharSequence suffix, boolean z10) {
        kotlin.jvm.internal.t.i(charSequence, "<this>");
        kotlin.jvm.internal.t.i(suffix, "suffix");
        return (!z10 && (charSequence instanceof String) && (suffix instanceof String)) ? q.w((String) charSequence, (String) suffix, false, 2, null) : u0(charSequence, charSequence.length() - suffix.length(), suffix, 0, suffix.length(), z10);
    }

    @NotNull
    public static final String T0(@NotNull String str, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        kotlin.jvm.internal.t.i(str, "<this>");
        kotlin.jvm.internal.t.i(delimiter, "delimiter");
        kotlin.jvm.internal.t.i(missingDelimiterValue, "missingDelimiterValue");
        int iE0 = e0(str, delimiter, 0, false, 6, null);
        if (iE0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iE0);
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ boolean U(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return S(charSequence, c10, z10);
    }

    public static /* synthetic */ String U0(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return S0(str, c10, str2);
    }

    public static /* synthetic */ boolean V(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return T(charSequence, charSequence2, z10);
    }

    public static /* synthetic */ String V0(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return T0(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v8.s<Integer, String> W(CharSequence charSequence, Collection<String> collection, int i10, boolean z10, boolean z11) {
        Object next;
        Object next2;
        if (!z10 && collection.size() == 1) {
            String str = (String) d0.D0(collection);
            int iE0 = !z11 ? e0(charSequence, str, i10, false, 4, null) : k0(charSequence, str, i10, false, 4, null);
            if (iE0 < 0) {
                return null;
            }
            return v8.y.a(Integer.valueOf(iE0), str);
        }
        n9.g iVar = !z11 ? new n9.i(n9.o.e(i10, 0), charSequence.length()) : n9.o.r(n9.o.j(i10, Y(charSequence)), 0);
        if (charSequence instanceof String) {
            int iB = iVar.b();
            int iE = iVar.e();
            int iF = iVar.f();
            if ((iF > 0 && iB <= iE) || (iF < 0 && iE <= iB)) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        String str2 = (String) next2;
                        if (q.A(str2, 0, (String) charSequence, iB, str2.length(), z10)) {
                            break;
                        }
                    }
                    String str3 = (String) next2;
                    if (str3 == null) {
                        if (iB == iE) {
                            break;
                        }
                        iB += iF;
                    } else {
                        return v8.y.a(Integer.valueOf(iB), str3);
                    }
                }
            }
        } else {
            int iB2 = iVar.b();
            int iE2 = iVar.e();
            int iF2 = iVar.f();
            if ((iF2 > 0 && iB2 <= iE2) || (iF2 < 0 && iE2 <= iB2)) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                        String str4 = (String) next;
                        if (u0(str4, 0, charSequence, iB2, str4.length(), z10)) {
                            break;
                        }
                    }
                    String str5 = (String) next;
                    if (str5 == null) {
                        if (iB2 == iE2) {
                            break;
                        }
                        iB2 += iF2;
                    } else {
                        return v8.y.a(Integer.valueOf(iB2), str5);
                    }
                }
            }
        }
        return null;
    }

    @NotNull
    public static final String W0(@NotNull String str, char c10, @NotNull String missingDelimiterValue) {
        kotlin.jvm.internal.t.i(str, "<this>");
        kotlin.jvm.internal.t.i(missingDelimiterValue, "missingDelimiterValue");
        int iJ0 = j0(str, c10, 0, false, 6, null);
        if (iJ0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iJ0);
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @NotNull
    public static n9.i X(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.t.i(charSequence, "<this>");
        return new n9.i(0, charSequence.length() - 1);
    }

    @NotNull
    public static final String X0(@NotNull String str, @NotNull String delimiter, @NotNull String missingDelimiterValue) {
        kotlin.jvm.internal.t.i(str, "<this>");
        kotlin.jvm.internal.t.i(delimiter, "delimiter");
        kotlin.jvm.internal.t.i(missingDelimiterValue, "missingDelimiterValue");
        int iK0 = k0(str, delimiter, 0, false, 6, null);
        if (iK0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iK0);
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static int Y(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.t.i(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static /* synthetic */ String Y0(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return W0(str, c10, str2);
    }

    public static final int Z(@NotNull CharSequence charSequence, char c10, int i10, boolean z10) {
        kotlin.jvm.internal.t.i(charSequence, "<this>");
        return (z10 || !(charSequence instanceof String)) ? f0(charSequence, new char[]{c10}, i10, z10) : ((String) charSequence).indexOf(c10, i10);
    }

    public static /* synthetic */ String Z0(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return X0(str, str2, str3);
    }

    public static final int a0(@NotNull CharSequence charSequence, @NotNull String string, int i10, boolean z10) {
        kotlin.jvm.internal.t.i(charSequence, "<this>");
        kotlin.jvm.internal.t.i(string, "string");
        return (z10 || !(charSequence instanceof String)) ? c0(charSequence, string, i10, charSequence.length(), z10, false, 16, null) : ((String) charSequence).indexOf(string, i10);
    }

    @Nullable
    public static Boolean a1(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<this>");
        if (kotlin.jvm.internal.t.d(str, com.ironsource.mediationsdk.metadata.a.f13688g)) {
            return Boolean.TRUE;
        }
        if (kotlin.jvm.internal.t.d(str, "false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    private static final int b0(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11) {
        n9.g iVar = !z11 ? new n9.i(n9.o.e(i10, 0), n9.o.j(i11, charSequence.length())) : n9.o.r(n9.o.j(i10, Y(charSequence)), n9.o.e(i11, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int iB = iVar.b();
            int iE = iVar.e();
            int iF = iVar.f();
            if ((iF <= 0 || iB > iE) && (iF >= 0 || iE > iB)) {
                return -1;
            }
            while (!q.A((String) charSequence2, 0, (String) charSequence, iB, charSequence2.length(), z10)) {
                if (iB == iE) {
                    return -1;
                }
                iB += iF;
            }
            return iB;
        }
        int iB2 = iVar.b();
        int iE2 = iVar.e();
        int iF2 = iVar.f();
        if ((iF2 <= 0 || iB2 > iE2) && (iF2 >= 0 || iE2 > iB2)) {
            return -1;
        }
        while (!u0(charSequence2, 0, charSequence, iB2, charSequence2.length(), z10)) {
            if (iB2 == iE2) {
                return -1;
            }
            iB2 += iF2;
        }
        return iB2;
    }

    @NotNull
    public static CharSequence b1(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.t.i(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean zC = p9.b.c(charSequence.charAt(!z10 ? i10 : length));
            if (z10) {
                if (!zC) {
                    break;
                }
                length--;
            } else if (zC) {
                i10++;
            } else {
                z10 = true;
            }
        }
        return charSequence.subSequence(i10, length + 1);
    }

    static /* synthetic */ int c0(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            z11 = false;
        }
        return b0(charSequence, charSequence2, i10, i11, z10, z11);
    }

    @NotNull
    public static String c1(@NotNull String str, @NotNull char... chars) {
        kotlin.jvm.internal.t.i(str, "<this>");
        kotlin.jvm.internal.t.i(chars, "chars");
        int length = str.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean zE = kotlin.collections.p.E(chars, str.charAt(!z10 ? i10 : length));
            if (z10) {
                if (!zE) {
                    break;
                }
                length--;
            } else if (zE) {
                i10++;
            } else {
                z10 = true;
            }
        }
        return str.subSequence(i10, length + 1).toString();
    }

    public static /* synthetic */ int d0(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return Z(charSequence, c10, i10, z10);
    }

    public static /* synthetic */ int e0(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return a0(charSequence, str, i10, z10);
    }

    public static final int f0(@NotNull CharSequence charSequence, @NotNull char[] chars, int i10, boolean z10) {
        boolean z11;
        kotlin.jvm.internal.t.i(charSequence, "<this>");
        kotlin.jvm.internal.t.i(chars, "chars");
        if (!z10 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(kotlin.collections.p.h0(chars), i10);
        }
        l0 l0VarG = new n9.i(n9.o.e(i10, 0), Y(charSequence)).iterator();
        while (l0VarG.hasNext()) {
            int iNextInt = l0VarG.nextInt();
            char cCharAt = charSequence.charAt(iNextInt);
            int length = chars.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    z11 = false;
                    break;
                }
                if (p9.c.g(chars[i11], cCharAt, z10)) {
                    z11 = true;
                    break;
                }
                i11++;
            }
            if (z11) {
                return iNextInt;
            }
        }
        return -1;
    }

    public static /* synthetic */ int g0(CharSequence charSequence, char[] cArr, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return f0(charSequence, cArr, i10, z10);
    }

    public static final int h0(@NotNull CharSequence charSequence, char c10, int i10, boolean z10) {
        kotlin.jvm.internal.t.i(charSequence, "<this>");
        return (z10 || !(charSequence instanceof String)) ? l0(charSequence, new char[]{c10}, i10, z10) : ((String) charSequence).lastIndexOf(c10, i10);
    }

    public static final int i0(@NotNull CharSequence charSequence, @NotNull String string, int i10, boolean z10) {
        kotlin.jvm.internal.t.i(charSequence, "<this>");
        kotlin.jvm.internal.t.i(string, "string");
        return (z10 || !(charSequence instanceof String)) ? b0(charSequence, string, i10, 0, z10, true) : ((String) charSequence).lastIndexOf(string, i10);
    }

    public static /* synthetic */ int j0(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = Y(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return h0(charSequence, c10, i10, z10);
    }

    public static /* synthetic */ int k0(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = Y(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return i0(charSequence, str, i10, z10);
    }

    public static final int l0(@NotNull CharSequence charSequence, @NotNull char[] chars, int i10, boolean z10) {
        kotlin.jvm.internal.t.i(charSequence, "<this>");
        kotlin.jvm.internal.t.i(chars, "chars");
        if (!z10 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(kotlin.collections.p.h0(chars), i10);
        }
        for (int iJ = n9.o.j(i10, Y(charSequence)); -1 < iJ; iJ--) {
            char cCharAt = charSequence.charAt(iJ);
            int length = chars.length;
            boolean z11 = false;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (p9.c.g(chars[i11], cCharAt, z10)) {
                    z11 = true;
                    break;
                }
                i11++;
            }
            if (z11) {
                return iJ;
            }
        }
        return -1;
    }

    @NotNull
    public static o9.g<String> m0(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.t.i(charSequence, "<this>");
        return E0(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    @NotNull
    public static final List<String> n0(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.t.i(charSequence, "<this>");
        return o9.o.w(m0(charSequence));
    }

    @NotNull
    public static final CharSequence o0(@NotNull CharSequence charSequence, int i10, char c10) {
        kotlin.jvm.internal.t.i(charSequence, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException("Desired length " + i10 + " is less than zero.");
        }
        if (i10 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i10);
        l0 l0VarG = new n9.i(1, i10 - charSequence.length()).iterator();
        while (l0VarG.hasNext()) {
            l0VarG.nextInt();
            sb.append(c10);
        }
        sb.append(charSequence);
        return sb;
    }

    @NotNull
    public static String p0(@NotNull String str, int i10, char c10) {
        kotlin.jvm.internal.t.i(str, "<this>");
        return o0(str, i10, c10).toString();
    }

    private static final o9.g<n9.i> q0(CharSequence charSequence, char[] cArr, int i10, boolean z10, int i11) {
        x0(i11);
        return new e(charSequence, i10, i11, new a(cArr, z10));
    }

    private static final o9.g<n9.i> r0(CharSequence charSequence, String[] strArr, int i10, boolean z10, int i11) {
        x0(i11);
        return new e(charSequence, i10, i11, new b(kotlin.collections.o.c(strArr), z10));
    }

    static /* synthetic */ o9.g s0(CharSequence charSequence, char[] cArr, int i10, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        return q0(charSequence, cArr, i10, z10, i11);
    }

    static /* synthetic */ o9.g t0(CharSequence charSequence, String[] strArr, int i10, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        return r0(charSequence, strArr, i10, z10, i11);
    }

    public static final boolean u0(@NotNull CharSequence charSequence, int i10, @NotNull CharSequence other, int i11, int i12, boolean z10) {
        kotlin.jvm.internal.t.i(charSequence, "<this>");
        kotlin.jvm.internal.t.i(other, "other");
        if (i11 < 0 || i10 < 0 || i10 > charSequence.length() - i12 || i11 > other.length() - i12) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (!p9.c.g(charSequence.charAt(i10 + i13), other.charAt(i11 + i13), z10)) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static String v0(@NotNull String str, @NotNull CharSequence prefix) {
        kotlin.jvm.internal.t.i(str, "<this>");
        kotlin.jvm.internal.t.i(prefix, "prefix");
        if (!I0(str, prefix, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(prefix.length());
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    @NotNull
    public static String w0(@NotNull String str, @NotNull CharSequence suffix) {
        kotlin.jvm.internal.t.i(str, "<this>");
        kotlin.jvm.internal.t.i(suffix, "suffix");
        if (!V(str, suffix, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - suffix.length());
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final void x0(int i10) {
        if (i10 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i10).toString());
    }

    @NotNull
    public static final List<String> y0(@NotNull CharSequence charSequence, @NotNull char[] delimiters, boolean z10, int i10) {
        kotlin.jvm.internal.t.i(charSequence, "<this>");
        kotlin.jvm.internal.t.i(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return A0(charSequence, String.valueOf(delimiters[0]), z10, i10);
        }
        Iterable iterableH = o9.o.h(s0(charSequence, delimiters, 0, z10, i10, 2, null));
        ArrayList arrayList = new ArrayList(kotlin.collections.w.v(iterableH, 10));
        Iterator it = iterableH.iterator();
        while (it.hasNext()) {
            arrayList.add(J0(charSequence, (n9.i) it.next()));
        }
        return arrayList;
    }

    @NotNull
    public static final List<String> z0(@NotNull CharSequence charSequence, @NotNull String[] delimiters, boolean z10, int i10) {
        kotlin.jvm.internal.t.i(charSequence, "<this>");
        kotlin.jvm.internal.t.i(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (!(str.length() == 0)) {
                return A0(charSequence, str, z10, i10);
            }
        }
        Iterable iterableH = o9.o.h(t0(charSequence, delimiters, 0, z10, i10, 2, null));
        ArrayList arrayList = new ArrayList(kotlin.collections.w.v(iterableH, 10));
        Iterator it = iterableH.iterator();
        while (it.hasNext()) {
            arrayList.add(J0(charSequence, (n9.i) it.next()));
        }
        return arrayList;
    }
}
