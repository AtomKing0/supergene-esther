package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.UiComposable;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import h9.a;
import h9.l;
import h9.p;
import h9.q;
import h9.r;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: BackdropScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BackdropScaffoldKt {
    private static final float AnimationSlideOffset = Dp.m3673constructorimpl(20);

    /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$BackLayerTransition$2, reason: invalid class name */
    /* JADX INFO: compiled from: BackdropScaffold.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ p<Composer, Integer, k0> $appBar;
        final /* synthetic */ p<Composer, Integer, k0> $content;
        final /* synthetic */ BackdropValue $target;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(BackdropValue backdropValue, p<? super Composer, ? super Integer, k0> pVar, p<? super Composer, ? super Integer, k0> pVar2, int i10) {
            super(2);
            this.$target = backdropValue;
            this.$appBar = pVar;
            this.$content = pVar2;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            BackdropScaffoldKt.BackLayerTransition(this.$target, this.$appBar, this.$content, composer, this.$$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropStack$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BackdropScaffold.kt */
    static final class C09162 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ p<Composer, Integer, k0> $backLayer;
        final /* synthetic */ l<Constraints, Constraints> $calculateBackLayerConstraints;
        final /* synthetic */ r<Constraints, Float, Composer, Integer, k0> $frontLayer;
        final /* synthetic */ Modifier $modifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09162(Modifier modifier, p<? super Composer, ? super Integer, k0> pVar, l<? super Constraints, Constraints> lVar, r<? super Constraints, ? super Float, ? super Composer, ? super Integer, k0> rVar, int i10) {
            super(2);
            this.$modifier = modifier;
            this.$backLayer = pVar;
            this.$calculateBackLayerConstraints = lVar;
            this.$frontLayer = rVar;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            BackdropScaffoldKt.BackdropStack(this.$modifier, this.$backLayer, this.$calculateBackLayerConstraints, this.$frontLayer, composer, this.$$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$rememberBackdropScaffoldState$1, reason: invalid class name */
    /* JADX INFO: compiled from: BackdropScaffold.kt */
    static final class AnonymousClass1 extends v implements l<BackdropValue, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        public final Boolean invoke(@NotNull BackdropValue it) {
            t.i(it, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$rememberBackdropScaffoldState$3, reason: invalid class name */
    /* JADX INFO: compiled from: BackdropScaffold.kt */
    static final class AnonymousClass3 extends v implements a<BackdropScaffoldState> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ l<BackdropValue, Boolean> $confirmStateChange;
        final /* synthetic */ BackdropValue $initialValue;
        final /* synthetic */ SnackbarHostState $snackbarHostState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(BackdropValue backdropValue, AnimationSpec<Float> animationSpec, l<? super BackdropValue, Boolean> lVar, SnackbarHostState snackbarHostState) {
            super(0);
            this.$initialValue = backdropValue;
            this.$animationSpec = animationSpec;
            this.$confirmStateChange = lVar;
            this.$snackbarHostState = snackbarHostState;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final BackdropScaffoldState invoke() {
            return new BackdropScaffoldState(this.$initialValue, this.$animationSpec, this.$confirmStateChange, this.$snackbarHostState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void BackLayerTransition(BackdropValue backdropValue, p<? super Composer, ? super Integer, k0> pVar, p<? super Composer, ? super Integer, k0> pVar2, Composer composer, int i10) {
        int i11;
        p<? super Composer, ? super Integer, k0> pVar3 = pVar2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-950970976);
        if ((i10 & 14) == 0) {
            i11 = (composerStartRestartGroup.changed(backdropValue) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 112) == 0) {
            i11 |= composerStartRestartGroup.changed(pVar) ? 32 : 16;
        }
        if ((i10 & 896) == 0) {
            i11 |= composerStartRestartGroup.changed(pVar3) ? 256 : 128;
        }
        int i12 = i11;
        if ((i12 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(backdropValue == BackdropValue.Revealed ? 0.0f : 2.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, composerStartRestartGroup, 0, 12);
            float fMo296toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo296toPx0680j_4(AnimationSlideOffset);
            float f10 = 1;
            float fM = o.m(m867BackLayerTransition$lambda7(stateAnimateFloatAsState) - f10, 0.0f, 1.0f);
            float fM2 = o.m(f10 - m867BackLayerTransition$lambda7(stateAnimateFloatAsState), 0.0f, 1.0f);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            Modifier.Companion companion = Modifier.Companion;
            Alignment.Companion companion2 = Alignment.Companion;
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            a<ComposeUiNode> constructor = companion3.getConstructor();
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
            Updater.m1265setimpl(composerM1258constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1265setimpl(composerM1258constructorimpl, density, companion3.getSetDensity());
            Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion3.getSetLayoutDirection());
            Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion3.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(2065804710);
            Modifier modifierM1735graphicsLayerpANQ8Wg$default = GraphicsLayerModifierKt.m1735graphicsLayerpANQ8Wg$default(ZIndexModifierKt.zIndex(companion, fM), 0.0f, 0.0f, fM, 0.0f, (f10 - fM) * fMo296toPx0680j_4, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 65515, null);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            a<ComposeUiNode> constructor2 = companion3.getConstructor();
            q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf2 = LayoutKt.materializerOf(modifierM1735graphicsLayerpANQ8Wg$default);
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
            Updater.m1265setimpl(composerM1258constructorimpl2, measurePolicyRememberBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m1265setimpl(composerM1258constructorimpl2, density2, companion3.getSetDensity());
            Updater.m1265setimpl(composerM1258constructorimpl2, layoutDirection2, companion3.getSetLayoutDirection());
            Updater.m1265setimpl(composerM1258constructorimpl2, viewConfiguration2, companion3.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            qVarMaterializerOf2.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            composerStartRestartGroup.startReplaceableGroup(-1057690836);
            pVar.mo4invoke(composerStartRestartGroup, Integer.valueOf((i12 >> 3) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierM1735graphicsLayerpANQ8Wg$default2 = GraphicsLayerModifierKt.m1735graphicsLayerpANQ8Wg$default(ZIndexModifierKt.zIndex(companion, fM2), 0.0f, 0.0f, fM2, 0.0f, (f10 - fM2) * (-fMo296toPx0680j_4), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 65515, null);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            a<ComposeUiNode> constructor3 = companion3.getConstructor();
            q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf3 = LayoutKt.materializerOf(modifierM1735graphicsLayerpANQ8Wg$default2);
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
            Updater.m1265setimpl(composerM1258constructorimpl3, measurePolicyRememberBoxMeasurePolicy3, companion3.getSetMeasurePolicy());
            Updater.m1265setimpl(composerM1258constructorimpl3, density3, companion3.getSetDensity());
            Updater.m1265setimpl(composerM1258constructorimpl3, layoutDirection3, companion3.getSetLayoutDirection());
            Updater.m1265setimpl(composerM1258constructorimpl3, viewConfiguration3, companion3.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            qVarMaterializerOf3.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            composerStartRestartGroup.startReplaceableGroup(-676544093);
            pVar3 = pVar2;
            pVar3.mo4invoke(composerStartRestartGroup, Integer.valueOf((i12 >> 6) & 14));
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
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(backdropValue, pVar, pVar3, i10));
    }

    /* JADX INFO: renamed from: BackLayerTransition$lambda-7, reason: not valid java name */
    private static final float m867BackLayerTransition$lambda7(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x04f7  */
    /* JADX WARN: Removed duplicated region for block: B:287:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0141  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: BackdropScaffold-BZszfkY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m868BackdropScaffoldBZszfkY(@org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r53, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r54, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r55, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r56, @org.jetbrains.annotations.Nullable androidx.compose.material.BackdropScaffoldState r57, boolean r58, float r59, float r60, boolean r61, boolean r62, long r63, long r65, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r67, float r68, long r69, long r71, long r73, @org.jetbrains.annotations.Nullable h9.q<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r75, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r76, int r77, int r78, int r79) {
        /*
            Method dump skipped, instruction units count: 1301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BackdropScaffoldKt.m868BackdropScaffoldBZszfkY(h9.p, h9.p, h9.p, androidx.compose.ui.Modifier, androidx.compose.material.BackdropScaffoldState, boolean, float, float, boolean, boolean, long, long, androidx.compose.ui.graphics.Shape, float, long, long, long, h9.q, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @UiComposable
    public static final void BackdropStack(Modifier modifier, p<? super Composer, ? super Integer, k0> pVar, l<? super Constraints, Constraints> lVar, r<? super Constraints, ? super Float, ? super Composer, ? super Integer, k0> rVar, Composer composer, int i10) {
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1248995194);
        if ((i10 & 14) == 0) {
            i11 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 112) == 0) {
            i11 |= composerStartRestartGroup.changed(pVar) ? 32 : 16;
        }
        if ((i10 & 896) == 0) {
            i11 |= composerStartRestartGroup.changed(lVar) ? 256 : 128;
        }
        if ((i10 & 7168) == 0) {
            i11 |= composerStartRestartGroup.changed(rVar) ? 2048 : 1024;
        }
        if ((i11 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            composerStartRestartGroup.startReplaceableGroup(1618982084);
            boolean zChanged = composerStartRestartGroup.changed(pVar) | composerStartRestartGroup.changed(lVar) | composerStartRestartGroup.changed(rVar);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new BackdropScaffoldKt$BackdropStack$1$1(pVar, lVar, rVar, i11);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(modifier, (p) objRememberedValue, composerStartRestartGroup, i11 & 14, 0);
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C09162(modifier, pVar, lVar, rVar, i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Scrim-3J-VO9M, reason: not valid java name */
    public static final void m869Scrim3JVO9M(long j10, a<k0> aVar, boolean z10, Composer composer, int i10) {
        int i11;
        Modifier modifierPointerInput;
        Composer composerStartRestartGroup = composer.startRestartGroup(-92141505);
        if ((i10 & 14) == 0) {
            i11 = (composerStartRestartGroup.changed(j10) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 112) == 0) {
            i11 |= composerStartRestartGroup.changed(aVar) ? 32 : 16;
        }
        if ((i10 & 896) == 0) {
            i11 |= composerStartRestartGroup.changed(z10) ? 256 : 128;
        }
        if ((i11 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (j10 != Color.Companion.m1634getUnspecified0d7_KjU()) {
                State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z10 ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, composerStartRestartGroup, 0, 12);
                composerStartRestartGroup.startReplaceableGroup(1010547004);
                if (z10) {
                    Modifier.Companion companion = Modifier.Companion;
                    k0 k0Var = k0.f35197a;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    boolean zChanged = composerStartRestartGroup.changed(aVar);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new BackdropScaffoldKt$Scrim$dismissModifier$1$1(aVar, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, k0Var, (p<? super PointerInputScope, ? super d<? super k0>, ? extends Object>) objRememberedValue);
                } else {
                    modifierPointerInput = Modifier.Companion;
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null).then(modifierPointerInput);
                Color colorM1588boximpl = Color.m1588boximpl(j10);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                boolean zChanged2 = composerStartRestartGroup.changed(colorM1588boximpl) | composerStartRestartGroup.changed(stateAnimateFloatAsState);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new BackdropScaffoldKt$Scrim$1$1(j10, stateAnimateFloatAsState);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(modifierThen, (l) objRememberedValue2, composerStartRestartGroup, 0);
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new BackdropScaffoldKt$Scrim$2(j10, aVar, z10, i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Scrim_3J_VO9M$lambda-4, reason: not valid java name */
    public static final float m870Scrim_3J_VO9M$lambda4(State<Float> state) {
        return state.getValue().floatValue();
    }

    @Composable
    @ExperimentalMaterialApi
    @NotNull
    public static final BackdropScaffoldState rememberBackdropScaffoldState(@NotNull BackdropValue initialValue, @Nullable AnimationSpec<Float> animationSpec, @Nullable l<? super BackdropValue, Boolean> lVar, @Nullable SnackbarHostState snackbarHostState, @Nullable Composer composer, int i10, int i11) {
        t.i(initialValue, "initialValue");
        composer.startReplaceableGroup(-862178912);
        if ((i11 & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i11 & 4) != 0) {
            lVar = AnonymousClass1.INSTANCE;
        }
        if ((i11 & 8) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) objRememberedValue;
        }
        BackdropScaffoldState backdropScaffoldState = (BackdropScaffoldState) RememberSaveableKt.m1271rememberSaveable(new Object[]{animationSpec, lVar, snackbarHostState}, (Saver) BackdropScaffoldState.Companion.Saver(animationSpec, lVar, snackbarHostState), (String) null, (a) new AnonymousClass3(initialValue, animationSpec, lVar, snackbarHostState), composer, 72, 4);
        composer.endReplaceableGroup();
        return backdropScaffoldState;
    }
}
