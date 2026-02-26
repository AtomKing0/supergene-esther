package a4;

import a4.m;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: ListenerSet.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p f234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b<T> f235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CopyOnWriteArraySet<c<T>> f236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ArrayDeque<Runnable> f237e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayDeque<Runnable> f238f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f239g;

    /* JADX INFO: compiled from: ListenerSet.java */
    public interface a<T> {
        void invoke(T t10);
    }

    /* JADX INFO: compiled from: ListenerSet.java */
    public interface b<T> {
        void a(T t10, m mVar);
    }

    /* JADX INFO: compiled from: ListenerSet.java */
    private static final class c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private m.b f241b = new m.b();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f242c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f243d;

        public c(T t10) {
            this.f240a = t10;
        }

        public void a(int i10, a<T> aVar) {
            if (this.f243d) {
                return;
            }
            if (i10 != -1) {
                this.f241b.a(i10);
            }
            this.f242c = true;
            aVar.invoke(this.f240a);
        }

        public void b(b<T> bVar) {
            if (this.f243d || !this.f242c) {
                return;
            }
            m mVarE = this.f241b.e();
            this.f241b = new m.b();
            this.f242c = false;
            bVar.a(this.f240a, mVarE);
        }

        public void c(b<T> bVar) {
            this.f243d = true;
            if (this.f242c) {
                this.f242c = false;
                bVar.a(this.f240a, this.f241b.e());
            }
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            return this.f240a.equals(((c) obj).f240a);
        }

        public int hashCode() {
            return this.f240a.hashCode();
        }
    }

    public s(Looper looper, d dVar, b<T> bVar) {
        this(new CopyOnWriteArraySet(), looper, dVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(Message message) {
        Iterator<c<T>> it = this.f236d.iterator();
        while (it.hasNext()) {
            it.next().b(this.f235c);
            if (this.f234b.hasMessages(0)) {
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(CopyOnWriteArraySet copyOnWriteArraySet, int i10, a aVar) {
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(i10, aVar);
        }
    }

    public void c(T t10) {
        if (this.f239g) {
            return;
        }
        a4.a.e(t10);
        this.f236d.add(new c<>(t10));
    }

    @CheckResult
    public s<T> d(Looper looper, d dVar, b<T> bVar) {
        return new s<>(this.f236d, looper, dVar, bVar);
    }

    @CheckResult
    public s<T> e(Looper looper, b<T> bVar) {
        return d(looper, this.f233a, bVar);
    }

    public void f() {
        if (this.f238f.isEmpty()) {
            return;
        }
        if (!this.f234b.hasMessages(0)) {
            p pVar = this.f234b;
            pVar.a(pVar.obtainMessage(0));
        }
        boolean z10 = !this.f237e.isEmpty();
        this.f237e.addAll(this.f238f);
        this.f238f.clear();
        if (z10) {
            return;
        }
        while (!this.f237e.isEmpty()) {
            this.f237e.peekFirst().run();
            this.f237e.removeFirst();
        }
    }

    public void i(final int i10, final a<T> aVar) {
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.f236d);
        this.f238f.add(new Runnable() { // from class: a4.r
            @Override // java.lang.Runnable
            public final void run() {
                s.h(copyOnWriteArraySet, i10, aVar);
            }
        });
    }

    public void j() {
        Iterator<c<T>> it = this.f236d.iterator();
        while (it.hasNext()) {
            it.next().c(this.f235c);
        }
        this.f236d.clear();
        this.f239g = true;
    }

    public void k(T t10) {
        for (c<T> cVar : this.f236d) {
            if (cVar.f240a.equals(t10)) {
                cVar.c(this.f235c);
                this.f236d.remove(cVar);
            }
        }
    }

    public void l(int i10, a<T> aVar) {
        i(i10, aVar);
        f();
    }

    private s(CopyOnWriteArraySet<c<T>> copyOnWriteArraySet, Looper looper, d dVar, b<T> bVar) {
        this.f233a = dVar;
        this.f236d = copyOnWriteArraySet;
        this.f235c = bVar;
        this.f237e = new ArrayDeque<>();
        this.f238f = new ArrayDeque<>();
        this.f234b = dVar.createHandler(looper, new Handler.Callback() { // from class: a4.q
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f229a.g(message);
            }
        });
    }
}
