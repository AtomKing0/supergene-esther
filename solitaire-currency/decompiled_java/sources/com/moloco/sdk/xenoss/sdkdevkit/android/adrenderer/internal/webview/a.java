package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.a$a, reason: collision with other inner class name */
    public static final class C0472a extends v implements l<Context, FrameLayout> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ WebView f21518g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0472a(WebView webView) {
            super(1);
            this.f21518g = webView;
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final FrameLayout invoke(@NotNull Context it) {
            t.i(it, "it");
            FrameLayout frameLayout = new FrameLayout(it);
            WebView webView = this.f21518g;
            webView.setBackgroundColor(0);
            webView.setVisibility(0);
            frameLayout.addView(webView, new ViewGroup.LayoutParams(-1, -1));
            return frameLayout;
        }
    }

    public static final class b extends v implements p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ k0 f21519g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(k0 k0Var) {
            super(2);
            this.f21519g = k0Var;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void a(@Nullable Composer composer, int i10) {
            if ((i10 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1018657295, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.AdWebView.<anonymous>.<anonymous> (AdWebView.kt:40)");
            }
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

    public static final class c extends v implements l<DisposableEffectScope, DisposableEffectResult> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ WebView f21520g;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.a$c$a, reason: collision with other inner class name */
        public static final class C0473a implements DisposableEffectResult {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ WebView f21521a;

            public C0473a(WebView webView) {
                this.f21521a = webView;
            }

            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                ViewParent parent = this.f21521a.getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null) {
                    viewGroup.removeView(this.f21521a);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(WebView webView) {
            super(1);
            this.f21520g = webView;
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
            t.i(DisposableEffect, "$this$DisposableEffect");
            return new C0473a(this.f21520g);
        }
    }

    public static final class d extends v implements p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ WebView f21522g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Modifier f21523h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ r f21524i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f21525j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ int f21526k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(WebView webView, Modifier modifier, r rVar, int i10, int i11) {
            super(2);
            this.f21522g = webView;
            this.f21523h = modifier;
            this.f21524i = rVar;
            this.f21525j = i10;
            this.f21526k = i11;
        }

        public final void a(@Nullable Composer composer, int i10) {
            a.a(this.f21522g, this.f21523h, this.f21524i, composer, this.f21525j | 1, this.f21526k);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void a(@NotNull WebView webView, @Nullable Modifier modifier, @Nullable r rVar, @Nullable Composer composer, int i10, int i11) {
        t.i(webView, "webView");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1111633024);
        if ((i11 & 2) != 0) {
            modifier = Modifier.Companion;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1111633024, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.AdWebView (AdWebView.kt:13)");
        }
        composerStartRestartGroup.startReplaceableGroup(-1335812377);
        AndroidView_androidKt.AndroidView(new C0472a(webView), modifier, null, composerStartRestartGroup, i10 & 112, 4);
        k0 k0Var = k0.f35197a;
        if (rVar != null) {
            rVar.a(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1018657295, true, new b(k0Var)), composerStartRestartGroup, ((i10 >> 3) & 112) | 6);
        }
        composerStartRestartGroup.endReplaceableGroup();
        EffectsKt.DisposableEffect(webView, new c(webView), composerStartRestartGroup, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new d(webView, modifier, rVar, i10, i11));
    }
}
