package gatewayprotocol.v1;

import gatewayprotocol.v1.NetworkCapabilityTransportsKt;
import gatewayprotocol.v1.NetworkCapabilityTransportsOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: NetworkCapabilityTransportsKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class NetworkCapabilityTransportsKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializenetworkCapabilityTransports, reason: not valid java name */
    public static final NetworkCapabilityTransportsOuterClass.NetworkCapabilityTransports m4182initializenetworkCapabilityTransports(@NotNull l<? super NetworkCapabilityTransportsKt.Dsl, k0> block) {
        t.i(block, "block");
        NetworkCapabilityTransportsKt.Dsl.Companion companion = NetworkCapabilityTransportsKt.Dsl.Companion;
        NetworkCapabilityTransportsOuterClass.NetworkCapabilityTransports.Builder builderNewBuilder = NetworkCapabilityTransportsOuterClass.NetworkCapabilityTransports.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        NetworkCapabilityTransportsKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final NetworkCapabilityTransportsOuterClass.NetworkCapabilityTransports copy(@NotNull NetworkCapabilityTransportsOuterClass.NetworkCapabilityTransports networkCapabilityTransports, @NotNull l<? super NetworkCapabilityTransportsKt.Dsl, k0> block) {
        t.i(networkCapabilityTransports, "<this>");
        t.i(block, "block");
        NetworkCapabilityTransportsKt.Dsl.Companion companion = NetworkCapabilityTransportsKt.Dsl.Companion;
        NetworkCapabilityTransportsOuterClass.NetworkCapabilityTransports.Builder builder = networkCapabilityTransports.toBuilder();
        t.h(builder, "this.toBuilder()");
        NetworkCapabilityTransportsKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
