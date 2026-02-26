package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme;

import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final Colors f20053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final Colors f20054b;

    public static final class a extends v implements p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f20055g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ p<Composer, Integer, k0> f20056h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f20057i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f20058j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(boolean z10, p<? super Composer, ? super Integer, k0> pVar, int i10, int i11) {
            super(2);
            this.f20055g = z10;
            this.f20056h = pVar;
            this.f20057i = i10;
            this.f20058j = i11;
        }

        public final void a(@Nullable Composer composer, int i10) {
            c.a(this.f20055g, this.f20056h, composer, this.f20057i | 1, this.f20058j);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    static {
        long jA = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.a.a();
        long jA2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.a.a();
        Color.Companion companion = Color.Companion;
        f20053a = ColorsKt.m971darkColors2qZNXz8$default(jA, jA2, companion.m1635getWhite0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 4088, null);
        f20054b = ColorsKt.m972lightColors2qZNXz8((4095 & 1) != 0 ? ColorKt.Color(4284612846L) : com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.a.a(), (4095 & 2) != 0 ? ColorKt.Color(4281794739L) : com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.a.a(), (4095 & 4) != 0 ? ColorKt.Color(4278442694L) : companion.m1635getWhite0d7_KjU(), (4095 & 8) != 0 ? ColorKt.Color(4278290310L) : 0L, (4095 & 16) != 0 ? Color.Companion.m1635getWhite0d7_KjU() : 0L, (4095 & 32) != 0 ? Color.Companion.m1635getWhite0d7_KjU() : 0L, (4095 & 64) != 0 ? ColorKt.Color(4289724448L) : 0L, (4095 & 128) != 0 ? Color.Companion.m1635getWhite0d7_KjU() : 0L, (4095 & 256) != 0 ? Color.Companion.m1624getBlack0d7_KjU() : 0L, (4095 & 512) != 0 ? Color.Companion.m1624getBlack0d7_KjU() : 0L, (4095 & 1024) != 0 ? Color.Companion.m1624getBlack0d7_KjU() : 0L, (4095 & 2048) != 0 ? Color.Companion.m1635getWhite0d7_KjU() : 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009a  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[0[0]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(boolean r8, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r9, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r10, int r11, int r12) {
        /*
            java.lang.String r0 = "content"
            kotlin.jvm.internal.t.i(r9, r0)
            r0 = -1535794432(0xffffffffa475a300, float:-5.3263973E-17)
            androidx.compose.runtime.Composer r10 = r10.startRestartGroup(r0)
            r1 = r11 & 14
            if (r1 != 0) goto L1f
            r1 = r12 & 1
            if (r1 != 0) goto L1c
            boolean r1 = r10.changed(r8)
            if (r1 == 0) goto L1c
            r1 = 4
            goto L1d
        L1c:
            r1 = 2
        L1d:
            r1 = r1 | r11
            goto L20
        L1f:
            r1 = r11
        L20:
            r2 = r12 & 2
            if (r2 == 0) goto L27
            r1 = r1 | 48
            goto L37
        L27:
            r2 = r11 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L37
            boolean r2 = r10.changed(r9)
            if (r2 == 0) goto L34
            r2 = 32
            goto L36
        L34:
            r2 = 16
        L36:
            r1 = r1 | r2
        L37:
            r2 = r1 & 91
            r3 = 18
            if (r2 != r3) goto L48
            boolean r2 = r10.getSkipping()
            if (r2 != 0) goto L44
            goto L48
        L44:
            r10.skipToGroupEnd()
            goto L9d
        L48:
            r10.startDefaults()
            r2 = r11 & 1
            if (r2 == 0) goto L5e
            boolean r2 = r10.getDefaultsInvalid()
            if (r2 == 0) goto L56
            goto L5e
        L56:
            r10.skipToGroupEnd()
            r2 = r12 & 1
            if (r2 == 0) goto L69
            goto L67
        L5e:
            r2 = r12 & 1
            if (r2 == 0) goto L69
            r8 = 0
            boolean r8 = androidx.compose.foundation.DarkThemeKt.isSystemInDarkTheme(r10, r8)
        L67:
            r1 = r1 & (-15)
        L69:
            r10.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L78
            r2 = -1
            java.lang.String r3 = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.Theme (Theme.kt:31)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r2, r3)
        L78:
            if (r8 == 0) goto L7d
            androidx.compose.material.Colors r0 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.c.f20053a
            goto L7f
        L7d:
            androidx.compose.material.Colors r0 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.c.f20054b
        L7f:
            androidx.compose.material.Typography r2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.d.a()
            androidx.compose.material.Shapes r3 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.b.a()
            int r1 = r1 << 6
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r6 = r1 | 432(0x1b0, float:6.05E-43)
            r7 = 0
            r1 = r0
            r4 = r9
            r5 = r10
            androidx.compose.material.MaterialThemeKt.MaterialTheme(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L9d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L9d:
            androidx.compose.runtime.ScopeUpdateScope r10 = r10.endRestartGroup()
            if (r10 != 0) goto La4
            goto Lac
        La4:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.c$a r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.c$a
            r0.<init>(r8, r9, r11, r12)
            r10.updateScope(r0)
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.c.a(boolean, h9.p, androidx.compose.runtime.Composer, int, int):void");
    }
}
