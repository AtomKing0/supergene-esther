package ab;

import ab.c;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: compiled from: CompletableFutureCallAdapterFactory.java */
/* JADX INFO: loaded from: classes5.dex */
@IgnoreJRERequirement
final class g extends c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final c.a f402a = new g();

    /* JADX INFO: compiled from: CompletableFutureCallAdapterFactory.java */
    @IgnoreJRERequirement
    private static final class a<R> implements ab.c<R, CompletableFuture<R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Type f403a;

        /* JADX INFO: renamed from: ab.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CompletableFutureCallAdapterFactory.java */
        class C0009a implements d<R> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ CompletableFuture f404a;

            C0009a(CompletableFuture completableFuture) {
                this.f404a = completableFuture;
            }

            @Override // ab.d
            public void a(ab.b<R> bVar, y<R> yVar) {
                if (yVar.d()) {
                    this.f404a.complete(yVar.a());
                } else {
                    this.f404a.completeExceptionally(new l(yVar));
                }
            }

            @Override // ab.d
            public void b(ab.b<R> bVar, Throwable th) {
                this.f404a.completeExceptionally(th);
            }
        }

        a(Type type) {
            this.f403a = type;
        }

        @Override // ab.c
        public Type a() {
            return this.f403a;
        }

        @Override // ab.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public CompletableFuture<R> b(ab.b<R> bVar) {
            b bVar2 = new b(bVar);
            bVar.i0(new C0009a(bVar2));
            return bVar2;
        }
    }

    /* JADX INFO: compiled from: CompletableFutureCallAdapterFactory.java */
    private static final class b<T> extends CompletableFuture<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ab.b<?> f406a;

        b(ab.b<?> bVar) {
            this.f406a = bVar;
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean cancel(boolean z10) {
            if (z10) {
                this.f406a.cancel();
            }
            return super.cancel(z10);
        }
    }

    /* JADX INFO: compiled from: CompletableFutureCallAdapterFactory.java */
    @IgnoreJRERequirement
    private static final class c<R> implements ab.c<R, CompletableFuture<y<R>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Type f407a;

        /* JADX INFO: compiled from: CompletableFutureCallAdapterFactory.java */
        class a implements d<R> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ CompletableFuture f408a;

            a(CompletableFuture completableFuture) {
                this.f408a = completableFuture;
            }

            @Override // ab.d
            public void a(ab.b<R> bVar, y<R> yVar) {
                this.f408a.complete(yVar);
            }

            @Override // ab.d
            public void b(ab.b<R> bVar, Throwable th) {
                this.f408a.completeExceptionally(th);
            }
        }

        c(Type type) {
            this.f407a = type;
        }

        @Override // ab.c
        public Type a() {
            return this.f407a;
        }

        @Override // ab.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public CompletableFuture<y<R>> b(ab.b<R> bVar) {
            b bVar2 = new b(bVar);
            bVar.i0(new a(bVar2));
            return bVar2;
        }
    }

    g() {
    }

    @Override // ab.c.a
    public ab.c<?, ?> a(Type type, Annotation[] annotationArr, z zVar) {
        if (c.a.c(type) != CompletableFuture.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        }
        Type typeB = c.a.b(0, (ParameterizedType) type);
        if (c.a.c(typeB) != y.class) {
            return new a(typeB);
        }
        if (typeB instanceof ParameterizedType) {
            return new c(c.a.b(0, (ParameterizedType) typeB));
        }
        throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
    }
}
