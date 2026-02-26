package y2;

import a4.c0;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.MimeTypes;
import com.google.common.collect.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import k2.j2;
import k2.o1;
import p2.h0;
import y2.i;

/* JADX INFO: compiled from: VorbisReader.java */
/* JADX INFO: loaded from: classes2.dex */
final class j extends i {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private a f36491n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f36492o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f36493p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private h0.d f36494q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    private h0.b f36495r;

    /* JADX INFO: compiled from: VorbisReader.java */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h0.d f36496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h0.b f36497b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f36498c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final h0.c[] f36499d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f36500e;

        public a(h0.d dVar, h0.b bVar, byte[] bArr, h0.c[] cVarArr, int i10) {
            this.f36496a = dVar;
            this.f36497b = bVar;
            this.f36498c = bArr;
            this.f36499d = cVarArr;
            this.f36500e = i10;
        }
    }

    j() {
    }

    @VisibleForTesting
    static void n(c0 c0Var, long j10) {
        if (c0Var.b() < c0Var.f() + 4) {
            c0Var.M(Arrays.copyOf(c0Var.d(), c0Var.f() + 4));
        } else {
            c0Var.O(c0Var.f() + 4);
        }
        byte[] bArrD = c0Var.d();
        bArrD[c0Var.f() - 4] = (byte) (j10 & 255);
        bArrD[c0Var.f() - 3] = (byte) ((j10 >>> 8) & 255);
        bArrD[c0Var.f() - 2] = (byte) ((j10 >>> 16) & 255);
        bArrD[c0Var.f() - 1] = (byte) ((j10 >>> 24) & 255);
    }

    private static int o(byte b10, a aVar) {
        return !aVar.f36499d[p(b10, aVar.f36500e, 1)].f32494a ? aVar.f36496a.f32504g : aVar.f36496a.f32505h;
    }

    @VisibleForTesting
    static int p(byte b10, int i10, int i11) {
        return (b10 >> i11) & (255 >>> (8 - i10));
    }

    public static boolean r(c0 c0Var) {
        try {
            return h0.m(1, c0Var, true);
        } catch (j2 unused) {
            return false;
        }
    }

    @Override // y2.i
    protected void e(long j10) {
        super.e(j10);
        this.f36493p = j10 != 0;
        h0.d dVar = this.f36494q;
        this.f36492o = dVar != null ? dVar.f32504g : 0;
    }

    @Override // y2.i
    protected long f(c0 c0Var) {
        if ((c0Var.d()[0] & 1) == 1) {
            return -1L;
        }
        int iO = o(c0Var.d()[0], (a) a4.a.i(this.f36491n));
        long j10 = this.f36493p ? (this.f36492o + iO) / 4 : 0;
        n(c0Var, j10);
        this.f36493p = true;
        this.f36492o = iO;
        return j10;
    }

    @Override // y2.i
    protected boolean h(c0 c0Var, long j10, i.b bVar) throws IOException {
        if (this.f36491n != null) {
            a4.a.e(bVar.f36489a);
            return false;
        }
        a aVarQ = q(c0Var);
        this.f36491n = aVarQ;
        if (aVarQ == null) {
            return true;
        }
        h0.d dVar = aVarQ.f36496a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar.f32507j);
        arrayList.add(aVarQ.f36498c);
        bVar.f36489a = new o1.b().e0(MimeTypes.AUDIO_VORBIS).G(dVar.f32502e).Z(dVar.f32501d).H(dVar.f32499b).f0(dVar.f32500c).T(arrayList).X(h0.c(y.n(aVarQ.f36497b.f32492b))).E();
        return true;
    }

    @Override // y2.i
    protected void l(boolean z10) {
        super.l(z10);
        if (z10) {
            this.f36491n = null;
            this.f36494q = null;
            this.f36495r = null;
        }
        this.f36492o = 0;
        this.f36493p = false;
    }

    @Nullable
    @VisibleForTesting
    a q(c0 c0Var) throws IOException {
        h0.d dVar = this.f36494q;
        if (dVar == null) {
            this.f36494q = h0.k(c0Var);
            return null;
        }
        h0.b bVar = this.f36495r;
        if (bVar == null) {
            this.f36495r = h0.i(c0Var);
            return null;
        }
        byte[] bArr = new byte[c0Var.f()];
        System.arraycopy(c0Var.d(), 0, bArr, 0, c0Var.f());
        return new a(dVar, bVar, bArr, h0.l(c0Var, dVar.f32499b), h0.a(r4.length - 1));
    }
}
