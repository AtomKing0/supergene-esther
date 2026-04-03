package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NonCancellable.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class p2 extends z8.a implements b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final p2 f29966a = new p2();

    private p2() {
        super(b2.O7);
    }

    @Override // kotlinx.coroutines.b2
    @NotNull
    public u G0(@NotNull w wVar) {
        return q2.f29976a;
    }

    @Override // kotlinx.coroutines.b2
    @NotNull
    public g1 J(@NotNull h9.l<? super Throwable, v8.k0> lVar) {
        return q2.f29976a;
    }

    @Override // kotlinx.coroutines.b2
    @Nullable
    public b2 getParent() {
        return null;
    }

    @Override // kotlinx.coroutines.b2
    @NotNull
    public g1 h0(boolean z10, boolean z11, @NotNull h9.l<? super Throwable, v8.k0> lVar) {
        return q2.f29976a;
    }

    @Override // kotlinx.coroutines.b2
    public boolean i() {
        return false;
    }

    @Override // kotlinx.coroutines.b2
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.b2
    public boolean isCancelled() {
        return false;
    }

    @Override // kotlinx.coroutines.b2
    public boolean start() {
        return false;
    }

    @NotNull
    public String toString() {
        return "NonCancellable";
    }

    @Override // kotlinx.coroutines.b2
    @NotNull
    public CancellationException x() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // kotlinx.coroutines.b2
    @Nullable
    public Object z(@NotNull z8.d<? super v8.k0> dVar) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.b2
    public void cancel(@Nullable CancellationException cancellationException) {
    }
}
