package androidx.compose.foundation.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.exoplayer.RendererCapabilities;
import h9.p;
import h9.q;
import java.util.List;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Box.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BoxKt {

    @NotNull
    private static final MeasurePolicy DefaultBoxMeasurePolicy = boxMeasurePolicy(Alignment.Companion.getTopStart(), false);

    @NotNull
    private static final MeasurePolicy EmptyBoxMeasurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.layout.BoxKt$EmptyBoxMeasurePolicy$1
        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i10) {
            return androidx.compose.ui.layout.d.a(this, intrinsicMeasureScope, list, i10);
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i10) {
            return androidx.compose.ui.layout.d.b(this, intrinsicMeasureScope, list, i10);
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        @NotNull
        /* JADX INFO: renamed from: measure-3p2s80s */
        public final MeasureResult mo8measure3p2s80s(@NotNull MeasureScope MeasurePolicy, @NotNull List<? extends Measurable> list, long j10) {
            t.i(MeasurePolicy, "$this$MeasurePolicy");
            t.i(list, "<anonymous parameter 0>");
            return MeasureScope.CC.p(MeasurePolicy, Constraints.m3643getMinWidthimpl(j10), Constraints.m3642getMinHeightimpl(j10), null, BoxKt$EmptyBoxMeasurePolicy$1$measure$1.INSTANCE, 4, null);
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i10) {
            return androidx.compose.ui.layout.d.c(this, intrinsicMeasureScope, list, i10);
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i10) {
            return androidx.compose.ui.layout.d.d(this, intrinsicMeasureScope, list, i10);
        }
    };

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.BoxKt$Box$3, reason: invalid class name */
    /* JADX INFO: compiled from: Box.kt */
    static final class AnonymousClass3 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ Modifier $modifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Modifier modifier, int i10) {
            super(2);
            this.$modifier = modifier;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            BoxKt.Box(this.$modifier, composer, this.$$changed | 1);
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void Box(@Nullable Modifier modifier, @Nullable Alignment alignment, boolean z10, @NotNull q<? super BoxScope, ? super Composer, ? super Integer, k0> content, @Nullable Composer composer, int i10, int i11) {
        t.i(content, "content");
        composer.startReplaceableGroup(733328855);
        if ((i11 & 1) != 0) {
            modifier = Modifier.Companion;
        }
        if ((i11 & 2) != 0) {
            alignment = Alignment.Companion.getTopStart();
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        int i12 = i10 >> 3;
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = rememberBoxMeasurePolicy(alignment, z10, composer, (i12 & 112) | (i12 & 14));
        composer.startReplaceableGroup(-1323940314);
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        h9.a<ComposeUiNode> constructor = companion.getConstructor();
        q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(modifier);
        int i13 = ((((i10 << 3) & 112) << 9) & 7168) | 6;
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
        Updater.m1265setimpl(composerM1258constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m1265setimpl(composerM1258constructorimpl, density, companion.getSetDensity());
        Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion.getSetLayoutDirection());
        Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
        composer.enableReusing();
        qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composer)), composer, Integer.valueOf((i13 >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        composer.startReplaceableGroup(-2137368960);
        if (((i13 >> 9) & 14 & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            content.invoke(BoxScopeInstance.INSTANCE, composer, Integer.valueOf(((i10 >> 6) & 112) | 6));
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    @NotNull
    public static final MeasurePolicy boxMeasurePolicy(@NotNull final Alignment alignment, final boolean z10) {
        t.i(alignment, "alignment");
        return new MeasurePolicy() { // from class: androidx.compose.foundation.layout.BoxKt.boxMeasurePolicy.1
            @Override // androidx.compose.ui.layout.MeasurePolicy
            public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i10) {
                return androidx.compose.ui.layout.d.a(this, intrinsicMeasureScope, list, i10);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i10) {
                return androidx.compose.ui.layout.d.b(this, intrinsicMeasureScope, list, i10);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            @NotNull
            /* JADX INFO: renamed from: measure-3p2s80s */
            public final MeasureResult mo8measure3p2s80s(@NotNull MeasureScope MeasurePolicy, @NotNull List<? extends Measurable> measurables, long j10) {
                int iM3643getMinWidthimpl;
                Placeable placeableMo2987measureBRTryo0;
                int iMax;
                t.i(MeasurePolicy, "$this$MeasurePolicy");
                t.i(measurables, "measurables");
                if (measurables.isEmpty()) {
                    return MeasureScope.CC.p(MeasurePolicy, Constraints.m3643getMinWidthimpl(j10), Constraints.m3642getMinHeightimpl(j10), null, BoxKt$boxMeasurePolicy$1$measure$1.INSTANCE, 4, null);
                }
                long jM3632copyZbe2FdA$default = z10 ? j10 : Constraints.m3632copyZbe2FdA$default(j10, 0, 0, 0, 0, 10, null);
                if (measurables.size() == 1) {
                    Measurable measurable = measurables.get(0);
                    if (BoxKt.getMatchesParentSize(measurable)) {
                        iM3643getMinWidthimpl = Constraints.m3643getMinWidthimpl(j10);
                        int iM3642getMinHeightimpl = Constraints.m3642getMinHeightimpl(j10);
                        placeableMo2987measureBRTryo0 = measurable.mo2987measureBRTryo0(Constraints.Companion.m3649fixedJhjzzOo(Constraints.m3643getMinWidthimpl(j10), Constraints.m3642getMinHeightimpl(j10)));
                        iMax = iM3642getMinHeightimpl;
                    } else {
                        Placeable placeableMo2987measureBRTryo02 = measurable.mo2987measureBRTryo0(jM3632copyZbe2FdA$default);
                        int iMax2 = Math.max(Constraints.m3643getMinWidthimpl(j10), placeableMo2987measureBRTryo02.getWidth());
                        iMax = Math.max(Constraints.m3642getMinHeightimpl(j10), placeableMo2987measureBRTryo02.getHeight());
                        placeableMo2987measureBRTryo0 = placeableMo2987measureBRTryo02;
                        iM3643getMinWidthimpl = iMax2;
                    }
                    return MeasureScope.CC.p(MeasurePolicy, iM3643getMinWidthimpl, iMax, null, new BoxKt$boxMeasurePolicy$1$measure$2(placeableMo2987measureBRTryo0, measurable, MeasurePolicy, iM3643getMinWidthimpl, iMax, alignment), 4, null);
                }
                Placeable[] placeableArr = new Placeable[measurables.size()];
                l0 l0Var = new l0();
                l0Var.f29831a = Constraints.m3643getMinWidthimpl(j10);
                l0 l0Var2 = new l0();
                l0Var2.f29831a = Constraints.m3642getMinHeightimpl(j10);
                int size = measurables.size();
                boolean z11 = false;
                for (int i10 = 0; i10 < size; i10++) {
                    Measurable measurable2 = measurables.get(i10);
                    if (BoxKt.getMatchesParentSize(measurable2)) {
                        z11 = true;
                    } else {
                        Placeable placeableMo2987measureBRTryo03 = measurable2.mo2987measureBRTryo0(jM3632copyZbe2FdA$default);
                        placeableArr[i10] = placeableMo2987measureBRTryo03;
                        l0Var.f29831a = Math.max(l0Var.f29831a, placeableMo2987measureBRTryo03.getWidth());
                        l0Var2.f29831a = Math.max(l0Var2.f29831a, placeableMo2987measureBRTryo03.getHeight());
                    }
                }
                if (z11) {
                    int i11 = l0Var.f29831a;
                    int i12 = i11 != Integer.MAX_VALUE ? i11 : 0;
                    int i13 = l0Var2.f29831a;
                    long jConstraints = ConstraintsKt.Constraints(i12, i11, i13 != Integer.MAX_VALUE ? i13 : 0, i13);
                    int size2 = measurables.size();
                    for (int i14 = 0; i14 < size2; i14++) {
                        Measurable measurable3 = measurables.get(i14);
                        if (BoxKt.getMatchesParentSize(measurable3)) {
                            placeableArr[i14] = measurable3.mo2987measureBRTryo0(jConstraints);
                        }
                    }
                }
                return MeasureScope.CC.p(MeasurePolicy, l0Var.f29831a, l0Var2.f29831a, null, new BoxKt$boxMeasurePolicy$1$measure$5(placeableArr, measurables, MeasurePolicy, l0Var, l0Var2, alignment), 4, null);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i10) {
                return androidx.compose.ui.layout.d.c(this, intrinsicMeasureScope, list, i10);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i10) {
                return androidx.compose.ui.layout.d.d(this, intrinsicMeasureScope, list, i10);
            }
        };
    }

    private static final BoxChildData getBoxChildData(Measurable measurable) {
        Object parentData = measurable.getParentData();
        if (parentData instanceof BoxChildData) {
            return (BoxChildData) parentData;
        }
        return null;
    }

    @NotNull
    public static final MeasurePolicy getDefaultBoxMeasurePolicy() {
        return DefaultBoxMeasurePolicy;
    }

    @NotNull
    public static final MeasurePolicy getEmptyBoxMeasurePolicy() {
        return EmptyBoxMeasurePolicy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getMatchesParentSize(Measurable measurable) {
        BoxChildData boxChildData = getBoxChildData(measurable);
        if (boxChildData != null) {
            return boxChildData.getMatchParentSize();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeInBox(Placeable.PlacementScope placementScope, Placeable placeable, Measurable measurable, LayoutDirection layoutDirection, int i10, int i11, Alignment alignment) {
        Alignment alignment2;
        BoxChildData boxChildData = getBoxChildData(measurable);
        Placeable.PlacementScope.m3017place70tqf50$default(placementScope, placeable, ((boxChildData == null || (alignment2 = boxChildData.getAlignment()) == null) ? alignment : alignment2).mo1275alignKFBX0sM(IntSizeKt.IntSize(placeable.getWidth(), placeable.getHeight()), IntSizeKt.IntSize(i10, i11), layoutDirection), 0.0f, 2, null);
    }

    @Composable
    @NotNull
    public static final MeasurePolicy rememberBoxMeasurePolicy(@NotNull Alignment alignment, boolean z10, @Nullable Composer composer, int i10) {
        MeasurePolicy measurePolicy;
        t.i(alignment, "alignment");
        composer.startReplaceableGroup(56522820);
        if (!t.d(alignment, Alignment.Companion.getTopStart()) || z10) {
            Boolean boolValueOf = Boolean.valueOf(z10);
            composer.startReplaceableGroup(511388516);
            boolean zChanged = composer.changed(boolValueOf) | composer.changed(alignment);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = boxMeasurePolicy(alignment, z10);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            measurePolicy = (MeasurePolicy) objRememberedValue;
        } else {
            measurePolicy = DefaultBoxMeasurePolicy;
        }
        composer.endReplaceableGroup();
        return measurePolicy;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Box(@NotNull Modifier modifier, @Nullable Composer composer, int i10) {
        int i11;
        t.i(modifier, "modifier");
        Composer composerStartRestartGroup = composer.startRestartGroup(-211209833);
        if ((i10 & 14) == 0) {
            i11 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i11 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            MeasurePolicy measurePolicy = EmptyBoxMeasurePolicy;
            int i12 = ((i11 << 3) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK;
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            h9.a<ComposeUiNode> constructor = companion.getConstructor();
            q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(modifier);
            int i13 = ((i12 << 9) & 7168) | 6;
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM1258constructorimpl = Updater.m1258constructorimpl(composerStartRestartGroup);
            Updater.m1265setimpl(composerM1258constructorimpl, measurePolicy, companion.getSetMeasurePolicy());
            Updater.m1265setimpl(composerM1258constructorimpl, density, companion.getSetDensity());
            Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion.getSetLayoutDirection());
            Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, Integer.valueOf((i13 >> 3) & 112));
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(1021196736);
            if (((i13 >> 9) & 14 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.skipToGroupEnd();
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(modifier, i10));
    }
}
