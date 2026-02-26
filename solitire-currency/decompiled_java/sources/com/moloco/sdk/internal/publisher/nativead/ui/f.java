package com.moloco.sdk.internal.publisher.nativead.ui;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.res.PainterResources_androidKt;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.k;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import h9.l;
import h9.p;
import h9.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class f {
    @Composable
    @NotNull
    public static final u<BoxScope, Boolean, Boolean, p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, k0>, l<? super Boolean, k0>, Composer, Integer, k0> a(@Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(-314360066);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-314360066, i10, -1, "com.moloco.sdk.internal.publisher.nativead.ui.nativeVideoMuteButton (NativeVideoMuteButton.kt:11)");
        }
        u<BoxScope, Boolean, Boolean, p<? super a.AbstractC0481a.c, ? super a.AbstractC0481a.c.EnumC0483a, k0>, l<? super Boolean, k0>, Composer, Integer, k0> uVarE = k.e(0L, 0L, null, 0L, Alignment.Companion.getTopStart(), null, Color.Companion.m1635getWhite0d7_KjU(), PainterResources_androidKt.painterResource(com.moloco.sdk.p.f18862j, composer, 0), PainterResources_androidKt.painterResource(com.moloco.sdk.p.f18863k, composer, 0), null, composer, 152592384, 559);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return uVarE;
    }
}
