package androidx.compose.runtime;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import h9.l;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;
import v8.s;
import v8.y;

/* JADX INFO: compiled from: DerivedState.kt */
/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class SnapshotStateKt__DerivedStateKt {

    @NotNull
    private static final SnapshotThreadLocal<PersistentList<s<l<DerivedState<?>, k0>, l<DerivedState<?>, k0>>>> derivedStateObservers = new SnapshotThreadLocal<>();

    @NotNull
    private static final SnapshotThreadLocal<Boolean> isCalculationBlockRunning = new SnapshotThreadLocal<>();

    @NotNull
    public static final <T> State<T> derivedStateOf(@NotNull h9.a<? extends T> calculation) {
        t.i(calculation, "calculation");
        return new DerivedSnapshotState(calculation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R notifyObservers$SnapshotStateKt__DerivedStateKt(DerivedState<?> derivedState, h9.a<? extends R> aVar) {
        PersistentList persistentListPersistentListOf = (PersistentList) derivedStateObservers.get();
        if (persistentListPersistentListOf == null) {
            persistentListPersistentListOf = ExtensionsKt.persistentListOf();
        }
        int size = persistentListPersistentListOf.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            ((l) ((s) persistentListPersistentListOf.get(i11)).a()).invoke(derivedState);
        }
        try {
            return aVar.invoke();
        } finally {
            r.b(1);
            int size2 = persistentListPersistentListOf.size();
            while (i10 < size2) {
                ((l) ((s) persistentListPersistentListOf.get(i10)).b()).invoke(derivedState);
                i10++;
            }
            r.a(1);
        }
    }

    public static final <R> void observeDerivedStateRecalculations(@NotNull l<? super State<?>, k0> start, @NotNull l<? super State<?>, k0> done, @NotNull h9.a<? extends R> block) {
        t.i(start, "start");
        t.i(done, "done");
        t.i(block, "block");
        SnapshotThreadLocal<PersistentList<s<l<DerivedState<?>, k0>, l<DerivedState<?>, k0>>>> snapshotThreadLocal = derivedStateObservers;
        PersistentList<s<l<DerivedState<?>, k0>, l<DerivedState<?>, k0>>> persistentList = snapshotThreadLocal.get();
        try {
            PersistentList<s<l<DerivedState<?>, k0>, l<DerivedState<?>, k0>>> persistentListPersistentListOf = snapshotThreadLocal.get();
            if (persistentListPersistentListOf == null) {
                persistentListPersistentListOf = ExtensionsKt.persistentListOf();
            }
            snapshotThreadLocal.set(persistentListPersistentListOf.add(y.a(start, done)));
            block.invoke();
            snapshotThreadLocal.set(persistentList);
        } catch (Throwable th) {
            derivedStateObservers.set(persistentList);
            throw th;
        }
    }
}
