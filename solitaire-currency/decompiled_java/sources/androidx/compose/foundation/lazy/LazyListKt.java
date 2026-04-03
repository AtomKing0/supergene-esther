package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import h9.l;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: LazyList.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListKt$LazyList$2, reason: invalid class name */
    /* JADX INFO: compiled from: LazyList.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$changed1;
        final /* synthetic */ int $$default;
        final /* synthetic */ l<LazyListScope, k0> $content;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ FlingBehavior $flingBehavior;
        final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
        final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
        final /* synthetic */ boolean $isVertical;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ boolean $reverseLayout;
        final /* synthetic */ LazyListState $state;
        final /* synthetic */ boolean $userScrollEnabled;
        final /* synthetic */ Alignment.Vertical $verticalAlignment;
        final /* synthetic */ Arrangement.Vertical $verticalArrangement;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z10, boolean z11, FlingBehavior flingBehavior, boolean z12, Alignment.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, Arrangement.Horizontal horizontal2, l<? super LazyListScope, k0> lVar, int i10, int i11, int i12) {
            super(2);
            this.$modifier = modifier;
            this.$state = lazyListState;
            this.$contentPadding = paddingValues;
            this.$reverseLayout = z10;
            this.$isVertical = z11;
            this.$flingBehavior = flingBehavior;
            this.$userScrollEnabled = z12;
            this.$horizontalAlignment = horizontal;
            this.$verticalArrangement = vertical;
            this.$verticalAlignment = vertical2;
            this.$horizontalArrangement = horizontal2;
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
            LazyListKt.LazyList(this.$modifier, this.$state, this.$contentPadding, this.$reverseLayout, this.$isVertical, this.$flingBehavior, this.$userScrollEnabled, this.$horizontalAlignment, this.$verticalArrangement, this.$verticalAlignment, this.$horizontalArrangement, this.$content, composer, this.$$changed | 1, this.$$changed1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListKt$ScrollPositionUpdater$1, reason: invalid class name */
    /* JADX INFO: compiled from: LazyList.kt */
    static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ LazyListItemProvider $itemProvider;
        final /* synthetic */ LazyListState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LazyListItemProvider lazyListItemProvider, LazyListState lazyListState, int i10) {
            super(2);
            this.$itemProvider = lazyListItemProvider;
            this.$state = lazyListState;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            LazyListKt.ScrollPositionUpdater(this.$itemProvider, this.$state, composer, this.$$changed | 1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:174:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012f  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LazyList(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r35, @org.jetbrains.annotations.NotNull androidx.compose.foundation.lazy.LazyListState r36, @org.jetbrains.annotations.NotNull androidx.compose.foundation.layout.PaddingValues r37, boolean r38, boolean r39, @org.jetbrains.annotations.NotNull androidx.compose.foundation.gestures.FlingBehavior r40, boolean r41, @org.jetbrains.annotations.Nullable androidx.compose.ui.Alignment.Horizontal r42, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.Arrangement.Vertical r43, @org.jetbrains.annotations.Nullable androidx.compose.ui.Alignment.Vertical r44, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.Arrangement.Horizontal r45, @org.jetbrains.annotations.NotNull h9.l<? super androidx.compose.foundation.lazy.LazyListScope, v8.k0> r46, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r47, int r48, int r49, int r50) {
        /*
            Method dump skipped, instruction units count: 905
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListKt.LazyList(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, boolean, androidx.compose.foundation.gestures.FlingBehavior, boolean, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, h9.l, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ExperimentalFoundationApi
    public static final void ScrollPositionUpdater(LazyListItemProvider lazyListItemProvider, LazyListState lazyListState, Composer composer, int i10) {
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(3173830);
        if ((i10 & 14) == 0) {
            i11 = (composerStartRestartGroup.changed(lazyListItemProvider) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 112) == 0) {
            i11 |= composerStartRestartGroup.changed(lazyListState) ? 32 : 16;
        }
        if ((i11 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else if (lazyListItemProvider.getItemCount() > 0) {
            lazyListState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyListItemProvider);
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(lazyListItemProvider, lazyListState, i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshOverscrollInfo(OverscrollEffect overscrollEffect, LazyListMeasureResult lazyListMeasureResult) {
        boolean canScrollForward = lazyListMeasureResult.getCanScrollForward();
        LazyMeasuredItem firstVisibleItem = lazyListMeasureResult.getFirstVisibleItem();
        overscrollEffect.setEnabled(canScrollForward || ((firstVisibleItem != null ? firstVisibleItem.getIndex() : 0) != 0 || lazyListMeasureResult.getFirstVisibleItemScrollOffset() != 0));
    }

    @Composable
    @ExperimentalFoundationApi
    private static final p<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyListMeasurePolicy(LazyListItemProvider lazyListItemProvider, LazyListState lazyListState, LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo, OverscrollEffect overscrollEffect, PaddingValues paddingValues, boolean z10, boolean z11, Alignment.Horizontal horizontal, Alignment.Vertical vertical, Arrangement.Horizontal horizontal2, Arrangement.Vertical vertical2, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, Composer composer, int i10, int i11, int i12) {
        composer.startReplaceableGroup(-1404987696);
        Alignment.Horizontal horizontal3 = (i12 & 128) != 0 ? null : horizontal;
        Alignment.Vertical vertical3 = (i12 & 256) != 0 ? null : vertical;
        Arrangement.Horizontal horizontal4 = (i12 & 512) != 0 ? null : horizontal2;
        Arrangement.Vertical vertical4 = (i12 & 1024) != 0 ? null : vertical2;
        Object[] objArr = {lazyListState, lazyListBeyondBoundsInfo, overscrollEffect, paddingValues, Boolean.valueOf(z10), Boolean.valueOf(z11), horizontal3, vertical3, horizontal4, vertical4, lazyListItemPlacementAnimator};
        composer.startReplaceableGroup(-568225417);
        boolean zChanged = false;
        for (int i13 = 0; i13 < 11; i13++) {
            zChanged |= composer.changed(objArr[i13]);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new LazyListKt$rememberLazyListMeasurePolicy$1$1(z11, paddingValues, z10, lazyListState, lazyListItemProvider, vertical4, horizontal4, lazyListItemPlacementAnimator, lazyListBeyondBoundsInfo, horizontal3, vertical3, overscrollEffect);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        p<LazyLayoutMeasureScope, Constraints, MeasureResult> pVar = (p) objRememberedValue;
        composer.endReplaceableGroup();
        return pVar;
    }
}
