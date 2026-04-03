package va;

import java.io.EOFException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import ua.e1;
import ua.n0;

/* JADX INFO: compiled from: -Buffer.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final byte[] f35253a = e1.a("0123456789abcdef");

    @NotNull
    public static final byte[] a() {
        return f35253a;
    }

    @NotNull
    public static final String b(@NotNull ua.c cVar, long j10) throws EOFException {
        t.i(cVar, "<this>");
        if (j10 > 0) {
            long j11 = j10 - 1;
            if (cVar.L(j11) == ((byte) 13)) {
                String strD0 = cVar.d0(j11);
                cVar.skip(2L);
                return strD0;
            }
        }
        String strD02 = cVar.d0(j10);
        cVar.skip(1L);
        return strD02;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0065, code lost:
    
        if (r19 == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0067, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0068, code lost:
    
        return r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int c(@org.jetbrains.annotations.NotNull ua.c r17, @org.jetbrains.annotations.NotNull ua.n0 r18, boolean r19) {
        /*
            r0 = r17
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.t.i(r0, r1)
            java.lang.String r1 = "options"
            r2 = r18
            kotlin.jvm.internal.t.i(r2, r1)
            ua.u0 r0 = r0.f34738a
            r1 = -2
            r3 = -1
            if (r0 != 0) goto L19
            if (r19 == 0) goto L17
            goto L18
        L17:
            r1 = r3
        L18:
            return r1
        L19:
            byte[] r4 = r0.f34826a
            int r5 = r0.f34827b
            int r6 = r0.f34828c
            int[] r2 = r18.f()
            r7 = 0
            r9 = r0
            r10 = r3
            r8 = r7
        L27:
            int r11 = r8 + 1
            r8 = r2[r8]
            int r12 = r11 + 1
            r11 = r2[r11]
            if (r11 == r3) goto L32
            r10 = r11
        L32:
            if (r9 != 0) goto L35
            goto L65
        L35:
            r11 = 0
            if (r8 >= 0) goto L82
            int r8 = r8 * (-1)
            int r13 = r12 + r8
        L3c:
            int r8 = r5 + 1
            r5 = r4[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r14 = r12 + 1
            r12 = r2[r12]
            if (r5 == r12) goto L49
            return r10
        L49:
            if (r14 != r13) goto L4d
            r5 = 1
            goto L4e
        L4d:
            r5 = r7
        L4e:
            if (r8 != r6) goto L6f
            kotlin.jvm.internal.t.f(r9)
            ua.u0 r4 = r9.f34831f
            kotlin.jvm.internal.t.f(r4)
            int r6 = r4.f34827b
            byte[] r8 = r4.f34826a
            int r9 = r4.f34828c
            if (r4 != r0) goto L69
            if (r5 == 0) goto L65
            r4 = r8
            r8 = r11
            goto L75
        L65:
            if (r19 == 0) goto L68
            return r1
        L68:
            return r10
        L69:
            r16 = r8
            r8 = r4
            r4 = r16
            goto L75
        L6f:
            r16 = r9
            r9 = r6
            r6 = r8
            r8 = r16
        L75:
            if (r5 == 0) goto L7d
            r5 = r2[r14]
            r13 = r6
            r6 = r9
            r9 = r8
            goto La7
        L7d:
            r5 = r6
            r6 = r9
            r12 = r14
            r9 = r8
            goto L3c
        L82:
            int r13 = r5 + 1
            r5 = r4[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r14 = r12 + r8
        L8a:
            if (r12 != r14) goto L8d
            return r10
        L8d:
            r15 = r2[r12]
            if (r5 != r15) goto Lae
            int r12 = r12 + r8
            r5 = r2[r12]
            if (r13 != r6) goto La7
            ua.u0 r9 = r9.f34831f
            kotlin.jvm.internal.t.f(r9)
            int r4 = r9.f34827b
            byte[] r6 = r9.f34826a
            int r8 = r9.f34828c
            r13 = r4
            r4 = r6
            r6 = r8
            if (r9 != r0) goto La7
            r9 = r11
        La7:
            if (r5 < 0) goto Laa
            return r5
        Laa:
            int r8 = -r5
            r5 = r13
            goto L27
        Lae:
            int r12 = r12 + 1
            goto L8a
        */
        throw new UnsupportedOperationException("Method not decompiled: va.f.c(ua.c, ua.n0, boolean):int");
    }

    public static /* synthetic */ int d(ua.c cVar, n0 n0Var, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return c(cVar, n0Var, z10);
    }
}
