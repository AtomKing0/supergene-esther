package e8;

import e8.z;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Query.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e0 {
    private static final void a(a0 a0Var, String str, int i10, int i11, int i12, boolean z10) {
        String strSubstring;
        String strSubstring2;
        String strSubstring3;
        if (i11 == -1) {
            int iF = f(i10, i12, str);
            int iE = e(iF, i12, str);
            if (iE > iF) {
                if (z10) {
                    strSubstring3 = b.k(str, iF, iE, false, null, 12, null);
                } else {
                    strSubstring3 = str.substring(iF, iE);
                    kotlin.jvm.internal.t.h(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                a0Var.d(strSubstring3, kotlin.collections.v.l());
                return;
            }
            return;
        }
        int iF2 = f(i10, i11, str);
        int iE2 = e(iF2, i11, str);
        if (iE2 > iF2) {
            if (z10) {
                strSubstring = b.k(str, iF2, iE2, false, null, 12, null);
            } else {
                strSubstring = str.substring(iF2, iE2);
                kotlin.jvm.internal.t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            int iF3 = f(i11 + 1, i12, str);
            int iE3 = e(iF3, i12, str);
            if (z10) {
                strSubstring2 = b.k(str, iF3, iE3, true, null, 8, null);
            } else {
                strSubstring2 = str.substring(iF3, iE3);
                kotlin.jvm.internal.t.h(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            a0Var.f(strSubstring, strSubstring2);
        }
    }

    private static final void b(a0 a0Var, String str, int i10, int i11, boolean z10) {
        int i12;
        int i13;
        int iY = p9.r.Y(str);
        int i14 = 0;
        if (i10 <= iY) {
            int i15 = 0;
            int i16 = -1;
            int i17 = i10;
            int i18 = i17;
            while (i15 != i11) {
                char cCharAt = str.charAt(i17);
                if (cCharAt == '&') {
                    a(a0Var, str, i18, i16, i17, z10);
                    i15++;
                    i16 = -1;
                    i18 = i17 + 1;
                } else if (cCharAt == '=' && i16 == -1) {
                    i16 = i17;
                }
                if (i17 != iY) {
                    i17++;
                } else {
                    i13 = i18;
                    i12 = i16;
                    i14 = i15;
                }
            }
            return;
        }
        i12 = -1;
        i13 = i10;
        if (i14 == i11) {
            return;
        }
        a(a0Var, str, i13, i12, str.length(), z10);
    }

    @NotNull
    public static final z c(@NotNull String query, int i10, int i11, boolean z10) {
        kotlin.jvm.internal.t.i(query, "query");
        if (i10 > p9.r.Y(query)) {
            return z.f25406b.a();
        }
        z.a aVar = z.f25406b;
        a0 a0VarB = d0.b(0, 1, null);
        b(a0VarB, query, i10, i11, z10);
        return a0VarB.build();
    }

    public static /* synthetic */ z d(String str, int i10, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = 1000;
        }
        if ((i12 & 8) != 0) {
            z10 = true;
        }
        return c(str, i10, i11, z10);
    }

    private static final int e(int i10, int i11, CharSequence charSequence) {
        while (i11 > i10 && p9.b.c(charSequence.charAt(i11 - 1))) {
            i11--;
        }
        return i11;
    }

    private static final int f(int i10, int i11, CharSequence charSequence) {
        while (i10 < i11 && p9.b.c(charSequence.charAt(i10))) {
            i10++;
        }
        return i10;
    }
}
