package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.content.Context;
import android.graphics.Rect;
import android.webkit.WebView;
import com.moloco.sdk.internal.t;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import s9.c0;
import s9.e0;
import s9.m0;
import s9.x;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f19547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final o0 f19548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final x<n> f19549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final c0<n> f19550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final v f19551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final WebView f19552f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final m0<Boolean> f19553g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final m0<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> f19554h;

    public static final class a implements o {
        public a() {
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.o
        public boolean a(@NotNull String fromUrl) {
            kotlin.jvm.internal.t.i(fromUrl, "fromUrl");
            return g.this.p(fromUrl);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidBridgeImpl$consumeMraidJsCommand$1", f = "MraidBridge.kt", l = {101}, m = "invokeSuspend")
    public static final class b extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f19556j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f19557k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.t<n, n.b.a> f19558l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ g f19559m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.moloco.sdk.internal.t<n, n.b.a> tVar, g gVar, z8.d<? super b> dVar) {
            super(2, dVar);
            this.f19558l = tVar;
            this.f19559m = gVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((b) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new b(this.f19558l, this.f19559m, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            n nVar;
            Object objE = a9.d.e();
            int i10 = this.f19557k;
            if (i10 == 0) {
                v8.u.b(obj);
                n nVar2 = (n) ((t.b) this.f19558l).a();
                x xVar = this.f19559m.f19549c;
                this.f19556j = nVar2;
                this.f19557k = 1;
                if (xVar.emit(nVar2, this) == objE) {
                    return objE;
                }
                nVar = nVar2;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                nVar = (n) this.f19556j;
                v8.u.b(obj);
            }
            this.f19559m.m(nVar);
            return k0.f35197a;
        }
    }

    public g(@NotNull Context context, @NotNull o0 scope, boolean z10) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(scope, "scope");
        this.f19547a = z10;
        this.f19548b = p0.i(scope, com.moloco.sdk.internal.scheduling.c.a().getMain());
        x<n> xVarB = e0.b(0, 0, null, 7, null);
        this.f19549c = xVarB;
        this.f19550d = xVarB;
        v vVar = new v(context, new a());
        this.f19551e = vVar;
        this.f19552f = vVar;
        this.f19553g = vVar.c();
        this.f19554h = vVar.getUnrecoverableError();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    @Nullable
    public Object b(@NotNull String str, @NotNull z8.d<? super com.moloco.sdk.internal.t<c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> dVar) {
        return this.f19551e.b(str, this.f19547a, dVar);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    @NotNull
    public WebView c() {
        return this.f19552f;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public void d(@NotNull r screenMetrics) {
        kotlin.jvm.internal.t.i(screenMetrics, "screenMetrics");
        q("\n                mraidbridge.setScreenSize(" + o(screenMetrics.i()) + ");\n                mraidbridge.setMaxSize(" + o(screenMetrics.h()) + ");\n                mraidbridge.setCurrentPosition(" + g(screenMetrics.d()) + ");\n                mraidbridge.setDefaultPosition(" + g(screenMetrics.g()) + ")\n            ");
        StringBuilder sb = new StringBuilder();
        sb.append("mraidbridge.notifySizeChangeEvent(");
        sb.append(o(screenMetrics.d()));
        sb.append(')');
        q(sb.toString());
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i
    public void destroy() {
        this.f19551e.destroy();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public void e(@NotNull s state) {
        kotlin.jvm.internal.t.i(state, "state");
        q("mraidbridge.setState(" + JSONObject.quote(state.c()) + ')');
    }

    public final String g(Rect rect) {
        StringBuilder sb = new StringBuilder();
        sb.append(rect.left);
        sb.append(',');
        sb.append(rect.top);
        sb.append(',');
        sb.append(rect.width());
        sb.append(',');
        sb.append(rect.height());
        return sb.toString();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public void h(@NotNull n command, @NotNull String msg) {
        kotlin.jvm.internal.t.i(command, "command");
        kotlin.jvm.internal.t.i(msg, "msg");
        q("mraidbridge.notifyErrorEvent(" + JSONObject.quote(command.a()) + ", " + JSONObject.quote(msg) + ')');
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public void i() {
        q("mraidbridge.notifyReadyEvent()");
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public void k(boolean z10) {
        q("mraidbridge.setIsViewable(" + z10 + ')');
    }

    public final void m(n nVar) {
        q("mraidbridge.nativeCallComplete(" + JSONObject.quote(nVar.a()) + ')');
    }

    public final String o(Rect rect) {
        StringBuilder sb = new StringBuilder();
        sb.append(rect.width());
        sb.append(',');
        sb.append(rect.height());
        return sb.toString();
    }

    public final boolean p(String str) {
        com.moloco.sdk.internal.t<n, n.b.a> tVarA = n.f19586b.a(str);
        if (tVarA instanceof t.b) {
            kotlinx.coroutines.k.d(this.f19548b, null, null, new b(tVarA, this, null), 3, null);
            return true;
        }
        if (tVarA instanceof t.a) {
            return ((n.b.a) ((t.a) tVarA).a()).a();
        }
        throw new v8.q();
    }

    public final void q(String str) {
        this.f19551e.loadUrl("javascript:" + str);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    @NotNull
    public c0<n> w() {
        return this.f19550d;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    @NotNull
    public m0<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> x() {
        return this.f19554h;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public void c(@NotNull q placementType) {
        kotlin.jvm.internal.t.i(placementType, "placementType");
        q("mraidbridge.setPlacementType(" + JSONObject.quote(placementType.c()) + ')');
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.f
    public void i(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        q("mraidbridge.setSupports(" + z10 + ',' + z11 + ',' + z12 + ',' + z13 + ',' + z14 + ')');
    }
}
