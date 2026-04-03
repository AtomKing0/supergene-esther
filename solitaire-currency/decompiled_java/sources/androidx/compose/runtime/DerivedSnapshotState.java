package androidx.compose.runtime;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateRecord;
import h9.l;
import java.util.HashSet;
import java.util.Set;
import kotlin.collections.z0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.s;

/* JADX INFO: compiled from: DerivedState.kt */
/* JADX INFO: loaded from: classes.dex */
final class DerivedSnapshotState<T> implements StateObject, DerivedState<T> {

    @NotNull
    private final h9.a<T> calculation;

    @NotNull
    private ResultRecord<T> first;

    /* JADX INFO: compiled from: DerivedState.kt */
    private static final class ResultRecord<T> extends StateRecord {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private static final Object Unset = new Object();

        @Nullable
        private HashSet<StateObject> dependencies;

        @Nullable
        private Object result = Unset;
        private int resultHash;

        /* JADX INFO: compiled from: DerivedState.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            @NotNull
            public final Object getUnset() {
                return ResultRecord.Unset;
            }
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(@NotNull StateRecord value) {
            t.i(value, "value");
            ResultRecord resultRecord = (ResultRecord) value;
            this.dependencies = resultRecord.dependencies;
            this.result = resultRecord.result;
            this.resultHash = resultRecord.resultHash;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        @NotNull
        public StateRecord create() {
            return new ResultRecord();
        }

        @Nullable
        public final HashSet<StateObject> getDependencies() {
            return this.dependencies;
        }

        @Nullable
        public final Object getResult() {
            return this.result;
        }

        public final int getResultHash() {
            return this.resultHash;
        }

        public final boolean isValid(@NotNull DerivedState<?> derivedState, @NotNull Snapshot snapshot) {
            t.i(derivedState, "derivedState");
            t.i(snapshot, "snapshot");
            return this.result != Unset && this.resultHash == readableHash(derivedState, snapshot);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int readableHash(@NotNull DerivedState<?> derivedState, @NotNull Snapshot snapshot) {
            HashSet<StateObject> hashSet;
            t.i(derivedState, "derivedState");
            t.i(snapshot, "snapshot");
            synchronized (SnapshotKt.getLock()) {
                hashSet = this.dependencies;
            }
            int iIdentityHashCode = 7;
            if (hashSet != null) {
                PersistentList persistentListPersistentListOf = (PersistentList) SnapshotStateKt__DerivedStateKt.derivedStateObservers.get();
                if (persistentListPersistentListOf == null) {
                    persistentListPersistentListOf = ExtensionsKt.persistentListOf();
                }
                int size = persistentListPersistentListOf.size();
                int i10 = 0;
                for (int i11 = 0; i11 < size; i11++) {
                    ((l) ((s) persistentListPersistentListOf.get(i11)).a()).invoke(derivedState);
                }
                try {
                    for (StateObject stateObject : hashSet) {
                        StateRecord firstStateRecord = stateObject.getFirstStateRecord();
                        t.h(stateObject, "stateObject");
                        StateRecord stateRecord = SnapshotKt.readable(firstStateRecord, stateObject, snapshot);
                        iIdentityHashCode = (((iIdentityHashCode * 31) + ActualJvm_jvmKt.identityHashCode(stateRecord)) * 31) + stateRecord.getSnapshotId$runtime_release();
                    }
                    k0 k0Var = k0.f35197a;
                } finally {
                    int size2 = persistentListPersistentListOf.size();
                    while (i10 < size2) {
                        ((l) ((s) persistentListPersistentListOf.get(i10)).b()).invoke(derivedState);
                        i10++;
                    }
                }
            }
            return iIdentityHashCode;
        }

        public final void setDependencies(@Nullable HashSet<StateObject> hashSet) {
            this.dependencies = hashSet;
        }

        public final void setResult(@Nullable Object obj) {
            this.result = obj;
        }

        public final void setResultHash(int i10) {
            this.resultHash = i10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DerivedSnapshotState(@NotNull h9.a<? extends T> calculation) {
        t.i(calculation, "calculation");
        this.calculation = calculation;
        this.first = new ResultRecord<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ResultRecord<T> currentRecord(ResultRecord<T> resultRecord, Snapshot snapshot, h9.a<? extends T> aVar) {
        Snapshot.Companion companion;
        ResultRecord<T> resultRecord2;
        if (resultRecord.isValid(this, snapshot)) {
            return resultRecord;
        }
        Boolean bool = (Boolean) SnapshotStateKt__DerivedStateKt.isCalculationBlockRunning.get();
        int i10 = 0;
        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
        HashSet<StateObject> hashSet = new HashSet<>();
        PersistentList persistentListPersistentListOf = (PersistentList) SnapshotStateKt__DerivedStateKt.derivedStateObservers.get();
        if (persistentListPersistentListOf == null) {
            persistentListPersistentListOf = ExtensionsKt.persistentListOf();
        }
        int size = persistentListPersistentListOf.size();
        for (int i11 = 0; i11 < size; i11++) {
            ((l) ((s) persistentListPersistentListOf.get(i11)).a()).invoke(this);
        }
        if (!zBooleanValue) {
            try {
                SnapshotStateKt__DerivedStateKt.isCalculationBlockRunning.set(Boolean.TRUE);
            } finally {
                int size2 = persistentListPersistentListOf.size();
                while (i10 < size2) {
                    ((l) ((s) persistentListPersistentListOf.get(i10)).b()).invoke(this);
                    i10++;
                }
            }
        }
        Object objObserve = Snapshot.Companion.observe(new DerivedSnapshotState$currentRecord$result$1$result$1(this, hashSet), null, aVar);
        if (!zBooleanValue) {
            SnapshotStateKt__DerivedStateKt.isCalculationBlockRunning.set(Boolean.FALSE);
        }
        synchronized (SnapshotKt.getLock()) {
            companion = Snapshot.Companion;
            Snapshot current = companion.getCurrent();
            resultRecord2 = (ResultRecord) SnapshotKt.newWritableRecord(this.first, this, current);
            resultRecord2.setDependencies(hashSet);
            resultRecord2.setResultHash(resultRecord2.readableHash(this, current));
            resultRecord2.setResult(objObserve);
        }
        if (!zBooleanValue) {
            companion.notifyObjectsInitialized();
        }
        return resultRecord2;
    }

    private final String displayValue() {
        ResultRecord<T> resultRecord = this.first;
        Snapshot.Companion companion = Snapshot.Companion;
        ResultRecord resultRecord2 = (ResultRecord) SnapshotKt.current(resultRecord, companion.getCurrent());
        return resultRecord2.isValid(this, companion.getCurrent()) ? String.valueOf(resultRecord2.getResult()) : "<Not calculated>";
    }

    @Override // androidx.compose.runtime.DerivedState
    public T getCurrentValue() {
        ResultRecord<T> resultRecord = this.first;
        Snapshot.Companion companion = Snapshot.Companion;
        return (T) currentRecord((ResultRecord) SnapshotKt.current(resultRecord, companion.getCurrent()), companion.getCurrent(), this.calculation).getResult();
    }

    @Nullable
    public final T getDebuggerDisplayValue() {
        ResultRecord<T> resultRecord = this.first;
        Snapshot.Companion companion = Snapshot.Companion;
        ResultRecord resultRecord2 = (ResultRecord) SnapshotKt.current(resultRecord, companion.getCurrent());
        if (resultRecord2.isValid(this, companion.getCurrent())) {
            return (T) resultRecord2.getResult();
        }
        return null;
    }

    @Override // androidx.compose.runtime.DerivedState
    @NotNull
    public Set<StateObject> getDependencies() {
        ResultRecord<T> resultRecord = this.first;
        Snapshot.Companion companion = Snapshot.Companion;
        HashSet<StateObject> dependencies = currentRecord((ResultRecord) SnapshotKt.current(resultRecord, companion.getCurrent()), companion.getCurrent(), this.calculation).getDependencies();
        return dependencies != null ? dependencies : z0.e();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    @NotNull
    public StateRecord getFirstStateRecord() {
        return this.first;
    }

    @Override // androidx.compose.runtime.State
    public T getValue() {
        l<Object, k0> readObserver$runtime_release = Snapshot.Companion.getCurrent().getReadObserver$runtime_release();
        if (readObserver$runtime_release != null) {
            readObserver$runtime_release.invoke(this);
        }
        return getCurrentValue();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public /* synthetic */ StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        return androidx.compose.runtime.snapshots.a.a(this, stateRecord, stateRecord2, stateRecord3);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(@NotNull StateRecord value) {
        t.i(value, "value");
        this.first = (ResultRecord) value;
    }

    @NotNull
    public String toString() {
        return "DerivedState(value=" + displayValue() + ")@" + hashCode();
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }
}
