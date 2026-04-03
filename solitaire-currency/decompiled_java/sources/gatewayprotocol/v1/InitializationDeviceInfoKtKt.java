package gatewayprotocol.v1;

import gatewayprotocol.v1.InitializationDeviceInfoKt;
import gatewayprotocol.v1.InitializationRequestOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: InitializationDeviceInfoKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InitializationDeviceInfoKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeinitializationDeviceInfo, reason: not valid java name */
    public static final InitializationRequestOuterClass.InitializationDeviceInfo m4176initializeinitializationDeviceInfo(@NotNull l<? super InitializationDeviceInfoKt.Dsl, k0> block) {
        t.i(block, "block");
        InitializationDeviceInfoKt.Dsl.Companion companion = InitializationDeviceInfoKt.Dsl.Companion;
        InitializationRequestOuterClass.InitializationDeviceInfo.Builder builderNewBuilder = InitializationRequestOuterClass.InitializationDeviceInfo.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        InitializationDeviceInfoKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final InitializationRequestOuterClass.InitializationDeviceInfo copy(@NotNull InitializationRequestOuterClass.InitializationDeviceInfo initializationDeviceInfo, @NotNull l<? super InitializationDeviceInfoKt.Dsl, k0> block) {
        t.i(initializationDeviceInfo, "<this>");
        t.i(block, "block");
        InitializationDeviceInfoKt.Dsl.Companion companion = InitializationDeviceInfoKt.Dsl.Companion;
        InitializationRequestOuterClass.InitializationDeviceInfo.Builder builder = initializationDeviceInfo.toBuilder();
        t.h(builder, "this.toBuilder()");
        InitializationDeviceInfoKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
