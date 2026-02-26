package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class v extends d2 implements u {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final w f29988e;

    public v(@NotNull w wVar) {
        this.f29988e = wVar;
    }

    @Override // kotlinx.coroutines.u
    public boolean a(@NotNull Throwable th) {
        return r().N(th);
    }

    @Override // kotlinx.coroutines.u
    @NotNull
    public b2 getParent() {
        return r();
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ v8.k0 invoke(Throwable th) {
        q(th);
        return v8.k0.f35197a;
    }

    @Override // kotlinx.coroutines.e0
    public void q(@Nullable Throwable th) {
        this.f29988e.B(r());
    }
}
