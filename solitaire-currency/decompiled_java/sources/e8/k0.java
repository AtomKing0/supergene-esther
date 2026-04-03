package e8;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: URLParser.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final List<String> f25260a = kotlin.collections.u.e("");

    /* JADX INFO: compiled from: URLParser.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.p<String, List<? extends String>, v8.k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f0 f25261g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(f0 f0Var) {
            super(2);
            this.f25261g = f0Var;
        }

        public final void a(@NotNull String key, @NotNull List<String> values) {
            kotlin.jvm.internal.t.i(key, "key");
            kotlin.jvm.internal.t.i(values, "values");
            this.f25261g.e().d(key, values);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ v8.k0 mo4invoke(String str, List<? extends String> list) {
            a(str, list);
            return v8.k0.f35197a;
        }
    }

    private static final int a(String str, int i10, int i11, char c10) {
        int i12 = 0;
        while (true) {
            int i13 = i10 + i12;
            if (i13 >= i11 || str.charAt(i13) != c10) {
                break;
            }
            i12++;
        }
        return i12;
    }

    private static final void b(f0 f0Var, String str, int i10, int i11) {
        Integer numValueOf = Integer.valueOf(e(str, i10, i11));
        if (!(numValueOf.intValue() > 0)) {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : i11;
        String strSubstring = str.substring(i10, iIntValue);
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        f0Var.w(strSubstring);
        int i12 = iIntValue + 1;
        if (i12 >= i11) {
            f0Var.x(0);
            return;
        }
        String strSubstring2 = str.substring(i12, i11);
        kotlin.jvm.internal.t.h(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
        f0Var.x(Integer.parseInt(strSubstring2));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final int c(java.lang.String r12, int r13, int r14) {
        /*
            char r0 = r12.charAt(r13)
            r1 = 123(0x7b, float:1.72E-43)
            r2 = 1
            r3 = 0
            r4 = 97
            if (r4 > r0) goto L10
            if (r0 >= r1) goto L10
            r5 = r2
            goto L11
        L10:
            r5 = r3
        L11:
            r6 = 91
            r7 = 65
            r8 = -1
            if (r5 != 0) goto L24
            if (r7 > r0) goto L1e
            if (r0 >= r6) goto L1e
            r0 = r2
            goto L1f
        L1e:
            r0 = r3
        L1f:
            if (r0 != 0) goto L24
            r0 = r13
            r5 = r0
            goto L26
        L24:
            r0 = r13
            r5 = r8
        L26:
            if (r0 >= r14) goto L87
            char r9 = r12.charAt(r0)
            r10 = 58
            if (r9 != r10) goto L4b
            if (r5 != r8) goto L34
            int r0 = r0 - r13
            return r0
        L34:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "Illegal character in scheme at position "
            r13.append(r14)
            r13.append(r5)
            java.lang.String r13 = r13.toString()
            r12.<init>(r13)
            throw r12
        L4b:
            r11 = 47
            if (r9 == r11) goto L87
            r11 = 63
            if (r9 == r11) goto L87
            r11 = 35
            if (r9 != r11) goto L58
            goto L87
        L58:
            if (r5 != r8) goto L84
            if (r4 > r9) goto L60
            if (r9 >= r1) goto L60
            r11 = r2
            goto L61
        L60:
            r11 = r3
        L61:
            if (r11 != 0) goto L84
            if (r7 > r9) goto L69
            if (r9 >= r6) goto L69
            r11 = r2
            goto L6a
        L69:
            r11 = r3
        L6a:
            if (r11 != 0) goto L84
            r11 = 48
            if (r11 > r9) goto L74
            if (r9 >= r10) goto L74
            r10 = r2
            goto L75
        L74:
            r10 = r3
        L75:
            if (r10 != 0) goto L84
            r10 = 46
            if (r9 == r10) goto L84
            r10 = 43
            if (r9 == r10) goto L84
            r10 = 45
            if (r9 == r10) goto L84
            r5 = r0
        L84:
            int r0 = r0 + 1
            goto L26
        L87:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: e8.k0.c(java.lang.String, int, int):int");
    }

    @NotNull
    public static final List<String> d() {
        return f25260a;
    }

    private static final int e(String str, int i10, int i11) {
        boolean z10 = false;
        while (i10 < i11) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '[') {
                z10 = true;
            } else if (cCharAt == ']') {
                z10 = false;
            } else if (cCharAt == ':' && !z10) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    private static final void f(f0 f0Var, String str, int i10, int i11, int i12) {
        if (i12 != 2) {
            if (i12 != 3) {
                throw new IllegalArgumentException("Invalid file url: " + str);
            }
            f0Var.w("");
            StringBuilder sb = new StringBuilder();
            sb.append('/');
            String strSubstring = str.substring(i10, i11);
            kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            sb.append(strSubstring);
            h0.i(f0Var, sb.toString());
            return;
        }
        int iD0 = p9.r.d0(str, '/', i10, false, 4, null);
        if (iD0 == -1 || iD0 == i11) {
            String strSubstring2 = str.substring(i10, i11);
            kotlin.jvm.internal.t.h(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
            f0Var.w(strSubstring2);
        } else {
            String strSubstring3 = str.substring(i10, iD0);
            kotlin.jvm.internal.t.h(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
            f0Var.w(strSubstring3);
            String strSubstring4 = str.substring(iD0, i11);
            kotlin.jvm.internal.t.h(strSubstring4, "this as java.lang.String…ing(startIndex, endIndex)");
            h0.i(f0Var, strSubstring4);
        }
    }

    private static final void g(f0 f0Var, String str, int i10, int i11) {
        if (i10 >= i11 || str.charAt(i10) != '#') {
            return;
        }
        String strSubstring = str.substring(i10 + 1, i11);
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        f0Var.r(strSubstring);
    }

    private static final void h(f0 f0Var, String str, int i10, int i11) {
        int iE0 = p9.r.e0(str, "@", i10, false, 4, null);
        if (iE0 == -1) {
            throw new IllegalArgumentException("Invalid mailto url: " + str + ", it should contain '@'.");
        }
        String strSubstring = str.substring(i10, iE0);
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        f0Var.A(b.i(strSubstring, 0, 0, null, 7, null));
        String strSubstring2 = str.substring(iE0 + 1, i11);
        kotlin.jvm.internal.t.h(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
        f0Var.w(strSubstring2);
    }

    private static final int i(f0 f0Var, String str, int i10, int i11) {
        int i12 = i10 + 1;
        if (i12 == i11) {
            f0Var.z(true);
            return i11;
        }
        Integer numValueOf = Integer.valueOf(p9.r.d0(str, '#', i12, false, 4, null));
        if (!(numValueOf.intValue() > 0)) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            i11 = numValueOf.intValue();
        }
        String strSubstring = str.substring(i12, i11);
        kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        e0.d(strSubstring, 0, 0, false, 6, null).d(new a(f0Var));
        return i11;
    }

    @NotNull
    public static final f0 j(@NotNull f0 f0Var, @NotNull String urlString) {
        kotlin.jvm.internal.t.i(f0Var, "<this>");
        kotlin.jvm.internal.t.i(urlString, "urlString");
        if (p9.q.z(urlString)) {
            return f0Var;
        }
        try {
            return k(f0Var, urlString);
        } catch (Throwable th) {
            throw new j0(urlString, th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01ae  */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final e8.f0 k(@org.jetbrains.annotations.NotNull e8.f0 r21, @org.jetbrains.annotations.NotNull java.lang.String r22) {
        /*
            Method dump skipped, instruction units count: 472
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e8.k0.k(e8.f0, java.lang.String):e8.f0");
    }
}
