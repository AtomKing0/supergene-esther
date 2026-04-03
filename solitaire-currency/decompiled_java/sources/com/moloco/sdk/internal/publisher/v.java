package com.moloco.sdk.internal.publisher;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.VisibleForTesting;
import androidx.media3.extractor.ts.PsExtractor;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.Banner;
import com.moloco.sdk.publisher.BannerAdShowListener;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.MolocoAdKt;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import java.util.Locale;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"ViewConstructor"})
@VisibleForTesting
public final class v<L extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p> extends Banner implements a0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NotNull
    public static final a f18284v = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Context f18285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.services.m f18286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a f18287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final String f18288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f18289e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z f18290f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final h9.v<Context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a, com.moloco.sdk.internal.ortb.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r, com.moloco.sdk.internal.a, com.moloco.sdk.internal.services.b0, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.i, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u<L>> f18291g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r f18292h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.publisher.a f18293i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.a f18294j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.i f18295k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.services.b0 f18296l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.acm.f f18297m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public com.moloco.sdk.acm.f f18298n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    public final o0 f18299o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NotNull
    public final s<L> f18300p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.i f18301q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public com.moloco.sdk.internal.publisher.d f18302r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public BannerAdShowListener f18303s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NotNull
    public final AdLoad f18304t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NotNull
    public final L f18305u;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ class b extends kotlin.jvm.internal.q implements h9.l<Long, q9.b> {
        public b(Object obj) {
            super(1, obj, com.moloco.sdk.internal.publisher.a.class, "calculateTimeout", "calculateTimeout-5sfh64U(J)J", 0);
        }

        public final long a(long j10) {
            return ((com.moloco.sdk.internal.publisher.a) this.receiver).a(j10);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ q9.b invoke(Long l10) {
            return q9.b.g(a(l10.longValue()));
        }
    }

    public /* synthetic */ class c extends kotlin.jvm.internal.q implements h9.l<com.moloco.sdk.internal.ortb.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b> {
        public c(Object obj) {
            super(1, obj, v.class, "recreateXenossAd", "recreateXenossAd(Lcom/moloco/sdk/internal/ortb/model/Bid;)Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/AdLoad;", 0);
        }

        @Override // h9.l
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b invoke(@NotNull com.moloco.sdk.internal.ortb.model.c p02) {
            kotlin.jvm.internal.t.i(p02, "p0");
            return ((v) this.receiver).c(p02);
        }
    }

    public static final class d extends kotlin.jvm.internal.v implements h9.a<com.moloco.sdk.internal.ortb.model.q> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ v<L> f18306g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(v<L> vVar) {
            super(0);
            this.f18306g = vVar;
        }

        @Override // h9.a
        @Nullable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.internal.ortb.model.q invoke() {
            return this.f18306g.f18300p.l();
        }
    }

    public static final class e extends kotlin.jvm.internal.v implements h9.a<r> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ v<L> f18307g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(v<L> vVar) {
            super(0);
            this.f18307g = vVar;
        }

        @Override // h9.a
        @Nullable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final r invoke() {
            return this.f18307g.f18300p.h();
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.BannerViewImpl$listenToAdDisplayState$1$1", f = "Banner.kt", l = {}, m = "invokeSuspend")
    public static final class f extends kotlin.coroutines.jvm.internal.l implements h9.p<Boolean, z8.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18308j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ boolean f18309k;

        public f(z8.d<? super f> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            f fVar = new f(dVar);
            fVar.f18309k = ((Boolean) obj).booleanValue();
            return fVar;
        }

        @Nullable
        public final Object f(boolean z10, @Nullable z8.d<? super Boolean> dVar) {
            return ((f) create(Boolean.valueOf(z10), dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo4invoke(Boolean bool, z8.d<? super Boolean> dVar) {
            return f(bool.booleanValue(), dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f18308j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            return kotlin.coroutines.jvm.internal.b.a(!this.f18309k);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.BannerViewImpl$listenToAdDisplayState$1$2", f = "Banner.kt", l = {}, m = "invokeSuspend")
    public static final class g extends kotlin.coroutines.jvm.internal.l implements h9.p<Boolean, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18310j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ boolean f18311k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ v<L> f18312l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ s<L> f18313m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(v<L> vVar, s<L> sVar, z8.d<? super g> dVar) {
            super(2, dVar);
            this.f18312l = vVar;
            this.f18313m = sVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            g gVar = new g(this.f18312l, this.f18313m, dVar);
            gVar.f18311k = ((Boolean) obj).booleanValue();
            return gVar;
        }

        @Nullable
        public final Object f(boolean z10, @Nullable z8.d<? super k0> dVar) {
            return ((g) create(Boolean.valueOf(z10), dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo4invoke(Boolean bool, z8.d<? super k0> dVar) {
            return f(bool.booleanValue(), dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f18310j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            if (this.f18311k) {
                com.moloco.sdk.acm.f fVar = this.f18312l.f18298n;
                if (fVar != null) {
                    com.moloco.sdk.acm.a aVar = com.moloco.sdk.acm.a.f17293a;
                    String strC = com.moloco.sdk.internal.client_metrics_data.b.AdType.c();
                    String lowerCase = com.ironsource.mediationsdk.l.f13634a.toLowerCase(Locale.ROOT);
                    kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    aVar.u(fVar.f(strC, lowerCase));
                }
                com.moloco.sdk.internal.publisher.d dVar = this.f18312l.f18302r;
                if (dVar != null) {
                    dVar.onAdShowSuccess(MolocoAdKt.createAdInfo$default(this.f18312l.f18288d, null, 2, null));
                }
            } else {
                com.moloco.sdk.internal.publisher.d dVar2 = this.f18312l.f18302r;
                if (dVar2 != null) {
                    dVar2.onAdHidden(MolocoAdKt.createAdInfo$default(this.f18312l.f18288d, null, 2, null));
                }
                b2 b2VarA = this.f18313m.a();
                if (b2VarA != null) {
                    b2.a.a(b2VarA, null, 1, null);
                }
            }
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.BannerViewImpl$load$1", f = "Banner.kt", l = {}, m = "invokeSuspend")
    public static final class h extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18314j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ v<L> f18315k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ String f18316l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ AdLoad.Listener f18317m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(v<L> vVar, String str, AdLoad.Listener listener, z8.d<? super h> dVar) {
            super(2, dVar);
            this.f18315k = vVar;
            this.f18316l = str;
            this.f18317m = listener;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((h) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new h(this.f18315k, this.f18316l, this.f18317m, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f18314j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            this.f18315k.f18304t.load(this.f18316l, this.f18317m);
            return k0.f35197a;
        }
    }

    public static final class i extends kotlin.jvm.internal.v implements h9.l<a.AbstractC0481a.c, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ v<L> f18318g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(v<L> vVar) {
            super(1);
            this.f18318g = vVar;
        }

        public final void a(@NotNull a.AbstractC0481a.c button) {
            kotlin.jvm.internal.t.i(button, "button");
            this.f18318g.f18301q.g(button);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(a.AbstractC0481a.c cVar) {
            a(cVar);
            return k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.BannerViewImpl$recreateXenossAd$touchInterceptor$1$1", f = "Banner.kt", l = {PsExtractor.VIDEO_STREAM_MASK}, m = "invokeSuspend")
    public static final class j extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18319j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ s9.c0<k0> f18320k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ v<L> f18321l;

        public static final class a implements s9.i<k0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ v<L> f18322a;

            public a(v<L> vVar) {
                this.f18322a = vVar;
            }

            @Override // s9.i
            @Nullable
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(@NotNull k0 k0Var, @NotNull z8.d<? super k0> dVar) {
                this.f18322a.f18305u.a();
                return k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(s9.c0<k0> c0Var, v<L> vVar, z8.d<? super j> dVar) {
            super(2, dVar);
            this.f18320k = c0Var;
            this.f18321l = vVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((j) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new j(this.f18320k, this.f18321l, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f18319j;
            if (i10 == 0) {
                v8.u.b(obj);
                s9.c0<k0> c0Var = this.f18320k;
                a aVar = new a(this.f18321l);
                this.f18319j = 1;
                if (c0Var.collect(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            throw new v8.h();
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.BannerViewImpl$recreateXenossAd$touchInterceptor$1$2$1", f = "Banner.kt", l = {248}, m = "invokeSuspend")
    public static final class k extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f18323j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ MotionEvent f18324k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.s f18325l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ v<L> f18326m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ s9.x<k0> f18327n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(MotionEvent motionEvent, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.s sVar, v<L> vVar, s9.x<k0> xVar, z8.d<? super k> dVar) {
            super(2, dVar);
            this.f18324k = motionEvent;
            this.f18325l = sVar;
            this.f18326m = vVar;
            this.f18327n = xVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((k) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new k(this.f18324k, this.f18325l, this.f18326m, this.f18327n, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f18323j;
            if (i10 == 0) {
                v8.u.b(obj);
                MotionEvent event = this.f18324k;
                if (event != null) {
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.s sVar = this.f18325l;
                    v<L> vVar = this.f18326m;
                    s9.x<k0> xVar = this.f18327n;
                    kotlin.jvm.internal.t.h(event, "event");
                    com.moloco.sdk.internal.services.b0 b0Var = vVar.f18296l;
                    String strJ = vVar.f18300p.j();
                    String strK = vVar.f18300p.k();
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.i iVar = vVar.f18301q;
                    this.f18323j = 1;
                    if (sVar.a(event, b0Var, strJ, strK, iVar, xVar, (64 & 64) != 0 ? com.moloco.sdk.internal.w.a() : null, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            return k0.f35197a;
        }
    }

    public static final class l implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v<L> f18328a;

        public l(v<L> vVar) {
            this.f18328a = vVar;
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p
        public void a(boolean z10) {
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c
        public void a(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c internalShowError) {
            kotlin.jvm.internal.t.i(internalShowError, "internalShowError");
            v<L> vVar = this.f18328a;
            vVar.h(com.moloco.sdk.internal.r.a(vVar.f18288d, MolocoAdError.ErrorType.AD_SHOW_ERROR, internalShowError));
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.c
        public void a() {
            com.moloco.sdk.internal.publisher.d dVar = this.f18328a.f18302r;
            if (dVar != null) {
                dVar.onAdClicked(MolocoAdKt.createAdInfo$default(this.f18328a.f18288d, null, 2, null));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public v(@NotNull Context context, @NotNull com.moloco.sdk.internal.services.m appLifecycleTrackerService, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, @NotNull String adUnitId, boolean z10, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z externalLinkHandler, @NotNull h9.v<? super Context, ? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a, ? super com.moloco.sdk.internal.ortb.model.c, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r, ? super com.moloco.sdk.internal.a, ? super com.moloco.sdk.internal.services.b0, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.i, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u<L>> createXenossBannerView, @NotNull h9.l<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p, ? extends L> createXenossBannerAdShowListener, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r watermark, @NotNull com.moloco.sdk.internal.publisher.a adCreateLoadTimeoutManager, @NotNull com.moloco.sdk.internal.a viewLifecycleOwner, @NotNull com.moloco.sdk.internal.i bannerSize, @NotNull com.moloco.sdk.internal.services.b0 clickthroughService) {
        super(context);
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(appLifecycleTrackerService, "appLifecycleTrackerService");
        kotlin.jvm.internal.t.i(customUserEventBuilderService, "customUserEventBuilderService");
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        kotlin.jvm.internal.t.i(externalLinkHandler, "externalLinkHandler");
        kotlin.jvm.internal.t.i(createXenossBannerView, "createXenossBannerView");
        kotlin.jvm.internal.t.i(createXenossBannerAdShowListener, "createXenossBannerAdShowListener");
        kotlin.jvm.internal.t.i(watermark, "watermark");
        kotlin.jvm.internal.t.i(adCreateLoadTimeoutManager, "adCreateLoadTimeoutManager");
        kotlin.jvm.internal.t.i(viewLifecycleOwner, "viewLifecycleOwner");
        kotlin.jvm.internal.t.i(bannerSize, "bannerSize");
        kotlin.jvm.internal.t.i(clickthroughService, "clickthroughService");
        this.f18285a = context;
        this.f18286b = appLifecycleTrackerService;
        this.f18287c = customUserEventBuilderService;
        this.f18288d = adUnitId;
        this.f18289e = z10;
        this.f18290f = externalLinkHandler;
        this.f18291g = createXenossBannerView;
        this.f18292h = watermark;
        this.f18293i = adCreateLoadTimeoutManager;
        this.f18294j = viewLifecycleOwner;
        this.f18295k = bannerSize;
        this.f18296l = clickthroughService;
        com.moloco.sdk.acm.f fVarW = com.moloco.sdk.acm.a.f17293a.w(com.moloco.sdk.internal.client_metrics_data.c.CreateToLoad.c());
        String strC = com.moloco.sdk.internal.client_metrics_data.b.AdType.c();
        String lowerCase = com.ironsource.mediationsdk.l.f13634a.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        this.f18297m = fVarW.f(strC, lowerCase);
        o0 o0VarA = p0.a(com.moloco.sdk.internal.scheduling.c.a().getMain());
        this.f18299o = o0VarA;
        this.f18300p = new s<>(null, null, null, null, null, null, false, 127, null);
        this.f18301q = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.k.a();
        this.f18304t = com.moloco.sdk.internal.publisher.j.a(o0VarA, new b(adCreateLoadTimeoutManager), adUnitId, new c(this), AdFormatType.BANNER);
        this.f18305u = createXenossBannerAdShowListener.invoke(new l(this));
    }

    public static /* synthetic */ void g(v vVar, com.moloco.sdk.internal.q qVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            qVar = null;
        }
        vVar.h(qVar);
    }

    public static final boolean j(v this$0, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.s this_apply, s9.x clickthroughFlow, View view, MotionEvent motionEvent) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(this_apply, "$this_apply");
        kotlin.jvm.internal.t.i(clickthroughFlow, "$clickthroughFlow");
        kotlinx.coroutines.k.d(this$0.f18299o, null, null, new k(motionEvent, this_apply, this$0, clickthroughFlow, null), 3, null);
        return false;
    }

    public final com.moloco.sdk.internal.publisher.d a(BannerAdShowListener bannerAdShowListener) {
        return new com.moloco.sdk.internal.publisher.d(bannerAdShowListener, this.f18286b, this.f18287c, new d(this), new e(this), AdFormatType.BANNER);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b c(com.moloco.sdk.internal.ortb.model.c cVar) {
        com.moloco.sdk.internal.ortb.model.b bVarA;
        com.moloco.sdk.internal.ortb.model.b bVarA2;
        g(this, null, 1, null);
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u<L> uVarInvoke = this.f18291g.invoke(this.f18285a, this.f18287c, cVar, this.f18290f, this.f18292h, this.f18294j, this.f18296l, this.f18301q);
        s<L> sVar = this.f18300p;
        sVar.d(uVarInvoke);
        sVar.b(cVar.d().e());
        sVar.c(cVar.c() != null ? new r(cVar.c(), Float.valueOf(cVar.e())) : null);
        com.moloco.sdk.internal.ortb.model.m mVarA = cVar.d().a();
        sVar.i((mVarA == null || (bVarA2 = mVarA.a()) == null) ? null : bVarA2.a());
        com.moloco.sdk.internal.ortb.model.m mVarA2 = cVar.d().a();
        sVar.e((mVarA2 == null || (bVarA = mVarA2.a()) == null) ? null : bVarA.c());
        com.moloco.sdk.internal.ortb.model.m mVarA3 = cVar.d().a();
        sVar.g((mVarA3 != null ? mVarA3.a() : null) != null);
        uVarInvoke.setAdShowListener(this.f18305u);
        i(uVarInvoke);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.moloco.sdk.internal.j.a(this.f18295k.b()), com.moloco.sdk.internal.j.a(this.f18295k.a()));
        layoutParams.gravity = 17;
        addView(uVarInvoke, layoutParams);
        if (this.f18300p.n()) {
            final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.s sVar2 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.s(this.f18285a);
            final s9.x xVarB = s9.e0.b(0, 0, null, 7, null);
            kotlinx.coroutines.k.d(this.f18299o, null, null, new j(xVarB, this, null), 3, null);
            sVar2.setOnTouchListener(new View.OnTouchListener() { // from class: com.moloco.sdk.internal.publisher.u
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return v.j(this.f18281a, sVar2, xVarB, view, motionEvent);
                }
            });
            addView(sVar2);
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.d dVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.d(this.f18290f, this.f18285a, null, 0, 12, null);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 8388691;
        dVar.setPadding(12, 0, 0, 12);
        dVar.setPrivacyUrl("https://cdn-f.adsmoloco.com/moloco-cdn/privacy.html");
        dVar.setOnButtonRenderedListener(new i(this));
        dVar.setLayoutParams(layoutParams2);
        addView(dVar);
        return uVarInvoke;
    }

    @Override // com.moloco.sdk.publisher.Destroyable
    public void destroy() {
        p0.e(this.f18299o, null, 1, null);
        g(this, null, 1, null);
        setAdShowListener(null);
        this.f18302r = null;
    }

    public final m0<Boolean> e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u<L> uVar) {
        return (this.f18289e || uVar == null) ? isViewShown() : uVar.l();
    }

    @Override // com.moloco.sdk.publisher.Banner
    @Nullable
    public BannerAdShowListener getAdShowListener() {
        return this.f18303s;
    }

    public long getCreateAdObjectStartTime() {
        return this.f18293i.b();
    }

    public final void h(com.moloco.sdk.internal.q qVar) {
        com.moloco.sdk.internal.publisher.d dVar;
        com.moloco.sdk.internal.publisher.d dVar2;
        s<L> sVar = this.f18300p;
        b2 b2VarA = sVar.a();
        if (b2VarA != null) {
            b2.a.a(b2VarA, null, 1, null);
        }
        sVar.f(null);
        boolean zBooleanValue = e(this.f18300p.m()).getValue().booleanValue();
        s<L> sVar2 = this.f18300p;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u<L> uVarM = sVar2.m();
        if (uVarM != null) {
            uVarM.destroy();
        }
        sVar2.d(null);
        if (qVar != null && (dVar2 = this.f18302r) != null) {
            dVar2.a(qVar);
        }
        if (zBooleanValue && (dVar = this.f18302r) != null) {
            dVar.onAdHidden(MolocoAdKt.createAdInfo$default(this.f18288d, null, 2, null));
        }
        this.f18300p.b(null);
        this.f18300p.c(null);
    }

    public final void i(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.a aVar) {
        s<L> sVar = this.f18300p;
        b2 b2VarA = sVar.a();
        if (b2VarA != null) {
            b2.a.a(b2VarA, null, 1, null);
        }
        sVar.f(s9.j.D(s9.j.G(s9.j.q(e(this.f18300p.m()), new f(null)), new g(this, sVar, null)), this.f18299o));
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public boolean isLoaded() {
        return this.f18304t.isLoaded();
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public void load(@NotNull String bidResponseJson, @Nullable AdLoad.Listener listener) {
        kotlin.jvm.internal.t.i(bidResponseJson, "bidResponseJson");
        com.moloco.sdk.acm.a aVar = com.moloco.sdk.acm.a.f17293a;
        aVar.u(this.f18297m);
        this.f18298n = aVar.w(com.moloco.sdk.internal.client_metrics_data.c.LoadToShow.c());
        kotlinx.coroutines.k.d(this.f18299o, null, null, new h(this, bidResponseJson, listener, null), 3, null);
    }

    @Override // com.moloco.sdk.publisher.Banner
    public void setAdShowListener(@Nullable BannerAdShowListener bannerAdShowListener) {
        com.moloco.sdk.internal.publisher.d dVarA = a(bannerAdShowListener);
        this.f18302r = dVarA;
        this.f18303s = dVarA.b();
    }

    @Override // com.moloco.sdk.internal.publisher.a0
    public void setCreateAdObjectStartTime(long j10) {
        this.f18293i.setCreateAdObjectStartTime(j10);
    }
}
