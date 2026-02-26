package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.o;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import h9.l;
import h9.p;
import h9.q;
import h9.w;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.y;
import v8.c0;
import v8.k0;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f21527a = Dp.m3673constructorimpl(12);

    public static final class a extends v implements h9.a<k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ MutableState<Boolean> f21528g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MutableState<Boolean> mutableState) {
            super(0);
            this.f21528g = mutableState;
        }

        public final void b() {
            this.f21528g.setValue(Boolean.TRUE);
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            b();
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$b, reason: collision with other inner class name */
    public static final class C0474b extends v implements p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ WebView f21529g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f21530h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ MutableState<Boolean> f21531i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ l<a.AbstractC0481a.c, k0> f21532j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f21533k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ Modifier f21534l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ long f21535m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0> f21536n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ r f21537o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ float f21538p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ boolean f21539q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final /* synthetic */ int f21540r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final /* synthetic */ int f21541s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final /* synthetic */ int f21542t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C0474b(WebView webView, int i10, MutableState<Boolean> mutableState, l<? super a.AbstractC0481a.c, k0> lVar, h9.a<k0> aVar, Modifier modifier, long j10, h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0> bVar, r rVar, float f10, boolean z10, int i11, int i12, int i13) {
            super(2);
            this.f21529g = webView;
            this.f21530h = i10;
            this.f21531i = mutableState;
            this.f21532j = lVar;
            this.f21533k = aVar;
            this.f21534l = modifier;
            this.f21535m = j10;
            this.f21536n = bVar;
            this.f21537o = rVar;
            this.f21538p = f10;
            this.f21539q = z10;
            this.f21540r = i11;
            this.f21541s = i12;
            this.f21542t = i13;
        }

        public final void a(@Nullable Composer composer, int i10) {
            b.g(this.f21529g, this.f21530h, this.f21531i, this.f21532j, this.f21533k, this.f21534l, this.f21535m, this.f21536n, this.f21537o, this.f21538p, this.f21539q, composer, this.f21540r | 1, this.f21541s, this.f21542t);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    public static final class c extends v implements q<i.a, Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ w<Context, WebView, Integer, y<Boolean>, l<? super a.AbstractC0481a.c, k0>, h9.a<k0>, r, Dp, Boolean, View> f21543g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ WebView f21544h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f21545i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ y<Boolean> f21546j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ l<a.AbstractC0481a.c, k0> f21547k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ r f21548l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f21549m;

        public static final class a extends v implements l<Context, View> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ w<Context, WebView, Integer, y<Boolean>, l<? super a.AbstractC0481a.c, k0>, h9.a<k0>, r, Dp, Boolean, View> f21550g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ WebView f21551h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ int f21552i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public final /* synthetic */ y<Boolean> f21553j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ l<a.AbstractC0481a.c, k0> f21554k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ r f21555l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final /* synthetic */ h9.a<k0> f21556m;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$c$a$a, reason: collision with other inner class name */
            public static final class C0475a extends v implements h9.a<k0> {

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                public final /* synthetic */ y<Boolean> f21557g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                public final /* synthetic */ h9.a<k0> f21558h;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0475a(y<Boolean> yVar, h9.a<k0> aVar) {
                    super(0);
                    this.f21557g = yVar;
                    this.f21558h = aVar;
                }

                public final void b() {
                    b.h(this.f21557g, this.f21558h);
                }

                @Override // h9.a
                public /* bridge */ /* synthetic */ k0 invoke() {
                    b();
                    return k0.f35197a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(w<? super Context, ? super WebView, ? super Integer, ? super y<Boolean>, ? super l<? super a.AbstractC0481a.c, k0>, ? super h9.a<k0>, ? super r, ? super Dp, ? super Boolean, ? extends View> wVar, WebView webView, int i10, y<Boolean> yVar, l<? super a.AbstractC0481a.c, k0> lVar, r rVar, h9.a<k0> aVar) {
                super(1);
                this.f21550g = wVar;
                this.f21551h = webView;
                this.f21552i = i10;
                this.f21553j = yVar;
                this.f21554k = lVar;
                this.f21555l = rVar;
                this.f21556m = aVar;
            }

            @Override // h9.l
            @NotNull
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final View invoke(@NotNull Context it) {
                t.i(it, "it");
                w<Context, WebView, Integer, y<Boolean>, l<? super a.AbstractC0481a.c, k0>, h9.a<k0>, r, Dp, Boolean, View> wVar = this.f21550g;
                WebView webView = this.f21551h;
                Integer numValueOf = Integer.valueOf(this.f21552i);
                y<Boolean> yVar = this.f21553j;
                return wVar.invoke(it, webView, numValueOf, yVar, this.f21554k, new C0475a(yVar, this.f21556m), this.f21555l, Dp.m3671boximpl(b.a()), Boolean.TRUE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(w<? super Context, ? super WebView, ? super Integer, ? super y<Boolean>, ? super l<? super a.AbstractC0481a.c, k0>, ? super h9.a<k0>, ? super r, ? super Dp, ? super Boolean, ? extends View> wVar, WebView webView, int i10, y<Boolean> yVar, l<? super a.AbstractC0481a.c, k0> lVar, r rVar, h9.a<k0> aVar) {
            super(3);
            this.f21543g = wVar;
            this.f21544h = webView;
            this.f21545i = i10;
            this.f21546j = yVar;
            this.f21547k = lVar;
            this.f21548l = rVar;
            this.f21549m = aVar;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void a(@Nullable i.a aVar, @Nullable Composer composer, int i10) {
            int i11;
            if ((i10 & 14) == 0) {
                i11 = (composer.changed(aVar) ? 4 : 2) | i10;
            } else {
                i11 = i10;
            }
            if ((i11 & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1935552634, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.MraidAdContainerScreen.<anonymous>.<anonymous> (AdWebViewRenderer.kt:219)");
            }
            if (aVar instanceof i.a.C0434a) {
                composer.startReplaceableGroup(1878992711);
                composer.endReplaceableGroup();
            } else if (aVar instanceof i.a.c) {
                composer.startReplaceableGroup(1878992774);
                composer.endReplaceableGroup();
            } else if (aVar instanceof i.a.b) {
                composer.startReplaceableGroup(1878992854);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.c.b(((i.a.b) aVar).b(), null, null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), composer, 3504, 0);
                composer.endReplaceableGroup();
            } else if (aVar instanceof i.a.d) {
                composer.startReplaceableGroup(1878993130);
                AndroidView_androidKt.AndroidView(new a(this.f21543g, this.f21544h, this.f21545i, this.f21546j, this.f21547k, this.f21548l, this.f21549m), null, null, composer, 0, 6);
                composer.endReplaceableGroup();
            } else if (aVar == null) {
                composer.startReplaceableGroup(1878993738);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(1878993754);
                composer.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(i.a aVar, Composer composer, Integer num) {
            a(aVar, composer, num.intValue());
            return k0.f35197a;
        }
    }

    public static final class d extends v implements h9.a<k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ y<Boolean> f21559g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f21560h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(y<Boolean> yVar, h9.a<k0> aVar) {
            super(0);
            this.f21559g = yVar;
            this.f21560h = aVar;
        }

        public final void b() {
            b.h(this.f21559g, this.f21560h);
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            b();
            return k0.f35197a;
        }
    }

    public static final class e extends v implements p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Activity f21561g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i f21562h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ WebView f21563i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f21564j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ l<a.AbstractC0481a.c, k0> f21565k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f21566l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ w<Context, WebView, Integer, y<Boolean>, l<? super a.AbstractC0481a.c, k0>, h9.a<k0>, r, Dp, Boolean, View> f21567m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ r f21568n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0> f21569o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0> f21570p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ int f21571q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public e(Activity activity, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i iVar, WebView webView, int i10, l<? super a.AbstractC0481a.c, k0> lVar, h9.a<k0> aVar, w<? super Context, ? super WebView, ? super Integer, ? super y<Boolean>, ? super l<? super a.AbstractC0481a.c, k0>, ? super h9.a<k0>, ? super r, ? super Dp, ? super Boolean, ? extends View> wVar, r rVar, h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0> bVar, h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0> bVar2, int i11) {
            super(2);
            this.f21561g = activity;
            this.f21562h = iVar;
            this.f21563i = webView;
            this.f21564j = i10;
            this.f21565k = lVar;
            this.f21566l = aVar;
            this.f21567m = wVar;
            this.f21568n = rVar;
            this.f21569o = bVar;
            this.f21570p = bVar2;
            this.f21571q = i11;
        }

        public final void a(@Nullable Composer composer, int i10) {
            b.f(this.f21561g, this.f21562h, this.f21563i, this.f21564j, this.f21565k, this.f21566l, this.f21567m, this.f21568n, this.f21569o, this.f21570p, composer, this.f21571q | 1);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    public static final class f extends v implements l<Context, View> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ w<Context, WebView, Integer, y<Boolean>, l<? super a.AbstractC0481a.c, k0>, h9.a<k0>, r, Dp, Boolean, View> f21572g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ WebView f21573h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f21574i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ y<Boolean> f21575j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ l<a.AbstractC0481a.c, k0> f21576k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ r f21577l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f21578m;

        public static final class a extends v implements h9.a<k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ y<Boolean> f21579g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ h9.a<k0> f21580h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(y<Boolean> yVar, h9.a<k0> aVar) {
                super(0);
                this.f21579g = yVar;
                this.f21580h = aVar;
            }

            public final void b() {
                b.j(this.f21579g, this.f21580h);
            }

            @Override // h9.a
            public /* bridge */ /* synthetic */ k0 invoke() {
                b();
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public f(w<? super Context, ? super WebView, ? super Integer, ? super y<Boolean>, ? super l<? super a.AbstractC0481a.c, k0>, ? super h9.a<k0>, ? super r, ? super Dp, ? super Boolean, ? extends View> wVar, WebView webView, int i10, y<Boolean> yVar, l<? super a.AbstractC0481a.c, k0> lVar, r rVar, h9.a<k0> aVar) {
            super(1);
            this.f21572g = wVar;
            this.f21573h = webView;
            this.f21574i = i10;
            this.f21575j = yVar;
            this.f21576k = lVar;
            this.f21577l = rVar;
            this.f21578m = aVar;
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final View invoke(@NotNull Context it) {
            t.i(it, "it");
            w<Context, WebView, Integer, y<Boolean>, l<? super a.AbstractC0481a.c, k0>, h9.a<k0>, r, Dp, Boolean, View> wVar = this.f21572g;
            WebView webView = this.f21573h;
            Integer numValueOf = Integer.valueOf(this.f21574i);
            y<Boolean> yVar = this.f21575j;
            return wVar.invoke(it, webView, numValueOf, yVar, this.f21576k, new a(yVar, this.f21578m), this.f21577l, Dp.m3671boximpl(b.a()), Boolean.FALSE);
        }
    }

    public static final class g extends v implements h9.a<k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ y<Boolean> f21581g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f21582h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(y<Boolean> yVar, h9.a<k0> aVar) {
            super(0);
            this.f21581g = yVar;
            this.f21582h = aVar;
        }

        public final void b() {
            b.j(this.f21581g, this.f21582h);
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            b();
            return k0.f35197a;
        }
    }

    public static final class h extends v implements p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Activity f21583g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ WebView f21584h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f21585i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ l<a.AbstractC0481a.c, k0> f21586j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f21587k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ w<Context, WebView, Integer, y<Boolean>, l<? super a.AbstractC0481a.c, k0>, h9.a<k0>, r, Dp, Boolean, View> f21588l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ r f21589m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ int f21590n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public h(Activity activity, WebView webView, int i10, l<? super a.AbstractC0481a.c, k0> lVar, h9.a<k0> aVar, w<? super Context, ? super WebView, ? super Integer, ? super y<Boolean>, ? super l<? super a.AbstractC0481a.c, k0>, ? super h9.a<k0>, ? super r, ? super Dp, ? super Boolean, ? extends View> wVar, r rVar, int i11) {
            super(2);
            this.f21583g = activity;
            this.f21584h = webView;
            this.f21585i = i10;
            this.f21586j = lVar;
            this.f21587k = aVar;
            this.f21588l = wVar;
            this.f21589m = rVar;
            this.f21590n = i11;
        }

        public final void a(@Nullable Composer composer, int i10) {
            b.e(this.f21583g, this.f21584h, this.f21585i, this.f21586j, this.f21587k, this.f21588l, this.f21589m, composer, this.f21590n | 1);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return k0.f35197a;
        }
    }

    public static final class i extends v implements p<Composer, Integer, h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<? extends k0>, ? super l<? super a.AbstractC0481a.c, ? extends k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, ? extends k0>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final i f21591g = new i();

        public i() {
            super(2);
        }

        @Composable
        @NotNull
        public final h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0> a(@Nullable Composer composer, int i10) {
            composer.startReplaceableGroup(-189169605);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-189169605, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.defaultAdWebViewRenderer.<anonymous> (AdWebViewRenderer.kt:142)");
            }
            h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0> bVarB = o.b(null, null, 0L, 0L, 0L, null, null, null, composer, 0, 255);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return bVarB;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<? extends k0>, ? super l<? super a.AbstractC0481a.c, ? extends k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, ? extends k0> mo4invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    public static final class j extends v implements w<Context, WebView, Integer, y<Boolean>, l<? super a.AbstractC0481a.c, ? extends k0>, h9.a<? extends k0>, r, Dp, Boolean, ComposeView> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ long f21592g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ p<Composer, Integer, h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0>> f21593h;

        public static final class a extends v implements p<Composer, Integer, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ WebView f21594g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ int f21595h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ l<a.AbstractC0481a.c, k0> f21596i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public final /* synthetic */ h9.a<k0> f21597j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ long f21598k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ p<Composer, Integer, h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0>> f21599l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final /* synthetic */ r f21600m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public final /* synthetic */ float f21601n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public final /* synthetic */ boolean f21602o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public final /* synthetic */ y<Boolean> f21603p;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$j$a$a, reason: collision with other inner class name */
            public static final class C0476a extends v implements p<Composer, Integer, k0> {

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                public final /* synthetic */ WebView f21604g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                public final /* synthetic */ int f21605h;

                /* JADX INFO: renamed from: i, reason: collision with root package name */
                public final /* synthetic */ l<a.AbstractC0481a.c, k0> f21606i;

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public final /* synthetic */ h9.a<k0> f21607j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public final /* synthetic */ long f21608k;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                public final /* synthetic */ p<Composer, Integer, h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0>> f21609l;

                /* JADX INFO: renamed from: m, reason: collision with root package name */
                public final /* synthetic */ r f21610m;

                /* JADX INFO: renamed from: n, reason: collision with root package name */
                public final /* synthetic */ float f21611n;

                /* JADX INFO: renamed from: o, reason: collision with root package name */
                public final /* synthetic */ boolean f21612o;

                /* JADX INFO: renamed from: p, reason: collision with root package name */
                public final /* synthetic */ y<Boolean> f21613p;

                /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$j$a$a$a, reason: collision with other inner class name */
                @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.AdWebViewRendererKt$defaultAdWebViewRenderer$2$1$1$1$1", f = "AdWebViewRenderer.kt", l = {157}, m = "invokeSuspend")
                public static final class C0477a extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {

                    /* JADX INFO: renamed from: j, reason: collision with root package name */
                    public int f21614j;

                    /* JADX INFO: renamed from: k, reason: collision with root package name */
                    public final /* synthetic */ MutableState<Boolean> f21615k;

                    /* JADX INFO: renamed from: l, reason: collision with root package name */
                    public final /* synthetic */ y<Boolean> f21616l;

                    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$j$a$a$a$a, reason: collision with other inner class name */
                    public static final class C0478a extends v implements h9.a<Boolean> {

                        /* JADX INFO: renamed from: g, reason: collision with root package name */
                        public final /* synthetic */ MutableState<Boolean> f21617g;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public C0478a(MutableState<Boolean> mutableState) {
                            super(0);
                            this.f21617g = mutableState;
                        }

                        @Override // h9.a
                        @NotNull
                        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                        public final Boolean invoke() {
                            return this.f21617g.getValue();
                        }
                    }

                    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$j$a$a$a$b, reason: collision with other inner class name */
                    public static final class C0479b implements s9.i<Boolean> {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ y<Boolean> f21618a;

                        public C0479b(y<Boolean> yVar) {
                            this.f21618a = yVar;
                        }

                        @Nullable
                        public final Object b(boolean z10, @NotNull z8.d<? super k0> dVar) {
                            this.f21618a.setValue(kotlin.coroutines.jvm.internal.b.a(z10));
                            return k0.f35197a;
                        }

                        @Override // s9.i
                        public /* bridge */ /* synthetic */ Object emit(Boolean bool, z8.d dVar) {
                            return b(bool.booleanValue(), dVar);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C0477a(MutableState<Boolean> mutableState, y<Boolean> yVar, z8.d<? super C0477a> dVar) {
                        super(2, dVar);
                        this.f21615k = mutableState;
                        this.f21616l = yVar;
                    }

                    @Override // h9.p
                    @Nullable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                        return ((C0477a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @NotNull
                    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                        return new C0477a(this.f21615k, this.f21616l, dVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        Object objE = a9.d.e();
                        int i10 = this.f21614j;
                        if (i10 == 0) {
                            u.b(obj);
                            s9.h hVarSnapshotFlow = SnapshotStateKt.snapshotFlow(new C0478a(this.f21615k));
                            C0479b c0479b = new C0479b(this.f21616l);
                            this.f21614j = 1;
                            if (hVarSnapshotFlow.collect(c0479b, this) == objE) {
                                return objE;
                            }
                        } else {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            u.b(obj);
                        }
                        return k0.f35197a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C0476a(WebView webView, int i10, l<? super a.AbstractC0481a.c, k0> lVar, h9.a<k0> aVar, long j10, p<? super Composer, ? super Integer, ? extends h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0>> pVar, r rVar, float f10, boolean z10, y<Boolean> yVar) {
                    super(2);
                    this.f21604g = webView;
                    this.f21605h = i10;
                    this.f21606i = lVar;
                    this.f21607j = aVar;
                    this.f21608k = j10;
                    this.f21609l = pVar;
                    this.f21610m = rVar;
                    this.f21611n = f10;
                    this.f21612o = z10;
                    this.f21613p = yVar;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void a(@Nullable Composer composer, int i10) {
                    if ((i10 & 11) == 2 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1635041213, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.defaultAdWebViewRenderer.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AdWebViewRenderer.kt:149)");
                    }
                    y<Boolean> yVar = this.f21613p;
                    composer.startReplaceableGroup(-492369756);
                    Object objRememberedValue = composer.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(yVar.getValue(), null, 2, null);
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    composer.endReplaceableGroup();
                    MutableState mutableState = (MutableState) objRememberedValue;
                    EffectsKt.LaunchedEffect(k0.f35197a, new C0477a(mutableState, this.f21613p, null), composer, 70);
                    b.g(this.f21604g, this.f21605h, mutableState, this.f21606i, this.f21607j, null, this.f21608k, this.f21609l.mo4invoke(composer, 0), this.f21610m, this.f21611n, this.f21612o, composer, 392, 0, 32);
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

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(WebView webView, int i10, l<? super a.AbstractC0481a.c, k0> lVar, h9.a<k0> aVar, long j10, p<? super Composer, ? super Integer, ? extends h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0>> pVar, r rVar, float f10, boolean z10, y<Boolean> yVar) {
                super(2);
                this.f21594g = webView;
                this.f21595h = i10;
                this.f21596i = lVar;
                this.f21597j = aVar;
                this.f21598k = j10;
                this.f21599l = pVar;
                this.f21600m = rVar;
                this.f21601n = f10;
                this.f21602o = z10;
                this.f21603p = yVar;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void a(@Nullable Composer composer, int i10) {
                if ((i10 & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(852256256, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.defaultAdWebViewRenderer.<anonymous>.<anonymous>.<anonymous> (AdWebViewRenderer.kt:148)");
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.c.a(false, ComposableLambdaKt.composableLambda(composer, 1635041213, true, new C0476a(this.f21594g, this.f21595h, this.f21596i, this.f21597j, this.f21598k, this.f21599l, this.f21600m, this.f21601n, this.f21602o, this.f21603p)), composer, 48, 1);
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public j(long j10, p<? super Composer, ? super Integer, ? extends h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0>> pVar) {
            super(9);
            this.f21592g = j10;
            this.f21593h = pVar;
        }

        @NotNull
        public final ComposeView a(@NotNull Context context, @NotNull WebView webView, int i10, @NotNull y<Boolean> canClose, @NotNull l<? super a.AbstractC0481a.c, k0> onButtonRendered, @NotNull h9.a<k0> onClose, @Nullable r rVar, float f10, boolean z10) {
            t.i(context, "context");
            t.i(webView, "webView");
            t.i(canClose, "canClose");
            t.i(onButtonRendered, "onButtonRendered");
            t.i(onClose, "onClose");
            ComposeView composeView = new ComposeView(context, null, 0, 6, null);
            long j10 = this.f21592g;
            p<Composer, Integer, h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0>> pVar = this.f21593h;
            composeView.setId(com.moloco.sdk.q.f18866a);
            composeView.setContent(ComposableLambdaKt.composableLambdaInstance(852256256, true, new a(webView, i10, onButtonRendered, onClose, j10, pVar, rVar, f10, z10, canClose)));
            return composeView;
        }

        @Override // h9.w
        public /* bridge */ /* synthetic */ ComposeView invoke(Context context, WebView webView, Integer num, y<Boolean> yVar, l<? super a.AbstractC0481a.c, ? extends k0> lVar, h9.a<? extends k0> aVar, r rVar, Dp dp, Boolean bool) {
            return a(context, webView, num.intValue(), yVar, lVar, aVar, rVar, dp.m3687unboximpl(), bool.booleanValue());
        }
    }

    public static final float a() {
        return f21527a;
    }

    public static final i.a b(State<? extends i.a> state) {
        return state.getValue();
    }

    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable:[androidx.compose.ui.UiComposable]]]")
    @NotNull
    public static final w<Context, WebView, Integer, y<Boolean>, l<? super a.AbstractC0481a.c, k0>, h9.a<k0>, r, Dp, Boolean, View> c(long j10, @NotNull p<? super Composer, ? super Integer, ? extends h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0>> adCloseCountdownButton) {
        t.i(adCloseCountdownButton, "adCloseCountdownButton");
        return new j(j10, adCloseCountdownButton);
    }

    public static /* synthetic */ w d(long j10, p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = Color.Companion.m1624getBlack0d7_KjU();
        }
        if ((i10 & 2) != 0) {
            pVar = i.f21591g;
        }
        return c(j10, pVar);
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void e(@NotNull Activity activity, @NotNull WebView webView, int i10, @NotNull l<? super a.AbstractC0481a.c, k0> onButtonRendered, @NotNull h9.a<k0> onClose, @NotNull w<? super Context, ? super WebView, ? super Integer, ? super y<Boolean>, ? super l<? super a.AbstractC0481a.c, k0>, ? super h9.a<k0>, ? super r, ? super Dp, ? super Boolean, ? extends View> adWebViewRenderer, @Nullable r rVar, @Nullable Composer composer, int i11) {
        t.i(activity, "<this>");
        t.i(webView, "webView");
        t.i(onButtonRendered, "onButtonRendered");
        t.i(onClose, "onClose");
        t.i(adWebViewRenderer, "adWebViewRenderer");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1336318846);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1336318846, i11, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.StaticAdWebViewScreen (AdWebViewRenderer.kt:265)");
        }
        Modifier modifierM166backgroundbw27NRU$default = BackgroundKt.m166backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), Color.Companion.m1624getBlack0d7_KjU(), null, 2, null);
        composerStartRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        h9.a<ComposeUiNode> constructor = companion.getConstructor();
        q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(modifierM166backgroundbw27NRU$default);
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
        Updater.m1265setimpl(composerM1258constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m1265setimpl(composerM1258constructorimpl, density, companion.getSetDensity());
        Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion.getSetLayoutDirection());
        Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
        composerStartRestartGroup.enableReusing();
        qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        composerStartRestartGroup.startReplaceableGroup(-2137368960);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        Integer numValueOf = Integer.valueOf(i10);
        composerStartRestartGroup.startReplaceableGroup(1157296644);
        boolean zChanged = composerStartRestartGroup.changed(numValueOf);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = s9.o0.a(Boolean.valueOf(i10 == 0));
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        y yVar = (y) objRememberedValue;
        AndroidView_androidKt.AndroidView(new f(adWebViewRenderer, webView, i10, yVar, onButtonRendered, rVar, onClose), null, null, composerStartRestartGroup, 0, 6);
        BackHandlerKt.BackHandler(false, new g(yVar, onClose), composerStartRestartGroup, 0, 1);
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.q.a(activity, composerStartRestartGroup, 8);
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new h(activity, webView, i10, onButtonRendered, onClose, adWebViewRenderer, rVar, i11));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][_]]")
    public static final void f(@NotNull Activity activity, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i adViewModel, @NotNull WebView webView, int i10, @NotNull l<? super a.AbstractC0481a.c, k0> onButtonRendered, @NotNull h9.a<k0> onClose, @NotNull w<? super Context, ? super WebView, ? super Integer, ? super y<Boolean>, ? super l<? super a.AbstractC0481a.c, k0>, ? super h9.a<k0>, ? super r, ? super Dp, ? super Boolean, ? extends View> adWebViewRenderer, @Nullable r rVar, @Nullable h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0> bVar, @Nullable h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0> bVar2, @Nullable Composer composer, int i11) {
        t.i(activity, "<this>");
        t.i(adViewModel, "adViewModel");
        t.i(webView, "webView");
        t.i(onButtonRendered, "onButtonRendered");
        t.i(onClose, "onClose");
        t.i(adWebViewRenderer, "adWebViewRenderer");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1840546172);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1840546172, i11, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.MraidAdContainerScreen (AdWebViewRenderer.kt:192)");
        }
        Modifier modifierTestTag = TestTagKt.testTag(BackgroundKt.m166backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null), Color.Companion.m1624getBlack0d7_KjU(), null, 2, null), "MraidAdContainerScreen");
        composerStartRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        h9.a<ComposeUiNode> constructor = companion.getConstructor();
        q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(modifierTestTag);
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
        Updater.m1265setimpl(composerM1258constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m1265setimpl(composerM1258constructorimpl, density, companion.getSetDensity());
        Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion.getSetLayoutDirection());
        Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
        composerStartRestartGroup.enableReusing();
        qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        composerStartRestartGroup.startReplaceableGroup(-2137368960);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        Integer numValueOf = Integer.valueOf(i10);
        composerStartRestartGroup.startReplaceableGroup(1157296644);
        boolean zChanged = composerStartRestartGroup.changed(numValueOf);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = s9.o0.a(Boolean.valueOf(i10 == 0));
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        y yVar = (y) objRememberedValue;
        State stateCollectAsState = SnapshotStateKt.collectAsState(adViewModel.j(), null, composerStartRestartGroup, 8, 1);
        CrossfadeKt.Crossfade(b(stateCollectAsState), null, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1935552634, true, new c(adWebViewRenderer, webView, i10, yVar, onButtonRendered, rVar, onClose)), composerStartRestartGroup, 3072, 6);
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g.c(boxScopeInstance, adViewModel, b(stateCollectAsState), bVar2, bVar, composerStartRestartGroup, (i11 & 112) | 6 | ((i11 >> 18) & 7168) | ((i11 >> 12) & 57344));
        BackHandlerKt.BackHandler(false, new d(yVar, onClose), composerStartRestartGroup, 0, 1);
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.q.a(activity, composerStartRestartGroup, 8);
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new e(activity, adViewModel, webView, i10, onButtonRendered, onClose, adWebViewRenderer, rVar, bVar, bVar2, i11));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void g(WebView webView, int i10, MutableState<Boolean> mutableState, l<? super a.AbstractC0481a.c, k0> lVar, h9.a<k0> aVar, Modifier modifier, long j10, h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0> bVar, r rVar, float f10, boolean z10, Composer composer, int i11, int i12, int i13) {
        h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0> bVarB;
        int i14;
        Composer composerStartRestartGroup = composer.startRestartGroup(1270178777);
        Modifier modifier2 = (i13 & 32) != 0 ? Modifier.Companion : modifier;
        long jM1624getBlack0d7_KjU = (i13 & 64) != 0 ? Color.Companion.m1624getBlack0d7_KjU() : j10;
        if ((i13 & 128) != 0) {
            bVarB = o.b(null, null, 0L, 0L, 0L, null, null, null, composerStartRestartGroup, 0, 255);
            i14 = i11 & (-29360129);
        } else {
            bVarB = bVar;
            i14 = i11;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1270178777, i14, i12, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.AdWebViewRenderDisplay (AdWebViewRenderer.kt:63)");
        }
        Modifier modifierM166backgroundbw27NRU$default = BackgroundKt.m166backgroundbw27NRU$default(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null), jM1624getBlack0d7_KjU, null, 2, null);
        composerStartRestartGroup.startReplaceableGroup(733328855);
        Alignment.Companion companion = Alignment.Companion;
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion.getTopStart(), false, composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
        h9.a<ComposeUiNode> constructor = companion2.getConstructor();
        q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(modifierM166backgroundbw27NRU$default);
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
        Updater.m1265setimpl(composerM1258constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m1265setimpl(composerM1258constructorimpl, density, companion2.getSetDensity());
        Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
        Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
        composerStartRestartGroup.enableReusing();
        qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        composerStartRestartGroup.startReplaceableGroup(-2137368960);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        Modifier.Companion companion3 = Modifier.Companion;
        long j11 = jM1624getBlack0d7_KjU;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.a.a(webView, SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null), rVar, composerStartRestartGroup, ((i14 >> 18) & 896) | 56, 0);
        composerStartRestartGroup.startReplaceableGroup(-461543684);
        if (bVarB != null) {
            Integer numValueOf = Integer.valueOf(i10);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged = composerStartRestartGroup.changed(numValueOf);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new m(c0.a(c0.c(n9.o.e(i10, 0))));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            m mVar = (m) objRememberedValue;
            boolean zBooleanValue = mutableState.getValue().booleanValue();
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged2 = composerStartRestartGroup.changed(mutableState);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new a(mutableState);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.r.b(boxScopeInstance, mVar, true, zBooleanValue, (h9.a) objRememberedValue2, aVar, lVar, bVarB, z10, composerStartRestartGroup, ((i14 << 3) & 458752) | 390 | ((i14 << 9) & 3670016) | ((i12 << 24) & 234881024));
        }
        composerStartRestartGroup.endReplaceableGroup();
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a.c(PaddingKt.m399padding3ABfNKs(boxScopeInstance.align(companion3, companion.getBottomStart()), f10), null, null, null, composerStartRestartGroup, 0, 14).invoke(boxScopeInstance, lVar, composerStartRestartGroup, Integer.valueOf(((i14 >> 6) & 112) | 6));
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C0474b(webView, i10, mutableState, lVar, aVar, modifier2, j11, bVarB, rVar, f10, z10, i11, i12, i13));
    }

    public static final void h(y<Boolean> yVar, h9.a<k0> aVar) {
        if (yVar.getValue().booleanValue()) {
            aVar.invoke();
        }
    }

    public static final void j(y<Boolean> yVar, h9.a<k0> aVar) {
        if (yVar.getValue().booleanValue()) {
            aVar.invoke();
        }
    }
}
