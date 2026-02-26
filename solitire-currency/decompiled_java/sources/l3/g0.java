package l3;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;
import k2.o1;
import l3.a0;

/* JADX INFO: compiled from: MediaSourceEventListener.java */
/* JADX INFO: loaded from: classes2.dex */
public interface g0 {

    /* JADX INFO: compiled from: MediaSourceEventListener.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final a0.b f30537b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final CopyOnWriteArrayList<C0619a> f30538c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f30539d;

        /* JADX INFO: renamed from: l3.g0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MediaSourceEventListener.java */
        private static final class C0619a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Handler f30540a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public g0 f30541b;

            public C0619a(Handler handler, g0 g0Var) {
                this.f30540a = handler;
                this.f30541b = g0Var;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null, 0L);
        }

        private long g(long j10) {
            long jP0 = a4.o0.P0(j10);
            return jP0 == C.TIME_UNSET ? C.TIME_UNSET : this.f30539d + jP0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(g0 g0Var, w wVar) {
            g0Var.K(this.f30536a, this.f30537b, wVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(g0 g0Var, t tVar, w wVar) {
            g0Var.J(this.f30536a, this.f30537b, tVar, wVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(g0 g0Var, t tVar, w wVar) {
            g0Var.n(this.f30536a, this.f30537b, tVar, wVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(g0 g0Var, t tVar, w wVar, IOException iOException, boolean z10) {
            g0Var.o(this.f30536a, this.f30537b, tVar, wVar, iOException, z10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(g0 g0Var, t tVar, w wVar) {
            g0Var.k(this.f30536a, this.f30537b, tVar, wVar);
        }

        public void f(Handler handler, g0 g0Var) {
            a4.a.e(handler);
            a4.a.e(g0Var);
            this.f30538c.add(new C0619a(handler, g0Var));
        }

        public void h(int i10, @Nullable o1 o1Var, int i11, @Nullable Object obj, long j10) {
            i(new w(1, i10, o1Var, i11, obj, g(j10), C.TIME_UNSET));
        }

        public void i(final w wVar) {
            for (C0619a c0619a : this.f30538c) {
                final g0 g0Var = c0619a.f30541b;
                a4.o0.C0(c0619a.f30540a, new Runnable() { // from class: l3.c0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f30478a.j(g0Var, wVar);
                    }
                });
            }
        }

        public void o(t tVar, int i10, int i11, @Nullable o1 o1Var, int i12, @Nullable Object obj, long j10, long j11) {
            p(tVar, new w(i10, i11, o1Var, i12, obj, g(j10), g(j11)));
        }

        public void p(final t tVar, final w wVar) {
            for (C0619a c0619a : this.f30538c) {
                final g0 g0Var = c0619a.f30541b;
                a4.o0.C0(c0619a.f30540a, new Runnable() { // from class: l3.f0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f30530a.k(g0Var, tVar, wVar);
                    }
                });
            }
        }

        public void q(t tVar, int i10, int i11, @Nullable o1 o1Var, int i12, @Nullable Object obj, long j10, long j11) {
            r(tVar, new w(i10, i11, o1Var, i12, obj, g(j10), g(j11)));
        }

        public void r(final t tVar, final w wVar) {
            for (C0619a c0619a : this.f30538c) {
                final g0 g0Var = c0619a.f30541b;
                a4.o0.C0(c0619a.f30540a, new Runnable() { // from class: l3.e0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f30511a.l(g0Var, tVar, wVar);
                    }
                });
            }
        }

        public void s(t tVar, int i10, int i11, @Nullable o1 o1Var, int i12, @Nullable Object obj, long j10, long j11, IOException iOException, boolean z10) {
            t(tVar, new w(i10, i11, o1Var, i12, obj, g(j10), g(j11)), iOException, z10);
        }

        public void t(final t tVar, final w wVar, final IOException iOException, final boolean z10) {
            for (C0619a c0619a : this.f30538c) {
                final g0 g0Var = c0619a.f30541b;
                a4.o0.C0(c0619a.f30540a, new Runnable() { // from class: l3.d0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f30503a.m(g0Var, tVar, wVar, iOException, z10);
                    }
                });
            }
        }

        public void u(t tVar, int i10, int i11, @Nullable o1 o1Var, int i12, @Nullable Object obj, long j10, long j11) {
            v(tVar, new w(i10, i11, o1Var, i12, obj, g(j10), g(j11)));
        }

        public void v(final t tVar, final w wVar) {
            for (C0619a c0619a : this.f30538c) {
                final g0 g0Var = c0619a.f30541b;
                a4.o0.C0(c0619a.f30540a, new Runnable() { // from class: l3.b0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f30464a.n(g0Var, tVar, wVar);
                    }
                });
            }
        }

        public void w(g0 g0Var) {
            for (C0619a c0619a : this.f30538c) {
                if (c0619a.f30541b == g0Var) {
                    this.f30538c.remove(c0619a);
                }
            }
        }

        @CheckResult
        public a x(int i10, @Nullable a0.b bVar, long j10) {
            return new a(this.f30538c, i10, bVar, j10);
        }

        private a(CopyOnWriteArrayList<C0619a> copyOnWriteArrayList, int i10, @Nullable a0.b bVar, long j10) {
            this.f30538c = copyOnWriteArrayList;
            this.f30536a = i10;
            this.f30537b = bVar;
            this.f30539d = j10;
        }
    }

    void J(int i10, @Nullable a0.b bVar, t tVar, w wVar);

    void K(int i10, @Nullable a0.b bVar, w wVar);

    void k(int i10, @Nullable a0.b bVar, t tVar, w wVar);

    void n(int i10, @Nullable a0.b bVar, t tVar, w wVar);

    void o(int i10, @Nullable a0.b bVar, t tVar, w wVar, IOException iOException, boolean z10);
}
