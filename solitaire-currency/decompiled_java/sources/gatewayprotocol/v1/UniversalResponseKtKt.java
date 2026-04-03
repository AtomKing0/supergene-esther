package gatewayprotocol.v1;

import gatewayprotocol.v1.AdDataRefreshResponseOuterClass;
import gatewayprotocol.v1.AdPlayerConfigResponseOuterClass;
import gatewayprotocol.v1.AdResponseOuterClass;
import gatewayprotocol.v1.ErrorOuterClass;
import gatewayprotocol.v1.InitializationResponseOuterClass;
import gatewayprotocol.v1.MutableDataOuterClass;
import gatewayprotocol.v1.PrivacyUpdateResponseOuterClass;
import gatewayprotocol.v1.UniversalResponseKt;
import gatewayprotocol.v1.UniversalResponseOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: UniversalResponseKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UniversalResponseKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeuniversalResponse, reason: not valid java name */
    public static final UniversalResponseOuterClass.UniversalResponse m4206initializeuniversalResponse(@NotNull l<? super UniversalResponseKt.Dsl, k0> block) {
        t.i(block, "block");
        UniversalResponseKt.Dsl.Companion companion = UniversalResponseKt.Dsl.Companion;
        UniversalResponseOuterClass.UniversalResponse.Builder builderNewBuilder = UniversalResponseOuterClass.UniversalResponse.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        UniversalResponseKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final UniversalResponseOuterClass.UniversalResponse copy(@NotNull UniversalResponseOuterClass.UniversalResponse universalResponse, @NotNull l<? super UniversalResponseKt.Dsl, k0> block) {
        t.i(universalResponse, "<this>");
        t.i(block, "block");
        UniversalResponseKt.Dsl.Companion companion = UniversalResponseKt.Dsl.Companion;
        UniversalResponseOuterClass.UniversalResponse.Builder builder = universalResponse.toBuilder();
        t.h(builder, "this.toBuilder()");
        UniversalResponseKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final AdDataRefreshResponseOuterClass.AdDataRefreshResponse getAdDataRefreshResponseOrNull(@NotNull UniversalResponseOuterClass.UniversalResponse.PayloadOrBuilder payloadOrBuilder) {
        t.i(payloadOrBuilder, "<this>");
        if (payloadOrBuilder.hasAdDataRefreshResponse()) {
            return payloadOrBuilder.getAdDataRefreshResponse();
        }
        return null;
    }

    @Nullable
    public static final AdPlayerConfigResponseOuterClass.AdPlayerConfigResponse getAdPlayerConfigResponseOrNull(@NotNull UniversalResponseOuterClass.UniversalResponse.PayloadOrBuilder payloadOrBuilder) {
        t.i(payloadOrBuilder, "<this>");
        if (payloadOrBuilder.hasAdPlayerConfigResponse()) {
            return payloadOrBuilder.getAdPlayerConfigResponse();
        }
        return null;
    }

    @Nullable
    public static final AdResponseOuterClass.AdResponse getAdResponseOrNull(@NotNull UniversalResponseOuterClass.UniversalResponse.PayloadOrBuilder payloadOrBuilder) {
        t.i(payloadOrBuilder, "<this>");
        if (payloadOrBuilder.hasAdResponse()) {
            return payloadOrBuilder.getAdResponse();
        }
        return null;
    }

    @Nullable
    public static final ErrorOuterClass.Error getErrorOrNull(@NotNull UniversalResponseOuterClass.UniversalResponseOrBuilder universalResponseOrBuilder) {
        t.i(universalResponseOrBuilder, "<this>");
        if (universalResponseOrBuilder.hasError()) {
            return universalResponseOrBuilder.getError();
        }
        return null;
    }

    @Nullable
    public static final InitializationResponseOuterClass.InitializationResponse getInitializationResponseOrNull(@NotNull UniversalResponseOuterClass.UniversalResponse.PayloadOrBuilder payloadOrBuilder) {
        t.i(payloadOrBuilder, "<this>");
        if (payloadOrBuilder.hasInitializationResponse()) {
            return payloadOrBuilder.getInitializationResponse();
        }
        return null;
    }

    @Nullable
    public static final MutableDataOuterClass.MutableData getMutableDataOrNull(@NotNull UniversalResponseOuterClass.UniversalResponseOrBuilder universalResponseOrBuilder) {
        t.i(universalResponseOrBuilder, "<this>");
        if (universalResponseOrBuilder.hasMutableData()) {
            return universalResponseOrBuilder.getMutableData();
        }
        return null;
    }

    @Nullable
    public static final UniversalResponseOuterClass.UniversalResponse.Payload getPayloadOrNull(@NotNull UniversalResponseOuterClass.UniversalResponseOrBuilder universalResponseOrBuilder) {
        t.i(universalResponseOrBuilder, "<this>");
        if (universalResponseOrBuilder.hasPayload()) {
            return universalResponseOrBuilder.getPayload();
        }
        return null;
    }

    @Nullable
    public static final PrivacyUpdateResponseOuterClass.PrivacyUpdateResponse getPrivacyUpdateResponseOrNull(@NotNull UniversalResponseOuterClass.UniversalResponse.PayloadOrBuilder payloadOrBuilder) {
        t.i(payloadOrBuilder, "<this>");
        if (payloadOrBuilder.hasPrivacyUpdateResponse()) {
            return payloadOrBuilder.getPrivacyUpdateResponse();
        }
        return null;
    }

    @NotNull
    public static final UniversalResponseOuterClass.UniversalResponse.Payload copy(@NotNull UniversalResponseOuterClass.UniversalResponse.Payload payload, @NotNull l<? super UniversalResponseKt.PayloadKt.Dsl, k0> block) {
        t.i(payload, "<this>");
        t.i(block, "block");
        UniversalResponseKt.PayloadKt.Dsl.Companion companion = UniversalResponseKt.PayloadKt.Dsl.Companion;
        UniversalResponseOuterClass.UniversalResponse.Payload.Builder builder = payload.toBuilder();
        t.h(builder, "this.toBuilder()");
        UniversalResponseKt.PayloadKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
