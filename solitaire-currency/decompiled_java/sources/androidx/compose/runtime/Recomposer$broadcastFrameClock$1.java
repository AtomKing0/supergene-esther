package androidx.compose.runtime;

import androidx.compose.runtime.Recomposer;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o;
import kotlinx.coroutines.p1;
import v8.k0;
import v8.t;

/* JADX INFO: compiled from: Recomposer.kt */
/* JADX INFO: loaded from: classes.dex */
final class Recomposer$broadcastFrameClock$1 extends v implements h9.a<k0> {
    final /* synthetic */ Recomposer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Recomposer$broadcastFrameClock$1(Recomposer recomposer) {
        super(0);
        this.this$0 = recomposer;
    }

    @Override // h9.a
    public /* bridge */ /* synthetic */ k0 invoke() {
        invoke2();
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        o oVarDeriveStateLocked;
        Object obj = this.this$0.stateLock;
        Recomposer recomposer = this.this$0;
        synchronized (obj) {
            oVarDeriveStateLocked = recomposer.deriveStateLocked();
            if (((Recomposer.State) recomposer._state.getValue()).compareTo(Recomposer.State.ShuttingDown) <= 0) {
                throw p1.a("Recomposer shutdown; frame clock awaiter will never resume", recomposer.closeCause);
            }
        }
        if (oVarDeriveStateLocked != null) {
            t.a aVar = t.f35208b;
            oVarDeriveStateLocked.resumeWith(t.b(k0.f35197a));
        }
    }
}
