package t7;

import e8.k;
import e8.u;
import e8.v;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.h2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SavedCall.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g extends b8.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final e f34098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final a0 f34099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final v f34100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final u f34101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final j8.b f34102e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final j8.b f34103f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final k f34104g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final z8.g f34105h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private final io.ktor.utils.io.g f34106i;

    public g(@NotNull e call, @NotNull byte[] body, @NotNull b8.c origin) {
        t.i(call, "call");
        t.i(body, "body");
        t.i(origin, "origin");
        this.f34098a = call;
        a0 a0VarB = h2.b(null, 1, null);
        this.f34099b = a0VarB;
        this.f34100c = origin.f();
        this.f34101d = origin.g();
        this.f34102e = origin.d();
        this.f34103f = origin.e();
        this.f34104g = origin.b();
        this.f34105h = origin.getCoroutineContext().plus(a0VarB);
        this.f34106i = io.ktor.utils.io.d.a(body);
    }

    @Override // e8.q
    @NotNull
    public k b() {
        return this.f34104g;
    }

    @Override // b8.c
    @NotNull
    public io.ktor.utils.io.g c() {
        return this.f34106i;
    }

    @Override // b8.c
    @NotNull
    public j8.b d() {
        return this.f34102e;
    }

    @Override // b8.c
    @NotNull
    public j8.b e() {
        return this.f34103f;
    }

    @Override // b8.c
    @NotNull
    public v f() {
        return this.f34100c;
    }

    @Override // b8.c
    @NotNull
    public u g() {
        return this.f34101d;
    }

    @Override // kotlinx.coroutines.o0
    @NotNull
    public z8.g getCoroutineContext() {
        return this.f34105h;
    }

    @Override // b8.c
    @NotNull
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public e R() {
        return this.f34098a;
    }
}
