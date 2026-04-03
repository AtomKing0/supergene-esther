package gatewayprotocol.v1;

import gatewayprotocol.v1.NativeConfigurationOuterClass;
import gatewayprotocol.v1.RequestTimeoutPolicyKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: RequestTimeoutPolicyKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class RequestTimeoutPolicyKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializerequestTimeoutPolicy, reason: not valid java name */
    public static final NativeConfigurationOuterClass.RequestTimeoutPolicy m4192initializerequestTimeoutPolicy(@NotNull l<? super RequestTimeoutPolicyKt.Dsl, k0> block) {
        t.i(block, "block");
        RequestTimeoutPolicyKt.Dsl.Companion companion = RequestTimeoutPolicyKt.Dsl.Companion;
        NativeConfigurationOuterClass.RequestTimeoutPolicy.Builder builderNewBuilder = NativeConfigurationOuterClass.RequestTimeoutPolicy.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        RequestTimeoutPolicyKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final NativeConfigurationOuterClass.RequestTimeoutPolicy copy(@NotNull NativeConfigurationOuterClass.RequestTimeoutPolicy requestTimeoutPolicy, @NotNull l<? super RequestTimeoutPolicyKt.Dsl, k0> block) {
        t.i(requestTimeoutPolicy, "<this>");
        t.i(block, "block");
        RequestTimeoutPolicyKt.Dsl.Companion companion = RequestTimeoutPolicyKt.Dsl.Companion;
        NativeConfigurationOuterClass.RequestTimeoutPolicy.Builder builder = requestTimeoutPolicy.toBuilder();
        t.h(builder, "this.toBuilder()");
        RequestTimeoutPolicyKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
