package androidx.compose.runtime;

import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.snapshots.Snapshot;
import h9.p;
import java.util.Set;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o;
import org.jetbrains.annotations.NotNull;
import v8.k0;
import v8.t;

/* JADX INFO: compiled from: Recomposer.kt */
/* JADX INFO: loaded from: classes.dex */
final class Recomposer$recompositionRunner$2$unregisterApplyObserver$1 extends v implements p<Set<? extends Object>, Snapshot, k0> {
    final /* synthetic */ Recomposer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Recomposer$recompositionRunner$2$unregisterApplyObserver$1(Recomposer recomposer) {
        super(2);
        this.this$0 = recomposer;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Set<? extends Object> set, Snapshot snapshot) {
        invoke2(set, snapshot);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Set<? extends Object> changed, @NotNull Snapshot snapshot) {
        o oVarDeriveStateLocked;
        t.i(changed, "changed");
        t.i(snapshot, "<anonymous parameter 1>");
        Object obj = this.this$0.stateLock;
        Recomposer recomposer = this.this$0;
        synchronized (obj) {
            if (((Recomposer.State) recomposer._state.getValue()).compareTo(Recomposer.State.Idle) >= 0) {
                recomposer.snapshotInvalidations.add(changed);
                oVarDeriveStateLocked = recomposer.deriveStateLocked();
            } else {
                oVarDeriveStateLocked = null;
            }
        }
        if (oVarDeriveStateLocked != null) {
            t.a aVar = v8.t.f35208b;
            oVarDeriveStateLocked.resumeWith(v8.t.b(k0.f35197a));
        }
    }
}
