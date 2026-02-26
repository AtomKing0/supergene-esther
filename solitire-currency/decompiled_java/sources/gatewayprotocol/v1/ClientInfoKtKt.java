package gatewayprotocol.v1;

import gatewayprotocol.v1.ClientInfoKt;
import gatewayprotocol.v1.ClientInfoOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ClientInfoKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ClientInfoKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeclientInfo, reason: not valid java name */
    public static final ClientInfoOuterClass.ClientInfo m4156initializeclientInfo(@NotNull l<? super ClientInfoKt.Dsl, k0> block) {
        t.i(block, "block");
        ClientInfoKt.Dsl.Companion companion = ClientInfoKt.Dsl.Companion;
        ClientInfoOuterClass.ClientInfo.Builder builderNewBuilder = ClientInfoOuterClass.ClientInfo.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        ClientInfoKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final ClientInfoOuterClass.ClientInfo copy(@NotNull ClientInfoOuterClass.ClientInfo clientInfo, @NotNull l<? super ClientInfoKt.Dsl, k0> block) {
        t.i(clientInfo, "<this>");
        t.i(block, "block");
        ClientInfoKt.Dsl.Companion companion = ClientInfoKt.Dsl.Companion;
        ClientInfoOuterClass.ClientInfo.Builder builder = clientInfo.toBuilder();
        t.h(builder, "this.toBuilder()");
        ClientInfoKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
