package z7;

import e8.k;
import e8.p0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import z8.g;

/* JADX INFO: compiled from: DelegatedCall.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c implements a8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final t7.b f37595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ a8.b f37596b;

    public c(@NotNull t7.b call, @NotNull a8.b origin) {
        t.i(call, "call");
        t.i(origin, "origin");
        this.f37595a = call;
        this.f37596b = origin;
    }

    @Override // a8.b
    @NotNull
    public t7.b R() {
        return this.f37595a;
    }

    @Override // e8.q
    @NotNull
    public k b() {
        return this.f37596b.b();
    }

    @Override // a8.b
    @NotNull
    public g8.b getAttributes() {
        return this.f37596b.getAttributes();
    }

    @Override // a8.b, kotlinx.coroutines.o0
    @NotNull
    public g getCoroutineContext() {
        return this.f37596b.getCoroutineContext();
    }

    @Override // a8.b
    @NotNull
    public e8.t getMethod() {
        return this.f37596b.getMethod();
    }

    @Override // a8.b
    @NotNull
    public p0 getUrl() {
        return this.f37596b.getUrl();
    }
}
