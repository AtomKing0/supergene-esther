package androidx.work;

import com.google.common.util.concurrent.m;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.o;
import v8.t;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: ListenableFuture.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ListenableFutureKt$await$2$1 implements Runnable {
    final /* synthetic */ o<R> $cancellableContinuation;
    final /* synthetic */ m<R> $this_await;

    /* JADX WARN: Multi-variable type inference failed */
    public ListenableFutureKt$await$2$1(o<? super R> oVar, m<R> mVar) {
        this.$cancellableContinuation = oVar;
        this.$this_await = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            d dVar = this.$cancellableContinuation;
            t.a aVar = t.f35208b;
            dVar.resumeWith(t.b(this.$this_await.get()));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                cause = th;
            }
            if (th instanceof CancellationException) {
                this.$cancellableContinuation.b(cause);
                return;
            }
            d dVar2 = this.$cancellableContinuation;
            t.a aVar2 = t.f35208b;
            dVar2.resumeWith(t.b(u.a(cause)));
        }
    }
}
