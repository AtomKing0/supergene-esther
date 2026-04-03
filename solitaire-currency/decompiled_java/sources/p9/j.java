package p9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.d0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Indent.kt */
/* JADX INFO: loaded from: classes5.dex */
public class j extends i {

    /* JADX INFO: compiled from: Indent.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.l<String, String> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f32974g = new a();

        a() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String invoke(@NotNull String line) {
            kotlin.jvm.internal.t.i(line, "line");
            return line;
        }
    }

    /* JADX INFO: compiled from: Indent.kt */
    static final class b extends kotlin.jvm.internal.v implements h9.l<String, String> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f32975g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(1);
            this.f32975g = str;
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String invoke(@NotNull String line) {
            kotlin.jvm.internal.t.i(line, "line");
            return this.f32975g + line;
        }
    }

    private static final h9.l<String, String> b(String str) {
        return str.length() == 0 ? a.f32974g : new b(str);
    }

    private static final int c(String str) {
        int length = str.length();
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            }
            if (!p9.b.c(str.charAt(i10))) {
                break;
            }
            i10++;
        }
        return i10 == -1 ? str.length() : i10;
    }

    @NotNull
    public static final String d(@NotNull String str, @NotNull String newIndent) {
        String strInvoke;
        kotlin.jvm.internal.t.i(str, "<this>");
        kotlin.jvm.internal.t.i(newIndent, "newIndent");
        List<String> listN0 = r.n0(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listN0) {
            if (!q.z((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.w.v(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(c((String) it.next())));
        }
        Integer num = (Integer) d0.w0(arrayList2);
        int i10 = 0;
        int iIntValue = num != null ? num.intValue() : 0;
        int length = str.length() + (newIndent.length() * listN0.size());
        h9.l<String, String> lVarB = b(newIndent);
        int iM = kotlin.collections.v.m(listN0);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listN0) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.v.u();
            }
            String str2 = (String) obj2;
            if ((i10 == 0 || i10 == iM) && q.z(str2)) {
                str2 = null;
            } else {
                String strD1 = t.d1(str2, iIntValue);
                if (strD1 != null && (strInvoke = lVarB.invoke(strD1)) != null) {
                    str2 = strInvoke;
                }
            }
            if (str2 != null) {
                arrayList3.add(str2);
            }
            i10 = i11;
        }
        String string = ((StringBuilder) d0.p0(arrayList3, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
        kotlin.jvm.internal.t.h(string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }

    @NotNull
    public static final String e(@NotNull String str, @NotNull String newIndent, @NotNull String marginPrefix) {
        int i10;
        String strInvoke;
        kotlin.jvm.internal.t.i(str, "<this>");
        kotlin.jvm.internal.t.i(newIndent, "newIndent");
        kotlin.jvm.internal.t.i(marginPrefix, "marginPrefix");
        if (!(!q.z(marginPrefix))) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
        }
        List<String> listN0 = r.n0(str);
        int length = str.length() + (newIndent.length() * listN0.size());
        h9.l<String, String> lVarB = b(newIndent);
        int iM = kotlin.collections.v.m(listN0);
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        for (Object obj : listN0) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.v.u();
            }
            String str2 = (String) obj;
            String strSubstring = null;
            if ((i11 == 0 || i11 == iM) && q.z(str2)) {
                str2 = null;
            } else {
                int length2 = str2.length();
                int i13 = 0;
                while (true) {
                    if (i13 >= length2) {
                        i10 = -1;
                        break;
                    }
                    if (!p9.b.c(str2.charAt(i13))) {
                        i10 = i13;
                        break;
                    }
                    i13++;
                }
                if (i10 != -1) {
                    int i14 = i10;
                    if (q.J(str2, marginPrefix, i10, false, 4, null)) {
                        int length3 = i14 + marginPrefix.length();
                        kotlin.jvm.internal.t.g(str2, "null cannot be cast to non-null type java.lang.String");
                        strSubstring = str2.substring(length3);
                        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String).substring(startIndex)");
                    }
                }
                if (strSubstring != null && (strInvoke = lVarB.invoke(strSubstring)) != null) {
                    str2 = strInvoke;
                }
            }
            if (str2 != null) {
                arrayList.add(str2);
            }
            i11 = i12;
        }
        String string = ((StringBuilder) d0.p0(arrayList, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
        kotlin.jvm.internal.t.h(string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }

    @NotNull
    public static String f(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<this>");
        return d(str, "");
    }

    @NotNull
    public static final String g(@NotNull String str, @NotNull String marginPrefix) {
        kotlin.jvm.internal.t.i(str, "<this>");
        kotlin.jvm.internal.t.i(marginPrefix, "marginPrefix");
        return e(str, "", marginPrefix);
    }

    public static /* synthetic */ String h(String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str2 = "|";
        }
        return g(str, str2);
    }
}
