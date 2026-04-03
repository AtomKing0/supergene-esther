package androidx.compose.runtime;

import h9.l;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Latch.kt */
/* JADX INFO: loaded from: classes.dex */
final class Latch$await$2$2 extends v implements l<Throwable, k0> {
    final /* synthetic */ o<k0> $co;
    final /* synthetic */ Latch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    Latch$await$2$2(Latch latch, o<? super k0> oVar) {
        super(1);
        this.this$0 = latch;
        this.$co = oVar;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
        invoke2(th);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable Throwable th) {
        Object obj = this.this$0.lock;
        Latch latch = this.this$0;
        o<k0> oVar = this.$co;
        synchronized (obj) {
            latch.awaiters.remove(oVar);
            k0 k0Var = k0.f35197a;
        }
    }
}
