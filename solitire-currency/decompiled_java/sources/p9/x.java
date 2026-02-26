package p9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.a0;
import v8.c0;
import v8.e0;
import v8.h0;

/* JADX INFO: compiled from: UStrings.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class x {
    public static final byte a(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<this>");
        a0 a0VarB = b(str);
        if (a0VarB != null) {
            return a0VarB.g();
        }
        p.k(str);
        throw new v8.h();
    }

    @Nullable
    public static final a0 b(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<this>");
        return c(str, 10);
    }

    @Nullable
    public static final a0 c(@NotNull String str, int i10) {
        kotlin.jvm.internal.t.i(str, "<this>");
        c0 c0VarF = f(str, i10);
        if (c0VarF == null) {
            return null;
        }
        int iG = c0VarF.g();
        if (Integer.compare(iG ^ Integer.MIN_VALUE, c0.c(255) ^ Integer.MIN_VALUE) > 0) {
            return null;
        }
        return a0.a(a0.c((byte) iG));
    }

    public static final int d(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<this>");
        c0 c0VarE = e(str);
        if (c0VarE != null) {
            return c0VarE.g();
        }
        p.k(str);
        throw new v8.h();
    }

    @Nullable
    public static final c0 e(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<this>");
        return f(str, 10);
    }

    @Nullable
    public static final c0 f(@NotNull String str, int i10) {
        int i11;
        kotlin.jvm.internal.t.i(str, "<this>");
        b.a(i10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i12 = 0;
        char cCharAt = str.charAt(0);
        if (kotlin.jvm.internal.t.k(cCharAt, 48) < 0) {
            i11 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        } else {
            i11 = 0;
        }
        int iC = c0.c(i10);
        int iA = 119304647;
        while (i11 < length) {
            int iB = b.b(str.charAt(i11), i10);
            if (iB < 0) {
                return null;
            }
            if (Integer.compare(i12 ^ Integer.MIN_VALUE, iA ^ Integer.MIN_VALUE) > 0) {
                if (iA == 119304647) {
                    iA = w.a(-1, iC);
                    if (Integer.compare(i12 ^ Integer.MIN_VALUE, iA ^ Integer.MIN_VALUE) > 0) {
                    }
                }
                return null;
            }
            int iC2 = c0.c(i12 * iC);
            int iC3 = c0.c(c0.c(iB) + iC2);
            if (Integer.compare(iC3 ^ Integer.MIN_VALUE, iC2 ^ Integer.MIN_VALUE) < 0) {
                return null;
            }
            i11++;
            i12 = iC3;
        }
        return c0.a(i12);
    }

    public static final long g(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<this>");
        e0 e0VarH = h(str);
        if (e0VarH != null) {
            return e0VarH.g();
        }
        p.k(str);
        throw new v8.h();
    }

    @Nullable
    public static final e0 h(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<this>");
        return i(str, 10);
    }

    @Nullable
    public static final e0 i(@NotNull String str, int i10) {
        kotlin.jvm.internal.t.i(str, "<this>");
        b.a(i10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i11 = 0;
        char cCharAt = str.charAt(0);
        if (kotlin.jvm.internal.t.k(cCharAt, 48) < 0) {
            i11 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        }
        long jC = e0.c(i10);
        long j10 = 0;
        long jA = 512409557603043100L;
        while (i11 < length) {
            int iB = b.b(str.charAt(i11), i10);
            if (iB < 0) {
                return null;
            }
            if (Long.compare(j10 ^ Long.MIN_VALUE, jA ^ Long.MIN_VALUE) > 0) {
                if (jA == 512409557603043100L) {
                    jA = v.a(-1L, jC);
                    if (Long.compare(j10 ^ Long.MIN_VALUE, jA ^ Long.MIN_VALUE) > 0) {
                    }
                }
                return null;
            }
            long jC2 = e0.c(j10 * jC);
            long jC3 = e0.c(e0.c(((long) c0.c(iB)) & 4294967295L) + jC2);
            if (Long.compare(jC3 ^ Long.MIN_VALUE, jC2 ^ Long.MIN_VALUE) < 0) {
                return null;
            }
            i11++;
            j10 = jC3;
        }
        return e0.a(j10);
    }

    public static final short j(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<this>");
        h0 h0VarK = k(str);
        if (h0VarK != null) {
            return h0VarK.g();
        }
        p.k(str);
        throw new v8.h();
    }

    @Nullable
    public static final h0 k(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<this>");
        return l(str, 10);
    }

    @Nullable
    public static final h0 l(@NotNull String str, int i10) {
        kotlin.jvm.internal.t.i(str, "<this>");
        c0 c0VarF = f(str, i10);
        if (c0VarF == null) {
            return null;
        }
        int iG = c0VarF.g();
        if (Integer.compare(iG ^ Integer.MIN_VALUE, c0.c(65535) ^ Integer.MIN_VALUE) > 0) {
            return null;
        }
        return h0.a(h0.c((short) iG));
    }
}
