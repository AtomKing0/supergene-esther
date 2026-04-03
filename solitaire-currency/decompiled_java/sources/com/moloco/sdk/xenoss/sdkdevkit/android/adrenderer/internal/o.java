package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import com.moloco.sdk.internal.t;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"ViewConstructor"})
public final class o extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final Context f19670g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a f19671h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.q f19672i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public final z f19673j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    public final o0 f19674k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    public final j f19675l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g f19676m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a f19677n;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastBannerView$listenToPlayerEvents$1", f = "VastBannerView.kt", l = {}, m = "invokeSuspend")
    public static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19678j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f19679k;

        public a(z8.d<? super a> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            a aVar = o.this.new a(dVar);
            aVar.f19679k = obj;
            return aVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar, @Nullable z8.d<? super v8.k0> dVar) {
            return ((a) create(bVar, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f19678j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b) this.f19679k;
            if (kotlin.jvm.internal.t.d(bVar, b.i.f20763a)) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p adShowListener = o.this.getAdShowListener();
                if (adShowListener != null) {
                    adShowListener.a(true);
                }
            } else if (kotlin.jvm.internal.t.d(bVar, b.c.f20757a)) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p adShowListener2 = o.this.getAdShowListener();
                if (adShowListener2 != null) {
                    adShowListener2.a(false);
                }
            } else if (kotlin.jvm.internal.t.d(bVar, b.a.f20755a)) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p adShowListener3 = o.this.getAdShowListener();
                if (adShowListener3 != null) {
                    adShowListener3.a();
                }
            } else if (bVar instanceof b.f) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p adShowListener4 = o.this.getAdShowListener();
                if (adShowListener4 != null) {
                    adShowListener4.a(((b.f) bVar).a());
                }
            } else if (!kotlin.jvm.internal.t.d(bVar, b.g.f20761a) && !kotlin.jvm.internal.t.d(bVar, b.C0428b.f20756a) && !kotlin.jvm.internal.t.d(bVar, b.d.f20758a) && !kotlin.jvm.internal.t.d(bVar, b.h.f20762a)) {
                kotlin.jvm.internal.t.d(bVar, b.e.f20759a);
            }
            return v8.k0.f35197a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@NotNull Context context, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.q options, @NotNull z externalLinkHandler, @NotNull o0 scope, @NotNull j adLoader) {
        super(context, scope);
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(customUserEventBuilderService, "customUserEventBuilderService");
        kotlin.jvm.internal.t.i(options, "options");
        kotlin.jvm.internal.t.i(externalLinkHandler, "externalLinkHandler");
        kotlin.jvm.internal.t.i(scope, "scope");
        kotlin.jvm.internal.t.i(adLoader, "adLoader");
        this.f19670g = context;
        this.f19671h = customUserEventBuilderService;
        this.f19672i = options;
        this.f19673j = externalLinkHandler;
        this.f19674k = scope;
        this.f19675l = adLoader;
        setTag("MolocoVastBannerView");
        this.f19676m = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g.VAST;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i
    public void destroy() {
        super.destroy();
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVar = this.f19677n;
        if (aVar != null) {
            aVar.destroy();
        }
        this.f19677n = null;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h
    @NotNull
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g getCreativeType() {
        return this.f19676m;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u
    public void m() {
        com.moloco.sdk.internal.t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c> tVarB = getAdLoader().b();
        if (tVarB instanceof t.a) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c) ((t.a) tVarB).a();
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p adShowListener = getAdShowListener();
            if (adShowListener != null) {
                adShowListener.a(cVar);
                return;
            }
            return;
        }
        if (!(tVarB instanceof t.b)) {
            throw new v8.q();
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVarB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.b((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) ((t.b) tVarB).a(), this.f19673j, this.f19670g, this.f19671h, this.f19672i.g(), this.f19672i.e(), this.f19672i.f(), this.f19672i.c(), this.f19672i.d(), this.f19672i.b(), this.f19672i.a());
        this.f19677n = aVarB;
        setAdView(this.f19672i.h().mo4invoke(this.f19670g, aVarB));
        n();
        aVarB.d();
    }

    public final void n() {
        s9.h<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b> hVarA;
        s9.h hVarG;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a aVar = this.f19677n;
        if (aVar == null || (hVarA = aVar.a()) == null || (hVarG = s9.j.G(hVarA, new a(null))) == null) {
            return;
        }
        s9.j.D(hVarG, this.f19674k);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u
    @NotNull
    public j getAdLoader() {
        return this.f19675l;
    }
}
