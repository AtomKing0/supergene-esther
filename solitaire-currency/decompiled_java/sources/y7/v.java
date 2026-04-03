package y7;

import org.jetbrains.annotations.NotNull;
import v8.k0;
import y7.u;

/* JADX INFO: compiled from: HttpRequestRetry.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final xa.a f36855a = k8.a.a("io.ktor.client.plugins.HttpRequestRetry");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final g8.a<Integer> f36856b = new g8.a<>("MaxRetriesPerRequestAttributeKey");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final g8.a<h9.q<u.f, a8.b, b8.c, Boolean>> f36857c = new g8.a<>("ShouldRetryPerRequestAttributeKey");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private static final g8.a<h9.q<u.f, a8.c, Throwable, Boolean>> f36858d = new g8.a<>("ShouldRetryOnExceptionPerRequestAttributeKey");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final g8.a<h9.p<u.c, a8.c, k0>> f36859e = new g8.a<>("ModifyRequestPerRequestAttributeKey");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final g8.a<h9.p<u.b, Integer, Long>> f36860f = new g8.a<>("RetryDelayPerRequestAttributeKey");

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(Throwable th) {
        Throwable thA = c8.d.a(th);
        return (thA instanceof w) || (thA instanceof x7.a) || (thA instanceof x7.b);
    }

    public static final void i(@NotNull a8.c cVar, @NotNull h9.l<? super u.a, k0> block) {
        kotlin.jvm.internal.t.i(cVar, "<this>");
        kotlin.jvm.internal.t.i(block, "block");
        u.a aVar = new u.a();
        block.invoke(aVar);
        cVar.c().c(f36857c, aVar.j());
        cVar.c().c(f36858d, aVar.k());
        cVar.c().c(f36860f, aVar.g());
        cVar.c().c(f36856b, Integer.valueOf(aVar.h()));
        cVar.c().c(f36859e, aVar.i());
    }
}
