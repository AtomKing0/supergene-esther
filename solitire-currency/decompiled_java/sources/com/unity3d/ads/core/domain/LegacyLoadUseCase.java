package com.unity3d.ads.core.domain;

import android.content.Context;
import com.google.protobuf.ByteString;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.model.LoadResult;
import com.unity3d.ads.core.data.model.OperationType;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.LegacyLoadUseCase;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import com.unity3d.ads.core.extensions.TimeExtensionsKt;
import com.unity3d.services.banners.UnityBannerSize;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import gatewayprotocol.v1.AdRequestOuterClass;
import gatewayprotocol.v1.BannerSizeKt;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import gatewayprotocol.v1.HeaderBiddingAdMarkupOuterClass;
import h9.p;
import java.util.Map;
import kotlin.collections.r0;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.i;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import p9.q;
import q9.j;
import q9.k;
import v8.u;
import v8.y;

/* JADX INFO: compiled from: LegacyLoadUseCase.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class LegacyLoadUseCase {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final String KEY_AD_MARKUP = "adMarkup";

    @NotNull
    public static final String KEY_OBJECT_ID = "objectId";

    @NotNull
    private final AdRepository adRepository;

    @NotNull
    private final AwaitInitialization awaitInitialization;

    @NotNull
    private final k0 dispatcher;

    @NotNull
    private final GetInitializationState getInitializationState;
    private boolean isBanner;
    private boolean isHeaderBidding;

    @Nullable
    private IUnityAdsLoadListener listener;

    @NotNull
    private final Load load;

    @Nullable
    private UnityAdsLoadOptions loadOptions;

    @Nullable
    private ByteString opportunity;

    @Nullable
    private String placement;

    @NotNull
    private final SendDiagnosticEvent sendDiagnosticEvent;

    @NotNull
    private final SessionRepository sessionRepository;

    @Nullable
    private j startTime;

    /* JADX INFO: compiled from: LegacyLoadUseCase.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.LegacyLoadUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: LegacyLoadUseCase.kt */
    @f(c = "com.unity3d.ads.core.domain.LegacyLoadUseCase", f = "LegacyLoadUseCase.kt", l = {91, 152, 153, 163}, m = "invoke")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(z8.d<? super AnonymousClass1> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LegacyLoadUseCase.this.invoke(null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.LegacyLoadUseCase$loadFailure$2, reason: invalid class name */
    /* JADX INFO: compiled from: LegacyLoadUseCase.kt */
    @f(c = "com.unity3d.ads.core.domain.LegacyLoadUseCase$loadFailure$2", f = "LegacyLoadUseCase.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<o0, z8.d<? super v8.k0>, Object> {
        final /* synthetic */ LoadResult.Failure $loadResult;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(LoadResult.Failure failure, z8.d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$loadResult = failure;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(LegacyLoadUseCase legacyLoadUseCase, LoadResult.Failure failure) {
            IUnityAdsLoadListener iUnityAdsLoadListener = legacyLoadUseCase.listener;
            if (iUnityAdsLoadListener != null) {
                iUnityAdsLoadListener.onUnityAdsFailedToLoad(legacyLoadUseCase.placement, failure.getError(), failure.getMessage());
            }
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return LegacyLoadUseCase.this.new AnonymousClass2(this.$loadResult, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            final LegacyLoadUseCase legacyLoadUseCase = LegacyLoadUseCase.this;
            final LoadResult.Failure failure = this.$loadResult;
            Utilities.wrapCustomerListener(new Runnable() { // from class: com.unity3d.ads.core.domain.c
                @Override // java.lang.Runnable
                public final void run() {
                    LegacyLoadUseCase.AnonymousClass2.invokeSuspend$lambda$0(legacyLoadUseCase, failure);
                }
            });
            return v8.k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.LegacyLoadUseCase$loadSuccess$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LegacyLoadUseCase.kt */
    @f(c = "com.unity3d.ads.core.domain.LegacyLoadUseCase$loadSuccess$2", f = "LegacyLoadUseCase.kt", l = {}, m = "invokeSuspend")
    static final class C31822 extends l implements p<o0, z8.d<? super v8.k0>, Object> {
        int label;

        C31822(z8.d<? super C31822> dVar) {
            super(2, dVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(LegacyLoadUseCase legacyLoadUseCase) {
            IUnityAdsLoadListener iUnityAdsLoadListener = legacyLoadUseCase.listener;
            if (iUnityAdsLoadListener != null) {
                iUnityAdsLoadListener.onUnityAdsAdLoaded(legacyLoadUseCase.placement);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return LegacyLoadUseCase.this.new C31822(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            final LegacyLoadUseCase legacyLoadUseCase = LegacyLoadUseCase.this;
            Utilities.wrapCustomerListener(new Runnable() { // from class: com.unity3d.ads.core.domain.d
                @Override // java.lang.Runnable
                public final void run() {
                    LegacyLoadUseCase.C31822.invokeSuspend$lambda$0(legacyLoadUseCase);
                }
            });
            return v8.k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((C31822) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    public LegacyLoadUseCase(@NotNull k0 dispatcher, @NotNull Load load, @NotNull SendDiagnosticEvent sendDiagnosticEvent, @NotNull GetInitializationState getInitializationState, @NotNull AwaitInitialization awaitInitialization, @NotNull SessionRepository sessionRepository, @NotNull AdRepository adRepository) {
        t.i(dispatcher, "dispatcher");
        t.i(load, "load");
        t.i(sendDiagnosticEvent, "sendDiagnosticEvent");
        t.i(getInitializationState, "getInitializationState");
        t.i(awaitInitialization, "awaitInitialization");
        t.i(sessionRepository, "sessionRepository");
        t.i(adRepository, "adRepository");
        this.dispatcher = dispatcher;
        this.load = load;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.getInitializationState = getInitializationState;
        this.awaitInitialization = awaitInitialization;
        this.sessionRepository = sessionRepository;
        this.adRepository = adRepository;
    }

    private final String getAdMarkup(UnityAdsLoadOptions unityAdsLoadOptions) {
        Object objOpt;
        JSONObject data = unityAdsLoadOptions.getData();
        if (data == null || (objOpt = data.opt("adMarkup")) == null) {
            return null;
        }
        return objOpt.toString();
    }

    private final DiagnosticEventRequestOuterClass.DiagnosticAdType getAdType() {
        return this.isBanner ? DiagnosticEventRequestOuterClass.DiagnosticAdType.DIAGNOSTIC_AD_TYPE_BANNER : DiagnosticEventRequestOuterClass.DiagnosticAdType.DIAGNOSTIC_AD_TYPE_FULLSCREEN;
    }

    private final AdRequestOuterClass.BannerSize getBannerSize(UnityBannerSize unityBannerSize) {
        if (unityBannerSize == null) {
            return null;
        }
        BannerSizeKt.Dsl.Companion companion = BannerSizeKt.Dsl.Companion;
        AdRequestOuterClass.BannerSize.Builder builderNewBuilder = AdRequestOuterClass.BannerSize.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        BannerSizeKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setWidth(unityBannerSize.getWidth());
        dsl_create.setHeight(unityBannerSize.getHeight());
        return dsl_create._build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup getHeaderBiddingAdMarkup(String str) {
        if (str == null || q.z(str)) {
            return HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup.getDefaultInstance();
        }
        try {
            return HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup.parseFrom(ProtobufExtensionsKt.fromBase64(str).toByteArray());
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getOpportunityId(UnityAdsLoadOptions unityAdsLoadOptions) {
        Object objOpt;
        JSONObject data = unityAdsLoadOptions.getData();
        if (data == null || (objOpt = data.opt("objectId")) == null) {
            return null;
        }
        return objOpt.toString();
    }

    private final Map<String, String> getTags(String str, String str2) {
        Map<String, String> mapL = r0.l(y.a("state", this.getInitializationState.invoke().toString()), y.a("operation", OperationType.LOAD.toString()));
        if (!(str == null || str.length() == 0)) {
            mapL.put("reason", str);
        }
        if (!(str2 == null || str2.length() == 0)) {
            mapL.put("reason_debug", str2);
        }
        return mapL;
    }

    static /* synthetic */ Map getTags$default(LegacyLoadUseCase legacyLoadUseCase, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        return legacyLoadUseCase.getTags(str, str2);
    }

    private final AdObject getTmpAdObject() {
        ByteString byteString = this.opportunity;
        if (byteString == null) {
            byteString = ByteString.EMPTY;
        }
        ByteString byteString2 = byteString;
        t.h(byteString2, "opportunity ?: ByteString.EMPTY");
        String str = this.placement;
        if (str == null) {
            str = "";
        }
        String str2 = str;
        ByteString EMPTY = ByteString.EMPTY;
        t.h(EMPTY, "EMPTY");
        UnityAdsLoadOptions unityAdsLoadOptions = this.loadOptions;
        if (unityAdsLoadOptions == null) {
            unityAdsLoadOptions = new UnityAdsLoadOptions();
        }
        return new AdObject(byteString2, str2, EMPTY, null, null, unityAdsLoadOptions, Boolean.valueOf(this.isHeaderBidding), getAdType(), 16, null);
    }

    public static /* synthetic */ Object invoke$default(LegacyLoadUseCase legacyLoadUseCase, Context context, String str, UnityAdsLoadOptions unityAdsLoadOptions, IUnityAdsLoadListener iUnityAdsLoadListener, UnityBannerSize unityBannerSize, z8.d dVar, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            unityBannerSize = null;
        }
        return legacyLoadUseCase.invoke(context, str, unityAdsLoadOptions, iUnityAdsLoadListener, unityBannerSize, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadFailure(LoadResult.Failure failure, z8.d<? super v8.k0> dVar) {
        DeviceLog.debug("Unity Ads Load Failure for placement: " + this.placement + " reason: " + failure.getError() + " :: " + failure.getMessage());
        SendDiagnosticEvent sendDiagnosticEvent = this.sendDiagnosticEvent;
        j jVar = this.startTime;
        SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, "native_load_failure_time", jVar != null ? kotlin.coroutines.jvm.internal.b.b(TimeExtensionsKt.elapsedMillis(jVar)) : null, getTags(failure.getReason(), failure.getReasonDebug()), null, getTmpAdObject(), 8, null);
        Object objG = i.g(this.dispatcher, new AnonymousClass2(failure, null), dVar);
        return objG == a9.d.e() ? objG : v8.k0.f35197a;
    }

    private final j loadStart() {
        long jA = q9.k.f33196a.a();
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_load_started", null, getTags$default(this, null, null, 3, null), null, getTmpAdObject(), 10, null);
        return k.a.c(jA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadSuccess(AdObject adObject, z8.d<? super v8.k0> dVar) {
        DeviceLog.debug("Unity Ads Load Success for placement: " + this.placement);
        SendDiagnosticEvent sendDiagnosticEvent = this.sendDiagnosticEvent;
        j jVar = this.startTime;
        SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, "native_load_success_time", jVar != null ? kotlin.coroutines.jvm.internal.b.b(TimeExtensionsKt.elapsedMillis(jVar)) : null, getTags$default(this, null, null, 3, null), null, adObject, 8, null);
        Object objG = i.g(this.dispatcher, new C31822(null), dVar);
        return objG == a9.d.e() ? objG : v8.k0.f35197a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull android.content.Context r27, @org.jetbrains.annotations.Nullable java.lang.String r28, @org.jetbrains.annotations.NotNull com.unity3d.ads.UnityAdsLoadOptions r29, @org.jetbrains.annotations.Nullable com.unity3d.ads.IUnityAdsLoadListener r30, @org.jetbrains.annotations.Nullable com.unity3d.services.banners.UnityBannerSize r31, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r32) {
        /*
            Method dump skipped, instruction units count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.LegacyLoadUseCase.invoke(android.content.Context, java.lang.String, com.unity3d.ads.UnityAdsLoadOptions, com.unity3d.ads.IUnityAdsLoadListener, com.unity3d.services.banners.UnityBannerSize, z8.d):java.lang.Object");
    }
}
