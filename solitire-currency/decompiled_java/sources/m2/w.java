package m2;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.C;

/* JADX INFO: compiled from: AudioTimestampPoller.java */
/* JADX INFO: loaded from: classes2.dex */
final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final a f31386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f31387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f31388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f31389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f31390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f31391f;

    /* JADX INFO: compiled from: AudioTimestampPoller.java */
    @RequiresApi(19)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AudioTrack f31392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AudioTimestamp f31393b = new AudioTimestamp();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f31394c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f31395d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f31396e;

        public a(AudioTrack audioTrack) {
            this.f31392a = audioTrack;
        }

        public long a() {
            return this.f31396e;
        }

        public long b() {
            return this.f31393b.nanoTime / 1000;
        }

        public boolean c() {
            boolean timestamp = this.f31392a.getTimestamp(this.f31393b);
            if (timestamp) {
                long j10 = this.f31393b.framePosition;
                if (this.f31395d > j10) {
                    this.f31394c++;
                }
                this.f31395d = j10;
                this.f31396e = j10 + (this.f31394c << 32);
            }
            return timestamp;
        }
    }

    public w(AudioTrack audioTrack) {
        if (a4.o0.f214a >= 19) {
            this.f31386a = new a(audioTrack);
            g();
        } else {
            this.f31386a = null;
            h(3);
        }
    }

    private void h(int i10) {
        this.f31387b = i10;
        if (i10 == 0) {
            this.f31390e = 0L;
            this.f31391f = -1L;
            this.f31388c = System.nanoTime() / 1000;
            this.f31389d = 10000L;
            return;
        }
        if (i10 == 1) {
            this.f31389d = 10000L;
            return;
        }
        if (i10 == 2 || i10 == 3) {
            this.f31389d = 10000000L;
        } else {
            if (i10 != 4) {
                throw new IllegalStateException();
            }
            this.f31389d = 500000L;
        }
    }

    public void a() {
        if (this.f31387b == 4) {
            g();
        }
    }

    @TargetApi(19)
    public long b() {
        a aVar = this.f31386a;
        if (aVar != null) {
            return aVar.a();
        }
        return -1L;
    }

    @TargetApi(19)
    public long c() {
        a aVar = this.f31386a;
        return aVar != null ? aVar.b() : C.TIME_UNSET;
    }

    public boolean d() {
        return this.f31387b == 2;
    }

    @TargetApi(19)
    public boolean e(long j10) {
        a aVar = this.f31386a;
        if (aVar == null || j10 - this.f31390e < this.f31389d) {
            return false;
        }
        this.f31390e = j10;
        boolean zC = aVar.c();
        int i10 = this.f31387b;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            throw new IllegalStateException();
                        }
                    } else if (zC) {
                        g();
                    }
                } else if (!zC) {
                    g();
                }
            } else if (!zC) {
                g();
            } else if (this.f31386a.a() > this.f31391f) {
                h(2);
            }
        } else if (zC) {
            if (this.f31386a.b() < this.f31388c) {
                return false;
            }
            this.f31391f = this.f31386a.a();
            h(1);
        } else if (j10 - this.f31388c > 500000) {
            h(3);
        }
        return zC;
    }

    public void f() {
        h(4);
    }

    public void g() {
        if (this.f31386a != null) {
            h(0);
        }
    }
}
