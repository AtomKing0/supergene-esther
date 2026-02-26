package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import h9.l;
import h9.p;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: LazyGrid.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyGridKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridKt$LazyGrid$2, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGrid.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$changed1;
        final /* synthetic */ int $$default;
        final /* synthetic */ l<LazyGridScope, k0> $content;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ FlingBehavior $flingBehavior;
        final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
        final /* synthetic */ boolean $isVertical;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ boolean $reverseLayout;
        final /* synthetic */ p<Density, Constraints, List<Integer>> $slotSizesSums;
        final /* synthetic */ LazyGridState $state;
        final /* synthetic */ boolean $userScrollEnabled;
        final /* synthetic */ Arrangement.Vertical $verticalArrangement;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Modifier modifier, LazyGridState lazyGridState, p<? super Density, ? super Constraints, ? extends List<Integer>> pVar, PaddingValues paddingValues, boolean z10, boolean z11, FlingBehavior flingBehavior, boolean z12, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, l<? super LazyGridScope, k0> lVar, int i10, int i11, int i12) {
            super(2);
            this.$modifier = modifier;
            this.$state = lazyGridState;
            this.$slotSizesSums = pVar;
            this.$contentPadding = paddingValues;
            this.$reverseLayout = z10;
            this.$isVertical = z11;
            this.$flingBehavior = flingBehavior;
            this.$userScrollEnabled = z12;
            this.$verticalArrangement = vertical;
            this.$horizontalArrangement = horizontal;
            this.$content = lVar;
            this.$$changed = i10;
            this.$$changed1 = i11;
            this.$$default = i12;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            LazyGridKt.LazyGrid(this.$modifier, this.$state, this.$slotSizesSums, this.$contentPadding, this.$reverseLayout, this.$isVertical, this.$flingBehavior, this.$userScrollEnabled, this.$verticalArrangement, this.$horizontalArrangement, this.$content, composer, this.$$changed | 1, this.$$changed1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridKt$ScrollPositionUpdater$1, reason: invalid class name */
    /* JADX INFO: compiled from: LazyGrid.kt */
    static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ LazyGridItemProvider $itemProvider;
        final /* synthetic */ LazyGridState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LazyGridItemProvider lazyGridItemProvider, LazyGridState lazyGridState, int i10) {
            super(2);
            this.$itemProvider = lazyGridItemProvider;
            this.$state = lazyGridState;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            LazyGridKt.ScrollPositionUpdater(this.$itemProvider, this.$state, composer, this.$$changed | 1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:172:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0133  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LazyGrid(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r33, @org.jetbrains.annotations.NotNull androidx.compose.foundation.lazy.grid.LazyGridState r34, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.ui.unit.Density, ? super androidx.compose.ui.unit.Constraints, ? extends java.util.List<java.lang.Integer>> r35, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.PaddingValues r36, boolean r37, boolean r38, @org.jetbrains.annotations.Nullable androidx.compose.foundation.gestures.FlingBehavior r39, boolean r40, @org.jetbrains.annotations.NotNull androidx.compose.foundation.layout.Arrangement.Vertical r41, @org.jetbrains.annotations.NotNull androidx.compose.foundation.layout.Arrangement.Horizontal r42, @org.jetbrains.annotations.NotNull h9.l<? super androidx.compose.foundation.lazy.grid.LazyGridScope, v8.k0> r43, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r44, int r45, int r46, int r47) {
        /*
            Method dump skipped, instruction units count: 860
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.grid.LazyGridState, h9.p, androidx.compose.foundation.layout.PaddingValues, boolean, boolean, androidx.compose.foundation.gestures.FlingBehavior, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, h9.l, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final void ScrollPositionUpdater(LazyGridItemProvider lazyGridItemProvider, LazyGridState lazyGridState, Composer composer, int i10) {
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(950944068);
        if ((i10 & 14) == 0) {
            i11 = (composerStartRestartGroup.changed(lazyGridItemProvider) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 112) == 0) {
            i11 |= composerStartRestartGroup.changed(lazyGridState) ? 32 : 16;
        }
        if ((i11 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else if (lazyGridItemProvider.getItemCount() > 0) {
            lazyGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyGridItemProvider);
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(lazyGridItemProvider, lazyGridState, i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshOverscrollInfo(OverscrollEffect overscrollEffect, LazyGridMeasureResult lazyGridMeasureResult) {
        Object obj;
        LazyMeasuredItem[] items;
        boolean canScrollForward = lazyGridMeasureResult.getCanScrollForward();
        LazyMeasuredLine firstVisibleLine = lazyGridMeasureResult.getFirstVisibleLine();
        if (firstVisibleLine == null || (items = firstVisibleLine.getItems()) == null || (obj = (LazyMeasuredItem) kotlin.collections.p.O(items)) == null) {
            obj = 0;
        }
        overscrollEffect.setEnabled(canScrollForward || (!t.d(obj, 0) || lazyGridMeasureResult.getFirstVisibleLineScrollOffset() != 0));
    }

    @Composable
    private static final p<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy(LazyGridItemProvider lazyGridItemProvider, LazyGridState lazyGridState, OverscrollEffect overscrollEffect, p<? super Density, ? super Constraints, ? extends List<Integer>> pVar, PaddingValues paddingValues, boolean z10, boolean z11, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(1958911962);
        Arrangement.Horizontal horizontal2 = (i11 & 128) != 0 ? null : horizontal;
        Arrangement.Vertical vertical2 = (i11 & 256) != 0 ? null : vertical;
        Object[] objArr = {lazyGridState, overscrollEffect, pVar, paddingValues, Boolean.valueOf(z10), Boolean.valueOf(z11), horizontal2, vertical2, lazyGridItemPlacementAnimator};
        composer.startReplaceableGroup(-568225417);
        boolean zChanged = false;
        for (int i12 = 0; i12 < 9; i12++) {
            zChanged |= composer.changed(objArr[i12]);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new LazyGridKt$rememberLazyGridMeasurePolicy$1$1(z11, paddingValues, z10, lazyGridState, lazyGridItemProvider, pVar, vertical2, horizontal2, lazyGridItemPlacementAnimator, overscrollEffect);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        p<LazyLayoutMeasureScope, Constraints, MeasureResult> pVar2 = (p) objRememberedValue;
        composer.endReplaceableGroup();
        return pVar2;
    }
}
