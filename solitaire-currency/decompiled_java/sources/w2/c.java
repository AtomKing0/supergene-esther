package w2;

import a4.o0;
import android.util.Pair;
import androidx.media3.common.C;
import h3.k;
import p2.b0;
import p2.c0;

/* JADX INFO: compiled from: MlltSeeker.java */
/* JADX INFO: loaded from: classes2.dex */
final class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long[] f35332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f35333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f35334c;

    private c(long[] jArr, long[] jArr2, long j10) {
        this.f35332a = jArr;
        this.f35333b = jArr2;
        this.f35334c = j10 == C.TIME_UNSET ? o0.w0(jArr2[jArr2.length - 1]) : j10;
    }

    public static c a(long j10, k kVar, long j11) {
        int length = kVar.f26458e.length;
        int i10 = length + 1;
        long[] jArr = new long[i10];
        long[] jArr2 = new long[i10];
        jArr[0] = j10;
        long j12 = 0;
        jArr2[0] = 0;
        for (int i11 = 1; i11 <= length; i11++) {
            int i12 = i11 - 1;
            j10 += (long) (kVar.f26456c + kVar.f26458e[i12]);
            j12 += (long) (kVar.f26457d + kVar.f26459f[i12]);
            jArr[i11] = j10;
            jArr2[i11] = j12;
        }
        return new c(jArr, jArr2, j11);
    }

    private static Pair<Long, Long> b(long j10, long[] jArr, long[] jArr2) {
        int i10 = o0.i(jArr, j10, true, true);
        long j11 = jArr[i10];
        long j12 = jArr2[i10];
        int i11 = i10 + 1;
        if (i11 == jArr.length) {
            return Pair.create(Long.valueOf(j11), Long.valueOf(j12));
        }
        return Pair.create(Long.valueOf(j10), Long.valueOf(((long) ((jArr[i11] == j11 ? 0.0d : (j10 - j11) / (r6 - j11)) * (jArr2[i11] - j12))) + j12));
    }

    @Override // w2.g
    public long getDataEndPosition() {
        return -1L;
    }

    @Override // p2.b0
    public long getDurationUs() {
        return this.f35334c;
    }

    @Override // p2.b0
    public b0.a getSeekPoints(long j10) {
        Pair<Long, Long> pairB = b(o0.P0(o0.q(j10, 0L, this.f35334c)), this.f35333b, this.f35332a);
        return new b0.a(new c0(o0.w0(((Long) pairB.first).longValue()), ((Long) pairB.second).longValue()));
    }

    @Override // w2.g
    public long getTimeUs(long j10) {
        return o0.w0(((Long) b(j10, this.f35332a, this.f35333b).second).longValue());
    }

    @Override // p2.b0
    public boolean isSeekable() {
        return true;
    }
}
