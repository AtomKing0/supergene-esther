package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.UiComposable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.MeasureBlocks;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.JvmActuals_jvmKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.exoplayer.RendererCapabilities;
import h9.p;
import h9.q;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Layout.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutKt {

    /* JADX INFO: renamed from: androidx.compose.ui.layout.LayoutKt$Layout$3, reason: invalid class name */
    /* JADX INFO: compiled from: Layout.kt */
    static final class AnonymousClass3 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ p<Composer, Integer, k0> $content;
        final /* synthetic */ q<IntrinsicMeasureScope, List<? extends IntrinsicMeasurable>, Integer, Integer> $maxIntrinsicHeightMeasureBlock;
        final /* synthetic */ q<IntrinsicMeasureScope, List<? extends IntrinsicMeasurable>, Integer, Integer> $maxIntrinsicWidthMeasureBlock;
        final /* synthetic */ q<MeasureScope, List<? extends Measurable>, Constraints, MeasureResult> $measureBlock;
        final /* synthetic */ q<IntrinsicMeasureScope, List<? extends IntrinsicMeasurable>, Integer, Integer> $minIntrinsicHeightMeasureBlock;
        final /* synthetic */ q<IntrinsicMeasureScope, List<? extends IntrinsicMeasurable>, Integer, Integer> $minIntrinsicWidthMeasureBlock;
        final /* synthetic */ Modifier $modifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(p<? super Composer, ? super Integer, k0> pVar, q<? super IntrinsicMeasureScope, ? super List<? extends IntrinsicMeasurable>, ? super Integer, Integer> qVar, q<? super IntrinsicMeasureScope, ? super List<? extends IntrinsicMeasurable>, ? super Integer, Integer> qVar2, q<? super IntrinsicMeasureScope, ? super List<? extends IntrinsicMeasurable>, ? super Integer, Integer> qVar3, q<? super IntrinsicMeasureScope, ? super List<? extends IntrinsicMeasurable>, ? super Integer, Integer> qVar4, Modifier modifier, q<? super MeasureScope, ? super List<? extends Measurable>, ? super Constraints, ? extends MeasureResult> qVar5, int i10, int i11) {
            super(2);
            this.$content = pVar;
            this.$minIntrinsicWidthMeasureBlock = qVar;
            this.$minIntrinsicHeightMeasureBlock = qVar2;
            this.$maxIntrinsicWidthMeasureBlock = qVar3;
            this.$maxIntrinsicHeightMeasureBlock = qVar4;
            this.$modifier = modifier;
            this.$measureBlock = qVar5;
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
            LayoutKt.Layout(this.$content, this.$minIntrinsicWidthMeasureBlock, this.$minIntrinsicHeightMeasureBlock, this.$maxIntrinsicWidthMeasureBlock, this.$maxIntrinsicHeightMeasureBlock, this.$modifier, this.$measureBlock, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.layout.LayoutKt$MultiMeasureLayout$2, reason: invalid class name */
    /* JADX INFO: compiled from: Layout.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ p<Composer, Integer, k0> $content;
        final /* synthetic */ MeasurePolicy $measurePolicy;
        final /* synthetic */ Modifier $modifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Modifier modifier, p<? super Composer, ? super Integer, k0> pVar, MeasurePolicy measurePolicy, int i10, int i11) {
            super(2);
            this.$modifier = modifier;
            this.$content = pVar;
            this.$measurePolicy = measurePolicy;
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
            LayoutKt.MultiMeasureLayout(this.$modifier, this.$content, this.$measurePolicy, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.layout.LayoutKt$materializerOf$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Layout.kt */
    static final class C09961 extends v implements q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> {
        final /* synthetic */ Modifier $modifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09961(Modifier modifier) {
            super(3);
            this.$modifier = modifier;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(SkippableUpdater<ComposeUiNode> skippableUpdater, Composer composer, Integer num) {
            m2995invokeDeg8D_g(skippableUpdater.m1255unboximpl(), composer, num.intValue());
            return k0.f35197a;
        }

        @Composable
        /* JADX INFO: renamed from: invoke-Deg8D_g, reason: not valid java name */
        public final void m2995invokeDeg8D_g(@NotNull Composer composer, @Nullable Composer composer2, int i10) {
            t.i(composer, "$this$null");
            Modifier modifierMaterialize = ComposedModifierKt.materialize(composer2, this.$modifier);
            composer.startReplaceableGroup(509942095);
            Updater.m1265setimpl(Updater.m1258constructorimpl(composer), modifierMaterialize, ComposeUiNode.Companion.getSetModifier());
            composer.endReplaceableGroup();
        }
    }

    @Composable
    @UiComposable
    public static final void Layout(@NotNull p<? super Composer, ? super Integer, k0> content, @Nullable Modifier modifier, @NotNull MeasurePolicy measurePolicy, @Nullable Composer composer, int i10, int i11) {
        t.i(content, "content");
        t.i(measurePolicy, "measurePolicy");
        composer.startReplaceableGroup(-1323940314);
        if ((i11 & 2) != 0) {
            modifier = Modifier.Companion;
        }
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        h9.a<ComposeUiNode> constructor = companion.getConstructor();
        q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = materializerOf(modifier);
        int i12 = ((i10 << 9) & 7168) | 6;
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer composerM1258constructorimpl = Updater.m1258constructorimpl(composer);
        Updater.m1265setimpl(composerM1258constructorimpl, measurePolicy, companion.getSetMeasurePolicy());
        Updater.m1265setimpl(composerM1258constructorimpl, density, companion.getSetDensity());
        Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion.getSetLayoutDirection());
        Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
        composer.enableReusing();
        qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composer)), composer, Integer.valueOf((i12 >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        content.mo4invoke(composer, Integer.valueOf((i12 >> 9) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
    }

    @NotNull
    public static final MeasureBlocks MeasuringIntrinsicsMeasureBlocks(@NotNull final q<? super MeasureScope, ? super List<? extends Measurable>, ? super Constraints, ? extends MeasureResult> measureBlock) {
        t.i(measureBlock, "measureBlock");
        return new MeasureBlocks() { // from class: androidx.compose.ui.layout.LayoutKt.MeasuringIntrinsicsMeasureBlocks.1
            @Override // androidx.compose.ui.node.MeasureBlocks
            public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
                t.i(intrinsicMeasureScope, "intrinsicMeasureScope");
                t.i(measurables, "measurables");
                return LayoutKt.MeasuringMaxIntrinsicHeight(intrinsicMeasureScope, measureBlock, measurables, i10, intrinsicMeasureScope.getLayoutDirection());
            }

            @Override // androidx.compose.ui.node.MeasureBlocks
            public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
                t.i(intrinsicMeasureScope, "intrinsicMeasureScope");
                t.i(measurables, "measurables");
                return LayoutKt.MeasuringMaxIntrinsicWidth(intrinsicMeasureScope, measureBlock, measurables, i10, intrinsicMeasureScope.getLayoutDirection());
            }

            @Override // androidx.compose.ui.node.MeasureBlocks
            @NotNull
            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
            public MeasureResult mo2994measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> measurables, long j10) {
                t.i(measureScope, "measureScope");
                t.i(measurables, "measurables");
                return measureBlock.invoke(measureScope, measurables, Constraints.m3629boximpl(j10));
            }

            @Override // androidx.compose.ui.node.MeasureBlocks
            public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
                t.i(intrinsicMeasureScope, "intrinsicMeasureScope");
                t.i(measurables, "measurables");
                return LayoutKt.MeasuringMinIntrinsicHeight(intrinsicMeasureScope, measureBlock, measurables, i10, intrinsicMeasureScope.getLayoutDirection());
            }

            @Override // androidx.compose.ui.node.MeasureBlocks
            public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
                t.i(intrinsicMeasureScope, "intrinsicMeasureScope");
                t.i(measurables, "measurables");
                return LayoutKt.MeasuringMinIntrinsicWidth(intrinsicMeasureScope, measureBlock, measurables, i10, intrinsicMeasureScope.getLayoutDirection());
            }

            @NotNull
            public String toString() {
                return JvmActuals_jvmKt.simpleIdentityToString(this, "MeasuringIntrinsicsMeasureBlocks") + "{ measureBlock=" + JvmActuals_jvmKt.simpleIdentityToString(measureBlock, null) + " }";
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int MeasuringMaxIntrinsicHeight(Density density, q<? super MeasureScope, ? super List<? extends Measurable>, ? super Constraints, ? extends MeasureResult> qVar, List<? extends IntrinsicMeasurable> list, int i10, LayoutDirection layoutDirection) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.add(new DefaultIntrinsicMeasurable(list.get(i11), IntrinsicMinMax.Max, IntrinsicWidthHeight.Height));
        }
        return qVar.invoke(new IntrinsicsMeasureScope(density, layoutDirection), arrayList, Constraints.m3629boximpl(ConstraintsKt.Constraints$default(0, i10, 0, 0, 13, null))).getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int MeasuringMaxIntrinsicWidth(Density density, q<? super MeasureScope, ? super List<? extends Measurable>, ? super Constraints, ? extends MeasureResult> qVar, List<? extends IntrinsicMeasurable> list, int i10, LayoutDirection layoutDirection) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.add(new DefaultIntrinsicMeasurable(list.get(i11), IntrinsicMinMax.Max, IntrinsicWidthHeight.Width));
        }
        return qVar.invoke(new IntrinsicsMeasureScope(density, layoutDirection), arrayList, Constraints.m3629boximpl(ConstraintsKt.Constraints$default(0, 0, 0, i10, 7, null))).getWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int MeasuringMinIntrinsicHeight(Density density, q<? super MeasureScope, ? super List<? extends Measurable>, ? super Constraints, ? extends MeasureResult> qVar, List<? extends IntrinsicMeasurable> list, int i10, LayoutDirection layoutDirection) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.add(new DefaultIntrinsicMeasurable(list.get(i11), IntrinsicMinMax.Min, IntrinsicWidthHeight.Height));
        }
        return qVar.invoke(new IntrinsicsMeasureScope(density, layoutDirection), arrayList, Constraints.m3629boximpl(ConstraintsKt.Constraints$default(0, i10, 0, 0, 13, null))).getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int MeasuringMinIntrinsicWidth(Density density, q<? super MeasureScope, ? super List<? extends Measurable>, ? super Constraints, ? extends MeasureResult> qVar, List<? extends IntrinsicMeasurable> list, int i10, LayoutDirection layoutDirection) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.add(new DefaultIntrinsicMeasurable(list.get(i11), IntrinsicMinMax.Min, IntrinsicWidthHeight.Width));
        }
        return qVar.invoke(new IntrinsicsMeasureScope(density, layoutDirection), arrayList, Constraints.m3629boximpl(ConstraintsKt.Constraints$default(0, 0, 0, i10, 7, null))).getWidth();
    }

    @Composable
    @UiComposable
    public static final void MultiMeasureLayout(@Nullable Modifier modifier, @NotNull p<? super Composer, ? super Integer, k0> content, @NotNull MeasurePolicy measurePolicy, @Nullable Composer composer, int i10, int i11) {
        int i12;
        t.i(content, "content");
        t.i(measurePolicy, "measurePolicy");
        Composer composerStartRestartGroup = composer.startRestartGroup(1949933075);
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
            i12 |= composerStartRestartGroup.changed(content) ? 32 : 16;
        }
        if ((i11 & 4) != 0) {
            i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i10 & 896) == 0) {
            i12 |= composerStartRestartGroup.changed(measurePolicy) ? 256 : 128;
        }
        if ((i12 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i13 != 0) {
                modifier = Modifier.Companion;
            }
            Modifier modifierMaterialize = ComposedModifierKt.materialize(composerStartRestartGroup, modifier);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            h9.a<LayoutNode> constructor$ui_release = LayoutNode.Companion.getConstructor$ui_release();
            int i14 = ((i12 << 3) & 896) | 6;
            composerStartRestartGroup.startReplaceableGroup(-692256719);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor$ui_release);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM1258constructorimpl = Updater.m1258constructorimpl(composerStartRestartGroup);
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Updater.m1265setimpl(composerM1258constructorimpl, modifierMaterialize, companion.getSetModifier());
            Updater.m1265setimpl(composerM1258constructorimpl, measurePolicy, companion.getSetMeasurePolicy());
            Updater.m1265setimpl(composerM1258constructorimpl, density, companion.getSetDensity());
            Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion.getSetLayoutDirection());
            Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
            Updater.m1262initimpl(composerM1258constructorimpl, LayoutKt$MultiMeasureLayout$1$1.INSTANCE);
            composerStartRestartGroup.enableReusing();
            content.mo4invoke(composerStartRestartGroup, Integer.valueOf((i14 >> 6) & 14));
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
        }
        Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(modifier2, content, measurePolicy, i10, i11));
    }

    @NotNull
    public static final q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> materializerOf(@NotNull Modifier modifier) {
        t.i(modifier, "modifier");
        return ComposableLambdaKt.composableLambdaInstance(-1586257396, true, new C09961(modifier));
    }

    @NotNull
    public static final MeasureBlocks measureBlocksOf(@NotNull final q<? super IntrinsicMeasureScope, ? super List<? extends IntrinsicMeasurable>, ? super Integer, Integer> minIntrinsicWidthMeasureBlock, @NotNull final q<? super IntrinsicMeasureScope, ? super List<? extends IntrinsicMeasurable>, ? super Integer, Integer> minIntrinsicHeightMeasureBlock, @NotNull final q<? super IntrinsicMeasureScope, ? super List<? extends IntrinsicMeasurable>, ? super Integer, Integer> maxIntrinsicWidthMeasureBlock, @NotNull final q<? super IntrinsicMeasureScope, ? super List<? extends IntrinsicMeasurable>, ? super Integer, Integer> maxIntrinsicHeightMeasureBlock, @NotNull final q<? super MeasureScope, ? super List<? extends Measurable>, ? super Constraints, ? extends MeasureResult> measureBlock) {
        t.i(minIntrinsicWidthMeasureBlock, "minIntrinsicWidthMeasureBlock");
        t.i(minIntrinsicHeightMeasureBlock, "minIntrinsicHeightMeasureBlock");
        t.i(maxIntrinsicWidthMeasureBlock, "maxIntrinsicWidthMeasureBlock");
        t.i(maxIntrinsicHeightMeasureBlock, "maxIntrinsicHeightMeasureBlock");
        t.i(measureBlock, "measureBlock");
        return new MeasureBlocks() { // from class: androidx.compose.ui.layout.LayoutKt.measureBlocksOf.1
            @Override // androidx.compose.ui.node.MeasureBlocks
            public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
                t.i(intrinsicMeasureScope, "intrinsicMeasureScope");
                t.i(measurables, "measurables");
                return maxIntrinsicHeightMeasureBlock.invoke(intrinsicMeasureScope, measurables, Integer.valueOf(i10)).intValue();
            }

            @Override // androidx.compose.ui.node.MeasureBlocks
            public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
                t.i(intrinsicMeasureScope, "intrinsicMeasureScope");
                t.i(measurables, "measurables");
                return maxIntrinsicWidthMeasureBlock.invoke(intrinsicMeasureScope, measurables, Integer.valueOf(i10)).intValue();
            }

            @Override // androidx.compose.ui.node.MeasureBlocks
            @NotNull
            /* JADX INFO: renamed from: measure-3p2s80s */
            public MeasureResult mo2994measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> measurables, long j10) {
                t.i(measureScope, "measureScope");
                t.i(measurables, "measurables");
                return measureBlock.invoke(measureScope, measurables, Constraints.m3629boximpl(j10));
            }

            @Override // androidx.compose.ui.node.MeasureBlocks
            public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
                t.i(intrinsicMeasureScope, "intrinsicMeasureScope");
                t.i(measurables, "measurables");
                return minIntrinsicHeightMeasureBlock.invoke(intrinsicMeasureScope, measurables, Integer.valueOf(i10)).intValue();
            }

            @Override // androidx.compose.ui.node.MeasureBlocks
            public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
                t.i(intrinsicMeasureScope, "intrinsicMeasureScope");
                t.i(measurables, "measurables");
                return minIntrinsicWidthMeasureBlock.invoke(intrinsicMeasureScope, measurables, Integer.valueOf(i10)).intValue();
            }
        };
    }

    @Composable
    @UiComposable
    public static final void Layout(@Nullable Modifier modifier, @NotNull MeasurePolicy measurePolicy, @Nullable Composer composer, int i10, int i11) {
        t.i(measurePolicy, "measurePolicy");
        composer.startReplaceableGroup(544976794);
        if ((i11 & 1) != 0) {
            modifier = Modifier.Companion;
        }
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        Modifier modifierMaterialize = ComposedModifierKt.materialize(composer, modifier);
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        h9.a<ComposeUiNode> constructor = companion.getConstructor();
        composer.startReplaceableGroup(1405779621);
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(new LayoutKt$Layout$$inlined$ReusableComposeNode$1(constructor));
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer composerM1258constructorimpl = Updater.m1258constructorimpl(composer);
        Updater.m1265setimpl(composerM1258constructorimpl, measurePolicy, companion.getSetMeasurePolicy());
        Updater.m1265setimpl(composerM1258constructorimpl, density, companion.getSetDensity());
        Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion.getSetLayoutDirection());
        Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
        Updater.m1265setimpl(composerM1258constructorimpl, modifierMaterialize, companion.getSetModifier());
        composer.enableReusing();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.UiComposable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Layout(@org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r16, @org.jetbrains.annotations.NotNull final h9.q<? super androidx.compose.ui.layout.IntrinsicMeasureScope, ? super java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable>, ? super java.lang.Integer, java.lang.Integer> r17, @org.jetbrains.annotations.NotNull final h9.q<? super androidx.compose.ui.layout.IntrinsicMeasureScope, ? super java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable>, ? super java.lang.Integer, java.lang.Integer> r18, @org.jetbrains.annotations.NotNull final h9.q<? super androidx.compose.ui.layout.IntrinsicMeasureScope, ? super java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable>, ? super java.lang.Integer, java.lang.Integer> r19, @org.jetbrains.annotations.NotNull final h9.q<? super androidx.compose.ui.layout.IntrinsicMeasureScope, ? super java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable>, ? super java.lang.Integer, java.lang.Integer> r20, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r21, @org.jetbrains.annotations.NotNull final h9.q<? super androidx.compose.ui.layout.MeasureScope, ? super java.util.List<? extends androidx.compose.ui.layout.Measurable>, ? super androidx.compose.ui.unit.Constraints, ? extends androidx.compose.ui.layout.MeasureResult> r22, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r23, int r24, int r25) {
        /*
            Method dump skipped, instruction units count: 475
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.LayoutKt.Layout(h9.p, h9.q, h9.q, h9.q, h9.q, androidx.compose.ui.Modifier, h9.q, androidx.compose.runtime.Composer, int, int):void");
    }
}
