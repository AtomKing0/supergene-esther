package q2;

import a4.o0;
import android.net.Uri;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import k2.j2;
import k2.o1;
import p2.a0;
import p2.b0;
import p2.e;
import p2.e0;
import p2.l;
import p2.m;
import p2.n;
import p2.q;
import p2.r;

/* JADX INFO: compiled from: AmrExtractor.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements l {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int[] f33131r;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f33134u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f33135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f33136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f33137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f33138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f33139e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f33140f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f33141g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f33142h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f33143i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f33144j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f33145k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private n f33146l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private e0 f33147m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private b0 f33148n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f33149o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final r f33129p = new r() { // from class: q2.a
        @Override // p2.r
        public final l[] createExtractors() {
            return b.l();
        }

        @Override // p2.r
        public /* synthetic */ l[] createExtractors(Uri uri, Map map) {
            return q.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int[] f33130q = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final byte[] f33132s = o0.h0("#!AMR\n");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final byte[] f33133t = o0.h0("#!AMR-WB\n");

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        f33131r = iArr;
        f33134u = iArr[8];
    }

    public b() {
        this(0);
    }

    private void e() {
        a4.a.i(this.f33147m);
        o0.j(this.f33146l);
    }

    private static int f(int i10, long j10) {
        return (int) (((((long) i10) * 8) * 1000000) / j10);
    }

    private b0 g(long j10, boolean z10) {
        return new e(j10, this.f33142h, f(this.f33143i, 20000L), this.f33143i, z10);
    }

    private int h(int i10) throws j2 {
        if (j(i10)) {
            return this.f33137c ? f33131r[i10] : f33130q[i10];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Illegal AMR ");
        sb.append(this.f33137c ? "WB" : "NB");
        sb.append(" frame type ");
        sb.append(i10);
        throw j2.a(sb.toString(), null);
    }

    private boolean i(int i10) {
        return !this.f33137c && (i10 < 12 || i10 > 14);
    }

    private boolean j(int i10) {
        return i10 >= 0 && i10 <= 15 && (k(i10) || i(i10));
    }

    private boolean k(int i10) {
        return this.f33137c && (i10 < 10 || i10 > 13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] l() {
        return new l[]{new b()};
    }

    private void m() {
        if (this.f33149o) {
            return;
        }
        this.f33149o = true;
        boolean z10 = this.f33137c;
        this.f33147m.f(new o1.b().e0(z10 ? MimeTypes.AUDIO_AMR_WB : MimeTypes.AUDIO_AMR_NB).W(f33134u).H(1).f0(z10 ? 16000 : 8000).E());
    }

    private void n(long j10, int i10) {
        int i11;
        if (this.f33141g) {
            return;
        }
        int i12 = this.f33136b;
        if ((i12 & 1) == 0 || j10 == -1 || !((i11 = this.f33143i) == -1 || i11 == this.f33139e)) {
            b0.b bVar = new b0.b(C.TIME_UNSET);
            this.f33148n = bVar;
            this.f33146l.h(bVar);
            this.f33141g = true;
            return;
        }
        if (this.f33144j >= 20 || i10 == -1) {
            b0 b0VarG = g(j10, (i12 & 2) != 0);
            this.f33148n = b0VarG;
            this.f33146l.h(b0VarG);
            this.f33141g = true;
        }
    }

    private static boolean o(m mVar, byte[] bArr) throws IOException {
        mVar.resetPeekPosition();
        byte[] bArr2 = new byte[bArr.length];
        mVar.peekFully(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    private int p(m mVar) throws IOException {
        mVar.resetPeekPosition();
        mVar.peekFully(this.f33135a, 0, 1);
        byte b10 = this.f33135a[0];
        if ((b10 & 131) <= 0) {
            return h((b10 >> 3) & 15);
        }
        throw j2.a("Invalid padding bits for frame header " + ((int) b10), null);
    }

    private boolean q(m mVar) throws IOException {
        byte[] bArr = f33132s;
        if (o(mVar, bArr)) {
            this.f33137c = false;
            mVar.skipFully(bArr.length);
            return true;
        }
        byte[] bArr2 = f33133t;
        if (!o(mVar, bArr2)) {
            return false;
        }
        this.f33137c = true;
        mVar.skipFully(bArr2.length);
        return true;
    }

    private int r(m mVar) throws IOException {
        if (this.f33140f == 0) {
            try {
                int iP = p(mVar);
                this.f33139e = iP;
                this.f33140f = iP;
                if (this.f33143i == -1) {
                    this.f33142h = mVar.getPosition();
                    this.f33143i = this.f33139e;
                }
                if (this.f33143i == this.f33139e) {
                    this.f33144j++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int iC = this.f33147m.c(mVar, this.f33140f, true);
        if (iC == -1) {
            return -1;
        }
        int i10 = this.f33140f - iC;
        this.f33140f = i10;
        if (i10 > 0) {
            return 0;
        }
        this.f33147m.a(this.f33145k + this.f33138d, 1, this.f33139e, 0, null);
        this.f33138d += 20000;
        return 0;
    }

    @Override // p2.l
    public int a(m mVar, a0 a0Var) throws IOException {
        e();
        if (mVar.getPosition() == 0 && !q(mVar)) {
            throw j2.a("Could not find AMR header.", null);
        }
        m();
        int iR = r(mVar);
        n(mVar.getLength(), iR);
        return iR;
    }

    @Override // p2.l
    public void b(n nVar) {
        this.f33146l = nVar;
        this.f33147m = nVar.track(0, 1);
        nVar.endTracks();
    }

    @Override // p2.l
    public boolean c(m mVar) throws IOException {
        return q(mVar);
    }

    @Override // p2.l
    public void seek(long j10, long j11) {
        this.f33138d = 0L;
        this.f33139e = 0;
        this.f33140f = 0;
        if (j10 != 0) {
            b0 b0Var = this.f33148n;
            if (b0Var instanceof e) {
                this.f33145k = ((e) b0Var).b(j10);
                return;
            }
        }
        this.f33145k = 0L;
    }

    public b(int i10) {
        this.f33136b = (i10 & 2) != 0 ? i10 | 1 : i10;
        this.f33135a = new byte[1];
        this.f33143i = -1;
    }

    @Override // p2.l
    public void release() {
    }
}
