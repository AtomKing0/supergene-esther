package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.UiComposable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SubcomposeLayout.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SubcomposeLayoutKt {

    /* JADX INFO: renamed from: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$2, reason: invalid class name */
    /* JADX INFO: compiled from: SubcomposeLayout.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ p<SubcomposeMeasureScope, Constraints, MeasureResult> $measurePolicy;
        final /* synthetic */ Modifier $modifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Modifier modifier, p<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> pVar, int i10, int i11) {
            super(2);
            this.$modifier = modifier;
            this.$measurePolicy = pVar;
            this.$$changed = i10;
            this.$$default = i11;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            SubcomposeLayoutKt.SubcomposeLayout(this.$modifier, this.$measurePolicy, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$4, reason: invalid class name */
    /* JADX INFO: compiled from: SubcomposeLayout.kt */
    static final class AnonymousClass4 extends v implements h9.a<k0> {
        final /* synthetic */ SubcomposeLayoutState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(SubcomposeLayoutState subcomposeLayoutState) {
            super(0);
            this.$state = subcomposeLayoutState;
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            invoke2();
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$state.forceRecomposeChildren$ui_release();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$6, reason: invalid class name */
    /* JADX INFO: compiled from: SubcomposeLayout.kt */
    static final class AnonymousClass6 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ p<SubcomposeMeasureScope, Constraints, MeasureResult> $measurePolicy;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ SubcomposeLayoutState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass6(SubcomposeLayoutState subcomposeLayoutState, Modifier modifier, p<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> pVar, int i10, int i11) {
            super(2);
            this.$state = subcomposeLayoutState;
            this.$modifier = modifier;
            this.$measurePolicy = pVar;
            this.$$changed = i10;
            this.$$default = i11;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            SubcomposeLayoutKt.SubcomposeLayout(this.$state, this.$modifier, this.$measurePolicy, composer, this.$$changed | 1, this.$$default);
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SubcomposeLayout(@Nullable Modifier modifier, @NotNull p<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> measurePolicy, @Nullable Composer composer, int i10, int i11) {
        int i12;
        t.i(measurePolicy, "measurePolicy");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1298353104);
        int i13 = i11 & 1;
        if (i13 != 0) {
            i12 = i10 | 6;
        } else if ((i10 & 14) == 0) {
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i11 & 2) != 0) {
            i12 |= 48;
        } else if ((i10 & 112) == 0) {
            i12 |= composerStartRestartGroup.changed(measurePolicy) ? 32 : 16;
        }
        if ((i12 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i13 != 0) {
                modifier = Modifier.Companion;
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new SubcomposeLayoutState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            int i14 = i12 << 3;
            SubcomposeLayout((SubcomposeLayoutState) objRememberedValue, modifier, measurePolicy, composerStartRestartGroup, (i14 & 112) | 8 | (i14 & 896), 0);
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(modifier, measurePolicy, i10, i11));
    }

    @NotNull
    public static final SubcomposeSlotReusePolicy SubcomposeSlotReusePolicy(int i10) {
        return new FixedCountSubcomposeSlotReusePolicy(i10);
    }

    @Composable
    @UiComposable
    public static final void SubcomposeLayout(@NotNull SubcomposeLayoutState state, @Nullable Modifier modifier, @NotNull p<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> measurePolicy, @Nullable Composer composer, int i10, int i11) {
        t.i(state, "state");
        t.i(measurePolicy, "measurePolicy");
        Composer composerStartRestartGroup = composer.startRestartGroup(-511989831);
        if ((i11 & 2) != 0) {
            modifier = Modifier.Companion;
        }
        Modifier modifier2 = modifier;
        CompositionContext compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
        Modifier modifierMaterialize = ComposedModifierKt.materialize(composerStartRestartGroup, modifier2);
        Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        h9.a<LayoutNode> constructor$ui_release = LayoutNode.Companion.getConstructor$ui_release();
        composerStartRestartGroup.startReplaceableGroup(1886828752);
        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(new SubcomposeLayoutKt$SubcomposeLayout$$inlined$ComposeNode$1(constructor$ui_release));
        } else {
            composerStartRestartGroup.useNode();
        }
        Composer composerM1258constructorimpl = Updater.m1258constructorimpl(composerStartRestartGroup);
        Updater.m1265setimpl(composerM1258constructorimpl, state, state.getSetRoot$ui_release());
        Updater.m1265setimpl(composerM1258constructorimpl, compositionContextRememberCompositionContext, state.getSetCompositionContext$ui_release());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        Updater.m1265setimpl(composerM1258constructorimpl, modifierMaterialize, companion.getSetModifier());
        Updater.m1265setimpl(composerM1258constructorimpl, measurePolicy, state.getSetMeasurePolicy$ui_release());
        Updater.m1265setimpl(composerM1258constructorimpl, density, companion.getSetDensity());
        Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion.getSetLayoutDirection());
        Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.startReplaceableGroup(-607848778);
        if (!composerStartRestartGroup.getSkipping()) {
            EffectsKt.SideEffect(new AnonymousClass4(state), composerStartRestartGroup, 0);
        }
        composerStartRestartGroup.endReplaceableGroup();
        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(state, composerStartRestartGroup, 8);
        k0 k0Var = k0.f35197a;
        composerStartRestartGroup.startReplaceableGroup(1157296644);
        boolean zChanged = composerStartRestartGroup.changed(stateRememberUpdatedState);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new SubcomposeLayoutKt$SubcomposeLayout$5$1(stateRememberUpdatedState);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        EffectsKt.DisposableEffect(k0Var, (h9.l<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue, composerStartRestartGroup, 0);
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass6(state, modifier2, measurePolicy, i10, i11));
    }
}
