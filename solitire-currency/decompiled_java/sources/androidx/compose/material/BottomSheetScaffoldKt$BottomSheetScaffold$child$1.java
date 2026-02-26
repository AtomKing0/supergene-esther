package androidx.compose.material;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import h9.a;
import h9.l;
import h9.p;
import h9.q;
import j9.c;
import java.util.Map;
import kotlin.collections.q0;
import kotlin.collections.r0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.y;

/* JADX INFO: compiled from: BottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
final class BottomSheetScaffoldKt$BottomSheetScaffold$child$1 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ int $$dirty2;
    final /* synthetic */ MutableState<Float> $bottomSheetHeight$delegate;
    final /* synthetic */ q<PaddingValues, Composer, Integer, k0> $content;
    final /* synthetic */ p<Composer, Integer, k0> $floatingActionButton;
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ float $peekHeightPx;
    final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
    final /* synthetic */ Modifier $semantics;
    final /* synthetic */ long $sheetBackgroundColor;
    final /* synthetic */ q<ColumnScope, Composer, Integer, k0> $sheetContent;
    final /* synthetic */ long $sheetContentColor;
    final /* synthetic */ float $sheetElevation;
    final /* synthetic */ boolean $sheetGesturesEnabled;
    final /* synthetic */ float $sheetPeekHeight;
    final /* synthetic */ Shape $sheetShape;
    final /* synthetic */ q<SnackbarHostState, Composer, Integer, k0> $snackbarHost;
    final /* synthetic */ p<Composer, Integer, k0> $topBar;

    /* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$child$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: BottomSheetScaffold.kt */
    static final class AnonymousClass1 extends v implements q<Integer, Composer, Integer, k0> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ int $$dirty1;
        final /* synthetic */ MutableState<Float> $bottomSheetHeight$delegate;
        final /* synthetic */ float $peekHeightPx;
        final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
        final /* synthetic */ Modifier $semantics;
        final /* synthetic */ long $sheetBackgroundColor;
        final /* synthetic */ q<ColumnScope, Composer, Integer, k0> $sheetContent;
        final /* synthetic */ long $sheetContentColor;
        final /* synthetic */ float $sheetElevation;
        final /* synthetic */ boolean $sheetGesturesEnabled;
        final /* synthetic */ float $sheetPeekHeight;
        final /* synthetic */ Shape $sheetShape;

        /* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$child$1$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: BottomSheetScaffold.kt */
        static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
            final /* synthetic */ int $$dirty;
            final /* synthetic */ q<ColumnScope, Composer, Integer, k0> $sheetContent;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(q<? super ColumnScope, ? super Composer, ? super Integer, k0> qVar, int i10) {
                super(2);
                this.$sheetContent = qVar;
                this.$$dirty = i10;
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
                q<ColumnScope, Composer, Integer, k0> qVar = this.$sheetContent;
                int i11 = (this.$$dirty << 9) & 7168;
                composer.startReplaceableGroup(-483455358);
                Modifier.Companion companion = Modifier.Companion;
                int i12 = i11 >> 3;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, (i12 & 112) | (i12 & 14));
                composer.startReplaceableGroup(-1323940314);
                Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                a<ComposeUiNode> constructor = companion2.getConstructor();
                q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(companion);
                int i13 = ((((i11 << 3) & 112) << 9) & 7168) | 6;
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
                Updater.m1265setimpl(composerM1258constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m1265setimpl(composerM1258constructorimpl, density, companion2.getSetDensity());
                Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
                Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
                composer.enableReusing();
                qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composer)), composer, Integer.valueOf((i13 >> 3) & 112));
                composer.startReplaceableGroup(2058660585);
                composer.startReplaceableGroup(-1163856341);
                if (((i13 >> 9) & 14 & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                } else {
                    qVar.invoke(ColumnScopeInstance.INSTANCE, composer, Integer.valueOf(((i11 >> 6) & 112) | 6));
                }
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endNode();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(float f10, BottomSheetScaffoldState bottomSheetScaffoldState, boolean z10, Modifier modifier, float f11, MutableState<Float> mutableState, Shape shape, long j10, long j11, float f12, int i10, int i11, q<? super ColumnScope, ? super Composer, ? super Integer, k0> qVar) {
            super(3);
            this.$peekHeightPx = f10;
            this.$scaffoldState = bottomSheetScaffoldState;
            this.$sheetGesturesEnabled = z10;
            this.$semantics = modifier;
            this.$sheetPeekHeight = f11;
            this.$bottomSheetHeight$delegate = mutableState;
            this.$sheetShape = shape;
            this.$sheetBackgroundColor = j10;
            this.$sheetContentColor = j11;
            this.$sheetElevation = f12;
            this.$$dirty = i10;
            this.$$dirty1 = i11;
            this.$sheetContent = qVar;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(Integer num, Composer composer, Integer num2) {
            invoke(num.intValue(), composer, num2.intValue());
            return k0.f35197a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(int i10, @Nullable Composer composer, int i11) {
            int i12;
            Map mapJ;
            Modifier modifierM1157swipeablepPrIpRY;
            if ((i11 & 14) == 0) {
                i12 = i11 | (composer.changed(i10) ? 4 : 2);
            } else {
                i12 = i11;
            }
            if ((i12 & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            Float fM894BottomSheetScaffold_bGncdBI$lambda4 = BottomSheetScaffoldKt.m894BottomSheetScaffold_bGncdBI$lambda4(this.$bottomSheetHeight$delegate);
            if (fM894BottomSheetScaffold_bGncdBI$lambda4 == null) {
                modifierM1157swipeablepPrIpRY = Modifier.Companion;
            } else {
                if (c.c(fM894BottomSheetScaffold_bGncdBI$lambda4.floatValue()) == c.c(this.$peekHeightPx)) {
                    mapJ = q0.e(y.a(Float.valueOf(i10 - fM894BottomSheetScaffold_bGncdBI$lambda4.floatValue()), BottomSheetValue.Collapsed));
                } else {
                    float f10 = i10;
                    Float fM894BottomSheetScaffold_bGncdBI$lambda42 = BottomSheetScaffoldKt.m894BottomSheetScaffold_bGncdBI$lambda4(this.$bottomSheetHeight$delegate);
                    t.f(fM894BottomSheetScaffold_bGncdBI$lambda42);
                    mapJ = r0.j(y.a(Float.valueOf(f10 - fM894BottomSheetScaffold_bGncdBI$lambda42.floatValue()), BottomSheetValue.Expanded), y.a(Float.valueOf(f10 - this.$peekHeightPx), BottomSheetValue.Collapsed));
                }
                Map map = mapJ;
                modifierM1157swipeablepPrIpRY = SwipeableKt.m1157swipeablepPrIpRY(Modifier.Companion, this.$scaffoldState.getBottomSheetState(), map, Orientation.Vertical, (288 & 8) != 0 ? true : this.$sheetGesturesEnabled, (288 & 16) != 0 ? false : false, (288 & 32) != 0 ? null : null, (288 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : null, (288 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map.keySet(), 0.0f, 0.0f, 6, null) : null, (288 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1156getVelocityThresholdD9Ej5fM() : 0.0f);
            }
            Modifier modifierM431requiredHeightInVpY3zN4$default = SizeKt.m431requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(NestedScrollModifierKt.nestedScroll$default(Modifier.Companion, this.$scaffoldState.getBottomSheetState().getNestedScrollConnection$material_release(), null, 2, null).then(modifierM1157swipeablepPrIpRY).then(this.$semantics), 0.0f, 1, null), this.$sheetPeekHeight, 0.0f, 2, null);
            MutableState<Float> mutableState = this.$bottomSheetHeight$delegate;
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(mutableState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$child$1$1$1$1(mutableState);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            Modifier modifierOnSizeChanged = OnRemeasuredModifierKt.onSizeChanged(modifierM431requiredHeightInVpY3zN4$default, (l) objRememberedValue);
            Shape shape = this.$sheetShape;
            long j10 = this.$sheetBackgroundColor;
            long j11 = this.$sheetContentColor;
            float f11 = this.$sheetElevation;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -698903261, true, new AnonymousClass2(this.$sheetContent, this.$$dirty));
            int i13 = this.$$dirty;
            int i14 = this.$$dirty1;
            SurfaceKt.m1147SurfaceFjzlyU(modifierOnSizeChanged, shape, j10, j11, null, f11, composableLambda, composer, ((i13 >> 21) & 112) | 1572864 | ((i14 << 6) & 896) | ((i14 << 6) & 7168) | ((i13 >> 12) & 458752), 16);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$child$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: BottomSheetScaffold.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
        final /* synthetic */ q<SnackbarHostState, Composer, Integer, k0> $snackbarHost;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(q<? super SnackbarHostState, ? super Composer, ? super Integer, k0> qVar, BottomSheetScaffoldState bottomSheetScaffoldState, int i10) {
            super(2);
            this.$snackbarHost = qVar;
            this.$scaffoldState = bottomSheetScaffoldState;
            this.$$dirty = i10;
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
            } else {
                this.$snackbarHost.invoke(this.$scaffoldState.getSnackbarHostState(), composer, Integer.valueOf((this.$$dirty >> 9) & 112));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BottomSheetScaffoldKt$BottomSheetScaffold$child$1(BottomSheetScaffoldState bottomSheetScaffoldState, p<? super Composer, ? super Integer, k0> pVar, q<? super PaddingValues, ? super Composer, ? super Integer, k0> qVar, p<? super Composer, ? super Integer, k0> pVar2, float f10, int i10, int i11, int i12, int i13, float f11, boolean z10, Modifier modifier, MutableState<Float> mutableState, Shape shape, long j10, long j11, float f12, q<? super ColumnScope, ? super Composer, ? super Integer, k0> qVar2, q<? super SnackbarHostState, ? super Composer, ? super Integer, k0> qVar3) {
        super(2);
        this.$scaffoldState = bottomSheetScaffoldState;
        this.$topBar = pVar;
        this.$content = qVar;
        this.$floatingActionButton = pVar2;
        this.$sheetPeekHeight = f10;
        this.$floatingActionButtonPosition = i10;
        this.$$dirty = i11;
        this.$$dirty2 = i12;
        this.$$dirty1 = i13;
        this.$peekHeightPx = f11;
        this.$sheetGesturesEnabled = z10;
        this.$semantics = modifier;
        this.$bottomSheetHeight$delegate = mutableState;
        this.$sheetShape = shape;
        this.$sheetBackgroundColor = j10;
        this.$sheetContentColor = j11;
        this.$sheetElevation = f12;
        this.$sheetContent = qVar2;
        this.$snackbarHost = qVar3;
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
        State<Float> offset = this.$scaffoldState.getBottomSheetState().getOffset();
        BottomSheetState bottomSheetState = this.$scaffoldState.getBottomSheetState();
        p<Composer, Integer, k0> pVar = this.$topBar;
        q<PaddingValues, Composer, Integer, k0> qVar = this.$content;
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -1378534681, true, new AnonymousClass1(this.$peekHeightPx, this.$scaffoldState, this.$sheetGesturesEnabled, this.$semantics, this.$sheetPeekHeight, this.$bottomSheetHeight$delegate, this.$sheetShape, this.$sheetBackgroundColor, this.$sheetContentColor, this.$sheetElevation, this.$$dirty, this.$$dirty1, this.$sheetContent));
        p<Composer, Integer, k0> pVar2 = this.$floatingActionButton;
        ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer, -486138068, true, new AnonymousClass2(this.$snackbarHost, this.$scaffoldState, this.$$dirty));
        float f10 = this.$sheetPeekHeight;
        int i11 = this.$floatingActionButtonPosition;
        int i12 = this.$$dirty;
        BottomSheetScaffoldKt.m893BottomSheetScaffoldLayoutKCBPh4w(pVar, qVar, composableLambda, pVar2, composableLambda2, f10, i11, offset, bottomSheetState, composer, ((i12 >> 9) & 14) | 24960 | ((this.$$dirty2 >> 3) & 112) | ((i12 >> 6) & 7168) | ((this.$$dirty1 << 9) & 458752) | (i12 & 3670016));
    }
}
