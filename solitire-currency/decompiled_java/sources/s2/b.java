package s2;

import java.io.IOException;
import java.util.Objects;
import p2.a;
import p2.m;
import p2.s;
import p2.v;

/* JADX INFO: compiled from: FlacBinarySearchSeeker.java */
/* JADX INFO: loaded from: classes2.dex */
final class b extends p2.a {

    /* JADX INFO: renamed from: s2.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FlacBinarySearchSeeker.java */
    private static final class C0669b implements a.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final v f33475a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f33476b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final s.a f33477c;

        private long b(m mVar) throws IOException {
            while (mVar.getPeekPosition() < mVar.getLength() - 6 && !s.h(mVar, this.f33475a, this.f33476b, this.f33477c)) {
                mVar.advancePeekPosition(1);
            }
            if (mVar.getPeekPosition() < mVar.getLength() - 6) {
                return this.f33477c.f32528a;
            }
            mVar.advancePeekPosition((int) (mVar.getLength() - mVar.getPeekPosition()));
            return this.f33475a.f32541j;
        }

        @Override // p2.a.f
        public a.e a(m mVar, long j10) throws IOException {
            long position = mVar.getPosition();
            long jB = b(mVar);
            long peekPosition = mVar.getPeekPosition();
            mVar.advancePeekPosition(Math.max(6, this.f33475a.f32534c));
            long jB2 = b(mVar);
            return (jB > j10 || jB2 <= j10) ? jB2 <= j10 ? a.e.f(jB2, mVar.getPeekPosition()) : a.e.d(jB, position) : a.e.e(peekPosition);
        }

        @Override // p2.a.f
        public /* synthetic */ void onSeekFinished() {
            p2.b.a(this);
        }

        private C0669b(v vVar, int i10) {
            this.f33475a = vVar;
            this.f33476b = i10;
            this.f33477c = new s.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(final v vVar, int i10, long j10, long j11) {
        super(new a.d() { // from class: s2.a
            @Override // p2.a.d
            public final long timeUsToTargetTime(long j12) {
                return vVar.i(j12);
            }
        }, new C0669b(vVar, i10), vVar.f(), 0L, vVar.f32541j, j10, j11, vVar.d(), Math.max(6, vVar.f32534c));
        Objects.requireNonNull(vVar);
    }
}
