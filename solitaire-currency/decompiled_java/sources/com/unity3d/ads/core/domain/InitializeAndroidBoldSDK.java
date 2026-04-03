package com.unity3d.ads.core.domain;

import com.unity3d.ads.UnityAds;
import com.unity3d.ads.core.data.manager.SDKPropertiesManager;
import com.unity3d.ads.core.data.manager.StorageManager;
import com.unity3d.ads.core.data.model.InitializationState;
import com.unity3d.ads.core.data.model.OperationType;
import com.unity3d.ads.core.data.model.exception.InitializationException;
import com.unity3d.ads.core.data.repository.DiagnosticEventRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.domain.events.EventObservers;
import com.unity3d.ads.core.domain.om.InitializeOMSDK;
import com.unity3d.ads.core.extensions.TimeExtensionsKt;
import com.unity3d.ads.gatewayclient.GatewayClient;
import com.unity3d.services.core.configuration.ConfigurationReader;
import com.unity3d.services.core.log.DeviceLog;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import h9.p;
import java.util.Map;
import kotlin.collections.q0;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.i;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q9.j;

/* JADX INFO: compiled from: InitializeAndroidBoldSDK.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InitializeAndroidBoldSDK implements InitializeBoldSDK {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final String MSG_GATEWAY_DENIED = "Gateway communication failure";

    @NotNull
    public static final String MSG_NETWORK = "Network";

    @NotNull
    public static final String MSG_TIMEOUT = "Timeout";

    @NotNull
    public static final String MSG_UNKNOWN = "Initialization failure";

    @NotNull
    private final ClearCache clearCache;

    @NotNull
    private final k0 defaultDispatcher;

    @NotNull
    private final DiagnosticEventRepository diagnosticEventRepository;

    @NotNull
    private final EventObservers eventObservers;

    @NotNull
    private final GatewayClient gatewayClient;

    @NotNull
    private final GetInitializationRequest getInitializeRequest;

    @NotNull
    private final GetRequestPolicy getRequestPolicy;

    @NotNull
    private final HandleGatewayInitializationResponse handleGatewayInitializationResponse;

    @NotNull
    private final InitializeOMSDK initializeOM;

    @NotNull
    private final ConfigurationReader legacyConfigurationReader;

    @NotNull
    private final SDKPropertiesManager sdkPropertiesManager;

    @NotNull
    private final SendDiagnosticEvent sendDiagnosticEvent;

    @NotNull
    private final SessionRepository sessionRepository;

    @NotNull
    private final StorageManager storageManager;

    @NotNull
    private final TriggerInitializeListener triggerInitializeListener;

    /* JADX INFO: compiled from: InitializeAndroidBoldSDK.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.InitializeAndroidBoldSDK$initializationSuccess$1, reason: invalid class name */
    /* JADX INFO: compiled from: InitializeAndroidBoldSDK.kt */
    @f(c = "com.unity3d.ads.core.domain.InitializeAndroidBoldSDK", f = "InitializeAndroidBoldSDK.kt", l = {94, 95, 97}, m = "initializationSuccess")
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
            return InitializeAndroidBoldSDK.this.initializationSuccess(null, this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.InitializeAndroidBoldSDK$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: InitializeAndroidBoldSDK.kt */
    @f(c = "com.unity3d.ads.core.domain.InitializeAndroidBoldSDK$invoke$2", f = "InitializeAndroidBoldSDK.kt", l = {60, 74}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<o0, z8.d<? super v8.k0>, Object> {
        long J$0;
        int label;

        /* JADX INFO: renamed from: com.unity3d.ads.core.domain.InitializeAndroidBoldSDK$invoke$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: InitializeAndroidBoldSDK.kt */
        @f(c = "com.unity3d.ads.core.domain.InitializeAndroidBoldSDK$invoke$2$1", f = "InitializeAndroidBoldSDK.kt", l = {61, 63, 65, 66}, m = "invokeSuspend")
        static final class AnonymousClass1 extends l implements p<o0, z8.d<? super v8.k0>, Object> {
            int label;
            final /* synthetic */ InitializeAndroidBoldSDK this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(InitializeAndroidBoldSDK initializeAndroidBoldSDK, z8.d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.this$0 = initializeAndroidBoldSDK;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new AnonymousClass1(this.this$0, dVar);
            }

            /* JADX WARN: Removed duplicated region for block: B:22:0x0070 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:25:0x008e A[RETURN] */
            @Override // kotlin.coroutines.jvm.internal.a
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) throws com.unity3d.ads.core.data.model.exception.InitializationException {
                /*
                    r12 = this;
                    java.lang.Object r0 = a9.b.e()
                    int r1 = r12.label
                    r2 = 4
                    r3 = 3
                    r4 = 2
                    r5 = 1
                    if (r1 == 0) goto L2d
                    if (r1 == r5) goto L29
                    if (r1 == r4) goto L25
                    if (r1 == r3) goto L21
                    if (r1 != r2) goto L19
                    v8.u.b(r13)
                    goto L8f
                L19:
                    java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r13.<init>(r0)
                    throw r13
                L21:
                    v8.u.b(r13)
                    goto L71
                L25:
                    v8.u.b(r13)
                    goto L4f
                L29:
                    v8.u.b(r13)
                    goto L3b
                L2d:
                    v8.u.b(r13)
                    com.unity3d.ads.core.domain.InitializeAndroidBoldSDK r13 = r12.this$0
                    r12.label = r5
                    java.lang.Object r13 = com.unity3d.ads.core.domain.InitializeAndroidBoldSDK.access$initializationStart(r13, r12)
                    if (r13 != r0) goto L3b
                    return r0
                L3b:
                    com.unity3d.ads.core.domain.InitializeAndroidBoldSDK r13 = r12.this$0
                    com.unity3d.ads.core.domain.InitializeAndroidBoldSDK.access$checkCanInitialize(r13)
                    com.unity3d.ads.core.domain.InitializeAndroidBoldSDK r13 = r12.this$0
                    com.unity3d.ads.core.domain.GetInitializationRequest r13 = com.unity3d.ads.core.domain.InitializeAndroidBoldSDK.access$getGetInitializeRequest$p(r13)
                    r12.label = r4
                    java.lang.Object r13 = r13.invoke(r12)
                    if (r13 != r0) goto L4f
                    return r0
                L4f:
                    r6 = r13
                    gatewayprotocol.v1.UniversalRequestOuterClass$UniversalRequest r6 = (gatewayprotocol.v1.UniversalRequestOuterClass.UniversalRequest) r6
                    com.unity3d.ads.core.domain.InitializeAndroidBoldSDK r13 = r12.this$0
                    com.unity3d.ads.core.domain.GetRequestPolicy r13 = com.unity3d.ads.core.domain.InitializeAndroidBoldSDK.access$getGetRequestPolicy$p(r13)
                    com.unity3d.ads.gatewayclient.RequestPolicy r7 = r13.invoke()
                    com.unity3d.ads.core.domain.InitializeAndroidBoldSDK r13 = r12.this$0
                    com.unity3d.ads.gatewayclient.GatewayClient r4 = com.unity3d.ads.core.domain.InitializeAndroidBoldSDK.access$getGatewayClient$p(r13)
                    r5 = 0
                    com.unity3d.ads.core.data.model.OperationType r8 = com.unity3d.ads.core.data.model.OperationType.INITIALIZATION
                    r10 = 1
                    r11 = 0
                    r12.label = r3
                    r9 = r12
                    java.lang.Object r13 = com.unity3d.ads.gatewayclient.GatewayClient.DefaultImpls.request$default(r4, r5, r6, r7, r8, r9, r10, r11)
                    if (r13 != r0) goto L71
                    return r0
                L71:
                    gatewayprotocol.v1.UniversalResponseOuterClass$UniversalResponse r13 = (gatewayprotocol.v1.UniversalResponseOuterClass.UniversalResponse) r13
                    com.unity3d.ads.core.domain.InitializeAndroidBoldSDK r1 = r12.this$0
                    com.unity3d.ads.core.domain.HandleGatewayInitializationResponse r1 = com.unity3d.ads.core.domain.InitializeAndroidBoldSDK.access$getHandleGatewayInitializationResponse$p(r1)
                    gatewayprotocol.v1.UniversalResponseOuterClass$UniversalResponse$Payload r13 = r13.getPayload()
                    gatewayprotocol.v1.InitializationResponseOuterClass$InitializationResponse r13 = r13.getInitializationResponse()
                    java.lang.String r3 = "response.payload.initializationResponse"
                    kotlin.jvm.internal.t.h(r13, r3)
                    r12.label = r2
                    java.lang.Object r13 = r1.invoke(r13, r12)
                    if (r13 != r0) goto L8f
                    return r0
                L8f:
                    v8.k0 r13 = v8.k0.f35197a
                    return r13
                */
                throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.InitializeAndroidBoldSDK.AnonymousClass2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
                return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
            }
        }

        AnonymousClass2(z8.d<? super AnonymousClass2> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return InitializeAndroidBoldSDK.this.new AnonymousClass2(dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0050 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = a9.b.e()
                int r1 = r8.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                v8.u.b(r9)
                goto L51
            L12:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1a:
                long r3 = r8.J$0
                v8.u.b(r9)     // Catch: java.lang.Exception -> L20
                goto L42
            L20:
                r9 = move-exception
                goto L56
            L22:
                v8.u.b(r9)
                q9.k r9 = q9.k.f33196a
                long r4 = r9.a()
                com.unity3d.ads.core.domain.InitializeAndroidBoldSDK$invoke$2$1 r9 = new com.unity3d.ads.core.domain.InitializeAndroidBoldSDK$invoke$2$1     // Catch: java.lang.Exception -> L54
                com.unity3d.ads.core.domain.InitializeAndroidBoldSDK r1 = com.unity3d.ads.core.domain.InitializeAndroidBoldSDK.this     // Catch: java.lang.Exception -> L54
                r6 = 0
                r9.<init>(r1, r6)     // Catch: java.lang.Exception -> L54
                r8.J$0 = r4     // Catch: java.lang.Exception -> L54
                r8.label = r3     // Catch: java.lang.Exception -> L54
                r6 = 120000(0x1d4c0, double:5.9288E-319)
                java.lang.Object r9 = kotlinx.coroutines.f3.c(r6, r9, r8)     // Catch: java.lang.Exception -> L54
                if (r9 != r0) goto L41
                return r0
            L41:
                r3 = r4
            L42:
                com.unity3d.ads.core.domain.InitializeAndroidBoldSDK r9 = com.unity3d.ads.core.domain.InitializeAndroidBoldSDK.this
                q9.k$a r1 = q9.k.a.c(r3)
                r8.label = r2
                java.lang.Object r9 = com.unity3d.ads.core.domain.InitializeAndroidBoldSDK.access$initializationSuccess(r9, r1, r8)
                if (r9 != r0) goto L51
                return r0
            L51:
                v8.k0 r9 = v8.k0.f35197a
                return r9
            L54:
                r9 = move-exception
                r3 = r4
            L56:
                com.unity3d.ads.core.data.model.exception.InitializationException$Companion r0 = com.unity3d.ads.core.data.model.exception.InitializationException.Companion
                com.unity3d.ads.core.data.model.exception.InitializationException r9 = r0.parseFrom(r9)
                com.unity3d.ads.core.domain.InitializeAndroidBoldSDK r0 = com.unity3d.ads.core.domain.InitializeAndroidBoldSDK.this
                q9.k$a r1 = q9.k.a.c(r3)
                com.unity3d.ads.core.domain.InitializeAndroidBoldSDK.access$initializationFailure(r0, r1, r9)
                v8.k0 r9 = v8.k0.f35197a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.InitializeAndroidBoldSDK.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    public InitializeAndroidBoldSDK(@NotNull k0 defaultDispatcher, @NotNull InitializeOMSDK initializeOM, @NotNull GetInitializationRequest getInitializeRequest, @NotNull GetRequestPolicy getRequestPolicy, @NotNull ClearCache clearCache, @NotNull HandleGatewayInitializationResponse handleGatewayInitializationResponse, @NotNull GatewayClient gatewayClient, @NotNull SessionRepository sessionRepository, @NotNull EventObservers eventObservers, @NotNull TriggerInitializeListener triggerInitializeListener, @NotNull SendDiagnosticEvent sendDiagnosticEvent, @NotNull DiagnosticEventRepository diagnosticEventRepository, @NotNull StorageManager storageManager, @NotNull ConfigurationReader legacyConfigurationReader, @NotNull SDKPropertiesManager sdkPropertiesManager) {
        t.i(defaultDispatcher, "defaultDispatcher");
        t.i(initializeOM, "initializeOM");
        t.i(getInitializeRequest, "getInitializeRequest");
        t.i(getRequestPolicy, "getRequestPolicy");
        t.i(clearCache, "clearCache");
        t.i(handleGatewayInitializationResponse, "handleGatewayInitializationResponse");
        t.i(gatewayClient, "gatewayClient");
        t.i(sessionRepository, "sessionRepository");
        t.i(eventObservers, "eventObservers");
        t.i(triggerInitializeListener, "triggerInitializeListener");
        t.i(sendDiagnosticEvent, "sendDiagnosticEvent");
        t.i(diagnosticEventRepository, "diagnosticEventRepository");
        t.i(storageManager, "storageManager");
        t.i(legacyConfigurationReader, "legacyConfigurationReader");
        t.i(sdkPropertiesManager, "sdkPropertiesManager");
        this.defaultDispatcher = defaultDispatcher;
        this.initializeOM = initializeOM;
        this.getInitializeRequest = getInitializeRequest;
        this.getRequestPolicy = getRequestPolicy;
        this.clearCache = clearCache;
        this.handleGatewayInitializationResponse = handleGatewayInitializationResponse;
        this.gatewayClient = gatewayClient;
        this.sessionRepository = sessionRepository;
        this.eventObservers = eventObservers;
        this.triggerInitializeListener = triggerInitializeListener;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.diagnosticEventRepository = diagnosticEventRepository;
        this.storageManager = storageManager;
        this.legacyConfigurationReader = legacyConfigurationReader;
        this.sdkPropertiesManager = sdkPropertiesManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkCanInitialize() throws InitializationException {
        if (!this.sessionRepository.getShouldInitialize()) {
            throw new InitializationException(MSG_GATEWAY_DENIED, null, "gateway", "!sessionRepository.shouldInitialize", 2, null);
        }
    }

    private final Map<String, String> getTags(InitializationException initializationException) {
        Map mapC = q0.c();
        mapC.put("operation", OperationType.INITIALIZATION.toString());
        mapC.put("reason", initializationException.getReason());
        if (initializationException.getReasonDebug() != null) {
            mapC.put("reason_debug", initializationException.getReasonDebug());
        }
        return q0.b(mapC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initializationFailure(j jVar, InitializationException initializationException) {
        DeviceLog.debug("Unity Ads Initialization Failure: " + initializationException.getMessage());
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_initialize_task_failure_time", Double.valueOf(TimeExtensionsKt.elapsedMillis(jVar)), getTags(initializationException), null, null, 24, null);
        this.triggerInitializeListener.error(UnityAds.UnityAdsInitializationError.INTERNAL_ERROR, initializationException.getMessage());
        this.sessionRepository.setInitializationState(InitializationState.FAILED);
        this.sdkPropertiesManager.setInitialized(false);
        setupDiagnosticEvents();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object initializationStart(z8.d<? super v8.k0> dVar) {
        DeviceLog.debug("Unity Ads Initialization Start");
        SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_initialization_started", null, null, null, null, 30, null);
        this.sessionRepository.setInitializationState(InitializationState.INITIALIZING);
        Object objInvoke = this.eventObservers.invoke(dVar);
        return objInvoke == a9.d.e() ? objInvoke : v8.k0.f35197a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0098 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object initializationSuccess(q9.j r17, z8.d<? super v8.k0> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.unity3d.ads.core.domain.InitializeAndroidBoldSDK.AnonymousClass1
            if (r2 == 0) goto L17
            r2 = r1
            com.unity3d.ads.core.domain.InitializeAndroidBoldSDK$initializationSuccess$1 r2 = (com.unity3d.ads.core.domain.InitializeAndroidBoldSDK.AnonymousClass1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1c
        L17:
            com.unity3d.ads.core.domain.InitializeAndroidBoldSDK$initializationSuccess$1 r2 = new com.unity3d.ads.core.domain.InitializeAndroidBoldSDK$initializationSuccess$1
            r2.<init>(r1)
        L1c:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = a9.b.e()
            int r4 = r2.label
            r5 = 3
            r6 = 2
            r7 = 1
            if (r4 == 0) goto L4f
            if (r4 == r7) goto L47
            if (r4 == r6) goto L3f
            if (r4 != r5) goto L37
            java.lang.Object r2 = r2.L$0
            com.unity3d.ads.core.domain.InitializeAndroidBoldSDK r2 = (com.unity3d.ads.core.domain.InitializeAndroidBoldSDK) r2
            v8.u.b(r1)
            goto L9a
        L37:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3f:
            java.lang.Object r4 = r2.L$0
            com.unity3d.ads.core.domain.InitializeAndroidBoldSDK r4 = (com.unity3d.ads.core.domain.InitializeAndroidBoldSDK) r4
            v8.u.b(r1)
            goto L8c
        L47:
            java.lang.Object r4 = r2.L$0
            com.unity3d.ads.core.domain.InitializeAndroidBoldSDK r4 = (com.unity3d.ads.core.domain.InitializeAndroidBoldSDK) r4
            v8.u.b(r1)
            goto L7f
        L4f:
            v8.u.b(r1)
            java.lang.String r1 = "Unity Ads Initialization Success"
            com.unity3d.services.core.log.DeviceLog.debug(r1)
            com.unity3d.ads.core.domain.SendDiagnosticEvent r8 = r0.sendDiagnosticEvent
            java.lang.String r9 = "native_initialize_task_success_time"
            double r10 = com.unity3d.ads.core.extensions.TimeExtensionsKt.elapsedMillis(r17)
            java.lang.Double r10 = kotlin.coroutines.jvm.internal.b.b(r10)
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 28
            r15 = 0
            com.unity3d.ads.core.domain.SendDiagnosticEvent.DefaultImpls.invoke$default(r8, r9, r10, r11, r12, r13, r14, r15)
            com.unity3d.ads.core.data.manager.StorageManager r1 = r0.storageManager
            r1.hasInitialized()
            com.unity3d.ads.core.domain.om.InitializeOMSDK r1 = r0.initializeOM
            r2.L$0 = r0
            r2.label = r7
            java.lang.Object r1 = r1.invoke(r2)
            if (r1 != r3) goto L7e
            return r3
        L7e:
            r4 = r0
        L7f:
            com.unity3d.ads.core.domain.ClearCache r1 = r4.clearCache
            r2.L$0 = r4
            r2.label = r6
            java.lang.Object r1 = r1.invoke(r2)
            if (r1 != r3) goto L8c
            return r3
        L8c:
            com.unity3d.ads.core.data.repository.SessionRepository r1 = r4.sessionRepository
            r2.L$0 = r4
            r2.label = r5
            java.lang.Object r1 = r1.persistNativeConfiguration(r2)
            if (r1 != r3) goto L99
            return r3
        L99:
            r2 = r4
        L9a:
            com.unity3d.services.core.configuration.ConfigurationReader r1 = r2.legacyConfigurationReader
            com.unity3d.services.core.configuration.Configuration r1 = r1.getCurrentConfiguration()
            r1.deleteFromDisk()
            com.unity3d.ads.core.domain.TriggerInitializeListener r1 = r2.triggerInitializeListener
            r1.success()
            com.unity3d.ads.core.data.repository.SessionRepository r1 = r2.sessionRepository
            com.unity3d.ads.core.data.model.InitializationState r3 = com.unity3d.ads.core.data.model.InitializationState.INITIALIZED
            r1.setInitializationState(r3)
            com.unity3d.ads.core.data.manager.SDKPropertiesManager r1 = r2.sdkPropertiesManager
            r1.setInitialized(r7)
            r2.setupDiagnosticEvents()
            v8.k0 r1 = v8.k0.f35197a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.InitializeAndroidBoldSDK.initializationSuccess(q9.j, z8.d):java.lang.Object");
    }

    private final void setupDiagnosticEvents() {
        NativeConfigurationOuterClass.DiagnosticEventsConfiguration config = this.sessionRepository.getNativeConfiguration().getDiagnosticEvents();
        DiagnosticEventRepository diagnosticEventRepository = this.diagnosticEventRepository;
        t.h(config, "config");
        diagnosticEventRepository.configure(config);
    }

    @Override // com.unity3d.ads.core.domain.InitializeBoldSDK
    @Nullable
    public Object invoke(@NotNull z8.d<? super v8.k0> dVar) {
        Object objG = i.g(this.defaultDispatcher, new AnonymousClass2(null), dVar);
        return objG == a9.d.e() ? objG : v8.k0.f35197a;
    }
}
