package va;

import com.unity3d.services.UnityAdsConstants;
import h9.l;
import h9.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import kotlin.collections.d0;
import kotlin.collections.r0;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.m0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import p9.q;
import p9.r;
import ua.c1;
import ua.q0;
import v8.k0;
import v8.y;

/* JADX INFO: compiled from: zip.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class e {

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return x8.b.a(((d) t10).a(), ((d) t11).a());
        }
    }

    /* JADX INFO: compiled from: zip.kt */
    static final class b extends v implements p<Integer, Long, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ i0 f35243g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f35244h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ m0 f35245i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ ua.e f35246j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ m0 f35247k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ m0 f35248l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(i0 i0Var, long j10, m0 m0Var, ua.e eVar, m0 m0Var2, m0 m0Var3) {
            super(2);
            this.f35243g = i0Var;
            this.f35244h = j10;
            this.f35245i = m0Var;
            this.f35246j = eVar;
            this.f35247k = m0Var2;
            this.f35248l = m0Var3;
        }

        public final void a(int i10, long j10) throws IOException {
            if (i10 == 1) {
                i0 i0Var = this.f35243g;
                if (i0Var.f29826a) {
                    throw new IOException("bad zip: zip64 extra repeated");
                }
                i0Var.f29826a = true;
                if (j10 < this.f35244h) {
                    throw new IOException("bad zip: zip64 extra too short");
                }
                m0 m0Var = this.f35245i;
                long jU = m0Var.f29833a;
                if (jU == 4294967295L) {
                    jU = this.f35246j.U();
                }
                m0Var.f29833a = jU;
                m0 m0Var2 = this.f35247k;
                m0Var2.f29833a = m0Var2.f29833a == 4294967295L ? this.f35246j.U() : 0L;
                m0 m0Var3 = this.f35248l;
                m0Var3.f29833a = m0Var3.f29833a == 4294967295L ? this.f35246j.U() : 0L;
            }
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Integer num, Long l10) throws IOException {
            a(num.intValue(), l10.longValue());
            return k0.f35197a;
        }
    }

    /* JADX INFO: compiled from: zip.kt */
    static final class c extends v implements p<Integer, Long, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ua.e f35249g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ n0<Long> f35250h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ n0<Long> f35251i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ n0<Long> f35252j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(ua.e eVar, n0<Long> n0Var, n0<Long> n0Var2, n0<Long> n0Var3) {
            super(2);
            this.f35249g = eVar;
            this.f35250h = n0Var;
            this.f35251i = n0Var2;
            this.f35252j = n0Var3;
        }

        /* JADX WARN: Type inference failed for: r0v13, types: [T, java.lang.Long] */
        /* JADX WARN: Type inference failed for: r10v12, types: [T, java.lang.Long] */
        /* JADX WARN: Type inference failed for: r11v3, types: [T, java.lang.Long] */
        public final void a(int i10, long j10) throws IOException {
            if (i10 == 21589) {
                if (j10 < 1) {
                    throw new IOException("bad zip: extended timestamp extra too short");
                }
                int i11 = this.f35249g.readByte() & 255;
                boolean z10 = (i11 & 1) == 1;
                boolean z11 = (i11 & 2) == 2;
                boolean z12 = (i11 & 4) == 4;
                ua.e eVar = this.f35249g;
                long j11 = z10 ? 5L : 1L;
                if (z11) {
                    j11 += 4;
                }
                if (z12) {
                    j11 += 4;
                }
                if (j10 < j11) {
                    throw new IOException("bad zip: extended timestamp extra too short");
                }
                if (z10) {
                    this.f35250h.f29834a = Long.valueOf(((long) eVar.y0()) * 1000);
                }
                if (z11) {
                    this.f35251i.f29834a = Long.valueOf(((long) this.f35249g.y0()) * 1000);
                }
                if (z12) {
                    this.f35252j.f29834a = Long.valueOf(((long) this.f35249g.y0()) * 1000);
                }
            }
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Integer num, Long l10) throws IOException {
            a(num.intValue(), l10.longValue());
            return k0.f35197a;
        }
    }

    private static final Map<q0, d> a(List<d> list) {
        q0 q0VarE = q0.a.e(q0.f34806b, UnityAdsConstants.DefaultUrls.AD_ASSET_PATH, false, 1, null);
        Map<q0, d> mapL = r0.l(y.a(q0VarE, new d(q0VarE, true, null, 0L, 0L, 0L, 0, null, 0L, 508, null)));
        for (d dVar : d0.I0(list, new a())) {
            if (mapL.put(dVar.a(), dVar) == null) {
                while (true) {
                    q0 q0VarH = dVar.a().h();
                    if (q0VarH != null) {
                        d dVar2 = mapL.get(q0VarH);
                        if (dVar2 != null) {
                            dVar2.b().add(dVar.a());
                            break;
                        }
                        d dVar3 = new d(q0VarH, true, null, 0L, 0L, 0L, 0, null, 0L, 508, null);
                        mapL.put(q0VarH, dVar3);
                        dVar3.b().add(dVar.a());
                        dVar = dVar3;
                    }
                }
            }
        }
        return mapL;
    }

    private static final Long b(int i10, int i11) {
        if (i11 == -1) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(14, 0);
        gregorianCalendar.set(((i10 >> 9) & 127) + 1980, ((i10 >> 5) & 15) - 1, i10 & 31, (i11 >> 11) & 31, (i11 >> 5) & 63, (i11 & 31) << 1);
        return Long.valueOf(gregorianCalendar.getTime().getTime());
    }

    private static final String c(int i10) {
        StringBuilder sb = new StringBuilder();
        sb.append("0x");
        String string = Integer.toString(i10, p9.b.a(16));
        t.h(string, "toString(this, checkRadix(radix))");
        sb.append(string);
        return sb.toString();
    }

    @NotNull
    public static final c1 d(@NotNull q0 zipPath, @NotNull ua.j fileSystem, @NotNull l<? super d, Boolean> predicate) throws IOException {
        long size;
        long j10;
        ua.e eVarD;
        t.i(zipPath, "zipPath");
        t.i(fileSystem, "fileSystem");
        t.i(predicate, "predicate");
        ua.h hVarN = fileSystem.n(zipPath);
        try {
            size = hVarN.size() - ((long) 22);
        } finally {
        }
        if (size < 0) {
            throw new IOException("not a zip: size=" + hVarN.size());
        }
        long jMax = Math.max(size - 65536, 0L);
        do {
            ua.e eVarD2 = ua.k0.d(hVarN.J(size));
            try {
                if (eVarD2.y0() == 101010256) {
                    va.a aVarF = f(eVarD2);
                    String strD0 = eVarD2.d0(aVarF.b());
                    eVarD2.close();
                    long j11 = size - ((long) 20);
                    if (j11 > 0) {
                        eVarD = ua.k0.d(hVarN.J(j11));
                        try {
                            if (eVarD.y0() == 117853008) {
                                int iY0 = eVarD.y0();
                                long jU = eVarD.U();
                                if (eVarD.y0() != 1 || iY0 != 0) {
                                    throw new IOException("unsupported zip: spanned");
                                }
                                eVarD = ua.k0.d(hVarN.J(jU));
                                try {
                                    int iY02 = eVarD.y0();
                                    if (iY02 != 101075792) {
                                        throw new IOException("bad zip: expected " + c(101075792) + " but was " + c(iY02));
                                    }
                                    aVarF = j(eVarD, aVarF);
                                    k0 k0Var = k0.f35197a;
                                    f9.c.a(eVarD, null);
                                } finally {
                                }
                            }
                            k0 k0Var2 = k0.f35197a;
                            f9.c.a(eVarD, null);
                        } finally {
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    eVarD = ua.k0.d(hVarN.J(aVarF.a()));
                    try {
                        long jC = aVarF.c();
                        for (j10 = 0; j10 < jC; j10++) {
                            d dVarE = e(eVarD);
                            if (dVarE.f() >= aVarF.a()) {
                                throw new IOException("bad zip: local file header offset >= central directory offset");
                            }
                            if (predicate.invoke(dVarE).booleanValue()) {
                                arrayList.add(dVarE);
                            }
                        }
                        k0 k0Var3 = k0.f35197a;
                        f9.c.a(eVarD, null);
                        c1 c1Var = new c1(zipPath, fileSystem, a(arrayList), strD0);
                        f9.c.a(hVarN, null);
                        return c1Var;
                    } finally {
                        try {
                            throw th;
                        } finally {
                            f9.c.a(eVarD, th);
                        }
                    }
                }
                eVarD2.close();
                size--;
            } catch (Throwable th) {
                eVarD2.close();
                throw th;
            }
        } while (size >= jMax);
        throw new IOException("not a zip: end of central directory signature not found");
    }

    @NotNull
    public static final d e(@NotNull ua.e eVar) throws IOException {
        m0 m0Var;
        long j10;
        t.i(eVar, "<this>");
        int iY0 = eVar.y0();
        if (iY0 != 33639248) {
            throw new IOException("bad zip: expected " + c(33639248) + " but was " + c(iY0));
        }
        eVar.skip(4L);
        int iT = eVar.T() & 65535;
        if ((iT & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + c(iT));
        }
        int iT2 = eVar.T() & 65535;
        Long lB = b(eVar.T() & 65535, eVar.T() & 65535);
        long jY0 = ((long) eVar.y0()) & 4294967295L;
        m0 m0Var2 = new m0();
        m0Var2.f29833a = ((long) eVar.y0()) & 4294967295L;
        m0 m0Var3 = new m0();
        m0Var3.f29833a = ((long) eVar.y0()) & 4294967295L;
        int iT3 = eVar.T() & 65535;
        int iT4 = eVar.T() & 65535;
        int iT5 = eVar.T() & 65535;
        eVar.skip(8L);
        m0 m0Var4 = new m0();
        m0Var4.f29833a = ((long) eVar.y0()) & 4294967295L;
        String strD0 = eVar.d0(iT3);
        if (r.O(strD0, (char) 0, false, 2, null)) {
            throw new IOException("bad zip: filename contains 0x00");
        }
        if (m0Var3.f29833a == 4294967295L) {
            j10 = ((long) 8) + 0;
            m0Var = m0Var4;
        } else {
            m0Var = m0Var4;
            j10 = 0;
        }
        if (m0Var2.f29833a == 4294967295L) {
            j10 += (long) 8;
        }
        m0 m0Var5 = m0Var;
        if (m0Var5.f29833a == 4294967295L) {
            j10 += (long) 8;
        }
        long j11 = j10;
        i0 i0Var = new i0();
        g(eVar, iT4, new b(i0Var, j11, m0Var3, eVar, m0Var2, m0Var5));
        if (j11 > 0 && !i0Var.f29826a) {
            throw new IOException("bad zip: zip64 extra required but absent");
        }
        return new d(q0.a.e(q0.f34806b, UnityAdsConstants.DefaultUrls.AD_ASSET_PATH, false, 1, null).j(strD0), q.w(strD0, UnityAdsConstants.DefaultUrls.AD_ASSET_PATH, false, 2, null), eVar.d0(iT5), jY0, m0Var2.f29833a, m0Var3.f29833a, iT2, lB, m0Var5.f29833a);
    }

    private static final va.a f(ua.e eVar) throws IOException {
        int iT = eVar.T() & 65535;
        int iT2 = eVar.T() & 65535;
        long jT = eVar.T() & 65535;
        if (jT != (eVar.T() & 65535) || iT != 0 || iT2 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        eVar.skip(4L);
        return new va.a(jT, 4294967295L & ((long) eVar.y0()), eVar.T() & 65535);
    }

    private static final void g(ua.e eVar, int i10, p<? super Integer, ? super Long, k0> pVar) throws IOException {
        long j10 = i10;
        while (j10 != 0) {
            if (j10 < 4) {
                throw new IOException("bad zip: truncated header in extra field");
            }
            int iT = eVar.T() & 65535;
            long jT = ((long) eVar.T()) & 65535;
            long j11 = j10 - ((long) 4);
            if (j11 < jT) {
                throw new IOException("bad zip: truncated value in extra field");
            }
            eVar.a0(jT);
            long size = eVar.g().size();
            pVar.mo4invoke(Integer.valueOf(iT), Long.valueOf(jT));
            long size2 = (eVar.g().size() + jT) - size;
            if (size2 < 0) {
                throw new IOException("unsupported zip: too many bytes processed for " + iT);
            }
            if (size2 > 0) {
                eVar.g().skip(size2);
            }
            j10 = j11 - jT;
        }
    }

    @NotNull
    public static final ua.i h(@NotNull ua.e eVar, @NotNull ua.i basicMetadata) throws IOException {
        t.i(eVar, "<this>");
        t.i(basicMetadata, "basicMetadata");
        ua.i iVarI = i(eVar, basicMetadata);
        t.f(iVarI);
        return iVarI;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final ua.i i(ua.e eVar, ua.i iVar) throws IOException {
        n0 n0Var = new n0();
        n0Var.f29834a = iVar != null ? iVar.c() : 0;
        n0 n0Var2 = new n0();
        n0 n0Var3 = new n0();
        int iY0 = eVar.y0();
        if (iY0 != 67324752) {
            throw new IOException("bad zip: expected " + c(67324752) + " but was " + c(iY0));
        }
        eVar.skip(2L);
        int iT = eVar.T() & 65535;
        if ((iT & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + c(iT));
        }
        eVar.skip(18L);
        long jT = ((long) eVar.T()) & 65535;
        int iT2 = eVar.T() & 65535;
        eVar.skip(jT);
        if (iVar == null) {
            eVar.skip(iT2);
            return null;
        }
        g(eVar, iT2, new c(eVar, n0Var, n0Var2, n0Var3));
        return new ua.i(iVar.g(), iVar.f(), null, iVar.d(), (Long) n0Var3.f29834a, (Long) n0Var.f29834a, (Long) n0Var2.f29834a, null, 128, null);
    }

    private static final va.a j(ua.e eVar, va.a aVar) throws IOException {
        eVar.skip(12L);
        int iY0 = eVar.y0();
        int iY02 = eVar.y0();
        long jU = eVar.U();
        if (jU != eVar.U() || iY0 != 0 || iY02 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        eVar.skip(8L);
        return new va.a(jU, eVar.U(), aVar.b());
    }

    public static final void k(@NotNull ua.e eVar) {
        t.i(eVar, "<this>");
        i(eVar, null);
    }
}
