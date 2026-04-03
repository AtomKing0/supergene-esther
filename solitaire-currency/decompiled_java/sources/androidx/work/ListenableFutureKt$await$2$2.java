package androidx.work;

import com.google.common.util.concurrent.m;
import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ListenableFuture.kt */
/* JADX INFO: loaded from: classes2.dex */
final class ListenableFutureKt$await$2$2 extends v implements l<Throwable, k0> {
    final /* synthetic */ m<R> $this_await;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListenableFutureKt$await$2$2(m<R> mVar) {
        super(1);
        this.$this_await = mVar;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
        invoke2(th);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable Throwable th) {
        this.$this_await.cancel(false);
    }
}
