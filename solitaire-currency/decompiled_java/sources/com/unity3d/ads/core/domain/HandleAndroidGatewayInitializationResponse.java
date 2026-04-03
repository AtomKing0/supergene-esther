package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.manager.TransactionEventManager;
import com.unity3d.ads.core.data.model.exception.GatewayException;
import com.unity3d.ads.core.data.repository.SessionRepository;
import gatewayprotocol.v1.InitializationResponseOuterClass;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: HandleAndroidGatewayInitializationResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class HandleAndroidGatewayInitializationResponse implements HandleGatewayInitializationResponse {

    @NotNull
    private final o0 sdkScope;

    @NotNull
    private final SessionRepository sessionRepository;

    @NotNull
    private final TransactionEventManager transactionEventManager;

    @NotNull
    private final TriggerInitializationCompletedRequest triggerInitializationCompletedRequest;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.HandleAndroidGatewayInitializationResponse$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: HandleAndroidGatewayInitializationResponse.kt */
    @f(c = "com.unity3d.ads.core.domain.HandleAndroidGatewayInitializationResponse$invoke$2", f = "HandleAndroidGatewayInitializationResponse.kt", l = {35}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<o0, z8.d<? super k0>, Object> {
        int label;

        AnonymousClass2(z8.d<? super AnonymousClass2> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return HandleAndroidGatewayInitializationResponse.this.new AnonymousClass2(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                TriggerInitializationCompletedRequest triggerInitializationCompletedRequest = HandleAndroidGatewayInitializationResponse.this.triggerInitializationCompletedRequest;
                this.label = 1;
                if (triggerInitializationCompletedRequest.invoke(this) == objE) {
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
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    public HandleAndroidGatewayInitializationResponse(@NotNull TransactionEventManager transactionEventManager, @NotNull TriggerInitializationCompletedRequest triggerInitializationCompletedRequest, @NotNull SessionRepository sessionRepository, @NotNull o0 sdkScope) {
        t.i(transactionEventManager, "transactionEventManager");
        t.i(triggerInitializationCompletedRequest, "triggerInitializationCompletedRequest");
        t.i(sessionRepository, "sessionRepository");
        t.i(sdkScope, "sdkScope");
        this.transactionEventManager = transactionEventManager;
        this.triggerInitializationCompletedRequest = triggerInitializationCompletedRequest;
        this.sessionRepository = sessionRepository;
        this.sdkScope = sdkScope;
    }

    @Override // com.unity3d.ads.core.domain.HandleGatewayInitializationResponse
    @Nullable
    public Object invoke(@NotNull InitializationResponseOuterClass.InitializationResponse initializationResponse, @NotNull z8.d<? super k0> dVar) throws GatewayException {
        if (initializationResponse.hasError()) {
            String errorText = initializationResponse.getError().getErrorText();
            t.h(errorText, "response.error.errorText");
            throw new GatewayException(errorText, new IllegalStateException(initializationResponse.getError().getErrorText()), "gateway_initialization", initializationResponse.getError().getErrorText());
        }
        SessionRepository sessionRepository = this.sessionRepository;
        NativeConfigurationOuterClass.NativeConfiguration nativeConfiguration = initializationResponse.getNativeConfiguration();
        t.h(nativeConfiguration, "response.nativeConfiguration");
        sessionRepository.setNativeConfiguration(nativeConfiguration);
        if (initializationResponse.hasUniversalRequestUrl()) {
            String universalRequestUrl = initializationResponse.getUniversalRequestUrl();
            if (!(universalRequestUrl == null || universalRequestUrl.length() == 0)) {
                SessionRepository sessionRepository2 = this.sessionRepository;
                String universalRequestUrl2 = initializationResponse.getUniversalRequestUrl();
                t.h(universalRequestUrl2, "response.universalRequestUrl");
                sessionRepository2.setGatewayUrl(universalRequestUrl2);
            }
        }
        if (initializationResponse.getTriggerInitializationCompletedRequest()) {
            k.d(this.sdkScope, null, null, new AnonymousClass2(null), 3, null);
        }
        if (initializationResponse.getNativeConfiguration().getEnableIapEvent()) {
            this.transactionEventManager.invoke();
        }
        return k0.f35197a;
    }
}
