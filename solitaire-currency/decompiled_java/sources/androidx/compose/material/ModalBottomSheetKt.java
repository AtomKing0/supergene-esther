package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import h9.a;
import h9.l;
import h9.p;
import java.util.Map;
import kotlin.collections.r0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.y;
import z8.d;

/* JADX INFO: compiled from: ModalBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModalBottomSheetKt {

    /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$rememberModalBottomSheetState$1, reason: invalid class name */
    /* JADX INFO: compiled from: ModalBottomSheet.kt */
    static final class AnonymousClass1 extends v implements l<ModalBottomSheetValue, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        public final Boolean invoke(@NotNull ModalBottomSheetValue it) {
            t.i(it, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$rememberModalBottomSheetState$2, reason: invalid class name */
    /* JADX INFO: compiled from: ModalBottomSheet.kt */
    static final class AnonymousClass2 extends v implements a<ModalBottomSheetState> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ l<ModalBottomSheetValue, Boolean> $confirmStateChange;
        final /* synthetic */ ModalBottomSheetValue $initialValue;
        final /* synthetic */ boolean $skipHalfExpanded;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(ModalBottomSheetValue modalBottomSheetValue, AnimationSpec<Float> animationSpec, boolean z10, l<? super ModalBottomSheetValue, Boolean> lVar) {
            super(0);
            this.$initialValue = modalBottomSheetValue;
            this.$animationSpec = animationSpec;
            this.$skipHalfExpanded = z10;
            this.$confirmStateChange = lVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final ModalBottomSheetState invoke() {
            return new ModalBottomSheetState(this.$initialValue, this.$animationSpec, this.$skipHalfExpanded, this.$confirmStateChange);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$rememberModalBottomSheetState$3, reason: invalid class name */
    /* JADX INFO: compiled from: ModalBottomSheet.kt */
    static final class AnonymousClass3 extends v implements l<ModalBottomSheetValue, Boolean> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        AnonymousClass3() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        public final Boolean invoke(@NotNull ModalBottomSheetValue it) {
            t.i(it, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:158:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0111  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: ModalBottomSheetLayout-BzaUkTc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1064ModalBottomSheetLayoutBzaUkTc(@org.jetbrains.annotations.NotNull h9.q<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r31, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r32, @org.jetbrains.annotations.Nullable androidx.compose.material.ModalBottomSheetState r33, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r34, float r35, long r36, long r38, long r40, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r42, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r43, int r44, int r45) {
        /*
            Method dump skipped, instruction units count: 667
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ModalBottomSheetKt.m1064ModalBottomSheetLayoutBzaUkTc(h9.q, androidx.compose.ui.Modifier, androidx.compose.material.ModalBottomSheetState, androidx.compose.ui.graphics.Shape, float, long, long, long, h9.p, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Scrim-3J-VO9M, reason: not valid java name */
    public static final void m1065Scrim3JVO9M(long j10, a<k0> aVar, boolean z10, Composer composer, int i10) {
        int i11;
        Modifier modifierSemantics;
        Composer composerStartRestartGroup = composer.startRestartGroup(-526532668);
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
                String strM1145getString4foXLRw = Strings_androidKt.m1145getString4foXLRw(Strings.Companion.m1139getCloseSheetUdPEhr4(), composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(1010547488);
                if (z10) {
                    Modifier.Companion companion = Modifier.Companion;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    boolean zChanged = composerStartRestartGroup.changed(aVar);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new ModalBottomSheetKt$Scrim$dismissModifier$1$1(aVar, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, aVar, (p<? super PointerInputScope, ? super d<? super k0>, ? extends Object>) objRememberedValue);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    boolean zChanged2 = composerStartRestartGroup.changed(strM1145getString4foXLRw) | composerStartRestartGroup.changed(aVar);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = new ModalBottomSheetKt$Scrim$dismissModifier$2$1(strM1145getString4foXLRw, aVar);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    modifierSemantics = SemanticsModifierKt.semantics(modifierPointerInput, true, (l) objRememberedValue2);
                } else {
                    modifierSemantics = Modifier.Companion;
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null).then(modifierSemantics);
                Color colorM1588boximpl = Color.m1588boximpl(j10);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                boolean zChanged3 = composerStartRestartGroup.changed(colorM1588boximpl) | composerStartRestartGroup.changed(stateAnimateFloatAsState);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged3 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                    objRememberedValue3 = new ModalBottomSheetKt$Scrim$1$1(j10, stateAnimateFloatAsState);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(modifierThen, (l) objRememberedValue3, composerStartRestartGroup, 0);
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new ModalBottomSheetKt$Scrim$2(j10, aVar, z10, i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Scrim_3J_VO9M$lambda-0, reason: not valid java name */
    public static final float m1066Scrim_3J_VO9M$lambda0(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier bottomSheetSwipeable(Modifier modifier, ModalBottomSheetState modalBottomSheetState, float f10, State<Float> state) {
        Modifier modifierM1157swipeablepPrIpRY;
        Float value = state.getValue();
        if (value != null) {
            float f11 = f10 / 2;
            Map mapJ = (value.floatValue() < f11 || modalBottomSheetState.isSkipHalfExpanded$material_release()) ? r0.j(y.a(Float.valueOf(f10), ModalBottomSheetValue.Hidden), y.a(Float.valueOf(f10 - value.floatValue()), ModalBottomSheetValue.Expanded)) : r0.j(y.a(Float.valueOf(f10), ModalBottomSheetValue.Hidden), y.a(Float.valueOf(f11), ModalBottomSheetValue.HalfExpanded), y.a(Float.valueOf(Math.max(0.0f, f10 - value.floatValue())), ModalBottomSheetValue.Expanded));
            modifierM1157swipeablepPrIpRY = SwipeableKt.m1157swipeablepPrIpRY(Modifier.Companion, modalBottomSheetState, mapJ, Orientation.Vertical, (288 & 8) != 0 ? true : modalBottomSheetState.getCurrentValue() != ModalBottomSheetValue.Hidden, (288 & 16) != 0 ? false : false, (288 & 32) != 0 ? null : null, (288 & 64) != 0 ? SwipeableKt$swipeable$1.INSTANCE : null, (288 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, mapJ.keySet(), 0.0f, 0.0f, 6, null) : null, (288 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1156getVelocityThresholdD9Ej5fM() : 0.0f);
        } else {
            modifierM1157swipeablepPrIpRY = Modifier.Companion;
        }
        return modifier.then(modifierM1157swipeablepPrIpRY);
    }

    @Composable
    @ExperimentalMaterialApi
    @NotNull
    public static final ModalBottomSheetState rememberModalBottomSheetState(@NotNull ModalBottomSheetValue initialValue, @Nullable AnimationSpec<Float> animationSpec, boolean z10, @Nullable l<? super ModalBottomSheetValue, Boolean> lVar, @Nullable Composer composer, int i10, int i11) {
        t.i(initialValue, "initialValue");
        composer.startReplaceableGroup(-409288536);
        if ((i11 & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i11 & 8) != 0) {
            lVar = AnonymousClass1.INSTANCE;
        }
        ModalBottomSheetState modalBottomSheetState = (ModalBottomSheetState) RememberSaveableKt.m1271rememberSaveable(new Object[]{initialValue, animationSpec, Boolean.valueOf(z10), lVar}, (Saver) ModalBottomSheetState.Companion.Saver(animationSpec, z10, lVar), (String) null, (a) new AnonymousClass2(initialValue, animationSpec, z10, lVar), composer, 72, 4);
        composer.endReplaceableGroup();
        return modalBottomSheetState;
    }

    @Composable
    @ExperimentalMaterialApi
    @NotNull
    public static final ModalBottomSheetState rememberModalBottomSheetState(@NotNull ModalBottomSheetValue initialValue, @Nullable AnimationSpec<Float> animationSpec, @Nullable l<? super ModalBottomSheetValue, Boolean> lVar, @Nullable Composer composer, int i10, int i11) {
        t.i(initialValue, "initialValue");
        composer.startReplaceableGroup(-1928569212);
        if ((i11 & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        AnimationSpec<Float> animationSpec2 = animationSpec;
        if ((i11 & 4) != 0) {
            lVar = AnonymousClass3.INSTANCE;
        }
        ModalBottomSheetState modalBottomSheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(initialValue, animationSpec2, false, lVar, composer, (i10 & 14) | 448 | ((i10 << 3) & 7168), 0);
        composer.endReplaceableGroup();
        return modalBottomSheetStateRememberModalBottomSheetState;
    }
}
