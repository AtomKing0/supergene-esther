package gatewayprotocol.v1;

import gatewayprotocol.v1.NativeConfigurationOuterClass;
import gatewayprotocol.v1.RequestRetryPolicyKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: RequestRetryPolicyKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class RequestRetryPolicyKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializerequestRetryPolicy, reason: not valid java name */
    public static final NativeConfigurationOuterClass.RequestRetryPolicy m4191initializerequestRetryPolicy(@NotNull l<? super RequestRetryPolicyKt.Dsl, k0> block) {
        t.i(block, "block");
        RequestRetryPolicyKt.Dsl.Companion companion = RequestRetryPolicyKt.Dsl.Companion;
        NativeConfigurationOuterClass.RequestRetryPolicy.Builder builderNewBuilder = NativeConfigurationOuterClass.RequestRetryPolicy.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        RequestRetryPolicyKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final NativeConfigurationOuterClass.RequestRetryPolicy copy(@NotNull NativeConfigurationOuterClass.RequestRetryPolicy requestRetryPolicy, @NotNull l<? super RequestRetryPolicyKt.Dsl, k0> block) {
        t.i(requestRetryPolicy, "<this>");
        t.i(block, "block");
        RequestRetryPolicyKt.Dsl.Companion companion = RequestRetryPolicyKt.Dsl.Companion;
        NativeConfigurationOuterClass.RequestRetryPolicy.Builder builder = requestRetryPolicy.toBuilder();
        t.h(builder, "this.toBuilder()");
        RequestRetryPolicyKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
