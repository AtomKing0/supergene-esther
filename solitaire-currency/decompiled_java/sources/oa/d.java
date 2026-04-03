package oa;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.webkit.ProxyConfig;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.zk;
import com.unity3d.services.UnityAdsConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.d0;
import kotlin.collections.o;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import ua.k0;
import ua.z0;

/* JADX INFO: compiled from: Hpack.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f32113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final c[] f32114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Map<ua.f, Integer> f32115c;

    static {
        d dVar = new d();
        f32113a = dVar;
        ua.f fVar = c.f32106g;
        ua.f fVar2 = c.f32107h;
        ua.f fVar3 = c.f32108i;
        ua.f fVar4 = c.f32105f;
        f32114b = new c[]{new c(c.f32109j, ""), new c(fVar, "GET"), new c(fVar, "POST"), new c(fVar2, UnityAdsConstants.DefaultUrls.AD_ASSET_PATH), new c(fVar2, "/index.html"), new c(fVar3, ProxyConfig.MATCH_HTTP), new c(fVar3, "https"), new c(fVar4, "200"), new c(fVar4, "204"), new c(fVar4, "206"), new c(fVar4, "304"), new c(fVar4, "400"), new c(fVar4, "404"), new c(fVar4, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c(IronSourceSegment.AGE, ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c(TypedValues.TransitionType.S_FROM, ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c("location", ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c("refresh", ""), new c("retry-after", ""), new c(zk.f16431a, ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};
        f32115c = dVar.d();
    }

    private d() {
    }

    private final Map<ua.f, Integer> d() {
        c[] cVarArr = f32114b;
        LinkedHashMap linkedHashMap = new LinkedHashMap(cVarArr.length);
        int length = cVarArr.length;
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            c[] cVarArr2 = f32114b;
            if (!linkedHashMap.containsKey(cVarArr2[i10].f32110a)) {
                linkedHashMap.put(cVarArr2[i10].f32110a, Integer.valueOf(i10));
            }
            i10 = i11;
        }
        Map<ua.f, Integer> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        t.h(mapUnmodifiableMap, "unmodifiableMap(result)");
        return mapUnmodifiableMap;
    }

    @NotNull
    public final ua.f a(@NotNull ua.f name) throws IOException {
        t.i(name, "name");
        int iB = name.B();
        int i10 = 0;
        while (i10 < iB) {
            int i11 = i10 + 1;
            byte bF = name.f(i10);
            if (65 <= bF && bF <= 90) {
                throw new IOException(t.r("PROTOCOL_ERROR response malformed: mixed case name: ", name.G()));
            }
            i10 = i11;
        }
        return name;
    }

    @NotNull
    public final Map<ua.f, Integer> b() {
        return f32115c;
    }

    @NotNull
    public final c[] c() {
        return f32114b;
    }

    /* JADX INFO: compiled from: Hpack.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f32116a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f32117b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final List<c> f32118c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        private final ua.e f32119d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        public c[] f32120e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f32121f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f32122g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f32123h;

        public a(@NotNull z0 source, int i10, int i11) {
            t.i(source, "source");
            this.f32116a = i10;
            this.f32117b = i11;
            this.f32118c = new ArrayList();
            this.f32119d = k0.d(source);
            this.f32120e = new c[8];
            this.f32121f = r2.length - 1;
        }

        private final void a() {
            int i10 = this.f32117b;
            int i11 = this.f32123h;
            if (i10 < i11) {
                if (i10 == 0) {
                    b();
                } else {
                    d(i11 - i10);
                }
            }
        }

        private final void b() {
            o.v(this.f32120e, null, 0, 0, 6, null);
            this.f32121f = this.f32120e.length - 1;
            this.f32122g = 0;
            this.f32123h = 0;
        }

        private final int c(int i10) {
            return this.f32121f + 1 + i10;
        }

        private final int d(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f32120e.length;
                while (true) {
                    length--;
                    i11 = this.f32121f;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    c cVar = this.f32120e[length];
                    t.f(cVar);
                    int i13 = cVar.f32112c;
                    i10 -= i13;
                    this.f32123h -= i13;
                    this.f32122g--;
                    i12++;
                }
                c[] cVarArr = this.f32120e;
                System.arraycopy(cVarArr, i11 + 1, cVarArr, i11 + 1 + i12, this.f32122g);
                this.f32121f += i12;
            }
            return i12;
        }

        private final ua.f f(int i10) throws IOException {
            if (h(i10)) {
                return d.f32113a.c()[i10].f32110a;
            }
            int iC = c(i10 - d.f32113a.c().length);
            if (iC >= 0) {
                c[] cVarArr = this.f32120e;
                if (iC < cVarArr.length) {
                    c cVar = cVarArr[iC];
                    t.f(cVar);
                    return cVar.f32110a;
                }
            }
            throw new IOException(t.r("Header index too large ", Integer.valueOf(i10 + 1)));
        }

        private final void g(int i10, c cVar) {
            this.f32118c.add(cVar);
            int i11 = cVar.f32112c;
            if (i10 != -1) {
                c cVar2 = this.f32120e[c(i10)];
                t.f(cVar2);
                i11 -= cVar2.f32112c;
            }
            int i12 = this.f32117b;
            if (i11 > i12) {
                b();
                return;
            }
            int iD = d((this.f32123h + i11) - i12);
            if (i10 == -1) {
                int i13 = this.f32122g + 1;
                c[] cVarArr = this.f32120e;
                if (i13 > cVarArr.length) {
                    c[] cVarArr2 = new c[cVarArr.length * 2];
                    System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                    this.f32121f = this.f32120e.length - 1;
                    this.f32120e = cVarArr2;
                }
                int i14 = this.f32121f;
                this.f32121f = i14 - 1;
                this.f32120e[i14] = cVar;
                this.f32122g++;
            } else {
                this.f32120e[i10 + c(i10) + iD] = cVar;
            }
            this.f32123h += i11;
        }

        private final boolean h(int i10) {
            return i10 >= 0 && i10 <= d.f32113a.c().length - 1;
        }

        private final int i() throws IOException {
            return ha.d.d(this.f32119d.readByte(), 255);
        }

        private final void l(int i10) throws IOException {
            if (h(i10)) {
                this.f32118c.add(d.f32113a.c()[i10]);
                return;
            }
            int iC = c(i10 - d.f32113a.c().length);
            if (iC >= 0) {
                c[] cVarArr = this.f32120e;
                if (iC < cVarArr.length) {
                    List<c> list = this.f32118c;
                    c cVar = cVarArr[iC];
                    t.f(cVar);
                    list.add(cVar);
                    return;
                }
            }
            throw new IOException(t.r("Header index too large ", Integer.valueOf(i10 + 1)));
        }

        private final void n(int i10) throws IOException {
            g(-1, new c(f(i10), j()));
        }

        private final void o() throws IOException {
            g(-1, new c(d.f32113a.a(j()), j()));
        }

        private final void p(int i10) throws IOException {
            this.f32118c.add(new c(f(i10), j()));
        }

        private final void q() throws IOException {
            this.f32118c.add(new c(d.f32113a.a(j()), j()));
        }

        @NotNull
        public final List<c> e() {
            List<c> listP0 = d0.P0(this.f32118c);
            this.f32118c.clear();
            return listP0;
        }

        @NotNull
        public final ua.f j() throws IOException {
            int i10 = i();
            boolean z10 = (i10 & 128) == 128;
            long jM = m(i10, 127);
            if (!z10) {
                return this.f32119d.f0(jM);
            }
            ua.c cVar = new ua.c();
            k.f32292a.b(this.f32119d, jM, cVar);
            return cVar.w0();
        }

        public final void k() throws IOException {
            while (!this.f32119d.m0()) {
                int iD = ha.d.d(this.f32119d.readByte(), 255);
                if (iD == 128) {
                    throw new IOException("index == 0");
                }
                if ((iD & 128) == 128) {
                    l(m(iD, 127) - 1);
                } else if (iD == 64) {
                    o();
                } else if ((iD & 64) == 64) {
                    n(m(iD, 63) - 1);
                } else if ((iD & 32) == 32) {
                    int iM = m(iD, 31);
                    this.f32117b = iM;
                    if (iM < 0 || iM > this.f32116a) {
                        throw new IOException(t.r("Invalid dynamic table size update ", Integer.valueOf(this.f32117b)));
                    }
                    a();
                } else if (iD == 16 || iD == 0) {
                    q();
                } else {
                    p(m(iD, 15) - 1);
                }
            }
        }

        public final int m(int i10, int i11) throws IOException {
            int i12 = i10 & i11;
            if (i12 < i11) {
                return i12;
            }
            int i13 = 0;
            while (true) {
                int i14 = i();
                if ((i14 & 128) == 0) {
                    return i11 + (i14 << i13);
                }
                i11 += (i14 & 127) << i13;
                i13 += 7;
            }
        }

        public /* synthetic */ a(z0 z0Var, int i10, int i11, int i12, kotlin.jvm.internal.k kVar) {
            this(z0Var, i10, (i12 & 4) != 0 ? i10 : i11);
        }
    }

    /* JADX INFO: compiled from: Hpack.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f32124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f32125b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final ua.c f32126c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f32127d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f32128e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f32129f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @NotNull
        public c[] f32130g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f32131h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f32132i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f32133j;

        public b(int i10, boolean z10, @NotNull ua.c out) {
            t.i(out, "out");
            this.f32124a = i10;
            this.f32125b = z10;
            this.f32126c = out;
            this.f32127d = Integer.MAX_VALUE;
            this.f32129f = i10;
            this.f32130g = new c[8];
            this.f32131h = r2.length - 1;
        }

        private final void a() {
            int i10 = this.f32129f;
            int i11 = this.f32133j;
            if (i10 < i11) {
                if (i10 == 0) {
                    b();
                } else {
                    c(i11 - i10);
                }
            }
        }

        private final void b() {
            o.v(this.f32130g, null, 0, 0, 6, null);
            this.f32131h = this.f32130g.length - 1;
            this.f32132i = 0;
            this.f32133j = 0;
        }

        private final int c(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f32130g.length;
                while (true) {
                    length--;
                    i11 = this.f32131h;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    c cVar = this.f32130g[length];
                    t.f(cVar);
                    i10 -= cVar.f32112c;
                    int i13 = this.f32133j;
                    c cVar2 = this.f32130g[length];
                    t.f(cVar2);
                    this.f32133j = i13 - cVar2.f32112c;
                    this.f32132i--;
                    i12++;
                }
                c[] cVarArr = this.f32130g;
                System.arraycopy(cVarArr, i11 + 1, cVarArr, i11 + 1 + i12, this.f32132i);
                c[] cVarArr2 = this.f32130g;
                int i14 = this.f32131h;
                Arrays.fill(cVarArr2, i14 + 1, i14 + 1 + i12, (Object) null);
                this.f32131h += i12;
            }
            return i12;
        }

        private final void d(c cVar) {
            int i10 = cVar.f32112c;
            int i11 = this.f32129f;
            if (i10 > i11) {
                b();
                return;
            }
            c((this.f32133j + i10) - i11);
            int i12 = this.f32132i + 1;
            c[] cVarArr = this.f32130g;
            if (i12 > cVarArr.length) {
                c[] cVarArr2 = new c[cVarArr.length * 2];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.f32131h = this.f32130g.length - 1;
                this.f32130g = cVarArr2;
            }
            int i13 = this.f32131h;
            this.f32131h = i13 - 1;
            this.f32130g[i13] = cVar;
            this.f32132i++;
            this.f32133j += i10;
        }

        public final void e(int i10) {
            this.f32124a = i10;
            int iMin = Math.min(i10, 16384);
            int i11 = this.f32129f;
            if (i11 == iMin) {
                return;
            }
            if (iMin < i11) {
                this.f32127d = Math.min(this.f32127d, iMin);
            }
            this.f32128e = true;
            this.f32129f = iMin;
            a();
        }

        public final void f(@NotNull ua.f data) throws IOException {
            t.i(data, "data");
            if (this.f32125b) {
                k kVar = k.f32292a;
                if (kVar.d(data) < data.B()) {
                    ua.c cVar = new ua.c();
                    kVar.c(data, cVar);
                    ua.f fVarW0 = cVar.w0();
                    h(fVarW0.B(), 127, 128);
                    this.f32126c.I(fVarW0);
                    return;
                }
            }
            h(data.B(), 127, 0);
            this.f32126c.I(data);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0081  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void g(@org.jetbrains.annotations.NotNull java.util.List<oa.c> r15) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 272
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: oa.d.b.g(java.util.List):void");
        }

        public final void h(int i10, int i11, int i12) {
            if (i10 < i11) {
                this.f32126c.writeByte(i10 | i12);
                return;
            }
            this.f32126c.writeByte(i12 | i11);
            int i13 = i10 - i11;
            while (i13 >= 128) {
                this.f32126c.writeByte(128 | (i13 & 127));
                i13 >>>= 7;
            }
            this.f32126c.writeByte(i13);
        }

        public /* synthetic */ b(int i10, boolean z10, ua.c cVar, int i11, kotlin.jvm.internal.k kVar) {
            this((i11 & 1) != 0 ? 4096 : i10, (i11 & 2) != 0 ? true : z10, cVar);
        }
    }
}
