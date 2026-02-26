package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IdentityScopeMap;
import androidx.compose.runtime.snapshots.StateObject;
import h9.p;
import h9.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.collections.d0;
import kotlin.collections.o;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.s;
import z8.g;

/* JADX INFO: compiled from: Composition.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CompositionImpl implements ControlledComposition {

    @Nullable
    private final g _recomposeContext;

    @NotNull
    private final HashSet<RememberObserver> abandonSet;

    @NotNull
    private final Applier<?> applier;

    @NotNull
    private final List<q<Applier<?>, SlotWriter, RememberManager, k0>> changes;

    @NotNull
    private p<? super Composer, ? super Integer, k0> composable;

    @NotNull
    private final ComposerImpl composer;

    @NotNull
    private final HashSet<RecomposeScopeImpl> conditionallyInvalidatedScopes;

    @NotNull
    private final IdentityScopeMap<DerivedState<?>> derivedStates;
    private boolean disposed;

    @Nullable
    private CompositionImpl invalidationDelegate;
    private int invalidationDelegateGroup;

    @NotNull
    private IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> invalidations;
    private final boolean isRoot;

    @NotNull
    private final List<q<Applier<?>, SlotWriter, RememberManager, k0>> lateChanges;

    @NotNull
    private final Object lock;

    @NotNull
    private final IdentityScopeMap<RecomposeScopeImpl> observations;

    @NotNull
    private final IdentityScopeMap<RecomposeScopeImpl> observationsProcessed;

    @NotNull
    private final CompositionContext parent;
    private boolean pendingInvalidScopes;

    @NotNull
    private final AtomicReference<Object> pendingModifications;

    @NotNull
    private final SlotTable slotTable;

    /* JADX INFO: compiled from: Composition.kt */
    private static final class RememberEventDispatcher implements RememberManager {

        @NotNull
        private final Set<RememberObserver> abandoning;

        @NotNull
        private final List<RememberObserver> forgetting;

        @NotNull
        private final List<RememberObserver> remembering;

        @NotNull
        private final List<h9.a<k0>> sideEffects;

        public RememberEventDispatcher(@NotNull Set<RememberObserver> abandoning) {
            t.i(abandoning, "abandoning");
            this.abandoning = abandoning;
            this.remembering = new ArrayList();
            this.forgetting = new ArrayList();
            this.sideEffects = new ArrayList();
        }

        public final void dispatchAbandons() {
            if (!this.abandoning.isEmpty()) {
                Object objBeginSection = Trace.INSTANCE.beginSection("Compose:abandons");
                try {
                    Iterator<RememberObserver> it = this.abandoning.iterator();
                    while (it.hasNext()) {
                        RememberObserver next = it.next();
                        it.remove();
                        next.onAbandoned();
                    }
                    k0 k0Var = k0.f35197a;
                } finally {
                    Trace.INSTANCE.endSection(objBeginSection);
                }
            }
        }

        public final void dispatchRememberObservers() {
            Object objBeginSection;
            if (!this.forgetting.isEmpty()) {
                objBeginSection = Trace.INSTANCE.beginSection("Compose:onForgotten");
                try {
                    for (int size = this.forgetting.size() - 1; -1 < size; size--) {
                        RememberObserver rememberObserver = this.forgetting.get(size);
                        if (!this.abandoning.contains(rememberObserver)) {
                            rememberObserver.onForgotten();
                        }
                    }
                    k0 k0Var = k0.f35197a;
                } finally {
                }
            }
            if (!this.remembering.isEmpty()) {
                objBeginSection = Trace.INSTANCE.beginSection("Compose:onRemembered");
                try {
                    List<RememberObserver> list = this.remembering;
                    int size2 = list.size();
                    for (int i10 = 0; i10 < size2; i10++) {
                        RememberObserver rememberObserver2 = list.get(i10);
                        this.abandoning.remove(rememberObserver2);
                        rememberObserver2.onRemembered();
                    }
                    k0 k0Var2 = k0.f35197a;
                } finally {
                }
            }
        }

        public final void dispatchSideEffects() {
            if (!this.sideEffects.isEmpty()) {
                Object objBeginSection = Trace.INSTANCE.beginSection("Compose:sideeffects");
                try {
                    List<h9.a<k0>> list = this.sideEffects;
                    int size = list.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        list.get(i10).invoke();
                    }
                    this.sideEffects.clear();
                    k0 k0Var = k0.f35197a;
                } finally {
                    Trace.INSTANCE.endSection(objBeginSection);
                }
            }
        }

        @Override // androidx.compose.runtime.RememberManager
        public void forgetting(@NotNull RememberObserver instance) {
            t.i(instance, "instance");
            int iLastIndexOf = this.remembering.lastIndexOf(instance);
            if (iLastIndexOf < 0) {
                this.forgetting.add(instance);
            } else {
                this.remembering.remove(iLastIndexOf);
                this.abandoning.remove(instance);
            }
        }

        @Override // androidx.compose.runtime.RememberManager
        public void remembering(@NotNull RememberObserver instance) {
            t.i(instance, "instance");
            int iLastIndexOf = this.forgetting.lastIndexOf(instance);
            if (iLastIndexOf < 0) {
                this.remembering.add(instance);
            } else {
                this.forgetting.remove(iLastIndexOf);
                this.abandoning.remove(instance);
            }
        }

        @Override // androidx.compose.runtime.RememberManager
        public void sideEffect(@NotNull h9.a<k0> effect) {
            t.i(effect, "effect");
            this.sideEffects.add(effect);
        }
    }

    public CompositionImpl(@NotNull CompositionContext parent, @NotNull Applier<?> applier, @Nullable g gVar) {
        t.i(parent, "parent");
        t.i(applier, "applier");
        this.parent = parent;
        this.applier = applier;
        this.pendingModifications = new AtomicReference<>(null);
        this.lock = new Object();
        HashSet<RememberObserver> hashSet = new HashSet<>();
        this.abandonSet = hashSet;
        SlotTable slotTable = new SlotTable();
        this.slotTable = slotTable;
        this.observations = new IdentityScopeMap<>();
        this.conditionallyInvalidatedScopes = new HashSet<>();
        this.derivedStates = new IdentityScopeMap<>();
        ArrayList arrayList = new ArrayList();
        this.changes = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.lateChanges = arrayList2;
        this.observationsProcessed = new IdentityScopeMap<>();
        this.invalidations = new IdentityArrayMap<>(0, 1, null);
        ComposerImpl composerImpl = new ComposerImpl(applier, parent, slotTable, hashSet, arrayList, arrayList2, this);
        parent.registerComposer$runtime_release(composerImpl);
        this.composer = composerImpl;
        this._recomposeContext = gVar;
        this.isRoot = parent instanceof Recomposer;
        this.composable = ComposableSingletons$CompositionKt.INSTANCE.m1244getLambda1$runtime_release();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void addPendingInvalidationsLocked(java.util.Set<? extends java.lang.Object> r17, boolean r18) {
        /*
            Method dump skipped, instruction units count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.addPendingInvalidationsLocked(java.util.Set, boolean):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.HashSet] */
    /* JADX WARN: Type inference failed for: r2v7, types: [T, java.util.HashSet] */
    /* JADX WARN: Type inference failed for: r2v9 */
    private static final void addPendingInvalidationsLocked$invalidate(CompositionImpl compositionImpl, boolean z10, n0<HashSet<RecomposeScopeImpl>> n0Var, Object obj) {
        IdentityScopeMap<RecomposeScopeImpl> identityScopeMap = compositionImpl.observations;
        int iFind = identityScopeMap.find(obj);
        if (iFind >= 0) {
            for (RecomposeScopeImpl recomposeScopeImpl : identityScopeMap.scopeSetAt(iFind)) {
                if (!compositionImpl.observationsProcessed.remove(obj, recomposeScopeImpl) && recomposeScopeImpl.invalidateForResult(obj) != InvalidationResult.IGNORED) {
                    if (!recomposeScopeImpl.isConditional() || z10) {
                        HashSet<RecomposeScopeImpl> hashSet = n0Var.f29834a;
                        ?? r22 = hashSet;
                        if (hashSet == null) {
                            ?? hashSet2 = new HashSet();
                            n0Var.f29834a = hashSet2;
                            r22 = hashSet2;
                        }
                        r22.add(recomposeScopeImpl);
                    } else {
                        compositionImpl.conditionallyInvalidatedScopes.add(recomposeScopeImpl);
                    }
                }
            }
        }
    }

    private final void applyChangesInLocked(List<q<Applier<?>, SlotWriter, RememberManager, k0>> list) {
        boolean zIsEmpty;
        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
        try {
            if (list.isEmpty()) {
                if (zIsEmpty) {
                    return;
                } else {
                    return;
                }
            }
            Object objBeginSection = Trace.INSTANCE.beginSection("Compose:applyChanges");
            try {
                this.applier.onBeginChanges();
                SlotWriter slotWriterOpenWriter = this.slotTable.openWriter();
                try {
                    Applier<?> applier = this.applier;
                    int size = list.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        list.get(i10).invoke(applier, slotWriterOpenWriter, rememberEventDispatcher);
                    }
                    list.clear();
                    k0 k0Var = k0.f35197a;
                    slotWriterOpenWriter.close();
                    this.applier.onEndChanges();
                    Trace trace = Trace.INSTANCE;
                    trace.endSection(objBeginSection);
                    rememberEventDispatcher.dispatchRememberObservers();
                    rememberEventDispatcher.dispatchSideEffects();
                    if (this.pendingInvalidScopes) {
                        objBeginSection = trace.beginSection("Compose:unobserve");
                        try {
                            this.pendingInvalidScopes = false;
                            IdentityScopeMap<RecomposeScopeImpl> identityScopeMap = this.observations;
                            int size2 = identityScopeMap.getSize();
                            int i11 = 0;
                            for (int i12 = 0; i12 < size2; i12++) {
                                int i13 = identityScopeMap.getValueOrder()[i12];
                                IdentityArraySet<RecomposeScopeImpl> identityArraySet = identityScopeMap.getScopeSets()[i13];
                                t.f(identityArraySet);
                                int size3 = identityArraySet.size();
                                int i14 = 0;
                                for (int i15 = 0; i15 < size3; i15++) {
                                    Object obj = identityArraySet.getValues()[i15];
                                    if (obj == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                                    }
                                    if (!(!((RecomposeScopeImpl) obj).getValid())) {
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
                                        int i17 = identityScopeMap.getValueOrder()[i11];
                                        identityScopeMap.getValueOrder()[i11] = i13;
                                        identityScopeMap.getValueOrder()[i12] = i17;
                                    }
                                    i11++;
                                }
                            }
                            int size5 = identityScopeMap.getSize();
                            for (int i18 = i11; i18 < size5; i18++) {
                                identityScopeMap.getValues()[identityScopeMap.getValueOrder()[i18]] = null;
                            }
                            identityScopeMap.setSize(i11);
                            cleanUpDerivedStateObservations();
                            k0 k0Var2 = k0.f35197a;
                            Trace.INSTANCE.endSection(objBeginSection);
                        } finally {
                        }
                    }
                    if (this.lateChanges.isEmpty()) {
                        rememberEventDispatcher.dispatchAbandons();
                    }
                } catch (Throwable th) {
                    slotWriterOpenWriter.close();
                    throw th;
                }
            } finally {
            }
        } finally {
            if (this.lateChanges.isEmpty()) {
                rememberEventDispatcher.dispatchAbandons();
            }
        }
    }

    private final void cleanUpDerivedStateObservations() {
        IdentityScopeMap<DerivedState<?>> identityScopeMap = this.derivedStates;
        int size = identityScopeMap.getSize();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            int i12 = identityScopeMap.getValueOrder()[i11];
            IdentityArraySet<DerivedState<?>> identityArraySet = identityScopeMap.getScopeSets()[i12];
            t.f(identityArraySet);
            int size2 = identityArraySet.size();
            int i13 = 0;
            for (int i14 = 0; i14 < size2; i14++) {
                Object obj = identityArraySet.getValues()[i14];
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                }
                if (!(!this.observations.contains((DerivedState) obj))) {
                    if (i13 != i14) {
                        identityArraySet.getValues()[i13] = obj;
                    }
                    i13++;
                }
            }
            int size3 = identityArraySet.size();
            for (int i15 = i13; i15 < size3; i15++) {
                identityArraySet.getValues()[i15] = null;
            }
            identityArraySet.setSize(i13);
            if (identityArraySet.size() > 0) {
                if (i10 != i11) {
                    int i16 = identityScopeMap.getValueOrder()[i10];
                    identityScopeMap.getValueOrder()[i10] = i12;
                    identityScopeMap.getValueOrder()[i11] = i16;
                }
                i10++;
            }
        }
        int size4 = identityScopeMap.getSize();
        for (int i17 = i10; i17 < size4; i17++) {
            identityScopeMap.getValues()[identityScopeMap.getValueOrder()[i17]] = null;
        }
        identityScopeMap.setSize(i10);
        Iterator<RecomposeScopeImpl> it = this.conditionallyInvalidatedScopes.iterator();
        t.h(it, "iterator()");
        while (it.hasNext()) {
            if (!it.next().isConditional()) {
                it.remove();
            }
        }
    }

    private final void drainPendingModificationsForCompositionLocked() {
        Object andSet = this.pendingModifications.getAndSet(CompositionKt.PendingApplyNoModifications);
        if (andSet != null) {
            if (t.d(andSet, CompositionKt.PendingApplyNoModifications)) {
                throw new IllegalStateException("pending composition has not been applied".toString());
            }
            if (andSet instanceof Set) {
                addPendingInvalidationsLocked((Set) andSet, true);
                return;
            }
            if (!(andSet instanceof Object[])) {
                throw new IllegalStateException(("corrupt pendingModifications drain: " + this.pendingModifications).toString());
            }
            for (Set<? extends Object> set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, true);
            }
        }
    }

    private final void drainPendingModificationsLocked() {
        Object andSet = this.pendingModifications.getAndSet(null);
        if (t.d(andSet, CompositionKt.PendingApplyNoModifications)) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set) andSet, false);
            return;
        }
        if (!(andSet instanceof Object[])) {
            if (andSet == null) {
                throw new IllegalStateException("calling recordModificationsOf and applyChanges concurrently is not supported".toString());
            }
            throw new IllegalStateException(("corrupt pendingModifications drain: " + this.pendingModifications).toString());
        }
        for (Set<? extends Object> set : (Set[]) andSet) {
            addPendingInvalidationsLocked(set, false);
        }
    }

    private final boolean getAreChildrenComposing() {
        return this.composer.getAreChildrenComposing$runtime_release();
    }

    private final InvalidationResult invalidateChecked(RecomposeScopeImpl recomposeScopeImpl, Anchor anchor, Object obj) {
        synchronized (this.lock) {
            CompositionImpl compositionImpl = this.invalidationDelegate;
            if (compositionImpl == null || !this.slotTable.groupContainsAnchor(this.invalidationDelegateGroup, anchor)) {
                compositionImpl = null;
            }
            if (compositionImpl == null) {
                if (isComposing() && this.composer.tryImminentInvalidation$runtime_release(recomposeScopeImpl, obj)) {
                    return InvalidationResult.IMMINENT;
                }
                if (obj == null) {
                    this.invalidations.set(recomposeScopeImpl, null);
                } else {
                    CompositionKt.addValue(this.invalidations, recomposeScopeImpl, obj);
                }
            }
            if (compositionImpl != null) {
                return compositionImpl.invalidateChecked(recomposeScopeImpl, anchor, obj);
            }
            this.parent.invalidate$runtime_release(this);
            return isComposing() ? InvalidationResult.DEFERRED : InvalidationResult.SCHEDULED;
        }
    }

    private final void invalidateScopeOfLocked(Object obj) {
        IdentityScopeMap<RecomposeScopeImpl> identityScopeMap = this.observations;
        int iFind = identityScopeMap.find(obj);
        if (iFind >= 0) {
            for (RecomposeScopeImpl recomposeScopeImpl : identityScopeMap.scopeSetAt(iFind)) {
                if (recomposeScopeImpl.invalidateForResult(obj) == InvalidationResult.IMMINENT) {
                    this.observationsProcessed.add(obj, recomposeScopeImpl);
                }
            }
        }
    }

    private final IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> takeInvalidations() {
        IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMap = this.invalidations;
        this.invalidations = new IdentityArrayMap<>(0, 1, null);
        return identityArrayMap;
    }

    private final <T> T trackAbandonedValues(h9.a<? extends T> aVar) {
        try {
            T tInvoke = aVar.invoke();
            r.b(1);
            r.a(1);
            return tInvoke;
        } catch (Throwable th) {
            r.b(1);
            if (!this.abandonSet.isEmpty()) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            r.a(1);
            throw th;
        }
    }

    private final void validateRecomposeScopeAnchors(SlotTable slotTable) {
        Object[] slots = slotTable.getSlots();
        ArrayList arrayList = new ArrayList();
        for (Object obj : slots) {
            RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
            if (recomposeScopeImpl != null) {
                arrayList.add(recomposeScopeImpl);
            }
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) arrayList.get(i10);
            Anchor anchor = recomposeScopeImpl2.getAnchor();
            if (anchor != null && !slotTable.slotsOf$runtime_release(anchor.toIndexFor(slotTable)).contains(recomposeScopeImpl2)) {
                throw new IllegalStateException(("Misaligned anchor " + anchor + " in scope " + recomposeScopeImpl2 + " encountered, scope found at " + kotlin.collections.p.Y(slotTable.getSlots(), recomposeScopeImpl2)).toString());
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyChanges() {
        synchronized (this.lock) {
            applyChangesInLocked(this.changes);
            drainPendingModificationsLocked();
            k0 k0Var = k0.f35197a;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyLateChanges() {
        synchronized (this.lock) {
            if (!this.lateChanges.isEmpty()) {
                applyChangesInLocked(this.lateChanges);
            }
            k0 k0Var = k0.f35197a;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void changesApplied() {
        synchronized (this.lock) {
            this.composer.changesApplied$runtime_release();
            if (!this.abandonSet.isEmpty()) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            k0 k0Var = k0.f35197a;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void composeContent(@NotNull p<? super Composer, ? super Integer, k0> content) {
        t.i(content, "content");
        try {
            synchronized (this.lock) {
                drainPendingModificationsForCompositionLocked();
                this.composer.composeContent$runtime_release(takeInvalidations(), content);
                k0 k0Var = k0.f35197a;
            }
        } catch (Throwable th) {
            if (!this.abandonSet.isEmpty()) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            throw th;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public <R> R delegateInvalidations(@Nullable ControlledComposition controlledComposition, int i10, @NotNull h9.a<? extends R> block) {
        t.i(block, "block");
        if (controlledComposition == null || t.d(controlledComposition, this) || i10 < 0) {
            return block.invoke();
        }
        this.invalidationDelegate = (CompositionImpl) controlledComposition;
        this.invalidationDelegateGroup = i10;
        try {
            return block.invoke();
        } finally {
            this.invalidationDelegate = null;
            this.invalidationDelegateGroup = 0;
        }
    }

    @Override // androidx.compose.runtime.Composition
    public void dispose() {
        synchronized (this.lock) {
            if (!this.disposed) {
                this.disposed = true;
                this.composable = ComposableSingletons$CompositionKt.INSTANCE.m1245getLambda2$runtime_release();
                boolean z10 = this.slotTable.getGroupsSize() > 0;
                if (z10 || (true ^ this.abandonSet.isEmpty())) {
                    RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
                    if (z10) {
                        SlotWriter slotWriterOpenWriter = this.slotTable.openWriter();
                        try {
                            ComposerKt.removeCurrentGroup(slotWriterOpenWriter, rememberEventDispatcher);
                            k0 k0Var = k0.f35197a;
                            slotWriterOpenWriter.close();
                            this.applier.clear();
                            rememberEventDispatcher.dispatchRememberObservers();
                        } catch (Throwable th) {
                            slotWriterOpenWriter.close();
                            throw th;
                        }
                    }
                    rememberEventDispatcher.dispatchAbandons();
                }
                this.composer.dispose$runtime_release();
            }
            k0 k0Var2 = k0.f35197a;
        }
        this.parent.unregisterComposition$runtime_release(this);
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void disposeUnusedMovableContent(@NotNull MovableContentState state) {
        t.i(state, "state");
        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
        SlotWriter slotWriterOpenWriter = state.getSlotTable$runtime_release().openWriter();
        try {
            ComposerKt.removeCurrentGroup(slotWriterOpenWriter, rememberEventDispatcher);
            k0 k0Var = k0.f35197a;
            slotWriterOpenWriter.close();
            rememberEventDispatcher.dispatchRememberObservers();
        } catch (Throwable th) {
            slotWriterOpenWriter.close();
            throw th;
        }
    }

    @NotNull
    public final p<Composer, Integer, k0> getComposable() {
        return this.composable;
    }

    @NotNull
    public final List<RecomposeScopeImpl> getConditionalScopes$runtime_release() {
        return d0.P0(this.conditionallyInvalidatedScopes);
    }

    @NotNull
    public final List<Object> getDerivedStateDependencies$runtime_release() {
        return kotlin.collections.p.K(this.derivedStates.getValues());
    }

    @Override // androidx.compose.runtime.Composition
    public boolean getHasInvalidations() {
        boolean z10;
        synchronized (this.lock) {
            z10 = this.invalidations.getSize$runtime_release() > 0;
        }
        return z10;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean getHasPendingChanges() {
        boolean hasPendingChanges$runtime_release;
        synchronized (this.lock) {
            hasPendingChanges$runtime_release = this.composer.getHasPendingChanges$runtime_release();
        }
        return hasPendingChanges$runtime_release;
    }

    @NotNull
    public final List<Object> getObservedObjects$runtime_release() {
        return kotlin.collections.p.K(this.observations.getValues());
    }

    public final boolean getPendingInvalidScopes$runtime_release() {
        return this.pendingInvalidScopes;
    }

    @NotNull
    public final g getRecomposeContext() {
        g gVar = this._recomposeContext;
        return gVar == null ? this.parent.getRecomposeCoroutineContext$runtime_release() : gVar;
    }

    @NotNull
    public final SlotTable getSlotTable$runtime_release() {
        return this.slotTable;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void insertMovableContent(@NotNull List<s<MovableContentStateReference, MovableContentStateReference>> references) {
        t.i(references, "references");
        int size = references.size();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                z10 = true;
                break;
            } else if (!t.d(references.get(i10).c().getComposition$runtime_release(), this)) {
                break;
            } else {
                i10++;
            }
        }
        ComposerKt.runtimeCheck(z10);
        try {
            this.composer.insertMovableContentReferences(references);
            k0 k0Var = k0.f35197a;
        } catch (Throwable th) {
            if (!this.abandonSet.isEmpty()) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            throw th;
        }
    }

    @NotNull
    public final InvalidationResult invalidate(@NotNull RecomposeScopeImpl scope, @Nullable Object obj) {
        t.i(scope, "scope");
        if (scope.getDefaultsInScope()) {
            scope.setDefaultsInvalid(true);
        }
        Anchor anchor = scope.getAnchor();
        return (anchor != null && this.slotTable.ownsAnchor(anchor) && anchor.getValid()) ? !anchor.getValid() ? InvalidationResult.IGNORED : !scope.getCanRecompose() ? InvalidationResult.IGNORED : invalidateChecked(scope, anchor, obj) : InvalidationResult.IGNORED;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void invalidateAll() {
        synchronized (this.lock) {
            for (Object obj : this.slotTable.getSlots()) {
                RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
                if (recomposeScopeImpl != null) {
                    recomposeScopeImpl.invalidate();
                }
            }
            k0 k0Var = k0.f35197a;
        }
    }

    public final void invalidateGroupsWithKey(int i10) {
        List<RecomposeScopeImpl> listInvalidateGroupsWithKey$runtime_release;
        boolean z10;
        synchronized (this.lock) {
            listInvalidateGroupsWithKey$runtime_release = this.slotTable.invalidateGroupsWithKey$runtime_release(i10);
        }
        boolean z11 = true;
        if (listInvalidateGroupsWithKey$runtime_release != null) {
            int size = listInvalidateGroupsWithKey$runtime_release.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    z10 = false;
                    break;
                }
                if (listInvalidateGroupsWithKey$runtime_release.get(i11).invalidateForResult(null) == InvalidationResult.IGNORED) {
                    z10 = true;
                    break;
                }
                i11++;
            }
            if (!z10) {
                z11 = false;
            }
        }
        if (z11 && this.composer.forceRecomposeScopes$runtime_release()) {
            this.parent.invalidate$runtime_release(this);
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean isComposing() {
        return this.composer.isComposing$runtime_release();
    }

    @Override // androidx.compose.runtime.Composition
    public boolean isDisposed() {
        return this.disposed;
    }

    public final boolean isRoot() {
        return this.isRoot;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean observesAnyOf(@NotNull Set<? extends Object> values) {
        t.i(values, "values");
        for (Object obj : values) {
            if (this.observations.contains(obj) || this.derivedStates.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void prepareCompose(@NotNull h9.a<k0> block) {
        t.i(block, "block");
        this.composer.prepareCompose$runtime_release(block);
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean recompose() {
        boolean zRecompose$runtime_release;
        synchronized (this.lock) {
            drainPendingModificationsForCompositionLocked();
            try {
                zRecompose$runtime_release = this.composer.recompose$runtime_release(takeInvalidations());
                if (!zRecompose$runtime_release) {
                    drainPendingModificationsLocked();
                }
            } finally {
            }
        }
        return zRecompose$runtime_release;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void recordModificationsOf(@NotNull Set<? extends Object> values) {
        Object obj;
        Object objY;
        t.i(values, "values");
        do {
            obj = this.pendingModifications.get();
            if (obj == null ? true : t.d(obj, CompositionKt.PendingApplyNoModifications)) {
                objY = values;
            } else if (obj instanceof Set) {
                objY = new Set[]{(Set) obj, values};
            } else {
                if (!(obj instanceof Object[])) {
                    throw new IllegalStateException(("corrupt pendingModifications: " + this.pendingModifications).toString());
                }
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>");
                }
                objY = o.y((Set[]) obj, values);
            }
        } while (!androidx.compose.animation.core.d.a(this.pendingModifications, obj, objY));
        if (obj == null) {
            synchronized (this.lock) {
                drainPendingModificationsLocked();
                k0 k0Var = k0.f35197a;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void recordReadOf(@NotNull Object value) {
        RecomposeScopeImpl currentRecomposeScope$runtime_release;
        t.i(value, "value");
        if (getAreChildrenComposing() || (currentRecomposeScope$runtime_release = this.composer.getCurrentRecomposeScope$runtime_release()) == null) {
            return;
        }
        currentRecomposeScope$runtime_release.setUsed(true);
        this.observations.add(value, currentRecomposeScope$runtime_release);
        if (value instanceof DerivedState) {
            this.derivedStates.removeScope(value);
            Iterator<T> it = ((DerivedState) value).getDependencies().iterator();
            while (it.hasNext()) {
                this.derivedStates.add((StateObject) it.next(), value);
            }
        }
        currentRecomposeScope$runtime_release.recordRead(value);
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void recordWriteOf(@NotNull Object value) {
        t.i(value, "value");
        synchronized (this.lock) {
            invalidateScopeOfLocked(value);
            IdentityScopeMap<DerivedState<?>> identityScopeMap = this.derivedStates;
            int iFind = identityScopeMap.find(value);
            if (iFind >= 0) {
                Iterator<T> it = identityScopeMap.scopeSetAt(iFind).iterator();
                while (it.hasNext()) {
                    invalidateScopeOfLocked((DerivedState) it.next());
                }
            }
            k0 k0Var = k0.f35197a;
        }
    }

    public final void removeDerivedStateObservation$runtime_release(@NotNull DerivedState<?> state) {
        t.i(state, "state");
        if (this.observations.contains(state)) {
            return;
        }
        this.derivedStates.removeScope(state);
    }

    public final void removeObservation$runtime_release(@NotNull Object instance, @NotNull RecomposeScopeImpl scope) {
        t.i(instance, "instance");
        t.i(scope, "scope");
        this.observations.remove(instance, scope);
    }

    public final void setComposable(@NotNull p<? super Composer, ? super Integer, k0> pVar) {
        t.i(pVar, "<set-?>");
        this.composable = pVar;
    }

    @Override // androidx.compose.runtime.Composition
    public void setContent(@NotNull p<? super Composer, ? super Integer, k0> content) {
        t.i(content, "content");
        if (!(!this.disposed)) {
            throw new IllegalStateException("The composition is disposed".toString());
        }
        this.composable = content;
        this.parent.composeInitial$runtime_release(this, content);
    }

    public final void setPendingInvalidScopes$runtime_release(boolean z10) {
        this.pendingInvalidScopes = z10;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void verifyConsistent() {
        synchronized (this.lock) {
            if (!isComposing()) {
                this.slotTable.verifyWellFormed();
                validateRecomposeScopeAnchors(this.slotTable);
            }
            k0 k0Var = k0.f35197a;
        }
    }

    public /* synthetic */ CompositionImpl(CompositionContext compositionContext, Applier applier, g gVar, int i10, k kVar) {
        this(compositionContext, applier, (i10 & 4) != 0 ? null : gVar);
    }
}
