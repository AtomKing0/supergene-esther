package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes5.dex */
final class a2 extends i2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final h9.l<Throwable, v8.k0> f29851e;

    /* JADX WARN: Multi-variable type inference failed */
    public a2(@NotNull h9.l<? super Throwable, v8.k0> lVar) {
        this.f29851e = lVar;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ v8.k0 invoke(Throwable th) {
        q(th);
        return v8.k0.f35197a;
    }

    @Override // kotlinx.coroutines.e0
    public void q(@Nullable Throwable th) {
        this.f29851e.invoke(th);
    }
}
