package r9;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.j2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ChannelCoroutine.kt */
/* JADX INFO: loaded from: classes5.dex */
public class e<E> extends kotlinx.coroutines.a<k0> implements d<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final d<E> f33391d;

    public e(@NotNull z8.g gVar, @NotNull d<E> dVar, boolean z10, boolean z11) {
        super(gVar, z10, z11);
        this.f33391d = dVar;
    }

    @Override // kotlinx.coroutines.j2
    public void H(@NotNull Throwable th) {
        CancellationException cancellationExceptionJ0 = j2.J0(this, th, null, 1, null);
        this.f33391d.cancel(cancellationExceptionJ0);
        F(cancellationExceptionJ0);
    }

    @NotNull
    protected final d<E> V0() {
        return this.f33391d;
    }

    @Override // kotlinx.coroutines.j2, kotlinx.coroutines.b2
    public final void cancel(@Nullable CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new c2(M(), null, this);
        }
        H(cancellationException);
    }

    @Override // r9.u
    public boolean d(@Nullable Throwable th) {
        return this.f33391d.d(th);
    }

    @Override // r9.t
    @Nullable
    public Object e(@NotNull z8.d<? super h<? extends E>> dVar) {
        Object objE = this.f33391d.e(dVar);
        a9.d.e();
        return objE;
    }

    @Override // r9.u
    @NotNull
    public Object f(E e10) {
        return this.f33391d.f(e10);
    }

    @Override // r9.u
    public void g(@NotNull h9.l<? super Throwable, k0> lVar) {
        this.f33391d.g(lVar);
    }

    @Override // r9.t
    @NotNull
    public Object h() {
        return this.f33391d.h();
    }

    @Override // r9.t
    @NotNull
    public f<E> iterator() {
        return this.f33391d.iterator();
    }

    @Override // r9.u
    @Nullable
    public Object p(E e10, @NotNull z8.d<? super k0> dVar) {
        return this.f33391d.p(e10, dVar);
    }

    @Override // r9.t
    @Nullable
    public Object s(@NotNull z8.d<? super E> dVar) {
        return this.f33391d.s(dVar);
    }

    @Override // r9.u
    public boolean t() {
        return this.f33391d.t();
    }

    @NotNull
    public final d<E> U0() {
        return this;
    }
}
