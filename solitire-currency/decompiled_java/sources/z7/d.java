package z7;

import e8.k;
import e8.u;
import e8.v;
import io.ktor.utils.io.g;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DelegatedCall.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d extends b8.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final t7.b f37597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final g f37598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final b8.c f37599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final z8.g f37600d;

    public d(@NotNull t7.b call, @NotNull g content, @NotNull b8.c origin) {
        t.i(call, "call");
        t.i(content, "content");
        t.i(origin, "origin");
        this.f37597a = call;
        this.f37598b = content;
        this.f37599c = origin;
        this.f37600d = origin.getCoroutineContext();
    }

    @Override // b8.c
    @NotNull
    public t7.b R() {
        return this.f37597a;
    }

    @Override // e8.q
    @NotNull
    public k b() {
        return this.f37599c.b();
    }

    @Override // b8.c
    @NotNull
    public g c() {
        return this.f37598b;
    }

    @Override // b8.c
    @NotNull
    public j8.b d() {
        return this.f37599c.d();
    }

    @Override // b8.c
    @NotNull
    public j8.b e() {
        return this.f37599c.e();
    }

    @Override // b8.c
    @NotNull
    public v f() {
        return this.f37599c.f();
    }

    @Override // b8.c
    @NotNull
    public u g() {
        return this.f37599c.g();
    }

    @Override // kotlinx.coroutines.o0
    @NotNull
    public z8.g getCoroutineContext() {
        return this.f37600d;
    }
}
