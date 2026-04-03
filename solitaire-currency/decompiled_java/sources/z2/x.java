package z2;

import a4.l0;
import a4.o0;
import androidx.media3.common.C;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import java.io.IOException;
import p2.a;

/* JADX INFO: compiled from: PsBinarySearchSeeker.java */
/* JADX INFO: loaded from: classes2.dex */
final class x extends p2.a {

    /* JADX INFO: compiled from: PsBinarySearchSeeker.java */
    private static final class b implements a.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final l0 f37352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a4.c0 f37353b;

        private a.e b(a4.c0 c0Var, long j10, long j11) {
            int iE = -1;
            int iE2 = -1;
            long j12 = -9223372036854775807L;
            while (c0Var.a() >= 4) {
                if (x.k(c0Var.d(), c0Var.e()) != 442) {
                    c0Var.Q(1);
                } else {
                    c0Var.Q(4);
                    long jL = y.l(c0Var);
                    if (jL != C.TIME_UNSET) {
                        long jB = this.f37352a.b(jL);
                        if (jB > j10) {
                            return j12 == C.TIME_UNSET ? a.e.d(jB, j11) : a.e.e(j11 + ((long) iE2));
                        }
                        if (SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US + jB > j10) {
                            return a.e.e(j11 + ((long) c0Var.e()));
                        }
                        iE2 = c0Var.e();
                        j12 = jB;
                    }
                    c(c0Var);
                    iE = c0Var.e();
                }
            }
            return j12 != C.TIME_UNSET ? a.e.f(j12, j11 + ((long) iE)) : a.e.f32439d;
        }

        private static void c(a4.c0 c0Var) {
            int iK;
            int iF = c0Var.f();
            if (c0Var.a() < 10) {
                c0Var.P(iF);
                return;
            }
            c0Var.Q(9);
            int iD = c0Var.D() & 7;
            if (c0Var.a() < iD) {
                c0Var.P(iF);
                return;
            }
            c0Var.Q(iD);
            if (c0Var.a() < 4) {
                c0Var.P(iF);
                return;
            }
            if (x.k(c0Var.d(), c0Var.e()) == 443) {
                c0Var.Q(4);
                int iJ = c0Var.J();
                if (c0Var.a() < iJ) {
                    c0Var.P(iF);
                    return;
                }
                c0Var.Q(iJ);
            }
            while (c0Var.a() >= 4 && (iK = x.k(c0Var.d(), c0Var.e())) != 442 && iK != 441 && (iK >>> 8) == 1) {
                c0Var.Q(4);
                if (c0Var.a() < 2) {
                    c0Var.P(iF);
                    return;
                }
                c0Var.P(Math.min(c0Var.f(), c0Var.e() + c0Var.J()));
            }
        }

        @Override // p2.a.f
        public a.e a(p2.m mVar, long j10) throws IOException {
            long position = mVar.getPosition();
            int iMin = (int) Math.min(20000L, mVar.getLength() - position);
            this.f37353b.L(iMin);
            mVar.peekFully(this.f37353b.d(), 0, iMin);
            return b(this.f37353b, j10, position);
        }

        @Override // p2.a.f
        public void onSeekFinished() {
            this.f37353b.M(o0.f219f);
        }

        private b(l0 l0Var) {
            this.f37352a = l0Var;
            this.f37353b = new a4.c0();
        }
    }

    public x(l0 l0Var, long j10, long j11) {
        super(new a.b(), new b(l0Var), j10, 0L, j10 + 1, 0L, j11, 188L, 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(byte[] bArr, int i10) {
        return (bArr[i10 + 3] & 255) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10 + 2] & 255) << 8);
    }
}
