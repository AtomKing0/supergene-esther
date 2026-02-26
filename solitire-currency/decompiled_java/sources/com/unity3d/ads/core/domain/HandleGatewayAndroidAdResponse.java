package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import com.unity3d.ads.adplayer.AdPlayer;
import com.unity3d.ads.adplayer.AdPlayerScope;
import com.unity3d.ads.adplayer.AndroidWebViewContainer;
import com.unity3d.ads.adplayer.model.LoadEvent;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.data.repository.CampaignRepository;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.domain.events.GetOperativeEventApi;
import gatewayprotocol.v1.AdResponseOuterClass;
import gatewayprotocol.v1.AllowedPiiOuterClass;
import h9.p;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.s;
import v8.u;

/* JADX INFO: compiled from: HandleGatewayAndroidAdResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class HandleGatewayAndroidAdResponse implements HandleGatewayAdResponse {

    @NotNull
    private final AdPlayerScope adPlayerScope;

    @NotNull
    private final AdRepository adRepository;

    @NotNull
    private final CampaignRepository campaignRepository;

    @NotNull
    private final DeviceInfoRepository deviceInfoRepository;

    @NotNull
    private final GetAdPlayer getAdPlayer;

    @NotNull
    private final HandleInvocationsFromAdViewer getHandleInvocationsFromAdViewer;

    @NotNull
    private final GetLatestWebViewConfiguration getLatestWebViewConfiguration;

    @NotNull
    private final GetOperativeEventApi getOperativeEventApi;

    @NotNull
    private final GetWebViewBridgeUseCase getWebViewBridge;

    @NotNull
    private final AndroidGetWebViewContainerUseCase getWebViewContainerUseCase;

    @NotNull
    private final SendDiagnosticEvent sendDiagnosticEvent;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$cleanup$1, reason: invalid class name */
    /* JADX INFO: compiled from: HandleGatewayAndroidAdResponse.kt */
    @f(c = "com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse", f = "HandleGatewayAndroidAdResponse.kt", l = {199, 205}, m = "cleanup")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
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
            return HandleGatewayAndroidAdResponse.this.cleanup(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HandleGatewayAndroidAdResponse.kt */
    @f(c = "com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse", f = "HandleGatewayAndroidAdResponse.kt", l = {85, 118, 153, 162, 165, 177, 181}, m = "invoke")
    static final class C31811 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C31811(z8.d<? super C31811> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HandleGatewayAndroidAdResponse.this.invoke(null, null, null, null, null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: HandleGatewayAndroidAdResponse.kt */
    @f(c = "com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$2", f = "HandleGatewayAndroidAdResponse.kt", l = {123}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<AllowedPiiOuterClass.AllowedPii, z8.d<? super k0>, Object> {
        final /* synthetic */ n0<AdPlayer> $adPlayer;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(n0<AdPlayer> n0Var, z8.d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$adPlayer = n0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$adPlayer, dVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull AllowedPiiOuterClass.AllowedPii allowedPii, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass2) create(allowedPii, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                AllowedPiiOuterClass.AllowedPii allowedPii = (AllowedPiiOuterClass.AllowedPii) this.L$0;
                AdPlayer adPlayer = this.$adPlayer.f29834a;
                byte[] byteArray = allowedPii.toByteArray();
                t.h(byteArray, "it.toByteArray()");
                this.label = 1;
                if (adPlayer.onAllowedPiiChange(byteArray, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$3, reason: invalid class name */
    /* JADX INFO: compiled from: HandleGatewayAndroidAdResponse.kt */
    @f(c = "com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$3", f = "HandleGatewayAndroidAdResponse.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass3 extends l implements p<s<? extends byte[], ? extends Integer>, z8.d<? super k0>, Object> {
        final /* synthetic */ ByteString $opportunityId;
        final /* synthetic */ String $placementId;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(ByteString byteString, String str, z8.d<? super AnonymousClass3> dVar) {
            super(2, dVar);
            this.$opportunityId = byteString;
            this.$placementId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass3 anonymousClass3 = HandleGatewayAndroidAdResponse.this.new AnonymousClass3(this.$opportunityId, this.$placementId, dVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo4invoke(s<? extends byte[], ? extends Integer> sVar, z8.d<? super k0> dVar) {
            return invoke2((s<byte[], Integer>) sVar, dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0055  */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
            /*
                r6 = this;
                a9.b.e()
                int r0 = r6.label
                if (r0 != 0) goto L91
                v8.u.b(r7)
                java.lang.Object r7 = r6.L$0
                v8.s r7 = (v8.s) r7
                java.lang.Object r0 = r7.a()
                byte[] r0 = (byte[]) r0
                java.lang.Object r7 = r7.b()
                java.lang.Number r7 = (java.lang.Number) r7
                int r7 = r7.intValue()
                com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse r1 = com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse.this
                com.unity3d.ads.core.data.repository.CampaignRepository r1 = com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse.access$getCampaignRepository$p(r1)
                com.google.protobuf.ByteString r2 = r6.$opportunityId
                gatewayprotocol.v1.CampaignStateOuterClass$Campaign r1 = r1.getCampaign(r2)
                if (r1 == 0) goto L55
                gatewayprotocol.v1.CampaignKt$Dsl$Companion r2 = gatewayprotocol.v1.CampaignKt.Dsl.Companion
                com.google.protobuf.GeneratedMessageLite$Builder r1 = r1.toBuilder()
                java.lang.String r3 = "this.toBuilder()"
                kotlin.jvm.internal.t.h(r1, r3)
                gatewayprotocol.v1.CampaignStateOuterClass$Campaign$Builder r1 = (gatewayprotocol.v1.CampaignStateOuterClass.Campaign.Builder) r1
                gatewayprotocol.v1.CampaignKt$Dsl r1 = r2._create(r1)
                java.lang.String r2 = new java.lang.String
                java.nio.charset.Charset r3 = p9.d.f32957g
                r2.<init>(r0, r3)
                com.google.protobuf.ByteString r2 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.fromBase64(r2)
                r1.setData(r2)
                r1.setDataVersion(r7)
                gatewayprotocol.v1.CampaignStateOuterClass$Campaign r1 = r1._build()
                if (r1 == 0) goto L55
                goto L83
            L55:
                java.lang.String r1 = r6.$placementId
                com.google.protobuf.ByteString r2 = r6.$opportunityId
                gatewayprotocol.v1.CampaignKt$Dsl$Companion r3 = gatewayprotocol.v1.CampaignKt.Dsl.Companion
                gatewayprotocol.v1.CampaignStateOuterClass$Campaign$Builder r4 = gatewayprotocol.v1.CampaignStateOuterClass.Campaign.newBuilder()
                java.lang.String r5 = "newBuilder()"
                kotlin.jvm.internal.t.h(r4, r5)
                gatewayprotocol.v1.CampaignKt$Dsl r3 = r3._create(r4)
                java.lang.String r4 = new java.lang.String
                java.nio.charset.Charset r5 = p9.d.f32957g
                r4.<init>(r0, r5)
                com.google.protobuf.ByteString r0 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.fromBase64(r4)
                r3.setData(r0)
                r3.setDataVersion(r7)
                r3.setPlacementId(r1)
                r3.setImpressionOpportunityId(r2)
                gatewayprotocol.v1.CampaignStateOuterClass$Campaign r1 = r3._build()
            L83:
                com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse r7 = com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse.this
                com.unity3d.ads.core.data.repository.CampaignRepository r7 = com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse.access$getCampaignRepository$p(r7)
                com.google.protobuf.ByteString r0 = r6.$opportunityId
                r7.setCampaign(r0, r1)
                v8.k0 r7 = v8.k0.f35197a
                return r7
            L91:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull s<byte[], Integer> sVar, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass3) create(sVar, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$4, reason: invalid class name */
    /* JADX INFO: compiled from: HandleGatewayAndroidAdResponse.kt */
    @f(c = "com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$4", f = "HandleGatewayAndroidAdResponse.kt", l = {159}, m = "invokeSuspend")
    static final class AnonymousClass4 extends l implements h9.l<z8.d<? super k0>, Object> {
        final /* synthetic */ String $webViewUrl;
        final /* synthetic */ AndroidWebViewContainer $webviewContainer;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(AndroidWebViewContainer androidWebViewContainer, String str, z8.d<? super AnonymousClass4> dVar) {
            super(1, dVar);
            this.$webviewContainer = androidWebViewContainer;
            this.$webViewUrl = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@NotNull z8.d<?> dVar) {
            return new AnonymousClass4(this.$webviewContainer, this.$webViewUrl, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                AndroidWebViewContainer androidWebViewContainer = this.$webviewContainer;
                String str = this.$webViewUrl;
                this.label = 1;
                if (androidWebViewContainer.loadUrl(str, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }

        @Override // h9.l
        @Nullable
        public final Object invoke(@Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass4) create(dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$5, reason: invalid class name */
    /* JADX INFO: compiled from: HandleGatewayAndroidAdResponse.kt */
    @f(c = "com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$5", f = "HandleGatewayAndroidAdResponse.kt", l = {166}, m = "invokeSuspend")
    static final class AnonymousClass5 extends l implements p<o0, z8.d<? super k0>, Object> {
        final /* synthetic */ n0<AdPlayer> $adPlayer;
        final /* synthetic */ LoadEvent $loadEvent;
        final /* synthetic */ ByteString $opportunityId;
        final /* synthetic */ AdResponseOuterClass.AdResponse $response;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(LoadEvent loadEvent, ByteString byteString, AdResponseOuterClass.AdResponse adResponse, n0<AdPlayer> n0Var, z8.d<? super AnonymousClass5> dVar) {
            super(2, dVar);
            this.$loadEvent = loadEvent;
            this.$opportunityId = byteString;
            this.$response = adResponse;
            this.$adPlayer = n0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return HandleGatewayAndroidAdResponse.this.new AnonymousClass5(this.$loadEvent, this.$opportunityId, this.$response, this.$adPlayer, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                HandleGatewayAndroidAdResponse handleGatewayAndroidAdResponse = HandleGatewayAndroidAdResponse.this;
                Error error = new Error(((LoadEvent.Error) this.$loadEvent).getMessage());
                ByteString byteString = this.$opportunityId;
                AdResponseOuterClass.AdResponse adResponse = this.$response;
                AdPlayer adPlayer = this.$adPlayer.f29834a;
                this.label = 1;
                if (handleGatewayAndroidAdResponse.cleanup(error, byteString, adResponse, adPlayer, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass5) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$6, reason: invalid class name */
    /* JADX INFO: compiled from: HandleGatewayAndroidAdResponse.kt */
    @f(c = "com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$6", f = "HandleGatewayAndroidAdResponse.kt", l = {182}, m = "invokeSuspend")
    static final class AnonymousClass6 extends l implements p<o0, z8.d<? super k0>, Object> {
        final /* synthetic */ n0<AdPlayer> $adPlayer;
        final /* synthetic */ ByteString $opportunityId;
        final /* synthetic */ AdResponseOuterClass.AdResponse $response;
        final /* synthetic */ CancellationException $t;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(CancellationException cancellationException, ByteString byteString, AdResponseOuterClass.AdResponse adResponse, n0<AdPlayer> n0Var, z8.d<? super AnonymousClass6> dVar) {
            super(2, dVar);
            this.$t = cancellationException;
            this.$opportunityId = byteString;
            this.$response = adResponse;
            this.$adPlayer = n0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return HandleGatewayAndroidAdResponse.this.new AnonymousClass6(this.$t, this.$opportunityId, this.$response, this.$adPlayer, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                HandleGatewayAndroidAdResponse handleGatewayAndroidAdResponse = HandleGatewayAndroidAdResponse.this;
                CancellationException cancellationException = this.$t;
                ByteString byteString = this.$opportunityId;
                AdResponseOuterClass.AdResponse adResponse = this.$response;
                AdPlayer adPlayer = this.$adPlayer.f29834a;
                this.label = 1;
                if (handleGatewayAndroidAdResponse.cleanup(cancellationException, byteString, adResponse, adPlayer, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass6) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    public HandleGatewayAndroidAdResponse(@NotNull AdRepository adRepository, @NotNull AndroidGetWebViewContainerUseCase getWebViewContainerUseCase, @NotNull GetWebViewBridgeUseCase getWebViewBridge, @NotNull DeviceInfoRepository deviceInfoRepository, @NotNull HandleInvocationsFromAdViewer getHandleInvocationsFromAdViewer, @NotNull CampaignRepository campaignRepository, @NotNull SendDiagnosticEvent sendDiagnosticEvent, @NotNull GetOperativeEventApi getOperativeEventApi, @NotNull GetLatestWebViewConfiguration getLatestWebViewConfiguration, @NotNull AdPlayerScope adPlayerScope, @NotNull GetAdPlayer getAdPlayer) {
        t.i(adRepository, "adRepository");
        t.i(getWebViewContainerUseCase, "getWebViewContainerUseCase");
        t.i(getWebViewBridge, "getWebViewBridge");
        t.i(deviceInfoRepository, "deviceInfoRepository");
        t.i(getHandleInvocationsFromAdViewer, "getHandleInvocationsFromAdViewer");
        t.i(campaignRepository, "campaignRepository");
        t.i(sendDiagnosticEvent, "sendDiagnosticEvent");
        t.i(getOperativeEventApi, "getOperativeEventApi");
        t.i(getLatestWebViewConfiguration, "getLatestWebViewConfiguration");
        t.i(adPlayerScope, "adPlayerScope");
        t.i(getAdPlayer, "getAdPlayer");
        this.adRepository = adRepository;
        this.getWebViewContainerUseCase = getWebViewContainerUseCase;
        this.getWebViewBridge = getWebViewBridge;
        this.deviceInfoRepository = deviceInfoRepository;
        this.getHandleInvocationsFromAdViewer = getHandleInvocationsFromAdViewer;
        this.campaignRepository = campaignRepository;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.getOperativeEventApi = getOperativeEventApi;
        this.getLatestWebViewConfiguration = getLatestWebViewConfiguration;
        this.adPlayerScope = adPlayerScope;
        this.getAdPlayer = getAdPlayer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object cleanup(java.lang.Throwable r15, com.google.protobuf.ByteString r16, gatewayprotocol.v1.AdResponseOuterClass.AdResponse r17, com.unity3d.ads.adplayer.AdPlayer r18, z8.d<? super v8.k0> r19) {
        /*
            r14 = this;
            r0 = r14
            r1 = r19
            boolean r2 = r1 instanceof com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse.AnonymousClass1
            if (r2 == 0) goto L16
            r2 = r1
            com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$cleanup$1 r2 = (com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse.AnonymousClass1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L16
            int r3 = r3 - r4
            r2.label = r3
            goto L1b
        L16:
            com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$cleanup$1 r2 = new com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$cleanup$1
            r2.<init>(r1)
        L1b:
            java.lang.Object r1 = r2.result
            java.lang.Object r12 = a9.b.e()
            int r3 = r2.label
            r13 = 2
            r4 = 1
            if (r3 == 0) goto L41
            if (r3 == r4) goto L38
            if (r3 != r13) goto L30
            v8.u.b(r1)
            goto Lac
        L30:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L38:
            java.lang.Object r3 = r2.L$0
            com.unity3d.ads.adplayer.AdPlayer r3 = (com.unity3d.ads.adplayer.AdPlayer) r3
            v8.u.b(r1)
            r1 = r3
            goto L9e
        L41:
            v8.u.b(r1)
            gatewayprotocol.v1.OperativeEventErrorDataKt$Dsl$Companion r1 = gatewayprotocol.v1.OperativeEventErrorDataKt.Dsl.Companion
            gatewayprotocol.v1.OperativeEventRequestOuterClass$OperativeEventErrorData$Builder r3 = gatewayprotocol.v1.OperativeEventRequestOuterClass.OperativeEventErrorData.newBuilder()
            java.lang.String r5 = "newBuilder()"
            kotlin.jvm.internal.t.h(r3, r5)
            gatewayprotocol.v1.OperativeEventErrorDataKt$Dsl r1 = r1._create(r3)
            gatewayprotocol.v1.OperativeEventRequestOuterClass$OperativeEventErrorType r3 = gatewayprotocol.v1.OperativeEventRequestOuterClass.OperativeEventErrorType.OPERATIVE_EVENT_ERROR_TYPE_UNSPECIFIED
            r1.setErrorType(r3)
            java.lang.Throwable r3 = r15.getCause()
            if (r3 == 0) goto L64
            java.lang.String r3 = r3.getMessage()
            if (r3 != 0) goto L6c
        L64:
            java.lang.String r3 = r15.getMessage()
            if (r3 != 0) goto L6c
            java.lang.String r3 = ""
        L6c:
            r1.setMessage(r3)
            gatewayprotocol.v1.OperativeEventRequestOuterClass$OperativeEventErrorData r1 = r1._build()
            com.unity3d.ads.core.domain.events.GetOperativeEventApi r3 = r0.getOperativeEventApi
            gatewayprotocol.v1.OperativeEventRequestOuterClass$OperativeEventType r5 = gatewayprotocol.v1.OperativeEventRequestOuterClass.OperativeEventType.OPERATIVE_EVENT_TYPE_LOAD_ERROR
            com.google.protobuf.ByteString r6 = r17.getTrackingToken()
            java.lang.String r7 = "response.trackingToken"
            kotlin.jvm.internal.t.h(r6, r7)
            com.google.protobuf.ByteString r7 = r1.toByteString()
            java.lang.String r1 = "operativeEventErrorData.toByteString()"
            kotlin.jvm.internal.t.h(r7, r1)
            r8 = 0
            r10 = 16
            r11 = 0
            r1 = r18
            r2.L$0 = r1
            r2.label = r4
            r4 = r5
            r5 = r16
            r9 = r2
            java.lang.Object r3 = com.unity3d.ads.core.domain.events.GetOperativeEventApi.invoke$default(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            if (r3 != r12) goto L9e
            return r12
        L9e:
            if (r1 == 0) goto Laf
            r3 = 0
            r2.L$0 = r3
            r2.label = r13
            java.lang.Object r1 = r1.destroy(r2)
            if (r1 != r12) goto Lac
            return r12
        Lac:
            v8.k0 r1 = v8.k0.f35197a
            return r1
        Laf:
            v8.k0 r1 = v8.k0.f35197a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse.cleanup(java.lang.Throwable, com.google.protobuf.ByteString, gatewayprotocol.v1.AdResponseOuterClass$AdResponse, com.unity3d.ads.adplayer.AdPlayer, z8.d):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x00a3: MOVE (r12 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]) (LINE:164), block:B:26:0x00a3 */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0428 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b4 A[Catch: CancellationException -> 0x03e7, TryCatch #9 {CancellationException -> 0x03e7, blocks: (B:58:0x01a3, B:63:0x01b4, B:65:0x01ca, B:70:0x01e1, B:72:0x01ea, B:104:0x03d1, B:71:0x01e5), top: B:142:0x01a3, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01ca A[Catch: CancellationException -> 0x03e7, TryCatch #9 {CancellationException -> 0x03e7, blocks: (B:58:0x01a3, B:63:0x01b4, B:65:0x01ca, B:70:0x01e1, B:72:0x01ea, B:104:0x03d1, B:71:0x01e5), top: B:142:0x01a3, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0329 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0354 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x035b A[Catch: CancellationException -> 0x03cc, TryCatch #6 {CancellationException -> 0x03cc, blocks: (B:98:0x03c6, B:93:0x0386, B:87:0x0355, B:89:0x035b, B:95:0x03ab, B:84:0x032c), top: B:137:0x032c }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x03ab A[Catch: CancellationException -> 0x03cc, TryCatch #6 {CancellationException -> 0x03cc, blocks: (B:98:0x03c6, B:93:0x0386, B:87:0x0355, B:89:0x035b, B:95:0x03ab, B:84:0x032c), top: B:137:0x032c }] */
    /* JADX WARN: Type inference failed for: r13v10, types: [T, com.unity3d.ads.adplayer.AdPlayer] */
    /* JADX WARN: Type inference failed for: r40v1, types: [kotlin.jvm.internal.n0] */
    /* JADX WARN: Type inference failed for: r40v3, types: [kotlin.jvm.internal.n0] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.lang.Object, kotlin.jvm.internal.n0] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15, types: [java.lang.Object, kotlin.jvm.internal.n0] */
    /* JADX WARN: Type inference failed for: r5v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    @Override // com.unity3d.ads.core.domain.HandleGatewayAdResponse
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object invoke(@org.jetbrains.annotations.NotNull com.unity3d.ads.UnityAdsLoadOptions r35, @org.jetbrains.annotations.NotNull com.google.protobuf.ByteString r36, @org.jetbrains.annotations.NotNull gatewayprotocol.v1.AdResponseOuterClass.AdResponse r37, @org.jetbrains.annotations.NotNull android.content.Context r38, @org.jetbrains.annotations.NotNull java.lang.String r39, @org.jetbrains.annotations.NotNull gatewayprotocol.v1.DiagnosticEventRequestOuterClass.DiagnosticAdType r40, boolean r41, @org.jetbrains.annotations.NotNull z8.d<? super com.unity3d.ads.core.data.model.LoadResult> r42) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1096
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse.invoke(com.unity3d.ads.UnityAdsLoadOptions, com.google.protobuf.ByteString, gatewayprotocol.v1.AdResponseOuterClass$AdResponse, android.content.Context, java.lang.String, gatewayprotocol.v1.DiagnosticEventRequestOuterClass$DiagnosticAdType, boolean, z8.d):java.lang.Object");
    }
}
