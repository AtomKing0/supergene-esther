package gatewayprotocol.v1;

import com.google.protobuf.Timestamp;
import gatewayprotocol.v1.TimestampsKt;
import gatewayprotocol.v1.TimestampsOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TimestampsKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TimestampsKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializetimestamps, reason: not valid java name */
    public static final TimestampsOuterClass.Timestamps m4198initializetimestamps(@NotNull l<? super TimestampsKt.Dsl, k0> block) {
        t.i(block, "block");
        TimestampsKt.Dsl.Companion companion = TimestampsKt.Dsl.Companion;
        TimestampsOuterClass.Timestamps.Builder builderNewBuilder = TimestampsOuterClass.Timestamps.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        TimestampsKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final TimestampsOuterClass.Timestamps copy(@NotNull TimestampsOuterClass.Timestamps timestamps, @NotNull l<? super TimestampsKt.Dsl, k0> block) {
        t.i(timestamps, "<this>");
        t.i(block, "block");
        TimestampsKt.Dsl.Companion companion = TimestampsKt.Dsl.Companion;
        TimestampsOuterClass.Timestamps.Builder builder = timestamps.toBuilder();
        t.h(builder, "this.toBuilder()");
        TimestampsKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final Timestamp getTimestampOrNull(@NotNull TimestampsOuterClass.TimestampsOrBuilder timestampsOrBuilder) {
        t.i(timestampsOrBuilder, "<this>");
        if (timestampsOrBuilder.hasTimestamp()) {
            return timestampsOrBuilder.getTimestamp();
        }
        return null;
    }
}
