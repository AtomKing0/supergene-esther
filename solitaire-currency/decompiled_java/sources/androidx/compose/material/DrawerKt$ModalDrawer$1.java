package androidx.compose.material;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import h9.a;
import h9.l;
import h9.p;
import h9.q;
import java.util.Map;
import kotlin.collections.r0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.y;

/* JADX INFO: compiled from: Drawer.kt */
/* JADX INFO: loaded from: classes.dex */
final class DrawerKt$ModalDrawer$1 extends v implements q<BoxWithConstraintsScope, Composer, Integer, k0> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ p<Composer, Integer, k0> $content;
    final /* synthetic */ long $drawerBackgroundColor;
    final /* synthetic */ q<ColumnScope, Composer, Integer, k0> $drawerContent;
    final /* synthetic */ long $drawerContentColor;
    final /* synthetic */ float $drawerElevation;
    final /* synthetic */ Shape $drawerShape;
    final /* synthetic */ DrawerState $drawerState;
    final /* synthetic */ boolean $gesturesEnabled;
    final /* synthetic */ o0 $scope;
    final /* synthetic */ long $scrimColor;

    /* JADX INFO: renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: Drawer.kt */
    static final class AnonymousClass1 extends v implements p<DrawerValue, DrawerValue, ThresholdConfig> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(2);
        }

        @Override // h9.p
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final ThresholdConfig mo4invoke(@NotNull DrawerValue drawerValue, @NotNull DrawerValue drawerValue2) {
            t.i(drawerValue, "<anonymous parameter 0>");
            t.i(drawerValue2, "<anonymous parameter 1>");
            return new FractionalThreshold(0.5f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DrawerKt$ModalDrawer$1(DrawerState drawerState, boolean z10, int i10, long j10, Shape shape, long j11, long j12, float f10, p<? super Composer, ? super Integer, k0> pVar, o0 o0Var, q<? super ColumnScope, ? super Composer, ? super Integer, k0> qVar) {
        super(3);
        this.$drawerState = drawerState;
        this.$gesturesEnabled = z10;
        this.$$dirty = i10;
        this.$scrimColor = j10;
        this.$drawerShape = shape;
        this.$drawerBackgroundColor = j11;
        this.$drawerContentColor = j12;
        this.$drawerElevation = f10;
        this.$content = pVar;
        this.$scope = o0Var;
        this.$drawerContent = qVar;
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
        long jMo371getConstraintsmsEJaDk = BoxWithConstraints.mo371getConstraintsmsEJaDk();
        if (!Constraints.m3637getHasBoundedWidthimpl(jMo371getConstraintsmsEJaDk)) {
            throw new IllegalStateException("Drawer shouldn't have infinite width");
        }
        float f10 = -Constraints.m3641getMaxWidthimpl(jMo371getConstraintsmsEJaDk);
        Map mapJ = r0.j(y.a(Float.valueOf(f10), DrawerValue.Closed), y.a(Float.valueOf(0.0f), DrawerValue.Open));
        boolean z10 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl;
        Modifier.Companion companion = Modifier.Companion;
        Modifier modifierM1157swipeablepPrIpRY = SwipeableKt.m1157swipeablepPrIpRY(companion, this.$drawerState.getSwipeableState$material_release(), mapJ, Orientation.Horizontal, (288 & 8) != 0 ? true : this.$gesturesEnabled, (288 & 16) != 0 ? false : z10, (288 & 32) != 0 ? null : null, (288 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : AnonymousClass1.INSTANCE, (288 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapJ.keySet(), 0.0f, 0.0f, 6, null) : null, (288 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1156getVelocityThresholdD9Ej5fM() : DrawerKt.DrawerVelocityThreshold);
        DrawerState drawerState = this.$drawerState;
        int i12 = this.$$dirty;
        long j10 = this.$scrimColor;
        Shape shape = this.$drawerShape;
        long j11 = this.$drawerBackgroundColor;
        long j12 = this.$drawerContentColor;
        float f11 = this.$drawerElevation;
        p<Composer, Integer, k0> pVar = this.$content;
        boolean z11 = this.$gesturesEnabled;
        o0 o0Var = this.$scope;
        q<ColumnScope, Composer, Integer, k0> qVar = this.$drawerContent;
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
        composer.startReplaceableGroup(-1263168067);
        composer.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composer, 0);
        composer.startReplaceableGroup(-1323940314);
        Density density2 = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection2 = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        a<ComposeUiNode> constructor2 = companion3.getConstructor();
        q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf2 = LayoutKt.materializerOf(companion);
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
        Updater.m1265setimpl(composerM1258constructorimpl2, measurePolicyRememberBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
        Updater.m1265setimpl(composerM1258constructorimpl2, density2, companion3.getSetDensity());
        Updater.m1265setimpl(composerM1258constructorimpl2, layoutDirection2, companion3.getSetLayoutDirection());
        Updater.m1265setimpl(composerM1258constructorimpl2, viewConfiguration2, companion3.getSetViewConfiguration());
        composer.enableReusing();
        qVarMaterializerOf2.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        composer.startReplaceableGroup(-2137368960);
        composer.startReplaceableGroup(32495683);
        pVar.mo4invoke(composer, Integer.valueOf((i12 >> 27) & 14));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        boolean zIsOpen = drawerState.isOpen();
        DrawerKt$ModalDrawer$1$2$2 drawerKt$ModalDrawer$1$2$2 = new DrawerKt$ModalDrawer$1$2$2(z11, drawerState, o0Var);
        Object objValueOf = Float.valueOf(f10);
        Object objValueOf2 = Float.valueOf(0.0f);
        composer.startReplaceableGroup(1618982084);
        boolean zChanged = composer.changed(objValueOf) | composer.changed(objValueOf2) | composer.changed(drawerState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new DrawerKt$ModalDrawer$1$2$3$1(f10, 0.0f, drawerState);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        DrawerKt.m1001ScrimBx497Mc(zIsOpen, drawerKt$ModalDrawer$1$2$2, (a) objRememberedValue, j10, composer, (i12 >> 15) & 7168);
        String strM1145getString4foXLRw = Strings_androidKt.m1145getString4foXLRw(Strings.Companion.m1142getNavigationMenuUdPEhr4(), composer, 6);
        Density density3 = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        Modifier modifierM443sizeInqDBjuR0 = SizeKt.m443sizeInqDBjuR0(companion, density3.mo293toDpu2uoSUM(Constraints.m3643getMinWidthimpl(jMo371getConstraintsmsEJaDk)), density3.mo293toDpu2uoSUM(Constraints.m3642getMinHeightimpl(jMo371getConstraintsmsEJaDk)), density3.mo293toDpu2uoSUM(Constraints.m3641getMaxWidthimpl(jMo371getConstraintsmsEJaDk)), density3.mo293toDpu2uoSUM(Constraints.m3640getMaxHeightimpl(jMo371getConstraintsmsEJaDk)));
        composer.startReplaceableGroup(1157296644);
        boolean zChanged2 = composer.changed(drawerState);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new DrawerKt$ModalDrawer$1$2$5$1(drawerState);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        int i13 = i12 >> 12;
        SurfaceKt.m1147SurfaceFjzlyU(SemanticsModifierKt.semantics$default(PaddingKt.m403paddingqDBjuR0$default(OffsetKt.offset(modifierM443sizeInqDBjuR0, (l) objRememberedValue2), 0.0f, 0.0f, DrawerKt.EndDrawerPadding, 0.0f, 11, null), false, new DrawerKt$ModalDrawer$1$2$6(strM1145getString4foXLRw, drawerState, o0Var), 1, null), shape, j11, j12, null, f11, ComposableLambdaKt.composableLambda(composer, -1941234439, true, new DrawerKt$ModalDrawer$1$2$7(qVar, i12)), composer, ((i12 >> 9) & 112) | 1572864 | (i13 & 896) | (i13 & 7168) | (458752 & i12), 16);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }
}
