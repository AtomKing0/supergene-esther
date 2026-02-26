package androidx.compose.material;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import h9.a;
import h9.l;
import h9.p;
import h9.q;
import java.util.Map;
import java.util.Set;
import kotlin.collections.r0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.s;
import v8.y;

/* JADX INFO: compiled from: SwipeToDismiss.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SwipeToDismissKt {

    /* JADX INFO: renamed from: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$1, reason: invalid class name */
    /* JADX INFO: compiled from: SwipeToDismiss.kt */
    static final class AnonymousClass1 extends v implements l<DismissDirection, FractionalThreshold> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        public final FractionalThreshold invoke(@NotNull DismissDirection it) {
            t.i(it, "it");
            return new FractionalThreshold(0.5f);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2, reason: invalid class name */
    /* JADX INFO: compiled from: SwipeToDismiss.kt */
    static final class AnonymousClass2 extends v implements q<BoxWithConstraintsScope, Composer, Integer, k0> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ q<RowScope, Composer, Integer, k0> $background;
        final /* synthetic */ Set<DismissDirection> $directions;
        final /* synthetic */ q<RowScope, Composer, Integer, k0> $dismissContent;
        final /* synthetic */ l<DismissDirection, ThresholdConfig> $dismissThresholds;
        final /* synthetic */ DismissState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Set<? extends DismissDirection> set, l<? super DismissDirection, ? extends ThresholdConfig> lVar, int i10, DismissState dismissState, q<? super RowScope, ? super Composer, ? super Integer, k0> qVar, q<? super RowScope, ? super Composer, ? super Integer, k0> qVar2) {
            super(3);
            this.$directions = set;
            this.$dismissThresholds = lVar;
            this.$$dirty = i10;
            this.$state = dismissState;
            this.$background = qVar;
            this.$dismissContent = qVar2;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, Integer num) {
            invoke(boxWithConstraintsScope, composer, num.intValue());
            return k0.f35197a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(@NotNull BoxWithConstraintsScope BoxWithConstraints, @Nullable Composer composer, int i10) {
            int i11;
            t.i(BoxWithConstraints, "$this$BoxWithConstraints");
            if ((i10 & 14) == 0) {
                i11 = i10 | (composer.changed(BoxWithConstraints) ? 4 : 2);
            } else {
                i11 = i10;
            }
            if ((i11 & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            float fM3641getMaxWidthimpl = Constraints.m3641getMaxWidthimpl(BoxWithConstraints.mo371getConstraintsmsEJaDk());
            boolean z10 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl;
            Float fValueOf = Float.valueOf(0.0f);
            DismissValue dismissValue = DismissValue.Default;
            Map mapL = r0.l(y.a(fValueOf, dismissValue));
            Set<DismissDirection> set = this.$directions;
            DismissDirection dismissDirection = DismissDirection.StartToEnd;
            if (set.contains(dismissDirection)) {
                s sVarA = y.a(Float.valueOf(fM3641getMaxWidthimpl), DismissValue.DismissedToEnd);
                mapL.put(sVarA.c(), sVarA.d());
            }
            Set<DismissDirection> set2 = this.$directions;
            DismissDirection dismissDirection2 = DismissDirection.EndToStart;
            if (set2.contains(dismissDirection2)) {
                s sVarA2 = y.a(Float.valueOf(-fM3641getMaxWidthimpl), DismissValue.DismissedToStart);
                mapL.put(sVarA2.c(), sVarA2.d());
            }
            l<DismissDirection, ThresholdConfig> lVar = this.$dismissThresholds;
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(lVar);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1(lVar);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            p pVar = (p) objRememberedValue;
            float f10 = this.$directions.contains(dismissDirection2) ? 10.0f : 20.0f;
            float f11 = this.$directions.contains(dismissDirection) ? 10.0f : 20.0f;
            Modifier.Companion companion = Modifier.Companion;
            Modifier modifierM1157swipeablepPrIpRY = SwipeableKt.m1157swipeablepPrIpRY(companion, this.$state, mapL, Orientation.Horizontal, (288 & 8) != 0 ? true : this.$state.getCurrentValue() == dismissValue, (288 & 16) != 0 ? false : z10, (288 & 32) != 0 ? null : null, (288 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : pVar, (288 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapL.keySet(), 0.0f, 0.0f, 6, null) : new ResistanceConfig(fM3641getMaxWidthimpl, f10, f11), (288 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1156getVelocityThresholdD9Ej5fM() : 0.0f);
            q<RowScope, Composer, Integer, k0> qVar = this.$background;
            int i12 = this.$$dirty;
            DismissState dismissState = this.$state;
            q<RowScope, Composer, Integer, k0> qVar2 = this.$dismissContent;
            composer.startReplaceableGroup(733328855);
            Alignment.Companion companion2 = Alignment.Companion;
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composer, 0);
            composer.startReplaceableGroup(-1323940314);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            a<ComposeUiNode> constructor = companion3.getConstructor();
            q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(modifierM1157swipeablepPrIpRY);
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
            Updater.m1265setimpl(composerM1258constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1265setimpl(composerM1258constructorimpl, density, companion3.getSetDensity());
            Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion3.getSetLayoutDirection());
            Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion3.getSetViewConfiguration());
            composer.enableReusing();
            qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            composer.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composer.startReplaceableGroup(981834387);
            Modifier modifierMatchParentSize = boxScopeInstance.matchParentSize(companion);
            int i13 = (i12 >> 3) & 7168;
            composer.startReplaceableGroup(693286680);
            Arrangement arrangement = Arrangement.INSTANCE;
            int i14 = i13 >> 3;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer, (i14 & 14) | (i14 & 112));
            composer.startReplaceableGroup(-1323940314);
            Density density2 = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            a<ComposeUiNode> constructor2 = companion3.getConstructor();
            q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf2 = LayoutKt.materializerOf(modifierMatchParentSize);
            int i15 = ((((i13 << 3) & 112) << 9) & 7168) | 6;
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer composerM1258constructorimpl2 = Updater.m1258constructorimpl(composer);
            Updater.m1265setimpl(composerM1258constructorimpl2, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1265setimpl(composerM1258constructorimpl2, density2, companion3.getSetDensity());
            Updater.m1265setimpl(composerM1258constructorimpl2, layoutDirection2, companion3.getSetLayoutDirection());
            Updater.m1265setimpl(composerM1258constructorimpl2, viewConfiguration2, companion3.getSetViewConfiguration());
            composer.enableReusing();
            qVarMaterializerOf2.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composer)), composer, Integer.valueOf((i15 >> 3) & 112));
            composer.startReplaceableGroup(2058660585);
            composer.startReplaceableGroup(-678309503);
            if (((i15 >> 9) & 14 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                qVar.invoke(RowScopeInstance.INSTANCE, composer, Integer.valueOf(((i13 >> 6) & 112) | 6));
            }
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.startReplaceableGroup(1157296644);
            boolean zChanged2 = composer.changed(dismissState);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new SwipeToDismissKt$SwipeToDismiss$2$1$1$1(dismissState);
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceableGroup();
            Modifier modifierOffset = OffsetKt.offset(companion, (l) objRememberedValue2);
            int i16 = (i12 >> 6) & 7168;
            composer.startReplaceableGroup(693286680);
            int i17 = i16 >> 3;
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer, (i17 & 112) | (i17 & 14));
            composer.startReplaceableGroup(-1323940314);
            Density density3 = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            a<ComposeUiNode> constructor3 = companion3.getConstructor();
            q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf3 = LayoutKt.materializerOf(modifierOffset);
            int i18 = ((((i16 << 3) & 112) << 9) & 7168) | 6;
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor3);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer composerM1258constructorimpl3 = Updater.m1258constructorimpl(composer);
            Updater.m1265setimpl(composerM1258constructorimpl3, measurePolicyRowMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m1265setimpl(composerM1258constructorimpl3, density3, companion3.getSetDensity());
            Updater.m1265setimpl(composerM1258constructorimpl3, layoutDirection3, companion3.getSetLayoutDirection());
            Updater.m1265setimpl(composerM1258constructorimpl3, viewConfiguration3, companion3.getSetViewConfiguration());
            composer.enableReusing();
            qVarMaterializerOf3.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composer)), composer, Integer.valueOf((i18 >> 3) & 112));
            composer.startReplaceableGroup(2058660585);
            composer.startReplaceableGroup(-678309503);
            if (((i18 >> 9) & 14 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                qVar2.invoke(RowScopeInstance.INSTANCE, composer, Integer.valueOf(((i16 >> 6) & 112) | 6));
            }
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$3, reason: invalid class name */
    /* JADX INFO: compiled from: SwipeToDismiss.kt */
    static final class AnonymousClass3 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ q<RowScope, Composer, Integer, k0> $background;
        final /* synthetic */ Set<DismissDirection> $directions;
        final /* synthetic */ q<RowScope, Composer, Integer, k0> $dismissContent;
        final /* synthetic */ l<DismissDirection, ThresholdConfig> $dismissThresholds;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ DismissState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(DismissState dismissState, Modifier modifier, Set<? extends DismissDirection> set, l<? super DismissDirection, ? extends ThresholdConfig> lVar, q<? super RowScope, ? super Composer, ? super Integer, k0> qVar, q<? super RowScope, ? super Composer, ? super Integer, k0> qVar2, int i10, int i11) {
            super(2);
            this.$state = dismissState;
            this.$modifier = modifier;
            this.$directions = set;
            this.$dismissThresholds = lVar;
            this.$background = qVar;
            this.$dismissContent = qVar2;
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
            SwipeToDismissKt.SwipeToDismiss(this.$state, this.$modifier, this.$directions, this.$dismissThresholds, this.$background, this.$dismissContent, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeToDismissKt$rememberDismissState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SwipeToDismiss.kt */
    static final class C09461 extends v implements l<DismissValue, Boolean> {
        public static final C09461 INSTANCE = new C09461();

        C09461() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        public final Boolean invoke(@NotNull DismissValue it) {
            t.i(it, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeToDismissKt$rememberDismissState$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SwipeToDismiss.kt */
    static final class C09472 extends v implements a<DismissState> {
        final /* synthetic */ l<DismissValue, Boolean> $confirmStateChange;
        final /* synthetic */ DismissValue $initialValue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09472(DismissValue dismissValue, l<? super DismissValue, Boolean> lVar) {
            super(0);
            this.$initialValue = dismissValue;
            this.$confirmStateChange = lVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final DismissState invoke() {
            return new DismissState(this.$initialValue, this.$confirmStateChange);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void SwipeToDismiss(@org.jetbrains.annotations.NotNull androidx.compose.material.DismissState r21, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r22, @org.jetbrains.annotations.Nullable java.util.Set<? extends androidx.compose.material.DismissDirection> r23, @org.jetbrains.annotations.Nullable h9.l<? super androidx.compose.material.DismissDirection, ? extends androidx.compose.material.ThresholdConfig> r24, @org.jetbrains.annotations.NotNull h9.q<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r25, @org.jetbrains.annotations.NotNull h9.q<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r26, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r27, int r28, int r29) {
        /*
            Method dump skipped, instruction units count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeToDismissKt.SwipeToDismiss(androidx.compose.material.DismissState, androidx.compose.ui.Modifier, java.util.Set, h9.l, h9.q, h9.q, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DismissDirection getDismissDirection(DismissValue dismissValue, DismissValue dismissValue2) {
        if (dismissValue == dismissValue2 && dismissValue == DismissValue.Default) {
            return null;
        }
        if (dismissValue == dismissValue2 && dismissValue == DismissValue.DismissedToEnd) {
            return DismissDirection.StartToEnd;
        }
        if (dismissValue == dismissValue2 && dismissValue == DismissValue.DismissedToStart) {
            return DismissDirection.EndToStart;
        }
        DismissValue dismissValue3 = DismissValue.Default;
        if (dismissValue == dismissValue3 && dismissValue2 == DismissValue.DismissedToEnd) {
            return DismissDirection.StartToEnd;
        }
        if (dismissValue == dismissValue3 && dismissValue2 == DismissValue.DismissedToStart) {
            return DismissDirection.EndToStart;
        }
        if (dismissValue == DismissValue.DismissedToEnd && dismissValue2 == dismissValue3) {
            return DismissDirection.StartToEnd;
        }
        if (dismissValue == DismissValue.DismissedToStart && dismissValue2 == dismissValue3) {
            return DismissDirection.EndToStart;
        }
        return null;
    }

    @Composable
    @ExperimentalMaterialApi
    @NotNull
    public static final DismissState rememberDismissState(@Nullable DismissValue dismissValue, @Nullable l<? super DismissValue, Boolean> lVar, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(-1753522702);
        if ((i11 & 1) != 0) {
            dismissValue = DismissValue.Default;
        }
        if ((i11 & 2) != 0) {
            lVar = C09461.INSTANCE;
        }
        DismissState dismissState = (DismissState) RememberSaveableKt.m1271rememberSaveable(new Object[0], (Saver) DismissState.Companion.Saver(lVar), (String) null, (a) new C09472(dismissValue, lVar), composer, 72, 4);
        composer.endReplaceableGroup();
        return dismissState;
    }
}
