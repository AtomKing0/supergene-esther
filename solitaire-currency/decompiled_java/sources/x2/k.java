package x2;

import a4.c0;
import a4.o0;
import a4.y;
import android.net.Uri;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.mp4.Atom;
import c3.a;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import k2.j2;
import k2.o1;
import p2.a0;
import p2.b0;
import p2.e0;
import p2.f0;
import p2.x;
import x2.a;

/* JADX INFO: compiled from: Mp4Extractor.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k implements p2.l, b0 {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final p2.r f35816y = new p2.r() { // from class: x2.i
        @Override // p2.r
        public final p2.l[] createExtractors() {
            return k.m();
        }

        @Override // p2.r
        public /* synthetic */ p2.l[] createExtractors(Uri uri, Map map) {
            return p2.q.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f35817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c0 f35818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c0 f35819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c0 f35820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c0 f35821e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayDeque<a.C0730a> f35822f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final m f35823g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<a.b> f35824h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f35825i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f35826j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f35827k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f35828l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private c0 f35829m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f35830n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f35831o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f35832p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f35833q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private p2.n f35834r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private a[] f35835s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long[][] f35836t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f35837u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f35838v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f35839w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    private i3.b f35840x;

    /* JADX INFO: compiled from: Mp4Extractor.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o f35841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final r f35842b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e0 f35843c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final f0 f35844d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f35845e;

        public a(o oVar, r rVar, e0 e0Var) {
            this.f35841a = oVar;
            this.f35842b = rVar;
            this.f35843c = e0Var;
            this.f35844d = MimeTypes.AUDIO_TRUEHD.equals(oVar.f35863f.f29347l) ? new f0() : null;
        }
    }

    public k() {
        this(0);
    }

    private void A(a aVar, long j10) {
        r rVar = aVar.f35842b;
        int iA = rVar.a(j10);
        if (iA == -1) {
            iA = rVar.b(j10);
        }
        aVar.f35845e = iA;
    }

    private static int f(int i10) {
        if (i10 != 1751476579) {
            return i10 != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private static long[][] g(a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        int[] iArr = new int[aVarArr.length];
        long[] jArr2 = new long[aVarArr.length];
        boolean[] zArr = new boolean[aVarArr.length];
        for (int i10 = 0; i10 < aVarArr.length; i10++) {
            jArr[i10] = new long[aVarArr[i10].f35842b.f35893b];
            jArr2[i10] = aVarArr[i10].f35842b.f35897f[0];
        }
        long j10 = 0;
        int i11 = 0;
        while (i11 < aVarArr.length) {
            long j11 = Long.MAX_VALUE;
            int i12 = -1;
            for (int i13 = 0; i13 < aVarArr.length; i13++) {
                if (!zArr[i13]) {
                    long j12 = jArr2[i13];
                    if (j12 <= j11) {
                        i12 = i13;
                        j11 = j12;
                    }
                }
            }
            int i14 = iArr[i12];
            long[] jArr3 = jArr[i12];
            jArr3[i14] = j10;
            r rVar = aVarArr[i12].f35842b;
            j10 += (long) rVar.f35895d[i14];
            int i15 = i14 + 1;
            iArr[i12] = i15;
            if (i15 < jArr3.length) {
                jArr2[i12] = rVar.f35897f[i15];
            } else {
                zArr[i12] = true;
                i11++;
            }
        }
        return jArr;
    }

    private void h() {
        this.f35825i = 0;
        this.f35828l = 0;
    }

    private static int j(r rVar, long j10) {
        int iA = rVar.a(j10);
        return iA == -1 ? rVar.b(j10) : iA;
    }

    private int k(long j10) {
        int i10 = -1;
        int i11 = -1;
        int i12 = 0;
        long j11 = Long.MAX_VALUE;
        boolean z10 = true;
        long j12 = Long.MAX_VALUE;
        boolean z11 = true;
        long j13 = Long.MAX_VALUE;
        while (true) {
            a[] aVarArr = this.f35835s;
            if (i12 >= aVarArr.length) {
                break;
            }
            a aVar = aVarArr[i12];
            int i13 = aVar.f35845e;
            r rVar = aVar.f35842b;
            if (i13 != rVar.f35893b) {
                long j14 = rVar.f35894c[i13];
                long j15 = ((long[][]) o0.j(this.f35836t))[i12][i13];
                long j16 = j14 - j10;
                boolean z12 = j16 < 0 || j16 >= 262144;
                if ((!z12 && z11) || (z12 == z11 && j16 < j13)) {
                    z11 = z12;
                    j13 = j16;
                    i11 = i12;
                    j12 = j15;
                }
                if (j15 < j11) {
                    z10 = z12;
                    i10 = i12;
                    j11 = j15;
                }
            }
            i12++;
        }
        return (j11 == Long.MAX_VALUE || !z10 || j12 < j11 + 10485760) ? i11 : i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ p2.l[] m() {
        return new p2.l[]{new k()};
    }

    private static long n(r rVar, long j10, long j11) {
        int iJ = j(rVar, j10);
        return iJ == -1 ? j11 : Math.min(rVar.f35894c[iJ], j11);
    }

    private void o(p2.m mVar) throws IOException {
        this.f35820d.L(8);
        mVar.peekFully(this.f35820d.d(), 0, 8);
        b.e(this.f35820d);
        mVar.skipFully(this.f35820d.e());
        mVar.resetPeekPosition();
    }

    private void p(long j10) throws j2 {
        while (!this.f35822f.isEmpty() && this.f35822f.peek().f35730b == j10) {
            a.C0730a c0730aPop = this.f35822f.pop();
            if (c0730aPop.f35729a == 1836019574) {
                s(c0730aPop);
                this.f35822f.clear();
                this.f35825i = 2;
            } else if (!this.f35822f.isEmpty()) {
                this.f35822f.peek().d(c0730aPop);
            }
        }
        if (this.f35825i != 2) {
            h();
        }
    }

    private void q() {
        if (this.f35839w != 2 || (this.f35817a & 2) == 0) {
            return;
        }
        this.f35834r.track(0, 4).f(new o1.b().X(this.f35840x == null ? null : new c3.a(this.f35840x)).E());
        this.f35834r.endTracks();
        this.f35834r.h(new b0.b(C.TIME_UNSET));
    }

    private static int r(c0 c0Var) {
        c0Var.P(8);
        int iF = f(c0Var.n());
        if (iF != 0) {
            return iF;
        }
        c0Var.Q(4);
        while (c0Var.a() > 0) {
            int iF2 = f(c0Var.n());
            if (iF2 != 0) {
                return iF2;
            }
        }
        return 0;
    }

    private void s(a.C0730a c0730a) throws j2 {
        c3.a aVar;
        c3.a aVar2;
        List<r> list;
        int i10;
        int i11;
        ArrayList arrayList = new ArrayList();
        boolean z10 = this.f35839w == 1;
        x xVar = new x();
        a.b bVarG = c0730a.g(Atom.TYPE_udta);
        if (bVarG != null) {
            Pair<c3.a, c3.a> pairB = b.B(bVarG);
            c3.a aVar3 = (c3.a) pairB.first;
            c3.a aVar4 = (c3.a) pairB.second;
            if (aVar3 != null) {
                xVar.c(aVar3);
            }
            aVar = aVar4;
            aVar2 = aVar3;
        } else {
            aVar = null;
            aVar2 = null;
        }
        a.C0730a c0730aF = c0730a.f(Atom.TYPE_meta);
        c3.a aVarN = c0730aF != null ? b.n(c0730aF) : null;
        List<r> listA = b.A(c0730a, xVar, C.TIME_UNSET, null, (this.f35817a & 1) != 0, z10, new e5.g() { // from class: x2.j
            @Override // e5.g
            public final Object apply(Object obj) {
                return k.l((o) obj);
            }
        });
        int size = listA.size();
        long j10 = C.TIME_UNSET;
        long j11 = -9223372036854775807L;
        int i12 = 0;
        int size2 = -1;
        while (i12 < size) {
            r rVar = listA.get(i12);
            if (rVar.f35893b == 0) {
                list = listA;
                i10 = size;
            } else {
                o oVar = rVar.f35892a;
                list = listA;
                i10 = size;
                long j12 = oVar.f35862e;
                if (j12 == j10) {
                    j12 = rVar.f35899h;
                }
                long jMax = Math.max(j11, j12);
                a aVar5 = new a(oVar, rVar, this.f35834r.track(i12, oVar.f35859b));
                int i13 = MimeTypes.AUDIO_TRUEHD.equals(oVar.f35863f.f29347l) ? rVar.f35896e * 16 : rVar.f35896e + 30;
                o1.b bVarB = oVar.f35863f.b();
                bVarB.W(i13);
                if (oVar.f35859b == 2 && j12 > 0 && (i11 = rVar.f35893b) > 1) {
                    bVarB.P(i11 / (j12 / 1000000.0f));
                }
                h.k(oVar.f35859b, xVar, bVarB);
                int i14 = oVar.f35859b;
                c3.a[] aVarArr = new c3.a[2];
                aVarArr[0] = aVar;
                aVarArr[1] = this.f35824h.isEmpty() ? null : new c3.a(this.f35824h);
                h.l(i14, aVar2, aVarN, bVarB, aVarArr);
                aVar5.f35843c.f(bVarB.E());
                if (oVar.f35859b == 2 && size2 == -1) {
                    size2 = arrayList.size();
                }
                arrayList.add(aVar5);
                j11 = jMax;
            }
            i12++;
            listA = list;
            size = i10;
            j10 = C.TIME_UNSET;
        }
        this.f35837u = size2;
        this.f35838v = j11;
        a[] aVarArr2 = (a[]) arrayList.toArray(new a[0]);
        this.f35835s = aVarArr2;
        this.f35836t = g(aVarArr2);
        this.f35834r.endTracks();
        this.f35834r.h(this);
    }

    private void t(long j10) {
        if (this.f35826j == 1836086884) {
            int i10 = this.f35828l;
            this.f35840x = new i3.b(0L, j10, C.TIME_UNSET, j10 + ((long) i10), this.f35827k - ((long) i10));
        }
    }

    private boolean u(p2.m mVar) throws IOException {
        a.C0730a c0730aPeek;
        if (this.f35828l == 0) {
            if (!mVar.readFully(this.f35821e.d(), 0, 8, true)) {
                q();
                return false;
            }
            this.f35828l = 8;
            this.f35821e.P(0);
            this.f35827k = this.f35821e.F();
            this.f35826j = this.f35821e.n();
        }
        long j10 = this.f35827k;
        if (j10 == 1) {
            mVar.readFully(this.f35821e.d(), 8, 8);
            this.f35828l += 8;
            this.f35827k = this.f35821e.I();
        } else if (j10 == 0) {
            long length = mVar.getLength();
            if (length == -1 && (c0730aPeek = this.f35822f.peek()) != null) {
                length = c0730aPeek.f35730b;
            }
            if (length != -1) {
                this.f35827k = (length - mVar.getPosition()) + ((long) this.f35828l);
            }
        }
        if (this.f35827k < this.f35828l) {
            throw j2.c("Atom size less than header length (unsupported).");
        }
        if (y(this.f35826j)) {
            long position = mVar.getPosition();
            long j11 = this.f35827k;
            int i10 = this.f35828l;
            long j12 = (position + j11) - ((long) i10);
            if (j11 != i10 && this.f35826j == 1835365473) {
                o(mVar);
            }
            this.f35822f.push(new a.C0730a(this.f35826j, j12));
            if (this.f35827k == this.f35828l) {
                p(j12);
            } else {
                h();
            }
        } else if (z(this.f35826j)) {
            a4.a.g(this.f35828l == 8);
            a4.a.g(this.f35827k <= 2147483647L);
            c0 c0Var = new c0((int) this.f35827k);
            System.arraycopy(this.f35821e.d(), 0, c0Var.d(), 0, 8);
            this.f35829m = c0Var;
            this.f35825i = 1;
        } else {
            t(mVar.getPosition() - ((long) this.f35828l));
            this.f35829m = null;
            this.f35825i = 1;
        }
        return true;
    }

    private boolean v(p2.m mVar, a0 a0Var) throws IOException {
        boolean z10;
        long j10 = this.f35827k - ((long) this.f35828l);
        long position = mVar.getPosition() + j10;
        c0 c0Var = this.f35829m;
        if (c0Var != null) {
            mVar.readFully(c0Var.d(), this.f35828l, (int) j10);
            if (this.f35826j == 1718909296) {
                this.f35839w = r(c0Var);
            } else if (!this.f35822f.isEmpty()) {
                this.f35822f.peek().e(new a.b(this.f35826j, c0Var));
            }
        } else {
            if (j10 >= 262144) {
                a0Var.f32443a = mVar.getPosition() + j10;
                z10 = true;
                p(position);
                return (z10 || this.f35825i == 2) ? false : true;
            }
            mVar.skipFully((int) j10);
        }
        z10 = false;
        p(position);
        if (z10) {
        }
    }

    private int w(p2.m mVar, a0 a0Var) throws IOException {
        int i10;
        a0 a0Var2;
        long position = mVar.getPosition();
        if (this.f35830n == -1) {
            int iK = k(position);
            this.f35830n = iK;
            if (iK == -1) {
                return -1;
            }
        }
        a aVar = this.f35835s[this.f35830n];
        e0 e0Var = aVar.f35843c;
        int i11 = aVar.f35845e;
        r rVar = aVar.f35842b;
        long j10 = rVar.f35894c[i11];
        int i12 = rVar.f35895d[i11];
        f0 f0Var = aVar.f35844d;
        long j11 = (j10 - position) + ((long) this.f35831o);
        if (j11 < 0) {
            i10 = 1;
            a0Var2 = a0Var;
        } else {
            if (j11 < 262144) {
                if (aVar.f35841a.f35864g == 1) {
                    j11 += 8;
                    i12 -= 8;
                }
                mVar.skipFully((int) j11);
                o oVar = aVar.f35841a;
                if (oVar.f35867j == 0) {
                    if (MimeTypes.AUDIO_AC4.equals(oVar.f35863f.f29347l)) {
                        if (this.f35832p == 0) {
                            m2.c.a(i12, this.f35820d);
                            e0Var.e(this.f35820d, 7);
                            this.f35832p += 7;
                        }
                        i12 += 7;
                    } else if (f0Var != null) {
                        f0Var.d(mVar);
                    }
                    while (true) {
                        int i13 = this.f35832p;
                        if (i13 >= i12) {
                            break;
                        }
                        int iC = e0Var.c(mVar, i12 - i13, false);
                        this.f35831o += iC;
                        this.f35832p += iC;
                        this.f35833q -= iC;
                    }
                } else {
                    byte[] bArrD = this.f35819c.d();
                    bArrD[0] = 0;
                    bArrD[1] = 0;
                    bArrD[2] = 0;
                    int i14 = aVar.f35841a.f35867j;
                    int i15 = 4 - i14;
                    while (this.f35832p < i12) {
                        int i16 = this.f35833q;
                        if (i16 == 0) {
                            mVar.readFully(bArrD, i15, i14);
                            this.f35831o += i14;
                            this.f35819c.P(0);
                            int iN = this.f35819c.n();
                            if (iN < 0) {
                                throw j2.a("Invalid NAL length", null);
                            }
                            this.f35833q = iN;
                            this.f35818b.P(0);
                            e0Var.e(this.f35818b, 4);
                            this.f35832p += 4;
                            i12 += i15;
                        } else {
                            int iC2 = e0Var.c(mVar, i16, false);
                            this.f35831o += iC2;
                            this.f35832p += iC2;
                            this.f35833q -= iC2;
                        }
                    }
                }
                int i17 = i12;
                r rVar2 = aVar.f35842b;
                long j12 = rVar2.f35897f[i11];
                int i18 = rVar2.f35898g[i11];
                if (f0Var != null) {
                    f0Var.c(e0Var, j12, i18, i17, 0, null);
                    if (i11 + 1 == aVar.f35842b.f35893b) {
                        f0Var.a(e0Var, null);
                    }
                } else {
                    e0Var.a(j12, i18, i17, 0, null);
                }
                aVar.f35845e++;
                this.f35830n = -1;
                this.f35831o = 0;
                this.f35832p = 0;
                this.f35833q = 0;
                return 0;
            }
            a0Var2 = a0Var;
            i10 = 1;
        }
        a0Var2.f32443a = j10;
        return i10;
    }

    private int x(p2.m mVar, a0 a0Var) throws IOException {
        int iC = this.f35823g.c(mVar, a0Var, this.f35824h);
        if (iC == 1 && a0Var.f32443a == 0) {
            h();
        }
        return iC;
    }

    private static boolean y(int i10) {
        return i10 == 1836019574 || i10 == 1953653099 || i10 == 1835297121 || i10 == 1835626086 || i10 == 1937007212 || i10 == 1701082227 || i10 == 1835365473;
    }

    private static boolean z(int i10) {
        return i10 == 1835296868 || i10 == 1836476516 || i10 == 1751411826 || i10 == 1937011556 || i10 == 1937011827 || i10 == 1937011571 || i10 == 1668576371 || i10 == 1701606260 || i10 == 1937011555 || i10 == 1937011578 || i10 == 1937013298 || i10 == 1937007471 || i10 == 1668232756 || i10 == 1953196132 || i10 == 1718909296 || i10 == 1969517665 || i10 == 1801812339 || i10 == 1768715124;
    }

    @Override // p2.l
    public int a(p2.m mVar, a0 a0Var) throws IOException {
        while (true) {
            int i10 = this.f35825i;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        return w(mVar, a0Var);
                    }
                    if (i10 == 3) {
                        return x(mVar, a0Var);
                    }
                    throw new IllegalStateException();
                }
                if (v(mVar, a0Var)) {
                    return 1;
                }
            } else if (!u(mVar)) {
                return -1;
            }
        }
    }

    @Override // p2.l
    public void b(p2.n nVar) {
        this.f35834r = nVar;
    }

    @Override // p2.l
    public boolean c(p2.m mVar) throws IOException {
        return n.d(mVar, (this.f35817a & 2) != 0);
    }

    @Override // p2.b0
    public long getDurationUs() {
        return this.f35838v;
    }

    @Override // p2.b0
    public b0.a getSeekPoints(long j10) {
        return i(j10, -1);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public p2.b0.a i(long r17, int r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r19
            x2.k$a[] r4 = r0.f35835s
            int r5 = r4.length
            if (r5 != 0) goto L13
            p2.b0$a r1 = new p2.b0$a
            p2.c0 r2 = p2.c0.f32448c
            r1.<init>(r2)
            return r1
        L13:
            r5 = -1
            if (r3 == r5) goto L18
            r6 = r3
            goto L1a
        L18:
            int r6 = r0.f35837u
        L1a:
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r9 = -1
            if (r6 == r5) goto L58
            r4 = r4[r6]
            x2.r r4 = r4.f35842b
            int r6 = j(r4, r1)
            if (r6 != r5) goto L35
            p2.b0$a r1 = new p2.b0$a
            p2.c0 r2 = p2.c0.f32448c
            r1.<init>(r2)
            return r1
        L35:
            long[] r11 = r4.f35897f
            r12 = r11[r6]
            long[] r11 = r4.f35894c
            r14 = r11[r6]
            int r11 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r11 >= 0) goto L5e
            int r11 = r4.f35893b
            int r11 = r11 + (-1)
            if (r6 >= r11) goto L5e
            int r1 = r4.b(r1)
            if (r1 == r5) goto L5e
            if (r1 == r6) goto L5e
            long[] r2 = r4.f35897f
            r9 = r2[r1]
            long[] r2 = r4.f35894c
            r1 = r2[r1]
            goto L60
        L58:
            r14 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r12 = r1
        L5e:
            r1 = r9
            r9 = r7
        L60:
            if (r3 != r5) goto L7f
            r3 = 0
        L63:
            x2.k$a[] r4 = r0.f35835s
            int r5 = r4.length
            if (r3 >= r5) goto L7f
            int r5 = r0.f35837u
            if (r3 == r5) goto L7c
            r4 = r4[r3]
            x2.r r4 = r4.f35842b
            long r14 = n(r4, r12, r14)
            int r5 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r5 == 0) goto L7c
            long r1 = n(r4, r9, r1)
        L7c:
            int r3 = r3 + 1
            goto L63
        L7f:
            p2.c0 r3 = new p2.c0
            r3.<init>(r12, r14)
            int r4 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r4 != 0) goto L8e
            p2.b0$a r1 = new p2.b0$a
            r1.<init>(r3)
            return r1
        L8e:
            p2.c0 r4 = new p2.c0
            r4.<init>(r9, r1)
            p2.b0$a r1 = new p2.b0$a
            r1.<init>(r3, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.k.i(long, int):p2.b0$a");
    }

    @Override // p2.b0
    public boolean isSeekable() {
        return true;
    }

    @Override // p2.l
    public void seek(long j10, long j11) {
        this.f35822f.clear();
        this.f35828l = 0;
        this.f35830n = -1;
        this.f35831o = 0;
        this.f35832p = 0;
        this.f35833q = 0;
        if (j10 == 0) {
            if (this.f35825i != 3) {
                h();
                return;
            } else {
                this.f35823g.g();
                this.f35824h.clear();
                return;
            }
        }
        for (a aVar : this.f35835s) {
            A(aVar, j11);
            f0 f0Var = aVar.f35844d;
            if (f0Var != null) {
                f0Var.b();
            }
        }
    }

    public k(int i10) {
        this.f35817a = i10;
        this.f35825i = (i10 & 4) != 0 ? 3 : 0;
        this.f35823g = new m();
        this.f35824h = new ArrayList();
        this.f35821e = new c0(16);
        this.f35822f = new ArrayDeque<>();
        this.f35818b = new c0(y.f258a);
        this.f35819c = new c0(4);
        this.f35820d = new c0();
        this.f35830n = -1;
        this.f35834r = p2.n.P7;
        this.f35835s = new a[0];
    }

    @Override // p2.l
    public void release() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o l(o oVar) {
        return oVar;
    }
}
