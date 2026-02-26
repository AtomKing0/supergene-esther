package androidx.compose.material;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import h9.l;
import h9.p;
import h9.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.w;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.h;

/* JADX INFO: compiled from: TabRow.kt */
/* JADX INFO: loaded from: classes.dex */
final class TabRowKt$ScrollableTabRow$2 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ p<Composer, Integer, k0> $divider;
    final /* synthetic */ float $edgePadding;
    final /* synthetic */ q<List<TabPosition>, Composer, Integer, k0> $indicator;
    final /* synthetic */ int $selectedTabIndex;
    final /* synthetic */ p<Composer, Integer, k0> $tabs;

    /* JADX INFO: renamed from: androidx.compose.material.TabRowKt$ScrollableTabRow$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: TabRow.kt */
    static final class AnonymousClass1 extends v implements p<SubcomposeMeasureScope, Constraints, MeasureResult> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ p<Composer, Integer, k0> $divider;
        final /* synthetic */ float $edgePadding;
        final /* synthetic */ q<List<TabPosition>, Composer, Integer, k0> $indicator;
        final /* synthetic */ ScrollableTabData $scrollableTabData;
        final /* synthetic */ int $selectedTabIndex;
        final /* synthetic */ p<Composer, Integer, k0> $tabs;

        /* JADX INFO: renamed from: androidx.compose.material.TabRowKt$ScrollableTabRow$2$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: TabRow.kt */
        static final class AnonymousClass2 extends v implements l<Placeable.PlacementScope, k0> {
            final /* synthetic */ int $$dirty;
            final /* synthetic */ long $constraints;
            final /* synthetic */ p<Composer, Integer, k0> $divider;
            final /* synthetic */ q<List<TabPosition>, Composer, Integer, k0> $indicator;
            final /* synthetic */ l0 $layoutHeight;
            final /* synthetic */ l0 $layoutWidth;
            final /* synthetic */ int $padding;
            final /* synthetic */ ScrollableTabData $scrollableTabData;
            final /* synthetic */ int $selectedTabIndex;
            final /* synthetic */ List<Placeable> $tabPlaceables;
            final /* synthetic */ SubcomposeMeasureScope $this_SubcomposeLayout;

            /* JADX INFO: renamed from: androidx.compose.material.TabRowKt$ScrollableTabRow$2$1$2$3, reason: invalid class name */
            /* JADX INFO: compiled from: TabRow.kt */
            static final class AnonymousClass3 extends v implements p<Composer, Integer, k0> {
                final /* synthetic */ int $$dirty;
                final /* synthetic */ q<List<TabPosition>, Composer, Integer, k0> $indicator;
                final /* synthetic */ List<TabPosition> $tabPositions;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass3(q<? super List<TabPosition>, ? super Composer, ? super Integer, k0> qVar, List<TabPosition> list, int i10) {
                    super(2);
                    this.$indicator = qVar;
                    this.$tabPositions = list;
                    this.$$dirty = i10;
                }

                @Override // h9.p
                /* JADX INFO: renamed from: invoke */
                public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return k0.f35197a;
                }

                @Composable
                public final void invoke(@Nullable Composer composer, int i10) {
                    if ((i10 & 11) == 2 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                    } else {
                        this.$indicator.invoke(this.$tabPositions, composer, Integer.valueOf(((this.$$dirty >> 12) & 112) | 8));
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(int i10, List<? extends Placeable> list, SubcomposeMeasureScope subcomposeMeasureScope, p<? super Composer, ? super Integer, k0> pVar, ScrollableTabData scrollableTabData, int i11, long j10, l0 l0Var, l0 l0Var2, q<? super List<TabPosition>, ? super Composer, ? super Integer, k0> qVar, int i12) {
                super(1);
                this.$padding = i10;
                this.$tabPlaceables = list;
                this.$this_SubcomposeLayout = subcomposeMeasureScope;
                this.$divider = pVar;
                this.$scrollableTabData = scrollableTabData;
                this.$selectedTabIndex = i11;
                this.$constraints = j10;
                this.$layoutWidth = l0Var;
                this.$layoutHeight = l0Var2;
                this.$indicator = qVar;
                this.$$dirty = i12;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Placeable.PlacementScope layout) {
                t.i(layout, "$this$layout");
                ArrayList arrayList = new ArrayList();
                int i10 = this.$padding;
                List<Placeable> list = this.$tabPlaceables;
                SubcomposeMeasureScope subcomposeMeasureScope = this.$this_SubcomposeLayout;
                int width = i10;
                for (Placeable placeable : list) {
                    Placeable.PlacementScope.placeRelative$default(layout, placeable, width, 0, 0.0f, 4, null);
                    arrayList.add(new TabPosition(subcomposeMeasureScope.mo293toDpu2uoSUM(width), subcomposeMeasureScope.mo293toDpu2uoSUM(placeable.getWidth()), null));
                    width += placeable.getWidth();
                }
                List<Measurable> listSubcompose = this.$this_SubcomposeLayout.subcompose(TabSlots.Divider, this.$divider);
                long j10 = this.$constraints;
                l0 l0Var = this.$layoutWidth;
                l0 l0Var2 = this.$layoutHeight;
                for (Measurable measurable : listSubcompose) {
                    int i11 = l0Var.f29831a;
                    Placeable placeableMo2987measureBRTryo0 = measurable.mo2987measureBRTryo0(Constraints.m3632copyZbe2FdA$default(j10, i11, i11, 0, 0, 8, null));
                    Placeable.PlacementScope.placeRelative$default(layout, placeableMo2987measureBRTryo0, 0, l0Var2.f29831a - placeableMo2987measureBRTryo0.getHeight(), 0.0f, 4, null);
                    l0Var = l0Var;
                    l0Var2 = l0Var2;
                    j10 = j10;
                }
                List<Measurable> listSubcompose2 = this.$this_SubcomposeLayout.subcompose(TabSlots.Indicator, ComposableLambdaKt.composableLambdaInstance(230769237, true, new AnonymousClass3(this.$indicator, arrayList, this.$$dirty)));
                l0 l0Var3 = this.$layoutWidth;
                l0 l0Var4 = this.$layoutHeight;
                Iterator<T> it = listSubcompose2.iterator();
                while (it.hasNext()) {
                    Placeable.PlacementScope.placeRelative$default(layout, ((Measurable) it.next()).mo2987measureBRTryo0(Constraints.Companion.m3649fixedJhjzzOo(l0Var3.f29831a, l0Var4.f29831a)), 0, 0, 0.0f, 4, null);
                }
                this.$scrollableTabData.onLaidOut(this.$this_SubcomposeLayout, this.$padding, arrayList, this.$selectedTabIndex);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(float f10, p<? super Composer, ? super Integer, k0> pVar, p<? super Composer, ? super Integer, k0> pVar2, ScrollableTabData scrollableTabData, int i10, q<? super List<TabPosition>, ? super Composer, ? super Integer, k0> qVar, int i11) {
            super(2);
            this.$edgePadding = f10;
            this.$tabs = pVar;
            this.$divider = pVar2;
            this.$scrollableTabData = scrollableTabData;
            this.$selectedTabIndex = i10;
            this.$indicator = qVar;
            this.$$dirty = i11;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ MeasureResult mo4invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
            return m1184invoke0kLqBqw(subcomposeMeasureScope, constraints.m3647unboximpl());
        }

        @NotNull
        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
        public final MeasureResult m1184invoke0kLqBqw(@NotNull SubcomposeMeasureScope SubcomposeLayout, long j10) {
            t.i(SubcomposeLayout, "$this$SubcomposeLayout");
            int iMo290roundToPx0680j_4 = SubcomposeLayout.mo290roundToPx0680j_4(TabRowKt.ScrollableTabRowMinimumTabWidth);
            int iMo290roundToPx0680j_42 = SubcomposeLayout.mo290roundToPx0680j_4(this.$edgePadding);
            long jM3632copyZbe2FdA$default = Constraints.m3632copyZbe2FdA$default(j10, iMo290roundToPx0680j_4, 0, 0, 0, 14, null);
            List<Measurable> listSubcompose = SubcomposeLayout.subcompose(TabSlots.Tabs, this.$tabs);
            ArrayList<Placeable> arrayList = new ArrayList(w.v(listSubcompose, 10));
            Iterator<T> it = listSubcompose.iterator();
            while (it.hasNext()) {
                arrayList.add(((Measurable) it.next()).mo2987measureBRTryo0(jM3632copyZbe2FdA$default));
            }
            l0 l0Var = new l0();
            l0Var.f29831a = iMo290roundToPx0680j_42 * 2;
            l0 l0Var2 = new l0();
            for (Placeable placeable : arrayList) {
                l0Var.f29831a += placeable.getWidth();
                l0Var2.f29831a = Math.max(l0Var2.f29831a, placeable.getHeight());
            }
            return MeasureScope.CC.p(SubcomposeLayout, l0Var.f29831a, l0Var2.f29831a, null, new AnonymousClass2(iMo290roundToPx0680j_42, arrayList, SubcomposeLayout, this.$divider, this.$scrollableTabData, this.$selectedTabIndex, j10, l0Var, l0Var2, this.$indicator, this.$$dirty), 4, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TabRowKt$ScrollableTabRow$2(float f10, p<? super Composer, ? super Integer, k0> pVar, p<? super Composer, ? super Integer, k0> pVar2, int i10, q<? super List<TabPosition>, ? super Composer, ? super Integer, k0> qVar, int i11) {
        super(2);
        this.$edgePadding = f10;
        this.$tabs = pVar;
        this.$divider = pVar2;
        this.$selectedTabIndex = i10;
        this.$indicator = qVar;
        this.$$dirty = i11;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i10) {
        if ((i10 & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        ScrollState scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composer, 0, 1);
        composer.startReplaceableGroup(773894976);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (objRememberedValue == companion.getEmpty()) {
            Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(h.f37608a, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            objRememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        composer.endReplaceableGroup();
        o0 coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(511388516);
        boolean zChanged = composer.changed(scrollStateRememberScrollState) | composer.changed(coroutineScope);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new ScrollableTabData(scrollStateRememberScrollState, coroutineScope);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        SubcomposeLayoutKt.SubcomposeLayout(ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Alignment.Companion.getCenterStart(), false, 2, null), scrollStateRememberScrollState, false, null, false, 14, null))), new AnonymousClass1(this.$edgePadding, this.$tabs, this.$divider, (ScrollableTabData) objRememberedValue2, this.$selectedTabIndex, this.$indicator, this.$$dirty), composer, 0, 0);
    }
}
