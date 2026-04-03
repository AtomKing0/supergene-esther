package com.moloco.sdk.internal.publisher;

import android.content.Context;
import android.view.ViewParent;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.error.b;
import com.moloco.sdk.internal.i;
import com.moloco.sdk.internal.t;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.Banner;
import com.moloco.sdk.publisher.Initialization;
import com.moloco.sdk.publisher.InterstitialAd;
import com.moloco.sdk.publisher.MediationInfo;
import com.moloco.sdk.publisher.Moloco;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.NativeAd;
import com.moloco.sdk.publisher.RewardedInterstitialAd;
import com.moloco.sdk.service_locator.a;
import java.util.Locale;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f17830f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final m0<Initialization> f17831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.services.r f17832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.publisher.e f17833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final h9.l<z8.d<? super com.moloco.sdk.internal.b>, Object> f17834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final z8.g f17835e;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17836a;

        static {
            int[] iArr = new int[Initialization.values().length];
            try {
                iArr[Initialization.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Initialization.FAILURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f17836a = iArr;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.c$c, reason: collision with other inner class name */
    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.AdCreator", f = "AdCreator.kt", l = {391}, m = "awaitAdFactoryWithTimeoutOrNull")
    public static final class C0311c extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f17837j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f17838k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f17839l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f17841n;

        public C0311c(z8.d<? super C0311c> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f17839l = obj;
            this.f17841n |= Integer.MIN_VALUE;
            return c.this.e(null, null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.AdCreator$awaitAdFactoryWithTimeoutOrNull$2", f = "AdCreator.kt", l = {391}, m = "invokeSuspend")
    public static final class d extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super com.moloco.sdk.internal.b>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f17842j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ h9.l<z8.d<? super com.moloco.sdk.internal.b>, Object> f17843k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(h9.l<? super z8.d<? super com.moloco.sdk.internal.b>, ? extends Object> lVar, z8.d<? super d> dVar) {
            super(2, dVar);
            this.f17843k = lVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super com.moloco.sdk.internal.b> dVar) {
            return ((d) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new d(this.f17843k, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f17842j;
            if (i10 == 0) {
                v8.u.b(obj);
                h9.l<z8.d<? super com.moloco.sdk.internal.b>, Object> lVar = this.f17843k;
                this.f17842j = 1;
                obj = lVar.invoke(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            return obj;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.AdCreator$createBanner$2", f = "AdCreator.kt", l = {71}, m = "invokeSuspend")
    public static final class e extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super com.moloco.sdk.internal.t<Banner, MolocoAdError.AdCreateError>>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f17844j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f17845k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f17846l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f17847m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f17848n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ String f17850p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ String f17851q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, String str2, z8.d<? super e> dVar) {
            super(2, dVar);
            this.f17850p = str;
            this.f17851q = str2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super com.moloco.sdk.internal.t<Banner, MolocoAdError.AdCreateError>> dVar) {
            return ((e) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return c.this.new e(this.f17850p, this.f17851q, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE;
            com.moloco.sdk.acm.f fVar;
            long j10;
            b0 b0Var;
            String str;
            e eVar;
            com.moloco.sdk.acm.f fVar2;
            Object objE2 = a9.d.e();
            int i10 = this.f17848n;
            if (i10 == 0) {
                v8.u.b(obj);
                b0 b0Var2 = b0.BANNER;
                long jInvoke = c.this.f17832b.invoke();
                String strG = c.this.g();
                com.moloco.sdk.acm.f fVarF = com.moloco.sdk.acm.a.f17293a.w(com.moloco.sdk.internal.client_metrics_data.c.CreateAd.c()).f(com.moloco.sdk.internal.client_metrics_data.b.AdType.c(), b0Var2.name()).f("initial_sdk_init_state", strG);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, "AdCreator", "Creating " + b0Var2 + " ad with adUnitId: " + this.f17850p, null, false, 12, null);
                c cVar = c.this;
                h9.l lVar = cVar.f17834d;
                this.f17844j = b0Var2;
                this.f17845k = strG;
                this.f17846l = fVarF;
                this.f17847m = jInvoke;
                this.f17848n = 1;
                objE = cVar.e(lVar, b0Var2, this);
                if (objE == objE2) {
                    return objE2;
                }
                fVar = fVarF;
                j10 = jInvoke;
                b0Var = b0Var2;
                str = strG;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j10 = this.f17847m;
                com.moloco.sdk.acm.f fVar3 = (com.moloco.sdk.acm.f) this.f17846l;
                String str2 = (String) this.f17845k;
                b0 b0Var3 = (b0) this.f17844j;
                v8.u.b(obj);
                b0Var = b0Var3;
                str = str2;
                fVar = fVar3;
                objE = obj;
            }
            com.moloco.sdk.internal.b bVar = (com.moloco.sdk.internal.b) objE;
            if (bVar != null) {
                Context contextA = com.moloco.sdk.service_locator.a.f18869a.a();
                com.moloco.sdk.internal.services.m mVarB = a.b.f18871a.b();
                String str3 = this.f17850p;
                a.h hVar = a.h.f18920a;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t tVarH = hVar.h();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z zVarD = hVar.d();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.s sVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.s(this.f17851q);
                AdFormatType adFormatType = AdFormatType.BANNER;
                MediationInfo mediationInfo$moloco_sdk_release = Moloco.INSTANCE.getMediationInfo$moloco_sdk_release();
                long j11 = j10;
                com.moloco.sdk.acm.f fVar4 = fVar;
                ViewParent viewParentC = bVar.c(contextA, mVarB, str3, tVarH, zVarD, sVar, new com.moloco.sdk.internal.publisher.a(adFormatType, com.moloco.sdk.internal.mediators.a.a(mediationInfo$moloco_sdk_release != null ? mediationInfo$moloco_sdk_release.getName() : null), null), hVar.g(), i.b.f17652c);
                if (viewParentC != null) {
                    com.moloco.sdk.acm.a aVar = com.moloco.sdk.acm.a.f17293a;
                    com.moloco.sdk.acm.c cVar2 = new com.moloco.sdk.acm.c(com.moloco.sdk.internal.client_metrics_data.a.CreateAd.c());
                    com.moloco.sdk.internal.client_metrics_data.b bVar2 = com.moloco.sdk.internal.client_metrics_data.b.Result;
                    aVar.t(cVar2.d(bVar2.c(), "success").d(com.moloco.sdk.internal.client_metrics_data.b.AdType.c(), b0Var.name()).d("initial_sdk_init_state", str));
                    aVar.u(fVar4.f(bVar2.c(), "success"));
                    if (viewParentC instanceof a0) {
                        ((a0) viewParentC).setCreateAdObjectStartTime(j11);
                    }
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, "AdCreator", "Created " + b0Var + " ad with adUnitId: " + this.f17850p, null, false, 12, null);
                    return new t.b(viewParentC);
                }
                eVar = this;
                fVar2 = fVar4;
            } else {
                eVar = this;
                fVar2 = fVar;
            }
            MolocoAdError.AdCreateError adCreateErrorB = c.this.b(eVar.f17850p, str, fVar2, b0Var);
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, "AdCreator", "Failed to create " + b0Var + " with reason: " + adCreateErrorB, null, false, 12, null);
            return new t.a(adCreateErrorB);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.AdCreator$createBannerTablet$2", f = "AdCreator.kt", l = {124}, m = "invokeSuspend")
    public static final class f extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super com.moloco.sdk.internal.t<Banner, MolocoAdError.AdCreateError>>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f17852j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f17853k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f17854l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f17855m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f17856n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ String f17858p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ String f17859q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, String str2, z8.d<? super f> dVar) {
            super(2, dVar);
            this.f17858p = str;
            this.f17859q = str2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super com.moloco.sdk.internal.t<Banner, MolocoAdError.AdCreateError>> dVar) {
            return ((f) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return c.this.new f(this.f17858p, this.f17859q, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE;
            com.moloco.sdk.acm.f fVar;
            long j10;
            b0 b0Var;
            String str;
            f fVar2;
            com.moloco.sdk.acm.f fVar3;
            Object objE2 = a9.d.e();
            int i10 = this.f17856n;
            if (i10 == 0) {
                v8.u.b(obj);
                b0 b0Var2 = b0.BANNER_TABLET;
                long jInvoke = c.this.f17832b.invoke();
                String strG = c.this.g();
                com.moloco.sdk.acm.f fVarF = com.moloco.sdk.acm.a.f17293a.w(com.moloco.sdk.internal.client_metrics_data.c.CreateAd.c()).f(com.moloco.sdk.internal.client_metrics_data.b.AdType.c(), b0Var2.name()).f("initial_sdk_init_state", strG);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, "AdCreator", "Creating " + b0Var2 + " ad with adUnitId: " + this.f17858p, null, false, 12, null);
                c cVar = c.this;
                h9.l lVar = cVar.f17834d;
                this.f17852j = b0Var2;
                this.f17853k = strG;
                this.f17854l = fVarF;
                this.f17855m = jInvoke;
                this.f17856n = 1;
                objE = cVar.e(lVar, b0Var2, this);
                if (objE == objE2) {
                    return objE2;
                }
                fVar = fVarF;
                j10 = jInvoke;
                b0Var = b0Var2;
                str = strG;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j10 = this.f17855m;
                com.moloco.sdk.acm.f fVar4 = (com.moloco.sdk.acm.f) this.f17854l;
                String str2 = (String) this.f17853k;
                b0 b0Var3 = (b0) this.f17852j;
                v8.u.b(obj);
                b0Var = b0Var3;
                str = str2;
                fVar = fVar4;
                objE = obj;
            }
            com.moloco.sdk.internal.b bVar = (com.moloco.sdk.internal.b) objE;
            if (bVar != null) {
                Context contextA = com.moloco.sdk.service_locator.a.f18869a.a();
                com.moloco.sdk.internal.services.m mVarB = a.b.f18871a.b();
                String str3 = this.f17858p;
                a.h hVar = a.h.f18920a;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t tVarH = hVar.h();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z zVarD = hVar.d();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.s sVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.s(this.f17859q);
                AdFormatType adFormatType = AdFormatType.BANNER;
                MediationInfo mediationInfo$moloco_sdk_release = Moloco.INSTANCE.getMediationInfo$moloco_sdk_release();
                long j11 = j10;
                com.moloco.sdk.acm.f fVar5 = fVar;
                ViewParent viewParentD = bVar.d(contextA, mVarB, str3, tVarH, zVarD, sVar, new com.moloco.sdk.internal.publisher.a(adFormatType, com.moloco.sdk.internal.mediators.a.a(mediationInfo$moloco_sdk_release != null ? mediationInfo$moloco_sdk_release.getName() : null), null), hVar.g(), i.c.f17653c);
                if (viewParentD != null) {
                    com.moloco.sdk.acm.a aVar = com.moloco.sdk.acm.a.f17293a;
                    com.moloco.sdk.acm.c cVar2 = new com.moloco.sdk.acm.c(com.moloco.sdk.internal.client_metrics_data.a.CreateAd.c());
                    com.moloco.sdk.internal.client_metrics_data.b bVar2 = com.moloco.sdk.internal.client_metrics_data.b.Result;
                    aVar.t(cVar2.d(bVar2.c(), "success").d(com.moloco.sdk.internal.client_metrics_data.b.AdType.c(), b0Var.name()).d("initial_sdk_init_state", str));
                    aVar.u(fVar5.f(bVar2.c(), "success"));
                    if (viewParentD instanceof a0) {
                        ((a0) viewParentD).setCreateAdObjectStartTime(j11);
                    }
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, "AdCreator", "Created " + b0Var + " ad with adUnitId: " + this.f17858p, null, false, 12, null);
                    return new t.b(viewParentD);
                }
                fVar2 = this;
                fVar3 = fVar5;
            } else {
                fVar2 = this;
                fVar3 = fVar;
            }
            MolocoAdError.AdCreateError adCreateErrorB = c.this.b(fVar2.f17858p, str, fVar3, b0Var);
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, "AdCreator", "Failed to create " + b0Var + " with reason: " + adCreateErrorB, null, false, 12, null);
            return new t.a(adCreateErrorB);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.AdCreator$createInterstitial$2", f = "AdCreator.kt", l = {251}, m = "invokeSuspend")
    public static final class g extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super com.moloco.sdk.internal.t<InterstitialAd, MolocoAdError.AdCreateError>>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f17860j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f17861k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f17862l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f17863m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f17864n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ String f17866p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ String f17867q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, String str2, z8.d<? super g> dVar) {
            super(2, dVar);
            this.f17866p = str;
            this.f17867q = str2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super com.moloco.sdk.internal.t<InterstitialAd, MolocoAdError.AdCreateError>> dVar) {
            return ((g) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return c.this.new g(this.f17866p, this.f17867q, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE;
            com.moloco.sdk.acm.f fVar;
            long j10;
            b0 b0Var;
            String str;
            g gVar;
            com.moloco.sdk.acm.f fVar2;
            Object objE2 = a9.d.e();
            int i10 = this.f17864n;
            if (i10 == 0) {
                v8.u.b(obj);
                b0 b0Var2 = b0.INTERSTITIAL;
                long jInvoke = c.this.f17832b.invoke();
                String strG = c.this.g();
                com.moloco.sdk.acm.f fVarF = com.moloco.sdk.acm.a.f17293a.w(com.moloco.sdk.internal.client_metrics_data.c.CreateAd.c()).f(com.moloco.sdk.internal.client_metrics_data.b.AdType.c(), b0Var2.name()).f("initial_sdk_init_state", strG);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, "AdCreator", "Creating " + b0Var2 + " ad with adUnitId: " + this.f17866p, null, false, 12, null);
                c cVar = c.this;
                h9.l lVar = cVar.f17834d;
                this.f17860j = b0Var2;
                this.f17861k = strG;
                this.f17862l = fVarF;
                this.f17863m = jInvoke;
                this.f17864n = 1;
                objE = cVar.e(lVar, b0Var2, this);
                if (objE == objE2) {
                    return objE2;
                }
                fVar = fVarF;
                j10 = jInvoke;
                b0Var = b0Var2;
                str = strG;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j10 = this.f17863m;
                com.moloco.sdk.acm.f fVar3 = (com.moloco.sdk.acm.f) this.f17862l;
                String str2 = (String) this.f17861k;
                b0 b0Var3 = (b0) this.f17860j;
                v8.u.b(obj);
                b0Var = b0Var3;
                str = str2;
                fVar = fVar3;
                objE = obj;
            }
            com.moloco.sdk.internal.b bVar = (com.moloco.sdk.internal.b) objE;
            if (bVar != null) {
                Context contextA = com.moloco.sdk.service_locator.a.f18869a.a();
                com.moloco.sdk.internal.services.m mVarB = a.b.f18871a.b();
                String str3 = this.f17866p;
                a.h hVar = a.h.f18920a;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t tVarH = hVar.h();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z zVarD = hVar.d();
                com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVarC = a.i.f18932a.c();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.s sVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.s(this.f17867q);
                AdFormatType adFormatType = AdFormatType.INTERSTITIAL;
                MediationInfo mediationInfo$moloco_sdk_release = Moloco.INSTANCE.getMediationInfo$moloco_sdk_release();
                long j11 = j10;
                com.moloco.sdk.acm.f fVar4 = fVar;
                InterstitialAd interstitialAdA = bVar.a(contextA, mVarB, str3, tVarH, zVarD, iVarC, sVar, new com.moloco.sdk.internal.publisher.a(adFormatType, com.moloco.sdk.internal.mediators.a.b(mediationInfo$moloco_sdk_release != null ? mediationInfo$moloco_sdk_release.getName() : null), null));
                if (interstitialAdA != null) {
                    com.moloco.sdk.acm.a aVar = com.moloco.sdk.acm.a.f17293a;
                    com.moloco.sdk.acm.c cVar2 = new com.moloco.sdk.acm.c(com.moloco.sdk.internal.client_metrics_data.a.CreateAd.c());
                    com.moloco.sdk.internal.client_metrics_data.b bVar2 = com.moloco.sdk.internal.client_metrics_data.b.Result;
                    aVar.t(cVar2.d(bVar2.c(), "success").d(com.moloco.sdk.internal.client_metrics_data.b.AdType.c(), b0Var.name()).d("initial_sdk_init_state", str.toString()));
                    aVar.u(fVar4.f(bVar2.c(), "success"));
                    if (interstitialAdA instanceof a0) {
                        ((a0) interstitialAdA).setCreateAdObjectStartTime(j11);
                    }
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, "AdCreator", "Created " + b0Var + " ad with adUnitId: " + this.f17866p, null, false, 12, null);
                    return new t.b(interstitialAdA);
                }
                gVar = this;
                fVar2 = fVar4;
            } else {
                gVar = this;
                fVar2 = fVar;
            }
            MolocoAdError.AdCreateError adCreateErrorB = c.this.b(gVar.f17866p, str, fVar2, b0Var);
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, "AdCreator", "Failed to create " + b0Var + " with reason: " + adCreateErrorB, null, false, 12, null);
            return new t.a(adCreateErrorB);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.AdCreator$createMREC$2", f = "AdCreator.kt", l = {169}, m = "invokeSuspend")
    public static final class h extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super com.moloco.sdk.internal.t<Banner, MolocoAdError.AdCreateError>>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f17868j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f17869k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f17870l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f17871m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f17872n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ String f17874p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ String f17875q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, String str2, z8.d<? super h> dVar) {
            super(2, dVar);
            this.f17874p = str;
            this.f17875q = str2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super com.moloco.sdk.internal.t<Banner, MolocoAdError.AdCreateError>> dVar) {
            return ((h) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return c.this.new h(this.f17874p, this.f17875q, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE;
            com.moloco.sdk.acm.f fVar;
            long j10;
            b0 b0Var;
            String str;
            h hVar;
            com.moloco.sdk.acm.f fVar2;
            Object objE2 = a9.d.e();
            int i10 = this.f17872n;
            if (i10 == 0) {
                v8.u.b(obj);
                b0 b0Var2 = b0.MREC;
                long jA = c.this.f17832b.a();
                String strG = c.this.g();
                com.moloco.sdk.acm.f fVarF = com.moloco.sdk.acm.a.f17293a.w(com.moloco.sdk.internal.client_metrics_data.c.CreateAd.c()).f(com.moloco.sdk.internal.client_metrics_data.b.AdType.c(), b0Var2.name()).f("initial_sdk_init_state", strG);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, "AdCreator", "Creating " + b0Var2 + " ad with adUnitId: " + this.f17874p, null, false, 12, null);
                c cVar = c.this;
                h9.l lVar = cVar.f17834d;
                this.f17868j = b0Var2;
                this.f17869k = strG;
                this.f17870l = fVarF;
                this.f17871m = jA;
                this.f17872n = 1;
                objE = cVar.e(lVar, b0Var2, this);
                if (objE == objE2) {
                    return objE2;
                }
                fVar = fVarF;
                j10 = jA;
                b0Var = b0Var2;
                str = strG;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j10 = this.f17871m;
                com.moloco.sdk.acm.f fVar3 = (com.moloco.sdk.acm.f) this.f17870l;
                String str2 = (String) this.f17869k;
                b0 b0Var3 = (b0) this.f17868j;
                v8.u.b(obj);
                b0Var = b0Var3;
                str = str2;
                fVar = fVar3;
                objE = obj;
            }
            com.moloco.sdk.internal.b bVar = (com.moloco.sdk.internal.b) objE;
            if (bVar != null) {
                Context contextA = com.moloco.sdk.service_locator.a.f18869a.a();
                com.moloco.sdk.internal.services.m mVarB = a.b.f18871a.b();
                String str3 = this.f17874p;
                a.h hVar2 = a.h.f18920a;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t tVarH = hVar2.h();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z zVarD = hVar2.d();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.s sVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.s(this.f17875q);
                AdFormatType adFormatType = AdFormatType.MREC;
                MediationInfo mediationInfo$moloco_sdk_release = Moloco.INSTANCE.getMediationInfo$moloco_sdk_release();
                long j11 = j10;
                com.moloco.sdk.acm.f fVar4 = fVar;
                ViewParent viewParentE = bVar.e(contextA, mVarB, str3, tVarH, zVarD, sVar, new com.moloco.sdk.internal.publisher.a(adFormatType, com.moloco.sdk.internal.mediators.a.a(mediationInfo$moloco_sdk_release != null ? mediationInfo$moloco_sdk_release.getName() : null), null), hVar2.g(), i.a.f17651c);
                if (viewParentE != null) {
                    com.moloco.sdk.acm.a aVar = com.moloco.sdk.acm.a.f17293a;
                    com.moloco.sdk.acm.c cVar2 = new com.moloco.sdk.acm.c(com.moloco.sdk.internal.client_metrics_data.a.CreateAd.c());
                    com.moloco.sdk.internal.client_metrics_data.b bVar2 = com.moloco.sdk.internal.client_metrics_data.b.Result;
                    aVar.t(cVar2.d(bVar2.c(), "success").d(com.moloco.sdk.internal.client_metrics_data.b.AdType.c(), b0Var.name()).d("initial_sdk_init_state", str.toString()));
                    aVar.u(fVar4.f(bVar2.c(), "success"));
                    if (viewParentE instanceof a0) {
                        ((a0) viewParentE).setCreateAdObjectStartTime(j11);
                    }
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, "AdCreator", "Created " + b0Var + " ad with adUnitId: " + this.f17874p, null, false, 12, null);
                    return new t.b(viewParentE);
                }
                hVar = this;
                fVar2 = fVar4;
            } else {
                hVar = this;
                fVar2 = fVar;
            }
            MolocoAdError.AdCreateError adCreateErrorB = c.this.b(hVar.f17874p, str, fVar2, b0Var);
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, "AdCreator", "Failed to create " + b0Var + " with reason: " + adCreateErrorB, null, false, 12, null);
            return new t.a(adCreateErrorB);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.AdCreator$createNativeAd$2", f = "AdCreator.kt", l = {206}, m = "invokeSuspend")
    public static final class i extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super com.moloco.sdk.internal.t<NativeAd, MolocoAdError.AdCreateError>>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f17876j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f17877k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f17878l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f17879m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f17880n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ String f17882p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ String f17883q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(String str, String str2, z8.d<? super i> dVar) {
            super(2, dVar);
            this.f17882p = str;
            this.f17883q = str2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super com.moloco.sdk.internal.t<NativeAd, MolocoAdError.AdCreateError>> dVar) {
            return ((i) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return c.this.new i(this.f17882p, this.f17883q, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE;
            com.moloco.sdk.acm.f fVar;
            long j10;
            b0 b0Var;
            String str;
            i iVar;
            com.moloco.sdk.acm.f fVar2;
            Object objE2 = a9.d.e();
            int i10 = this.f17880n;
            if (i10 == 0) {
                v8.u.b(obj);
                b0 b0Var2 = b0.NATIVE_AD_MEDIATION;
                long jA = c.this.f17832b.a();
                String strG = c.this.g();
                com.moloco.sdk.acm.f fVarF = com.moloco.sdk.acm.a.f17293a.w(com.moloco.sdk.internal.client_metrics_data.c.CreateAd.c()).f(com.moloco.sdk.internal.client_metrics_data.b.AdType.c(), b0Var2.name()).f("initial_sdk_init_state", strG);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, "AdCreator", "Creating " + b0Var2 + " ad with adUnitId: " + this.f17882p, null, false, 12, null);
                c cVar = c.this;
                h9.l lVar = cVar.f17834d;
                this.f17876j = b0Var2;
                this.f17877k = strG;
                this.f17878l = fVarF;
                this.f17879m = jA;
                this.f17880n = 1;
                objE = cVar.e(lVar, b0Var2, this);
                if (objE == objE2) {
                    return objE2;
                }
                fVar = fVarF;
                j10 = jA;
                b0Var = b0Var2;
                str = strG;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j10 = this.f17879m;
                com.moloco.sdk.acm.f fVar3 = (com.moloco.sdk.acm.f) this.f17878l;
                String str2 = (String) this.f17877k;
                b0 b0Var3 = (b0) this.f17876j;
                v8.u.b(obj);
                b0Var = b0Var3;
                str = str2;
                fVar = fVar3;
                objE = obj;
            }
            com.moloco.sdk.internal.b bVar = (com.moloco.sdk.internal.b) objE;
            if (bVar != null) {
                Context contextA = com.moloco.sdk.service_locator.a.f18869a.a();
                com.moloco.sdk.internal.services.m mVarB = a.b.f18871a.b();
                com.moloco.sdk.internal.services.x xVarC = a.e.f18889a.c();
                String str3 = this.f17882p;
                a.h hVar = a.h.f18920a;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t tVarH = hVar.h();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z zVarD = hVar.d();
                com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVarC = a.i.f18932a.c();
                com.moloco.sdk.internal.a aVarG = hVar.g();
                long j11 = j10;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.s sVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.s(this.f17883q);
                AdFormatType adFormatType = AdFormatType.NATIVE;
                MediationInfo mediationInfo$moloco_sdk_release = Moloco.INSTANCE.getMediationInfo$moloco_sdk_release();
                com.moloco.sdk.acm.f fVar4 = fVar;
                NativeAd nativeAdB = bVar.b(contextA, mVarB, xVarC, str3, tVarH, zVarD, iVarC, aVarG, sVar, new com.moloco.sdk.internal.publisher.a(adFormatType, com.moloco.sdk.internal.mediators.a.c(mediationInfo$moloco_sdk_release != null ? mediationInfo$moloco_sdk_release.getName() : null), null), hVar.f());
                if (nativeAdB != null) {
                    com.moloco.sdk.acm.a aVar = com.moloco.sdk.acm.a.f17293a;
                    com.moloco.sdk.acm.c cVar2 = new com.moloco.sdk.acm.c(com.moloco.sdk.internal.client_metrics_data.a.CreateAd.c());
                    com.moloco.sdk.internal.client_metrics_data.b bVar2 = com.moloco.sdk.internal.client_metrics_data.b.Result;
                    aVar.t(cVar2.d(bVar2.c(), "success").d(com.moloco.sdk.internal.client_metrics_data.b.AdType.c(), b0Var.name()).d("initial_sdk_init_state", str.toString()));
                    aVar.u(fVar4.f(bVar2.c(), "success"));
                    if (nativeAdB instanceof a0) {
                        ((a0) nativeAdB).setCreateAdObjectStartTime(j11);
                    }
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, "AdCreator", "Created " + b0Var + " ad with adUnitId: " + this.f17882p, null, false, 12, null);
                    return new t.b(nativeAdB);
                }
                iVar = this;
                fVar2 = fVar4;
            } else {
                iVar = this;
                fVar2 = fVar;
            }
            MolocoAdError.AdCreateError adCreateErrorB = c.this.b(iVar.f17882p, str, fVar2, b0Var);
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, "AdCreator", "Failed to create " + b0Var + " with reason: " + adCreateErrorB, null, false, 12, null);
            return new t.a(adCreateErrorB);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.publisher.AdCreator$createRewardedInterstitial$2", f = "AdCreator.kt", l = {291}, m = "invokeSuspend")
    public static final class j extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super com.moloco.sdk.internal.t<RewardedInterstitialAd, MolocoAdError.AdCreateError>>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f17884j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f17885k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f17886l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f17887m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f17888n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ String f17890p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ String f17891q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(String str, String str2, z8.d<? super j> dVar) {
            super(2, dVar);
            this.f17890p = str;
            this.f17891q = str2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super com.moloco.sdk.internal.t<RewardedInterstitialAd, MolocoAdError.AdCreateError>> dVar) {
            return ((j) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return c.this.new j(this.f17890p, this.f17891q, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE;
            com.moloco.sdk.acm.f fVar;
            long j10;
            b0 b0Var;
            String str;
            j jVar;
            com.moloco.sdk.acm.f fVar2;
            Object objE2 = a9.d.e();
            int i10 = this.f17888n;
            if (i10 == 0) {
                v8.u.b(obj);
                b0 b0Var2 = b0.REWARDED;
                long jInvoke = c.this.f17832b.invoke();
                String strG = c.this.g();
                com.moloco.sdk.acm.f fVarF = com.moloco.sdk.acm.a.f17293a.w(com.moloco.sdk.internal.client_metrics_data.c.CreateAd.c()).f(com.moloco.sdk.internal.client_metrics_data.b.AdType.c(), b0Var2.name()).f("initial_sdk_init_state", strG);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, "AdCreator", "Creating " + b0Var2 + " ad with adUnitId: " + this.f17890p, null, false, 12, null);
                c cVar = c.this;
                h9.l lVar = cVar.f17834d;
                this.f17884j = b0Var2;
                this.f17885k = strG;
                this.f17886l = fVarF;
                this.f17887m = jInvoke;
                this.f17888n = 1;
                objE = cVar.e(lVar, b0Var2, this);
                if (objE == objE2) {
                    return objE2;
                }
                fVar = fVarF;
                j10 = jInvoke;
                b0Var = b0Var2;
                str = strG;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j10 = this.f17887m;
                com.moloco.sdk.acm.f fVar3 = (com.moloco.sdk.acm.f) this.f17886l;
                String str2 = (String) this.f17885k;
                b0 b0Var3 = (b0) this.f17884j;
                v8.u.b(obj);
                b0Var = b0Var3;
                str = str2;
                fVar = fVar3;
                objE = obj;
            }
            com.moloco.sdk.internal.b bVar = (com.moloco.sdk.internal.b) objE;
            if (bVar != null) {
                Context contextA = com.moloco.sdk.service_locator.a.f18869a.a();
                com.moloco.sdk.internal.services.m mVarB = a.b.f18871a.b();
                String str3 = this.f17890p;
                a.h hVar = a.h.f18920a;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t tVarH = hVar.h();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z zVarD = hVar.d();
                com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVarC = a.i.f18932a.c();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.s sVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.s(this.f17891q);
                AdFormatType adFormatType = AdFormatType.REWARDED;
                MediationInfo mediationInfo$moloco_sdk_release = Moloco.INSTANCE.getMediationInfo$moloco_sdk_release();
                long j11 = j10;
                com.moloco.sdk.acm.f fVar4 = fVar;
                RewardedInterstitialAd rewardedInterstitialAdF = bVar.f(contextA, mVarB, str3, tVarH, zVarD, iVarC, sVar, new com.moloco.sdk.internal.publisher.a(adFormatType, com.moloco.sdk.internal.mediators.a.b(mediationInfo$moloco_sdk_release != null ? mediationInfo$moloco_sdk_release.getName() : null), null));
                if (rewardedInterstitialAdF != null) {
                    com.moloco.sdk.acm.a aVar = com.moloco.sdk.acm.a.f17293a;
                    com.moloco.sdk.acm.c cVar2 = new com.moloco.sdk.acm.c(com.moloco.sdk.internal.client_metrics_data.a.CreateAd.c());
                    com.moloco.sdk.internal.client_metrics_data.b bVar2 = com.moloco.sdk.internal.client_metrics_data.b.Result;
                    aVar.t(cVar2.d(bVar2.c(), "success").d(com.moloco.sdk.internal.client_metrics_data.b.AdType.c(), b0Var.name()).d("initial_sdk_init_state", str));
                    aVar.u(fVar4.f(bVar2.c(), "success"));
                    if (rewardedInterstitialAdF instanceof a0) {
                        ((a0) rewardedInterstitialAdF).setCreateAdObjectStartTime(j11);
                    }
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, "AdCreator", "Created " + b0Var + " ad with adUnitId: " + this.f17890p, null, false, 12, null);
                    return new t.b(rewardedInterstitialAdF);
                }
                jVar = this;
                fVar2 = fVar4;
            } else {
                jVar = this;
                fVar2 = fVar;
            }
            MolocoAdError.AdCreateError adCreateErrorB = c.this.b(jVar.f17890p, str, fVar2, b0Var);
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, "AdCreator", "Failed to create " + b0Var + " with reason: " + adCreateErrorB, null, false, 12, null);
            return new t.a(adCreateErrorB);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(@NotNull m0<? extends Initialization> initializationState, @NotNull com.moloco.sdk.internal.services.r timeProviderService, @NotNull com.moloco.sdk.internal.publisher.e adCreatorConfiguration, @NotNull h9.l<? super z8.d<? super com.moloco.sdk.internal.b>, ? extends Object> awaitAdFactory) {
        kotlin.jvm.internal.t.i(initializationState, "initializationState");
        kotlin.jvm.internal.t.i(timeProviderService, "timeProviderService");
        kotlin.jvm.internal.t.i(adCreatorConfiguration, "adCreatorConfiguration");
        kotlin.jvm.internal.t.i(awaitAdFactory, "awaitAdFactory");
        this.f17831a = initializationState;
        this.f17832b = timeProviderService;
        this.f17833c = adCreatorConfiguration;
        this.f17834d = awaitAdFactory;
        this.f17835e = com.moloco.sdk.internal.scheduling.c.a().getDefault();
    }

    public final MolocoAdError.AdCreateError b(String str, String str2, com.moloco.sdk.acm.f fVar, b0 b0Var) {
        com.moloco.sdk.acm.c cVar = new com.moloco.sdk.acm.c(com.moloco.sdk.internal.client_metrics_data.a.CreateAd.c());
        com.moloco.sdk.internal.client_metrics_data.b bVar = com.moloco.sdk.internal.client_metrics_data.b.Result;
        com.moloco.sdk.acm.c cVarD = cVar.d(bVar.c(), "failure").d("initial_sdk_init_state", str2).d(com.moloco.sdk.internal.client_metrics_data.b.AdType.c(), b0Var.name());
        Initialization value = this.f17831a.getValue();
        int i10 = value == null ? -1 : b.f17836a[value.ordinal()];
        if (i10 == -1) {
            com.moloco.sdk.internal.error.b bVarC = a.b.f18871a.c();
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE_");
            String upperCase = b0Var.name().toUpperCase(Locale.ROOT);
            kotlin.jvm.internal.t.h(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            sb.append(upperCase);
            sb.append("_AD_FAILED_SDK_INIT_NOT_COMPLETED");
            b.a.a(bVarC, sb.toString(), null, 2, null);
            com.moloco.sdk.acm.a aVar = com.moloco.sdk.acm.a.f17293a;
            com.moloco.sdk.acm.f fVarF = fVar.f(bVar.c(), "failure");
            com.moloco.sdk.internal.client_metrics_data.b bVar2 = com.moloco.sdk.internal.client_metrics_data.b.Reason;
            aVar.u(fVarF.f(bVar2.c(), "sdk_init_not_completed"));
            aVar.t(cVarD.d(bVar2.c(), "sdk_init_not_completed"));
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "AdCreator", "Cannot retrieve AdFactory as SDK init was not called or not completed", null, false, 12, null);
            return MolocoAdError.AdCreateError.SDK_INIT_WAS_NOT_COMPLETED;
        }
        if (i10 == 1) {
            b.a.a(a.b.f18871a.c(), "UNABLE_TO_CREATE_AD", null, 2, null);
            com.moloco.sdk.acm.a aVar2 = com.moloco.sdk.acm.a.f17293a;
            com.moloco.sdk.acm.f fVarF2 = fVar.f(bVar.c(), "failure");
            com.moloco.sdk.internal.client_metrics_data.b bVar3 = com.moloco.sdk.internal.client_metrics_data.b.Reason;
            aVar2.u(fVarF2.f(bVar3.c(), "unable_to_create_ad"));
            aVar2.t(cVarD.d(bVar3.c(), "unable_to_create_ad"));
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "AdCreator", "Could not find the adUnitId that was requested for load: " + str, null, false, 12, null);
            return MolocoAdError.AdCreateError.UNABLE_TO_CREATE_AD;
        }
        if (i10 != 2) {
            throw new v8.q();
        }
        com.moloco.sdk.internal.error.b bVarC2 = a.b.f18871a.c();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CREATE_");
        String upperCase2 = b0Var.name().toUpperCase(Locale.ROOT);
        kotlin.jvm.internal.t.h(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        sb2.append(upperCase2);
        sb2.append("_AD_FAILED_SDK_INIT_FAILED");
        b.a.a(bVarC2, sb2.toString(), null, 2, null);
        com.moloco.sdk.acm.a aVar3 = com.moloco.sdk.acm.a.f17293a;
        com.moloco.sdk.acm.f fVarF3 = fVar.f(bVar.c(), "failure");
        com.moloco.sdk.internal.client_metrics_data.b bVar4 = com.moloco.sdk.internal.client_metrics_data.b.Reason;
        aVar3.u(fVarF3.f(bVar4.c(), "sdk_init_failed"));
        aVar3.t(cVarD.d(bVar4.c(), "sdk_init_failed"));
        MolocoLogger.error$default(MolocoLogger.INSTANCE, "AdCreator", "Cannot create AdFactory as SDK init was failure", null, false, 12, null);
        return MolocoAdError.AdCreateError.SDK_INIT_FAILED;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @android.annotation.SuppressLint({"RestrictedApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(h9.l<? super z8.d<? super com.moloco.sdk.internal.b>, ? extends java.lang.Object> r18, com.moloco.sdk.internal.publisher.b0 r19, z8.d<? super com.moloco.sdk.internal.b> r20) {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.c.e(h9.l, com.moloco.sdk.internal.publisher.b0, z8.d):java.lang.Object");
    }

    @Nullable
    public final Object f(@NotNull String str, @Nullable String str2, @NotNull z8.d<? super com.moloco.sdk.internal.t<Banner, MolocoAdError.AdCreateError>> dVar) {
        return kotlinx.coroutines.i.g(this.f17835e, new e(str, str2, null), dVar);
    }

    public final String g() {
        String strName;
        Initialization value = this.f17831a.getValue();
        if (value != null && (strName = value.name()) != null) {
            String lowerCase = strName.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.t.h(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (lowerCase != null) {
                return lowerCase;
            }
        }
        return "not_invoked_or_in_progress";
    }

    @Nullable
    public final Object i(@NotNull String str, @Nullable String str2, @NotNull z8.d<? super com.moloco.sdk.internal.t<Banner, MolocoAdError.AdCreateError>> dVar) {
        return kotlinx.coroutines.i.g(this.f17835e, new f(str, str2, null), dVar);
    }

    @Nullable
    public final Object j(@NotNull String str, @Nullable String str2, @NotNull z8.d<? super com.moloco.sdk.internal.t<InterstitialAd, MolocoAdError.AdCreateError>> dVar) {
        return kotlinx.coroutines.i.g(this.f17835e, new g(str, str2, null), dVar);
    }

    @Nullable
    public final Object l(@NotNull String str, @Nullable String str2, @NotNull z8.d<? super com.moloco.sdk.internal.t<Banner, MolocoAdError.AdCreateError>> dVar) {
        return kotlinx.coroutines.i.g(this.f17835e, new h(str, str2, null), dVar);
    }

    @Nullable
    public final Object m(@NotNull String str, @Nullable String str2, @NotNull z8.d<? super com.moloco.sdk.internal.t<NativeAd, MolocoAdError.AdCreateError>> dVar) {
        return kotlinx.coroutines.i.g(this.f17835e, new i(str, str2, null), dVar);
    }

    @Nullable
    public final Object n(@NotNull String str, @Nullable String str2, @NotNull z8.d<? super com.moloco.sdk.internal.t<RewardedInterstitialAd, MolocoAdError.AdCreateError>> dVar) {
        return kotlinx.coroutines.i.g(this.f17835e, new j(str, str2, null), dVar);
    }
}
