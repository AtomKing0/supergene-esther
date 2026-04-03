package androidx.compose.runtime;

import androidx.compose.runtime.Recomposer;
import h9.l;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.f;
import v8.k0;

/* JADX INFO: compiled from: Recomposer.kt */
/* JADX INFO: loaded from: classes.dex */
final class Recomposer$effectJob$1$1$1$1 extends v implements l<Throwable, k0> {
    final /* synthetic */ Throwable $throwable;
    final /* synthetic */ Recomposer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Recomposer$effectJob$1$1$1$1(Recomposer recomposer, Throwable th) {
        super(1);
        this.this$0 = recomposer;
        this.$throwable = th;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
        invoke2(th);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable Throwable th) {
        Object obj = this.this$0.stateLock;
        Recomposer recomposer = this.this$0;
        Throwable th2 = this.$throwable;
        synchronized (obj) {
            if (th2 != null) {
                if (th != null) {
                    if (!(!(th instanceof CancellationException))) {
                        th = null;
                    }
                    if (th != null) {
                        f.a(th2, th);
                    }
                }
            }
            th2 = null;
            recomposer.closeCause = th2;
            recomposer._state.setValue(Recomposer.State.ShutDown);
            k0 k0Var = k0.f35197a;
        }
    }
}
