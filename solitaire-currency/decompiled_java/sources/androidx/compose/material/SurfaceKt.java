package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;

/* JADX INFO: compiled from: Surface.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SurfaceKt {
    /* JADX WARN: Removed duplicated region for block: B:108:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:208:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012c  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Surface-9VG74zQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1146Surface9VG74zQ(@org.jetbrains.annotations.NotNull h9.a<v8.k0> r38, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r39, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r40, long r41, long r43, @org.jetbrains.annotations.Nullable androidx.compose.foundation.BorderStroke r45, float r46, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r47, @org.jetbrains.annotations.Nullable androidx.compose.foundation.Indication r48, boolean r49, @org.jetbrains.annotations.Nullable java.lang.String r50, @org.jetbrains.annotations.Nullable androidx.compose.ui.semantics.Role r51, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r52, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r53, int r54, int r55, int r56) {
        /*
            Method dump skipped, instruction units count: 884
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt.m1146Surface9VG74zQ(h9.a, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.foundation.BorderStroke, float, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.foundation.Indication, boolean, java.lang.String, androidx.compose.ui.semantics.Role, h9.p, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0133  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Surface-F-jzlyU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1147SurfaceFjzlyU(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r22, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r23, long r24, long r26, @org.jetbrains.annotations.Nullable androidx.compose.foundation.BorderStroke r28, float r29, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r30, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            Method dump skipped, instruction units count: 481
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt.m1147SurfaceFjzlyU(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.foundation.BorderStroke, float, h9.p, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010d  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Surface-LPr_se0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1148SurfaceLPr_se0(@org.jetbrains.annotations.NotNull h9.a<v8.k0> r29, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r30, boolean r31, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r32, long r33, long r35, @org.jetbrains.annotations.Nullable androidx.compose.foundation.BorderStroke r37, float r38, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r39, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r40, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r41, int r42, int r43) {
        /*
            Method dump skipped, instruction units count: 679
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt.m1148SurfaceLPr_se0(h9.a, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.foundation.BorderStroke, float, androidx.compose.foundation.interaction.MutableInteractionSource, h9.p, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:175:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011d  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Surface-Ny5ogXk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1149SurfaceNy5ogXk(boolean r32, @org.jetbrains.annotations.NotNull h9.a<v8.k0> r33, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r34, boolean r35, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r36, long r37, long r39, @org.jetbrains.annotations.Nullable androidx.compose.foundation.BorderStroke r41, float r42, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r43, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r44, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r45, int r46, int r47, int r48) {
        /*
            Method dump skipped, instruction units count: 740
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt.m1149SurfaceNy5ogXk(boolean, h9.a, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.foundation.BorderStroke, float, androidx.compose.foundation.interaction.MutableInteractionSource, h9.p, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: surface-8ww4TTg, reason: not valid java name */
    public static final Modifier m1153surface8ww4TTg(Modifier modifier, Shape shape, long j10, BorderStroke borderStroke, float f10) {
        return ClipKt.clip(BackgroundKt.m165backgroundbw27NRU(ShadowKt.m1296shadows4CzXII$default(modifier, f10, shape, false, 0L, 0L, 24, null).then(borderStroke != null ? BorderKt.border(Modifier.Companion, borderStroke, shape) : Modifier.Companion), j10, shape), shape);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    /* JADX INFO: renamed from: surfaceColorAtElevation-cq6XJ1M, reason: not valid java name */
    public static final long m1154surfaceColorAtElevationcq6XJ1M(long j10, ElevationOverlay elevationOverlay, float f10, Composer composer, int i10) {
        composer.startReplaceableGroup(1561611256);
        if (Color.m1599equalsimpl0(j10, MaterialTheme.INSTANCE.getColors(composer, 6).m955getSurface0d7_KjU()) && elevationOverlay != null) {
            j10 = elevationOverlay.mo985apply7g2Lkgo(j10, f10, composer, (i10 & 14) | ((i10 >> 3) & 112) | ((i10 << 3) & 896));
        }
        composer.endReplaceableGroup();
        return j10;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:175:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011d  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: Surface-Ny5ogXk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1150SurfaceNy5ogXk(boolean r32, @org.jetbrains.annotations.NotNull h9.l<? super java.lang.Boolean, v8.k0> r33, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r34, boolean r35, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r36, long r37, long r39, @org.jetbrains.annotations.Nullable androidx.compose.foundation.BorderStroke r41, float r42, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r43, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r44, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r45, int r46, int r47, int r48) {
        /*
            Method dump skipped, instruction units count: 740
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt.m1150SurfaceNy5ogXk(boolean, h9.l, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.foundation.BorderStroke, float, androidx.compose.foundation.interaction.MutableInteractionSource, h9.p, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
