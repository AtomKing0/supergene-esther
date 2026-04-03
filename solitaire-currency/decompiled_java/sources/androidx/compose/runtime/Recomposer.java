package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.tooling.CompositionData;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdError;
import h9.p;
import h9.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.d0;
import kotlin.collections.w;
import kotlin.collections.y0;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.f2;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.h;
import s9.j;
import s9.m0;
import s9.o0;
import s9.y;
import v8.k0;
import v8.s;
import v8.t;
import v8.u;
import z8.g;

/* JADX INFO: compiled from: Recomposer.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class Recomposer extends CompositionContext {

    @NotNull
    private final y<State> _state;

    @NotNull
    private final BroadcastFrameClock broadcastFrameClock;
    private long changeCount;

    @Nullable
    private Throwable closeCause;

    @NotNull
    private final List<ControlledComposition> compositionInvalidations;

    @NotNull
    private final Map<MovableContentStateReference, MovableContentState> compositionValueStatesAvailable;

    @NotNull
    private final List<MovableContentStateReference> compositionValuesAwaitingInsert;

    @NotNull
    private final Map<MovableContent<Object>, List<MovableContentStateReference>> compositionValuesRemoved;

    @NotNull
    private final List<ControlledComposition> compositionsAwaitingApply;
    private int concurrentCompositionsOutstanding;

    @NotNull
    private final g effectCoroutineContext;

    @NotNull
    private final a0 effectJob;
    private boolean isClosed;

    @NotNull
    private final List<ControlledComposition> knownCompositions;

    @NotNull
    private final RecomposerInfoImpl recomposerInfo;

    @Nullable
    private b2 runnerJob;

    @NotNull
    private final List<Set<Object>> snapshotInvalidations;

    @NotNull
    private final Object stateLock;

    @Nullable
    private o<? super k0> workContinuation;

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    @NotNull
    private static final y<PersistentSet<RecomposerInfoImpl>> _runningRecomposers = o0.a(ExtensionsKt.persistentSetOf());

    /* JADX INFO: compiled from: Recomposer.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void addRunning(RecomposerInfoImpl recomposerInfoImpl) {
            PersistentSet persistentSet;
            PersistentSet persistentSetAdd;
            do {
                persistentSet = (PersistentSet) Recomposer._runningRecomposers.getValue();
                persistentSetAdd = persistentSet.add(recomposerInfoImpl);
                if (persistentSet == persistentSetAdd) {
                    return;
                }
            } while (!Recomposer._runningRecomposers.d(persistentSet, persistentSetAdd));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void removeRunning(RecomposerInfoImpl recomposerInfoImpl) {
            PersistentSet persistentSet;
            PersistentSet persistentSetRemove;
            do {
                persistentSet = (PersistentSet) Recomposer._runningRecomposers.getValue();
                persistentSetRemove = persistentSet.remove(recomposerInfoImpl);
                if (persistentSet == persistentSetRemove) {
                    return;
                }
            } while (!Recomposer._runningRecomposers.d(persistentSet, persistentSetRemove));
        }

        @NotNull
        public final m0<Set<RecomposerInfo>> getRunningRecomposers() {
            return Recomposer._runningRecomposers;
        }

        public final void invalidateGroupsWithKey$runtime_release(int i10) {
            Iterator it = ((Iterable) Recomposer._runningRecomposers.getValue()).iterator();
            while (it.hasNext()) {
                ((RecomposerInfoImpl) it.next()).invalidateGroupsWithKey(i10);
            }
        }

        public final void loadStateAndComposeForHotReload$runtime_release(@NotNull Object token) {
            t.i(token, "token");
            List list = (List) token;
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((HotReloadable) list.get(i10)).resetContent();
            }
            int size2 = list.size();
            for (int i11 = 0; i11 < size2; i11++) {
                ((HotReloadable) list.get(i11)).recompose();
            }
        }

        @NotNull
        public final Object saveStateAndDisposeForHotReload$runtime_release() {
            Iterable iterable = (Iterable) Recomposer._runningRecomposers.getValue();
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                kotlin.collections.a0.B(arrayList, ((RecomposerInfoImpl) it.next()).saveStateAndDisposeForHotReload());
            }
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: Recomposer.kt */
    private static final class HotReloadable {

        @NotNull
        private p<? super Composer, ? super Integer, k0> composable;

        @NotNull
        private final CompositionImpl composition;

        public HotReloadable(@NotNull CompositionImpl composition) {
            t.i(composition, "composition");
            this.composition = composition;
            this.composable = composition.getComposable();
        }

        public final void clearContent() {
            if (this.composition.isRoot()) {
                this.composition.setContent(ComposableSingletons$RecomposerKt.INSTANCE.m1246getLambda1$runtime_release());
            }
        }

        public final void recompose() {
            if (this.composition.isRoot()) {
                this.composition.setContent(this.composable);
            }
        }

        public final void resetContent() {
            this.composition.setComposable(this.composable);
        }
    }

    /* JADX INFO: compiled from: Recomposer.kt */
    private final class RecomposerInfoImpl implements RecomposerInfo {
        public RecomposerInfoImpl() {
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public long getChangeCount() {
            return Recomposer.this.getChangeCount();
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public boolean getHasPendingWork() {
            return Recomposer.this.getHasPendingWork();
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        @NotNull
        public h<State> getState() {
            return Recomposer.this.getCurrentState();
        }

        public final void invalidateGroupsWithKey(int i10) {
            List listR0;
            Object obj = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (obj) {
                listR0 = d0.R0(recomposer.knownCompositions);
            }
            ArrayList arrayList = new ArrayList(listR0.size());
            int size = listR0.size();
            for (int i11 = 0; i11 < size; i11++) {
                ControlledComposition controlledComposition = (ControlledComposition) listR0.get(i11);
                CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
                if (compositionImpl != null) {
                    arrayList.add(compositionImpl);
                }
            }
            int size2 = arrayList.size();
            for (int i12 = 0; i12 < size2; i12++) {
                ((CompositionImpl) arrayList.get(i12)).invalidateGroupsWithKey(i10);
            }
        }

        @NotNull
        public final List<HotReloadable> saveStateAndDisposeForHotReload() {
            List listR0;
            Object obj = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (obj) {
                listR0 = d0.R0(recomposer.knownCompositions);
            }
            ArrayList arrayList = new ArrayList(listR0.size());
            int size = listR0.size();
            for (int i10 = 0; i10 < size; i10++) {
                ControlledComposition controlledComposition = (ControlledComposition) listR0.get(i10);
                CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
                if (compositionImpl != null) {
                    arrayList.add(compositionImpl);
                }
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size2 = arrayList.size();
            for (int i11 = 0; i11 < size2; i11++) {
                HotReloadable hotReloadable = new HotReloadable((CompositionImpl) arrayList.get(i11));
                hotReloadable.clearContent();
                arrayList2.add(hotReloadable);
            }
            return arrayList2;
        }
    }

    /* JADX INFO: compiled from: Recomposer.kt */
    public enum State {
        ShutDown,
        ShuttingDown,
        Inactive,
        InactivePendingWork,
        Idle,
        PendingWork
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$awaitIdle$2, reason: invalid class name */
    /* JADX INFO: compiled from: Recomposer.kt */
    @f(c = "androidx.compose.runtime.Recomposer$awaitIdle$2", f = "Recomposer.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<State, z8.d<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(z8.d<? super AnonymousClass2> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(dVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull State state, @Nullable z8.d<? super Boolean> dVar) {
            return ((AnonymousClass2) create(state, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            return kotlin.coroutines.jvm.internal.b.a(((State) this.L$0).compareTo(State.Idle) > 0);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$join$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Recomposer.kt */
    @f(c = "androidx.compose.runtime.Recomposer$join$2", f = "Recomposer.kt", l = {}, m = "invokeSuspend")
    static final class C09822 extends l implements p<State, z8.d<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        C09822(z8.d<? super C09822> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            C09822 c09822 = new C09822(dVar);
            c09822.L$0 = obj;
            return c09822;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull State state, @Nullable z8.d<? super Boolean> dVar) {
            return ((C09822) create(state, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            return kotlin.coroutines.jvm.internal.b.a(((State) this.L$0) == State.ShutDown);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$readObserverOf$1, reason: invalid class name */
    /* JADX INFO: compiled from: Recomposer.kt */
    static final class AnonymousClass1 extends v implements h9.l<Object, k0> {
        final /* synthetic */ ControlledComposition $composition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ControlledComposition controlledComposition) {
            super(1);
            this.$composition = controlledComposition;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Object obj) {
            invoke2(obj);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Object value) {
            t.i(value, "value");
            this.$composition.recordReadOf(value);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$recompositionRunner$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Recomposer.kt */
    @f(c = "androidx.compose.runtime.Recomposer$recompositionRunner$2", f = "Recomposer.kt", l = {744}, m = "invokeSuspend")
    static final class C09832 extends l implements p<kotlinx.coroutines.o0, z8.d<? super k0>, Object> {
        final /* synthetic */ q<kotlinx.coroutines.o0, MonotonicFrameClock, z8.d<? super k0>, Object> $block;
        final /* synthetic */ MonotonicFrameClock $parentFrameClock;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$recompositionRunner$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Recomposer.kt */
        @f(c = "androidx.compose.runtime.Recomposer$recompositionRunner$2$2", f = "Recomposer.kt", l = {745}, m = "invokeSuspend")
        static final class C01172 extends l implements p<kotlinx.coroutines.o0, z8.d<? super k0>, Object> {
            final /* synthetic */ q<kotlinx.coroutines.o0, MonotonicFrameClock, z8.d<? super k0>, Object> $block;
            final /* synthetic */ MonotonicFrameClock $parentFrameClock;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C01172(q<? super kotlinx.coroutines.o0, ? super MonotonicFrameClock, ? super z8.d<? super k0>, ? extends Object> qVar, MonotonicFrameClock monotonicFrameClock, z8.d<? super C01172> dVar) {
                super(2, dVar);
                this.$block = qVar;
                this.$parentFrameClock = monotonicFrameClock;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                C01172 c01172 = new C01172(this.$block, this.$parentFrameClock, dVar);
                c01172.L$0 = obj;
                return c01172;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    kotlinx.coroutines.o0 o0Var = (kotlinx.coroutines.o0) this.L$0;
                    q<kotlinx.coroutines.o0, MonotonicFrameClock, z8.d<? super k0>, Object> qVar = this.$block;
                    MonotonicFrameClock monotonicFrameClock = this.$parentFrameClock;
                    this.label = 1;
                    if (qVar.invoke(o0Var, monotonicFrameClock, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                }
                return k0.f35197a;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                return ((C01172) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09832(q<? super kotlinx.coroutines.o0, ? super MonotonicFrameClock, ? super z8.d<? super k0>, ? extends Object> qVar, MonotonicFrameClock monotonicFrameClock, z8.d<? super C09832> dVar) {
            super(2, dVar);
            this.$block = qVar;
            this.$parentFrameClock = monotonicFrameClock;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            C09832 c09832 = Recomposer.this.new C09832(this.$block, this.$parentFrameClock, dVar);
            c09832.L$0 = obj;
            return c09832;
        }

        /* JADX WARN: Removed duplicated region for block: B:53:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x00c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 226
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.C09832.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((C09832) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$runFrameLoop$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Recomposer.kt */
    @f(c = "androidx.compose.runtime.Recomposer", f = "Recomposer.kt", l = {IronSourceError.ERROR_BN_BINDING_SKIP_INVISIBLE, LevelPlayAdError.ERROR_CODE_SHOW_WHILE_SHOW}, m = "runFrameLoop")
    static final class C09841 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C09841(z8.d<? super C09841> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Recomposer.this.runFrameLoop(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$runFrameLoop$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Recomposer.kt */
    static final class C09852 extends v implements h9.l<Long, o<? super k0>> {
        final /* synthetic */ ProduceFrameSignal $frameSignal;
        final /* synthetic */ List<ControlledComposition> $toApply;
        final /* synthetic */ List<ControlledComposition> $toRecompose;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09852(List<ControlledComposition> list, List<ControlledComposition> list2, ProduceFrameSignal produceFrameSignal) {
            super(1);
            this.$toRecompose = list;
            this.$toApply = list2;
            this.$frameSignal = produceFrameSignal;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ o<? super k0> invoke(Long l10) {
            return invoke(l10.longValue());
        }

        @Nullable
        public final o<k0> invoke(long j10) {
            Object objBeginSection;
            int i10;
            o<k0> oVarDeriveStateLocked;
            if (Recomposer.this.broadcastFrameClock.getHasAwaiters()) {
                Recomposer recomposer = Recomposer.this;
                Trace trace = Trace.INSTANCE;
                objBeginSection = trace.beginSection("Recomposer:animation");
                try {
                    recomposer.broadcastFrameClock.sendFrame(j10);
                    Snapshot.Companion.sendApplyNotifications();
                    k0 k0Var = k0.f35197a;
                    trace.endSection(objBeginSection);
                } finally {
                }
            }
            Recomposer recomposer2 = Recomposer.this;
            List<ControlledComposition> list = this.$toRecompose;
            List<ControlledComposition> list2 = this.$toApply;
            ProduceFrameSignal produceFrameSignal = this.$frameSignal;
            objBeginSection = Trace.INSTANCE.beginSection("Recomposer:recompose");
            try {
                synchronized (recomposer2.stateLock) {
                    recomposer2.recordComposerModificationsLocked();
                    List list3 = recomposer2.compositionsAwaitingApply;
                    int size = list3.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        list2.add((ControlledComposition) list3.get(i11));
                    }
                    recomposer2.compositionsAwaitingApply.clear();
                    List list4 = recomposer2.compositionInvalidations;
                    int size2 = list4.size();
                    for (int i12 = 0; i12 < size2; i12++) {
                        list.add((ControlledComposition) list4.get(i12));
                    }
                    recomposer2.compositionInvalidations.clear();
                    produceFrameSignal.takeFrameRequestLocked();
                    k0 k0Var2 = k0.f35197a;
                }
                IdentityArraySet identityArraySet = new IdentityArraySet();
                try {
                    int size3 = list.size();
                    for (int i13 = 0; i13 < size3; i13++) {
                        ControlledComposition controlledCompositionPerformRecompose = recomposer2.performRecompose(list.get(i13), identityArraySet);
                        if (controlledCompositionPerformRecompose != null) {
                            list2.add(controlledCompositionPerformRecompose);
                        }
                    }
                    list.clear();
                    if (!list2.isEmpty()) {
                        recomposer2.changeCount = recomposer2.getChangeCount() + 1;
                    }
                    try {
                        int size4 = list2.size();
                        for (i10 = 0; i10 < size4; i10++) {
                            list2.get(i10).applyChanges();
                        }
                        list2.clear();
                        synchronized (recomposer2.stateLock) {
                            oVarDeriveStateLocked = recomposer2.deriveStateLocked();
                        }
                        return oVarDeriveStateLocked;
                    } catch (Throwable th) {
                        list2.clear();
                        throw th;
                    }
                } catch (Throwable th2) {
                    list.clear();
                    throw th2;
                }
            } finally {
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Recomposer.kt */
    @f(c = "androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2", f = "Recomposer.kt", l = {436, 454}, m = "invokeSuspend")
    static final class C09862 extends l implements q<kotlinx.coroutines.o0, MonotonicFrameClock, z8.d<? super k0>, Object> {
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Recomposer.kt */
        static final class C01182 extends v implements h9.l<Long, o<? super k0>> {
            final /* synthetic */ List<ControlledComposition> $toApply;
            final /* synthetic */ Set<ControlledComposition> $toComplete;
            final /* synthetic */ List<MovableContentStateReference> $toInsert;
            final /* synthetic */ Set<ControlledComposition> $toLateApply;
            final /* synthetic */ List<ControlledComposition> $toRecompose;
            final /* synthetic */ Recomposer this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01182(Recomposer recomposer, List<ControlledComposition> list, List<MovableContentStateReference> list2, Set<ControlledComposition> set, List<ControlledComposition> list3, Set<ControlledComposition> set2) {
                super(1);
                this.this$0 = recomposer;
                this.$toRecompose = list;
                this.$toInsert = list2;
                this.$toLateApply = set;
                this.$toApply = list3;
                this.$toComplete = set2;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ o<? super k0> invoke(Long l10) {
                return invoke(l10.longValue());
            }

            @Nullable
            public final o<k0> invoke(long j10) {
                Object objBeginSection;
                IdentityArraySet identityArraySet;
                IdentityArraySet identityArraySet2;
                o<k0> oVarDeriveStateLocked;
                if (this.this$0.broadcastFrameClock.getHasAwaiters()) {
                    Recomposer recomposer = this.this$0;
                    Trace trace = Trace.INSTANCE;
                    objBeginSection = trace.beginSection("Recomposer:animation");
                    try {
                        recomposer.broadcastFrameClock.sendFrame(j10);
                        Snapshot.Companion.sendApplyNotifications();
                        k0 k0Var = k0.f35197a;
                        trace.endSection(objBeginSection);
                    } finally {
                    }
                }
                Recomposer recomposer2 = this.this$0;
                List<ControlledComposition> list = this.$toRecompose;
                List<MovableContentStateReference> list2 = this.$toInsert;
                Set<ControlledComposition> set = this.$toLateApply;
                List<ControlledComposition> list3 = this.$toApply;
                Set<ControlledComposition> set2 = this.$toComplete;
                objBeginSection = Trace.INSTANCE.beginSection("Recomposer:recompose");
                try {
                    synchronized (recomposer2.stateLock) {
                        recomposer2.recordComposerModificationsLocked();
                        List list4 = recomposer2.compositionInvalidations;
                        int size = list4.size();
                        for (int i10 = 0; i10 < size; i10++) {
                            list.add((ControlledComposition) list4.get(i10));
                        }
                        recomposer2.compositionInvalidations.clear();
                        k0 k0Var2 = k0.f35197a;
                    }
                    identityArraySet = new IdentityArraySet();
                    identityArraySet2 = new IdentityArraySet();
                } finally {
                }
                while (true) {
                    if (!(!list.isEmpty()) && !(!list2.isEmpty())) {
                        break;
                    }
                    try {
                        int size2 = list.size();
                        for (int i11 = 0; i11 < size2; i11++) {
                            ControlledComposition controlledComposition = list.get(i11);
                            identityArraySet2.add(controlledComposition);
                            ControlledComposition controlledCompositionPerformRecompose = recomposer2.performRecompose(controlledComposition, identityArraySet);
                            if (controlledCompositionPerformRecompose != null) {
                                list3.add(controlledCompositionPerformRecompose);
                            }
                        }
                        list.clear();
                        if (identityArraySet.isNotEmpty()) {
                            synchronized (recomposer2.stateLock) {
                                List list5 = recomposer2.knownCompositions;
                                int size3 = list5.size();
                                for (int i12 = 0; i12 < size3; i12++) {
                                    ControlledComposition controlledComposition2 = (ControlledComposition) list5.get(i12);
                                    if (!identityArraySet2.contains(controlledComposition2) && controlledComposition2.observesAnyOf(identityArraySet)) {
                                        list.add(controlledComposition2);
                                    }
                                }
                                k0 k0Var3 = k0.f35197a;
                            }
                        }
                        if (list.isEmpty()) {
                            C09862.invokeSuspend$fillToInsert(list2, recomposer2);
                            while (!list2.isEmpty()) {
                                kotlin.collections.a0.B(set, recomposer2.performInsertValues(list2, identityArraySet));
                                C09862.invokeSuspend$fillToInsert(list2, recomposer2);
                            }
                        }
                    } catch (Throwable th) {
                        list.clear();
                        throw th;
                    }
                }
                if (!list3.isEmpty()) {
                    recomposer2.changeCount = recomposer2.getChangeCount() + 1;
                    try {
                        kotlin.collections.a0.B(set2, list3);
                        int size4 = list3.size();
                        for (int i13 = 0; i13 < size4; i13++) {
                            list3.get(i13).applyChanges();
                        }
                        list3.clear();
                    } catch (Throwable th2) {
                        list3.clear();
                        throw th2;
                    }
                }
                if (!set.isEmpty()) {
                    try {
                        kotlin.collections.a0.B(set2, set);
                        Iterator<T> it = set.iterator();
                        while (it.hasNext()) {
                            ((ControlledComposition) it.next()).applyLateChanges();
                        }
                        set.clear();
                    } catch (Throwable th3) {
                        set.clear();
                        throw th3;
                    }
                }
                if (!set2.isEmpty()) {
                    try {
                        Iterator<T> it2 = set2.iterator();
                        while (it2.hasNext()) {
                            ((ControlledComposition) it2.next()).changesApplied();
                        }
                        set2.clear();
                    } catch (Throwable th4) {
                        set2.clear();
                        throw th4;
                    }
                }
                recomposer2.discardUnusedValues();
                synchronized (recomposer2.stateLock) {
                    oVarDeriveStateLocked = recomposer2.deriveStateLocked();
                }
                return oVarDeriveStateLocked;
            }
        }

        C09862(z8.d<? super C09862> dVar) {
            super(3, dVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer) {
            list.clear();
            synchronized (recomposer.stateLock) {
                List list2 = recomposer.compositionValuesAwaitingInsert;
                int size = list2.size();
                for (int i10 = 0; i10 < size; i10++) {
                    list.add((MovableContentStateReference) list2.get(i10));
                }
                recomposer.compositionValuesAwaitingInsert.clear();
                k0 k0Var = k0.f35197a;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0105  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00c8 -> B:11:0x0086). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00f9 -> B:31:0x00fd). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r19) {
            /*
                Method dump skipped, instruction units count: 264
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.C09862.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // h9.q
        @Nullable
        public final Object invoke(@NotNull kotlinx.coroutines.o0 o0Var, @NotNull MonotonicFrameClock monotonicFrameClock, @Nullable z8.d<? super k0> dVar) {
            C09862 c09862 = Recomposer.this.new C09862(dVar);
            c09862.L$0 = monotonicFrameClock;
            return c09862.invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Recomposer.kt */
    @f(c = "androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2", f = "Recomposer.kt", l = {592, 612, IronSourceError.ERROR_BN_RELOAD_SKIP_INVISIBLE}, m = "invokeSuspend")
    static final class C09872 extends l implements q<kotlinx.coroutines.o0, MonotonicFrameClock, z8.d<? super k0>, Object> {
        final /* synthetic */ g $recomposeCoroutineContext;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ Recomposer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09872(g gVar, Recomposer recomposer, z8.d<? super C09872> dVar) {
            super(3, dVar);
            this.$recomposeCoroutineContext = gVar;
            this.this$0 = recomposer;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0171  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0195 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:65:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00aa -> B:25:0x00ac). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r20) {
            /*
                Method dump skipped, instruction units count: 440
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.C09872.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // h9.q
        @Nullable
        public final Object invoke(@NotNull kotlinx.coroutines.o0 o0Var, @NotNull MonotonicFrameClock monotonicFrameClock, @Nullable z8.d<? super k0> dVar) {
            C09872 c09872 = new C09872(this.$recomposeCoroutineContext, this.this$0, dVar);
            c09872.L$0 = o0Var;
            c09872.L$1 = monotonicFrameClock;
            return c09872.invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$writeObserverOf$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Recomposer.kt */
    static final class C09881 extends v implements h9.l<Object, k0> {
        final /* synthetic */ ControlledComposition $composition;
        final /* synthetic */ IdentityArraySet<Object> $modifiedValues;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09881(ControlledComposition controlledComposition, IdentityArraySet<Object> identityArraySet) {
            super(1);
            this.$composition = controlledComposition;
            this.$modifiedValues = identityArraySet;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Object obj) {
            invoke2(obj);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Object value) {
            t.i(value, "value");
            this.$composition.recordWriteOf(value);
            IdentityArraySet<Object> identityArraySet = this.$modifiedValues;
            if (identityArraySet != null) {
                identityArraySet.add(value);
            }
        }
    }

    public Recomposer(@NotNull g effectCoroutineContext) {
        t.i(effectCoroutineContext, "effectCoroutineContext");
        BroadcastFrameClock broadcastFrameClock = new BroadcastFrameClock(new Recomposer$broadcastFrameClock$1(this));
        this.broadcastFrameClock = broadcastFrameClock;
        a0 a0VarA = f2.a((b2) effectCoroutineContext.get(b2.O7));
        a0VarA.J(new Recomposer$effectJob$1$1(this));
        this.effectJob = a0VarA;
        this.effectCoroutineContext = effectCoroutineContext.plus(broadcastFrameClock).plus(a0VarA);
        this.stateLock = new Object();
        this.knownCompositions = new ArrayList();
        this.snapshotInvalidations = new ArrayList();
        this.compositionInvalidations = new ArrayList();
        this.compositionsAwaitingApply = new ArrayList();
        this.compositionValuesAwaitingInsert = new ArrayList();
        this.compositionValuesRemoved = new LinkedHashMap();
        this.compositionValueStatesAvailable = new LinkedHashMap();
        this._state = o0.a(State.Inactive);
        this.recomposerInfo = new RecomposerInfoImpl();
    }

    private final void applyAndCheck(MutableSnapshot mutableSnapshot) {
        try {
            if (mutableSnapshot.apply() instanceof SnapshotApplyResult.Failure) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.".toString());
            }
        } finally {
            mutableSnapshot.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitWorkAvailable(z8.d<? super k0> dVar) throws Throwable {
        if (getHasSchedulingWork()) {
            return k0.f35197a;
        }
        kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(a9.c.c(dVar), 1);
        pVar.C();
        synchronized (this.stateLock) {
            if (getHasSchedulingWork()) {
                t.a aVar = v8.t.f35208b;
                pVar.resumeWith(v8.t.b(k0.f35197a));
            } else {
                this.workContinuation = pVar;
            }
            k0 k0Var = k0.f35197a;
        }
        Object objZ = pVar.z();
        if (objZ == a9.d.e()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ == a9.d.e() ? objZ : k0.f35197a;
    }

    private final <T> T composing(ControlledComposition controlledComposition, IdentityArraySet<Object> identityArraySet, h9.a<? extends T> aVar) {
        MutableSnapshot mutableSnapshotTakeMutableSnapshot = Snapshot.Companion.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, identityArraySet));
        try {
            Snapshot snapshotMakeCurrent = mutableSnapshotTakeMutableSnapshot.makeCurrent();
            try {
                return aVar.invoke();
            } finally {
                r.b(1);
                mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                r.a(1);
            }
        } finally {
            r.b(1);
            applyAndCheck(mutableSnapshotTakeMutableSnapshot);
            r.a(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final o<k0> deriveStateLocked() {
        State state;
        if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
            this.knownCompositions.clear();
            this.snapshotInvalidations.clear();
            this.compositionInvalidations.clear();
            this.compositionsAwaitingApply.clear();
            this.compositionValuesAwaitingInsert.clear();
            o<? super k0> oVar = this.workContinuation;
            if (oVar != null) {
                o.a.a(oVar, null, 1, null);
            }
            this.workContinuation = null;
            return null;
        }
        if (this.runnerJob == null) {
            this.snapshotInvalidations.clear();
            this.compositionInvalidations.clear();
            state = this.broadcastFrameClock.getHasAwaiters() ? State.InactivePendingWork : State.Inactive;
        } else {
            state = ((this.compositionInvalidations.isEmpty() ^ true) || (this.snapshotInvalidations.isEmpty() ^ true) || (this.compositionsAwaitingApply.isEmpty() ^ true) || (this.compositionValuesAwaitingInsert.isEmpty() ^ true) || this.concurrentCompositionsOutstanding > 0 || this.broadcastFrameClock.getHasAwaiters()) ? State.PendingWork : State.Idle;
        }
        this._state.setValue(state);
        if (state != State.PendingWork) {
            return null;
        }
        o oVar2 = this.workContinuation;
        this.workContinuation = null;
        return oVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void discardUnusedValues() {
        int i10;
        List listL;
        synchronized (this.stateLock) {
            if (!this.compositionValuesRemoved.isEmpty()) {
                List listX = w.x(this.compositionValuesRemoved.values());
                this.compositionValuesRemoved.clear();
                listL = new ArrayList(listX.size());
                int size = listX.size();
                for (int i11 = 0; i11 < size; i11++) {
                    MovableContentStateReference movableContentStateReference = (MovableContentStateReference) listX.get(i11);
                    listL.add(v8.y.a(movableContentStateReference, this.compositionValueStatesAvailable.get(movableContentStateReference)));
                }
                this.compositionValueStatesAvailable.clear();
            } else {
                listL = kotlin.collections.v.l();
            }
        }
        int size2 = listL.size();
        for (i10 = 0; i10 < size2; i10++) {
            s sVar = (s) listL.get(i10);
            MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) sVar.a();
            MovableContentState movableContentState = (MovableContentState) sVar.b();
            if (movableContentState != null) {
                movableContentStateReference2.getComposition$runtime_release().disposeUnusedMovableContent(movableContentState);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasConcurrentFrameWorkLocked() {
        return (this.compositionsAwaitingApply.isEmpty() ^ true) || this.broadcastFrameClock.getHasAwaiters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasFrameWorkLocked() {
        return (this.compositionInvalidations.isEmpty() ^ true) || this.broadcastFrameClock.getHasAwaiters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasSchedulingWork() {
        boolean z10;
        synchronized (this.stateLock) {
            z10 = true;
            if (!(!this.snapshotInvalidations.isEmpty()) && !(!this.compositionInvalidations.isEmpty())) {
                if (!this.broadcastFrameClock.getHasAwaiters()) {
                    z10 = false;
                }
            }
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getShouldKeepRecomposing() {
        boolean z10;
        boolean z11;
        synchronized (this.stateLock) {
            z10 = !this.isClosed;
        }
        if (z10) {
            return true;
        }
        Iterator<b2> it = this.effectJob.q().iterator();
        while (true) {
            if (!it.hasNext()) {
                z11 = false;
                break;
            }
            if (it.next().isActive()) {
                z11 = true;
                break;
            }
        }
        return z11;
    }

    private final void performInitialMovableContentInserts(ControlledComposition controlledComposition) {
        synchronized (this.stateLock) {
            List<MovableContentStateReference> list = this.compositionValuesAwaitingInsert;
            int size = list.size();
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    break;
                }
                if (kotlin.jvm.internal.t.d(list.get(i10).getComposition$runtime_release(), controlledComposition)) {
                    z10 = true;
                    break;
                }
                i10++;
            }
            if (z10) {
                k0 k0Var = k0.f35197a;
                ArrayList arrayList = new ArrayList();
                performInitialMovableContentInserts$fillToInsert(arrayList, this, controlledComposition);
                while (!arrayList.isEmpty()) {
                    performInsertValues(arrayList, null);
                    performInitialMovableContentInserts$fillToInsert(arrayList, this, controlledComposition);
                }
            }
        }
    }

    private static final void performInitialMovableContentInserts$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer, ControlledComposition controlledComposition) {
        list.clear();
        synchronized (recomposer.stateLock) {
            Iterator<MovableContentStateReference> it = recomposer.compositionValuesAwaitingInsert.iterator();
            while (it.hasNext()) {
                MovableContentStateReference next = it.next();
                if (kotlin.jvm.internal.t.d(next.getComposition$runtime_release(), controlledComposition)) {
                    list.add(next);
                    it.remove();
                }
            }
            k0 k0Var = k0.f35197a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ControlledComposition> performInsertValues(List<MovableContentStateReference> list, IdentityArraySet<Object> identityArraySet) {
        ArrayList arrayList;
        HashMap map = new HashMap(list.size());
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            MovableContentStateReference movableContentStateReference = list.get(i10);
            ControlledComposition composition$runtime_release = movableContentStateReference.getComposition$runtime_release();
            Object arrayList2 = map.get(composition$runtime_release);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                map.put(composition$runtime_release, arrayList2);
            }
            ((ArrayList) arrayList2).add(movableContentStateReference);
        }
        for (Map.Entry entry : map.entrySet()) {
            ControlledComposition controlledComposition = (ControlledComposition) entry.getKey();
            List list2 = (List) entry.getValue();
            ComposerKt.runtimeCheck(!controlledComposition.isComposing());
            MutableSnapshot mutableSnapshotTakeMutableSnapshot = Snapshot.Companion.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, identityArraySet));
            try {
                Snapshot snapshotMakeCurrent = mutableSnapshotTakeMutableSnapshot.makeCurrent();
                try {
                    synchronized (this.stateLock) {
                        arrayList = new ArrayList(list2.size());
                        int size2 = list2.size();
                        for (int i11 = 0; i11 < size2; i11++) {
                            MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) list2.get(i11);
                            arrayList.add(v8.y.a(movableContentStateReference2, RecomposerKt.removeLastMultiValue(this.compositionValuesRemoved, movableContentStateReference2.getContent$runtime_release())));
                        }
                    }
                    controlledComposition.insertMovableContent(arrayList);
                    k0 k0Var = k0.f35197a;
                } finally {
                }
            } finally {
                applyAndCheck(mutableSnapshotTakeMutableSnapshot);
            }
        }
        return d0.P0(map.keySet());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ControlledComposition performRecompose(ControlledComposition controlledComposition, IdentityArraySet<Object> identityArraySet) {
        if (controlledComposition.isComposing() || controlledComposition.isDisposed()) {
            return null;
        }
        MutableSnapshot mutableSnapshotTakeMutableSnapshot = Snapshot.Companion.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, identityArraySet));
        try {
            Snapshot snapshotMakeCurrent = mutableSnapshotTakeMutableSnapshot.makeCurrent();
            boolean z10 = false;
            if (identityArraySet != null) {
                try {
                    if (identityArraySet.isNotEmpty()) {
                        z10 = true;
                    }
                } catch (Throwable th) {
                    mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    throw th;
                }
            }
            if (z10) {
                controlledComposition.prepareCompose(new Recomposer$performRecompose$1$1(identityArraySet, controlledComposition));
            }
            boolean zRecompose = controlledComposition.recompose();
            mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
            if (zRecompose) {
                return controlledComposition;
            }
            return null;
        } finally {
            applyAndCheck(mutableSnapshotTakeMutableSnapshot);
        }
    }

    private final h9.l<Object, k0> readObserverOf(ControlledComposition controlledComposition) {
        return new AnonymousClass1(controlledComposition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object recompositionRunner(q<? super kotlinx.coroutines.o0, ? super MonotonicFrameClock, ? super z8.d<? super k0>, ? extends Object> qVar, z8.d<? super k0> dVar) {
        Object objG = i.g(this.broadcastFrameClock, new C09832(qVar, MonotonicFrameClockKt.getMonotonicFrameClock(dVar.getContext()), null), dVar);
        return objG == a9.d.e() ? objG : k0.f35197a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordComposerModificationsLocked() {
        if (!this.snapshotInvalidations.isEmpty()) {
            List<Set<Object>> list = this.snapshotInvalidations;
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                Set<? extends Object> set = list.get(i10);
                List<ControlledComposition> list2 = this.knownCompositions;
                int size2 = list2.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    list2.get(i11).recordModificationsOf(set);
                }
            }
            this.snapshotInvalidations.clear();
            if (deriveStateLocked() != null) {
                throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerRunnerJob(b2 b2Var) {
        synchronized (this.stateLock) {
            Throwable th = this.closeCause;
            if (th != null) {
                throw th;
            }
            if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                throw new IllegalStateException("Recomposer shut down".toString());
            }
            if (this.runnerJob != null) {
                throw new IllegalStateException("Recomposer already running".toString());
            }
            this.runnerJob = b2Var;
            deriveStateLocked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0087 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00a2 -> B:13:0x003f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object runFrameLoop(androidx.compose.runtime.MonotonicFrameClock r8, androidx.compose.runtime.ProduceFrameSignal r9, z8.d<? super v8.k0> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof androidx.compose.runtime.Recomposer.C09841
            if (r0 == 0) goto L13
            r0 = r10
            androidx.compose.runtime.Recomposer$runFrameLoop$1 r0 = (androidx.compose.runtime.Recomposer.C09841) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.runtime.Recomposer$runFrameLoop$1 r0 = new androidx.compose.runtime.Recomposer$runFrameLoop$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L65
            if (r2 == r4) goto L4d
            if (r2 != r3) goto L45
            java.lang.Object r8 = r0.L$4
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r0.L$3
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r2 = r0.L$2
            androidx.compose.runtime.ProduceFrameSignal r2 = (androidx.compose.runtime.ProduceFrameSignal) r2
            java.lang.Object r5 = r0.L$1
            androidx.compose.runtime.MonotonicFrameClock r5 = (androidx.compose.runtime.MonotonicFrameClock) r5
            java.lang.Object r6 = r0.L$0
            androidx.compose.runtime.Recomposer r6 = (androidx.compose.runtime.Recomposer) r6
            v8.u.b(r10)
        L3f:
            r10 = r9
            r9 = r2
            r2 = r8
            r8 = r5
            r5 = r6
            goto L73
        L45:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L4d:
            java.lang.Object r8 = r0.L$4
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r0.L$3
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r2 = r0.L$2
            androidx.compose.runtime.ProduceFrameSignal r2 = (androidx.compose.runtime.ProduceFrameSignal) r2
            java.lang.Object r5 = r0.L$1
            androidx.compose.runtime.MonotonicFrameClock r5 = (androidx.compose.runtime.MonotonicFrameClock) r5
            java.lang.Object r6 = r0.L$0
            androidx.compose.runtime.Recomposer r6 = (androidx.compose.runtime.Recomposer) r6
            v8.u.b(r10)
            goto L8d
        L65:
            v8.u.b(r10)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r5 = r7
        L73:
            java.lang.Object r6 = r5.stateLock
            r0.L$0 = r5
            r0.L$1 = r8
            r0.L$2 = r9
            r0.L$3 = r10
            r0.L$4 = r2
            r0.label = r4
            java.lang.Object r6 = r9.awaitFrameRequest(r6, r0)
            if (r6 != r1) goto L88
            return r1
        L88:
            r6 = r5
            r5 = r8
            r8 = r2
            r2 = r9
            r9 = r10
        L8d:
            androidx.compose.runtime.Recomposer$runFrameLoop$2 r10 = new androidx.compose.runtime.Recomposer$runFrameLoop$2
            r10.<init>(r9, r8, r2)
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r2
            r0.L$3 = r9
            r0.L$4 = r8
            r0.label = r3
            java.lang.Object r10 = r5.withFrameNanos(r10, r0)
            if (r10 != r1) goto L3f
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.runFrameLoop(androidx.compose.runtime.MonotonicFrameClock, androidx.compose.runtime.ProduceFrameSignal, z8.d):java.lang.Object");
    }

    private final h9.l<Object, k0> writeObserverOf(ControlledComposition controlledComposition, IdentityArraySet<Object> identityArraySet) {
        return new C09881(controlledComposition, identityArraySet);
    }

    @NotNull
    public final RecomposerInfo asRecomposerInfo() {
        return this.recomposerInfo;
    }

    @Nullable
    public final Object awaitIdle(@NotNull z8.d<? super k0> dVar) {
        Object objK = j.k(j.N(getCurrentState(), new AnonymousClass2(null)), dVar);
        return objK == a9.d.e() ? objK : k0.f35197a;
    }

    public final void cancel() {
        synchronized (this.stateLock) {
            if (this._state.getValue().compareTo(State.Idle) >= 0) {
                this._state.setValue(State.ShuttingDown);
            }
            k0 k0Var = k0.f35197a;
        }
        b2.a.a(this.effectJob, null, 1, null);
    }

    public final void close() {
        if (this.effectJob.complete()) {
            synchronized (this.stateLock) {
                this.isClosed = true;
                k0 k0Var = k0.f35197a;
            }
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    @ComposableInferredTarget(scheme = "[0[0]]")
    public void composeInitial$runtime_release(@NotNull ControlledComposition composition, @NotNull p<? super Composer, ? super Integer, k0> content) {
        kotlin.jvm.internal.t.i(composition, "composition");
        kotlin.jvm.internal.t.i(content, "content");
        boolean zIsComposing = composition.isComposing();
        Snapshot.Companion companion = Snapshot.Companion;
        MutableSnapshot mutableSnapshotTakeMutableSnapshot = companion.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, null));
        try {
            Snapshot snapshotMakeCurrent = mutableSnapshotTakeMutableSnapshot.makeCurrent();
            try {
                composition.composeContent(content);
                k0 k0Var = k0.f35197a;
                if (!zIsComposing) {
                    companion.notifyObjectsInitialized();
                }
                synchronized (this.stateLock) {
                    if (this._state.getValue().compareTo(State.ShuttingDown) > 0 && !this.knownCompositions.contains(composition)) {
                        this.knownCompositions.add(composition);
                    }
                }
                performInitialMovableContentInserts(composition);
                composition.applyChanges();
                composition.applyLateChanges();
                if (zIsComposing) {
                    return;
                }
                companion.notifyObjectsInitialized();
            } finally {
                mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
            }
        } finally {
            applyAndCheck(mutableSnapshotTakeMutableSnapshot);
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void deletedMovableContent$runtime_release(@NotNull MovableContentStateReference reference) {
        kotlin.jvm.internal.t.i(reference, "reference");
        synchronized (this.stateLock) {
            RecomposerKt.addMultiValue(this.compositionValuesRemoved, reference.getContent$runtime_release(), reference);
        }
    }

    public final long getChangeCount() {
        return this.changeCount;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingParameterInformation$runtime_release() {
        return false;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public int getCompoundHashKey$runtime_release() {
        return 1000;
    }

    @NotNull
    public final m0<State> getCurrentState() {
        return this._state;
    }

    @Override // androidx.compose.runtime.CompositionContext
    @NotNull
    public g getEffectCoroutineContext$runtime_release() {
        return this.effectCoroutineContext;
    }

    public final boolean getHasPendingWork() {
        boolean z10;
        synchronized (this.stateLock) {
            z10 = true;
            if (!(!this.snapshotInvalidations.isEmpty()) && !(!this.compositionInvalidations.isEmpty()) && this.concurrentCompositionsOutstanding <= 0 && !(!this.compositionsAwaitingApply.isEmpty())) {
                if (!this.broadcastFrameClock.getHasAwaiters()) {
                    z10 = false;
                }
            }
        }
        return z10;
    }

    @Override // androidx.compose.runtime.CompositionContext
    @NotNull
    public g getRecomposeCoroutineContext$runtime_release() {
        return z8.h.f37608a;
    }

    @NotNull
    public final h<State> getState() {
        return getCurrentState();
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void insertMovableContent$runtime_release(@NotNull MovableContentStateReference reference) {
        o<k0> oVarDeriveStateLocked;
        kotlin.jvm.internal.t.i(reference, "reference");
        synchronized (this.stateLock) {
            this.compositionValuesAwaitingInsert.add(reference);
            oVarDeriveStateLocked = deriveStateLocked();
        }
        if (oVarDeriveStateLocked != null) {
            t.a aVar = v8.t.f35208b;
            oVarDeriveStateLocked.resumeWith(v8.t.b(k0.f35197a));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidate$runtime_release(@NotNull ControlledComposition composition) {
        o<k0> oVarDeriveStateLocked;
        kotlin.jvm.internal.t.i(composition, "composition");
        synchronized (this.stateLock) {
            if (this.compositionInvalidations.contains(composition)) {
                oVarDeriveStateLocked = null;
            } else {
                this.compositionInvalidations.add(composition);
                oVarDeriveStateLocked = deriveStateLocked();
            }
        }
        if (oVarDeriveStateLocked != null) {
            t.a aVar = v8.t.f35208b;
            oVarDeriveStateLocked.resumeWith(v8.t.b(k0.f35197a));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidateScope$runtime_release(@NotNull RecomposeScopeImpl scope) {
        o<k0> oVarDeriveStateLocked;
        kotlin.jvm.internal.t.i(scope, "scope");
        synchronized (this.stateLock) {
            this.snapshotInvalidations.add(y0.c(scope));
            oVarDeriveStateLocked = deriveStateLocked();
        }
        if (oVarDeriveStateLocked != null) {
            t.a aVar = v8.t.f35208b;
            oVarDeriveStateLocked.resumeWith(v8.t.b(k0.f35197a));
        }
    }

    @Nullable
    public final Object join(@NotNull z8.d<? super k0> dVar) {
        Object objV = j.v(getCurrentState(), new C09822(null), dVar);
        return objV == a9.d.e() ? objV : k0.f35197a;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void movableContentStateReleased$runtime_release(@NotNull MovableContentStateReference reference, @NotNull MovableContentState data) {
        kotlin.jvm.internal.t.i(reference, "reference");
        kotlin.jvm.internal.t.i(data, "data");
        synchronized (this.stateLock) {
            this.compositionValueStatesAvailable.put(reference, data);
            k0 k0Var = k0.f35197a;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    @Nullable
    public MovableContentState movableContentStateResolve$runtime_release(@NotNull MovableContentStateReference reference) {
        MovableContentState movableContentStateRemove;
        kotlin.jvm.internal.t.i(reference, "reference");
        synchronized (this.stateLock) {
            movableContentStateRemove = this.compositionValueStatesAvailable.remove(reference);
        }
        return movableContentStateRemove;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void recordInspectionTable$runtime_release(@NotNull Set<CompositionData> table) {
        kotlin.jvm.internal.t.i(table, "table");
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void registerComposition$runtime_release(@NotNull ControlledComposition composition) {
        kotlin.jvm.internal.t.i(composition, "composition");
    }

    @Nullable
    public final Object runRecomposeAndApplyChanges(@NotNull z8.d<? super k0> dVar) {
        Object objRecompositionRunner = recompositionRunner(new C09862(null), dVar);
        return objRecompositionRunner == a9.d.e() ? objRecompositionRunner : k0.f35197a;
    }

    @ExperimentalComposeApi
    @Nullable
    public final Object runRecomposeConcurrentlyAndApplyChanges(@NotNull g gVar, @NotNull z8.d<? super k0> dVar) {
        Object objRecompositionRunner = recompositionRunner(new C09872(gVar, this, null), dVar);
        return objRecompositionRunner == a9.d.e() ? objRecompositionRunner : k0.f35197a;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void unregisterComposition$runtime_release(@NotNull ControlledComposition composition) {
        kotlin.jvm.internal.t.i(composition, "composition");
        synchronized (this.stateLock) {
            this.knownCompositions.remove(composition);
            this.compositionInvalidations.remove(composition);
            this.compositionsAwaitingApply.remove(composition);
            k0 k0Var = k0.f35197a;
        }
    }

    private final void recordComposerModificationsLocked(h9.l<? super ControlledComposition, k0> lVar) {
        if (!this.snapshotInvalidations.isEmpty()) {
            List list = this.snapshotInvalidations;
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                Set<? extends Object> set = (Set) list.get(i10);
                List list2 = this.knownCompositions;
                int size2 = list2.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    ((ControlledComposition) list2.get(i11)).recordModificationsOf(set);
                }
            }
            this.snapshotInvalidations.clear();
        }
        List list3 = this.compositionInvalidations;
        int size3 = list3.size();
        for (int i12 = 0; i12 < size3; i12++) {
            lVar.invoke(list3.get(i12));
        }
        this.compositionInvalidations.clear();
        if (deriveStateLocked() != null) {
            throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
        }
    }

    public static /* synthetic */ void getState$annotations() {
    }
}
