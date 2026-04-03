package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes5.dex */
final class u2 extends i2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final z8.d<v8.k0> f29987e;

    /* JADX WARN: Multi-variable type inference failed */
    public u2(@NotNull z8.d<? super v8.k0> dVar) {
        this.f29987e = dVar;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ v8.k0 invoke(Throwable th) {
        q(th);
        return v8.k0.f35197a;
    }

    @Override // kotlinx.coroutines.e0
    public void q(@Nullable Throwable th) {
        z8.d<v8.k0> dVar = this.f29987e;
        t.a aVar = v8.t.f35208b;
        dVar.resumeWith(v8.t.b(v8.k0.f35197a));
    }
}
