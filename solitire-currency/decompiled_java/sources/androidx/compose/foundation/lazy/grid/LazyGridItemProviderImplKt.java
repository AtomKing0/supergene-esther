package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import h9.p;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.r0;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import n9.i;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.h;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: LazyGridItemProviderImpl.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyGridItemProviderImplKt {
    private static final int ExtraItemsNearTheSlidingWindow = 200;
    private static final int VisibleItemsSlidingWindowSize = 90;

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridItemProviderImplKt$rememberItemProvider$1, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGridItemProviderImpl.kt */
    @f(c = "androidx.compose.foundation.lazy.grid.LazyGridItemProviderImplKt$rememberItemProvider$1", f = "LazyGridItemProviderImpl.kt", l = {53}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ MutableState<i> $nearestItemsRangeState;
        final /* synthetic */ LazyGridState $state;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridItemProviderImplKt$rememberItemProvider$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: LazyGridItemProviderImpl.kt */
        static final class C00561 extends v implements h9.a<i> {
            final /* synthetic */ LazyGridState $state;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00561(LazyGridState lazyGridState) {
                super(0);
                this.$state = lazyGridState;
            }

            @Override // h9.a
            @NotNull
            public final i invoke() {
                return LazyGridItemProviderImplKt.calculateNearestItemsRange(this.$state.getFirstVisibleItemIndex());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LazyGridState lazyGridState, MutableState<i> mutableState, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$state = lazyGridState;
            this.$nearestItemsRangeState = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new AnonymousClass1(this.$state, this.$nearestItemsRangeState, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                h hVarSnapshotFlow = SnapshotStateKt.snapshotFlow(new C00561(this.$state));
                final MutableState<i> mutableState = this.$nearestItemsRangeState;
                s9.i<i> iVar = new s9.i<i>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemProviderImplKt.rememberItemProvider.1.2
                    @Override // s9.i
                    public /* bridge */ /* synthetic */ Object emit(i iVar2, d dVar) {
                        return emit2(iVar2, (d<? super k0>) dVar);
                    }

                    @Nullable
                    /* JADX INFO: renamed from: emit, reason: avoid collision after fix types in other method */
                    public final Object emit2(@NotNull i iVar2, @NotNull d<? super k0> dVar) {
                        mutableState.setValue(iVar2);
                        return k0.f35197a;
                    }
                };
                this.label = 1;
                if (hVarSnapshotFlow.collect(iVar, this) == objE) {
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
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i calculateNearestItemsRange(int i10) {
        int i11 = VisibleItemsSlidingWindowSize;
        int i12 = (i10 / i11) * i11;
        int i13 = ExtraItemsNearTheSlidingWindow;
        return o.u(Math.max(i12 - i13, 0), i12 + i11 + i13);
    }

    @ExperimentalFoundationApi
    @NotNull
    public static final Map<Object, Integer> generateKeyToIndexMap(@NotNull i range, @NotNull IntervalList<LazyGridIntervalContent> list) {
        t.i(range, "range");
        t.i(list, "list");
        int iB = range.b();
        if (!(iB >= 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        int iMin = Math.min(range.e(), list.getSize() - 1);
        if (iMin < iB) {
            return r0.g();
        }
        HashMap map = new HashMap();
        list.forEach(iB, iMin, new LazyGridItemProviderImplKt$generateKeyToIndexMap$1$1(iB, iMin, map));
        return map;
    }

    @Composable
    @ExperimentalFoundationApi
    @NotNull
    public static final LazyGridItemProvider rememberItemProvider(@NotNull LazyGridState state, @NotNull h9.l<? super LazyGridScope, k0> content, @Nullable Composer composer, int i10) {
        t.i(state, "state");
        t.i(content, "content");
        composer.startReplaceableGroup(1895482293);
        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(content, composer, (i10 >> 3) & 14);
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(state);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            Snapshot snapshotCreateNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
            try {
                Snapshot snapshotMakeCurrent = snapshotCreateNonObservableSnapshot.makeCurrent();
                try {
                    i iVarCalculateNearestItemsRange = calculateNearestItemsRange(state.getFirstVisibleItemIndex());
                    snapshotCreateNonObservableSnapshot.dispose();
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(iVarCalculateNearestItemsRange, null, 2, null);
                    composer.updateRememberedValue(objRememberedValue);
                } finally {
                    snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                }
            } catch (Throwable th) {
                snapshotCreateNonObservableSnapshot.dispose();
                throw th;
            }
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) objRememberedValue;
        EffectsKt.LaunchedEffect(mutableState, new AnonymousClass1(state, mutableState, null), composer, 0);
        composer.startReplaceableGroup(1157296644);
        boolean zChanged2 = composer.changed(mutableState);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new LazyGridItemProviderImpl(SnapshotStateKt.derivedStateOf(new LazyGridItemProviderImplKt$rememberItemProvider$2$1(stateRememberUpdatedState, mutableState)));
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        LazyGridItemProviderImpl lazyGridItemProviderImpl = (LazyGridItemProviderImpl) objRememberedValue2;
        composer.endReplaceableGroup();
        return lazyGridItemProviderImpl;
    }
}
