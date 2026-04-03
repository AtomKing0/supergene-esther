package gatewayprotocol.v1;

import gatewayprotocol.v1.DynamicDeviceInfoOuterClass;
import gatewayprotocol.v1.InitializationCompletedEventRequestKt;
import gatewayprotocol.v1.InitializationCompletedEventRequestOuterClass;
import gatewayprotocol.v1.StaticDeviceInfoOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: InitializationCompletedEventRequestKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InitializationCompletedEventRequestKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeinitializationCompletedEventRequest, reason: not valid java name */
    public static final InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest m4174initializeinitializationCompletedEventRequest(@NotNull l<? super InitializationCompletedEventRequestKt.Dsl, k0> block) {
        t.i(block, "block");
        InitializationCompletedEventRequestKt.Dsl.Companion companion = InitializationCompletedEventRequestKt.Dsl.Companion;
        InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest.Builder builderNewBuilder = InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        InitializationCompletedEventRequestKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest copy(@NotNull InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest initializationCompletedEventRequest, @NotNull l<? super InitializationCompletedEventRequestKt.Dsl, k0> block) {
        t.i(initializationCompletedEventRequest, "<this>");
        t.i(block, "block");
        InitializationCompletedEventRequestKt.Dsl.Companion companion = InitializationCompletedEventRequestKt.Dsl.Companion;
        InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest.Builder builder = initializationCompletedEventRequest.toBuilder();
        t.h(builder, "this.toBuilder()");
        InitializationCompletedEventRequestKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final DynamicDeviceInfoOuterClass.DynamicDeviceInfo getDynamicDeviceInfoOrNull(@NotNull InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequestOrBuilder initializationCompletedEventRequestOrBuilder) {
        t.i(initializationCompletedEventRequestOrBuilder, "<this>");
        if (initializationCompletedEventRequestOrBuilder.hasDynamicDeviceInfo()) {
            return initializationCompletedEventRequestOrBuilder.getDynamicDeviceInfo();
        }
        return null;
    }

    @Nullable
    public static final StaticDeviceInfoOuterClass.StaticDeviceInfo getStaticDeviceInfoOrNull(@NotNull InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequestOrBuilder initializationCompletedEventRequestOrBuilder) {
        t.i(initializationCompletedEventRequestOrBuilder, "<this>");
        if (initializationCompletedEventRequestOrBuilder.hasStaticDeviceInfo()) {
            return initializationCompletedEventRequestOrBuilder.getStaticDeviceInfo();
        }
        return null;
    }
}
