package gatewayprotocol.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.AdDataRefreshRequestOuterClass;
import gatewayprotocol.v1.AdPlayerConfigRequestOuterClass;
import gatewayprotocol.v1.AdRequestOuterClass;
import gatewayprotocol.v1.DeveloperConsentOuterClass;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import gatewayprotocol.v1.GetTokenEventRequestOuterClass;
import gatewayprotocol.v1.InitializationCompletedEventRequestOuterClass;
import gatewayprotocol.v1.InitializationRequestOuterClass;
import gatewayprotocol.v1.OperativeEventRequestOuterClass;
import gatewayprotocol.v1.PiiOuterClass;
import gatewayprotocol.v1.PrivacyUpdateRequestOuterClass;
import gatewayprotocol.v1.TestDataOuterClass;
import gatewayprotocol.v1.TimestampsOuterClass;
import gatewayprotocol.v1.TransactionEventRequestOuterClass;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import h9.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: UniversalRequestKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UniversalRequestKt {

    @NotNull
    public static final UniversalRequestKt INSTANCE = new UniversalRequestKt();

    /* JADX INFO: compiled from: UniversalRequestKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final UniversalRequestOuterClass.UniversalRequest.Builder _builder;

        /* JADX INFO: compiled from: UniversalRequestKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(UniversalRequestOuterClass.UniversalRequest.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(UniversalRequestOuterClass.UniversalRequest.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ UniversalRequestOuterClass.UniversalRequest _build() {
            UniversalRequestOuterClass.UniversalRequest universalRequestBuild = this._builder.build();
            t.h(universalRequestBuild, "_builder.build()");
            return universalRequestBuild;
        }

        public final void clearPayload() {
            this._builder.clearPayload();
        }

        public final void clearSharedData() {
            this._builder.clearSharedData();
        }

        @NotNull
        public final UniversalRequestOuterClass.UniversalRequest.Payload getPayload() {
            UniversalRequestOuterClass.UniversalRequest.Payload payload = this._builder.getPayload();
            t.h(payload, "_builder.getPayload()");
            return payload;
        }

        @NotNull
        public final UniversalRequestOuterClass.UniversalRequest.SharedData getSharedData() {
            UniversalRequestOuterClass.UniversalRequest.SharedData sharedData = this._builder.getSharedData();
            t.h(sharedData, "_builder.getSharedData()");
            return sharedData;
        }

        public final boolean hasPayload() {
            return this._builder.hasPayload();
        }

        public final boolean hasSharedData() {
            return this._builder.hasSharedData();
        }

        public final void setPayload(@NotNull UniversalRequestOuterClass.UniversalRequest.Payload value) {
            t.i(value, "value");
            this._builder.setPayload(value);
        }

        public final void setSharedData(@NotNull UniversalRequestOuterClass.UniversalRequest.SharedData value) {
            t.i(value, "value");
            this._builder.setSharedData(value);
        }

        private Dsl(UniversalRequestOuterClass.UniversalRequest.Builder builder) {
            this._builder = builder;
        }
    }

    /* JADX INFO: compiled from: UniversalRequestKt.kt */
    public static final class PayloadKt {

        @NotNull
        public static final PayloadKt INSTANCE = new PayloadKt();

        /* JADX INFO: compiled from: UniversalRequestKt.kt */
        @ProtoDslMarker
        public static final class Dsl {

            @NotNull
            public static final Companion Companion = new Companion(null);

            @NotNull
            private final UniversalRequestOuterClass.UniversalRequest.Payload.Builder _builder;

            /* JADX INFO: compiled from: UniversalRequestKt.kt */
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(k kVar) {
                    this();
                }

                public final /* synthetic */ Dsl _create(UniversalRequestOuterClass.UniversalRequest.Payload.Builder builder) {
                    t.i(builder, "builder");
                    return new Dsl(builder, null);
                }
            }

            public /* synthetic */ Dsl(UniversalRequestOuterClass.UniversalRequest.Payload.Builder builder, k kVar) {
                this(builder);
            }

            public final /* synthetic */ UniversalRequestOuterClass.UniversalRequest.Payload _build() {
                UniversalRequestOuterClass.UniversalRequest.Payload payloadBuild = this._builder.build();
                t.h(payloadBuild, "_builder.build()");
                return payloadBuild;
            }

            public final void clearAdDataRefreshRequest() {
                this._builder.clearAdDataRefreshRequest();
            }

            public final void clearAdPlayerConfigRequest() {
                this._builder.clearAdPlayerConfigRequest();
            }

            public final void clearAdRequest() {
                this._builder.clearAdRequest();
            }

            public final void clearDiagnosticEventRequest() {
                this._builder.clearDiagnosticEventRequest();
            }

            public final void clearGetTokenEventRequest() {
                this._builder.clearGetTokenEventRequest();
            }

            public final void clearInitializationCompletedEventRequest() {
                this._builder.clearInitializationCompletedEventRequest();
            }

            public final void clearInitializationRequest() {
                this._builder.clearInitializationRequest();
            }

            public final void clearOperativeEvent() {
                this._builder.clearOperativeEvent();
            }

            public final void clearPrivacyUpdateRequest() {
                this._builder.clearPrivacyUpdateRequest();
            }

            public final void clearTransactionEventRequest() {
                this._builder.clearTransactionEventRequest();
            }

            public final void clearValue() {
                this._builder.clearValue();
            }

            @NotNull
            public final AdDataRefreshRequestOuterClass.AdDataRefreshRequest getAdDataRefreshRequest() {
                AdDataRefreshRequestOuterClass.AdDataRefreshRequest adDataRefreshRequest = this._builder.getAdDataRefreshRequest();
                t.h(adDataRefreshRequest, "_builder.getAdDataRefreshRequest()");
                return adDataRefreshRequest;
            }

            @NotNull
            public final AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest getAdPlayerConfigRequest() {
                AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest adPlayerConfigRequest = this._builder.getAdPlayerConfigRequest();
                t.h(adPlayerConfigRequest, "_builder.getAdPlayerConfigRequest()");
                return adPlayerConfigRequest;
            }

            @NotNull
            public final AdRequestOuterClass.AdRequest getAdRequest() {
                AdRequestOuterClass.AdRequest adRequest = this._builder.getAdRequest();
                t.h(adRequest, "_builder.getAdRequest()");
                return adRequest;
            }

            @NotNull
            public final DiagnosticEventRequestOuterClass.DiagnosticEventRequest getDiagnosticEventRequest() {
                DiagnosticEventRequestOuterClass.DiagnosticEventRequest diagnosticEventRequest = this._builder.getDiagnosticEventRequest();
                t.h(diagnosticEventRequest, "_builder.getDiagnosticEventRequest()");
                return diagnosticEventRequest;
            }

            @NotNull
            public final GetTokenEventRequestOuterClass.GetTokenEventRequest getGetTokenEventRequest() {
                GetTokenEventRequestOuterClass.GetTokenEventRequest getTokenEventRequest = this._builder.getGetTokenEventRequest();
                t.h(getTokenEventRequest, "_builder.getGetTokenEventRequest()");
                return getTokenEventRequest;
            }

            @NotNull
            public final InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest getInitializationCompletedEventRequest() {
                InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest initializationCompletedEventRequest = this._builder.getInitializationCompletedEventRequest();
                t.h(initializationCompletedEventRequest, "_builder.getInitializationCompletedEventRequest()");
                return initializationCompletedEventRequest;
            }

            @NotNull
            public final InitializationRequestOuterClass.InitializationRequest getInitializationRequest() {
                InitializationRequestOuterClass.InitializationRequest initializationRequest = this._builder.getInitializationRequest();
                t.h(initializationRequest, "_builder.getInitializationRequest()");
                return initializationRequest;
            }

            @NotNull
            public final OperativeEventRequestOuterClass.OperativeEventRequest getOperativeEvent() {
                OperativeEventRequestOuterClass.OperativeEventRequest operativeEvent = this._builder.getOperativeEvent();
                t.h(operativeEvent, "_builder.getOperativeEvent()");
                return operativeEvent;
            }

            @NotNull
            public final PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest getPrivacyUpdateRequest() {
                PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest privacyUpdateRequest = this._builder.getPrivacyUpdateRequest();
                t.h(privacyUpdateRequest, "_builder.getPrivacyUpdateRequest()");
                return privacyUpdateRequest;
            }

            @NotNull
            public final TransactionEventRequestOuterClass.TransactionEventRequest getTransactionEventRequest() {
                TransactionEventRequestOuterClass.TransactionEventRequest transactionEventRequest = this._builder.getTransactionEventRequest();
                t.h(transactionEventRequest, "_builder.getTransactionEventRequest()");
                return transactionEventRequest;
            }

            @NotNull
            public final UniversalRequestOuterClass.UniversalRequest.Payload.ValueCase getValueCase() {
                UniversalRequestOuterClass.UniversalRequest.Payload.ValueCase valueCase = this._builder.getValueCase();
                t.h(valueCase, "_builder.getValueCase()");
                return valueCase;
            }

            public final boolean hasAdDataRefreshRequest() {
                return this._builder.hasAdDataRefreshRequest();
            }

            public final boolean hasAdPlayerConfigRequest() {
                return this._builder.hasAdPlayerConfigRequest();
            }

            public final boolean hasAdRequest() {
                return this._builder.hasAdRequest();
            }

            public final boolean hasDiagnosticEventRequest() {
                return this._builder.hasDiagnosticEventRequest();
            }

            public final boolean hasGetTokenEventRequest() {
                return this._builder.hasGetTokenEventRequest();
            }

            public final boolean hasInitializationCompletedEventRequest() {
                return this._builder.hasInitializationCompletedEventRequest();
            }

            public final boolean hasInitializationRequest() {
                return this._builder.hasInitializationRequest();
            }

            public final boolean hasOperativeEvent() {
                return this._builder.hasOperativeEvent();
            }

            public final boolean hasPrivacyUpdateRequest() {
                return this._builder.hasPrivacyUpdateRequest();
            }

            public final boolean hasTransactionEventRequest() {
                return this._builder.hasTransactionEventRequest();
            }

            public final void setAdDataRefreshRequest(@NotNull AdDataRefreshRequestOuterClass.AdDataRefreshRequest value) {
                t.i(value, "value");
                this._builder.setAdDataRefreshRequest(value);
            }

            public final void setAdPlayerConfigRequest(@NotNull AdPlayerConfigRequestOuterClass.AdPlayerConfigRequest value) {
                t.i(value, "value");
                this._builder.setAdPlayerConfigRequest(value);
            }

            public final void setAdRequest(@NotNull AdRequestOuterClass.AdRequest value) {
                t.i(value, "value");
                this._builder.setAdRequest(value);
            }

            public final void setDiagnosticEventRequest(@NotNull DiagnosticEventRequestOuterClass.DiagnosticEventRequest value) {
                t.i(value, "value");
                this._builder.setDiagnosticEventRequest(value);
            }

            public final void setGetTokenEventRequest(@NotNull GetTokenEventRequestOuterClass.GetTokenEventRequest value) {
                t.i(value, "value");
                this._builder.setGetTokenEventRequest(value);
            }

            public final void setInitializationCompletedEventRequest(@NotNull InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest value) {
                t.i(value, "value");
                this._builder.setInitializationCompletedEventRequest(value);
            }

            public final void setInitializationRequest(@NotNull InitializationRequestOuterClass.InitializationRequest value) {
                t.i(value, "value");
                this._builder.setInitializationRequest(value);
            }

            public final void setOperativeEvent(@NotNull OperativeEventRequestOuterClass.OperativeEventRequest value) {
                t.i(value, "value");
                this._builder.setOperativeEvent(value);
            }

            public final void setPrivacyUpdateRequest(@NotNull PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest value) {
                t.i(value, "value");
                this._builder.setPrivacyUpdateRequest(value);
            }

            public final void setTransactionEventRequest(@NotNull TransactionEventRequestOuterClass.TransactionEventRequest value) {
                t.i(value, "value");
                this._builder.setTransactionEventRequest(value);
            }

            private Dsl(UniversalRequestOuterClass.UniversalRequest.Payload.Builder builder) {
                this._builder = builder;
            }
        }

        private PayloadKt() {
        }
    }

    /* JADX INFO: compiled from: UniversalRequestKt.kt */
    public static final class SharedDataKt {

        @NotNull
        public static final SharedDataKt INSTANCE = new SharedDataKt();

        /* JADX INFO: compiled from: UniversalRequestKt.kt */
        @ProtoDslMarker
        public static final class Dsl {

            @NotNull
            public static final Companion Companion = new Companion(null);

            @NotNull
            private final UniversalRequestOuterClass.UniversalRequest.SharedData.Builder _builder;

            /* JADX INFO: compiled from: UniversalRequestKt.kt */
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(k kVar) {
                    this();
                }

                public final /* synthetic */ Dsl _create(UniversalRequestOuterClass.UniversalRequest.SharedData.Builder builder) {
                    t.i(builder, "builder");
                    return new Dsl(builder, null);
                }
            }

            public /* synthetic */ Dsl(UniversalRequestOuterClass.UniversalRequest.SharedData.Builder builder, k kVar) {
                this(builder);
            }

            public final /* synthetic */ UniversalRequestOuterClass.UniversalRequest.SharedData _build() {
                UniversalRequestOuterClass.UniversalRequest.SharedData sharedDataBuild = this._builder.build();
                t.h(sharedDataBuild, "_builder.build()");
                return sharedDataBuild;
            }

            public final void clearAppStartTime() {
                this._builder.clearAppStartTime();
            }

            public final void clearCurrentState() {
                this._builder.clearCurrentState();
            }

            public final void clearDeveloperConsent() {
                this._builder.clearDeveloperConsent();
            }

            public final void clearLimitedSessionToken() {
                this._builder.clearLimitedSessionToken();
            }

            public final void clearPii() {
                this._builder.clearPii();
            }

            public final void clearSdkStartTime() {
                this._builder.clearSdkStartTime();
            }

            public final void clearSessionToken() {
                this._builder.clearSessionToken();
            }

            public final void clearTestData() {
                this._builder.clearTestData();
            }

            public final void clearTimestamps() {
                this._builder.clearTimestamps();
            }

            public final void clearWebviewVersion() {
                this._builder.clearWebviewVersion();
            }

            @NotNull
            public final Timestamp getAppStartTime() {
                Timestamp appStartTime = this._builder.getAppStartTime();
                t.h(appStartTime, "_builder.getAppStartTime()");
                return appStartTime;
            }

            @NotNull
            public final ByteString getCurrentState() {
                ByteString currentState = this._builder.getCurrentState();
                t.h(currentState, "_builder.getCurrentState()");
                return currentState;
            }

            @NotNull
            public final DeveloperConsentOuterClass.DeveloperConsent getDeveloperConsent() {
                DeveloperConsentOuterClass.DeveloperConsent developerConsent = this._builder.getDeveloperConsent();
                t.h(developerConsent, "_builder.getDeveloperConsent()");
                return developerConsent;
            }

            @Nullable
            public final DeveloperConsentOuterClass.DeveloperConsent getDeveloperConsentOrNull(@NotNull Dsl dsl) {
                t.i(dsl, "<this>");
                return UniversalRequestKtKt.getDeveloperConsentOrNull(dsl._builder);
            }

            @NotNull
            public final UniversalRequestOuterClass.LimitedSessionToken getLimitedSessionToken() {
                UniversalRequestOuterClass.LimitedSessionToken limitedSessionToken = this._builder.getLimitedSessionToken();
                t.h(limitedSessionToken, "_builder.getLimitedSessionToken()");
                return limitedSessionToken;
            }

            @Nullable
            public final UniversalRequestOuterClass.LimitedSessionToken getLimitedSessionTokenOrNull(@NotNull Dsl dsl) {
                t.i(dsl, "<this>");
                return UniversalRequestKtKt.getLimitedSessionTokenOrNull(dsl._builder);
            }

            @NotNull
            public final PiiOuterClass.Pii getPii() {
                PiiOuterClass.Pii pii = this._builder.getPii();
                t.h(pii, "_builder.getPii()");
                return pii;
            }

            @Nullable
            public final PiiOuterClass.Pii getPiiOrNull(@NotNull Dsl dsl) {
                t.i(dsl, "<this>");
                return UniversalRequestKtKt.getPiiOrNull(dsl._builder);
            }

            @NotNull
            public final Timestamp getSdkStartTime() {
                Timestamp sdkStartTime = this._builder.getSdkStartTime();
                t.h(sdkStartTime, "_builder.getSdkStartTime()");
                return sdkStartTime;
            }

            @NotNull
            public final ByteString getSessionToken() {
                ByteString sessionToken = this._builder.getSessionToken();
                t.h(sessionToken, "_builder.getSessionToken()");
                return sessionToken;
            }

            @NotNull
            public final TestDataOuterClass.TestData getTestData() {
                TestDataOuterClass.TestData testData = this._builder.getTestData();
                t.h(testData, "_builder.getTestData()");
                return testData;
            }

            @Nullable
            public final TestDataOuterClass.TestData getTestDataOrNull(@NotNull Dsl dsl) {
                t.i(dsl, "<this>");
                return UniversalRequestKtKt.getTestDataOrNull(dsl._builder);
            }

            @NotNull
            public final TimestampsOuterClass.Timestamps getTimestamps() {
                TimestampsOuterClass.Timestamps timestamps = this._builder.getTimestamps();
                t.h(timestamps, "_builder.getTimestamps()");
                return timestamps;
            }

            public final int getWebviewVersion() {
                return this._builder.getWebviewVersion();
            }

            public final boolean hasAppStartTime() {
                return this._builder.hasAppStartTime();
            }

            public final boolean hasCurrentState() {
                return this._builder.hasCurrentState();
            }

            public final boolean hasDeveloperConsent() {
                return this._builder.hasDeveloperConsent();
            }

            public final boolean hasLimitedSessionToken() {
                return this._builder.hasLimitedSessionToken();
            }

            public final boolean hasPii() {
                return this._builder.hasPii();
            }

            public final boolean hasSdkStartTime() {
                return this._builder.hasSdkStartTime();
            }

            public final boolean hasSessionToken() {
                return this._builder.hasSessionToken();
            }

            public final boolean hasTestData() {
                return this._builder.hasTestData();
            }

            public final boolean hasTimestamps() {
                return this._builder.hasTimestamps();
            }

            public final boolean hasWebviewVersion() {
                return this._builder.hasWebviewVersion();
            }

            public final void setAppStartTime(@NotNull Timestamp value) {
                t.i(value, "value");
                this._builder.setAppStartTime(value);
            }

            public final void setCurrentState(@NotNull ByteString value) {
                t.i(value, "value");
                this._builder.setCurrentState(value);
            }

            public final void setDeveloperConsent(@NotNull DeveloperConsentOuterClass.DeveloperConsent value) {
                t.i(value, "value");
                this._builder.setDeveloperConsent(value);
            }

            public final void setLimitedSessionToken(@NotNull UniversalRequestOuterClass.LimitedSessionToken value) {
                t.i(value, "value");
                this._builder.setLimitedSessionToken(value);
            }

            public final void setPii(@NotNull PiiOuterClass.Pii value) {
                t.i(value, "value");
                this._builder.setPii(value);
            }

            public final void setSdkStartTime(@NotNull Timestamp value) {
                t.i(value, "value");
                this._builder.setSdkStartTime(value);
            }

            public final void setSessionToken(@NotNull ByteString value) {
                t.i(value, "value");
                this._builder.setSessionToken(value);
            }

            public final void setTestData(@NotNull TestDataOuterClass.TestData value) {
                t.i(value, "value");
                this._builder.setTestData(value);
            }

            public final void setTimestamps(@NotNull TimestampsOuterClass.Timestamps value) {
                t.i(value, "value");
                this._builder.setTimestamps(value);
            }

            public final void setWebviewVersion(int i10) {
                this._builder.setWebviewVersion(i10);
            }

            private Dsl(UniversalRequestOuterClass.UniversalRequest.SharedData.Builder builder) {
                this._builder = builder;
            }
        }

        private SharedDataKt() {
        }
    }

    private UniversalRequestKt() {
    }

    @NotNull
    /* JADX INFO: renamed from: -initializepayload, reason: not valid java name */
    public final UniversalRequestOuterClass.UniversalRequest.Payload m4202initializepayload(@NotNull l<? super PayloadKt.Dsl, k0> block) {
        t.i(block, "block");
        PayloadKt.Dsl.Companion companion = PayloadKt.Dsl.Companion;
        UniversalRequestOuterClass.UniversalRequest.Payload.Builder builderNewBuilder = UniversalRequestOuterClass.UniversalRequest.Payload.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        PayloadKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    /* JADX INFO: renamed from: -initializesharedData, reason: not valid java name */
    public final UniversalRequestOuterClass.UniversalRequest.SharedData m4203initializesharedData(@NotNull l<? super SharedDataKt.Dsl, k0> block) {
        t.i(block, "block");
        SharedDataKt.Dsl.Companion companion = SharedDataKt.Dsl.Companion;
        UniversalRequestOuterClass.UniversalRequest.SharedData.Builder builderNewBuilder = UniversalRequestOuterClass.UniversalRequest.SharedData.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        SharedDataKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
