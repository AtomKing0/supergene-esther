package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateRecord;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SnapshotState.kt */
/* JADX INFO: loaded from: classes.dex */
public class SnapshotMutableStateImpl<T> implements StateObject, SnapshotMutableState<T> {

    @NotNull
    private StateStateRecord<T> next;

    @NotNull
    private final SnapshotMutationPolicy<T> policy;

    /* JADX INFO: compiled from: SnapshotState.kt */
    private static final class StateStateRecord<T> extends StateRecord {
        private T value;

        public StateStateRecord(T t10) {
            this.value = t10;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(@NotNull StateRecord value) {
            t.i(value, "value");
            this.value = ((StateStateRecord) value).value;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        @NotNull
        public StateRecord create() {
            return new StateStateRecord(this.value);
        }

        public final T getValue() {
            return this.value;
        }

        public final void setValue(T t10) {
            this.value = t10;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotMutableStateImpl$component2$1, reason: invalid class name */
    /* JADX INFO: compiled from: SnapshotState.kt */
    static final class AnonymousClass1 extends v implements l<T, k0> {
        final /* synthetic */ SnapshotMutableStateImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SnapshotMutableStateImpl<T> snapshotMutableStateImpl) {
            super(1);
            this.this$0 = snapshotMutableStateImpl;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Object obj) {
            invoke2(obj);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(T t10) {
            this.this$0.setValue(t10);
        }
    }

    public SnapshotMutableStateImpl(T t10, @NotNull SnapshotMutationPolicy<T> policy) {
        t.i(policy, "policy");
        this.policy = policy;
        this.next = new StateStateRecord<>(t10);
    }

    @Override // androidx.compose.runtime.MutableState
    public T component1() {
        return getValue();
    }

    @Override // androidx.compose.runtime.MutableState
    @NotNull
    public l<T, k0> component2() {
        return new AnonymousClass1(this);
    }

    public final T getDebuggerDisplayValue() {
        return (T) ((StateStateRecord) SnapshotKt.current(this.next, Snapshot.Companion.getCurrent())).getValue();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    @NotNull
    public StateRecord getFirstStateRecord() {
        return this.next;
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotMutableState
    @NotNull
    public SnapshotMutationPolicy<T> getPolicy() {
        return this.policy;
    }

    @Override // androidx.compose.runtime.MutableState, androidx.compose.runtime.State
    public T getValue() {
        return (T) ((StateStateRecord) SnapshotKt.readable(this.next, this)).getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.snapshots.StateObject
    @Nullable
    public StateRecord mergeRecords(@NotNull StateRecord previous, @NotNull StateRecord current, @NotNull StateRecord applied) {
        t.i(previous, "previous");
        t.i(current, "current");
        t.i(applied, "applied");
        StateStateRecord stateStateRecord = (StateStateRecord) previous;
        StateStateRecord stateStateRecord2 = (StateStateRecord) current;
        StateStateRecord stateStateRecord3 = (StateStateRecord) applied;
        if (getPolicy().equivalent(stateStateRecord2.getValue(), stateStateRecord3.getValue())) {
            return current;
        }
        Object objMerge = getPolicy().merge(stateStateRecord.getValue(), stateStateRecord2.getValue(), stateStateRecord3.getValue());
        if (objMerge == null) {
            return null;
        }
        StateRecord stateRecordCreate = stateStateRecord3.create();
        ((StateStateRecord) stateRecordCreate).setValue(objMerge);
        return stateRecordCreate;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(@NotNull StateRecord value) {
        t.i(value, "value");
        this.next = (StateStateRecord) value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.MutableState
    public void setValue(T t10) {
        Snapshot current;
        StateStateRecord<T> stateStateRecord = this.next;
        Snapshot.Companion companion = Snapshot.Companion;
        StateStateRecord stateStateRecord2 = (StateStateRecord) SnapshotKt.current(stateStateRecord, companion.getCurrent());
        if (getPolicy().equivalent(stateStateRecord2.getValue(), t10)) {
            return;
        }
        StateStateRecord<T> stateStateRecord3 = this.next;
        SnapshotKt.getSnapshotInitializer();
        synchronized (SnapshotKt.getLock()) {
            current = companion.getCurrent();
            ((StateStateRecord) SnapshotKt.overwritableRecord(stateStateRecord3, this, current, stateStateRecord2)).setValue(t10);
            k0 k0Var = k0.f35197a;
        }
        SnapshotKt.notifyWrite(current, this);
    }

    @NotNull
    public String toString() {
        return "MutableState(value=" + ((StateStateRecord) SnapshotKt.current(this.next, Snapshot.Companion.getCurrent())).getValue() + ")@" + hashCode();
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public static /* synthetic */ void getValue$annotations() {
    }
}
