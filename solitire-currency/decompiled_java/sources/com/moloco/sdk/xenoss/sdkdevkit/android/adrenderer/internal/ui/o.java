package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.MaterialTheme;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.res.PainterResources_androidKt;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.m;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.c0;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class o {
    @Composable
    @NotNull
    public static final m a(@Nullable Painter painter, long j10, @Nullable Shape shape, long j11, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(571957227);
        Painter painterPainterResource = (i11 & 1) != 0 ? PainterResources_androidKt.painterResource(com.moloco.sdk.p.f18853a, composer, 0) : painter;
        long jB = (i11 & 2) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b() : j10;
        Shape shapeE = (i11 & 4) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.e() : shape;
        long jD = (i11 & 8) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.d() : j11;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(571957227, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.adCloseAfterCountdownIcon (DefaultAdCloseCountdownButton.kt:44)");
        }
        m.b bVar = new m.b(painterPainterResource, "Close", jB, shapeE, jD, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return bVar;
    }

    @Composable
    @NotNull
    public static final h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0> b(@Nullable Alignment alignment, @Nullable PaddingValues paddingValues, long j10, long j11, long j12, @Nullable m mVar, @Nullable h9.a<k0> aVar, @Nullable com.moloco.sdk.internal.ortb.model.i iVar, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(-449222014);
        Alignment topEnd = (i11 & 1) != 0 ? Alignment.Companion.getTopEnd() : alignment;
        PaddingValues paddingValuesM392PaddingValues0680j_4 = (i11 & 2) != 0 ? PaddingKt.m392PaddingValues0680j_4(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.a()) : paddingValues;
        long jM951getPrimary0d7_KjU = (i11 & 4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m951getPrimary0d7_KjU() : j10;
        long jB = (i11 & 8) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b() : j11;
        long jC = (i11 & 16) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.c() : j12;
        m mVarA = (i11 & 32) != 0 ? a(null, 0L, null, 0L, composer, 0, 15) : mVar;
        h9.a<k0> aVar2 = (i11 & 64) != 0 ? null : aVar;
        com.moloco.sdk.internal.ortb.model.i iVar2 = (i11 & 128) == 0 ? iVar : null;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-449222014, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultAdCloseCountdownButton (DefaultAdCloseCountdownButton.kt:22)");
        }
        int i12 = i10 << 3;
        h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0> bVarA = f.a(topEnd, paddingValuesM392PaddingValues0680j_4, jM951getPrimary0d7_KjU, jB, jC, mVarA, a.AbstractC0481a.c.EnumC0483a.CLOSE, aVar2, iVar2, composer, (i10 & 14) | 1572864 | (i10 & 112) | (i10 & 896) | (i10 & 7168) | (57344 & i10) | (458752 & i10) | (29360128 & i12) | (i12 & 234881024));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return bVarA;
    }
}
