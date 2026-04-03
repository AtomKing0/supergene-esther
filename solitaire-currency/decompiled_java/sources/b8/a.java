package b8;

import e8.k;
import e8.u;
import e8.v;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DefaultHttpResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final t7.b f2233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final z8.g f2234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final v f2235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final u f2236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final j8.b f2237e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final j8.b f2238f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final io.ktor.utils.io.g f2239g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final k f2240h;

    public a(@NotNull t7.b call, @NotNull a8.g responseData) {
        t.i(call, "call");
        t.i(responseData, "responseData");
        this.f2233a = call;
        this.f2234b = responseData.b();
        this.f2235c = responseData.f();
        this.f2236d = responseData.g();
        this.f2237e = responseData.d();
        this.f2238f = responseData.e();
        Object objA = responseData.a();
        io.ktor.utils.io.g gVar = objA instanceof io.ktor.utils.io.g ? (io.ktor.utils.io.g) objA : null;
        this.f2239g = gVar == null ? io.ktor.utils.io.g.f26800a.a() : gVar;
        this.f2240h = responseData.c();
    }

    @Override // b8.c
    @NotNull
    public t7.b R() {
        return this.f2233a;
    }

    @Override // e8.q
    @NotNull
    public k b() {
        return this.f2240h;
    }

    @Override // b8.c
    @NotNull
    public io.ktor.utils.io.g c() {
        return this.f2239g;
    }

    @Override // b8.c
    @NotNull
    public j8.b d() {
        return this.f2237e;
    }

    @Override // b8.c
    @NotNull
    public j8.b e() {
        return this.f2238f;
    }

    @Override // b8.c
    @NotNull
    public v f() {
        return this.f2235c;
    }

    @Override // b8.c
    @NotNull
    public u g() {
        return this.f2236d;
    }

    @Override // kotlinx.coroutines.o0
    @NotNull
    public z8.g getCoroutineContext() {
        return this.f2234b;
    }
}
