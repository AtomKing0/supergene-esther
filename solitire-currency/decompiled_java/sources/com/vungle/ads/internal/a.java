package com.vungle.ads.internal;

import android.content.Context;
import android.content.Intent;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.b2;
import com.vungle.ads.f0;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.ui.a;
import com.vungle.ads.internal.util.c;
import com.vungle.ads.q0;
import com.vungle.ads.v1;
import com.vungle.ads.w1;
import com.vungle.ads.z1;
import java.lang.ref.WeakReference;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AdInternal.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a implements com.vungle.ads.internal.load.a {

    @NotNull
    private static final String TAG = "AdInternal";
    private static final boolean THROW_ON_ILLEGAL_TRANSITION = false;

    @Nullable
    private com.vungle.ads.internal.load.a adLoaderCallback;

    @NotNull
    private EnumC0499a adState;

    @Nullable
    private com.vungle.ads.internal.model.b advertisement;

    @Nullable
    private com.vungle.ads.internal.load.d baseAdLoader;

    @Nullable
    private com.vungle.ads.internal.model.e bidPayload;

    @NotNull
    private final Context context;

    @Nullable
    private com.vungle.ads.internal.model.j placement;

    @Nullable
    private WeakReference<Context> playContext;

    @Nullable
    private w1 requestMetric;

    @NotNull
    private final v8.l signalManager$delegate;

    @NotNull
    private final v8.l vungleApiClient$delegate;

    @NotNull
    public static final c Companion = new c(null);

    @NotNull
    private static final kotlinx.serialization.json.a json = kotlinx.serialization.json.m.b(null, b.INSTANCE, 1, null);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: com.vungle.ads.internal.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdInternal.kt */
    public static final class EnumC0499a {
        public static final EnumC0499a NEW = new d("NEW", 0);
        public static final EnumC0499a LOADING = new c("LOADING", 1);
        public static final EnumC0499a READY = new f("READY", 2);
        public static final EnumC0499a PLAYING = new e("PLAYING", 3);
        public static final EnumC0499a FINISHED = new b("FINISHED", 4);
        public static final EnumC0499a ERROR = new C0500a("ERROR", 5);
        private static final /* synthetic */ EnumC0499a[] $VALUES = $values();

        /* JADX INFO: renamed from: com.vungle.ads.internal.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AdInternal.kt */
        static final class C0500a extends EnumC0499a {
            C0500a(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.vungle.ads.internal.a.EnumC0499a
            public boolean canTransitionTo(@NotNull EnumC0499a adState) {
                kotlin.jvm.internal.t.i(adState, "adState");
                return adState == EnumC0499a.FINISHED;
            }
        }

        /* JADX INFO: renamed from: com.vungle.ads.internal.a$a$b */
        /* JADX INFO: compiled from: AdInternal.kt */
        static final class b extends EnumC0499a {
            b(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.vungle.ads.internal.a.EnumC0499a
            public boolean canTransitionTo(@NotNull EnumC0499a adState) {
                kotlin.jvm.internal.t.i(adState, "adState");
                return false;
            }
        }

        /* JADX INFO: renamed from: com.vungle.ads.internal.a$a$c */
        /* JADX INFO: compiled from: AdInternal.kt */
        static final class c extends EnumC0499a {
            c(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.vungle.ads.internal.a.EnumC0499a
            public boolean canTransitionTo(@NotNull EnumC0499a adState) {
                kotlin.jvm.internal.t.i(adState, "adState");
                return adState == EnumC0499a.READY || adState == EnumC0499a.ERROR;
            }
        }

        /* JADX INFO: renamed from: com.vungle.ads.internal.a$a$d */
        /* JADX INFO: compiled from: AdInternal.kt */
        static final class d extends EnumC0499a {
            d(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.vungle.ads.internal.a.EnumC0499a
            public boolean canTransitionTo(@NotNull EnumC0499a adState) {
                kotlin.jvm.internal.t.i(adState, "adState");
                return adState == EnumC0499a.LOADING || adState == EnumC0499a.READY || adState == EnumC0499a.ERROR;
            }
        }

        /* JADX INFO: renamed from: com.vungle.ads.internal.a$a$e */
        /* JADX INFO: compiled from: AdInternal.kt */
        static final class e extends EnumC0499a {
            e(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.vungle.ads.internal.a.EnumC0499a
            public boolean canTransitionTo(@NotNull EnumC0499a adState) {
                kotlin.jvm.internal.t.i(adState, "adState");
                return adState == EnumC0499a.FINISHED || adState == EnumC0499a.ERROR;
            }
        }

        /* JADX INFO: renamed from: com.vungle.ads.internal.a$a$f */
        /* JADX INFO: compiled from: AdInternal.kt */
        static final class f extends EnumC0499a {
            f(String str, int i10) {
                super(str, i10, null);
            }

            @Override // com.vungle.ads.internal.a.EnumC0499a
            public boolean canTransitionTo(@NotNull EnumC0499a adState) {
                kotlin.jvm.internal.t.i(adState, "adState");
                return adState == EnumC0499a.PLAYING || adState == EnumC0499a.FINISHED || adState == EnumC0499a.ERROR;
            }
        }

        private static final /* synthetic */ EnumC0499a[] $values() {
            return new EnumC0499a[]{NEW, LOADING, READY, PLAYING, FINISHED, ERROR};
        }

        public /* synthetic */ EnumC0499a(String str, int i10, kotlin.jvm.internal.k kVar) {
            this(str, i10);
        }

        public static EnumC0499a valueOf(String str) {
            return (EnumC0499a) Enum.valueOf(EnumC0499a.class, str);
        }

        public static EnumC0499a[] values() {
            return (EnumC0499a[]) $VALUES.clone();
        }

        public abstract boolean canTransitionTo(@NotNull EnumC0499a enumC0499a);

        public final boolean isTerminalState() {
            return kotlin.collections.v.n(FINISHED, ERROR).contains(this);
        }

        @NotNull
        public final EnumC0499a transitionTo(@NotNull EnumC0499a adState) {
            kotlin.jvm.internal.t.i(adState, "adState");
            if (this != adState && !canTransitionTo(adState)) {
                String str = "Cannot transition from " + name() + " to " + adState.name();
                if (a.THROW_ON_ILLEGAL_TRANSITION) {
                    throw new IllegalStateException(str);
                }
                com.vungle.ads.internal.util.p.Companion.e(a.TAG, "Illegal state transition", new IllegalStateException(str));
            }
            return adState;
        }

        private EnumC0499a(String str, int i10) {
        }
    }

    /* JADX INFO: compiled from: AdInternal.kt */
    static final class b extends kotlin.jvm.internal.v implements h9.l<kotlinx.serialization.json.c, k0> {
        public static final b INSTANCE = new b();

        b() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(kotlinx.serialization.json.c cVar) {
            invoke2(cVar);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull kotlinx.serialization.json.c Json) {
            kotlin.jvm.internal.t.i(Json, "$this$Json");
            Json.f(true);
            Json.d(true);
            Json.e(false);
        }
    }

    /* JADX INFO: compiled from: AdInternal.kt */
    public /* synthetic */ class d {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnumC0499a.values().length];
            iArr[EnumC0499a.NEW.ordinal()] = 1;
            iArr[EnumC0499a.LOADING.ordinal()] = 2;
            iArr[EnumC0499a.READY.ordinal()] = 3;
            iArr[EnumC0499a.PLAYING.ordinal()] = 4;
            iArr[EnumC0499a.FINISHED.ordinal()] = 5;
            iArr[EnumC0499a.ERROR.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class e extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.task.f> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.task.f, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.task.f invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.task.f.class);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class f extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.omsdk.c> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.omsdk.c, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.omsdk.c invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.omsdk.c.class);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class g extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.executor.d> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.executor.d, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.executor.d invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.executor.d.class);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class h extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.util.q> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.util.q, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.util.q invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.util.q.class);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class i extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.downloader.e> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.downloader.e, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.downloader.e invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.downloader.e.class);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class j extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.executor.d> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.executor.d, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.executor.d invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.executor.d.class);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class k extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.util.q> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.util.q, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.util.q invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.util.q.class);
        }
    }

    /* JADX INFO: compiled from: AdInternal.kt */
    public static final class l extends com.vungle.ads.internal.presenter.c {
        final /* synthetic */ a this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(com.vungle.ads.internal.presenter.b bVar, a aVar) {
            super(bVar);
            this.this$0 = aVar;
        }

        @Override // com.vungle.ads.internal.presenter.c, com.vungle.ads.internal.presenter.b
        public void onAdEnd(@Nullable String str) {
            this.this$0.setAdState(EnumC0499a.FINISHED);
            super.onAdEnd(str);
        }

        @Override // com.vungle.ads.internal.presenter.c, com.vungle.ads.internal.presenter.b
        public void onAdStart(@Nullable String str) {
            this.this$0.setAdState(EnumC0499a.PLAYING);
            super.onAdStart(str);
        }

        @Override // com.vungle.ads.internal.presenter.c, com.vungle.ads.internal.presenter.b
        public void onFailure(@NotNull b2 error) {
            kotlin.jvm.internal.t.i(error, "error");
            this.this$0.setAdState(EnumC0499a.ERROR);
            super.onFailure(error);
        }
    }

    /* JADX INFO: compiled from: AdInternal.kt */
    public static final class m extends com.vungle.ads.internal.presenter.a {
        m(com.vungle.ads.internal.presenter.b bVar, com.vungle.ads.internal.model.j jVar) {
            super(bVar, jVar);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class n extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.network.i> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.network.i, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.network.i invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.network.i.class);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class o extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.signals.b> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.signals.b, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.signals.b invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.signals.b.class);
        }
    }

    public a(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        this.context = context;
        this.adState = EnumC0499a.NEW;
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        v8.p pVar = v8.p.f35201a;
        this.vungleApiClient$delegate = v8.n.b(pVar, new n(context));
        this.signalManager$delegate = v8.n.b(pVar, new o(context));
    }

    /* JADX INFO: renamed from: _set_adState_$lambda-1$lambda-0, reason: not valid java name */
    private static final com.vungle.ads.internal.task.f m4028_set_adState_$lambda1$lambda0(v8.l<? extends com.vungle.ads.internal.task.f> lVar) {
        return lVar.getValue();
    }

    public static /* synthetic */ b2 canPlayAd$default(a aVar, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: canPlayAd");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return aVar.canPlayAd(z10);
    }

    private final com.vungle.ads.internal.signals.b getSignalManager() {
        return (com.vungle.ads.internal.signals.b) this.signalManager$delegate.getValue();
    }

    private final com.vungle.ads.internal.network.i getVungleApiClient() {
        return (com.vungle.ads.internal.network.i) this.vungleApiClient$delegate.getValue();
    }

    /* JADX INFO: renamed from: loadAd$lambda-2, reason: not valid java name */
    private static final com.vungle.ads.internal.omsdk.c m4029loadAd$lambda2(v8.l<com.vungle.ads.internal.omsdk.c> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: renamed from: loadAd$lambda-3, reason: not valid java name */
    private static final com.vungle.ads.internal.executor.d m4030loadAd$lambda3(v8.l<com.vungle.ads.internal.executor.d> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: renamed from: loadAd$lambda-4, reason: not valid java name */
    private static final com.vungle.ads.internal.util.q m4031loadAd$lambda4(v8.l<com.vungle.ads.internal.util.q> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: renamed from: loadAd$lambda-5, reason: not valid java name */
    private static final com.vungle.ads.internal.downloader.e m4032loadAd$lambda5(v8.l<? extends com.vungle.ads.internal.downloader.e> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: renamed from: onSuccess$lambda-9$lambda-6, reason: not valid java name */
    private static final com.vungle.ads.internal.executor.d m4033onSuccess$lambda9$lambda6(v8.l<com.vungle.ads.internal.executor.d> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: renamed from: onSuccess$lambda-9$lambda-7, reason: not valid java name */
    private static final com.vungle.ads.internal.util.q m4034onSuccess$lambda9$lambda7(v8.l<com.vungle.ads.internal.util.q> lVar) {
        return lVar.getValue();
    }

    public void adLoadedAndUpdateConfigure$vungle_ads_release(@NotNull com.vungle.ads.internal.model.b advertisement) {
        kotlin.jvm.internal.t.i(advertisement, "advertisement");
    }

    @Nullable
    public final b2 canPlayAd(boolean z10) {
        b2 q0Var;
        com.vungle.ads.internal.model.b bVar = this.advertisement;
        if (bVar == null) {
            q0Var = new com.vungle.ads.h();
        } else {
            boolean z11 = false;
            if (bVar != null && bVar.hasExpired()) {
                z11 = true;
            }
            if (z11) {
                q0Var = z10 ? new com.vungle.ads.e() : new com.vungle.ads.d();
            } else {
                EnumC0499a enumC0499a = this.adState;
                if (enumC0499a == EnumC0499a.PLAYING) {
                    q0Var = new f0();
                } else {
                    if (enumC0499a == EnumC0499a.READY) {
                        return null;
                    }
                    q0Var = new q0(0, null, null, null, null, null, 63, null);
                }
            }
        }
        if (z10) {
            com.vungle.ads.internal.model.j jVar = this.placement;
            b2 placementId$vungle_ads_release = q0Var.setPlacementId$vungle_ads_release(jVar != null ? jVar.getReferenceId() : null);
            com.vungle.ads.internal.model.b bVar2 = this.advertisement;
            b2 creativeId$vungle_ads_release = placementId$vungle_ads_release.setCreativeId$vungle_ads_release(bVar2 != null ? bVar2.getCreativeId() : null);
            com.vungle.ads.internal.model.b bVar3 = this.advertisement;
            creativeId$vungle_ads_release.setEventId$vungle_ads_release(bVar3 != null ? bVar3.eventId() : null).logErrorNoReturnValue$vungle_ads_release();
        }
        return q0Var;
    }

    public final void cancelDownload$vungle_ads_release() {
        com.vungle.ads.internal.load.d dVar = this.baseAdLoader;
        if (dVar != null) {
            dVar.cancel();
        }
    }

    @Nullable
    public abstract z1 getAdSizeForAdRequest();

    @NotNull
    public final EnumC0499a getAdState() {
        return this.adState;
    }

    @Nullable
    public final com.vungle.ads.internal.model.b getAdvertisement() {
        return this.advertisement;
    }

    @Nullable
    public final com.vungle.ads.internal.model.e getBidPayload() {
        return this.bidPayload;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    public final com.vungle.ads.internal.model.j getPlacement() {
        return this.placement;
    }

    public final boolean isErrorTerminal$vungle_ads_release(int i10) {
        return this.adState == EnumC0499a.READY && i10 == 304;
    }

    public abstract boolean isValidAdSize(@Nullable z1 z1Var);

    public abstract boolean isValidAdTypeForPlacement(@NotNull com.vungle.ads.internal.model.j jVar);

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0070, code lost:
    
        if ((r22 == null || r22.length() == 0) == false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void loadAd(@org.jetbrains.annotations.NotNull java.lang.String r21, @org.jetbrains.annotations.Nullable java.lang.String r22, @org.jetbrains.annotations.NotNull com.vungle.ads.internal.load.a r23) {
        /*
            Method dump skipped, instruction units count: 630
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.a.loadAd(java.lang.String, java.lang.String, com.vungle.ads.internal.load.a):void");
    }

    @Override // com.vungle.ads.internal.load.a
    public void onFailure(@NotNull b2 error) {
        kotlin.jvm.internal.t.i(error, "error");
        setAdState(EnumC0499a.ERROR);
        com.vungle.ads.internal.load.a aVar = this.adLoaderCallback;
        if (aVar != null) {
            aVar.onFailure(error);
        }
    }

    @Override // com.vungle.ads.internal.load.a
    public void onSuccess(@NotNull com.vungle.ads.internal.model.b advertisement) {
        kotlin.jvm.internal.t.i(advertisement, "advertisement");
        this.advertisement = advertisement;
        setAdState(EnumC0499a.READY);
        adLoadedAndUpdateConfigure$vungle_ads_release(advertisement);
        com.vungle.ads.internal.load.a aVar = this.adLoaderCallback;
        if (aVar != null) {
            aVar.onSuccess(advertisement);
        }
        w1 w1Var = this.requestMetric;
        if (w1Var != null) {
            if (!advertisement.adLoadOptimizationEnabled()) {
                w1Var.setMetricType(Sdk$SDKMetric.b.AD_REQUEST_TO_CALLBACK_DURATION_MS);
            }
            w1Var.markEnd();
            com.vungle.ads.o oVar = com.vungle.ads.o.INSTANCE;
            com.vungle.ads.internal.model.j jVar = this.placement;
            com.vungle.ads.o.logMetric$vungle_ads_release$default(oVar, w1Var, jVar != null ? jVar.getReferenceId() : null, advertisement.getCreativeId(), advertisement.eventId(), (String) null, 16, (Object) null);
            long jCalculateIntervalDuration = w1Var.calculateIntervalDuration();
            ServiceLocator.Companion companion = ServiceLocator.Companion;
            Context context = this.context;
            v8.p pVar = v8.p.f35201a;
            v8.l lVarB = v8.n.b(pVar, new j(context));
            v8.l lVarB2 = v8.n.b(pVar, new k(this.context));
            List tpatUrls$default = com.vungle.ads.internal.model.b.getTpatUrls$default(advertisement, com.vungle.ads.internal.l.AD_LOAD_DURATION_TPAT_KEY, String.valueOf(jCalculateIntervalDuration), null, 4, null);
            if (tpatUrls$default != null) {
                new com.vungle.ads.internal.network.g(getVungleApiClient(), advertisement.placementId(), advertisement.getCreativeId(), advertisement.eventId(), m4033onSuccess$lambda9$lambda6(lVarB).getIoExecutor(), m4034onSuccess$lambda9$lambda7(lVarB2), getSignalManager()).sendTpats(tpatUrls$default, m4033onSuccess$lambda9$lambda6(lVarB).getJobExecutor());
            }
        }
    }

    public final void play(@Nullable Context context, @NotNull com.vungle.ads.internal.presenter.b adPlayCallback) {
        kotlin.jvm.internal.t.i(adPlayCallback, "adPlayCallback");
        this.playContext = context != null ? new WeakReference<>(context) : null;
        b2 b2VarCanPlayAd = canPlayAd(true);
        if (b2VarCanPlayAd != null) {
            adPlayCallback.onFailure(b2VarCanPlayAd);
            if (isErrorTerminal$vungle_ads_release(b2VarCanPlayAd.getCode())) {
                setAdState(EnumC0499a.ERROR);
                return;
            }
            return;
        }
        com.vungle.ads.internal.model.b bVar = this.advertisement;
        if (bVar == null) {
            return;
        }
        l lVar = new l(adPlayCallback, this);
        cancelDownload$vungle_ads_release();
        renderAd$vungle_ads_release(lVar, bVar);
    }

    public void renderAd$vungle_ads_release(@Nullable com.vungle.ads.internal.presenter.b bVar, @NotNull com.vungle.ads.internal.model.b advertisement) {
        Context context;
        kotlin.jvm.internal.t.i(advertisement, "advertisement");
        a.C0532a c0532a = com.vungle.ads.internal.ui.a.Companion;
        c0532a.setEventListener$vungle_ads_release(new m(bVar, this.placement));
        c0532a.setAdvertisement$vungle_ads_release(advertisement);
        c0532a.setBidPayload$vungle_ads_release(this.bidPayload);
        WeakReference<Context> weakReference = this.playContext;
        if (weakReference == null || (context = weakReference.get()) == null) {
            context = this.context;
        }
        kotlin.jvm.internal.t.h(context, "playContext?.get() ?: context");
        com.vungle.ads.internal.model.j jVar = this.placement;
        if (jVar == null) {
            return;
        }
        Intent intentCreateIntent = c0532a.createIntent(context, jVar.getReferenceId(), advertisement.eventId());
        c.a aVar = com.vungle.ads.internal.util.c.Companion;
        if (!aVar.isForeground()) {
            com.vungle.ads.internal.util.p.Companion.d(TAG, "The ad activity is in background on play.");
            com.vungle.ads.o.INSTANCE.logMetric$vungle_ads_release(new v1(Sdk$SDKMetric.b.VIEW_NOT_VISIBLE_ON_PLAY), (30 & 2) != 0 ? null : jVar.getReferenceId(), (30 & 4) != 0 ? null : advertisement.getCreativeId(), (30 & 8) != 0 ? null : advertisement.eventId(), (30 & 16) != 0 ? null : null);
        }
        aVar.startWhenForeground(context, null, intentCreateIntent, null);
    }

    public final void setAdState(@NotNull EnumC0499a value) {
        com.vungle.ads.internal.model.b bVar;
        String strEventId;
        kotlin.jvm.internal.t.i(value, "value");
        if (value.isTerminalState() && (bVar = this.advertisement) != null && (strEventId = bVar.eventId()) != null) {
            ServiceLocator.Companion companion = ServiceLocator.Companion;
            m4028_set_adState_$lambda1$lambda0(v8.n.b(v8.p.f35201a, new e(this.context))).execute(com.vungle.ads.internal.task.a.Companion.makeJobInfo(strEventId));
        }
        this.adState = this.adState.transitionTo(value);
    }

    public final void setAdvertisement(@Nullable com.vungle.ads.internal.model.b bVar) {
        this.advertisement = bVar;
    }

    public final void setBidPayload(@Nullable com.vungle.ads.internal.model.e eVar) {
        this.bidPayload = eVar;
    }

    public final void setPlacement(@Nullable com.vungle.ads.internal.model.j jVar) {
        this.placement = jVar;
    }

    /* JADX INFO: compiled from: AdInternal.kt */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(kotlin.jvm.internal.k kVar) {
            this();
        }

        private static /* synthetic */ void getJson$annotations() {
        }
    }
}
