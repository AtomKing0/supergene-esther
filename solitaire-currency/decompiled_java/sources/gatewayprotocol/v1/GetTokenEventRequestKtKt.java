package gatewayprotocol.v1;

import gatewayprotocol.v1.GetTokenEventRequestKt;
import gatewayprotocol.v1.GetTokenEventRequestOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: GetTokenEventRequestKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GetTokenEventRequestKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializegetTokenEventRequest, reason: not valid java name */
    public static final GetTokenEventRequestOuterClass.GetTokenEventRequest m4171initializegetTokenEventRequest(@NotNull l<? super GetTokenEventRequestKt.Dsl, k0> block) {
        t.i(block, "block");
        GetTokenEventRequestKt.Dsl.Companion companion = GetTokenEventRequestKt.Dsl.Companion;
        GetTokenEventRequestOuterClass.GetTokenEventRequest.Builder builderNewBuilder = GetTokenEventRequestOuterClass.GetTokenEventRequest.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        GetTokenEventRequestKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final GetTokenEventRequestOuterClass.GetTokenEventRequest copy(@NotNull GetTokenEventRequestOuterClass.GetTokenEventRequest getTokenEventRequest, @NotNull l<? super GetTokenEventRequestKt.Dsl, k0> block) {
        t.i(getTokenEventRequest, "<this>");
        t.i(block, "block");
        GetTokenEventRequestKt.Dsl.Companion companion = GetTokenEventRequestKt.Dsl.Companion;
        GetTokenEventRequestOuterClass.GetTokenEventRequest.Builder builder = getTokenEventRequest.toBuilder();
        t.h(builder, "this.toBuilder()");
        GetTokenEventRequestKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
