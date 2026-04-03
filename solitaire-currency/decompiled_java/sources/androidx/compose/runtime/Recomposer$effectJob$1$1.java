package androidx.compose.runtime;

import androidx.compose.runtime.Recomposer;
import h9.l;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.o;
import kotlinx.coroutines.p1;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;

/* JADX INFO: compiled from: Recomposer.kt */
/* JADX INFO: loaded from: classes.dex */
final class Recomposer$effectJob$1$1 extends v implements l<Throwable, k0> {
    final /* synthetic */ Recomposer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Recomposer$effectJob$1$1(Recomposer recomposer) {
        super(1);
        this.this$0 = recomposer;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
        invoke2(th);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable Throwable th) {
        o oVar;
        o oVar2;
        CancellationException cancellationExceptionA = p1.a("Recomposer effect job completed", th);
        Object obj = this.this$0.stateLock;
        Recomposer recomposer = this.this$0;
        synchronized (obj) {
            b2 b2Var = recomposer.runnerJob;
            oVar = null;
            if (b2Var != null) {
                recomposer._state.setValue(Recomposer.State.ShuttingDown);
                if (recomposer.isClosed) {
                    if (recomposer.workContinuation != null) {
                        oVar2 = recomposer.workContinuation;
                    }
                    recomposer.workContinuation = null;
                    b2Var.J(new Recomposer$effectJob$1$1$1$1(recomposer, th));
                    oVar = oVar2;
                } else {
                    b2Var.cancel(cancellationExceptionA);
                }
                oVar2 = null;
                recomposer.workContinuation = null;
                b2Var.J(new Recomposer$effectJob$1$1$1$1(recomposer, th));
                oVar = oVar2;
            } else {
                recomposer.closeCause = cancellationExceptionA;
                recomposer._state.setValue(Recomposer.State.ShutDown);
                k0 k0Var = k0.f35197a;
            }
        }
        if (oVar != null) {
            t.a aVar = t.f35208b;
            oVar.resumeWith(t.b(k0.f35197a));
        }
    }
}
