package y7;

import e8.c;
import f8.b;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.o0;
import kotlinx.coroutines.b2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: DefaultTransformersJvm.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: compiled from: DefaultTransformersJvm.kt */
    public static final class a extends b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private final Long f36701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final e8.c f36702b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f36703c;

        a(a8.c cVar, e8.c cVar2, Object obj) {
            this.f36703c = obj;
            String strH = cVar.b().h(e8.o.f25274a.g());
            this.f36701a = strH != null ? Long.valueOf(Long.parseLong(strH)) : null;
            this.f36702b = cVar2 == null ? c.a.f25201a.a() : cVar2;
        }

        @Override // f8.b
        @Nullable
        public Long a() {
            return this.f36701a;
        }

        @Override // f8.b
        @NotNull
        public e8.c b() {
            return this.f36702b;
        }

        @Override // f8.b.c
        @NotNull
        public io.ktor.utils.io.g d() {
            return io.ktor.utils.io.jvm.javaio.h.c((InputStream) this.f36703c, null, null, 3, null);
        }
    }

    /* JADX INFO: compiled from: DefaultTransformersJvm.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.plugins.DefaultTransformersJvmKt$platformResponseDefaultTransformers$1", f = "DefaultTransformersJvm.kt", l = {36}, m = "invokeSuspend")
    static final class b extends kotlin.coroutines.jvm.internal.l implements h9.q<l8.e<b8.d, t7.b>, b8.d, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f36704j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private /* synthetic */ Object f36705k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f36706l;

        /* JADX INFO: compiled from: DefaultTransformersJvm.kt */
        public static final class a extends InputStream {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ InputStream f36707a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ l8.e<b8.d, t7.b> f36708b;

            a(InputStream inputStream, l8.e<b8.d, t7.b> eVar) {
                this.f36707a = inputStream;
                this.f36708b = eVar;
            }

            @Override // java.io.InputStream
            public int available() {
                return this.f36707a.available();
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                super.close();
                this.f36707a.close();
                b8.e.d(this.f36708b.c().f());
            }

            @Override // java.io.InputStream
            public int read() {
                return this.f36707a.read();
            }

            @Override // java.io.InputStream
            public int read(@NotNull byte[] b10, int i10, int i11) {
                kotlin.jvm.internal.t.i(b10, "b");
                return this.f36707a.read(b10, i10, i11);
            }
        }

        b(z8.d<? super b> dVar) {
            super(3, dVar);
        }

        @Override // h9.q
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull l8.e<b8.d, t7.b> eVar, @NotNull b8.d dVar, @Nullable z8.d<? super k0> dVar2) {
            b bVar = new b(dVar2);
            bVar.f36705k = eVar;
            bVar.f36706l = dVar;
            return bVar.invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f36704j;
            if (i10 == 0) {
                v8.u.b(obj);
                l8.e eVar = (l8.e) this.f36705k;
                b8.d dVar = (b8.d) this.f36706l;
                m8.a aVarA = dVar.a();
                Object objB = dVar.b();
                if (!(objB instanceof io.ktor.utils.io.g)) {
                    return k0.f35197a;
                }
                if (kotlin.jvm.internal.t.d(aVarA.a(), o0.b(InputStream.class))) {
                    b8.d dVar2 = new b8.d(aVarA, new a(io.ktor.utils.io.jvm.javaio.b.c((io.ktor.utils.io.g) objB, (b2) ((t7.b) eVar.c()).getCoroutineContext().get(b2.O7)), eVar));
                    this.f36705k = null;
                    this.f36704j = 1;
                    if (eVar.e(dVar2, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            return k0.f35197a;
        }
    }

    @Nullable
    public static final f8.b a(@Nullable e8.c cVar, @NotNull a8.c context, @NotNull Object body) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(body, "body");
        if (body instanceof InputStream) {
            return new a(context, cVar, body);
        }
        return null;
    }

    public static final void b(@NotNull s7.a aVar) {
        kotlin.jvm.internal.t.i(aVar, "<this>");
        aVar.B().l(b8.f.f2253h.a(), new b(null));
    }
}
