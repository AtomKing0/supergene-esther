package com.moloco.sdk.internal.publisher.nativead.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.VisibleForTesting;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.ComposeView;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r;
import h9.p;
import h9.q;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"ViewConstructor"})
public final class e extends FrameLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f18249d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a f18250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.a f18251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public ComposeView f18252c;

    public static final class a {
        public /* synthetic */ a(k kVar) {
            this();
        }

        public a() {
        }
    }

    public static final class b extends v implements q<Modifier, Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ r f18253g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ e f18254h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ h9.a<k0> f18255i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ t f18256j;

        public static final class a extends v implements p<Composer, Integer, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ e f18257g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ h9.a<k0> f18258h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ Modifier f18259i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public final /* synthetic */ t f18260j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ int f18261k;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(e eVar, h9.a<k0> aVar, Modifier modifier, t tVar, int i10) {
                super(2);
                this.f18257g = eVar;
                this.f18258h = aVar;
                this.f18259i = modifier;
                this.f18260j = tVar;
                this.f18261k = i10;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void a(@Nullable Composer composer, int i10) {
                if ((i10 & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1035844210, i10, -1, "com.moloco.sdk.internal.publisher.nativead.ui.NativeAdVideoContainer.videoView.<anonymous>.<anonymous> (NativeAdVideoContainer.kt:56)");
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVar = this.f18257g.f18250a;
                long jM1624getBlack0d7_KjU = Color.Companion.m1624getBlack0d7_KjU();
                h9.a<k0> aVar2 = this.f18258h;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.f fVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.f(aVar2, aVar2, aVar2);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.k.g(aVar, this.f18259i, jM1624getBlack0d7_KjU, f.a(composer, 0), null, null, null, fVar, null, null, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.g.a(g.a(), composer, 6, 0), this.f18260j, composer, ((this.f18261k << 3) & 112) | 102457728, 0, 512);
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
        public b(r rVar, e eVar, h9.a<k0> aVar, t tVar) {
            super(3);
            this.f18253g = rVar;
            this.f18254h = eVar;
            this.f18255i = aVar;
            this.f18256j = tVar;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void a(@NotNull Modifier modifier, @Nullable Composer composer, int i10) {
            kotlin.jvm.internal.t.i(modifier, "modifier");
            if ((i10 & 14) == 0) {
                i10 |= composer.changed(modifier) ? 4 : 2;
            }
            int i11 = i10;
            if ((i11 & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1867022133, i11, -1, "com.moloco.sdk.internal.publisher.nativead.ui.NativeAdVideoContainer.videoView.<anonymous> (NativeAdVideoContainer.kt:55)");
            }
            this.f18253g.a(ComposableLambdaKt.composableLambda(composer, 1035844210, true, new a(this.f18254h, this.f18255i, modifier, this.f18256j, i11)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ k0 invoke(Modifier modifier, Composer composer, Integer num) {
            a(modifier, composer, num.intValue());
            return k0.f35197a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull Context context, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a vastAdController, @NotNull t viewVisibilityTracker, @NotNull com.moloco.sdk.internal.a viewLifecycleOwner, @NotNull r watermark, @Nullable h9.a<k0> aVar) {
        super(context);
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(vastAdController, "vastAdController");
        kotlin.jvm.internal.t.i(viewVisibilityTracker, "viewVisibilityTracker");
        kotlin.jvm.internal.t.i(viewLifecycleOwner, "viewLifecycleOwner");
        kotlin.jvm.internal.t.i(watermark, "watermark");
        this.f18250a = vastAdController;
        this.f18251b = viewLifecycleOwner;
        ComposeView composeViewA = com.moloco.sdk.internal.publisher.nativead.ui.b.a(context, ComposableLambdaKt.composableLambdaInstance(1867022133, true, new b(watermark, this, aVar, viewVisibilityTracker)));
        addView(composeViewA, new ViewGroup.LayoutParams(-1, -1));
        this.f18252c = composeViewA;
    }

    public final void b() {
        this.f18250a.destroy();
        c();
    }

    public final void c() {
        removeAllViews();
        ComposeView composeView = this.f18252c;
        if (composeView != null) {
            composeView.disposeComposition();
        }
        this.f18252c = null;
    }

    @Nullable
    public final ComposeView getVideoView() {
        return this.f18252c;
    }

    @Override // android.view.ViewGroup, android.view.View
    @VisibleForTesting(otherwise = 4)
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "VideoContainer", "onAttachedToWindow", null, false, 12, null);
        this.f18251b.a(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    @VisibleForTesting(otherwise = 4)
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "VideoContainer", "onDetachedFromWindow", null, false, 12, null);
        this.f18251b.b(this);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10) {
            this.f18251b.c(this);
        } else {
            this.f18251b.d(this);
        }
    }

    public final void setVideoView(@Nullable ComposeView composeView) {
        this.f18252c = composeView;
    }

    @VisibleForTesting
    public static /* synthetic */ void getVideoView$annotations() {
    }
}
