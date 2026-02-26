package androidx.compose.material;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
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
final class DrawerKt$BottomDrawer$1 extends v implements q<BoxWithConstraintsScope, Composer, Integer, k0> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ p<Composer, Integer, k0> $content;
    final /* synthetic */ long $drawerBackgroundColor;
    final /* synthetic */ q<ColumnScope, Composer, Integer, k0> $drawerContent;
    final /* synthetic */ long $drawerContentColor;
    final /* synthetic */ float $drawerElevation;
    final /* synthetic */ Shape $drawerShape;
    final /* synthetic */ BottomDrawerState $drawerState;
    final /* synthetic */ boolean $gesturesEnabled;
    final /* synthetic */ o0 $scope;
    final /* synthetic */ long $scrimColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DrawerKt$BottomDrawer$1(boolean z10, BottomDrawerState bottomDrawerState, p<? super Composer, ? super Integer, k0> pVar, int i10, long j10, Shape shape, long j11, long j12, float f10, o0 o0Var, q<? super ColumnScope, ? super Composer, ? super Integer, k0> qVar) {
        super(3);
        this.$gesturesEnabled = z10;
        this.$drawerState = bottomDrawerState;
        this.$content = pVar;
        this.$$dirty = i10;
        this.$scrimColor = j10;
        this.$drawerShape = shape;
        this.$drawerBackgroundColor = j11;
        this.$drawerContentColor = j12;
        this.$drawerElevation = f10;
        this.$scope = o0Var;
        this.$drawerContent = qVar;
    }

    /* JADX INFO: renamed from: invoke$lambda-1, reason: not valid java name */
    private static final float m1006invoke$lambda1(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: invoke$lambda-2, reason: not valid java name */
    public static final void m1007invoke$lambda2(MutableState<Float> mutableState, float f10) {
        mutableState.setValue(Float.valueOf(f10));
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
        float fM3640getMaxHeightimpl = Constraints.m3640getMaxHeightimpl(BoxWithConstraints.mo371getConstraintsmsEJaDk());
        Object objValueOf = Float.valueOf(fM3640getMaxHeightimpl);
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(objValueOf);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(fM3640getMaxHeightimpl), null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) objRememberedValue;
        boolean z10 = Constraints.m3641getMaxWidthimpl(BoxWithConstraints.mo371getConstraintsmsEJaDk()) > Constraints.m3640getMaxHeightimpl(BoxWithConstraints.mo371getConstraintsmsEJaDk());
        float f10 = 0.5f * fM3640getMaxHeightimpl;
        float fMax = Math.max(0.0f, fM3640getMaxHeightimpl - m1006invoke$lambda1(mutableState));
        Map mapJ = (m1006invoke$lambda1(mutableState) < f10 || z10) ? r0.j(y.a(Float.valueOf(fM3640getMaxHeightimpl), BottomDrawerValue.Closed), y.a(Float.valueOf(fMax), BottomDrawerValue.Expanded)) : r0.j(y.a(Float.valueOf(fM3640getMaxHeightimpl), BottomDrawerValue.Closed), y.a(Float.valueOf(f10), BottomDrawerValue.Open), y.a(Float.valueOf(fMax), BottomDrawerValue.Expanded));
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        Modifier.Companion companion = Modifier.Companion;
        Modifier modifierM444sizeInqDBjuR0$default = SizeKt.m444sizeInqDBjuR0$default(companion, 0.0f, 0.0f, density.mo293toDpu2uoSUM(Constraints.m3641getMaxWidthimpl(BoxWithConstraints.mo371getConstraintsmsEJaDk())), density.mo293toDpu2uoSUM(Constraints.m3640getMaxHeightimpl(BoxWithConstraints.mo371getConstraintsmsEJaDk())), 3, null);
        Modifier modifierM1157swipeablepPrIpRY = SwipeableKt.m1157swipeablepPrIpRY(companion.then(this.$gesturesEnabled ? NestedScrollModifierKt.nestedScroll$default(companion, this.$drawerState.getNestedScrollConnection$material_release(), null, 2, null) : companion), this.$drawerState, mapJ, Orientation.Vertical, (288 & 8) != 0 ? true : this.$gesturesEnabled, (288 & 16) != 0 ? false : false, (288 & 32) != 0 ? null : null, (288 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : null, (288 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapJ.keySet(), 0.0f, 0.0f, 6, null) : null, (288 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1156getVelocityThresholdD9Ej5fM() : 0.0f);
        p<Composer, Integer, k0> pVar = this.$content;
        int i12 = this.$$dirty;
        long j10 = this.$scrimColor;
        BottomDrawerState bottomDrawerState = this.$drawerState;
        Shape shape = this.$drawerShape;
        long j11 = this.$drawerBackgroundColor;
        long j12 = this.$drawerContentColor;
        float f11 = this.$drawerElevation;
        boolean z11 = this.$gesturesEnabled;
        o0 o0Var = this.$scope;
        q<ColumnScope, Composer, Integer, k0> qVar = this.$drawerContent;
        composer.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer, 0);
        composer.startReplaceableGroup(-1323940314);
        Density density2 = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
        a<ComposeUiNode> constructor = companion2.getConstructor();
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
        Updater.m1265setimpl(composerM1258constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m1265setimpl(composerM1258constructorimpl, density2, companion2.getSetDensity());
        Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
        Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
        composer.enableReusing();
        qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        composer.startReplaceableGroup(-2137368960);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        composer.startReplaceableGroup(-1660053078);
        pVar.mo4invoke(composer, Integer.valueOf((i12 >> 27) & 14));
        DrawerKt.m998BottomDrawerScrim3JVO9M(j10, new DrawerKt$BottomDrawer$1$1$1(z11, bottomDrawerState, o0Var), bottomDrawerState.getTargetValue() != BottomDrawerValue.Closed, composer, (i12 >> 24) & 14);
        String strM1145getString4foXLRw = Strings_androidKt.m1145getString4foXLRw(Strings.Companion.m1142getNavigationMenuUdPEhr4(), composer, 6);
        composer.startReplaceableGroup(1157296644);
        boolean zChanged2 = composer.changed(bottomDrawerState);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new DrawerKt$BottomDrawer$1$1$2$1(bottomDrawerState);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        Modifier modifierOffset = OffsetKt.offset(modifierM444sizeInqDBjuR0$default, (l) objRememberedValue2);
        composer.startReplaceableGroup(1157296644);
        boolean zChanged3 = composer.changed(mutableState);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged3 || objRememberedValue3 == Composer.Companion.getEmpty()) {
            objRememberedValue3 = new DrawerKt$BottomDrawer$1$1$3$1(mutableState);
            composer.updateRememberedValue(objRememberedValue3);
        }
        composer.endReplaceableGroup();
        int i13 = i12 >> 12;
        SurfaceKt.m1147SurfaceFjzlyU(SemanticsModifierKt.semantics$default(OnGloballyPositionedModifierKt.onGloballyPositioned(modifierOffset, (l) objRememberedValue3), false, new DrawerKt$BottomDrawer$1$1$4(strM1145getString4foXLRw, bottomDrawerState, o0Var), 1, null), shape, j11, j12, null, f11, ComposableLambdaKt.composableLambda(composer, 457750254, true, new DrawerKt$BottomDrawer$1$1$5(qVar, i12)), composer, ((i12 >> 9) & 112) | 1572864 | (i13 & 896) | (i13 & 7168) | (458752 & i12), 16);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }
}
