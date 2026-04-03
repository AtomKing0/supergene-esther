package j;

import android.graphics.Bitmap;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import j.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v.i;
import v.n;
import v.r;

/* JADX INFO: compiled from: EventListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface c extends i.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f28546a = b.f28548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final c f28547b = new a();

    /* JADX INFO: compiled from: EventListener.kt */
    public static final class a implements c {
        a() {
        }

        @Override // j.c, v.i.b
        @MainThread
        public void a(@NotNull i iVar, @NotNull r rVar) {
            C0590c.l(this, iVar, rVar);
        }

        @Override // j.c, v.i.b
        @MainThread
        public void b(@NotNull i iVar) {
            C0590c.k(this, iVar);
        }

        @Override // j.c, v.i.b
        @MainThread
        public void c(@NotNull i iVar, @NotNull v.f fVar) {
            C0590c.j(this, iVar, fVar);
        }

        @Override // j.c, v.i.b
        @MainThread
        public void d(@NotNull i iVar) {
            C0590c.i(this, iVar);
        }

        @Override // j.c
        @MainThread
        public void e(@NotNull i iVar) {
            C0590c.n(this, iVar);
        }

        @Override // j.c
        @WorkerThread
        public void f(@NotNull i iVar, @NotNull Bitmap bitmap) {
            C0590c.o(this, iVar, bitmap);
        }

        @Override // j.c
        @MainThread
        public void g(@NotNull i iVar, @NotNull z.c cVar) {
            C0590c.q(this, iVar, cVar);
        }

        @Override // j.c
        @MainThread
        public void h(@NotNull i iVar, @NotNull z.c cVar) {
            C0590c.r(this, iVar, cVar);
        }

        @Override // j.c
        @MainThread
        public void i(@NotNull i iVar, @NotNull Object obj) {
            C0590c.f(this, iVar, obj);
        }

        @Override // j.c
        @WorkerThread
        public void j(@NotNull i iVar, @NotNull m.i iVar2, @NotNull n nVar) {
            C0590c.b(this, iVar, iVar2, nVar);
        }

        @Override // j.c
        @WorkerThread
        public void k(@NotNull i iVar, @NotNull m.i iVar2, @NotNull n nVar, @Nullable m.g gVar) {
            C0590c.a(this, iVar, iVar2, nVar, gVar);
        }

        @Override // j.c
        @MainThread
        public void l(@NotNull i iVar, @Nullable String str) {
            C0590c.e(this, iVar, str);
        }

        @Override // j.c
        @WorkerThread
        public void m(@NotNull i iVar, @NotNull p.i iVar2, @NotNull n nVar, @Nullable p.h hVar) {
            C0590c.c(this, iVar, iVar2, nVar, hVar);
        }

        @Override // j.c
        @MainThread
        public void n(@NotNull i iVar, @NotNull Object obj) {
            C0590c.h(this, iVar, obj);
        }

        @Override // j.c
        @WorkerThread
        public void o(@NotNull i iVar, @NotNull p.i iVar2, @NotNull n nVar) {
            C0590c.d(this, iVar, iVar2, nVar);
        }

        @Override // j.c
        @WorkerThread
        public void p(@NotNull i iVar, @NotNull Bitmap bitmap) {
            C0590c.p(this, iVar, bitmap);
        }

        @Override // j.c
        @MainThread
        public void q(@NotNull i iVar, @NotNull Object obj) {
            C0590c.g(this, iVar, obj);
        }

        @Override // j.c
        @MainThread
        public void r(@NotNull i iVar, @NotNull w.i iVar2) {
            C0590c.m(this, iVar, iVar2);
        }
    }

    /* JADX INFO: compiled from: EventListener.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ b f28548a = new b();

        private b() {
        }
    }

    /* JADX INFO: compiled from: EventListener.kt */
    public interface d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f28549a = a.f28551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public static final d f28550b = new d() { // from class: j.d
            @Override // j.c.d
            public final c a(i iVar) {
                return c.d.b.a(iVar);
            }
        };

        /* JADX INFO: compiled from: EventListener.kt */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final /* synthetic */ a f28551a = new a();

            private a() {
            }
        }

        /* JADX INFO: compiled from: EventListener.kt */
        public static final class b {
            /* JADX INFO: Access modifiers changed from: private */
            public static c a(i iVar) {
                return c.f28547b;
            }
        }

        @NotNull
        c a(@NotNull i iVar);
    }

    @Override // v.i.b
    @MainThread
    void a(@NotNull i iVar, @NotNull r rVar);

    @Override // v.i.b
    @MainThread
    void b(@NotNull i iVar);

    @Override // v.i.b
    @MainThread
    void c(@NotNull i iVar, @NotNull v.f fVar);

    @Override // v.i.b
    @MainThread
    void d(@NotNull i iVar);

    @MainThread
    void e(@NotNull i iVar);

    @WorkerThread
    void f(@NotNull i iVar, @NotNull Bitmap bitmap);

    @MainThread
    void g(@NotNull i iVar, @NotNull z.c cVar);

    @MainThread
    void h(@NotNull i iVar, @NotNull z.c cVar);

    @MainThread
    void i(@NotNull i iVar, @NotNull Object obj);

    @WorkerThread
    void j(@NotNull i iVar, @NotNull m.i iVar2, @NotNull n nVar);

    @WorkerThread
    void k(@NotNull i iVar, @NotNull m.i iVar2, @NotNull n nVar, @Nullable m.g gVar);

    @MainThread
    void l(@NotNull i iVar, @Nullable String str);

    @WorkerThread
    void m(@NotNull i iVar, @NotNull p.i iVar2, @NotNull n nVar, @Nullable p.h hVar);

    @MainThread
    void n(@NotNull i iVar, @NotNull Object obj);

    @WorkerThread
    void o(@NotNull i iVar, @NotNull p.i iVar2, @NotNull n nVar);

    @WorkerThread
    void p(@NotNull i iVar, @NotNull Bitmap bitmap);

    @MainThread
    void q(@NotNull i iVar, @NotNull Object obj);

    @MainThread
    void r(@NotNull i iVar, @NotNull w.i iVar2);

    /* JADX INFO: renamed from: j.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EventListener.kt */
    public static final class C0590c {
        @MainThread
        public static void i(@NotNull c cVar, @NotNull i iVar) {
        }

        @MainThread
        public static void k(@NotNull c cVar, @NotNull i iVar) {
        }

        @MainThread
        public static void n(@NotNull c cVar, @NotNull i iVar) {
        }

        @MainThread
        public static void e(@NotNull c cVar, @NotNull i iVar, @Nullable String str) {
        }

        @MainThread
        public static void f(@NotNull c cVar, @NotNull i iVar, @NotNull Object obj) {
        }

        @MainThread
        public static void g(@NotNull c cVar, @NotNull i iVar, @NotNull Object obj) {
        }

        @MainThread
        public static void h(@NotNull c cVar, @NotNull i iVar, @NotNull Object obj) {
        }

        @MainThread
        public static void j(@NotNull c cVar, @NotNull i iVar, @NotNull v.f fVar) {
        }

        @MainThread
        public static void l(@NotNull c cVar, @NotNull i iVar, @NotNull r rVar) {
        }

        @MainThread
        public static void m(@NotNull c cVar, @NotNull i iVar, @NotNull w.i iVar2) {
        }

        @WorkerThread
        public static void o(@NotNull c cVar, @NotNull i iVar, @NotNull Bitmap bitmap) {
        }

        @WorkerThread
        public static void p(@NotNull c cVar, @NotNull i iVar, @NotNull Bitmap bitmap) {
        }

        @MainThread
        public static void q(@NotNull c cVar, @NotNull i iVar, @NotNull z.c cVar2) {
        }

        @MainThread
        public static void r(@NotNull c cVar, @NotNull i iVar, @NotNull z.c cVar2) {
        }

        @WorkerThread
        public static void b(@NotNull c cVar, @NotNull i iVar, @NotNull m.i iVar2, @NotNull n nVar) {
        }

        @WorkerThread
        public static void d(@NotNull c cVar, @NotNull i iVar, @NotNull p.i iVar2, @NotNull n nVar) {
        }

        @WorkerThread
        public static void a(@NotNull c cVar, @NotNull i iVar, @NotNull m.i iVar2, @NotNull n nVar, @Nullable m.g gVar) {
        }

        @WorkerThread
        public static void c(@NotNull c cVar, @NotNull i iVar, @NotNull p.i iVar2, @NotNull n nVar, @Nullable p.h hVar) {
        }
    }
}
