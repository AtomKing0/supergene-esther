package y7;

import a8.b;
import e8.p0;
import org.jetbrains.annotations.NotNull;
import v8.k0;
import y7.k;

/* JADX INFO: compiled from: HttpCallValidator.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final xa.a f36743a = k8.a.a("io.ktor.client.plugins.HttpCallValidator");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final g8.a<Boolean> f36744b = new g8.a<>("ExpectSuccessAttributeKey");

    /* JADX INFO: compiled from: HttpCallValidator.kt */
    public static final class a implements a8.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final e8.t f36745a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final p0 f36746b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final g8.b f36747c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        private final e8.k f36748d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a8.c f36749e;

        a(a8.c cVar) {
            this.f36749e = cVar;
            this.f36745a = cVar.h();
            this.f36746b = cVar.i().b();
            this.f36747c = cVar.c();
            this.f36748d = cVar.b().n();
        }

        @Override // a8.b
        @NotNull
        public t7.b R() {
            throw new IllegalStateException("Call is not initialized".toString());
        }

        @Override // e8.q
        @NotNull
        public e8.k b() {
            return this.f36748d;
        }

        @Override // a8.b
        @NotNull
        public g8.b getAttributes() {
            return this.f36747c;
        }

        @Override // a8.b, kotlinx.coroutines.o0
        @NotNull
        public z8.g getCoroutineContext() {
            return b.a.a(this);
        }

        @Override // a8.b
        @NotNull
        public e8.t getMethod() {
            return this.f36745a;
        }

        @Override // a8.b
        @NotNull
        public p0 getUrl() {
            return this.f36746b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a a(a8.c cVar) {
        return new a(cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void b(@NotNull s7.b<?> bVar, @NotNull h9.l<? super k.b, k0> block) {
        kotlin.jvm.internal.t.i(bVar, "<this>");
        kotlin.jvm.internal.t.i(block, "block");
        bVar.i(k.f36711d, block);
    }

    @NotNull
    public static final g8.a<Boolean> e() {
        return f36744b;
    }
}
