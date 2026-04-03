package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: SnapshotStateObserver.kt */
/* JADX INFO: loaded from: classes.dex */
final class SnapshotStateObserver$readObserver$1 extends v implements l<Object, k0> {
    final /* synthetic */ SnapshotStateObserver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnapshotStateObserver$readObserver$1(SnapshotStateObserver snapshotStateObserver) {
        super(1);
        this.this$0 = snapshotStateObserver;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Object obj) {
        invoke2(obj);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Object state) {
        t.i(state, "state");
        if (this.this$0.isPaused) {
            return;
        }
        MutableVector mutableVector = this.this$0.applyMaps;
        SnapshotStateObserver snapshotStateObserver = this.this$0;
        synchronized (mutableVector) {
            SnapshotStateObserver.ApplyMap applyMap = snapshotStateObserver.currentMap;
            t.f(applyMap);
            applyMap.addValue(state);
            k0 k0Var = k0.f35197a;
        }
    }
}
