package androidx.privacysandbox.ads.adservices.java.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import h9.l;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.v0;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: CoroutineAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
final class CoroutineAdapterKt$asListenableFuture$1$1 extends v implements l<Throwable, k0> {
    final /* synthetic */ CallbackToFutureAdapter.Completer<T> $completer;
    final /* synthetic */ v0<T> $this_asListenableFuture;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CoroutineAdapterKt$asListenableFuture$1$1(CallbackToFutureAdapter.Completer<T> completer, v0<? extends T> v0Var) {
        super(1);
        this.$completer = completer;
        this.$this_asListenableFuture = v0Var;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
        invoke2(th);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable Throwable th) {
        if (th == null) {
            this.$completer.set(this.$this_asListenableFuture.n());
        } else if (th instanceof CancellationException) {
            this.$completer.setCancelled();
        } else {
            this.$completer.setException(th);
        }
    }
}
