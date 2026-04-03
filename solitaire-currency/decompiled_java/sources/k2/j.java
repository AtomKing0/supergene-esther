package k2;

import android.os.SystemClock;
import androidx.media3.common.C;
import k2.w1;

/* JADX INFO: compiled from: DefaultLivePlaybackSpeedControl.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f29166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f29167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f29168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f29169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f29170e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f29171f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f29172g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f29173h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f29174i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f29175j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f29176k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f29177l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f29178m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f29179n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f29180o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f29181p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f29182q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f29183r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f29184s;

    /* JADX INFO: compiled from: DefaultLivePlaybackSpeedControl.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f29185a = 0.97f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f29186b = 1.03f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f29187c = 1000;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f29188d = 1.0E-7f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f29189e = a4.o0.w0(20);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f29190f = a4.o0.w0(500);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private float f29191g = 0.999f;

        public j a() {
            return new j(this.f29185a, this.f29186b, this.f29187c, this.f29188d, this.f29189e, this.f29190f, this.f29191g);
        }
    }

    private void b(long j10) {
        long j11 = this.f29183r + (this.f29184s * 3);
        if (this.f29178m > j11) {
            float fW0 = a4.o0.w0(this.f29168c);
            this.f29178m = g5.g.c(j11, this.f29175j, this.f29178m - (((long) ((this.f29181p - 1.0f) * fW0)) + ((long) ((this.f29179n - 1.0f) * fW0))));
            return;
        }
        long jQ = a4.o0.q(j10 - ((long) (Math.max(0.0f, this.f29181p - 1.0f) / this.f29169d)), this.f29178m, j11);
        this.f29178m = jQ;
        long j12 = this.f29177l;
        if (j12 == C.TIME_UNSET || jQ <= j12) {
            return;
        }
        this.f29178m = j12;
    }

    private void c() {
        long j10 = this.f29173h;
        if (j10 != C.TIME_UNSET) {
            long j11 = this.f29174i;
            if (j11 != C.TIME_UNSET) {
                j10 = j11;
            }
            long j12 = this.f29176k;
            if (j12 != C.TIME_UNSET && j10 < j12) {
                j10 = j12;
            }
            long j13 = this.f29177l;
            if (j13 != C.TIME_UNSET && j10 > j13) {
                j10 = j13;
            }
        } else {
            j10 = -9223372036854775807L;
        }
        if (this.f29175j == j10) {
            return;
        }
        this.f29175j = j10;
        this.f29178m = j10;
        this.f29183r = C.TIME_UNSET;
        this.f29184s = C.TIME_UNSET;
        this.f29182q = C.TIME_UNSET;
    }

    private static long d(long j10, long j11, float f10) {
        return (long) ((j10 * f10) + ((1.0f - f10) * j11));
    }

    private void e(long j10, long j11) {
        long j12 = j10 - j11;
        long j13 = this.f29183r;
        if (j13 == C.TIME_UNSET) {
            this.f29183r = j12;
            this.f29184s = 0L;
        } else {
            long jMax = Math.max(j12, d(j13, j12, this.f29172g));
            this.f29183r = jMax;
            this.f29184s = d(this.f29184s, Math.abs(j12 - jMax), this.f29172g);
        }
    }

    @Override // k2.t1
    public void a(w1.g gVar) {
        this.f29173h = a4.o0.w0(gVar.f29570a);
        this.f29176k = a4.o0.w0(gVar.f29571b);
        this.f29177l = a4.o0.w0(gVar.f29572c);
        float f10 = gVar.f29573d;
        if (f10 == -3.4028235E38f) {
            f10 = this.f29166a;
        }
        this.f29180o = f10;
        float f11 = gVar.f29574e;
        if (f11 == -3.4028235E38f) {
            f11 = this.f29167b;
        }
        this.f29179n = f11;
        if (f10 == 1.0f && f11 == 1.0f) {
            this.f29173h = C.TIME_UNSET;
        }
        c();
    }

    @Override // k2.t1
    public float getAdjustedPlaybackSpeed(long j10, long j11) {
        if (this.f29173h == C.TIME_UNSET) {
            return 1.0f;
        }
        e(j10, j11);
        if (this.f29182q != C.TIME_UNSET && SystemClock.elapsedRealtime() - this.f29182q < this.f29168c) {
            return this.f29181p;
        }
        this.f29182q = SystemClock.elapsedRealtime();
        b(j10);
        long j12 = j10 - this.f29178m;
        if (Math.abs(j12) < this.f29170e) {
            this.f29181p = 1.0f;
        } else {
            this.f29181p = a4.o0.o((this.f29169d * j12) + 1.0f, this.f29180o, this.f29179n);
        }
        return this.f29181p;
    }

    @Override // k2.t1
    public long getTargetLiveOffsetUs() {
        return this.f29178m;
    }

    @Override // k2.t1
    public void notifyRebuffer() {
        long j10 = this.f29178m;
        if (j10 == C.TIME_UNSET) {
            return;
        }
        long j11 = j10 + this.f29171f;
        this.f29178m = j11;
        long j12 = this.f29177l;
        if (j12 != C.TIME_UNSET && j11 > j12) {
            this.f29178m = j12;
        }
        this.f29182q = C.TIME_UNSET;
    }

    @Override // k2.t1
    public void setTargetLiveOffsetOverrideUs(long j10) {
        this.f29174i = j10;
        c();
    }

    private j(float f10, float f11, long j10, float f12, long j11, long j12, float f13) {
        this.f29166a = f10;
        this.f29167b = f11;
        this.f29168c = j10;
        this.f29169d = f12;
        this.f29170e = j11;
        this.f29171f = j12;
        this.f29172g = f13;
        this.f29173h = C.TIME_UNSET;
        this.f29174i = C.TIME_UNSET;
        this.f29176k = C.TIME_UNSET;
        this.f29177l = C.TIME_UNSET;
        this.f29180o = f10;
        this.f29179n = f11;
        this.f29181p = 1.0f;
        this.f29182q = C.TIME_UNSET;
        this.f29175j = C.TIME_UNSET;
        this.f29178m = C.TIME_UNSET;
        this.f29183r = C.TIME_UNSET;
        this.f29184s = C.TIME_UNSET;
    }
}
