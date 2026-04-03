package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.UiComposable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.unit.Dp;
import h9.p;
import h9.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Scaffold.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ScaffoldKt {

    @NotNull
    private static final ProvidableCompositionLocal<FabPlacement> LocalFabPlacement = CompositionLocalKt.staticCompositionLocalOf(ScaffoldKt$LocalFabPlacement$1.INSTANCE);
    private static final float FabSpacing = Dp.m3673constructorimpl(16);

    /* JADX WARN: Removed duplicated region for block: B:108:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:294:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x013f  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Scaffold-27mzLpw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1118Scaffold27mzLpw(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r40, @org.jetbrains.annotations.Nullable androidx.compose.material.ScaffoldState r41, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r42, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r43, @org.jetbrains.annotations.Nullable h9.q<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r44, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r45, int r46, boolean r47, @org.jetbrains.annotations.Nullable h9.q<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r48, boolean r49, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r50, float r51, long r52, long r54, long r56, long r58, long r60, @org.jetbrains.annotations.NotNull h9.q<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r62, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r63, int r64, int r65, int r66) {
        /*
            Method dump skipped, instruction units count: 1255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ScaffoldKt.m1118Scaffold27mzLpw(androidx.compose.ui.Modifier, androidx.compose.material.ScaffoldState, h9.p, h9.p, h9.q, h9.p, int, boolean, h9.q, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, long, long, h9.q, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @UiComposable
    /* JADX INFO: renamed from: ScaffoldLayout-MDYNRJg, reason: not valid java name */
    public static final void m1119ScaffoldLayoutMDYNRJg(boolean z10, int i10, p<? super Composer, ? super Integer, k0> pVar, q<? super PaddingValues, ? super Composer, ? super Integer, k0> qVar, p<? super Composer, ? super Integer, k0> pVar2, p<? super Composer, ? super Integer, k0> pVar3, p<? super Composer, ? super Integer, k0> pVar4, Composer composer, int i11) {
        int i12;
        int i13;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1401632215);
        int i14 = (i11 & 14) == 0 ? (composerStartRestartGroup.changed(z10) ? 4 : 2) | i11 : i11;
        if ((i11 & 112) == 0) {
            i14 |= composerStartRestartGroup.changed(i10) ? 32 : 16;
        }
        if ((i11 & 896) == 0) {
            i14 |= composerStartRestartGroup.changed(pVar) ? 256 : 128;
        }
        if ((i11 & 7168) == 0) {
            i14 |= composerStartRestartGroup.changed(qVar) ? 2048 : 1024;
        }
        if ((57344 & i11) == 0) {
            i14 |= composerStartRestartGroup.changed(pVar2) ? 16384 : 8192;
        }
        if ((458752 & i11) == 0) {
            i14 |= composerStartRestartGroup.changed(pVar3) ? 131072 : 65536;
        }
        if ((3670016 & i11) == 0) {
            i14 |= composerStartRestartGroup.changed(pVar4) ? 1048576 : 524288;
        }
        int i15 = i14;
        if ((i15 & 2995931) == 599186 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            Object[] objArr = {pVar, pVar2, pVar3, FabPosition.m1031boximpl(i10), Boolean.valueOf(z10), pVar4, qVar};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            boolean zChanged = false;
            for (int i16 = 0; i16 < 7; i16++) {
                zChanged |= composerStartRestartGroup.changed(objArr[i16]);
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                i12 = 1;
                i13 = 0;
                ScaffoldKt$ScaffoldLayout$1$1 scaffoldKt$ScaffoldLayout$1$1 = new ScaffoldKt$ScaffoldLayout$1$1(pVar, pVar2, pVar3, i10, z10, pVar4, i15, qVar);
                composerStartRestartGroup.updateRememberedValue(scaffoldKt$ScaffoldLayout$1$1);
                objRememberedValue = scaffoldKt$ScaffoldLayout$1$1;
            } else {
                i12 = 1;
                i13 = 0;
            }
            composerStartRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(null, (p) objRememberedValue, composerStartRestartGroup, i13, i12);
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new ScaffoldKt$ScaffoldLayout$2(z10, i10, pVar, qVar, pVar2, pVar3, pVar4, i11));
    }

    @NotNull
    public static final ProvidableCompositionLocal<FabPlacement> getLocalFabPlacement() {
        return LocalFabPlacement;
    }

    @Composable
    @NotNull
    public static final ScaffoldState rememberScaffoldState(@Nullable DrawerState drawerState, @Nullable SnackbarHostState snackbarHostState, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(1569641925);
        if ((i11 & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, null, composer, 6, 2);
        }
        if ((i11 & 2) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) objRememberedValue;
        }
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new ScaffoldState(drawerState, snackbarHostState);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        ScaffoldState scaffoldState = (ScaffoldState) objRememberedValue2;
        composer.endReplaceableGroup();
        return scaffoldState;
    }
}
