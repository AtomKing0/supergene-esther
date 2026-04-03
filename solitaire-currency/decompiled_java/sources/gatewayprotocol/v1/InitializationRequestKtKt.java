package gatewayprotocol.v1;

import gatewayprotocol.v1.ClientInfoOuterClass;
import gatewayprotocol.v1.InitializationRequestKt;
import gatewayprotocol.v1.InitializationRequestOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: InitializationRequestKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InitializationRequestKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeinitializationRequest, reason: not valid java name */
    public static final InitializationRequestOuterClass.InitializationRequest m4177initializeinitializationRequest(@NotNull l<? super InitializationRequestKt.Dsl, k0> block) {
        t.i(block, "block");
        InitializationRequestKt.Dsl.Companion companion = InitializationRequestKt.Dsl.Companion;
        InitializationRequestOuterClass.InitializationRequest.Builder builderNewBuilder = InitializationRequestOuterClass.InitializationRequest.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        InitializationRequestKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final InitializationRequestOuterClass.InitializationRequest copy(@NotNull InitializationRequestOuterClass.InitializationRequest initializationRequest, @NotNull l<? super InitializationRequestKt.Dsl, k0> block) {
        t.i(initializationRequest, "<this>");
        t.i(block, "block");
        InitializationRequestKt.Dsl.Companion companion = InitializationRequestKt.Dsl.Companion;
        InitializationRequestOuterClass.InitializationRequest.Builder builder = initializationRequest.toBuilder();
        t.h(builder, "this.toBuilder()");
        InitializationRequestKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final ClientInfoOuterClass.ClientInfo getClientInfoOrNull(@NotNull InitializationRequestOuterClass.InitializationRequestOrBuilder initializationRequestOrBuilder) {
        t.i(initializationRequestOrBuilder, "<this>");
        if (initializationRequestOrBuilder.hasClientInfo()) {
            return initializationRequestOrBuilder.getClientInfo();
        }
        return null;
    }

    @Nullable
    public static final InitializationRequestOuterClass.InitializationDeviceInfo getDeviceInfoOrNull(@NotNull InitializationRequestOuterClass.InitializationRequestOrBuilder initializationRequestOrBuilder) {
        t.i(initializationRequestOrBuilder, "<this>");
        if (initializationRequestOrBuilder.hasDeviceInfo()) {
            return initializationRequestOrBuilder.getDeviceInfo();
        }
        return null;
    }
}
