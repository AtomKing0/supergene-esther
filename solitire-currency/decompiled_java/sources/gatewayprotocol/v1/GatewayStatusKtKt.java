package gatewayprotocol.v1;

import gatewayprotocol.v1.BidRequestEventOuterClass;
import gatewayprotocol.v1.GatewayStatusKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: GatewayStatusKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GatewayStatusKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializegatewayStatus, reason: not valid java name */
    public static final BidRequestEventOuterClass.GatewayStatus m4169initializegatewayStatus(@NotNull l<? super GatewayStatusKt.Dsl, k0> block) {
        t.i(block, "block");
        GatewayStatusKt.Dsl.Companion companion = GatewayStatusKt.Dsl.Companion;
        BidRequestEventOuterClass.GatewayStatus.Builder builderNewBuilder = BidRequestEventOuterClass.GatewayStatus.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        GatewayStatusKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final BidRequestEventOuterClass.GatewayStatus copy(@NotNull BidRequestEventOuterClass.GatewayStatus gatewayStatus, @NotNull l<? super GatewayStatusKt.Dsl, k0> block) {
        t.i(gatewayStatus, "<this>");
        t.i(block, "block");
        GatewayStatusKt.Dsl.Companion companion = GatewayStatusKt.Dsl.Companion;
        BidRequestEventOuterClass.GatewayStatus.Builder builder = gatewayStatus.toBuilder();
        t.h(builder, "this.toBuilder()");
        GatewayStatusKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
