package q9;

import androidx.media3.common.PlaybackException;
import kotlin.jvm.internal.t;
import n9.l;
import n9.o;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Duration.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d {
    /* JADX INFO: Access modifiers changed from: private */
    public static final long i(long j10, int i10) {
        return b.j((j10 << 1) + ((long) i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long j(long j10) {
        return b.j((j10 << 1) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long k(long j10) {
        return new l(-4611686018426L, 4611686018426L).g(j10) ? l(n(j10)) : j(o.p(j10, -4611686018427387903L, 4611686018427387903L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long l(long j10) {
        return b.j(j10 << 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long m(long j10) {
        return new l(-4611686018426999999L, 4611686018426999999L).g(j10) ? l(j10) : j(o(j10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long n(long j10) {
        return j10 * ((long) PlaybackException.CUSTOM_ERROR_CODE_BASE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long o(long j10) {
        return j10 / ((long) PlaybackException.CUSTOM_ERROR_CODE_BASE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:170:0x00a6 A[EDGE_INSN: B:170:0x00a6->B:49:0x00a6 BREAK  A[LOOP:1: B:36:0x006c->B:47:0x009a], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009a A[LOOP:1: B:36:0x006c->B:47:0x009a, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long p(java.lang.String r27, boolean r28) {
        /*
            Method dump skipped, instruction units count: 727
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q9.d.p(java.lang.String, boolean):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final long q(java.lang.String r9) {
        /*
            int r0 = r9.length()
            r1 = 0
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 <= 0) goto L18
            java.lang.String r5 = "+-"
            char r6 = r9.charAt(r4)
            boolean r5 = p9.h.O(r5, r6, r4, r2, r1)
            if (r5 == 0) goto L18
            r5 = r3
            goto L19
        L18:
            r5 = r4
        L19:
            int r0 = r0 - r5
            r6 = 16
            if (r0 <= r6) goto L6e
            n9.i r0 = new n9.i
            int r6 = p9.h.Y(r9)
            r0.<init>(r5, r6)
            boolean r5 = r0 instanceof java.util.Collection
            if (r5 == 0) goto L36
            r5 = r0
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L36
        L34:
            r0 = r3
            goto L5b
        L36:
            java.util.Iterator r0 = r0.iterator()
        L3a:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L34
            r5 = r0
            kotlin.collections.l0 r5 = (kotlin.collections.l0) r5
            int r5 = r5.nextInt()
            n9.c r6 = new n9.c
            r7 = 48
            r8 = 57
            r6.<init>(r7, r8)
            char r5 = r9.charAt(r5)
            boolean r5 = r6.g(r5)
            if (r5 != 0) goto L3a
            r0 = r4
        L5b:
            if (r0 == 0) goto L6e
            char r9 = r9.charAt(r4)
            r0 = 45
            if (r9 != r0) goto L68
            r0 = -9223372036854775808
            goto L6d
        L68:
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L6d:
            return r0
        L6e:
            java.lang.String r0 = "+"
            boolean r0 = p9.h.K(r9, r0, r4, r2, r1)
            if (r0 == 0) goto L7a
            java.lang.String r9 = p9.h.d1(r9, r3)
        L7a:
            long r0 = java.lang.Long.parseLong(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: q9.d.q(java.lang.String):long");
    }

    public static final long r(double d10, @NotNull e unit) {
        t.i(unit, "unit");
        double dA = f.a(d10, unit, e.f33184b);
        if (!(!Double.isNaN(dA))) {
            throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
        }
        long jD = j9.c.d(dA);
        return new l(-4611686018426999999L, 4611686018426999999L).g(jD) ? l(jD) : k(j9.c.d(f.a(d10, unit, e.f33186d)));
    }

    public static final long s(int i10, @NotNull e unit) {
        t.i(unit, "unit");
        return unit.compareTo(e.f33187e) <= 0 ? l(f.c(i10, unit, e.f33184b)) : t(i10, unit);
    }

    public static final long t(long j10, @NotNull e unit) {
        t.i(unit, "unit");
        e eVar = e.f33184b;
        long jC = f.c(4611686018426999999L, eVar, unit);
        return new l(-jC, jC).g(j10) ? l(f.c(j10, unit, eVar)) : j(o.p(f.b(j10, unit, e.f33186d), -4611686018427387903L, 4611686018427387903L));
    }
}
