package y2;

import a4.o0;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import java.io.EOFException;
import java.io.IOException;
import p2.b0;
import p2.c0;
import p2.m;
import p2.o;

/* JADX INFO: compiled from: DefaultOggSeeker.java */
/* JADX INFO: loaded from: classes2.dex */
final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f36434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f36435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f36436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final i f36437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f36438e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f36439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f36440g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f36441h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f36442i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f36443j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f36444k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f36445l;

    /* JADX INFO: compiled from: DefaultOggSeeker.java */
    private final class b implements b0 {
        private b() {
        }

        @Override // p2.b0
        public long getDurationUs() {
            return a.this.f36437d.b(a.this.f36439f);
        }

        @Override // p2.b0
        public b0.a getSeekPoints(long j10) {
            return new b0.a(new c0(j10, o0.q((a.this.f36435b + ((a.this.f36437d.c(j10) * (a.this.f36436c - a.this.f36435b)) / a.this.f36439f)) - 30000, a.this.f36435b, a.this.f36436c - 1)));
        }

        @Override // p2.b0
        public boolean isSeekable() {
            return true;
        }
    }

    public a(i iVar, long j10, long j11, long j12, long j13, boolean z10) {
        a4.a.a(j10 >= 0 && j11 > j10);
        this.f36437d = iVar;
        this.f36435b = j10;
        this.f36436c = j11;
        if (j12 == j11 - j10 || z10) {
            this.f36439f = j13;
            this.f36438e = 4;
        } else {
            this.f36438e = 0;
        }
        this.f36434a = new f();
    }

    private long g(m mVar) throws IOException {
        if (this.f36442i == this.f36443j) {
            return -1L;
        }
        long position = mVar.getPosition();
        if (!this.f36434a.d(mVar, this.f36443j)) {
            long j10 = this.f36442i;
            if (j10 != position) {
                return j10;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.f36434a.a(mVar, false);
        mVar.resetPeekPosition();
        long j11 = this.f36441h;
        f fVar = this.f36434a;
        long j12 = fVar.f36464c;
        long j13 = j11 - j12;
        int i10 = fVar.f36469h + fVar.f36470i;
        if (0 <= j13 && j13 < 72000) {
            return -1L;
        }
        if (j13 < 0) {
            this.f36443j = position;
            this.f36445l = j12;
        } else {
            this.f36442i = mVar.getPosition() + ((long) i10);
            this.f36444k = this.f36434a.f36464c;
        }
        long j14 = this.f36443j;
        long j15 = this.f36442i;
        if (j14 - j15 < SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US) {
            this.f36443j = j15;
            return j15;
        }
        long position2 = mVar.getPosition() - (((long) i10) * (j13 <= 0 ? 2L : 1L));
        long j16 = this.f36443j;
        long j17 = this.f36442i;
        return o0.q(position2 + ((j13 * (j16 - j17)) / (this.f36445l - this.f36444k)), j17, j16 - 1);
    }

    private void i(m mVar) throws IOException {
        while (true) {
            this.f36434a.c(mVar);
            this.f36434a.a(mVar, false);
            f fVar = this.f36434a;
            if (fVar.f36464c > this.f36441h) {
                mVar.resetPeekPosition();
                return;
            } else {
                mVar.skipFully(fVar.f36469h + fVar.f36470i);
                this.f36442i = mVar.getPosition();
                this.f36444k = this.f36434a.f36464c;
            }
        }
    }

    @Override // y2.g
    public long a(m mVar) throws IOException {
        int i10 = this.f36438e;
        if (i10 == 0) {
            long position = mVar.getPosition();
            this.f36440g = position;
            this.f36438e = 1;
            long j10 = this.f36436c - 65307;
            if (j10 > position) {
                return j10;
            }
        } else if (i10 != 1) {
            if (i10 == 2) {
                long jG = g(mVar);
                if (jG != -1) {
                    return jG;
                }
                this.f36438e = 3;
            } else if (i10 != 3) {
                if (i10 == 4) {
                    return -1L;
                }
                throw new IllegalStateException();
            }
            i(mVar);
            this.f36438e = 4;
            return -(this.f36444k + 2);
        }
        this.f36439f = h(mVar);
        this.f36438e = 4;
        return this.f36440g;
    }

    @Override // y2.g
    @Nullable
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public b createSeekMap() {
        if (this.f36439f != 0) {
            return new b();
        }
        return null;
    }

    @VisibleForTesting
    long h(m mVar) throws IOException {
        this.f36434a.b();
        if (!this.f36434a.c(mVar)) {
            throw new EOFException();
        }
        this.f36434a.a(mVar, false);
        f fVar = this.f36434a;
        mVar.skipFully(fVar.f36469h + fVar.f36470i);
        long j10 = this.f36434a.f36464c;
        while (true) {
            f fVar2 = this.f36434a;
            if ((fVar2.f36463b & 4) == 4 || !fVar2.c(mVar) || mVar.getPosition() >= this.f36436c || !this.f36434a.a(mVar, true)) {
                break;
            }
            f fVar3 = this.f36434a;
            if (!o.e(mVar, fVar3.f36469h + fVar3.f36470i)) {
                break;
            }
            j10 = this.f36434a.f36464c;
        }
        return j10;
    }

    @Override // y2.g
    public void startSeek(long j10) {
        this.f36441h = o0.q(j10, 0L, this.f36439f - 1);
        this.f36438e = 2;
        this.f36442i = this.f36435b;
        this.f36443j = this.f36436c;
        this.f36444k = 0L;
        this.f36445l = this.f36439f;
    }
}
