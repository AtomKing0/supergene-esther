package androidx.compose.runtime;

import androidx.compose.runtime.BroadcastFrameClock;
import h9.l;
import java.util.List;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: BroadcastFrameClock.kt */
/* JADX INFO: loaded from: classes.dex */
final class BroadcastFrameClock$withFrameNanos$2$1 extends v implements l<Throwable, k0> {
    final /* synthetic */ n0<BroadcastFrameClock.FrameAwaiter<R>> $awaiter;
    final /* synthetic */ BroadcastFrameClock this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BroadcastFrameClock$withFrameNanos$2$1(BroadcastFrameClock broadcastFrameClock, n0<BroadcastFrameClock.FrameAwaiter<R>> n0Var) {
        super(1);
        this.this$0 = broadcastFrameClock;
        this.$awaiter = n0Var;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
        invoke2(th);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable Throwable th) {
        BroadcastFrameClock.FrameAwaiter frameAwaiter;
        Object obj = this.this$0.lock;
        BroadcastFrameClock broadcastFrameClock = this.this$0;
        n0<BroadcastFrameClock.FrameAwaiter<R>> n0Var = this.$awaiter;
        synchronized (obj) {
            List list = broadcastFrameClock.awaiters;
            Object obj2 = n0Var.f29834a;
            if (obj2 == null) {
                t.A("awaiter");
                frameAwaiter = null;
            } else {
                frameAwaiter = (BroadcastFrameClock.FrameAwaiter) obj2;
            }
            list.remove(frameAwaiter);
            k0 k0Var = k0.f35197a;
        }
    }
}
