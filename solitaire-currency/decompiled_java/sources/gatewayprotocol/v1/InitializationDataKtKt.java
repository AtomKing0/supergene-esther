package gatewayprotocol.v1;

import gatewayprotocol.v1.InitializationDataKt;
import gatewayprotocol.v1.InitializationDataOuterClass;
import gatewayprotocol.v1.InitializationRequestOuterClass;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: InitializationDataKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InitializationDataKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeinitializationData, reason: not valid java name */
    public static final InitializationDataOuterClass.InitializationData m4175initializeinitializationData(@NotNull l<? super InitializationDataKt.Dsl, k0> block) {
        t.i(block, "block");
        InitializationDataKt.Dsl.Companion companion = InitializationDataKt.Dsl.Companion;
        InitializationDataOuterClass.InitializationData.Builder builderNewBuilder = InitializationDataOuterClass.InitializationData.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        InitializationDataKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final InitializationDataOuterClass.InitializationData copy(@NotNull InitializationDataOuterClass.InitializationData initializationData, @NotNull l<? super InitializationDataKt.Dsl, k0> block) {
        t.i(initializationData, "<this>");
        t.i(block, "block");
        InitializationDataKt.Dsl.Companion companion = InitializationDataKt.Dsl.Companion;
        InitializationDataOuterClass.InitializationData.Builder builder = initializationData.toBuilder();
        t.h(builder, "this.toBuilder()");
        InitializationDataKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final InitializationRequestOuterClass.InitializationRequest getInitializationRequestOrNull(@NotNull InitializationDataOuterClass.InitializationDataOrBuilder initializationDataOrBuilder) {
        t.i(initializationDataOrBuilder, "<this>");
        if (initializationDataOrBuilder.hasInitializationRequest()) {
            return initializationDataOrBuilder.getInitializationRequest();
        }
        return null;
    }

    @Nullable
    public static final UniversalRequestOuterClass.UniversalRequest.SharedData getSharedDataOrNull(@NotNull InitializationDataOuterClass.InitializationDataOrBuilder initializationDataOrBuilder) {
        t.i(initializationDataOrBuilder, "<this>");
        if (initializationDataOrBuilder.hasSharedData()) {
            return initializationDataOrBuilder.getSharedData();
        }
        return null;
    }
}
