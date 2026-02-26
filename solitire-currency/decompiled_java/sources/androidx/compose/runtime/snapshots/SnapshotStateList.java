package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.Stable;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.snapshots.Snapshot;
import h9.l;
import i9.d;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: SnapshotStateList.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public final class SnapshotStateList<T> implements List<T>, StateObject, d {

    @NotNull
    private StateRecord firstStateRecord = new StateListStateRecord(ExtensionsKt.persistentListOf());

    /* JADX INFO: compiled from: SnapshotStateList.kt */
    public static final class StateListStateRecord<T> extends StateRecord {

        @NotNull
        private PersistentList<? extends T> list;
        private int modification;

        public StateListStateRecord(@NotNull PersistentList<? extends T> list) {
            t.i(list, "list");
            this.list = list;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(@NotNull StateRecord value) {
            t.i(value, "value");
            synchronized (SnapshotStateListKt.sync) {
                this.list = ((StateListStateRecord) value).list;
                this.modification = ((StateListStateRecord) value).modification;
                k0 k0Var = k0.f35197a;
            }
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        @NotNull
        public StateRecord create() {
            return new StateListStateRecord(this.list);
        }

        @NotNull
        public final PersistentList<T> getList$runtime_release() {
            return this.list;
        }

        public final int getModification$runtime_release() {
            return this.modification;
        }

        public final void setList$runtime_release(@NotNull PersistentList<? extends T> persistentList) {
            t.i(persistentList, "<set-?>");
            this.list = persistentList;
        }

        public final void setModification$runtime_release(int i10) {
            this.modification = i10;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.SnapshotStateList$addAll$1, reason: invalid class name */
    /* JADX INFO: compiled from: SnapshotStateList.kt */
    static final class AnonymousClass1 extends v implements l<List<T>, Boolean> {
        final /* synthetic */ Collection<T> $elements;
        final /* synthetic */ int $index;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(int i10, Collection<? extends T> collection) {
            super(1);
            this.$index = i10;
            this.$elements = collection;
        }

        @Override // h9.l
        @NotNull
        public final Boolean invoke(@NotNull List<T> it) {
            t.i(it, "it");
            return Boolean.valueOf(it.addAll(this.$index, this.$elements));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.SnapshotStateList$retainAll$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SnapshotStateList.kt */
    static final class C09941 extends v implements l<List<T>, Boolean> {
        final /* synthetic */ Collection<T> $elements;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09941(Collection<? extends T> collection) {
            super(1);
            this.$elements = collection;
        }

        @Override // h9.l
        @NotNull
        public final Boolean invoke(@NotNull List<T> it) {
            t.i(it, "it");
            return Boolean.valueOf(it.retainAll(this.$elements));
        }
    }

    private final boolean conditionalUpdate(l<? super PersistentList<? extends T>, ? extends PersistentList<? extends T>> lVar) {
        Snapshot.Companion companion;
        int modification$runtime_release;
        PersistentList<T> list$runtime_release;
        boolean z10;
        Snapshot current;
        do {
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
                    companion = Snapshot.Companion;
                    StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, companion.getCurrent());
                    modification$runtime_release = stateListStateRecord2.getModification$runtime_release();
                    list$runtime_release = stateListStateRecord2.getList$runtime_release();
                    k0 k0Var = k0.f35197a;
                    r.b(1);
                } catch (Throwable th) {
                    r.b(1);
                    r.a(1);
                    throw th;
                }
            }
            r.a(1);
            t.f(list$runtime_release);
            PersistentList<? extends T> persistentListInvoke = lVar.invoke(list$runtime_release);
            z10 = false;
            if (t.d(persistentListInvoke, list$runtime_release)) {
                return false;
            }
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateListStateRecord stateListStateRecord3 = (StateListStateRecord) getFirstStateRecord();
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        try {
                            current = companion.getCurrent();
                            StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, current);
                            if (stateListStateRecord4.getModification$runtime_release() == modification$runtime_release) {
                                stateListStateRecord4.setList$runtime_release(persistentListInvoke);
                                stateListStateRecord4.setModification$runtime_release(stateListStateRecord4.getModification$runtime_release() + 1);
                                z10 = true;
                            }
                            r.b(1);
                        } catch (Throwable th2) {
                            r.b(1);
                            r.a(1);
                            throw th2;
                        }
                    }
                    r.a(1);
                    SnapshotKt.notifyWrite(current, this);
                    r.b(1);
                } catch (Throwable th3) {
                    r.b(1);
                    r.a(1);
                    throw th3;
                }
            }
            r.a(1);
        } while (!z10);
        return true;
    }

    private final <R> R mutate(l<? super List<T>, ? extends R> lVar) {
        Snapshot.Companion companion;
        int modification$runtime_release;
        PersistentList<T> list$runtime_release;
        R rInvoke;
        Snapshot current;
        boolean z10;
        do {
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
                    companion = Snapshot.Companion;
                    StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, companion.getCurrent());
                    modification$runtime_release = stateListStateRecord2.getModification$runtime_release();
                    list$runtime_release = stateListStateRecord2.getList$runtime_release();
                    k0 k0Var = k0.f35197a;
                    r.b(1);
                } catch (Throwable th) {
                    r.b(1);
                    r.a(1);
                    throw th;
                }
            }
            r.a(1);
            t.f(list$runtime_release);
            PersistentList.Builder<T> builder = list$runtime_release.builder();
            rInvoke = lVar.invoke(builder);
            PersistentList<T> persistentListBuild = builder.build();
            if (t.d(persistentListBuild, list$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateListStateRecord stateListStateRecord3 = (StateListStateRecord) getFirstStateRecord();
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        try {
                            current = companion.getCurrent();
                            StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, current);
                            if (stateListStateRecord4.getModification$runtime_release() == modification$runtime_release) {
                                stateListStateRecord4.setList$runtime_release(persistentListBuild);
                                stateListStateRecord4.setModification$runtime_release(stateListStateRecord4.getModification$runtime_release() + 1);
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            r.b(1);
                        } finally {
                        }
                    }
                    r.a(1);
                    SnapshotKt.notifyWrite(current, this);
                    r.b(1);
                } catch (Throwable th2) {
                    r.b(1);
                    r.a(1);
                    throw th2;
                }
            }
            r.a(1);
        } while (!z10);
        return rInvoke;
    }

    private final boolean mutateBoolean(l<? super List<T>, Boolean> lVar) {
        Snapshot.Companion companion;
        int modification$runtime_release;
        PersistentList<T> list$runtime_release;
        Boolean boolInvoke;
        Snapshot current;
        boolean z10;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
                companion = Snapshot.Companion;
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, companion.getCurrent());
                modification$runtime_release = stateListStateRecord2.getModification$runtime_release();
                list$runtime_release = stateListStateRecord2.getList$runtime_release();
                k0 k0Var = k0.f35197a;
            }
            t.f(list$runtime_release);
            PersistentList.Builder<T> builder = list$runtime_release.builder();
            boolInvoke = lVar.invoke(builder);
            PersistentList<T> persistentListBuild = builder.build();
            if (t.d(persistentListBuild, list$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = companion.getCurrent();
                    StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, current);
                    if (stateListStateRecord4.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord4.setList$runtime_release(persistentListBuild);
                        z10 = true;
                        stateListStateRecord4.setModification$runtime_release(stateListStateRecord4.getModification$runtime_release() + 1);
                    } else {
                        z10 = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z10);
        return boolInvoke.booleanValue();
    }

    private final void update(l<? super PersistentList<? extends T>, ? extends PersistentList<? extends T>> lVar) {
        Snapshot.Companion companion;
        int modification$runtime_release;
        PersistentList<T> list$runtime_release;
        Snapshot current;
        boolean z10;
        do {
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
                    companion = Snapshot.Companion;
                    StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, companion.getCurrent());
                    modification$runtime_release = stateListStateRecord2.getModification$runtime_release();
                    list$runtime_release = stateListStateRecord2.getList$runtime_release();
                    k0 k0Var = k0.f35197a;
                    r.b(1);
                } catch (Throwable th) {
                    r.b(1);
                    r.a(1);
                    throw th;
                }
            }
            r.a(1);
            t.f(list$runtime_release);
            PersistentList<? extends T> persistentListInvoke = lVar.invoke(list$runtime_release);
            if (t.d(persistentListInvoke, list$runtime_release)) {
                return;
            }
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateListStateRecord stateListStateRecord3 = (StateListStateRecord) getFirstStateRecord();
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        try {
                            current = companion.getCurrent();
                            StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, current);
                            if (stateListStateRecord4.getModification$runtime_release() == modification$runtime_release) {
                                stateListStateRecord4.setList$runtime_release(persistentListInvoke);
                                stateListStateRecord4.setModification$runtime_release(stateListStateRecord4.getModification$runtime_release() + 1);
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            r.b(1);
                        } catch (Throwable th2) {
                            r.b(1);
                            r.a(1);
                            throw th2;
                        }
                    }
                    r.a(1);
                    SnapshotKt.notifyWrite(current, this);
                    r.b(1);
                } catch (Throwable th3) {
                    r.b(1);
                    r.a(1);
                    throw th3;
                }
            }
            r.a(1);
        } while (!z10);
    }

    private final <R> R withCurrent(l<? super StateListStateRecord<T>, ? extends R> lVar) {
        return lVar.invoke(SnapshotKt.current((StateListStateRecord) getFirstStateRecord(), Snapshot.Companion.getCurrent()));
    }

    private final <R> R writable(l<? super StateListStateRecord<T>, ? extends R> lVar) {
        Snapshot current;
        R rInvoke;
        StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
        SnapshotKt.getSnapshotInitializer();
        synchronized (SnapshotKt.getLock()) {
            try {
                current = Snapshot.Companion.getCurrent();
                rInvoke = lVar.invoke(SnapshotKt.writableRecord(stateListStateRecord, this, current));
                r.b(1);
            } catch (Throwable th) {
                r.b(1);
                r.a(1);
                throw th;
            }
        }
        r.a(1);
        SnapshotKt.notifyWrite(current, this);
        return rInvoke;
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T t10) {
        Snapshot.Companion companion;
        int modification$runtime_release;
        PersistentList<T> list$runtime_release;
        boolean z10;
        Snapshot current;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
                companion = Snapshot.Companion;
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, companion.getCurrent());
                modification$runtime_release = stateListStateRecord2.getModification$runtime_release();
                list$runtime_release = stateListStateRecord2.getList$runtime_release();
                k0 k0Var = k0.f35197a;
            }
            t.f(list$runtime_release);
            PersistentList<T> persistentListAdd = list$runtime_release.add(t10);
            z10 = false;
            if (t.d(persistentListAdd, list$runtime_release)) {
                return false;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = companion.getCurrent();
                    StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, current);
                    if (stateListStateRecord4.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord4.setList$runtime_release(persistentListAdd);
                        stateListStateRecord4.setModification$runtime_release(stateListStateRecord4.getModification$runtime_release() + 1);
                        z10 = true;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z10);
        return true;
    }

    @Override // java.util.List
    public boolean addAll(int i10, @NotNull Collection<? extends T> elements) {
        t.i(elements, "elements");
        return mutateBoolean(new AnonymousClass1(i10, elements));
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        Snapshot current;
        synchronized (SnapshotStateListKt.sync) {
            StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord, this, current);
                stateListStateRecord2.setList$runtime_release(ExtensionsKt.persistentListOf());
                stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
            }
            SnapshotKt.notifyWrite(current, this);
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return getReadable$runtime_release().getList$runtime_release().contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> elements) {
        t.i(elements, "elements");
        return getReadable$runtime_release().getList$runtime_release().containsAll(elements);
    }

    @Override // java.util.List
    public T get(int i10) {
        return getReadable$runtime_release().getList$runtime_release().get(i10);
    }

    @NotNull
    public final List<T> getDebuggerDisplayValue() {
        return ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) getFirstStateRecord(), Snapshot.Companion.getCurrent())).getList$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    @NotNull
    public StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public final int getModification$runtime_release() {
        return ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) getFirstStateRecord(), Snapshot.Companion.getCurrent())).getModification$runtime_release();
    }

    @NotNull
    public final StateListStateRecord<T> getReadable$runtime_release() {
        return (StateListStateRecord) SnapshotKt.readable((StateListStateRecord) getFirstStateRecord(), this);
    }

    public int getSize() {
        return getReadable$runtime_release().getList$runtime_release().size();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return getReadable$runtime_release().getList$runtime_release().indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return getReadable$runtime_release().getList$runtime_release().isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return getReadable$runtime_release().getList$runtime_release().lastIndexOf(obj);
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<T> listIterator() {
        return new StateListIterator(this, 0);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public /* synthetic */ StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        return a.a(this, stateRecord, stateRecord2, stateRecord3);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(@NotNull StateRecord value) {
        t.i(value, "value");
        value.setNext$runtime_release(getFirstStateRecord());
        this.firstStateRecord = (StateListStateRecord) value;
    }

    @Override // java.util.List
    public final /* bridge */ T remove(int i10) {
        return removeAt(i10);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        Snapshot.Companion companion;
        int modification$runtime_release;
        PersistentList<T> list$runtime_release;
        boolean z10;
        Snapshot current;
        t.i(elements, "elements");
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
                companion = Snapshot.Companion;
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, companion.getCurrent());
                modification$runtime_release = stateListStateRecord2.getModification$runtime_release();
                list$runtime_release = stateListStateRecord2.getList$runtime_release();
                k0 k0Var = k0.f35197a;
            }
            t.f(list$runtime_release);
            PersistentList<T> persistentListRemoveAll = list$runtime_release.removeAll((Collection<? extends T>) elements);
            z10 = false;
            if (t.d(persistentListRemoveAll, list$runtime_release)) {
                return false;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = companion.getCurrent();
                    StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, current);
                    if (stateListStateRecord4.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord4.setList$runtime_release(persistentListRemoveAll);
                        stateListStateRecord4.setModification$runtime_release(stateListStateRecord4.getModification$runtime_release() + 1);
                        z10 = true;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z10);
        return true;
    }

    public T removeAt(int i10) {
        Snapshot.Companion companion;
        int modification$runtime_release;
        PersistentList<T> list$runtime_release;
        Snapshot current;
        boolean z10;
        T t10 = get(i10);
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
                companion = Snapshot.Companion;
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, companion.getCurrent());
                modification$runtime_release = stateListStateRecord2.getModification$runtime_release();
                list$runtime_release = stateListStateRecord2.getList$runtime_release();
                k0 k0Var = k0.f35197a;
            }
            t.f(list$runtime_release);
            PersistentList<T> persistentListRemoveAt = list$runtime_release.removeAt(i10);
            if (t.d(persistentListRemoveAt, list$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = companion.getCurrent();
                    StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, current);
                    if (stateListStateRecord4.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord4.setList$runtime_release(persistentListRemoveAt);
                        z10 = true;
                        stateListStateRecord4.setModification$runtime_release(stateListStateRecord4.getModification$runtime_release() + 1);
                    } else {
                        z10 = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z10);
        return t10;
    }

    public final void removeRange(int i10, int i11) {
        Snapshot.Companion companion;
        int modification$runtime_release;
        PersistentList<T> list$runtime_release;
        Snapshot current;
        boolean z10;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
                companion = Snapshot.Companion;
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, companion.getCurrent());
                modification$runtime_release = stateListStateRecord2.getModification$runtime_release();
                list$runtime_release = stateListStateRecord2.getList$runtime_release();
                k0 k0Var = k0.f35197a;
            }
            t.f(list$runtime_release);
            PersistentList.Builder<T> builder = list$runtime_release.builder();
            builder.subList(i10, i11).clear();
            PersistentList<T> persistentListBuild = builder.build();
            if (t.d(persistentListBuild, list$runtime_release)) {
                return;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = companion.getCurrent();
                    StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, current);
                    if (stateListStateRecord4.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord4.setList$runtime_release(persistentListBuild);
                        z10 = true;
                        stateListStateRecord4.setModification$runtime_release(stateListStateRecord4.getModification$runtime_release() + 1);
                    } else {
                        z10 = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z10);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        t.i(elements, "elements");
        return mutateBoolean(new C09941(elements));
    }

    public final int retainAllInRange$runtime_release(@NotNull Collection<? extends T> elements, int i10, int i11) {
        Snapshot.Companion companion;
        int modification$runtime_release;
        PersistentList<T> list$runtime_release;
        Snapshot current;
        boolean z10;
        t.i(elements, "elements");
        int size = size();
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
                companion = Snapshot.Companion;
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, companion.getCurrent());
                modification$runtime_release = stateListStateRecord2.getModification$runtime_release();
                list$runtime_release = stateListStateRecord2.getList$runtime_release();
                k0 k0Var = k0.f35197a;
            }
            t.f(list$runtime_release);
            PersistentList.Builder<T> builder = list$runtime_release.builder();
            builder.subList(i10, i11).retainAll(elements);
            PersistentList<T> persistentListBuild = builder.build();
            if (t.d(persistentListBuild, list$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = companion.getCurrent();
                    StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, current);
                    if (stateListStateRecord4.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord4.setList$runtime_release(persistentListBuild);
                        z10 = true;
                        stateListStateRecord4.setModification$runtime_release(stateListStateRecord4.getModification$runtime_release() + 1);
                    } else {
                        z10 = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z10);
        return size - size();
    }

    @Override // java.util.List
    public T set(int i10, T t10) {
        Snapshot.Companion companion;
        int modification$runtime_release;
        PersistentList<T> list$runtime_release;
        Snapshot current;
        boolean z10;
        T t11 = get(i10);
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
                companion = Snapshot.Companion;
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, companion.getCurrent());
                modification$runtime_release = stateListStateRecord2.getModification$runtime_release();
                list$runtime_release = stateListStateRecord2.getList$runtime_release();
                k0 k0Var = k0.f35197a;
            }
            t.f(list$runtime_release);
            PersistentList<T> persistentList = list$runtime_release.set(i10, t10);
            if (t.d(persistentList, list$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = companion.getCurrent();
                    StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, current);
                    if (stateListStateRecord4.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord4.setList$runtime_release(persistentList);
                        z10 = true;
                        stateListStateRecord4.setModification$runtime_release(stateListStateRecord4.getModification$runtime_release() + 1);
                    } else {
                        z10 = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z10);
        return t11;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    @NotNull
    public List<T> subList(int i10, int i11) {
        if ((i10 >= 0 && i10 <= i11) && i11 <= size()) {
            return new SubList(this, i10, i11);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return j.a(this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(@NotNull Collection<? extends T> elements) {
        Snapshot.Companion companion;
        int modification$runtime_release;
        PersistentList<T> list$runtime_release;
        boolean z10;
        Snapshot current;
        t.i(elements, "elements");
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
                companion = Snapshot.Companion;
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, companion.getCurrent());
                modification$runtime_release = stateListStateRecord2.getModification$runtime_release();
                list$runtime_release = stateListStateRecord2.getList$runtime_release();
                k0 k0Var = k0.f35197a;
            }
            t.f(list$runtime_release);
            PersistentList<T> persistentListAddAll = list$runtime_release.addAll(elements);
            z10 = false;
            if (t.d(persistentListAddAll, list$runtime_release)) {
                return false;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = companion.getCurrent();
                    StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, current);
                    if (stateListStateRecord4.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord4.setList$runtime_release(persistentListAddAll);
                        stateListStateRecord4.setModification$runtime_release(stateListStateRecord4.getModification$runtime_release() + 1);
                        z10 = true;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z10);
        return true;
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<T> listIterator(int i10) {
        return new StateListIterator(this, i10);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        Snapshot.Companion companion;
        int modification$runtime_release;
        PersistentList<T> list$runtime_release;
        boolean z10;
        Snapshot current;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
                companion = Snapshot.Companion;
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, companion.getCurrent());
                modification$runtime_release = stateListStateRecord2.getModification$runtime_release();
                list$runtime_release = stateListStateRecord2.getList$runtime_release();
                k0 k0Var = k0.f35197a;
            }
            t.f(list$runtime_release);
            PersistentList<T> persistentListRemove = list$runtime_release.remove(obj);
            z10 = false;
            if (t.d(persistentListRemove, list$runtime_release)) {
                return false;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = companion.getCurrent();
                    StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, current);
                    if (stateListStateRecord4.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord4.setList$runtime_release(persistentListRemove);
                        stateListStateRecord4.setModification$runtime_release(stateListStateRecord4.getModification$runtime_release() + 1);
                        z10 = true;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z10);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] array) {
        t.i(array, "array");
        return (T[]) j.b(this, array);
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public static /* synthetic */ void getReadable$runtime_release$annotations() {
    }

    @Override // java.util.List
    public void add(int i10, T t10) {
        Snapshot.Companion companion;
        int modification$runtime_release;
        PersistentList<T> list$runtime_release;
        Snapshot current;
        boolean z10;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord = (StateListStateRecord) getFirstStateRecord();
                companion = Snapshot.Companion;
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.current(stateListStateRecord, companion.getCurrent());
                modification$runtime_release = stateListStateRecord2.getModification$runtime_release();
                list$runtime_release = stateListStateRecord2.getList$runtime_release();
                k0 k0Var = k0.f35197a;
            }
            t.f(list$runtime_release);
            PersistentList<T> persistentListAdd = list$runtime_release.add(i10, t10);
            if (t.d(persistentListAdd, list$runtime_release)) {
                return;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) getFirstStateRecord();
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = companion.getCurrent();
                    StateListStateRecord stateListStateRecord4 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord3, this, current);
                    if (stateListStateRecord4.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord4.setList$runtime_release(persistentListAdd);
                        z10 = true;
                        stateListStateRecord4.setModification$runtime_release(stateListStateRecord4.getModification$runtime_release() + 1);
                    } else {
                        z10 = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z10);
    }
}
