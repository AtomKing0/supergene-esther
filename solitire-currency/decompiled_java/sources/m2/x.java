package m2;

import android.media.AudioTrack;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.exoplayer.dash.DashMediaSource;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: AudioTrackPositionTracker.java */
/* JADX INFO: loaded from: classes2.dex */
final class x {
    private long A;
    private long B;
    private long C;
    private boolean D;
    private long E;
    private long F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f31397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f31398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private AudioTrack f31399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f31400d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f31401e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private w f31402f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f31403g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f31404h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f31405i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f31406j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f31407k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f31408l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f31409m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private Method f31410n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f31411o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f31412p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f31413q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f31414r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f31415s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f31416t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f31417u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f31418v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f31419w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f31420x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f31421y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private long f31422z;

    /* JADX INFO: compiled from: AudioTrackPositionTracker.java */
    public interface a {
        void onInvalidLatency(long j10);

        void onPositionAdvancing(long j10);

        void onPositionFramesMismatch(long j10, long j11, long j12, long j13);

        void onSystemTimeUsMismatch(long j10, long j11, long j12, long j13);

        void onUnderrun(int i10, long j10);
    }

    public x(a aVar) {
        this.f31397a = (a) a4.a.e(aVar);
        if (a4.o0.f214a >= 18) {
            try {
                this.f31410n = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.f31398b = new long[10];
    }

    private boolean a() {
        return this.f31404h && ((AudioTrack) a4.a.e(this.f31399c)).getPlayState() == 2 && e() == 0;
    }

    private long b(long j10) {
        return (j10 * 1000000) / ((long) this.f31403g);
    }

    private long e() {
        AudioTrack audioTrack = (AudioTrack) a4.a.e(this.f31399c);
        if (this.f31420x != C.TIME_UNSET) {
            return Math.min(this.A, this.f31422z + ((((SystemClock.elapsedRealtime() * 1000) - this.f31420x) * ((long) this.f31403g)) / 1000000));
        }
        int playState = audioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = ((long) audioTrack.getPlaybackHeadPosition()) & 4294967295L;
        if (this.f31404h) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.f31417u = this.f31415s;
            }
            playbackHeadPosition += this.f31417u;
        }
        if (a4.o0.f214a <= 29) {
            if (playbackHeadPosition == 0 && this.f31415s > 0 && playState == 3) {
                if (this.f31421y == C.TIME_UNSET) {
                    this.f31421y = SystemClock.elapsedRealtime();
                }
                return this.f31415s;
            }
            this.f31421y = C.TIME_UNSET;
        }
        if (this.f31415s > playbackHeadPosition) {
            this.f31416t++;
        }
        this.f31415s = playbackHeadPosition;
        return playbackHeadPosition + (this.f31416t << 32);
    }

    private long f() {
        return b(e());
    }

    private void l(long j10, long j11) {
        w wVar = (w) a4.a.e(this.f31402f);
        if (wVar.e(j10)) {
            long jC = wVar.c();
            long jB = wVar.b();
            if (Math.abs(jC - j10) > DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US) {
                this.f31397a.onSystemTimeUsMismatch(jB, jC, j10, j11);
                wVar.f();
            } else if (Math.abs(b(jB) - j11) <= DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US) {
                wVar.a();
            } else {
                this.f31397a.onPositionFramesMismatch(jB, jC, j10, j11);
                wVar.f();
            }
        }
    }

    private void m() {
        long jF = f();
        if (jF == 0) {
            return;
        }
        long jNanoTime = System.nanoTime() / 1000;
        if (jNanoTime - this.f31409m >= 30000) {
            long[] jArr = this.f31398b;
            int i10 = this.f31418v;
            jArr[i10] = jF - jNanoTime;
            this.f31418v = (i10 + 1) % 10;
            int i11 = this.f31419w;
            if (i11 < 10) {
                this.f31419w = i11 + 1;
            }
            this.f31409m = jNanoTime;
            this.f31408l = 0L;
            int i12 = 0;
            while (true) {
                int i13 = this.f31419w;
                if (i12 >= i13) {
                    break;
                }
                this.f31408l += this.f31398b[i12] / ((long) i13);
                i12++;
            }
        }
        if (this.f31404h) {
            return;
        }
        l(jNanoTime, jF);
        n(jNanoTime);
    }

    private void n(long j10) {
        Method method;
        if (!this.f31413q || (method = this.f31410n) == null || j10 - this.f31414r < 500000) {
            return;
        }
        try {
            long jIntValue = (((long) ((Integer) a4.o0.j((Integer) method.invoke(a4.a.e(this.f31399c), new Object[0]))).intValue()) * 1000) - this.f31405i;
            this.f31411o = jIntValue;
            long jMax = Math.max(jIntValue, 0L);
            this.f31411o = jMax;
            if (jMax > DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US) {
                this.f31397a.onInvalidLatency(jMax);
                this.f31411o = 0L;
            }
        } catch (Exception unused) {
            this.f31410n = null;
        }
        this.f31414r = j10;
    }

    private static boolean o(int i10) {
        return a4.o0.f214a < 23 && (i10 == 5 || i10 == 6);
    }

    private void r() {
        this.f31408l = 0L;
        this.f31419w = 0;
        this.f31418v = 0;
        this.f31409m = 0L;
        this.C = 0L;
        this.F = 0L;
        this.f31407k = false;
    }

    public int c(long j10) {
        return this.f31401e - ((int) (j10 - (e() * ((long) this.f31400d))));
    }

    public long d(boolean z10) {
        long jF;
        if (((AudioTrack) a4.a.e(this.f31399c)).getPlayState() == 3) {
            m();
        }
        long jNanoTime = System.nanoTime() / 1000;
        w wVar = (w) a4.a.e(this.f31402f);
        boolean zD = wVar.d();
        if (zD) {
            jF = b(wVar.b()) + a4.o0.U(jNanoTime - wVar.c(), this.f31406j);
        } else {
            jF = this.f31419w == 0 ? f() : this.f31408l + jNanoTime;
            if (!z10) {
                jF = Math.max(0L, jF - this.f31411o);
            }
        }
        if (this.D != zD) {
            this.F = this.C;
            this.E = this.B;
        }
        long j10 = jNanoTime - this.F;
        if (j10 < 1000000) {
            long jU = this.E + a4.o0.U(j10, this.f31406j);
            long j11 = (j10 * 1000) / 1000000;
            jF = ((jF * j11) + ((1000 - j11) * jU)) / 1000;
        }
        if (!this.f31407k) {
            long j12 = this.B;
            if (jF > j12) {
                this.f31407k = true;
                this.f31397a.onPositionAdvancing(System.currentTimeMillis() - a4.o0.P0(a4.o0.Z(a4.o0.P0(jF - j12), this.f31406j)));
            }
        }
        this.C = jNanoTime;
        this.B = jF;
        this.D = zD;
        return jF;
    }

    public void g(long j10) {
        this.f31422z = e();
        this.f31420x = SystemClock.elapsedRealtime() * 1000;
        this.A = j10;
    }

    public boolean h(long j10) {
        return j10 > e() || a();
    }

    public boolean i() {
        return ((AudioTrack) a4.a.e(this.f31399c)).getPlayState() == 3;
    }

    public boolean j(long j10) {
        return this.f31421y != C.TIME_UNSET && j10 > 0 && SystemClock.elapsedRealtime() - this.f31421y >= 200;
    }

    public boolean k(long j10) {
        int playState = ((AudioTrack) a4.a.e(this.f31399c)).getPlayState();
        if (this.f31404h) {
            if (playState == 2) {
                this.f31412p = false;
                return false;
            }
            if (playState == 1 && e() == 0) {
                return false;
            }
        }
        boolean z10 = this.f31412p;
        boolean zH = h(j10);
        this.f31412p = zH;
        if (z10 && !zH && playState != 1) {
            this.f31397a.onUnderrun(this.f31401e, a4.o0.P0(this.f31405i));
        }
        return true;
    }

    public boolean p() {
        r();
        if (this.f31420x != C.TIME_UNSET) {
            return false;
        }
        ((w) a4.a.e(this.f31402f)).g();
        return true;
    }

    public void q() {
        r();
        this.f31399c = null;
        this.f31402f = null;
    }

    public void s(AudioTrack audioTrack, boolean z10, int i10, int i11, int i12) {
        this.f31399c = audioTrack;
        this.f31400d = i11;
        this.f31401e = i12;
        this.f31402f = new w(audioTrack);
        this.f31403g = audioTrack.getSampleRate();
        this.f31404h = z10 && o(i10);
        boolean zO0 = a4.o0.o0(i10);
        this.f31413q = zO0;
        this.f31405i = zO0 ? b(i12 / i11) : -9223372036854775807L;
        this.f31415s = 0L;
        this.f31416t = 0L;
        this.f31417u = 0L;
        this.f31412p = false;
        this.f31420x = C.TIME_UNSET;
        this.f31421y = C.TIME_UNSET;
        this.f31414r = 0L;
        this.f31411o = 0L;
        this.f31406j = 1.0f;
    }

    public void t(float f10) {
        this.f31406j = f10;
        w wVar = this.f31402f;
        if (wVar != null) {
            wVar.g();
        }
    }

    public void u() {
        ((w) a4.a.e(this.f31402f)).g();
    }
}
