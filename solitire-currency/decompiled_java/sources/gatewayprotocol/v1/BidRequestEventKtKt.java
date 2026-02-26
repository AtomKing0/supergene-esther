package gatewayprotocol.v1;

import com.google.protobuf.Timestamp;
import gatewayprotocol.v1.BidRequestEventKt;
import gatewayprotocol.v1.BidRequestEventOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: BidRequestEventKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BidRequestEventKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializebidRequestEvent, reason: not valid java name */
    public static final BidRequestEventOuterClass.BidRequestEvent m4153initializebidRequestEvent(@NotNull l<? super BidRequestEventKt.Dsl, k0> block) {
        t.i(block, "block");
        BidRequestEventKt.Dsl.Companion companion = BidRequestEventKt.Dsl.Companion;
        BidRequestEventOuterClass.BidRequestEvent.Builder builderNewBuilder = BidRequestEventOuterClass.BidRequestEvent.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        BidRequestEventKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final BidRequestEventOuterClass.BidRequestEvent copy(@NotNull BidRequestEventOuterClass.BidRequestEvent bidRequestEvent, @NotNull l<? super BidRequestEventKt.Dsl, k0> block) {
        t.i(bidRequestEvent, "<this>");
        t.i(block, "block");
        BidRequestEventKt.Dsl.Companion companion = BidRequestEventKt.Dsl.Companion;
        BidRequestEventOuterClass.BidRequestEvent.Builder builder = bidRequestEvent.toBuilder();
        t.h(builder, "this.toBuilder()");
        BidRequestEventKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final BidRequestEventOuterClass.App getAppOrNull(@NotNull BidRequestEventOuterClass.BidRequestEventOrBuilder bidRequestEventOrBuilder) {
        t.i(bidRequestEventOrBuilder, "<this>");
        if (bidRequestEventOrBuilder.hasApp()) {
            return bidRequestEventOrBuilder.getApp();
        }
        return null;
    }

    @Nullable
    public static final BidRequestEventOuterClass.Device getDeviceOrNull(@NotNull BidRequestEventOuterClass.BidRequestEventOrBuilder bidRequestEventOrBuilder) {
        t.i(bidRequestEventOrBuilder, "<this>");
        if (bidRequestEventOrBuilder.hasDevice()) {
            return bidRequestEventOrBuilder.getDevice();
        }
        return null;
    }

    @Nullable
    public static final BidRequestEventOuterClass.Geo getGeoOrNull(@NotNull BidRequestEventOuterClass.BidRequestEventOrBuilder bidRequestEventOrBuilder) {
        t.i(bidRequestEventOrBuilder, "<this>");
        if (bidRequestEventOrBuilder.hasGeo()) {
            return bidRequestEventOrBuilder.getGeo();
        }
        return null;
    }

    @Nullable
    public static final BidRequestEventOuterClass.Publisher getPublisherOrNull(@NotNull BidRequestEventOuterClass.BidRequestEventOrBuilder bidRequestEventOrBuilder) {
        t.i(bidRequestEventOrBuilder, "<this>");
        if (bidRequestEventOrBuilder.hasPublisher()) {
            return bidRequestEventOrBuilder.getPublisher();
        }
        return null;
    }

    @Nullable
    public static final BidRequestEventOuterClass.GatewayStatus getStatusOrNull(@NotNull BidRequestEventOuterClass.BidRequestEventOrBuilder bidRequestEventOrBuilder) {
        t.i(bidRequestEventOrBuilder, "<this>");
        if (bidRequestEventOrBuilder.hasStatus()) {
            return bidRequestEventOrBuilder.getStatus();
        }
        return null;
    }

    @Nullable
    public static final Timestamp getTimestampOrNull(@NotNull BidRequestEventOuterClass.BidRequestEventOrBuilder bidRequestEventOrBuilder) {
        t.i(bidRequestEventOrBuilder, "<this>");
        if (bidRequestEventOrBuilder.hasTimestamp()) {
            return bidRequestEventOrBuilder.getTimestamp();
        }
        return null;
    }

    @Nullable
    public static final BidRequestEventOuterClass.TokenInfo getTokenInfoOrNull(@NotNull BidRequestEventOuterClass.BidRequestEventOrBuilder bidRequestEventOrBuilder) {
        t.i(bidRequestEventOrBuilder, "<this>");
        if (bidRequestEventOrBuilder.hasTokenInfo()) {
            return bidRequestEventOrBuilder.getTokenInfo();
        }
        return null;
    }

    @Nullable
    public static final BidRequestEventOuterClass.User getUserOrNull(@NotNull BidRequestEventOuterClass.BidRequestEventOrBuilder bidRequestEventOrBuilder) {
        t.i(bidRequestEventOrBuilder, "<this>");
        if (bidRequestEventOrBuilder.hasUser()) {
            return bidRequestEventOrBuilder.getUser();
        }
        return null;
    }
}
