package b4;

import androidx.media3.common.C;
import java.util.Arrays;

/* JADX INFO: compiled from: FixedFrameRateEstimator.java */
/* JADX INFO: loaded from: classes2.dex */
final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2096d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2098f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f2093a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f2094b = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f2097e = C.TIME_UNSET;

    /* JADX INFO: compiled from: FixedFrameRateEstimator.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f2099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f2100b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f2101c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f2102d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f2103e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f2104f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean[] f2105g = new boolean[15];

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f2106h;

        private static int c(long j10) {
            return (int) (j10 % 15);
        }

        public long a() {
            long j10 = this.f2103e;
            if (j10 == 0) {
                return 0L;
            }
            return this.f2104f / j10;
        }

        public long b() {
            return this.f2104f;
        }

        public boolean d() {
            long j10 = this.f2102d;
            if (j10 == 0) {
                return false;
            }
            return this.f2105g[c(j10 - 1)];
        }

        public boolean e() {
            return this.f2102d > 15 && this.f2106h == 0;
        }

        public void f(long j10) {
            long j11 = this.f2102d;
            if (j11 == 0) {
                this.f2099a = j10;
            } else if (j11 == 1) {
                long j12 = j10 - this.f2099a;
                this.f2100b = j12;
                this.f2104f = j12;
                this.f2103e = 1L;
            } else {
                long j13 = j10 - this.f2101c;
                int iC = c(j11);
                if (Math.abs(j13 - this.f2100b) <= 1000000) {
                    this.f2103e++;
                    this.f2104f += j13;
                    boolean[] zArr = this.f2105g;
                    if (zArr[iC]) {
                        zArr[iC] = false;
                        this.f2106h--;
                    }
                } else {
                    boolean[] zArr2 = this.f2105g;
                    if (!zArr2[iC]) {
                        zArr2[iC] = true;
                        this.f2106h++;
                    }
                }
            }
            this.f2102d++;
            this.f2101c = j10;
        }

        public void g() {
            this.f2102d = 0L;
            this.f2103e = 0L;
            this.f2104f = 0L;
            this.f2106h = 0;
            Arrays.fill(this.f2105g, false);
        }
    }

    public long a() {
        return e() ? this.f2093a.a() : C.TIME_UNSET;
    }

    public float b() {
        if (e()) {
            return (float) (1.0E9d / this.f2093a.a());
        }
        return -1.0f;
    }

    public int c() {
        return this.f2098f;
    }

    public long d() {
        return e() ? this.f2093a.b() : C.TIME_UNSET;
    }

    public boolean e() {
        return this.f2093a.e();
    }

    public void f(long j10) {
        this.f2093a.f(j10);
        if (this.f2093a.e() && !this.f2096d) {
            this.f2095c = false;
        } else if (this.f2097e != C.TIME_UNSET) {
            if (!this.f2095c || this.f2094b.d()) {
                this.f2094b.g();
                this.f2094b.f(this.f2097e);
            }
            this.f2095c = true;
            this.f2094b.f(j10);
        }
        if (this.f2095c && this.f2094b.e()) {
            a aVar = this.f2093a;
            this.f2093a = this.f2094b;
            this.f2094b = aVar;
            this.f2095c = false;
            this.f2096d = false;
        }
        this.f2097e = j10;
        this.f2098f = this.f2093a.e() ? 0 : this.f2098f + 1;
    }

    public void g() {
        this.f2093a.g();
        this.f2094b.g();
        this.f2095c = false;
        this.f2097e = C.TIME_UNSET;
        this.f2098f = 0;
    }
}
