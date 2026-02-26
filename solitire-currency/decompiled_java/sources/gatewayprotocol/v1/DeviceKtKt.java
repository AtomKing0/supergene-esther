package gatewayprotocol.v1;

import gatewayprotocol.v1.BidRequestEventOuterClass;
import gatewayprotocol.v1.DeviceKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: DeviceKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DeviceKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializedevice, reason: not valid java name */
    public static final BidRequestEventOuterClass.Device m4159initializedevice(@NotNull l<? super DeviceKt.Dsl, k0> block) {
        t.i(block, "block");
        DeviceKt.Dsl.Companion companion = DeviceKt.Dsl.Companion;
        BidRequestEventOuterClass.Device.Builder builderNewBuilder = BidRequestEventOuterClass.Device.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        DeviceKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final BidRequestEventOuterClass.Device copy(@NotNull BidRequestEventOuterClass.Device device, @NotNull l<? super DeviceKt.Dsl, k0> block) {
        t.i(device, "<this>");
        t.i(block, "block");
        DeviceKt.Dsl.Companion companion = DeviceKt.Dsl.Companion;
        BidRequestEventOuterClass.Device.Builder builder = device.toBuilder();
        t.h(builder, "this.toBuilder()");
        DeviceKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
