package gatewayprotocol.v1;

import gatewayprotocol.v1.NativeConfigurationOuterClass;
import gatewayprotocol.v1.RequestPolicyKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: RequestPolicyKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class RequestPolicyKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializerequestPolicy, reason: not valid java name */
    public static final NativeConfigurationOuterClass.RequestPolicy m4190initializerequestPolicy(@NotNull l<? super RequestPolicyKt.Dsl, k0> block) {
        t.i(block, "block");
        RequestPolicyKt.Dsl.Companion companion = RequestPolicyKt.Dsl.Companion;
        NativeConfigurationOuterClass.RequestPolicy.Builder builderNewBuilder = NativeConfigurationOuterClass.RequestPolicy.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        RequestPolicyKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final NativeConfigurationOuterClass.RequestPolicy copy(@NotNull NativeConfigurationOuterClass.RequestPolicy requestPolicy, @NotNull l<? super RequestPolicyKt.Dsl, k0> block) {
        t.i(requestPolicy, "<this>");
        t.i(block, "block");
        RequestPolicyKt.Dsl.Companion companion = RequestPolicyKt.Dsl.Companion;
        NativeConfigurationOuterClass.RequestPolicy.Builder builder = requestPolicy.toBuilder();
        t.h(builder, "this.toBuilder()");
        RequestPolicyKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final NativeConfigurationOuterClass.RequestRetryPolicy getRetryPolicyOrNull(@NotNull NativeConfigurationOuterClass.RequestPolicyOrBuilder requestPolicyOrBuilder) {
        t.i(requestPolicyOrBuilder, "<this>");
        if (requestPolicyOrBuilder.hasRetryPolicy()) {
            return requestPolicyOrBuilder.getRetryPolicy();
        }
        return null;
    }

    @Nullable
    public static final NativeConfigurationOuterClass.RequestTimeoutPolicy getTimeoutPolicyOrNull(@NotNull NativeConfigurationOuterClass.RequestPolicyOrBuilder requestPolicyOrBuilder) {
        t.i(requestPolicyOrBuilder, "<this>");
        if (requestPolicyOrBuilder.hasTimeoutPolicy()) {
            return requestPolicyOrBuilder.getTimeoutPolicy();
        }
        return null;
    }
}
