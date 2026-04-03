package gatewayprotocol.v1;

import gatewayprotocol.v1.AllowedPiiOuterClass;
import gatewayprotocol.v1.MutableDataKt;
import gatewayprotocol.v1.MutableDataOuterClass;
import gatewayprotocol.v1.SessionCountersOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: MutableDataKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class MutableDataKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializemutableData, reason: not valid java name */
    public static final MutableDataOuterClass.MutableData m4180initializemutableData(@NotNull l<? super MutableDataKt.Dsl, k0> block) {
        t.i(block, "block");
        MutableDataKt.Dsl.Companion companion = MutableDataKt.Dsl.Companion;
        MutableDataOuterClass.MutableData.Builder builderNewBuilder = MutableDataOuterClass.MutableData.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        MutableDataKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MutableDataOuterClass.MutableData copy(@NotNull MutableDataOuterClass.MutableData mutableData, @NotNull l<? super MutableDataKt.Dsl, k0> block) {
        t.i(mutableData, "<this>");
        t.i(block, "block");
        MutableDataKt.Dsl.Companion companion = MutableDataKt.Dsl.Companion;
        MutableDataOuterClass.MutableData.Builder builder = mutableData.toBuilder();
        t.h(builder, "this.toBuilder()");
        MutableDataKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final AllowedPiiOuterClass.AllowedPii getAllowedPiiOrNull(@NotNull MutableDataOuterClass.MutableDataOrBuilder mutableDataOrBuilder) {
        t.i(mutableDataOrBuilder, "<this>");
        if (mutableDataOrBuilder.hasAllowedPii()) {
            return mutableDataOrBuilder.getAllowedPii();
        }
        return null;
    }

    @Nullable
    public static final SessionCountersOuterClass.SessionCounters getSessionCountersOrNull(@NotNull MutableDataOuterClass.MutableDataOrBuilder mutableDataOrBuilder) {
        t.i(mutableDataOrBuilder, "<this>");
        if (mutableDataOrBuilder.hasSessionCounters()) {
            return mutableDataOrBuilder.getSessionCounters();
        }
        return null;
    }
}
