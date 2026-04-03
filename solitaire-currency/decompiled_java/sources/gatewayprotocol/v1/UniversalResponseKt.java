package gatewayprotocol.v1;

import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.AdDataRefreshResponseOuterClass;
import gatewayprotocol.v1.AdPlayerConfigResponseOuterClass;
import gatewayprotocol.v1.AdResponseOuterClass;
import gatewayprotocol.v1.ErrorOuterClass;
import gatewayprotocol.v1.InitializationResponseOuterClass;
import gatewayprotocol.v1.MutableDataOuterClass;
import gatewayprotocol.v1.PrivacyUpdateResponseOuterClass;
import gatewayprotocol.v1.UniversalResponseOuterClass;
import h9.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: UniversalResponseKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UniversalResponseKt {

    @NotNull
    public static final UniversalResponseKt INSTANCE = new UniversalResponseKt();

    /* JADX INFO: compiled from: UniversalResponseKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final UniversalResponseOuterClass.UniversalResponse.Builder _builder;

        /* JADX INFO: compiled from: UniversalResponseKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(UniversalResponseOuterClass.UniversalResponse.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(UniversalResponseOuterClass.UniversalResponse.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ UniversalResponseOuterClass.UniversalResponse _build() {
            UniversalResponseOuterClass.UniversalResponse universalResponseBuild = this._builder.build();
            t.h(universalResponseBuild, "_builder.build()");
            return universalResponseBuild;
        }

        public final void clearError() {
            this._builder.clearError();
        }

        public final void clearMutableData() {
            this._builder.clearMutableData();
        }

        public final void clearPayload() {
            this._builder.clearPayload();
        }

        @NotNull
        public final ErrorOuterClass.Error getError() {
            ErrorOuterClass.Error error = this._builder.getError();
            t.h(error, "_builder.getError()");
            return error;
        }

        @Nullable
        public final ErrorOuterClass.Error getErrorOrNull(@NotNull Dsl dsl) {
            t.i(dsl, "<this>");
            return UniversalResponseKtKt.getErrorOrNull(dsl._builder);
        }

        @NotNull
        public final MutableDataOuterClass.MutableData getMutableData() {
            MutableDataOuterClass.MutableData mutableData = this._builder.getMutableData();
            t.h(mutableData, "_builder.getMutableData()");
            return mutableData;
        }

        @Nullable
        public final MutableDataOuterClass.MutableData getMutableDataOrNull(@NotNull Dsl dsl) {
            t.i(dsl, "<this>");
            return UniversalResponseKtKt.getMutableDataOrNull(dsl._builder);
        }

        @NotNull
        public final UniversalResponseOuterClass.UniversalResponse.Payload getPayload() {
            UniversalResponseOuterClass.UniversalResponse.Payload payload = this._builder.getPayload();
            t.h(payload, "_builder.getPayload()");
            return payload;
        }

        public final boolean hasError() {
            return this._builder.hasError();
        }

        public final boolean hasMutableData() {
            return this._builder.hasMutableData();
        }

        public final boolean hasPayload() {
            return this._builder.hasPayload();
        }

        public final void setError(@NotNull ErrorOuterClass.Error value) {
            t.i(value, "value");
            this._builder.setError(value);
        }

        public final void setMutableData(@NotNull MutableDataOuterClass.MutableData value) {
            t.i(value, "value");
            this._builder.setMutableData(value);
        }

        public final void setPayload(@NotNull UniversalResponseOuterClass.UniversalResponse.Payload value) {
            t.i(value, "value");
            this._builder.setPayload(value);
        }

        private Dsl(UniversalResponseOuterClass.UniversalResponse.Builder builder) {
            this._builder = builder;
        }
    }

    /* JADX INFO: compiled from: UniversalResponseKt.kt */
    public static final class PayloadKt {

        @NotNull
        public static final PayloadKt INSTANCE = new PayloadKt();

        /* JADX INFO: compiled from: UniversalResponseKt.kt */
        @ProtoDslMarker
        public static final class Dsl {

            @NotNull
            public static final Companion Companion = new Companion(null);

            @NotNull
            private final UniversalResponseOuterClass.UniversalResponse.Payload.Builder _builder;

            /* JADX INFO: compiled from: UniversalResponseKt.kt */
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(k kVar) {
                    this();
                }

                public final /* synthetic */ Dsl _create(UniversalResponseOuterClass.UniversalResponse.Payload.Builder builder) {
                    t.i(builder, "builder");
                    return new Dsl(builder, null);
                }
            }

            public /* synthetic */ Dsl(UniversalResponseOuterClass.UniversalResponse.Payload.Builder builder, k kVar) {
                this(builder);
            }

            public final /* synthetic */ UniversalResponseOuterClass.UniversalResponse.Payload _build() {
                UniversalResponseOuterClass.UniversalResponse.Payload payloadBuild = this._builder.build();
                t.h(payloadBuild, "_builder.build()");
                return payloadBuild;
            }

            public final void clearAdDataRefreshResponse() {
                this._builder.clearAdDataRefreshResponse();
            }

            public final void clearAdPlayerConfigResponse() {
                this._builder.clearAdPlayerConfigResponse();
            }

            public final void clearAdResponse() {
                this._builder.clearAdResponse();
            }

            public final void clearInitializationResponse() {
                this._builder.clearInitializationResponse();
            }

            public final void clearPrivacyUpdateResponse() {
                this._builder.clearPrivacyUpdateResponse();
            }

            public final void clearValue() {
                this._builder.clearValue();
            }

            @NotNull
            public final AdDataRefreshResponseOuterClass.AdDataRefreshResponse getAdDataRefreshResponse() {
                AdDataRefreshResponseOuterClass.AdDataRefreshResponse adDataRefreshResponse = this._builder.getAdDataRefreshResponse();
                t.h(adDataRefreshResponse, "_builder.getAdDataRefreshResponse()");
                return adDataRefreshResponse;
            }

            @NotNull
            public final AdPlayerConfigResponseOuterClass.AdPlayerConfigResponse getAdPlayerConfigResponse() {
                AdPlayerConfigResponseOuterClass.AdPlayerConfigResponse adPlayerConfigResponse = this._builder.getAdPlayerConfigResponse();
                t.h(adPlayerConfigResponse, "_builder.getAdPlayerConfigResponse()");
                return adPlayerConfigResponse;
            }

            @NotNull
            public final AdResponseOuterClass.AdResponse getAdResponse() {
                AdResponseOuterClass.AdResponse adResponse = this._builder.getAdResponse();
                t.h(adResponse, "_builder.getAdResponse()");
                return adResponse;
            }

            @NotNull
            public final InitializationResponseOuterClass.InitializationResponse getInitializationResponse() {
                InitializationResponseOuterClass.InitializationResponse initializationResponse = this._builder.getInitializationResponse();
                t.h(initializationResponse, "_builder.getInitializationResponse()");
                return initializationResponse;
            }

            @NotNull
            public final PrivacyUpdateResponseOuterClass.PrivacyUpdateResponse getPrivacyUpdateResponse() {
                PrivacyUpdateResponseOuterClass.PrivacyUpdateResponse privacyUpdateResponse = this._builder.getPrivacyUpdateResponse();
                t.h(privacyUpdateResponse, "_builder.getPrivacyUpdateResponse()");
                return privacyUpdateResponse;
            }

            @NotNull
            public final UniversalResponseOuterClass.UniversalResponse.Payload.ValueCase getValueCase() {
                UniversalResponseOuterClass.UniversalResponse.Payload.ValueCase valueCase = this._builder.getValueCase();
                t.h(valueCase, "_builder.getValueCase()");
                return valueCase;
            }

            public final boolean hasAdDataRefreshResponse() {
                return this._builder.hasAdDataRefreshResponse();
            }

            public final boolean hasAdPlayerConfigResponse() {
                return this._builder.hasAdPlayerConfigResponse();
            }

            public final boolean hasAdResponse() {
                return this._builder.hasAdResponse();
            }

            public final boolean hasInitializationResponse() {
                return this._builder.hasInitializationResponse();
            }

            public final boolean hasPrivacyUpdateResponse() {
                return this._builder.hasPrivacyUpdateResponse();
            }

            public final void setAdDataRefreshResponse(@NotNull AdDataRefreshResponseOuterClass.AdDataRefreshResponse value) {
                t.i(value, "value");
                this._builder.setAdDataRefreshResponse(value);
            }

            public final void setAdPlayerConfigResponse(@NotNull AdPlayerConfigResponseOuterClass.AdPlayerConfigResponse value) {
                t.i(value, "value");
                this._builder.setAdPlayerConfigResponse(value);
            }

            public final void setAdResponse(@NotNull AdResponseOuterClass.AdResponse value) {
                t.i(value, "value");
                this._builder.setAdResponse(value);
            }

            public final void setInitializationResponse(@NotNull InitializationResponseOuterClass.InitializationResponse value) {
                t.i(value, "value");
                this._builder.setInitializationResponse(value);
            }

            public final void setPrivacyUpdateResponse(@NotNull PrivacyUpdateResponseOuterClass.PrivacyUpdateResponse value) {
                t.i(value, "value");
                this._builder.setPrivacyUpdateResponse(value);
            }

            private Dsl(UniversalResponseOuterClass.UniversalResponse.Payload.Builder builder) {
                this._builder = builder;
            }
        }

        private PayloadKt() {
        }
    }

    private UniversalResponseKt() {
    }

    @NotNull
    /* JADX INFO: renamed from: -initializepayload, reason: not valid java name */
    public final UniversalResponseOuterClass.UniversalResponse.Payload m4205initializepayload(@NotNull l<? super PayloadKt.Dsl, k0> block) {
        t.i(block, "block");
        PayloadKt.Dsl.Companion companion = PayloadKt.Dsl.Companion;
        UniversalResponseOuterClass.UniversalResponse.Payload.Builder builderNewBuilder = UniversalResponseOuterClass.UniversalResponse.Payload.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        PayloadKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
