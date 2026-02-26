package gatewayprotocol.v1;

import gatewayprotocol.v1.CampaignStateOuterClass;
import gatewayprotocol.v1.DynamicDeviceInfoOuterClass;
import gatewayprotocol.v1.OperativeEventRequestKt;
import gatewayprotocol.v1.OperativeEventRequestOuterClass;
import gatewayprotocol.v1.SessionCountersOuterClass;
import gatewayprotocol.v1.StaticDeviceInfoOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: OperativeEventRequestKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OperativeEventRequestKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeoperativeEventRequest, reason: not valid java name */
    public static final OperativeEventRequestOuterClass.OperativeEventRequest m4184initializeoperativeEventRequest(@NotNull l<? super OperativeEventRequestKt.Dsl, k0> block) {
        t.i(block, "block");
        OperativeEventRequestKt.Dsl.Companion companion = OperativeEventRequestKt.Dsl.Companion;
        OperativeEventRequestOuterClass.OperativeEventRequest.Builder builderNewBuilder = OperativeEventRequestOuterClass.OperativeEventRequest.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        OperativeEventRequestKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final OperativeEventRequestOuterClass.OperativeEventRequest copy(@NotNull OperativeEventRequestOuterClass.OperativeEventRequest operativeEventRequest, @NotNull l<? super OperativeEventRequestKt.Dsl, k0> block) {
        t.i(operativeEventRequest, "<this>");
        t.i(block, "block");
        OperativeEventRequestKt.Dsl.Companion companion = OperativeEventRequestKt.Dsl.Companion;
        OperativeEventRequestOuterClass.OperativeEventRequest.Builder builder = operativeEventRequest.toBuilder();
        t.h(builder, "this.toBuilder()");
        OperativeEventRequestKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final CampaignStateOuterClass.CampaignState getCampaignStateOrNull(@NotNull OperativeEventRequestOuterClass.OperativeEventRequestOrBuilder operativeEventRequestOrBuilder) {
        t.i(operativeEventRequestOrBuilder, "<this>");
        if (operativeEventRequestOrBuilder.hasCampaignState()) {
            return operativeEventRequestOrBuilder.getCampaignState();
        }
        return null;
    }

    @Nullable
    public static final DynamicDeviceInfoOuterClass.DynamicDeviceInfo getDynamicDeviceInfoOrNull(@NotNull OperativeEventRequestOuterClass.OperativeEventRequestOrBuilder operativeEventRequestOrBuilder) {
        t.i(operativeEventRequestOrBuilder, "<this>");
        if (operativeEventRequestOrBuilder.hasDynamicDeviceInfo()) {
            return operativeEventRequestOrBuilder.getDynamicDeviceInfo();
        }
        return null;
    }

    @Nullable
    public static final SessionCountersOuterClass.SessionCounters getSessionCountersOrNull(@NotNull OperativeEventRequestOuterClass.OperativeEventRequestOrBuilder operativeEventRequestOrBuilder) {
        t.i(operativeEventRequestOrBuilder, "<this>");
        if (operativeEventRequestOrBuilder.hasSessionCounters()) {
            return operativeEventRequestOrBuilder.getSessionCounters();
        }
        return null;
    }

    @Nullable
    public static final StaticDeviceInfoOuterClass.StaticDeviceInfo getStaticDeviceInfoOrNull(@NotNull OperativeEventRequestOuterClass.OperativeEventRequestOrBuilder operativeEventRequestOrBuilder) {
        t.i(operativeEventRequestOrBuilder, "<this>");
        if (operativeEventRequestOrBuilder.hasStaticDeviceInfo()) {
            return operativeEventRequestOrBuilder.getStaticDeviceInfo();
        }
        return null;
    }
}
