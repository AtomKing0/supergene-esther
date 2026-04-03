package z2;

import a4.l0;
import a4.o0;
import androidx.media3.common.C;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import androidx.media3.extractor.ts.TsExtractor;
import java.io.IOException;
import p2.a;

/* JADX INFO: compiled from: TsBinarySearchSeeker.java */
/* JADX INFO: loaded from: classes2.dex */
final class e0 extends p2.a {

    /* JADX INFO: compiled from: TsBinarySearchSeeker.java */
    private static final class a implements a.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final l0 f37048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a4.c0 f37049b = new a4.c0();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f37050c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f37051d;

        public a(int i10, l0 l0Var, int i11) {
            this.f37050c = i10;
            this.f37048a = l0Var;
            this.f37051d = i11;
        }

        private a.e b(a4.c0 c0Var, long j10, long j11) {
            int iA;
            int iA2;
            int iF = c0Var.f();
            long j12 = -1;
            long j13 = -1;
            long j14 = -9223372036854775807L;
            while (c0Var.a() >= 188 && (iA2 = (iA = j0.a(c0Var.d(), c0Var.e(), iF)) + TsExtractor.TS_PACKET_SIZE) <= iF) {
                long jC = j0.c(c0Var, iA, this.f37050c);
                if (jC != C.TIME_UNSET) {
                    long jB = this.f37048a.b(jC);
                    if (jB > j10) {
                        return j14 == C.TIME_UNSET ? a.e.d(jB, j11) : a.e.e(j11 + j13);
                    }
                    if (SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US + jB > j10) {
                        return a.e.e(j11 + ((long) iA));
                    }
                    j13 = iA;
                    j14 = jB;
                }
                c0Var.P(iA2);
                j12 = iA2;
            }
            return j14 != C.TIME_UNSET ? a.e.f(j14, j11 + j12) : a.e.f32439d;
        }

        @Override // p2.a.f
        public a.e a(p2.m mVar, long j10) throws IOException {
            long position = mVar.getPosition();
            int iMin = (int) Math.min(this.f37051d, mVar.getLength() - position);
            this.f37049b.L(iMin);
            mVar.peekFully(this.f37049b.d(), 0, iMin);
            return b(this.f37049b, j10, position);
        }

        @Override // p2.a.f
        public void onSeekFinished() {
            this.f37049b.M(o0.f219f);
        }
    }

    public e0(l0 l0Var, long j10, long j11, int i10, int i11) {
        super(new a.b(), new a(i10, l0Var, i11), j10, 0L, j10 + 1, 0L, j11, 188L, 940);
    }
}
