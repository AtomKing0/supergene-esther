package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Builders.common.kt */
/* JADX INFO: loaded from: classes5.dex */
final class l2<T> extends w0<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final z8.d<v8.k0> f29955d;

    public l2(@NotNull z8.g gVar, @NotNull h9.p<? super o0, ? super z8.d<? super T>, ? extends Object> pVar) {
        super(gVar, false);
        this.f29955d = a9.c.a(pVar, this, this);
    }

    @Override // kotlinx.coroutines.j2
    protected void z0() throws Throwable {
        v9.a.c(this.f29955d, this);
    }
}
