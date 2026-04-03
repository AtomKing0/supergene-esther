package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import h9.a;
import h9.l;
import h9.p;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: BottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BottomSheetScaffoldKt {
    private static final float FabSpacing = Dp.m3673constructorimpl(16);

    /* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$rememberBottomSheetState$1, reason: invalid class name */
    /* JADX INFO: compiled from: BottomSheetScaffold.kt */
    static final class AnonymousClass1 extends v implements l<BottomSheetValue, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        public final Boolean invoke(@NotNull BottomSheetValue it) {
            t.i(it, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$rememberBottomSheetState$2, reason: invalid class name */
    /* JADX INFO: compiled from: BottomSheetScaffold.kt */
    static final class AnonymousClass2 extends v implements a<BottomSheetState> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ l<BottomSheetValue, Boolean> $confirmStateChange;
        final /* synthetic */ BottomSheetValue $initialValue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(BottomSheetValue bottomSheetValue, AnimationSpec<Float> animationSpec, l<? super BottomSheetValue, Boolean> lVar) {
            super(0);
            this.$initialValue = bottomSheetValue;
            this.$animationSpec = animationSpec;
            this.$confirmStateChange = lVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final BottomSheetState invoke() {
            return new BottomSheetState(this.$initialValue, this.$animationSpec, this.$confirmStateChange);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0464  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x046f  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0475  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0478  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0496  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x049c  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x04a3  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x04d6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x04ed  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x04f8  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0507  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x050e  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0532  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0568  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x05a1  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x05ac  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x05bd  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x0681  */
    /* JADX WARN: Removed duplicated region for block: B:377:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0139  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][_]]")
    /* JADX INFO: renamed from: BottomSheetScaffold-bGncdBI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m892BottomSheetScaffoldbGncdBI(@org.jetbrains.annotations.NotNull h9.q<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r44, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r45, @org.jetbrains.annotations.Nullable androidx.compose.material.BottomSheetScaffoldState r46, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r47, @org.jetbrains.annotations.Nullable h9.q<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r48, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r49, int r50, boolean r51, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r52, float r53, long r54, long r56, float r58, @org.jetbrains.annotations.Nullable h9.q<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r59, boolean r60, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r61, float r62, long r63, long r65, long r67, long r69, long r71, @org.jetbrains.annotations.NotNull h9.q<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r73, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r74, int r75, int r76, int r77, int r78) {
        /*
            Method dump skipped, instruction units count: 1700
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt.m892BottomSheetScaffoldbGncdBI(h9.q, androidx.compose.ui.Modifier, androidx.compose.material.BottomSheetScaffoldState, h9.p, h9.q, h9.p, int, boolean, androidx.compose.ui.graphics.Shape, float, long, long, float, h9.q, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, long, long, h9.q, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][_][_][androidx.compose.ui.UiComposable][_]]")
    /* JADX INFO: renamed from: BottomSheetScaffoldLayout-KCBPh4w, reason: not valid java name */
    public static final void m893BottomSheetScaffoldLayoutKCBPh4w(p<? super Composer, ? super Integer, k0> pVar, q<? super PaddingValues, ? super Composer, ? super Integer, k0> qVar, q<? super Integer, ? super Composer, ? super Integer, k0> qVar2, p<? super Composer, ? super Integer, k0> pVar2, p<? super Composer, ? super Integer, k0> pVar3, float f10, int i10, State<Float> state, BottomSheetState bottomSheetState, Composer composer, int i11) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(499725572);
        int i12 = (i11 & 14) == 0 ? (composerStartRestartGroup.changed(pVar) ? 4 : 2) | i11 : i11;
        if ((i11 & 112) == 0) {
            i12 |= composerStartRestartGroup.changed(qVar) ? 32 : 16;
        }
        if ((i11 & 896) == 0) {
            i12 |= composerStartRestartGroup.changed(qVar2) ? 256 : 128;
        }
        if ((i11 & 7168) == 0) {
            i12 |= composerStartRestartGroup.changed(pVar2) ? 2048 : 1024;
        }
        if ((57344 & i11) == 0) {
            i12 |= composerStartRestartGroup.changed(pVar3) ? 16384 : 8192;
        }
        if ((458752 & i11) == 0) {
            i12 |= composerStartRestartGroup.changed(f10) ? 131072 : 65536;
        }
        if ((3670016 & i11) == 0) {
            i12 |= composerStartRestartGroup.changed(i10) ? 1048576 : 524288;
        }
        if ((29360128 & i11) == 0) {
            i12 |= composerStartRestartGroup.changed(state) ? 8388608 : 4194304;
        }
        if ((234881024 & i11) == 0) {
            i12 |= composerStartRestartGroup.changed(bottomSheetState) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i13 = i12;
        if ((i13 & 191739611) == 38347922 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            Object[] objArr = {qVar2, state, pVar, qVar, Dp.m3671boximpl(f10), pVar2, FabPosition.m1031boximpl(i10), pVar3, bottomSheetState};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            boolean zChanged = false;
            for (int i14 = 0; i14 < 9; i14++) {
                zChanged |= composerStartRestartGroup.changed(objArr[i14]);
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                composer2 = composerStartRestartGroup;
                BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1 bottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1 = new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1(state, pVar, pVar2, i10, f10, pVar3, bottomSheetState, qVar2, i13, qVar);
                composer2.updateRememberedValue(bottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1);
                objRememberedValue = bottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1;
            } else {
                composer2 = composerStartRestartGroup;
            }
            composer2.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(null, (p) objRememberedValue, composer2, 0, 1);
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2(pVar, qVar, qVar2, pVar2, pVar3, f10, i10, state, bottomSheetState, i11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: BottomSheetScaffold_bGncdBI$lambda-4, reason: not valid java name */
    public static final Float m894BottomSheetScaffold_bGncdBI$lambda4(MutableState<Float> mutableState) {
        return mutableState.getValue();
    }

    @Composable
    @ExperimentalMaterialApi
    @NotNull
    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(@Nullable DrawerState drawerState, @Nullable BottomSheetState bottomSheetState, @Nullable SnackbarHostState snackbarHostState, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(-1353009744);
        if ((i11 & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, null, composer, 6, 2);
        }
        if ((i11 & 2) != 0) {
            bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed, null, null, composer, 6, 6);
        }
        if ((i11 & 4) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) objRememberedValue;
        }
        composer.startReplaceableGroup(1618982084);
        boolean zChanged = composer.changed(drawerState) | composer.changed(bottomSheetState) | composer.changed(snackbarHostState);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new BottomSheetScaffoldState(drawerState, bottomSheetState, snackbarHostState);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) objRememberedValue2;
        composer.endReplaceableGroup();
        return bottomSheetScaffoldState;
    }

    @Composable
    @ExperimentalMaterialApi
    @NotNull
    public static final BottomSheetState rememberBottomSheetState(@NotNull BottomSheetValue initialValue, @Nullable AnimationSpec<Float> animationSpec, @Nullable l<? super BottomSheetValue, Boolean> lVar, @Nullable Composer composer, int i10, int i11) {
        t.i(initialValue, "initialValue");
        composer.startReplaceableGroup(1808153344);
        if ((i11 & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i11 & 4) != 0) {
            lVar = AnonymousClass1.INSTANCE;
        }
        BottomSheetState bottomSheetState = (BottomSheetState) RememberSaveableKt.m1271rememberSaveable(new Object[]{animationSpec}, (Saver) BottomSheetState.Companion.Saver(animationSpec, lVar), (String) null, (a) new AnonymousClass2(initialValue, animationSpec, lVar), composer, 72, 4);
        composer.endReplaceableGroup();
        return bottomSheetState;
    }
}
