package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class t extends d2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final p<?> f29979e;

    public t(@NotNull p<?> pVar) {
        this.f29979e = pVar;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ v8.k0 invoke(Throwable th) {
        q(th);
        return v8.k0.f35197a;
    }

    @Override // kotlinx.coroutines.e0
    public void q(@Nullable Throwable th) {
        p<?> pVar = this.f29979e;
        pVar.J(pVar.x(r()));
    }
}
