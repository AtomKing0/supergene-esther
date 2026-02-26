package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer;

import android.graphics.Bitmap;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class s implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public String f21636a;

    public static final class a extends v implements h9.p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ h9.p<Composer, Integer, k0> f21637g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f21638h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(h9.p<? super Composer, ? super Integer, k0> pVar, int i10) {
            super(2);
            this.f21637g = pVar;
            this.f21638h = i10;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void a(@Nullable Composer composer, int i10) {
            if ((i10 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(652818811, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.WatermarkImpl.ApplyWatermark.<anonymous> (Watermark.kt:46)");
            }
            this.f21637g.mo4invoke(composer, Integer.valueOf(this.f21638h & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    public static final class b extends v implements h9.p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ h9.p<Composer, Integer, k0> f21640h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f21641i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(h9.p<? super Composer, ? super Integer, k0> pVar, int i10) {
            super(2);
            this.f21640h = pVar;
            this.f21641i = i10;
        }

        public final void a(@Nullable Composer composer, int i10) {
            s.this.a(this.f21640h, composer, this.f21641i | 1);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    public s(@Nullable String str) {
        this.f21636a = str;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public void a(@NotNull h9.p<? super Composer, ? super Integer, k0> content, @Nullable Composer composer, int i10) {
        kotlin.jvm.internal.t.i(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1557485728);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1557485728, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.WatermarkImpl.ApplyWatermark (Watermark.kt:45)");
        }
        t.b(this.f21636a, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 652818811, true, new a(content, i10)), composerStartRestartGroup, 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new b(content, i10));
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r
    public void a(@NotNull View view) {
        kotlin.jvm.internal.t.i(view, "view");
        Bitmap bitmapA = t.a(this.f21636a);
        if (bitmapA == null) {
            return;
        }
        com.moloco.sdk.service_locator.a aVar = com.moloco.sdk.service_locator.a.f18869a;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.a().getResources(), bitmapA);
        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
        bitmapDrawable.setTileModeXY(tileMode, tileMode);
        bitmapDrawable.setTargetDensity(aVar.a().getResources().getDisplayMetrics());
        view.setForeground(bitmapDrawable);
        view.setClickable(false);
        view.setFocusable(false);
    }
}
