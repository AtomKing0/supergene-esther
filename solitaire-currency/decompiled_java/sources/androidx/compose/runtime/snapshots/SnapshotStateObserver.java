package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IdentityScopeMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import h9.l;
import h9.p;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SnapshotStateObserver.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class SnapshotStateObserver {
    public static final int $stable = 8;

    @NotNull
    private final MutableVector<ApplyMap<?>> applyMaps;

    @NotNull
    private final p<Set<? extends Object>, Snapshot, k0> applyObserver;

    @Nullable
    private ObserverHandle applyUnsubscribe;

    @Nullable
    private ApplyMap<?> currentMap;
    private boolean isPaused;

    @NotNull
    private final l<h9.a<k0>, k0> onChangedExecutor;

    @NotNull
    private final l<Object, k0> readObserver;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SnapshotStateObserver.kt */
    static final class ApplyMap<T> {

        @Nullable
        private T currentScope;

        @NotNull
        private final HashSet<Object> invalidated;

        @NotNull
        private final IdentityScopeMap<T> map;

        @NotNull
        private final l<T, k0> onChanged;

        /* JADX WARN: Multi-variable type inference failed */
        public ApplyMap(@NotNull l<? super T, k0> onChanged) {
            t.i(onChanged, "onChanged");
            this.onChanged = onChanged;
            this.map = new IdentityScopeMap<>();
            this.invalidated = new HashSet<>();
        }

        public final void addValue(@NotNull Object value) {
            t.i(value, "value");
            IdentityScopeMap<T> identityScopeMap = this.map;
            T t10 = this.currentScope;
            t.f(t10);
            identityScopeMap.add(value, t10);
        }

        public final void callOnChanged(@NotNull Collection<? extends Object> scopes) {
            t.i(scopes, "scopes");
            Iterator<T> it = scopes.iterator();
            while (it.hasNext()) {
                this.onChanged.invoke(it.next());
            }
        }

        @Nullable
        public final T getCurrentScope() {
            return this.currentScope;
        }

        @NotNull
        public final HashSet<Object> getInvalidated() {
            return this.invalidated;
        }

        @NotNull
        public final IdentityScopeMap<T> getMap() {
            return this.map;
        }

        @NotNull
        public final l<T, k0> getOnChanged() {
            return this.onChanged;
        }

        public final void setCurrentScope(@Nullable T t10) {
            this.currentScope = t10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SnapshotStateObserver(@NotNull l<? super h9.a<k0>, k0> onChangedExecutor) {
        t.i(onChangedExecutor, "onChangedExecutor");
        this.onChangedExecutor = onChangedExecutor;
        this.applyObserver = new SnapshotStateObserver$applyObserver$1(this);
        this.readObserver = new SnapshotStateObserver$readObserver$1(this);
        this.applyMaps = new MutableVector<>(new ApplyMap[16], 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callOnChanged() {
        MutableVector<ApplyMap<?>> mutableVector = this.applyMaps;
        int size = mutableVector.getSize();
        if (size > 0) {
            ApplyMap<?>[] content = mutableVector.getContent();
            int i10 = 0;
            do {
                ApplyMap<?> applyMap = content[i10];
                HashSet<Object> invalidated = applyMap.getInvalidated();
                if (!invalidated.isEmpty()) {
                    applyMap.callOnChanged(invalidated);
                    invalidated.clear();
                }
                i10++;
            } while (i10 < size);
        }
    }

    private final <T> ApplyMap<T> ensureMap(l<? super T, k0> lVar) {
        int i10;
        MutableVector<ApplyMap<?>> mutableVector = this.applyMaps;
        int size = mutableVector.getSize();
        if (size > 0) {
            ApplyMap[] content = mutableVector.getContent();
            i10 = 0;
            do {
                if (content[i10].getOnChanged() == lVar) {
                    break;
                }
                i10++;
            } while (i10 < size);
            i10 = -1;
        } else {
            i10 = -1;
        }
        if (i10 != -1) {
            return (ApplyMap) this.applyMaps.getContent()[i10];
        }
        ApplyMap<T> applyMap = new ApplyMap<>(lVar);
        this.applyMaps.add(applyMap);
        return applyMap;
    }

    public final void clear(@NotNull Object scope) {
        t.i(scope, "scope");
        synchronized (this.applyMaps) {
            MutableVector<ApplyMap<?>> mutableVector = this.applyMaps;
            int size = mutableVector.getSize();
            if (size > 0) {
                ApplyMap<?>[] content = mutableVector.getContent();
                int i10 = 0;
                do {
                    IdentityScopeMap<?> map = content[i10].getMap();
                    int size2 = map.getSize();
                    int i11 = 0;
                    for (int i12 = 0; i12 < size2; i12++) {
                        int i13 = map.getValueOrder()[i12];
                        IdentityArraySet<?> identityArraySet = map.getScopeSets()[i13];
                        t.f(identityArraySet);
                        int size3 = identityArraySet.size();
                        int i14 = 0;
                        for (int i15 = 0; i15 < size3; i15++) {
                            Object obj = identityArraySet.getValues()[i15];
                            if (obj == null) {
                                throw new NullPointerException("null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            }
                            if (!(obj == scope)) {
                                if (i14 != i15) {
                                    identityArraySet.getValues()[i14] = obj;
                                }
                                i14++;
                            }
                        }
                        int size4 = identityArraySet.size();
                        for (int i16 = i14; i16 < size4; i16++) {
                            identityArraySet.getValues()[i16] = null;
                        }
                        identityArraySet.setSize(i14);
                        if (identityArraySet.size() > 0) {
                            if (i11 != i12) {
                                int i17 = map.getValueOrder()[i11];
                                map.getValueOrder()[i11] = i13;
                                map.getValueOrder()[i12] = i17;
                            }
                            i11++;
                        }
                    }
                    int size5 = map.getSize();
                    for (int i18 = i11; i18 < size5; i18++) {
                        map.getValues()[map.getValueOrder()[i18]] = null;
                    }
                    map.setSize(i11);
                    i10++;
                } while (i10 < size);
            }
            k0 k0Var = k0.f35197a;
        }
    }

    public final void clearIf(@NotNull l<Object, Boolean> predicate) {
        t.i(predicate, "predicate");
        synchronized (this.applyMaps) {
            MutableVector<ApplyMap<?>> mutableVector = this.applyMaps;
            int size = mutableVector.getSize();
            if (size > 0) {
                ApplyMap<?>[] content = mutableVector.getContent();
                int i10 = 0;
                do {
                    IdentityScopeMap<?> map = content[i10].getMap();
                    int size2 = map.getSize();
                    int i11 = 0;
                    for (int i12 = 0; i12 < size2; i12++) {
                        int i13 = map.getValueOrder()[i12];
                        IdentityArraySet<?> identityArraySet = map.getScopeSets()[i13];
                        t.f(identityArraySet);
                        int size3 = identityArraySet.size();
                        int i14 = 0;
                        for (int i15 = 0; i15 < size3; i15++) {
                            Object obj = identityArraySet.getValues()[i15];
                            if (obj == null) {
                                throw new NullPointerException("null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                            }
                            if (!predicate.invoke(obj).booleanValue()) {
                                if (i14 != i15) {
                                    identityArraySet.getValues()[i14] = obj;
                                }
                                i14++;
                            }
                        }
                        int size4 = identityArraySet.size();
                        for (int i16 = i14; i16 < size4; i16++) {
                            identityArraySet.getValues()[i16] = null;
                        }
                        identityArraySet.setSize(i14);
                        if (identityArraySet.size() > 0) {
                            if (i11 != i12) {
                                int i17 = map.getValueOrder()[i11];
                                map.getValueOrder()[i11] = i13;
                                map.getValueOrder()[i12] = i17;
                            }
                            i11++;
                        }
                    }
                    int size5 = map.getSize();
                    for (int i18 = i11; i18 < size5; i18++) {
                        map.getValues()[map.getValueOrder()[i18]] = null;
                    }
                    map.setSize(i11);
                    i10++;
                } while (i10 < size);
            }
            k0 k0Var = k0.f35197a;
        }
    }

    public final void notifyChanges(@NotNull Set<? extends Object> changes, @NotNull Snapshot snapshot) {
        t.i(changes, "changes");
        t.i(snapshot, "snapshot");
        this.applyObserver.mo4invoke(changes, snapshot);
    }

    public final <T> void observeReads(@NotNull T scope, @NotNull l<? super T, k0> onValueChangedForScope, @NotNull h9.a<k0> block) {
        ApplyMap<?> applyMapEnsureMap;
        t.i(scope, "scope");
        t.i(onValueChangedForScope, "onValueChangedForScope");
        t.i(block, "block");
        ApplyMap<?> applyMap = this.currentMap;
        boolean z10 = this.isPaused;
        synchronized (this.applyMaps) {
            applyMapEnsureMap = ensureMap(onValueChangedForScope);
            applyMapEnsureMap.getMap().removeScope(scope);
        }
        Object currentScope = applyMapEnsureMap.getCurrentScope();
        applyMapEnsureMap.setCurrentScope(scope);
        this.currentMap = applyMapEnsureMap;
        this.isPaused = false;
        Snapshot.Companion.observe(this.readObserver, null, block);
        this.currentMap = applyMap;
        applyMapEnsureMap.setCurrentScope(currentScope);
        this.isPaused = z10;
    }

    public final void start() {
        this.applyUnsubscribe = Snapshot.Companion.registerApplyObserver(this.applyObserver);
    }

    public final void stop() {
        ObserverHandle observerHandle = this.applyUnsubscribe;
        if (observerHandle != null) {
            observerHandle.dispose();
        }
    }

    public final void withNoObservations(@NotNull h9.a<k0> block) {
        t.i(block, "block");
        boolean z10 = this.isPaused;
        this.isPaused = true;
        try {
            block.invoke();
        } finally {
            this.isPaused = z10;
        }
    }

    public final void clear() {
        synchronized (this.applyMaps) {
            MutableVector<ApplyMap<?>> mutableVector = this.applyMaps;
            int size = mutableVector.getSize();
            if (size > 0) {
                ApplyMap<?>[] content = mutableVector.getContent();
                int i10 = 0;
                do {
                    content[i10].getMap().clear();
                    i10++;
                } while (i10 < size);
            }
            k0 k0Var = k0.f35197a;
        }
    }
}
