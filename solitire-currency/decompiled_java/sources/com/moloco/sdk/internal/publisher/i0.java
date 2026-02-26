package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.internal.u;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdShowListener;
import com.moloco.sdk.publisher.MolocoAd;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import java.util.Locale;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class i0 implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final AdShowListener f18025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.services.m f18026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a f18027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final h9.a<com.moloco.sdk.internal.ortb.model.q> f18028d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final h9.a<r> f18029e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.u f18030f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.f f18031g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final AdFormatType f18032h;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.InternalAdShowListenerImpl$onAdShowSuccess$2$1", f = "InternalAdShowListener.kt", l = {95}, m = "invokeSuspend")
    public static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18033j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ long f18035l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ r f18036m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j10, r rVar, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f18035l = j10;
            this.f18036m = rVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return i0.this.new a(this.f18035l, this.f18036m, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f18033j;
            if (i10 == 0) {
                v8.u.b(obj);
                com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar = i0.this.f18027c;
                long j10 = this.f18035l;
                a.AbstractC0481a.e eVar = a.AbstractC0481a.e.f21692a;
                String strA = this.f18036m.a();
                this.f18033j = 1;
                obj = aVar.a(j10, eVar, strA, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            i0.this.f18031g.a((String) obj);
            return k0.f35197a;
        }
    }

    public i0(@Nullable AdShowListener adShowListener, @NotNull com.moloco.sdk.internal.services.m appLifecycleTrackerService, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, @NotNull h9.a<com.moloco.sdk.internal.ortb.model.q> provideSdkEvents, @NotNull h9.a<r> provideBUrlData, @NotNull com.moloco.sdk.internal.u sdkEventUrlTracker, @NotNull com.moloco.sdk.internal.f bUrlTracker, @NotNull AdFormatType adType) {
        kotlin.jvm.internal.t.i(appLifecycleTrackerService, "appLifecycleTrackerService");
        kotlin.jvm.internal.t.i(customUserEventBuilderService, "customUserEventBuilderService");
        kotlin.jvm.internal.t.i(provideSdkEvents, "provideSdkEvents");
        kotlin.jvm.internal.t.i(provideBUrlData, "provideBUrlData");
        kotlin.jvm.internal.t.i(sdkEventUrlTracker, "sdkEventUrlTracker");
        kotlin.jvm.internal.t.i(bUrlTracker, "bUrlTracker");
        kotlin.jvm.internal.t.i(adType, "adType");
        this.f18025a = adShowListener;
        this.f18026b = appLifecycleTrackerService;
        this.f18027c = customUserEventBuilderService;
        this.f18028d = provideSdkEvents;
        this.f18029e = provideBUrlData;
        this.f18030f = sdkEventUrlTracker;
        this.f18031g = bUrlTracker;
        this.f18032h = adType;
    }

    @Override // com.moloco.sdk.internal.publisher.h0
    public void a(@NotNull com.moloco.sdk.internal.q internalError) {
        String strG;
        kotlin.jvm.internal.t.i(internalError, "internalError");
        com.moloco.sdk.internal.ortb.model.q qVarInvoke = this.f18028d.invoke();
        if (qVarInvoke != null && (strG = qVarInvoke.g()) != null) {
            this.f18030f.a(strG, System.currentTimeMillis(), internalError);
        }
        com.moloco.sdk.acm.a aVar = com.moloco.sdk.acm.a.f17293a;
        com.moloco.sdk.acm.c cVar = new com.moloco.sdk.acm.c(com.moloco.sdk.internal.client_metrics_data.a.ShowAdFailed.c());
        String strC = com.moloco.sdk.internal.client_metrics_data.b.AdType.c();
        String lowerCase = this.f18032h.name().toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        aVar.t(cVar.d(strC, lowerCase).d(com.moloco.sdk.internal.client_metrics_data.b.Reason.c(), String.valueOf(internalError.a().getErrorType())));
        AdShowListener adShowListener = this.f18025a;
        if (adShowListener != null) {
            adShowListener.onAdShowFailed(internalError.a());
        }
    }

    @Override // com.moloco.sdk.internal.publisher.h0
    public void onAdClicked(@NotNull MolocoAd molocoAd) {
        String strA;
        kotlin.jvm.internal.t.i(molocoAd, "molocoAd");
        this.f18026b.b();
        com.moloco.sdk.internal.ortb.model.q qVarInvoke = this.f18028d.invoke();
        if (qVarInvoke != null && (strA = qVarInvoke.a()) != null) {
            u.a.a(this.f18030f, strA, System.currentTimeMillis(), null, 4, null);
        }
        com.moloco.sdk.acm.a aVar = com.moloco.sdk.acm.a.f17293a;
        com.moloco.sdk.acm.c cVar = new com.moloco.sdk.acm.c(com.moloco.sdk.internal.client_metrics_data.a.AdClicked.c());
        String strC = com.moloco.sdk.internal.client_metrics_data.b.AdType.c();
        String lowerCase = this.f18032h.name().toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        aVar.t(cVar.d(strC, lowerCase));
        AdShowListener adShowListener = this.f18025a;
        if (adShowListener != null) {
            adShowListener.onAdClicked(molocoAd);
        }
    }

    @Override // com.moloco.sdk.internal.publisher.h0
    public void onAdHidden(@NotNull MolocoAd molocoAd) {
        String strC;
        kotlin.jvm.internal.t.i(molocoAd, "molocoAd");
        com.moloco.sdk.internal.ortb.model.q qVarInvoke = this.f18028d.invoke();
        if (qVarInvoke != null && (strC = qVarInvoke.c()) != null) {
            u.a.a(this.f18030f, strC, System.currentTimeMillis(), null, 4, null);
        }
        AdShowListener adShowListener = this.f18025a;
        if (adShowListener != null) {
            adShowListener.onAdHidden(molocoAd);
        }
    }

    @Override // com.moloco.sdk.internal.publisher.h0
    public void onAdShowSuccess(@NotNull MolocoAd molocoAd) {
        String strH;
        kotlin.jvm.internal.t.i(molocoAd, "molocoAd");
        com.moloco.sdk.internal.ortb.model.q qVarInvoke = this.f18028d.invoke();
        if (qVarInvoke != null && (strH = qVarInvoke.h()) != null) {
            u.a.a(this.f18030f, strH, System.currentTimeMillis(), null, 4, null);
        }
        r rVarInvoke = this.f18029e.invoke();
        if (rVarInvoke != null) {
            kotlinx.coroutines.k.d(com.moloco.sdk.internal.scheduling.d.f18390a.a(), null, null, new a(System.currentTimeMillis(), rVarInvoke, null), 3, null);
        }
        com.moloco.sdk.acm.a aVar = com.moloco.sdk.acm.a.f17293a;
        com.moloco.sdk.acm.c cVar = new com.moloco.sdk.acm.c(com.moloco.sdk.internal.client_metrics_data.a.ShowAdSuccess.c());
        String strC = com.moloco.sdk.internal.client_metrics_data.b.AdType.c();
        String lowerCase = this.f18032h.name().toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        aVar.t(cVar.d(strC, lowerCase));
        AdShowListener adShowListener = this.f18025a;
        if (adShowListener != null) {
            adShowListener.onAdShowSuccess(molocoAd);
        }
    }
}
