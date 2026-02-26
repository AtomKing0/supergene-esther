package t9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.g;

/* JADX INFO: compiled from: SafeCollector.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class l implements z8.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Throwable f34166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ z8.g f34167b;

    public l(@NotNull Throwable th, @NotNull z8.g gVar) {
        this.f34166a = th;
        this.f34167b = gVar;
    }

    @Override // z8.g
    public <R> R fold(R r10, @NotNull h9.p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) this.f34167b.fold(r10, pVar);
    }

    @Override // z8.g
    @Nullable
    public <E extends g.b> E get(@NotNull g.c<E> cVar) {
        return (E) this.f34167b.get(cVar);
    }

    @Override // z8.g
    @NotNull
    public z8.g minusKey(@NotNull g.c<?> cVar) {
        return this.f34167b.minusKey(cVar);
    }

    @Override // z8.g
    @NotNull
    public z8.g plus(@NotNull z8.g gVar) {
        return this.f34167b.plus(gVar);
    }
}
