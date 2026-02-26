package com.moloco.sdk.internal.publisher.nativead;

import com.moloco.sdk.acm.f;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.publisher.a0;
import com.moloco.sdk.internal.publisher.g0;
import com.moloco.sdk.internal.publisher.n;
import com.moloco.sdk.internal.publisher.nativead.c;
import com.moloco.sdk.internal.services.m;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.MolocoAdKt;
import com.moloco.sdk.publisher.NativeAd;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z;
import com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i;
import h9.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;
import v8.u;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements NativeAd, a0 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    public static final a f18065o = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f18066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final c f18067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.publisher.nativead.a f18068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final m f18069d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a f18070e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final z f18071f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final i f18072g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.publisher.a f18073h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public NativeAd.InteractionListener f18074i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public final AdFormatType f18075j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    public final o0 f18076k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    public final f f18077l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public d f18078m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public b2 f18079n;

    public static final class a {
        public /* synthetic */ a(k kVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.nativead.b$b, reason: collision with other inner class name */
    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdImpl$load$1", f = "NativeAdImpl.kt", l = {103}, m = "invokeSuspend")
    public static final class C0314b extends l implements p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f18080j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f18081k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ AdLoad.Listener f18083m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ String f18084n;

        /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.nativead.b$b$a */
        public /* synthetic */ class a extends q implements h9.a<k0> {
            public a(Object obj) {
                super(0, obj, b.class, "handleGeneralAdClick", "handleGeneralAdClick()V", 0);
            }

            public final void c() {
                ((b) this.receiver).handleGeneralAdClick();
            }

            @Override // h9.a
            public /* bridge */ /* synthetic */ k0 invoke() {
                c();
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0314b(AdLoad.Listener listener, String str, z8.d<? super C0314b> dVar) {
            super(2, dVar);
            this.f18083m = listener;
            this.f18084n = str;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((C0314b) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return b.this.new C0314b(this.f18083m, this.f18084n, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            g0 g0Var;
            Object objJ;
            Object objE = a9.d.e();
            int i10 = this.f18081k;
            if (i10 == 0) {
                u.b(obj);
                b bVar = b.this;
                g0 g0VarB = bVar.b(bVar.f18077l, this.f18083m);
                c cVar = b.this.f18067b;
                String str = this.f18084n;
                f fVar = b.this.f18077l;
                this.f18080j = g0VarB;
                this.f18081k = 1;
                Object objM = cVar.m(str, fVar, g0VarB, this);
                if (objM == objE) {
                    return objE;
                }
                g0Var = g0VarB;
                objJ = objM;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                g0Var = (g0) this.f18080j;
                u.b(obj);
                objJ = ((t) obj).j();
            }
            Throwable thE = t.e(objJ);
            if (thE != null) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, "NativeAdImpl", "Failed to load native ad.", thE, false, 8, null);
                return k0.f35197a;
            }
            c.b bVar2 = (c.b) objJ;
            b bVar3 = b.this;
            bVar3.d(new d(bVar3.f18066a, bVar2.a(), bVar2.b(), bVar3.f18069d, bVar3.f18070e, bVar3.f18075j, bVar3.f18072g, bVar3.f18071f));
            bVar3.getAssets().e(bVar2.c());
            bVar3.getAssets().f(new a(bVar3));
            g0Var.b(MolocoAdKt.createAdInfo(bVar3.f18066a, kotlin.coroutines.jvm.internal.b.c(bVar2.a().e())), bVar2.a().d().e());
            return k0.f35197a;
        }
    }

    public b(@NotNull String adUnitId, @NotNull c nativeAdLoader, @NotNull com.moloco.sdk.internal.publisher.nativead.a assets, @NotNull m appLifecycleTrackerService, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, @NotNull z externalLinkHandler, @NotNull i persistentHttpRequest, @NotNull com.moloco.sdk.internal.publisher.a createLoadTimeoutManager) {
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        kotlin.jvm.internal.t.i(nativeAdLoader, "nativeAdLoader");
        kotlin.jvm.internal.t.i(assets, "assets");
        kotlin.jvm.internal.t.i(appLifecycleTrackerService, "appLifecycleTrackerService");
        kotlin.jvm.internal.t.i(customUserEventBuilderService, "customUserEventBuilderService");
        kotlin.jvm.internal.t.i(externalLinkHandler, "externalLinkHandler");
        kotlin.jvm.internal.t.i(persistentHttpRequest, "persistentHttpRequest");
        kotlin.jvm.internal.t.i(createLoadTimeoutManager, "createLoadTimeoutManager");
        this.f18066a = adUnitId;
        this.f18067b = nativeAdLoader;
        this.f18068c = assets;
        this.f18069d = appLifecycleTrackerService;
        this.f18070e = customUserEventBuilderService;
        this.f18071f = externalLinkHandler;
        this.f18072g = persistentHttpRequest;
        this.f18073h = createLoadTimeoutManager;
        this.f18075j = AdFormatType.NATIVE;
        this.f18076k = p0.a(com.moloco.sdk.internal.scheduling.c.a().getMain());
        this.f18077l = com.moloco.sdk.acm.a.f17293a.w(com.moloco.sdk.internal.client_metrics_data.c.LoadAd.c());
    }

    public final g0 b(f fVar, AdLoad.Listener listener) {
        return n.a(listener, fVar, this.f18075j);
    }

    public final void d(@Nullable d dVar) {
        this.f18078m = dVar;
    }

    @Override // com.moloco.sdk.publisher.Destroyable
    public void destroy() {
        p0.e(this.f18076k, null, 1, null);
        getAssets().c();
        setInteractionListener(null);
    }

    @Override // com.moloco.sdk.publisher.NativeAd
    @NotNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public com.moloco.sdk.internal.publisher.nativead.a getAssets() {
        return this.f18068c;
    }

    @Override // com.moloco.sdk.publisher.NativeAd
    @Nullable
    public NativeAd.InteractionListener getInteractionListener() {
        return this.f18074i;
    }

    @Override // com.moloco.sdk.publisher.NativeAd
    public void handleGeneralAdClick() {
        NativeAd.InteractionListener interactionListener = getInteractionListener();
        if (interactionListener != null) {
            interactionListener.onGeneralClickHandled();
        }
        d dVar = this.f18078m;
        if (dVar != null) {
            dVar.d();
        }
    }

    @Override // com.moloco.sdk.publisher.NativeAd
    public void handleImpression() {
        NativeAd.InteractionListener interactionListener = getInteractionListener();
        if (interactionListener != null) {
            interactionListener.onImpressionHandled();
        }
        d dVar = this.f18078m;
        if (dVar != null) {
            dVar.e();
        }
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public boolean isLoaded() {
        return getAssets().g() != null;
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public synchronized void load(@NotNull String bidResponseJson, @Nullable AdLoad.Listener listener) {
        kotlin.jvm.internal.t.i(bidResponseJson, "bidResponseJson");
        b2 b2Var = this.f18079n;
        if (b2Var != null && b2Var.isActive()) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, "NativeAdImpl", "load() called while another load operation is in progress. Ignoring this call.", null, false, 12, null);
        } else if (isLoaded()) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, "NativeAdImpl", "load() called but ad is already loaded. Ignoring this call.", null, false, 12, null);
        } else {
            this.f18079n = kotlinx.coroutines.k.d(this.f18076k, null, null, new C0314b(listener, bidResponseJson, null), 3, null);
        }
    }

    @Override // com.moloco.sdk.internal.publisher.a0
    public void setCreateAdObjectStartTime(long j10) {
        this.f18073h.setCreateAdObjectStartTime(j10);
    }

    @Override // com.moloco.sdk.publisher.NativeAd
    public void setInteractionListener(@Nullable NativeAd.InteractionListener interactionListener) {
        this.f18074i = interactionListener;
    }
}
