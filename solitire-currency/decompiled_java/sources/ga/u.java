package ga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import kotlin.jvm.internal.s0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Headers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class u implements Iterable<v8.s<? extends String, ? extends String>>, i9.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final b f26213b = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String[] f26214a;

    /* JADX INFO: compiled from: Headers.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final List<String> f26215a = new ArrayList(20);

        @NotNull
        public final a a(@NotNull String name, @NotNull String value) {
            kotlin.jvm.internal.t.i(name, "name");
            kotlin.jvm.internal.t.i(value, "value");
            b bVar = u.f26213b;
            bVar.d(name);
            bVar.e(value, name);
            d(name, value);
            return this;
        }

        @NotNull
        public final a b(@NotNull u headers) {
            kotlin.jvm.internal.t.i(headers, "headers");
            int size = headers.size();
            for (int i10 = 0; i10 < size; i10++) {
                d(headers.e(i10), headers.i(i10));
            }
            return this;
        }

        @NotNull
        public final a c(@NotNull String line) {
            kotlin.jvm.internal.t.i(line, "line");
            int iD0 = p9.r.d0(line, ':', 1, false, 4, null);
            if (iD0 != -1) {
                String strSubstring = line.substring(0, iD0);
                kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                String strSubstring2 = line.substring(iD0 + 1);
                kotlin.jvm.internal.t.h(strSubstring2, "this as java.lang.String).substring(startIndex)");
                d(strSubstring, strSubstring2);
            } else if (line.charAt(0) == ':') {
                String strSubstring3 = line.substring(1);
                kotlin.jvm.internal.t.h(strSubstring3, "this as java.lang.String).substring(startIndex)");
                d("", strSubstring3);
            } else {
                d("", line);
            }
            return this;
        }

        @NotNull
        public final a d(@NotNull String name, @NotNull String value) {
            kotlin.jvm.internal.t.i(name, "name");
            kotlin.jvm.internal.t.i(value, "value");
            h().add(name);
            h().add(p9.r.b1(value).toString());
            return this;
        }

        @NotNull
        public final a e(@NotNull String name, @NotNull String value) {
            kotlin.jvm.internal.t.i(name, "name");
            kotlin.jvm.internal.t.i(value, "value");
            u.f26213b.d(name);
            d(name, value);
            return this;
        }

        @NotNull
        public final u f() {
            Object[] array = this.f26215a.toArray(new String[0]);
            if (array != null) {
                return new u((String[]) array, null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }

        @Nullable
        public final String g(@NotNull String name) {
            kotlin.jvm.internal.t.i(name, "name");
            int size = this.f26215a.size() - 2;
            int iC = c9.c.c(size, 0, -2);
            if (iC > size) {
                return null;
            }
            while (true) {
                int i10 = size - 2;
                if (p9.q.x(name, this.f26215a.get(size), true)) {
                    return this.f26215a.get(size + 1);
                }
                if (size == iC) {
                    return null;
                }
                size = i10;
            }
        }

        @NotNull
        public final List<String> h() {
            return this.f26215a;
        }

        @NotNull
        public final a i(@NotNull String name) {
            kotlin.jvm.internal.t.i(name, "name");
            int i10 = 0;
            while (i10 < h().size()) {
                if (p9.q.x(name, h().get(i10), true)) {
                    h().remove(i10);
                    h().remove(i10);
                    i10 -= 2;
                }
                i10 += 2;
            }
            return this;
        }

        @NotNull
        public final a j(@NotNull String name, @NotNull String value) {
            kotlin.jvm.internal.t.i(name, "name");
            kotlin.jvm.internal.t.i(value, "value");
            b bVar = u.f26213b;
            bVar.d(name);
            bVar.e(value, name);
            i(name);
            d(name, value);
            return this;
        }
    }

    /* JADX INFO: compiled from: Headers.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(String str) {
            if (!(str.length() > 0)) {
                throw new IllegalArgumentException("name is empty".toString());
            }
            int length = str.length();
            int i10 = 0;
            while (i10 < length) {
                int i11 = i10 + 1;
                char cCharAt = str.charAt(i10);
                if (!('!' <= cCharAt && cCharAt < 127)) {
                    throw new IllegalArgumentException(ha.d.t("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i10), str).toString());
                }
                i10 = i11;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void e(java.lang.String r8, java.lang.String r9) {
            /*
                r7 = this;
                int r0 = r8.length()
                r1 = 0
                r2 = r1
            L6:
                if (r2 >= r0) goto L5d
                int r3 = r2 + 1
                char r4 = r8.charAt(r2)
                r5 = 9
                r6 = 1
                if (r4 == r5) goto L23
                r5 = 32
                if (r5 > r4) goto L1d
                r5 = 127(0x7f, float:1.78E-43)
                if (r4 >= r5) goto L1d
                r5 = r6
                goto L1e
            L1d:
                r5 = r1
            L1e:
                if (r5 == 0) goto L21
                goto L23
            L21:
                r5 = r1
                goto L24
            L23:
                r5 = r6
            L24:
                if (r5 != 0) goto L5b
                r0 = 3
                java.lang.Object[] r0 = new java.lang.Object[r0]
                java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
                r0[r1] = r3
                java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
                r0[r6] = r1
                r1 = 2
                r0[r1] = r9
                java.lang.String r1 = "Unexpected char %#04x at %d in %s value"
                java.lang.String r0 = ha.d.t(r1, r0)
                boolean r9 = ha.d.H(r9)
                if (r9 == 0) goto L47
                java.lang.String r8 = ""
                goto L4d
            L47:
                java.lang.String r9 = ": "
                java.lang.String r8 = kotlin.jvm.internal.t.r(r9, r8)
            L4d:
                java.lang.String r8 = kotlin.jvm.internal.t.r(r0, r8)
                java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
                java.lang.String r8 = r8.toString()
                r9.<init>(r8)
                throw r9
            L5b:
                r2 = r3
                goto L6
            L5d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ga.u.b.e(java.lang.String, java.lang.String):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String f(String[] strArr, String str) {
            int length = strArr.length - 2;
            int iC = c9.c.c(length, 0, -2);
            if (iC > length) {
                return null;
            }
            while (true) {
                int i10 = length - 2;
                if (p9.q.x(str, strArr[length], true)) {
                    return strArr[length + 1];
                }
                if (length == iC) {
                    return null;
                }
                length = i10;
            }
        }

        @NotNull
        public final u g(@NotNull String... namesAndValues) {
            kotlin.jvm.internal.t.i(namesAndValues, "namesAndValues");
            int i10 = 0;
            if (!(namesAndValues.length % 2 == 0)) {
                throw new IllegalArgumentException("Expected alternating header names and values".toString());
            }
            String[] strArr = (String[]) namesAndValues.clone();
            int length = strArr.length;
            int i11 = 0;
            while (i11 < length) {
                int i12 = i11 + 1;
                String str = strArr[i11];
                if (!(str != null)) {
                    throw new IllegalArgumentException("Headers cannot be null".toString());
                }
                strArr[i11] = p9.r.b1(str).toString();
                i11 = i12;
            }
            int iC = c9.c.c(0, strArr.length - 1, 2);
            if (iC >= 0) {
                while (true) {
                    int i13 = i10 + 2;
                    String str2 = strArr[i10];
                    String str3 = strArr[i10 + 1];
                    d(str2);
                    e(str3, str2);
                    if (i10 == iC) {
                        break;
                    }
                    i10 = i13;
                }
            }
            return new u(strArr, null);
        }
    }

    public /* synthetic */ u(String[] strArr, kotlin.jvm.internal.k kVar) {
        this(strArr);
    }

    @NotNull
    public static final u g(@NotNull String... strArr) {
        return f26213b.g(strArr);
    }

    @Nullable
    public final String a(@NotNull String name) {
        kotlin.jvm.internal.t.i(name, "name");
        return f26213b.f(this.f26214a, name);
    }

    @Nullable
    public final Date b(@NotNull String name) {
        kotlin.jvm.internal.t.i(name, "name");
        String strA = a(name);
        if (strA == null) {
            return null;
        }
        return ma.c.a(strA);
    }

    @NotNull
    public final String e(int i10) {
        return this.f26214a[i10 * 2];
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof u) && Arrays.equals(this.f26214a, ((u) obj).f26214a);
    }

    @NotNull
    public final a f() {
        a aVar = new a();
        kotlin.collections.a0.D(aVar.h(), this.f26214a);
        return aVar;
    }

    @NotNull
    public final Map<String, List<String>> h() {
        TreeMap treeMap = new TreeMap(p9.q.y(s0.f29840a));
        int size = size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            String strE = e(i10);
            Locale US = Locale.US;
            kotlin.jvm.internal.t.h(US, "US");
            String lowerCase = strE.toLowerCase(US);
            kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(i(i10));
            i10 = i11;
        }
        return treeMap;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f26214a);
    }

    @NotNull
    public final String i(int i10) {
        return this.f26214a[(i10 * 2) + 1];
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<v8.s<? extends String, ? extends String>> iterator() {
        int size = size();
        v8.s[] sVarArr = new v8.s[size];
        for (int i10 = 0; i10 < size; i10++) {
            sVarArr[i10] = v8.y.a(e(i10), i(i10));
        }
        return kotlin.jvm.internal.c.a(sVarArr);
    }

    @NotNull
    public final List<String> j(@NotNull String name) {
        kotlin.jvm.internal.t.i(name, "name");
        int size = size();
        ArrayList arrayList = null;
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            if (p9.q.x(name, e(i10), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(i(i10));
            }
            i10 = i11;
        }
        if (arrayList == null) {
            return kotlin.collections.v.l();
        }
        List<String> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        kotlin.jvm.internal.t.h(listUnmodifiableList, "{\n      Collections.unmodifiableList(result)\n    }");
        return listUnmodifiableList;
    }

    public final int size() {
        return this.f26214a.length / 2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            String strE = e(i10);
            String strI = i(i10);
            sb.append(strE);
            sb.append(": ");
            if (ha.d.H(strE)) {
                strI = "██";
            }
            sb.append(strI);
            sb.append("\n");
            i10 = i11;
        }
        String string = sb.toString();
        kotlin.jvm.internal.t.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    private u(String[] strArr) {
        this.f26214a = strArr;
    }
}
