package a8;

import e8.k;
import e8.p0;
import e8.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DefaultHttpRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final t7.b f333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final t f334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final p0 f335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final f8.b f336d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final k f337e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final g8.b f338f;

    public a(@NotNull t7.b call, @NotNull d data) {
        kotlin.jvm.internal.t.i(call, "call");
        kotlin.jvm.internal.t.i(data, "data");
        this.f333a = call;
        this.f334b = data.f();
        this.f335c = data.h();
        this.f336d = data.b();
        this.f337e = data.e();
        this.f338f = data.a();
    }

    @Override // a8.b
    @NotNull
    public t7.b R() {
        return this.f333a;
    }

    @Override // e8.q
    @NotNull
    public k b() {
        return this.f337e;
    }

    @Override // a8.b
    @NotNull
    public g8.b getAttributes() {
        return this.f338f;
    }

    @Override // a8.b, kotlinx.coroutines.o0
    @NotNull
    public z8.g getCoroutineContext() {
        return R().getCoroutineContext();
    }

    @Override // a8.b
    @NotNull
    public t getMethod() {
        return this.f334b;
    }

    @Override // a8.b
    @NotNull
    public p0 getUrl() {
        return this.f335c;
    }
}
