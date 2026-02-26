package l3;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.io.IOException;
import k2.n3;
import k2.w1;
import l2.t1;

/* JADX INFO: compiled from: MediaSource.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a0 {

    /* JADX INFO: compiled from: MediaSource.java */
    public interface a {
        a a(z3.f0 f0Var);

        a0 b(w1 w1Var);

        a c(o2.b0 b0Var);
    }

    /* JADX INFO: compiled from: MediaSource.java */
    public static final class b extends y {
        public b(Object obj) {
            super(obj);
        }

        public b c(Object obj) {
            return new b(super.a(obj));
        }

        public b(Object obj, long j10) {
            super(obj, j10);
        }

        public b(Object obj, long j10, int i10) {
            super(obj, j10, i10);
        }

        public b(Object obj, int i10, int i11, long j10) {
            super(obj, i10, i11, j10);
        }

        public b(y yVar) {
            super(yVar);
        }
    }

    /* JADX INFO: compiled from: MediaSource.java */
    public interface c {
        void a(a0 a0Var, n3 n3Var);
    }

    void a(c cVar);

    void b(c cVar);

    void c(c cVar, @Nullable z3.m0 m0Var, t1 t1Var);

    void d(Handler handler, o2.w wVar);

    void e(x xVar);

    void f(o2.w wVar);

    void g(g0 g0Var);

    @Nullable
    n3 getInitialTimeline();

    w1 getMediaItem();

    void h(Handler handler, g0 g0Var);

    void i(c cVar);

    boolean isSingleWindow();

    x j(b bVar, z3.b bVar2, long j10);

    void maybeThrowSourceInfoRefreshError() throws IOException;
}
