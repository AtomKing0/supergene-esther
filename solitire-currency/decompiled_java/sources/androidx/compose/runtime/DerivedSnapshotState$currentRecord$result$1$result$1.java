package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.StateObject;
import h9.l;
import java.util.HashSet;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: DerivedState.kt */
/* JADX INFO: loaded from: classes.dex */
final class DerivedSnapshotState$currentRecord$result$1$result$1 extends v implements l<Object, k0> {
    final /* synthetic */ HashSet<StateObject> $newDependencies;
    final /* synthetic */ DerivedSnapshotState<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DerivedSnapshotState$currentRecord$result$1$result$1(DerivedSnapshotState<T> derivedSnapshotState, HashSet<StateObject> hashSet) {
        super(1);
        this.this$0 = derivedSnapshotState;
        this.$newDependencies = hashSet;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(Object obj) {
        invoke2(obj);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Object it) {
        t.i(it, "it");
        if (it == this.this$0) {
            throw new IllegalStateException("A derived state calculation cannot read itself".toString());
        }
        if (it instanceof StateObject) {
            this.$newDependencies.add(it);
        }
    }
}
