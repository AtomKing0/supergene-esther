package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class i1 extends i2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final g1 f29905e;

    public i1(@NotNull g1 g1Var) {
        this.f29905e = g1Var;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ v8.k0 invoke(Throwable th) {
        q(th);
        return v8.k0.f35197a;
    }

    @Override // kotlinx.coroutines.e0
    public void q(@Nullable Throwable th) {
        this.f29905e.dispose();
    }
}
