package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.unit.Dp;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.d0;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.e0;
import s9.m0;
import s9.x;
import s9.y;
import v8.c0;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class MraidActivity extends ComponentActivity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f19487f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public static final x<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b> f19488g = e0.b(0, 0, null, 7, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final o0 f19489a = p0.a(com.moloco.sdk.internal.scheduling.c.a().getMain());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final v8.l f19490b = v8.n.a(c.f19495g);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a f19491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public j f19492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f19493e;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final boolean c(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c adData, @NotNull j controller, @NotNull Context context, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.d options, @Nullable com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r rVar, @Nullable h9.a<k0> aVar, @Nullable h9.a<k0> aVar2) {
            kotlin.jvm.internal.t.i(adData, "adData");
            kotlin.jvm.internal.t.i(controller, "controller");
            kotlin.jvm.internal.t.i(context, "context");
            kotlin.jvm.internal.t.i(options, "options");
            if (!d(controller)) {
                return false;
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.b bVar = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.b.f19506a;
            bVar.c(adData);
            bVar.e(rVar);
            bVar.h(options.a());
            bVar.g(options.c());
            bVar.f(aVar);
            bVar.d(controller);
            bVar.j(aVar2);
            Intent intent = new Intent(context, (Class<?>) MraidActivity.class);
            d0.a(intent, options.b());
            d0.e(intent, options.d());
            intent.setFlags(268435456);
            context.startActivity(intent);
            return true;
        }

        public final boolean d(j jVar) {
            WebView webViewC;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.b bVar = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.b.f19506a;
            j jVarP = bVar.p();
            if (jVarP != null && !kotlin.jvm.internal.t.d(jVarP, jVar)) {
                return false;
            }
            bVar.d(null);
            ViewParent parent = (jVarP == null || (webViewC = jVarP.c()) == null) ? null : webViewC.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(jVarP.c());
            }
            bVar.h(null);
            bVar.c(null);
            bVar.e(null);
            Activity activityO = bVar.o();
            if (activityO != null) {
                activityO.finish();
            }
            bVar.b(null);
            return true;
        }

        public final boolean e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar) {
            return kotlin.jvm.internal.t.d(bVar, b.e.f20759a);
        }

        public final boolean g(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar) {
            return bVar instanceof b.f;
        }

        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19494a;

        static {
            int[] iArr = new int[p.values().length];
            try {
                iArr[p.Portrait.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[p.Landscape.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[p.None.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f19494a = iArr;
        }
    }

    public static final class c extends kotlin.jvm.internal.v implements h9.a<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f19495g = new c();

        public c() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a invoke() {
            return a.k.f18946a.a();
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidActivity$onCreate$1", f = "MraidActivity.kt", l = {116}, m = "invokeSuspend")
    public static final class d extends kotlin.coroutines.jvm.internal.l implements h9.p<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19496j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f19497k;

        public d(z8.d<? super d> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            d dVar2 = MraidActivity.this.new d(dVar);
            dVar2.f19497k = obj;
            return dVar2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar, @Nullable z8.d<? super k0> dVar) {
            return ((d) create(bVar, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar;
            Object objE = a9.d.e();
            int i10 = this.f19496j;
            if (i10 == 0) {
                v8.u.b(obj);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b) this.f19497k;
                x xVar = MraidActivity.f19488g;
                this.f19497k = bVar2;
                this.f19496j = 1;
                if (xVar.emit(bVar2, this) == objE) {
                    return objE;
                }
                bVar = bVar2;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                bVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b) this.f19497k;
                v8.u.b(obj);
            }
            a aVar = MraidActivity.f19487f;
            if (aVar.g(bVar)) {
                MraidActivity.this.finish();
            } else if (aVar.e(bVar)) {
                MraidActivity.this.f19493e = true;
                MraidActivity.this.finish();
            }
            return k0.f35197a;
        }
    }

    public static final class e extends kotlin.jvm.internal.v implements h9.p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a f19500h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ j f19501i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ h9.w<Context, WebView, Integer, y<Boolean>, h9.l<? super a.AbstractC0481a.c, k0>, h9.a<k0>, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r, Dp, Boolean, View> f19502j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ h9.p<Composer, Integer, h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0>> f19503k;

        public static final class a extends kotlin.jvm.internal.v implements h9.l<a.AbstractC0481a.c, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final a f19504g = new a();

            public a() {
                super(1);
            }

            public final void a(@NotNull a.AbstractC0481a.c it) {
                kotlin.jvm.internal.t.i(it, "it");
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(a.AbstractC0481a.c cVar) {
                a(cVar);
                return k0.f35197a;
            }
        }

        public /* synthetic */ class b extends kotlin.jvm.internal.q implements h9.a<k0> {
            public b(Object obj) {
                super(0, obj, j.class, "onSkipOrClose", "onSkipOrClose()V", 0);
            }

            public final void c() {
                ((j) this.receiver).M();
            }

            @Override // h9.a
            public /* bridge */ /* synthetic */ k0 invoke() {
                c();
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVar, j jVar, h9.w<? super Context, ? super WebView, ? super Integer, ? super y<Boolean>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super h9.a<k0>, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r, ? super Dp, ? super Boolean, ? extends View> wVar, h9.p<? super Composer, ? super Integer, ? extends h9.b<? super BoxScope, ? super Boolean, ? super Boolean, ? super h9.a<k0>, ? super h9.l<? super a.AbstractC0481a.c, k0>, ? super Boolean, ? super c0, ? super c0, ? super Composer, ? super Integer, k0>> pVar) {
            super(2);
            this.f19500h = aVar;
            this.f19501i = jVar;
            this.f19502j = wVar;
            this.f19503k = pVar;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void a(@Nullable Composer composer, int i10) {
            if ((i10 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1048815572, i10, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidActivity.onCreate.<anonymous> (MraidActivity.kt:125)");
            }
            MraidActivity mraidActivity = MraidActivity.this;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVar = this.f19500h;
            WebView webViewC = this.f19501i.c();
            Intent intent = MraidActivity.this.getIntent();
            kotlin.jvm.internal.t.h(intent, "intent");
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b.f(mraidActivity, aVar, webViewC, d0.h(intent), a.f19504g, new b(this.f19501i), this.f19502j, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.b.f19506a.n(), this.f19503k.mo4invoke(composer, 0), com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.d.b(null, null, 0L, 0L, 0L, null, null, null, composer, 0, 255), composer, 25096);
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

    public /* synthetic */ class f extends kotlin.jvm.internal.a implements h9.p<n.f, z8.d<? super k0>, Object> {
        public f(Object obj) {
            super(2, obj, MraidActivity.class, "setOrientation", "setOrientation(Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/mraid/MraidJsCommand$SetOrientationProperties;)V", 4);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@Nullable n.f fVar, @NotNull z8.d<? super k0> dVar) {
            return MraidActivity.u((MraidActivity) this.receiver, fVar, dVar);
        }
    }

    public static final /* synthetic */ Object u(MraidActivity mraidActivity, n.f fVar, z8.d dVar) {
        mraidActivity.r(fVar);
        return k0.f35197a;
    }

    public final Integer m(p pVar) {
        int i10 = b.f19494a[pVar.ordinal()];
        if (i10 == 1) {
            return 1;
        }
        if (i10 == 2) {
            return 0;
        }
        if (i10 == 3) {
            return null;
        }
        throw new v8.q();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVarA;
        super.onCreate(bundle);
        com.moloco.sdk.internal.android_context.b.a(getApplicationContext());
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.b bVar = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.b.f19506a;
        bVar.b(this);
        h9.p<Composer, Integer, h9.b<BoxScope, Boolean, Boolean, h9.a<k0>, h9.l<? super a.AbstractC0481a.c, k0>, Boolean, c0, c0, Composer, Integer, k0>> pVarI = bVar.i();
        h9.w<Context, WebView, Integer, y<Boolean>, h9.l<? super a.AbstractC0481a.c, k0>, h9.a<k0>, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r, Dp, Boolean, View> wVarK = bVar.k();
        if (wVarK == null) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "MraidActivity", "can't display ad: MraidRenderer is missing", null, false, 12, null);
            finish();
            return;
        }
        j jVarP = bVar.p();
        if (jVarP == null) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "MraidActivity", "can't display ad: mraid controller is missing", null, false, 12, null);
            finish();
            return;
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c cVarA = bVar.a();
        if (cVarA != null) {
            z zVarD = a.h.f18920a.d();
            Intent intent = getIntent();
            kotlin.jvm.internal.t.h(intent, "intent");
            aVarA = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.a(cVarA, zVarD, this, jVarP, d0.k(intent), t());
        } else {
            aVarA = null;
        }
        if (aVarA == null) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "MraidActivity", "can't display ad: mraid ad data is missing", null, false, 12, null);
            finish();
            return;
        }
        s(jVarP.s());
        s9.j.D(s9.j.G(aVarA.a(), new d(null)), this.f19489a);
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-1048815572, true, new e(aVarA, jVarP, wVarK, pVarI)), 1, null);
        aVarA.d();
        this.f19491c = aVarA;
        this.f19492d = jVarP;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        h9.a<k0> aVarM;
        super.onDestroy();
        if (!this.f19493e && (aVarM = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.b.f19506a.m()) != null) {
            aVarM.invoke();
        }
        h9.a<k0> aVarL = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.b.f19506a.l();
        if (aVarL != null) {
            aVarL.invoke();
        }
        f19487f.d(this.f19492d);
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVar = this.f19491c;
        if (aVar != null) {
            aVar.destroy();
        }
        this.f19491c = null;
        p0.e(this.f19489a, null, 1, null);
    }

    public final void r(n.f fVar) {
        p pVarB;
        Integer numM;
        if (fVar == null || (pVarB = fVar.b()) == null || (numM = m(pVarB)) == null) {
            return;
        }
        setRequestedOrientation(numM.intValue());
    }

    public final void s(m0<n.f> m0Var) {
        r(m0Var.getValue());
        s9.j.D(s9.j.G(m0Var, new f(this)), this.f19489a);
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a t() {
        return (com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a) this.f19490b.getValue();
    }
}
