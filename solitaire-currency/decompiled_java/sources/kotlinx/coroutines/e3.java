package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Timeout.kt */
/* JADX INFO: loaded from: classes5.dex */
final class e3<U, T extends U> extends u9.d0<T> implements Runnable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f29889e;

    public e3(long j10, @NotNull z8.d<? super U> dVar) {
        super(dVar.getContext(), dVar);
        this.f29889e = j10;
    }

    @Override // java.lang.Runnable
    public void run() {
        F(f3.a(this.f29889e, y0.b(getContext()), this));
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.j2
    @NotNull
    public String t0() {
        return super.t0() + "(timeMillis=" + this.f29889e + ')';
    }
}
