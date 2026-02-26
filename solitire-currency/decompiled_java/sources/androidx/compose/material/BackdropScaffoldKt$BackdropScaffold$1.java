package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
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
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import h9.a;
import h9.l;
import h9.p;
import h9.q;
import h9.r;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.h;

/* JADX INFO: compiled from: BackdropScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
final class BackdropScaffoldKt$BackdropScaffold$1 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ p<Composer, Integer, k0> $backLayer;
    final /* synthetic */ l<Constraints, Constraints> $calculateBackLayerConstraints;
    final /* synthetic */ long $frontLayerBackgroundColor;
    final /* synthetic */ p<Composer, Integer, k0> $frontLayerContent;
    final /* synthetic */ long $frontLayerContentColor;
    final /* synthetic */ float $frontLayerElevation;
    final /* synthetic */ long $frontLayerScrimColor;
    final /* synthetic */ Shape $frontLayerShape;
    final /* synthetic */ boolean $gesturesEnabled;
    final /* synthetic */ float $headerHeight;
    final /* synthetic */ float $headerHeightPx;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ float $peekHeight;
    final /* synthetic */ float $peekHeightPx;
    final /* synthetic */ BackdropScaffoldState $scaffoldState;
    final /* synthetic */ q<SnackbarHostState, Composer, Integer, k0> $snackbarHost;
    final /* synthetic */ boolean $stickyFrontLayer;

    /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: BackdropScaffold.kt */
    static final class AnonymousClass1 extends v implements r<Constraints, Float, Composer, Integer, k0> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ int $$dirty1;
        final /* synthetic */ long $frontLayerBackgroundColor;
        final /* synthetic */ p<Composer, Integer, k0> $frontLayerContent;
        final /* synthetic */ long $frontLayerContentColor;
        final /* synthetic */ float $frontLayerElevation;
        final /* synthetic */ long $frontLayerScrimColor;
        final /* synthetic */ Shape $frontLayerShape;
        final /* synthetic */ boolean $gesturesEnabled;
        final /* synthetic */ float $headerHeight;
        final /* synthetic */ float $headerHeightPx;
        final /* synthetic */ float $peekHeight;
        final /* synthetic */ float $peekHeightPx;
        final /* synthetic */ BackdropScaffoldState $scaffoldState;
        final /* synthetic */ o0 $scope;
        final /* synthetic */ q<SnackbarHostState, Composer, Integer, k0> $snackbarHost;
        final /* synthetic */ boolean $stickyFrontLayer;

        /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: BackdropScaffold.kt */
        static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
            final /* synthetic */ int $$dirty;
            final /* synthetic */ int $$dirty1;
            final /* synthetic */ p<Composer, Integer, k0> $frontLayerContent;
            final /* synthetic */ long $frontLayerScrimColor;
            final /* synthetic */ boolean $gesturesEnabled;
            final /* synthetic */ float $peekHeight;
            final /* synthetic */ BackdropScaffoldState $scaffoldState;
            final /* synthetic */ o0 $scope;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(float f10, p<? super Composer, ? super Integer, k0> pVar, int i10, long j10, BackdropScaffoldState backdropScaffoldState, int i11, boolean z10, o0 o0Var) {
                super(2);
                this.$peekHeight = f10;
                this.$frontLayerContent = pVar;
                this.$$dirty = i10;
                this.$frontLayerScrimColor = j10;
                this.$scaffoldState = backdropScaffoldState;
                this.$$dirty1 = i11;
                this.$gesturesEnabled = z10;
                this.$scope = o0Var;
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
                Modifier modifierM403paddingqDBjuR0$default = PaddingKt.m403paddingqDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, this.$peekHeight, 7, null);
                p<Composer, Integer, k0> pVar = this.$frontLayerContent;
                int i11 = this.$$dirty;
                long j10 = this.$frontLayerScrimColor;
                BackdropScaffoldState backdropScaffoldState = this.$scaffoldState;
                int i12 = this.$$dirty1;
                boolean z10 = this.$gesturesEnabled;
                o0 o0Var = this.$scope;
                composer.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer, 0);
                composer.startReplaceableGroup(-1323940314);
                Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                a<ComposeUiNode> constructor = companion.getConstructor();
                q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(modifierM403paddingqDBjuR0$default);
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
                qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composer)), composer, 0);
                composer.startReplaceableGroup(2058660585);
                composer.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                composer.startReplaceableGroup(-1889954677);
                pVar.mo4invoke(composer, Integer.valueOf((i11 >> 6) & 14));
                BackdropScaffoldKt.m869Scrim3JVO9M(j10, new BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1(z10, backdropScaffoldState, o0Var), backdropScaffoldState.getTargetValue() == BackdropValue.Revealed, composer, (i12 >> 18) & 14);
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endNode();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(float f10, boolean z10, boolean z11, BackdropScaffoldState backdropScaffoldState, float f11, int i10, Shape shape, long j10, long j11, float f12, int i11, float f13, o0 o0Var, float f14, p<? super Composer, ? super Integer, k0> pVar, long j12, q<? super SnackbarHostState, ? super Composer, ? super Integer, k0> qVar) {
            super(4);
            this.$headerHeightPx = f10;
            this.$stickyFrontLayer = z10;
            this.$gesturesEnabled = z11;
            this.$scaffoldState = backdropScaffoldState;
            this.$peekHeightPx = f11;
            this.$$dirty = i10;
            this.$frontLayerShape = shape;
            this.$frontLayerBackgroundColor = j10;
            this.$frontLayerContentColor = j11;
            this.$frontLayerElevation = f12;
            this.$$dirty1 = i11;
            this.$headerHeight = f13;
            this.$scope = o0Var;
            this.$peekHeight = f14;
            this.$frontLayerContent = pVar;
            this.$frontLayerScrimColor = j12;
            this.$snackbarHost = qVar;
        }

        @Override // h9.r
        public /* bridge */ /* synthetic */ k0 invoke(Constraints constraints, Float f10, Composer composer, Integer num) {
            m873invokejYbf7pk(constraints.m3647unboximpl(), f10.floatValue(), composer, num.intValue());
            return k0.f35197a;
        }

        /* JADX WARN: Removed duplicated region for block: B:43:0x0169  */
        @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @androidx.compose.runtime.Composable
        /* JADX INFO: renamed from: invoke-jYbf7pk, reason: not valid java name */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void m873invokejYbf7pk(long r32, float r34, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r35, int r36) {
            /*
                Method dump skipped, instruction units count: 577
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1.AnonymousClass1.m873invokejYbf7pk(long, float, androidx.compose.runtime.Composer, int):void");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BackdropScaffoldKt$BackdropScaffold$1(Modifier modifier, p<? super Composer, ? super Integer, k0> pVar, l<? super Constraints, Constraints> lVar, float f10, boolean z10, boolean z11, BackdropScaffoldState backdropScaffoldState, float f11, int i10, Shape shape, long j10, long j11, float f12, int i11, float f13, float f14, p<? super Composer, ? super Integer, k0> pVar2, long j12, q<? super SnackbarHostState, ? super Composer, ? super Integer, k0> qVar) {
        super(2);
        this.$modifier = modifier;
        this.$backLayer = pVar;
        this.$calculateBackLayerConstraints = lVar;
        this.$headerHeightPx = f10;
        this.$stickyFrontLayer = z10;
        this.$gesturesEnabled = z11;
        this.$scaffoldState = backdropScaffoldState;
        this.$peekHeightPx = f11;
        this.$$dirty = i10;
        this.$frontLayerShape = shape;
        this.$frontLayerBackgroundColor = j10;
        this.$frontLayerContentColor = j11;
        this.$frontLayerElevation = f12;
        this.$$dirty1 = i11;
        this.$headerHeight = f13;
        this.$peekHeight = f14;
        this.$frontLayerContent = pVar2;
        this.$frontLayerScrimColor = j12;
        this.$snackbarHost = qVar;
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
        composer.startReplaceableGroup(773894976);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(h.f37608a, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            objRememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        composer.endReplaceableGroup();
        o0 coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
        composer.endReplaceableGroup();
        BackdropScaffoldKt.BackdropStack(SizeKt.fillMaxSize$default(this.$modifier, 0.0f, 1, null), this.$backLayer, this.$calculateBackLayerConstraints, ComposableLambdaKt.composableLambda(composer, 1800047509, true, new AnonymousClass1(this.$headerHeightPx, this.$stickyFrontLayer, this.$gesturesEnabled, this.$scaffoldState, this.$peekHeightPx, this.$$dirty, this.$frontLayerShape, this.$frontLayerBackgroundColor, this.$frontLayerContentColor, this.$frontLayerElevation, this.$$dirty1, this.$headerHeight, coroutineScope, this.$peekHeight, this.$frontLayerContent, this.$frontLayerScrimColor, this.$snackbarHost)), composer, 3120);
    }
}
