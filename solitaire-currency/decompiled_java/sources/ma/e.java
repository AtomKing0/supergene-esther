package ma;

import ga.d0;
import ga.m;
import ga.n;
import ga.u;
import ga.v;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import p9.q;
import ua.f;

/* JADX INFO: compiled from: HttpHeaders.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final ua.f f31480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final ua.f f31481b;

    static {
        f.a aVar = ua.f.f34755d;
        f31480a = aVar.d("\"\\");
        f31481b = aVar.d("\t ,=");
    }

    @NotNull
    public static final List<ga.h> a(@NotNull u uVar, @NotNull String headerName) {
        t.i(uVar, "<this>");
        t.i(headerName, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = uVar.size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            if (q.x(headerName, uVar.e(i10), true)) {
                try {
                    c(new ua.c().E(uVar.i(i10)), arrayList);
                } catch (EOFException e10) {
                    qa.j.f33228a.g().k("Unable to parse challenge", 5, e10);
                }
            }
            i10 = i11;
        }
        return arrayList;
    }

    public static final boolean b(@NotNull d0 d0Var) {
        t.i(d0Var, "<this>");
        if (t.d(d0Var.I0().h(), "HEAD")) {
            return false;
        }
        int iQ = d0Var.q();
        return (((iQ >= 100 && iQ < 200) || iQ == 204 || iQ == 304) && ha.d.v(d0Var) == -1 && !q.x("chunked", d0.J(d0Var, "Transfer-Encoding", null, 2, null), true)) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0079, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0079, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void c(ua.c r7, java.util.List<ga.h> r8) throws java.io.EOFException {
        /*
            r0 = 0
        L1:
            r1 = r0
        L2:
            if (r1 != 0) goto Le
            g(r7)
            java.lang.String r1 = e(r7)
            if (r1 != 0) goto Le
            return
        Le:
            boolean r2 = g(r7)
            java.lang.String r3 = e(r7)
            if (r3 != 0) goto L2c
            boolean r7 = r7.m0()
            if (r7 != 0) goto L1f
            return
        L1f:
            ga.h r7 = new ga.h
            java.util.Map r0 = kotlin.collections.o0.g()
            r7.<init>(r1, r0)
            r8.add(r7)
            return
        L2c:
            r4 = 61
            int r5 = ha.d.L(r7, r4)
            boolean r6 = g(r7)
            if (r2 != 0) goto L5c
            if (r6 != 0) goto L40
            boolean r2 = r7.m0()
            if (r2 == 0) goto L5c
        L40:
            ga.h r2 = new ga.h
            java.lang.String r4 = "="
            java.lang.String r4 = p9.h.C(r4, r5)
            java.lang.String r3 = kotlin.jvm.internal.t.r(r3, r4)
            java.util.Map r3 = java.util.Collections.singletonMap(r0, r3)
            java.lang.String r4 = "singletonMap<String, Str…ek + \"=\".repeat(eqCount))"
            kotlin.jvm.internal.t.h(r3, r4)
            r2.<init>(r1, r3)
            r8.add(r2)
            goto L1
        L5c:
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            int r6 = ha.d.L(r7, r4)
            int r5 = r5 + r6
        L66:
            if (r3 != 0) goto L77
            java.lang.String r3 = e(r7)
            boolean r5 = g(r7)
            if (r5 == 0) goto L73
            goto L79
        L73:
            int r5 = ha.d.L(r7, r4)
        L77:
            if (r5 != 0) goto L84
        L79:
            ga.h r4 = new ga.h
            r4.<init>(r1, r2)
            r8.add(r4)
            r1 = r3
            goto L2
        L84:
            r6 = 1
            if (r5 <= r6) goto L88
            return
        L88:
            boolean r6 = g(r7)
            if (r6 == 0) goto L8f
            return
        L8f:
            r6 = 34
            boolean r6 = h(r7, r6)
            if (r6 == 0) goto L9c
            java.lang.String r6 = d(r7)
            goto La0
        L9c:
            java.lang.String r6 = e(r7)
        La0:
            if (r6 != 0) goto La3
            return
        La3:
            java.lang.Object r3 = r2.put(r3, r6)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto Lac
            return
        Lac:
            boolean r3 = g(r7)
            if (r3 != 0) goto Lb9
            boolean r3 = r7.m0()
            if (r3 != 0) goto Lb9
            return
        Lb9:
            r3 = r0
            goto L66
        */
        throw new UnsupportedOperationException("Method not decompiled: ma.e.c(ua.c, java.util.List):void");
    }

    private static final String d(ua.c cVar) throws EOFException {
        if (!(cVar.readByte() == 34)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        ua.c cVar2 = new ua.c();
        while (true) {
            long jR = cVar.R(f31480a);
            if (jR == -1) {
                return null;
            }
            if (cVar.L(jR) == 34) {
                cVar2.G(cVar, jR);
                cVar.readByte();
                return cVar2.K0();
            }
            if (cVar.size() == jR + 1) {
                return null;
            }
            cVar2.G(cVar, jR);
            cVar.readByte();
            cVar2.G(cVar, 1L);
        }
    }

    private static final String e(ua.c cVar) {
        long jR = cVar.R(f31481b);
        if (jR == -1) {
            jR = cVar.size();
        }
        if (jR != 0) {
            return cVar.d0(jR);
        }
        return null;
    }

    public static final void f(@NotNull n nVar, @NotNull v url, @NotNull u headers) {
        t.i(nVar, "<this>");
        t.i(url, "url");
        t.i(headers, "headers");
        if (nVar == n.f26183b) {
            return;
        }
        List<m> listE = m.f26168j.e(url, headers);
        if (listE.isEmpty()) {
            return;
        }
        nVar.a(url, listE);
    }

    private static final boolean g(ua.c cVar) throws EOFException {
        boolean z10 = false;
        while (!cVar.m0()) {
            byte bL = cVar.L(0L);
            boolean z11 = true;
            if (bL != 44) {
                if (bL != 32 && bL != 9) {
                    z11 = false;
                }
                if (!z11) {
                    break;
                }
                cVar.readByte();
            } else {
                cVar.readByte();
                z10 = true;
            }
        }
        return z10;
    }

    private static final boolean h(ua.c cVar, byte b10) {
        return !cVar.m0() && cVar.L(0L) == b10;
    }
}
