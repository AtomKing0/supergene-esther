package androidx.compose.material.internal;

import android.view.View;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.d;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.media3.exoplayer.RendererCapabilities;
import h9.a;
import h9.l;
import h9.p;
import h9.q;
import j9.c;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ExposedDropdownMenuPopup.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ExposedDropdownMenuPopupKt {

    @NotNull
    private static final ProvidableCompositionLocal<String> LocalPopupTestTag = CompositionLocalKt.compositionLocalOf$default(null, ExposedDropdownMenuPopupKt$LocalPopupTestTag$1.INSTANCE, 1, null);

    /* JADX INFO: renamed from: androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$1, reason: invalid class name */
    /* JADX INFO: compiled from: ExposedDropdownMenuPopup.kt */
    static final class AnonymousClass1 extends v implements l<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ LayoutDirection $layoutDirection;
        final /* synthetic */ a<k0> $onDismissRequest;
        final /* synthetic */ PopupLayout $popupLayout;
        final /* synthetic */ String $testTag;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PopupLayout popupLayout, a<k0> aVar, String str, LayoutDirection layoutDirection) {
            super(1);
            this.$popupLayout = popupLayout;
            this.$onDismissRequest = aVar;
            this.$testTag = str;
            this.$layoutDirection = layoutDirection;
        }

        @Override // h9.l
        @NotNull
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
            t.i(DisposableEffect, "$this$DisposableEffect");
            this.$popupLayout.show();
            this.$popupLayout.updateParameters(this.$onDismissRequest, this.$testTag, this.$layoutDirection);
            final PopupLayout popupLayout = this.$popupLayout;
            return new DisposableEffectResult() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$1$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    popupLayout.disposeComposition();
                    popupLayout.dismiss();
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$2, reason: invalid class name */
    /* JADX INFO: compiled from: ExposedDropdownMenuPopup.kt */
    static final class AnonymousClass2 extends v implements a<k0> {
        final /* synthetic */ LayoutDirection $layoutDirection;
        final /* synthetic */ a<k0> $onDismissRequest;
        final /* synthetic */ PopupLayout $popupLayout;
        final /* synthetic */ String $testTag;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PopupLayout popupLayout, a<k0> aVar, String str, LayoutDirection layoutDirection) {
            super(0);
            this.$popupLayout = popupLayout;
            this.$onDismissRequest = aVar;
            this.$testTag = str;
            this.$layoutDirection = layoutDirection;
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            invoke2();
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$popupLayout.updateParameters(this.$onDismissRequest, this.$testTag, this.$layoutDirection);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$3, reason: invalid class name */
    /* JADX INFO: compiled from: ExposedDropdownMenuPopup.kt */
    static final class AnonymousClass3 extends v implements l<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ PopupLayout $popupLayout;
        final /* synthetic */ PopupPositionProvider $popupPositionProvider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(PopupLayout popupLayout, PopupPositionProvider popupPositionProvider) {
            super(1);
            this.$popupLayout = popupLayout;
            this.$popupPositionProvider = popupPositionProvider;
        }

        @Override // h9.l
        @NotNull
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
            t.i(DisposableEffect, "$this$DisposableEffect");
            this.$popupLayout.setPositionProvider(this.$popupPositionProvider);
            this.$popupLayout.updatePosition();
            return new DisposableEffectResult() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$3$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$5, reason: invalid class name */
    /* JADX INFO: compiled from: ExposedDropdownMenuPopup.kt */
    static final class AnonymousClass5 extends v implements l<LayoutCoordinates, k0> {
        final /* synthetic */ PopupLayout $popupLayout;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(PopupLayout popupLayout) {
            super(1);
            this.$popupLayout = popupLayout;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(LayoutCoordinates layoutCoordinates) {
            invoke2(layoutCoordinates);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull LayoutCoordinates childCoordinates) {
            t.i(childCoordinates, "childCoordinates");
            LayoutCoordinates parentLayoutCoordinates = childCoordinates.getParentLayoutCoordinates();
            t.f(parentLayoutCoordinates);
            long jMo2989getSizeYbymL2g = parentLayoutCoordinates.mo2989getSizeYbymL2g();
            long jPositionInWindow = LayoutCoordinatesKt.positionInWindow(parentLayoutCoordinates);
            this.$popupLayout.setParentBounds(IntRectKt.m3823IntRectVbeCjmY(IntOffsetKt.IntOffset(c.c(Offset.m1367getXimpl(jPositionInWindow)), c.c(Offset.m1368getYimpl(jPositionInWindow))), jMo2989getSizeYbymL2g));
            this.$popupLayout.updatePosition();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$7, reason: invalid class name */
    /* JADX INFO: compiled from: ExposedDropdownMenuPopup.kt */
    static final class AnonymousClass7 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ p<Composer, Integer, k0> $content;
        final /* synthetic */ a<k0> $onDismissRequest;
        final /* synthetic */ PopupPositionProvider $popupPositionProvider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass7(a<k0> aVar, PopupPositionProvider popupPositionProvider, p<? super Composer, ? super Integer, k0> pVar, int i10, int i11) {
            super(2);
            this.$onDismissRequest = aVar;
            this.$popupPositionProvider = popupPositionProvider;
            this.$content = pVar;
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
            ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup(this.$onDismissRequest, this.$popupPositionProvider, this.$content, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.internal.ExposedDropdownMenuPopupKt$SimpleStack$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ExposedDropdownMenuPopup.kt */
    public static final class C09601 implements MeasurePolicy {
        public static final C09601 INSTANCE = new C09601();

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i10) {
            return d.a(this, intrinsicMeasureScope, list, i10);
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i10) {
            return d.b(this, intrinsicMeasureScope, list, i10);
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        @NotNull
        /* JADX INFO: renamed from: measure-3p2s80s */
        public final MeasureResult mo8measure3p2s80s(@NotNull MeasureScope Layout, @NotNull List<? extends Measurable> measurables, long j10) {
            int i10;
            int i11;
            t.i(Layout, "$this$Layout");
            t.i(measurables, "measurables");
            int size = measurables.size();
            if (size == 0) {
                return MeasureScope.CC.p(Layout, 0, 0, null, ExposedDropdownMenuPopupKt$SimpleStack$1$measure$1.INSTANCE, 4, null);
            }
            int i12 = 0;
            if (size == 1) {
                Placeable placeableMo2987measureBRTryo0 = measurables.get(0).mo2987measureBRTryo0(j10);
                return MeasureScope.CC.p(Layout, placeableMo2987measureBRTryo0.getWidth(), placeableMo2987measureBRTryo0.getHeight(), null, new ExposedDropdownMenuPopupKt$SimpleStack$1$measure$2(placeableMo2987measureBRTryo0), 4, null);
            }
            ArrayList arrayList = new ArrayList(measurables.size());
            int size2 = measurables.size();
            for (int i13 = 0; i13 < size2; i13++) {
                arrayList.add(measurables.get(i13).mo2987measureBRTryo0(j10));
            }
            int iM = kotlin.collections.v.m(arrayList);
            if (iM >= 0) {
                int iMax = 0;
                int iMax2 = 0;
                while (true) {
                    Placeable placeable = (Placeable) arrayList.get(i12);
                    iMax = Math.max(iMax, placeable.getWidth());
                    iMax2 = Math.max(iMax2, placeable.getHeight());
                    if (i12 == iM) {
                        break;
                    }
                    i12++;
                }
                i10 = iMax;
                i11 = iMax2;
            } else {
                i10 = 0;
                i11 = 0;
            }
            return MeasureScope.CC.p(Layout, i10, i11, null, new ExposedDropdownMenuPopupKt$SimpleStack$1$measure$3(arrayList), 4, null);
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i10) {
            return d.c(this, intrinsicMeasureScope, list, i10);
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i10) {
            return d.d(this, intrinsicMeasureScope, list, i10);
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void ExposedDropdownMenuPopup(@Nullable a<k0> aVar, @NotNull PopupPositionProvider popupPositionProvider, @NotNull p<? super Composer, ? super Integer, k0> content, @Nullable Composer composer, int i10, int i11) {
        a<k0> aVar2;
        int i12;
        final LayoutDirection layoutDirection;
        String str;
        a<k0> aVar3;
        int i13;
        Composer composer2;
        Object obj;
        Composer composer3;
        t.i(popupPositionProvider, "popupPositionProvider");
        t.i(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-841446797);
        int i14 = i11 & 1;
        if (i14 != 0) {
            i12 = i10 | 6;
            aVar2 = aVar;
        } else if ((i10 & 14) == 0) {
            aVar2 = aVar;
            i12 = (composerStartRestartGroup.changed(aVar2) ? 4 : 2) | i10;
        } else {
            aVar2 = aVar;
            i12 = i10;
        }
        if ((i11 & 2) != 0) {
            i12 |= 48;
        } else if ((i10 & 112) == 0) {
            i12 |= composerStartRestartGroup.changed(popupPositionProvider) ? 32 : 16;
        }
        if ((i11 & 4) != 0) {
            i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i10 & 896) == 0) {
            i12 |= composerStartRestartGroup.changed(content) ? 256 : 128;
        }
        int i15 = i12;
        if ((i15 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer3 = composerStartRestartGroup;
        } else {
            a<k0> aVar4 = i14 != 0 ? null : aVar2;
            View view = (View) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            String str2 = (String) composerStartRestartGroup.consume(LocalPopupTestTag);
            LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            CompositionContext compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(content, composerStartRestartGroup, (i15 >> 6) & 14);
            UUID popupId = (UUID) RememberSaveableKt.m1271rememberSaveable(new Object[0], (Saver) null, (String) null, (a) ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupId$1.INSTANCE, composerStartRestartGroup, 3080, 6);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                t.h(popupId, "popupId");
                layoutDirection = layoutDirection2;
                str = str2;
                aVar3 = aVar4;
                i13 = i15;
                Composer composer4 = composerStartRestartGroup;
                PopupLayout popupLayout = new PopupLayout(aVar4, str2, view, density, popupPositionProvider, popupId);
                popupLayout.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(144472904, true, new ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$popupLayout$1$1$1(popupLayout, stateRememberUpdatedState)));
                composer4.updateRememberedValue(popupLayout);
                obj = popupLayout;
                composer2 = composer4;
            } else {
                layoutDirection = layoutDirection2;
                str = str2;
                aVar3 = aVar4;
                i13 = i15;
                composer2 = composerStartRestartGroup;
                obj = objRememberedValue;
            }
            composer2.endReplaceableGroup();
            final PopupLayout popupLayout2 = (PopupLayout) obj;
            EffectsKt.DisposableEffect(popupLayout2, new AnonymousClass1(popupLayout2, aVar3, str, layoutDirection), composer2, 8);
            EffectsKt.SideEffect(new AnonymousClass2(popupLayout2, aVar3, str, layoutDirection), composer2, 0);
            EffectsKt.DisposableEffect(popupPositionProvider, new AnonymousClass3(popupLayout2, popupPositionProvider), composer2, (i13 >> 3) & 14);
            Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.Companion, new AnonymousClass5(popupLayout2));
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopupKt.ExposedDropdownMenuPopup.6
                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i16) {
                    return d.a(this, intrinsicMeasureScope, list, i16);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i16) {
                    return d.b(this, intrinsicMeasureScope, list, i16);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                @NotNull
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo8measure3p2s80s(@NotNull MeasureScope Layout, @NotNull List<? extends Measurable> list, long j10) {
                    t.i(Layout, "$this$Layout");
                    t.i(list, "<anonymous parameter 0>");
                    popupLayout2.setParentLayoutDirection(layoutDirection);
                    return MeasureScope.CC.p(Layout, 0, 0, null, ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$6$measure$1.INSTANCE, 4, null);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i16) {
                    return d.c(this, intrinsicMeasureScope, list, i16);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i16) {
                    return d.d(this, intrinsicMeasureScope, list, i16);
                }
            };
            composer2.startReplaceableGroup(-1323940314);
            Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            a<ComposeUiNode> constructor = companion.getConstructor();
            q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(modifierOnGloballyPositioned);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            composer2.disableReusing();
            Composer composerM1258constructorimpl = Updater.m1258constructorimpl(composer2);
            Updater.m1265setimpl(composerM1258constructorimpl, measurePolicy, companion.getSetMeasurePolicy());
            Updater.m1265setimpl(composerM1258constructorimpl, density2, companion.getSetDensity());
            Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection3, companion.getSetLayoutDirection());
            Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
            composer2.enableReusing();
            qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-261830998);
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            aVar2 = aVar3;
            composer3 = composer2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(aVar2, popupPositionProvider, content, i10, i11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ExposedDropdownMenuPopup$lambda-0, reason: not valid java name */
    public static final p<Composer, Integer, k0> m1222ExposedDropdownMenuPopup$lambda0(State<? extends p<? super Composer, ? super Integer, k0>> state) {
        return (p) state.getValue();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    private static final void SimpleStack(Modifier modifier, p<? super Composer, ? super Integer, k0> pVar, Composer composer, int i10) {
        composer.startReplaceableGroup(1769324208);
        C09601 c09601 = C09601.INSTANCE;
        int i11 = ((i10 << 3) & 112) | ((i10 >> 3) & 14);
        composer.startReplaceableGroup(-1323940314);
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        a<ComposeUiNode> constructor = companion.getConstructor();
        q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(modifier);
        int i12 = ((i11 << 9) & 7168) | 6;
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
        Updater.m1265setimpl(composerM1258constructorimpl, c09601, companion.getSetMeasurePolicy());
        Updater.m1265setimpl(composerM1258constructorimpl, density, companion.getSetDensity());
        Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion.getSetLayoutDirection());
        Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
        composer.enableReusing();
        qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composer)), composer, Integer.valueOf((i12 >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        pVar.mo4invoke(composer, Integer.valueOf((i12 >> 9) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    @NotNull
    public static final ProvidableCompositionLocal<String> getLocalPopupTestTag() {
        return LocalPopupTestTag;
    }
}
