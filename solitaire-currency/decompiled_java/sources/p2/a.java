package p2;

import a4.o0;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.io.IOException;
import p2.b0;

/* JADX INFO: compiled from: BinarySearchSeeker.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final C0649a f32420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final f f32421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    protected c f32422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f32423d;

    /* JADX INFO: renamed from: p2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BinarySearchSeeker.java */
    public static class C0649a implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f32424a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f32425b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f32426c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f32427d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long f32428e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final long f32429f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final long f32430g;

        public C0649a(d dVar, long j10, long j11, long j12, long j13, long j14, long j15) {
            this.f32424a = dVar;
            this.f32425b = j10;
            this.f32426c = j11;
            this.f32427d = j12;
            this.f32428e = j13;
            this.f32429f = j14;
            this.f32430g = j15;
        }

        public long f(long j10) {
            return this.f32424a.timeUsToTargetTime(j10);
        }

        @Override // p2.b0
        public long getDurationUs() {
            return this.f32425b;
        }

        @Override // p2.b0
        public b0.a getSeekPoints(long j10) {
            return new b0.a(new c0(j10, c.h(this.f32424a.timeUsToTargetTime(j10), this.f32426c, this.f32427d, this.f32428e, this.f32429f, this.f32430g)));
        }

        @Override // p2.b0
        public boolean isSeekable() {
            return true;
        }
    }

    /* JADX INFO: compiled from: BinarySearchSeeker.java */
    protected static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f32431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f32432b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f32433c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f32434d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f32435e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f32436f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f32437g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f32438h;

        protected c(long j10, long j11, long j12, long j13, long j14, long j15, long j16) {
            this.f32431a = j10;
            this.f32432b = j11;
            this.f32434d = j12;
            this.f32435e = j13;
            this.f32436f = j14;
            this.f32437g = j15;
            this.f32433c = j16;
            this.f32438h = h(j11, j12, j13, j14, j15, j16);
        }

        protected static long h(long j10, long j11, long j12, long j13, long j14, long j15) {
            if (j13 + 1 >= j14 || j11 + 1 >= j12) {
                return j13;
            }
            long j16 = (long) ((j10 - j11) * ((j14 - j13) / (j12 - j11)));
            return o0.q(((j16 + j13) - j15) - (j16 / 20), j13, j14 - 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long i() {
            return this.f32437g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long j() {
            return this.f32436f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long k() {
            return this.f32438h;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long l() {
            return this.f32431a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long m() {
            return this.f32432b;
        }

        private void n() {
            this.f32438h = h(this.f32432b, this.f32434d, this.f32435e, this.f32436f, this.f32437g, this.f32433c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(long j10, long j11) {
            this.f32435e = j10;
            this.f32437g = j11;
            n();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p(long j10, long j11) {
            this.f32434d = j10;
            this.f32436f = j11;
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: compiled from: BinarySearchSeeker.java */
    public interface d {
        long timeUsToTargetTime(long j10);
    }

    /* JADX INFO: compiled from: BinarySearchSeeker.java */
    public static final class e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final e f32439d = new e(-3, C.TIME_UNSET, -1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f32440a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f32441b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f32442c;

        private e(int i10, long j10, long j11) {
            this.f32440a = i10;
            this.f32441b = j10;
            this.f32442c = j11;
        }

        public static e d(long j10, long j11) {
            return new e(-1, j10, j11);
        }

        public static e e(long j10) {
            return new e(0, C.TIME_UNSET, j10);
        }

        public static e f(long j10, long j11) {
            return new e(-2, j10, j11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: compiled from: BinarySearchSeeker.java */
    public interface f {
        e a(m mVar, long j10) throws IOException;

        void onSeekFinished();
    }

    protected a(d dVar, f fVar, long j10, long j11, long j12, long j13, long j14, long j15, int i10) {
        this.f32421b = fVar;
        this.f32423d = i10;
        this.f32420a = new C0649a(dVar, j10, j11, j12, j13, j14, j15);
    }

    protected c a(long j10) {
        return new c(j10, this.f32420a.f(j10), this.f32420a.f32426c, this.f32420a.f32427d, this.f32420a.f32428e, this.f32420a.f32429f, this.f32420a.f32430g);
    }

    public final b0 b() {
        return this.f32420a;
    }

    public int c(m mVar, a0 a0Var) throws IOException {
        while (true) {
            c cVar = (c) a4.a.i(this.f32422c);
            long j10 = cVar.j();
            long jI = cVar.i();
            long jK = cVar.k();
            if (jI - j10 <= this.f32423d) {
                e(false, j10);
                return g(mVar, j10, a0Var);
            }
            if (!i(mVar, jK)) {
                return g(mVar, jK, a0Var);
            }
            mVar.resetPeekPosition();
            e eVarA = this.f32421b.a(mVar, cVar.m());
            int i10 = eVarA.f32440a;
            if (i10 == -3) {
                e(false, jK);
                return g(mVar, jK, a0Var);
            }
            if (i10 == -2) {
                cVar.p(eVarA.f32441b, eVarA.f32442c);
            } else {
                if (i10 != -1) {
                    if (i10 != 0) {
                        throw new IllegalStateException("Invalid case");
                    }
                    i(mVar, eVarA.f32442c);
                    e(true, eVarA.f32442c);
                    return g(mVar, eVarA.f32442c, a0Var);
                }
                cVar.o(eVarA.f32441b, eVarA.f32442c);
            }
        }
    }

    public final boolean d() {
        return this.f32422c != null;
    }

    protected final void e(boolean z10, long j10) {
        this.f32422c = null;
        this.f32421b.onSeekFinished();
        f(z10, j10);
    }

    protected final int g(m mVar, long j10, a0 a0Var) {
        if (j10 == mVar.getPosition()) {
            return 0;
        }
        a0Var.f32443a = j10;
        return 1;
    }

    public final void h(long j10) {
        c cVar = this.f32422c;
        if (cVar == null || cVar.l() != j10) {
            this.f32422c = a(j10);
        }
    }

    protected final boolean i(m mVar, long j10) throws IOException {
        long position = j10 - mVar.getPosition();
        if (position < 0 || position > 262144) {
            return false;
        }
        mVar.skipFully((int) position);
        return true;
    }

    /* JADX INFO: compiled from: BinarySearchSeeker.java */
    public static final class b implements d {
        @Override // p2.a.d
        public long timeUsToTargetTime(long j10) {
            return j10;
        }
    }

    protected void f(boolean z10, long j10) {
    }
}
