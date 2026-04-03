package androidx.compose.material;

import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.d;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import h9.a;
import h9.p;
import h9.q;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.d0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Snackbar.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SnackbarKt {
    private static final float HorizontalSpacingButtonSide;
    private static final float TextEndExtraSpacing;
    private static final float HeightToFirstLine = Dp.m3673constructorimpl(30);
    private static final float HorizontalSpacing = Dp.m3673constructorimpl(16);
    private static final float SeparateButtonExtraY = Dp.m3673constructorimpl(2);
    private static final float SnackbarVerticalPadding = Dp.m3673constructorimpl(6);
    private static final float LongButtonVerticalOffset = Dp.m3673constructorimpl(12);
    private static final float SnackbarMinHeightOneLine = Dp.m3673constructorimpl(48);
    private static final float SnackbarMinHeightTwoLines = Dp.m3673constructorimpl(68);

    /* JADX INFO: renamed from: androidx.compose.material.SnackbarKt$NewLineButtonSnackbar$2, reason: invalid class name */
    /* JADX INFO: compiled from: Snackbar.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ p<Composer, Integer, k0> $action;
        final /* synthetic */ p<Composer, Integer, k0> $text;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(p<? super Composer, ? super Integer, k0> pVar, p<? super Composer, ? super Integer, k0> pVar2, int i10) {
            super(2);
            this.$text = pVar;
            this.$action = pVar2;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            SnackbarKt.NewLineButtonSnackbar(this.$text, this.$action, composer, this.$$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SnackbarKt$OneRowSnackbar$3, reason: invalid class name */
    /* JADX INFO: compiled from: Snackbar.kt */
    static final class AnonymousClass3 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ p<Composer, Integer, k0> $action;
        final /* synthetic */ p<Composer, Integer, k0> $text;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(p<? super Composer, ? super Integer, k0> pVar, p<? super Composer, ? super Integer, k0> pVar2, int i10) {
            super(2);
            this.$text = pVar;
            this.$action = pVar2;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            SnackbarKt.OneRowSnackbar(this.$text, this.$action, composer, this.$$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SnackbarKt$TextOnlySnackbar$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Snackbar.kt */
    static final class C09453 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ p<Composer, Integer, k0> $content;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09453(p<? super Composer, ? super Integer, k0> pVar, int i10) {
            super(2);
            this.$content = pVar;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            SnackbarKt.TextOnlySnackbar(this.$content, composer, this.$$changed | 1);
        }
    }

    static {
        float f10 = 8;
        HorizontalSpacingButtonSide = Dp.m3673constructorimpl(f10);
        TextEndExtraSpacing = Dp.m3673constructorimpl(f10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void NewLineButtonSnackbar(p<? super Composer, ? super Integer, k0> pVar, p<? super Composer, ? super Integer, k0> pVar2, Composer composer, int i10) {
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1229075900);
        if ((i10 & 14) == 0) {
            i11 = (composerStartRestartGroup.changed(pVar) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 112) == 0) {
            i11 |= composerStartRestartGroup.changed(pVar2) ? 32 : 16;
        }
        if ((i11 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            Modifier.Companion companion = Modifier.Companion;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            float f10 = HorizontalSpacing;
            float f11 = HorizontalSpacingButtonSide;
            Modifier modifierM403paddingqDBjuR0$default = PaddingKt.m403paddingqDBjuR0$default(modifierFillMaxWidth$default, f10, 0.0f, f11, SeparateButtonExtraY, 2, null);
            composerStartRestartGroup.startReplaceableGroup(-483455358);
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
            Alignment.Companion companion2 = Alignment.Companion;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            a<ComposeUiNode> constructor = companion3.getConstructor();
            q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(modifierM403paddingqDBjuR0$default);
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
            Updater.m1265setimpl(composerM1258constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1265setimpl(composerM1258constructorimpl, density, companion3.getSetDensity());
            Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion3.getSetLayoutDirection());
            Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion3.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-1163856341);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-1214415430);
            Modifier modifierM403paddingqDBjuR0$default2 = PaddingKt.m403paddingqDBjuR0$default(AlignmentLineKt.m329paddingFromBaselineVpY3zN4(companion, HeightToFirstLine, LongButtonVerticalOffset), 0.0f, 0.0f, f11, 0.0f, 11, null);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            a<ComposeUiNode> constructor2 = companion3.getConstructor();
            q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf2 = LayoutKt.materializerOf(modifierM403paddingqDBjuR0$default2);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM1258constructorimpl2 = Updater.m1258constructorimpl(composerStartRestartGroup);
            Updater.m1265setimpl(composerM1258constructorimpl2, measurePolicyRememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1265setimpl(composerM1258constructorimpl2, density2, companion3.getSetDensity());
            Updater.m1265setimpl(composerM1258constructorimpl2, layoutDirection2, companion3.getSetLayoutDirection());
            Updater.m1265setimpl(composerM1258constructorimpl2, viewConfiguration2, companion3.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            qVarMaterializerOf2.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(1193033152);
            pVar.mo4invoke(composerStartRestartGroup, Integer.valueOf(i11 & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierAlign = columnScopeInstance.align(companion, companion2.getEnd());
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            a<ComposeUiNode> constructor3 = companion3.getConstructor();
            q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf3 = LayoutKt.materializerOf(modifierAlign);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM1258constructorimpl3 = Updater.m1258constructorimpl(composerStartRestartGroup);
            Updater.m1265setimpl(composerM1258constructorimpl3, measurePolicyRememberBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m1265setimpl(composerM1258constructorimpl3, density3, companion3.getSetDensity());
            Updater.m1265setimpl(composerM1258constructorimpl3, layoutDirection3, companion3.getSetLayoutDirection());
            Updater.m1265setimpl(composerM1258constructorimpl3, viewConfiguration3, companion3.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            qVarMaterializerOf3.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            composerStartRestartGroup.startReplaceableGroup(-2100387721);
            pVar2.mo4invoke(composerStartRestartGroup, Integer.valueOf((i11 >> 3) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(pVar, pVar2, i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void OneRowSnackbar(p<? super Composer, ? super Integer, k0> pVar, p<? super Composer, ? super Integer, k0> pVar2, Composer composer, int i10) {
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(-534813202);
        if ((i10 & 14) == 0) {
            i11 = (composerStartRestartGroup.changed(pVar) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 112) == 0) {
            i11 |= composerStartRestartGroup.changed(pVar2) ? 32 : 16;
        }
        if ((i11 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            Modifier.Companion companion = Modifier.Companion;
            Modifier modifierM403paddingqDBjuR0$default = PaddingKt.m403paddingqDBjuR0$default(companion, HorizontalSpacing, 0.0f, HorizontalSpacingButtonSide, 0.0f, 10, null);
            final String str = "action";
            final String str2 = "text";
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material.SnackbarKt.OneRowSnackbar.2
                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i12) {
                    return d.a(this, intrinsicMeasureScope, list, i12);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i12) {
                    return d.b(this, intrinsicMeasureScope, list, i12);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                @NotNull
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo8measure3p2s80s(@NotNull MeasureScope Layout, @NotNull List<? extends Measurable> measurables, long j10) {
                    int i12;
                    int height;
                    int iMax;
                    t.i(Layout, "$this$Layout");
                    t.i(measurables, "measurables");
                    List<? extends Measurable> list = measurables;
                    String str3 = str;
                    for (Measurable measurable : list) {
                        if (t.d(LayoutIdKt.getLayoutId(measurable), str3)) {
                            Placeable placeableMo2987measureBRTryo0 = measurable.mo2987measureBRTryo0(j10);
                            int iE = o.e((Constraints.m3641getMaxWidthimpl(j10) - placeableMo2987measureBRTryo0.getWidth()) - Layout.mo290roundToPx0680j_4(SnackbarKt.TextEndExtraSpacing), Constraints.m3643getMinWidthimpl(j10));
                            String str4 = str2;
                            for (Measurable measurable2 : list) {
                                if (t.d(LayoutIdKt.getLayoutId(measurable2), str4)) {
                                    Placeable placeableMo2987measureBRTryo02 = measurable2.mo2987measureBRTryo0(Constraints.m3632copyZbe2FdA$default(j10, 0, iE, 0, 0, 9, null));
                                    int i13 = placeableMo2987measureBRTryo02.get(androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline());
                                    if (!(i13 != Integer.MIN_VALUE)) {
                                        throw new IllegalArgumentException("No baselines for text".toString());
                                    }
                                    int i14 = placeableMo2987measureBRTryo02.get(androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline());
                                    if (!(i14 != Integer.MIN_VALUE)) {
                                        throw new IllegalArgumentException("No baselines for text".toString());
                                    }
                                    boolean z10 = i13 == i14;
                                    int iM3641getMaxWidthimpl = Constraints.m3641getMaxWidthimpl(j10) - placeableMo2987measureBRTryo0.getWidth();
                                    if (z10) {
                                        iMax = Math.max(Layout.mo290roundToPx0680j_4(SnackbarKt.SnackbarMinHeightOneLine), placeableMo2987measureBRTryo0.getHeight());
                                        int height2 = (iMax - placeableMo2987measureBRTryo02.getHeight()) / 2;
                                        int i15 = placeableMo2987measureBRTryo0.get(androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline());
                                        height = i15 != Integer.MIN_VALUE ? (i13 + height2) - i15 : 0;
                                        i12 = height2;
                                    } else {
                                        int iMo290roundToPx0680j_4 = Layout.mo290roundToPx0680j_4(SnackbarKt.HeightToFirstLine) - i13;
                                        int iMax2 = Math.max(Layout.mo290roundToPx0680j_4(SnackbarKt.SnackbarMinHeightTwoLines), placeableMo2987measureBRTryo02.getHeight() + iMo290roundToPx0680j_4);
                                        i12 = iMo290roundToPx0680j_4;
                                        height = (iMax2 - placeableMo2987measureBRTryo0.getHeight()) / 2;
                                        iMax = iMax2;
                                    }
                                    return MeasureScope.CC.p(Layout, Constraints.m3641getMaxWidthimpl(j10), iMax, null, new SnackbarKt$OneRowSnackbar$2$measure$4(placeableMo2987measureBRTryo02, i12, placeableMo2987measureBRTryo0, iM3641getMaxWidthimpl, height), 4, null);
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i12) {
                    return d.c(this, intrinsicMeasureScope, list, i12);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i12) {
                    return d.d(this, intrinsicMeasureScope, list, i12);
                }
            };
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            a<ComposeUiNode> constructor = companion2.getConstructor();
            q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(modifierM403paddingqDBjuR0$default);
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
            Updater.m1265setimpl(composerM1258constructorimpl, measurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1265setimpl(composerM1258constructorimpl, density, companion2.getSetDensity());
            Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
            Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-643033641);
            Modifier modifierM401paddingVpY3zN4$default = PaddingKt.m401paddingVpY3zN4$default(LayoutIdKt.layoutId(companion, "text"), 0.0f, SnackbarVerticalPadding, 1, null);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            Alignment.Companion companion3 = Alignment.Companion;
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            a<ComposeUiNode> constructor2 = companion2.getConstructor();
            q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf2 = LayoutKt.materializerOf(modifierM401paddingVpY3zN4$default);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM1258constructorimpl2 = Updater.m1258constructorimpl(composerStartRestartGroup);
            Updater.m1265setimpl(composerM1258constructorimpl2, measurePolicyRememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1265setimpl(composerM1258constructorimpl2, density2, companion2.getSetDensity());
            Updater.m1265setimpl(composerM1258constructorimpl2, layoutDirection2, companion2.getSetLayoutDirection());
            Updater.m1265setimpl(composerM1258constructorimpl2, viewConfiguration2, companion2.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            qVarMaterializerOf2.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(1616738193);
            pVar.mo4invoke(composerStartRestartGroup, Integer.valueOf(i11 & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierLayoutId = LayoutIdKt.layoutId(companion, "action");
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            a<ComposeUiNode> constructor3 = companion2.getConstructor();
            q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf3 = LayoutKt.materializerOf(modifierLayoutId);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM1258constructorimpl3 = Updater.m1258constructorimpl(composerStartRestartGroup);
            Updater.m1265setimpl(composerM1258constructorimpl3, measurePolicyRememberBoxMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m1265setimpl(composerM1258constructorimpl3, density3, companion2.getSetDensity());
            Updater.m1265setimpl(composerM1258constructorimpl3, layoutDirection3, companion2.getSetLayoutDirection());
            Updater.m1265setimpl(composerM1258constructorimpl3, viewConfiguration3, companion2.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            qVarMaterializerOf3.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            composerStartRestartGroup.startReplaceableGroup(-1690150342);
            pVar2.mo4invoke(composerStartRestartGroup, Integer.valueOf((i11 >> 3) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(pVar, pVar2, i10));
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0117  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Snackbar-7zSek6w, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1129Snackbar7zSek6w(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r29, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r30, boolean r31, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r32, long r33, long r35, float r37, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r38, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r39, int r40, int r41) {
        /*
            Method dump skipped, instruction units count: 495
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarKt.m1129Snackbar7zSek6w(androidx.compose.ui.Modifier, h9.p, boolean, androidx.compose.ui.graphics.Shape, long, long, float, h9.p, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0114  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* JADX INFO: renamed from: Snackbar-sPrSdHI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1130SnackbarsPrSdHI(@org.jetbrains.annotations.NotNull androidx.compose.material.SnackbarData r29, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r30, boolean r31, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r32, long r33, long r35, long r37, float r39, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r40, int r41, int r42) {
        /*
            Method dump skipped, instruction units count: 575
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarKt.m1130SnackbarsPrSdHI(androidx.compose.material.SnackbarData, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, long, long, long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void TextOnlySnackbar(p<? super Composer, ? super Integer, k0> pVar, Composer composer, int i10) {
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(917397959);
        if ((i10 & 14) == 0) {
            i11 = (composerStartRestartGroup.changed(pVar) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i11 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            C09442 c09442 = new MeasurePolicy() { // from class: androidx.compose.material.SnackbarKt.TextOnlySnackbar.2
                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i12) {
                    return d.a(this, intrinsicMeasureScope, list, i12);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i12) {
                    return d.b(this, intrinsicMeasureScope, list, i12);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                @NotNull
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo8measure3p2s80s(@NotNull MeasureScope Layout, @NotNull List<? extends Measurable> measurables, long j10) {
                    t.i(Layout, "$this$Layout");
                    t.i(measurables, "measurables");
                    if (!(measurables.size() == 1)) {
                        throw new IllegalArgumentException("text for Snackbar expected to have exactly only one child".toString());
                    }
                    Placeable placeableMo2987measureBRTryo0 = ((Measurable) d0.i0(measurables)).mo2987measureBRTryo0(j10);
                    int i12 = placeableMo2987measureBRTryo0.get(androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline());
                    int i13 = placeableMo2987measureBRTryo0.get(androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline());
                    if (!(i12 != Integer.MIN_VALUE)) {
                        throw new IllegalArgumentException("No baselines for text".toString());
                    }
                    if (!(i13 != Integer.MIN_VALUE)) {
                        throw new IllegalArgumentException("No baselines for text".toString());
                    }
                    int iMax = Math.max(Layout.mo290roundToPx0680j_4(i12 == i13 ? SnackbarKt.SnackbarMinHeightOneLine : SnackbarKt.SnackbarMinHeightTwoLines), placeableMo2987measureBRTryo0.getHeight());
                    return MeasureScope.CC.p(Layout, Constraints.m3641getMaxWidthimpl(j10), iMax, null, new SnackbarKt$TextOnlySnackbar$2$measure$4(iMax, placeableMo2987measureBRTryo0), 4, null);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i12) {
                    return d.c(this, intrinsicMeasureScope, list, i12);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i12) {
                    return d.d(this, intrinsicMeasureScope, list, i12);
                }
            };
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Modifier.Companion companion = Modifier.Companion;
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            a<ComposeUiNode> constructor = companion2.getConstructor();
            q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(companion);
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
            Updater.m1265setimpl(composerM1258constructorimpl, c09442, companion2.getSetMeasurePolicy());
            Updater.m1265setimpl(composerM1258constructorimpl, density, companion2.getSetDensity());
            Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
            Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-266728784);
            Modifier modifierM400paddingVpY3zN4 = PaddingKt.m400paddingVpY3zN4(companion, HorizontalSpacing, SnackbarVerticalPadding);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            a<ComposeUiNode> constructor2 = companion2.getConstructor();
            q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf2 = LayoutKt.materializerOf(modifierM400paddingVpY3zN4);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM1258constructorimpl2 = Updater.m1258constructorimpl(composerStartRestartGroup);
            Updater.m1265setimpl(composerM1258constructorimpl2, measurePolicyRememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1265setimpl(composerM1258constructorimpl2, density2, companion2.getSetDensity());
            Updater.m1265setimpl(composerM1258constructorimpl2, layoutDirection2, companion2.getSetLayoutDirection());
            Updater.m1265setimpl(composerM1258constructorimpl2, viewConfiguration2, companion2.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            qVarMaterializerOf2.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(1392363114);
            pVar.mo4invoke(composerStartRestartGroup, Integer.valueOf(i11 & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C09453(pVar, i10));
    }
}
