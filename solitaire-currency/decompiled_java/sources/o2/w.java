package o2;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.util.concurrent.CopyOnWriteArrayList;
import l3.a0;

/* JADX INFO: compiled from: DrmSessionEventListener.java */
/* JADX INFO: loaded from: classes2.dex */
public interface w {

    /* JADX INFO: compiled from: DrmSessionEventListener.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31944a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final a0.b f31945b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final CopyOnWriteArrayList<C0637a> f31946c;

        /* JADX INFO: renamed from: o2.w$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DrmSessionEventListener.java */
        private static final class C0637a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Handler f31947a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public w f31948b;

            public C0637a(Handler handler, w wVar) {
                this.f31947a = handler;
                this.f31948b = wVar;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(w wVar) {
            wVar.v(this.f31944a, this.f31945b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(w wVar) {
            wVar.p(this.f31944a, this.f31945b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(w wVar) {
            wVar.s(this.f31944a, this.f31945b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(w wVar, int i10) {
            wVar.q(this.f31944a, this.f31945b);
            wVar.C(this.f31944a, this.f31945b, i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(w wVar, Exception exc) {
            wVar.w(this.f31944a, this.f31945b, exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(w wVar) {
            wVar.A(this.f31944a, this.f31945b);
        }

        public void g(Handler handler, w wVar) {
            a4.a.e(handler);
            a4.a.e(wVar);
            this.f31946c.add(new C0637a(handler, wVar));
        }

        public void h() {
            for (C0637a c0637a : this.f31946c) {
                final w wVar = c0637a.f31948b;
                a4.o0.C0(c0637a.f31947a, new Runnable() { // from class: o2.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f31940a.n(wVar);
                    }
                });
            }
        }

        public void i() {
            for (C0637a c0637a : this.f31946c) {
                final w wVar = c0637a.f31948b;
                a4.o0.C0(c0637a.f31947a, new Runnable() { // from class: o2.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f31938a.o(wVar);
                    }
                });
            }
        }

        public void j() {
            for (C0637a c0637a : this.f31946c) {
                final w wVar = c0637a.f31948b;
                a4.o0.C0(c0637a.f31947a, new Runnable() { // from class: o2.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f31942a.p(wVar);
                    }
                });
            }
        }

        public void k(final int i10) {
            for (C0637a c0637a : this.f31946c) {
                final w wVar = c0637a.f31948b;
                a4.o0.C0(c0637a.f31947a, new Runnable() { // from class: o2.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f31935a.q(wVar, i10);
                    }
                });
            }
        }

        public void l(final Exception exc) {
            for (C0637a c0637a : this.f31946c) {
                final w wVar = c0637a.f31948b;
                a4.o0.C0(c0637a.f31947a, new Runnable() { // from class: o2.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f31932a.r(wVar, exc);
                    }
                });
            }
        }

        public void m() {
            for (C0637a c0637a : this.f31946c) {
                final w wVar = c0637a.f31948b;
                a4.o0.C0(c0637a.f31947a, new Runnable() { // from class: o2.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f31930a.s(wVar);
                    }
                });
            }
        }

        public void t(w wVar) {
            for (C0637a c0637a : this.f31946c) {
                if (c0637a.f31948b == wVar) {
                    this.f31946c.remove(c0637a);
                }
            }
        }

        @CheckResult
        public a u(int i10, @Nullable a0.b bVar) {
            return new a(this.f31946c, i10, bVar);
        }

        private a(CopyOnWriteArrayList<C0637a> copyOnWriteArrayList, int i10, @Nullable a0.b bVar) {
            this.f31946c = copyOnWriteArrayList;
            this.f31944a = i10;
            this.f31945b = bVar;
        }
    }

    void A(int i10, @Nullable a0.b bVar);

    void C(int i10, @Nullable a0.b bVar, int i11);

    void p(int i10, @Nullable a0.b bVar);

    @Deprecated
    void q(int i10, @Nullable a0.b bVar);

    void s(int i10, @Nullable a0.b bVar);

    void v(int i10, @Nullable a0.b bVar);

    void w(int i10, @Nullable a0.b bVar, Exception exc);
}
