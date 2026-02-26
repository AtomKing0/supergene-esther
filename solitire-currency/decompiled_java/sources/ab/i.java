package ab;

import ab.c;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: DefaultCallAdapterFactory.java */
/* JADX INFO: loaded from: classes5.dex */
final class i extends c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f410a;

    /* JADX INFO: compiled from: DefaultCallAdapterFactory.java */
    class a implements c<Object, ab.b<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Executor f412b;

        a(Type type, Executor executor) {
            this.f411a = type;
            this.f412b = executor;
        }

        @Override // ab.c
        public Type a() {
            return this.f411a;
        }

        @Override // ab.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public ab.b<Object> b(ab.b<Object> bVar) {
            Executor executor = this.f412b;
            return executor == null ? bVar : new b(executor, bVar);
        }
    }

    /* JADX INFO: compiled from: DefaultCallAdapterFactory.java */
    static final class b<T> implements ab.b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Executor f414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ab.b<T> f415b;

        /* JADX INFO: compiled from: DefaultCallAdapterFactory.java */
        class a implements d<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f416a;

            a(d dVar) {
                this.f416a = dVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void e(d dVar, Throwable th) {
                dVar.b(b.this, th);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void f(d dVar, y yVar) {
                if (b.this.f415b.isCanceled()) {
                    dVar.b(b.this, new IOException("Canceled"));
                } else {
                    dVar.a(b.this, yVar);
                }
            }

            @Override // ab.d
            public void a(ab.b<T> bVar, final y<T> yVar) {
                Executor executor = b.this.f414a;
                final d dVar = this.f416a;
                executor.execute(new Runnable() { // from class: ab.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f418a.f(dVar, yVar);
                    }
                });
            }

            @Override // ab.d
            public void b(ab.b<T> bVar, final Throwable th) {
                Executor executor = b.this.f414a;
                final d dVar = this.f416a;
                executor.execute(new Runnable() { // from class: ab.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f421a.e(dVar, th);
                    }
                });
            }
        }

        b(Executor executor, ab.b<T> bVar) {
            this.f414a = executor;
            this.f415b = bVar;
        }

        @Override // ab.b
        public ga.b0 a() {
            return this.f415b.a();
        }

        @Override // ab.b
        public void cancel() {
            this.f415b.cancel();
        }

        @Override // ab.b
        public y<T> execute() throws IOException {
            return this.f415b.execute();
        }

        @Override // ab.b
        public void i0(d<T> dVar) {
            Objects.requireNonNull(dVar, "callback == null");
            this.f415b.i0(new a(dVar));
        }

        @Override // ab.b
        public boolean isCanceled() {
            return this.f415b.isCanceled();
        }

        @Override // ab.b
        /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
        public ab.b<T> m0clone() {
            return new b(this.f414a, this.f415b.m0clone());
        }
    }

    i(Executor executor) {
        this.f410a = executor;
    }

    @Override // ab.c.a
    public c<?, ?> a(Type type, Annotation[] annotationArr, z zVar) {
        if (c.a.c(type) != ab.b.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return new a(d0.g(0, (ParameterizedType) type), d0.l(annotationArr, b0.class) ? null : this.f410a);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
